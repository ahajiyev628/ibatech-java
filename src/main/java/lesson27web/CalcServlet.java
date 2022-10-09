package lesson27web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalcServlet extends HttpServlet {

  private final History history;

  public CalcServlet(History history) {
    this.history = history;
  }

  // http://localhost:8080/calc?x=5&y=7
  // http://localhost:8080/calc?x=5&y=8
  // http://localhost:8080/calc?x=5&y=9

  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    String user = SessionRelated.findOrThrow(rq).getValue();

    try (PrintWriter w = rs.getWriter()){
      w.printf("user id = %s\n", user);
      String xs = rq.getParameter("x");  // non-convertable string / absence (null)
      String ys = rq.getParameter("y");
      int x = Integer.parseInt(xs);
      int y = Integer.parseInt(ys);
      int z = x + y;
      history.save(user, new HistoryItem(x, y, z));
      w.printf("adding... %d + %d = %d", x, y, z);
    }

  }

}
