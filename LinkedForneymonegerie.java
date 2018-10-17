package linked_forneymonegerie;

import java.util.NoSuchElementException;

public class LinkedForneymonegerie implements LinkedForneymonegerieInterface {

    // Fields
    // -----------------------------------------------------------
    private ForneymonType head;
    private int size, typeSize, modCount;
    
    
    // Constructor
    // -----------------------------------------------------------
    LinkedForneymonegerie () {
        head = null;
        size = 0;
        typeSize = 0;
        modCount = 0;
    }
    
    
    // Methods
    // -----------------------------------------------------------
    public boolean empty () {
        throw new UnsupportedOperationException();
    }
    
    public int size () {
        throw new UnsupportedOperationException();
    }
    
    public int typeSize () {
        throw new UnsupportedOperationException();
    }
    
    public boolean collect (String toAdd) {
        throw new UnsupportedOperationException();
    }
    
    public boolean release (String toRemove) {
        throw new UnsupportedOperationException();
    }
    
    public void releaseType (String toNuke) {
        throw new UnsupportedOperationException();
    }
    
    public int countType (String toCount) {
        throw new UnsupportedOperationException();
    }
    
    public boolean contains (String toCheck) {
        throw new UnsupportedOperationException();
    }
    
    public String rarestType () {
        throw new UnsupportedOperationException();
    }
    
    public LinkedForneymonegerie clone () {
        throw new UnsupportedOperationException();
    }
    
    public void trade (LinkedForneymonegerie other) {
        throw new UnsupportedOperationException();
    }
    
    public LinkedForneymonegerie.Iterator getIterator () {
        throw new UnsupportedOperationException();
    }
    
    
    // -----------------------------------------------------------
    // Static methods
    // -----------------------------------------------------------
    
    public static LinkedForneymonegerie diffMon (LinkedForneymonegerie y1, LinkedForneymonegerie y2) {
        throw new UnsupportedOperationException();
    }
    
    public static boolean sameCollection (LinkedForneymonegerie y1, LinkedForneymonegerie y2) {
        throw new UnsupportedOperationException();
    }
    
    // Private helper methods
    // -----------------------------------------------------------

    // TODO: Your helper methods here!
    
    
    // Inner Classes
    // -----------------------------------------------------------
    
    public class Iterator implements LinkedForneymonegerieIteratorInterface {
        LinkedForneymonegerie owner;
        ForneymonType current;
        int itModCount;
        
        Iterator (LinkedForneymonegerie y) {
            // TODO
        }
        
        public boolean hasNext () {
            throw new UnsupportedOperationException();
        }
        
        public boolean hasPrev () {
            throw new UnsupportedOperationException();
        }
        
        public boolean isValid () {
            throw new UnsupportedOperationException();
        }
        
        public String getType () {
            throw new UnsupportedOperationException();
        }

        public void next () {
            throw new UnsupportedOperationException();
        }
        
        public void prev () {
            throw new UnsupportedOperationException();
        }
        
        public void replaceAll (String toReplaceWith) {
            throw new UnsupportedOperationException();
        }
        
    }
    
    private class ForneymonType {
        ForneymonType next, prev;
        String type;
        int count;
        
        ForneymonType (String t, int c) {
            type = t;
            count = c;
        }
    }
    
}
