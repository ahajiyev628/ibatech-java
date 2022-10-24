package tinderProject.Servlets;

import TinderProject.Database.ConnectionDB;
import TinderProject.Objects.User;
import tinderProject.DAO.MessagesDAO;
import tinderProject.Objects.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static tinderProject.Database.ConnectionDB.conn;

public class ChatServlet extends HttpServlet {
    MessagesDAO md = new MessagesDAO(conn);
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String fileName = getClass().getClassLoader().getResource("chat.html").getFile();

        List<String> lines = Files.readAllLines(Path.of(fileName));
        try (PrintWriter w = rs.getWriter()){
            for (String line: lines) {
                w.println(line);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String receiver = rq.getParameter("message");
        String msg = rq.getParameter("msg");
        String send = rq.getParameter("send");
        if(send.equals("sent")) {
            md.put(new Message("",receiver,msg));
        }
        ArrayList<Message> messages = md.getAll();
    }
}
