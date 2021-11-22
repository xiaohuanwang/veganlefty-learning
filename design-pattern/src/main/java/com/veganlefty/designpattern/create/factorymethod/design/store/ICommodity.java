package com.veganlefty.designpattern.create.factorymethod.design.store;

import java.util.Map;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2021/11/22 10:57 上午
 */
public interface ICommodity {
    /**
     * description
     *
     * @param uId
     * @param commodityId
     * @param bizId
     * @param extMap
     * @return void
     * @author wxh_work@163.com
     * @date 2021/11/22 11:13 上午
     * @since 1.0
     */
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}
