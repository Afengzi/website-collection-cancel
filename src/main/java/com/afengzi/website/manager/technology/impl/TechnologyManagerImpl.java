package com.afengzi.website.manager.technology.impl;

import com.afengzi.website.dao.technology.TechnologyDao;
import com.afengzi.website.domain.site.Website;
import com.afengzi.website.domain.site.WebsiteQuery;
import com.afengzi.website.domain.site.WebsiteVo;
import com.afengzi.website.manager.base.BaseManager;
import com.afengzi.website.manager.technology.TechnologyManager;
import com.mongodb.DBCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-11
 * Time: ÏÂÎç7:55
 * To change this template use File | Settings | File Templates.
 */
@Component(value = "technologyManager")
public class TechnologyManagerImpl extends BaseManager implements TechnologyManager {

    @Autowired
    private TechnologyDao technologyDao;

    @Override
    public List<WebsiteVo> getTechnologyVoList(WebsiteQuery websiteQuery) {
        if (websiteQuery == null) {
            return null;
        }
        DBCursor cursor = technologyDao.queryTechnologyList(convertWebsiteBean(websiteQuery));
        List<Website> websiteList = new ArrayList<Website>();
        if (cursor == null) {
            return null;
        }
        Website website = null;
        while (cursor.hasNext()) {
            website = new Website();
            convertDBObject(cursor.next(), website);
            if (website != null) {
                websiteList.add(website);
            }
        }
        return null ;

    }

    @Override
    public boolean insertOneWebsite(Website technology) {
        technologyDao.insert(convertWebsiteBean(technology));
        return true;
    }

}
