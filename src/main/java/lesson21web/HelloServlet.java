package lesson21web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

  /* http://localhost:8080/hello?x=5&y=7 */
  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
//    rq.getPathInfo();
//    rq.getQueryString();
//    rq.getPart("a");
//    rq.getCookies();
//    rq.getHeader();

    String xs = rq.getParameter("x");
    String ys = rq.getParameter("y");
    String zs = rq.getParameter("z"); // null !!!

    int x = Integer.parseInt(xs);
    int y = Integer.parseInt(ys);
    int z = x + y;

    try (PrintWriter w = rs.getWriter()){
      w.printf("Hello, %d, %d given, the sum is %d", x, y, z);
    }
  }

}
