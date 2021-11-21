package cn.emmayu.homework.week.first;

/**
 * 641. 设计循环双端队列
 * https://leetcode-cn.com/problems/design-circular-deque/
 */
public class MyCircularDeque {
    /**
     * 头
     */
    private Node head;

    /**
     * 尾
     */
    private Node tail;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 最大容量
     */
    private int maxCapacity;

    /**
     * 最小容量
     */
    private final int MIN_CAPACITY = 0;

    public MyCircularDeque(int k) {
        this.maxCapacity = k;
    }

    public boolean insertFront(int value) {
        if (++size <= maxCapacity) {
            Node tmp = head;
            Node newNode = new Node(value, tail, head);
            head = newNode;
            if (tmp == null) {
                tail = newNode;
            } else {
                tmp.prev = newNode;
            }
            head.prev = tail;
            tail.next = head;
            return true;
        } else {
            size--;
            return false;
        }
    }

    public boolean insertLast(int value) {
        if (++size <= maxCapacity) {
            Node tmp = tail;
            Node newNode = new Node(value, tail, head);
            tail = newNode;
            if (tmp == null) {
                head = newNode;
            } else {
                tmp.next = newNode;
            }
            head.prev = tail;
            tail.next = head;
            return true;
        } else {
            size--;
            return false;
        }
    }

    public boolean deleteFront() {
        if (--size >= MIN_CAPACITY) {
            if (head != null && head.next != null && head != tail) {
                Node tmp = head;
                head = head.next;
                tmp = null;
            } else {
                head = tail = null;
            }
            return true;
        } else {
            size++;
            return false;
        }
    }

    public boolean deleteLast() {
        if (--size >= MIN_CAPACITY) {
            if (tail != null && tail.prev != null && tail != head) {
                Node tmp = tail;
                tail = tail.prev;
                tmp = null;
            } else {
                tail = head = null;
            }
            return true;
        } else {
            size++;
            return false;
        }
    }

    public int getFront() {
        return head == null || size == 0 ? -1 : head.val;
    }

    public int getRear() {
        return tail == null || size == 0 ? -1 : tail.val;
    }

    public boolean isEmpty() {
        return size == MIN_CAPACITY;
    }

    public boolean isFull() {
        return size == maxCapacity;
    }

    private static class Node {
        int val;
        Node next;
        Node prev;

        Node() {
        }

        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

    }
}

