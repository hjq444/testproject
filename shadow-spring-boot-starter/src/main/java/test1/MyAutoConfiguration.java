package test1;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)
public class MyAutoConfiguration {
    @Bean
    public StudentService student(){
        System.out.println("开始初始化。。。。。");
        return new StudentService();
    }
}
