package com.afengzi.website.manager.technology;

import com.afengzi.website.domain.site.Website;
import com.afengzi.website.domain.site.WebsiteQuery;
import com.afengzi.website.domain.site.WebsiteVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-11
 * Time: ����7:55
 * To change this template use File | Settings | File Templates.
 */
public interface TechnologyManager {
    /**
     * ��ȡ����վ�㼯��
     *
     * @param websiteQuery
     * @return
     */
    public List<WebsiteVo> getTechnologyVoList(WebsiteQuery websiteQuery);

    public boolean insertOneWebsite(Website website);
}
