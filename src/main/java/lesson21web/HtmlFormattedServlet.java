package lesson21web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class HtmlFormattedServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    try (PrintWriter w = rs.getWriter()){
      w.println("<html>");
      w.println("<body>");
      w.println("<table border=\"1\">");
      w.println("    <tr>");
      w.println("        <td>iphone 14</td>");
      w.println("        <td>2000</td>");
      w.println("    </tr>");
      w.println("</table>");
      w.println("</body>");
      w.println("</html>");
    }
  }

}
