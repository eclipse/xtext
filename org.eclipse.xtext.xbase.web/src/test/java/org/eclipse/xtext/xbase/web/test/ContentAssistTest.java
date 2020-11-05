/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.web.test;

import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class ContentAssistTest extends AbstractXbaseWebTest {
	protected void assertContentAssistResult(CharSequence resourceContent, CharSequence expectedResult) {
		String contentString = normalizeLineSeparator(resourceContent.toString());
		int cursorOffset = contentString.indexOf("|");
		if (cursorOffset >= 0) {
			contentString = contentString.substring(0, cursorOffset) + contentString.substring(cursorOffset + 1);
			assertContentAssistResult(contentString, cursorOffset, expectedResult);
		} else {
			assertContentAssistResult(resourceContent, 0, expectedResult);
		}
	}

	protected void assertContentAssistResult(CharSequence resourceContent, int offset, CharSequence expectedResult) {
		XtextServiceDispatcher.ServiceDescriptor contentAssist = getService(ImmutableMap.<String, String>builder()
				.put("serviceType", "assist").put("fullText", resourceContent.toString())
				.put("caretOffset", Integer.valueOf(offset).toString()).build());
		ContentAssistResult result = (ContentAssistResult) contentAssist.getService().apply();
		assertEquals(expectedResult.toString(), result.toString());
	}

	@Test
	public void testExtendsType() {
		String model = "entity Foo extends AbstractQu|";
		String expectedResult = "ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"AbstractQu\"\n" +
				"      proposal = \"AbstractQueue\"\n" +
				"      description = \"java.util.AbstractQueue\"\n" +
				"      textReplacements = ArrayList (\n" +
				"        replace region [0 / length: 0] '\n" +
				"        import java.util.AbstractQueue'\n" +
				"      )\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"AbstractQu\"\n" +
				"      proposal = \"AbstractQueuedLongSynchronizer\"\n" +
				"      description = \"java.util.concurrent.locks.AbstractQueuedLongSynchronizer\"\n" +
				"      textReplacements = ArrayList (\n" +
				"        replace region [0 / length: 0] '\n" +
				"        import java.util.concurrent.locks.AbstractQueuedLongSynchronizer'\n" +
				"      )\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"AbstractQu\"\n" +
				"      proposal = \"AbstractQueuedSynchronizer\"\n" +
				"      description = \"java.util.concurrent.locks.AbstractQueuedSynchronizer\"\n" +
				"      textReplacements = ArrayList (\n" +
				"        replace region [0 / length: 0] '\n" +
				"        import java.util.concurrent.locks.AbstractQueuedSynchronizer'\n" +
				"      )\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testPropertyType() {
		String model = "entity Foo { bar: AbstractQu| }";
		String expectedResult = 
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"AbstractQu\"\n" +
				"      proposal = \"AbstractQueue\"\n" +
				"      description = \"java.util.AbstractQueue\"\n" +
				"      textReplacements = ArrayList (\n" +
				"        replace region [0 / length: 0] '\n" +
				"        import java.util.AbstractQueue'\n" +
				"      )\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"AbstractQu\"\n" +
				"      proposal = \"AbstractQueuedLongSynchronizer\"\n" +
				"      description = \"java.util.concurrent.locks.AbstractQueuedLongSynchronizer\"\n" +
				"      textReplacements = ArrayList (\n" +
				"        replace region [0 / length: 0] '\n" +
				"        import java.util.concurrent.locks.AbstractQueuedLongSynchronizer'\n" +
				"      )\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"AbstractQu\"\n" +
				"      proposal = \"AbstractQueuedSynchronizer\"\n" +
				"      description = \"java.util.concurrent.locks.AbstractQueuedSynchronizer\"\n" +
				"      textReplacements = ArrayList (\n" +
				"        replace region [0 / length: 0] '\n" +
				"        import java.util.concurrent.locks.AbstractQueuedSynchronizer'\n" +
				"      )\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testListMethods() {
		String model = "entity Foo { op bar(): void { #['blub'].add| } }";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"add\"\n" +
				"      proposal = \"add()\"\n" +
				"      label = \"add(E arg0) : boolean\"\n" +
				"      description = \"List\"\n" +
				"      escapePosition = 45\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList (\n" +
				"        [44:0]\n" +
				"      )\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"add\"\n" +
				"      proposal = \"add()\"\n" +
				"      label = \"add(int arg0, E arg1) : void\"\n" +
				"      description = \"List\"\n" +
				"      escapePosition = 45\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList (\n" +
				"        [44:0]\n" +
				"      )\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"add\"\n" +
				"      proposal = \"addAll()\"\n" +
				"      label = \"addAll(Collection<? extends E> arg0) : boolean\"\n" +
				"      description = \"List\"\n" +
				"      escapePosition = 48\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList (\n" +
				"        [47:0]\n" +
				"      )\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"add\"\n" +
				"      proposal = \"addAll()\"\n" +
				"      label = \"addAll(Iterable<? extends T> arg1) : boolean\"\n" +
				"      description = \"CollectionExtensions\"\n" +
				"      escapePosition = 48\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList (\n" +
				"        [47:0]\n" +
				"      )\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"add\"\n" +
				"      proposal = \"addAll()\"\n" +
				"      label = \"addAll(T... arg1) : boolean\"\n" +
				"      description = \"CollectionExtensions\"\n" +
				"      escapePosition = 48\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList (\n" +
				"        [47:0]\n" +
				"      )\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"add\"\n" +
				"      proposal = \"addAll()\"\n" +
				"      label = \"addAll(int arg0, Collection<? extends E> arg1) : boolean\"\n" +
				"      description = \"List\"\n" +
				"      escapePosition = 48\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList (\n" +
				"        [47:0]\n" +
				"      )\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"!=\"\n" +
				"      description = \"JvmOperation\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"!==\"\n" +
				"      description = \"JvmOperation\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"&&\"\n" +
				"      description = \"JvmOperation\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"+\"\n" +
				"      description = \"JvmOperation\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"->\"\n" +
				"      description = \"JvmOperation\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"<\"\n" +
				"      description = \"JvmOperation\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"<=\"\n" +
				"      description = \"JvmOperation\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"<=>\"\n" +
				"      description = \"JvmOperation\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"==\"\n" +
				"      description = \"JvmOperation\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"===\"\n" +
				"      description = \"JvmOperation\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"=>\"\n" +
				"      description = \"JvmOperation\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \">\"\n" +
				"      description = \"JvmOperation\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \">=\"\n" +
				"      description = \"JvmOperation\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"?:\"\n" +
				"      description = \"JvmOperation\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"||\"\n" +
				"      description = \"JvmOperation\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"\"\n" +
				"      proposal = \"\"value\"\"\n" +
				"      description = \"STRING\"\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList (\n" +
				"        [44:5]\n" +
				"      )\n" +
				"      kind = \"TEXT\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}

	@Test
	public void testMembers() {
		String model =
				"entity Foo {\n" +
				"	foobar1: String\n" +
				"	op foobar2(): String {}\n" +
				"	op baz(): void {\n" +
				"		println(foob|)\n" +
				"	}\n" +
				"}\n";
		String expectedResult =
				"ContentAssistResult [\n" +
				"  stateId = \"-80000000\"\n" +
				"  entries = ArrayList (\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"foob\"\n" +
				"      proposal = \"foobar1\"\n" +
				"      label = \"foobar1 : String\"\n" +
				"      description = \"Foo\"\n" +
				"      escapePosition = 90\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"foob\"\n" +
				"      proposal = \"foobar1 = value\"\n" +
				"      label = \"foobar1 = value : void\"\n" +
				"      description = \"Foo.setFoobar1()\"\n" +
				"      escapePosition = 98\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList (\n" +
				"        [93:5]\n" +
				"      )\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ],\n" +
				"    ContentAssistEntry [\n" +
				"      prefix = \"foob\"\n" +
				"      proposal = \"foobar2\"\n" +
				"      label = \"foobar2 : String\"\n" +
				"      description = \"Foo.foobar2()\"\n" +
				"      escapePosition = 90\n" +
				"      textReplacements = ArrayList ()\n" +
				"      editPositions = ArrayList ()\n" +
				"      kind = \"REFERENCE\"\n" +
				"    ]\n" +
				"  )\n]";
		assertContentAssistResult(model, expectedResult);
	}
}
