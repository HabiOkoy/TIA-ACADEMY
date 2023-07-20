package auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtil;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtil.connect();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        String passwordMD5 = auth.MD5.getMd5(password);

        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        if (role.equals("admin")) {
            if (DBUtil.registerAdmin(email, passwordMD5)) {
                writer.println("Admin " + email + " berhasil didaftarkan");
                writer.println("<h4><a href=\"index.jsp\">Kembali ke Login</a></h4>");
            } else {
                writer.println("Email " + email + " sudah terdaftar sebagai admin");
                writer.println("<h4><a href=\"register.jsp\">Coba lagi</a></h4>");
            }
        } else {
            if (DBUtil.registerUser(email, passwordMD5)) {
                writer.println("User " + email + " berhasil didaftarkan");
                writer.println("<h4><a href=\"index.jsp\">Kembali ke Login</a></h4>");
            } else {
                writer.println("Email " + email + " sudah terdaftar sebagai user");
                writer.println("<h4><a href=\"register.jsp\">Coba lagi</a></h4>");
            }
        }

        writer.println("</body></html>");
        writer.flush();
    }
}
