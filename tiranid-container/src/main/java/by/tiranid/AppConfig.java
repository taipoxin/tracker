package by.tiranid;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;


@SpringBootApplication

@ComponentScan("by.tiranid")
public class AppConfig {


    public static void main(String[] args){
        SpringApplication.run(AppConfig.class);
    }
}
