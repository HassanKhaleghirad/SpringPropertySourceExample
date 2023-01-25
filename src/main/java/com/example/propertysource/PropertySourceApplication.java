package com.example.propertysource;

import com.example.propertysource.config.DBConnection;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class PropertySourceApplication {

    public static void main(String[] args)
       throws SQLException {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
            context.scan("com.example.propertysource");
            context.refresh();

            DBConnection dbConnection = context.getBean(DBConnection.class);

            Connection con = dbConnection.getConnection();

            System.out.println(con.getMetaData().getDatabaseProductName());
            System.out.println(con.getMetaData().getDatabaseProductVersion());

            // close the spring context
            context.close();
        }


}
