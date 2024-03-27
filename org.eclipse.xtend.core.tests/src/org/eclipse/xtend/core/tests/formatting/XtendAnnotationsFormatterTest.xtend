/*******************************************************************************
 * Copyright (c) 2012, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.formatting

import org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtext.preferences.MapBasedPreferenceValues
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.AbstractFormatterTest
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
class XtendAnnotationsFormatterTest extends AbstractFormatterTest {

	private def toFile(CharSequence ann) '''
		package foo
		
		import java.lang.annotation.*
		import com.google.common.annotations.*
		
		«ann»
		class bar {
		}
	'''

	private def assertFormattedAnnotation(CharSequence expectation, CharSequence actual) {
		actual.toFile.assertFormattedTo(expectation.toFile)
	}
	
	@Test def formatClassSingleAnnotationSL() {
		 '''
			package foo @Deprecated class bar { }
		'''.assertFormattedTo('''
			package foo
			
			@Deprecated class bar {
			}
		''', [
			put(newLineAfterClassAnnotations, false)
			put(preserveNewLines, true)
		])
	}

	@Test def formatClassSingleAnnotationML1() {
		'''
			package foo
			
			@Deprecated
			class bar {
			}
		'''.assertUnformattedEqualsFormatted[
			put(newLineAfterClassAnnotations, false)
			put(preserveNewLines, true)			
		]	
	}

	@Test def formatClassSingleAnnotationML11() {
		assertUnformattedEqualsFormatted('''
			package foo
			
			@SuppressWarnings("restriction")
			public class Foo {
			}
		''')	
	}

	@Test def formatClassSingleAnnotationML2() {
		'''
			package foo @Deprecated class bar { }
		'''.assertFormattedTo('''
			package foo
			
			@Deprecated
			class bar {
			}
		''', [
			put(newLineAfterClassAnnotations, true)
			put(preserveNewLines, true)
		])
	}

	@Test def formatClassTwoAnnotationsSL() {
		assertUnformattedEqualsFormatted('''
			package foo
			
			@Override @Deprecated class bar {
			}
		''')	
	}

	@Test def formatClassTwoAnnotationsML1() {
		assertUnformattedEqualsFormatted('''
			package foo
			
			@Override
			@Deprecated
			class bar {
			}
		''')	
	}

	@Test def formatClassTwoAnnotationsML2() {
		assertUnformattedEqualsFormatted('''
			package foo
			
			@Override @Deprecated
			class bar {
			}
		''')	
	}

	@Test def formatConstructorTwoAnnotations1() {
		assertFormattedMember([
			put(newLineAfterConstructorAnnotations, false)
			put(preserveNewLines, true)
		], '''
			@Override
			@Deprecated
			new() {
			}
		''')	
	}

	@Test def formatConstructorTwoAnnotations2() {
		assertFormattedMember([
			put(newLineAfterConstructorAnnotations, true)
			put(preserveNewLines, true)
		], '''
			@Override
			@Deprecated
			new() {
			}
		''')	
	}

	@Test def formatConstructorTwoAnnotationsSL1() {
		assertFormattedMember([
			put(newLineAfterConstructorAnnotations, false)
			put(preserveNewLines, false)
		], '''
			@Override @Deprecated new() {
			}
		''', '''
			@Override 
			@Deprecated 
			new() {
			}
		''')	
	}

	@Test def formatConstructorTwoAnnotationsSL2() {
		assertFormattedMember([
			put(newLineAfterConstructorAnnotations, false)
			put(preserveNewLines, true)
		], '''
			@Override @Deprecated new() {
			}
		''')	
	}

	@Test def formatConstructorSingleAnnotations() {
		'''
			@Deprecated
			new() {
			}
		'''.toMember.assertUnformattedEqualsFormatted	
	}

	@Test def formatConstructorParameterTwoAnnotations() {
		assertFormattedMember('''
			new(@Override @Deprecated String p) {
			}
		''', '''
			new(  @Override  @Deprecated  String  p  ) {  }
		''')	
	}

	@Test def formatConstructorParameterSingleAnnotations() {
		assertFormattedMember('''
			new(@Deprecated String p) {
			}
		''', '''
			new(  @Deprecated  String   p  ) {  }
		''')	
	}
	
	@Test def formatFieldTwoAnnotations1() {
		assertFormattedMember([
			put(newLineAfterFieldAnnotations, true)
			put(preserveNewLines, true)
		],'''
			@Override
			@Deprecated
			int value
		''')	
	}

	@Test def formatFieldTwoAnnotations2() {
		assertFormattedMember([
			put(newLineAfterFieldAnnotations, false)
			put(preserveNewLines, false)
		],'''
			@Override @Deprecated int value
		''')	
	}

	@Test def formatFieldSingleAnnotations1() {
		assertFormattedMember([
			put(newLineAfterFieldAnnotations, true)
			put(preserveNewLines, true)
		],'''
			@Override
			int value
		''')	
	}

	@Test def formatFieldSingleAnnotations2() {
		assertFormattedMember([
			put(newLineAfterFieldAnnotations, false)
			put(preserveNewLines, false)
		],'''
			@Override int value
		''')	
	}

	@Test def formatMethodTwoAnnotations1() {
		assertFormattedMember([
			put(newLineAfterMethodAnnotations, true)
			put(preserveNewLines, true)
		],'''
			@Override
			@Deprecated
			def foo() {
			}
		''')	
	}

	@Test def formatMethodTwoAnnotations2() {
		assertFormattedMember([
			put(newLineAfterMethodAnnotations, true)
			put(preserveNewLines, false)
		],'''
			@Override
			@Deprecated
			def foo() {
			}
		''')	
	}
	
	@Test def formatMethodTwoAnnotations3() {
		assertFormattedMember([
			put(newLineAfterMethodAnnotations, false)
			put(preserveNewLines, true)
		],'''
			@Override
			@Deprecated
			def foo() {
			}
		''')	
	}

	@Test def formatMethodTwoAnnotations4() {
		assertFormattedMember([
			put(XtendFormatterPreferenceKeys.keepOneLineMethods, false)
			put(newLineAfterMethodAnnotations, false)
			put(preserveNewLines, false)
		],'''
			@Override @Deprecated def foo() {
			}
		''', '''
			@Override  
			@Deprecated  
			def foo() {  }
		''')	
	}

	@Test def formatMethodSingleAnnotations() {
		assertFormattedMember('''
			@Deprecated
			def foo() {
			}
		''', '''
			@Deprecated  
			def foo() {  }
		''')	
	}

	@Test def formatMethodParameterTwoAnnotations1() {
		assertFormattedMember([
			put(XtendFormatterPreferenceKeys.keepOneLineMethods, false)
			put(newLineAfterParameterAnnotations, false)
			put(preserveNewLines, true)
		],'''
			def foo(@Override @Deprecated String p) {
			}
		''', '''
			def foo(  @Override  @Deprecated  String  p  ) {  }
		''')	
	}

	@Ignore @Test def formatMethodParameterTwoAnnotations2() {
		assertFormattedMember([
			put(newLineAfterParameterAnnotations, true)
			put(preserveNewLines, true)
		],'''
			def foo(
				@Override
				@Deprecated
				String p) {
			}
		''', '''
			def foo(  @Override  @Deprecated  String  p  ) {  }
		''')	
	}

	@Test def formatMethodParameterSingleAnnotations() {
		assertFormattedMember('''
			def foo(@Deprecated String p) {
			}
		''', '''
			def foo(  @Deprecated  String   p  ) {  }
		''')	
	}

	@Test def formatAnnotationSingeValue() {
		assertFormattedAnnotation('''
			@SuppressWarnings("all")
		''', '''
			@  SuppressWarnings  (  "all"  )
		''')	
	}

	@Test def formatAnnotationListValue3() {
		assertFormattedAnnotation('''
			@SuppressWarnings(#[])
		''', '''
			@SuppressWarnings(#  [  ]  )
		''')	
	}

	@Test def formatAnnotationListValue4() {
		assertFormattedAnnotation('''
			@SuppressWarnings(#["all"])
		''', '''
			@SuppressWarnings(  #  [  "all"  ]  )
		''')	
	}

	@Test def formatAnnotationListValue5() {
		assertFormattedAnnotation('''
			@SuppressWarnings(#["all", "access"])
		''', '''
			@SuppressWarnings( #   [  "all"  ,   "access"  ]  )
		''')	
	}

	@Test def formatAnnotationAssignedSingeValue() {
		assertFormattedAnnotation('''
			@SuppressWarnings(value="all")
		''', '''
			@SuppressWarnings(  value  =  "all"  )
		''')	
	}

	@Test def formatAnnotationAssignedListValue_1() {
		assertFormattedAnnotation('''
			@SuppressWarnings(value=#["all", "access"])
		''', '''
			@SuppressWarnings(  value  =#  [  "all"  ,   "access"  ]  )
		''')	
	}

	@Test def formatAnnotationMultiAssignments() {
		assertFormattedAnnotation('''
			@GwtCompatible(serializable=true, emulated=true)
		''', '''
			@GwtCompatible(  serializable  =  true,  emulated  =  true  )
		''')	
	}

	@Test def formatAnnotationEnumLiteral() {
		assertFormattedAnnotation('''
			@Retention(RetentionPolicy::CLASS)
		''', '''
			@Retention(  RetentionPolicy::  CLASS  )
		''')	
	}

	@Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=393349")
	@Test def formatAnnotationStringConcatenation() {
		assertFormattedAnnotation('''
			@SuppressWarnings(("all" + "more"))
		''', '''
			@  SuppressWarnings  (  (  "all"  +  "more"  )  )
		''')	
	}
	
	private def assertFormattedMember(String expectation, CharSequence toBeFormatted) {
		toBeFormatted.toMember.assertFormattedTo(expectation.toMember, [put(XtendFormatterPreferenceKeys.keepOneLineMethods, false)])
	}

	private def assertFormattedMember((MapBasedPreferenceValues)=>void cfg, String expectation, CharSequence toBeFormatted) {
		toBeFormatted.toMember.assertFormattedTo(expectation.toMember, cfg)
	}

	private def assertFormattedMember((MapBasedPreferenceValues)=>void cfg, String expectation) {
		expectation.toMember.assertUnformattedEqualsFormatted(cfg)
	}

	private def toMember(CharSequence expression) '''
		package foo
		
		class bar {
			«expression»
		}
	'''
}