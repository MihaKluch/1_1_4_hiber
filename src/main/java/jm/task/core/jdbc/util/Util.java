package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/userx";
    private static final String USER = "root";
    private static final String PASSWORD = "1234554321";

    private static SessionFactory sessionFactory;

    static {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            sessionFactory = new Configuration()
                    .setProperty("hibernate.connection.url", URL)
                    .setProperty("hibernate.connection.username", USER)
                    .setProperty("hibernate.connection.password", PASSWORD)
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .setProperty("hibernate.show_sql", "true")
                    .setProperty("hibernate.format_sql", "true")
                    .setProperty("hibernate.current_session_context_class", "thread")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Ошибка загрузки JDBC-драйвера!", e);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка инициализации Hibernate!", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к базе данных!", e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}