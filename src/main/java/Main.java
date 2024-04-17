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

    private static void Taskqueue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the task queue: ");
        int size = scanner.nextInt();
        scanner.nextLine();
        taskQueue = new BoundedPriorityQueueSet(size);
    }

    private static void printMenu() {
        System.out.println("\nTask Manager Menu:");
        System.out.println("1. Add a new Task");
        System.out.println("2. View the next Task");
        System.out.println("3. Mark the next Task as done");
        System.out.println("4. View the number of Tasks remaining");
        System.out.println("5. View the space remaining in the queue");
        System.out.println("6. Exit the program");
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter owner's name: ");
        String owner = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        LocalDate deadline = LocalDate.now();
        Task task = new Task(owner, description, deadline);
        try {
            taskQueue.add(task);
            System.out.println("Task added successfully.");
        } catch (DuplicateElementException e) {
            System.out.println("Task already exists in the queue.");
        } catch (IllegalStateException e) {
            System.out.println("Queue is full. Task cannot be added.");
        }
    }




}



