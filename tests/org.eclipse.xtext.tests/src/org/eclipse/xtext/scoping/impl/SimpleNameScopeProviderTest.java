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
import org.eclipse.xtext.tests.AbstractGeneratorTest;

import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class SimpleNameScopeProviderTest extends AbstractGeneratorTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(ImportUriTestLanguageStandaloneSetup.class);
	}

	public void testSimple() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("foo.importuritestlanguage", "import 'bar.importuritestlanguage' type foo extends bar");
		models.addModel("bar.importuritestlanguage", "type bar");

		Resource resource = rs.getResource(URI.createURI("foo.importuritestlanguage"), true);

		assertWithXtend("'bar'", "types.first().extends.name", resource.getContents().get(0));
	}

	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=266879
	public void testRelativeScope() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("testfile://my/folder/foo.importuritestlanguage", "import 'bar.importuritestlanguage' type foo extends bar type bar extends bar2");
		models.addModel("testfile://my/folder/bar.importuritestlanguage", "type bar type bar2 extends bar");

		Resource resource = rs.getResource(URI.createURI("testfile://my/folder/foo.importuritestlanguage"), true);

		assertWithXtend("'bar'", "types.first().extends.name", resource.getContents().get(0));
		assertWithXtend("'bar2'", "types.first().extends.extends.name", resource.getContents().get(0));
		assertWithXtend("'bar'", "types.first().extends.extends.extends.name", resource.getContents().get(0));
		assertWithXtend("null", "types.first().extends.extends.extends.extends", resource.getContents().get(0));
	}

	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=266879
	public void testRelativeScopeWithPath() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);
		models.addModel("testfile://my/folder/foo.importuritestlanguage", "import './../folder/bar.importuritestlanguage' type foo extends bar type bar extends bar2");

		models.addModel("testfile://my/folder/bar.importuritestlanguage", "type bar type bar2 extends bar");

		Resource resource = rs.getResource(URI.createURI("testfile://my/folder/foo.importuritestlanguage"), true);

		assertWithXtend("'bar'", "types.first().extends.name", resource.getContents().get(0));
		assertWithXtend("'bar2'", "types.first().extends.extends.name", resource.getContents().get(0));
		assertWithXtend("'bar'", "types.first().extends.extends.extends.name", resource.getContents().get(0));
		assertWithXtend("null", "types.first().extends.extends.extends.extends", resource.getContents().get(0));
	}

	public void testScopeFileName() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("foo.importuritestlanguage", "import 'bar.importuritestlanguage' type foo extends bar type bar extends bar2");
		models.addModel("bar.importuritestlanguage", "type bar type bar2 extends bar");

		Resource resource = rs.getResource(URI.createURI("foo.importuritestlanguage"), true);

		assertWithXtend("'bar'", "types.first().extends.name", resource.getContents().get(0));
		assertWithXtend("'bar2'", "types.first().extends.extends.name", resource.getContents().get(0));
		assertWithXtend("'bar'", "types.first().extends.extends.extends.name", resource.getContents().get(0));
		assertWithXtend("null", "types.first().extends.extends.extends.extends", resource.getContents().get(0));
	}

	public void testUnresolvableImport() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("testfile://my/folder/foo.importuritestlanguage",
				"import 'unknownfile.importuritestlanguage' type foo extends bar type bar extends bar2");

		Resource resource = rs.getResource(URI.createURI("testfile://my/folder/foo.importuritestlanguage"), true);
		assertNotNull(resource);
	}

	public void testCircularImport() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("foo.importuritestlanguage", "import 'bar.importuritestlanguage' type foo extends bar");
		models.addModel("bar.importuritestlanguage", "import 'foo.importuritestlanguage' type bar extends foo");

		Resource resource = rs.getResource(URI.createURI("foo.importuritestlanguage"), true);

		assertWithXtend("'bar'", "types.first().extends.name", resource.getContents().get(0));
		assertWithXtend("'foo'", "types.first().extends.extends.name", resource.getContents().get(0));
		assertWithXtend("true", "types.first().extends.extends == types.first()", resource.getContents().get(0));
	}

	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=261630
	 */
	public void testBug261630_duplicateImports() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("foo.importuritestlanguage", "import 'bar.importuritestlanguage' import 'bar.importuritestlanguage' import 'bar.importuritestlanguage' type foo extends bar type bar extends bar2");
		models.addModel("bar.importuritestlanguage", "type bar type bar2 extends bar");

		Resource resource = rs.getResource(URI.createURI("foo.importuritestlanguage"), true);

		assertWithXtend("'bar'", "types.first().extends.name", resource.getContents().get(0));
		assertWithXtend("'bar2'", "types.first().extends.extends.name", resource.getContents().get(0));
		assertWithXtend("'bar'", "types.first().extends.extends.extends.name", resource.getContents().get(0));
		assertWithXtend("null", "types.first().extends.extends.extends.extends", resource.getContents().get(0));
	}
	
	public void testGetAllContents() throws Exception {
		SyntheticModelAwareURIConverter models = new SyntheticModelAwareURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("foo.importuritestlanguage", "import 'bar.importuritestlanguage' type Foo");
		models.addModel("bar.importuritestlanguage", "type A type B type C");

		Resource resource = rs.getResource(URI.createURI("foo.importuritestlanguage"), true);
		
		IScope scope = getScopeProvider().getScope(((Main)resource.getContents().get(0)).getTypes().get(0), ImportedURIPackage.Literals.TYPE__EXTENDS);
		HashSet<IEObjectDescription> set = Sets.newHashSet(scope.getAllContents());
		assertEquals(4,set.size());
	}

}
