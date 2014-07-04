package com.afengzi.website.manager.website.impl;

import com.afengzi.website.dao.directory.DirectoryDao;
import com.afengzi.website.dao.sites.SiteDao;
import com.afengzi.website.domain.CollectionConstant;
import com.afengzi.website.domain.node.Node;
import com.afengzi.website.domain.node.NodeVo;
import com.afengzi.website.domain.site.Site;
import com.afengzi.website.domain.site.SiteVo;
import com.afengzi.website.manager.website.WebsiteManager;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-4
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 */
@Component
public class WebsiteManagerImpl implements WebsiteManager {

    private static final Logger logger = Logger.getLogger("WebsiteManagerImpl");
    @Autowired
    private DirectoryDao directoryDao;
    @Autowired
    private SiteDao siteDao;

    @Override
    public List<NodeVo> queryByUser(String userName) {
        Query query = Query.query(Criteria.where(CollectionConstant.DIRECTORY_SITES_USER_NAME).is(userName));
        List<Node> nodes = directoryDao.query(query);
        if (CollectionUtils.isEmpty(nodes)) {
            return null;
        }
        List<NodeVo> nodeVos = copyNodeProperties(nodes);
        List<Site> sites = siteDao.query(query);
        if (CollectionUtils.isEmpty(sites)) {
            return nodeVos;
        }

        Map<Integer, List<SiteVo>> siteVosMap = getSiteVosMap(copySiteProperties(sites));
        joinNodeAndSite(nodeVos, siteVosMap);

        return nodeVos;

    }

    private void joinNodeAndSite(List<NodeVo> nodeVos, Map<Integer, List<SiteVo>> siteVosMap) {
        if (CollectionUtils.isEmpty(nodeVos) || siteVosMap.isEmpty()) {
            return;
        }
        for (NodeVo nodeVo : nodeVos) {
            nodeVo.setWebsiteVos(siteVosMap.get(nodeVo.get_id()));
            if (nodeVo.hasChildren()) {
                joinNodeAndSite(nodeVo.getChildren(), siteVosMap);
            }
        }

    }

    /**
     * 把sitVo分类
     *
     * @param siteVos
     * @return nodeId为key
     */
    private Map<Integer, List<SiteVo>> getSiteVosMap(List<SiteVo> siteVos) {
        Map<Integer, List<SiteVo>> sitesMap = new HashMap<Integer, List<SiteVo>>();

        List<SiteVo> siteVosNew = null;
        for (SiteVo siteVo : siteVos) {
            if (siteVo == null || siteVo.getNodeId() < 1) {
                continue;
            }
            List<SiteVo> siteVosList = sitesMap.get(siteVo.getNodeId());
            if (siteVosList == null) {
                siteVosNew = new ArrayList<SiteVo>();
                siteVosNew.add(siteVo);
                sitesMap.put(siteVo.getNodeId(), siteVosNew);
            } else {
                siteVosList.add(siteVo);
                sitesMap.put(siteVo.getNodeId(), siteVosList);
            }
        }
        return sitesMap;

    }

    private List<SiteVo> copySiteProperties(List<Site> sites) {
        List<SiteVo> siteVos = new ArrayList<SiteVo>();
        SiteVo siteVo = null;
        for (Site site : sites) {
            siteVo = new SiteVo();
            try {
                BeanUtils.copyProperties(siteVo, site);
            } catch (IllegalAccessException e) {
                logger.error("site-->siteVo error.", e);
            } catch (InvocationTargetException e) {
                logger.error("site-->siteVo error.", e);
            }
            siteVos.add(siteVo);
        }
        return siteVos;
    }

    private List<NodeVo> copyNodeProperties(List<Node> nodes) {
        List<NodeVo> nodeVos = new ArrayList<NodeVo>();
        NodeVo nodeVo = null;
        for (Node node : nodes) {
            nodeVo = new NodeVo();
            try {
                BeanUtils.copyProperties(nodeVo, node);
                if (node.hasChildren()){
                    nodeVo.setChildren(copyNodeProperties(node.getChildren()));
                }
            } catch (IllegalAccessException e) {
                logger.error("site-->siteVo error.", e);
            } catch (InvocationTargetException e) {
                logger.error("site-->siteVo error.", e);
            }
            nodeVos.add(nodeVo);
        }
        return nodeVos;
    }
}
