import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
public class Main {
    private static BoundedPriorityQueueSet taskQueue;
    private static Random random = new Random();

    public static void main(String[] args) {
        randomchoice();

        Scanner scanner = new Scanner(System.in);

    }

    private static void randomchoice() {
        int randomNumber = random.nextInt(2);
        if (randomNumber == 0) {
            System.out.println("Risky approach selected.");
            taskQueue = new RiskyBoundedPriorityQueueSet();
        } else {
            System.out.println("Safe approach selected.");
            taskQueue = new BoundedPriorityQueueSet();
        }
    }
}


