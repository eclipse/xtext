package org.eclipse.xtend.core.tests.formatting

import org.junit.Ignore
import org.junit.Test

class XtendCommentFormatterTest extends AbstractXtendFormatterTest {
	@Test def formatMLCommentBeforePackage() {
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
	
	@Test def formatMLComment1() {
		assertFormatted('''
			/***********
			 * copyright
			 ***********/
			class zonk {
			}
		''', '''
			/***********
			copyright
			***********/
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
	
	@Test def formatSLDocCommentInStatement21() {
		assertFormatted('''
			class bar {
				// my comment
			}
		''', '''
			class bar{
			 //    my comment
			}
		''')	
	}
	
	@Test def formatSLDocCommentInStatement22() {
		assertFormatted('''
			class bar {
				//
			}
		''', '''
			class bar{
			 //    
			}
		''')	
	}
	
	@Test def formatSLCodeCommentInStatement21() {
		assertFormatted('''
			class bar {
			//    my comment
			}
		''', '''
			class bar{
			//    my comment
			}
		''')	
	}
	
	@Test def formatMLCommentInBlock1() {
		assertFormatted('''
			class bar {
				/*
				 * my comment
				 */
			}
		''', '''
			class bar{
			/*
			my comment
			*/
			}
		''')	
	}
	
	@Test def formatMLCommentInBlock2() {
		assertFormatted('''
			class bar {
				/*
				 * my comment
				 */
			}
		''', '''
			class bar{
					/*
					my comment
					*/
			}
		''')	
	}
	
	@Test def formatMLCommentInBlock3() {
		assertFormatted('''
			class bar {
				/*
				 * my comment
				 */
			}
		''', '''
			class bar{
					/*
							*my comment
					*/
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
	
	@Test def formatMLCommentBeforeStatement22() {
		assertFormatted('''
			class AATest {
			
				/**
				 * genColumns
				 */
				def foo() {
				}
			}
		''')	
	}
	
	@Ignore("see https://bugs.eclipse.org/bugs/show_bug.cgi?id=415950")
	@Test def formatSLCommentAtEndOfClass() {
		assertFormatted('''
			class bar {
				val i = 0
				/* my comment */
			}
		''', '''
			class bar{
			val i = 0
			/* my comment */
			}
		''')	
	}
	
	@Ignore("see https://bugs.eclipse.org/bugs/show_bug.cgi?id=415950")
	@Test def formatSLCommentAtEndOfMethod() {
		assertFormatted('''
			class FormatterIssue {
				def method() {
					val i = 0
				
					// comment
				}
			}
		''')
	}
}