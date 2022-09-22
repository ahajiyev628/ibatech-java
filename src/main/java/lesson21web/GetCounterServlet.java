package lesson21web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCounterServlet extends HttpServlet {

  private final Counter c;

  public GetCounterServlet(Counter c) {
    this.c = c;
  }

  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    try (PrintWriter w = rs.getWriter()){
      w.printf("counted %d", c.get());
    }
  }
}
