package TinderProject.Servlets;

import TinderProject.DAO.UsersDAO;
import TinderProject.Database.ConnectionDB;
import TinderProject.Objects.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;


import static TinderProject.Database.ConnectionDB.conn;

public class LoginServlet extends HttpServlet {
    UsersDAO ud = new UsersDAO(conn);
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String fileName = getClass().getClassLoader().getResource("login.html").getFile();

        List<String> lines = Files.readAllLines(Path.of(fileName));
        try (PrintWriter w = rs.getWriter()){
            for (String line: lines) {
                w.println(line);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String email = rq.getParameter("email");
        String password = rq.getParameter("password");
        User u = new User(UUID.randomUUID().toString(), email, password);
        ud.put(u);
        rs.sendRedirect("/peoplelist");
    }
}
