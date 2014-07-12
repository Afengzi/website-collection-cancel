package com.afengzi.website.service.site;

import com.afengzi.website.domain.site.Site;
import com.afengzi.website.domain.site.SiteVo;
import com.afengzi.website.manager.site.SiteManager;
import com.afengzi.website.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-11
 * Time: ����6:46
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteManager siteManager ;
    @Override
    public void addSite(SiteVo siteVo) {
        Site site = BeanUtil.siteVo2Site(siteVo) ;
        if (site!=null){
            siteManager.saveSite(site);
        }
    }

    @Override
    public void delSite(SiteVo siteVo) {
        Site site = BeanUtil.siteVo2Site(siteVo) ;
        if (site!=null){
            siteManager.deleteSite(site) ;
        }
    }

}
