package lesson21web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * https://mvnrepository.com
 */
public class ServerApp {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);

    Counter c = new Counter();

    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(HelloServlet.class, "/hello");
    handler.addServlet(HtmlFormattedServlet.class, "/html");

    CountServlet countServlet = new CountServlet(c);
    GetCounterServlet getCounterServlet = new GetCounterServlet(c);

    handler.addServlet(new ServletHolder(countServlet), "/count");
    handler.addServlet(new ServletHolder(getCounterServlet), "/get");

    server.setHandler(handler);
    server.start();
    server.join();
  }
}
