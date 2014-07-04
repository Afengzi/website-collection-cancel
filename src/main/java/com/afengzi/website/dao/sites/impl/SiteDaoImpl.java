package com.afengzi.website.dao.sites.impl;

import com.afengzi.website.dao.sites.SiteDao;
import com.afengzi.website.domain.site.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-4
 * Time: ÉÏÎç10:37
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class SiteDaoImpl implements SiteDao {
    private static final String COLLECTION_SITE_NAME = "website.sites";
    @Autowired
    private MongoTemplate mongoTemplate ;
    @Override
    public List<Site> query(Query query) {
        return mongoTemplate.find(query,Site.class,COLLECTION_SITE_NAME);
    }
}
