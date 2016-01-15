package org.xpect.tests.state

import org.junit.Test
import org.xpect.state.ManagedImpl
import org.xpect.state.StateContainer

import static org.junit.Assert.*

class StateContainerTest {

	@Test
	def void testPrimaryValue() {
		val cnt = new StateContainer [
			it.addDefaultValue("Foo")
		]
		assertEquals("Foo", cnt.get(String).get())
	}

	@Test
	def void testPrimaryValueAnn() {
		val cnt = new StateContainer [
			it.addValue(TestData.Ann, "Foo")
		]
		assertEquals("Foo", cnt.get(String, TestData.Ann).get())
	}

	@Test
	def void testPrimaryManaged() {
		val cnt = new StateContainer [
			it.addDefaultValue(String, new ManagedImpl<String>("Foo"))
		]
		assertEquals("Foo", cnt.get(String).get())
	}

	@Test
	def void testPrimaryManagedAnn() {
		val cnt = new StateContainer [
			it.addValue(TestData.Ann, String, new ManagedImpl<String>("Foo"))
		]
		assertEquals("Foo", cnt.get(String, TestData.Ann).get())
	}

	@Test
	def void testDerivedValue() {
		val cnt = new StateContainer [
			it.addFactory(TestData.StaticValueProvider)
		]
		assertEquals("DefaultValue", cnt.get(String).get())
		assertEquals("AnnotatedValue", cnt.get(String, TestData.Ann).get())
	}

	@Test
	def void testDerivedManaged() {
		val cnt = new StateContainer [
			it.addFactory(TestData.StaticManagedProvider)
		]
		assertEquals("DefaultManaged", cnt.get(String).get())
		assertEquals("AnnotatedManaged", cnt.get(String, TestData.Ann).get())
	}
}
