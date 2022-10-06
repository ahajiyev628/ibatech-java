package lesson26web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class LogoutServlet extends HttpServlet {

  private final History history;

  public LogoutServlet(History history) {
    this.history = history;
  }

  // http://localhost:8080/logout

  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {

    Optional<Cookie> found = SessionRelated.find(rq);

    found.ifPresent(cookie -> {
      cookie.setMaxAge(0);
      rs.addCookie(cookie);
      history.delete(cookie.getValue());
    });

    try (PrintWriter w = rs.getWriter()){
      String message = found
          .map(Cookie::getValue)
          .map(x -> String.format("user %s successfully logged out", x))
          .orElse("there was no logged user");

      w.println(message);
    }

  }

}
