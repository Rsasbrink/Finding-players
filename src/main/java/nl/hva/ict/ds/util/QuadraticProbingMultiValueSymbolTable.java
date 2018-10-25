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

    private int hash(String string) {
        return (string.hashCode() & 0x7fffffff) % size;
    }

    @Override
    public void put(String key, Player val) {
        int hashValue = hash(key);
        int j = 1;
        while (keys[hashValue] != null) {
            this.collisions++;
            hashValue = (j * (j++)) % size;
            if (hashValue < 0 || hashValue > size) {
                hashValue = hash(key);
            }

        }

        keys[hashValue] = key;
        vals[hashValue] = val;

    }

    @Override
    public List<Player> get(String key) {
        List<Player> players = new ArrayList<>();
        int j = 1;
        int i = hash(key);
        while (i > 0 && i < size) {
             if​ (keys[i].equals(key)) {
                if (!players.contains(vals[i])) {
                    players.add(vals[i]);
                }
            }
            i = j * j++ % size;
        }

        return players;
    }

    public void printHashTable() {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < size; i++) {
            if (keys[i] != null) {
                System.out.println(i + ": " + keys[i] + " " + vals[i].getFirstName());
            }
        }
        System.out.println();
    }

    @Override
    public int collissions() {
        return this.collisions;
    }
}
