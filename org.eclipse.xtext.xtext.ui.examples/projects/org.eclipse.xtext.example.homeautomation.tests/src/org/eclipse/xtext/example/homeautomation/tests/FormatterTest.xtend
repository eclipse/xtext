package org.eclipse.xtext.example.homeautomation.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.formatter.FormatterTestHelper

class FormatterTest extends AbstractTest {

	@Inject extension FormatterTestHelper

	override protected test(CharSequence document) {
		assertFormatted[
			toBeFormatted = document
		]
	}

}