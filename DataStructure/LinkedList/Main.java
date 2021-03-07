package com.jetbrains;


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

        StackArr opa = new StackArr();
        System.out.println(opa.isEmpty());
        opa.push(1);
        opa.push(2);
        opa.push(3);
        opa.push(4);
        opa.printStack();
        System.out.println("peek:\t" + opa.peek());
        opa.printStack();
        System.out.println("pop:\t" + opa.pop());
        opa.printStack();
        System.out.println("peek:\t" + opa.peek());
        System.out.println(opa.isEmpty());
        opa.printStack();



    }


}


//  -----------------------------------------

@FunctionalInterface
interface MyName{
    String computeName(String name);
}

@FunctionalInterface
interface NumerticTest{
    boolean computeTest(int n);
}

@FunctionalInterface
interface myGreeting{
    String processName(String str);
}

@FunctionalInterface
interface myString{
    StringBuilder myStringFunction(String str);
}

@FunctionalInterface
interface MyGeneric<T>{
    T compute (T t);
}


/*Lmbda =   anonymous function/methods (methods without names)
 *   -   used to implement a method defined by a functional interface (provides implementation of functional interface)
 *       -   functional interface    =   interface with only one abstract method
 *       -   Java provides an annotation @FunctionalInterface - used to declare an interface as functional one
 *   -   useful in collection library
 *   -   helps to iterate, filter and extract data from collections
 *   -   lambda expression is treated as a function -> so compiler does not create .class file
 *
 * SYNTAX:   (argument-list) -> {body}
 * - argument-list   ->  can be empty or non-empty as well
 * - arrow operator  ->  used to link argument-list and body of expression
 * - body            ->  contains the expressions and statements for lambda expression
 *
 * */

/*
        System.out.println("\nTestin Lambda expressions\n\n");

                NumerticTest isEven = (n) -> (n % 2) == 0;
                NumerticTest isNegative = (n) -> (n < 0);
        MyName namePrint = (str) -> "You are\t" + str;
        myGreeting morningGreeting = (str) -> "Good morningt\t" + str;
        myGreeting eveningGreeting = (str) -> "Good evening\t" + str;

        System.out.println(isEven.computeTest(5));
        System.out.println(isNegative.computeTest(-5));
        System.out.println(namePrint.computeName("Andrew"));
        System.out.println(morningGreeting.processName("Luis"));
        System.out.println(eveningGreeting.processName("Jessica"));

//  Block Lambda expressions
        myString reverseOne = (String str) -> {
        StringBuilder result = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
        result.append(str.charAt(i));
        }
        return result;
        };

//  Generic Functional Interface (different types)
        MyGeneric<String> reverseString = (String word) -> {
        String result = "";
        for (int i = word.length() - 1; i >= 0; i--) {
        result += word.charAt(i);
        }
        return result;
        };

        MyGeneric<Integer> factorial = (Integer number) -> {
        Integer result = 1;
        for (int i = 1; i <= number; i++) {
        result *= i;
        //System.out.println("Factorial of " + i + " = " + result);
        }
        return result;
        };

        System.out.println(reverseOne.myStringFunction("Lambda Demo"));
        System.out.println("\n");
        System.out.println(reverseString.compute("Andrew is here ^_^"));
        System.out.println(factorial.compute(5));

 */