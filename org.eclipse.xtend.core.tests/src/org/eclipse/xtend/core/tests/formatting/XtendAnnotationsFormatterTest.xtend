package org.eclipse.xtend.core.tests.formatting

import org.junit.Ignore
import org.junit.Test

import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

class XtendAnnotationsFormatterTest extends AbstractXtendFormatterTest {
	
	def protected toFile(CharSequence ann) '''
		package foo
		
		import java.lang.annotation.*
		import com.google.common.annotations.*
		
		«ann»
		class bar {
		}
	'''
	
	def protected assertFormattedAnnotation(CharSequence expectation, CharSequence actual) {
		assertFormatted(expectation.toFile, actual.toFile)
	}
	
	@Test def formatClassSingleAnnotationSL() {
		assertFormatted([
			it.put(newLineAfterClassAnnotations, false)
			it.put(preserveNewLines, true)
		], '''
			package foo
			
			@Deprecated class bar {
			}
		''', '''
			package foo @Deprecated class bar { }
		''')	
	}
	
	@Test def formatClassSingleAnnotationML1() {
		assertFormatted([
			put(newLineAfterClassAnnotations, false)
			put(preserveNewLines, true)
		],'''
			package foo
			
			@Deprecated
			class bar {
			}
		''')	
	}
	
	@Test def formatClassSingleAnnotationML11() {
		assertFormatted('''
			package foo
			
			@SuppressWarnings("restriction")
			public class Foo {
			}
		''')	
	}
	
	@Test def formatClassSingleAnnotationML2() {
		assertFormatted([
			it.put(newLineAfterClassAnnotations, true)
			it.put(preserveNewLines, true)
		],'''
			package foo
			
			@Deprecated
			class bar {
			}
		''', '''
			package foo @Deprecated class bar { }
		''')	
	}
	
	@Test def formatClassTwoAnnotationsSL() {
		assertFormatted('''
			package foo
			
			@Override @Deprecated class bar {
			}
		''')	
	}
	
	@Test def formatClassTwoAnnotationsML1() {
		assertFormatted('''
			package foo
			
			@Override
			@Deprecated
			class bar {
			}
		''')	
	}
	
	@Test def formatClassTwoAnnotationsML2() {
		assertFormatted('''
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
		assertFormattedMember('''
			@Deprecated
			new() {
			}
		''')	
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
	
	
		
	
}