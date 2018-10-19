package linkedforneymonegerie;

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
        return insertForneymon(toAdd, 1);
    }
    
    public boolean release (String toRemove) {
        return releaseForneymon(toRemove, 1);
    }
    
    public void releaseType (String toNuke) {
    	ForneymonType toRidOf = findType(toNuke);
    	if (toRidOf != null) {
    		modCount++;
    	}
    	size-= toRidOf.count;
        remove(toNuke);
    }
    
    public int countType (String toCount) {
    	if (findType(toCount) == null) {
    		return 0;
    	}
        return findType(toCount).count;
    }
    
    public boolean contains (String toCheck) {
        return (findType(toCheck)!= null);
    }
    
    public String rarestType () {
    	String rarest = null;
        int lowestCount = 0;
        if (this.empty()) {
        	return null;
        }
        ForneymonType currentType = head;
        for (int i = 0; i < typeSize; i++) {            
            if (currentType.count <= lowestCount || rarest == null) {
                lowestCount = currentType.count;
                rarest = currentType.type;
            }
            currentType = currentType.next;
        }
        return rarest;
    }
    
    public LinkedForneymonegerie clone () {
        LinkedForneymonegerie dolly = new LinkedForneymonegerie();
        if (empty()) {
            return dolly;
        }
        dolly.size = size;
        dolly.typeSize = typeSize;
        dolly.head = new ForneymonType(head.type, head.count);
        ForneymonType current = head;
        ForneymonType dollyCurrent = dolly.head;
        for (int i = 0; i < typeSize; i++) {
            if (current.next != null) {
            	dollyCurrent.next = new ForneymonType(current.next.type, current.next.count);
            	dollyCurrent.next.prev = dollyCurrent;
            	dollyCurrent = dollyCurrent.next;
                current = current.next;
            }
            
        }
        return dolly;
    }
    
    public String toString () {
        String[] result = new String[typeSize];
        ForneymonType current = head;
        for (int i = 0; i < typeSize; i++) {
            result[i] = "\"" + current.type + "\": " + current.count;
            current = current.next;
        }
        return "[ " + String.join(", ", result) + " ]";
    }
    
    public void trade (LinkedForneymonegerie other) {
    	ForneymonType tempHead = head;
        int tempSize = size,
            tempUniqueSize = typeSize;
        
        head = other.head;
        size = other.size;
        typeSize = other.typeSize;
        
        other.head = tempHead;
        other.size = tempSize;
        other.typeSize = tempUniqueSize;
    }
    
    public LinkedForneymonegerie.Iterator getIterator () {
        return new Iterator(this);
    }
    
    
    // -----------------------------------------------------------
    // Static methods
    // -----------------------------------------------------------
    
    public static LinkedForneymonegerie diffMon (LinkedForneymonegerie y1, LinkedForneymonegerie y2) {
    	LinkedForneymonegerie result = y1.clone();
    	ForneymonType y2current = y2.head;
        for (int i = 0; i < y2.typeSize; i++) {
            result.releaseForneymon(y2current.type, y2current.count);
            y2current = y2current.next;
        }
        return result;
    }
    
    public static boolean sameCollection (LinkedForneymonegerie y1, LinkedForneymonegerie y2) {
    	return diffMon(y1, y2).empty() && diffMon(y2, y1).empty();
    }
    
    // Private helper methods
    // -----------------------------------------------------------
    
//    private int findIndex(String text) {
//        ForneymonType current = head;
//        for (int i = 0; i < typeSize; i++) {
//            if (current.type.equals(text)) {
//                return i;
//            }
//            current = current.next; 
//        }
//        return -1;
//    }
    
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
        	if (current.next != null) {
        		current = current.next; 
        	}
        }
        return current; 
    }
    
    private void remove(String toRid) {
    	if (findType(toRid) == null) {
    		return;
    	}
    	ForneymonType toRidOf = findType(toRid);
    	typeSize--;

    	if (toRidOf.prev != null) {
    		toRidOf.prev.next = toRidOf.next;
    	}
        if (toRidOf .next != null) {
        	toRidOf.next.prev = toRidOf.prev;
        }
        if (toRidOf == head) {
        	head = head.next;
        }
        
    }
    
    
    
    private boolean insertForneymon (String text, int count) {
        ForneymonType typeMon = findType(text);
        // Case: new string, so add new ForneymonType
        modCount++;
        if (typeMon == null) {
        	if(this.empty()) {
        		head = new ForneymonType(text, count);
        		size+= count;
                typeSize++;
        		return true;        		
        	}
            findTypeByIndex(typeSize-1).next = new ForneymonType(text, count);
            findTypeByIndex(typeSize).prev = findTypeByIndex(typeSize-1);
            size+= count;
            typeSize++;
            return true;
            
        // Case: existing string, so update count
        } else {
            size+= count;
            typeMon.count+= count;
            return false;
        }
    }
    
    private boolean releaseForneymon (String text, int count) {
        ForneymonType typeMon = findType(text);
        // Case: new string, so add new ForneymonType
        
        if (typeMon == null) {
        	return false;
            
        // Case: existing string, so update count
        } else {
        	modCount++;
            typeMon.count-= count;
            size-= count;
            if (typeMon.count <= 0) {
            	remove(text);
            }
            return false;
        }
    }
    
    
    // Inner Classes
    // -----------------------------------------------------------
    
    public class Iterator implements LinkedForneymonegerieIteratorInterface {
        LinkedForneymonegerie owner;
        ForneymonType current;
        int itModCount;
        int typeCount;
        
        Iterator (LinkedForneymonegerie y) {
            owner = y;
            current = y.head;
            itModCount = y.modCount;
            typeCount = 1;
        }
        
        public boolean hasNext () {
            return (current.next != null) && this.isValid();
        }
        
        public boolean hasPrev () {
        	return (current.prev != null) && this.isValid();
        }
        
        public boolean isValid () {
        	return (itModCount == owner.modCount);
        }
        
        public String getType () {
            return (this.isValid()) ? current.type : null;
        }

        public void next () {
            typeCount++;
            if (typeCount > current.count) {
            	if (hasNext()) {
            		current = current.next;
            	}
            	typeCount = 1; 
            }
        }
        
        public void prev () {
        	typeCount--;
            if (typeCount < 1) {
            	if (hasPrev()) {
            		current = current.prev;
            	}
            	typeCount = current.count; 
            }
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
