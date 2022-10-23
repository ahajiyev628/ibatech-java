package TinderProject.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LikePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String fileName = getClass().getClassLoader().getResource("like-page.html").getFile();

        List<String> lines = Files.readAllLines(Path.of(fileName));
        try (PrintWriter w = rs.getWriter()){
            for (String line: lines) {
                w.println(line);
            }
        }
    }

}
