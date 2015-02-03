/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.javadoc

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.resource.XtextResource
import org.junit.Test
import org.eclipse.emf.ecore.EObject

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
		'''.assertDocumentation("my javadoc comment")
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
		'''.assertDocumentation("my javadoc comment")
	}	

	def private void assertDocumentation(CharSequence input, String expectedDocumentation) {
		val resource = clazz(input.toString).eResource as XtextResource
		val eObject = resource.parseResult.rootASTElement.assertInstanceOf(XtendFile).xtendTypes.filter(XtendClass).head
		val actualDocumentation = documentationProvider.getDocumentation(eObject)
		assertEquals(expectedDocumentation, actualDocumentation)
	}	
	
	def private <T> T assertInstanceOf(EObject object, Class<T> expectedType) {
		assertTrue(expectedType.isAssignableFrom(object.class))
		object as T
	}
}