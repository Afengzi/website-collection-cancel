package com.afengzi.website.test;

import com.afengzi.website.util.sequence.Sequence;
import com.afengzi.website.util.sequence.SequenceUtil;
import com.mongodb.DBAddress;
import com.mongodb.Mongo;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-2
 * Time: ����9:42
 * To change this template use File | Settings | File Templates.
 */
public class IdUtil extends MongoBase {

    public static Long getId(String name){
        Sequence sequence = new Sequence();
        sequence.setBlockSize(10);
        sequence.setMongo(mongo());

        SequenceUtil util = new SequenceUtil();
        util.setDefaultSequence(sequence);

        long id = util.get(name) ;
        System.out.println(id);
        return id ;

    }

    private static Mongo mongo(){
        try {
            DBAddress address = new DBAddress("127.0.0.1",27017,"website");
            Mongo mongo = new Mongo(address);
            return mongo;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null ;

    }

}
