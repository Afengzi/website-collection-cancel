package com.afengzi.website.service.website;

import com.afengzi.website.domain.node.NodeVo;
import com.afengzi.website.domain.site.SiteVo;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-4
 * Time: ÏÂÎç3:50
 * To change this template use File | Settings | File Templates.
 */
public interface WebsiteService {

    public List<NodeVo> queryByUser(String userName) ;

    /**
     * ²éÑ¯ÍøÕ¾µã
     * @param userName
     * @return
     */
    public Map<String,Object> querySitesByUser(String userName) ;
}
