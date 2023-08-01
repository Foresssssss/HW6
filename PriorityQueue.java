package HW6;

public class PriorityQueue {
    private int[] arr;
    private int size;

    public PriorityQueue() {
        arr = new int[10];
        size = 0;
    }

    public void add(int element) {
        if (size == arr.length) {
            resize();
        }
        int index = size;
        arr[index] = element;
        size++;
        while (index > 0 && arr[index] < arr[(index - 1) / 2]) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public int remove() {
        if (size == 0) {
            throw new IllegalStateException("Priority queue is empty");
        }
        int root = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapify(0);
        return root;
    }

    private void heapify(int index) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < size && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < size && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void resize() {
        int[] temp = new int[arr.length * 2];
        System.arraycopy(arr, 0, temp, 0, size);
        arr = temp;
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();

        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(10);
        priorityQueue.add(3);

        System.out.println(priorityQueue.remove()); // Output: 1
        System.out.println(priorityQueue.remove()); // Output: 3
        System.out.println(priorityQueue.remove()); // Output: 5
    }
}
