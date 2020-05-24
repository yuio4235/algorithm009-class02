package com.danny.algo.learn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyCircularDeque {
    // container to store items
    private int[] array;
    // the last inserted position
    private int curr;
    //lock for safe mode
    Lock lock = new ReentrantLock();
    public MyCircularDeque(int k) {
        array = new int[k];
        curr = -1;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        lock.lock();
        try {
            if (curr == array.length -1) {
                return false;
            }
            array[++curr] = value;
            return true;
        } finally {
            lock.unlock();
        }
    }
    
    /**
     * Adds an item at the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertLast(int value) {
        lock.lock();
        try {
            if (curr == array.length -1 ) {
                return false;
            }
            if (curr < 0) {
                array[++curr] = value;
                return true;
            }
            int[] temp = new int[curr+1];
            System.arraycopy(array, 0, temp, 0, curr + 1);
            array[0] = value;
            System.arraycopy(temp, 0, array, 1, curr + 1);
            curr ++;
            return true;
        } finally {
            lock.unlock();
        }
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        lock.lock();
        try {
            if (curr < 0) {
                return false;
            }
            curr --;
            return true;
        } finally {
            lock.unlock();
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        lock.lock();
        try {
            if (curr < 0) {
                return false;
            }
            int[] temp = new int[curr];
            System.arraycopy(array, 1, temp, 0, curr);
            System.arraycopy(temp, 0, array, 0, curr);
            curr--;
            return true;
        } finally {
            lock.unlock();
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        lock.lock();
        try {
            if (curr < 0) {
                return -1;
            }
            return array[curr];
        } finally {
            lock.unlock();
        }
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        lock.lock();
        try {
            if (curr < 0) {
                return -1;
            }
            return array[0];
        } finally {
            lock.unlock();
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        lock.lock();
        try {
            return curr < 0;
        } finally {
            lock.unlock();
        }
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        lock.lock();
        try {
            return curr == array.length -1;
        } finally {
            lock.unlock();
        }
    }
}