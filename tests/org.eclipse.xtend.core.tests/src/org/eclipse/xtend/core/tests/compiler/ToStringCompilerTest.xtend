/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test

class ToStringCompilerTest extends AbstractXtendCompilerTest {
	@Inject
	extension ValidationTestHelper
	
	@Test
	def void testToString() {
		'''
			@ToString class Foo {
				static String ignoreMe
				transient String ignoreMe2
				def create {} ignoreMe3() {}
				int a = 1
			}
		'''.compile [
			val instance = compiledClass.newInstance
			
			assertEquals("Foo{a=1}", instance.toString)
		]
	}
	
	@Test
	def void testToStringWithSuperClass() {
		'''
			class Foo {
				int a = 1
			}
			@ToString class Bar extends Foo {
				String b = "Bar"
			}
		'''.compile [
			val instance = getCompiledClass("Bar").newInstance
			
			assertEquals('Bar [\n'+'  b = "Bar"\n' +'  a = 1\n' + ']', instance.toString)
		]
	}
	
	@Test
	def void testExistingToString() {
		val text = '''
			@ToString class Foo {
				int a = 1
				override toString() {
					"foo"
				}
			}
		'''
		text.clazz.assertWarning(XtendPackage.Literals.XTEND_CLASS,"user.issue", "no effect")
		text.compile [
			val instance = compiledClass.newInstance
			assertEquals("foo", instance.toString)
		]
	}
}