/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules;

import java.util.Date;

import org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.EcoreTerminalsTestLanguageFactory;
import org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.Model;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.ibm.icu.text.SimpleDateFormat;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultTerminalConverterTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(EcoreTerminalsTestLanguageStandaloneSetup.class);
	}
	
	@Test public void testSerializeAndReparse() throws Exception {
		int intValue=34786482;
		double doubleValue=2.32E-17;
		Date dateValue = new SimpleDateFormat("YYYY-MM-DD").parse("2010-05-25");
		Model model = EcoreTerminalsTestLanguageFactory.eINSTANCE.createModel();
		model.getIntValues().add(intValue);
		model.getDoubleValues().add(doubleValue);
		model.getDateValues().add(dateValue);
		ISerializer serializer = get(ISerializer.class);
		String modelAsString = serializer.serialize(model);
		
		Model reparsedModel = (Model) getModel(modelAsString);
		assertEquals(intValue, (int) reparsedModel.getIntValues().get(0));
		assertEquals(doubleValue, reparsedModel.getDoubleValues().get(0), 0.00001);
		assertEquals(dateValue, reparsedModel.getDateValues().get(0));
		
		try {
			model.getDoubleValues().add(-doubleValue);
			modelAsString = serializer.serialize(model);
			fail("Serialization should fail");
		} catch (Exception exc) {
			// normal case
		}
	}
}
