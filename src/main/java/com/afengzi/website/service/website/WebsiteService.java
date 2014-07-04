package com.afengzi.website.service.website;

import com.afengzi.website.domain.node.NodeVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-4
 * Time: обнГ3:50
 * To change this template use File | Settings | File Templates.
 */
public interface WebsiteService {

    public List<NodeVo> queryByUser(String userName) ;
}
