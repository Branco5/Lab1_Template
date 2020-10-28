package pt.pa.adts;

public class main {
    public static void main(String[] args) {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();

        try{
            for(int i = 1; i<6; i++){
                queue.enqueue(i);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try {

            System.out.println("Queue is empty? " + queue.isEmpty());

            System.out.println("Size: " + queue.size());

            System.out.println("Front of queue is: " + queue.front());

            System.out.println("Dequeue all elements from queue:");

            while(!queue.isEmpty()) {
                System.out.println(queue.dequeue());
            }

            System.out.println("Queue is empty? " + queue.isEmpty());

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

