package com.veganlefty.workflow;

import com.veganlefty.constant.OrderStatusChangeEvent;
import com.veganlefty.constant.OrderStatusEnum;
import com.veganlefty.model.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.statemachine.support.DefaultStateMachineContext;

import java.util.EnumSet;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/7 10:43
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends StateMachineConfigurerAdapter<OrderStatusEnum, OrderStatusChangeEvent> {

    @Override
    public void configure(StateMachineStateConfigurer<OrderStatusEnum, OrderStatusChangeEvent> states) throws Exception {
        states
                .withStates()
                .initial(OrderStatusEnum.WAIT_PAYMENT)
                .states(EnumSet.allOf(OrderStatusEnum.class));
    }

    /**
     * 配置状态转换事件关系
     * @param transitions
     * @throws Exception
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatusEnum, OrderStatusChangeEvent> transitions) throws Exception {
        transitions
                .withExternal().source(OrderStatusEnum.WAIT_PAYMENT).target(OrderStatusEnum.WAIT_DELIVER).event(OrderStatusChangeEvent.PAYED)
                .and()
                .withExternal().source(OrderStatusEnum.WAIT_DELIVER).target(OrderStatusEnum.WAIT_RECEIVE).event(OrderStatusChangeEvent.DELIVERY)
                .and()
                .withExternal().source(OrderStatusEnum.WAIT_RECEIVE).target(OrderStatusEnum.FINISH).event(OrderStatusChangeEvent.RECEIVED);
    }

    /**
     * 持久化配置
     * 实际使用中，可以配合redis等，进行持久化操作
     * @return
     */
    @Bean
    public StateMachinePersister<OrderStatusEnum, OrderStatusChangeEvent, Order> persister(){
        return new DefaultStateMachinePersister<>(new StateMachinePersist<OrderStatusEnum, OrderStatusChangeEvent, Order>() {
            @Override
            public void write(StateMachineContext<OrderStatusEnum, OrderStatusChangeEvent> context, Order order) throws Exception {
                //此处并没有进行持久化操作
            }

            @Override
            public StateMachineContext<OrderStatusEnum, OrderStatusChangeEvent> read(Order order) throws Exception {
                //此处直接获取order中的状态，其实并没有进行持久化读取操作
                return new DefaultStateMachineContext<>(order.getOrderStatus(), null, null, null);
            }
        });
    }

}
