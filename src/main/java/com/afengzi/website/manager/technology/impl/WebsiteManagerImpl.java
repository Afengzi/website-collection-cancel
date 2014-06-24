package com.afengzi.website.manager.technology.impl;

import com.afengzi.website.dao.technology.TechnologyDao;
import com.afengzi.website.domain.site.ModuleVo;
import com.afengzi.website.domain.site.Website;
import com.afengzi.website.domain.site.WebsiteQuery;
import com.afengzi.website.domain.typeenum.CategoryTypeEnum;
import com.afengzi.website.manager.base.BaseManager;
import com.afengzi.website.manager.technology.WebsiteManager;
import com.mongodb.DBCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-11
 * Time: ����7:55
 * To change this template use File | Settings | File Templates.
 */
@Component(value = "technologyManager")
public class WebsiteManagerImpl extends BaseManager implements WebsiteManager {

    @Autowired
    private TechnologyDao technologyDao;

    @Override
    public List<ModuleVo> getWebsiteList(WebsiteQuery websiteQuery) {
        if (websiteQuery == null) {
            return null;
        }
        DBCursor cursor = technologyDao.queryTechnologyList(convertWebsiteBean(websiteQuery));

        return getModuleVoList(cursor, CategoryTypeEnum.TECHNOLOGY.getValue());

    }


    @Override
    public boolean insertOneWebsite(Website website) {
        technologyDao.insert(convertWebsiteBean(website));
        return true;
    }

}
