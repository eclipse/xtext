/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossrefs.indexbased;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.impl.memory.InMemoryIndex;
import org.eclipse.xtext.crossref.indexImpl.AbstractDeclarativeNameProvider;
import org.eclipse.xtext.crossref.indexImpl.INameProvider;
import org.eclipse.xtext.crossref.indexImpl.IndexAwareResourceSet;
import org.eclipse.xtext.crossrefs.ImportUriTestLanguageRuntimeModule;
import org.eclipse.xtext.crossrefs.ImportUriTestLanguageStandaloneSetup;
import org.eclipse.xtext.crossrefs.importedURI.Type;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * TODO this test fails with NoClassDefFound for a guice class, when
 *      executed as plugin test
 */
public class IndexAwareResourcesetTest extends AbstractGeneratorTest {

	public void testStuff() throws Exception {
		IndexAwareResourceSet set = get(IndexAwareResourceSet.class);
		URI uri = URI.createURI("classpath:/" + getClass().getName().replace('.', '/')
				+ ".importuritestlanguage");
		System.out.println(uri);
		set.getResource(uri, true);
		Iterator<EObjectDescriptor> result = set.getStore().eObjectDAO().createQuery().executeListResult()
				.iterator();
		List<String> names = new ArrayList<String>();
		names.add(result.next().getName());
		names.add(result.next().getName());
		assertFalse(result.hasNext());
		
		assertTrue(names.contains("A"));
		assertTrue(names.contains("B"));
		
		Iterator<ECrossReferenceDescriptor> iter = set.getStore().eCrossReferenceDAO().createQuery().executeListResult().iterator();
		ECrossReferenceDescriptor next = iter.next();
		assertEquals("B",next.getSource().getName());
		assertEquals("A",next.getTarget().getName());
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
										return IndexAwareResourcesetTest.this.getNameProvider();
									}

								});
					}

					@SuppressWarnings("unused")
					public Class<? extends IIndexStore> bindIIndexStore() {
						return InMemoryIndex.class;
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
