/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.conversion

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.RichString
import org.eclipse.xtend.core.xtend.RichStringLiteral
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.xbase.XStringLiteral
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ValueConverterExceptionProducesErrorTest extends AbstractXtendTestCase {
	
	@Test
	def void testUnclosedTerminal_01() throws Exception {
		val resource = "class C { def m() '''".toResource
		assertEquals(1, resource.errors.size)
		val error = resource.errors.head
		assertNotNull(error)
		assertEquals('String literal is not closed', error.message)
		assertLiteral('', resource)
	}
	
	@Test
	def void testUnclosedTerminal_02() throws Exception {
		val resource = "class C { def m() '''abc".toResource
		assertEquals(1, resource.errors.size)
		val error = resource.errors.head
		assertNotNull(error)
		assertEquals('String literal is not closed', error.message)
		assertLiteral('abc', resource)
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=428525
	 */
	@Test
	def void testInvalidUnicode() throws Exception {
		val resource = "class C { def m() {'\\u'.toString}}".toResource
		EcoreUtil2.resolveAll(resource)
		assertEquals(1, resource.errors.size)
		val error = resource.errors.head
		assertNotNull(error)
		assertEquals('Invalid unicode', error.message)
		val literal = resource.allContents.filter(XStringLiteral).head
		assertEquals("u", literal.value)
	}
	
	private def assertLiteral(String expectation, Resource resource) {
		val file = resource.contents.head as XtendFile
		val type = file.xtendTypes.head
		val method = type.members.head as XtendFunction
		val body = method.expression as RichString
		val singleElement = body.expressions.head as RichStringLiteral
		assertEquals(expectation, singleElement.value)
	}
		
	private def toResource(CharSequence input) throws Exception {
		val resource = resourceSet.createResource(URI::createURI("abcdefg.xtend"))
		resource.load(new StringInputStream(input.toString), null)
		return resource
	}
	
}