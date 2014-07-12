package com.afengzi.website.util;

import com.afengzi.website.domain.node.Node;
import com.afengzi.website.domain.node.NodeVo;
import com.afengzi.website.domain.site.Site;
import com.afengzi.website.domain.site.SiteVo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-11
 * Time: ÏÂÎç3:47
 * To change this template use File | Settings | File Templates.
 */
public class BeanUtil {

    private static final Logger logger = Logger.getLogger("BeanUtil");

    public static List<SiteVo> copySiteProperties(List<Site> sites) {
        List<SiteVo> siteVos = new ArrayList<SiteVo>();
        SiteVo siteVo = null;
        for (Site site : sites) {
            siteVo = new SiteVo();
            try {
                org.apache.commons.beanutils.BeanUtils.copyProperties(siteVo, site);
            } catch (IllegalAccessException e) {
                logger.error("site-->siteVo error.", e);
            } catch (InvocationTargetException e) {
                logger.error("site-->siteVo error.", e);
            }
            siteVos.add(siteVo);
        }
        return siteVos;
    }

    public static List<NodeVo> copyNodeProperties(List<Node> nodes) {
        List<NodeVo> nodeVos = new ArrayList<NodeVo>();
        NodeVo nodeVo = null;
        for (Node node : nodes) {
            nodeVo = new NodeVo();
            try {
                BeanUtils.copyProperties(nodeVo, node);
                if (node.hasChildren()) {
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

    public static Site siteVo2Site(SiteVo siteVo){
        if (siteVo==null){
            return null ;
        }
        Site site = new Site();
        try {
            BeanUtils.copyProperties(site,siteVo);
        } catch (IllegalAccessException e) {
            logger.error("nodeVo-->node error.", e);
        } catch (InvocationTargetException e) {
            logger.error("nodeVo-->node error.", e);
        }
        return site ;
    }
}
