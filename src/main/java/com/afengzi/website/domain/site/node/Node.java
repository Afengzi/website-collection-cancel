package com.afengzi.website.domain.site.node;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-25
 * Time: ÉÏÎç9:17
 * To change this template use File | Settings | File Templates.
 */
public class Node {
    private int id;
    private String title;
    private int depth;
    private Node previous;
    private Node latter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Node getLatter() {
        return latter;
    }

    public void setLatter(Node latter) {
        this.latter = latter;
    }
}
