/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.index;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.EObjectDescriptor.Query;
import org.eclipse.emf.index.impl.memory.InMemoryIndex;
import org.eclipse.xtext.linking.ImportUriTestLanguageRuntimeModule;
import org.eclipse.xtext.linking.ImportUriTestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.importedURI.Type;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.index.AbstractDeclarativeNameProvider;
import org.eclipse.xtext.scoping.index.INameProvider;
import org.eclipse.xtext.scoping.index.IndexAwareResourceSet;
import org.eclipse.xtext.scoping.index.IndexBasedScopeProvider;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class IndexBasedScopeProviderTest extends AbstractGeneratorTest {

	public void testStuff() throws Exception {
		
		IndexAwareResourceSet set = get(IndexAwareResourceSet.class);
		set.setClasspathURIContext(getClass());
		URI uri = URI.createURI("classpath:/" + IndexAwareResourcesetTest.class.getName().replace('.', '/')
				+ ".importuritestlanguage");
		System.out.println(uri);
		set.getResource(uri, true);
		set.getResource(URI.createURI("classpath:/" + getClass().getName().replace('.', '/')
				+ ".importuritestlanguage"), true);
		
		IIndexStore store = set.getStore();
		Query createQuery = store.eObjectDAO().createQuery();
		Iterator<EObjectDescriptor> result = createQuery.executeListResult().iterator();
		List<String> names = new ArrayList<String>();
		while (result.hasNext()) {
			EObjectDescriptor next = result.next();
			if (next.getName().equals("D")) {
				Type obj = (Type) set.getEObject(next.getFragmentURI(), true);
				assertEquals("A", obj.getExtends().getName());
			}
			names.add(next.getName());
		}
		assertTrue(names.contains("A"));
		assertTrue(names.contains("B"));
		assertTrue(names.contains("C"));
		assertTrue(names.contains("D"));
		assertEquals(4,names.size());
		
		// TODO
//		Iterator<ECrossReferenceDescriptor> crossRefs = set.getStore().eCrossReferenceDAO().createQuery().executeListResult().iterator();
//		crossRefs.next();
//		crossRefs.next();
//		crossRefs.next();
//		assertFalse(crossRefs.hasNext());
	}

	private final INameProvider nameProvider = new AbstractDeclarativeNameProvider() {
		@SuppressWarnings("unused")
		public String getName(Type type) {
			return type.getName();
		}
	};

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new ImportUriTestLanguageStandaloneSetup() {

			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ImportUriTestLanguageRuntimeModule() {

					@Override
					public void configure(Binder binder) {
						super.configure(binder);
						binder.bind(INameProvider.class).toProvider(
								new Provider<? extends INameProvider>() {

									public INameProvider get() {
										return IndexBasedScopeProviderTest.this.getNameProvider();
									}

								});
						binder.bind(IIndexStore.class).toInstance(new InMemoryIndex());
					}

					@Override
					public Class<? extends IScopeProvider> bindIScopeProvider() {
						return IndexBasedScopeProvider.class;
					}
				});
			}
		});
	}

	/**
	 * @return
	 */
	protected INameProvider getNameProvider() {
		return this.nameProvider;
	}
}
