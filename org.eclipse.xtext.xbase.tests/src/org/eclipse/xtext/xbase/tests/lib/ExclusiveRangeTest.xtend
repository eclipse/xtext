package org.eclipse.xtext.xbase.tests.lib

import org.junit.Test
import static org.junit.Assert.*

/** 
 * @author Jan Koehnlein
 */
class ExclusiveRangeTest {
	
	@Test
	def testContent() {
		 assertEquals("1,2,3,4", new ExclusiveRange(1, 5, true).join(","))
		 assertEquals("", new ExclusiveRange(0, 0, true).join(","))
		 assertEquals("", new ExclusiveRange(0, -1, true).join(","))
		 assertEquals("-1", new ExclusiveRange(-1, 0, true).join(","))
		 assertEquals("4,3,2,1", new ExclusiveRange(5, 1, false).join(","))
		 assertEquals("", new ExclusiveRange(0, 0, false).join(","))
		 assertEquals("", new ExclusiveRange(-1, 0, false).join(","))
		 assertEquals("-1", new ExclusiveRange(0, -1, false).join(","))
	}
	
	@Test
	def testSize() {
		 assertEquals(4, new ExclusiveRange(1, 5, true).size())
		 assertEquals(0, new ExclusiveRange(0, 0, true).size())
		 assertEquals(0, new ExclusiveRange(0, -1, true).size())
		 assertEquals(1, new ExclusiveRange(-1, 0, true).size())
		 assertEquals(4, new ExclusiveRange(5, 1, false).size())
		 assertEquals(0, new ExclusiveRange(0, 0, false).size())
		 assertEquals(0, new ExclusiveRange(-1, 0, false).size())
		 assertEquals(1, new ExclusiveRange(0, -1, false).size())
	}
	
	@Test
	def testIsEmpty() {
		 assertFalse(new ExclusiveRange(1, 5, true).isEmpty())
		 assertTrue(new ExclusiveRange(0, 0, true).isEmpty())
		 assertTrue(new ExclusiveRange(0, -1, true).isEmpty())
		 assertFalse(new ExclusiveRange(-1, 0, true).isEmpty())
		 assertFalse(new ExclusiveRange(5, 1, false).isEmpty())
		 assertTrue(new ExclusiveRange(0, 0, false).isEmpty())
		 assertTrue(new ExclusiveRange(-1, 0, false).isEmpty())
		 assertFalse(new ExclusiveRange(0, -1, false).isEmpty())
	}
	
	@Test
	def testContains() {
		 assertFalse(new ExclusiveRange(1, 5, true).contains(0))
		 assertTrue(new ExclusiveRange(1, 5, true).contains(1))
		 assertTrue(new ExclusiveRange(1, 5, true).contains(2))
		 assertTrue(new ExclusiveRange(1, 5, true).contains(3))
		 assertTrue(new ExclusiveRange(1, 5, true).contains(4))
		 assertFalse(new ExclusiveRange(1, 5, true).contains(5))
		 
		 assertFalse(new ExclusiveRange(0, 0, true).contains(0))
		 
		 assertFalse(new ExclusiveRange(0, -1, true).contains(0))
		 assertFalse(new ExclusiveRange(0, -1, true).contains(-1))
		 
		 assertFalse(new ExclusiveRange(-1, 0, true).contains(-2))
		 assertTrue(new ExclusiveRange(-1, 0, true).contains(-1))
		 assertFalse(new ExclusiveRange(-1, 0, true).contains(-0))
		 
		 assertFalse(new ExclusiveRange(5, 1, false).contains(0))
		 assertTrue(new ExclusiveRange(5, 1, false).contains(1))
		 assertTrue(new ExclusiveRange(5, 1, false).contains(2))
		 assertTrue(new ExclusiveRange(5, 1, false).contains(3))
		 assertTrue(new ExclusiveRange(5, 1, false).contains(4))
		 assertFalse(new ExclusiveRange(5, 1, false).contains(5))
		 
		 assertFalse(new ExclusiveRange(0, 0, false).contains(0))
		 
		 assertFalse(new ExclusiveRange(-1, 0, false).contains(0))
		 assertFalse(new ExclusiveRange(-1, 0, false).contains(-1))
		 
		 assertFalse(new ExclusiveRange(0, -1, false).contains(-2))
		 assertTrue(new ExclusiveRange(0, -1, false).contains(-1))
		 assertFalse(new ExclusiveRange(0, -1, false).contains(-0))
	}
}