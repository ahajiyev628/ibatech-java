package lesson21web;

import lesson16.dao.DAO;
import lesson16.dao.Pizza;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class HelloServlet extends HttpServlet {

  private final DAO<Pizza> dp;

  public HelloServlet(DAO<Pizza> dp) {
    this.dp = dp;
  }

  /* http://localhost:8080/hello?x=5&y=7&z=3&z=13&z=15 */
  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
//    dp.load(1)
    String wholeQueryString = rq.getQueryString();
//    rq.getPart("a");
//    rq.getCookies();
//    rq.getHeader();
    Map<String, String[]> all = rq.getParameterMap();
    // x -> ['5']
    // y -> ['7']
    // z -> ['3', '13', '15']

    String xs = rq.getParameter("x");
    String ys = rq.getParameter("y");
    String zs = rq.getParameter("z"); // null !!!

    int x = Integer.parseInt(xs);
    int y = Integer.parseInt(ys);
    int z = x + y;

    try (PrintWriter w = rs.getWriter()){
      w.println(wholeQueryString);
      w.printf("all params: %s\n", all);
      w.printf("Hello, %d, %d given, the sum is %d", x, y, z);
    }
  }

  @Override
  protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    try (PrintWriter w = rs.getWriter()){
      w.println("handling POST");
      w.printf("Custom-Heqder: %s\n", rq.getHeader("Custom-Heqder"));
      w.printf("user: %s\n", rq.getParameter("user"));
      w.printf("password: %s\n", rq.getParameter("password"));
    }
  }

}
