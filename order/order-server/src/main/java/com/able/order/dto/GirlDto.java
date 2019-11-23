package com.able.order.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @param
 * @author jipeng
 * @date 2019-11-21 9:13
 */
@Data
@RefreshScope
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlDto {
    String name;
    int age;
}

