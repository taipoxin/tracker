package by.tiranid;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

/**
 * Created by Yayheniy_Lepkovich on 7/13/2017.
 */
@SpringBootApplication

@ComponentScan("by.apertura")
public class AppConfig {

    private static final String pathToConfig = "src/main/resources/logger/log4j2.xml";

    public static void main(String[] args){
        SpringApplication.run(AppConfig.class);

    }
}
