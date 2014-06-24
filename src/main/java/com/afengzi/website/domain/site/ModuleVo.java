package com.afengzi.website.domain.site;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-20
 * Time: ÏÂÎç7:17
 * To change this template use File | Settings | File Templates.
 */
public class ModuleVo {
    private int kind;
    private String moduleName;
    private List<WebsiteVo> websiteVoList;

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public List<WebsiteVo> getWebsiteVoList() {
        return websiteVoList;
    }

    public void setWebsiteVoList(List<WebsiteVo> websiteVoList) {
        this.websiteVoList = websiteVoList;
    }
}
