/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace;

import org.eclipse.xtext.generator.trace.TraceRegionToStringTester.Location;
import org.eclipse.xtext.generator.trace.TraceRegionToStringTester.Region;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.TextRegion;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TraceRegionToStringTest {
	@Test
	public void simple() {
		TraceRegionToStringTester tester = new TraceRegionToStringTester();
		tester.setLocalText("foo bar");
		tester.setRemote1("baz buz");
		tester.setTrace(new Region(1, 2, Lists.newArrayList(new Location(4, 2, tester.getUri1()))));
		doTest(tester,
				"-- local1 --- | -- remote1 --\n" +
				"f[1[oo]1] bar | baz [1[bu]1]z\n" +
				"-----------------------------\n" +
				"1: D 1-2 Region -> Location[4,2,remote1]\n");
	}

	@Test
	public void oneChild() {
		TraceRegionToStringTester tester = new TraceRegionToStringTester();
		tester.setLocalText("foo bar");
		tester.setRemote1("baz buz");
		Region region = new Region(0, 7, Lists.newArrayList(new Location(1, 6, tester.getUri1())));
		region.addChild(1, 6, Lists.newArrayList(new Location(2, 4)));
		tester.setTrace(region);
		doTest(tester,
				"----- local1 ----- | ----- remote1 -----\n" +
				"[1[f[2[oo bar]2,1] | b[1[a[2[z bu]2]z]1]\n" +
				"----------------------------------------\n" +
				"1: D 0-7 Region -> Location[1,6,remote1] {\n" +
				"2: D 1-6   Region -> Location[2,4]\n" +
				"1:       }\n");
	}

	@Test
	public void twoIdentical() {
		TraceRegionToStringTester tester = new TraceRegionToStringTester();
		tester.setLocalText("foo bar");
		tester.setRemote1("baz buz");
		Region region = new Region(0, 7, Lists.newArrayList(new Location(1, 5, tester.getUri1())));
		region.addChild(0, 7, Lists.newArrayList(new Location(1, 5)));
		tester.setTrace(region);
		doTest(tester,
				"---- local1 ----- | ---- remote1 ----\n" +
				"[1,2[foo bar]2,1] | b[1,2[az bu]2,1]z\n" +
				"-------------------------------------\n" +
				"1: D 0-7 Region -> Location[1,5,remote1] {\n" +
				"2: D 0-7   Region -> Location[1,5]\n" +
				"1:       }\n");
	}

	@Test
	public void twoBounding() {
		TraceRegionToStringTester tester = new TraceRegionToStringTester();
		tester.setLocalText("foobar");
		tester.setRemote1("bazbuz");
		Region region = new Region(0, 6, Lists.newArrayList(new Location(0, 6, tester.getUri1())));
		region.addChild(0, 3, Lists.newArrayList(new Location(0, 3)));
		region.addChild(3, 3, Lists.newArrayList(new Location(3, 3)));
		tester.setTrace(region);
		doTest(tester,
				"------- local1 ------- | ------ remote1 -------\n" +
				"[1,2[foo]2][3[bar]3,1] | [1,2[baz]2][3[buz]3,1]\n" +
				"-----------------------------------------------\n" +
				"1: D 0-6 Region -> Location[0,6,remote1] {\n" +
				"2: D 0-3   Region -> Location[0,3]\n" +
				"3: D 3-3   Region -> Location[3,3]\n" +
				"1:       }\n");
	}

	@Test
	public void twoFrame1() {
		TraceRegionToStringTester tester = new TraceRegionToStringTester();
		tester.setLocalText("foo bar");
		tester.setLocalFrame(new TextRegion(1, 5));
		tester.setRemote1("baz buz");
		Region region = new Region(0, 7, Lists.newArrayList(new Location(1, 5, tester.getUri1())));
		region.addChild(2, 1, Lists.newArrayList(new Location(1, 5)));
		region.addChild(5, 1, Lists.newArrayList(new Location(1, 5)));
		tester.setTrace(region);
		doTest(tester,
				"---- local1 ----- | ---- remote1 ----\n" +
				"o[1[o]1] b[2[a]2] | b[1,2[az bu]2,1]z\n" +
				"-------------------------------------\n" +
				"1: D 2-1 Region -> Location[1,5]\n" +
				"2: D 5-1 Region -> Location[1,5]\n");
	}

	@Test
	public void twoFrame2() {
		TraceRegionToStringTester tester = new TraceRegionToStringTester();
		tester.setLocalText("foo bar");
		tester.setLocalFrame(new TextRegion(2, 4));
		tester.setRemote1("baz buz");
		Region region = new Region(0, 7, Lists.newArrayList(new Location(1, 5, tester.getUri1())));
		region.addChild(2, 1, Lists.newArrayList(new Location(1, 5)));
		region.addChild(5, 1, Lists.newArrayList(new Location(1, 5)));
		tester.setTrace(region);
		doTest(tester,
				"---- local1 ---- | ---- remote1 ----\n" +
				"[1[o]1] b[2[a]2] | b[1,2[az bu]2,1]z\n" +
				"------------------------------------\n" +
				"1: D 2-1 Region -> Location[1,5]\n" +
				"2: D 5-1 Region -> Location[1,5]\n");
	}

	@Test
	public void twoFiles() {
		TraceRegionToStringTester tester = new TraceRegionToStringTester();
		tester.setLocalText("foo bar");
		tester.setRemote1("baz buz");
		tester.setRemote2("xxx zzz");
		Region region = new Region(0, 7, Lists.newArrayList(new Location(0, 7, tester.getUri1())));
		region.addChild(0, 3, Lists.newArrayList(new Location(0, 3)));
		region.addChild(4, 3, Lists.newArrayList(new Location(0, 3, tester.getUri2())));
		tester.setTrace(region);
		doTest(tester,
				"------- local1 -------- | ---- remote1 -----\n" +
				"[1,2[foo]2] [3[bar]3,1] | [1,2[baz]2] buz]1]\n" +
				"                        | ---- remote2 -----\n" +
				"                        | [3[xxx]3] zzz\n" +
				"--------------------------------------------\n" +
				"1: D 0-7 Region -> Location[0,7,remote1] {\n" +
				"2: D 0-3   Region -> Location[0,3]\n" +
				"3: D 4-3   Region -> Location[0,3,remote2]\n" +
				"1:       }\n");
	}

	public void doTest(TraceRegionToStringTester actual, CharSequence expectation) {
		String rendered = actual.toString();
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation.toString().trim()), rendered);
	}
}
