package com.afengzi.website.service.directory;

import com.afengzi.website.domain.node.NodeVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-3
 * Time: обнГ5:18
 * To change this template use File | Settings | File Templates.
 */
public interface DirectoryService {

    public String queryByUser(String userName);

    public List<NodeVo> queryNodeVosByUser(String userName) ;
}
