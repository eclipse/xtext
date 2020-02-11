/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SynonymTypesProviderTest extends AbstractXbaseTestCase {
	
	@Inject
	private SynonymTypesProvider synonymTypeProvider;
	
	@Inject
	private IBatchTypeResolver typeResolver;
	
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
		assertSynonymTypes("null as Iterable<? extends Integer>", "int[]", "java.lang.Integer[]");
	}
	
	@Test public void testListToArray_02() throws Exception {
		assertSynonymTypes("null as java.util.ArrayList<Integer>", "int[]", "java.lang.Integer[]");
	}
	
	protected void assertSynonymTypes(final String expression, String ...expectedSynonymTypes)
			throws Exception {
		XExpression parsedExpression = expression(expression);
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(parsedExpression);
		LightweightTypeReference type = resolvedTypes.getActualType(parsedExpression);
		final List<LightweightTypeReference> synonyms = Lists.newArrayList();
		synonymTypeProvider.collectSynonymTypes(type, new SynonymTypesProvider.Acceptor() {
			
			@Override
			protected boolean accept(/* @NonNull */ LightweightTypeReference synonym, int flags) {
				synonyms.add(synonym);
				return true;
			}
		});
		Iterator<LightweightTypeReference> iterator = synonyms.iterator();
		for (String clazz: expectedSynonymTypes) {
			assertEquals(clazz,iterator.next().getIdentifier());
		}
		assertFalse(iterator.hasNext());
	}
}
