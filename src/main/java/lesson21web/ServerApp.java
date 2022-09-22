package lesson21web;

import lesson16.dao.DaoPizzaInMemory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * https://mvnrepository.com
 */
public class ServerApp {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);

    Counter counter = new Counter();
    DaoPizzaInMemory daoPizzaInMemory = new DaoPizzaInMemory();

    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(new ServletHolder(new HelloServlet(daoPizzaInMemory)), "/hello");
    handler.addServlet(HtmlFormattedServlet.class, "/html");

    CountServlet countServlet = new CountServlet(counter);
    GetCounterServlet getCounterServlet = new GetCounterServlet(counter);

    handler.addServlet(new ServletHolder(countServlet), "/count");
    handler.addServlet(new ServletHolder(getCounterServlet), "/get");

    server.setHandler(handler);
    server.start();
    server.join();
  }
}
