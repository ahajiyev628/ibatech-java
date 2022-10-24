package tinderProject.Server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import tinderProject.Service.Counter;
import tinderProject.Servlets.LikedPeopleListTest;
import tinderProject.Servlets.ChatServlet;
import tinderProject.Servlets.LoginServlet;
import tinderProject.Servlets.PeopleListServlet;

public class ServerApp {
    //TinderProject.Server.ChatServlet();

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        Counter counter = new Counter();

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new ChatServlet()), "/chat");
        handler.addServlet(new ServletHolder(new LoginServlet()), "/login");
        handler.addServlet(new ServletHolder(new PeopleListServlet(counter)), "/peoplelistt");
        handler.addServlet(new ServletHolder(new LikedPeopleListTest()), "/liked");
        handler.addServlet(new ServletHolder(new ChatServlet()), "/messages");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}