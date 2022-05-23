package com.maktab74;

import com.maktab74.domain.User;
import com.maktab74.util.ApplicationContext;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
public class StoreApplication {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       ApplicationContext context = new ApplicationContext();

        context.getDatabaseInitializer().init();

        boolean globalLoop = true;

        while (globalLoop) {
            context.getMenu().showWelcomeMenu();
            boolean isSelectedNumberInValid = true;
            while (isSelectedNumberInValid) {
                int selectedNumber = context.getNumberScanner().nextInt();
                if (selectedNumber == 1 || selectedNumber == 2 || selectedNumber == 3) {
                    isSelectedNumberInValid = false;
                    redirectUser(selectedNumber, context);
                } else if (selectedNumber == 4) {
                    isSelectedNumberInValid = false;
                    context.getMenu().showExitMessage();
                    globalLoop = false;
                } else {
                    context.getMenu().showIncorrectNumberMessage();
                }
            }
        }

    }

    private static void redirectUser(int selectedNumber, ApplicationContext context)
            throws SQLException, ParseException {
        if (selectedNumber == 1) {
            boolean isLoginSuccess = login(context);
            if (isLoginSuccess) {
                redirectUserToPanel(context);
            }
        } else if (selectedNumber == 2){
            signup(context);
        } else {

        }

    }

    private static boolean login(ApplicationContext context) throws SQLException {
        context.getMenu().showFillInformationMessage();

        context.getMenu().showEnterUsernameMessage();
        String username = context.getStringScanner().nextLine();

        context.getMenu().showEnterPasswordMessage();
        String password = context.getStringScanner().nextLine();

        User user = context.getUserRepository()
                .getByUsernameAndPassword(username, password);
        if (user != null) {
            context.getMenu().showLoginSuccessMessage(user);
            context.getSecurityContext().setCurrentUser(user);
            return true;
        } else {
            context.getMenu().showLoginFailMessage();
            return false;
        }
    }
    private static void signup(ApplicationContext context) throws SQLException, ParseException {
        boolean flag = false;
        User user = new User();
        context.getMenu().showFillInformationMessage();

        do {
            context.getMenu().showEnterUsernameMessage();
            user.setUsername(context.getStringScanner().nextLine());
            flag = checkUsername(context, user.getUsername());
        }while (flag);

        do {
            context.getMenu().showEnterNationalCodeMessage();
            user.setNationalCode(context.getStringScanner().nextLine());
            flag = checkNationalCode(context, user.getNationalCode());
        }while (flag);


        user.setPassword(user.getNationalCode());

        context.getMenu().showEnterBirthDateMessage();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(context.getStringScanner().nextLine());
        user.setBirthDate(date);

        user = context.getUserRepository().insert(user);

        System.out.println(user);
    }
    private static boolean checkUsername(ApplicationContext context, String username) throws SQLException{
        boolean find = false;
        if (username.length() < 5) {
            context.getMenu().showShortUsernameMessage();
            find = true;
        }
        else {
            if (username.charAt(0) == '_' || username.charAt(username.length()-1) == '_'){
                context.getMenu().showUnderlineErrorMessage();
                find = true;
            }
            else {
                find = checkChar(username);
                if (find)
                    context.getMenu().showNotStandardUsernameMessage();
                else {
                    find = checkForDuplicateUsername(context, username);
                    if (find)
                        context.getMenu().showTakenUsernameMessage();
                }
            }
        }
        return find;
    }
    private static void redirectUserToPanel(ApplicationContext context) throws SQLException {
        context.getMenu().showUserPanelMenu();
        boolean isSelectedNumberInValid = true;
        while (isSelectedNumberInValid) {
            int selectedNumber = context.getNumberScanner().nextInt();
            if (selectedNumber == 1 || selectedNumber == 2 || selectedNumber == 3) {
                showUserSelectedPage(selectedNumber, context);
                context.getMenu().showUserPanelMenu();
            } else if (selectedNumber == 4) {
                isSelectedNumberInValid = false;
                context.getMenu().showLogoutMessage();
                context.getSecurityContext().logout();
            } else {
                context.getMenu().showIncorrectNumberMessage();
                context.getMenu().showUserPanelMenu();
            }
        }
    }
}*/