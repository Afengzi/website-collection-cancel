package com.afengzi.website.domain.site;

import java.util.Date;

/**
 * <title>Website</title>
 * <p/>
 * <project>website-collection</project>
 * <p/>
 * <package>com.afengzi.website.domain.site</package>
 * <p/>
 * <file>Website.java</file>
 * <p/>
 * <date>2014年6月9日 下午10:16:26</date>
 * <p/>
 * <brief></brief>
 *
 * @author klov
 */
public class Website {

    private long id;
    private String title;
    private String url;
    private String description;
    /*类型*/
    /**
     * @see com.afengzi.website.domain.typeenum.SiteTypeEnum
     */
    private int moduleType;
    /**
     * @see com.afengzi.website.domain.typeenum.DevelopmentTechniqueEnum
     */
    private int areaType;
    /*优先级*/
    private int priority;
    private Date created;
    private Date modified;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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

    public int getModuleType() {
        return moduleType;
    }

    public void setModuleType(int moduleType) {
        this.moduleType = moduleType;
    }

    public int getAreaType() {
        return areaType;
    }

    public void setAreaType(int areaType) {
        this.areaType = areaType;
    }
}
