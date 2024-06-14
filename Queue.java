public class Queue {

    private ListNode front;
    private ListNode rear;
    private int length;
    
    
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);

        

        queue.display();
        queue.dequeue();
        queue.display();

    }


     public int size(){
        return length;
     }
     public boolean isEmpty(){
        return length == 0;
     }

     public void display(){
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("front <- ");
        ListNode current = front;
        while (current != null) {
            System.out.print(current.data + " <- ");
            current = current.next;
        }
        System.out.println("rear");
     }

     public void enqueue(int data){
        ListNode node = new ListNode(data);
        if(isEmpty()){
            front = node;
            rear = node;
        }else{
            rear.next = node;
            rear = node;
        }
        length++;

       


     }

     public int dequeue(){
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        int result = front.data;

        front = front.next;
        if (front == null) {
            rear = null; 
        }
        length--;
        return result;

     }

     public int peek(){
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return front.data;
     }


    private class ListNode{
        private ListNode next;
        private int data;

        public ListNode(int data) {
        this.next = null;
        this.data = data;
        }
        
    }
}
