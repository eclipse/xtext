/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.test;

import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.occurrences.OccurrencesResult;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class OccurrenceTest extends AbstractWebServerTest {
	protected OccurrencesResult getOccurrences(CharSequence resourceContent) {
		String content = resourceContent.toString();
		int offset = content.indexOf("#");
		XtextServiceDispatcher.ServiceDescriptor occurrences = this.getService(ImmutableMap.<String, String>builder()
				.put("serviceType", "occurrences").put("fullText", content.replace("#", ""))
				.put("caretOffset", Integer.valueOf(offset).toString()).build());
		return (OccurrencesResult) occurrences.getService().apply();
	}

	protected void assertOccurrences(CharSequence resourceContent, CharSequence expectation) {
		assertEquals(expectation.toString().trim(),
				getOccurrences(normalizeLineSeparator(resourceContent.toString())).toString().trim());
	}

	@Test
	public void testNoOccurrenceOnEmptyFile() {
		OccurrencesResult result = getOccurrences("#");
		Assert.assertTrue(result.getReadRegions().isEmpty());
		Assert.assertTrue(result.getWriteRegions().isEmpty());
	}

	@Test
	public void testNoOccurrencesOnKeyword() {
		OccurrencesResult result = getOccurrences("#state foo\n");
		Assert.assertTrue(result.getReadRegions().isEmpty());
		Assert.assertTrue(result.getWriteRegions().isEmpty());
	}

	@Test
	public void testSingleWriteOccurrence() {
		String model = "state #foo\n";
		String expectation = 
				"OccurrencesResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  writeRegions = ArrayList (\n" +
				"    [6:3]\n" +
				"  )\n" +
				"  readRegions = ArrayList ()\n" +
				"]\n";
		assertOccurrences(model, expectation);
	}

	@Test
	public void testReadAndWriteOccurrence() {
		String model = 
				"input signal #foo\n" +
				"state bar \n" +
				"	set foo == true\n" +
				"	set foo == true\n" +
				"end\n";
		String expectation = 
				"OccurrencesResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  writeRegions = ArrayList (\n" +
				"    [13:3]\n" +
				"  )\n" +
				"  readRegions = ArrayList (\n" +
				"    [33:3],\n" +
				"    [50:3]\n" +
				"  )\n" +
				"]\n";
		assertOccurrences(model, expectation);
	}

	@Test
	public void testReadAndWriteOccurrence_2() {
		String model = "input signal foo\n" +
				"state bar \n" +
				"	set #foo == true\n" +
				"	set foo == true\n" +
				"end\n";
		String expectation = "OccurrencesResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  writeRegions = ArrayList (\n" +
				"    [13:3]\n" +
				"  )\n" +
				"  readRegions = ArrayList (\n" +
				"    [33:3],\n" +
				"    [50:3]\n" +
				"  )\n" +
				"]\n";
		assertOccurrences(model, expectation);
	}

	@Test
	public void testSyntaxError() {
		String model = "state foo\n" +
				"end\n" +
				"asdf#\n" +
				"state bar \n" +
				"end\n";
		String expectation = "OccurrencesResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  writeRegions = ArrayList ()\n" +
				"  readRegions = ArrayList ()\n" +
				"]\n";
		assertOccurrences(model, expectation);
	}
}
