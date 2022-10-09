package lesson27web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HistoryServlet extends HttpServlet {

  private final History history;

  private final static ObjectMapper mapper = new ObjectMapper();

  public HistoryServlet(History history) {
    this.history = history;
    mapper.registerModule(new JavaTimeModule());
  }

  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    String user = SessionRelated.findOrThrow(rq).getValue();
    boolean isJson = rq.getParameter("json") != null;

    try (PrintWriter w = rs.getWriter()){
      w.println("history:");
      List<HistoryItem> items = history.getAll(user);

      if (isJson) {
        String json = mapper.writeValueAsString(items);
        w.println(json);
      } else items.forEach(w::println);
    }
  }
}
