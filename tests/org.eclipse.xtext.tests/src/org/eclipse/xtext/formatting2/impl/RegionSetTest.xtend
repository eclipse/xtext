/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.impl

import java.util.List
import org.eclipse.xtext.formatting2.FormatterProblemReporter
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.xtext.formatting2.ITextSegment
import java.util.Collection

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class RegionSetTest {

	def private void test(CharSequence expectation, (TextSegmentSet<ITextSegment>)=>void test) {
		val issues = new TestableProblemReporter
		val set = new ArrayListTextSegmentSet(new TextSegment(null, 10, 90), null, issues)
		test.apply(set)
		val actual = '''
			issues=«issues»
			set=[«set.toString.replace("\n", ", ")»]
		'''
		assertEquals(expectation.toString, actual.toString)
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

	@Test def void testLowerBoundOK1() {
		'''
			issues=
			set=[[10,1]]
		'''.test [
			add(new TextSegment(null, 10, 1))
		]
	}

	@Test def void testLowerBoundOK2() {
		'''
			issues=
			set=[[10,0]]
		'''.test [
			add(new TextSegment(null, 10, 0))
		]
	}

	@Test def void testLowerBoundNotOK() {
		'''
			issues=outOfRegion:[9,1]
			set=[]
		'''.test [
			add(new TextSegment(null, 9, 1))
		]
	}

	@Test def void testUpperBoundOK1() {
		'''
			issues=
			set=[[99,1]]
		'''.test [
			add(new TextSegment(null, 99, 1))
		]
	}

	@Test def void testUpperBoundOK2() {
		'''
			issues=
			set=[[100,0]]
		'''.test [
			add(new TextSegment(null, 100, 0))
		]
	}

	@Test def void testUpperBoundNotOK() {
		'''
			issues=outOfRegion:[101,1]
			set=[]
		'''.test [
			add(new TextSegment(null, 101, 1))
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

class TestableProblemReporter extends FormatterProblemReporter {

	val List<String> issues = newArrayList

	def private String fmt(ITextSegment region) {
		'''[«region.offset»,«region.length»]'''
	}

	override reportMergeConflict(TextSegmentSet<? extends ITextSegment> set,
		Collection<? extends ITextSegment> existing) {
		issues += '''mergeConflict:«existing.map[fmt].join("<>")»'''
	}

	override reportOutsideOfRegion(TextSegmentSet<? extends ITextSegment> set, ITextSegment region) {
		issues += '''outOfRegion:«region.fmt»'''
	}

	override toString() {
		issues.join(", ")
	}
}
