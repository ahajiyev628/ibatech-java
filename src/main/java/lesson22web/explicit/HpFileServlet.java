package lesson22web.explicit;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HpFileServlet extends HttpServlet {

// http://localhost:8080/hp.jpg
  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    String fileName = getClass().getClassLoader().getResource("a/hp.jpg").getFile();

    try (ServletOutputStream os = rs.getOutputStream()) {
      Files.copy(Path.of(fileName), os);
    }
  }

}
