package util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//Read parameters from web.xml
//Opens connection when app is starting
//Called by Servlet
@WebListener
public class AppContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String dbUrl = servletContextEvent.getServletContext().getInitParameter("dburl");
        String schema = servletContextEvent.getServletContext().getInitParameter("schema");
        DbConnectionService.connect(dbUrl, schema);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        DbConnectionService.disconnect();
    }
}