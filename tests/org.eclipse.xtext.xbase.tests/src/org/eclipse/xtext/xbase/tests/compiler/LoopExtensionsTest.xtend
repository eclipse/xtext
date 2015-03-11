package org.eclipse.xtext.xbase.tests.compiler

import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.compiler.LoopExtensions
import org.junit.Test
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable
import org.eclipse.xtext.xbase.compiler.LoopParams

import static java.util.Collections.*
import com.google.inject.Inject

class LoopExtensionsTest extends AbstractXbaseTestCase {
	
	@Inject LoopExtensions loopExtensions
	
	@Test
	def testForEach_all() {
		val all = newArrayList('jan', 'hein', 'class', 'pit')
		all.assertForEach([], 'janheinclasspit')
		all.assertForEach([prefix='_'], '_janheinclasspit')
		all.assertForEach([prefix='_' separator=' '], '_jan hein class pit')
		all.assertForEach([prefix='_' suffix='*'], '_janheinclasspit*')
		all.assertForEach([prefix='_' separator=' ' suffix='*'], '_jan hein class pit*')
		all.assertForEach([separator=' '], 'jan hein class pit')
		all.assertForEach([separator=' ' suffix='*'], 'jan hein class pit*')
		all.assertForEach([suffix='*'], 'janheinclasspit*')
	} 

	@Test
	def testForEach_single() {
		val single = newArrayList('foo')
		single.assertForEach([], 'foo')
		single.assertForEach([prefix='_'], '_foo')
		single.assertForEach([prefix='_' separator=' '], '_foo')
		single.assertForEach([prefix='_' suffix='*'], '_foo*')
		single.assertForEach([prefix='_' separator=' ' suffix='*'], '_foo*')
		single.assertForEach([separator=' '], 'foo')
		single.assertForEach([separator=' ' suffix='*'], 'foo*')
		single.assertForEach([suffix='*'], 'foo*')
	}
	
	@Test
	def testForEach_empty() {
		val empty = <String>emptyList
		empty.assertForEach([], '')
		empty.assertForEach([prefix='_'], '')
		empty.assertForEach([prefix='_' separator=' '], '')
		empty.assertForEach([prefix='_' suffix='*'], '')
		empty.assertForEach([prefix='_' separator=' ' suffix='*'], '')
		empty.assertForEach([separator=' '], '')
		empty.assertForEach([separator=' ' suffix='*'], '')
		empty.assertForEach([suffix='*'], '')
	}
	
	def testForEachWithSkip() {
		val all = newArrayList('jan', 'hein', 'class', 'pit')
		all.assertForEachWithSkip([it=='jan'], '{hein, class, pit}')		
		all.assertForEachWithSkip([it=='hein'], '{jan, class, pit}')		
		all.assertForEachWithSkip([it=='pit'], '{jan, hein, class}')		
		all.assertForEachWithSkip([true], '{}')		
	}
	
	@Test
	def testForEachWithShortcut() {
		newArrayList('jan', 'hein', 'class', 'pit').assertForEachWithShortcut("{ jan, hein, class, pit }")
		newArrayList('foo').assertForEachWithShortcut("foo")
		newArrayList().assertForEachWithShortcut("{}")
	}

	def protected assertForEach(Iterable<String> elements, (LoopParams)=>void params, String expectedResult) {
		val app = new FakeTreeAppendable
		loopExtensions.forEach(app, elements, params, [app.append(it)])
		assertEquals(expectedResult, app.toString)
	}

	def protected assertForEachWithSkip(Iterable<String> elements, (String)=>boolean append, String expectedResult) {
		val app = new FakeTreeAppendable
		loopExtensions.forEach(app, elements, [prefix="{" separator=", " suffix="}"], [ if(!append.apply(it)) app.append(it)]) 
		assertEquals(expectedResult, app.toString)
	}

	def protected assertForEachWithShortcut(Iterable<String> elements, String expectedResult) {
		val app = new FakeTreeAppendable
		loopExtensions.forEachWithShortcut(app, elements, [app.append(it)])
		assertEquals(expectedResult, app.toString)
	}
}