package com.afengzi.website.util.sequence;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-27
 * Time: 上午9:49
 * To change this template use File | Settings | File Templates.
 */
public class Sequence {

    private static final String COLLECTION_NAME = "website.sequence_value";
    private static final String DATABASE_NAME = "website";
    private static final String NAME_COLUMN = "name";
    private static final String VALUE_COLUMN = "id_value";
    private static final Logger logger = Logger.getLogger("Sequence");
    private long start = 0;
    private int blockSize = 5;
    private Mongo mongo;
    private Map<String, Step> sequenceMap = new HashMap<String, Step>();

    public synchronized Long getValue(String name) {
        Step step = sequenceMap.get(name);
        if (step == null) {
            step = new Step(start, start + blockSize);
            sequenceMap.put(name, step);
        } else {
            if (step.currentValue < step.endValue) {
                return ++step.currentValue;
            }
        }

        for (int i = 0; i < blockSize; i++) {
            if (getNextBlock(name, step)) {
                return step.incrementAndGet();
            }
        }
        throw new RuntimeException("No more value .");
    }

    private boolean getNextBlock(String name, Step step) {
        Long id = incrementAndGet(name);
        if (id == null) {
            try {
                newPersistenceValue(name);
            } catch (Exception e) {
                logger.error("newPersistenceValue is error.", e);
                id = incrementAndGet(name);
            }
        }
        step.setCurrentValue(id);
        step.setEndValue(id + blockSize);
        return true;
    }

    /**
     * findAndModify 增加blockSize
     *
     * @param name
     * @return !=Null:增加成功 Null:name不存在,需先保存name文档
     */
    private Long incrementAndGet(String name) {
        DBCollection collection = mongo.getDB(DATABASE_NAME).getCollection(COLLECTION_NAME);
        DBObject query = new BasicDBObject();
        query.put(NAME_COLUMN, COLLECTION_NAME);

        DBObject update = new BasicDBObject();
        update.put("$inc", new BasicDBObject().append(VALUE_COLUMN, blockSize));

        DBObject dbObject = collection.findAndModify(query, update);
        Map<String, Object> valueMap = (Map<String, Object>) dbObject.get("value");
        if (valueMap != null) {
            return (Long) valueMap.get(VALUE_COLUMN);
        }

        return null;
    }

    private void newPersistenceValue(String name) {
        DBCollection collection = mongo.getDB(DATABASE_NAME).getCollection(COLLECTION_NAME);

        DBObject saveObj = new BasicDBObject();
        saveObj.put(NAME_COLUMN, name);
        saveObj.put(VALUE_COLUMN, start);
        try {
            collection.save(saveObj);
        } catch (Exception e) {
            throw new RuntimeException("save sequence value error.", e);
        }
    }

    public void setMongo(Mongo mongo) {
        this.mongo = mongo;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    private static class Step {
        private long currentValue;
        private long endValue;

        private Step(long currentValue, long endValue) {
            this.currentValue = currentValue;
            this.endValue = endValue;
        }

        public long getCurrentValue() {
            return currentValue;
        }

        public void setCurrentValue(long currentValue) {
            this.currentValue = currentValue;
        }

        public long getEndValue() {
            return endValue;
        }

        public void setEndValue(long endValue) {
            this.endValue = endValue;
        }

        public Long incrementAndGet() {
            return ++currentValue;
        }
    }

}
