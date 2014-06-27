package com.afengzi.website.service.impl;

import com.afengzi.website.domain.constant.WebsiteConstant;
import com.afengzi.website.domain.site.CategoryVo;
import com.afengzi.website.domain.site.ModuleVo;
import com.afengzi.website.domain.site.Website;
import com.afengzi.website.domain.site.WebsiteQuery;
import com.afengzi.website.domain.typeenum.CategoryTypeEnum;
import com.afengzi.website.domain.typeenum.TechnologyModuleKindEnum;
import com.afengzi.website.manager.technology.WebsiteManager;
import com.afengzi.website.service.WebsiteService;
import com.afengzi.website.util.sequence.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-11
 * Time: 下午7:53
 * To change this template use File | Settings | File Templates.
 */
@Service(value = "websiteService")
public class WebsiteServiceImpl implements WebsiteService {
    @Autowired
    private WebsiteManager websiteManager;

    @Override
    public List<CategoryVo> getWebsiteVoList(String userName) {
        WebsiteQuery websiteQuery = new WebsiteQuery();
        if (StringUtil.isEmpty(userName)) {
            userName = WebsiteConstant.GUEST_USER_PIN;
        }
        websiteQuery.setUserPin(userName);
        List<ModuleVo> moduleVoList = websiteManager.getWebsiteList(websiteQuery);
        List<CategoryVo> categoryVoList = new ArrayList<CategoryVo>();
        categoryVoList.add(getCategoryVo(moduleVoList, CategoryTypeEnum.TECHNOLOGY));
        return categoryVoList;

    }

    private CategoryVo getCategoryVo(List<ModuleVo> moduleVoList, CategoryTypeEnum categoryTypeEnum) {
        CategoryVo categoryVo = new CategoryVo();
        categoryVo.setCategoryName(categoryTypeEnum.getName());
        categoryVo.setModuleVoList(moduleVoList);
        categoryVo.setType(categoryTypeEnum.getValue());

        return categoryVo;
    }

    @Override
    public boolean addOneWebsite(String url, String title, String description) {
        Website website = new Website();
        website.setUrl("http://jd.com");
        website.setTitle("京东商城");
        website.setCategoryType(CategoryTypeEnum.TECHNOLOGY.getValue());
        website.setModuleKind(TechnologyModuleKindEnum.JAVA.getValue());

        websiteManager.insertOneWebsite(website);
        return true;
    }


}
