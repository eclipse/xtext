/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextResourceDescriptionTest extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup());
	}
	
	@Test public void testComputeEObjectDescriptionsForEmptyFile() throws Exception {
		Resource res = getResourceAndExpect(new StringInputStream(""),URI.createURI("foo.xtext"),1);
		Manager manager = get(IResourceDescription.Manager.class);
		IResourceDescription description = manager.getResourceDescription(res);
		Iterable<IEObjectDescription> iterable = description.getExportedObjects();
		assertTrue(Lists.newArrayList(iterable).isEmpty());
	}
	
	@Test public void testComputeEObjectDescriptionsForUnnamedGrammar() throws Exception {
		Resource res = getResourceAndExpect(new StringInputStream("grammar "),URI.createURI("foo.xtext"),1);
		Manager manager = get(IResourceDescription.Manager.class);
		IResourceDescription description = manager.getResourceDescription(res);
		Iterable<IEObjectDescription> iterable = description.getExportedObjects();
		assertTrue(Lists.newArrayList(iterable).isEmpty());
	}
	
	@Test public void testGetExportedEObjectsErroneousResource() throws Exception {
		Resource res = getResourceAndExpect(new StringInputStream("grammar foo Start : 'main';"),URI.createURI("foo.xtext"),1);
		Manager manager = get(IResourceDescription.Manager.class);
		IResourceDescription description = manager.getResourceDescription(res);
		Iterable<IEObjectDescription> iterable = description.getExportedObjects();
		assertTrue(Lists.newArrayList(iterable).size()==2);
	}

	@Test public void testGetExportedEObjects() throws Exception {
		Resource res = getResource(new StringInputStream("grammar foo generate x \"someURI\" Start : 'main';"),URI.createURI("foo.xtext"));
		Manager manager = get(IResourceDescription.Manager.class);
		IResourceDescription description = manager.getResourceDescription(res);
		Iterable<IEObjectDescription> iterable = description.getExportedObjects();
		assertTrue(Lists.newArrayList(iterable).size()==3);
	}
	
	@Test public void testBug350695() throws Exception {
		Resource res = getResource(new StringInputStream("grammar org.foo.Zonk generate x \"someURI\" Start : 'main';"), URI.createURI("foo.xtext"));
		Manager manager = get(IResourceDescription.Manager.class);
		IResourceDescription description = manager.getResourceDescription(res);
		assertTrue(Iterables.isEmpty(description.getExportedObjects(XtextPackage.Literals.GRAMMAR, QualifiedName.create("org.foo.Zonk"), false)));
		IEObjectDescription element = Iterables.getOnlyElement(
				description.getExportedObjects(XtextPackage.Literals.GRAMMAR, QualifiedName.create("org","foo","Zonk"), false));
		assertNotNull(element);
	}
}
