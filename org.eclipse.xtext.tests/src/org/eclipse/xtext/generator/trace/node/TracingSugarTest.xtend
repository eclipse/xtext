/*******************************************************************************
 * Copyright (c) 2017 TypeFox (https://typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.generator.trace.ITraceRegionProvider
import org.eclipse.xtext.linking.lazy.lazyLinking.LazyLinkingFactory
import org.eclipse.xtext.linking.lazy.lazyLinking.Model
import org.eclipse.xtext.linking.lazy.lazyLinking.Property
import org.eclipse.xtext.linking.lazy.lazyLinking.Type
import org.eclipse.xtext.linking.lazy.tests.LazyLinkingTestLanguageInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.tests.LineDelimiters
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(LazyLinkingTestLanguageInjectorProvider)
class TracingSugarTest {
	
	@TracedAccessors(LazyLinkingFactory)
	static class MyExtensions {
		
		/**
		 * manual implementation for unsupported multi cross reference
		 */
		def IGeneratorNode _type(Property it, (Type)=>String provider) {
			val location = location(eClass.getEStructuralFeature("type"), 0)
			val result = location.trace
			result.append(provider.apply(type.head))
			return result
		}
	}
	
	@Inject extension MyExtensions
	@Inject ParseHelper<Model> parseHelper
	
	@Test def void testCodeGeneration() {
		val root = parseHelper.parse(LineDelimiters.toUnix('''
			type String {}
			type Foo {
				String name;
			}
		'''))
		val fsa = new InMemoryFileSystemAccess
		fsa.generateTracedFile('foo/bar.txt', root, '''
			«FOR t : root.types»
				«t._generateType»
			«ENDFOR»
		''')
		val generated = fsa.textFiles.get(IFileSystemAccess.DEFAULT_OUTPUT + 'foo/bar.txt')
		
		// check the generated string is as expected
		Assert.assertEquals(LineDelimiters.toUnix('''
			«FOR t : root.types»
				«t.generateType»
			«ENDFOR»
		'''), generated.toString)
		
		val trace = (generated as ITraceRegionProvider).traceRegion
		Assert.assertEquals(LineDelimiters.toUnix('''
			CompletableTraceRegion [myOffset=0, myLength=55, useForDebugging=false] associations={
			  LocationData [TextRegionWithLineInformation [0:41][lineNumber=0, endLineNumber=3]][path=__synthetic0.lazylinkingtestlanguage]
			} nestedRegions={
			  CompletableTraceRegion [myOffset=0, myLength=17, useForDebugging=false] associations={
			    LocationData [TextRegionWithLineInformation [0:14][lineNumber=0, endLineNumber=0]][path=__synthetic0.lazylinkingtestlanguage]
			  } nestedRegions={
			    CompletableTraceRegion [myOffset=6, myLength=6, useForDebugging=false] associations={
			      LocationData [TextRegionWithLineInformation [5:6][lineNumber=0, endLineNumber=0]][path=__synthetic0.lazylinkingtestlanguage]
			    }
			  }
			  CompletableTraceRegion [myOffset=17, myLength=38, useForDebugging=false] associations={
			    LocationData [TextRegionWithLineInformation [15:26][lineNumber=1, endLineNumber=3]][path=__synthetic0.lazylinkingtestlanguage]
			  } nestedRegions={
			    CompletableTraceRegion [myOffset=23, myLength=3, useForDebugging=false] associations={
			      LocationData [TextRegionWithLineInformation [20:3][lineNumber=1, endLineNumber=1]][path=__synthetic0.lazylinkingtestlanguage]
			    }
			    CompletableTraceRegion [myOffset=30, myLength=24, useForDebugging=false] associations={
			      LocationData [TextRegionWithLineInformation [27:12][lineNumber=2, endLineNumber=2]][path=__synthetic0.lazylinkingtestlanguage]
			    } nestedRegions={
			      CompletableTraceRegion [myOffset=39, myLength=4, useForDebugging=false] associations={
			        LocationData [TextRegionWithLineInformation [34:4][lineNumber=2, endLineNumber=2]][path=__synthetic0.lazylinkingtestlanguage]
			      }
			      CompletableTraceRegion [myOffset=46, myLength=6, useForDebugging=false] associations={
			        LocationData [TextRegionWithLineInformation [27:6][lineNumber=2, endLineNumber=2]][path=__synthetic0.lazylinkingtestlanguage]
			      }
			    }
			  }
			}'''), trace.toString)
	}
	
	@Test def void testCodeGenerationWithDebug() {
		val root = parseHelper.parse(LineDelimiters.toUnix('''
			type String {}
			type Foo {
				String name;
			}
		'''))
		val fsa = new InMemoryFileSystemAccess
		fsa.generateTracedFile('foo/bar.txt', root, '''
			«FOR t : root.types»
				«t._generateTypeWithDebugging»
			«ENDFOR»
		''')
		val generated = fsa.textFiles.get(IFileSystemAccess.DEFAULT_OUTPUT + 'foo/bar.txt')
		
		// check the generated string is as expected
		Assert.assertEquals(LineDelimiters.toUnix('''
			«FOR t : root.types»
				«t.generateTypeWithDebugging»
			«ENDFOR»
		'''), generated.toString)
		
		val trace = (generated as ITraceRegionProvider).traceRegion
		Assert.assertEquals(LineDelimiters.toUnix('''
			CompletableTraceRegion [myOffset=0, myLength=55, useForDebugging=false] associations={
			  LocationData [TextRegionWithLineInformation [0:41][lineNumber=0, endLineNumber=3]][path=__synthetic0.lazylinkingtestlanguage]
			} nestedRegions={
			  CompletableTraceRegion [myOffset=0, myLength=17, useForDebugging=true] associations={
			    LocationData [TextRegionWithLineInformation [0:14][lineNumber=0, endLineNumber=0]][path=__synthetic0.lazylinkingtestlanguage]
			  } nestedRegions={
			    CompletableTraceRegion [myOffset=6, myLength=6, useForDebugging=false] associations={
			      LocationData [TextRegionWithLineInformation [5:6][lineNumber=0, endLineNumber=0]][path=__synthetic0.lazylinkingtestlanguage]
			    }
			  }
			  CompletableTraceRegion [myOffset=17, myLength=38, useForDebugging=true] associations={
			    LocationData [TextRegionWithLineInformation [15:26][lineNumber=1, endLineNumber=3]][path=__synthetic0.lazylinkingtestlanguage]
			  } nestedRegions={
			    CompletableTraceRegion [myOffset=23, myLength=3, useForDebugging=false] associations={
			      LocationData [TextRegionWithLineInformation [20:3][lineNumber=1, endLineNumber=1]][path=__synthetic0.lazylinkingtestlanguage]
			    }
			    CompletableTraceRegion [myOffset=30, myLength=24, useForDebugging=false] associations={
			      LocationData [TextRegionWithLineInformation [27:12][lineNumber=2, endLineNumber=2]][path=__synthetic0.lazylinkingtestlanguage]
			    } nestedRegions={
			      CompletableTraceRegion [myOffset=39, myLength=4, useForDebugging=false] associations={
			        LocationData [TextRegionWithLineInformation [34:4][lineNumber=2, endLineNumber=2]][path=__synthetic0.lazylinkingtestlanguage]
			      }
			      CompletableTraceRegion [myOffset=46, myLength=6, useForDebugging=false] associations={
			        LocationData [TextRegionWithLineInformation [27:6][lineNumber=2, endLineNumber=2]][path=__synthetic0.lazylinkingtestlanguage]
			      }
			    }
			  }
			}'''), trace.toString)
	}
	
	@Test def void testCodeGenerationWithDebug_02() {
		val root = parseHelper.parse(LineDelimiters.toUnix('''
			type String {}
			type Foo {
				String name;
			}
		'''))
		val fsa = new InMemoryFileSystemAccess
		fsa.generateTracedFile('foo/bar.txt', root, '''
			«FOR t : root.types»
				«t._generateTypeWithDebugging02»
			«ENDFOR»
		''')
		val generated = fsa.textFiles.get(IFileSystemAccess.DEFAULT_OUTPUT + 'foo/bar.txt')
		
		// check the generated string is as expected
		Assert.assertEquals(LineDelimiters.toUnix('''
			«FOR t : root.types»
				«t.generateTypeWithDebugging»
			«ENDFOR»
		'''), generated.toString)
		
		val trace = (generated as ITraceRegionProvider).traceRegion
		Assert.assertEquals(LineDelimiters.toUnix('''
			CompletableTraceRegion [myOffset=0, myLength=55, useForDebugging=false] associations={
			  LocationData [TextRegionWithLineInformation [0:41][lineNumber=0, endLineNumber=3]][path=__synthetic0.lazylinkingtestlanguage]
			} nestedRegions={
			  CompletableTraceRegion [myOffset=0, myLength=17, useForDebugging=false] associations={
			    LocationData [TextRegionWithLineInformation [0:14][lineNumber=0, endLineNumber=0]][path=__synthetic0.lazylinkingtestlanguage]
			  } nestedRegions={
			    CompletableTraceRegion [myOffset=6, myLength=6, useForDebugging=false] associations={
			      LocationData [TextRegionWithLineInformation [5:6][lineNumber=0, endLineNumber=0]][path=__synthetic0.lazylinkingtestlanguage]
			    }
			  }
			  CompletableTraceRegion [myOffset=17, myLength=38, useForDebugging=false] associations={
			    LocationData [TextRegionWithLineInformation [15:26][lineNumber=1, endLineNumber=3]][path=__synthetic0.lazylinkingtestlanguage]
			  } nestedRegions={
			    CompletableTraceRegion [myOffset=23, myLength=3, useForDebugging=false] associations={
			      LocationData [TextRegionWithLineInformation [20:3][lineNumber=1, endLineNumber=1]][path=__synthetic0.lazylinkingtestlanguage]
			    }
			    CompletableTraceRegion [myOffset=30, myLength=24, useForDebugging=true] associations={
			      LocationData [TextRegionWithLineInformation [27:12][lineNumber=2, endLineNumber=2]][path=__synthetic0.lazylinkingtestlanguage]
			    } nestedRegions={
			      CompletableTraceRegion [myOffset=39, myLength=4, useForDebugging=true] associations={
			        LocationData [TextRegionWithLineInformation [34:4][lineNumber=2, endLineNumber=2]][path=__synthetic0.lazylinkingtestlanguage]
			      }
			      CompletableTraceRegion [myOffset=46, myLength=6, useForDebugging=false] associations={
			        LocationData [TextRegionWithLineInformation [27:6][lineNumber=2, endLineNumber=2]][path=__synthetic0.lazylinkingtestlanguage]
			      }
			    }
			  }
			}'''), trace.toString)
	}
	
	@Traced def _generateType(Type it) '''
		Class «_name» {
			«FOR p : properties»
				«p._generateProperty»
			«ENDFOR»
		}
	'''
	
	@Traced(useForDebugging=true) def _generateTypeWithDebugging(Type it) '''
		Class «_name» {
			«FOR p : properties»
				«p._generateProperty»
			«ENDFOR»
		}
	'''
	
	@Traced def _generateTypeWithDebugging02(Type it) '''
		Class «_name» {
			«FOR p : properties»
				«p._generatePropertyWithDebugging»
			«ENDFOR»
		}
	'''
	
	@Traced def _generateProperty(Property it) '''
		Property «_name» : «_type[name]»
	'''
	
	@Traced(useForDebugging=true) def _generatePropertyWithDebugging(Property it) '''
		Property «_name(true)» : «_type[name]»
	'''
	
	def generateType(Type it) '''
		Class «name» {
			«FOR p : properties»
				«p.generateProperty»
			«ENDFOR»
		}
	'''
	
	def generateTypeWithDebugging(Type it) '''
		Class «name» {
			«FOR p : properties»
				«p.generateProperty»
			«ENDFOR»
		}
	'''
	
	def generateProperty(Property it) '''
		Property «name» : «type.head.name»
	'''
	
}