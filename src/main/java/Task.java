import java.time.LocalDate;

public class Task {
        private String Owner;
        private String  Description;
        private LocalDate deadline = LocalDate.of(2024, 4, 16);

    public Task(String owner, String description, LocalDate deadline) {
        Owner = owner;
        Description = description;
        this.deadline = deadline;

        if (deadline.equals(LocalDate.now()))
        {
            System.out.println("UR LATE U GET 0 LMAFOOOOOOOOOOOOO");
        }
    }
}



