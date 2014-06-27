package com.afengzi.website.test;


import com.afengzi.website.domain.node.Node;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-25
 * Time: ÉÏÎç9:24
 * To change this template use File | Settings | File Templates.
 */
public class MongodbTest extends MongoBase{

    private static final String WEBSITE_GROUP_COLLECTION = "website.group" ;
    private static final String SEQUENCE_VALUE_COLLECTION = "sequence_value" ;

    public static void main(String[] args){
        MongodbTest mongodb = new MongodbTest();
        mongodb.automicInc();

    }

    public void automicInc(){
        DBObject query = new BasicDBObject();
        query.put("name",WEBSITE_GROUP_COLLECTION);

        List<String> stringList = findStr(SEQUENCE_VALUE_COLLECTION) ;
        System.out.println(stringList);

        DBObject update = new BasicDBObject() ;
        update.put("$inc",new BasicDBObject().append("value",1)) ;

        DBObject result = new BasicDBObject() ;
        result.put("new",true) ;
//        update.put("_id",10);
//        System.out.println(query);
//        System.out.println(update);

        DBObject dbObject = db.getCollection(SEQUENCE_VALUE_COLLECTION).findAndModify(query,update,result) ;

        System.out.println(dbObject);
    }



    public DBObject getDbObject(){
        Node root = new Node();
        root.setDepth(0);
        root.setTitle("¿Æ¼¼");

        Node leaf1 = new Node();
        leaf1.setDepth(1);
        leaf1.setTitle("JAVA");

        Node leaf2 = new Node();
        leaf2.setDepth(1);
        leaf2.setTitle("PYTHON");

        List<Node> nodes = new ArrayList<Node>();
        nodes.add(leaf1);
        nodes.add(leaf2) ;

        root.setLatter(nodes);

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
}
