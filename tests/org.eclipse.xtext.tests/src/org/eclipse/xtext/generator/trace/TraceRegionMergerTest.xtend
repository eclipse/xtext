/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace

import java.util.List
import java.util.Queue
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class TraceRegionMergerTest {

	@Test
	def testSingleFile() {
		traceTo('foo') [
			region(2, 6, 1, 3) [
				region(2, 2, 1, 2)
				region(4, 2, 2, 2)
			]
		]
		.assertMerged[
			region(2, 6, 1, 3) [
				region(2, 2, 1, 2, 'foo')
				region(4, 2, 2, 2, 'foo')
				region(6, 2, 2, 3, 'foo')
			]
		]
	}
	
	@Test 
	def testSame() {
		/*
		 * 0: 0n
		 * 1: 2n
		 */
		traceTo('foo') [
			region(0, 4, 0, 2) [
				region(0, 2, 0, 1)
				region(2, 2, 1, 2)
			]
		]
		.traceTo('bar') [
			region(0, 4, 0, 2) [
				region(0, 2, 0, 1)
				region(2, 2, 1, 2)
			]
		]
		.assertMerged[
			region(0, 4, 0, 2) [
				region(0, 2, 0, 1, 'foo', 'bar')
				region(2, 2, 1, 2, 'foo', 'bar')
			] 
		]
	}

	@Test 
	def testDisjunctive() {
		/*
		 * 0: 0n
		 * 1: 2n
		 */
		traceTo('foo') [
			region(0, 2, 0, 1) [
				region(0, 2, 0, 1)
			]
		]
		.traceTo('bar') [
			region(2, 2, 1, 2) [
				region(2, 2, 1, 2)
			]
		]
		.assertMerged[
			region(0, 4, 0, 2) [
				region(0, 2, 0, 1, 'foo')
				region(2, 2, 1, 2, 'bar')
			] 
		]
	}

	@Test 
	def testOneInCommon() {
		/*
		 * 0: 0n
		 * 1: 2n
		 */
		traceTo('foo') [
			region(0, 4, 0, 2) [
				region(0, 2, 0, 1)
				region(2, 2, 1, 2)
			]
		]
		.traceTo('bar') [
			region(2, 2, 1, 2) [
				region(2, 2, 1, 2)
			]
		]
		.assertMerged[
			region(0, 4, 0, 2) [
				region(0, 2, 0, 1, 'foo')
				region(2, 2, 1, 2, 'foo', 'bar')
			] 
		]
	}

	@Test
	def testSplit() {
		/*
		 * 0: 0n
		 * 1: 2n
		 * 2: 456n
		 */
		traceTo('foo') [
			region(2, 6, 1, 3) [
				region(2, 2, 1, 2)
				region(4, 2, 2, 2)
			]
		]
		.traceTo('bar') [
			region(0, 3, 0, 1)
		]
		.assertMerged [
			region(0, 8, 0, 3) [
				region(0, 2, 0, 1, 'bar')
				region(2, 1, 1, 1, 'foo', 'bar')
				region(3, 1, 1, 2, 'foo')
				region(4, 2, 2, 2, 'foo')
				region(6, 2, 2, 3, 'foo')
			]
		]
	}
	
	@Test
	def testContainedSplitBeforeNewline() {
		/*
		 * 0: 01n
		 * 1: 34n
		 */
		traceTo('foo') [
			region(0, 6, 0, 2)
		]
		.traceTo('bar') [
			region(2, 2, 0, 1)
		]
		.assertMerged [
			region(0, 6, 0, 2) [
				region(0, 2, 0, 0, 'foo')
				region(2, 2, 0, 1, 'foo', 'bar')
				region(4, 2, 1, 2, 'foo')
			]
		]
	}
	
	@Test
	def testContainedSplitAfterNewline() {
		/*
		 * 0: 01n
		 * 1: 34n
		 */
		traceTo('foo') [
			region(0, 6, 0, 2)
		]
		.traceTo('bar') [
			region(3, 2, 1, 1)
		]
		.assertMerged [
			region(0, 6, 0, 2) [
				region(0, 3, 0, 1, 'foo')
				region(3, 2, 1, 1, 'foo', 'bar')
				region(5, 1, 1, 2, 'foo')
			]
		]
	}
	
	@Test
	def testOverlapSplitBeforeNewline() {
		/*
		 * 0: 01n
		 * 1: 34n
		 */
		traceTo('foo') [
			region(0, 4, 0, 1)
		]
		.traceTo('bar') [
			region(2, 4, 0, 2)
		]
		.assertMerged [
			region(0, 6, 0, 2) [
				region(0, 2, 0, 0, 'foo')
				region(2, 2, 0, 1, 'foo', 'bar')
				region(4, 2, 1, 2, 'bar')
			]
		]
	}
	
	@Test
	def testOverlapSplitAfterNewline() {
		/*
		 * 0: 01n
		 * 1: 34n
		 */
		traceTo('foo') [
			region(0, 4, 0, 1)
		]
		.traceTo('bar') [
			region(3, 3, 1, 2)
		]
		.assertMerged [
			region(0, 6, 0, 2) [
				region(0, 3, 0, 1, 'foo')
				region(3, 1, 1, 1, 'foo', 'bar')
				region(4, 2, 1, 2, 'bar')
			]
		]
	}

	@Test	
	def testOverlapChain_SplitAfterNewline() {
		/*
		 * 0: 01n
		 * 1: 34n
		 * 2: 67n
		 */
		traceTo('foo') [
			region(0, 9, 0, 3) [
				region(0, 3, 0, 1)
				region(3, 3, 1, 2)
				region(6, 3, 2, 3)
			]
		]
		.traceTo('bar') [
			region(1, 6, 0, 2) [
				region(1, 3, 0, 1)
				region(4, 3, 1, 2)
			]
		]
		.assertMerged [
			region(0, 9, 0, 3) [
				region(0, 1, 0, 0, 'foo')
				region(1, 2, 0, 1, 'foo', 'bar')
				region(3, 1, 1, 1, 'foo', 'bar')
				region(4, 2, 1, 2, 'foo', 'bar')
				region(6, 1, 2, 2, 'foo', 'bar')
				region(7, 2, 2, 3, 'foo')
			]
		]
	}
	
	@Test	
	def testOverlapChain_SplitBeforeNewline() {
		/*
		 * 0: 01n
		 * 1: 34n
		 * 2: 67n
		 */
		traceTo('foo') [
			region(0, 9, 0, 3) [
				region(0, 3, 0, 1)
				region(3, 3, 1, 2)
				region(6, 3, 2, 3)
			]
		]
		.traceTo('bar') [
			region(2, 6, 0, 2) [
				region(2, 3, 0, 1)
				region(5, 3, 1, 2)
			]
		]
		.assertMerged [
			region(0, 9, 0, 3) [
				region(0, 2, 0, 0, 'foo')
				region(2, 1, 0, 1, 'foo', 'bar')
				region(3, 2, 1, 1, 'foo', 'bar')
				region(5, 1, 1, 2, 'foo', 'bar')
				region(6, 2, 2, 2, 'foo', 'bar')
				region(8, 1, 2, 3, 'foo')
			]
		]
	}
	
	@Test	
	def testThree() {
		/*
		 * 01n
		 * 34n
		 * 67n
		 */
		traceTo('foo') [
			region(0, 9, 0, 3) [
				region(0, 3, 0, 1)
				region(3, 3, 1, 2)
				region(6, 3, 2, 3)
			]
		]
		.traceTo('bar') [
			region(1, 6, 0, 2) [
				region(1, 3, 0, 1)
				region(4, 3, 1, 2)
			]
		]
		.traceTo('baz') [
			region(2, 6, 0, 2) [
				region(2, 3, 0, 1)
				region(5, 3, 1, 2)
			]
		]
		.assertMerged [
			region(0, 9, 0, 3) [
				region(0, 1, 0, 0, 'foo')
				region(1, 1, 0, 0, 'foo', 'bar')
				region(2, 1, 0, 1, 'foo', 'bar', 'baz')
				region(3, 1, 1, 1, 'foo', 'bar', 'baz')
				region(4, 1, 1, 1, 'foo', 'bar', 'baz')
				region(5, 1, 1, 2, 'foo', 'bar', 'baz')
				region(6, 1, 2, 2, 'foo', 'bar', 'baz')
				region(7, 1, 2, 2, 'foo', 'baz')
				region(8, 1, 2, 3, 'foo')
			]
		]
	}
	
	
	
	def traceTo(String uri, (TraceBuilder)=>AbstractTraceRegion init) {
		new TestBuilder().traceTo(uri, init)
	}

	@Accessors
	static class TestBuilder {
		List<AbstractTraceRegion> roots = newArrayList
		
		def TestBuilder traceTo(String uri, (TraceBuilder)=>AbstractTraceRegion init) {
			val traceBuilder = new TraceBuilder(this, uri)
			roots.add(init.apply(traceBuilder))
			this
		} 
		
		def void assertMerged((AssertBuilder)=>void init) {
			val mergedRoot = new TraceRegionMerger().mergeTraceRegions(roots)
			assertNotNull(mergedRoot)
			val assertBuilder = new AssertBuilder(this, newLinkedList(mergedRoot))
			init.apply(assertBuilder)
			assertBuilder.thatsIt
		}
	} 

	@FinalFieldsConstructor
	static class TraceBuilder {
		
		val TestBuilder testBuilder
		val SourceRelativeURI uri
		val AbstractTraceRegion root

		new(TestBuilder testBuilder, String uri) {
			this(testBuilder, new SourceRelativeURI(URI.createURI(uri)), null)
		}

		def AbstractTraceRegion region(int offset, int length, int startLine, int endLine) {
			region(offset, length, startLine, endLine, null)
		}
		
		def AbstractTraceRegion region(int offset, int length, int startLine, int endLine, (TraceBuilder)=>void init) {
			val root = new TraceRegion(offset, length, startLine, endLine, true, 0,0,0,0, root, uri)
			if (init != null) {
				val child = new TraceBuilder(testBuilder, uri, root)
				init.apply(child)
			}
			root
		}
	}
	
	@FinalFieldsConstructor
	static class AssertBuilder {

		val TestBuilder testBuilder
		val Queue<AbstractTraceRegion> regions

		def region(int offset, int length, int startLine, int endLine, String... uris) {
			region(offset, length, startLine, endLine, uris, null)
		}
		
		def region(int offset, int length, int startLine, int endLine, String uri, (AssertBuilder)=>void init) {
				region(offset, length, startLine, endLine, #[uri], null)
		}
		
		def region(int offset, int length, int startLine, int endLine, (AssertBuilder)=>void init) {
				region(offset, length, startLine, endLine, #[], init)
		}
		
		def region(int offset, int length, int startLine, int endLine, List<String> uris, (AssertBuilder)=>void init) {
			val head = regions.poll
			assertEquals(head.toString, offset, head.myOffset)
			assertEquals(head.toString, length, head.myLength)
			assertEquals(head.toString, startLine, head.myLineNumber)
			assertEquals(head.toString, endLine, head.myEndLineNumber)
			val associatedLocations = head.associatedLocations.map[srcRelativePath].toSet
			assertEquals(head.toString, uris.length, associatedLocations.length)
			for(uri: uris) {
				assertTrue('Missing ' + uri, associatedLocations.contains(new SourceRelativeURI(URI.createURI(uri))))
			}
			if(init == null) {
				assertTrue(head.nestedRegions.empty)
			} else {
				val child = new AssertBuilder(testBuilder, newLinkedList(head.nestedRegions))
				init.apply(child)
				child.thatsIt
			}
			this
		}	
		
		def thatsIt() {
			assertTrue(regions.toString, regions.empty)
		}
	}
}