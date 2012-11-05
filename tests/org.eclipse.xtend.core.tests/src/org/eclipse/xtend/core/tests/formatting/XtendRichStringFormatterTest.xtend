package org.eclipse.xtend.core.tests.formatting

import org.junit.Test

class XtendRichStringFormatterTest extends AbstractFormatterTest {
	
	@Test def testSimple() {
		assertFormattedExpression(
			"val x = '''foo''';", 
			"val  x  =  '''foo''' ;"
		)
	}
	
	@Test def testSimpleVar() {
		assertFormattedExpression(
			"val x = '''foo«newArrayList()»bar''';", 
			"val  x  =  '''foo«  newArrayList()  »bar''' ;"
		)
	}
	
	@Test def testIndentation1() {
		assertFormattedExpression(
			"val x = '''\n" +
            "	foo\n" +
            "''';",
            "val  x  = '''\n" +
            "foo\n" +
            "''' ;"
		)
	}
	
	@Test def testIndentation2() {
		assertFormattedExpression(
			"val x = '''x\n" +
            "foo\n" +
            "''';",
            "val  x  = '''x\n" +
            "foo\n" +
            "''' ;"
		)
	}
	
	@Test def testIndentation3() {
		assertFormattedExpression(
			"val x = '''x\n" +
            "  foo\n" +
            "''';",
            "val  x  = '''x\n" +
            "  foo\n" +
            "  ''' ;"
		)
	}
	
	@Test def testIndentation4() {
		assertFormattedExpression(
			"val x = '''\n" +
            "  foo\n" +
            "x''';",
            "val  x  = '''\n" +
            "  foo\n" +
            "x''' ;"
		)
	}
	
	@Test def testIndentation5() {
		val x = '''
				foo
					«IF true»
						bar
					«ENDIF»
		''' 
		
		assertFormattedExpression(
			"'''\n"+
			"	foo\n"+
			"	   «IF true»\n"+
			"	      bar\n"+
			"	   «ENDIF»\n"+
			"'''",
			"'''\n"+
			"foo\n"+
			"   «IF true»\n"+
			"      bar\n"+
			"   «ENDIF»\n"+
			"'''"
		)
	}
}