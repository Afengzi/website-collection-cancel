package com.afengzi.website.dao.group.impl;

import com.afengzi.website.dao.BaseDao;
import com.afengzi.website.domain.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-25
 * Time: ÏÂÎç6:48
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class WebsiteGroupDaoImpl extends BaseDao{

    private static final String COLLECTION_NAME="website.goup" ;
    @Autowired
    private MongoTemplate mongoTemplate ;

    public void persist(Node node){
        mongoTemplate.insert(node,COLLECTION_NAME);
    }
}
