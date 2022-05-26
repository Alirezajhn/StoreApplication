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
        System.out.println("Welcome" + currentUser.getFirstName() + " " + currentUser.getLastName());
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
        System.out.println("1: show all products with unit and price (list of items)");
        System.out.println("2: add product from basket");
        System.out.println("3: delete product from basket");
        System.out.println("4; print all add product to basket with unit and total price");
        System.out.println("5: final confirmation of basket");
        System.out.println("6: logout");
        System.out.print("please choose a number:");
    }

    public void showIncorrectNumberMessage() {
        System.out.println("please enter right number");
    }

    public void showLogoutMessage() {
        System.out.println("logout successful");
    }

    public void showUserProfile(User currentUser) {
        System.out.println("username: " + currentUser.getUsername());
    }

    public void showEnterFirstNameMessage() {
        System.out.println("please enter your firstName: ");
    }

    public void showEnterLastNameMessage() {
        System.out.println("please enter your lastName: ");
    }

    public void showEnterPhoneNumberMessage() {
        System.out.println("please enter your phoneNumber: ");
    }

    public void showEnterEmailMessage() {
        System.out.println("please enter your Email: ");
    }

    public void showEnterProvinceMessage() {
        System.out.println("please enter your province: ");
    }

    public void showEnterCityMessage() {
        System.out.println("please enter your city: ");
    }

    public void showEnterStreetMessage() {
        System.out.println("please enter your street: ");
    }

    public void showEnterPostalCodeMessage() {
        System.out.println("please enter your postalCode: ");
    }

    public void showEmptyTvMessage() {
        System.out.println("there is no tvs!!!");
    }

    public void showEmptyShoesMessage() {
        System.out.println("there is no shoes!!!");
    }

    public void showEmptyReadableItemsMessage() {
        System.out.println("there is no readableItems!!!");
    }

    public void showEmptyRadioMessage() {
        System.out.println("there is no radios!!!!!");
    }
}
