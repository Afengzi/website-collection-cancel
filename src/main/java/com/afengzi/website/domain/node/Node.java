package com.afengzi.website.domain.node;

import com.afengzi.website.domain.BaseDomain;
import org.apache.commons.collections.CollectionUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-25
 * Time: ����9:17
 * To change this template use File | Settings | File Templates.
 * �ڵ�bean��:���siteIds��Ϊ�����ʾ��Ҷ��
 */
public class Node extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -8733106272680210721L;
    private long _id;
    private String title;
    private int depth;
    private Node previous;
    private String userName;
    /**
     * �ӽڵ�
     */
    private List<Node> children;
    /**
     * վ��ID,�൱��Ҷ��ID
     */
    private List<Long> siteIds;
    private Date created;
    private Date modified;

    public boolean hasChildren(){
        return CollectionUtils.isNotEmpty(children) ;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public List<Long> getSiteIds() {
        return siteIds;
    }

    public void setSiteIds(List<Long> siteIds) {
        this.siteIds = siteIds;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
