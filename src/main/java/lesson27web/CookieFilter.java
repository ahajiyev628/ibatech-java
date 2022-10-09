package lesson27web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieFilter implements HttpFilter {

  private boolean isCookiePresent(HttpServletRequest rq) {
    return SessionRelated.find(rq).isPresent();
  }

  @Override
  public void doHttpFilter(
      HttpServletRequest rq,
      HttpServletResponse rs,
      FilterChain filterChain) throws IOException, ServletException {
    if (isCookiePresent(rq))

      // our logic for happy path
      filterChain.doFilter(rq, rs);

      // our logic for unhappy path
    else rs.sendRedirect("/login");
  }

}
