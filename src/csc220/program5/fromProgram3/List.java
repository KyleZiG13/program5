//Kyle Zeigler
//5/3/2017
//Program Assignment 5
//This is the same list class used in the Program 5 example but is modified to
//have a addBeforeNext and a remove method to contribute to the StageFrame.
//The remove method requires multiple clicks in order to remove an object.
package csc220.program5.fromProgram3;

import csc220.program5.sample.*;
import csc220.list.AddIterator;
import csc220.list.Node;
import java.util.NoSuchElementException;


public class List<E> extends csc220.list.List<E> { 
       
   @Override
   public AddIterator<E> addIterator(){return new ListAddIterator<>();}
   
   
   //  This nested class replaces the one in csc220.list.List
   protected class ListAddIterator<T extends E> extends csc220.list.List<E>.ListAddIterator<E> {
       
       private static final boolean DEBUGGING = true;
      
        protected Node<E> prevNode = null;
        
        @Override
        public E next() {
            prevNode= nextNode;
            return super.next();
        }

        // For debugging purposes.
        private void printNodes(String s) {
            if (!DEBUGGING)
                return;
            System.out.print(s);
            if (prevNode != null) {
                System.out.print("--previous data = " + prevNode.data);
            }
            if (nextNode != null) {
                System.out.print("--next data = " + nextNode.data);               
            }
            System.out.println("");
        }
        
        @Override 
        public void addBeforeNext(E e) {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            
            Node<E> newNode = new Node();
            newNode.data = e;
            newNode.next = prevNode.next;
            prevNode.next = newNode;
                }
        @Override
        public void remove() {
            Node<E> tmp = new Node<>();
            while(tmp != prevNode){
                tmp = prevNode;
            }
            if(prevNode == nextNode){
                tmp.next = nextNode;
                prevNode = null;
            }
            if (first == prevNode){
                first = nextNode;
                prevNode = null;
            }
            if(last == prevNode){
                last = nextNode;
                prevNode = null; 
            }
        }
     }
   
   
}
