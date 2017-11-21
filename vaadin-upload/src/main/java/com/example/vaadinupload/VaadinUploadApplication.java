package com.example.vaadinupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class VaadinUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(VaadinUploadApplication.class, args);
    }
}
