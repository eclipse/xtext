package org.eclipse.xtext.xbase.tests.formatting

import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.configuration.MapBasedConfigurationValues
import org.eclipse.xtext.xbase.formatting.XbaseFormatterConfigKeys
import org.eclipse.xtext.xbase.junit.formatter.FormatterTester
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseFormatterTestInjectorProvider))
abstract class AbstractXbaseFormatterTest {
	@Inject FormatterTester tester
	@Inject XbaseFormatterConfigKeys keys

	def assertFormatted(CharSequence toBeFormatted) {
		assertFormatted(toBeFormatted, toBeFormatted)
	}

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
			expectation.toString.trim.replace("\n", "\n\t"),
			toBeFormatted.toString.trim.replace("\n", "\n\t"),
			"{\n\t",
			"\n}",
			allowErrors
		)
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
			initConfig(it.cfg, cfg)
			it.expectation = expectation
			it.toBeFormatted = toBeFormatted
			it.prefix = prefix
			it.postfix = postfix
			it.allowErrors = allowErrors
		]
	}

	def initConfig(MapBasedConfigurationValues target, (MapBasedConfigurationValues)=>void cfg) {
		target.put(keys.maxLineWidth, 80)
		if (cfg != null)
			cfg.apply(target)
	}

}
