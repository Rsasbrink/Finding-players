package nl.hva.ict.ds.util;

import java.util.ArrayList;
import nl.hva.ict.ds.Player;

import java.util.List;

public class DoubleHashingMultiValueSymbolTable implements MultiValueSymbolTable<String, Player> {

    private int size;
    private String[] keys;
    private Player[] vals;
    private final int PRIME = 2;
    private int collissions;

    public DoubleHashingMultiValueSymbolTable(int arraySize) {
        this.collissions = 0;
        this.size = arraySize;
        this.keys = (String[])  new​ String[arraySize];
        this.vals = (Player[])  new​ Player[arraySize];
    }

    private int hash(String string) {
        return (string.hashCode() & 0x7fffffff) % size;
    }

    private int hashPrime(String string) {
         return​ (PRIME - (string.hashCode() % PRIME));
    }

    @Override
    public void put(String key, Player value) {
        int hashValue = hash(key);
        int stepSize = hashPrime(key);

        while (vals[hashValue] != null) {
            this.collissions++;
            hashValue += stepSize;
            hashValue = hashValue % size;
        }
        keys[hashValue] = key;
        vals[hashValue] = value;
    }

    @Override
    public List<Player> get(String key) {
        List<Player> players = new ArrayList<>();
        int hashValue = hash(key);
        int stepSize = hashPrime(key);

        while (keys[hashValue] != null) {
            if (keys[hashValue].equals(key)) {
                players.add(vals[hashValue]);
            }
            hashValue = hashValue + stepSize;
            hashValue = hashValue % size;
        }
        return players;
    }

    @Override
    public int collisions() {
        return this.collissions;
    }
}
