/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.resource;

import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*;
import static org.eclipse.xtext.common.types.TypesPackage.Literals.*;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.core.resource.DescriptionFlags;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.builder.clustering.CopiedResourceDescription;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class IndexingTest extends AbstractXtendTestCase {

	@Inject
	private IResourceDescription.Manager resourceDescriptionManager;
	
	@Inject
	private IQualifiedNameConverter converter;
	
	@Inject
	private DescriptionFlags flags;
	
	@Test public void testIndexing() throws Exception {
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

	@Test public void testDispatchMethod() throws Exception {
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

	@Test public void testConstructors() throws Exception {
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
	
	@Test public void testStaticFlags() throws Exception {
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
	
	@Test public void testFieldSignatureChange() throws Exception {
		assertSameResourceDescriptions(
				"package test class Foo { String bar }",
				"package test class Foo { String bar }");
		assertDifferentResourceDescriptions(
				"package test class Foo { String bar }",
				"package test class Foo { int bar }");
		assertDifferentResourceDescriptions(
				"package test class Foo { String bar }",
				"package test class Foo { String baz }");
		assertDifferentResourceDescriptions(
				"package test class Foo { String bar }",
				"package test class Foo { public String bar }");
		assertDifferentResourceDescriptions(
				"package test class Foo { String bar }",
				"package test class Foo { static String bar }");
	}
	
	@Test public void testConstructorSignatureChange() throws Exception {
		assertSameResourceDescriptions(
				"package test class Foo { new() {} }",
				"package test class Foo { new() {} }");
		assertSameResourceDescriptions(
				"package test class Foo { new() {} }",
				"package test class Foo { new() { return } }");
		assertSameResourceDescriptions(
				"package test class Foo { new(String bar) {} }",
				"package test class Foo { new(String baz) {} }");
		assertDifferentResourceDescriptions(
				"package test class Foo { new(String bar) {} }",
				"package test class Foo { new(int bar) {} }");
		assertDifferentResourceDescriptions(
				"package test class Foo { new(String bar) {} }",
				"package test class Foo { private new(String bar) {} }");
		assertDifferentResourceDescriptions(
				"package test class Foo { new(String bar) {} }",
				"package test class Foo { new(String bar) throws Exception { throw new Exception() } }");
		assertDifferentResourceDescriptions(
				"package test class Foo { new <T> () {} }",
				"package test class Foo { new() {} }");
	}
	
	@Test public void testMethodSignatureChange() throws Exception {
		assertSameResourceDescriptions(
				"package test class Foo { def void foo() {} }",
				"package test class Foo { def void foo() {} }");
		assertSameResourceDescriptions(
				"package test class Foo { def void foo() {} }",
				"package test class Foo { def void foo() { retrun } }");
		assertDifferentResourceDescriptions(
				"package test class Foo { def void foo() {} }",
				"package test class Foo { def void bar() {} }");
		assertDifferentResourceDescriptions(
				"package test class Foo { def String foo() { '' } }",
				"package test class Foo { def CharSequence foo() { '' } }");
		assertDifferentResourceDescriptions(
				"package test class Foo { def void foo() {} }",
				"package test class Foo { def private void foo() {} }");
		assertDifferentResourceDescriptions(
				"package test class Foo { def void foo() {} }",
				"package test class Foo { def static void foo() {} }");
		assertDifferentResourceDescriptions(
				"package test class Foo { def void foo(String x) {} }",
				"package test class Foo { def void foo(int x) {} }");
		assertDifferentResourceDescriptions(
				"package test class Foo { def void foo() {} }",
				"package test class Foo { def void foo() throws Exception { throw new Exception() } }");
		assertDifferentResourceDescriptions(
				"package test class Foo { def void foo() {} }",
				"package test class Foo { def <T> void foo() {} }");
	}
	
	protected Iterator<IEObjectDescription> getExportedObjects(String model) throws Exception {
		IResourceDescription rd = getResourceDescription(model);
		Iterable<IEObjectDescription> exportedObjects = rd.getExportedObjects();
		return exportedObjects.iterator();
	}

	protected IResourceDescription getResourceDescription(String model) throws Exception {
		XtendFile file = file(model);
		IResourceDescription rd = resourceDescriptionManager.getResourceDescription(file.eResource());
		return rd;
	}
	
	protected IResourceDescription.Delta getResourceDescriptionDelta(String model0, String model1) throws Exception {
		IResourceDescription resourceDescription0 = new CopiedResourceDescription(getResourceDescription(model0));
		IResourceDescription resourceDescription1 = new CopiedResourceDescription(getResourceDescription(model1));
		return new DefaultResourceDescriptionDelta(resourceDescription0, resourceDescription1);
	}
	
	protected void assertSameResourceDescriptions(String model0, String model1) throws Exception {
		assertFalse(getResourceDescriptionDelta(model0, model1).haveEObjectDescriptionsChanged());
	}

	protected void assertDifferentResourceDescriptions(String model0, String model1) throws Exception {
		assertTrue(getResourceDescriptionDelta(model0, model1).haveEObjectDescriptionsChanged());
	}
	
	protected IEObjectDescription expect(Iterator<IEObjectDescription> i, String name, EClass eClass) {
		IEObjectDescription desc = i.next();
		assertEquals(name, converter.toString(desc.getQualifiedName()));
		assertEquals(eClass, desc.getEClass());
		return desc;
	}

}
