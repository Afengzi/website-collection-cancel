package com.afengzi.website.domain.site;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-20
 * Time: ÉÏÎç9:39
 * To change this template use File | Settings | File Templates.
 */
public class WebsiteVo {
    private long id;
    private String url;
    private String title;
    private String description;
    private int moduleKine;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getModuleKine() {
        return moduleKine;
    }

    public void setModuleKine(int moduleKine) {
        this.moduleKine = moduleKine;
    }
}
