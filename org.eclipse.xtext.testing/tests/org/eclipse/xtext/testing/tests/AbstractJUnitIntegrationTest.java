/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.IRegistryConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Base class for testing JUnit specific integration. For JUnit 4 this is the Test Runner {@link XtextRunner},
 * while JUnit 5 uses extensions, here the {@link InjectionExtension}.
 * <p>
 * Copied from initial XtextRunnerTest.
 * 
 * @author Sebastian Benz - Initial contribution and API
 * @author Karsten Thoms - Initial contribution and API
 */
public class AbstractJUnitIntegrationTest {
	private static boolean injectorCreated = false;
	private static boolean registrySaved = false;
	private static boolean registryRestored = false;
	
	@Inject
	private Boolean fieldsInjected = false;

	public static class MyInjectorProvider implements IRegistryConfigurator, IInjectorProvider {
		@Override
		public Injector getInjector() {
			injectorCreated = true;
			assertTrue(registrySaved);
			
			return Guice.createInjector(new Module(){
				@Override
				public void configure(Binder binder) {
					binder.bind(Boolean.class).toInstance(Boolean.TRUE);
				}
			});
		}

		@Override
		public void setupRegistry() {
			registrySaved = true;
			assertFalse(injectorCreated);
		}

		@Override
		public void restoreRegistry() {
			assertTrue(registrySaved);
			registryRestored = true;
		}
	}
	
	@Before
	public void beforeShouldBeExecutedAfterTheRegistriesAreInitialized(){
		assertTrue(registrySaved);
		assertTrue(injectorCreated);
		assertTrue(fieldsInjected);
	}
	
	@Test
	public void shouldSaveRegistriesBeforeCreatingAnInjector() {
		// tests are performed in MyInjectorProvider
	}
	
	@After
	public void afterShouldBeExecutedBeforeTheRegistriesAreRestored(){
		assertFalse(registryRestored);
	}
}
