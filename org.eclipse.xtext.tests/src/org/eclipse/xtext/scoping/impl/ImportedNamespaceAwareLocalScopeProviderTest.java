/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.index.IndexTestLanguageStandaloneSetup;
import org.eclipse.xtext.index.indexTestLanguage.Datatype;
import org.eclipse.xtext.index.indexTestLanguage.Entity;
import org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.ResourceSetReferencingResourceSetImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceServiceProviderRegistryImpl;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class ImportedNamespaceAwareLocalScopeProviderTest extends AbstractXtextTests {

	private ImportedNamespaceAwareLocalScopeProvider scopeProvider;
	private ResourceSetGlobalScopeProvider globalScopeProvider;
	private IQualifiedNameProvider nameProvider;
	private IQualifiedNameConverter nameConverter;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new IndexTestLanguageStandaloneSetup());

		globalScopeProvider = new ResourceSetGlobalScopeProvider();
		nameProvider = new DefaultDeclarativeQualifiedNameProvider();
		nameConverter = new IQualifiedNameConverter.DefaultImpl();
		final DefaultResourceDescriptionStrategy strategy = new DefaultResourceDescriptionStrategy();
		strategy.setQualifiedNameProvider(nameProvider);
		final DefaultResourceDescriptionManager resourceDescMnr = new DefaultResourceDescriptionManager() {
			@Override
			public IResourceDescription getResourceDescription(Resource resource) {
				DefaultResourceDescription resourceDescription = new DefaultResourceDescription(resource,
						strategy);
				return resourceDescription;
			}
			
		};
		final DefaultResourceServiceProvider provider = new DefaultResourceServiceProvider() {
			@Override
			public Manager getResourceDescriptionManager() {
				return resourceDescMnr;
			}
		};
		globalScopeProvider.setGlobalResourceDecriptionProvider(new GlobalResourceDescriptionProvider(new ResourceServiceProviderRegistryImpl() {
			@Override
			public IResourceServiceProvider getResourceServiceProvider(URI uri, String contentType) {
				return provider;
			}
		}));
		CaseInsensitivityHelper caseInsensitivityHelper = new CaseInsensitivityHelper();
		globalScopeProvider.setCaseInsensitivityHelper(caseInsensitivityHelper);
		scopeProvider = new ImportedNamespaceAwareLocalScopeProvider(globalScopeProvider, nameProvider, nameConverter, caseInsensitivityHelper);
	}

	@Test public void testImports() throws Exception {
		XtextResource resource = getResource(new StringInputStream("import foo.bar.* "), URI
				.createURI("import.indextestlanguage"));
		resource.getResourceSet().createResource(URI.createURI("foo.indextestlanguage")).load(
				new StringInputStream(
						"foo.bar { " 
						+ "  entity Person {  " 
						+ "    String name " 
						+ "  } "
						+ "  datatype String " 
						+ "}"), null);

		IScope scope = scopeProvider.getScope(resource.getContents().get(0), IndexTestLanguagePackage.eINSTANCE
				.getFile_Elements());
		List<QualifiedName> names = toListOfNames(scope.getAllElements());
		assertEquals(names.toString(), 5, names.size());
		assertTrue(names.contains(nameConverter.toQualifiedName("Person")));
		assertTrue(names.contains(nameConverter.toQualifiedName("String")));
		assertTrue(names.contains(nameConverter.toQualifiedName("foo.bar")));
		assertTrue(names.contains(nameConverter.toQualifiedName("foo.bar.Person")));
		assertTrue(names.contains(nameConverter.toQualifiedName("foo.bar.String")));
	}
	
	@Test public void testImports_02() throws Exception {
		XtextResource resource = getResource(new StringInputStream("import foo.* "), URI
				.createURI("import.indextestlanguage"));
		resource.getResourceSet().createResource(URI.createURI("foo.indextestlanguage")).load(
				new StringInputStream(
						"foo.bar { " 
						+ "  entity Person {  " 
						+ "    String name " 
						+ "  } "
						+ "  datatype String " 
						+ "}"), null);

		IScope scope = scopeProvider.getScope(resource.getContents().get(0), IndexTestLanguagePackage.eINSTANCE
				.getFile_Elements());
		List<QualifiedName> names = toListOfNames(scope.getAllElements());
		assertEquals(names.toString(), 6, names.size());
		assertTrue(names.contains(nameConverter.toQualifiedName("bar.Person")));
		assertTrue(names.contains(nameConverter.toQualifiedName("bar.String")));
		assertTrue(names.contains(nameConverter.toQualifiedName("bar")));
		assertTrue(names.contains(nameConverter.toQualifiedName("foo.bar")));
		assertTrue(names.contains(nameConverter.toQualifiedName("foo.bar.Person")));
		assertTrue(names.contains(nameConverter.toQualifiedName("foo.bar.String")));
	}
	
	@Test public void testImports_03() throws Exception {
		XtextResource resource = getResource(new StringInputStream("import foo.bar"), URI
				.createURI("import.indextestlanguage"));
		resource.getResourceSet().createResource(URI.createURI("foo.indextestlanguage")).load(
				new StringInputStream(
						"foo.bar { " 
						+ "  entity Person {  " 
						+ "    String name " 
						+ "  } "
						+ "  datatype String " 
						+ "}"), null);

		IScope scope = scopeProvider.getScope(resource.getContents().get(0), IndexTestLanguagePackage.eINSTANCE
				.getFile_Elements());
		List<QualifiedName> names = toListOfNames(scope.getAllElements());
		assertEquals(names.toString(), 4, names.size());
		assertTrue(names.contains(nameConverter.toQualifiedName("bar")));
		assertTrue(names.contains(nameConverter.toQualifiedName("foo.bar")));
		assertTrue(names.contains(nameConverter.toQualifiedName("foo.bar.Person")));
		assertTrue(names.contains(nameConverter.toQualifiedName("foo.bar.String")));
	}

	@Test public void testRelativeContext() throws Exception {
		final XtextResource resource = getResource(new StringInputStream(
				  "stuff { " 
				+ "  baz { "
				+ "    datatype String " 
				+ "  } " 
				+ "  entity Person {}" 
				+ "}"), URI
				.createURI("relative.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			@Override
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Entity entity = filter(allContents, Entity.class).iterator().next();

		IScope scope = scopeProvider.getScope(entity, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("baz.String")));
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("stuff.baz.String")));
	}

	@Test public void testRelativePath() throws Exception {
		final XtextResource resource = getResource(new StringInputStream(
				  "stuff { " 
				+ "  import baz.*" 
				+ "  baz { "
				+ "    datatype String " 
				+ "  } " 
				+ "  entity Person {" 
				+ "  }" 
				+ "}"), URI
				.createURI("relative.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			@Override
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Entity entity = filter(allContents, Entity.class).iterator().next();

		IScope scope = scopeProvider.getScope(entity, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("String")));
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("baz.String")));
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("stuff.baz.String")));
	}

	@Test public void testReexports2() throws Exception {
		final XtextResource resource = getResource(new StringInputStream(
				  "A { " 
				+ "  B { " 
				+ "    entity D {}" + "  }"
				+ "}" 
				+ "E {" 
				+ "  import A.B.*" 
				+ "  entity D {}" 
				+ "  datatype Context" 
				+ "}"), URI
				.createURI("testReexports2.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			@Override
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Datatype datatype = filter(allContents, Datatype.class).iterator().next();

		IScope scope = scopeProvider.getScope(datatype, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("D")));
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("E.D")));
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("A.B.D")));
	}

	@Test public void testLocalElementsNotFromIndex() throws Exception {
		final XtextResource resource = getResource(new StringInputStream(
				  "A { " 
				+ "  B { " 
				+ "    entity D {}" 
				+ "  }"
				+ "}" 
				+ "E {" 
				+ "  datatype Context" 
				+ "}"), URI.createURI("foo23.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			@Override
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Datatype datatype = filter(allContents, Datatype.class).iterator().next();
		IScope scope = scopeProvider.getScope(datatype, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("A.B.D")));
	}

	@Test public void testImportsWithoutWildcard() throws Exception {
		final XtextResource resource = getResource(new StringInputStream(
				  "foo { " 
				+ "  import bar.Bar"
				+ "  entity Foo {" 
				+ "  }" 
				+ "}" 
				+ "bar {" 
				+ "  entity Bar{}" 
				+ "}"), URI
				.createURI("withoutwildcard.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			@Override
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Iterator<Entity> iterator = Iterables.filter(allContents, Entity.class).iterator();
		Entity foo = iterator.next();
		assertEquals("Foo", foo.getName());

		IScope scope = scopeProvider.getScope(foo, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("Bar")));
	}
	
	@Test public void testDuplicateImportsAreIgnored() throws Exception {
		final XtextResource resource = getResource(new StringInputStream(
				  "foo { " 
				+ "  entity Foo {}" 
				+ "  entity Bar {}" 
				+ "}"
				+ "bar {"
				+ "  entity Foo {}" 
				+ "}" 
				+ "baz {" 
				+ "  import foo.*" 
				+ "  import foo.*" 
				+ "  entity Baz{}" 
				+ "}"), URI
				.createURI("withoutwildcard.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			@Override
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Entity foo = find(Iterables.filter(allContents, Entity.class), new Predicate<Entity>(){
			@Override
			public boolean apply(Entity input) {
				return input.getName().equals("Baz");
			}});
		
		IScope scope = scopeProvider.getScope(foo, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("Bar")));
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("Foo")));
		ArrayList<IEObjectDescription> list = newArrayList(scope.getAllElements());
		assertEquals(7,list.size());
		assertTrue(any(list, new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription input) {
				return input.getName().equals(QualifiedName.create("Foo"));
			}
		}));
	}
	
	@Test public void testUnambiguousImportAreShadowed_00() throws Exception {
		final XtextResource resource = getResource(new StringInputStream(
				  "foo { " 
				+ "  entity Foo {}" 
				+ "  entity Bar {}" 
				+ "}"
				+ "bar {"
				+ "  entity Foo {}" 
				+ "}" 
				+ "baz {" 
				+ "  import foo.*" 
				+ "  import bar.*" 
				+ "  entity Baz{}" 
				+ "}"), URI
				.createURI("withoutwildcard.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			@Override
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Entity foo = find(Iterables.filter(allContents, Entity.class), new Predicate<Entity>(){
			@Override
			public boolean apply(Entity input) {
				return input.getName().equals("Baz");
			}});
		
		IScope scope = scopeProvider.getScope(foo, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("Bar")));
		assertNull(scope.getSingleElement(nameConverter.toQualifiedName("Foo")));
		ArrayList<IEObjectDescription> list = newArrayList(scope.getAllElements());
		assertEquals(6,list.size());
		assertFalse(any(list, new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription input) {
				return input.getName().equals(QualifiedName.create("Foo"));
			}
		}));
	}
	@Test public void testUnambiguousImportAreShadowed_01() throws Exception {
		final XtextResource resource = getResource(new StringInputStream(
				"foo { " 
				+ "  entity Foo {}" 
				+ "  entity Bar {}" 
				+ "}"
				+ "bar {"
				+ "  entity Foo {}" 
				+ "}" 
				+ "baz {" 
				+ "  import foo.*" 
				+ "  import bar.Foo" 
				+ "  entity Baz{}" 
				+ "}"), URI
				.createURI("withoutwildcard.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			@Override
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Entity foo = find(Iterables.filter(allContents, Entity.class), new Predicate<Entity>(){
			@Override
			public boolean apply(Entity input) {
				return input.getName().equals("Baz");
			}});
		
		IScope scope = scopeProvider.getScope(foo, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("Bar")));
		assertNull(scope.getSingleElement(nameConverter.toQualifiedName("Foo")));
		ArrayList<IEObjectDescription> list = newArrayList(scope.getAllElements());
		assertEquals(6,list.size());
		assertFalse(any(list, new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription input) {
				return input.getName().equals(QualifiedName.create("Foo"));
			}
		}));
	}
	@Test public void testUnambiguousImportAreShadowed_02() throws Exception {
		final XtextResource resource = getResource(new StringInputStream(
				"foo { " 
				+ "  entity Foo {}" 
				+ "  entity Bar {}" 
				+ "}"
				+ "bar {"
				+ "  entity Foo {}" 
				+ "}" 
				+ "baz {" 
				+ "  import foo.Foo" 
				+ "  import bar.Foo" 
				+ "  entity Baz{}" 
				+ "}"), URI
				.createURI("withoutwildcard.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			@Override
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Entity foo = find(Iterables.filter(allContents, Entity.class), new Predicate<Entity>(){
			@Override
			public boolean apply(Entity input) {
				return input.getName().equals("Baz");
			}});
		
		IScope scope = scopeProvider.getScope(foo, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNull(scope.getSingleElement(nameConverter.toQualifiedName("Bar")));
		assertNull(scope.getSingleElement(nameConverter.toQualifiedName("Foo")));
		ArrayList<IEObjectDescription> list = newArrayList(scope.getAllElements());
		assertEquals(5,list.size());
		assertFalse(any(list, new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription input) {
				return input.getName().equals(QualifiedName.create("Foo"));
			}
		}));
	}

	@Test public void testMultipleFiles() throws Exception {
		ResourceSetImpl rs = new ResourceSetImpl();
		final Resource res1 = rs.createResource(URI.createURI("file1.indextestlanguage"));
		Resource res2 = rs.createResource(URI.createURI("file2.indextestlanguage"));
		res1.load(new StringInputStream("foo { " + "  import bar.Bar" + "  entity Foo {" + "  }" + "}"), null);
		res2.load(new StringInputStream("bar {" + "  entity Bar{}" + "}"), null);

		Iterable<EObject> allContents = new Iterable<EObject>() {
			@Override
			public Iterator<EObject> iterator() {
				return res1.getAllContents();
			}
		};
		Iterator<Entity> iterator = Iterables.filter(allContents, Entity.class).iterator();
		Entity foo = iterator.next();
		assertEquals("Foo", foo.getName());

		IScope scope = scopeProvider.getScope(foo, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("Bar")));
	}

	@Test public void testResourceSetReferencingResourceSet() throws Exception {
		ResourceSetReferencingResourceSetImpl rs = new ResourceSetReferencingResourceSetImpl();
		Resource res = rs.createResource(URI.createURI("file2.indextestlanguage"));
		res.load(new StringInputStream(
				  "bar {" 
				+ "  entity Bar{}" 
				+ "}"), null);

		ResourceSetReferencingResourceSetImpl rs1 = new ResourceSetReferencingResourceSetImpl();
		rs1.getReferencedResourceSets().add(rs);
		final Resource res1 = rs1.createResource(URI.createURI("file1.indextestlanguage"));
		res1.load(new StringInputStream(
				  "foo { " 
				+ "  import bar.Bar" 
				+ "  entity Foo {}" 
				+ "}"), null);

		Iterable<EObject> allContents = new Iterable<EObject>() {
			@Override
			public Iterator<EObject> iterator() {
				return res1.getAllContents();
			}
		};
		Iterator<Entity> iterator = Iterables.filter(allContents, Entity.class).iterator();
		Entity foo = iterator.next();
		assertEquals("Foo", foo.getName());

		IScope scope = scopeProvider.getScope(foo, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("Bar")));
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("bar.Bar")));
	}

	@Test public void testResourceSetReferencingResourceSet2() throws Exception {
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

		Entity baz = getEntityByName(res2,"Baz");

		IScope scope = scopeProvider.getScope(baz, IndexTestLanguagePackage.eINSTANCE.getProperty_Type());
		assertNotNull(scope.getSingleElement(nameConverter.toQualifiedName("foo.Foo")));
		assertNull(scope.getSingleElement(nameConverter.toQualifiedName("bar.Bar")));
	}

	protected Entity getEntityByName(final Resource res2, String name) {
		Iterable<EObject> allContents = new Iterable<EObject>() {
			@Override
			public Iterator<EObject> iterator() {
				return res2.getAllContents();
			}
		};
		Iterable<Entity> iterator = Iterables.filter(allContents, Entity.class);
		for (Entity entity : iterator) {
			if (entity.getName().equals(name))
				return entity;
		}
		return null;
	}
	
	protected List<QualifiedName> toListOfNames(Iterable<IEObjectDescription> elements) {
		List<QualifiedName> result = Lists.newArrayList();
		for (IEObjectDescription e : elements) {
			if (!result.contains(e.getName()))
				result.add(e.getName());
		}
		Collections.sort(result);
		return result;
	}

}
