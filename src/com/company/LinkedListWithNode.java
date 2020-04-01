package com.company;

import java.util.List;

public class LinkedListWithNode implements Cloneable {


    private Node head;
    private int listCount;

    public LinkedListWithNode() {
        // this is an empty list, so the reference to the head node
        // is set to a new node with no data
        head = new Node(null);
        listCount = 0;
    }
    public void add(Object data) 	{
        // post: appends the specified element to the end of this list.
        Node temp = new Node(data);
        Node current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        temp.setPrev(current);
        listCount++;// increment the number of elements variable
    }
    public void add(Object data, int index) {
        // post: inserts the element at the specified position in this list.
        Node temp1 = null;
        Node temp = new Node(data);
        Node current = head;
        for(int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        temp1 = current.getNext();
        temp.setPrev(current);
        temp.setNext(current.getNext());
        temp1.setPrev(temp);
        current.setNext(temp);


        listCount++;// increment the number of elements variable
    }
    public Object get(int index) {
        // post: returns element at specified position (must be >=1) in this list.
        if(index <= 0)
            return null;
        Node current = head.getNext();
        for(int i = 1; i < index; i++) {
            if(current.getNext() == null)
                return null;
            current = current.getNext();
        }
        return current.getData();
    }




    public boolean remove(int index) { // post: removes specified element
        Node temp1 = null;
        if (index < 1 || index > size())
            return false;
        Node current = head;
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null)
                return false;
            current = current.getNext();
        }
        // check if last node
        if (current.getNext().getNext() == null) {
            current.setNext(null);

        } else {
            temp1 = current.getNext().getNext();
            temp1.setPrev(current);
            current.setNext(current.getNext().getNext());
        }
        listCount--; // decrement the number of elements variable
        return true;
    }
    public int size() {  // post: returns number of elements in list.
        return listCount;
    }
    public String toString() {
        Node current = head.getNext();
        String output = "";
        while(current != null) {
            output += "[" + current.getData().toString() + "]";
            current = current.getNext();
        }
        return output;
    }

    public LinkedListWithNode ListReverse(){
        Node rHead = null;
        Node current = head;
        Node current1 = null;

        // Loop to the end of the last node
        while(current.getNext() != null) {
            current = current.getNext();
        }
        // loop in the reverse order
        LinkedListWithNode rList = new LinkedListWithNode();
        while(current.getPrev() != null){
            rList.add(current.getData());

            current = current.getPrev();
        }
        return rList;
    }
    @Override
    public LinkedListWithNode clone() throws CloneNotSupportedException {
        Node current = head.getNext();
        // loop in the reverse order
        LinkedListWithNode newClone = new LinkedListWithNode();
        while(current != null){
            newClone.add(current.getData());
            current = current.getNext();
        }
        return newClone;

    }


    public int listSearch(Object target){
        Node current = head.getNext();
        int count = 1;

        while(current.getNext() != null){
            String lhs = (String) target;
            String rhs = (String) current.getData();
            if (lhs.equals(rhs)){
                return count;
            }
            current = current.getNext();
            count++;

        }
        return -1;
    }

    public LinkedListWithNode listPart(int start, int end) throws IllegalArgumentException{
        Node current = head.getNext();
        int count = 1;

        if (start < 1 || start > listCount || start > end){
            throw new IllegalArgumentException();
        }
        if (end < 1 || end > listCount){
            throw new IllegalArgumentException();

        }
        LinkedListWithNode lList = new LinkedListWithNode();
        while(current.getNext() != null ){


            if (count >= start && count <= end){
                lList.add(current.getData());

            }
            current = current.getNext();
            count++;

        }

        return lList;
    }



    private class Node {
        // reference to next node in chain, or null if there isn't one.
        Node next;
        // data carried by this node.
        Object data;
        // reference to the previous node in chain
        Node prev;
        public Node(Object _data) {
            prev = null;
            next = null;
            data = _data;
        }
        public Node(Object _data, Node _next, Node _prev) {
            prev = _prev;
            next = _next;
            data = _data;
        }
        public Object getData() {

            return data;
        }
        public void setData(Object _data) {

            data = _data;
        }
        public Node getPrev(){
            return prev;
        }

        public void setPrev(Node _prev){
            prev = _prev;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node _next) {
            next = _next;
        }
    }
}