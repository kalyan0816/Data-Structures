package utils;

import java.util.Stack;

public class QueueInTwoStacks {

    private static Stack<Integer> original = new Stack<>();
    private static Stack<Integer> dummy = new Stack<>();

    public static void main(String[] args) {
        enqueue(1);
        enqueue(3);
        enqueue(4);
        System.out.println(dequeue());
        enqueue(5);
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
    }

    static void enqueue(int x) {
        original.push(x);
    }

    static Integer dequeue() {
        if (original.empty() && dummy.empty()) {
            System.out.println("queue is empty");
            return null;
        }
        if (!dummy.empty()) {
            return dummy.pop();
        }
        while (!original.empty()) {
            dummy.push(original.pop());
        }
        return dequeue();
    }
}