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
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtend.core.xtend.XtendFile

/**
 * @author koehnlein - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(Java8RuntimeInjectorProvider)
class Java8TypeProviderTest {
	
	@Inject IJvmTypeProvider.Factory typeProviderFactory;
	
	@Inject ParseHelper<XtendFile> parseHelper
	
	@Test def testDefaultJavaMethod() {
		val typeProvider = typeProviderFactory.createTypeProvider
		val intf = typeProvider.findTypeByName(JavaInterface.canonicalName) as JvmGenericType
		doTestMethods(intf)		
	}
	@Test def testDefaultXtendMethod() {
		val file = parseHelper.parse('''
			interface XtendInterface {
				def void defaultMethod() {} 
				static def void staticMethod() {}
			}
		''')
		val intf = file.eResource.contents.last as JvmGenericType
		doTestMethods(intf)
	}

	protected def doTestMethods(JvmGenericType intf) {
		val staticMethod = intf.members.filter(JvmOperation).filter[simpleName=='staticMethod'].head
		assertNotNull(staticMethod)
		assertFalse((staticMethod).abstract)
		assertTrue((staticMethod).^static)
		assertFalse((staticMethod).^default)

		val defaultMethod = intf.members.filter(JvmOperation).filter[simpleName=='defaultMethod'].head
		assertNotNull(defaultMethod)
		assertFalse((defaultMethod).abstract)
		assertFalse((defaultMethod).^static)
		assertTrue((defaultMethod).^default)
	} 
}

