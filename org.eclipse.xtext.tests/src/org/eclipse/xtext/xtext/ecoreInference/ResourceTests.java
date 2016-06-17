/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.langATestLanguage.Main;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class ResourceTests extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(LangATestLanguageStandaloneSetup.class);
	}

	@Test public void testFragmentsWorkInBothDirections() throws Exception {
		Main model = (Main) getModel("type A extends B type B extends A");
		EObject typeA1 = model.getTypes().get(0);
		EObject typeA2 = model.eResource().getEObject(model.eResource().getURIFragment(typeA1));
		assertEquals(typeA1, typeA2);
	}

}
