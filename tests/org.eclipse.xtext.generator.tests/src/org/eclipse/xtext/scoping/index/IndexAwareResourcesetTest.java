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
import org.eclipse.emf.index.EObjectDescriptor.DAO;
import org.eclipse.emf.index.EObjectDescriptor.Query;
import org.eclipse.emf.index.impl.memory.EmfIndexDefaultModule;
import org.eclipse.xtext.linking.ImportUriTestLanguageRuntimeModule;
import org.eclipse.xtext.linking.ImportUriTestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.importedURI.Type;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API 
 */
public class IndexAwareResourcesetTest extends AbstractGeneratorTest {

	public void testStuff() throws Exception {
		IndexAwareResourceSet set = get(IndexAwareResourceSet.class);
		set.setClasspathURIContext(IndexAwareResourcesetTest.class);
		URI uri = URI.createURI("classpath:/" + getClass().getName().replace('.', '/') + ".importuritestlanguage");
		set.getResource(uri, true);
		DAO eObjectDao = set.getStore().eObjectDAO();
		Query createQuery = eObjectDao.createQuery();
		Iterable<EObjectDescriptor> query = createQuery.executeListResult();
		Iterator<EObjectDescriptor> result = query.iterator();
		List<String> names = new ArrayList<String>();
		names.add(result.next().getName());
		names.add(result.next().getName());
		assertFalse(result.hasNext());

		assertTrue(names.contains("A"));
		assertTrue(names.contains("B"));

		result = query.iterator();
		List<URI> uris = new ArrayList<URI>();
		uris.add(result.next().getFragmentURI());
		uris.add(result.next().getFragmentURI());
		
		// FIXME
//		Iterator<ECrossReferenceDescriptor> iter = set.getStore().eCrossReferenceDAO().createQuery()
//				.executeListResult().iterator();
//		ECrossReferenceDescriptor next = iter.next();
//		assertTrue(uris.contains(next.getSourceURI()));
//		assertTrue(uris.contains(next.getTargetURI()));
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
						binder.bind(INameProvider.class).toProvider(new Provider<? extends INameProvider>() {

							public INameProvider get() {
								return IndexAwareResourcesetTest.this.getNameProvider();
							}

						});
						new EmfIndexDefaultModule().configure(binder);
					}
				});
			}
		});
	}

	protected INameProvider getNameProvider() {
		return this.nameProvider;
	}
}
