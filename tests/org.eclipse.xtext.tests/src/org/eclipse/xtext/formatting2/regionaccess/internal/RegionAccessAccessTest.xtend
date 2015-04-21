/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.Collection
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root
import org.eclipse.xtext.formatting2.regionaccess.internal.services.RegionAccessTestLanguageGrammarAccess
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.resource.XtextResource
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage.Literals.*
import static org.junit.Assert.*
import com.google.common.collect.ImmutableList

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(RegionAccessTestLanguageInjectorProvider)
class RegionAccessAccessTest {
	@Inject extension ParseHelper<Root> parseHelper
	@Inject Provider<TextRegionAccessBuilder> textRegionAccessBuilder
	@Inject extension ValidationTestHelper validationTestHelper
	@Inject extension RegionAccessTestLanguageGrammarAccess

	@Test def void regionForFeatureAttribute() {
		val mixed = '''6 (foo)'''.parseAs(Mixed)
		val access = mixed.toAccess
		val actual = access.regionForFeature(mixed, MIXED__NAME)
		val actuals = access.regionsForFeatures(mixed, MIXED__NAME)
		assertEquals("foo", actual, actuals)
	}

	@Test def void regionForFeatureCrossReference() {
		val mixed = '''6 (ref foo) action (foo) end'''.parseAs(AssignedAction)
		val access = mixed.toAccess
		val actual = access.regionForFeature(mixed.child, MIXED__REF)
		val actuals = access.regionsForFeatures(mixed.child, MIXED__REF)
		assertEquals("foo", actual, actuals)
	}

	def void regionForFeatureContainmentReference() {
		val mixed = '''6 (foo) action'''.parseAs(AssignedAction)
		val access = mixed.toAccess
		try {
			access.regionForFeature(mixed, ASSIGNED_ACTION__CHILD)
			fail()
		} catch (IllegalStateException e) {
		}
		try {
			access.regionsForFeatures(mixed, ASSIGNED_ACTION__CHILD)
			fail()
		} catch (IllegalStateException e) {
		}
	}

	@Test def void regionForRuleCallUnassignedTerminal() {
		val mixed = '''6 (unassigned foo)'''.parseAs(Mixed)
		val access = mixed.toAccess
		val actual = access.regionForRuleCall(mixed, mixedAccess.IDTerminalRuleCall_1_1_0)
		val actuals = access.regionsForRuleCalls(mixed, mixedAccess.IDTerminalRuleCall_1_1_0)
		assertEquals("foo", actual, actuals)
	}

	@Test def void regionForRuleCallUnassignedDataType() {
		val mixed = '''6 (unassigned datatype foo)'''.parseAs(Mixed)
		val access = mixed.toAccess
		val actual = access.regionForRuleCall(mixed, mixedAccess.datatypeParserRuleCall_1_1_1)
		val actuals = access.regionsForRuleCalls(mixed, mixedAccess.datatypeParserRuleCall_1_1_1)
		assertEquals("datatype foo", actual, actuals)
	}

	@Test def void regionForRuleCallAssignedTerminal() {
		val mixed = '''6 (foo)'''.parseAs(Mixed)
		val access = mixed.toAccess
		val actual = access.regionForRuleCall(mixed, mixedAccess.nameIDTerminalRuleCall_2_2_0_0)
		val actuals = access.regionForRuleCall(mixed, mixedAccess.nameIDTerminalRuleCall_2_2_0_0)
		assertEquals("foo", actual, actuals)
	}

	@Test def void regionForRuleCallAssignedDataType() {
		val mixed = '''6 (datatype foo)'''.parseAs(Mixed)
		val access = mixed.toAccess
		val actual = access.regionForRuleCall(mixed, mixedAccess.datatypeDatatypeParserRuleCall_2_2_2_0)
		val actuals = access.regionForRuleCall(mixed, mixedAccess.datatypeDatatypeParserRuleCall_2_2_2_0)
		assertEquals("datatype foo", actual, actuals)
	}

	@Test def void regionForRuleCallCrossReference() {
		val mixed = '''6 (ref foo) action (foo) end'''.parseAs(AssignedAction)
		val access = mixed.toAccess
		val actual = access.regionForRuleCall(mixed.child, mixedAccess.refMixedIDTerminalRuleCall_2_2_3_1_0_1)
		val actuals = access.regionsForRuleCalls(mixed.child, mixedAccess.refMixedIDTerminalRuleCall_2_2_3_1_0_1)
		assertEquals("foo", actual, actuals)
	}

	def void regionForRuleCallEObjectParserRule() {
		val mixed = '''6 (child foo)'''.parseAs(Mixed)
		val access = mixed.toAccess
		try {
			access.regionForRuleCall(mixed, mixedAccess.eobjMixedParserRuleCall_2_2_1_1_0)
			fail()
		} catch (IllegalStateException e) {
		}
		try {
			access.regionsForRuleCalls(mixed, mixedAccess.eobjMixedParserRuleCall_2_2_1_1_0)
			fail()
		} catch (IllegalStateException e) {
		}
	}

	def private <T extends EObject> parseAs(CharSequence seq, Class<T> cls) {
		val result = seq.parse
		result.assertNoErrors
		return cls.cast(result)
	}

	def private ITextRegionAccess toAccess(EObject obj) {
		return textRegionAccessBuilder.get.forNodeModel(obj.eResource as XtextResource).create
	}

	def private void assertEquals(String expected, ITextSegment single, Collection<? extends ITextSegment> regions) {
		assertEquals(expected, single.text)
		assertEquals(1, regions.size)
		assertEquals(expected, regions.head.text)
		assertTrue(regions instanceof ImmutableList<?>)
	}
}