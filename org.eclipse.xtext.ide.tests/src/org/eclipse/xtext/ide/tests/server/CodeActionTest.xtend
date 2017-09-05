/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class CodeActionTest extends AbstractTestLangLanguageServerTest {

	@Test
	def void testCodeAction() {
		testCodeAction [
			model = '''
				type foo {
					
				}
			'''
			expectedCodeActions = '''
				command : my.textedit.command
				title : Make 'foo' upper case
				args : 
				    changes :
				        MyModel.testlang : Foo [[0, 5] .. [0, 8]]
				    documentChanges : 
			'''
		]
	}

	@Test
	def void testSemanticCodeAction() {
		testCodeAction [
			model = '''
				type Foo {
					String ccc
					String aaa
				}
				type String {}
			'''
			expectedCodeActions = '''
				command : my.textedit.command
				title : Sort Members
				args : 
				    changes :
				        MyModel.testlang : 
				            String aaa
				             [[0, 10] .. [1, 1]]
				        
				         [[1, 11] .. [3, 0]]
				    documentChanges : 
			'''
		]

	}

}
