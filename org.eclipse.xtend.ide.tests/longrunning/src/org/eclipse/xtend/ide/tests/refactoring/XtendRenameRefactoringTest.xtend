/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring

import org.junit.Test
import org.junit.Ignore

class XtendRenameRefactoringTest extends AbstractXtendRenameRefactoringTest {
	
	@Ignore("https://github.com/eclipse/xtext-xtend/issues/164")
	@Test def testRenameXtendMember() {
		testHelper.createFile("testb/B.java", '''
			package testb;
			
			import testa.A;
			
			public class B {
			
			}
		''')
		val xtendModel = '''
			package testa
«««Removing this import makes the test pass
			import testb.B
			
			class A {
			
				val ARROWHEAD__E = ""
			
				private interface IAttributeValueParser<T> {
			
				}
			
				val ENUM_PARSER = new IAttributeValueParser<Splines>(){
			
				}
			
				val SPLINES_PARSER = new IAttributeValueParser<Splines>(){
			
				}
			
				@SuppressWarnings("unchecked")
				def a(IAttributeValueParser<Splines> parser) {
				}
			
				def b(){
					a(SPLINES_PARSER)
				}
			}
			
			class Splines{
			
			}
		'''
		val editor = openEditorSafely("A.xtend", xtendModel)
			
		editor.renameXtendElement(xtendModel.indexOf("ARROWHEAD__E"), "arrowhead__e1")
			
		editor.assertDocumentContains("arrowhead__e1")
	}
}