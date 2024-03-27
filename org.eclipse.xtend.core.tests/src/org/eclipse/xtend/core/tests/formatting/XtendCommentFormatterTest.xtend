/*******************************************************************************
 * Copyright (c) 2012, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.formatting

import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.AbstractFormatterTest
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
class XtendCommentFormatterTest extends AbstractFormatterTest {

	@Test def formatMLCommentBeforePackage() {
		'''
			/***********
			 * copyright
			 ***********/package foo
			class zonk {}
		'''.assertFormattedTo('''
			/***********
			 * copyright
			 ***********/
			package foo
			
			class zonk {
			}
		''')
	}

	@Test def formatMLComment1() {
		'''
			/***********
			copyright
			***********/
			class zonk {}
		'''.assertFormattedTo('''
			/***********
			 * copyright
			 ***********/
			class zonk {
			}
		''')
	}

	@Test def formatSLCommentAfterStatement() {
		'''
			package foo // my comment
			class bar{}
		'''.assertFormattedTo('''
			package foo // my comment
			
			class bar {
			}
		''')
	}

	@Test def formatSLCommentBeforeStatement1() {
		'''
			package foo 
			// my comment
			class bar{}
		'''.assertFormattedTo('''
			package foo
			
			// my comment
			class bar {
			}
		''')
	}

	@Test def formatSLCommentBeforeStatement2() {
		'''
			package foo import java.util.Map 




			// my comment
			class bar{}
		'''.assertFormattedTo('''
			package foo

			import java.util.Map

			// my comment
			class bar {
			}
		''')
	}

	@Test def formatMLCommentAfterStatement() {
		'''
			package foo /* my comment */
			class bar{}
		'''.assertFormattedTo('''
			package foo /* my comment */
			
			class bar {
			}
		''')
	}

	@Test def formatSLCommentInStatement() {
		'''
			package  /* my comment */  foo
			class bar{}
		'''.assertFormattedTo('''
			package /* my comment */ foo
			
			class bar {
			}
		''')
	}

	@Test def formatMLCommentInStatement() {
		'''
			package  /* my 
			comment */  foo
			class bar{}
		'''.assertFormattedTo('''
			package
			/* my 
			 comment */
			foo

			class bar {
			}
		''')
	}

	@Test def formatMLCommentBeforeStatement1() {
		'''
			package foo 
			/* my comment */
			class bar{}
		'''.assertFormattedTo('''
			package foo

			/* my comment */
			class bar {
			}
		''')
	}

	@Test def formatMLCommentBeforeStatement2() {
		'''
			import java.util.Map 




			/* my comment */
			class bar{}
		'''.assertFormattedTo('''
			import java.util.Map

			/* my comment */
			class bar {
			}
		''')
	}

	@Test def formatSLCommentAfterStatement2() {
		'''
			class bar{    // my comment
			}
		'''.assertFormattedTo('''
			class bar { // my comment
			}
		''')
	}

	@Test def formatSLDocCommentInStatement21() {
		'''
			class bar{
			 //    my comment
			}
		'''.assertFormattedTo('''
			class bar {
				// my comment
			}
		''')
	}

	@Test def formatSLDocCommentInStatement22() {
		'''
			class bar{
			 //    
			}
		'''.assertFormattedTo('''
			class bar {
				//
			}
		''')
	}

	@Test def formatSLCodeCommentInStatement21() {
		'''
			class bar{
			//    my comment
			}
		'''.assertFormattedTo('''
			class bar {
			//    my comment
			}
		''')
	}

	@Test def formatMLCommentInBlock1() {
		'''
			class bar{
			/*
			my comment
			*/
			}
		'''.assertFormattedTo('''
			class bar {
				/*
				 * my comment
				 */
			}
		''')
	}

	@Test def formatMLCommentInBlock2() {
		'''
			class bar{
					/*
					my comment
					*/
			}
		'''.assertFormattedTo('''
			class bar {
				/*
				 * my comment
				 */
			}
		''')
	}

	@Test def formatMLCommentInBlock3() {
		'''
			class bar{
					/*
							*my comment
					*/
			}
		'''.assertFormattedTo('''
			class bar {
				/*
				 * my comment
				 */
			}
		''')
	}

	@Test def formatMLCommentAfterStatement2() {
		'''
			class bar{   /* my comment */ 
			}
		'''.assertFormattedTo('''
			class bar { /* my comment */
			}
		''')
	}

	@Test def formatMLCommentBeforeStatement21() {
		'''
			class bar{
			/* my comment */
			}
		'''.assertFormattedTo('''
			class bar {
				/* my comment */
			}
		''')
	}

	@Test def formatMLCommentBeforeStatement22() {
		'''
			class AATest {
			
				/**
				 * genColumns
				 */
				def foo() {
				}
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Ignore("see https://bugs.eclipse.org/bugs/show_bug.cgi?id=415950")
	@Test def formatSLCommentAtEndOfClass() {
		'''
			class bar {
				val i = 0
				/* my comment */
			}
		'''.assertFormattedTo('''
			class bar{
			val i = 0
			/* my comment */
			}
		''')
	}

	@Ignore("see https://bugs.eclipse.org/bugs/show_bug.cgi?id=415950")
	@Test def formatSLCommentAtEndOfMethod() {
		'''
			class FormatterIssue {
				def method() {
					val i = 0
				
					// comment
				}
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Ignore("see https://github.com/eclipse/xtext-xtend/issues/77")
	@Test def formatSLCommentAfterCode() {
		'''
			class bar {
				def method() { // comment
				
					val i = 0
				}
			}
		'''.assertUnformattedEqualsFormatted
	}
}