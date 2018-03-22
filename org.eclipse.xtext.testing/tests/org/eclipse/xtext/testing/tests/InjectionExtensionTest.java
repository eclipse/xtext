/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testing.tests;

import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.IRegistryConfigurator;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Test for {@link InjectionExtension}.
 * Copied from {@link XtextRunnerTest}.
 * 
 * @author Karsten Thoms - Initial contribution and API
 */
@InjectWith(InjectionExtensionTest.MyInjectorProvider.class)
@ExtendWith(InjectionExtension.class)
public class InjectionExtensionTest {

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
