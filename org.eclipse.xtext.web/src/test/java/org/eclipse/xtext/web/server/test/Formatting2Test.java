/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.test;

import java.io.File;

import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.formatting.FormattingResult;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class Formatting2Test extends AbstractWebServerTest {
	@Test
	public void testFormatFile() {
		File file = createFile("/* bla */ output signal x state foo set x = true end");
		XtextServiceDispatcher.ServiceDescriptor format = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "format")
						.put("resource", file.getName())
						.build());
		Assert.assertTrue(format.isHasSideEffects());
		FormattingResult result = (FormattingResult) format.getService().apply();
		String expectedResult = 
				"FormattingResult [\n" +
				"  stateId = \"-7fffffff\"\n" +
				"  formattedText = \"/* bla */ output signal x\\nstate foo\\n	set x = true\\nend\\n\"\n" +
				"]";
		assertEquals(expectedResult, result.toString());
	}

	@Test
	public void testFormatSelection() {
		File file = createFile("/* bla */ output signal x state foo set x = true end ");
		XtextServiceDispatcher.ServiceDescriptor format = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "format")
						.put("selectionStart", "26")
						.put("selectionEnd", "52")
						.put("resource", file.getName())
						.build());
		Assert.assertTrue(format.isHasSideEffects());
		FormattingResult result = (FormattingResult) format.getService().apply();
		String expectedResult = 
				"FormattingResult [\n" +
				"  stateId = \"-7fffffff\"\n" +
				"  formattedText = \"state foo\\n	set x = true\\nend\"\n" +
				"  replaceRegion = [26:26]\n" +
				"]";
		assertEquals(expectedResult, result.toString());
	}
}
