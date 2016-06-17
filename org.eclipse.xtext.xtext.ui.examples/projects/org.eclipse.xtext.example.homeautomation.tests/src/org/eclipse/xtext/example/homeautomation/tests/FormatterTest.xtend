package org.eclipse.xtext.example.homeautomation.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.formatter.FormatterTester

class FormatterTest extends AbstractTest {

	@Inject extension FormatterTester

	override protected test(CharSequence document) {
		assertFormatted[
			toBeFormatted = document
		]
	}

}