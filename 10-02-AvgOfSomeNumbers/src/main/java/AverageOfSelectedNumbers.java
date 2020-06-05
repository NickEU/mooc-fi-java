import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.IntPredicate;

public class AverageOfSelectedNumbers {
  private static ArrayList<Integer> userStrings;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    userStrings = new ArrayList<>();
    System.out.println("Input numbers, type \"end\" to stop.");

    while (true) {
      String userInput = sc.nextLine();
      if ("end".equals(userInput)) {
        break;
      }

      Integer userNumber = tryParse(userInput);
      if (userNumber != null) {
        userStrings.add(userNumber);
      }
    }

    System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
    String userChoice = sc.nextLine();
    printAverage(userChoice.equals("n"));
  }

  private static void printAverage(boolean printNegatives) {
    // used isNegative.negate() for when printNegatives == false
    // first until I realised that it screws this up and starts to include zeroes
    // so settled on having two predicate variables
    IntPredicate isNegative = x -> x < 0;
    IntPredicate isPositive = x -> x > 0;
    IntPredicate filterCondition = printNegatives ? isNegative : isPositive;

    OptionalDouble avgOpt = userStrings.stream().mapToInt(n -> n).filter(filterCondition).average();
    AtomicReference<Double> avg = new AtomicReference<>((double) 0);
    // sanity check
    avgOpt.ifPresent(avg::set);

    String numberType = printNegatives ? "negative" : "positive";
    System.out.printf("average of the %s numbers: %.2f", numberType, avg.get());
  }

  public static Integer tryParse(String text) {
    try {
      return Integer.parseInt(text);
    } catch (NumberFormatException e) {
      return null;
    }
  }
}