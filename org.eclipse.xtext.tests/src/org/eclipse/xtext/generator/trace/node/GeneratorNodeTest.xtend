/*******************************************************************************
 * Copyright (c) 2017 TypeFox (https://typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.eclipse.xtext.generator.trace.LocationData
import org.eclipse.xtext.generator.trace.SourceRelativeURI
import org.junit.Assert
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class GeneratorNodeTest {
	
	extension GeneratorNodeExtensions exts = new GeneratorNodeExtensions()
	
	@Test def void testBasicCreationAndProcessing() {
		val root = loc(0)
		var node = root.trace
			.append('notindented').appendNewLine
		node.indent.trace(loc(1))
			.append('indented1').appendNewLine
			.append('indented2')
		node.appendNewLine.append('dedented')
		val processor = new GeneratorNodeProcessor
		val result = processor.process(node)
		assertEquals('''
			notindented
			  indented1
			  indented2
			dedented'''.toString, result.toString)
		assertEquals('''
			CompletableTraceRegion [myOffset=0, myLength=44, useForDebugging=false] associations={
			  LocationData [TextRegionWithLineInformation [0:100][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]
			} nestedRegions={
			  CompletableTraceRegion [myOffset=14, myLength=21, useForDebugging=false] associations={
			    LocationData [TextRegionWithLineInformation [1:99][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]
			  }
			}'''.toString, result.traceRegion.toString)
	}
	
	@Test def void testEmptyIndent() {
		val root = loc(0)
		var node = root.trace.append('Hallo').appendNewLine
		node.indent
		node.append('noindent').appendNewLine
		node.append(new IndentNode('  ', true, true))
		node.append('noindent').appendNewLine

		val processor = new GeneratorNodeProcessor
		assertEquals('''
			Hallo
			noindent
			noindent
		'''.toString, processor.process(node).toString)
	}
	
	@Test def void testTemplateProcessing() {
		val root = loc(0)
		val node = root.trace
			.appendTemplate('''
				«someCodeGen(2)»
			''')
			
		val processor = new GeneratorNodeProcessor
		val result = processor.process(node)
		assertEquals(someCodeGen_noTrace(2).toString, result.toString)
		assertEquals('''
			CompletableTraceRegion [myOffset=0, myLength=80, useForDebugging=false] associations={
			  LocationData [TextRegionWithLineInformation [0:100][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]
			} nestedRegions={
			  CompletableTraceRegion [myOffset=7, myLength=5, useForDebugging=false] associations={
			    LocationData [TextRegionWithLineInformation [10:90][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]
			  }
			  CompletableTraceRegion [myOffset=28, myLength=5, useForDebugging=false] associations={
			    LocationData [TextRegionWithLineInformation [10:90][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]
			  }
			  CompletableTraceRegion [myOffset=47, myLength=5, useForDebugging=false] associations={
			    LocationData [TextRegionWithLineInformation [11:89][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]
			  }
			  CompletableTraceRegion [myOffset=68, myLength=5, useForDebugging=false] associations={
			    LocationData [TextRegionWithLineInformation [10:90][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]
			  }
			}'''.toString, result.traceRegion.toString)
	}
	
	private def StringConcatenationClient someCodeGen(int n) '''
		«FOR i : 0..<n»
			before «loc(10+i).trace.append('Hello')» after
			  «someCodeGen(n-1)»
		«ENDFOR»
	'''
	private def String someCodeGen_noTrace(int n) '''
		«FOR i : 0..<n»
			before «'Hello'» after
			  «someCodeGen_noTrace(n-1)»
		«ENDFOR»
	'''
	
	private def loc(int idx) {
		new LocationData(idx, 100-idx, 0, 0, new SourceRelativeURI('foo/mymodel.dsl'))
	}
	
	@Test def void testAppendVariants() {
		val node = new CompositeGeneratorNode
		val String string = '''* a simple string'''
		node.append(string)
		node.appendNewLine
		val StringConcatenation stringConcat1 = '''
			* a multi-line string concatenation embedding
			  	«string»
		'''
		node.append(stringConcat1)
		val StringConcatenationClient client = '''
			* a string concatentation client embedding
			  	«stringConcat1»
		'''
		node.append(client)
		val nestedNode = new CompositeGeneratorNode
		val StringConcatenation stringConcat2 = '''
			* I can even embed
			  	«client»
			  in a string concatenation
		'''
		nestedNode.append(stringConcat2)
		node.append(nestedNode)

		val processor = new GeneratorNodeProcessor
		assertEquals('''
			* a simple string
			* a multi-line string concatenation embedding
			  	* a simple string
			* a string concatentation client embedding
			  	* a multi-line string concatenation embedding
			  	  	* a simple string
			* I can even embed
			  	* a string concatentation client embedding
			  	  	* a multi-line string concatenation embedding
			  	  	  	* a simple string
			  in a string concatenation
		'''.toString, processor.process(node).toString)
	}
	
	@Test def void testIndentVariants() {
		val node = new CompositeGeneratorNode
		node.doIndent(false, false)
		node.doIndent(true, false)
		node.doIndent(false, true)
		node.doIndent(true, true)

		val processor = new GeneratorNodeProcessor
		assertEquals('''
			  // indentImmediately: false, indentEmptyLines: false
			    a
			  
			    bc
			  
			  d
			  // indentImmediately: true, indentEmptyLines: false
			    a
			  
			    b  c
			  
			  d  
			  // indentImmediately: false, indentEmptyLines: true
			    a
			    
			    bc
			    
			  d
			  // indentImmediately: true, indentEmptyLines: true
			    a
			    
			    b  c
			    
			  d  
		'''.toString, processor.process(node).toString)
	}
	
	private def void doIndent(CompositeGeneratorNode parent, boolean indentImmediately, boolean indentEmptyLines) {
		parent.append('// indentImmediately: ').append(indentImmediately)
		parent.append(', indentEmptyLines: ').append(indentEmptyLines).appendNewLine
		parent.append(new IndentNode('  ', indentImmediately, indentEmptyLines).append('a').appendNewLine.appendNewLine.append('b'))
		parent.append(new IndentNode('  ', indentImmediately, indentEmptyLines).append('c')).appendNewLine
		parent.append(new IndentNode('  ', indentImmediately, indentEmptyLines).appendNewLine)
		parent.append('d').append(new IndentNode('  ', indentImmediately, indentEmptyLines).appendNewLine)
	}
	
    private def void assertEquals(String expected, String actual) {
		val expectedM = expected.toString.replaceAll(System.lineSeparator, "\n")
		val actualM = actual.toString.replaceAll(System.lineSeparator, "\n")
		Assert.assertEquals(expectedM, actualM)
	}
	
}