import java.time.LocalDate;
import java.util.Objects;

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
    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    //TODO; check if right

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(Owner, task.Owner) && Objects.equals(Description, task.Description) && Objects.equals(deadline, task.deadline);
    }

        //TODO; check if right
    @Override
    public int hashCode() {
        return Objects.hash(Owner, Description, deadline);
    }


    @Override
    public String toString() {
        return "Task{" +
                "Owner='" + Owner + '\'' +
                ", Description='" + Description + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
