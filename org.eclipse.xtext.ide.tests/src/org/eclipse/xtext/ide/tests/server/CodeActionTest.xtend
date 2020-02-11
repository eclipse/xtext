/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
				title : Sort Members
				kind : 
				command : 
				codes : unsorted_members
				edit : changes :
				    MyModel.testlang : 
				        String aaa
				     [[0, 10] .. [0, 10]]
				    
				     [[1, 11] .. [3, 0]]
				documentChanges : 
			'''
		]

	}

}
