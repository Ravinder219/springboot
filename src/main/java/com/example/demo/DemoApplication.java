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
        <!DOCTYPE html>
        <html>
        <head>
            <title>XYZ Global Technologies</title>
            <style>
                body { font-family: Arial; margin: 0; background: #f4f6f8; }
                header { background: #003366; color: white; padding: 15px; }
                nav a { color: white; margin: 15px; text-decoration: none; font-weight: bold; }
                section { padding: 40px; text-align: center; }
                footer { background: #003366; color: white; text-align: center; padding: 10px; }
                .btn { padding: 10px 20px; background: #28a745; color: white; text-decoration: none; border-radius: 5px; }
            </style>
        </head>
        <body>

        <header>
            <h1>XYZ Global Technologies</h1>
            <nav>
                <a href="/">Home</a>
                <a href="/about">About</a>
                <a href="/services">Services</a>
                <a href="/portal">Portal</a>
                <a href="/contact">Contact</a>
            </nav>
        </header>

        <section>
            <h2>Welcome to XYZ Global Technologies</h2>
            <p>We deliver enterprise IT, cloud, DevOps and digital transformation solutions.</p>
            <a class="btn" href="/services">Explore Services</a>
        </section>

        <footer>
            © 2026 XYZ Global Technologies
        </footer>

        </body>
        </html>
        """;
    }

    // ================= ABOUT =================
    @GetMapping("/about")
    public String about() {
        return """
        <h1>About XYZ Global Technologies</h1>
        <p>XYZ Global Technologies is a leading IT solutions provider offering cloud, DevOps, and enterprise software services.</p>
        <a href="/">Back to Home</a>
        """;
    }

    // ================= SERVICES =================
    @GetMapping("/services")
    public String services() {
        return """
        <h1>Our Services</h1>
        <ul>
            <li>Cloud Computing (AWS, Azure)</li>
            <li>DevOps & CI/CD Automation</li>
            <li>Spring Boot & Microservices</li>
            <li>Docker & Kubernetes</li>
            <li>Application Security & SonarQube</li>
        </ul>
        <a href="/">Back to Home</a>
        """;
    }

    // ================= PORTAL =================
    @GetMapping("/portal")
    public String portal() {
        return """
        <h1>Customer Portal Registration</h1>
        <form method="post" action="/portal/register">
            Name: <input type="text" name="name" required><br><br>
            Email: <input type="email" name="email" required><br><br>
            Company: <input type="text" name="company"><br><br>
            <button type="submit">Register</button>
        </form>
        <br>
        <a href="/">Back to Home</a>
        """;
    }

    // ================= PORTAL SUBMIT =================
    @PostMapping("/portal/register")
    public String register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam(required = false) String company) {

        return """
        <h1>Registration Successful</h1>
        <p>Thank you <b>%s</b> from <b>%s</b>.</p>
        <p>We will contact you at <b>%s</b>.</p>
        <a href="/">Go to Home</a>
        """.formatted(name, company == null ? "Individual" : company, email);
    }

    // ================= CONTACT =================
    @GetMapping("/contact")
    public String contact() {
        return """
        <h1>Contact Us</h1>
        <p>Email: support@xyzglobaltech.com</p>
        <p>Phone: +1 800 555 0199</p>
        <p>Location: New York, USA</p>
        <a href="/">Back to Home</a>
        """;
    }
}
