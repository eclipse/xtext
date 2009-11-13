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

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.emfindex.MemoryIndexImpl;
import org.eclipse.emf.emfindex.query.EObjectQueryExecutorStrategyImpl;
import org.eclipse.emf.emfindex.query.EReferenceQueryExecutorStrategyImpl;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.query.QueryExecutorImpl;
import org.eclipse.emf.emfindex.query.ResourceQueryExecutorStrategyImpl;
import org.eclipse.emf.emfindex.store.IndexUpdater;
import org.eclipse.emf.emfindex.store.IndexUpdaterImpl;
import org.eclipse.emf.emfindex.store.UpdateCommand;
import org.eclipse.emf.emfindex.store.UpdateableIndex;
import org.eclipse.xtext.index.IndexTestLanguageStandaloneSetup;
import org.eclipse.xtext.index.XtextIndexImpl;
import org.eclipse.xtext.index.indexTestLanguage.Datatype;
import org.eclipse.xtext.index.indexTestLanguage.Entity;
import org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.IQualifiedNameProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.namespaces.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.scoping.namespaces.IndexGlobalScopeProvider;
import org.eclipse.xtext.scoping.namespaces.QualifiedNameScopeProvider;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class IndexBasedQualifiedNameScopeProviderTest extends AbstractXtextTests {

	private QualifiedNameScopeProvider scopeProvider;
	private IQualifiedNameProvider nameProvider = new DefaultDeclarativeQualifiedNameProvider();
	private IndexGlobalScopeProvider globalScope;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new IndexTestLanguageStandaloneSetup());

		globalScope = new IndexGlobalScopeProvider();
		globalScope.setIndexStore(new XtextIndexImpl(createIndex()));
		scopeProvider = new QualifiedNameScopeProvider();
		scopeProvider.setGlobalScopeProvider(globalScope);
		scopeProvider.setNameProvider(nameProvider);
	}
	
	private MemoryIndexImpl createIndex() {
		MemoryIndexImpl index = new MemoryIndexImpl();
		index.setIndexUpdater(new IndexUpdaterImpl(index));
		QueryExecutorImpl queryExecutor = new QueryExecutorImpl(index);
		index.setQueryExecutor(queryExecutor);
		queryExecutor.addQueryExecutorStrategy(new EObjectQueryExecutorStrategyImpl(), 0);
		queryExecutor.addQueryExecutorStrategy(new EReferenceQueryExecutorStrategyImpl(), 0);
		queryExecutor.addQueryExecutorStrategy(new ResourceQueryExecutorStrategyImpl(), 0);
		return index;
	}

	private EReference reference(EClass element) {
		EReference eReference = EcoreFactory.eINSTANCE.createEReference();
		eReference.setEType(element);
		return eReference;
	}
	
	public void testLocalElementsNotFromIndex() throws Exception {
		// no index
		globalScope.setIndexStore(null);
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
		IScope scope = scopeProvider.getScope(datatype, reference(IndexTestLanguagePackage.eINSTANCE.getEntity()));
		assertNotNull(scope.getContentByName("A.B.D"));
	}
	
	public void testMultipleFiles() throws Exception {
		UpdateableIndex idx = globalScope.getIndexStore();
		idx.executeUpdateCommand(new UpdateCommand<Void>() {

			public Void execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor) {
				indexUpdater.createOrUpdateResource(null, URI.createURI("file2.indextestlanguage"), 0, null);
				indexUpdater.createOrUpdateEObject(URI.createURI("file2.indextestlanguage"), "bar.Bar", "bar.Bar", IndexTestLanguagePackage.eINSTANCE.getEntity(), null);
				return null;
			}
		});
		
		ResourceSetImpl rs = new ResourceSetImpl();
		final Resource res1 = rs.createResource(URI.createURI("file1.indextestlanguage"));
		res1.load(new StringInputStream(
				"foo { " +
				"  import bar.Bar" +
				"  entity Foo {" +
				"  }" +
				"}"
		), null);
		
		Iterable<EObject> allContents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return res1.getAllContents();
			}
		};
		Iterator<Entity> iterator = Iterables.filter(allContents, Entity.class).iterator();
		Entity foo = iterator.next();
		assertEquals("Foo", foo.getName());
		
		IScope scope = scopeProvider.getScope(foo, reference(IndexTestLanguagePackage.eINSTANCE.getEntity()));
		assertNotNull(scope.getContentByName("Bar"));
	}
	
	
	
}
