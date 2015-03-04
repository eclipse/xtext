/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.completion

import org.eclipse.xtend.idea.LightXtendTest

class XtendCompletionTest extends LightXtendTest {

	def void testClassKeyword() {
		complete("cl<caret>")
		assertLookupStrings("class")
	}
	
	def void testExtendsKeyword() {
		complete("class Foo ex<caret>")
		assertLookupStrings("extends")
	}
	
	def void testEmptyFile() {
		complete("")
		assertLookupStrings(
			"annotation",
			"class",
			"enum",
			"import",
			"interface",
			"package"
		)
	}
	
	def void testJvmParameterizedTypeReference_Type() {
		"class Foo extends Array<caret>".complete
		val lookupElementStrings = lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testJvmParameterizedTypeReference_Type_02() {
		'''
		   class Foo {
		   		def Array<caret> foo() {}
		   }
		'''.toString.complete
		val lookupElementStrings = lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testJvmParameterizedTypeReference_Type_03() {
		"class Foo <caret> {".complete
		assertLookupStrings(
			"extends",
			"implements"
		)
	}
	
	def void testXImportDeclaration_ImportedType() {
		"import <caret>".complete
		val lookupElementStrings = lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testXImportDeclaration_ImportedType_02() {
		"import java.util.Array<caret>".complete
		val lookupElementStrings = lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
	}
	
	def void testXConstructorCall_Constructor() {
		'''
		   class Foo {
		   		def foo() {
		   			new <caret>
		   		}
		   }
		   
		   class Bar {}
		   
		   abstract class AbstractBar {}
		   
		   interface InterfaceBar {}
		'''.toString.complete
		val lookupElementStrings = lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("Bar"))
		assertFalse(lookupElementStrings.toString, lookupElementStrings.contains("AbstractBar"))
		assertFalse(lookupElementStrings.toString, lookupElementStrings.contains("InterfaceBar"))
	}
	
	def void testXTypeLiteral_Type() {
		'''
		   class Foo {
		   		def foo() {
		   			typeof(<caret>
		   		}
		   }
		'''.toString.complete
		val lookupElementStrings = lookupElementStrings
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("ArrayList"))
		assertTrue(lookupElementStrings.toString, lookupElementStrings.contains("Foo"))
	}
}