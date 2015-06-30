/**
 * Created by Ёдуард on 09.06.15.
 * оздать 2 класса - дл€ очередей типа FIFO и LIFO реализовав Queue.
 * —оздать программу дл€ его тестировани€ (class with spvm)
 */
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.*;

import java.util.*;
import java.util.AbstractSequentialList;
import java.util.Random;
public class QueueFIFO extends AbstractSequentialList<Integer> implements Queue<Integer> {

    @Override
    public Integer get(int index) {
            throw new RuntimeException("Do not use this method") ;
    }
    @Override
    public ListIterator<Integer> listIterator(int index) {
        return null;
    }
    @Override
    public int size() {
        return 0;
    }
private AbstractSequentialList LIFO = new AbstractSequentialList() {
    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
};
    //////////////////////////////////////////////////
    int i= 0;
    LinkedList iter = new LinkedList();

    @Override
    public boolean add(Integer integer) {

        LIFO.add(i, integer);
        return true;
    }

    @Override
    public boolean offer(Integer integer) {
        return false;
    }

    @Override
    public Integer remove() {
        return null;
    }

    @Override
    public Integer poll() {
        return null;
    }

    @Override
    public Integer element() {
        return null;
    }

    @Override
    public Integer peek() {
        return null;
    }
    public static void main(String[]args){

        Stack q = new Stack();
        q.add(343);
        q.add(565);
        q.add(676);
        q.add(5);
        q.add(55);
        q.add(6);
        while (!q.empty()){
            System.out.println(q.pop());
        }
    }
}
