package by.apertura.config;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Yayheniy_Lepkovich on 7/13/2017.
 */
@SpringBootApplication
public class AppConfig {
    public static void main(String[] args){
        SpringApplication.run(AppConfig.class);
    }
}
