package org.kohsuke.randname;

/**
 * Generates random unique names
 */
public class RandomNameGenerator {
    private int pos;

    public RandomNameGenerator(int seed) {
        this.pos = seed;
    }

    public String next() {
        Dictionary d = Dictionary.INSTANCE;
        pos = Math.abs(pos+d.getPrime()) % d.size();
        return d.word(pos);
    }
}
