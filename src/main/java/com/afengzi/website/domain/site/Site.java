package com.afengzi.website.domain.site;

import com.afengzi.website.domain.BaseDomain;

import java.io.Serializable;
import java.util.Date;

/**
 * <title>Site</title>
 * <p/>
 * <project>website-collection</project>
 * <p/>
 * <package>com.afengzi.website.domain.site</package>
 * <p/>
 * <file>Site.java</file>
 * <p/>
 * <date>2014��6��9�� ����10:16:26</date>
 * <p/>
 * <brief></brief>
 *
 * @author klov
 */
public class Site extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 6977823849458882739L;
    private long _id;
    private String title;
    private String url;
    private String description;
    private int nodeId;
    private String nodeName;
    private String userName;
    private int status;
    private Date created;
    private Date modified;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
