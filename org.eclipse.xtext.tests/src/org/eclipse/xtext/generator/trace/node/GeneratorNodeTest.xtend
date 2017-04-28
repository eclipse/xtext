/*******************************************************************************
 * Copyright (c) 2017 TypeFox (https://typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
			.append("indented1").appendNewLine
			.append("indented2")
		node.appendNewLine.append("dedented")
		val processor = new GeneratorNodeProcessor()
		val result = processor.process(node)
		Assert.assertEquals('''
			notindented
			  indented1
			  indented2
			dedented'''.toString, result.toString)
		Assert.assertEquals('''
			CompletableTraceRegion [myOffset=0, myLength=44] associations={
			  LocationData [TextRegionWithLineInformation [0:100][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]
			} nestedRegions={
			  CompletableTraceRegion [myOffset=14, myLength=21] associations={
			    LocationData [TextRegionWithLineInformation [1:99][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]
			  }
			}'''.toString, result.traceRegion.toString)
	}
	
	@Test def void testEmptyIndent() {
		val root = loc(0)
		var node = root.trace.append("Hallo").appendNewLine;
		node.indent;
		node.append("noindent").appendNewLine

		val processor = new GeneratorNodeProcessor()
		Assert.assertEquals('''
			Hallo
			noindent
		'''.toString,processor.process(node).toString)
	}
	
	
	@Test def void testTemplateProcessing() {
		val root = loc(0)
		var node = root.trace
			.appendTemplate('''
				«someCodeGen(2)»
			''')
			
		val processor = new GeneratorNodeProcessor()
		val result = processor.process(node)
		Assert.assertEquals(someCodeGen_noTrace(2).toString, result.toString)
		Assert.assertEquals('''
			CompletableTraceRegion [myOffset=0, myLength=80] associations={
			  LocationData [TextRegionWithLineInformation [0:100][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]
			} nestedRegions={
			  CompletableTraceRegion [myOffset=7, myLength=5] associations={
			    LocationData [TextRegionWithLineInformation [10:90][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]
			  }
			  CompletableTraceRegion [myOffset=28, myLength=5] associations={
			    LocationData [TextRegionWithLineInformation [10:90][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]
			  }
			  CompletableTraceRegion [myOffset=47, myLength=5] associations={
			    LocationData [TextRegionWithLineInformation [11:89][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]
			  }
			  CompletableTraceRegion [myOffset=68, myLength=5] associations={
			    LocationData [TextRegionWithLineInformation [10:90][lineNumber=0, endLineNumber=0]][path=foo/mymodel.dsl]
			  }
			}'''.toString, result.traceRegion.toString)
	}
	
	def StringConcatenationClient someCodeGen(int n) '''
		«FOR i : 0..<n»
			before «loc(10+i).trace.append("Hello")» after
			  «someCodeGen(n-1)»
		«ENDFOR»
	'''
	def String someCodeGen_noTrace(int n) '''
		«FOR i : 0..<n»
			before «"Hello"» after
			  «someCodeGen_noTrace(n-1)»
		«ENDFOR»
	'''
	
	def loc(int idx) {
		new LocationData(idx, 100-idx, 0, 0, new SourceRelativeURI("foo/mymodel.dsl"))
	}
	
	@Test def void testAppendVariants() {
		val node = new CompositeGeneratorNode
		val String string = '''* a simple string'''
		node.append(string)
		node.appendNewLine
		val StringConcatenation stringConcat1 = '''
			* a multi-line string concatenation embedding
			  	´stringª
		'''
		node.append(stringConcat1)
		val StringConcatenationClient client = '''
			* a string concatentation client embedding
			  	´stringConcat1ª
		'''
		node.append(client)
		val nestedNode = new CompositeGeneratorNode
		val StringConcatenation stringConcat2 = '''
			* I can even embed
			  	´clientª
			  in a string concatenation
		'''
		nestedNode.append(stringConcat2)
		node.append(nestedNode)

		val processor = new GeneratorNodeProcessor
		Assert.assertEquals('''
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
	
}