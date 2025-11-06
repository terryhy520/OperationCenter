package com.meta.project.operationcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.meta.project.operationcenter")
@EnableJpaRepositories("com.meta.project.operationcenter.adapter.driven.persistance")
@EntityScan("com.meta.project.operationcenter.domain")
public class OperationcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperationcenterApplication.class, args);
    }

}
