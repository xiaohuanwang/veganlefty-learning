package com.veganlefty.designpattern.create.factorymethod.design;

import com.veganlefty.designpattern.create.factorymethod.design.store.ICommodity;
import com.veganlefty.designpattern.create.factorymethod.design.store.impl.CardCommodityService;
import com.veganlefty.designpattern.create.factorymethod.design.store.impl.CouponCommodityService;
import com.veganlefty.designpattern.create.factorymethod.design.store.impl.GoodsCommodityService;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2021/11/22 10:55 上午
 */
public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) {
            return null;
        }
        if (1 == commodityType) {
            return new CouponCommodityService();
        }
        if (2 == commodityType) {
            return new GoodsCommodityService();
        }
        if (3 == commodityType) {
            return new CardCommodityService();
        }
        throw new RuntimeException("不存在的商品服务类型");
    }
}
