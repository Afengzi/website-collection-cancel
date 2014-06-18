package com.afengzi.website.manager.technology;

import com.afengzi.website.domain.site.techonlogy.Technology;
import com.afengzi.website.domain.site.techonlogy.TechnologyQuery;
import com.afengzi.website.domain.site.techonlogy.TechnologyVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-11
 * Time: 下午7:55
 * To change this template use File | Settings | File Templates.
 */
public interface TechnologyManager {
    /**
     * 获取技术站点集合
     * @param technologyQuery
     * @return
     */
    public List<TechnologyVo> getTechnologyVoList(TechnologyQuery technologyQuery);

    public boolean insertOneWebsite(Technology technology);
}
