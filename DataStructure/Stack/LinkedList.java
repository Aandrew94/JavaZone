package com.jetbrains;

import java.util.ArrayList;

public final class LinkedList {

    private Node headNode;

    public LinkedList() {
        this.headNode = null;
    }


    public void insertNodeAtBeginning(final int newData){
        Node newNode = new Node(newData);       //  create the new Node;
        newNode.next = this.headNode;           //  set it to point to the Head node
        this.headNode = newNode;                //  make the head to be the new node that has been added
    }


    public void insertNodeAtEnd(int newData){
        if(this.headNode == null){              //  check if we have a head or if is null
            this.headNode = new Node(newData);  //  if true -> create the head;
            return;
        }

        Node currentNode = headNode;            //  make a reference(pointer) to point to the head (to the starting point)
        while(currentNode.next != null){        //  walk through the list until we arrive at the end.
            currentNode = currentNode.next;     //  keep moving until we arrive at the last node
        }

        currentNode.next = new Node(newData);   //  when we arrived at the end, at the last node, make the current
                                                //  reference to link (to point) to the new Node created at the beginning
    }


    public void insertValueAfterNode(final Node prevNode, int newData){
        if(prevNode.next == null){                   //  check is previous node is not null - it shouldn't
            System.out.println("The given previous node cannot be null");       //  if it is, it means that the prev node is the tail (or last node)
            return;
        }

        Node newNode = new Node(newData);
        newNode.next    =   prevNode.next;          //  set the new node to link (to reference) to the prev Node reference
        prevNode.next   =   newNode;                //  set the link (pointing) way of prev node to the new node inserted
    }

     /* Example, assume something like this.
                                             insert here

        |---------------|       |---------------|       |---------------|
        |       2       |       |       3       |       |       5       |
        |---------------|       |---------------|       |---------------|
        |   point to    |------>|   point to    |------>|   point to    |---->  null
        |_______________|       |_______________|       |_______________|


insertAfter(3, new Node(9));
    Node newNode = new Node(newData);   +   newNode.next = prevNode.next;

        |---------------|       |---------------|       |---------------|
        |       2       |       |       3       |       |       5       |
        |---------------|       |---------------|       |---------------|
        |   point to    |------>|   point to    |------>|   point to    |---->  null
        |_______________|       |_______________|    _->|_______________|
                                                    |
        |---------------|                           |
        |       9       |                           |
        |---------------|                           |
        |   point to    |---------------------------|
        |_______________|

prevNode.next = newNode;

        |---------------|       |---------------|           |---------------|
        |       2       |       |       3       |           |       5       |
        |---------------|       |---------------|           |---------------|
        |   point to    |------>|   point to    |---------->|   point to    |---->  null
        |_______________|       |_______________|-      --->|_______________|
                                                 |      |
                           ______________________|      |
                           |                            |
                           |    |---------------|       |
                           |    |       9       |       |
                           |    |---------------|       |
                           ---->|   point to    |--------
                                |_______________|


        |---------------|       |---------------|        |---------------|       |---------------|
        |       2       |       |       3       |        |       9       |       |       5       |
        |---------------|       |---------------|        |---------------|       |---------------|
        |   point to    |------>|   point to    |------->|   point to    |------>|   point to    |---> null
        |_______________|       |_______________|        |_______________|       |_______________|



     */


    public void deleteHead(){
        if(this.headNode == null){
            System.out.println("List is empty");
            return;
        }

        this.headNode = this.headNode.next;
    }


    public void deleteNodeByData(int dataToDelete){
        if(this.headNode == null) {
            return;
        }

        if (this.headNode.data == dataToDelete){            //  special case: here we check if we want to delete the head node
            this.headNode = this.headNode.next;             //  make the head to point to the next element
            return;
        }

        Node temp = this.headNode;                          //  make a reference(pointer) to point to the head (to the starting point)

        while(temp.next != null){                           //  walk through the list until we arrive at the last element
            if(temp.next.data == dataToDelete){             //  if the current data element is == to the value we want to delete
                temp.next = temp.next.next;                 //  walk around that node ... make the current node to point not to the next
                return;                                     //  but to the second one
            }
            temp = temp.next;                               // increment
        }
    }


    public Node searchFor(int dataToFind){
        if(this.headNode == null){
            System.out.println("LinkedList is empty");
            return null;
        }

        Node temp = this.headNode;
        while (temp != null){
            if(temp.data == dataToFind){
                System.out.println("Node found: " + "node adress: " + temp + "\t node data: " + temp.data);
                return temp;
            }
            temp = temp.next;
        }

        System.out.println("Value " + dataToFind + " not found...");
        return null;
    }

    public final int size(){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return -1;
        }

        int count = 1;
        for(Node temp = this.headNode; temp.next != null; temp = temp.next){
            count++;
        }

        return count;
    }

    public final    boolean isEmpty(){
        return (this.headNode == null);
    }

    public final    void    clear(){
        this.headNode = null;
    }

    public final    int     getHeadData(){
        return this.headNode.data;
    }

    public final    Node    getHeadNode(){
        return this.headNode;
    }

    public  void    setHeadNode(Node newHead){
        this.headNode = newHead;
    }

    public final    int     getTail(){
        Node currentNode = this.headNode;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }


    public void showList(){
        if(this.isEmpty()){
            System.out.println("Empty List");
        }
        System.out.print("\n");
        for(Node temp = this.headNode; temp != null; temp=temp.next){
            System.out.print(temp + "\t");
        }
        System.out.println();
        for(Node temp = this.headNode; temp != null; temp=temp.next){
            System.out.print(temp.data + "\t");
        }
        System.out.print("\n");
    }




    public void  swapNodes(final int data1,final  int data2){
        System.out.println("Swapping " + data1 + " with " + data2 + "\n");

        Node node1 = this.headNode;
        Node node2 = this.headNode;

        Node prevNode1 = null;
        Node prevNode2 = null;

        //  special_case:   if the elements are the same
        if(data1 == data2){
            System.out.println("Elements are the same, no swap is needed");
            return;
        }

        //  if elements are not the same        -   search for data1
        while(node1 != null){                   //  while node1 is not tail
            if(node1.data == data1){            //  if data matches
                break;                          //  data1 was found in list so break while loop
            }
                                                //  if data not found
            prevNode1 = node1;                  //  make prevNode = actual node (to keep track of prev pointer)
            node1 = node1.next;                 //  increment actual node
        }

        //  if elements are not the same        -   search for data2
        while(node2 != null){                   //  while node1 is not tail
            if(node2.data == data2){            //  if data matches
                break;                          //  data2 was found in list so break while loop
            }
                                                //  if data not found
            prevNode2 = node2;                  //  make prevNode = actual node (to keep track of prev pointer)
            node2 = node2.next;                 //  increment actual node
        }

        //  special_case:   no matching was found
        if(node1 == null || node2 == null){
            System.out.println("Swap not possible - one or more elements are not in the list");
            return;
        }

        //  Updating prevNode pointers
        if(prevNode1 == null){              //  check if prevNode is the head - if true node1 is head
            this.headNode = node2;          //  so make(update) node2 to be the head
        } else {
            prevNode1.next = node2;         //  set prevNode1.next to be the node2
        }

        if(prevNode2 == null){              //  check if prevNode is the head - if true node2 is head
            this.headNode = node1;          //  so make(update) node1 to be the head
        } else {
            prevNode2.next = node1;         //  set prevNode2.next to be the node1;
        }

        //  Updating next nodes pointers    -   simple basic swap;
        Node temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;
    }


    public int findNthElement(int n){
/**
 *      METHOD A:   TC: O(n) & SC: O(n) - return the size - nth element from and array

        ArrayList<Node>   listOfElements  =   new ArrayList<Node>(0);
        Node currentNode = this.headNode;

        while(currentNode != null){
            listOfElements.add(currentNode);
            currentNode = currentNode.next;
        }
        return listOfElements.get(listOfElements.size() - n).data;
  */

/**
 *      METHOD B:   TC: O(n) & SC: O(1)

        Node temp = null;
        Node currnetNode = this.headNode;
        int count = 0;
        while(currnetNode != null){
            currnetNode = currnetNode.next;
                if(count >= n) {
                    if (temp == null) {
                        temp = this.headNode;
                    }
                    temp = temp.next;
                }
            count++;
        }
        return temp.data;
 */

/**
 *       METHOD C:   TC: O(n) & SC: O(1)
 */

        Node p1 = this.headNode;
        Node p2 = this.headNode;

        //  Move p1 N nodes into the list
        for(int i=0; i<n; i++){
            if(p1 == null){
                return -1;    //  out of bounds
            }
            p1 = p1.next;
        }

        //  Move p1,p2 at same time
        //  when p1 will be at end, p2 will be at the right element
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2.data;
    }

    public int getMiddle(){
        /** Half Speed
         *

        int count = 0;
        Node fast = this.headNode;
        Node slow = this.headNode;

        while (fast != null){
            fast = fast.next;
            if (count % 2 != 0){
                slow = slow.next;
            }
            count++;
        }
        return slow.data;
        */


        Node fast = this.headNode;
        Node slow = this.headNode;

        while (fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow.data;
    }

    public boolean deleteMiddle(final Node n){
        if(n == null || n.next == null){
            return false;
        }

        Node nextNode = n.next;
        n.data = nextNode.data;
        n.next = nextNode.next;
        return true;
    }

    //  make a reverse linked list


}


