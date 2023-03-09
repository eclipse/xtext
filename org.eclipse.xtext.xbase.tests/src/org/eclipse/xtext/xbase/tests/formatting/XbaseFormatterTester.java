/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.formatting;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.junit.formatter.FormatterTester;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XbaseFormatterTester extends FormatterTester {
	public void assertFormattedExpression(Procedure1<? super FormatterTestRequest> test) {
		String prefix = "{" + Strings.newLine();
		String postfix = Strings.newLine() + "}";
		assertFormatted((FormatterTestRequest it) -> {
			test.apply(it);
			it.preferences((MapBasedPreferenceValues prefs) -> {
				prefs.put(FormatterPreferenceKeys.maxLineWidth, 80);
			});
			it.setExpectation(prefix + indent(it.getExpectationOrToBeFormatted().toString().trim(), "\t") + postfix);
			it.setToBeFormatted(prefix + indent(it.getToBeFormatted().toString().trim(), "\t") + postfix);
		});
	}

	protected String indent(String string, String indent) {
		return Arrays.stream(string.split("\\r?\\n")).map((String it) -> {
			if ("".equals(it)) {
				return it;
			} else {
				return indent + it;
			}
		}).collect(Collectors.joining(Strings.newLine()));
	}
}
