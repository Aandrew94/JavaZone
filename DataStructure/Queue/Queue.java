package com.jetbrains;

public final class Queue {
    private static class Node{
        private int data;
        private Node next;
        private Node(int data){
            this.data = data;
        }
    }

    private Node head;                  //  remove from the head
    private Node tail;                  //  add things here

    public Queue(){
        this.head = null;
        this.tail = null;
    }

    public final boolean isEmpty(){
        return this.head == null;
    }

    public final int peek(){
        return this.head.data;
    }

    public final void enqueue(final int data){      //  add to tail
        Node newNode = new Node(data);
        if(this.tail != null){
            this.tail.next = newNode;
        }
        this.tail = newNode;

        if(this.head == null){
            this.head = newNode;
        }
    }

    public final int dequeue(){                     //  remove from head
        int data = this.head.data;
        this.head = this.head.next;

        if(this.head == null){
            this.tail = null;
        }

        return data;
    }

    public final void print(){
        Node currentNode = this.head;
        while(currentNode != null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

}
