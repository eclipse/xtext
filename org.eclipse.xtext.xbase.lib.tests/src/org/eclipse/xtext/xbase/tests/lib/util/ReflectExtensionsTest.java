package org.eclipse.xtext.xbase.tests.lib.util;

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