package com.afengzi.website.dao.sites.impl;

import com.afengzi.website.dao.sites.SiteDao;
import com.afengzi.website.domain.node.Node;
import com.afengzi.website.domain.site.Site;
import com.afengzi.website.util.sequence.SequenceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-4
 * Time: ����10:37
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class SiteDaoImpl implements SiteDao {

    private static final String COLLECTION_SITE_NAME = "website.sites";
    @Autowired
    private SequenceUtil sequenceUtil ;
    @Autowired
    private MongoTemplate mongoTemplate ;
    @Override
    public List<Site> query(Query query) {
        return mongoTemplate.find(query,Site.class,COLLECTION_SITE_NAME);
    }

    public void persist(Site site){
        if (site==null){
            site = new Site();
        }
        site.setCreated(new Date());
        site.setModified(new Date());
        site.set_id(sequenceUtil.get(COLLECTION_SITE_NAME));
        mongoTemplate.insert(site,COLLECTION_SITE_NAME);
    }

    @Override
    public void update(Query query,Update update) {

        mongoTemplate.updateFirst(query,update,COLLECTION_SITE_NAME) ;
    }
}
