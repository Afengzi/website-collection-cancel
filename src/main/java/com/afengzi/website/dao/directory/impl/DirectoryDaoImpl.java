package com.afengzi.website.dao.directory.impl;

import com.afengzi.website.dao.BaseDao;
import com.afengzi.website.dao.directory.DirectoryDao;
import com.afengzi.website.domain.node.Node;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-25
 * Time: ÏÂÎç6:48
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class DirectoryDaoImpl extends BaseDao implements DirectoryDao {

    private static final String COLLECTION_NAME="website.directory" ;
    @Autowired
    private MongoTemplate mongoTemplate ;

    public void persist(Node node){
        mongoTemplate.insert(node,COLLECTION_NAME);
    }

    public List<Node> query(Query query){
        return mongoTemplate.find(query,Node.class,COLLECTION_NAME);
    }


}
