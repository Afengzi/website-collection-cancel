package com.afengzi.website.domain;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-4
 * Time: 上午9:45
 * To change this template use File | Settings | File Templates.
 */
public class BaseDomain implements Comparable {
    /**优先级*/
    private int priority;
    @Override
    public int compareTo(Object o) {
        if (!(o instanceof BaseDomain)){
            return 0 ;
        }
        BaseDomain d = (BaseDomain)o;

        return this.priority-d.priority ;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
