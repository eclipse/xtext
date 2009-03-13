package org.eclipse.xtext.service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.xtext.service.AbstractGenericModule.Binding;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class AbstractGenericModuleTest extends TestCase {
	
	public void testSimple() throws Exception {
		AbstractGenericModule module = new TestModule();
		Set<Binding> bindings = module.getBindings();
		assertEquals(3,bindings.size());
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(CharSequence.class, String.class,false,false)));
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(Type.class, Class.class,false,false)));
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(TestCase.class, AbstractGenericModuleTest.class,false,false)));
	}
	
	public void testOverride() throws Exception {
		AbstractGenericModule module = new MyModule();
		Set<Binding> bindings = module.getBindings();
		assertEquals(4,bindings.size());
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(CharSequence.class, StringBuffer.class,false,false)));
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(Type.class, Class.class,false,false)));
		assertFalse(bindings.contains(new AbstractGenericModule.Binding(CharSequence.class, String.class,false,false)));
	}
	
	
	public void testInstanceBinding() throws Exception {
		final Date date = new Date();
		AbstractGenericModule m = new AbstractGenericModule(){
			public Date bindDate() {
				return date;
			}
		};
		
		Set<Binding> bindings = m.getBindings();
		assertEquals(1,bindings.size());
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(Date.class, 
				date,false,false)));
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
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(CharSequence.class, Void.TYPE,false,false)));
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(Type.class, Void.TYPE,false,false)));
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(TestCase.class, Void.TYPE,false,false)));
	}
	
	public void testSingletonBinding() throws Exception {
		Foo.instantiations=0;

		AbstractGenericModule m = new AbstractGenericModule(){
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
	
	public static class Foo {
		public static int instantiations = 0;
		
		public Foo() {
			instantiations++;
		}
	}
}
