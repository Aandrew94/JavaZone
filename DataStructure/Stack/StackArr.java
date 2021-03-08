//  package com.jetbrains;

public final class StackArr {
    private final int maxSize = 1000;
    private int top;
    private final int[] stack;


    public StackArr(){
        this.top = -1;
        this.stack = new int[maxSize];
    }

    public final boolean isEmpty(){
        return  this.top < 0;
    }

    public final void push(final int x){
        this.top++;
        this.stack[this.top] = x;
        System.out.println(x + " pushed into the stack");
    }

    public final int pop() throws  ArrayIndexOutOfBoundsException{
        if(this.top < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        this.top--;
        return this.stack[this.top];
    }

    public final int peek(){
        return this.stack[top];
    }

    public final void display(){
        for(int i=top; i>=0; i--){
            System.out.println(this.stack[i]);
        }
    }

    public final int getSize(){
        int nrOfElements = 0;
        for(int i=0;i<=top;i++){
            nrOfElements++;
        }
        return nrOfElements;
    }

}
