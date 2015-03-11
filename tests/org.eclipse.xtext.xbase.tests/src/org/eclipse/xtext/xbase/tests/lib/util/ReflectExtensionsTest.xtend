package org.eclipse.xtext.xbase.tests.lib.util

import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.junit.Assert
import org.junit.Test

class ReflectExtensionsTest {
	
	public extension ReflectExtensions ext = new ReflectExtensions
	ReflectExtensions privateExt = new ReflectExtensions
	
	@Test
	def void testInvoke_01() {
		val x = 'foo'
		Assert::assertEquals(3, x.invoke('length'))
	}
	
	@Test
	def void testInvoke_02() {
		val x = 'foo'
		try {
			x.invoke('foo')
			Assert::fail
		} catch (NoSuchMethodException e) {
			// expected
		}
	}
	
	@Test
	def void testInvoke_03() {
		val x = 'foo'
		try {
			x.invoke('length', 24)
			Assert::fail
		} catch (NoSuchMethodException e) {
			// expected
		}
	}
	
	@Test
	def void testInvokeWithOverloadedMethods() {
		val x = new StringBuilder
		try {
			x.invoke('append', "foo")
			Assert::fail
		} catch (IllegalStateException e) {
			// expected
		}
	}
	
	@Test
	def void testInvokeWithNull() {
		val x = [String x | x]
		Assert::assertNull(x.invoke('apply', null))
		Assert::assertEquals('foo', x.invoke('apply', 'foo'))
	}
	
	@Test
	def void testInvokeWithPrimitives() {
		val x = 'foo'
		Assert::assertEquals("o", x.invoke('substring', 1,2))
	}
	
	@Test
	def void testGet_01() {
		val x = new ReflectExtensionsTest
		Assert::assertNotNull(x.get('ext'))
	}
	
	@Test
	def void testGet_02() {
		val x = new ReflectExtensionsTest
		try {
			Assert::assertNotNull(x.get('foo'))
			Assert::fail()
		} catch (NoSuchFieldException e) {
			// expected
		}
	}
	
	@Test
	def void testGet_03() {
		val x = new ReflectExtensionsTest
		Assert::assertSame(x.privateExt, x.get('privateExt'))
	}
	
	@Test
	def void testSet_01() {
		val x = new ReflectExtensionsTest
		x.set('ext', null)
		Assert::assertNull(x.ext)
	}
	
	@Test
	def void testSet_02() {
		val x = new ReflectExtensionsTest
		try {
			x.set('foo', 'bar')
			Assert::fail()
		} catch (NoSuchFieldException e) {
			// expected
		}
	}
	
	@Test
	def void testSet_03() {
		val x = new ReflectExtensionsTest
		x.set('privateExt', null)
		Assert::assertNull(x.privateExt)
	}

}