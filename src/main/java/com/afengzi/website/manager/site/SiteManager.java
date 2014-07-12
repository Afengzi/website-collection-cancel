package com.afengzi.website.manager.site;

import com.afengzi.website.domain.node.Node;
import com.afengzi.website.domain.site.Site;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-11
 * Time: ����6:58
 * To change this template use File | Settings | File Templates.
 */
public interface SiteManager {

    public void saveSite(Site site) ;

    public boolean deleteSite(Site site) ;


}
