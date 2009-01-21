package org.eclipse.xtext.service;

import junit.framework.TestCase;

import org.eclipse.xtext.service.examples.FooBar;
import org.eclipse.xtext.service.examples.IBar;
import org.eclipse.xtext.service.examples.IFoo;

public class PreferExplicitMatchTest extends TestCase {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ServiceRegistry.resetInternal();
	}
	
	IServiceScope scope = new IServiceScope(){
		
		public String getId() {
			return "foo.test";
		}
		
		public IServiceScope getParentScope() {
			return null;
		}};
		
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		ServiceRegistry.resetInternal();
	}
	
	public void testExplicitePreffered() throws Exception {
		final FooBar foo = new FooBar("IFoo");
		final FooBar bar = new FooBar("IBar");
			
		ServiceRegistry.registerFactory(scope, prototype(foo,IFoo.class));
		ServiceRegistry.registerFactory(scope, prototype(bar,IBar.class));
		
		assertEquals(foo,ServiceRegistry.getService(scope, IFoo.class));
	}
	
	public void testExplicitePreffered2() throws Exception {
		final FooBar foo = new FooBar("IFoo");
		final FooBar bar = new FooBar("IBar");
		
		ServiceRegistry.registerFactory(scope, prototype(bar,IBar.class));
		ServiceRegistry.registerFactory(scope, prototype(foo,IFoo.class));
		
		assertEquals(foo,ServiceRegistry.getService(scope, IFoo.class));
	}
	
	public void testCompatibleFallBack() throws Exception {
		final FooBar bar = new FooBar("IBar");
		
		ServiceRegistry.registerFactory(scope, prototype(bar,IBar.class));
		
		assertEquals(bar,ServiceRegistry.getService(scope, IFoo.class));
	}

	private IServiceFactory prototype(final Object foo,final Class<?> clazz) {
		return new IServiceFactory(){

			public Object createService() {
				return foo;
			}

			public Class<?> getServiceInterface() {
				return clazz;
			}};
	}
}
