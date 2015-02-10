/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.javadoc

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.junit.Test

/**
 * @author Joerg Reichert - Initial contribution and API
 */
class XtendDocumentationProviderTest extends AbstractXtendTestCase {
	@Inject private IEObjectDocumentationProvider documentationProvider

	@Test
	def void testComputation() {
		'''
			package foo

			/**
			 * my javadoc comment
			 */
			/*
			 * my multi line comment
			 */ 
			class Foo{}
		'''.assertClassDocumentation("my javadoc comment")
	}	

	@Test
	def void testComputation_2() {
		'''
			package foo

			/*
			 * my multi line comment
			 */ 
			/**
			 * my javadoc comment
			 */
			class Foo{}
		'''.assertClassDocumentation("my javadoc comment")
	}
	
	@Test
	def void testComputation_3() {
		'''
			/**
			 * my javadoc comment
			 */
			/*************************
			 * my copyright comment
			 ************************/ 
			package foo

			class Foo{}
		'''.assertFileDocumentation("my javadoc comment")
	}	

	@Test
	def void testComputation_4() {
		'''
			/*************************
			 * my copyright comment
			 ************************/ 
			/**my javadoc comment*/
			package foo

			class Foo{}
		'''.assertFileDocumentation("my javadoc comment")
	}	

	@Test
	def void testComputation_5() {
		'''
			/***my copyright comment*/ 
			package foo

			class Foo{}
		'''.assertFileDocumentation(null)
	}	

	def private void assertFileDocumentation(CharSequence input, String expectedDocumentation) {
		file(input.toString).assertDocumentation(expectedDocumentation)
	}
	
	def private void assertClassDocumentation(CharSequence input, String expectedDocumentation) {
		clazz(input.toString).assertDocumentation(expectedDocumentation)
	}

	def private void assertDocumentation(EObject eObject, String expectedDocumentation) {
		val actualDocumentation = documentationProvider.getDocumentation(eObject)
		assertEquals(expectedDocumentation, actualDocumentation)
	}	
}