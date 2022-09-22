package lesson21web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class CountServlet extends HttpServlet {

  private final Counter c;

  public CountServlet(Counter c) {
    this.c = c;
  }

  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    c.inc();
    try (PrintWriter w = rs.getWriter()){
      w.println("counted...");
    }
  }
}
