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
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.resource.XtextResource
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage.Literals.*
import static org.junit.Assert.*
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(RegionAccessTestLanguageInjectorProvider)
class RegionAccessAccessTest {
	@Inject extension ParseHelper<Root> parseHelper
	@Inject Provider<TextRegionAccessBuilder> textRegionAccessBuilder
	@Inject extension ValidationTestHelper validationTestHelper

	@Test def void regionForFeatureAttribute() {
		val mixed = '''6 (foo)'''.parseAs(Mixed)
		val access = mixed.toAccess
		val actual = access.regionForFeature(mixed, MIXED__NAME)
		assertEquals("foo", actual.text)
	}

	@Test def void regionForFeatureCrossReference() {
		val mixed = '''6 (ref foo) action (foo) end'''.parseAs(AssignedAction)
		val access = mixed.toAccess
		val actual = access.regionForFeature(mixed.child, MIXED__REF)
		assertEquals("foo", actual.text)
	}

	@Test(expected=IllegalStateException) def void regionForFeatureContainmentReference() {
		val mixed = '''6 (foo) action'''.parseAs(AssignedAction)
		val access = mixed.toAccess
		val actual = access.regionForFeature(mixed, ASSIGNED_ACTION__CHILD)
		assertEquals("foo", actual.text)
	}

	@Test def void regionsForFeaturesAttribute() {
		val mixed = '''6 (foo)'''.parseAs(Mixed)
		val access = mixed.toAccess
		val actual = access.regionsForFeatures(mixed, MIXED__NAME)
		assertEquals("foo", actual.map[text].join)
	}

	@Test def void regionsForFeaturesCrossReference() {
		val mixed = '''6 (ref foo) action (foo) end'''.parseAs(AssignedAction)
		val access = mixed.toAccess
		val actual = access.regionsForFeatures(mixed.child, MIXED__REF)
		assertEquals("foo", actual.map[text].join)
	}

	@Test(expected=IllegalStateException) def void regionsForFeaturesContainmentReference() {
		val mixed = '''6 (foo) action'''.parseAs(AssignedAction)
		val access = mixed.toAccess
		val actual = access.regionsForFeatures(mixed, ASSIGNED_ACTION__CHILD)
		assertEquals("foo", actual.map[text].join)
	}

	def private <T extends EObject> parseAs(CharSequence seq, Class<T> cls) {
		val result = seq.parse
		result.assertNoErrors
		return cls.cast(result)
	}

	def private ITextRegionAccess toAccess(EObject obj) {
		return textRegionAccessBuilder.get.forNodeModel(obj.eResource as XtextResource).create
	}
}