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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/artistList"})
public class artistList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (LoginAuth.isValid) {
            showTopArtists(resp);
        } else {
            LoginAuth.unauthorizedAccess(resp);
        }
    }

    public static void showTopArtists(HttpServletResponse resp) throws IOException {
        ResultSet resultSet = null;
        DBUtil.connect();
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Artist Populer Spotify</title>");
        writer.println("<style>");
        writer.println("body {");
        writer.println("  font-family: Arial, sans-serif;");
        writer.println("  background-color: #191414;");
        writer.println("  color: #ffffff;");
        writer.println("  margin: 0;");
        writer.println("  padding: 0;");
        writer.println("}");

        writer.println(".container {");
        writer.println("  max-width: 800px;");
        writer.println("  margin: 0 auto;");
        writer.println("  padding: 20px;");
        writer.println("}");

        writer.println("h2 {");
        writer.println("  color: #1DB954;");
        writer.println("  text-align: center;");
        writer.println("}");

        writer.println(".table-container {");
        writer.println("  margin-top: 20px;");
        writer.println("}");

        writer.println(".table {");
        writer.println("  width: 100%;");
        writer.println("  border-collapse: collapse;");
        writer.println("}");

        writer.println(".table th, .table td {");
        writer.println("  padding: 10px;");
        writer.println("  text-align: left;");
        writer.println("}");

        writer.println(".table th {");
        writer.println("  background-color: #1DB954;");
        writer.println("  color: #ffffff;");
        writer.println("}");

        writer.println(".table .even {");
        writer.println("  background-color: #121212;");
        writer.println("}");

        writer.println(".action-column {");
        writer.println("  display: flex;");
        writer.println("  justify-content: flex-end;");
        writer.println("}");

        writer.println(".action-column a {");
        writer.println("  display: inline-block;");
        writer.println("  padding: 8px 16px;");
        writer.println("  background-color: #1DB954;");
        writer.println("  color: #ffffff;");
        writer.println("  text-decoration: none;");
        writer.println("  border-radius: 4px;");
        writer.println("  transition: background-color 0.3s;");
        writer.println("  margin-left: 10px;");
        writer.println("}");

        writer.println(".action-column a:hover {");
        writer.println("  background-color: #1ED760;");
        writer.println("}");

        writer.println(".action-column .delete {");
        writer.println("  background-color: #FF0000;");
        writer.println("}");

        writer.println(".btn-container {");
        writer.println("  display: flex;");
        writer.println("  justify-content: flex-start;");
        writer.println("  margin-top: 20px;");
        writer.println("}");

        writer.println(".btn {");
        writer.println("  display: inline-block;");
        writer.println("  padding: 8px 16px;");
        writer.println("  background-color: #1DB954;");
        writer.println("  color: #ffffff;");
        writer.println("  text-decoration: none;");
        writer.println("  border-radius: 4px;");
        writer.println("  transition: background-color 0.3s;");
        writer.println("  margin-right: 10px;");
        writer.println("}");

        writer.println(".btn:hover {");
        writer.println("  background-color: #1ED760;");
        writer.println("}");

        writer.println(".btn.primary {");
        writer.println("  background-color: #1ED760;");
        writer.println("}");

        writer.println(".btn.delete {");
        writer.println("  background-color: #FF0000;");
        writer.println("}");

        writer.println("</style>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<div class=\"container\">");
        writer.println("<h2>Artist Populer</h2>");
        writer.println("<div class=\"table-container\">");
        writer.println("<table class=\"table\">");
        writer.println("<thead>");
        writer.println("<tr>");
        writer.println("<th>Artist</th>");
        writer.println("<th>Popularity</th>");
        writer.println("</tr>");
        writer.println("</thead>");
        writer.println("<tbody>");
        try {
            resultSet = DBUtil.selectTopN("listmusic", "popularity", 10);
            int rowNumber = 0;
            while (resultSet.next()) {
                String artist = resultSet.getString("artist");
                int popularity = resultSet.getInt("popularity");
                writer.println("<tr" + (rowNumber % 2 == 0 ? " class=\"even\"" : "") + ">");
                writer.println("<td>" + artist + "</td>");
                writer.println("<td>" + popularity + "</td>");
                writer.println("</td>");
                writer.println("</tr>");
                rowNumber++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        writer.println("</tbody>");
        writer.println("</table>");
        writer.println("</div>");
        writer.println("<div class=\"btn-container\">");
        writer.println("<a href=\"Main\" class=\"btn primary\">Back to Main Menu</a>");
        writer.println("</div>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
        writer.flush();
    }
}
