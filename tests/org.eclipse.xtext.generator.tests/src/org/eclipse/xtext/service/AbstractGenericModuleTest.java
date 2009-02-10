package org.eclipse.xtext.service;

import java.lang.reflect.Type;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.xtext.service.AbstractGenericModule.Binding;

public class AbstractGenericModuleTest extends TestCase {
	
	public void testSimple() throws Exception {
		AbstractGenericModule module = new TestModule();
		Set<Binding> bindings = module.getBindings();
		assertEquals(3,bindings.size());
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(CharSequence.class, String.class)));
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(Type.class, Class.class)));
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(TestCase.class, AbstractGenericModuleTest.class)));
	}
	
	public void testOverride() throws Exception {
		AbstractGenericModule module = new MyModule();
		Set<Binding> bindings = module.getBindings();
		assertEquals(4,bindings.size());
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(CharSequence.class, StringBuffer.class)));
		assertTrue(bindings.contains(new AbstractGenericModule.Binding(Type.class, Class.class)));
		assertFalse(bindings.contains(new AbstractGenericModule.Binding(CharSequence.class, String.class)));
	}
}
