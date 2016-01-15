package org.eclipse.xpect.tests.text

import org.junit.Assert

import org.junit.Test
import org.eclipse.xpect.text.Canvas
import org.eclipse.xpect.text.ICanvas

class CanvasTest {
	def private ICanvas newCanvas() {
		Canvas.create("-", "$\n")
	}

	@Test def void testPaintAt00() {
		val canvas = newCanvas
		canvas.print("Foo")
		canvas === '''
			Foo
		'''
	}

	@Test def void testPaintAt02() {
		val canvas = newCanvas
		canvas.at(0, 2).print("Foo")
		canvas === '''
			--Foo
		'''
	}

	@Test def void testPaintAt20() {
		val canvas = newCanvas
		canvas.at(2, 0).print("Foo")
		canvas === '''
			$
			$
			Foo
		'''
	}

	@Test def void testPaintAt22() {
		val canvas = newCanvas
		canvas.at(2, 2).print("Foo")
		canvas === '''
			$
			$
			--Foo
		'''
	}

	@Test def void testOverPaintAt22() {
		val canvas = newCanvas
		canvas.at(2, 2).print("Foo")
		canvas.at(1, 3).print("Bar\nBaz")
		canvas === '''
			$
			---Bar$
			--FBaz
		'''
	}

	@Test def void testSubcanvasAt22() {
		val canvas = newCanvas
		canvas.at(2, 2).newSubCanvas.print("Foo")
		canvas === '''
			$
			$
			--Foo
		'''
	}

	@Test def void testSubcanvasAt2235() {
		val canvas = newCanvas
		canvas.at(2, 2).newSubCanvas.at(3, 5).print("Foo")
		canvas === '''
			$
			$
			$
			$
			$
			-------Foo
		'''
	}

	@Test def void testBounds() {
		val canvas = newCanvas
		canvas.withBounds(2, 3).print("abcde\nfghij\nklmno\npqrstuv")
		canvas === '''
			abc$
			fgh
		'''
	}

	@Test def void testBoundsAt() {
		val canvas = newCanvas
		canvas.at(1, 2).withBounds(2, 3).print("abcde\nfghij\nklmno\npqrstuv")
		canvas === '''
			$
			--abc$
			--fgh
		'''
	}

	@Test def void testBoundsSubcanvasAt() {
		val canvas = newCanvas
		canvas.at(1, 2).withBounds(2, 3).newSubCanvas.print("abcde\nfghij\nklmno\npqrstuv")
		canvas === '''
			$
			--abc$
			--fgh
		'''
	}

	@Test def void testFill() {
		val canvas = newCanvas
		canvas.at(1, 2).withBounds(5, 8).fill("a\nbcd")
		canvas === '''
			$
			--a--a--a-$
			--bcdbcdbc$
			--a--a--a-$
			--bcdbcdbc$
			--a--a--a-
		'''
	}

	def operator_tripleEquals(Object o1, Object o2) {
		Assert.assertEquals(o2.toString.trim, o1.toString.trim)
	}
}
