package menu;

import auth.LoginAuth;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/MainUsers"})
public class MainUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (LoginAuth.isValid) {
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Main Menu</title>");
            writer.println("<style>");
            writer.println("body {");
            writer.println("  background-image: linear-gradient(to right, #1DB954, #191414);");
            writer.println("  font-family: Arial, sans-serif;");
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
            writer.println("  background-color: rgba(0, 0, 0, 0.7);");
            writer.println("  border-radius: 10px;");
            writer.println("  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);");
            writer.println("  padding: 40px;");
            writer.println("  width: 300px;");
            writer.println("  text-align: center;");
            writer.println("  transform: scale(0.95);");
            writer.println("  animation: scale-in 0.5s ease-in-out forwards;");
            writer.println("}");
            writer.println("@keyframes scale-in {");
            writer.println("  from {");
            writer.println("    transform: scale(0);");
            writer.println("  }");
            writer.println("  to {");
            writer.println("    transform: scale(0.95);");
            writer.println("  }");
            writer.println("}");
            writer.println("h2 {");
            writer.println("  color: #fff;");
            writer.println("  margin: 0 0 20px;");
            writer.println("}");
            writer.println("ul {");
            writer.println("  list-style-type: none;");
            writer.println("  padding: 0;");
            writer.println("}");
            writer.println(".menu-item {");
            writer.println("  background-color: rgba(255, 255, 255, 0.2);");
            writer.println("  padding: 15px;");
            writer.println("  border-radius: 5px;");
            writer.println("  margin-bottom: 15px;");
            writer.println("  transition: background-color 0.3s;");
            writer.println("}");
            writer.println(".menu-item:hover {");
            writer.println("  background-color: rgba(255, 255, 255, 0.3);");
            writer.println("}");
            writer.println("a {");
            writer.println("  text-decoration: none;");
            writer.println("  color: #1db954;");
            writer.println("  font-weight: bold;");
            writer.println("}");
            writer.println("</style>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<div class=\"container\">");
            writer.println("<div class=\"card\">");
            writer.println("<h2>Main Menu</h2>");
            writer.println("<ul>");
            writer.println("<li class=\"menu-item\"><a href=\"showListUsers\">SHOW ALL RECORD</a></li>");
            writer.println("<li class=\"menu-item\"><a href=\"prediksiList\">PREDIKSI</a></li>");
            writer.println("<li class=\"menu-item\"><a href=\"artistListUsers\">ARTIST POPULER</a></li>");
            writer.println("<li class=\"menu-item\"><a href=\"musikListUsers\">MUSIK POPULER</a></li>");
            writer.println("</ul>");
            writer.println("<a href=\"Logout\">Logout</a><br/>");
            writer.println("</div>");
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");
            writer.close();
        } else {
            LoginAuth.unauthorizedAccess(resp);
        }
    }

}
