package com.afengzi.website.service;

import com.afengzi.website.domain.base.WebsiteVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-6-11
 * Time: ����7:50
 * To change this template use File | Settings | File Templates.
 */
public interface WebsiteService {
    /**
     * ��ȡ�û���վ�㼯��
     *
     * @param userName
     * @return
     */
    public List<? extends WebsiteVo> getWebsiteVoList(String userName);
}
