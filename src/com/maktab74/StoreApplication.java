package com.maktab74;

import com.maktab74.domain.*;
import com.maktab74.util.ApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

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
                if (selectedNumber == 1 || selectedNumber == 2) {
                    isSelectedNumberInValid = false;
                    redirectUser(selectedNumber, context);
                } else if (selectedNumber == 3) {
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
            throws SQLException {
        if (selectedNumber == 1) {
            boolean isLoginSuccess = login(context);
            if (isLoginSuccess) {
                redirectUserToPanel(context);
            }
        } else if (selectedNumber == 2) {
            signUp(context);
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

    private static void signUp(ApplicationContext context) throws SQLException {
        boolean flag = false;
        User user = new User();
        context.getMenu().showFillInformationMessage();
        do {
            context.getMenu().showEnterUsernameMessage();
            user.setUsername(context.getStringScanner().nextLine());
            flag = checkUsername(context, user.getUsername());

            context.getMenu().showEnterPasswordMessage();
            user.setPassword(context.getStringScanner().nextLine());

            context.getMenu().showEnterFirstNameMessage();
            user.setFirstName(context.getStringScanner().nextLine());

            context.getMenu().showEnterLastNameMessage();
            user.setLastName(context.getStringScanner().nextLine());

            context.getMenu().showEnterPhoneNumberMessage();
            user.setPhoneNumber(context.getStringScanner().nextLine());

            context.getMenu().showEnterEmailMessage();
            user.setEmail(context.getStringScanner().nextLine());

            context.getMenu().showEnterProvinceMessage();
            user.setProvince(context.getStringScanner().nextLine());

            context.getMenu().showEnterCityMessage();
            user.setCity(context.getStringScanner().nextLine());

            context.getMenu().showEnterStreetMessage();
            user.setStreet(context.getStringScanner().nextLine());

            context.getMenu().showEnterPostalCodeMessage();
            user.setPostalCode(context.getStringScanner().nextLine());

        } while (flag);

        user = context.getUserRepository().insert(user);

        System.out.println(user);
    }

    private static boolean checkUsername(ApplicationContext context, String username) throws SQLException {
        boolean flag = false;
        if (checkForDuplicateUsername(context, username)) {
            context.getMenu().showTakenUsernameMessage();
            flag = true;
        }
        return flag;
    }

    private static void redirectUserToPanel(ApplicationContext context) throws SQLException {
        context.getMenu().showUserPanelMenu();
        boolean isSelectedNumberInValid = true;
        while (isSelectedNumberInValid) {
            int selectedNumber = context.getNumberScanner().nextInt();
            if (selectedNumber == 1 || selectedNumber == 2 || selectedNumber == 3 || selectedNumber == 4 || selectedNumber == 5) {
                showUserSelectedPage(selectedNumber, context);
                context.getMenu().showUserPanelMenu();
            } else if (selectedNumber == 6) {
                isSelectedNumberInValid = false;
                context.getMenu().showLogoutMessage();
                context.getSecurityContext().logout();
            } else {
                context.getMenu().showIncorrectNumberMessage();
                context.getMenu().showUserPanelMenu();
            }
        }
    }

    private static boolean checkForDuplicateUsername(ApplicationContext context, String username) throws SQLException {
        if (context.getUserRepository().getUserByUsername(username) == 1) {
            return true;
        }
        return false;
    }


    private static void showUserSelectedPage(int selectedNumber, ApplicationContext context) throws SQLException {
        if (selectedNumber == 1) {
            redirectUserToPanelProducts(context);
        } else if (selectedNumber == 2) {
            redirectUserToPanelProducts(context);


        } else if (selectedNumber == 3) {

        } else if (selectedNumber == 4) {

        } else if (selectedNumber == 5) {

        }
    }

    private static void selectedProductId(ApplicationContext context) throws SQLException {
        ArrayList<Shoes> allShoes = context.getShoesRepository().getAllShoes();

    }

    private static void redirectUserToPanelProducts(ApplicationContext context) throws SQLException {
        context.getMenu().showAllProductPanelMenu();
        boolean isSelectedNumberInValid = true;
        while (isSelectedNumberInValid) {
            int selectedNumber = context.getNumberScanner().nextInt();
            if (selectedNumber == 1 || selectedNumber == 2 || selectedNumber == 3 || selectedNumber == 4) {
                showUserSelectedProduct(selectedNumber, context);
                context.getMenu().showAllProductPanelMenu();
            } else {
                context.getMenu().showIncorrectNumberMessage();
                context.getMenu().showAllProductPanelMenu();
            }
        }
    }

    private static void showUserSelectedProduct(int selectedNumber, ApplicationContext context) throws SQLException {
        if (selectedNumber == 1) {
            showAllTVs(context);
        } else if (selectedNumber == 2) {
            showAllRadios(context);
        } else if (selectedNumber == 3) {
            showAllReadableItems(context);
        } else if (selectedNumber == 4) {
            showAllShoes(context);
        } else {
            context.getMenu().showIncorrectNumberMessage();
        }
    }

    private static void showAllRadios(ApplicationContext context) throws SQLException {
        ArrayList<Radio> allRadio = context.getRadioRepository().getAllRadio();
        if (allRadio == null) {
            context.getMenu().showEmptyRadioMessage();
        } else {
            for (int i = 0; i < allRadio.size(); i++) {
                System.out.println(allRadio.get(i));
            }
        }
    }

    private static void showAllReadableItems(ApplicationContext context) throws SQLException {
        ArrayList<ReadableItems> allReadableItems = context.getReadableItemsRepository().getAllReadableItems();
        if (allReadableItems == null) {
            context.getMenu().showEmptyReadableItemsMessage();
        } else {
            for (int i = 0; i < allReadableItems.size(); i++) {
                System.out.println(allReadableItems.get(i));
            }
        }
    }

    private static void showAllShoes(ApplicationContext context) throws SQLException {
        ArrayList<Shoes> allShoes = context.getShoesRepository().getAllShoes();
        if (allShoes == null) {
            context.getMenu().showEmptyShoesMessage();
        } else {
            for (int i = 0; i < allShoes.size(); i++) {
                System.out.println(allShoes.get(i));
            }
        }
    }

    private static void showAllTVs(ApplicationContext context) throws SQLException {
        ArrayList<Tv> allTv = context.getTvRepository().getAllTv();
        if (allTv == null) {
            context.getMenu().showEmptyTvMessage();
        } else {
            for (int i = 0; i < allTv.size(); i++) {
                System.out.println(allTv.get(i));
            }
        }
    }


}
