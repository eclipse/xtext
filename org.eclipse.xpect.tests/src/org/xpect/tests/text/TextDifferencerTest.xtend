package org.xpect.tests.text

import java.util.List
import org.junit.Assert
import org.junit.Test
import org.xpect.text.ITextDifferencer.ISegment
import org.xpect.text.ITextDifferencer.ITextDiffConfig
import org.xpect.text.StringEndsSimilarityFunction
import org.xpect.text.TextDifferencer
import org.junit.Ignore
import org.xpect.text.TextDiffToString

class TextDifferencerTest {
	@Test @Ignore def void testEqual() {
		val left = #["a", "b", "c"]
		val right = #["a", "b", "c"]
		diff(left, right) === '''
			abc
		'''
	}

	@Test def void testDiffSL() {
		val left = #["a", "b", "c"]
		val right = #["a", "d", "c"]
		diff(left, right) === '''
			| a[b|d]c
		'''
	}

	@Test def void testRemoveSL() {
		val left = #["a", "b", "c"]
		val right = #["a", "c"]
		diff(left, right) === '''
			| a[b|]c
		'''
	}

	@Test def void testAddSL() {
		val left = #["a", "c"]
		val right = #["a", "b", "c"]
		diff(left, right) === '''
			| a[|b]c
		'''
	}

	@Test def void testDiffSLEnd() {
		val left = #["a", "b"]
		val right = #["a", "c"]
		diff(left, right) === '''
			| a[b|c]
		'''
	}

	@Test def void testRemoveSLEnd() {
		val left = #["a", "b"]
		val right = #["a"]
		diff(left, right) === '''
			| a[b|]
		'''
	}

	@Test def void testAddSLEnd() {
		val left = #["a"]
		val right = #["a", "b"]
		diff(left, right) === '''
			| a[|b]
		'''
	}

	@Test def void testDiffML() {
		val left = #["a\n", "b\n", "c\n"]
		val right = #["a\n", "d\n", "c\n"]
		diff(left, right) === '''
			  a
			- b
			+ d
			  c
		'''
	}

	@Test def void testRemoveML() {
		val left = #["a\n", "b\n", "c\n"]
		val right = #["a\n", "c\n"]
		diff(left, right) === '''
			  a
			- b
			  c
		'''
	}

	@Test def void testAddML() {
		val left = #["a\n", "c\n"]
		val right = #["a\n", "b\n", "c\n"]
		diff(left, right) === '''
			  a
			+ b
			  c
		'''
	}

	@Test @Ignore def void testWhitespace() {
		val left = #["a", "  ", "b"]
		val right = #["a", "    ", "b"]
		diff(left, right) === '''
			a  b
		'''
	}

	@Test def void testWhitespaceDiff() {
		val left = #["a", "  ", "b", "   ", "c"]
		val right = #["a", "    ", "c"]
		diff(left, right) === '''
			| a  [b|]   c
		'''
	}

	@Test def void testWhitespaceDiff2() {
		val left = #["a", "  ", "b", "   ", "c", "    ", "d"]
		val right = #["a", "     ", "d"]
		diff(left, right) === '''
			| a  [b   c|]    d
		'''
	}

	def diff(List<String> left, List<String> right) {
		val toStr = new TextDiffToString().setAllowSingleLineDiff(false).setAllowSingleSegmentDiff(false)
		val diff = new TextDifferencer().diff(left, right, new TextDiffConfig)
		return toStr.apply(diff)
	}

	def operator_tripleEquals(Object o1, Object o2) {
		Assert.assertEquals(o2.toString.trim, o1.toString.trim)
	}
}

class TextDiffConfig implements ITextDiffConfig<String> {

	override isHidden(String token, String segment) {
		token.toCharArray.forall[Character.isWhitespace(it)]
	}

	override toSegments(String token) {
		#[token]
	}

	override similarity(ISegment object1, ISegment object2) {
		new StringEndsSimilarityFunction().similarity(object1.toString, object2.toString)
	}

}
