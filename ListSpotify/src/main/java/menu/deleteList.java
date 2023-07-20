package menu;

import auth.LoginAuth;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtil;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/deleteList"})
public class deleteList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (LoginAuth.isValid) {
            String name = req.getParameter("name");
            String artist = req.getParameter("artist");
            String release_date = req.getParameter("release_date");
            int length = Integer.parseInt(req.getParameter("length"));
            int popularity = Integer.parseInt(req.getParameter("popularity"));

            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Delete Data Spotify</title>");
            writer.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
            writer.println("<style>");
            writer.println("body {");
            writer.println("  font-family: Arial, sans-serif;");
            writer.println("  background-color: #f5f5f5;");
            writer.println("  margin: 0;");
            writer.println("  padding: 0;");
            writer.println("}");

            writer.println(".container {");
            writer.println("  max-width: 400px;");
            writer.println("  margin: 0 auto;");
            writer.println("  padding: 20px;");
            writer.println("  background-color: #fff;");
            writer.println("  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);");
            writer.println("}");

            writer.println("h4 {");
            writer.println("  color: #333;");
            writer.println("  text-align: center;");
            writer.println("}");

            writer.println(".form-group {");
            writer.println("  margin-bottom: 20px;");
            writer.println("}");

            writer.println("label {");
            writer.println("  display: block;");
            writer.println("  margin-bottom: 10px;");
            writer.println("}");

            writer.println("input[type=\"text\"] {");
            writer.println("  width: 100%;");
            writer.println("  padding: 10px;");
            writer.println("}");

            writer.println(".btn-primary {");
            writer.println("  background-color: #333;");
            writer.println("  color: #fff;");
            writer.println("  border: none;");
            writer.println("  padding: 10px 20px;");
            writer.println("  cursor: pointer;");
            writer.println("}");

            writer.println("</style>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<div class=\"container\">");
            writer.println("<h4>Delete Data Spotify</h4>");
            writer.println("<form action=\"deleteList\" method=\"post\">");
            writer.println("<div class=\"form-group\">");
            writer.println("<label for=\"name\">Nama:</label>");
            writer.println("<input type=\"text\" id=\"name\" name=\"name\" value=\"" + name + "\" readonly>");
            writer.println("</div>");
            writer.println("<div class=\"form-group\">");
            writer.println("<label for=\"artist\">Artist:</label>");
            writer.println("<input type=\"text\" id=\"artist\" name=\"artist\" value=\"" + artist + "\">");
            writer.println("</div>");
            writer.println("<div class=\"form-group\">");
            writer.println("<label for=\"release_date\">Release Date:</label>");
            writer.println("<input type=\"text\" id=\"release_date\" name=\"release_date\" value=\"" + release_date + "\">");
            writer.println("</div>");
            writer.println("<div class=\"form-group\">");
            writer.println("<label for=\"length\">Length:</label>");
            writer.println("<input type=\"text\" id=\"length\" name=\"length\" value=\"" + length + "\">");
            writer.println("</div>");
            writer.println("<div class=\"form-group\">");
            writer.println("<label for=\"popularity\">Popularity:</label>");
            writer.println("<input type=\"text\" id=\"popularity\" name=\"popularity\" value=\"" + popularity + "\">");
            writer.println("</div>");
            writer.println("<input type=\"submit\" value=\"DELETE\" class=\"btn btn-primary\">");
            writer.println("</form>");
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");
        } else {
            LoginAuth.unauthorizedAccess(resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nama = req.getParameter("name");

        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");

        if (DBUtil.delete("listmusic", nama)) {
            writer.println("Delete " + nama + " Berhasil! <br/>");
        } else {
            writer.println("Delete " + nama + " Gagal! <br/>");
        }
        writer.println("<h4><a href=\"Main\" class=\"btn btn-primary\">Kembali ke Menu Utama</a></h4>");
        writer.println("</html></body>");
        writer.flush();
    }
}