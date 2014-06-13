package com.afengzi.website.service.impl;

import com.afengzi.website.domain.base.WebsiteVo;
import com.afengzi.website.domain.constant.WebsiteConstant;
import com.afengzi.website.domain.site.techonlogy.TechnologyQuery;
import com.afengzi.website.manager.technology.TechnologyManager;
import com.afengzi.website.service.WebsiteService;
import com.afengzi.website.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-11
 * Time: ÏÂÎç7:53
 * To change this template use File | Settings | File Templates.
 */
public class WebsiteServiceImpl implements WebsiteService {
    @Autowired
    private TechnologyManager technologyManager;
    @Override
    public List<? extends WebsiteVo> getWebsiteVoList(String userName) {
        TechnologyQuery technologyQuery = new TechnologyQuery();
        if(StringUtil.isEmpty(userName)){
            userName= WebsiteConstant.GUEST_USER_PIN;
        }
        technologyQuery.setUserPin(userName);
        return technologyManager.getTechnologyVoList(technologyQuery);
    }

    public void setTechnologyManager(TechnologyManager technologyManager) {
        this.technologyManager = technologyManager;
    }
}
