/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ecoreInference;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class ResourceTests extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(LangATestLanguageStandaloneSetup.class);
	}

	public void testFragmentsWorkInBothDirections() throws Exception {
		EObject model = getModel("type A extends B type B extends A");
		EObject typeA1 = (EObject) invokeWithXtend("types.first()", model);
		EObject typeA2 = model.eResource().getEObject(model.eResource().getURIFragment(typeA1));
		assertEquals(typeA1, typeA2);
	}

}
