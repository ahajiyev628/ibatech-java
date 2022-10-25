package tinderProject.Servlets;

import TinderProject.Database.ConnectionDB;
import TinderProject.Objects.User;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import tinderProject.DAO.MessagesDAO;
import tinderProject.Objects.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

import static tinderProject.Database.ConnectionDB.conn;

public class ChatServlet extends HttpServlet {
    MessagesDAO md = new MessagesDAO(conn);

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        Configuration conf = new Configuration(Configuration.VERSION_2_3_28);
        conf.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        conf.setDirectoryForTemplateLoading(new File("src/main/java/tinderProject"));

        HashMap<String, Object> data = new HashMap<>();
        String receiver = rq.getParameter("message");
//        try (PrintWriter w = rs.getWriter()) {
//            w.println(receiver);
//        }

        try {
            PreparedStatement stmt = ConnectionDB.conn.prepareStatement("select * from abb_tech.messages where receiver=?");
            stmt.setString(1, receiver);
            ResultSet result = stmt.executeQuery();
            ResultSetMetaData rsmd = result.getMetaData();
            int columnCount = rsmd.getColumnCount();

            ArrayList<Message> all_msg = new ArrayList<>(columnCount);
            while (result.next()) {
                Message m = new Message();

                m.setSender_id(result.getString("sender_id"));
                m.setReceiver(result.getString("receiver"));
                m.setMessage(result.getString("message"));

                all_msg.add(m);
            }
            data.put("data", all_msg);


            try (PrintWriter w = rs.getWriter()) {
                conf.getTemplate("templates/chat.ftl").process(data, w);
            } catch (TemplateException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        @Override
        protected void doPost (HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
            String receiver = rq.getParameter("message");
            String msg = rq.getParameter("msg");
            String send = rq.getParameter("send");
            Message ms = new Message("", receiver, msg);
            if (send.equals("sent")) {
                md.put(ms);
                rs.sendRedirect("/messages?message="+receiver);
            }
        }
    }
