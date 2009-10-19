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
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.xtext.service.AbstractGenericModule.Binding;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class GenericModuleTest extends TestCase {
	
	public void testSimple() throws Exception {
		AbstractGenericModule module = new TestModule();
		Set<Binding> bindings = module.getBindings();
		assertEquals(3,bindings.size());
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(CharSequence.class, String.class,false,false, false)));
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(Type.class, Class.class,false,false, false)));
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(TestCase.class, GenericModuleTest.class,false,false, false)));
	}
	
	public void testOverride() throws Exception {
		AbstractGenericModule module = new MyModule();
		Set<Binding> bindings = module.getBindings();
		assertEquals(4,bindings.size());
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(CharSequence.class, StringBuffer.class,false,false, false)));
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(Type.class, Class.class,false,false, false)));
		assertFalse(bindings.contains(new AbstractGenericModule.Binding(CharSequence.class, String.class,false,false, false)));
	}
	
	
	public void testInstanceBinding() throws Exception {
		final Date date = new Date();
		AbstractGenericModule m = new AbstractGenericModule(){
			@SuppressWarnings("unused")
			public Date bindDate() {
				return date;
			}
		};
		
		Set<Binding> bindings = m.getBindings();
		assertEquals(1,bindings.size());
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(Date.class,
				date,false,false, false)));
	}
	
	public static class DateProvider implements Provider<Date> {

		public Date get() {
			return null;
		}
		
	}
	
	public void testProviderClassBinding() throws Exception {
		AbstractGenericModule m = new AbstractGenericModule(){
			@SuppressWarnings("unused")
			public Class<? extends Provider<Date>> provideDate() {
				return DateProvider.class;
			}
		};
		
		Set<Binding> bindings = m.getBindings();
		assertEquals(1,bindings.size());
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(Date.class,
				DateProvider.class, false,false, true)));
	}
	
	public void testProviderClassDeactivation() throws Exception {
		AbstractGenericModule m = new AbstractGenericModule(){
			@SuppressWarnings("unused")
			public Class<? extends Provider<Date>> provideDate() {
				return null;
			}
		};
		
		Set<Binding> bindings = m.getBindings();
		assertEquals(1,bindings.size());
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(Date.class,
				Void.TYPE, false,false, true)));
	}
	
	public void testProviderInstanceBinding() throws Exception {
		final Provider<Date> provider = new Provider<Date>() {
			public Date get() {
				return null;
			}
		};
		AbstractGenericModule m = new AbstractGenericModule(){
			@SuppressWarnings("unused")
			public Provider<Date> provideDate() {
				return provider;
			}
		};
		
		Set<Binding> bindings = m.getBindings();
		assertEquals(1,bindings.size());
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(Date.class,
				provider, false,false, true)));
	}
	
	public void testDeactivation() throws Exception {
		TestModule module = new TestModule(){
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
		
		Set<Binding> bindings = module.getBindings();
		assertEquals(3,bindings.size());
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(CharSequence.class, Void.TYPE,false,false, false)));
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(Type.class, Void.TYPE,false,false, false)));
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(TestCase.class, Void.TYPE,false,false, false)));
	}
	
	public void testSingletonBinding() throws Exception {
		Foo.instantiations=0;

		AbstractGenericModule m = new AbstractGenericModule(){
			@SuppressWarnings("unused")
			@SingletonBinding()
			public Class<Foo> bindFoo() {
				return Foo.class;
			}
		};
		
		assertEquals(0,Foo.instantiations);
		Injector inj = Guice.createInjector(m);
		assertEquals(0,Foo.instantiations);
		Foo foo = inj.getInstance(Foo.class);
		assertEquals(1,Foo.instantiations);
		assertTrue(foo == inj.getInstance(Foo.class));
		assertEquals(1,Foo.instantiations);
	}

	public void testEagerSingletonBinding() throws Exception {
		Foo.instantiations=0;
		
		AbstractGenericModule m = new AbstractGenericModule(){
			@SuppressWarnings("unused")
			@SingletonBinding(eager=true)
			public Class<Foo> bindFoo() {
				return Foo.class;
			}
		};
		
		assertEquals(0,Foo.instantiations);
		Injector inj = Guice.createInjector(m);
		assertEquals(1,Foo.instantiations);
		Foo foo = inj.getInstance(Foo.class);
		assertEquals(1,Foo.instantiations);
		assertTrue(foo == inj.getInstance(Foo.class));
		assertEquals(1,Foo.instantiations);
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
