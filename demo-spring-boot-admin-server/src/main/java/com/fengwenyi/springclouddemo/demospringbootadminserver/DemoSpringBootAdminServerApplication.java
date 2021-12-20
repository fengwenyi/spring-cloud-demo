package com.fengwenyi.springclouddemo.demospringbootadminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-20
 */
@SpringBootApplication
@EnableAdminServer
public class DemoSpringBootAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootAdminServerApplication.class, args);
    }

}
