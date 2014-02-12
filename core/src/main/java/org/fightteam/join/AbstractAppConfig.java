package org.fightteam.join;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 简单程序初始化上下文
 *
 * 基于spring的配置
 *
 * 扫描排除spring mvc的注解
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
@ComponentScan(basePackageClasses = AbstractAppConfig.class,
        excludeFilters = {@ComponentScan.Filter(Controller.class), @ComponentScan.Filter(ControllerAdvice.class)})
public class AbstractAppConfig {


}
