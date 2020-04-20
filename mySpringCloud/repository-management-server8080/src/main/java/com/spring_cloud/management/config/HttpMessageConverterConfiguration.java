package com.spring_cloud.management.config;

import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
public class HttpMessageConverterConfiguration implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 定义一个convert转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        // 添加fastjson的配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        SerializerFeature[] serializerFeatures = new SerializerFeature[] {
                // List字段如果为null,输出为[],而非null
                // SerializerFeature.WriteNullListAsEmpty,
                // 字符类型字段如果为null,输出为"",而非null
                // SerializerFeature.WriteNullStringAsEmpty,
                // Boolean字段如果为null,输出为false,而非null
                // SerializerFeature.WriteNullBooleanAsFalse,
                // 保留null
                SerializerFeature.WriteMapNullValue,
                // Date的日期转换器
                SerializerFeature.WriteDateUseDateFormat,
                // 循环引用
                SerializerFeature.DisableCircularReferenceDetect, };

        fastJsonConfig.setSerializerFeatures(serializerFeatures);
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);

        SerializeConfig serializeConfig = new SerializeConfig();
        serializeConfig.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
        fastJsonConfig.setSerializeConfig(serializeConfig);

        // 在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(0, fastConverter);
    }
}
