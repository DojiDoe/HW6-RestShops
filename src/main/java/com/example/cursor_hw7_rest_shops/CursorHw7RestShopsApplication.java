package com.example.cursor_hw7_rest_shops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CursorHw7RestShopsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CursorHw7RestShopsApplication.class, args);
    }

}
