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

@WebServlet(urlPatterns = {"/editList"})
public class editList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (LoginAuth.isValid) {
            String nama = req.getParameter("name");
            String artist = req.getParameter("artist");
            String release = req.getParameter("release_date");
            String length = req.getParameter("length");
            String popularity = req.getParameter("popularity");

            PrintWriter writer = resp.getWriter();
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Edit Data Spotify</title>");
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
            writer.println("  margin-bottom: 20px;");
            writer.println("}");

            writer.println("form {");
            writer.println("  margin-top: 20px;");
            writer.println("}");

            writer.println("label {");
            writer.println("  display: block;");
            writer.println("  margin-bottom: 10px;");
            writer.println("}");

            writer.println("input[type=\"text\"] {");
            writer.println("  width: 100%;");
            writer.println("  padding: 10px;");
            writer.println("  margin-bottom: 20px;");
            writer.println("}");

            writer.println(".button {");
            writer.println("  display: inline-block;");
            writer.println("  padding: 10px 20px;");
            writer.println("  background-color: #333;");
            writer.println("  color: #fff;");
            writer.println("  border: none;");
            writer.println("  cursor: pointer;");
            writer.println("  text-align: center;");
            writer.println("  text-decoration: none;");
            writer.println("  transition: background-color 0.3s;");
            writer.println("}");

            writer.println(".button:hover {");
            writer.println("  background-color: #555;");
            writer.println("}");

            writer.println("</style>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<div class=\"container\">");
            writer.println("<h4>Edit Data Spotify</h4>");
            writer.println("<form action=\"editList\" method=\"post\">");
            writer.println("<label>Nama:</label>");
            writer.println("<input type=\"text\" name=\"name\" value=\"" + nama + "\" readonly>");
            writer.println("<label>Artist:</label>");
            writer.println("<input type=\"text\" name=\"artist\" value=\"" + artist + "\">");
            writer.println("<label>Release Date:</label>");
            writer.println("<input type=\"text\" name=\"release_date\" value=\"" + release + "\">");
            writer.println("<label>Length:</label>");
            writer.println("<input type=\"text\" name=\"length\" value=\"" + length + "\">");
            writer.println("<label>Popularity:</label>");
            writer.println("<input type=\"text\" name=\"popularity\" value=\"" + popularity + "\">");
            writer.println("<input type=\"submit\" value=\"UPDATE\" class=\"button\">");
            writer.println("</form>");
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");
            writer.flush();
        } else {
            LoginAuth.unauthorizedAccess(resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringNama = req.getParameter("name");
        String stringArtist = req.getParameter("artist");
        String stringRelease = req.getParameter("release_date");
        String stringLength = req.getParameter("length");
        int length = Integer.parseInt(stringLength);
        String stringPopularity = req.getParameter("popularity");
        int popularity = 0; // Set default value to 0

        if (stringPopularity != null && !stringPopularity.isEmpty()) {
            popularity = Integer.parseInt(stringPopularity);
        }

        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        if (DBUtil.update("listmusic", stringNama, stringArtist, stringRelease, length, popularity)) {
            writer.println("Update " + stringNama + " Berhasil!<br/>");
        } else {
            writer.println("Update " + stringNama + " Gagal!<br/>");
        }
        writer.println("<a href=\"Main\" class=\"button\">Kembali ke Menu Utama</a>");
        writer.println("</body></html>");
        writer.flush();
    }
}
