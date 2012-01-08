/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import java.util.Iterator;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.SynonymTypesProvider;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SynonymTypesProviderTest extends AbstractXbaseTestCase {
	
	@Inject
	private SynonymTypesProvider synonymTypeProvider;
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Test public void testInt() throws Exception {
		assertSynonymTypes("null as int", Integer.class.getName());
		assertSynonymTypes("null as Integer", Integer.TYPE.getName());
	}
	@Test public void testShort() throws Exception {
		assertSynonymTypes("null as short", Short.class.getName());
		assertSynonymTypes("null as Short", Short.TYPE.getName());
	}
	@Test public void testDouble() throws Exception {
		assertSynonymTypes("null as double", Double.class.getName());
		assertSynonymTypes("null as Double", Double.TYPE.getName());
	}
	@Test public void testBoolean() throws Exception {
		assertSynonymTypes("null as boolean", Boolean.class.getName());
		assertSynonymTypes("null as Boolean", Boolean.TYPE.getName());
	}
	@Test public void testVoid() throws Exception {
		assertSynonymTypes("null as Void");
		assertSynonymTypes("null as void");
	}
	
	@Test public void testListToArray() throws Exception {
		assertSynonymTypes("''.toCharArray()", "java.util.List<java.lang.Character>");
		assertSynonymTypes("null as java.util.List<java.lang.String>", "java.lang.String[]");
	}
	
	@Test public void testListToArray_01() throws Exception {
		assertSynonymTypes("null as Iterable<? extends Integer>", "java.lang.Integer[]", "int[]");
	}
	
	@Test public void testListToArray_02() throws Exception {
		assertSynonymTypes("null as java.util.ArrayList<Integer>", "java.lang.Integer[]", "int[]");
	}
	
	protected void assertSynonymTypes(final String expression, String ...expectedSynonymTypes)
			throws Exception {
		JvmTypeReference type = typeProvider.getType(expression(expression));
		Iterable<JvmTypeReference> synonymTypes = synonymTypeProvider.getSynonymTypes(type, false);
		Iterator<JvmTypeReference> iterator = synonymTypes.iterator();
		for (String clazz: expectedSynonymTypes) {
			assertEquals(clazz,iterator.next().getIdentifier());
		}
		assertFalse(iterator.hasNext());
	}
}
