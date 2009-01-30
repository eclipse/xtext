package org.eclipse.xtext.service;

import java.lang.reflect.Type;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

public class AbstractRuntimeModuleTest extends TestCase {
	
	public void testSimple() throws Exception {
		AbstractXtextModule module = new TestModule();
		Set<Pair<Class<?>, Class<?>>> bindings = module.getBindings();
		assertEquals(3,bindings.size());
		assertTrue(bindings.contains(Tuples.create(CharSequence.class, String.class)));
		assertTrue(bindings.contains(Tuples.create(Type.class, Class.class)));
		assertTrue(bindings.contains(Tuples.create(TestCase.class, AbstractRuntimeModuleTest.class)));
	}
	
	public void testOverride() throws Exception {
		AbstractXtextModule module = new MyModule();
		Set<Pair<Class<?>, Class<?>>> bindings = module.getBindings();
		assertEquals(4,bindings.size());
		assertTrue(bindings.contains(Tuples.create(CharSequence.class, StringBuffer.class)));
		assertTrue(bindings.contains(Tuples.create(Type.class, Class.class)));
		assertFalse(bindings.contains(Tuples.create(CharSequence.class, String.class)));
	}
}
