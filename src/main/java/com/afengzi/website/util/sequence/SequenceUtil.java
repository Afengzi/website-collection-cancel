package com.afengzi.website.util.sequence;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-27
 * Time: 上午10:31
 * To change this template use File | Settings | File Templates.
 */

import java.util.Map;
/**
 * 可以指定一个序列增长器,也可以使用默认的
 */
public class SequenceUtil {

    private Map<String, Sequence> sequenceMap;
    private Sequence defaultSequence;

    public void setDefaultSequence(Sequence defaultSequence) {
        this.defaultSequence = defaultSequence;
    }

    public void setSequenceMap(Map<String, Sequence> sequenceMap) {
        this.sequenceMap = sequenceMap;
    }

    /**
     * 如果没有在map中指定，则使用默认的。 <br/>
     * 如果没有默认的，则出错。<br/>
     * 没有写入操作，并发无问题。<br/>
     *
     * @param name sequence名字
     * @return
     */
    public long get(String name) {
       Sequence sequence = null;
        if (sequenceMap != null) {
            sequence = sequenceMap.get(name);
        }
        if (sequence == null) {
            if (defaultSequence != null) {
                return defaultSequence.getValue(name);
            } else {
                throw new RuntimeException("sequence " + name + " undefined!");
            }
        }
        return sequence.getValue(name);
    }
}
