package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class HashTable {

	private ArrayList<LinkedList<Slot>> bucketList;
	private int bucketSize = 0;
	private int size = 0;
	
	public HashTable(int M){
		this.bucketSize = M;
		this.bucketList = new ArrayList<LinkedList<Slot>>();
		for(int i = 0; i < bucketSize; i++) {
			bucketList.add(null);
		}
	}
	
	class Slot {
		private String key;
		private Object value;
		
		public Slot(String key, Object value) {
			this.key = key;
			this.value = value;
		}
		
		public String getKey() {
			return this.key;
		}
		
		public Object getValue() {
			return this.value;
		}
		
		public void setValue(Object value) {
			this.value = value;			
		}		
	}
	
	public int getHashIndex(String key) {
		int hashIndex = 0;
		for(char c : key.toCharArray()){
			hashIndex = c + hashIndex*31;
		}
		return hashIndex % bucketList.size();
	}
	
	public Slot getSlot(LinkedList<Slot> bucket, String key) {
		if(bucket == null) return null;
		for(Slot slot : bucket) {
			if(slot.getKey().equals(key)) return slot; 
		}
		return null;
	}
	
	
	/*
	 * If the map previously contained a mapping for the key, 
	 * the old value is replaced by the specified value.
	 * returns : the previous value of the specified key in this hashtable, or null if it did not have one
	 */
	public void put(String key, Object value) {
		if(key == null || value == null)
			throw new NullPointerException();
		
		int hashIndex = getHashIndex(key);
		LinkedList<Slot> bucket = bucketList.get(hashIndex);		
		
		if(bucket == null) {
			bucket = new LinkedList<Slot>();
			bucketList.set(hashIndex, bucket);
		}
		
		Slot slot = getSlot(bucket, key);		
		if(slot != null) 
			slot.setValue(value);
		else{
			bucket.addLast(new Slot(key, value));
			size++;
		}
		
	}
	
	/*
	 * Returns the value to which the specified key is mapped, 
	 * or null if this map contains no mapping for the key.
	 */
	public Object get(String key) {
		LinkedList<Slot> bucket = bucketList.get(getHashIndex(key));
		if(bucket == null) return "NOT FOUND";
		for(Slot slot : bucket) {
			if(slot.getKey().equals(key)) return slot.getValue();
		}
		
		return "NOT FOUND";
	}
	
	public String remove(String key) {
		int hashIndex = getHashIndex(key);
		LinkedList<Slot> bucket = bucketList.get(hashIndex);
		
		if(bucket == null) return "NOT FOUND";
		
		Slot slot = getSlot(bucket, key);		
		if(slot == null) return "NOT FOUND";
		else{			
			bucket.remove(slot);
			return (String) slot.getValue();			
		}
			
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public boolean contains(String key) {
		int hashIndex = getHashIndex(key);
		LinkedList<Slot> bucket = bucketList.get(hashIndex);
		if(getSlot(bucket, key) == null) return true;
		else return false;
	}
	
	public String toString() {
		Iterator<Slot> bucket;
		StringBuffer sbuf = new StringBuffer();
		Slot slot;
		for(int i=0; i<bucketList.size(); i++){
			if(bucketList.get(i) != null){
				bucket = bucketList.get(i).iterator();
				while(bucket.hasNext()){
					slot = bucket.next();
					sbuf.append("{" + slot.getKey() + ":" + slot.getValue() + "}, ");
				}
				sbuf.append("\n");
			}		
		}
		return sbuf.toString();
	}
	
	
	
	

	
	
	
	
}
