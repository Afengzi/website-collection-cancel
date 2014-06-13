package com.afengzi.website.domain.base;

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
 * <date>2014��6��9�� ����10:16:26</date>
 *
 * <brief></brief>
 *
 * @author klov
 *
 */
public class Website {

	private long id ;
	private String title ;
	private String address;
	/*����*/
	private int siteType ;
	/*���ȼ�*/
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	
}
