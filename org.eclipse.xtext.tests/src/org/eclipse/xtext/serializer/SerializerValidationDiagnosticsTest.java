/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.sequencertest.Model;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywordsOrID;
import org.eclipse.xtext.serializer.tests.SequencerTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(SequencerTestLanguageInjectorProvider.class)
public class SerializerValidationDiagnosticsTest {
	@Inject
	private ParseHelper<Model> parseHelper;

	@Inject
	private ISerializer serializer;

	@Test
	public void testSingleValueMandatoryGenerated() throws Exception {
		Model model = parseHelper.parse("#1 foo bar");
		model.getX1().setVal1(null);
		assertSerializationError(model,
				"A value for feature \'val1\' is missing but required.\n" +
				"Semantic Object: Model.x1->SimpleGroup\n" +
				"URI: __synthetic0.sequencertestlanguage\n");
	}

	@Test
	public void testSingleValueMandatoryBacktracking() throws Exception {
		Model model = parseHelper.parse("#3 foo kw1 kw2 bar kw3");
		model.getX3().setVal1(null);
		assertSerializationError(model,
				"Could not serialize SimpleMultiplicities:\n" +
				"SimpleMultiplicities.val1 is required to have a value, but it does not.\n" +
				"Semantic Object: Model.x3->SimpleMultiplicities\n" +
				"URI: __synthetic0.sequencertestlanguage\n" +
				"Context: SimpleMultiplicities returns SimpleMultiplicities\n");
	}

	@Test
	public void testMultiValueUpperBoundBacktracking() throws Exception {
		Model model = parseHelper.parse("#17 foo");
		MultiKeywordsOrID mt = ((MultiKeywordsOrID) model.getX11());
		mt.getVal().add("bar");
		assertSerializationError(model,
				"Could not serialize MultiKeywordsOrID:\n" +
				"MultiKeywordsOrID.val violates the upper bound: It holds 2 values, but only 1 are allowed.\n" +
				"Semantic Object: Model.x11->MultiKeywordsOrID\n" +
				"URI: __synthetic0.sequencertestlanguage\n" +
				"Context: MultiKeywordsOrID returns MultiKeywordsOrID\n");
	}

	@Test
	public void testMultiValueLowerBoundBacktracking() throws Exception {
		Model model = parseHelper.parse("#17 foo");
		MultiKeywordsOrID mt = ((MultiKeywordsOrID) model.getX11());
		mt.getVal().clear();
		assertSerializationError(model,
				"Could not serialize MultiKeywordsOrID:\n" +
				"MultiKeywordsOrID.val violates the lower bound: It holds 0 values, but at least 1 are required.\n" +
				"Semantic Object: Model.x11->MultiKeywordsOrID\n" +
				"URI: __synthetic0.sequencertestlanguage\n" +
				"Context: MultiKeywordsOrID returns MultiKeywordsOrID\n");
	}

	@Test
	public void testBacktracking() throws Exception {
		Model model = parseHelper.parse("#8 foo bar");
		model.getX8().setVal3("baz");
		assertSerializationError(model,
				"Could not serialize AltList1 via backtracking.\n" +
				"Constraint: AltList1_AltList1 returns AltList1: ((val1=ID val2=ID) | (val1=ID val3=ID) | (val1=ID val4=ID?));\n" +
				"Values: val1(1), val2(1), val3(1)\n" +
				"Semantic Object: Model.x8->AltList1\n" +
				"URI: __synthetic0.sequencertestlanguage\n" +
				"Context: AltList1 returns AltList1\n");
	}

	private void assertSerializationError(EObject obj, String expected) {
		try {
			serializer.serialize(obj);
			Assert.fail("Serialization should not succeed.");
		} catch (Throwable t) {
			String expectedM = expected.toString().trim().replaceAll(System.lineSeparator(), "\n");
			String messageM = t.getMessage().replaceAll(System.lineSeparator(), "\n");
			Assert.assertEquals(expectedM, messageM);
		}
	}
}
