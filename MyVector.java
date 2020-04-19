/**
 *  Midterm: Data Structure Coding Challenge
 *  creates a dynamic generic list that updates its size, capacity, and increment value.
 *  CS108-4
 *  4/18/20
 *  @author  Danela Agpaoa
 */

import java.util.*;

public class MyVector<E> extends MyAbstractList<E>{
    public int size;
    public int capacity;
    public int increment;
    public AbstractList<E> myList;

    @SuppressWarnings("unchecked")
    public MyVector() {
        myList = new ArrayList<E>(10);
        capacity = 10;
        increment = 5;
        size = 0;
    }

    public MyVector(int givenCapacity) {
        capacity = givenCapacity;
    }

    public MyVector(int givenCapacity, int givenIncrement) {
        capacity = givenCapacity;
        increment = givenIncrement;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getIncrement() {
        return increment;
    }

    public String toString() {
        return myList.toString();
    }

    /**
     * Appends the specified element to the end of this list,
     * The list capacity should be resized based on a capacity
     * increment variable once the current capacity is filled (capacity == size).
     * @param data
     * @return boolean
     */
    @Override
    public boolean add(E data) {
        boolean checkAdd = false;
        myList.add(data);
        capacity++;
        if (capacity == size) {
            capacity += increment;
        }

        if (myList.contains(data)) {
            checkAdd = true;
        }

        return checkAdd;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements by adding one to their indices.
     * The list capacity should be resized based on a capacity
     * increment variable once the current capacity is filled (capacity == size).
     * @param index - index at which the specified element is to be inserted
     * @param data - element to be inserted
     * @return boolean
     * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
     */
    @Override
    public boolean add(int index, E data) throws IndexOutOfBoundsException {
        boolean checkAdd = false;
        myList.add(index, data);
        capacity++;
        if (capacity == size) {
            capacity += increment;
        }

        if (myList.indexOf(data) == index) {
            checkAdd = true;
        }

        return checkAdd;
    }




    /**
     * Removes all of the elements from this list
     */
    @Override
    public void clear() {
        myList.clear();
    }




    /**
     * Returns the element at the specified position in this list
     * @param index
     * @return E
     */
    @Override
    public E get(int index) {
        E element = myList.get(index);

        return element;
    }

    /**
     * Returns true if this list contains no elements
     * @return boolean
     */
    @Override
    public boolean isEmpty(){
        boolean empty = false;

        if (myList.isEmpty()){
            empty = true;
        }

        return empty;
    }

    /**
     * Removes the  element at the specified position in this list.
     * Shifts any subsequent elements by subtracting one from their indices.
     * @param index - index of the element to be removed
     * @return E - the element that was removed from the list
     * IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        E element = myList.get(index);
        myList.remove(index);

        return element;
    }



    /**
     * Trims the capacity of this MyVector instance to be the list's current size. An application
     * can use this operation to minimize the storage of a MyVector instance.
     */
    @Override
    public void trimToSize() {
        if (capacity > size) {
            for (int i = size; i < capacity; i++) {
                myList.remove(i);
            }
        }
    }



    /**
     * Returns the number of elements in this list
     * @return int
     */
    public int size(){
        return size;
    }

}
