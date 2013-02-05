/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.dispatch;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.dispatch.DispatchingSupport;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Tuples;
import org.junit.Test;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class DispatchingSupportTest extends AbstractXtendTestCase {
	
	@Inject
	protected DispatchingSupport dispatchingSupport;
	
	@Test public void testIgnoreVoidInParameterTypeInferrence() throws Exception {
		XtendClass clazz = clazz("class X {\n" +
			" def dispatch foo(Integer i) {null}" +
			" def dispatch foo(Number n) {null}" +
			" def dispatch foo(Void ignore) {null}" +
			"}");
		JvmOperation dispatchMethod = dispatchingSupport.findSyntheticDispatchMethod(clazz, Tuples.create("foo", 1));
		JvmFormalParameter firstParameter = dispatchMethod.getParameters().get(0);
		assertEquals("java.lang.Number", firstParameter.getParameterType().getIdentifier());
	}
	
	@Test public void testIgnoreVoidInParameterTypeInferrence_02() throws Exception {
		XtendClass clazz = clazz("class X {\n" +
			" def dispatch foo(Number n, Void v) {null}" +
			" def dispatch foo(Void ignore, Object o) {null}" +
			"}");
		JvmOperation dispatchMethod = dispatchingSupport.findSyntheticDispatchMethod(clazz, Tuples.create("foo", 2));
		JvmFormalParameter firstParameter = dispatchMethod.getParameters().get(0);
		assertEquals("java.lang.Number", firstParameter.getParameterType().getIdentifier());
		JvmFormalParameter secondParameter = dispatchMethod.getParameters().get(1);
		assertEquals("java.lang.Object", secondParameter.getParameterType().getIdentifier());
	}
	
	@Test public void testIgnoreVoidInParameterTypeInferrence_03() throws Exception {
		XtendClass clazz = clazz("class X {\n" +
			" def dispatch foo(String n, Void v) {null}" +
			" def dispatch foo(Integer i, Void v) {null}" +
			"}");
		JvmOperation dispatchMethod = dispatchingSupport.findSyntheticDispatchMethod(clazz, Tuples.create("foo", 2));
		JvmFormalParameter firstParameter = dispatchMethod.getParameters().get(0);
		assertEquals("java.lang.Object", firstParameter.getParameterType().getIdentifier());
		JvmFormalParameter secondParameter = dispatchMethod.getParameters().get(1);
		assertEquals("java.lang.Object", secondParameter.getParameterType().getIdentifier());
	}
	
	@Test public void testSort_00() throws Exception {
		XtendClass clazz = clazz("class X {\n" +
				" def dispatch foo(Integer i) {null}" +
				" def dispatch foo(Comparable<?> i) {null}" +
				" def dispatch foo(java.io.Serializable i) {null}" +
				" def dispatch foo(String i) {null}" +
				" def dispatch foo(Number i) {null}" +
				" def dispatch foo(Object i) {null}" +
				" def dispatch foo(CharSequence i) {null}" +
			"}");
		Multimap<Pair<String, Integer>, JvmOperation> multimap = dispatchingSupport.getDispatchMethods((JvmGenericType) clazz.eResource().getContents().get(1));
		Collection<JvmOperation> collection = multimap.values();
		List<JvmOperation> list = dispatchingSupport.sort(collection);
		Iterator<JvmOperation> i = list.iterator();
		assertEquals(Integer.class.getName(), i.next().getParameters().get(0).getParameterType().getIdentifier());
		assertEquals(Number.class.getName(), i.next().getParameters().get(0).getParameterType().getIdentifier());
		assertEquals(String.class.getName(), i.next().getParameters().get(0).getParameterType().getIdentifier());
		assertEquals(Serializable.class.getName(), i.next().getParameters().get(0).getParameterType().getIdentifier());
		assertEquals(CharSequence.class.getName(), i.next().getParameters().get(0).getParameterType().getIdentifier());
		assertEquals(Comparable.class.getName(), i.next().getParameters().get(0).getParameterType().getType().getIdentifier());
		assertEquals(Object.class.getName(), i.next().getParameters().get(0).getParameterType().getIdentifier());
	}
	
	@Test public void testSort_01() throws Exception {
		XtendClass clazz = clazz("class X {\n" +
				" def dispatch foo(Integer i) {null}" +
				" def dispatch foo(Boolean i) {null}" +
				" def dispatch foo(String i) {null}" +
		"}");
		Multimap<Pair<String, Integer>, JvmOperation> multimap = dispatchingSupport.getDispatchMethods((JvmGenericType) clazz.eResource().getContents().get(1));
		Collection<JvmOperation> collection = multimap.values();
		List<JvmOperation> list = dispatchingSupport.sort(collection);
		Iterator<JvmOperation> i = list.iterator();
		assertEquals(Integer.class.getName(), i.next().getParameters().get(0).getParameterType().getIdentifier());
		assertEquals(Boolean.class.getName(), i.next().getParameters().get(0).getParameterType().getIdentifier());
		assertEquals(String.class.getName(), i.next().getParameters().get(0).getParameterType().getIdentifier());
	}
	
	@Test public void testSort_02() throws Exception {
		XtendClass clazz = clazz("class X {\n" +
				" def dispatch foo(int a, String b) {null}" +
				" def dispatch foo(Boolean i, Object b) {null}" +
				" def dispatch foo(Object i, String b) {null}" +
		"}");
		Multimap<Pair<String, Integer>, JvmOperation> multimap = dispatchingSupport.getDispatchMethods((JvmGenericType) clazz.eResource().getContents().get(1));
		Collection<JvmOperation> collection = multimap.values();
		List<JvmOperation> list = dispatchingSupport.sort(collection);
		Iterator<JvmOperation> i = list.iterator();
		assertEquals(Integer.TYPE.getName(), i.next().getParameters().get(0).getParameterType().getIdentifier());
		assertEquals(Boolean.class.getName(), i.next().getParameters().get(0).getParameterType().getIdentifier());
		assertEquals(Object.class.getName(), i.next().getParameters().get(0).getParameterType().getIdentifier());
	}
	
	@Test public void testVisibility_00() throws Exception {
		XtendClass superClazz = clazz(
				"class Super {\n" +
				"  def private dispatch foo(Object x) {} \n" +
				"}");
		Resource subResource = superClazz.eResource().getResourceSet().createResource(URI.createURI("Sub.xtend", true));
		subResource.load(new StringInputStream(
				"class Sub extends Super {\n" +
				"  def dispatch foo(String x) {}\n" +
				"  def dispatch foo(Number x) {}\n" +
				"}"), null);
		JvmGenericType inferredType = (JvmGenericType) subResource.getContents().get(1);
		Multimap<Pair<String, Integer>, JvmOperation> dispatchMethods = dispatchingSupport.getDispatchMethods(inferredType);
		Collection<JvmOperation> collection = dispatchMethods.get(Tuples.create("foo", 1));
		assertEquals(2, collection.size());
	}
	
	@Test public void testVisibility_01() throws Exception {
		XtendClass superClazz = clazz(
				"class Super {\n" +
				"  def dispatch foo(Object x) {} \n" +
				"}");
		Resource subResource = superClazz.eResource().getResourceSet().createResource(URI.createURI("Sub.xtend", true));
		subResource.load(new StringInputStream(
				"class Sub extends Super {\n" +
				"  def dispatch foo(String x) {}\n" +
				"  def dispatch foo(Number x) {}\n" +
				"}"), null);
		JvmGenericType inferredType = (JvmGenericType) subResource.getContents().get(1);
		Multimap<Pair<String, Integer>, JvmOperation> dispatchMethods = dispatchingSupport.getDispatchMethods(inferredType);
		Collection<JvmOperation> collection = dispatchMethods.get(Tuples.create("foo", 1));
		assertEquals(3, collection.size());
	}
}
