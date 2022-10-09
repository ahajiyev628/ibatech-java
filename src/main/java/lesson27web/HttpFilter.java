package lesson27web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface HttpFilter extends Filter {

  private boolean isHttp(ServletRequest servletRequest,
                         ServletResponse servletResponse) {
    return servletRequest instanceof HttpServletRequest
        && servletResponse instanceof HttpServletResponse;
  }

  @Override
  default void init(FilterConfig filterConfig) throws ServletException {}

  void doHttpFilter(HttpServletRequest rq,
                       HttpServletResponse rs,
                       FilterChain filterChain) throws IOException, ServletException;

  @Override
  default void doFilter(ServletRequest servletRequest,
                       ServletResponse servletResponse,
                       FilterChain filterChain) throws IOException, ServletException {
    // check whether  HTTP
    if (isHttp(servletRequest, servletResponse)) {
      HttpServletRequest rq = (HttpServletRequest) servletRequest;
      HttpServletResponse rs = (HttpServletResponse) servletResponse;
      // our logic for happy path
      doHttpFilter(rq, rs, filterChain);
    }
    // not HTTP,just forward.
    else filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  default void destroy() {}
}
