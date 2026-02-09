package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

    // ================= IN-MEMORY DATABASE =================
    static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // ================= HOME PAGE =================
    @GetMapping("/")
    public String home() {

        StringBuilder rows = new StringBuilder();

        for (Customer c : customers) {
            rows.append("""
                <tr>
                    <td>%s</td>
                    <td>%s</td>
                    <td>%s</td>
                    <td>%s</td>
                </tr>
            """.formatted(c.name, c.email, c.company, c.mobile));
        }

        return """
        <html>
        <head>
            <title>XYZ Global Technologies</title>
            <style>
                body { font-family: Arial; background:#f4f6f8; }
                header { background:#003366; color:white; padding:15px; }
                nav a { color:white; margin:15px; text-decoration:none; }
                table { width:90%%; margin:20px auto; border-collapse:collapse; }
                th, td { border:1px solid #ccc; padding:10px; text-align:center; }
                th { background:#003366; color:white; }
                .btn { background:#28a745; padding:10px 15px; color:white; text-decoration:none; border-radius:5px; }
            </style>
        </head>
        <body>

        <header>
            <h1>XYZ Global Technologies</h1>
            <nav>
                <a href="/">Home</a>
                <a href="/portal">Portal</a>
                <a href="/services">Services</a>
                <a href="/contact">Contact</a>
            </nav>
        </header>

        <div style="text-align:center;margin:20px;">
            <a class="btn" href="/portal">Register New Customer</a>
        </div>

        <h2 style="text-align:center;">Customer Database Records</h2>

        <table>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Company</th>
                <th>Mobile</th>
            </tr>
            %s
        </table>

        </body>
        </html>
        """.formatted(rows.toString());
    }

    // ================= PORTAL PAGE =================
    @GetMapping("/portal")
    public String portal() {
        return """
        <html>
        <head>
            <title>Customer Registration</title>
            <style>
                body { font-family: Arial; background:#eef2f3; }
                .box { width:400px; margin:60px auto; background:white; padding:30px; border-radius:8px; }
                input, button { width:100%%; padding:10px; margin-top:10px; }
                button { background:#003366; color:white; border:none; }
            </style>
        </head>
        <body>

        <div class="box">
            <h2>Customer Portal Registration</h2>
            <form method="post" action="/portal/register">
                <input name="name" placeholder="Full Name" required>
                <input name="email" type="email" placeholder="Email" required>
                <input name="company" placeholder="Company Name">
                <input name="mobile" placeholder="Mobile Number">
                <button type="submit">Register</button>
            </form>
        </div>

        </body>
        </html>
        """;
    }

    // ================= REGISTER =================
    @PostMapping("/portal/register")
    public String register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String company,
            @RequestParam String mobile) {

        customers.add(new Customer(name, email, company, mobile));

        return """
        <h2>Registration Successful ✅</h2>
        <p>Customer added to database.</p>
        <a href="/">View Customer Records</a>
        """;
    }

    // ================= SERVICES =================
    @GetMapping("/services")
    public String services() {
        return """
        <h1>Our Services</h1>
        <ul>
            <li>DevOps & CI/CD</li>
            <li>Spring Boot Microservices</li>
            <li>Docker & Kubernetes</li>
            <li>Cloud Migration</li>
        </ul>
        <a href="/">Back</a>
        """;
    }

    // ================= CONTACT =================
    @GetMapping("/contact")
    public String contact() {
        return """
        <h1>Contact Us</h1>
        <p>Email: support@xyzglobaltech.com</p>
        <p>Phone: +1-800-555-0199</p>
        <a href="/">Back</a>
        """;
    }
}

// ================= CUSTOMER CLASS =================
class Customer {
    String name;
    String email;
    String company;
    String mobile;

    Customer(String name, String email, String company, String mobile) {
        this.name = name;
        this.email = email;
        this.company = company;
        this.mobile = mobile;
    }
}
