package com.cong.collisionHandlingPackage;

public class DoubleHashing extends HashFunction {

    public DoubleHashing() {
        super();
    }

    public DoubleHashing(int size) {
        super(size);
    }

    public int getHash(String s, int attempt) {
        int hash_a = genericHash(s, PRIME_1);
        int hash_b = genericHash(s, PRIME_2);
        return (hash_a + (attempt * (hash_b == 0 ? 1 : hash_b))) % numBuckets;
    }
}

