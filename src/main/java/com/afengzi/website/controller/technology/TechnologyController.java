package com.afengzi.website.controller.technology;

import com.afengzi.website.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-18
 * Time: 上午1:33
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/develop")
public class TechnologyController {
    @Autowired
    private WebsiteService websiteService ;

    @RequestMapping(value = "add")
    public String add(Model model){
        System.out.println("TechnologyController class add method ...");
        websiteService.addOneWebsite("http://jd.com","京东商城","3C大家电");
        model.addAttribute("success",true);
        return "result";
    }
}
