/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.fragments

import org.eclipse.xtext.junit4.AbstractXtextTests
import com.google.inject.Injector
import org.junit.Test
import org.eclipse.xtext.resource.XtextResource

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AbstractFragmentsPlainParsingTest extends AbstractXtextTests {

	override protected setInjector(Injector injector) {
		super.setInjector(injector)
		injectMembers(this)
	}
	
	override protected shouldTestSerializer(XtextResource resource) {
		// TODO implement serializer support for fragments
		false
	}
	
	@Test
	def void testSimpleModel() {
		'#1 myName'.model
	}
	
	@Test
	def void testReference() {
		'#2 myName -> myName'.model
	}
	
	@Test
	def void testReference_02() {
		'#1 myName : myName'.model
	}
	
	@Test
	def void testReferenceInFragment() {
		'#1 myName - myName'.model
	}
	
	@Test
	def void testReferenceBeforeFragment() {
		'#3 myName <- myName'.model
	}
	
	@Test
	def void testAction() {
		'#4 prev current'.model
	}
	
	@Test
	def void testActionAndReference() {
		'#4 prev current prev current'.model
	}
	
	@Test
	def void testActionInFragment_01() {
		'#5 prev current'.model
	}
	
	@Test
	def void testActionInFragment_02() {
		'#6 prev current'.model
	}
	
	@Test
	def void testActionInFragmentAndReference_01() {
		'#5 prev current current - prev'.model
	}
	
	@Test
	def void testActionInFragmentAndReference_02() {
		'#6 prev current current - prev'.model
	}
	
	@Test
	def void testActionInFragmentAndReferenceLoop() {
		'#7 root -> a a -> b b -> c c - root'.model
	}
	
	@Test
	def void testDatatypeRule_01() {
		'#8 a - a'.model
	}
	
	@Test
	def void testDatatypeRule_02() {
		'#8 a.b.c.d'.model
	}
	
	@Test
	def void testDatatypeRule_03() {
		'#8 a.b.c.d - a.b.c.d'.model
	}
}