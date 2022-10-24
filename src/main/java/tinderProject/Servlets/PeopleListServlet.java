package tinderProject.Servlets;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.SneakyThrows;
import tinderProject.DAO.LikesDAO;
import tinderProject.DAO.UsersDAO;
import tinderProject.Objects.Likes;
import tinderProject.Objects.User;
import tinderProject.Service.Counter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static tinderProject.DAO.UsersDAO.likedUsers;
import static tinderProject.Database.ConnectionDB.conn;
public class PeopleListServlet extends HttpServlet {
    UsersDAO ud = new UsersDAO(conn);
    LikesDAO ld = new LikesDAO(conn);
    private final Counter c;
    public PeopleListServlet(Counter c) {
        this.c = c;
    }
    public void checkSize(Counter c, int size) {
        if (size > c.get()) {
            c.inc();
        } else {
            c.zero();
        }
    }
    ArrayList<User> users = ud.getAll();
    ArrayList<User> newUsers = new ArrayList<>();
    int userListSize = users.size();
    int indx = -1;
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        var usersCon = config("templates/TestStepProject.ftl",rs);
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        var usersCon = config("templates/TestStepProject.ftl",rs);
        int ind = indx-1;
        likedUsers.add(usersCon.get(ind));
        Likes liked = new Likes(likedUsers.get(ind).getId(), likedUsers.get(ind).getUsername(),
                "yes", likedUsers.get(ind).getImg(), "no",null);
        ld.put(liked);
    }
    private List<User> config(String fileName,HttpServletResponse rs) throws IOException {
        Configuration conf = new Configuration(Configuration.VERSION_2_3_28);
        conf.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        conf.setDirectoryForTemplateLoading(new File("src/main/java/tinderProject"));

        HashMap<String, Object> data = new HashMap<>();

        int ind = c.get();
        indx = ind;

        checkSize(c, userListSize - 1);
        try (PrintWriter w = rs.getWriter()) {
            data.put("name", users.get(ind).getUsername());
            data.put("photo", users.get(ind).getImg());
            if (ud.getCount() == newUsers.size()){
                rs.sendRedirect("http://localhost:8080/liked");
           w.println("ssss");
            }
            else {
                newUsers.add(users.get(ind));
               conf.getTemplate(fileName).process(data, w);
            }
    } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
    }
