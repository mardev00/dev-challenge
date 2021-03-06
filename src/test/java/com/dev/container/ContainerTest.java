package com.dev.container;

import org.junit.Assert;
import org.junit.Test;
import com.dev.container.Container;

public class ContainerTest {

	@Test
	public void testAddContainer() {
		Container<String> c = new Container<>("root");
		Assert.assertEquals(c.root, c);
		
	}
	
	@Test
	public void testAddChildren() {
		Container<String> c = new Container<>("root");
		c.add("child1");
		c.add("child2");
		
		Assert.assertEquals(2, c.children.size());
		for(Container<String> child : c.children) {
			Assert.assertNotNull(c);
		}
		
	}
	
	
	@Test
	public void testGetRoot() {
		Container<String> c = new Container<>("root");
			Assert.assertNotNull(c.getRoot());
			Assert.assertEquals(c, c.getRoot());
		
	}
	
	@Test
	public void testContains() {
		Container<String> c = new Container<>("myData");
			Assert.assertNotNull(c.data);
			Assert.assertEquals("myData", c.data);
		
	}
}
