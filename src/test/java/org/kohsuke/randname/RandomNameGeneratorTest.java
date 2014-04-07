package org.kohsuke.randname;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kohsuke Kawaguchi
 */
public class RandomNameGeneratorTest extends Assert {
    RandomNameGenerator r = new RandomNameGenerator(0);

    /**
     * We can generate up to {@link Dictionary#size()} unique combinations.
     */
    @Test
    public void uniqueness() {
        int sz = Dictionary.INSTANCE.size();
        Set<String> s = new HashSet<String>(sz);

        for (int i=0; i<sz; i++)
            assertTrue(s.add(r.next()));

        assertFalse(s.add(r.next()));
    }

    @Test
    public void firstTen() {
        for (int i=0; i<10; i++)
            System.out.println(r.next());
    }
}
