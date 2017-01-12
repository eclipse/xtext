/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal

import com.google.common.base.Functions
import java.util.List
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment
import org.eclipse.xtext.formatting2.regionaccess.internal.TextSegment
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class RegionSetTest {

	def private void test(CharSequence expectation, (TestableTextSegmentSet)=>void test) {
		val set = new TestableTextSegmentSet(new ArrayListTextSegmentSet(Functions.identity, Functions.toStringFunction, true))
		try {
			test.apply(set)
		} catch (Throwable t) {
			t.printStackTrace
			fail()
		}
		assertEquals(expectation.toString, set.toString)
	}

	@Test def void testAddValid() {
		'''
			issues=
			set=[[10,0], [10,1], [11,1], [12,1], [99,1], [100,0]]
		'''.test [
			add(new TextSegment(null, 10, 0))
			add(new TextSegment(null, 11, 1))
			add(new TextSegment(null, 99, 1))
			add(new TextSegment(null, 10, 1))
			add(new TextSegment(null, 100, 0))
			add(new TextSegment(null, 12, 1))
		]
	}

	@Test def void testNoMergeConflic1() {
		'''
			issues=
			set=[[20,0], [20,1]]
		'''.test [
			add(new TextSegment(null, 20, 0))
			add(new TextSegment(null, 20, 1))
		]
	}

	@Test def void testNoMergeConflic2() {
		'''
			issues=
			set=[[20,0], [20,1]]
		'''.test [
			add(new TextSegment(null, 20, 1))
			add(new TextSegment(null, 20, 0))
		]
	}

	@Test def void testMergeConflic1() {
		'''
			issues=mergeConflict:[20,0]<>[20,0]
			set=[]
		'''.test [
			add(new TextSegment(null, 20, 0))
			add(new TextSegment(null, 20, 0))
		]
	}

	@Test def void testMergeConflic2() {
		'''
			issues=mergeConflict:[21,0]<>[20,2]
			set=[[20,2]]
		'''.test [
			add(new TextSegment(null, 20, 2))
			add(new TextSegment(null, 21, 0))
		]
	}

	@Test def void testMergeConflic3() {
		'''
			issues=mergeConflict:[20,2]<>[21,0]
			set=[[20,2]]
		'''.test [
			add(new TextSegment(null, 21, 0))
			add(new TextSegment(null, 20, 2))
		]
	}

	@Test def void testMergeConflic4() {
		'''
			issues=mergeConflict:[20,2]<>[21,5]
			set=[[21,5]]
		'''.test [
			add(new TextSegment(null, 21, 5))
			add(new TextSegment(null, 20, 2))
		]
	}

	@Test def void testMergeConflic5() {
		'''
			issues=mergeConflict:[20,2]<>[21,5]
			set=[[21,5]]
		'''.test [
			add(new TextSegment(null, 21, 5))
			add(new TextSegment(null, 20, 2))
		]
	}
}

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@FinalFieldsConstructor class TestableTextSegmentSet {
	val List<String> issues = newArrayList
	val TextSegmentSet<ITextSegment> set

	def private String fmt(ITextSegment region) {
		'''[«region.offset»,«region.length»]'''
	}

	override toString() '''
		issues=«issues.join(", ")»
		set=«set.map['''[«offset»,«length»]'''].toString.replace("\n", ", ")»
	'''

	def void add(ITextSegment segment) {
		try {
			set.add(segment)
		} catch (ConflictingRegionsException e) {
			val conflicting = e.traces.map[it.region]
			issues += '''mergeConflict:«conflicting.map[fmt].join("<>")»'''
		}
	}
}
