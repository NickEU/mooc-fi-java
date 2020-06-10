package FlightControl;

import FlightControl.logic.FlightControl;
import FlightControl.ui.ConsoleUI;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    FlightControl fc = new FlightControl();
    Scanner sc = new Scanner(System.in);
    ConsoleUI ui = new ConsoleUI(fc, sc);

    ui.start();
  }
}
