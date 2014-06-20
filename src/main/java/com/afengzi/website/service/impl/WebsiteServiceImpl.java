package com.afengzi.website.service.impl;

import com.afengzi.website.domain.constant.WebsiteConstant;
import com.afengzi.website.domain.site.WebsiteQuery;
import com.afengzi.website.domain.site.techonlogy.Technology;
import com.afengzi.website.manager.technology.TechnologyManager;
import com.afengzi.website.service.WebsiteService;
import com.afengzi.website.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-11
 * Time: ÏÂÎç7:53
 * To change this template use File | Settings | File Templates.
 */
@Service(value = "websiteService")
public class WebsiteServiceImpl implements WebsiteService {
    @Autowired
    private TechnologyManager technologyManager;

    @Override
    public List<? extends WebsiteVo> getWebsiteVoList(String userName) {
        WebsiteQuery websiteQuery = new WebsiteQuery();
        if (StringUtil.isEmpty(userName)) {
            userName = WebsiteConstant.GUEST_USER_PIN;
        }
        websiteQuery.setUserPin(userName);
        return technologyManager.getTechnologyVoList(websiteQuery);
    }

    @Override
    public boolean addOneWebsite(String url, String title, String description) {

        Technology technology = new Technology();
        technology.setUrl(url);
        technology.setTitle(title);
        technology.setDescription(description);
        technologyManager.insertOneWebsite(technology);
        return true;
    }


}
