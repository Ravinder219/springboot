package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // ================= HOME PAGE =================
    @GetMapping("/")
    public String home() {
        return """
        <!DOCTYPE html>
        <html>
        <head>
            <title>XYZ Global Technologies</title>
            <style>
                body { font-family: Arial; margin:0; background:#f4f6f8; }
                header { background:#003366; padding:20px; color:white; }
                nav a { color:white; margin-right:20px; text-decoration:none; font-weight:bold; }
                nav a:hover { text-decoration:underline; }
                .hero { background:#0059b3; color:white; padding:60px; text-align:center; }
                .section { padding:40px; max-width:1000px; margin:auto; }
                footer { background:#003366; color:white; text-align:center; padding:15px; }
                a.btn { background:#003366; color:white; padding:10px 20px; text-decoration:none; border-radius:5px; }
            </style>
        </head>
        <body>

        <header>
            <h1>XYZ Global Technologies</h1>
            <nav>
                <a href="/">Home</a>
                <a href="/services">Services</a>
                <a href="/portal">Portal</a>
                <a href="#contact">Contact</a>
            </nav>
        </header>

        <div class="hero">
            <h2>Powering Digital Transformation</h2>
            <p>Cloud | DevOps | Enterprise | Security</p>
            <br>
            <a class="btn" href="/portal">Client Portal</a>
        </div>

        <div class="section">
            <h3>About Us</h3>
            <p>
                XYZ Global Technologies delivers enterprise-grade IT solutions
                helping organizations modernize, secure, and scale their systems.
            </p>
        </div>

        <div class="section" id="contact">
            <h3>Contact</h3>
            <p>Email: contact@xyzglobal.com</p>
            <p>Phone: +91 98765 43210</p>
        </div>

        <footer>
            © 2026 XYZ Global Technologies
        </footer>

        </body>
        </html>
        """;
    }

    // ================= SERVICES PAGE =================
    @GetMapping("/services")
    public String services() {
        return """
        <!DOCTYPE html>
        <html>
        <head>
            <title>Our Services</title>
            <style>
                body { font-family: Arial; background:#f4f6f8; padding:30px; }
                h1 { color:#003366; }
                .service { background:white; padding:20px; margin-bottom:20px;
                           border-radius:8px; box-shadow:0 2px 8px rgba(0,0,0,0.1);}
                a { color:#003366; text-decoration:none; font-weight:bold; }
            </style>
        </head>
        <body>

        <h1>Our Services</h1>

        <div class="service">
            <h3>Cloud & DevOps</h3>
            <p>AWS, Azure, CI/CD, Docker, Kubernetes automation.</p>
        </div>

        <div class="service">
            <h3>Application Development</h3>
            <p>Spring Boot, Microservices, REST APIs, Java Full Stack.</p>
        </div>

        <div class="service">
            <h3>Enterprise Solutions</h3>
            <p>ERP, CRM integrations, enterprise modernization.</p>
        </div>

        <div class="service">
            <h3>Cyber Security</h3>
            <p>Infrastructure security, vulnerability management.</p>
        </div>

        <br>
        <a href="/">← Back to Home</a>

        </body>
        </html>
        """;
    }

    // ================= PORTAL PAGE =================
    @GetMapping("/portal")
    public String portal() {
        return """
        <!DOCTYPE html>
        <html>
        <head>
            <title>Client Portal</title>
            <style>
                body { font-family: Arial; background:#f4f6f8; padding:30px; }
                form { background:white; max-width:400px; margin:auto; padding:30px;
                       border-radius:8px; box-shadow:0 2px 8px rgba(0,0,0,0.1);}
                input { width:100%; padding:10px; margin:10px 0; }
                button { background:#003366; color:white; padding:10px; border:none; width:100%; }
            </style>
        </head>
        <body>

        <form method="post" action="/register">
            <h2>Client Registration</h2>
            <input name="name" placeholder="Full Name" required>
            <input name="email" placeholder="Email" required>
            <input name="company" placeholder="Company Name">
            <button type="submit">Register</button>
        </form>

        </body>
        </html>
        """;
    }

    // ================= REGISTRATION SUCCESS =================
    @PostMapping("/register")
    public String register(@RequestParam String name) {
        return """
        <h2>Registration Successful</h2>
        <p>Welcome, """ + name + """!</p>
        <p>Your portal account has been created.</p>
        <a href="/">Go to Home</a>
        """;
    }
}
