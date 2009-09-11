/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.linking.ImportUriTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class DefaultScopeProviderTest extends AbstractGeneratorTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(ImportUriTestLanguageStandaloneSetup.class);
	}

	public void testSimple() throws Exception {
		TestURIConverter models = new TestURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("foo.importuritestlanguage", "import 'bar.importuritestlanguage' type foo extends bar");
		models.addModel("bar.importuritestlanguage", "type bar");

		Resource resource = rs.getResource(URI.createURI("foo.importuritestlanguage"), true);

		assertWithXtend("'bar'", "types.first().extends.name", resource.getContents().get(0));
	}

	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=266879
	public void testRelativeScope() throws Exception {
		TestURIConverter models = new TestURIConverter();
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
		TestURIConverter models = new TestURIConverter();
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
		TestURIConverter models = new TestURIConverter();
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
		TestURIConverter models = new TestURIConverter();
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.setURIConverter(models);

		models.addModel("testfile://my/folder/foo.importuritestlanguage",
				"import 'unknownfile.importuritestlanguage' type foo extends bar type bar extends bar2");

		Resource resource = rs.getResource(URI.createURI("testfile://my/folder/foo.importuritestlanguage"), true);
		assertNotNull(resource);
	}

	public void testCircularImport() throws Exception {
		TestURIConverter models = new TestURIConverter();
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
		TestURIConverter models = new TestURIConverter();
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


	class TestURIConverter extends ExtensibleURIConverterImpl {
		private final Map<URI, InputStream> models = new HashMap<URI, InputStream>();

		public void addModel(String uri, String content) {
			models.put(URI.createURI(uri), new StringInputStream(content));
		}

		@Override
		public boolean exists(URI uri, Map<?, ?> options) {
		 	boolean result = models.containsKey(uri);
		 	if (!result) {
		 		for(URI knownUri: models.keySet()) {
		 			if (uri.toString().endsWith(knownUri.toString()))
		 				return true;
		 		}
		 	}
		 	return result;
		}

		@Override
		public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
			return models.get(uri);
		}
	}

}
