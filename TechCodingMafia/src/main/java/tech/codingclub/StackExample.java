package tech.codingclub;

import java.util.Date;
import java.util.Iterator;
import java.util.Stack;


public class StackExample {
    public static void main(String[] args) {
        System.out.println("Hello Mohit Kota! ");
        System.out.println("Stack.java  Running at " + new Date() + " sharp." );
        // creating a stack
        Stack<String> stack = new Stack<String>();
        Stack<Integer> stack1 = new Stack<Integer>();
        // push the elements into stack
        stack1.push(2);
        stack1.push(5);
        stack1.push(10);
        stack1.push(101);
        // pop the element from stack

        int TopElement = stack1.pop(); // removed element
        System.out.println("the top element is stack : "+stack1.peek());

        // Iterator
        Iterator<Integer> integerIterator = stack1.iterator();

        while(integerIterator.hasNext())
        {
            System.out.println("Interator showing element : "+integerIterator.next());
        }


        // search in stack
        int index = stack1.search(5);
        int find = stack1.search(10);

        System.out.println("Index of 5 : "+index);
        System.out.println("Index of 10 : "+find);

        // check whether stack is empty or not
        while(!stack1.empty())
        {
            int TopElements = stack1.pop();
            System.out.println("The popped element is : "+TopElements);

        }




    }
}
