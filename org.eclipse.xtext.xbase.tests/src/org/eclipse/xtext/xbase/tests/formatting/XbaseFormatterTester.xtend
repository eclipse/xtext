/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.formatting

import org.eclipse.xtext.formatting2.FormatterPreferenceKeys
import org.eclipse.xtext.testing.formatter.FormatterTestRequest
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.xbase.junit.formatter.FormatterTester

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class XbaseFormatterTester extends FormatterTester {

	def void assertFormattedExpression((FormatterTestRequest)=>void test) {
		val prefix = "{" + Strings.newLine
		val postfix = Strings.newLine + "}"
		val (FormatterTestRequest)=>void setup = [
			test.apply(it)
			preferences[
				put(FormatterPreferenceKeys.maxLineWidth, 80)
			]
			expectation = prefix + expectationOrToBeFormatted.toString.trim.indent("\t") + postfix
			toBeFormatted = prefix + toBeFormatted.toString.trim.indent("\t") + postfix
		]
		assertFormatted(setup)
	}

	def protected String indent(String string, String indent) {
		string.split("\\r?\\n").map[if(it == "") it else indent + it].join(Strings.newLine)
	}
}
