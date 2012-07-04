package org.eclipse.xtend.core.tests.formatting

import org.junit.runner.RunWith
import org.eclipse.xtend.core.tests.compiler.batch.XtendInjectorProvider
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test
import com.google.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtend.core.formatting.XtendFormatter2
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.Triple
import org.eclipse.xtext.util.Tuples
import org.junit.Assert

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XtendInjectorProvider))
class XtendFormatterTest {
	
	@Inject extension ParseHelper<XtendFile>
	@Inject XtendFormatter2 formatter
	
	def assertFormatted(CharSequence toBeFormatted) {
		assertFormatted(toBeFormatted, toBeFormatted)
	}
	
	def assertFormatted(CharSequence expectation, CharSequence toBeFormatted) {
		val parsed = toBeFormatted.parse
		Assert::assertEquals(0, parsed.eResource.errors.size)
		val root = (parsed.eResource as XtextResource).parseResult.rootNode
		val oldDocument = root.text
		val edits = <Triple<Integer, Integer, String>>newArrayList() 
		formatter.format(root, 0, oldDocument.length, [int offset, int length, String replacement | 
			edits += Tuples::create(offset, length, replacement)
		])
		var lastOffset = 0
		val newDocument = new StringBuilder()
		val debugTrace = new StringBuilder()
		for(edit:edits) {
			val text = oldDocument.substring(lastOffset, edit.first)
			newDocument.append(text)
			newDocument.append(edit.third)
			debugTrace.append(text)
			debugTrace.append('''[«oldDocument.substring(edit.first, edit.first)»|«edit.third»]''')
			lastOffset = edit.first + edit.second
		}
		val text = oldDocument.substring(lastOffset, oldDocument.length)
		newDocument.append(text)
		debugTrace.append(text)
		try {
			Assert::assertEquals(expectation.toString, newDocument.toString)
		} catch(AssertionError e) {
			println(debugTrace)
			throw e
		}
	}
	
	@Test def format1() {
		assertFormatted('''
			package foo
			
			class bar {
			}
		''', '''
			package foo class bar{}
		''')	
	}
	
}