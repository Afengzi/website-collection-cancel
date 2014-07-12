package com.afengzi.website.manager.site.impl;

import com.afengzi.website.dao.sites.SiteDao;
import com.afengzi.website.domain.enumtype.StatusEnu;
import com.afengzi.website.domain.node.Node;
import com.afengzi.website.domain.site.Site;
import com.afengzi.website.manager.site.SiteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-11
 * Time: ����6:58
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SiteManagerImpl implements SiteManager {

    @Autowired
    private SiteDao siteDao ;
    @Override
    public void saveSite(Site site) {
        siteDao.persist(site);
    }

    @Override
    public boolean deleteSite(Site site) {

        Query query = Query.query(Criteria.where("_id").is(site.get_id()).and("status").is(StatusEnu.VALID.getCode())) ;
        Update update = Update.update("status",StatusEnu.INVALID.getCode()) ;

        siteDao.update(query,update);

        return true ;
    }
}
