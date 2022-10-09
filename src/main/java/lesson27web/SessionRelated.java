package lesson27web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

/**
 * Integer.toString
 *
 * we focus on happy path
 * ----------------------
 * s.toInt        : String => Int           - can fail, because not all the Strings can be numbers
 * s.toIntOpt     : String => Optional<Int> - never fail due to Option: Optional.of or Optional.empty
 *
 * we don't focus on happy path
 * ----------------------------
 * s.toInt        : String => Optional<Int> - never fail due to Option: Optional.of or Optional.empty
 * s.toIntOrDie,
 * s.toIntOrThrow : String => Int           - can fail, because not all the Strings can be numbers
 *
 */
public class SessionRelated {

  private static String COOKIE_NAME = "user_id";

  public static Optional<Cookie> find(HttpServletRequest rq) {
    // WILL GIVE YOU NULL instead of EMPTY array.
    Cookie[] cookies = rq.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals(COOKIE_NAME)) {
          return Optional.of(cookie);
        }
      }
    }
    return Optional.empty();
  }

  public static Cookie findOrThrow(HttpServletRequest rq) {
    return find(rq)
//        .orElseGet(() -> { throw new RuntimeException("Will never happen due to design"); });
        .orElseThrow(() -> new RuntimeException("Will never happen due to design"));
  }

  public static Cookie newRandom() {
    return new Cookie(COOKIE_NAME, UUID.randomUUID().toString());
  }

}
