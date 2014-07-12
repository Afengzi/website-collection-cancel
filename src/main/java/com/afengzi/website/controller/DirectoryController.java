package com.afengzi.website.controller;

import com.afengzi.website.domain.CollectionConstant;
import com.afengzi.website.domain.node.NodeVo;
import com.afengzi.website.service.directory.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-11
 * Time: ����3:57
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class DirectoryController {
    @Autowired
    private DirectoryService directoryService;

    /**
     * 查询目录
     * @return
     */
    @RequestMapping(value = "/directory")
    @ResponseBody
    public List<NodeVo> directory() {
        String userName = CollectionConstant.WEBSITE_GUEST;
        List<NodeVo> nodeVos = directoryService.queryNodeVosByUser(userName);
        return nodeVos;
    }
}
