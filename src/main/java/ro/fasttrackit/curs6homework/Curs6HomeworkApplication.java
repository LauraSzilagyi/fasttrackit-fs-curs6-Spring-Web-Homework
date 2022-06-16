package ro.fasttrackit.curs6homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ro.fasttrackit.curs6homework.ex2.config.CountryFileConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(value = CountryFileConfiguration.class)
public class Curs6HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Curs6HomeworkApplication.class, args);
    }

}
