/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.langATestLanguage.LangATestLanguageFactory;
import org.eclipse.xtext.linking.langATestLanguage.Main;
import org.eclipse.xtext.linking.langATestLanguage.Type;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug285381Test extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(LangATestLanguageStandaloneSetup.class);
	}

	@Test public void testDummy() {
	}

	public void _testSerializeReference_01() throws Exception {
		String modelAsString = "type A extends A";
		Main model = (Main) getModel(modelAsString);
		Type parsedType = model.getTypes().get(0);
		assertSame(parsedType, parsedType.getExtends());
		Type newType = LangATestLanguageFactory.eINSTANCE.createType();
		newType.setName("Foo");
		parsedType.setExtends(newType);
		String serialized = serialize(model);
		// we use the existing value from the node model
		// since there is not string representation of the newType
		assertEquals(modelAsString, serialized);
	}

	public void _testSerializeReference_02() throws Exception {
		String modelAsString = "type A";
		Main model = (Main) getModel(modelAsString);
		Type parsedType = model.getTypes().get(0);
		assertNull(parsedType.getExtends());
		Type newType = LangATestLanguageFactory.eINSTANCE.createType();
		newType.setName("Foo");
		parsedType.setExtends(newType);
		try {
			serialize(model);
			fail("expected XtextSerializationException");
		} catch (XtextSerializationException e) {
			// expected
		}
	}
}
