package com.project.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AttoResearchAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttoResearchAssignmentApplication.class, args);
    }

}
