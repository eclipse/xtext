package org.eclipse.xtend.core.tests.formatting

import org.junit.Test
import org.junit.Ignore

class XtendRichStringFormatterTest extends AbstractFormatterTest {
	
	@Ignore
	@Test def testIf1() {
		val x = '''
			foo
				«IF true»
					bar
				«ENDIF»
		''' 
		
		assertFormattedExpression(/* "'''\n«IF true»\n       foo\n«ENDIF»\n'''", */
			"'''\nfoo\n    «IF true»\n        bar\n    «ENDIF»\n'''"
		)
	}
}