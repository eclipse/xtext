package org.eclipse.xtend.core.tests.formatting

import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.configuration.MapBasedConfigurationValues
import org.junit.runner.RunWith
import org.eclipse.xtext.xbase.formatting.XbaseFormatterConfigKeys
import org.eclipse.xtext.xbase.junit.formatter.FormatterTester
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(RuntimeInjectorProvider))
abstract class AbstractXtendFormatterTest {
	@Inject FormatterTester tester
	@Inject XbaseFormatterConfigKeys keys

	def assertFormatted(CharSequence toBeFormatted) {
		assertFormatted(toBeFormatted, toBeFormatted/* .parse.flattenWhitespace  */)
	}

	def private toMember(CharSequence expression) '''
		package foo
		
		class bar {
			«expression»
		}
	'''

	def assertFormattedExpression((MapBasedConfigurationValues)=>void cfg, CharSequence toBeFormatted) {
		assertFormattedExpression(cfg, toBeFormatted, toBeFormatted)
	}

	def assertFormattedExpression(CharSequence toBeFormatted) {
		assertFormattedExpression(null, toBeFormatted, toBeFormatted)
	}

	def assertFormattedExpression(String expectation, CharSequence toBeFormatted) {
		assertFormattedExpression(null, expectation, toBeFormatted)
	}

	def assertFormattedExpression((MapBasedConfigurationValues)=>void cfg, CharSequence expectation,
		CharSequence toBeFormatted) {
		assertFormattedExpression(cfg, expectation, toBeFormatted, false)
	}

	def assertFormattedExpression((MapBasedConfigurationValues)=>void cfg, CharSequence expectation,
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

	def assertFormattedMember((MapBasedConfigurationValues)=>void cfg, String expectation, CharSequence toBeFormatted) {
		assertFormatted(cfg, expectation.toMember, toBeFormatted.toMember)
	}

	def assertFormattedMember((MapBasedConfigurationValues)=>void cfg, String expectation) {
		assertFormatted(cfg, expectation.toMember, expectation.toMember)
	}

	def assertFormattedMember(String expectation) {
		assertFormatted(expectation.toMember, expectation.toMember)
	}

	def assertFormatted((MapBasedConfigurationValues)=>void cfg, CharSequence expectation) {
		assertFormatted(cfg, expectation, expectation)
	}

	def assertFormatted(CharSequence expectation, CharSequence toBeFormatted) {
		assertFormatted(null, expectation, toBeFormatted)
	}

	def assertFormatted((MapBasedConfigurationValues)=>void cfg, CharSequence expectation, CharSequence toBeFormatted) {
		assertFormatted(cfg, expectation, toBeFormatted, "", "", false)
	}

	def assertFormatted(
		(MapBasedConfigurationValues)=>void cfg,
		CharSequence expectation,
		CharSequence toBeFormatted,
		String prefix,
		String postfix,
		boolean allowErrors
	) {
		tester.assertFormatted [
			it.cfg.put(keys.maxLineWidth, 80)
			if (cfg != null) cfg.apply(it.cfg)
			it.expectation = expectation
			it.toBeFormatted = toBeFormatted
			it.prefix = prefix
			it.postfix = postfix
			it.allowErrors = allowErrors
		]
	}

}
