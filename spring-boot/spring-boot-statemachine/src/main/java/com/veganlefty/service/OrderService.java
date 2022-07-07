package com.veganlefty.service;

import com.veganlefty.constant.OrderStatusChangeEvent;
import com.veganlefty.constant.OrderStatusEnum;
import com.veganlefty.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/7 15:53
 */
@Service("orderService")
public class OrderService {
    @Autowired
    private StateMachine<OrderStatusEnum, OrderStatusChangeEvent> orderStateMachine;

    @Autowired
    private StateMachinePersister<OrderStatusEnum, OrderStatusChangeEvent, Order> persister;

    private int id = 1;
    private Map<Long, Order> orders = new HashMap<>();

    public Order creat() {
        Order order = new Order();
        order.setOrderStatus(OrderStatusEnum.WAIT_PAYMENT);
        order.setOrderId(id++);
        orders.put(order.getOrderId(), order);
        return order;
    }

    public Order pay(int id) {
        Order order = orders.get(id);
        System.out.println("threadName=" + Thread.currentThread().getName() + " 尝试支付 id=" + id);
        Message message = MessageBuilder.withPayload(OrderStatusChangeEvent.PAYED).setHeader("order", order).build();
        if (!sendEvent(message, order)) {
            System.out.println("threadName=" + Thread.currentThread().getName() + " 支付失败, 状态异常 id=" + id);
        }
        return orders.get(id);
    }

    public Order deliver(int id) {
        Order order = orders.get(id);
        System.out.println("threadName=" + Thread.currentThread().getName() + " 尝试发货 id=" + id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.DELIVERY).setHeader("order", order).build(), orders.get(id))) {
            System.out.println("threadName=" + Thread.currentThread().getName() + " 发货失败，状态异常 id=" + id);
        }
        return orders.get(id);
    }

    public Order receive(int id) {
        Order order = orders.get(id);
        System.out.println("threadName=" + Thread.currentThread().getName() + " 尝试收货 id=" + id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.RECEIVED).setHeader("order", order).build(), orders.get(id))) {
            System.out.println("threadName=" + Thread.currentThread().getName() + " 收货失败，状态异常 id=" + id);
        }
        return orders.get(id);
    }

    public Map<Long, Order> getOrders() {
        return orders;
    }


    /**
     * 发送订单状态转换事件
     *
     * @param message
     * @param order
     * @return
     */
    private synchronized boolean sendEvent(Message<OrderStatusChangeEvent> message, Order order) {
        boolean result = false;
        try {
            orderStateMachine.start();
            //尝试恢复状态机状态
            persister.restore(orderStateMachine, order);
            //添加延迟用于线程安全测试
            Thread.sleep(1000);
            result = orderStateMachine.sendEvent(message);
            //持久化状态机状态
            persister.persist(orderStateMachine, order);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            orderStateMachine.stop();
        }
        return result;
    }
}
