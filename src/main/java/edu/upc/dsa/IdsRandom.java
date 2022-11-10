package edu.upc.dsa;

import java.util.UUID;

public class IdsRandom {
    public static String getId() {
        return UUID.randomUUID().toString();
    }

}
