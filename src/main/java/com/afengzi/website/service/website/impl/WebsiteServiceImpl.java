package com.afengzi.website.service.website.impl;

import com.afengzi.website.domain.node.NodeVo;
import com.afengzi.website.manager.website.WebsiteManager;
import com.afengzi.website.service.website.WebsiteService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    private void log(String userName){
        List<NodeVo> nodeVos = websiteManager.queryByUser(userName);
        JSONArray jsonArray = JSONArray.fromObject(nodeVos);

        System.out.println(jsonArray.toString());
    }
}
