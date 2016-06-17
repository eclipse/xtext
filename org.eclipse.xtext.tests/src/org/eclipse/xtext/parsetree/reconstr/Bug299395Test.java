/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Factory;
import org.eclipse.xtext.parsetree.reconstr.bug299395.Model;
import org.eclipse.xtext.parsetree.reconstr.bug299395.SubModel;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug299395Test extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(Bug299395TestLanguageStandaloneSetup.class);
	}
	
	@Test public void testSerialization() {
		Model model = Bug299395Factory.eINSTANCE.createModel();
		String serialized = getSerializer().serialize(model);
		assertEquals("", serialized);
	}
	
	@Test public void testSerialization_02() {
		Model model = Bug299395Factory.eINSTANCE.createModel();
		model.getStrings().add("Foo");
		String serialized = getSerializer().serialize(model);
		assertEquals("{ \"Foo\" }", serialized);
	}
	
	@Test public void testSerialization_03() {
		Model model = Bug299395Factory.eINSTANCE.createModel();
		model.getStrings().add("Foo");
		model.getStrings().add("Bar");
		model.getStrings().add("Zonk");
		String serialized = getSerializer().serialize(model);
		assertEquals("{ \"Foo\" } { \"Bar\" } { \"Zonk\" }", serialized);
	}
	
	@Test public void testSerialization_04() {
		Model model = Bug299395Factory.eINSTANCE.createModel();
		model.getKeys().add("Key1");
		model.getValues().add("Value1");
		model.getKeys().add("Key2");
		model.getValues().add("Value2");
		String serialized = getSerializer().serialize(model);
		assertEquals("[ \"Key1\" \"Value1\" \"Key2\" \"Value2\" ]", serialized);
	}
	
	@Test public void testSerialization_05() {
		Model model = Bug299395Factory.eINSTANCE.createModel();
		model.getStrings().add("Unused");
		model.getKeys().add("Key1");
		model.getValues().add("Value1");
		model.getKeys().add("Key2");
		model.getValues().add("Value2");
		String serialized = getSerializer().serialize(model);
		assertEquals("{ \"Unused\" } [ \"Key1\" \"Value1\" \"Key2\" \"Value2\" ]", serialized);
	}
	
	@Test public void testSerialization_06() {
		Model model = Bug299395Factory.eINSTANCE.createModel();
		SubModel subModel = Bug299395Factory.eINSTANCE.createSubModel();
		model.setSubModel(subModel);
		String serialized = getSerializer().serialize(model);
		assertEquals("subModel", serialized);
	}
	
	@Test public void testSerialization_07() {
		Model model = Bug299395Factory.eINSTANCE.createModel();
		SubModel subModel = Bug299395Factory.eINSTANCE.createSubModel();
		model.setSubModel(subModel);
		subModel.getStrings().add("s1");
		String serialized = getSerializer().serialize(model);
		assertEquals("subModel 1 2 \"s1\"", serialized);
	}
	
	@Test public void testSerialization_08() {
		Model model = Bug299395Factory.eINSTANCE.createModel();
		SubModel subModel = Bug299395Factory.eINSTANCE.createSubModel();
		model.setSubModel(subModel);
		subModel.getStrings().add("s1");
		subModel.getStrings().add("s2");
		String serialized = getSerializer().serialize(model);
		assertEquals("subModel 1 2 \"s1\" 1 2 \"s2\"", serialized);
	}
}
