package com.cong.hashtable;

import java.lang.reflect.Array;

public class HashTable {

    int size;
    int count;
    HashTableItem[] items;


    public HashTable(int size, int count, HashTableItem[] items) {
        this.size = size;
        this.count = count;
        this.items = items;
    }

    public HashTable() {
        this.size = 53;
        this.count = 0;
        this.items = null;

    }

    HashTable createNewHashTable(){
        HashTable hashTable=new HashTable(53,0, null);
        return hashTable;
    }



    public static HashTableItem addNewItem(String key, String value){
        HashTableItem item = new HashTableItem(key,value);
        return item;
    }

    public int hash(String string, int a, int numBuckets){
        int hash = 0;
        int lengthString = string.length();
        for (int i =0;i<lengthString;i++){
            hash= hash + (int)(string.charAt(i)) * (int)Math.pow(a,lengthString-(i+1));
            hash=hash%numBuckets;
        }
        return hash;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public HashTableItem[] getItems() {
        return items;
    }

    public void setItems(HashTableItem[] items) {
        this.items = items;
    }
}
