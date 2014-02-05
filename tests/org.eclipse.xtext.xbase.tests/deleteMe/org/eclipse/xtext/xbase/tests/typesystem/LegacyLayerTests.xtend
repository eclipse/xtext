/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider
import org.eclipse.xtext.xbase.typesystem.legacy.LegacyTypeArgumentContextProvider
import org.eclipse.xtext.xbase.typesystem.legacy.XbaseBatchTypeProvider
import org.eclipse.xtext.xbase.typing.ITypeProvider
import org.junit.Ignore
import org.junit.Test

/**
 * @author Sebastian Zarnekow
 */
class LegacyTypeResolverTest extends AbstractOldAPITypeResolverTest {

	@Inject
	ITypeProvider typeProvider
	
	override protected getTypeProvider() {
		typeProvider
	}
	
	@Test 
	def void testSetup() {
		assertTrue(typeProvider instanceof XbaseBatchTypeProvider)
	}
	
	@Ignore("TODO discuss the preference - list or array?") 
	@Test override testIfExpression_10() throws Exception {
		super.testIfExpression_10()
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class LegacyTypeArgumentTest extends AbstractOldAPITypeArgumentTest {
	
	@Inject
	ITypeProvider typeProvider
	
	@Inject
	TypeArgumentContextProvider typeArgumentContextProvider
	
	override protected getTypeProvider() {
		typeProvider
	}
	
	override protected getTypeArgumentContextProvider() {
		typeArgumentContextProvider
	}
	
	@Test 
	def void testSetup() {
		assertTrue(typeProvider instanceof XbaseBatchTypeProvider)
		assertTrue(typeArgumentContextProvider instanceof LegacyTypeArgumentContextProvider)
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testRawType_01() throws Exception {
		super.testRawType_01()
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testRawType_02() throws Exception {
		super.testRawType_02()
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testRawType_05() throws Exception {
		super.testRawType_05()
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testFeatureCallWithExpectation_01() throws Exception {
		super.testFeatureCallWithExpectation_01()
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testFeatureCallWithExpectation_02() throws Exception {
		super.testFeatureCallWithExpectation_02()
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testFeatureCallWithExpectation_04() throws Exception {
		super.testFeatureCallWithExpectation_04()
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testFeatureCallWithExpectation_05() throws Exception {
		super.testFeatureCallWithExpectation_05()
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class LegacyClosureTypeTest extends AbstractOldAPIClosureTypeTest {
	
	@Inject
	ITypeProvider typeProvider
	
	override protected getTypeProvider() {
		typeProvider
	}
	
	@Test 
	def void testSetup() {
		assertTrue(typeProvider instanceof XbaseBatchTypeProvider)
	}
	
	@Ignore("TODO the assertion should hold") 
	@Test override void testClosure_51() throws Exception {
		super.testClosure_51
	}
	
	@Ignore("TODO the assertion should hold") 
	@Test override void testClosure_52() throws Exception {
		super.testClosure_52
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class LegacyConstructorCallTypeTest extends AbstractOldAPIConstructorCallTypeTest {
	
	@Inject
	ITypeProvider typeProvider
	
	override protected getTypeProvider() {
		typeProvider
	}
	
	@Test 
	def void testSetup() {
		assertTrue(typeProvider instanceof XbaseBatchTypeProvider)
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class LegacyFeatureCallTypeTest extends AbstractOldAPIFeatureCallTypeTest {
	
	@Inject
	ITypeProvider typeProvider
	
	override protected getTypeProvider() {
		typeProvider
	}
	
	override protected findFeatureCalls(CharSequence expression) {
		super.findFeatureCalls(expression).filterTypeLiteralsAndPackageFragments.toList
	}
	
	@Test 
	def void testSetup() {
		assertTrue(typeProvider instanceof XbaseBatchTypeProvider)
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testRawType_01() throws Exception {
		super.testRawType_01()
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testRawType_02() throws Exception {
		super.testRawType_02()
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testRawType_05() throws Exception {
		super.testRawType_05()
	}
	
	@Test
	@Ignore("TODO This should work")
	override testBug_391758() throws Exception {
		super.testBug_391758()
	}
	
	@Test
	@Ignore("TODO Fix me")
	override testArray_09() throws Exception {
		super.testArray_09()
	}
}

/**
 * @author Sebastian Zarnekow
 */
class LegacyIdentifiableTypeTest extends AbstractOldAPIIdentifiableTypeTest {
	
	@Inject
	ITypeProvider typeProvider
	
	override protected getTypeProvider() {
		typeProvider
	}
	
	@Test 
	def void testSetup() {
		assertTrue(typeProvider instanceof XbaseBatchTypeProvider)
	}
	
}