/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index;

import static com.google.common.collect.Iterables.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.index.ecore.impl.EcoreIndexFeederImpl;
import org.eclipse.emf.index.impl.PersistableIndexStore;
import org.eclipse.emf.index.resource.impl.IndexFeederImpl;
import org.eclipse.xtext.index.indexTestLanguage.Datatype;
import org.eclipse.xtext.index.indexTestLanguage.Entity;
import org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopedElement;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class IndexBasedScopeProviderTest extends AbstractGeneratorTest {

	private PersistableIndexStore store;
	private DefaultDeclarativeResourceIndexer indexer;
	private DefaultIndexBasedScopeProvider scopeProvider;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new IndexTestLanguageStandaloneSetup());
		store = new PersistableIndexStore();
		new EcoreIndexFeederImpl(store).feedEPackagesFromRegistry();

		indexer = new DefaultDeclarativeResourceIndexer();
		DefaultDeclarativeQualifiedNameProvider nameProvider = new DefaultDeclarativeQualifiedNameProvider();
		indexer.setNameProvider(nameProvider);

		scopeProvider = new DefaultIndexBasedScopeProvider();
		scopeProvider.setIndexStore(store);
		scopeProvider.setNameProvider(nameProvider);
	}

	public void indexExample() throws Exception {
		final String source = "foo.bar { " +
			"  entity Person {  " +
			"    String name " +
			"  } " +
			"  datatype String " +
			"}";
		XtextResource resource = getResource(new StringInputStream(source), URI.createURI("my.indextestlanguage"));

		IndexFeederImpl feeder = new IndexFeederImpl(store);
		indexer.resourceChanged(resource, feeder);
		feeder.commit();
	}

	public void testGlobalScope() throws Exception {
		indexExample();
		IScope scope = scopeProvider.getScope(null, IndexTestLanguagePackage.eINSTANCE.getElement());
		assertEquals(IScope.NULLSCOPE, scope.getOuterScope());
		List<String> names = toListOfNames(scope.getAllContents());
		assertEquals(3, names.size());
		assertTrue(names.contains("foo.bar"));
		assertTrue(names.contains("foo.bar.Person"));
		assertTrue(names.contains("foo.bar.String"));
	}
	
	public void testImports() throws Exception {
		indexExample();
		XtextResource resource = getResource(new StringInputStream(
				"import foo.bar.* "), URI.createURI("import.indextestlanguage"));
		
		IScope scope = scopeProvider.getScope(resource.getContents().get(0), IndexTestLanguagePackage.eINSTANCE.getElement());
		List<String> names = toListOfNames(scope.getAllContents());
		assertEquals(names.toString(), 5, names.size());
		assertTrue(names.contains("Person"));
		assertTrue(names.contains("String"));
		assertTrue(names.contains("foo.bar"));
		assertTrue(names.contains("foo.bar.Person"));
		assertTrue(names.contains("foo.bar.String"));
	}
	
	public void testRelativeContext() throws Exception {
		final XtextResource resource = getResource(new StringInputStream(
		"stuff { " +
		"  baz { " +
		"    datatype String " +
		"  } " +
		"  entity Person {}" +
		"}"), URI.createURI("relative.indextestlanguage"));
		IndexFeederImpl feeder = new IndexFeederImpl(store);
		indexer.resourceChanged(resource, feeder);
		feeder.commit();
		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}};
		Entity entity = filter(allContents, Entity.class).iterator().next();
		
		IScope scope = scopeProvider.getScope(entity, IndexTestLanguagePackage.eINSTANCE.getDatatype());
		List<String> names = toListOfNames(scope.getAllContents());
		assertEquals(names.toString(), 2, names.size());
		assertTrue(names.contains("baz.String"));
		assertTrue(names.contains("stuff.baz.String"));
	}
	
	public void testRelativePath() throws Exception {
		final XtextResource resource = getResource(new StringInputStream(
				"stuff { " +
				"  import baz.*" +
				"  baz { " +
				"    datatype String " +
				"  } " +
				"  entity Person {" +
				"  }" +
		"}"), URI.createURI("relative.indextestlanguage"));
		IndexFeederImpl feeder = new IndexFeederImpl(store);
		indexer.resourceChanged(resource, feeder);
		feeder.commit();
		Iterable<EObject> allContents = new Iterable<EObject>() {
		public Iterator<EObject> iterator() {
			return resource.getAllContents();
		}};
		Entity entity = filter(allContents, Entity.class).iterator().next();
		
		IScope scope = scopeProvider.getScope(entity, IndexTestLanguagePackage.eINSTANCE.getDatatype());
		List<String> names = toListOfNames(scope.getAllContents());
		assertEquals(names.toString(), 3, names.size());
		assertTrue(names.contains("String"));
		assertTrue(names.contains("baz.String"));
		assertTrue(names.contains("stuff.baz.String"));
	}
	
	public void testReexports() throws Exception {
		final XtextResource resource = getResource(new StringInputStream(
				"stuff { " +
				"  import baz.*" +
				"  baz { " +
				"    stuff {" +
				"      import stuff.*" +
				"      datatype String " +
				"    }" +
				"    entity Person {}" +
				"  }" +
		"}"), URI.createURI("relative.indextestlanguage"));
		IndexFeederImpl feeder = new IndexFeederImpl(store);
		indexer.resourceChanged(resource, feeder);
		feeder.commit();
		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Datatype datatype = filter(allContents, Datatype.class).iterator().next();
		
		// datatype String
		IScope scope = scopeProvider.getScope(datatype, IndexTestLanguagePackage.eINSTANCE.getEntity());
		List<String> names = toListOfNames(scope.getContents());
		assertEquals(names.toString(), 0, names.size());
		
		scope = scope.getOuterScope(); // stuff {
		names = toListOfNames(scope.getContents());
		assertEquals(names.toString(), 0, names.size());

		scope = scope.getOuterScope(); // import stuff.*
		names = toListOfNames(scope.getContents());
		assertEquals(names.toString(), 1, names.size());
		assertTrue(names.toString(),names.contains("baz.Person"));
		
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
		final XtextResource resource = getResource(new StringInputStream(
				"A { " +
				"  B { " +
				"    entity D {}" +
				"  }" +
				"}" +
				"E {" +
				"  import A.B.*" +
				"  entity D {}" +
				"  datatype Context" +
				"}"), URI.createURI("testReexports2.indextestlanguage"));
		IndexFeederImpl feeder = new IndexFeederImpl(store);
		indexer.resourceChanged(resource, feeder);
		feeder.commit();
		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Datatype datatype = filter(allContents, Datatype.class).iterator().next();
		
		IScope scope = scopeProvider.getScope(datatype, IndexTestLanguagePackage.eINSTANCE.getEntity());
		List<String> names = toListOfNames(scope.getAllContents());
		assertEquals(toString(scope, ""), 3, names.size());
		assertTrue(names.toString(),names.contains("D"));
		assertTrue(names.toString(),names.contains("E.D"));
		assertTrue(names.toString(),names.contains("A.B.D"));
	}
	
	public void testLocalElementsNotFromIndex() throws Exception {
		final XtextResource resource = getResource(new StringInputStream(
				"A { " +
				"  B { " +
				"    entity D {}" +
				"  }" +
				"}" +
				"E {" +
				"  datatype Context" +
				"}"), URI.createURI("foo23.indextestlanguage"));
		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Datatype datatype = filter(allContents, Datatype.class).iterator().next();
		IScope scope = scopeProvider.getScope(datatype, IndexTestLanguagePackage.eINSTANCE.getEntity());
		for (IScopedElement ele : scope.getAllContents()) {
			if (ele.name().equals("A.B.D"))
				return;
		}
		fail("No entity 'A.B.D' found");
	}
	
	public void testLocalElementsNotFromIndex2() throws Exception {
		final XtextResource resource = getResource(new StringInputStream(
				"A { " +
				"  B { " +
				"    entity D {}" +
				"  }" +
				"}" +
				"E {" +
				"  datatype Context" +
				"}"), URI.createURI("foo23.indextestlanguage"));
		IndexFeederImpl feeder = new IndexFeederImpl(store);
		indexer.resourceChanged(resource, feeder);
		feeder.commit();
		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		};
		Datatype datatype = filter(allContents, Datatype.class).iterator().next();
		IScope scope = scopeProvider.getScope(datatype, IndexTestLanguagePackage.eINSTANCE.getEntity());
		do {
			for (IScopedElement ele : scope.getContents()) {
				if (ele.name().equals("A.B.D")) {
					assertFalse(ele instanceof IndexBasedScopedElement);
				}
			}
			scope = scope.getOuterScope();
		} while (scope!=IScope.NULLSCOPE);
	}
	
	
	
	private static IQualifiedNameProvider nameProvider = new DefaultDeclarativeQualifiedNameProvider();
	
	private String toString(IScope scope, String indent) {
		if (scope==IScope.NULLSCOPE)
			return indent+"{NULLSCOPE}";
		String result = indent+"{\n";
		for (IScopedElement e : scope.getContents()) {
			result+= indent+e.name()+" ("+(((InternalEObject)e.element()).eIsProxy()?((InternalEObject)e.element()).eProxyURI(): nameProvider.getQualifiedName(e.element()))+")\n";
		}
		result+=toString(scope.getOuterScope(),indent+" ")+"\n";
		return result+indent+"}\n";
	}

	public void testLazyGlobalIndexAccess() throws Exception {
		scopeProvider.setIndexStore(null);
		IScope scope = scopeProvider.getScope(EcoreFactory.eINSTANCE.createEObject(), EcorePackage.Literals.EOBJECT);
		assertNotNull(scope);
		try {
			scope.getAllContents();
			fail("NullPointerException expected");
		}
		catch (NullPointerException e) {
		}
	}

	private List<String> toListOfNames(Iterable<IScopedElement> elements) {
		List<String> result = new ArrayList<String>();
		for (IScopedElement e : elements) {
			if (!result.contains(e.name()))
				result.add(e.name());
		}
		Collections.sort(result);
		return result;
	}

}
