package com.afengzi.website.dao.directory;

import com.afengzi.website.domain.node.Node;
import com.afengzi.website.domain.site.Site;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-25
 * Time: обнГ6:36
 * To change this template use File | Settings | File Templates.
 */
public interface DirectoryDao {

    public void persist(Node node);

    public List<Node> query(Query query);




}
