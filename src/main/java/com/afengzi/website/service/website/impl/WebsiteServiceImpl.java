package com.afengzi.website.service.website.impl;

import com.afengzi.website.domain.node.NodeVo;
import com.afengzi.website.domain.site.SiteVo;
import com.afengzi.website.manager.website.WebsiteManager;
import com.afengzi.website.service.website.WebsiteService;
import net.sf.json.JSONArray;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-4
 * Time: ÏÂÎç3:51
 * To change this template use File | Settings | File Templates.
 */
@Component
public class WebsiteServiceImpl implements WebsiteService {
    @Autowired
    private WebsiteManager websiteManager ;
    @Override
    public List<NodeVo> queryByUser(String userName) {
        log(userName);
        return websiteManager.queryByUser(userName);
    }

    @Override
    public Map<String,Object> querySitesByUser(String userName) {
        log(userName);
        List<SiteVo> siteVos = websiteManager.querySiteVosByUser(userName) ;
        if (CollectionUtils.isNotEmpty(siteVos)){
            return getNodeSiteMapBySites(siteVos) ;
        }
        return null ;
    }

    private Map<String,Object> getNodeSiteMapBySites(List<SiteVo> siteVos){
        Map<Long ,List<SiteVo>> nodeVoListMap = new HashMap<Long, List<SiteVo>>() ;
        Map<Long,String > nodeVoMap = new HashMap<Long, String>() ;

        Map<String,Object> resultMap = new HashMap<String, Object>() ;

        List<SiteVo> siteVoList = null ;
        for (SiteVo siteVo : siteVos){
            nodeVoMap.put(siteVo.getNodeId(),siteVo.getNodeName());
            siteVoList = nodeVoListMap.get(siteVo.getNodeId());
            if (siteVoList==null){
                siteVoList = new ArrayList<SiteVo>() ;
            }
            siteVoList.add(siteVo) ;
            nodeVoListMap.put(siteVo.getNodeId(),siteVoList) ;

        }

        resultMap.put("sitesInfo",nodeVoListMap) ;
        resultMap.put("nodeInfo",nodeVoMap) ;
        return resultMap ;
    }

    private void log(String userName){
        List<NodeVo> nodeVos = websiteManager.queryByUser(userName);
        JSONArray jsonArray = JSONArray.fromObject(nodeVos);

        System.out.println(jsonArray.toString());
    }
}
