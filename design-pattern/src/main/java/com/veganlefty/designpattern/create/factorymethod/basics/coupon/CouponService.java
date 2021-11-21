package com.veganlefty.designpattern.create.factorymethod.basics.coupon;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2021/11/21 9:17 上午
 */
public class CouponService {

    /**
     * description
     *
     * @param uId
     * @param couponNumber
     * @param uuid
     * @return CouponResult
     * @author wxh_work@163.com
     * @date 2021/11/21 9:56 上午
     * @since 1.0
     */
    public CouponResult sendCoupon(String uId, String couponNumber, String uuid) {
        System.out.println("模拟发放优惠券一张：" + uId + "," + couponNumber + "," + uuid);
        return new CouponResult("0000", "发放成功");
    }
}
