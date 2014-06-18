package com.afengzi.website.manager.technology.impl;

import com.afengzi.website.dao.technology.TechnologyDao;
import com.afengzi.website.domain.site.techonlogy.Technology;
import com.afengzi.website.domain.site.techonlogy.TechnologyQuery;
import com.afengzi.website.domain.site.techonlogy.TechnologyVo;
import com.afengzi.website.manager.base.BaseManager;
import com.afengzi.website.manager.technology.TechnologyManager;
import com.mongodb.DBCursor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-11
 * Time: ÏÂÎç7:55
 * To change this template use File | Settings | File Templates.
 */
public class TechnologyManagerImpl extends BaseManager implements TechnologyManager {

    @Autowired
    private TechnologyDao technologyDao;

    @Override
    public List<TechnologyVo> getTechnologyVoList(TechnologyQuery technologyQuery) {
        if (technologyQuery == null) {
            return null;
        }
        DBCursor cursor = technologyDao.queryTechnologyList(convertWebsiteBean(technologyQuery));
        return null;
    }

    @Override
    public boolean insertOneWebsite(Technology technology) {
        technologyDao.insert(convertWebsiteBean(technology));
        return true;
    }

}
