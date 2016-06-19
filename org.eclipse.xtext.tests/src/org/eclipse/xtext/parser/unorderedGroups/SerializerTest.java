/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.unorderedGroups;

import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguageFactory;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SerializerTest extends AbstractXtextTests {
	
	private Model model;
	private UnorderedSerialization serializableInstance;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(SimpleUnorderedGroupsTestLanguageStandaloneSetup.class);
		model = UnorderedGroupsTestLanguageFactory.eINSTANCE.createModel();
		serializableInstance = UnorderedGroupsTestLanguageFactory.eINSTANCE.createUnorderedSerialization();
		model.setSerialized(serializableInstance);
	}
	
	@Test public void testNoValueAssigned() {
		String serialized = serialize(model);
		assertEquals("serialization 1", serialized);
	}
	
	@Test public void testSerialize_1_A() {
		serializableInstance.setFirst(true);
		String serialized = serialize(model);
		assertEquals("serialization 1 a", serialized);
	}
	
	@Test public void testSerialize_1_B() {
		serializableInstance.setSecond(true);
		String serialized = serialize(model);
		assertEquals("serialization 1 b", serialized);
	}
	
	@Test public void testSerialize_1_C() {
		serializableInstance.setThird(true);
		String serialized = serialize(model);
		assertEquals("serialization 1 c", serialized);
	}
	
	@Test public void testSerialize_1_D() {
		serializableInstance.setForth(true);
		String serialized = serialize(model);
		assertEquals("serialization 1 d", serialized);
	}
	
	@Test public void testSerialize_1_A_B() {
		serializableInstance.setFirst(true);
		serializableInstance.setSecond(true);
		String serialized = serialize(model);
		assertEquals("serialization 1 a b", serialized);
	}
	
	@Test public void testSerialize_1_A_C() {
		serializableInstance.setFirst(true);
		serializableInstance.setThird(true);
		String serialized = serialize(model);
		assertEquals("serialization 1 a c", serialized);
	}
	
	@Test public void testSerialize_1_A_D() {
		serializableInstance.setFirst(true);
		serializableInstance.setForth(true);
		String serialized = serialize(model);
		assertEquals("serialization 1 a d", serialized);
	}
	
	@Test public void testSerialize_1_A_B_C() {
		serializableInstance.setFirst(true);
		serializableInstance.setSecond(true);
		serializableInstance.setThird(true);
		String serialized = serialize(model);
		assertEquals("serialization 1 a b c", serialized);
	}
	
	@Test public void testSerialize_1_A_B_D() {
		serializableInstance.setFirst(true);
		serializableInstance.setSecond(true);
		serializableInstance.setForth(true);
		String serialized = serialize(model);
		assertEquals("serialization 1 a b d", serialized);
	}
	
	@Test public void testSerialize_1_A_B_C_D() {
		serializableInstance.setFirst(true);
		serializableInstance.setSecond(true);
		serializableInstance.setThird(true);
		serializableInstance.setForth(true);
		String serialized = serialize(model);
		assertEquals("serialization 1 a b c d", serialized);
	}
	
	@Test public void testSerialize_1_B_C_D() {
		serializableInstance.setSecond(true);
		serializableInstance.setThird(true);
		serializableInstance.setForth(true);
		String serialized = serialize(model);
		assertEquals("serialization 1 b c d", serialized);
	}
	
	@Test public void testSerialize_1_B_C() {
		serializableInstance.setSecond(true);
		serializableInstance.setThird(true);
		String serialized = serialize(model);
		assertEquals("serialization 1 b c", serialized);
	}
	
	@Test public void testSerialize_1_B_D() {
		serializableInstance.setSecond(true);
		serializableInstance.setForth(true);
		String serialized = serialize(model);
		assertEquals("serialization 1 b d", serialized);
	}

	@Test public void testSerialize_1_C_D() {
		serializableInstance.setThird(true);
		serializableInstance.setForth(true);
		String serialized = serialize(model);
		assertEquals("serialization 1 c d", serialized);
	}
	
	@Test public void testSerialize_2_A_B() {
		serializableInstance.getFirstAsList().add("a");
		serializableInstance.getSecondAsList().add("b");
		String serialized = serialize(model);
		assertEquals("serialization 2 a b", serialized);
	}

	@Test public void testSerialize_2_A_B_A_B() {
		serializableInstance.getFirstAsList().add("a");
		serializableInstance.getFirstAsList().add("a");
		serializableInstance.getSecondAsList().add("b");
		serializableInstance.getSecondAsList().add("b");
		String serialized = serialize(model);
		assertEquals("serialization 2 a b a b", serialized);
	}
	
	@Test public void testSerialize_2_A_B_A_B_A_B() {
		serializableInstance.getFirstAsList().add("a");
		serializableInstance.getFirstAsList().add("a");
		serializableInstance.getFirstAsList().add("a");
		serializableInstance.getSecondAsList().add("b");
		serializableInstance.getSecondAsList().add("b");
		serializableInstance.getSecondAsList().add("b");
		String serialized = serialize(model);
		assertEquals("serialization 2 a b a b a b", serialized);
	}
	
	@Test public void testSerialize_3_A_B() {
		serializableInstance.getFirstAsList().add("a");
		serializableInstance.setSecond(true);
		String serialized = serialize(model);
		assertEquals("serialization 3 a b", serialized);
	}
	
	@Test public void testSerialize_3_A_A_B() {
		serializableInstance.getFirstAsList().add("a");
		serializableInstance.getFirstAsList().add("a");
		serializableInstance.setSecond(true);
		String serialized = serialize(model);
		assertEquals("serialization 3 a a b", serialized);
	}
	
	@Test public void testSerialize_3_A_A_A_B() {
		serializableInstance.getFirstAsList().add("a");
		serializableInstance.getFirstAsList().add("a");
		serializableInstance.getFirstAsList().add("a");
		serializableInstance.setSecond(true);
		String serialized = serialize(model);
		assertEquals("serialization 3 a a a b", serialized);
	}
}
