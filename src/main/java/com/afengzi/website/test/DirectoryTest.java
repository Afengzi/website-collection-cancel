package com.afengzi.website.test;

import com.afengzi.website.domain.CollectionConstant;
import com.afengzi.website.domain.node.Node;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-2
 * Time: 上午9:38
 * To change this template use File | Settings | File Templates.
 */
public class DirectoryTest extends MongoBase {

    private static final String WEBSITE_DIRECTORY_COLLECTION = "website.directory";

    public static void main(String[] arg){
        DirectoryTest dir = new DirectoryTest();
        dir.testSaveDirectory();
//        dir.testSaveDirectory();
//        dir.testConvert();
//        System.out.print(dir.getNewDbObject("dd",1));
    }



    public void testSaveDirectory() {
        save(getNewNode("科技",0),WEBSITE_DIRECTORY_COLLECTION);
    }

    public void testUpdate(){
        updateDire(191, "数据库", "科技");
    }

    public void updateDire(int parentId,String newTitle,String parentTitle){
        DBObject queryDbObject = new BasicDBObject() ;
        queryDbObject.put("_id",parentId);
        queryDbObject.put("title",parentTitle) ;

        DBObject updateDbObject = new BasicDBObject();
        updateDbObject.put("latter",getNewDbObject(newTitle,1)) ;

        DBObject update = new BasicDBObject();
        update.put("$addToSet",updateDbObject);

        add2Set(WEBSITE_DIRECTORY_COLLECTION, queryDbObject, update);

    }

    private Node getNewNode(String newTitle,int depth) {

        Node node = new Node();
        node.setTitle(newTitle);
        node.setDepth(depth);
        node.set_id(IdUtil.getId(WEBSITE_DIRECTORY_COLLECTION));
        node.setUserName(CollectionConstant.WEBSITE_GUEST);

        Node leaf = new Node();
        leaf.setTitle("JAVA");
        leaf.setDepth(1);
        leaf.set_id(IdUtil.getId(WEBSITE_DIRECTORY_COLLECTION));

        List<Node> leafs = new ArrayList<Node>();
        leafs.add(leaf);

        node.setChildren(leafs);
        return node ;
    }

    private DBObject getNewDbObject(String newTitle,int depth){
        JSONObject jsonObject = JSONObject.fromObject(getNewNode(newTitle,1)) ;
        DBObject dbObject = (DBObject) JSON.parse(jsonObject.toString()) ;

        return dbObject ;
    }

    private void testConvert(){
        DBObject dbObject = new BasicDBObject();
        dbObject.put("name","klov");
        JSONObject jsonObject = JSONObject.fromObject(dbObject);
        System.out.println(jsonObject.toString());
    }
}
