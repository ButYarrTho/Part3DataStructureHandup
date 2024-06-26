    import java.util.LinkedList;
    import java.util.NoSuchElementException;

    public class BoundedPriorityQueueSet {

        final LinkedList<Task> tasks;
        private final int boundedSize;

        public BoundedPriorityQueueSet() {
            this(10);
        }

        /**
         * Constructs a bounded priority queue set with the specified size
         * @param boundedSize The maximum size of the queue
         */
        public BoundedPriorityQueueSet(int boundedSize) {
            this.tasks = new LinkedList<>();
            this.boundedSize = boundedSize;
        }

        public int size() {
            return tasks.size();
        }

        /**
         * Checks if the queue is empty
         * @return True if the queue is empty, false otherwise
         */
        public boolean isEmpty() {
            return tasks.isEmpty();
        }

        /**
         * Checks if the queue is full
         * @return True if the queue is full, false otherwise
         */
        public boolean isFull() {
            return tasks.size() >= boundedSize;
        }

        /**
         * Calculates the position to insert a new task in the queue based on its deadline.
         * If a task with the same deadline already exists, it throws a DuplicateElementException.
         *
         * @param task The task to be inserted into the queue
        */

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

        /**
         * Adds a new task to the queue
         * @param newTask The task to be added
         * @throws DuplicateElementException If the task already exists in the queue
         * @throws IllegalStateException If the queue is full
         */
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

        /**
         * Offers a new task to the queue
         * @param newTask The task to be offered
         * @return True if the task was added successfully, false otherwise
         */
        public boolean offer(Task newTask) throws DuplicateElementException {
            if (isFull() || tasks.contains(newTask)) {
                return false;
            }
            int position = calcPosition(newTask);
            tasks.add(position, newTask);
            return true;
        }

        /**
         * gets but does not remove the head of the queue
         * @return The head of the queue or null if the queue is empty
         */
        public Task element() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return tasks.getFirst();
        }

        /**
         * gets but does not remove the head of the queue
         * @return The head of the queue or null if the queue is empty
         */
        public Task peek() {
            if (isEmpty()) {
                return null;
            }
            return tasks.getFirst();
        }
        /**
         * gets and removes the head of the queue
         * @return The head of the queue or null if the queue is empty
         */
        public Task remove() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return tasks.removeFirst();
        }

        /**
         * gets and removes the head of the queue
         * @return The head of the queue or null if the queue is empty
         */
        public Task poll() {
            if (isEmpty()) {
                return null;
            }
            return tasks.removeFirst();
        }
    }
