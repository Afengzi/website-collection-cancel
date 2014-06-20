package com.afengzi.website.domain.site;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-20
 * Time: ÉÏÎç9:39
 * To change this template use File | Settings | File Templates.
 */
public class CategoryVo {
    private int type ;
    private String categoryName ;
    private List<BranchVo> branchVoList ;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<BranchVo> getBranchVoList() {
        return branchVoList;
    }

    public void setBranchVoList(List<BranchVo> branchVoList) {
        this.branchVoList = branchVoList;
    }
}
