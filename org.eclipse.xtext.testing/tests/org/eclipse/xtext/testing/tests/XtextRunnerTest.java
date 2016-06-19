/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testing.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.IRegistryConfigurator;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author Sebastian Benz - Initial contribution and API
 */
@InjectWith(XtextRunnerTest.MyInjectorProvider.class)
@RunWith(XtextRunner.class)
public class XtextRunnerTest {

	private static boolean injectorCreated = false;
	private static boolean registrySaved = false;
	private static boolean registryRestored = false;
	
	@Inject
	private Boolean fieldsInjected = false;

	public static class MyInjectorProvider implements IRegistryConfigurator, IInjectorProvider {

		
		public Injector getInjector() {
			injectorCreated = true;
			
			assertTrue(registrySaved);
			
			return Guice.createInjector(new Module(){

				public void configure(Binder binder) {
					binder.bind(Boolean.class).toInstance(Boolean.TRUE);
				}
				
			});
		}

		public void setupRegistry() {
			registrySaved = true;
			assertFalse(injectorCreated);
		}

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
