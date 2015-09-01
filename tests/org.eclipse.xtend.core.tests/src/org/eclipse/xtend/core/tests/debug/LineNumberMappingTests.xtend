package org.eclipse.xtend.core.tests.debug

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.trace.AbstractTraceRegion
import org.eclipse.xtext.generator.trace.ITraceRegionProvider
import org.eclipse.xtext.generator.trace.LineMappingProvider
import org.eclipse.xtext.generator.trace.LineMappingProvider.LineMapping
import org.junit.Test

class LineNumberMappingTests extends AbstractXtendTestCase {
	
	@Inject IGenerator generator
	@Inject LineMappingProvider lineMappingProvider
	
	@Test
	def void testLineMapping_01() {
		assertLineNumbers('''
		package foo
		
		class Test {
			
			def void doStuff() {
				println( // 7
					"Hello World") // 8
			}
		}
		''')
	}
	
	@Test
	def void testLineMapping_02() {
		assertLineNumbers('''
		package foo
		
		class Test {
			
			def void doStuff() {
				println("Hello World") // 7
			}
		}
		''')
	}
	
	@Test
	def void testLineMapping_03() {
		assertLineNumbers('''
		package foo
		
		class Test {
			
			def void doStuff() {
				println( // 9
					new String( // 7
						"Hello World")) // 8
			}
		}
		''')
	}
	
	@Test
	def void testLineMapping_04() {
		assertLineNumbers('''
		package foo
		
		class Test {
			
			def void doStuff() {
				println(new String("Hello World")) // 7..8
			}
		}
		''')
	}
	
	@Test
	def void testLineMapping_05() {
		assertLineNumbers('''
		package foo
		
		class Test {
			
			def void doStuff() {
				switch x : "Hello" as Object { 		// 7..8
					String case x.length > 4 : { 	// 9..14
						println(					// 17
							"It's a long one " 		// 16
								+ x.length)			// 15
					}
				}
			}
		}
		''')
	}
	
	@Test
	def void testLineMapping_06() {
		assertLineNumbers('''
		package foo
		
		class Test {
			
			def void doStuff() {
				println(		// 7
					'foo' 		// 8
					+ 'bar')	// 8
			}
		}
		''')
	}
	
	@Test
	def void testLineMapping_07() {
		assertLineNumbers('''
		package foo
		
		class Test {
			
			def void doStuff() {
				foo(		// 6
					new Object())	// 5
			}
			def void foo(Object x) {
			}
		}
		''')
	}
	
	@Test
	def void testLineMapping_08() {
		assertLineNumbers('''
		package foo
		
		class Test {
			
			def void doStuff() {
				switch x : "Hello" { 		// 5..6
					String 					// 7..8
						case 
							x.length > 4 : {// 9..11
						null			// 13
					}
				}
			}
		}
		''')
	}
	
	// TODO the mapping of the decl to line 18 should be fixed
	@Test
	def void testLineMapping_09() {
		assertLineNumbers('''
		package foo
		
		class Test {
			
			def Object doStuff() { // 18 
				switch x : "Hello" { 		// 5..7
					String 					// 8..9
						case 
							x.length > 4 : {// 10..12
						null			// 14
					}
				}
			}
		}
		''')
	}
	
	def assertLineNumbers(CharSequence xtendCodeWithLineNumbers) {
		val region = xtendCodeWithLineNumbers.traceRegion
		val normalizedMappings = lineMappingProvider.getLineMapping(region)
		val lines = xtendCodeWithLineNumbers.toString.split('\n')
		for (lineNumber : 0..lines.size-1) {
			val mapping = findMapping(normalizedMappings, lineNumber)
			val line = lines.get(lineNumber)
			if (mapping != null) {
				if (line.indexOf("//") == -1) {
					fail('''Line «lineNumber» is mapped to «mapping.targetStartLine»('«line»')'''.toString)
				}
				val expectation = line.substring(line.indexOf('//')+2).trim
				var expTargetStart = -1
				var expTargetEnd = -1
				if (expectation.indexOf('..') != -1) {
					val idx = expectation.indexOf('..')
					expTargetStart = Integer::parseInt(expectation.substring(0, idx))
					expTargetEnd = Integer::parseInt(expectation.substring(idx+2))
				} else {
					expTargetStart = expTargetEnd = Integer::parseInt(expectation)
				}
				assertEquals(line, expTargetStart, mapping.targetStartLine)
				assertEquals("unexpected end in line : " + line, expTargetEnd, mapping.targetEndLine)
			} else if (line.indexOf('//') != -1){
				fail("Unmatched expectation : "+line)
			}
		}
	}
	
	def findMapping(List<LineMapping> mappings, Integer sourceLine) {
		for (m : mappings) {
			if (m.sourceStartLine == sourceLine+1)
				return m
		}
		return null
	}
	
	def AbstractTraceRegion getTraceRegion(CharSequence xtendCode) {
		val clazz = super.clazz(xtendCode.toString)
		val fsa = new AbstractTraceRegionFSA()
		// test without issues attached on purpose
		generator.doGenerate(clazz.eResource, fsa)
		val result = (fsa.charSequence as ITraceRegionProvider).traceRegion
		result.print(fsa.charSequence.toString)
		return result 
	}
	
	def void print(AbstractTraceRegion provider, String code) {
//		println(provider.getAnnotatedString(code))
	}
}