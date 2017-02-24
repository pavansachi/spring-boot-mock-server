package org.mockserver.configs;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages={"org.mockserver.dao.repositories"})
@EntityScan({"org.mockserver.dao.models"})
public class DataConfig {

}
