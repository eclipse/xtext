/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.access.IJvmTypeProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * @author koehnlein - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(Java8RuntimeInjectorProvider)
class Java8TypeProviderTest {
	
	@Inject IJvmTypeProvider.Factory typeProviderFactory;
	
	@Test def testDefaultJavaMethod() {
		doTestMethods(JavaInterface)		
	}
	@Test def testDefaultXtendMethod() {
		doTestMethods(XtendInterface)
	}

	protected def doTestMethods(Class<?> type) {
		val typeProvider = typeProviderFactory.createTypeProvider
		val intf = typeProvider.findTypeByName(type.canonicalName)
		assertTrue(intf instanceof JvmGenericType)
		val staticMethod = (intf as JvmGenericType).members.filter(JvmOperation).filter[simpleName=='staticMethod'].head
		assertNotNull(staticMethod)
		assertFalse((staticMethod).abstract)
		assertTrue((staticMethod).^static)
		assertFalse((staticMethod).^default)

		val defaultMethod = (intf as JvmGenericType).members.filter(JvmOperation).filter[simpleName=='defaultMethod'].head
		assertNotNull(defaultMethod)
		assertFalse((defaultMethod).abstract)
		assertFalse((defaultMethod).^static)
		// TODO fails, see https://bugs.eclipse.org/bugs/show_bug.cgi?id=427298
		//assertTrue((defaultMethod).^default)
	} 
}

interface XtendInterface {
	def void defaultMethod() {} 
	static def void staticMethod() {}
}