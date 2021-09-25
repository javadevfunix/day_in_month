package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import business.TimeManagement;

public class MainProgram {
  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    startUp();
    sc.close();
  }

  private static void startUp() {
    showMenu();
    int choice = getChoice();
    handleChoice(choice);
  }
  
  private static void showMenu() {
    System.out.println("DAYS IN MONTH");
    System.out.println("Please choose one option: ");
    System.out.println("1. Get number of days in month");
    System.out.println("2. Exit");
  }
  
  private static int getChoice() {
    boolean flag = false;
    int choice = 0;

    while (flag == false) {
      System.out.println("Your option is: ");
      String input = sc.nextLine();
      flag = true;

      try {
        choice = Integer.parseInt(input);
      } catch (Exception e) {
        printInputErrorMessage();
        flag = false;
      }

      if (choice < 1 || choice > 2) {
        printInputErrorMessage();
        flag = false;
      }
    }

    return choice;
  }
  
  private static void handleChoice(int choice) {

    switch (choice) {
      case 1:
        getDaysInMonth();
        break;

      default:
        System.exit(0);
        break;
    }

    waitKeyPress();
    startUp();
  }
  
  private static void getDaysInMonth() {
    short year = getYear();
    byte month = getMonth();
    TimeManagement timeManagement = new TimeManagement();
    short numberOfDaysInMonth = timeManagement.getDaysInMonth(year, month);
    System.out.println("Number of days in month: " + numberOfDaysInMonth);
  }
  
  private static byte getMonth() {
    System.out.println("Please input value of month (from -128 to 127): ");
    byte month = 0;
    boolean flag = false;

    while (flag == false) {
      String input = sc.nextLine();
      flag = true;

      try {
        month = Byte.parseByte(input);
      } catch (Exception e) {
        printInputErrorMessage();
        flag = false;
      }
    }

    return month;
  }
  
  private static short getYear() {
    System.out.println("Please input value of year (from -32768 to 32767): ");
    short year = 0;
    boolean flag = false;

    while (flag == false) {
      String input = sc.nextLine();
      flag = true;

      try {
        year = Short.parseShort(input);
      } catch (Exception e) {
        printInputErrorMessage();
        flag = false;
      }
    }

    return year;
  }
  
  private static void printInputErrorMessage() {
    System.out.println("Invalid input! Please try again!");
  }
  
  private static boolean waitKeyPress() {

    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int key = in.read();

      if (key != -1) {
        return true;
      }
    } catch (IOException io) {
      io.printStackTrace();
    }

    return false;
  }
}
