package com.veganlefty.designpattern.create.factorymethod.basics.card;

/**
 * 模拟爱奇艺会员卡服务
 *
 * @author wxh_work@163.com
 * @date 2021/11/20 11:57 下午
 * @version 1.0
 */
public class IQiYiCardService {
    /**
     * description 
     * @param bindMobileNumber
     * @param cardId
     * @return void 
     * @author wxh_work@163.com
     * @date 2021/11/21 12:52 上午
     * @since 1.0
     */
    public void grantToken(String bindMobileNumber, String cardId) {
        System.out.println("模拟发放爱奇艺会员卡一张：" + bindMobileNumber + "，" + cardId);
    }

}
