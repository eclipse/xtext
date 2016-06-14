/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.search;

import static com.google.common.collect.Iterables.*;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.ide.search.XtendSearchFilter;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SearchFilterTest extends AbstractXtendUITestCase {

	@Inject
	protected WorkbenchTestHelper testHelper;
	
	@Inject
	protected IResourceDescription.Manager resourceDescriptionManager;
	
	@Inject
	protected XtendSearchFilter searchFilter;
	
	@Inject
	protected IQualifiedNameConverter converter;
	
	@Override
	public void tearDown() throws Exception {
		testHelper.tearDown();
		super.tearDown();
	}
	
	@Test public void testSimpleFile() throws Exception {
		Iterator<IEObjectDescription> iterator = getExportedObjects(
				"package test\n" +
				"class Foo {\n" +
				"  def bar() {this}\n" +
				"}");
		// nothing in it, since xtedn only exports JvmGenericTypes and those are filtered.
		assertFalse(iterator.hasNext());
	}
	
	@Test public void testDispatchMethod() throws Exception {
		Iterator<IEObjectDescription> iterator = getExportedObjects(
				"package test\n" +
				"class Foo {\n" +
				"  def dispatch foo(Object x) {x.toString}\n" +
				"  def dispatch foo(String y) {y}\n" +
				"}");
		// nothing in it, since xtedn only exports JvmGenericTypes and those are filtered.
		assertFalse(iterator.hasNext()); 
	}

	protected Iterator<IEObjectDescription> getExportedObjects(String model) throws Exception {
		XtendFile file = testHelper.xtendFile("test/Foo", model);
		IResourceDescription rd = resourceDescriptionManager.getResourceDescription(file.eResource());
		Iterable<IEObjectDescription> exportedObjects = rd.getExportedObjects();
		return filter(exportedObjects, new Predicate<IEObjectDescription>() {
			@Override
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
