/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.web.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.DisposableRegistry;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.web.example.entities.EntitiesRuntimeModule;
import org.eclipse.xtext.web.example.entities.EntitiesStandaloneSetup;
import org.eclipse.xtext.web.example.entities.ide.EntitiesIdeModule;
import org.eclipse.xtext.web.example.entities.tests.EntitiesInjectorProvider;
import org.eclipse.xtext.web.server.ISession;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.web.test.languages.EntitiesWebModule;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public abstract class AbstractXbaseWebTest {
	public static class TestResourceBaseProvider implements IResourceBaseProvider {
		private final Map<String, URI> testFiles = new HashMap<String, URI>();

		@Override
		public URI getFileURI(String resourceId) {
			return testFiles.get(resourceId);
		}
	}

	protected String normalizeLineSeparator(String value) {
		return value.replace("\r\n", "\n");
	}

	public void assertEquals(CharSequence expected, CharSequence actual) {
		Assert.assertEquals(normalizeLineSeparator(expected.toString()),
				normalizeLineSeparator(actual.toString().toString()));
	}

	private final EntitiesInjectorProvider injectorProvider = new EntitiesInjectorProvider() {
		@Override
		protected Injector internalCreateInjector() {
			return new EntitiesStandaloneSetup() {
				@Override
				public Injector createInjector() {
					EntitiesWebModule webModule = new EntitiesWebModule();
					EntitiesIdeModule ideModule = new EntitiesIdeModule();
					webModule.setResourceBaseProvider(resourceBaseProvider);
					return Guice.createInjector(
							Modules2.mixin(getRuntimeModule(), ideModule, webModule));
				}
			}.createInjectorAndDoEMFRegistration();
		}
	};

	private AbstractXbaseWebTest.TestResourceBaseProvider resourceBaseProvider;

	@Inject
	private DisposableRegistry disposableRegistry;

	@Inject
	private XtextServiceDispatcher dispatcher;

	protected com.google.inject.Module getRuntimeModule() {
		return new EntitiesRuntimeModule();
	}

	@Before
	public void setup() {
		AbstractXbaseWebTest.TestResourceBaseProvider _testResourceBaseProvider = new AbstractXbaseWebTest.TestResourceBaseProvider();
		resourceBaseProvider = _testResourceBaseProvider;
		Injector injector = injectorProvider.getInjector();
		injector.injectMembers(this);
		injectorProvider.setupRegistry();
	}

	@After
	public void teardown() {
		disposableRegistry.dispose();
		resourceBaseProvider.testFiles.clear();
		injectorProvider.restoreRegistry();
	}

	protected File createFile(String content) {
		try {
			File file = Files.createTempFile("test", ".entities").toFile();
			resourceBaseProvider.testFiles.put(file.getName(), URI.createFileURI(file.getAbsolutePath()));
			FileWriter writer = new FileWriter(file);
			writer.write(content);
			writer.close();
			file.deleteOnExit();
			return file;
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected XtextServiceDispatcher.ServiceDescriptor getService(Map<String, String> parameters) {
		return getService(parameters, new HashMapSession());
	}

	protected XtextServiceDispatcher.ServiceDescriptor getService(Map<String, String> parameters, ISession session) {
		MockServiceContext serviceContext = new MockServiceContext(parameters, session);
		return dispatcher.getService(serviceContext);
	}
}
