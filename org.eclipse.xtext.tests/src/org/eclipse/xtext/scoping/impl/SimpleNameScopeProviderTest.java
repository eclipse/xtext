/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.HashSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.linking.ImportUriTestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.importedURI.ImportedURIPackage;
import org.eclipse.xtext.linking.importedURI.Main;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class SimpleNameScopeProviderTest extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(ImportUriTestLanguageStandaloneSetup.class);
	}

	@Test public void testSimple() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("foo.importuritestlanguage", "import 'bar.importuritestlanguage' type foo extends bar");
		models.addModel("bar.importuritestlanguage", "type bar");

		Resource resource = rs.getResource(URI.createURI("foo.importuritestlanguage"), true);
		Main main = (Main) resource.getContents().get(0);
		assertEquals("bar", main.getTypes().get(0).getExtends().getName());
	}

	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=266879
	@Test public void testRelativeScope() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("testfile://my/folder/foo.importuritestlanguage", "import 'bar.importuritestlanguage' type foo extends bar type bar extends bar2");
		models.addModel("testfile://my/folder/bar.importuritestlanguage", "type bar type bar2 extends bar");

		Resource resource = rs.getResource(URI.createURI("testfile://my/folder/foo.importuritestlanguage"), true);
		Main main = (Main) resource.getContents().get(0);
		assertEquals("bar", main.getTypes().get(0).getExtends().getName());
		assertEquals("bar2", main.getTypes().get(0).getExtends().getExtends().getName());
		assertEquals("bar", main.getTypes().get(0).getExtends().getExtends().getExtends().getName());
		assertNull(main.getTypes().get(0).getExtends().getExtends().getExtends().getExtends());
	}

	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=266879
	@Test public void testRelativeScopeWithPath() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);
		models.addModel("testfile://my/folder/foo.importuritestlanguage", "import './../folder/bar.importuritestlanguage' type foo extends bar type bar extends bar2");

		models.addModel("testfile://my/folder/bar.importuritestlanguage", "type bar type bar2 extends bar");

		Resource resource = rs.getResource(URI.createURI("testfile://my/folder/foo.importuritestlanguage"), true);
		Main main = (Main) resource.getContents().get(0);
		assertEquals("bar", main.getTypes().get(0).getExtends().getName());
		assertEquals("bar2", main.getTypes().get(0).getExtends().getExtends().getName());
		assertEquals("bar", main.getTypes().get(0).getExtends().getExtends().getExtends().getName());
		assertNull(main.getTypes().get(0).getExtends().getExtends().getExtends().getExtends());
	}

	@Test public void testScopeFileName() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("foo.importuritestlanguage", "import 'bar.importuritestlanguage' type foo extends bar type bar extends bar2");
		models.addModel("bar.importuritestlanguage", "type bar type bar2 extends bar");

		Resource resource = rs.getResource(URI.createURI("foo.importuritestlanguage"), true);
		Main main = (Main) resource.getContents().get(0);
		assertEquals("bar", main.getTypes().get(0).getExtends().getName());
		assertEquals("bar2", main.getTypes().get(0).getExtends().getExtends().getName());
		assertEquals("bar", main.getTypes().get(0).getExtends().getExtends().getExtends().getName());
		assertNull(main.getTypes().get(0).getExtends().getExtends().getExtends().getExtends());
	}

	@Test public void testUnresolvableImport() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("testfile://my/folder/foo.importuritestlanguage",
				"import 'unknownfile.importuritestlanguage' type foo extends bar type bar extends bar2");

		Resource resource = rs.getResource(URI.createURI("testfile://my/folder/foo.importuritestlanguage"), true);
		assertNotNull(resource);
	}

	@Test public void testCircularImport() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("foo.importuritestlanguage", "import 'bar.importuritestlanguage' type foo extends bar");
		models.addModel("bar.importuritestlanguage", "import 'foo.importuritestlanguage' type bar extends foo");

		Resource resource = rs.getResource(URI.createURI("foo.importuritestlanguage"), true);
		Main main = (Main) resource.getContents().get(0);
		assertEquals("bar", main.getTypes().get(0).getExtends().getName());
		assertEquals("foo", main.getTypes().get(0).getExtends().getExtends().getName());
		assertSame(main.getTypes().get(0).getExtends().getExtends(), main.getTypes().get(0));
	}

	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=261630
	 */
	@Test public void testBug261630_duplicateImports() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("foo.importuritestlanguage", "import 'bar.importuritestlanguage' import 'bar.importuritestlanguage' import 'bar.importuritestlanguage' type foo extends bar type bar extends bar2");
		models.addModel("bar.importuritestlanguage", "type bar type bar2 extends bar");

		Resource resource = rs.getResource(URI.createURI("foo.importuritestlanguage"), true);
		Main main = (Main) resource.getContents().get(0);
		assertEquals("bar", main.getTypes().get(0).getExtends().getName());
		assertEquals("bar2", main.getTypes().get(0).getExtends().getExtends().getName());
		assertEquals("bar", main.getTypes().get(0).getExtends().getExtends().getExtends().getName());
		assertNull(main.getTypes().get(0).getExtends().getExtends().getExtends().getExtends());
	}
	
	@Test public void testGetAllContents() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("foo.importuritestlanguage", "import 'bar.importuritestlanguage' type Foo");
		models.addModel("bar.importuritestlanguage", "type A type B type C");

		Resource resource = rs.getResource(URI.createURI("foo.importuritestlanguage"), true);
		
		IScope scope = getScopeProvider().getScope(((Main)resource.getContents().get(0)).getTypes().get(0), ImportedURIPackage.Literals.TYPE__EXTENDS);
		HashSet<IEObjectDescription> set = Sets.newHashSet(scope.getAllElements());
		assertEquals(4,set.size());
	}

}
