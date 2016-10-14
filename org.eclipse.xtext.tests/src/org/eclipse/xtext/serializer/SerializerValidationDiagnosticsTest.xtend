/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.serializer.sequencertest.Model
import org.eclipse.xtext.serializer.sequencertest.MultiKeywordsOrID
import org.eclipse.xtext.serializer.tests.SequencerTestLanguageInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(SequencerTestLanguageInjectorProvider)
class SerializerValidationDiagnosticsTest {

	@Inject extension ParseHelper<Model>
	@Inject extension ISerializer

	@Test def void testSingleValueMandatoryGenerated() {
		val model = '''
			#1 foo bar
		'''.parse
		model.x1.val1 = null
		model.assertSerializationError('''
			A value for feature 'val1' is missing but required.
			Semantic Object: Model.x1->SimpleGroup
			URI: __synthetic0.sequencertestlanguage
		''')
	}

	@Test def void testSingleValueMandatoryBacktracking() {
		val model = '''
			#3 foo kw1 kw2 bar kw3
		'''.parse
		model.x3.val1 = null
		model.assertSerializationError('''
			Could not serialize SimpleMultiplicities:
			SimpleMultiplicities.val1 is required to have a value, but it does not.
			Semantic Object: Model.x3->SimpleMultiplicities
			URI: __synthetic0.sequencertestlanguage
			Context: SimpleMultiplicities returns SimpleMultiplicities
		''')
	}
	
	@Test def void testMultiValueUpperBoundBacktracking() {
		val model = '''
			#17 foo
		'''.parse
		val mt = model.x11 as MultiKeywordsOrID
		mt.^val += "bar"
		model.assertSerializationError('''
			Could not serialize MultiKeywordsOrID:
			MultiKeywordsOrID.val violates the upper bound: It holds 2 values, but only 1 are allowed.
			Semantic Object: Model.x11->MultiKeywordsOrID
			URI: __synthetic0.sequencertestlanguage
			Context: MultiKeywordsOrID returns MultiKeywordsOrID
		''')
	}
	
	@Test def void testMultiValueLowerBoundBacktracking() {
		val model = '''
			#17 foo
		'''.parse
		val mt = model.x11 as MultiKeywordsOrID
		mt.^val.clear
		model.assertSerializationError('''
			Could not serialize MultiKeywordsOrID:
			MultiKeywordsOrID.val violates the lower bound: It holds 0 values, but at least 1 are required.
			Semantic Object: Model.x11->MultiKeywordsOrID
			URI: __synthetic0.sequencertestlanguage
			Context: MultiKeywordsOrID returns MultiKeywordsOrID
		''')
	}
	
	@Test def void testBacktracking() {
		val model = '''
			#8 foo bar
		'''.parse
		model.x8.val3 = "baz"
		model.assertSerializationError('''
			Could not serialize AltList1 via backtracking.
			Constraint: AltList1_AltList1 returns AltList1: ((val1=ID val2=ID) | (val1=ID val3=ID) | (val1=ID val4=ID?));
			Values: val1(1), val2(1), val3(1)
			Semantic Object: Model.x8->AltList1
			URI: __synthetic0.sequencertestlanguage
			Context: AltList1 returns AltList1
		''')
	}

	def private assertSerializationError(EObject obj, String expected) {
		try {
			obj.serialize
			Assert.fail("Serialization should not succeed.")
		} catch (Throwable t) {
			Assert.assertEquals(expected.toString.trim, t.message)
		}
	}

}
