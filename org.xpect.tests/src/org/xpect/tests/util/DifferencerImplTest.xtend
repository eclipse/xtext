package org.xpect.tests.util;

import java.util.List
import org.junit.Test
import org.xpect.util.DifferencerImpl
import org.junit.Assert
import com.google.common.collect.Sets
import org.junit.Ignore

class DifferencerImplTest {

	def private diff(List<String> left, List<String> right) {
		val diff = new DifferencerImpl().diff(left, right,
			[ s1, s2 |
				val set1 = s1.toCharArray.toSet
				val set2 = s2.toCharArray.toSet
				val overlap = Sets.intersection(set1, set2).size as float
				val size = Math.max(set1.size, set2.size) as float
				return 1 - overlap / size
			])
		return diff.join("\n")
	}

	@Test def void testOneMatch() {
		'''
			[0==0]
		''' === diff(#["A"], #["A"])
	}

	@Test def void testTwoMatches() {
		'''
			[0==0]
			[1==1]
		''' === diff(#["A", "B"], #["A", "B"])
	}

	@Test def void testThreeMatches() {
		'''
			[0==0]
			[1==1]
			[2==2]
		''' === diff(#["A", "B", "C"], #["A", "B", "C"])
	}

	@Test def void testInsertRightBeginning() {
		'''
			[---0]
			[0==1]
			[1==2]
		''' === diff(#["B", "C"], #["A", "B", "C"])
	}

	@Test def void testInsertRightMiddle() {
		'''
			[0==0]
			[---1]
			[1==2]
		''' === diff(#["A", "C"], #["A", "B", "C"])
	}

	@Test def void testInsertRightEnd() {
		'''
			[0==0]
			[1==1]
			[---2]
		''' === diff(#["A", "B"], #["A", "B", "C"])
	}

	@Test @Ignore def void testRemoveMiddle() {
		'''
			[0==0]
			[1---]
			[2---]
			[3---]
			[4==1]
		''' === diff(#["A", "B", "B", "B", "C"], #["A", "C"])
	}

	def operator_tripleEquals(Object o1, Object o2) {
		Assert.assertEquals(o1.toString.trim, o2.toString.trim)
	}
}
