/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.noJdt.noJdt.Greeting;
import org.eclipse.xtext.testlanguages.noJdt.noJdt.Model;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.ReplaceRegion;
import org.junit.Test;

/**
 * @author miklossy - Initial contribution and API
 */
public class SerializerReplacementCalculationTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(NoJdtTestLanguageStandaloneSetup.class);
	}

	@Test
	public void testSerializeReplacement001() throws Exception {
		// Given
		String textModel = "Hello Xtext!" + System.lineSeparator();
		StringBuilder stringBuilder = new StringBuilder(textModel);
		Model model = (Model) getModel(textModel);
		Greeting greeting = model.getGreetings().get(0);
		ReplaceRegion replacement =  getSerializer().serializeReplacement(greeting, SaveOptions.defaultOptions());

		// When
		replacement.applyTo(stringBuilder);

		// Then
		assertEquals(textModel, stringBuilder.toString());
	}

}
