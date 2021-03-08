package com.jetbrains;

import java.util.EmptyStackException;

public final class Stack {
//    private static class Node{
//        private final int   data;
//        private Node  next;
//
//        private Node(final int data){
//            this.data = data;
//            this.next = null;
//        }
//    }

    private Node    top;
    private int     size;
    private final int     MAXSIZE;

    public  Stack(){
        this(Integer.MAX_VALUE);
    }

    public  Stack(int initSize){
        this.top    =   null;
        this.size   =   0;
        this.MAXSIZE = initSize;
    }

    public final boolean isEmpty(){
        return top == null;
    }

    public final int peek() throws EmptyStackException{
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        return this.top.data;
    }

    public final void push(final int data) throws OutOfMemoryError{
        if(this.size >= this.MAXSIZE){
            throw new OutOfMemoryError();
        }

        Node newNode =  new Node(data);
        newNode.next =  this.top;
        this.top     =  newNode;
        this.size++;
    }

    public final int pop()  throws EmptyStackException{
        if(!isEmpty()){
            int data = top.data;
            top = top.next;
            this.size--;
            return data;
        } else {
            throw new EmptyStackException();
        }
    }

    public final int getSize(){
        return this.size;
    }

    public void display(){
        Node currentNode = this.top;
        while(currentNode != null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

}
