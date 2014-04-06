package org.kohsuke.randname;

import org.junit.Test;

/**
 * @author Kohsuke Kawaguchi
 */
public class DictionaryTest {
    @Test
    public void size() {
        Dictionary d = new Dictionary();
        System.out.println(d.size());
    }
}
