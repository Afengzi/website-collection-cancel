package com.afengzi.website;

import com.afengzi.website.domain.CollectionConstant;
import com.afengzi.website.domain.node.NodeVo;
import com.afengzi.website.service.directory.DirectoryService;
import com.afengzi.website.service.website.WebsiteService;
import net.sf.json.JSONArray;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
* Handles requests for the application home page.
*/
@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);


    @Autowired
    private WebsiteService websiteService;


    /**
     * ��ȡվ�㼯��
     * @param model
     * @return
     */
    @RequestMapping(value = "/")
    public String index(Model model){
        String userName = CollectionConstant.WEBSITE_GUEST ;
        Map<String,Object> resultMap = websiteService.querySitesByUser(userName) ;
        if (resultMap!=null){
            model.addAttribute("sitesMap",resultMap.get("sitesInfo")) ;
            model.addAttribute("nodeMap",resultMap.get("nodeInfo")) ;
        }

        return "index" ;
    }




}
