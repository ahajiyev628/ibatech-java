package TinderProject.Servlets;

import TinderProject.DAO.UsersDAO;
import TinderProject.Objects.User;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import static TinderProject.Database.ConnectionDB.conn;

public class PeopleListTest extends HttpServlet {
    UsersDAO ud = new UsersDAO(conn);

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        Configuration conf = new Configuration(Configuration.VERSION_2_3_28);
        conf.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        conf.setDirectoryForTemplateLoading(new File("src/main/java/TinderProject"));

        HashMap<String, Object> data = new HashMap<>();
        //users.put("data", new User(UUID.randomUUID().toString(), "email", "password", "google.com"));
        ArrayList<User> users = ud.getAll();
        data.put("data",users);


        try (PrintWriter w = rs.getWriter()){
            conf.getTemplate("PeopleList.ftl").process(data, w);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
