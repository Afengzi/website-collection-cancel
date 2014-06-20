package com.afengzi.website.domain.site;

import java.util.Date;

/**
 * <title>Website</title>
 *
 * <project>website-collection</project>
 *
 * <package>com.afengzi.website.domain.site</package>
 *
 * <file>Website.java</file>
 *
 * <date>2014年6月9日 下午10:16:26</date>
 *
 * <brief></brief>
 *
 * @author klov
 *
 */
public class Website {

	private long id ;
	private String title ;
	private String url;
    private String description;
	/*类型*/
	private int siteType ;
	/*优先级*/
	private int priority;
	private Date created ;
	private Date modified ;

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

	public int getSiteType() {
		return siteType;
	}
	public void setSiteType(int siteType) {
		this.siteType = siteType;
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
}
