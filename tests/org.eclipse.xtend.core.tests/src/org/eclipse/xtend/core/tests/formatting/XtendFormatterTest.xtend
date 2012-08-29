package org.eclipse.xtend.core.tests.formatting

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.tests.compiler.batch.XtendInjectorProvider
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.Triple
import org.eclipse.xtext.util.Tuples
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtend.core.formatting.XtendFormatter
import org.junit.Ignore

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XtendInjectorProvider))
class XtendFormatterTest {
	
	@Inject extension ParseHelper<XtendFile>
	@Inject XtendFormatter formatter
	
	def assertFormatted(CharSequence toBeFormatted) {
		assertFormatted(toBeFormatted, toBeFormatted.parse.flattenWhitespace)
	}
	
	def toFile(CharSequence expression) '''
		package foo
		
		class bar {
			def baz() {
				«expression»
			}
		}
	'''

	
	def assertFormattedExpression(CharSequence toBeFormatted) {
		assertFormatted(toBeFormatted.toFile, toBeFormatted.toFile.parse.flattenWhitespace)
	}
	
	def assertFormattedExpression(String expectation, CharSequence toBeFormatted) {
		assertFormatted(expectation.toFile, toBeFormatted.toFile)
	}
	
	def flattenWhitespace(EObject obj) {
		val result = new StringBuilder()
		for(node: (obj.eResource as XtextResource).parseResult.rootNode.leafNodes)
			if(node.hidden && node.text.trim == "")
				result.append(" ")
			else 
				result.append(node.text)
		return result.toString
	}
	
	def assertFormatted(CharSequence expectation, CharSequence toBeFormatted) {
		val parsed = toBeFormatted.parse
		Assert::assertEquals(0, parsed.eResource.errors.size)
		val root = (parsed.eResource as XtextResource).parseResult.rootNode
		val oldDocument = root.text
		val edits = <Triple<Integer, Integer, String>>newArrayList() 
		formatter.format(parsed.eResource as XtextResource, 0, oldDocument.length, [int offset, int length, String replacement |
//			println("offs: "+offset + " -> " + oldDocument.subSequence(Math::max(0, offset - 5), offset) + "|" + oldDocument.subSequence(offset, Math::min(offset + 5, oldDocument.length)))
			if(offset < 0) throw new IllegalStateException('''Offset to small. Offset: «offset»''') 
			if(length < 0) throw new IllegalStateException('''Length to small. Length: «length»''') 
			if(offset + length > oldDocument.length) throw new IllegalStateException('''Range exceeds document. Offset: «offset» Length: «length» DocumentLenght: «oldDocument.length»''')
			if(edits.exists[offset >= first && offset <= first + second]) throw new IllegalStateException('''Offset inside existing edit. Offset: «offset» Length: «length»''')
			if(edits.exists[offset + length >= first && offset + length <= first + second]) throw new IllegalStateException('''Offset+Lenght inside existing edit. Offset: «offset» Length: «length»''')
			edits += Tuples::create(offset, length, replacement)
		])
		var lastOffset = 0
		val newDocument = new StringBuilder()
		val debugTrace = new StringBuilder()
		for(edit:edits.sortBy[first]) {
			val text = oldDocument.substring(lastOffset, edit.first)
			newDocument.append(text)
			newDocument.append(edit.third)
			debugTrace.append(text)
			debugTrace.append('''[«oldDocument.substring(edit.first, edit.first + edit.second)»|«edit.third»]''')
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
//			println(NodeModelUtils::compactDump(root, true))
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
	
	@Test def formatBlockExpression() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b");
			val y = 'foo';
			x.join
		''', '''
			val x = newArrayList("A", "b") ; val y = 'foo' ; x.join
		''')	
	}
	
	@Test def formatClosures() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b")
			val y = x.filter[ toUpperCase == it ]
			y.join
		''')	
	}
	
	@Test def formatClosuresEmpty() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b")
			val y = x.filter[]
			y.join
		''', '''
			val x = newArrayList("A", "b") val y = x.filter[   ] y.join
		''')	
	}
	
	@Test def formatClosuresParam() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b")
			val y = x.filter[ z | z.toUpperCase == z ]
			y.join
		''')	
	}
	
	@Test def formatClosuresMultiLine() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b")
			val y = x.filter [
				val z = it
				z.toUpperCase == z
			]
			y.join
		''', '''
			val x = newArrayList("A", "b") val y = x.filter [
				val z = it z.toUpperCase == z 
			] y.join
		''')	
	}
	
	@Test def formatClosuresParamMultiLine() {
		assertFormattedExpression('''
			val x = newArrayList("A", "b")
			val y = x.filter[ z |
				val w = z
				w.toUpperCase == w
			]
			y.join
		''', '''
			val x = newArrayList("A", "b") val y = x.filter[ z |
				val w = z w.toUpperCase == w
			] y.join
		''')	
	}
	
	@Test def formatIf1SL() {
		assertFormattedExpression('''
			if(true) println("foo")
		''', '''
			if(true)println("foo")
		''')	
	}
	
	@Test def formatIf1ML() {
		assertFormattedExpression('''
			if(true)
				println("foo")
		''', '''
			if(true)
			println("foo")
		''')	
	}
	
	@Test def formatIf1MLSemicolon1() {
		assertFormattedExpression('''
			if(true)
				println("foo");
		''', '''
			if(true)
			println("foo");
		''')	
	}
	
	@Test def formatIf1MLSemicolon2() {
		assertFormattedExpression('''
			if(true)
				println("foo");
			println("bar")
		''', '''
			if(true)
			println("foo");
			println("bar")
		''')	
	}
	
	@Test def formatIf2() {
		assertFormattedExpression('''
			if(true) {
				println("foo")
			}
		''')	
	}
	
	@Test def formatIfElse1SL() {
		assertFormattedExpression('''
			if(true) println("foo") else println("bar")
		''', '''
			if(true)println("foo")else  println("bar")
		''')	
	}
	
	@Test def formatIfElse1ML() {
		assertFormattedExpression('''
			if(true)
				println("foo")
			else
				println("bar")
		''', '''
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
			
	@Test def formatFor1() {
		assertFormattedExpression('''
			for(i:1..2)
				println(i)
		''')	
	}
	
	@Test def formatFor2() {
		assertFormattedExpression('''
			for(i:1..2) {
				println(i)
			}
		''')	
	}
	
	@Test def formatSwitchSL() {
		assertFormattedExpression('''
			switch 'x' { case 'x': println('x') case 'y': println('y') }
		''', '''
			switch 'x'  {   case 'x':   println('x')   case   'y':    println('y')    }
		''')	
	}
	
	@Test def formatSwitchCaseSL() {
		assertFormattedExpression('''
			switch 'x' {
				case 'x': println('x')
				case 'y': println('y')
			}
		''', '''
			switch 'x'  {   
				case 'x':   println('x')   case   'y':    println('y')
			}
		''')	
	}
	
	@Test def formatSwitchML() {
		assertFormattedExpression('''
			switch 'x' {
				case 'x':
					println('x')
				case 'y':
					println('y')
			}
		''', '''
			switch 'x'  {   
				case 'x':   
					println('x')   case   'y':    println('y')
			}
		''')	
	}
	
	@Test def formatSwitchMLBlock() {
		assertFormattedExpression('''
			switch 'x' {
				case 'x': {
					println('x')
				}
				case 'y': {
					println('y')
				}
			}
		''', '''
			switch 'x'  { case 'x': { println('x') }  case   'y':  {  println('y') } }
		''')	
	}
	
	@Test def formatFeatureCall1() {
		assertFormattedExpression('''
			val ML2 = newArrayList(newArrayList(1, 2, 3, 4),
				newArrayList(5, 6, 7, 8), newArrayList(9, 10, 11, 12),
				newArrayList(13, 14, 15, 16))
		''', '''
			val ML2 = newArrayList(newArrayList(1, 2, 3, 4), newArrayList(5, 6, 7, 8), newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))
		''')	
	}
	
	@Test def formatFeatureCall2() {
		assertFormattedExpression('''
			val ML2 = newArrayList(newArrayList(1, 2, 3, 4),
				newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,
					110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),
				newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))
		''', '''
			val ML2 = newArrayList(newArrayList(1, 2, 3, 4), newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))
		''')	
	}
	
	@Test def formatMemberFeatureCall1() {
		assertFormattedExpression('''
			val ML1 = "x".substring(0).substring(1).substring(2).substring(3).
				substring(4).substring(5).substring(6).substring(7).substring(8).
				substring(9).substring(10).substring(11)
		''', '''
			val ML1 = "x".substring(0).substring(1).substring(2).substring(3).substring(4).substring(5).substring(6).substring(7).substring(8).substring(9).substring(10).substring(11)
		''')	
	}
	
// - constructors
// - annotations
// - templates
// - don't unfold imports when formatting
	
}