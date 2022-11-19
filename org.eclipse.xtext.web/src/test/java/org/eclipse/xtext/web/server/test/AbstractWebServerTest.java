/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.util.DisposableRegistry;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule;
import org.eclipse.xtext.web.example.statemachine.StatemachineStandaloneSetup;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineIdeModule;
import org.eclipse.xtext.web.example.statemachine.tests.StatemachineInjectorProvider;
import org.eclipse.xtext.web.server.ISession;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.test.languages.StatemachineWebModule;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public abstract class AbstractWebServerTest {
	public static class TestLineSeparatorInformation implements ILineSeparatorInformation {
		@Override
		public String getLineSeparator() {
			return "\n";
		}
	}

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

	private final StatemachineInjectorProvider injectorProvider = new StatemachineInjectorProvider() {
		@Override
		protected Injector internalCreateInjector() {
			return new StatemachineStandaloneSetup() {
				@Override
				public Injector createInjector() {
					StatemachineWebModule webModule = getWebModule();
					webModule.setResourceBaseProvider(resourceBaseProvider);
					return Guice.createInjector(Modules2.mixin(getRuntimeModule(),
							getIdeModule(), webModule));
				}
			}.createInjectorAndDoEMFRegistration();
		}
	};

	private AbstractWebServerTest.TestResourceBaseProvider resourceBaseProvider;

	@Inject
	private DisposableRegistry disposableRegistry;

	@Inject
	private XtextServiceDispatcher dispatcher;

	protected com.google.inject.Module getIdeModule() {
		return new StatemachineIdeModule();
	}

	protected StatemachineWebModule getWebModule() {
		return new StatemachineWebModule();
	}

	protected com.google.inject.Module getRuntimeModule() {

		return new StatemachineRuntimeModule() {
			@SuppressWarnings("unused")
			public Class<? extends ILineSeparatorInformation> bindILineSeparatorInformation() {
				return AbstractWebServerTest.TestLineSeparatorInformation.class;
			}
		};
	}

	@Before
	public void setup() {
		resourceBaseProvider = new AbstractWebServerTest.TestResourceBaseProvider();
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
			File file = Files.createTempFile("test", ".statemachine").toFile();
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
