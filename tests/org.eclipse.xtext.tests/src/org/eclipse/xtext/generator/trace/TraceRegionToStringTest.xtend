/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.generator.trace.TraceRegionToStringTester.Location
import org.eclipse.xtext.generator.trace.TraceRegionToStringTester.Region
import org.eclipse.xtext.util.ITextRegion
import org.eclipse.xtext.util.TextRegion
import org.junit.Assert
import org.junit.Test

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class TraceRegionToStringTest {

	@Test def void simple() {
		val tester = new TraceRegionToStringTester
		tester.localText = '''
			foo bar
		'''
		tester.remote1 = '''
			baz buz
		'''
		tester.trace = new Region(1, 2, #[new Location(4, 2, tester.uri1)])
		tester === '''
			-- local1 --- | -- remote1 --
			f[1[oo]1] bar | baz [1[bu]1]z
			-----------------------------
			1: D 1-2 Region -> Location[4,2,remote1]
		'''
	}

	@Test def void oneChild() {
		val tester = new TraceRegionToStringTester
		tester.localText = '''
			foo bar
		'''
		tester.remote1 = '''
			baz buz
		'''
		tester.trace = new Region(0, 7, #[new Location(1, 6, tester.uri1)]) => [
			addChild(1, 6, #[new Location(2, 4)])
		]
		tester === '''
			----- local1 ----- | ----- remote1 -----
			[1[f[2[oo bar]2,1] | b[1[a[2[z bu]2]z]1]
			----------------------------------------
			1: D 0-7 Region -> Location[1,6,remote1] {
			2: D 1-6   Region -> Location[2,4]
			1:       }
		'''
	}

	@Test def void twoIdentical() {
		val tester = new TraceRegionToStringTester
		tester.localText = '''
			foo bar
		'''
		tester.remote1 = '''
			baz buz
		'''
		tester.trace = new Region(0, 7, #[new Location(1, 5, tester.uri1)]) => [
			addChild(0, 7, #[new Location(1, 5)])
		]
		tester === '''
			---- local1 ----- | ---- remote1 ----
			[1,2[foo bar]2,1] | b[1,2[az bu]2,1]z
			-------------------------------------
			1: D 0-7 Region -> Location[1,5,remote1] {
			2: D 0-7   Region -> Location[1,5]
			1:       }
		'''
	}

	@Test def void twoFrame1() {
		val tester = new TraceRegionToStringTester
		tester.localText = '''
			foo bar
		'''
		tester.localFrame = new TextRegion(1, 5)
		tester.remote1 = '''
			baz buz
		'''
		tester.trace = new Region(0, 7, #[new Location(1, 5, tester.uri1)]) => [
			addChild(2, 1, #[new Location(1, 5)])
			addChild(5, 1, #[new Location(1, 5)])
		]
		tester === '''
			---- local1 ----- | ---- remote1 ----
			o[1[o]1] b[2[a]2] | b[1,2[az bu]2,1]z
			-------------------------------------
			1: D 2-1 Region -> Location[1,5]
			2: D 5-1 Region -> Location[1,5]
		'''
	}

	@Test def void twoFrame2() {
		val tester = new TraceRegionToStringTester
		tester.localText = '''
			foo bar
		'''
		tester.localFrame = new TextRegion(2, 4)
		tester.remote1 = '''
			baz buz
		'''
		tester.trace = new Region(0, 7, #[new Location(1, 5, tester.uri1)]) => [
			addChild(2, 1, #[new Location(1, 5)])
			addChild(5, 1, #[new Location(1, 5)])
		]
		tester === '''
			---- local1 ---- | ---- remote1 ----
			[1[o]1] b[2[a]2] | b[1,2[az bu]2,1]z
			------------------------------------
			1: D 2-1 Region -> Location[1,5]
			2: D 5-1 Region -> Location[1,5]
		'''
	}

	@Test def void twoFiles() {
		val tester = new TraceRegionToStringTester
		tester.localText = '''
			foo bar
		'''
		tester.remote1 = '''
			baz buz
		'''
		tester.remote2 = '''
			xxx zzz
		'''
		tester.trace = new Region(0, 7, #[new Location(0, 7, tester.uri1)]) => [
			addChild(0, 3, #[new Location(0, 3)])
			addChild(4, 3, #[new Location(0, 3, tester.uri2)])
		]
		tester === '''
			------- local1 -------- | ---- remote1 -----
			[1,2[foo]2] [3[bar]3,1] | [1,2[baz]2] buz]1]
			                        | ---- remote2 -----
			                        | [3[xxx]3] zzz
			--------------------------------------------
			1: D 0-7 Region -> Location[0,7,remote1] {
			2: D 0-3   Region -> Location[0,3]
			3: D 4-3   Region -> Location[0,3,remote2]
			1:       }
		'''
	}

	def void ===(TraceRegionToStringTester actual, CharSequence expectation) {
		val rendered = actual.toString
		Assert.assertEquals(expectation.toString.trim, rendered)
	}

}

@Accessors class TraceRegionToStringTester extends AbstractTraceRegionToString {

	static class Location extends LocationData {

		new(int offset, int length, SourceRelativeURI path) {
			super(offset, length, 0, 0, path)
		}

		new(int offset, int length) {
			this(offset, length, null)
		}

	}

	static class Region extends TraceRegion {
		new(int myOffset, int myLength, List<ILocationData> allLocationData, AbstractTraceRegion parent) {
			super(myOffset, myLength, 0, 0, true, allLocationData, parent)
		}

		new(int myOffset, int myLength, List<ILocationData> allLocationData) {
			super(myOffset, myLength, 0, 0, true, allLocationData, null)
		}

		def Region addChild(int myOffset, int myLength, List<ILocationData> allLocationData) {
			val child = new Region(myOffset, myLength, allLocationData, this)
			return child
		}

	}

	val uri1 = new SourceRelativeURI("remote1")
	val uri2 = new SourceRelativeURI("remote2")
	String localText
	String remote1
	String remote2
	ITextRegion localFrame
	Region trace

	new() {
		showLegend = false
	}

	override protected getRemoteText(SourceRelativeURI uri) {
		switch uri {
			case uri1: remote1
			case uri2: remote2
		}
	}

	override protected getLocalTitle() {
		"local1"
	}

}

