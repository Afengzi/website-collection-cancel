package com.afengzi.website.domain.node;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-27
 * Time: ÉÏÎç9:44
 * To change this template use File | Settings | File Templates.
 */
public class NodeVo {
    private int _id;
    private String title;
    private NodeVo nodeVo;
    private List<NodeVo> latters;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public NodeVo getNodeVo() {
        return nodeVo;
    }

    public void setNodeVo(NodeVo nodeVo) {
        this.nodeVo = nodeVo;
    }

    public List<NodeVo> getLatters() {
        return latters;
    }

    public void setLatters(List<NodeVo> latters) {
        this.latters = latters;
    }
}
