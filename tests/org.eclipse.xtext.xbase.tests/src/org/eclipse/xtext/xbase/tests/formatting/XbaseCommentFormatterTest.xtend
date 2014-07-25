package org.eclipse.xtext.xbase.tests.formatting

import org.eclipse.xtext.xbase.tests.formatting.AbstractXbaseFormatterTest
import org.junit.Test

class XbaseCommentFormatterTest extends AbstractXbaseFormatterTest {

	@Test def commentInIfExpression() {
		assertFormattedExpression('''
			if (true)
				println("foo")
			else // if (true)
				println("bar")
			println("end")
		''')
	}
	
	@Test def commentAfterForExpression1() {
		assertFormattedExpression('''
			for (f : #[])
				if (1 < 2) {
				}

			// foo
			var lastOffset = ""
		''')
	}
	
	@Test def commentAfterForExpression3() {
		assertFormattedExpression('''
			val ll = #[].map(e|e.toString) // error here
		''')
	}
}
