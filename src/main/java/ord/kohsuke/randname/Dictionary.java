package ord.kohsuke.randname;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kohsuke Kawaguchi
 */
public class Dictionary {
    private List<String> nouns = new ArrayList<String>();
    private List<String> adjectives = new ArrayList<String>();

    /**
     * Sufficiently big prime that's bigger than nouns*adjectives
     */
    private final int prime;

    public Dictionary() throws IOException {
        load("a.txt", adjectives);
        load("n.txt", nouns);
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

    private void load(String name, List<String> col) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(name),"US-ASCII"));
        String line;
        while ((line=r.readLine())!=null)
            col.add(line);
    }
}
