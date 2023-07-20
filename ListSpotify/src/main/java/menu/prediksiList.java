package menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/prediksiList"})
public class prediksiList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        // Tambahkan CSS untuk mengatur tampilan
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Prediksi Musik</title>");
        writer.println("<style>");
        writer.println("body {");
        writer.println("    font-family: Arial, sans-serif;");
        writer.println("    background-color: #1DB954;");
        writer.println("    padding: 20px;");
        writer.println("}");

        writer.println("h2 {");
        writer.println("    color: #FFF;");
        writer.println("    text-align: center;");
        writer.println("}");

        writer.println("form {");
        writer.println("    max-width: 400px;");
        writer.println("    margin: 0 auto;");
        writer.println("    background-color: #FFF;");
        writer.println("    padding: 20px;");
        writer.println("    border-radius: 5px;");
        writer.println("}");

        writer.println("label {");
        writer.println("    display: block;");
        writer.println("    margin-bottom: 10px;");
        writer.println("    color: #000;");
        writer.println("}");

        writer.println("input[type=text] {");
        writer.println("    width: 100%;");
        writer.println("    padding: 10px;");
        writer.println("    margin-bottom: 10px;");
        writer.println("    border: 1px solid #CCC;");
        writer.println("    border-radius: 5px;");
        writer.println("}");

        writer.println("input[type=submit] {");
        writer.println("    background-color: #1DB954;");
        writer.println("    color: #FFF;");
        writer.println("    padding: 10px 20px;");
        writer.println("    border: none;");
        writer.println("    border-radius: 5px;");
        writer.println("    cursor: pointer;");
        writer.println("}");

        writer.println("</style>");
        writer.println("</head>");

        writer.println("<body>");
        writer.println("<h2>Prediksi Musik</h2>");
        writer.println("<form action=\"prediksiList\" method=\"post\">");
        writer.println("<label for=\"name\">Nama Lagu:</label>");
        writer.println("<input type=\"text\" id=\"name\" name=\"name\" required>");
        writer.println("<label for=\"artist\">Nama Artis:</label>");
        writer.println("<input type=\"text\" id=\"artist\" name=\"artist\" required>");
        writer.println("<label for=\"release_date\">Tanggal Rilis:</label>");
        writer.println("<input type=\"text\" id=\"release_date\" name=\"release_date\" required>");
        writer.println("<label for=\"duration_minutes\">Durasi Lagu (menit):</label>");
        writer.println("<input type=\"text\" id=\"duration_minutes\" name=\"duration_minutes\" required>");
        writer.println("<label for=\"popularity\">Tingkat Popularitas (0-100):</label>");
        writer.println("<input type=\"text\" id=\"popularity\" name=\"popularity\" required>");
        writer.println("<input type=\"submit\" value=\"Predict Musik\">");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Hasil Prediksi Musik</title>");
        writer.println("<style>");
        writer.println("body {");
        writer.println("    font-family: Arial, sans-serif;");
        writer.println("    background-color: #1DB954;");
        writer.println("    padding: 20px;");
        writer.println("}");

        writer.println("h2 {");
        writer.println("    color: #FFF;");
        writer.println("    text-align: center;");
        writer.println("}");

        writer.println("h4 {");
        writer.println("    color: #FFF;");
        writer.println("    text-align: center;");
        writer.println("}");

        writer.println("a {");
        writer.println("    color: #FFF;");
        writer.println("    display: block;");
        writer.println("    text-align: center;");
        writer.println("    margin-top: 20px;");
        writer.println("    text-decoration: none;");
        writer.println("}");

        writer.println("</style>");
        writer.println("</head>");

        writer.println("<body>");
        writer.println("<h2>Hasil Prediksi Musik</h2>");

        // Ambil parameter dari input pengguna
        String name = req.getParameter("name");
        String artist = req.getParameter("artist");
        String releaseDate = req.getParameter("release_date");
        float durationMinutes = Float.parseFloat(req.getParameter("duration_minutes"));
        int popularity = Integer.parseInt(req.getParameter("popularity"));

        // Konversi durasi dari menit ke detik
        float durationSeconds = durationMinutes * 60;

        // Eksekusi file Python
        String pythonScriptPath = "C:/semester 6/phyton/dataset/predictmusic.py";
        ProcessBuilder processBuilder = new ProcessBuilder(
                "python",
                pythonScriptPath,
                name,
                artist,
                releaseDate,
                Float.toString(durationSeconds),
                Integer.toString(popularity)
        );
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        // Menampilkan hasil eksekusi
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            writer.println("<h4>Musik = " + line + "</h4>");
            System.out.println(line);
        }

        writer.println("<a href=\"Main\">Kembali ke Menu Utama</a>");
        writer.println("</body>");
        writer.println("</html>");
        writer.flush();
    }
}
