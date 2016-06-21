/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtext.xbase.testing.TemporaryFolder;
import org.eclipse.xtext.xbase.testing.OnTheFlyJavaCompiler;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public class OnTheFlyJavaCompilerTest extends Assert {
	
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	private OnTheFlyJavaCompiler compiler = new OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler();
	@Before
	public void setUp() throws Exception {
		compiler.setTemporaryFolder(tempFolder);
		compiler.setParentClassLoader(OnTheFlyJavaCompilerTest.class.getClassLoader());
		compiler.addClassPathOfClass(OnTheFlyJavaCompilerTest.class);
		compiler.addClassPathOfClass(Functions.class);
	}
	
	@SuppressWarnings("unchecked")
	@Test public void testCompileToClass() throws Exception {
		Class<?> class1 = compiler.compileToClass("Foo",
				"public class Foo implements "+Functions.Function0.class.getCanonicalName()+"<String> {" +
				"   public String apply() {\n" + 
				"	   return \"foo\";\n" + 
				"   }" +
				"}");
		assertEquals("foo", ((Functions.Function0<String>)class1.newInstance()).apply());
	}
	
	@Test public void testGetFunction0() throws Exception {
		assertEquals(42,compiler.createFunction("return 42;", Integer.class).apply().intValue());
	}
	
	@Test public void testGetFunction1() throws Exception {
		final Function1<Object, String> toUpper = compiler.createFunction("return p.toString().toUpperCase();", String.class, Object.class);
		assertEquals("FOO",toUpper.apply("foo"));
	}
	
	@Test public void testGetFunction2() throws Exception {
		Function2<Object, Object, Boolean> equals = compiler.createFunction("return p1==p2;", Boolean.class, Object.class, Object.class);
		assertTrue(equals.apply(null, null));
		assertFalse(equals.apply(null, "x"));
	}
}
