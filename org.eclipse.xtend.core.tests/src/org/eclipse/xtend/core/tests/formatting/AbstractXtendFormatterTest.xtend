package org.eclipse.xtend.core.tests.formatting

import com.google.inject.Inject
import org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.formatter.FormatterTester
import org.eclipse.xtext.preferences.MapBasedPreferenceValues
import org.eclipse.xtext.util.TextRegion
import org.junit.runner.RunWith

import static org.eclipse.xtext.formatting2.FormatterPreferenceKeys.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(RuntimeInjectorProvider))
abstract class AbstractXtendFormatterTest {
	@Inject protected FormatterTester tester

	def assertFormatted(CharSequence toBeFormatted) {
		assertFormatted(toBeFormatted, toBeFormatted/* .parse.flattenWhitespace  */)
	}

	def private toMember(CharSequence expression) '''
		package foo
		
		class bar {
			«expression»
		}
	'''

	def assertFormattedExpression((MapBasedPreferenceValues)=>void cfg, CharSequence toBeFormatted) {
		assertFormattedExpression(cfg, toBeFormatted, toBeFormatted)
	}

	def assertFormattedExpression(CharSequence toBeFormatted) {
		assertFormattedExpression(null, toBeFormatted, toBeFormatted)
	}

	def assertFormattedExpression(String expectation, CharSequence toBeFormatted) {
		assertFormattedExpression(null, expectation, toBeFormatted)
	}

	def assertFormattedExpression((MapBasedPreferenceValues)=>void cfg, CharSequence expectation,
		CharSequence toBeFormatted) {
		assertFormattedExpression(cfg, expectation, toBeFormatted, false)
	}

	def assertFormattedExpression((MapBasedPreferenceValues)=>void cfg, CharSequence expectation,
		CharSequence toBeFormatted, boolean allowErrors) {
		assertFormatted(
			cfg,
			expectation.toString.trim.replace("\n", "\n\t\t"),
			toBeFormatted.toString.trim.replace("\n", "\n\t\t"),
			"class bar {\n\tdef baz() {\n\t\t",
			"\n\t}\n}",
			allowErrors
		)
	}

	def assertFormattedMember(String expectation, CharSequence toBeFormatted) {
		assertFormatted(expectation.toMember, toBeFormatted.toMember)
	}

	def assertFormattedMember((MapBasedPreferenceValues)=>void cfg, String expectation, CharSequence toBeFormatted) {
		assertFormatted(cfg, expectation.toMember, toBeFormatted.toMember)
	}

	def assertFormattedMember((MapBasedPreferenceValues)=>void cfg, String expectation) {
		assertFormatted(cfg, expectation.toMember, expectation.toMember)
	}

	def assertFormattedMember(String expectation) {
		assertFormatted(expectation.toMember, expectation.toMember)
	}

	def assertFormatted((MapBasedPreferenceValues)=>void cfg, CharSequence expectation) {
		assertFormatted(cfg, expectation, expectation)
	}

	def assertFormatted(CharSequence expectation, CharSequence toBeFormatted) {
		assertFormatted(null, expectation, toBeFormatted)
	}

	def assertFormatted((MapBasedPreferenceValues)=>void cfg, CharSequence expectation, CharSequence toBeFormatted) {
		assertFormatted(cfg, expectation, toBeFormatted, "", "", false)
	}

	def assertFormatted(
		(MapBasedPreferenceValues)=>void cfg,
		CharSequence expectation,
		CharSequence toBeFormatted,
		String prefix,
		String postfix,
		boolean allowErrors
	) {
		tester.assertFormatted [
			it.preferences = [
				put(maxLineWidth, 80)
				put(XtendFormatterPreferenceKeys.keepOneLineMethods, false)
				cfg?.apply(it)
			]
			it.expectation = prefix + expectation + postfix
			it.toBeFormatted = prefix + toBeFormatted + postfix
			it.request.regions += new TextRegion(prefix.length, toBeFormatted.length)
			it.allowSyntaxErrors = allowErrors
		]
	}

	def protected String decode(CharSequence seq) {
		seq.toString.replace("<<", "«").replace(">>", "»").replace("```", "'''")
	}

	def void assertFormattedRichStringExpression(CharSequence seq) {
		assertFormattedExpression(seq.decode)
	}

	def void assertFormattedRichString(CharSequence seq) {
		assertFormatted(seq.decode)
	}

	def void assertFormattedRichStringExpression(CharSequence expected, CharSequence actual) {
		assertFormattedExpression(expected.decode, actual.decode)
	}

	def void assertFormattedRichStringExpressionWithErrors(CharSequence actual) {
		assertFormattedExpression(null, actual.decode, actual.decode, true)
	}

}
