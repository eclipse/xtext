/*******************************************************************************
 * Copyright (c) 2017 TypeFox (https://typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

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
}