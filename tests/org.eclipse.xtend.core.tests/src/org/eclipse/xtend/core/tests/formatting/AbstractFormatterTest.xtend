package org.eclipse.xtend.core.tests.formatting

import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtend.core.tests.compiler.batch.XtendInjectorProvider
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.InjectWith
import javax.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.formatting.XtendFormatter
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.XtextResource
import org.junit.Assert
import org.eclipse.xtext.util.Triple
import org.eclipse.xtend.core.formatting.RendererConfiguration
import org.eclipse.xtext.util.Tuples

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(XtendInjectorProvider))
abstract class AbstractFormatterTest {
	@Inject extension ParseHelper<XtendFile>
	@Inject XtendFormatter formatter
	
	def assertFormatted(CharSequence toBeFormatted) {
		assertFormatted(toBeFormatted, toBeFormatted.parse.flattenWhitespace)
	}
	
	def private toFile(CharSequence expression) '''
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
	
	def private flattenWhitespace(EObject obj) {
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
		val rc = new RendererConfiguration() => [
			maxLineWidth = 80
		]
		
		
		formatter.format(parsed.eResource as XtextResource, 0, oldDocument.length, rc, [int offset, int length, String replacement |
//			println("offs: "+offset + " -> " + oldDocument.subSequence(Math::max(0, offset - 5), offset) + "|" + oldDocument.subSequence(offset, Math::min(offset + 5, oldDocument.length)))
			if(offset < 0) throw new IllegalStateException('''Offset to small. Offset: «offset»''') 
			if(length < 0) throw new IllegalStateException('''Length to small. Length: «length»''') 
			if(offset + length > oldDocument.length) throw new IllegalStateException('''Range exceeds document. Offset: «offset» Length: «length» DocumentLenght: «oldDocument.length»''')
			if(edits.exists[offset >= first && offset < first + second]) throw new IllegalStateException('''Offset inside existing edit. Offset: «offset» Length: «length»''')
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
}
