/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import static com.google.common.collect.Sets.*;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions.VariableType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JdtVariableCompletionsTest extends Assert {

	private final static class TestableJdtVariableCompletions extends JdtVariableCompletions {
		
		@Override
		public String getFirstTypeArgumentSimpleName(String typeName) {
			return super.getFirstTypeArgumentSimpleName(typeName);
		}
		
		@Override
		public String getRawTypeSimpleName(String typeName) {
			return super.getRawTypeSimpleName(typeName);
		}
		
		@Override
		public String getArrayComponentTypeSimpleName(String typeName) {
			return super.getArrayComponentTypeSimpleName(typeName);
		}
		
		@Override
		public void internalGetVariableProposals(String typeName, EObject ctx, VariableType varType,
				Set<String> notAllowedNames, CompletionDataAcceptor acceptor) {
			super.internalGetVariableProposals(typeName, ctx, varType, notAllowedNames, acceptor);
		}
		
	}

	private TestableJdtVariableCompletions completions;
	
	@Before
	public void setUp() throws Exception {
		this.completions = new TestableJdtVariableCompletions();
	}
	
	@Test public void testGetRawTypeSimpleName() throws Exception {
		assertEquals("", completions.getRawTypeSimpleName(""));
		assertEquals("Map", completions.getRawTypeSimpleName("Map"));
		assertEquals("List", completions.getRawTypeSimpleName("List<String>"));
		assertEquals("List", completions.getRawTypeSimpleName("java.util.List<java.lang.String>"));
		assertEquals("Map", completions.getRawTypeSimpleName("Map<Foo,Bar>"));
		assertEquals("§52F$%%", completions.getRawTypeSimpleName("§52F$%%"));
	}
	
	@Test public void testGetFirstTypeArgumentSimpleName() throws Exception {
		assertNull(completions.getFirstTypeArgumentSimpleName(""));
		assertNull(completions.getFirstTypeArgumentSimpleName("Map"));
		assertEquals("String", completions.getFirstTypeArgumentSimpleName("List<String>"));
		assertEquals("String", completions.getFirstTypeArgumentSimpleName("java.util.List<java.lang.String>"));
		assertEquals("Foo", completions.getFirstTypeArgumentSimpleName("Map<Foo,Bar>"));
		assertEquals("Foo", completions.getFirstTypeArgumentSimpleName("Map<my.foo.Foo<?>,Bar>"));
		assertNull(completions.getFirstTypeArgumentSimpleName("Map<my.foo.Foo"));
		assertNull(completions.getFirstTypeArgumentSimpleName("Map<my.foo.Foo<"));
		assertEquals("Foo",completions.getFirstTypeArgumentSimpleName("Map<my.foo.Foo<>"));
		assertNull(completions.getFirstTypeArgumentSimpleName("§52F$%%"));
	}
	
	@Test public void testGetArrayComponentTypeSimpleName() throws Exception {
		assertNull(completions.getArrayComponentTypeSimpleName(""));
		assertNull(completions.getArrayComponentTypeSimpleName("Map"));
		assertEquals("String", completions.getArrayComponentTypeSimpleName("String[]"));
		assertEquals("String", completions.getArrayComponentTypeSimpleName("java.lang.String[]"));
		assertEquals("Foo", completions.getArrayComponentTypeSimpleName("org.stuff.Foo[]"));
		assertNull(completions.getArrayComponentTypeSimpleName("§52F$%%"));
		//TODO this is of course not expected
		assertEquals("Foo", completions.getArrayComponentTypeSimpleName("List<org.stuff.Foo[]>"));
		assertEquals("Foo>", completions.getArrayComponentTypeSimpleName("List<org.stuff.Foo>[]"));
	}
	
	@Test public void testGetVariableProposals() throws Exception {
		assertContainsProposals(newHashSet("strings"), "String[]");
		assertContainsProposals(newHashSet("strings2"), "String[]", newHashSet("strings"));
		assertContainsProposals(newHashSet("foos","myFoos"), "List<foo.bar.MyFoo>");
		assertContainsProposals(newHashSet("foo","myFoo"), "foo.bar.MyFoo");
		assertContainsProposals(newHashSet("foo","myFoo"), "MyFoo");
		assertContainsProposals(newHashSet("foos"), "List<org.stuff.Foo>[]");
		// no proposals is not ideal but not too problematic as it is such a rare case
		assertContainsProposals(new HashSet<String>(), "List<org.stuff.Foo[]>");
		assertContainsProposals(new HashSet<String>(), " \n§5 2F$%% ");
	}

	protected void assertContainsProposals(final Set<String> expected, final String typeName) {
		assertContainsProposals(expected, typeName, new HashSet<String>());
	}
	
	protected void assertContainsProposals(final Set<String> expected, final String typeName, final Set<String> excluded) {
		final Set<String> result = newHashSet();
		completions.internalGetVariableProposals(typeName, null, VariableType.INSTANCE_FIELD, excluded, new JdtVariableCompletions.CompletionDataAcceptor() {
			@Override
			public void accept(String replaceText, StyledString label, Image img) {
				result.add(replaceText);
			}
		});
		assertEquals(expected, result);
	}
}
