import java.util.EmptyStackException;

public class Stack {

    private ListNode top;
    private int length;

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.display();

        

    
    
    }

    public Stack(){
        this.top = null;
        this.length = 0;
    }

    public void push(int data){
        ListNode node = new ListNode(data);
        node.next = top;
        top = node;
        length++;
    }

    public void display(){
        ListNode current = top;

        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        return top.data;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int data = top.data;
        top = top.next;
        length--;
        return data;
    } 

    public boolean isEmpty(){
        return length == 0;
    }
    
    public int size(){
        return length;
    }



    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data) {
        this.data = data;
        }
    }
    
}
