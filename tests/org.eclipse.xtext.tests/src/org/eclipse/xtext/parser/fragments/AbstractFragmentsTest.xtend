/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.fragments

import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.nodemodel.impl.InvariantChecker
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamedWithAction
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.ParserRuleFragments
import org.eclipse.xtext.resource.XtextResource
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractFragmentsTest extends AbstractXtextTests {

	@Inject
	extension ParseHelper<ParserRuleFragments> parseHelper
	
	@Inject
	extension ValidationTestHelper validationTestHelper
	
	@Inject
	extension InvariantChecker invariantChecker
	
	override protected setInjector(Injector injector) {
		super.setInjector(injector)
		injectMembers(this)
	}
	
	@Test
	def void testSimpleModel() {
		val fragments = '#1 myName'.parseAndValidate
		assertNotNull(fragments)
		assertEquals('myName', fragments.element.name)
	}
	
	@Test
	def void testReference() {
		val fragments = '#2 myName -> myName'.parseAndValidate
		assertNotNull(fragments)
		assertEquals('myName', fragments.element.name)
		assertEquals(fragments.element, fragments.ref)
	}
	
	@Test
	def void testReference_02() {
		val fragments = '#1 myName : myName'.parseAndValidate
		assertNotNull(fragments)
		assertEquals('myName', fragments.element.name)
		assertEquals(fragments.element, fragments.element.ref)
	}
	
	@Test
	def void testReferenceInFragment() {
		val fragments = '#1 myName - myName'.parseAndValidate
		assertNotNull(fragments)
		assertEquals('myName', fragments.element.name)
		assertEquals(fragments.element, fragments.element.ref)
	}
	
	@Test
	def void testReferenceBeforeFragment() {
		val fragments = '#3 myName <- myName'.parseAndValidate
		assertNotNull(fragments)
		assertEquals('myName', fragments.element.name)
		assertEquals(fragments.element, fragments.element.ref)
	}
	
	@Test
	def void testAction() {
		val fragments = '#4 prev current'.parseAndValidate
		assertNotNull(fragments)
		assertEquals('current', fragments.element.name)
		assertEquals('prev', (fragments.element as PRFNamedWithAction).prev.name)
	}
	
	@Test
	def void testActionAndReference() {
		val fragments = '#4 prev current prev current'.parseAndValidate
		assertNotNull(fragments)
		val element = fragments.element
		assertEquals('current', element.name)
		val prev = (element as PRFNamedWithAction).prev
		assertEquals('prev', prev.name)
		
		assertEquals(prev, element.ref)
		assertEquals(element, (element as PRFNamedWithAction).ref2)
	}
	
	@Test
	def void testActionInFragment_01() {
		val fragments = '#5 prev current'.parseAndValidate
		assertNotNull(fragments)
		assertEquals('current', fragments.element.name)
		assertEquals('prev', (fragments.element as PRFNamedWithAction).prev.name)
	}
	
	@Test
	def void testActionInFragment_02() {
		val fragments = '#6 prev current'.parseAndValidate
		assertNotNull(fragments)
		assertEquals('current', fragments.element.name)
		assertEquals('prev', (fragments.element as PRFNamedWithAction).prev.name)
	}
	
	@Test
	def void testActionInFragmentAndReference_01() {
		val fragments = '#5 prev current current - prev'.parseAndValidate
		assertNotNull(fragments)
		val element = fragments.element
		assertEquals('current', element.name)
		val prev = (element as PRFNamedWithAction).prev
		assertEquals('prev', prev.name)
		
		assertEquals(prev, element.ref)
		assertEquals(element, (element as PRFNamedWithAction).ref2)
	}
	
	@Test
	def void testActionInFragmentAndReference_02() {
		val fragments = '#6 prev current current - prev'.parseAndValidate
		assertNotNull(fragments)
		val element = fragments.element
		assertEquals('current', element.name)
		val prev = (element as PRFNamedWithAction).prev
		assertEquals('prev', prev.name)
		
		assertEquals(prev, element.ref)
		assertEquals(element, (element as PRFNamedWithAction).ref2)
	}
	
	@Test
	def void testActionInFragmentAndReferenceLoop() {
		val fragments = '#7 root -> a a -> b b -> c c - root'.parseAndValidate
		assertNotNull(fragments)
		
		var element = fragments.element
		while(element instanceof PRFNamedWithAction) {
			assertEquals(element, element.ref2)
			element = element.prev
		}
		assertEquals(element, element.ref)
	}
	
	@Test
	def void testDatatypeRule_01() {
		val fragments = '#8 a - a'.parseAndValidate
		assertNotNull(fragments)
		
		var element = fragments.element
		assertEquals(element, element.ref)
	}
	
	@Test
	def void testDatatypeRule_02() {
		val fragments = '#8 a.b.c.d'.parseAndValidate
		assertNotNull(fragments)
		
		var element = fragments.element
		assertEquals('a.b.c.d', element.name)
	}
	
	@Test
	def void testDatatypeRule_03() {
		val fragments = '#8 a.b.c.d - a.b.c.d'.parseAndValidate
		assertNotNull(fragments)
		
		var element = fragments.element
		assertEquals(element, element.ref)
	}
	
	protected def parseAndValidate(CharSequence s) {
		val result = s.parse
		result.assertNoIssues
		val resource = result.eResource as XtextResource
		val node = resource.parseResult.rootNode
		node.checkInvariant
		return result
	}
	
}