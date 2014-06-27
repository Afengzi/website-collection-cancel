package com.afengzi.website.domain.node;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-25
 * Time: ÉÏÎç9:17
 * To change this template use File | Settings | File Templates.
 */
public class Node {
    private int _id;
    private String title;
    private int depth;
    private Node previous;
    private List<Node> latter;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public List<Node> getLatter() {
        return latter;
    }

    public void setLatter(List<Node> latter) {
        this.latter = latter;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
