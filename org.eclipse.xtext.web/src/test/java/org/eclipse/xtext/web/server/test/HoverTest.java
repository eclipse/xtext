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
import org.eclipse.xtext.web.server.hover.HoverResult;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class HoverTest extends AbstractWebServerTest {
	protected HoverResult getHover(CharSequence resourceContent) {
		String content = resourceContent.toString();
		int offset = content.indexOf("#");
		XtextServiceDispatcher.ServiceDescriptor hover = getService(ImmutableMap.<String, String>builder()
				.put("serviceType", "hover").put("fullText", content.replace("#", ""))
				.put("caretOffset", Integer.toString(offset)).build());
		return (HoverResult) hover.getService().apply();
	}

	protected HoverResult getContentAssistHover(CharSequence resourceContent, String proposal) {
		String content = resourceContent.toString();
		int offset = content.indexOf("|");
		XtextServiceDispatcher.ServiceDescriptor hover = getService(ImmutableMap.<String, String>builder()
				.put("serviceType", "hover").put("fullText", content.replace("|", ""))
				.put("caretOffset", Integer.valueOf(offset).toString()).put("proposal", proposal).build());
		return (HoverResult) hover.getService().apply();
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
	public void testNoHoverOnEmptyFile() {
		Assert.assertNull(getHover("#").getContent());
	}

	@Test
	public void testUndocumentedElement() {
		String expectedContent = "";
		String expectedTitle = 
				"<div class=\"xtext-hover\">\n" +
				"	<div class=\"State-icon default-icon\">\n" +
				"		<div class=\"element-name\">\n" +
				"			foo\n" +
				"		</div>\n" +
				"	</div>\n" +
				"</div>\n";
		assertTitle(assertContent(getHover("state #foo\n"), expectedContent), expectedTitle);
	}

	@Test
	public void testDocumentedElement() {
		String model =
				"/**\n" +
				" * This is foo!\n" +
				" */\n" +
				"state #foo\n";
		String expectedContent =
				"<div class=\"xtext-hover\">\n" +
				"	This is foo!\n" +
				"</div>\n";
		String expectedTitle =
				"<div class=\"xtext-hover\">\n" +
				"	<div class=\"State-icon default-icon\">\n" +
				"		<div class=\"element-name\">\n" +
				"			foo\n" +
				"		</div>\n" +
				"	</div>\n" +
				"</div>\n";
		assertTitle(assertContent(getHover(model), expectedContent), expectedTitle);
	}

	@Test
	public void testKeyword() {
		String model =
				"/**\n" +
				" * This is foo!\n" +
				" */\n" +
				"#state foo\n";
		Assert.assertNull(getHover(model).getContent());
	}

	@Test
	public void testSubClass() {
		String model = "input signal #foo\n";
		String expectedTitle =
				"<div class=\"xtext-hover\">\n" +
				"	<div class=\"InputSignal-icon Signal-icon default-icon\">\n" +
				"		<div class=\"element-name\">\n" +
				"			foo\n" +
				"		</div>\n" +
				"	</div>\n" +
				"</div>\n";
		assertTitle(getHover(model), expectedTitle);
	}

	@Test
	public void testDecoratedIcon() {
		String model = "output signal #foo\n";
		String expectedTitle =
				"<div class=\"xtext-hover\">\n" +
				"	<div class=\"OutputSignal-icon Signal-icon default-icon\">\n" +
				"		<div class=\"output-icon\">\n" +
				"			<div class=\"element-name\">\n" +
				"				foo\n" +
				"			</div>\n" +
				"		</div>\n" +
				"	</div>\n" +
				"</div>\n";
		assertTitle(getHover(model), expectedTitle);
	}

	@Test
	public void testNoHoverUnnamedElement() {
		String model =
				"input signal x\n" +
				"\n" +
				"state State1\n" +
				"	set z = fal#se\n" +
				"end\n";
		Assert.assertNull(getHover(model).getContent());
	}

	@Test
	public void testContentAssistCrossref1() {
		String model =
				"input signal x\n" +
				"/* my nice state */\n" +
				"state foo\n" +
				"end\n" +
				"state bar\n" +
				"	if x == true goto |\n" +
				"end\n";
		String proposal = "foo";
		String expectedTitle =
				"<div class=\"xtext-hover\">\n" +
				"	<div class=\"State-icon default-icon\">\n" +
				"		<div class=\"element-name\">\n" +
				"			foo\n" +
				"		</div>\n" +
				"	</div>\n" +
				"</div>\n";
		String expectedContent =
				"<div class=\"xtext-hover\">\n" +
				"	my nice state\n" +
				"</div>\n";
		assertContent(assertTitle(getContentAssistHover(model, proposal), expectedTitle), expectedContent);
	}

	@Test
	public void testContentAssistCrossref2() {
		String model =
				"input signal x\n" +
				"/* my nice signal */\n" +
				"input signal y\n" +
				"state foo\n" +
				"	if | == true goto foo\n" +
				"end\n";
		String expectedTitle =
				"<div class=\"xtext-hover\">\n" +
				"	<div class=\"InputSignal-icon Signal-icon default-icon\">\n" +
				"		<div class=\"element-name\">\n" +
				"			y\n" +
				"		</div>\n" +
				"	</div>\n" +
				"</div>\n";
		String expectedContent =
				"<div class=\"xtext-hover\">\n" +
				"	my nice signal\n" +
				"</div>\n";
		String proposal = "y";
		assertContent(assertTitle(getContentAssistHover(model, proposal), expectedTitle), expectedContent);
	}
}
