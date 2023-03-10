/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.test;

import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.hover.HoverResult;
import org.eclipse.xtext.web.server.syntaxcoloring.HighlightingResult;
import org.eclipse.xtext.web.server.syntaxcoloring.HighlightingResult.Region;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class HighlightingTest extends AbstractWebServerTest {
	protected void assertHighlighting(CharSequence resourceContent, String... styleClasses) {
		String content = resourceContent.toString();
		XtextServiceDispatcher.ServiceDescriptor highlighting = getService(ImmutableMap.<String, String>builder()
				.put("serviceType", "highlight").put("fullText", content.replace("#", "")).build());
		HighlightingResult result = (HighlightingResult) highlighting.getService().apply();
		Assert.assertEquals(styleClasses.length, result.getRegions().size());
		int offset = 0;
		String[] snippets = content.split("#");
		for (int i = 0; i < styleClasses.length; i++) {
			offset = offset + snippets[2 * i].length();
			int length = snippets[2 * i + 1].length();
			Region region = result.getRegions().get(i);
			assertEquals(styleClasses[i], region.getStyleClasses()[0]);
			Assert.assertEquals(offset, region.getOffset());
			Assert.assertEquals(length, region.getLength());
			offset = offset + length;
		}
	}

	protected HoverResult assertTitle(HoverResult result, String expectedTitle) {
		assertEquals(expectedTitle, result.getTitle());
		return result;
	}

	protected HoverResult assertContent(HoverResult result, String expectedContent) {
		assertEquals(expectedContent, result.getContent());
		return result;
	}

	@Test
	public void testNoHighlightingOnEmptyFile() {
		assertHighlighting("#");
	}

	@Test
	public void testNoSignal() {
		String model = 
				"state State\n" +
				"end\n";
		assertHighlighting(model);
	}

	@Test
	public void testInputSignal() {
		String model = 
				"input signal #in#\n" +
				"\n" +
				"state State\n" +
				"	if #in# == true goto State\n" +
				"end\n";
		assertHighlighting(model, "InputSignal",
				"InputSignal");
	}

	@Test
	public void testOutputSignal() {
		String model = 
				"output signal #out#\n" +
				"\n" +
				"state State\n" +
				"	set #out# = false\n" +
				"end\n";
		assertHighlighting(model, "OutputSignal", "OutputSignal");
	}

	@Test
	public void testMixed() {
		String model = 
				"input signal #in#\n" +
				"output signal #out#\n" +
				"\n" +
				"state State\n" +
				"	set #out# = false\n" +
				"	if #in# == true goto State\n" +
				"end\n";
		assertHighlighting(model, "InputSignal", "OutputSignal", "OutputSignal", "InputSignal");
	}
}
