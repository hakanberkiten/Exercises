public class SinglyLinkedList {

    private ListNode head;

    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        
        sl.head = new ListNode(10);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(6);
        ListNode fourth = new ListNode(7);
        ListNode fifth = new ListNode(8);
        sl.add(second.data);
        sl.add(third.data);
        sl.add(fourth.data);
        sl.add(fifth.data);
        sl.add(56,5);


        sl.addFirst(7);
        sl.display();
        sl.removeElement(7);
        sl.display();
        System.out.println(sl.size());




    }

    public void display(){

        ListNode current = head;

        System.out.print("head -> ");

        while(current != null){
            System.out.print(current.data+ " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void addFirst(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void clear(){
        head = null;
    }

    public void add(int data){
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

    }

    public void removeFirst(){
        if (head != null) {
            head = head.next;
        }
    }

    public void removeLast(){
        ListNode current = head;
        int count = 0;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        current = head;
        for(int i =0; i<count-1; i++){
            current = current.next;
        }
        current.next = null;
        
    }

    public void removeWithPosition(int index){
        ListNode current = head;
        int count = 0;

        if(index == 0){
            head = head.next;
        }
        else{
            while(current != null){
                if(count == index-1){
                   current.next = current.next.next;
                }
                count++;
                current = current.next;
            }
        }
    }

    public void removeElement(int element){
        while (head != null && head.data == element) {
            head = head.next;
        }
        
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.data == element) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }    
    }

    public void add(int data , int index){
        ListNode newNode = new ListNode(data);
        if(index == 0){
            newNode.next = head;
            head = newNode;
        }
        else{
            ListNode previous = head;
            int count = 1;
            while(count<index-1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;
        }

    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int indexOf(int data){
        ListNode current = head;
        int index = -1;
        int count = -1;
        while(current != null){
            count++;
            if(current.data == data){
                index = count;
             }
            current = current.next;
           
        }
        return index;

        
    }

    public int size(){
        ListNode current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }

        return count;
    }


    private static class ListNode{
        private int data;
        private ListNode next;
    
    
        public ListNode(int data) {
        this.data = data;
        this.next = null;
        }

        
    }

    
}

