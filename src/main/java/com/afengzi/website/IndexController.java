package com.afengzi.website;

import com.afengzi.website.domain.CollectionConstant;
import com.afengzi.website.service.directory.DirectoryService;
import com.afengzi.website.service.website.WebsiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
* Handles requests for the application home page.
*/
@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private DirectoryService directoryService ;
    @Autowired
    private WebsiteService websiteService;



	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public String index2(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );
		return "index";
	}

    @RequestMapping(value = "/")
    public String index(Model model){
        String userName = "admin" ;
        model.addAttribute("websites",websiteService.queryByUser(CollectionConstant.WEBSITE_GUEST));
        return "index";
    }


}
