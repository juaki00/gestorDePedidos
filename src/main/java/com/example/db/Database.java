package com.example.db;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class Database {

            private static final Connection connection;

    static{
                InputStream is = Database.class.getClassLoader().getResourceAsStream("database.properties");
                Properties config = new Properties();
                Logger logger = Logger.getLogger(Database.class.getName());
                try {
                    config.load(is);

                } catch (IOException e) {
                    throw new RuntimeException(e);

                }
                String host = (String) config.get("host");
                String name = (String) config.get("name");
                String pass = (String) config.get("pass");
                String port = (String) config.get("port");
                String user = (String) config.get("user");
                String url = (String) config.get("url");
                String urlCompleta = url + host + ":" + port + "/" + name;
                try {
                    connection = DriverManager.getConnection(urlCompleta,user,pass);
                    logger.info("Successful connection to database");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        public Connection getConnection(){
            return connection;
        }
}
