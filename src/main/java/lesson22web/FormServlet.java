package lesson22web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// http://localhost:8080/form
public class FormServlet extends HttpServlet {

  /** showing form */
  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    String fileName = getClass().getClassLoader().getResource("form.html").getFile();

    List<String> lines = Files.readAllLines(Path.of(fileName));
    try (PrintWriter w = rs.getWriter()){
      for (String line: lines) {
        w.println(line);
      }
    }
  }

  @Override
  protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    try (PrintWriter w = rs.getWriter()){
      String username = rq.getParameter("username");
      String password = rq.getParameter("password");
      w.printf("user entered: %s, %s", username, password);
    }
  }
}
