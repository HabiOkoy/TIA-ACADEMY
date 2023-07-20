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

@WebServlet(urlPatterns = {"/showListUsers"})
public class showListUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (LoginAuth.isValid) {
            String searchName = req.getParameter("searchName");
            if (searchName != null && !searchName.isEmpty()) {
                showFilteredRecord(resp, searchName);
            } else {
                showAllRecord(resp);
            }
        } else {
            LoginAuth.unauthorizedAccess(resp);
        }
    }

    public static void showAllRecord(HttpServletResponse resp) throws IOException {
        ResultSet resultSet = null;
        DBUtil.connect();
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Music Populer Spotify</title>");
        writer.println("<style>");
        writer.println("body {");
        writer.println("  font-family: Arial, sans-serif;");
        writer.println("  background-color: #181818;");
        writer.println("  margin: 0;");
        writer.println("  padding: 0;");
        writer.println("}");

        writer.println(".container {");
        writer.println("  max-width: 960px;");
        writer.println("  margin: 0 auto;");
        writer.println("  padding: 20px;");
        writer.println("}");

        writer.println("h2 {");
        writer.println("  text-align: center;");
        writer.println("  color: #1db954;");
        writer.println("}");

        writer.println("table {");
        writer.println("  width: 100%;");
        writer.println("  border-collapse: collapse;");
        writer.println("  margin-top: 20px;");
        writer.println("}");

        writer.println("th, td {");
        writer.println("  padding: 10px;");
        writer.println("  text-align: left;");
        writer.println("  border-bottom: 1px solid #282828;");
        writer.println("}");

        writer.println("th {");
        writer.println("  background-color: #282828;");
        writer.println("  color: white;");
        writer.println("}");

        writer.println("tr.even {");
        writer.println("  background-color: #121212;");
        writer.println("}");

        writer.println("input[type='text'] {");
        writer.println("  padding: 8px;");
        writer.println("  border: 1px solid #282828;");
        writer.println("  border-radius: 4px;");
        writer.println("  color: #fff;");
        writer.println("  background-color: #121212;");
        writer.println("}");

        writer.println("input[type='submit'] {");
        writer.println("  padding: 8px 16px;");
        writer.println("  background-color: #1db954;");
        writer.println("  color: white;");
        writer.println("  border: none;");
        writer.println("  border-radius: 4px;");
        writer.println("  cursor: pointer;");
        writer.println("}");

        writer.println("a.button {");
        writer.println("  padding: 8px 16px;");
        writer.println("  background-color: #1db954;");
        writer.println("  color: white;");
        writer.println("  text-decoration: none;");
        writer.println("  border-radius: 4px;");
        writer.println("}");

        writer.println("a.button.success {");
        writer.println("  background-color: #1db954;");
        writer.println("}");

        writer.println("a.button.delete {");
        writer.println("  background-color: #ff0000;");
        writer.println("}");

        writer.println("a.button.primary {");
        writer.println("  background-color: #1db954;");
        writer.println("}");

        writer.println("</style>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<div class=\"container\">");
        writer.println("<h2>Musik Populer</h2>");
        writer.println("<form action=\"showList\" method=\"GET\" style=\"text-align: right;\">");
        writer.println("<input type=\"text\" name=\"searchName\" placeholder=\"Search by name\">");
        writer.println("<input type=\"submit\" value=\"Search\">");
        writer.println("</form>");
        writer.println("<div class=\"table-container\">");
        writer.println("<table>");
        writer.println("<thead>");
        writer.println("<tr>");
        writer.println("<th>Name</th>");
        writer.println("<th>Artist</th>");
        writer.println("<th>Release Date</th>");
        writer.println("<th>Length</th>");
        writer.println("<th>Popularity</th>");
        writer.println("</tr>");
        writer.println("</thead>");
        writer.println("<tbody>");
        try {
            resultSet = DBUtil.selectAll("listmusic");
            int rowNumber = 0;
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String artist = resultSet.getString("artist");
                String releaseDate = resultSet.getString("release_date");
                int length = resultSet.getInt("length");
                int popularity = resultSet.getInt("popularity");
                writer.println("<tr" + (rowNumber % 2 == 0 ? " class=\"even\"" : "") + ">");
                writer.println("<td>" + name + "</td>");
                writer.println("<td>" + artist + "</td>");
                writer.println("<td>" + releaseDate + "</td>");
                writer.println("<td>" + length + "</td>");
                writer.println("<td>" + popularity + "</td>");
                writer.println("</tr>");
                rowNumber++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        writer.println("</tbody>");
        writer.println("</table>");
        writer.println("</div>");
        writer.println("<br>");
        writer.println("<a href=\"MainUsers\" class=\"button primary\">Back to Main Menu</a>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
        writer.flush();
    }

    public static void showFilteredRecord(HttpServletResponse resp, String searchName) throws IOException {
        ResultSet resultSet = null;
        DBUtil.connect();
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Music Populer Spotify</title>");
        writer.println("<style>");
        writer.println("body {");
        writer.println("  font-family: Arial, sans-serif;");
        writer.println("  background-color: #181818;");
        writer.println("  margin: 0;");
        writer.println("  padding: 0;");
        writer.println("}");

        writer.println(".container {");
        writer.println("  max-width: 960px;");
        writer.println("  margin: 0 auto;");
        writer.println("  padding: 20px;");
        writer.println("}");

        writer.println("h2 {");
        writer.println("  text-align: center;");
        writer.println("  color: #1db954;");
        writer.println("}");

        writer.println("table {");
        writer.println("  width: 100%;");
        writer.println("  border-collapse: collapse;");
        writer.println("  margin-top: 20px;");
        writer.println("}");

        writer.println("th, td {");
        writer.println("  padding: 10px;");
        writer.println("  text-align: left;");
        writer.println("  border-bottom: 1px solid #282828;");
        writer.println("}");

        writer.println("th {");
        writer.println("  background-color: #282828;");
        writer.println("  color: white;");
        writer.println("}");

        writer.println("tr.even {");
        writer.println("  background-color: #121212;");
        writer.println("}");

        writer.println("input[type='text'] {");
        writer.println("  padding: 8px;");
        writer.println("  border: 1px solid #282828;");
        writer.println("  border-radius: 4px;");
        writer.println("  color: #fff;");
        writer.println("  background-color: #121212;");
        writer.println("}");

        writer.println("input[type='submit'] {");
        writer.println("  padding: 8px 16px;");
        writer.println("  background-color: #1db954;");
        writer.println("  color: white;");
        writer.println("  border: none;");
        writer.println("  border-radius: 4px;");
        writer.println("  cursor: pointer;");
        writer.println("}");

        writer.println("a.button {");
        writer.println("  padding: 8px 16px;");
        writer.println("  background-color: #1db954;");
        writer.println("  color: white;");
        writer.println("  text-decoration: none;");
        writer.println("  border-radius: 4px;");
        writer.println("}");

        writer.println("a.button.success {");
        writer.println("  background-color: #1db954;");
        writer.println("}");

        writer.println("a.button.delete {");
        writer.println("  background-color: #ff0000;");
        writer.println("}");

        writer.println("a.button.primary {");
        writer.println("  background-color: #1db954;");
        writer.println("}");

        writer.println("</style>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<div class=\"container\">");
        writer.println("<h2>Musik Populer</h2>");
        writer.println("<form action=\"showList\" method=\"GET\" style=\"text-align: right;\">");
        writer.println("<input type=\"text\" name=\"searchName\" placeholder=\"Search by name\" value=\"" + searchName + "\">");
        writer.println("<input type=\"submit\" value=\"Search\">");
        writer.println("</form>");
        writer.println("<div class=\"table-container\">");
        writer.println("<table>");
        writer.println("<thead>");
        writer.println("<tr>");
        writer.println("<th>Name</th>");
        writer.println("<th>Artist</th>");
        writer.println("<th>Release Date</th>");
        writer.println("<th>Length</th>");
        writer.println("<th>Popularity</th>");
        writer.println("</tr>");
        writer.println("</thead>");
        writer.println("<tbody>");
        try {
            resultSet = DBUtil.selectFiltered("listmusic", "name", searchName);
            int rowNumber = 0;
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String artist = resultSet.getString("artist");
                String releaseDate = resultSet.getString("release_date");
                int length = resultSet.getInt("length");
                int popularity = resultSet.getInt("popularity");
                writer.println("<tr" + (rowNumber % 2 == 0 ? " class=\"even\"" : "") + ">");
                writer.println("<td>" + name + "</td>");
                writer.println("<td>" + artist + "</td>");
                writer.println("<td>" + releaseDate + "</td>");
                writer.println("<td>" + length + "</td>");
                writer.println("<td>" + popularity + "</td>");
                writer.println("</tr>");
                rowNumber++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        writer.println("</tbody>");
        writer.println("</table>");
        writer.println("</div>");
        writer.println("<br>");
        writer.println("<a href=\"MainUsers\" class=\"button primary\">Back to Main Menu</a>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
        writer.flush();
    }
}
