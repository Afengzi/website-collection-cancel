package com.afengzi.website.test;


import com.afengzi.data.importdb.MongoBase;
import com.afengzi.website.domain.node.Node;
import com.afengzi.website.util.sequence.Sequence;
import com.afengzi.website.util.sequence.SequenceUtil;
import com.mongodb.*;
import com.mongodb.util.JSON;
import net.sf.json.JSONObject;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-25
 * Time: ����9:24
 * To change this template use File | Settings | File Templates.
 */
public class MongodbTest extends MongoBase {

    private static final String WEBSITE_GROUP_COLLECTION = "website.directory" ;
    private static final String SEQUENCE_VALUE_COLLECTION = "sequence_value" ;

    public static void main(String[] args){
        MongodbTest mongodbTest = new MongodbTest();
        mongodbTest.getId();

    }

    public Long getId(){
        Sequence sequence = new Sequence();
        sequence.setBlockSize(10);
        sequence.setMongo(mongo());

        SequenceUtil util = new SequenceUtil();
        util.setDefaultSequence(sequence);

        long id = util.get(WEBSITE_GROUP_COLLECTION) ;
        System.out.println(id);
        return id ;

    }

    public void automicInc(){
//        DBObject query = new BasicDBObject();
//        query.put("name",WEBSITE_GROUP_COLLECTION);
//
//        List<String> stringList = findStr(SEQUENCE_VALUE_COLLECTION) ;
//        System.out.println(stringList);
//
//        DBObject update = new BasicDBObject() ;
//        update.put("$inc",new BasicDBObject().append("value",1)) ;
//
//        DBObject result = new BasicDBObject() ;
//        result.put("new",true) ;
////        update.put("_id",10);
////        System.out.println(query);
////        System.out.println(update);
//
//        DBObject dbObject = db.getCollection(SEQUENCE_VALUE_COLLECTION).findAndModify(query,update,result) ;
//
//        System.out.println(dbObject);
    }



    public DBObject getDbObject(){
        Node root = new Node();
        root.setDepth(0);
        root.setTitle("�Ƽ�");

        Node leaf1 = new Node();
        leaf1.setDepth(1);
        leaf1.setTitle("JAVA");

        Node leaf2 = new Node();
        leaf2.setDepth(1);
        leaf2.setTitle("PYTHON");

        List<Node> nodes = new ArrayList<Node>();
        nodes.add(leaf1);
        nodes.add(leaf2) ;

        root.setChildren(nodes);

        JSONObject jsonObject = JSONObject.fromObject(root) ;
        DBObject dbObject = (DBObject)JSON.parse(jsonObject.toString()) ;



        System.out.println(dbObject);


        String str = JSON.serialize(dbObject) ;
        System.out.println(str);

        JSONObject jsonObject1 = JSONObject.fromObject(str) ;
        Node node = (Node)JSONObject.toBean(jsonObject1,Node.class) ;
        System.out.println(node.getDepth());
//        Node node2 = JSONObject.toBean(,Node.class);

        return dbObject;
    }

    private Mongo mongo(){
        try {
            DBAddress address = new DBAddress("127.0.0.1",27017,"website");
            Mongo mongo = new Mongo(address);
            return mongo;
        } catch (UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null ;

    }
}
