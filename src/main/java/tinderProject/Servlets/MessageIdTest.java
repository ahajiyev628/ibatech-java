//package tinderProject.Servlets;
//
//import TinderProject.Database.ConnectionDB;
//import TinderProject.Objects.User;
//import freemarker.template.Configuration;
//import freemarker.template.TemplateException;
//import lombok.SneakyThrows;
//import tinderProject.DAO.LikesDAO;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.UUID;
//
//import static tinderProject.Database.ConnectionDB.conn;
//
//public class MessageIdTest extends HttpServlet {
//    @SneakyThrows
//    @Override
//    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
//        String fileName = getClass().getClassLoader().getResource("tinderProject/chat.html").getFile();
//
//        List<String> lines = Files.readAllLines(Path.of(fileName));
//        try (PrintWriter w = rs.getWriter()) {
//            for (String line : lines) {
//                w.println(line);
//            }
//        }
//    }
//    @SneakyThrows
//    @Override
//    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
//        String email = rq.getParameter("email");
//        String password = rq.getParameter("password");
//        String img = rq.getParameter("img");
//
//        // check if the user exists
//        // in case if the user exists, use the data from database. Otherwise, add new user data to database
//        try {
//            PreparedStatement stmt = ConnectionDB.conn.prepareStatement("select * from abb_tech.users where username=? and password=?");
//            stmt.setString(1, email);
//            stmt.setString(2, password);
//            ResultSet resultSet = stmt.executeQuery();
//            if (!resultSet.next()) {
//                User u = new User(UUID.randomUUID().toString(), email, password, img);
//                ud.put(u);
//                rs.sendRedirect("/peoplelistt");
//            } else {
//                rs.sendRedirect("/peoplelistt");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
