/*******************************************************************************
 * Copyright (c) 2012, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.formatting

import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtext.preferences.MapBasedPreferenceValues
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.AbstractFormatterTest
import org.eclipse.xtext.util.TextRegion
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
abstract class AbstractXtendFormatterTest extends AbstractFormatterTest {

	protected def String decode(CharSequence seq) {
		seq.toString.replace("<<", "«").replace(">>", "»").replace("```", "'''")
	}

	protected def assertFormattedExpression(CharSequence toBeFormatted) {
		assertFormattedExpression(null, toBeFormatted, toBeFormatted)
	}

	protected def assertFormattedExpression(String expectation, CharSequence toBeFormatted) {
		assertFormattedExpression(null, expectation, toBeFormatted)
	}

	protected def assertFormattedExpression((MapBasedPreferenceValues)=>void cfg, CharSequence expectation,
		CharSequence toBeFormatted) {
		assertFormattedExpression(cfg, expectation, toBeFormatted, false)
	}

	protected def assertFormattedRichStringExpression(CharSequence seq) {
		assertFormattedExpression(seq.decode)
	}

	protected def assertFormattedRichStringExpression(CharSequence expected, CharSequence actual) {
		assertFormattedExpression(expected.decode, actual.decode)
	}

	protected def assertFormattedRichStringExpressionWithErrors(CharSequence actual) {
		assertFormattedExpression(null, actual.decode, actual.decode, true)
	}

	private def assertFormattedExpression((MapBasedPreferenceValues)=>void cfg, CharSequence expectation,
		CharSequence toBeFormatted, boolean allowErrors) {

		val prefix = "class bar {\n\tdef baz() {\n\t\t"
		val postfix = "\n\t}\n}" 

		formatterTestHelper.assertFormatted [
			it.preferences = [
				cfg?.apply(it)
			]
			it.expectation = prefix + expectation.toString.trim.replace("\n", "\n\t\t") + postfix
			it.toBeFormatted = prefix + toBeFormatted.toString.trim.replace("\n", "\n\t\t") + postfix
			it.request.regions += new TextRegion(prefix.length, toBeFormatted.toString.trim.replace("\n", "\n\t\t").length)
			it.allowSyntaxErrors = allowErrors
		]

	}
}
