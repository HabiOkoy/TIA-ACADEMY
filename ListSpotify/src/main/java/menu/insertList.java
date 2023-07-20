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

@WebServlet(urlPatterns = {"/insertList"})
public class insertList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (LoginAuth.isValid) {
            PrintWriter writer = resp.getWriter();
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Input Data Spotify</title>");
            writer.println("<style>");
            writer.println("body {");
            writer.println("  font-family: Arial, sans-serif;");
            writer.println("  background-color: #000000;");
            writer.println("  color: #ffffff;");
            writer.println("  margin: 0;");
            writer.println("  padding: 0;");
            writer.println("}");

            writer.println(".container {");
            writer.println("  max-width: 400px;");
            writer.println("  margin: 0 auto;");
            writer.println("  padding: 20px;");
            writer.println("  background-color: #1F1F1F;");
            writer.println("  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);");
            writer.println("}");

            writer.println("h2 {");
            writer.println("  color: #1DB954;");
            writer.println("  text-align: center;");
            writer.println("}");

            writer.println("form {");
            writer.println("  margin-top: 20px;");
            writer.println("}");

            writer.println("label {");
            writer.println("  display: block;");
            writer.println("  margin-bottom: 10px;");
            writer.println("  color: #ffffff;");
            writer.println("}");

            writer.println("input[type=\"text\"] {");
            writer.println("  width: 100%;");
            writer.println("  padding: 10px;");
            writer.println("  margin-bottom: 20px;");
            writer.println("}");

            writer.println(".button-container {");
            writer.println("  display: flex;");
            writer.println("  justify-content: space-between;");
            writer.println("}");

            writer.println(".button-container button {");
            writer.println("  background-color: #1DB954;");
            writer.println("  color: #ffffff;");
            writer.println("  border: none;");
            writer.println("  padding: 10px 20px;");
            writer.println("  cursor: pointer;");
            writer.println("  border-radius: 4px;");
            writer.println("  transition: background-color 0.3s;");
            writer.println("}");

            writer.println(".button-container button:hover {");
            writer.println("  background-color: #1ED760;");
            writer.println("}");

            writer.println(".button-container button.cancel {");
            writer.println("  background-color: #FF0000;");
            writer.println("}");

            writer.println(".button-container button.cancel:hover {");
            writer.println("  background-color: #FF4444;");
            writer.println("}");

            writer.println("</style>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<div class=\"container\">");
            writer.println("<h2>Input Data Spotify</h2>");
            writer.println("<form action=\"insertList\" method=\"post\">");
            writer.println("<label>Nama:</label>");
            writer.println("<input type=\"text\" name=\"name\" required>");
            writer.println("<label>Artist:</label>");
            writer.println("<input type=\"text\" name=\"artist\" required>");
            writer.println("<label>Release Date:</label>");
            writer.println("<input type=\"text\" name=\"release_date\" required>");
            writer.println("<label>Length:</label>");
            writer.println("<input type=\"text\" name=\"length\" required>");
            writer.println("<label>Popularity:</label>");
            writer.println("<input type=\"text\" name=\"popularity\" required>");
            writer.println("<div class=\"button-container\">");
            writer.println("<button type=\"submit\">Simpan</button>");
            writer.println("<button type=\"button\" class=\"cancel\" onclick=\"location.href='Main'\">Cancel</button>");
            writer.println("</div>");
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
        String nama = req.getParameter("name");
        String artist = req.getParameter("artist");
        String release = req.getParameter("release_date");
        String stringLength = req.getParameter("length");
        int length = (stringLength != null) ? Integer.parseInt(stringLength) : 0;
        String stringPopularity = req.getParameter("popularity");
        int popularity = (stringPopularity != null) ? Integer.parseInt(stringPopularity) : 0;

        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        if (DBUtil.insert("listmusic", nama, artist, release, length, popularity)) {
            writer.println("Insert " + nama + " berhasil!<br/>");
        } else {
            writer.println("Insert " + nama + " gagal!<br/>");
        }
        writer.println("<a href=\"Main\">Kembali ke Menu Utama</a>");
        writer.println("</html></body>");
        writer.flush();
    }
}
