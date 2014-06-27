package com.afengzi.website.util.sequence;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-27
 * Time: ����10:31
 * To change this template use File | Settings | File Templates.
 */

import java.util.Map;
/**
 * ����ָ��һ������������,Ҳ����ʹ��Ĭ�ϵ�
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
     * ���û����map��ָ������ʹ��Ĭ�ϵġ� <br/>
     * ���û��Ĭ�ϵģ������<br/>
     * û��д����������������⡣<br/>
     *
     * @param name sequence����
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
