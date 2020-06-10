package FlightControl.ui;

import FlightControl.logic.FlightControl;
import java.util.Scanner;

public class ConsoleUI {
  private final FlightControl fc;
  private final Scanner sc;

  public ConsoleUI(FlightControl fc, Scanner sc) {
    this.fc = fc;
    this.sc = sc;
  }

  public void start() {
    this.startAssetControlLoop();
    this.startFlightControlLoop();
  }

  private void startAssetControlLoop() {
    System.out.println("Airport Asset Control");
    System.out.println("--------------------");
    System.out.println();

    while (true) {
      System.out.println("Choose an action:");
      System.out.println("[1] Add an airplane");
      System.out.println("[2] Add a flight");
      System.out.println("[x] Exit Airport Asset Control");

      System.out.print("> ");
      String command = sc.nextLine();

      if ("x".equalsIgnoreCase(command)) {
        break;
      }

      switch (command) {
        case "1":
          this.menuAddAirplane();
          break;
        case "2":
          this.menuAddFlight();
          break;
        default:
          System.out.println("Unknown command! Try again!");
      }
    }

    System.out.println();
  }

  private void menuAddFlight() {
    System.out.print("Give the airplane id: ");
    String planeId = sc.nextLine();
    System.out.print("Give the departure airport id: ");
    String portDepId = sc.nextLine();
    System.out.print("Give the target airport id: ");
    String portTarId = sc.nextLine();
    fc.addFlight(planeId, portDepId, portTarId);
  }

  private void menuAddAirplane() {
    System.out.print("Give the airplane id: ");
    String planeId = sc.nextLine();
    System.out.print("Give the airplane capacity: ");
    int planeCapacity = Integer.parseInt(sc.nextLine());
    fc.addAirplane(planeId, planeCapacity);
  }

  private void startFlightControlLoop() {
    System.out.println("Flight Control");
    System.out.println("------------");
    System.out.println();

    while (true) {
      System.out.println("Choose an action:");
      System.out.println("[1] Print airplanes");
      System.out.println("[2] Print flights");
      System.out.println("[3] Print airplane details");
      System.out.println("[x] Quit");

      System.out.print("> ");
      String command = sc.nextLine();

      if ("x".equalsIgnoreCase(command)) {
        break;
      }

      switch (command) {
        case "1":
          fc.getListOfAirplanes().forEach(System.out::println);
          break;
        case "2":
          fc.getListOfFlights().forEach(System.out::println);
          break;
        case "3":
          System.out.print("Give the airplane id: ");
          String planeId = sc.nextLine();
          System.out.println(fc.findPlaneById(planeId));
          break;
        default:
          System.out.println("Unknown command! Try again!");
      }
    }

    System.out.println();
  }
}
