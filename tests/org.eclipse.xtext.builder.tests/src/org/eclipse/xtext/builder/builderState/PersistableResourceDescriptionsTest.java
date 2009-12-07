/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.builder.BuilderModule;
import org.eclipse.xtext.builder.tests.BuilderTestLanguageStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PersistableResourceDescriptionsTest extends AbstractXtextTests {
	private static final String FILE_EXT = ".buildertestlanguage";
	private Injector builderInjector;

	private Map<String, String> fileSystem = Maps.newHashMap();
	private ExtensibleURIConverterImpl uriConverter;
	private PersistableResourceDescriptionsImpl builderState;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new BuilderTestLanguageStandaloneSetup());
		BuilderModule module = new BuilderModule();
		builderInjector = Guice.createInjector(module);
		builderState = builderInjector.getInstance(PersistableResourceDescriptionsImpl.class);
		uriConverter = new ExtensibleURIConverterImpl() {
			@Override
			public InputStream createInputStream(org.eclipse.emf.common.util.URI uri, Map<?, ?> options)
					throws IOException {
				return new StringInputStream(fileSystem.get(uri.toString()));
			}
		};
		builderState.setResourceSetProvider(new Provider<ResourceSet>() {

			public ResourceSet get() {
				ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
				resourceSetImpl.setURIConverter(uriConverter);
				return resourceSetImpl;
			}
		});
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		builderInjector = null;
		fileSystem = Maps.newHashMap();
		uriConverter = null;
		builderState = null;
	}

	public void testSimpleAdd() throws Exception {
		addToFileSystem("foo", "namespace foo { object A }");
		Map<URI, Delta> reload = update(uris("foo"), null);
		assertNull(reload.get(uri("foo")).getOld());
		assertNotNull(reload.get(uri("foo")).getNew());
	}

	public void testMultipleAdd() throws Exception {
		addToFileSystem("bar", "namespace bar { object B }");
		addToFileSystem("foo", "namespace foo { object A references bar.B}");
		Map<URI, Delta> reload = update(uris("foo", "bar"), null); // update
		assertNull(reload.get(uri("bar")).getOld());
		assertNull(reload.get(uri("foo")).getOld());
		assertNotNull(reload.get(uri("bar")).getNew());
		assertNotNull(reload.get(uri("foo")).getNew());
	}

	public void testUpdate() throws Exception {
		addToFileSystem("bar", "namespace bar { object B }");
		addToFileSystem("foo", "namespace foo { object A references bar.B}");
		Map<URI, Delta> reload = update(uris("foo", "bar"), null); // add
		assertNull(reload.get(uri("bar")).getOld());
		assertNull(reload.get(uri("foo")).getOld());
		assertNotNull(reload.get(uri("bar")).getNew());
		assertNotNull(reload.get(uri("foo")).getNew());

		addToFileSystem("bar", "namespace bar { object C }");
		reload = update(uris("bar"), null); // update
		assertNotNull(reload.get(uri("bar")).getOld());
		assertNotNull(reload.get(uri("bar")).getNew());
		assertNotNull(reload.get(uri("foo")).getOld());
		assertNotNull(reload.get(uri("foo")).getNew());
	}

	public void testUpdate_1() throws Exception {
		addToFileSystem("foo", "namespace foo { object A }");
		addToFileSystem("bar", "namespace bar { object B references foo.A}");
		addToFileSystem("baz", "namespace baz { object C references bar.B}");
		Map<URI, Delta> reload = update(uris("foo", "bar", "baz"), null); // add
		assertNull(reload.get(uri("foo")).getOld());
		assertNull(reload.get(uri("bar")).getOld());
		assertNull(reload.get(uri("baz")).getOld());
		assertNotNull(reload.get(uri("foo")).getNew());
		assertNotNull(reload.get(uri("bar")).getNew());
		assertNotNull(reload.get(uri("baz")).getNew());

		addToFileSystem("foo", "namespace foo { object X }");
		reload = update(uris("foo"), null); // update
		assertNotNull(reload.get(uri("foo")).getOld());
		assertNotNull(reload.get(uri("foo")).getNew());
		assertNotNull(reload.get(uri("bar")).getOld());
		assertNotNull(reload.get(uri("bar")).getNew());
		assertNull(reload.get(uri("baz")));
	}

	public void testUpdate_2() throws Exception {
		addToFileSystem("foo", "namespace foo { object A }");
		addToFileSystem("bar", "namespace bar { object B references foo.A}");
		addToFileSystem("baz", "namespace baz { object C references bar.B}");
		Map<URI, Delta> reload = update(uris("foo", "bar", "baz"), null); // add
		assertNull(reload.get(uri("foo")).getOld());
		assertNull(reload.get(uri("bar")).getOld());
		assertNull(reload.get(uri("baz")).getOld());
		assertNotNull(reload.get(uri("foo")).getNew());
		assertNotNull(reload.get(uri("bar")).getNew());
		assertNotNull(reload.get(uri("baz")).getNew());

		addToFileSystem("foo", "namespace foo { object X }");
		addToFileSystem("bar", "namespace bar { object B references foo.X}");
		reload = update(uris("foo"), null); // update
		assertNotNull(reload.get(uri("foo")).getOld());
		assertNotNull(reload.get(uri("foo")).getNew());
		assertNotNull(reload.get(uri("bar")).getOld());
		assertNotNull(reload.get(uri("bar")).getNew());
		assertNull(reload.get(uri("baz")));
	}

	public void testDelete() throws Exception {
		addToFileSystem("bar", "namespace bar { object B }");
		addToFileSystem("foo", "namespace foo { object A references bar.B}");
		Map<URI, Delta> reload = update(uris("foo", "bar"), null); // add
		assertNull(reload.get(uri("bar")).getOld());
		assertNull(reload.get(uri("foo")).getOld());
		assertNotNull(reload.get(uri("bar")).getNew());
		assertNotNull(reload.get(uri("foo")).getNew());

		reload = update(null, uris("bar")); // delete
		assertNotNull(reload.get(uri("bar")).getOld());
		assertNull(reload.get(uri("bar")).getNew());
		assertNotNull(reload.get(uri("foo")).getOld());
		assertNotNull(reload.get(uri("foo")).getNew());
	}

	public void testDelete_1() throws Exception {
		addToFileSystem("bar", "namespace bar { object B }");
		addToFileSystem("foo", "namespace foo { object A references bar.B}");
		Map<URI, Delta> reload = update(uris("foo", "bar"), null); // add
		assertNull(reload.get(uri("bar")).getOld());
		assertNull(reload.get(uri("foo")).getOld());
		assertNotNull(reload.get(uri("bar")).getNew());
		assertNotNull(reload.get(uri("foo")).getNew());

		reload = update(null, uris("foo")); // delete
		assertNull(reload.get(uri("bar")));
		assertNotNull(reload.get(uri("foo")).getOld());
		assertNull(reload.get(uri("foo")).getNew());
	}

	public void testUpdateNoChange() throws Exception {
		addToFileSystem("bar", "namespace bar { object B }");
		addToFileSystem("foo", "namespace foo { object A references bar.B}");
		Map<URI, Delta> reload = update(uris("foo", "bar"), null); // add
		assertNull(reload.get(uri("bar")).getOld());
		assertNull(reload.get(uri("foo")).getOld());
		assertNotNull(reload.get(uri("bar")).getNew());
		assertNotNull(reload.get(uri("foo")).getNew());

		reload = update(uris("bar"), null); // delete
		assertEquals(1, reload.size());
		assertNotNull(reload.get(uri("bar")).getOld());
		assertNotNull(reload.get(uri("bar")).getNew());
	}

	private void addToFileSystem(String uri, String contents) {
		fileSystem.put(uri + FILE_EXT, contents);
	}

	private URI uri(String name) {
		return URI.createURI(name + FILE_EXT);
	}

	private Set<URI> uris(String... urisAsStrings) {
		Set<URI> result = Sets.newHashSet();
		for (String string : urisAsStrings) {
			result.add(uri(string));
		}
		return result;
	}

	private Map<URI, IResourceDescription.Delta> update(Set<URI> toBeUpdated, Set<URI> toBeDeleted) {
		ImmutableList<Delta> update = builderState.update(toBeUpdated, toBeDeleted, new NullProgressMonitor());
		return Maps.uniqueIndex(update, new Function<IResourceDescription.Delta, URI>() {
			public URI apply(IResourceDescription.Delta from) {
				return from.getOld() != null ? from.getOld().getURI() : from.getNew().getURI();
			}
		});
	}

}
