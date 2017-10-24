package org.blottn.lca;

import org.junit.Test;
import org.junit.Assert;

public class LCATest {

    // LCA is a symmetric operation so we have to ensure it works regardless of the parameter ordering

    @Test
    public void testLCA() {
        int root = 5;
        LCAFinder finder = new LCAFinder(root);

        finder.setLeft(5,2);    //setting up the tree
        finder.setRight(5,6);
        finder.setRight(6,0);

        Assert.assertEquals("Root case failed for lca", 5, finder.lca(2,6));    //standard test
        Assert.assertEquals("Root case failed for lca", 5, finder.lca(6,2));    //test with parameters swapped to ensure symmetry

        Assert.assertEquals("Case for identical values failed for lca", 0, finder.lca(0,0));    //test for when both parameters are the same

        Assert.assertEquals("Case for non-existent node failed", LCAFinder.NONE, finder.lca(1,0));    //test for non-existent node
        Assert.assertEquals("Case for non-existent node failed", LCAFinder.NONE, finder.lca(0,1));    //test with parameters swapped to ensure symmetry
    }

    @Test
    public void testTreeCreation() {
        for (int i = 0; i < 1000; i++) {
            LCAFinder finder = new LCAFinder(i);
            Assert.assertEquals("Didn't return correct root", i, finder.getRoot());
        }

        //getRight and setRight checks, if either setRight or getRight are broken these tests should fail

        //test for no righthand value
        int root = 10;
        LCAFinder finder = new LCAFinder(root);
        Assert.assertEquals("Didn't return error response for no righthand value",LCAFinder.NONE, finder.getRight(10));

        //test for correct righthand value "shallow" in tree
        int rightValue = 12;
        finder.setRight(root,rightValue);
        Assert.assertEquals("Didn't return correct righthand value for shallow key",rightValue, finder.getRight(root));

        //test for correct righthand value "deep" in tree

        int someMiddleValue = 56;   //Build in some arbitrary branching in the tree
        finder.setLeft(12,56);
        int someOtherRightValue = 25;
        finder.setRight(someMiddleValue, someOtherRightValue);
        Assert.assertEquals("Didn't return correct righthand value for deep key",someOtherRightValue, finder.getRight(someMiddleValue));


        //getLeft and setLeft checks, if either setLeft or getLeft are broken these tests should fail

        //test for no lefthand value
        root = 10;
        finder = new LCAFinder(root);
        Assert.assertEquals("Didn't return error response for no lefthand value",LCAFinder.NONE, finder.getLeft(10));

        //test for correct lefthand value "shallow" in tree
        int leftValue = 12;
        finder.setLeft(root, leftValue);
        Assert.assertEquals("Didn't return correct lefthand value for shallow key",leftValue, finder.getLeft(root));

        //test for correct righthand value "deep" in tree
        someMiddleValue = 56;
        finder.setRight(12,56); //Build in some arbitrary branching in the tree
        int someOtherLeftValue = 25;
        finder.setLeft(someMiddleValue, someOtherLeftValue);
        Assert.assertEquals("Didn't return correct lefthand value for deep key",someOtherLeftValue, finder.getLeft(someMiddleValue));
    }

	@Test
	public void testCyclicTree() {
		int root = 2;
		LCAFinder finder = new LCAFinder(root);

		//Building:
		/*
				2
			   / \
			  1   7
			 / \ / \
            12  6   3
			   /   /
			  5   / 
			   \ /
				0
		*/
		
		finder.setRight(root,7);
		finder.setLeft(root,1);
		finder.setLeft(1,12);
		finder.setRight(1,6);
		finder.setRight(7,3);
		finder.setLeft(7,6);
		finder.setLeft(6,5);
		finder.setRight(5,0);
		finder.setLeft(3,0);
		//Finished construction
		Assert.assertEquals("didn't work for root and itself ",root,finder.lca(root,root));
	}
}
