package com.afengzi.website.controller;

import com.afengzi.website.domain.CollectionConstant;
import com.afengzi.website.domain.site.SiteVo;
import com.afengzi.website.service.site.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-11
 * Time: ����6:42
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class SiteController {
    @Autowired
    private SiteService siteService;

//    @ResponseBody
    @RequestMapping(value = "/addSite")
    public String addSite(Model model, String direName, long direId, String siteTitle, String siteUrl) {
        SiteVo siteVo = new SiteVo();
        siteVo.setNodeName(direName);
        siteVo.setNodeId(direId);
        siteVo.setTitle(siteTitle);
        siteVo.setUrl(siteUrl);
        siteVo.setUserName(CollectionConstant.WEBSITE_GUEST);
        siteService.addSite(siteVo);
        return "index";
    }

    public String delSite(Model model,long siteId){
        SiteVo siteVo = new SiteVo();
        siteVo.set_id(siteId);

        siteService.delSite(siteVo);

        return "index" ;
    }
}
