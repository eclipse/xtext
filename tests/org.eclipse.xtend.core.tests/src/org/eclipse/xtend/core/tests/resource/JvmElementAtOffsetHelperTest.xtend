/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.resource

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.xbase.resource.JvmElementAtOffsetHelper
import org.junit.Test

/**
 * @author Holger Schill - Initial contribution and API
 */
class JvmElementAtOffsetHelperTest extends AbstractXtendTestCase {

	@Inject
	JvmElementAtOffsetHelper jvmElementAtOffsetHelper

	@Test
	def void testdeclaration() {
		val content = '''
			package testPackage
			class TestCase {
				def fo|o(String a){
					bar(a)
				}
				def bar(String a){}
			}
		'''
		val file = this.file(content.replace("|", ""))
		var jvmIdentifiableElement = jvmElementAtOffsetHelper.getJvmIdentifiableElement(file.eResource as XtextResource,
			content.indexOf("|"))
		assertTrue(jvmIdentifiableElement instanceof JvmOperation)
		assertEquals("testPackage.TestCase.foo", jvmIdentifiableElement.qualifiedName)
	}

	@Test
	def void testRef() {
		val content = '''
			package testPackage
			class TestCase {
				def foo(String a){
					ba|r(a)
				}
				def bar(String a){}
			}
		'''
		val file = this.file(content.replace("|", ""))
		var jvmIdentifiableElement = jvmElementAtOffsetHelper.getJvmIdentifiableElement(file.eResource as XtextResource,
			content.indexOf("|"))
		assertTrue(jvmIdentifiableElement instanceof JvmOperation)
		assertEquals("testPackage.TestCase.bar", jvmIdentifiableElement.qualifiedName)
	}

	@Test
	def void testRefOtherClass() {
		val content = '''
			package testPackage
			class TestCase {
				def foo(String a){
					a.toStr|ing
				}
				def bar(String a){}
			}
		'''
		val file = this.file(content.replace("|", ""))
		var jvmIdentifiableElement = jvmElementAtOffsetHelper.getJvmIdentifiableElement(file.eResource as XtextResource,
			content.indexOf("|"))
		assertTrue(jvmIdentifiableElement instanceof JvmOperation)
		assertEquals("java.lang.String.toString", jvmIdentifiableElement.qualifiedName)
	}
}
