package com.afengzi.website.manager.directory.impl;

import com.afengzi.website.dao.directory.DirectoryDao;
import com.afengzi.website.domain.CollectionConstant;
import com.afengzi.website.domain.node.Node;
import com.afengzi.website.manager.directory.DirectoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-3
 * Time: ÏÂÎç4:26
 * To change this template use File | Settings | File Templates.
 */
@Component
public class DirectoryManagerImpl implements DirectoryManager {

    @Autowired
    private DirectoryDao directoryDao ;
    @Override
    public List<Node> queryByUser(String userName) {
        Query query = new Query(Criteria.where(CollectionConstant.WEBSITE_GUEST).is(userName));
        List<Node> nodes = directoryDao.query(query) ;

        return nodes ;
    }
}
