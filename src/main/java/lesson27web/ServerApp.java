package lesson27web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.EnumSet;

public class ServerApp {

  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);

    Connection conn = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/be5",
        "postgres",
        "pg123456"
    );
    //                           ......................
//    History historyService = new HistoryServiceDatabase(conn);
    History historyService = new HistoryServiceInMemory();

    CalcServlet calcServlet = new CalcServlet(historyService);
    HistoryServlet historyServlet = new HistoryServlet(historyService);
    LogoutServlet logoutServlet = new LogoutServlet(historyService);

    ServletContextHandler handler = new ServletContextHandler();

    // servlet without filtering
    handler.addServlet(LoginServlet.class, "/login");

    EnumSet<DispatcherType> dt = EnumSet.of(DispatcherType.REQUEST);
    // attaching filtering
    handler.addFilter(CookieFilter.class, "/calc", dt);
    handler.addFilter(CookieFilter.class, "/history", dt);
    handler.addFilter(CookieFilter.class, "/logout", dt);

    handler.addServlet(new ServletHolder(calcServlet), "/calc");
    handler.addServlet(new ServletHolder(historyServlet), "/history");
    handler.addServlet(new ServletHolder(logoutServlet), "/logout");

    server.setHandler(handler);
    server.start();
    server.join();

  }

}
