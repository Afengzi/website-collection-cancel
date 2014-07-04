package com.afengzi.website.service.directory.impl;

import com.afengzi.website.domain.node.Node;
import com.afengzi.website.manager.directory.DirectoryManager;
import com.afengzi.website.service.directory.DirectoryService;
import net.sf.json.JSONArray;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-3
 * Time: ÏÂÎç5:19
 * To change this template use File | Settings | File Templates.
 */
@Component
public class DirectoryServiceImpl implements DirectoryService {
    @Autowired
    private DirectoryManager directoryManager ;

    @Override
    public String queryByUser(String userName) {
       List<Node> nodes = directoryManager.queryByUser(userName) ;
       if (CollectionUtils.isEmpty(nodes)){
           return "";
       }
        return JSONArray.fromObject(nodes).toString();
    }
}
