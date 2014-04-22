/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.resource;

import static org.eclipse.xtext.common.types.TypesPackage.Literals.*;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Wrapper;
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
	private IDerivedStateComputer derivedStateComputer;
	
	@Inject
	private ClassLoader classLoader;
	
	@Test public void testIndexing() throws Exception {
		Iterator<IEObjectDescription> iterator = getExportedObjects(
				"package test\n" +
				"class Foo {\n" +
				"  String baz\n" +
				"  def bar() {this}\n" +
				"}");
//		expect(iterator, "test.Foo", XTEND_CLASS);
//		expect(iterator, "test.Foo.baz", XTEND_FIELD);
//		expect(iterator, "test.Foo.bar", XTEND_FUNCTION);
		expect(iterator, "test.Foo", JVM_GENERIC_TYPE);
//		expect(iterator, "test.Foo", JVM_CONSTRUCTOR);
//		expect(iterator, "test.Foo.baz", JVM_FIELD);
//		expect(iterator, "test.Foo.bar", JVM_OPERATION);
		assertFalse(iterator.hasNext());
	}

	@Test public void testDispatchMethod() throws Exception {
		Iterator<IEObjectDescription> iterator = getExportedObjects(
				"package test\n" +
				"class Foo {\n" +
				"  def dispatch foo(Object x) {x.toString}\n" +
				"  def dispatch foo(String y) {y}\n" +
				"}");
//		expect(iterator, "test.Foo", XTEND_CLASS);
//		expect(iterator, "test.Foo.foo", XTEND_FUNCTION);
//		expect(iterator, "test.Foo.foo", XTEND_FUNCTION);
		expect(iterator, "test.Foo", JVM_GENERIC_TYPE);
//		expect(iterator, "test.Foo", JVM_CONSTRUCTOR);
//		assertFalse(flags.isDispatcherOperation(expect(iterator, "test.Foo._foo", JVM_OPERATION)));
//		assertFalse(flags.isDispatcherOperation(expect(iterator, "test.Foo._foo", JVM_OPERATION)));
//		assertTrue(flags.isDispatcherOperation(expect(iterator, "test.Foo.foo", JVM_OPERATION)));
		assertFalse(iterator.hasNext()); 
	}

	@Test public void testConstructors() throws Exception {
		Iterator<IEObjectDescription> iterator = getExportedObjects("package test\n" +
				"class Foo {\n" +
				"  new(String x) {}\n" +
				"  new(int x) {}\n" +
				"}");
//		expect(iterator, "test.Foo", XTEND_CLASS);
//		expect(iterator, "test.Foo", XTEND_CONSTRUCTOR);
//		expect(iterator, "test.Foo", XTEND_CONSTRUCTOR);
		expect(iterator, "test.Foo", JVM_GENERIC_TYPE);
//		expect(iterator, "test.Foo", JVM_CONSTRUCTOR);
//		expect(iterator, "test.Foo", JVM_CONSTRUCTOR);
		assertFalse(iterator.hasNext()); 
	}
	
	@Test public void testStaticFlags() throws Exception {
		Iterator<IEObjectDescription> iterator = getExportedObjects("package test\n" +
				"class Foo {\n" +
				"  String bar\n" +
				"  static String bar_static\n" +
				"  def foo() {}\n" +
				"  def static foo_static() {}\n" +
				"}");
//		expect(iterator, "test.Foo", XTEND_CLASS);
//		assertFalse(flags.isStatic(iterator.next()));
//		assertTrue(flags.isStatic(iterator.next()));
//		assertFalse(flags.isStatic(iterator.next()));
//		assertTrue(flags.isStatic(iterator.next()));
		expect(iterator, "test.Foo", JVM_GENERIC_TYPE);
//		expect(iterator, "test.Foo", JVM_CONSTRUCTOR);
//		assertFalse(flags.isStatic(iterator.next()));
//		assertTrue(flags.isStatic(iterator.next()));
//		assertFalse(flags.isStatic(iterator.next()));
//		assertTrue(flags.isStatic(iterator.next()));
		assertFalse(iterator.hasNext()); 
	}
	
	@Test public void testAnonymousClass() throws Exception {
		Iterator<IEObjectDescription> iterator = getExportedObjects("package test\n" +
				"class Foo {\n" +
				"  val bar = new Runnable() {\n" +
				"    override run() {}\n" +
				"  }\n" +
				"}");
//		expect(iterator, "test.Foo", XTEND_CLASS);
//		assertFalse(flags.isStatic(iterator.next()));
//		assertTrue(flags.isStatic(iterator.next()));
//		assertFalse(flags.isStatic(iterator.next()));
//		assertTrue(flags.isStatic(iterator.next()));
		expect(iterator, "test.Foo", JVM_GENERIC_TYPE);
//		expect(iterator, "test.Foo", JVM_CONSTRUCTOR);
//		assertFalse(flags.isStatic(iterator.next()));
//		assertTrue(flags.isStatic(iterator.next()));
//		assertFalse(flags.isStatic(iterator.next()));
//		assertTrue(flags.isStatic(iterator.next()));
		assertFalse(iterator.hasNext()); 
	}
	
	@Test public void testResourceDescriptionWithoutGetContentsWithAnnotations() throws Exception {
		String input = "import com.google.inject.Inject class C%d extends C%d { @Inject def void m(Map<String, String> m) {} }";
		doTestResourceDescriptionWithoutGetContents(input);
	}
	
	private void doTestResourceDescriptionWithoutGetContents(final String input) throws IOException {
		XtextResourceSet resourceSet = getResourceSet();
		new ClasspathTypeProvider(classLoader, resourceSet, null);
		final Wrapper<Boolean> wrapper = Wrapper.wrap(Boolean.FALSE);
		for (int i = 0; i < 10; i++) {
			DerivedStateAwareResource resource = (DerivedStateAwareResource) resourceSet.createResource(URI.createURI("Dummy" + i + ".xtend"));
			resource.setDerivedStateComputer(new IDerivedStateComputer() {
				public void installDerivedState(DerivedStateAwareResource resource, boolean preLinkingPhase) {
					if (!preLinkingPhase) {
						wrapper.set(Boolean.TRUE);
					}
					derivedStateComputer.installDerivedState(resource, preLinkingPhase);
				}
				
				public void discardDerivedState(DerivedStateAwareResource resource) {
					derivedStateComputer.discardDerivedState(resource);
				}
			});
			String actualInput = input;
			if (i != 0) {
				actualInput = "import C" + (i+1) + " " + actualInput;
				actualInput = "import C" + (i-1) + " " + actualInput;
			}
			actualInput = String.format(actualInput, i, i+1);
			resource.load(new StringInputStream(actualInput), null);
		}
		for(int i = 0; i < 10; i++) {
			Resource resource = resourceSet.getResources().get(i);
			for(IEObjectDescription description: resourceDescriptionManager.getResourceDescription(resource).getExportedObjects()) {
				description.getEObjectOrProxy();
			}
		}
		assertFalse(wrapper.get());
	}
	
	@Test public void testResourceDescriptionWithoutGetContentsNoAnnotations() throws Exception {
		String input = "import com.google.inject.Inject class C { def void m(Map<String, String> m) {} }";
		doTestResourceDescriptionWithoutGetContents(input);
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
		
	protected IEObjectDescription expect(Iterator<IEObjectDescription> i, String name, EClass eClass) {
		IEObjectDescription desc = i.next();
		assertEquals(name, converter.toString(desc.getQualifiedName()));
		assertEquals(eClass, desc.getEClass());
		return desc;
	}

}
