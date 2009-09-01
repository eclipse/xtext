/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.linking.bug287988Test.BaseAttribute;
import org.eclipse.xtext.linking.bug287988Test.Model;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug287988Test extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(Bug287988TestLanguageStandaloneSetup.class);
	}
	
	public void testAction_01() throws Exception {
		String modelAsString = "actions master mytype attr1; attribute ref attr1 attr2;";
		checkSecondAttrRefersToFirst(modelAsString);
	}
	
	public void testAction_02() throws Exception {
		String modelAsString = "actions master mytype attr1; attribute myOtherType attr2;";
		Model model = (Model) getModel(modelAsString);
		assertEquals(2, model.getAttributes().size());
		BaseAttribute baseAttribute = model.getAttributes().get(1);
		assertNull(baseAttribute.getTypeRef());
	}
	
	public void testAction_03() throws Exception {
		String modelAsString = "actions master mytype attr1; attribute ref attr3 attr2;";
		Model model = (Model) getModelAndExpect(modelAsString, 1);
		assertEquals(2, model.getAttributes().size());
		BaseAttribute baseAttribute = model.getAttributes().get(1);
		assertNotNull(baseAttribute.getTypeRef());
		EObject eObject = baseAttribute.getTypeRef();
		assertTrue(eObject.eIsProxy());
	}
	
	public void testSimple_01() throws Exception {
		String modelAsString = "simple mytype attr1; ref attr1 attr2;";
		checkSecondAttrRefersToFirst(modelAsString);
	}
	
	public void testRuleCall_01() throws Exception {
		String modelAsString = "rulecall mytype attr1; ref attr1 attr2;";
		checkSecondAttrRefersToFirst(modelAsString);
	}
	
	public void testRuleCall_02() throws Exception {
		String modelAsString = "rulecall2 attr1 mytype; attr2 ref attr1;";
		checkSecondAttrRefersToFirst(modelAsString);
	}
	
	public void testRuleCall_03() throws Exception {
		String modelAsString = "rulecall3 call me attr1 mytype; call me attr2 ref attr1;";
		checkSecondAttrRefersToFirst(modelAsString);
	}
	
	public void testInlinedActions_01() throws Exception {
		String modelAsString = "inlinedActions master mytype attr1; attribute ref attr1 attr2;";
		checkSecondAttrRefersToFirst(modelAsString);
	}

	protected void checkSecondAttrRefersToFirst(String modelAsString) throws Exception {
		Model model = (Model) getModel(modelAsString);
		assertEquals(2, model.getAttributes().size());
		BaseAttribute baseAttribute = model.getAttributes().get(1);
		assertEquals(model.getAttributes().get(0), baseAttribute.getTypeRef());
	}
	
}
