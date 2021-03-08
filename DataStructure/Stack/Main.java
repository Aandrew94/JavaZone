//	package com.jetbrains;
public class Main {

    public static void main(String[] args) {

        StackArr opa = new StackArr();
        System.out.println(opa.isEmpty());
        opa.display();
        opa.push(1);
        opa.push(2);
        opa.push(3);
        opa.push(4);
        opa.display();
        System.out.println("peek:\t" + opa.peek());
        opa.display();
        System.out.println("pop:\t" + opa.pop());
        opa.display();
        System.out.println("peek:\t" + opa.peek());
        System.out.println(opa.isEmpty());
        opa.display();
        System.out.println("Size:\t" + opa.getSize());

    }
}
