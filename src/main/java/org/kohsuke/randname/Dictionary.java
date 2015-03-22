package org.kohsuke.randname;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Dictionary of adjectives and nouns.
 *
 * @author Kohsuke Kawaguchi
 */
public class Dictionary {
    private List<String> nouns = new ArrayList<String>();
    private List<String> adjectives = new ArrayList<String>();

    private final int prime;

    public Dictionary() {
        try {
            load("a.txt", adjectives);
            load("n.txt", nouns);
        } catch (IOException e) {
            throw new Error(e);
        }

        int combo = size();

        int primeCombo = 2;
        while (primeCombo<=combo) {
            int nextPrime = primeCombo+1;
            primeCombo *= nextPrime;
        }
        prime = primeCombo+1;
    }

    /**
     * Total size of the combined words.
     */
    public int size() {
        return nouns.size()*adjectives.size();
    }

    /**
     * Sufficiently big prime that's bigger than {@link #size()}
     */
    public int getPrime() {
        return prime;
    }

    public String word(int i) {
        int a = i%adjectives.size();
        int n = i/adjectives.size();

        return adjectives.get(a)+"_"+nouns.get(n);
    }

    private void load(String name, List<String> col) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(name),"US-ASCII"));
        try {
            String line;
            while ((line=r.readLine())!=null)
                col.add(line);
        } finally {
            r.close();
        }
    }

    static final Dictionary INSTANCE = new Dictionary();
}
