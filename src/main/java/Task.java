import java.time.LocalDate;
import java.util.Objects;

public class Task {
        private String Owner;
        private String  Description;
        private LocalDate deadline = LocalDate.of(2024, 4, 16);

    /**
     * Constructs a Task object with the specified owner, description, and deadline
     * @param owner The owner of the task
     * @param description The description of the task
     * @param deadline The deadline of the task
     */
    public Task(String owner, String description, LocalDate deadline) {
        Owner = owner;
        Description = description;
        this.deadline = deadline;

        if (deadline.equals(LocalDate.now()))
        {
            System.out.println("Ur past the deadline");
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


    /**
     * Checks if two tasks are equal.
     * @param o The object to compare.
     * @return True if the tasks are equal, false otherwise.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(Owner, task.Owner) && Objects.equals(Description, task.Description) && Objects.equals(deadline, task.deadline);
    }
    /**
     * Generates a hash code for the task
     * @return The hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(Owner, Description, deadline);
    }

    /**
     * Returns a string representation of the task
     * @return A string representation of the task
     */
    @Override
    public String toString() {
        return "Task{" +
                "Owner='" + Owner + '\'' +
                ", Description='" + Description + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
