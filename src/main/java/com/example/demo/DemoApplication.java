package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

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
            <title>XYZ Global Technologies</title>
            <style>
                body { margin:0; font-family: Arial, sans-serif; background:#f4f6f8; }
                header { background:#003366; padding:20px; color:white; }
                header h1 { margin:0; }
                nav { margin-top:10px; }
                nav a {
                    color:white; margin-right:20px;
                    text-decoration:none; font-weight:bold;
                }
                nav a:hover { text-decoration:underline; }

                .hero {
                    background: linear-gradient(to right, #003366, #0059b3);
                    color:white; padding:60px; text-align:center;
                }
                .hero h2 { font-size:36px; }
                .hero p { font-size:18px; }

                .section {
                    padding:50px;
                    max-width:1100px;
                    margin:auto;
                }
                .section h3 { color:#003366; margin-bottom:20px; }

                .services {
                    display:grid;
                    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
                    gap:20px;
                }
                .card {
                    background:white;
                    padding:20px;
                    border-radius:8px;
                    box-shadow:0 4px 10px rgba(0,0,0,0.1);
                }

                footer {
                    background:#003366;
                    color:white;
                    padding:20px;
                    text-align:center;
                }
                footer a { color:#9ecbff; text-decoration:none; margin:0 10px; }
            </style>
        </head>
        <body>

        <header>
            <h1>XYZ Global Technologies</h1>
            <nav>
                <a href="#about">About Us</a>
                <a href="#services">Services</a>
                <a href="#contact">Contact</a>
                <a href="/register">Portal</a>
            </nav>
        </header>

        <div class="hero">
            <h2>Powering Digital Transformation</h2>
            <p>Cloud | DevOps | Enterprise Applications | AI Solutions</p>
        </div>

        <div class="section" id="about">
            <h3>About Us</h3>
            <p>
                XYZ Global Technologies is a leading IT solutions provider delivering
                world-class digital transformation services. We help enterprises
                innovate, scale, and succeed using cutting-edge technologies.
            </p>
        </div>

        <div class="section" id="services">
            <h3>Our Services</h3>
            <div class="services">
                <div class="card">
                    <h4>Cloud & DevOps</h4>
                    <p>AWS, Azure, CI/CD pipelines, Docker, Kubernetes.</p>
                </div>
                <div class="card">
                    <h4>Application Development</h4>
                    <p>Spring Boot, Microservices, REST APIs.</p>
                </div>
                <div class="card">
                    <h4>Enterprise Solutions</h4>
                    <p>ERP, CRM, System Integration.</p>
                </div>
                <div class="card">
                    <h4>Cyber Security</h4>
                    <p>Secure infrastructure and compliance solutions.</p>
                </div>
            </div>
        </div>

        <div class="section" id="contact">
            <h3>Contact Us</h3>
            <p><b>Head Office:</b> Hyderabad, India</p>
            <p><b>Email:</b> contact@xyzglobal.com</p>
            <p><b>Phone:</b> +91 98765 43210</p>
        </div>

        <footer>
            <p>© 2026 XYZ Global Technologies. All Rights Reserved.</p>
            <a href="#">Privacy Policy</a>
            <a href="#">Careers</a>
            <a href="#">Support</a>
        </footer>

        </body>
        </html>
        """;
    }
}
