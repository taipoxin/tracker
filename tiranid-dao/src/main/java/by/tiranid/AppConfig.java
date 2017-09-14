package by.tiranid;

import by.tiranid.config.DataConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import(DataConfig.class)
@SpringBootApplication
@ComponentScan("by.tiranid")
public class AppConfig {

    public static void main(String[] args){
        SpringApplication.run(AppConfig.class);

    }

}
