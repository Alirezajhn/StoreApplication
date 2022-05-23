package com.maktab74.util;

import com.maktab74.repository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ApplicationContext {
    private DatabaseUtil databaseUtil;

    private DatabaseInitializer databaseInitializer;

    private Menu menu = null;

    private Scanner stringScanner = null;

    private Scanner numberScanner = null;

    private UserRepository userRepository = null;

    private SecurityContext securityContext = new SecurityContext();


    public ApplicationContext() throws SQLException, ClassNotFoundException {
        this.databaseUtil = new DatabaseUtil();
        this.databaseInitializer = new DatabaseInitializer(
                this.databaseUtil.getConnection()
        );
    }

    public DatabaseUtil getDatabaseUtil() {
        return databaseUtil;
    }

    public DatabaseInitializer getDatabaseInitializer() {
        return databaseInitializer;
    }

    public Menu getMenu() {
        if (menu == null) {
            this.menu = new Menu();
        }
        return menu;
    }

    public Scanner getStringScanner() {
        if (stringScanner == null) {
            this.stringScanner = new Scanner(System.in);
        }
        return stringScanner;
    }

    public Scanner getNumberScanner() {
        if (numberScanner == null) {
            this.numberScanner = new Scanner(System.in);
        }
        return numberScanner;
    }

    public UserRepository getUserRepository() {
        if (userRepository == null) {
            this.userRepository = new UserRepository(databaseUtil.getConnection());
        }
        return userRepository;
    }

    public SecurityContext getSecurityContext() {
        return securityContext;
    }

}
