package org.blottn.lca;

import org.junit.Test;
import org.junit.Assert;

public class LCATest {

    @Test
    public void testThing() {
        Assert.assertTrue("Whoops what a surprise that failed", true);
    }

    @Test
    public void testLCA() {
        LCAFinder finder = new LCAFinder();
        finder.findFor(2,6);
        finder.findFor(0,0);
        finder.findFor(1,0);
    }
    

}
