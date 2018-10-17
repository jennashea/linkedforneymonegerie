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
        return size == 0;
    }
    
    public int size () {
        return size;
    }
    
    public int typeSize () {
        return typeSize;
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
    
    private int findIndex(String text) {
        ForneymonType current = head;
        for (int i = 0; i < typeSize; i++) {
            if (current.type.equals(text)) {
                return i;
            }
            current = current.next; 
        }
        return -1;
    }
    
    private ForneymonType findType(String text) {
        ForneymonType current = head;
        for (int i = 0; i < typeSize; i++) {
            if (current.type.equals(text)) {
                return current;
            }
            current = current.next; 
        }
        return null;
    }
    
    private ForneymonType findTypeByIndex(int index) {
        ForneymonType current = head;
        for (int i = 0; i <= index; i++) {
            current = current.next; 
        }
        return current; 
    }
    
    private boolean insertForneymon (String text, int count) {
        ForneymonType typeMon = findType(text);
        // Case: new string, so add new ForneymonType
        if (type == null) {
            findTypeByIndex(typeSize-1).next = new ForneymonType(text, count);
            size++;
            typeSize++;
            return true;
            
        // Case: existing string, so update count
        } else {
            size++;
            typeMon.count++;
            return false;
        }
    }
    
    
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
