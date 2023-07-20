package auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import menu.Main;
import utils.DBUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/LoginAuth"})
public class LoginAuth extends HttpServlet {

    public static boolean isValid = false;

    public static void unauthorizedAccess(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h1>Unauthorized Access</h1>");
        resp.getWriter().println("<p>You are not authorized to access this page.</p>");
        resp.getWriter().println("<p>Please login with valid credentials.</p>");
        resp.getWriter().println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtil.connect();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordMD5 = auth.MD5.getMd5(password);

        ResultSet resultSet = null;

        resp.setContentType("text/html");
        resp.getWriter().println("<html>");
        resp.getWriter().println("<head>");
        resp.getWriter().println("<title>Login Result</title>");
        resp.getWriter().println("<style>");
        resp.getWriter().println("body {");
        resp.getWriter().println("  background-image: linear-gradient(to right, #1DB954, #191414);");
        resp.getWriter().println("  font-family: Arial, sans-serif;");
        resp.getWriter().println("  margin: 0;");
        resp.getWriter().println("  padding: 0;");
        resp.getWriter().println("}");
        resp.getWriter().println(".container {");
        resp.getWriter().println("  display: flex;");
        resp.getWriter().println("  justify-content: center;");
        resp.getWriter().println("  align-items: center;");
        resp.getWriter().println("  height: 100vh;");
        resp.getWriter().println("}");
        resp.getWriter().println(".card {");
        resp.getWriter().println("  background-color: rgba(0, 0, 0, 0.7);");
        resp.getWriter().println("  border-radius: 10px;");
        resp.getWriter().println("  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);");
        resp.getWriter().println("  padding: 40px;");
        resp.getWriter().println("  width: 300px;");
        resp.getWriter().println("  text-align: center;");
        resp.getWriter().println("  transform: scale(0.95);");
        resp.getWriter().println("  animation: scale-in 0.5s ease-in-out forwards;");
        resp.getWriter().println("}");
        resp.getWriter().println("@keyframes scale-in {");
        resp.getWriter().println("  from {");
        resp.getWriter().println("    transform: scale(0);");
        resp.getWriter().println("  }");
        resp.getWriter().println("  to {");
        resp.getWriter().println("    transform: scale(0.95);");
        resp.getWriter().println("  }");
        resp.getWriter().println("}");
        resp.getWriter().println("h2 {");
        resp.getWriter().println("  color: #fff;");
        resp.getWriter().println("  margin: 0 0 20px;");
        resp.getWriter().println("}");
        resp.getWriter().println("p {");
        resp.getWriter().println("  color: #fff;");
        resp.getWriter().println("  margin: 0 0 10px;");
        resp.getWriter().println("}");
        resp.getWriter().println("a {");
        resp.getWriter().println("  text-decoration: none;");
        resp.getWriter().println("  color: #1db954;");
        resp.getWriter().println("  font-weight: bold;");
        resp.getWriter().println("}");
        resp.getWriter().println("</style>");
        resp.getWriter().println("</head>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<div class=\"container\">");
        resp.getWriter().println("<div class=\"card\">");

        try {
            resultSet = DBUtil.selectUser(email, passwordMD5);
            if (resultSet.next()) {
                isValid = true;
                resp.getWriter().println("<h2>Login Successful</h2>");
                resp.getWriter().println("<p>Welcome, " + email + "!</p>");
                resp.getWriter().println("<p><a href=\"MainUsers\">Go to Main Menu</a></p>");
            } else {
                resultSet = DBUtil.selectAdmin(email, passwordMD5);
                if (resultSet.next()) {
                    isValid = true;
                    resp.getWriter().println("<h2>Login Successful</h2>");
                    resp.getWriter().println("<p>Welcome, " + email + "!</p>");
                    resp.getWriter().println("<p><a href=\"Main\">Go to Main Menu</a></p>");
                } else {
                    resp.getWriter().println("<h2>Login Failed</h2>");
                    resp.getWriter().println("<p>Invalid email or password.</p>");
                    resp.getWriter().println("<p><a href=\"index.jsp\">Try Again</a></p>");
                }
            }
        } catch (SQLException e) {
            resp.getWriter().println("<h2>Error</h2>");
            resp.getWriter().println("<p>An error occurred while processing your request.</p>");
            resp.getWriter().println("<p><a href=\"index.jsp\">Try Again</a></p>");
            e.printStackTrace();
        }

        resp.getWriter().println("</div>");
        resp.getWriter().println("</div>");
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");

        resp.getWriter().flush();

        DBUtil.close();
    }
}
