package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
////        Util.getConnection();
//        UserDao userDao = new UserDaoJDBCImpl();
//
//        userDao.createUsersTable();
//
//        userDao.saveUser("Михаил", "Ключенок", (byte) 43);
//        userDao.saveUser("Мария", "Осипович", (byte) 39);
//        userDao.saveUser("Ульяна", "Жуликовна", (byte) 12);
//        userDao.saveUser("Дарья", "Романова", (byte) 19);
//
//
////        System.out.println(userDao.getAllUsers());
////        userDao.removeUserById(1);
//        userDao.getAllUsers();
//        userDao.cleanUsersTable();
//        userDao.dropUsersTable();

//        ---------------------------------------------------------

        UserDao userDao = new UserDaoHibernateImpl();

// Удаление таблицы (если она уже есть)
        userDao.dropUsersTable();
        System.out.println("Таблица удалена");

// Создание таблицы
        userDao.createUsersTable();
        System.out.println("Таблица создана");

// Добавление пользователей
            userDao.saveUser("Михаил2", "Ключенок", (byte) 43);
       userDao.saveUser("Мария2", "Осипович", (byte) 39);
       userDao.saveUser("Ульяна2", "Жуликовна", (byte) 12);
        userDao.saveUser("Дарья2", "Романова", (byte) 19);
        System.out.println("Добавлены пользователи");

// Получение всех пользователей
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

// Удаление пользователя по id
        userDao.removeUserById(1);
        System.out.println("Удален пользователь с ID 1");

// Очистка таблицы
        userDao.cleanUsersTable();
        System.out.println("Таблица очищена");

// Удаление таблицы
        userDao.dropUsersTable();
        System.out.println("Таблица полностью удалена");

    }
}
