package nl.hva.ict.ds.util;

import java.util.ArrayList;
import nl.hva.ict.ds.Player;

import java.util.List;

public class QuadraticProbingMultiValueSymbolTable implements MultiValueSymbolTable<String, Player> {

    int collisions;
    private int size;
    private String[] keys;
    private Player[] vals;

    public QuadraticProbingMultiValueSymbolTable(int arraySize) {
        this.collisions = 0;
        this​.size = arraySize;
        this​.keys = (String[])  new​ String[size];
        this​.vals = (Player[])  new​ Player[size];
    }

    public int getCollisions() {
        return collisions;
    }

    private int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }

    public void put(String key, Player val) {
        int i;
        int j = 1;
        for (i = hash(key); keys[i] != null​; i = j * j++ % size) {
             if​ (keys[i].equals(key)) {
                vals[i] = val;
                printHashTable();

                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        printHashTable();

    }

    @Override
    public List<Player> get(String key) {
        List<Player> players = new ArrayList<>();
        int i = hash(key), h = 1;
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                players.add(vals[i]);
            }
            i = (i + h * h++) % size;

        }

        return players;
    }

    public void printHashTable() {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < size; i++) {
            if (keys[i] != null) {
                System.out.println(keys[i] + i + " " + vals[i].getFirstName());
            }
        }
        System.out.println();
    }
}
