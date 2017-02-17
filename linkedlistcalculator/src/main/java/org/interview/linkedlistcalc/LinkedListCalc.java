package org.interview.linkedlistcalc;

import java.util.LinkedList;
import java.util.List;

public class LinkedListCalc{


    public static LinkedList<String> add(LinkedList<String> numberA, LinkedList<String> numberB) {
        LinkedList<String> result = new LinkedList<String>();

        int sum = 0;
        while( !numberA.isEmpty() || !numberB.isEmpty()  || sum != 0 ) {
            int a = numberA.size() > 0 ? Integer.parseInt(numberA.removeLast()) : 0;
            int b = numberB.size() > 0 ? Integer.parseInt(numberB.removeLast()) : 0;

            sum += a + b;
            result.addFirst(Integer.toString(sum % 10));
            sum = sum / 10;
        }

        return result;
    }
}
