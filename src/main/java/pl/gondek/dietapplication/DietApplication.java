package pl.gondek.dietapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DietApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(DietApplication.class, args);
    }
}
