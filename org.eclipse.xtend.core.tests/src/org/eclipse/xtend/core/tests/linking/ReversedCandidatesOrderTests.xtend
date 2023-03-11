/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.linking

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(RuntimeInjectorProviderWithReversedCandidates))
class LinkingWithReversedCandidatesTest extends LinkingTest {
	
	@Ignore("TODO") @Test
	override testOverloadedWithLambdaArgument_01() throws Exception {
		super.testOverloadedWithLambdaArgument_01()
	}
	
	@Ignore("TODO") @Test
	override testExtensionMethodCall_Bug351827_01() throws Exception {
		super.testExtensionMethodCall_Bug351827_01()
	}
	
	@Ignore("TODO") @Test
	override testExtensionMethodCall_Bug351827_02() throws Exception {
		super.testExtensionMethodCall_Bug351827_02()
	}
	
	@Ignore("TODO") @Test
	override testExtensionMethodCall_Bug351827_04() throws Exception {
		super.testExtensionMethodCall_Bug351827_04()
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(RuntimeInjectorProviderWithReversedCandidates))
class AssignmentLinkingWithReversedCandidatesTest extends AssignmentLinkingTest {}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(RuntimeInjectorProviderWithReversedCandidates))
class LinkingShadowingWithReversedCandidatesTest extends LinkingShadowingTest {
	
	@Ignore("TODO") @Test
	override testOperation_implicitArgumentOnThis_shadows_implicitArgumentOnExtension() throws Exception {
		super.testOperation_implicitArgumentOnThis_shadows_implicitArgumentOnExtension()
	}
	
	@Ignore("TODO") @Test
	override testOperation_sugarImplicitArgumentOnThis_shadows_sugarImplicitArgumentOnExtension() throws Exception {
		super.testOperation_sugarImplicitArgumentOnThis_shadows_sugarImplicitArgumentOnExtension()
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(RuntimeInjectorProviderWithReversedCandidates))
class InferredJvmModelShadowingJavaLinkingWithReversedCandidatesTest extends InferredJvmModelShadowingJavaLinkingTests {}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(RuntimeInjectorProviderWithReversedCandidates))
class InheritedStaticMethodWithReversedCandidatesTest extends InheritedStaticMethodTest {}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(RuntimeInjectorProviderWithReversedCandidates))
class InheritedInstanceMethodWithReversedCandidatesTest extends InheritedInstanceMethodTest {}