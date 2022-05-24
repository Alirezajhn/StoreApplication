package com.maktab74.util;

import com.maktab74.domain.User;

public class Menu {
    public void showWelcomeMenu() {
        System.out.println("Welcome to StoreApplication ");
        System.out.println("1: login");
        System.out.println("2: signUp");
        System.out.println("3: exit");
        System.out.print("please choose a number: ");

    }
    //User
    public void showFillInformationMessage() {
        System.out.println("please fill your information");
    }

    public void showEnterUsernameMessage() {
        System.out.println("please enter your username: ");
    }

    public void showEnterPasswordMessage() {
        System.out.println("please enter your password: ");
    }

    public void showLoginSuccessMessage(User currentUser) {
        System.out.println("login successfully done");
        //System.out.println(
               // "welcome , your national code :" + currentUser.getNationalCode());

    }
    public void showShortUsernameMessage() {
        System.out.println(" short username!!!");
    }

    public void showUnderlineErrorMessage() {
        System.out.println("the first and last username should not be underline!!!");
    }
    public void showChangePasswordMessage() {
        System.out.println("1: change password");
        System.out.println("2: exit");
        System.out.print("plz choose a number:");
    }
    public void showNotStandardUsernameMessage() {
        System.out.println("this is not a standard username!!!");
    }

    public void showTakenUsernameMessage() {
        System.out.println("this username already is taken!!!");
    }

    public void showLoginFailMessage() {
        System.out.println("username or password is incorrect");
    }

    public void showExitMessage() {
        System.out.println("goodbye!!! have a nice time");
    }

    public void showUserPanelMenu() {
        System.out.println("1: show all products");
        System.out.println("2: add product");
        System.out.println("3: delete product");
        System.out.println("4: logout");
        System.out.print("plz choose a number:");
    }

    public void showIncorrectNumberMessage() {
        System.out.println("plz enter right number");
    }

    public void showLogoutMessage() {
        System.out.println("logout successful");
    }

    public void showUserProfile(User currentUser) {
        System.out.println("username: " + currentUser.getUsername());
    }

}
