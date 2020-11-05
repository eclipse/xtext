/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.lsp4j.FormattingOptions;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtext.ide.server.formatting.FormattingService;
import org.eclipse.xtext.testing.FormattingConfiguration;
import org.eclipse.xtext.testing.RangeFormattingConfiguration;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

/**
 * Tests for {@link FormattingService}
 * 
 * @author Christian Dietrich - Initial contribution and API
 */
public class FormattingTest extends AbstractTestLangLanguageServerTest {
	@Test
	public void testFormattingService() {
		testFormatting((FormattingConfiguration it) -> {
			it.setModel("type Foo{int bar} type Bar{Foo foo}");
			String expectedText =
					"type Foo{\n" +
					"	int bar\n" +
					"}\n" +
					"type Bar{\n" +
					"	Foo foo\n" +
					"}\n";
			it.setExpectedText(expectedText);
		});
	}

	@Test
	public void testFormattingService_02() {
		testFormatting(it -> it.setOptions(new FormattingOptions(4, true)), (FormattingConfiguration it) -> {
			it.setModel("type Foo{int bar} type Bar{Foo foo}");
			String expectedText =
					"type Foo{\n" +
					"    int bar\n" +
					"}\n" +
					"type Bar{\n" +
					"    Foo foo\n" +
					"}\n";
			it.setExpectedText(expectedText);
		});
	}

	@Test
	public void testFormattingClosedFile() {
		testFormatting((FormattingConfiguration it) -> {
			it.setFilesInScope(ImmutableMap.<String, CharSequence>builder()
					.put("foo.testlang", "type Foo{int bar} type Bar{Foo foo}").build());
			String expectedText =
					"type Foo{\n" +
					"	int bar\n" +
					"}\n" +
					"type Bar{\n" +
					"	Foo foo\n" +
					"}\n";
			it.setExpectedText(expectedText);
		});
	}

	@Test
	public void testRangeFormattingService() {
		testRangeFormatting((RangeFormattingConfiguration it) -> {
			it.setModel("type Foo{int bar} type Bar{Foo foo}");
			it.setRange(new Range(new Position(0, 0), new Position(0, 17)));
			String expectedText =
					"type Foo{\n" +
					"	int bar\n" +
					"} type Bar{Foo foo}";
			it.setExpectedText(expectedText);
		});
	}

	@Test
	public void testRangeFormattingService_02() {
		testRangeFormatting(it -> it.setOptions(new FormattingOptions(4, true)), (RangeFormattingConfiguration it) -> {
			it.setModel("type Foo{int bar} type Bar{Foo foo}");
			it.setRange(new Range(new Position(0, 0), new Position(0, 17)));
			String expectedText =
					"type Foo{\n" +
					"    int bar\n" +
					"} type Bar{Foo foo}";
			it.setExpectedText(expectedText);
		});
	}
}
