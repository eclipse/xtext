/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.shared;

import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Binder;
import com.google.inject.ConfigurationException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PlainInjectorTest {
	
	@Test
	public void testEmptyInjector() {
		Injector injector = Guice.createInjector();
		Assert.assertNull(injector.getExistingBinding(Key.get(String.class)));
		String emptyString = injector.getInstance(String.class);
		Assert.assertEquals("", emptyString);
		Assert.assertNotNull(injector.getExistingBinding(Key.get(String.class)));
	}
	
	@Test(expected = ConfigurationException.class)
	public void testEmptyInjectorNoJIT() {
		Injector injector = Guice.createInjector(new Module() {
			@Override
			public void configure(Binder binder) {
				binder.requireExplicitBindings();
			}
		});
		Assert.assertNull(injector.getExistingBinding(Key.get(String.class)));
		injector.getInstance(String.class);
	}
	
	@Test
	public void testEmptyChildInjector() {
		Injector parentInjector = Guice.createInjector();
		Injector injector = parentInjector.createChildInjector();
		Assert.assertNull(injector.getExistingBinding(Key.get(String.class)));
		String emptyString = injector.getInstance(String.class);
		Assert.assertEquals("", emptyString);
		Assert.assertNotNull(injector.getExistingBinding(Key.get(String.class)));
		Assert.assertNotNull(parentInjector.getExistingBinding(Key.get(String.class)));
	}
	
	@Test
	public void testChildInjector() {
		Injector parentInjector = Guice.createInjector();
		Injector injector = parentInjector.createChildInjector(new Module() {
			@Override
			public void configure(Binder binder) {
				binder.bind(CharSequence.class).to(String.class);
			}
		});
		Assert.assertNotNull(injector.getExistingBinding(Key.get(CharSequence.class)));
		// Parent allows JIT bindings and those are always created in the ancestor
		Assert.assertNotNull(injector.getExistingBinding(Key.get(String.class)));
		CharSequence emptyString = injector.getInstance(CharSequence.class);
		Assert.assertEquals("", emptyString);
		Assert.assertNotNull(injector.getExistingBinding(Key.get(String.class)));
		Assert.assertNotNull(parentInjector.getExistingBinding(Key.get(String.class)));
	}
	
	@Test(expected = ConfigurationException.class)
	public void testEmptyChildInjectorNoJIT() {
		Injector injector = Guice.createInjector().createChildInjector(new Module() {
			@Override
			public void configure(Binder binder) {
				binder.requireExplicitBindings();
			}
		});
		Assert.assertNull(injector.getExistingBinding(Key.get(String.class)));
		injector.getInstance(String.class);
	}
	
	@Test
	public void testChildInjectorNoJIT() {
		Injector parentInjector = Guice.createInjector(new Module() {
			@Override
			public void configure(Binder binder) {
				binder.bind(String.class).toInstance("");
			}
			
		});
		Injector injector = parentInjector.createChildInjector(new Module() {
			@Override
			public void configure(Binder binder) {
				binder.requireExplicitBindings();
				binder.bind(CharSequence.class).to(String.class);
			}
		});
		Assert.assertNotNull(injector.getExistingBinding(Key.get(String.class)));
		Assert.assertNotNull(parentInjector.getExistingBinding(Key.get(String.class)));
		Assert.assertEquals("", injector.getInstance(CharSequence.class));
		Assert.assertNotNull(parentInjector.getExistingBinding(Key.get(String.class)));
	}
	
	@Test
	public void testGrandChildInjectorNoJIT() {
		Injector parentInjector = Guice.createInjector();
		Injector injector = parentInjector.createChildInjector(new Module() {
			@Override
			public void configure(Binder binder) {
				binder.requireExplicitBindings();
			}
		}).createChildInjector(new Module() {
			@Override
			public void configure(Binder binder) {
				binder.bind(CharSequence.class).to(String.class);				
			}
		});
		Assert.assertNotNull(injector.getExistingBinding(Key.get(String.class)));
		Assert.assertNull(parentInjector.getExistingBinding(Key.get(String.class)));
		Assert.assertEquals("", injector.getInstance(CharSequence.class));
		Assert.assertNull(parentInjector.getExistingBinding(Key.get(String.class)));
	}
}
