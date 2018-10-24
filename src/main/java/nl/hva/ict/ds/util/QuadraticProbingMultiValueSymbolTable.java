package nl.hva.ict.ds.util;

import java.util.ArrayList;
import nl.hva.ict.ds.Player;

import java.util.List;

public class QuadraticProbingMultiValueSymbolTable implements MultiValueSymbolTable<String, Player> {

    private int size;
    private String[] keys;
    private Player[] vals;

    public QuadraticProbingMultiValueSymbolTable(int arraySize) {
        this​.size = arraySize;
        this​.keys = (String[])  new​ String[size];
        this​.vals = (Player[])  new​ Player[size];
    }

    private int hash(String key) {
        return (key.hashCode() & 0x7fffffff )% size;
    }

    @Override
    public void put(String key, Player value) {
        int i;
        int j = 1;
         for​ (i = hash(key); keys[i] != null​; i = j * j++ % size) {
             if​ (keys[i].equals(key)) {
                vals[i] = value;
                return;
            }
            //GenerateStudents.collisions++;
        }
        keys[i] = key;
        vals[i] = value;
    }

    @Override
    public List<Player> get(String key) {
        List<Player> players = new ArrayList<>();
         int​  j = 1;
        for ( int​  i = hash(key); keys[i] != null​; i = j * j++ % size) {
             if​ (keys[i].equals(key)) {
                players.add(vals[i]);
            }
        }

        return players;
    }
}
