package org.eclipse.xtext.util;

import java.util.Arrays;
import java.util.Iterator;

import junit.framework.TestCase;

public class ChainedIteratorTest extends TestCase {
	
	public void testSimple() throws Exception {
		ChainedIterator<String> iter = new ChainedIterator<String>(new ChainedIterator<String>(iter("a","b"),iter("c")),iter("d"));
		assertEquals("abcd",concat(iter));
	}
	
	public void testSecondArgNull() throws Exception {
		ChainedIterator<String> iter = new ChainedIterator<String>(new ChainedIterator<String>(iter("a","b"),null),null);
		assertEquals("ab",concat(iter));
	}
	
	public void testFirstArgNull() throws Exception {
		try {
			new ChainedIterator<String>(null,null);
			fail("nullpointer exception expected");
		} catch (NullPointerException npe){
			//expected
		}
	}
	
	private String concat(Iterator<String> iter) {
		String r = "";
		while (iter.hasNext())
			r+=iter.next();
		return r;
	}

	private Iterator<String> iter(String ... elements) {
		return Arrays.asList(elements).iterator();
	}
}
