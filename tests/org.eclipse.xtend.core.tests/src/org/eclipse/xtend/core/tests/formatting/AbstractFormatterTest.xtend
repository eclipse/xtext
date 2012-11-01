package org.eclipse.xtend.core.tests.formatting

import javax.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.formatting.XtendFormatterConfig
import org.eclipse.xtend.core.formatting.XtendFormatter
import org.eclipse.xtend.core.tests.compiler.batch.XtendInjectorProvider
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.resource.XtextResource
import org.junit.Assert
import org.junit.runner.RunWith
import java.util.List
import org.eclipse.xtend.core.formatting.TextReplacement

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
	
	def private toMember(CharSequence expression) '''
		package foo
		
		class bar {
			«expression»
		}
	'''
	
	def assertFormattedExpression(CharSequence toBeFormatted) {
		assertFormatted(toBeFormatted.toFile, toBeFormatted.toFile.parse.flattenWhitespace)
	}
	
	def assertFormattedExpression(String expectation, CharSequence toBeFormatted) {
		assertFormatted(expectation.toFile, toBeFormatted.toFile)
	}
	
	def assertFormattedMember(String expectation, CharSequence toBeFormatted) {
		assertFormatted(expectation.toMember, toBeFormatted.toMember)
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
		Assert::assertEquals(parsed.eResource.errors.join("\n"), 0, parsed.eResource.errors.size)
		val oldDocument = (parsed.eResource as XtextResource).parseResult.rootNode.text
		val rc = new XtendFormatterConfig() => [
			maxLineWidth = 80
		]
		formatter.allowIdentityEdits = true
		
		// Step 1: Ensure formatted document equals expectation 
		val edits = formatter.format(parsed.eResource as XtextResource, 0, oldDocument.length, rc)
		val newDocument = oldDocument.applyEdits(edits)
		try {
			Assert::assertEquals(expectation.toString, newDocument.toString)
		} catch(AssertionError e) {
			println(oldDocument.applyDebugEdits(edits))
			println()
//			println(NodeModelUtils::compactDump(root, true))
			throw e
		}
		
		// Step 2: Ensure formatting the document again doesn't change the document
		val parsed2 = newDocument.parse
		Assert::assertEquals(0, parsed2.eResource.errors.size)
		val edits2 = formatter.format(parsed2.eResource as XtextResource, 0, newDocument.length, rc)
		val newDocument2 = newDocument.applyEdits(edits2)
		try {
			Assert::assertEquals(newDocument.toString, newDocument2.toString)
		} catch(AssertionError e) {
			println(newDocument.applyDebugEdits(edits2))
			println()
			throw e
		}
	}
	
	def protected String applyEdits(String oldDocument, List<TextReplacement> edits) {
		var lastOffset = 0
		val newDocument = new StringBuilder()
		for(edit:edits.sortBy[offset]) {
			newDocument.append(oldDocument.substring(lastOffset, edit.offset))
			newDocument.append(edit.text)
			lastOffset = edit.offset + edit.length
		}
		newDocument.append(oldDocument.substring(lastOffset, oldDocument.length))
		newDocument.toString
	}
	
	def protected String applyDebugEdits(String oldDocument, List<TextReplacement> edits) {
		var lastOffset = 0
		val debugTrace = new StringBuilder()
		for(edit:edits.sortBy[offset]) {
			debugTrace.append(oldDocument.substring(lastOffset, edit.offset))
			debugTrace.append('''[«oldDocument.substring(edit.offset, edit.offset + edit.length)»|«edit.text»]''')
			lastOffset = edit.offset + edit.length
		}
		debugTrace.append(oldDocument.substring(lastOffset, oldDocument.length))
		debugTrace.toString
	}
}
