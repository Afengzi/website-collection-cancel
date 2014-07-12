package com.afengzi.website.manager.directory;

import com.afengzi.website.domain.node.Node;
import com.afengzi.website.domain.node.NodeVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-3
 * Time: обнГ4:23
 * To change this template use File | Settings | File Templates.
 */
public interface DirectoryManager {

    public List<NodeVo> queryByUser(String userName);
}
