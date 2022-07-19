package com.veganlefty;

import com.veganlefty.constants.RabbitConsts;
import com.veganlefty.message.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootRabbitmqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 测试直接模式发送
     */
    @Test
    public void sendDirectQueue() {
            rabbitTemplate.convertAndSend(RabbitConsts.DIRECT_QUEUE, new Order(1,"订单1",1));
    }

    /**
     * 测试工作模式发送
     */
    @Test
    public void sendWorkQueue() {
        for (int i = 0; i < 5; i++) {
            rabbitTemplate.convertAndSend(RabbitConsts.WORK_QUEUE, new Order(i,"订单"+i,1));
        }
    }

}
