package com.maktab74.util;

import com.maktab74.domain.Radio;
import com.maktab74.domain.ReadableItems;
import com.maktab74.repository.*;

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

    private TvRepository tvRepository = null;

    private RadioRepository radioRepository = null;

    private ShoesRepository shoesRepository = null;

    private ReadableItemsRepository readableItemsRepository = null;

    private BasketRepository basketRepository = null;


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

    public TvRepository getTvRepository() {
        if (tvRepository == null) {
            this.tvRepository = new TvRepository(databaseUtil.getConnection());
        }
        return tvRepository;
    }

    public RadioRepository getRadioRepository() {
        if (radioRepository == null) {
            this.radioRepository = new RadioRepository(databaseUtil.getConnection());
        }
        return radioRepository;
    }

    public ShoesRepository getShoesRepository() {
        if (shoesRepository == null) {
            this.shoesRepository = new ShoesRepository(databaseUtil.getConnection());
        }
        return shoesRepository;
    }

    public ReadableItemsRepository getReadableItemsRepository() {
        if (readableItemsRepository == null) {
            this.readableItemsRepository = new ReadableItemsRepository(databaseUtil.getConnection());
        }
        return readableItemsRepository;
    }

    public BasketRepository getBasketRepository() {
        if (basketRepository == null) {
            this.basketRepository = new BasketRepository(databaseUtil.getConnection());
        }
        return basketRepository;
    }
}
