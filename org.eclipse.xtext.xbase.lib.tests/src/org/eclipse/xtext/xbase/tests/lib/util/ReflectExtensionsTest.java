/*******************************************************************************
 * Copyright (c) 2018, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib.util;

import static org.junit.Assert.*;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.junit.Assert;
import org.junit.Test;

public class ReflectExtensionsTest {

	public ReflectExtensions ext = new ReflectExtensions();
	private ReflectExtensions privateExt = new ReflectExtensions();

	@Test
	public void testInvoke_01() throws Exception {
		String x = "foo";
		Assert.assertEquals(3, ext.invoke(x, "length"));
	}

	@Test(expected=NoSuchMethodException.class)
	public void testInvoke_02() throws Exception {
		String x = "foo";
		ext.invoke(x, "foo");
	}

	@Test(expected=NoSuchMethodException.class)
	public void testInvoke_03() throws Exception {
		String x = "foo";
		ext.invoke(x, "length", 24);
	}

	@Test(expected=IllegalStateException.class)
	public void testInvokeWithOverloadedMethods() throws Exception {
		StringBuilder x = new StringBuilder();
		ext.invoke(x, "append", "foo");
	}

	@Test
	public void testInvokeWithNull() throws Exception {
		final Function1<String, String> x = (String s) -> {
			return s;
		};
		Object[] args = null;
		Assert.assertNull(ext.invoke(x, "apply", args));
		Assert.assertEquals("foo", ext.invoke(x, "apply", "foo"));
	}

	@Test
	public void testInvokeWithPrimitives() throws Exception {
		String x = "foo";
		Assert.assertEquals("o", ext.invoke(x, "substring", 1, 2));
	}
	

	@Test
	public void testInvokeWithStaticMethod() throws Exception {
		String x = "foo";
		ext.invoke(x, "join", "a", new String[]{"b", "c"});
	}
	
	@Test
	public void testInvokeWithPrivateStaticMethod() throws Exception {
		MyClass x = new MyClass();
		ext.invoke(x, "doit");
	}
	
	@Test
	public void testSetWithPrivateStaticField() throws Exception {
		MyClass x = new MyClass();
		ext.set(x, "x","doit");
	}
	
	@Test
	public void testGetWithPrivateStaticField() throws Exception {
		MyClass x = new MyClass();
		assertEquals("old", ext.get(x, "x"));
	}
	
	public static class MyClass {
		@SuppressWarnings("unused")
		private static String doit() {
			return "doit";
		}
		@SuppressWarnings("unused")
		private String x = "old";
	}
	
	@Test
	public void testGet_01() throws Exception {
		ReflectExtensionsTest x = new ReflectExtensionsTest();
		Assert.assertNotNull(ext.get(x, "ext"));
	}

	@Test(expected=NoSuchFieldException.class)
	public void testGet_02() throws Exception {
		ReflectExtensionsTest x = new ReflectExtensionsTest();
		Assert.assertNotNull(ext.get(x, "foo"));
	}

	@Test
	public void testGet_03() throws Exception {
		ReflectExtensionsTest x = new ReflectExtensionsTest();
		Assert.assertSame(x.privateExt, ext.get(x, "privateExt"));
	}

	@Test
	public void testSet_01() throws Exception {
		ReflectExtensionsTest x = new ReflectExtensionsTest();
		ext.set(x, "ext", null);
		Assert.assertNull(x.ext);
	}

	@Test(expected=NoSuchFieldException.class)
	public void testSet_02() throws Exception {
		ReflectExtensionsTest x = new ReflectExtensionsTest();
		ext.set(x, "foo", "bar");
	}

	@Test
	public void testSet_03() throws Exception {
		ReflectExtensionsTest x = new ReflectExtensionsTest();
		ext.set(x, "privateExt", null);
		Assert.assertNull(x.privateExt);
	}


}