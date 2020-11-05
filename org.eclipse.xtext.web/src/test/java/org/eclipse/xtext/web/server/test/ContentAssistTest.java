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

import org.eclipse.xtext.web.example.statemachine.ide.StatemachineIdeModule;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineTemplateProposalProvider;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.ServiceConflictResult;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class ContentAssistTest extends AbstractWebServerTest {
	public static class StatemachineTemplateProposalProvider2 extends StatemachineTemplateProposalProvider {
		@Override
		protected String getLineDelimiter() {
			return "\n";
		}
	}

	@Override
	protected com.google.inject.Module getIdeModule() {
		return new StatemachineIdeModule() {
			@SuppressWarnings("unused")
			public Class<? extends StatemachineTemplateProposalProvider> bindStatemachineTemplateProposalProvider() {
				return ContentAssistTest.StatemachineTemplateProposalProvider2.class;
			}
		};
	}

	protected void assertContentAssistResult(CharSequence resourceContent, CharSequence expectedResult) {
		String contentString = resourceContent.toString();
		int cursorOffset = contentString.indexOf("|");
		if (cursorOffset >= 0) {
			contentString = contentString.substring(0, cursorOffset)+ contentString.substring(cursorOffset+ 1);
			assertContentAssistResult(contentString, cursorOffset, expectedResult);
		} else {
			assertContentAssistResult(resourceContent, 0, expectedResult);
		}
	}

	protected void assertContentAssistResult(CharSequence resourceContent, int offset, CharSequence expectedResult) {
		XtextServiceDispatcher.ServiceDescriptor contentAssist = getService(
				ImmutableMap.<String, String>builder()
					.put("serviceType", "assist")
					.put("fullText", resourceContent.toString())
					.put("caretOffset", Integer.valueOf(offset).toString())
					.build());
		Assert.assertFalse(contentAssist.isHasSideEffects());
		ContentAssistResult result = (ContentAssistResult) contentAssist.getService().apply();
		assertEquals(expectedResult.toString(), result.toString());
	}

	@Test
	public void testKeywords() {
		String model = "state foo | end";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"state name\\n	\\nend\\n\"\n" +
				"      label = \"state\"\n" +
				"      description = \"Create a new state\"\n" +
				"      escapePosition = 22\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList (\n" +
				"        [16:4]\n" +
				"      )\n" +
				"      kind = \"UNKNOWN\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"end\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"KEYWORD\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"if\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"KEYWORD\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"set\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"KEYWORD\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testKeywordWithPrefix() {
		String model = "inp|";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"inp\"\n" +
				"      proposal = \"input\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"KEYWORD\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testTemplate() {
		String model = "state foo end |";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"state name\\n	\\nend\\n\"\n" +
				"      label = \"state\"\n" +
				"      description = \"Create a new state\"\n" +
				"      escapePosition = 26\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList (\n" +
				"        [20:4]\n" +
				"      )\n" +
				"      kind = \"UNKNOWN\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testIndentedTemplate() {
		String model =
				"state foo end\n" +
				"	|\n";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"state name\\n		\\n	end\\n\"\n" +
				"      label = \"state\"\n" +
				"      description = \"Create a new state\"\n" +
				"      escapePosition = 28\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList (\n" +
				"        [21:4]\n" +
				"      )\n" +
				"      kind = \"UNKNOWN\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testTerminal() {
		String model = "state | end";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"name\"\n" +
				"      description = \"ID\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList (\n" +
				"        [6:4]\n" +
				"      )\n" +
				"      kind = \"VALUE\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testCrossref() {
		String model =
				"input signal x\n" +
				"state foo\n" +
				"end\n" +
				"state bar\n" +
				"	if x == true goto |\n" +
				"end\n";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"bar\"\n" +
				"      description = \"State\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"foo\"\n" +
				"      description = \"State\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testFqnCrossref() {
		String model =
				"input signal x\n" +
				"state foo\n" +
				"	state inner1 end\n" +
				"	state inner2 end\n" +
				"end\n" +
				"state bar\n" +
				"	if x == true goto |\n" +
				"end\n";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"bar\"\n" +
				"      description = \"State\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"foo\"\n" +
				"      description = \"State\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"foo.inner1\"\n" +
				"      description = \"State\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"foo.inner2\"\n" +
				"      description = \"State\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testCustomTerminal() {
		String model =
				"output signal x\n" +
				"state foo\n" +
				"	set x = |\n" +
				"end\n";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"false\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"UNKNOWN\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"true\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"UNKNOWN\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testCustomCrossref() {
		String model =
				"input signal x\n" +
				"output signal z\n" +
				"state foo\n" +
				"	if | == true goto foo\n" +
				"end\n";
		assertContentAssistResult(model,
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"x\"\n" +
				"      description = \"input signal\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"UNKNOWN\"\n" +
				"    ]\n" +
				"  )\n]");
	}

	@Test
	public void testCrossrefWithPrefix1() {
		String model =
				"input signal x\n" +
				"state foo\n" +
				"	if x == true goto fo|\n" +
				"end\n" +
				"state bar\n" +
				"end\n";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"fo\"\n" +
				"      proposal = \"foo\"\n" +
				"      description = \"State\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testCrossrefWithPrefix2() {
		String model =
				"input signal x\n" +
				"state Foooo\n" +
				"	if x == true goto fOoO|\n" +
				"end\n" +
				"state Baaar\n" +
				"end\n";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"fOoO\"\n" +
				"      proposal = \"Foooo\"\n" +
				"      description = \"State\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testFqnCrossrefWithPrefix1() {
		String model =
				"input signal x\n" +
				"state foo\n" +
				"	state inner1 end\n" +
				"	state inner2 end\n" +
				"end\n" +
				"state bar\n" +
				"	if x == true goto foo.|\n" +
				"end\n";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"foo.\"\n" +
				"      proposal = \"foo.inner1\"\n" +
				"      description = \"State\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"foo.\"\n" +
				"      proposal = \"foo.inner2\"\n" +
				"      description = \"State\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testFqnCrossrefWithPrefix2() {
		String model =
				"input signal x\n" +
				"state foo\n" +
				"	state inner1 end\n" +
				"	state inner2 end\n" +
				"end\n" +
				"state bar\n" +
				"	if x == true goto inner|\n" +
				"end\n";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"inner\"\n" +
				"      proposal = \"foo.inner1\"\n" +
				"      description = \"State\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"inner\"\n" +
				"      proposal = \"foo.inner2\"\n" +
				"      description = \"State\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testFqnCrossrefWithPrefix3() {
		String model =
				"input signal x\n" +
				"state foo\n" +
				"	state inner1\n" +
				"		state inner2 end\n" +
				"		state inner3 end\n" +
				"	end\n" +
				"end\n" +
				"state bar\n" +
				"	if x == true goto f.i.i|\n" +
				"end\n";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"f.i.i\"\n" +
				"      proposal = \"foo.inner1.inner2\"\n" +
				"      description = \"State\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"f.i.i\"\n" +
				"      proposal = \"foo.inner1.inner3\"\n" +
				"      description = \"State\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testTerminalWithPrefix() {
		String model = "state foo|\n";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList ()\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testCustomTerminalWithPrefix() {
		String model =
				"output signal x\n" +
				"state foo\n" +
				"	set x = f|\n" +
				"end\n";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"f\"\n" +
				"      proposal = \"false\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"UNKNOWN\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testIncorrectStateId() {
		File file = createFile("state foo end");
		XtextServiceDispatcher.ServiceDescriptor contentAssist = getService(
				ImmutableMap.<String, String>builder()
						.put("serviceType", "assist")
						.put("resource", file.getName())
						.put("caretOffset", "3")
						.put("requiredStateId", "totalerquatsch")
						.build());
		Assert.assertTrue(contentAssist.isHasConflict());
		IServiceResult result = contentAssist.getService().apply();
		MatcherAssert.assertThat(result, IsInstanceOf.instanceOf(ServiceConflictResult.class));
		assertEquals(((ServiceConflictResult) result).getConflict(), "invalidStateId");
	}
}
