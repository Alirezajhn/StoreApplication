package com.maktab74.util;

import com.maktab74.domain.User;

public class Menu {
    public void showWelcomeMenu() {
        System.out.println("Welcome to StoreApplication ");
        System.out.println("1: login");
        System.out.println("2: signUp");
        System.out.println("3: exit");
        System.out.print("plz choose a number: ");

    }
    //User
    public void showFillInformationMessage() {
        System.out.println("plz fill your information");
    }

    public void showEnterUsernameMessage() {
        System.out.println("plz enter your username: ");
    }

    public void showEnterPasswordMessage() {
        System.out.println("plz enter your password: ");
    }

    public void showLoginSuccessMessage(User currentUser) {
        System.out.println("login successfully done");
        //System.out.println(
               // "welcome , your national code :" + currentUser.getNationalCode());

    }

    public void showLoginFailMessage() {
        System.out.println("username or password is incorrect");
    }

    public void showExitMessage() {
        System.out.println("Bye!!! have nice time");
    }

    public void showUserPanelMenu() {
        System.out.println("1: show my profile");
        System.out.println("2: show my articles");
        System.out.println("3: add article");
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
       // System.out.println("national code: " + currentUser.getNationalCode());
       // System.out.println("birth date: " + currentUser.getBirthDate());
    }

}
