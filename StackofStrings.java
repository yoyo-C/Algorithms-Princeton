package com.yuyu.coursera.algorithms.stacksandqueues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by chenyuyu on 2016/11/23.
 */
public class StackofStrings {
    private Node first = null;

    private class Node {
        String item;
        Node next;
    }
    public StackofStrings() {

    }
    void push (String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }
    boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        StackofStrings stack = new StackofStrings();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                StdOut.print(stack.pop());
            }
            else {
                stack.push(s);
            }
        }
    }
}
