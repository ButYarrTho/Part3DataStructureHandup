import java.util.LinkedList;

public class RiskyBoundedPriorityQueueSet extends BoundedPriorityQueueSet {

    public RiskyBoundedPriorityQueueSet() {
        super();
    }

    public RiskyBoundedPriorityQueueSet(int boundedSize) {
        super(boundedSize);
    }

    @Override
    public void add(Task newTask) throws DuplicateElementException {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        tasks.add(newTask);
    }

    @Override
    public boolean offer(Task newTask) {
        if (isFull()) {
            return false;
        }
        tasks.add(newTask);
        return true;
    }
}
