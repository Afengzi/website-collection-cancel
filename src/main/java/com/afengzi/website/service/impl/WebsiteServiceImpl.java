package com.afengzi.website.service.impl;

import com.afengzi.website.domain.constant.WebsiteConstant;
import com.afengzi.website.domain.site.Website;
import com.afengzi.website.domain.site.WebsiteQuery;
import com.afengzi.website.domain.site.WebsiteVo;
import com.afengzi.website.domain.typeenum.DevelopmentTechniqueEnum;
import com.afengzi.website.domain.typeenum.SiteTypeEnum;
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
 * Time: ����7:53
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

        Website website = new Website();
        website.setTitle("京东商城");
        website.setUrl("http://jd.com");
        website.setModuleType(SiteTypeEnum.TECHNOLOGY.getValue());
        website.setAreaType(DevelopmentTechniqueEnum.JAVA.getValue());

        Website tmall = new Website();
        tmall.setTitle("天猫");
        tmall.setUrl("http://www.tmall.com/");
        tmall.setModuleType(SiteTypeEnum.TECHNOLOGY.getValue());
        tmall.setAreaType(DevelopmentTechniqueEnum.JAVA.getValue());

        technologyManager.insertOneWebsite(website);
        return true;
    }


}
