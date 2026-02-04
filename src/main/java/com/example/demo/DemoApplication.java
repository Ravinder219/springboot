package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Demo Spring Boot App</title>
                    <style>
                        body { font-family: Arial, sans-serif; background-color: #f0f0f0; text-align: center; margin-top: 50px; }
                        h1 { color: #333; }
                        p { font-size: 18px; color: #555; }
                        a.button { display: inline-block; padding: 10px 20px; margin-top: 20px; background-color: #4CAF50; color: white; text-decoration: none; border-radius: 5px; }
                        a.button:hover { background-color: #45a049; }
                    </style>
                </head>
                <body>
                    <h1>Welcome to Demo Spring Boot App!</h1>
                    <p>This is a simple HTML page served by Spring Boot.</p>
                    <a class="button" href="/hello">Go to Hello Endpoint</a>
                </body>
                </html>
                """;
    }

    @GetMapping("/hello")
    public String hello() {
        return "<h2>Hello World endpoint!</h2><p>This is another page.</p>";
    }
}
