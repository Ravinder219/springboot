package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.*;

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

    // ======================
    // HOME PAGE
    // ======================
    @GetMapping("/")
    public String home() {
        return """
        <!DOCTYPE html>
        <html>
        <head>
            <title>Destion Technologies</title>
            <style>
                body { font-family: Arial; background: #f4f6f8; text-align: center; padding: 50px; }
                h1 { color: #0b5ed7; }
                p { font-size: 18px; }
                .btn { padding: 12px 25px; background: #198754; color: white; text-decoration: none; border-radius: 6px; }
                .btn:hover { background: #157347; }
            </style>
        </head>
        <body>
            <h1>Welcome to Destion Technologies</h1>
            <p>We deliver enterprise-grade DevOps & Cloud solutions.</p>
            <p>CI/CD | Docker | Kubernetes | AWS</p>
            <a class="btn" href="/register">Register Now</a>
        </body>
        </html>
        """;
    }

    // ======================
    // REGISTRATION PAGE
    // ======================
    @GetMapping("/register")
    public String register() {
        return """
        <!DOCTYPE html>
        <html>
        <head>
            <title>User Registration</title>
            <style>
                body { font-family: Arial; background: #eef2f7; padding: 40px; }
                .container { max-width: 400px; margin: auto; background: white; padding: 25px; border-radius: 8px; }
                h2 { text-align: center; color: #0b5ed7; }
                input, button { width: 100%; padding: 10px; margin-top: 10px; }
                button { background: #0b5ed7; color: white; border: none; border-radius: 4px; }
                button:hover { background: #084298; }
            </style>
        </head>
        <body>
            <div class="container">
                <h2>Register with Destion</h2>
                <form action="/submit" method="post">
                    <input type="text" name="name" placeholder="Full Name" required />
                    <input type="email" name="email" placeholder="Email Address" required />
                    <input type="text" name="company" placeholder="Company Name" required />
                    <button type="submit">Submit</button>
                </form>
            </div>
        </body>
        </html>
        """;
    }

    // ======================
    // FORM SUBMIT
    // ======================
    @PostMapping("/submit")
    public String submit(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String company) {

        return """
        <!DOCTYPE html>
        <html>
        <head>
            <title>Registration Success</title>
            <style>
                body { font-family: Arial; background: #d1e7dd; text-align: center; padding: 60px; }
                h1 { color: #0f5132; }
                p { font-size: 18px; }
                a { text-decoration: none; color: #0d6efd; }
            </style>
        </head>
        <body>
            <h1>Registration Successful 🎉</h1>
            <p>Thank you <b>""" + name + """</b>!</p>
            <p>Email: """ + email + """</p>
            <p>Company: """ + company + """</p>
            <br/>
            <a href="/">Back to Home</a>
        </body>
        </html>
        """;
    }
}
