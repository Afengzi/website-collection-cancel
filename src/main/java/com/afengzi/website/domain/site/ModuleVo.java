package com.afengzi.website.domain.site;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-20
 * Time: ����7:17
 * To change this template use File | Settings | File Templates.
 */
public class ModuleVo {
    /**
     * @see com.afengzi.website.domain.typeenum.SiteTypeEnum
     */
    private int type;
    private String moduleName;
    private int priority;
    private List<WebsiteVo> websiteVoList;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<WebsiteVo> getWebsiteVoList() {
        return websiteVoList;
    }

    public void setWebsiteVoList(List<WebsiteVo> websiteVoList) {
        this.websiteVoList = websiteVoList;
    }
}
