package com.afengzi.website.test;

import com.afengzi.website.domain.node.NodeVo;
import com.afengzi.website.service.website.WebsiteService;
import com.afengzi.website.service.website.impl.WebsiteServiceImpl;
import net.sf.json.JSONArray;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-4
 * Time: ÏÂÎç3:54
 * To change this template use File | Settings | File Templates.
 */
public class WebsiteTest  {



    private void testQuery(String userName){
        WebsiteService websiteService = new WebsiteServiceImpl();
        List<NodeVo> nodeVos = websiteService.queryByUser(userName) ;
        JSONArray array = JSONArray.fromObject(nodeVos);
        System.out.println(array);
    }
}
