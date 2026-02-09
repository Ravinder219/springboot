package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // ================= HOME =================
    @GetMapping("/")
    public String home() {
        return """
        <html>
        <head>
            <title>XYZ Global Technologies</title>
            <style>
                body { font-family: Arial; background:#f4f6f8; margin:0; }
                header { background:#003366; color:white; padding:15px; }
                nav a { color:white; margin:15px; text-decoration:none; font-weight:bold; }
                section { padding:40px; text-align:center; }
                footer { background:#003366; color:white; text-align:center; padding:10px; }
                .btn { background:#28a745; padding:10px 20px; color:white; text-decoration:none; border-radius:5px; }
            </style>
        </head>
        <body>

        <header>
            <h1>XYZ Global Technologies</h1>
            <nav>
                <a href="/">Home</a>
                <a href="/services">Services</a>
                <a href="/portal">Portal</a>
                <a href="/contact">Contact</a>
            </nav>
        </header>

        <section>
            <h2>Welcome to XYZ Global Technologies</h2>
            <p>Enterprise IT, Cloud & DevOps Solutions</p>
            <a class="btn" href="/portal">Customer Portal</a>
        </section>

        <footer>© 2026 XYZ Global Technologies</footer>
        </body>
        </html>
        """;
    }

    // ================= SERVICES =================
    @GetMapping("/services")
    public String services() {
        return """
        <h1>Our Services</h1>
        <ul>
            <li>Cloud Computing</li>
            <li>DevOps CI/CD</li>
            <li>Spring Boot Microservices</li>
            <li>Docker & Kubernetes</li>
        </ul>
        <a href="/">Back</a>
        """;
    }

    // ================= PORTAL =================
    @GetMapping("/portal")
    public String portal() {
        return """
        <html>
        <head>
            <title>Customer Registration</title>
            <style>
                body { font-family: Arial; background:#eef2f3; }
                .box { width:400px; margin:60px auto; background:white; padding:30px; border-radius:8px; }
                input, button { width:100%; padding:10px; margin-top:10px; }
                button { background:#003366; color:white; border:none; }
            </style>
        </head>
        <body>

        <div class="box">
            <h2>Customer Portal Registration</h2>
            <form method="post" action="/portal/register">
                <input type="text" name="name" placeholder="Full Name" required>
                <input type="email" name="email" placeholder="Email Address" required>
                <input type="text" name="company" placeholder="Company Name">
                <input type="text" name="mobile" placeholder="Mobile Number">
                <button type="submit">Register</button>
            </form>
        </div>

        </body>
        </html>
        """;
    }

    // ================= SHOW DETAILS =================
    @PostMapping("/portal/register")
    public String register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String company,
            @RequestParam String mobile) {

        return """
        <html>
        <head>
            <title>Registration Successful</title>
            <style>
                body { font-family: Arial; background:#f4f6f8; }
                .card { width:450px; margin:60px auto; background:white; padding:30px; border-radius:8px; }
                h2 { color:#28a745; }
                p { font-size:16px; }
            </style>
        </head>
        <body>

        <div class="card">
            <h2>Registration Successful ✅</h2>
            <p><b>Name:</b> %s</p>
            <p><b>Email:</b> %s</p>
            <p><b>Company:</b> %s</p>
            <p><b>Mobile:</b> %s</p>
            <br>
            <a href="/">Go to Home</a>
        </div>

        </body>
        </html>
        """.formatted(name, email, company, mobile);
    }

    // ================= CONTACT =================
    @GetMapping("/contact")
    public String contact() {
        return """
        <h1>Contact Us</h1>
        <p>Email: support@xyzglobaltech.com</p>
        <p>Phone: +1 800 555 0199</p>
        <a href="/">Back</a>
        """;
    }
}
