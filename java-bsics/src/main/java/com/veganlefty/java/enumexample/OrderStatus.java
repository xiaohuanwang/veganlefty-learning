package com.veganlefty.java.enumexample;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/11/2 22:18
 */
public class OrderStatus {
    OrderStatusEnum orderStatus;

    public OrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public static void main(String[] args) {
        OrderStatus unpaid = new OrderStatus(OrderStatusEnum.UNPAID),
                paid = new OrderStatus(OrderStatusEnum.PAID),
                cancel = new OrderStatus(OrderStatusEnum.CANCEL);
        unpaid.status();
        paid.status();
        cancel.status();
    }

    public void status() {
        System.out.println("判断订单状态");
        switch (orderStatus) {
            case UNPAID:
                System.out.println("订单未支付");
                break;
            case PAID:
            case PARTIAL_PAYMENT:
                System.out.println("部分支付");
                break;
            case CANCEL:
            default:
                System.out.println("订单状态未知");
        }
    }
}
