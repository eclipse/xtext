/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.dispatch;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xtend2.dispatch.DispatchingSupport;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DispatchingSupportTest extends AbstractXtend2TestCase {
	
	@Inject
	private DispatchingSupport dispatchingSupport;
	
	public void testSort_00() throws Exception {
		XtendClass clazz = clazz("class X {\n" +
				"  dispatch foo(Integer i) null" +
				"  dispatch foo(Comparable<?> i) null" +
				"  dispatch foo(java.io.Serializable i) null" +
				"  dispatch foo(String i) null" +
				"  dispatch foo(Number i) null" +
				"  dispatch foo(Object i) null" +
				"  dispatch foo(CharSequence i) null" +
			"}");
		Multimap<Pair<String, Integer>, JvmOperation> multimap = dispatchingSupport.getDispatchMethods((JvmGenericType) clazz.eResource().getContents().get(1));
		Collection<JvmOperation> collection = multimap.values();
		List<JvmOperation> list = dispatchingSupport.sort(collection);
		Iterator<JvmOperation> i = list.iterator();
		assertEquals(Integer.class.getName(), i.next().getParameters().get(0).getParameterType().getCanonicalName());
		assertEquals(Number.class.getName(), i.next().getParameters().get(0).getParameterType().getCanonicalName());
		assertEquals(String.class.getName(), i.next().getParameters().get(0).getParameterType().getCanonicalName());
		assertEquals(Serializable.class.getName(), i.next().getParameters().get(0).getParameterType().getCanonicalName());
		assertEquals(CharSequence.class.getName(), i.next().getParameters().get(0).getParameterType().getCanonicalName());
		assertEquals(Comparable.class.getName(), i.next().getParameters().get(0).getParameterType().getType().getCanonicalName());
		assertEquals(Object.class.getName(), i.next().getParameters().get(0).getParameterType().getCanonicalName());
	}
	
	public void testSort_01() throws Exception {
		XtendClass clazz = clazz("class X {\n" +
				"  dispatch foo(Integer i) null" +
				"  dispatch foo(Boolean i) null" +
				"  dispatch foo(String i) null" +
		"}");
		Multimap<Pair<String, Integer>, JvmOperation> multimap = dispatchingSupport.getDispatchMethods((JvmGenericType) clazz.eResource().getContents().get(1));
		Collection<JvmOperation> collection = multimap.values();
		List<JvmOperation> list = dispatchingSupport.sort(collection);
		Iterator<JvmOperation> i = list.iterator();
		assertEquals(Integer.class.getName(), i.next().getParameters().get(0).getParameterType().getCanonicalName());
		assertEquals(Boolean.class.getName(), i.next().getParameters().get(0).getParameterType().getCanonicalName());
		assertEquals(String.class.getName(), i.next().getParameters().get(0).getParameterType().getCanonicalName());
	}
	
	public void testSort_02() throws Exception {
		XtendClass clazz = clazz("class X {\n" +
				"  dispatch foo(int a, String b) null" +
				"  dispatch foo(Boolean i, Object b) null" +
				"  dispatch foo(Object i, String b) null" +
		"}");
		Multimap<Pair<String, Integer>, JvmOperation> multimap = dispatchingSupport.getDispatchMethods((JvmGenericType) clazz.eResource().getContents().get(1));
		Collection<JvmOperation> collection = multimap.values();
		List<JvmOperation> list = dispatchingSupport.sort(collection);
		Iterator<JvmOperation> i = list.iterator();
		assertEquals(Integer.TYPE.getName(), i.next().getParameters().get(0).getParameterType().getCanonicalName());
		assertEquals(Boolean.class.getName(), i.next().getParameters().get(0).getParameterType().getCanonicalName());
		assertEquals(Object.class.getName(), i.next().getParameters().get(0).getParameterType().getCanonicalName());
	}
}
