package com.yuyu.coursera.algorithms.stacksandqueues;

import java.util.Iterator;

/**
 * Created by chenyuyu on 2016/11/23.
 */
public class FixedCapacityStackOfStrings<Item> implements Iterable<Item> {
    private Item[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        s = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }
    public void push(Item item) {
        s[N++] = item;
    }
    public Item pop() {
        return s[--N];
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext() {
            return i > 0;
        }
        public void remove() {

        }
        public Item next() {
            return s[--i];
        }
    }
}
