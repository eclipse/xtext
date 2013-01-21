/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseNewTypeSystemInjectorProvider.class)
@SuppressWarnings("deprecation")
public class XbaseTypeProviderTest2 extends XbaseTypeProviderTest {

	@Override
	@Test public void testTypeGuardedCase_1() throws Exception {
		XSwitchExpression expression = (XSwitchExpression) expression("switch s: '' as CharSequence { Cloneable: s String: s }", true);
		assertEquals("java.lang.CharSequence", toString(typeProvider.getType(expression.getSwitch())));
		// inverse order - real type first
		assertEquals("java.lang.CharSequence & java.lang.Cloneable", toString(typeProvider.getType(expression.getCases().get(0).getThen())));
		assertEquals("java.lang.String", toString(typeProvider.getType(expression.getCases().get(1).getThen())));
		assertEquals("java.lang.CharSequence", toString(typeProvider.getType(expression)));
	}
	
	@Test public void testTypeGuardedCase_2() throws Exception {
		XSwitchExpression expression = (XSwitchExpression) expression("switch s: '' as Comparable<?> { CharSequence : s String: s }", true);
		assertEquals("java.lang.Comparable<? extends java.lang.Object>", toString(typeProvider.getType(expression.getSwitch())));
		assertEquals("java.lang.Comparable<? extends java.lang.Object> & java.lang.CharSequence", toString(typeProvider.getType(expression.getCases().get(0).getThen())));
		assertEquals("java.lang.String", toString(typeProvider.getType(expression.getCases().get(1).getThen())));
		assertEquals("java.lang.Comparable<? extends java.lang.Object> & java.lang.CharSequence", toString(typeProvider.getType(expression)));
	}
	
	@Override
	@Test
	public void testConstructorCall() throws Exception {
		assertResolvedType("java.util.ArrayList<java.lang.Object>", "new java.util.ArrayList()");
		assertResolvedType("java.util.ArrayList<java.lang.String>", "new java.util.ArrayList<java.lang.String>()");
		assertResolvedType("java.util.HashMap<java.lang.String, java.lang.Boolean>",
				"new java.util.HashMap<java.lang.String, java.lang.Boolean>()");
	}
	
	@Override
	@Test
	public void testToList_01() throws Exception {
		// TODO fix IterableExtensions.toList
//		Iterable<? extends String> iter = null;
//		java.util.List<String> list = IterableExtensions.toList(iter);
		assertResolvedType("java.util.List<java.lang.String>", "{ val Iterable<? extends String> iter = null iter.toList }");
	}
	
}
