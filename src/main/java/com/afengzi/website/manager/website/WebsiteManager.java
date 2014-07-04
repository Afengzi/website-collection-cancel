package com.afengzi.website.manager.website;

import com.afengzi.website.domain.node.NodeVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-4
 * Time: ионГ10:43
 * To change this template use File | Settings | File Templates.
 */
public interface WebsiteManager {
    List<NodeVo> queryByUser(String userName);
}
