package auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginAuth.isValid = false;
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Logout</title>");
        writer.println("<style>");
        writer.println("body {");
        writer.println("  font-family: Arial, sans-serif;");
        writer.println("  background-color: #000000;");
        writer.println("  color: #ffffff;");
        writer.println("  margin: 0;");
        writer.println("  padding: 0;");
        writer.println("}");
        writer.println(".container {");
        writer.println("  display: flex;");
        writer.println("  justify-content: center;");
        writer.println("  align-items: center;");
        writer.println("  height: 100vh;");
        writer.println("}");
        writer.println(".card {");
        writer.println("  background-color: #1F1F1F;");
        writer.println("  border-radius: 5px;");
        writer.println("  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);");
        writer.println("  padding: 20px;");
        writer.println("  width: 300px;");
        writer.println("}");
        writer.println("h2 {");
        writer.println("  color: #1DB954;");
        writer.println("  font-size: 24px;");
        writer.println("  margin: 0 0 20px;");
        writer.println("}");
        writer.println("p {");
        writer.println("  color: #ffffff;");
        writer.println("  margin: 0 0 20px;");
        writer.println("}");
        writer.println("a {");
        writer.println("  text-decoration: none;");
        writer.println("  color: #1DB954;");
        writer.println("}");
        writer.println("</style>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<div class=\"container\">");
        writer.println("<div class=\"card\">");
        writer.println("<h2>Logout Berhasil</h2>");
        writer.println("<p>Terima kasih telah menggunakan aplikasi kami.</p>");
        writer.println("<a href=\"index.jsp\">Kembali ke Login</a>");
        writer.println("</div>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }
}
