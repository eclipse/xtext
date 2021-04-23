/**
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.formatting;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.util.Strings;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(XbaseFormatterTestInjectorProvider.class)
public class XbaseCommentFormatterTest {
	@Inject
	private XbaseFormatterTester xbaseFormatterTester;

	@Test
	public void commentInIfExpression() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String model =
					"if (true)\n" +
					"	println(\"foo\")\n" +
					"else // if (true)\n" +
					"	println(\"bar\")\n" +
					"println(\"end\")\n";
			it.setToBeFormatted(Strings.toPlatformLineSeparator(model));
		});
	}

	@Test
	public void commentAfterForExpression1() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String model =
					"for (f : #[])\n" +
					"	if (1 < 2) {\n" +
					"	}\n" +
					"\n" +
					"// foo\n" +
					"var lastOffset = \"\"\n";
			it.setToBeFormatted(Strings.toPlatformLineSeparator(model));
		});
	}

	@Test
	public void commentAfterForExpression3() {
		xbaseFormatterTester.assertFormattedExpression((FormatterTestRequest it) -> {
			String model = "val ll = #[].map(e|e.toString) // error here\n";
			it.setToBeFormatted(Strings.toPlatformLineSeparator(model));
		});
	}
}
