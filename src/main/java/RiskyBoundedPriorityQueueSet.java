import java.util.LinkedList;

public class RiskyBoundedPriorityQueueSet extends BoundedPriorityQueueSet {

    public RiskyBoundedPriorityQueueSet() {
        super();
    }

    public RiskyBoundedPriorityQueueSet(int boundedSize) {
        super(boundedSize);
    }

    /**
     * Adds a new task to the queue without considering priority or duplicate checking.
     * @param newTask The task to be added.
     * @throws IllegalStateException If the queue is full.
     */
    @Override
    public void add(Task newTask) throws DuplicateElementException {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        tasks.add(newTask);
    }
    /**
     * Offers a new task to the queue without considering priority or duplicate checking
     * @param newTask The task to be offered
     * @return Always returns true, as there is no check for queue being full
     **/
    @Override
    public boolean offer(Task newTask) {
        if (isFull()) {
            return false;
        }
        tasks.add(newTask);
        return true;
    }
}
