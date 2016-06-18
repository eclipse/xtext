package org.eclipse.xtext.xbase.tests.formatting

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XbaseFormatterTestInjectorProvider))
class XbaseCommentFormatterTest {

	@Inject extension XbaseFormatterTester

	@Test def commentInIfExpression() {
		assertFormattedExpression [
			toBeFormatted = '''
				if (true)
					println("foo")
				else // if (true)
					println("bar")
				println("end")
			'''
		]
	}

	@Test def commentAfterForExpression1() {
		assertFormattedExpression [
			toBeFormatted = '''
				for (f : #[])
					if (1 < 2) {
					}
				
				// foo
				var lastOffset = ""
			'''
		]
	}

	@Test def commentAfterForExpression3() {
		assertFormattedExpression [
			toBeFormatted = '''
				val ll = #[].map(e|e.toString) // error here
			'''
		]
	}
}
