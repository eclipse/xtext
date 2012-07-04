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
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XtendInjectorProvider))
class XtendFormatterTest {
	
	@Inject extension ParseHelper<XtendFile>
	@Inject XtendFormatter2 formatter
	
	def assertFormatted(CharSequence toBeFormatted) {
		assertFormatted(toBeFormatted, toBeFormatted)
	}
	
	def assertFormattedExpression(CharSequence toBeFormatted) {
		val text = '''
			package foo
			
			class bar {
				def baz() {
					«toBeFormatted»
				}
			}
		'''
		assertFormatted(text, text)
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
			println()
			println(NodeModelUtils::compactDump(root, true))
			throw e
		}
	}
	
	@Test def formatClass() {
		assertFormatted('''
			package foo
			
			class bar {
			}
		''', '''
			package foo class bar{}
		''')	
	}
	
	@Test def formatClassAnnotation() {
		assertFormatted('''
			package foo

			@Deprecated
			class bar {
				def baz() {
				}
			}
		''')	
	}
	
	@Test def formatImports() {
		assertFormatted('''
			package foo
			
			import java.util.Map
			import java.util.Set
			
			class bar {
				def baz() {
				}
			}
		''')	
	}
	
	@Test def formatMethod() {
		assertFormatted('''
			package foo
			
			class bar {
				def baz() {
				}
			}
		''')	
	}
	
	@Test def formatMethod1() {
		assertFormatted('''
			package foo
			
			class bar {
				def baz(String x) {
				}
			}
		''')	
	}
	
	@Test def formatMethod2() {
		assertFormatted('''
			package foo
			
			class bar {
				def baz(String x, String y) {
				}
			}
		''')	
	}
	
	@Test def formatMethodAnnotation() {
		assertFormatted('''
			package foo
			
			class bar {
				@Deprecated def baz() {
				}
			}
		''')	
	}
	
	
	@Test def formatGenerics() {
		assertFormattedExpression('''
			val x = <Pair<String, String>>newArrayList()
		''')	
	}
	
	@Test def formatClosures() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b")
			val y = x.filter[ toUpperCase == it ]
			y.join
		''')	
	}
	
	@Test def formatIf1() {
		assertFormattedExpression('''
			if(true)
				println("foo")
		''')	
	}
	
	@Test def formatIf2() {
		assertFormattedExpression('''
			if(true) {
				println("foo")
			}
		''')	
	}
	
	@Test def formatIfElse1() {
		assertFormattedExpression('''
			if(true)
				println("foo")
			else
				println("bar")
		''')	
	}
	
	@Test def formatIfElse2() {
		assertFormattedExpression('''
			if(true) {
				println("foo")
			} else {
				println("bar")
			}
		''')	
	}
	
}