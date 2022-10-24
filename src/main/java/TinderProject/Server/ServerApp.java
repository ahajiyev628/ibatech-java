package TinderProject.Server;

import TinderProject.Servlets.PeopleListTest;
import TinderProject.Servlets.ChatServlet;
import TinderProject.Servlets.LikePageServlet;
import TinderProject.Servlets.LoginServlet;
import TinderProject.ShowTextFile;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new ChatServlet()), "/chat");
        handler.addServlet(new ServletHolder(new LikePageServlet()), "/likepage");
        handler.addServlet(new ServletHolder(new LoginServlet()), "/login");
        //handler.addServlet(new ServletHolder(new PeopleListServlet()), "/peoplelist");

        handler.addServlet(new ServletHolder(new ShowTextFile()), "/showtext");
        handler.addServlet(new ServletHolder(new PeopleListTest()), "/peoplelistt");
        handler.addServlet(new ServletHolder(new ShowTextFile()), "/users");


        server.setHandler(handler);
        server.start();
        server.join();
    }
}