//package com.afengzi.website.service;
//
//import com.afengzi.website.domain.site.Website;
//import com.afengzi.website.domain.site.WebsiteVo;
//import com.afengzi.website.domain.typeenum.TechnologyModuleKindEnum;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created with IntelliJ IDEA.
// * User: lixiuhai
// * Date: 14-6-24
// * Time: ÉÏÎç9:18
// * To change this template use File | Settings | File Templates.
// */
//public class BaseService {
//
//    protected ModuleVo getModuleVo(List<Website> websiteList,TechnologyModuleKindEnum kindEnum){
//        ModuleVo moduleVo = new ModuleVo();
//        List<WebsiteVo> WebsiteVoList = new ArrayList<WebsiteVo>() ;
//        WebsiteVo websiteVo = null ;
//        for (Website website : websiteList){
//            if(website==null){
//                continue;
//            }
//            if (website.getModuleKind()==kindEnum.getValue()){
//                websiteVo = convert2WebsiteVo(website);
//                WebsiteVoList.add(websiteVo);
//            }
//        }
//        moduleVo.setWebsiteVoList(WebsiteVoList);
//        return moduleVo;
//    }
//
//    private WebsiteVo convert2WebsiteVo(Website website){
//        WebsiteVo websiteVo = new WebsiteVo();
//        websiteVo.setId(website.getId());
//        websiteVo.setDescription(website.getDescription());
//        websiteVo.setModuleKine(website.getModuleKind());
//        websiteVo.setTitle(website.getTitle());
//        websiteVo.setUrl(website.getUrl());
//        return websiteVo;
//    }
//}
