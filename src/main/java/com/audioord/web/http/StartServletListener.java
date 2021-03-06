package com.audioord.web.http;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Class describes ServletContextListener, the execution of which parses system config file to connect to database
 * implementation of {@link ServletContextListener}
 */
public class StartServletListener implements ServletContextListener {
  private static final String CONFIG = "config.properties";
  private static final Logger LOG = Logger.getLogger(StartServletListener.class);

  private static boolean isInitialized = false;

  /**
   * There is parsing configuration properties
   * It' s load, put config to {@link Properties} object and set them as props for servlet
   *
   * @param servletContextEvent {@link ServletContextListener}
   */
  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    if (isInitialized) {
      return;
    }

    // load config properties to System properties on system start.
    try (InputStream is = getConfigUrl().openStream()) {
      Properties p = new Properties();
      p.load(is);
      p.putAll(System.getProperties());
      System.setProperties(p);
    } catch (Exception e) {
      LOG.error(e);
    }

    isInitialized = true;
    LOG.info("System started successfully");
  }

  private URL getConfigUrl() {
    return getClass().getClassLoader().getResource(CONFIG);
  }

  /**
   * @param servletContextEvent {@link ServletContextEvent}
   */
  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
  }
}
