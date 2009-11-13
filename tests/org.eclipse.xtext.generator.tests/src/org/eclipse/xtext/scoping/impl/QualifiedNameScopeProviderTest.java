/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.index.IndexTestLanguageStandaloneSetup;
import org.eclipse.xtext.index.indexTestLanguage.Datatype;
import org.eclipse.xtext.index.indexTestLanguage.Entity;
import org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IExportedEObjectsProvider;
import org.eclipse.xtext.resource.IQualifiedNameProvider;
import org.eclipse.xtext.resource.ResourceSetReferencingResourceSetImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.DefaultExportedEObjectsProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.namespaces.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.scoping.namespaces.QualifiedName;
import org.eclipse.xtext.scoping.namespaces.QualifiedNameScopeProvider;
import org.eclipse.xtext.scoping.namespaces.QualifiedNameScopeProvider.ImportNormalizer;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class QualifiedNameScopeProviderTest extends AbstractGeneratorTest {

	private QualifiedNameScopeProvider scopeProvider;
	private ResourceSetGlobalScopeProvider globalScopeProvider;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new IndexTestLanguageStandaloneSetup());

		globalScopeProvider = new ResourceSetGlobalScopeProvider();
		globalScopeProvider.setServiceProvider(new IExportedEObjectsProvider.Registry() {
			public IExportedEObjectsProvider getExportedEObjectsProvider(Resource resource) {
				DefaultExportedEObjectsProvider result = new DefaultExportedEObjectsProvider();
				result.setNameProvider(new DefaultDeclarativeQualifiedNameProvider());
				return result;
			}});
		scopeProvider = new QualifiedNameScopeProvider();
		scopeProvider.setGlobalScopeProvider(globalScopeProvider);
		scopeProvider.setNameProvider(nameProvider);
	}

	public void testImports() throws Exception {
		XtextResource resource = getResource(new StringInputStream("import foo.bar.* "), URI
				.createURI("import.indextestlanguage"));
		resource.getResourceSet().createResource(URI.createURI("foo.indextestlanguage")).load(
				new StringInputStream("foo.bar { " + "  entity Person {  " + "    String name " + "  } " + "  datatype String " + "}"), null);

		IScope scope = scopeProvider.getScope(resource.getContents().get(0), IndexTestLanguagePackage.eINSTANCE
				.getFile_Elements());
		List<String> names = toListOfNames(scope.getAllContents());
		assertEquals(names.toString(), 5, names.size());
		assertTrue(names.contains("Person"));
		assertTrue(names.contains("String"));
		assertTrue(names.contains("foo.bar"));
		assertTrue(names.contains("foo.bar.Person"));
		assertTrue(names.contains("foo.bar.String"));
	}

	public void testRelativeContext() throws Exception {
		final XtextResource resource = getResource(new StringInputStream("stuff { " + "  baz { "
				+ "    datatype String " + "  } " + "  entity Person {}" + "}"), URI
				.createURI("relative.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Entity entity = filter(allContents, Entity.class).iterator().next();

		IScope scope = scopeProvider.getScope(entity, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getContentByName("baz.String"));
		assertNotNull(scope.getContentByName("stuff.baz.String"));
	}

	public void testRelativePath() throws Exception {
		final XtextResource resource = getResource(new StringInputStream("stuff { " + "  import baz.*" + "  baz { "
				+ "    datatype String " + "  } " + "  entity Person {" + "  }" + "}"), URI
				.createURI("relative.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Entity entity = filter(allContents, Entity.class).iterator().next();

		IScope scope = scopeProvider.getScope(entity, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getContentByName("String"));
		assertNotNull(scope.getContentByName("baz.String"));
		assertNotNull(scope.getContentByName("stuff.baz.String"));
	}

	public void testReexports() throws Exception {
		final XtextResource resource = getResource(new StringInputStream(
				  "stuff { " 
				+ "  import baz.*" 
				+ "  baz { "
				+ "    stuff {" 
				+ "      import stuff.*" 
				+ "      datatype String " 
				+ "    }" 
				+ "    entity Person {}"
				+ "  }" + "}"), URI.createURI("relative.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Datatype datatype = filter(allContents, Datatype.class).iterator().next();

		EReference propertyType = EcoreFactory.eINSTANCE.createEReference();
		propertyType.setEType(IndexTestLanguagePackage.eINSTANCE.getEntity());
		
		IScope scope = scopeProvider.getScope(datatype, propertyType);
		List<String> names = toListOfNames(scope.getContents());
		assertEquals(names.toString(), 0, names.size());

		scope = scope.getOuterScope(); // stuff {
		names = toListOfNames(scope.getContents());
		assertEquals(names.toString(), 0, names.size());

		scope = scope.getOuterScope(); // import stuff.*
		names = toListOfNames(scope.getContents());
		assertEquals(names.toString(), 1, names.size());
		assertTrue(names.toString(), names.contains("baz.Person"));

		scope = scope.getOuterScope(); // baz {
		names = toListOfNames(scope.getContents());
		assertEquals(names.toString(), 1, names.size());
		assertTrue(names.toString(), names.contains("Person"));

		scope = scope.getOuterScope(); // stuff {
		names = toListOfNames(scope.getContents());
		assertEquals(names.toString(), 1, names.size());
		assertTrue(names.contains("baz.Person"));

		scope = scope.getOuterScope(); // import baz.*
		names = toListOfNames(scope.getContents());
		assertEquals(names.toString(), 1, names.size());
		assertTrue(names.contains("Person"));

		scope = scope.getOuterScope(); // global scope
		names = toListOfNames(scope.getContents());
		assertEquals(names.toString(), 1, names.size());
		assertTrue(names.contains("stuff.baz.Person"));

	}

	public void testReexports2() throws Exception {
		final XtextResource resource = getResource(new StringInputStream("A { " + "  B { " + "    entity D {}" + "  }"
				+ "}" + "E {" + "  import A.B.*" + "  entity D {}" + "  datatype Context" + "}"), URI
				.createURI("testReexports2.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Datatype datatype = filter(allContents, Datatype.class).iterator().next();

		IScope scope = scopeProvider.getScope(datatype, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getContentByName("D"));
		assertNotNull(scope.getContentByName("E.D"));
		assertNotNull(scope.getContentByName("A.B.D"));
	}

	public void testLocalElementsNotFromIndex() throws Exception {
		final XtextResource resource = getResource(new StringInputStream("A { " + "  B { " + "    entity D {}" + "  }"
				+ "}" + "E {" + "  datatype Context" + "}"), URI.createURI("foo23.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Datatype datatype = filter(allContents, Datatype.class).iterator().next();
		IScope scope = scopeProvider.getScope(datatype, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getContentByName("A.B.D"));
	}

	public void testImportsWithoutWildcard() throws Exception {
		final XtextResource resource = getResource(new StringInputStream("foo { " + "  import bar.Bar"
				+ "  entity Foo {" + "  }" + "}" + "bar {" + "  entity Bar{}" + "}"), URI
				.createURI("withoutwildcard.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Iterator<Entity> iterator = Iterables.filter(allContents, Entity.class).iterator();
		Entity foo = iterator.next();
		assertEquals("Foo", foo.getName());

		IScope scope = scopeProvider.getScope(foo, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getContentByName("Bar"));
	}

	public void testMultipleFiles() throws Exception {
		ResourceSetImpl rs = new ResourceSetImpl();
		final Resource res1 = rs.createResource(URI.createURI("file1.indextestlanguage"));
		Resource res2 = rs.createResource(URI.createURI("file2.indextestlanguage"));
		res1.load(new StringInputStream("foo { " + "  import bar.Bar" + "  entity Foo {" + "  }" + "}"), null);
		res2.load(new StringInputStream("bar {" + "  entity Bar{}" + "}"), null);

		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return res1.getAllContents();
			}
		};
		Iterator<Entity> iterator = Iterables.filter(allContents, Entity.class).iterator();
		Entity foo = iterator.next();
		assertEquals("Foo", foo.getName());

		IScope scope = scopeProvider.getScope(foo, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getContentByName("Bar"));
	}

	public void testImportNormalizer() throws Exception {
		ImportNormalizer normalizer = new ImportNormalizer(new QualifiedName("foo.Bar"));
		assertEquals("foo.Bar", normalizer.shortToLongName("Bar"));
		assertEquals("Bar", normalizer.longToShortName("foo.Bar"));
		assertNull(normalizer.longToShortName("foo.Baz"));
		assertNull(normalizer.shortToLongName("Baz"));
	}

	public void testImportNormalizerWithWildCard() throws Exception {
		ImportNormalizer normalizer = new ImportNormalizer(new QualifiedName("foo.bar.*"));
		assertEquals("Bar", normalizer.longToShortName("foo.bar.Bar"));
		assertEquals("foo.bar.Bar", normalizer.shortToLongName("Bar"));
		assertNull(normalizer.longToShortName("foo.Baz"));
		assertEquals("foo.bar.bar.Baz", normalizer.shortToLongName("bar.Baz"));
	}

	public void testResourceSetReferencingResourceSet() throws Exception {
		ResourceSetReferencingResourceSetImpl rs = new ResourceSetReferencingResourceSetImpl();
		Resource res = rs.createResource(URI.createURI("file2.indextestlanguage"));
		res.load(new StringInputStream("bar {" + "  entity Bar{}" + "}"), null);

		ResourceSetReferencingResourceSetImpl rs1 = new ResourceSetReferencingResourceSetImpl();
		rs1.getReferencedResourceSets().add(rs);
		final Resource res1 = rs1.createResource(URI.createURI("file1.indextestlanguage"));
		res1.load(new StringInputStream("foo { " + "  import bar.Bar" + "  entity Foo {" + "  }" + "}"), null);

		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return res1.getAllContents();
			}
		};
		Iterator<Entity> iterator = Iterables.filter(allContents, Entity.class).iterator();
		Entity foo = iterator.next();
		assertEquals("Foo", foo.getName());

		IScope scope = scopeProvider.getScope(foo, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getContentByName("Bar"));
		assertNotNull(scope.getContentByName("bar.Bar"));
	}

	public void testResourceSetReferencingResourceSet2() throws Exception {
		ResourceSetReferencingResourceSetImpl rs = new ResourceSetReferencingResourceSetImpl();
		Resource res = rs.createResource(URI.createURI("file2.indextestlanguage"));
		res.load(new StringInputStream("bar {" + "  entity Bar{}" + "}"), null);

		ResourceSetReferencingResourceSetImpl rs1 = new ResourceSetReferencingResourceSetImpl();
		rs1.getReferencedResourceSets().add(rs);
		final Resource res1 = rs1.createResource(URI.createURI("file1.indextestlanguage"));
		res1.load(new StringInputStream("foo { " + "  import bar.Bar" + "  entity Foo {" + "  }" + "}"), null);

		ResourceSetReferencingResourceSetImpl rs2 = new ResourceSetReferencingResourceSetImpl();
		rs2.getReferencedResourceSets().add(rs1);
		final Resource res2 = rs2.createResource(URI.createURI("file2.indextestlanguage"));
		res2.load(new StringInputStream("baz {" + "  entity Baz{}" + "}"), null);

		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return res2.getAllContents();
			}
		};
		Iterator<Entity> iterator = Iterables.filter(allContents, Entity.class).iterator();
		Entity baz = iterator.next();
		assertEquals("Baz", baz.getName());

		IScope scope = scopeProvider.getScope(baz, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getContentByName("foo.Foo"));
		assertNull(scope.getContentByName("bar.Bar"));
	}

	private static IQualifiedNameProvider nameProvider = new DefaultDeclarativeQualifiedNameProvider();

	private List<String> toListOfNames(Iterable<IEObjectDescription> elements) {
		List<String> result = new ArrayList<String>();
		for (IEObjectDescription e : elements) {
			if (!result.contains(e.getName()))
				result.add(e.getName());
		}
		Collections.sort(result);
		return result;
	}

}
