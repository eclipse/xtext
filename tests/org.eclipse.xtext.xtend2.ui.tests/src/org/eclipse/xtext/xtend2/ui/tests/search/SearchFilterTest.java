/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.search;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.xtend2.xtend2.Xtend2Package.Literals.*;

import java.util.Iterator;

import junit.framework.Test;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xtend2.ui.search.Xtend2SearchFilter;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SearchFilterTest extends AbstractXtend2UITestCase {

	public static Test suite() {
		return WorkbenchTestHelper.suite(SearchFilterTest.class);
	}
	
	@Inject
	protected WorkbenchTestHelper testHelper;
	
	@Inject
	protected IResourceDescription.Manager resourceDescriptionManager;
	
	@Inject
	protected Xtend2SearchFilter searchFilter;
	
	@Inject
	protected IQualifiedNameConverter converter;
	
	@Override
	protected void tearDown() throws Exception {
		testHelper.tearDown();
		super.tearDown();
	}
	
	public void testSimpleFile() throws Exception {
		Iterator<IEObjectDescription> iterator = getExportedObjects(
				"package test\n" +
				"class Foo {\n" +
				"  def bar() {this}\n" +
				"}");
		expect(iterator, "test.Foo", XTEND_CLASS);
		expect(iterator, "test.Foo.bar", XTEND_FUNCTION);
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
		assertFalse(iterator.hasNext()); 
	}

	protected Iterator<IEObjectDescription> getExportedObjects(String model) throws Exception {
		XtendFile file = testHelper.xtendFile("test/Foo", model);
		IResourceDescription rd = resourceDescriptionManager.getResourceDescription(file.eResource());
		Iterable<IEObjectDescription> exportedObjects = rd.getExportedObjects();
		return filter(exportedObjects, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription element) {
				return !searchFilter.reject(element);
			}
		}).iterator();
	}
	
	protected void expect(Iterator<IEObjectDescription> i, String name, EClass eClass) {
		IEObjectDescription desc = i.next();
		assertEquals(name, converter.toString(desc.getQualifiedName()));
		assertEquals(eClass, desc.getEClass());
	}
}
