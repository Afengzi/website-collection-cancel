package com.afengzi.website.manager.technology.impl;

import com.afengzi.website.dao.technology.TechnologyDao;
import com.afengzi.website.domain.base.Website;
import com.afengzi.website.domain.site.techonlogy.Technology;
import com.afengzi.website.domain.site.techonlogy.TechnologyQuery;
import com.afengzi.website.domain.site.techonlogy.TechnologyVo;
import com.afengzi.website.manager.base.BaseManager;
import com.afengzi.website.manager.technology.TechnologyManager;
import com.afengzi.website.util.StringUtil;
import com.mongodb.DBCursor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-11
 * Time: ÏÂÎç7:55
 * To change this template use File | Settings | File Templates.
 */
public class TechnologyManagerImpl extends BaseManager implements TechnologyManager {

    private TechnologyDao technologyDao;
    @Override
    public List<TechnologyVo> getTechnologyVoList(TechnologyQuery technologyQuery) {
         if(technologyQuery==null){
             return null;
         }
         DBCursor cursor = technologyDao.queryTechnologyList(convertWebsiteBean(technologyQuery));
        return null;
    }

    public void setTechnologyDao(TechnologyDao technologyDao) {
        this.technologyDao = technologyDao;
    }
}
