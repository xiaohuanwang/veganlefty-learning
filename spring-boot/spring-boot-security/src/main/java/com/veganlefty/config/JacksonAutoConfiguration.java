package com.veganlefty.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * <p>description</p>
 *
 * @author puchaobo@caiduofu.cn
 * @date 2020-12-02 14:17:56
 */
@Configuration
class JacksonAutoConfiguration {

    /**
     * 序列换成json时,将所有的long变成string
     * 因为js中得数字类型不能包含所有的java long值
     */
    @Bean
    public SimpleModule simpleModule() {
        final SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        simpleModule.addSerializer(BigDecimal.class, new JsonSerializer<>() {
            @Override
            public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                if (Objects.isNull(value)) {
                    gen.writeNull();
                } else {
                    gen.writeString(value.stripTrailingZeros().toPlainString());
                }
            }
        });
        return simpleModule;
    }
}
