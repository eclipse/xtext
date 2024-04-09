/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8

import com.google.inject.Inject
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.access.IJvmTypeProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
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
		val intf = file.eResource.contents.lastOrNull as JvmGenericType
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

