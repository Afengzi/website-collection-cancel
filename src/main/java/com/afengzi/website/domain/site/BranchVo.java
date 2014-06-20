package com.afengzi.website.domain.site;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-20
 * Time: ÏÂÎç7:17
 * To change this template use File | Settings | File Templates.
 */
public class BranchVo {
    private int type;
    private String branchName;
    private List<WebsiteVo> websiteVoList;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<WebsiteVo> getWebsiteVoList() {
        return websiteVoList;
    }

    public void setWebsiteVoList(List<WebsiteVo> websiteVoList) {
        this.websiteVoList = websiteVoList;
    }
}
