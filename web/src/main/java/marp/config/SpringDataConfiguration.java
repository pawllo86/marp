package marp.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("marp.entity")
@EnableJpaRepositories(basePackages = "marp.repository")
public class SpringDataConfiguration {

}