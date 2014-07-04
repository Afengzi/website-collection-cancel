package com.afengzi.website.domain.node;

import com.afengzi.website.domain.site.SiteVo;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-27
 * Time: ÉÏÎç9:44
 * To change this template use File | Settings | File Templates.
 */
public class NodeVo {
    private int _id;
    private String title;
    private int prioriy;
    private List<NodeVo> children;
    private List<SiteVo> websiteVos;

    public boolean hasChildren(){
        return CollectionUtils.isNotEmpty(children) ;
    }
    public boolean hasLeaf(){
        return CollectionUtils.isNotEmpty(websiteVos) ;
    }
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrioriy() {
        return prioriy;
    }

    public void setPrioriy(int prioriy) {
        this.prioriy = prioriy;
    }

    public List<NodeVo> getChildren() {
        return children;
    }

    public void setChildren(List<NodeVo> children) {
        this.children = children;
    }

    public List<SiteVo> getWebsiteVos() {
        return websiteVos;
    }

    public void setWebsiteVos(List<SiteVo> websiteVos) {
        this.websiteVos = websiteVos;
    }
}
