package org.eclipse.xtend.core.tests.formatting

import org.eclipse.xtend.core.tests.formatting.AbstractXtendFormatterTest
import org.junit.Test

class XtendCommentFormatterTest extends AbstractXtendFormatterTest {
	@Test def formatSLCommentAfterpackage() {
		assertFormatted('''
			/***********
			 * copyright
			 ***********/
			package foo
			
			class zonk {
			}
		''', '''
			/***********
			 * copyright
			 ***********/package foo
			class zonk {}
		''')	
	}
	
	@Test def formatSLCommentAfterStatement() {
		assertFormatted('''
			package foo // my comment
			
			class bar {
			}
		''', '''
			package foo // my comment
			class bar{}
		''')	
	}
	
	@Test def formatSLCommentBeforeStatement1() {
		assertFormatted('''
			package foo
			
			// my comment
			class bar {
			}
		''', '''
			package foo 
			// my comment
			class bar{}
		''')	
	}
	
	@Test def formatSLCommentBeforeStatement2() {
		assertFormatted('''
			package foo
			
			import java.util.Map
			
			// my comment
			class bar {
			}
		''', '''
			package foo import java.util.Map 
			
			
			
			
			// my comment
			class bar{}
		''')	
	}
	
	@Test def formatMLCommentAfterStatement() {
		assertFormatted('''
			package foo /* my comment */
			
			class bar {
			}
		''', '''
			package foo /* my comment */
			class bar{}
		''')	
	}
	
	@Test def formatSLCommentInStatement() {
		assertFormatted('''
			package /* my comment */ foo
			
			class bar {
			}
		''', '''
			package  /* my comment */  foo
			class bar{}
		''')	
	}
	
	@Test def formatMLCommentInStatement() {
		assertFormatted('''
			package
			/* my 
			comment */
			foo
			
			class bar {
			}
		''', '''
			package  /* my 
			comment */  foo
			class bar{}
		''')	
	}
	
	@Test def formatMLCommentBeforeStatement1() {
		assertFormatted('''
			package foo
			
			/* my comment */
			class bar {
			}
		''', '''
			package foo 
			/* my comment */
			class bar{}
		''')	
	}
	
	@Test def formatMLCommentBeforeStatement2() {
		assertFormatted('''
			import java.util.Map
			
			/* my comment */
			class bar {
			}
		''', '''
			import java.util.Map 
			
			
			
			
			/* my comment */
			class bar{}
		''')	
	}
	
	@Test def formatSLCommentAfterStatement2() {
		assertFormatted('''
			class bar { // my comment
			}
		''', '''
			class bar{    // my comment
			}
		''')	
	}
	
	@Test def formatSLCommentBeforeStatement21() {
		assertFormatted('''
			class bar {
				// my comment
			}
		''', '''
			class bar{
			// my comment
			}
		''')	
	}
	
	@Test def formatMLCommentAfterStatement2() {
		assertFormatted('''
			class bar { /* my comment */
			}
		''', '''
			class bar{   /* my comment */ 
			}
		''')	
	}
	
	@Test def formatMLCommentBeforeStatement21() {
		assertFormatted('''
			class bar {
				/* my comment */
			}
		''', '''
			class bar{
			/* my comment */
			}
		''')	
	}
}