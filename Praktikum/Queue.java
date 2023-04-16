import java.util.Scanner;

public class Queue {
    int size = 10;
    int data[] = new int[size];
    int head, tail;
    Scanner input = new Scanner(System.in);

    public Queue() {
        head = -1;
        tail = -1;
    }

    public void menu() {
        char menu;
        int element;
        System.out.println(" ");
        System.out.println("Queue Operations");
        System.out.println("1. Insert");
        System.out.println("2. Remove");
        System.out.println("3. Peek");
        System.out.println("4. Check Empty");
        System.out.println("5. Check Full");
        System.out.println("6. Size");
        System.out.println("7. Exit");
        System.out.print("Pilih [1-7]: ");
        menu = input.next().charAt(0);
        System.out.println(" ");
        switch(menu){
            case '1': 
            System.out.print("Data: ");
            element = input.nextInt();
            enqueue(element);
            menu();
            case '2': 
            dequeue();
            menu();
            case '3':
            peek();
            menu();
            case '4':
            if(isEmpty()){
                System.out.println("Queue is Empty!");
            }else {
                System.out.println("Queue is not Empty!");
            }
            menu();
            case '5':
            if(isFull()){
                System.out.println("Queue is Full!");
            }else {
                System.out.println("Queue is not Full!");
            }
            menu();
            case '6':
            size();
            menu();
            case '7':
            System.exit(menu);
        }
    }

    // insert elements to the queue
    public void enqueue(int element) {
        // if queue is full
        if(isFull()) {
            System.out.println("Queue is full!");
        }else {
            if(head==-1) {
                head = 0;
            }
            tail++;
            // insert element
            data[tail] = element;
            System.out.println("Insert " + element);
        }
    }

    // remove element from the queue
    public int dequeue() {
        int element;

        // if queue is empty
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return (-1);
        }else {
            // remove element
            element = data[head];

            // if data is only one
            if(head >= tail) {
                head = -1;
                tail = -1;
            }else {
                for(int i=0; i < tail; i++) {
                    int temp = data[i+1];
                    data[i] = temp;
                }
                head++;
                tail--;
            }
            System.out.println(element + " Deleted");
            return (element);
        }
    }

    // check if queue is empty
    public boolean isEmpty() {
        if(head == -1) {
            return true;
        }else {
            return false;
        }
    }

    // check if queue is full
    public boolean isFull() {
        if(head == 0 && tail == size-1) {
            return true;
        }else {
            return false;
        }
    }

    // display head of queue
    public void peek() {
        System.out.println("Head of queue: " + data[0]);
    }

    // check size of queue 
    public void size() {
        System.out.println("Size of queue: " + (tail+1));
        print();
    }

    // print queue
    public void print() {
        for(int i = 0; i < (tail+1); i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
    }
}
