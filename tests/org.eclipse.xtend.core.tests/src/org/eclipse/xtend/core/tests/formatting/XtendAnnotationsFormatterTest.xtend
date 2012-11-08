package org.eclipse.xtend.core.tests.formatting

import org.junit.Test
import org.junit.Ignore
import org.eclipse.xtend.core.formatting.XtendFormatterConfigKeys
import com.google.inject.Inject

class XtendAnnotationsFormatterTest extends AbstractFormatterTest {
	
	@Inject extension XtendFormatterConfigKeys
	
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
			put(newLineAfterClassAnnotations, false)
			put(preserveNewLines, true)
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
	
	@Test def formatClassSingleAnnotationML2() {
		assertFormatted([
			put(newLineAfterClassAnnotations, true)
			put(preserveNewLines, true)
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
	
	@Test def formatMethodParameterTwoAnnotations2() {
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
	
	@Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=393343")
	@Test def formatAnnotationListValue0() {
		assertFormattedAnnotation('''
			@SuppressWarnings({})
		''', '''
			@SuppressWarnings(  {  }  )
		''')	
	}
	
	@Test def formatAnnotationListValue1() {
		assertFormattedAnnotation('''
			@SuppressWarnings({"all"})
		''', '''
			@SuppressWarnings(  {  "all"  }  )
		''')	
	}
	
	@Test def formatAnnotationListValue2() {
		assertFormattedAnnotation('''
			@SuppressWarnings({"all", "access"})
		''', '''
			@SuppressWarnings(  {  "all"  ,   "access"  }  )
		''')	
	}
	
	@Test def formatAnnotationAssignedSingeValue() {
		assertFormattedAnnotation('''
			@SuppressWarnings(value="all")
		''', '''
			@SuppressWarnings(  value  =  "all"  )
		''')	
	}
	
	@Test def formatAnnotationAssignedListValue() {
		assertFormattedAnnotation('''
			@SuppressWarnings(value={"all", "access"})
		''', '''
			@SuppressWarnings(  value  =  {  "all"  ,   "access"  }  )
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