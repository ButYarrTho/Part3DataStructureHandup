    import java.util.LinkedList;
    import java.util.NoSuchElementException;

    public class BoundedPriorityQueueSet {

        final LinkedList<Task> tasks;
        private final int boundedSize;

        public BoundedPriorityQueueSet() {
            this(10);
        }


        public BoundedPriorityQueueSet(int boundedSize) {
            this.tasks = new LinkedList<>();
            this.boundedSize = boundedSize;
        }

        public int size() {
            return tasks.size();
        }

        public boolean isEmpty() {
            return tasks.isEmpty();
        }

        public boolean isFull() {
            return tasks.size() >= boundedSize;
        }

        private int calcPosition(Task task) throws DuplicateElementException {
            for (int i = 0; i < tasks.size(); i++) {
                Task currentTask = tasks.get(i);

                int comparison = task.getDeadline().compareTo(currentTask.getDeadline());
                if (comparison == 0) {

                    throw new DuplicateElementException("Task already exists in the queue");
                } else if (comparison < 0) {

                    return i;
                }
            }

            return tasks.size();
        }

        public void add(Task newTask) throws DuplicateElementException {
            if (isFull()) {
                throw new IllegalStateException("Queue is full");
            }
            int position = calcPosition(newTask);
            if (tasks.contains(newTask)) {
                throw new DuplicateElementException("Task already exists in the queue");
            }
            tasks.add(position, newTask);
        }

        public boolean offer(Task newTask) throws DuplicateElementException {
            if (isFull() || tasks.contains(newTask)) {
                return false;
            }
            int position = calcPosition(newTask);
            tasks.add(position, newTask);
            return true;
        }


        public Task element() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return tasks.getFirst();
        }

        public Task peek() {
            if (isEmpty()) {
                return null;
            }
            return tasks.getFirst();
        }

        public Task remove() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return tasks.removeFirst();
        }

        public Task poll() {
            if (isEmpty()) {
                return null;
            }
            return tasks.removeFirst();
        }
    }
