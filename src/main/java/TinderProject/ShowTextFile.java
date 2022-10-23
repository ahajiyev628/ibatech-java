package TinderProject;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class ShowTextFile extends HttpServlet {

// http://localhost:8080/dynamic1
  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    Configuration conf = new Configuration(Configuration.VERSION_2_3_28);
    conf.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
    conf.setDirectoryForTemplateLoading(new File("src/main/java/TinderProject"));

    HashMap<String, String> data = new HashMap<>();
    data.put("name", "Messi");
    data.put("photo", "https://images.immediate.co.uk/production/volatile/sites/3/2022/01/Best-players-world-a653a22.jpg");

    data.put("name", "Ronaldo");
    data.put("photo", "https://images.immediate.co.uk/production/volatile/sites/3/2022/01/Best-players-world-a653a22.jpg");


    try (PrintWriter w = rs.getWriter()){
      conf.getTemplate("TestStepProject.ftl").process(data, w);
    } catch (TemplateException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    try (PrintWriter w = rs.getWriter()){
      String username = rq.getParameter("yes");
      String password = rq.getParameter("no");
      w.printf("user entered: %s, %s", username, password);
    }
  }

}
