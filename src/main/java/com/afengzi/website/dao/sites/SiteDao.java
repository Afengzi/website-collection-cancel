package com.afengzi.website.dao.sites;

import com.afengzi.website.domain.node.Node;
import com.afengzi.website.domain.site.Site;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-4
 * Time: ����10:34
 * To change this template use File | Settings | File Templates.
 */
public interface SiteDao {

    public List<Site> query(Query query);

    public void persist(Site site);

    public void update(Query query,Update update) ;

}
