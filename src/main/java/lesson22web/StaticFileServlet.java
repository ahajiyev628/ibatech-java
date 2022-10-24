/*
package lesson22web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StaticFileServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    String requestedName = rq.getPathInfo();
    if (requestedName.startsWith("/")) requestedName = requestedName.substring(1);
    String fileName = getClass().getClassLoader().getResource(requestedName).getFile();
    try (ServletOutputStream os = rs.getOutputStream()) {
      Files.copy(Path.of(fileName), os);
    }
  }

}
*/
