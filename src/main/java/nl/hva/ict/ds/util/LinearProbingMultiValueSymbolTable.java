package nl.hva.ict.ds.util;

import java.util.ArrayList;
import nl.hva.ict.ds.Player;

import java.util.List;

public class LinearProbingMultiValueSymbolTable implements MultiValueSymbolTable<String, Player> {

    private int size;
    private String[] keys;
    private Player[] vals;
    int collisions;

    public LinearProbingMultiValueSymbolTable(int arraySize) {
        this.collisions = 0;
        this.size = arraySize;
        this.keys = (String[])  new​ String[arraySize];
        this.vals = (Player[])  new​ Player[arraySize];
    }

    public int getCollisions() {
        return collisions;
    }

    private int hash(String string) {
        return (string.hashCode() & 0x7fffffff) % size;
    }

    @Override
    public void put(String key, Player value) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % size) {
             if​ (vals[i].equals(value)) {
                vals[i] = value;
                return;
            }
            this.collisions++;
        }
        keys[i] = key;
        vals[i] = value;
    }

    @Override
    public List<Player> get(String key) {
        List<Player> players = new ArrayList<>();
        for (int i = hash(key); vals[i] != null​; i = (i + 1) % size) {
             if​ (keys[i].equals(key)) {
                players.add(vals[i]);
            }
        }
         return​ players;
    }

    @Override
    public int collissions() {
        return this.collisions;
    }
}
