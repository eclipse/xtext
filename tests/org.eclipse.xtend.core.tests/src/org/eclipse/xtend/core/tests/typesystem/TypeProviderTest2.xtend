/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem

import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider
import org.eclipse.xtend.core.tests.typing.TypeProviderTest
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XFeatureCall
import org.junit.Test
import org.junit.Ignore

/**
 * @author Sebastian Zarnekow
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
class TypeProviderTest2 extends TypeProviderTest {

	@Test
	override testReturnTypeInConstructor_01() throws Exception {
		val constructor = "new() { ''.toString }".constructor
		val body = constructor.expression as XBlockExpression
		assertEquals('void', typeProvider.getExpectedType(body).identifier)
		assertEquals('void', typeProvider.getExpectedReturnType(body, true).identifier)
		val toString = body.expressions.head as XMemberFeatureCall
		assertNull(typeProvider.getExpectedType(toString))
		assertNull(typeProvider.getExpectedReturnType(toString, true))
	}
	
	@Test
	override testTypeOfSuperInConstructor() throws Exception {
		val constructor = "new() { super() }".constructor
		val body = constructor.expression as XBlockExpression
		val superCall = body.expressions.head as XFeatureCall
		assertEquals("void", typeProvider.getType(superCall).getIdentifier());
		assertNull(typeProvider.getExpectedType(superCall))
		assertNull(typeProvider.getExpectedReturnType(superCall, true))
	}
	
	@Test
	override testTypeOfThisInConstructor() throws Exception {
		val constructor = "new(int a) { this() } new() {}".constructor
		val body = constructor.expression as XBlockExpression
		val thisCall = body.expressions.head as XFeatureCall
		assertEquals("void", typeProvider.getType(thisCall).getIdentifier());
		assertNull(typeProvider.getExpectedType(thisCall))
		assertNull(typeProvider.getExpectedReturnType(thisCall, true))
	}
	
	@Test
	@Ignore("TODO improve expectation if the expected type is an unresolved type parameter")
	override testTypeOfRichStringWithExpectedString_2() throws Exception {
		super.testTypeOfRichStringWithExpectedString_2()
	}
	
	@Test
	@Ignore("TODO improve expectation if the expected type is an unresolved type parameter") 
	override testTypeOfRichStringWithExpectedString_3() throws Exception {
		super.testTypeOfRichStringWithExpectedString_3()
	}
}