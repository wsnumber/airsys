package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import config.DBconfig;

/**
 * 应用配置（spring配置）
 * 它相当于XML的替代者
 * @author ll
 *
 */
@Configuration
@ComponentScan({"dao","service","util"})
@Import(DBconfig.class)
@EnableAspectJAutoProxy
public class TestConfig {

}
