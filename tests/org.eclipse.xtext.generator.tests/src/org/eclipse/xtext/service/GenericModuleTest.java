/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service;

import java.lang.reflect.Type;
import java.util.Date;

import junit.framework.TestCase;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class GenericModuleTest extends TestCase {

	public void assertConfigures(CompoundModule module, Class<?> from, Object to, boolean singleton,
			boolean eagerSingleton, boolean provider) {
		assertTrue(module.isConfigured(from, to, singleton, eagerSingleton, provider));
	}

	public void assertConfiguresNot(CompoundModule module, Class<?> from, Class<?> to, boolean singleton,
			boolean eagerSingleton, boolean provider) {
		assertFalse(module.isConfigured(from, to, singleton, eagerSingleton, provider));
	}

	public void testSimple() throws Exception {
		AbstractGenericModule module = new TestModule();
		CompoundModule bindings = module.getBindings();
		assertEquals(3, bindings.size());
		assertConfigures(bindings, CharSequence.class, String.class, false, false, false);
		assertConfigures(bindings, Type.class, Class.class, false, false, false);
		assertConfigures(bindings, TestCase.class, GenericModuleTest.class, false, false, false);
	}

	public void testOverride() throws Exception {
		AbstractGenericModule module = new MyModule();
		CompoundModule bindings = module.getBindings();
		assertEquals(4, bindings.size());
		assertConfigures(bindings, CharSequence.class, StringBuffer.class, false, false, false);
		assertConfigures(bindings, Type.class, Class.class, false, false, false);
		assertConfiguresNot(bindings, CharSequence.class, String.class, false, false, false);
	}

	public void testInstanceBinding() throws Exception {
		final Date date = new Date();
		AbstractGenericModule m = new AbstractGenericModule() {
			@SuppressWarnings("unused")
			public Date bindDate() {
				return date;
			}
		};

		CompoundModule bindings = m.getBindings();
		assertEquals(1, bindings.size());
		assertConfigures(bindings, Date.class, date, false, false, false);
	}

	public static class DateProvider implements Provider<Date> {

		public Date get() {
			return null;
		}

	}

	public void testProviderClassBinding() throws Exception {
		AbstractGenericModule m = new AbstractGenericModule() {
			@SuppressWarnings("unused")
			public Class<? extends Provider<Date>> provideDate() {
				return DateProvider.class;
			}
		};

		CompoundModule bindings = m.getBindings();
		assertEquals(1, bindings.size());
		assertConfigures(bindings, Date.class, DateProvider.class, false, false, true);
	}

	public void testProviderClassDeactivation() throws Exception {
		AbstractGenericModule m = new AbstractGenericModule() {
			@SuppressWarnings("unused")
			public Class<? extends Provider<Date>> provideDate() {
				return null;
			}
		};

		CompoundModule bindings = m.getBindings();
		assertEquals(1, bindings.size());
		assertConfigures(bindings, Date.class, null, false, false, true);
	}

	public void testProviderInstanceBinding() throws Exception {
		final Provider<Date> provider = new Provider<Date>() {
			public Date get() {
				return null;
			}
		};
		AbstractGenericModule m = new AbstractGenericModule() {
			@SuppressWarnings("unused")
			public Provider<Date> provideDate() {
				return provider;
			}
		};

		CompoundModule bindings = m.getBindings();
		assertEquals(1, bindings.size());
		assertConfigures(bindings, Date.class, provider, false, false, true);
	}

	public void testDeactivation() throws Exception {
		TestModule module = new TestModule() {
			@Override
			public Class<? extends CharSequence> bindString() {
				return null;
			}

			@Override
			public Class<? extends TestCase> bindTestCase() {
				return null;
			}

			@Override
			public Class<? extends Type> bindType() {
				return null;
			}
		};

		CompoundModule bindings = module.getBindings();
		assertEquals(3, bindings.size());
		assertConfigures(bindings, CharSequence.class, null, false, false,
				false);
		assertConfigures(bindings, Type.class, null, false, false, false);
		assertConfigures(bindings, TestCase.class, null, false, false, false);
	}

	public void testSingletonBinding() throws Exception {
		Foo.instantiations = 0;

		AbstractGenericModule m = new AbstractGenericModule() {
			@SuppressWarnings("unused")
			@SingletonBinding()
			public Class<Foo> bindFoo() {
				return Foo.class;
			}
		};

		assertEquals(0, Foo.instantiations);
		Injector inj = Guice.createInjector(m);
		assertEquals(0, Foo.instantiations);
		Foo foo = inj.getInstance(Foo.class);
		assertEquals(1, Foo.instantiations);
		assertTrue(foo == inj.getInstance(Foo.class));
		assertEquals(1, Foo.instantiations);
	}

	public void testEagerSingletonBinding() throws Exception {
		Foo.instantiations = 0;

		AbstractGenericModule m = new AbstractGenericModule() {
			@SuppressWarnings("unused")
			@SingletonBinding(eager = true)
			public Class<Foo> bindFoo() {
				return Foo.class;
			}
		};

		assertEquals(0, Foo.instantiations);
		Injector inj = Guice.createInjector(m);
		assertEquals(1, Foo.instantiations);
		Foo foo = inj.getInstance(Foo.class);
		assertEquals(1, Foo.instantiations);
		assertTrue(foo == inj.getInstance(Foo.class));
		assertEquals(1, Foo.instantiations);
	}

	public void testNamedBinding() throws Exception {
		@SuppressWarnings("unused")
		AbstractGenericModule module = new AbstractGenericModule() {
			String foo() {
				return "bar";
			}
		};
	}

	public static class Foo {
		public static int instantiations = 0;

		public Foo() {
			instantiations++;
		}
	}
}
