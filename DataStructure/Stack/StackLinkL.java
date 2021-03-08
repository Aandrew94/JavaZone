//  package com.jetbrains;

import java.util.EmptyStackException;

public final class StackLinkL {
    private final LinkedList stack;

    StackLinkL(){
        this.stack = new LinkedList();
    }

    public final boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public final int peek(){
        if(this.stack.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return this.stack.getHeadNode().data;
    }

    public final void push(final int data){
        this.stack.insertNodeAtBeginning(data);
    }

    public final int pop(){
        if(this.stack.isEmpty()){
            System.out.println("Nothing to pop - stack empty");
            return -1;
        }
        int data = this.stack.getHeadData();
        this.stack.deleteHead();
        return data;
    }

    public final int getSize(){
        return this.stack.size();
    }

    public void printStack(){
        Node currentNode = this.stack.getHeadNode();
        while(currentNode != null){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

}
