/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.resource;

import static org.eclipse.xtext.common.types.TypesPackage.Literals.*;
import static org.eclipse.xtext.xtend2.xtend2.Xtend2Package.Literals.*;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xtend2.resource.DescriptionFlags;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class IndexingTest extends AbstractXtend2TestCase {

	@Inject
	private IResourceDescription.Manager resourceDescriptionManager;
	
	@Inject
	private IQualifiedNameConverter converter;
	
	@Inject
	private DescriptionFlags flags;
	
	public void testIndexing() throws Exception {
		Iterator<IEObjectDescription> iterator = getExportedObjects(
				"package test\n" +
				"class Foo {\n" +
				"  String baz\n" +
				"  def bar() {this}\n" +
				"}");
		expect(iterator, "test.Foo", XTEND_CLASS);
		expect(iterator, "test.Foo.baz", XTEND_FIELD);
		expect(iterator, "test.Foo.bar", XTEND_FUNCTION);
		expect(iterator, "test.Foo", JVM_GENERIC_TYPE);
		expect(iterator, "test.Foo", JVM_CONSTRUCTOR);
		expect(iterator, "test.Foo.baz", JVM_FIELD);
		expect(iterator, "test.Foo.bar", JVM_OPERATION);
		assertFalse(iterator.hasNext());
	}

	public void testDispatchMethod() throws Exception {
		Iterator<IEObjectDescription> iterator = getExportedObjects(
				"package test\n" +
				"class Foo {\n" +
				"  def dispatch foo(Object x) {x.toString}\n" +
				"  def dispatch foo(String y) {y}\n" +
				"}");
		expect(iterator, "test.Foo", XTEND_CLASS);
		expect(iterator, "test.Foo.foo", XTEND_FUNCTION);
		expect(iterator, "test.Foo.foo", XTEND_FUNCTION);
		expect(iterator, "test.Foo", JVM_GENERIC_TYPE);
		expect(iterator, "test.Foo", JVM_CONSTRUCTOR);
		assertFalse(flags.isDispatcherOperation(expect(iterator, "test.Foo._foo", JVM_OPERATION)));
		assertFalse(flags.isDispatcherOperation(expect(iterator, "test.Foo._foo", JVM_OPERATION)));
		assertTrue(flags.isDispatcherOperation(expect(iterator, "test.Foo.foo", JVM_OPERATION)));
		assertFalse(iterator.hasNext()); 
	}

	public void testConstructors() throws Exception {
		Iterator<IEObjectDescription> iterator = getExportedObjects("package test\n" +
				"class Foo {\n" +
				"  new(String x) {}\n" +
				"  new(int x) {}\n" +
				"}");
		expect(iterator, "test.Foo", XTEND_CLASS);
		expect(iterator, "test.Foo", XTEND_CONSTRUCTOR);
		expect(iterator, "test.Foo", XTEND_CONSTRUCTOR);
		expect(iterator, "test.Foo", JVM_GENERIC_TYPE);
		expect(iterator, "test.Foo", JVM_CONSTRUCTOR);
		expect(iterator, "test.Foo", JVM_CONSTRUCTOR);
	}
	
	public void testStaticFlags() throws Exception {
		Iterator<IEObjectDescription> iterator = getExportedObjects("package test\n" +
				"class Foo {\n" +
				"  String bar\n" +
				"  static String bar_static\n" +
				"  def foo() {}\n" +
				"  def static foo_static() {}\n" +
				"}");
		expect(iterator, "test.Foo", XTEND_CLASS);
		assertFalse(flags.isStatic(iterator.next()));
		assertTrue(flags.isStatic(iterator.next()));
		assertFalse(flags.isStatic(iterator.next()));
		assertTrue(flags.isStatic(iterator.next()));
		expect(iterator, "test.Foo", JVM_GENERIC_TYPE);
		expect(iterator, "test.Foo", JVM_CONSTRUCTOR);
		assertFalse(flags.isStatic(iterator.next()));
		assertTrue(flags.isStatic(iterator.next()));
		assertFalse(flags.isStatic(iterator.next()));
		assertTrue(flags.isStatic(iterator.next()));
	}
	
	protected Iterator<IEObjectDescription> getExportedObjects(String model) throws Exception {
		XtendFile file = file(model);
		IResourceDescription rd = resourceDescriptionManager.getResourceDescription(file.eResource());
		Iterable<IEObjectDescription> exportedObjects = rd.getExportedObjects();
		return exportedObjects.iterator();
	}
	
	protected IEObjectDescription expect(Iterator<IEObjectDescription> i, String name, EClass eClass) {
		IEObjectDescription desc = i.next();
		assertEquals(name, converter.toString(desc.getQualifiedName()));
		assertEquals(eClass, desc.getEClass());
		return desc;
	}

}
