package com.death.horizon.shopserver.util;

import com.google.common.hash.Hashing;


/**
 * @author dayday
 */
public class HashUtils {
    private HashUtils() {
    }

    public static String hash(String s, String salt, int length) {
        return Hashing.goodFastHash(length).hashUnencodedChars(s + salt).toString();
    }
}
