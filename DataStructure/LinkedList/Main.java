//package com.jetbrains;

public class Main {
    public static void main(String[] args) {
	// write your code here
        LinkedList ll = new LinkedList();
        for(int i=0;i<=4;i++){
            ll.insertNodeAtEnd(i);
        }
        System.out.println("LinkedList:");
        ll.showList();
        System.out.println("Size:\t" + ll.size());

        ll.swapNodes(1,2);
        ll.showList();
        System.out.println("Size:\t" + ll.size());

        System.out.println(ll.findNthElement(2));
        System.out.println("Midle:\t" + ll.getMiddle());

    }
}
