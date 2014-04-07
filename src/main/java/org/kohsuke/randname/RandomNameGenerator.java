package org.kohsuke.randname;

/**
 * Generates pseudo random unique names that combines one adjective and one noun,
 * like "friendly tiger" or "good apple".
 *
 * There's about 1.5 million unique combinations, and if you keep requesting a new word
 * it will start to loop (but this code will generate all unique combinations before it starts
 * to loop.)
 *
 * @author Kohsuke Kawaguchi
 */
public class RandomNameGenerator {
    private int pos;

    public RandomNameGenerator(int seed) {
        this.pos = seed;
    }

    public RandomNameGenerator() {
        this((int) System.currentTimeMillis());
    } 
    public synchronized String next() {
        Dictionary d = Dictionary.INSTANCE;
        pos = Math.abs(pos+d.getPrime()) % d.size();
        return d.word(pos);
    }
}
