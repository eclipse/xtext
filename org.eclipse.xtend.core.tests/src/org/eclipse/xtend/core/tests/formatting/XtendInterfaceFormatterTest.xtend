package org.eclipse.xtend.core.tests.formatting

import org.junit.Test

import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

class XtendInterfaceFormatterTest extends AbstractXtendFormatterTest {
	
	@Test def formatField01() {
		assertFormatted([
		],'''
			interface bar {
				int foo
			}
		''')	
	}
	
	@Test def formatField02() {
		assertFormatted([
		],'''
			interface bar {
				int foo
				int baz
			}
		''')	
	}
	
	@Test def formatFieldInit01() {
		assertFormatted([
		],'''
			interface bar {
				int foo = 1 + 1
			}
		''')	
	}
	
	@Test def formatFieldInit02() {
		assertFormatted([
		],'''
			interface bar {
				int foo = 1 + 1
				int baz = 1 + 1
			}
		''')	
	}
	
	@Test def formatFieldVal() {
		assertFormatted([
		],'''
			interface bar {
				val int foo
			}
		''')	
	}
	
	@Test def formatFieldFinal() {
		assertFormatted([
		],'''
			interface bar {
				final int foo
			}
		''')	
	}
	
	@Test def formatFieldPublicFinal() {
		assertFormatted([
		],'''
			interface bar {
				public final int foo
			}
		''')	
	}
	
	@Test def formatFieldStatic02() {
		assertFormatted([
		],'''
			interface bar {
				static int bar
			}
		''')	
	}
	
	@Test def formatFieldStatic03() {
		assertFormatted([
		],'''
			interface bar {
				public static int bar
			}
		''')	
	}
	
	@Test def formatFieldStaticVal() {
		assertFormatted([
		],'''
			interface bar {
				static val int foo
			}
		''')	
	}
	
	@Test def formatFieldStaticFinal() {
		assertFormatted([
		],'''
			interface bar {
				static final int foo
			}
		''')	
	}
	
	@Test def formatFieldPublicStaticFinal() {
		assertFormatted([
		],'''
			interface bar {
				public static final int foo
			}
		''')	
	}
	
	@Test def formatMethod01() {
		assertFormatted([
			put(bracesInNewLine, false)
		],'''
			package foo
			
			interface bar {
				def baz()
			}
		''')	
	}
	
	@Test def formatMethod02() {
		assertFormatted([
			put(bracesInNewLine, true)
		],'''
			package foo
			
			interface bar
			{
				def baz()
			}
		''')	
	}
	
	@Test def formatMethod03() {
		assertFormatted([
			put(bracesInNewLine, true)
		],'''
			package foo
			
			interface bar
			{
				abstract def baz()
			}
		''')	
	}
	
	@Test def formatMethod04() {
		assertFormatted([
			put(bracesInNewLine, true)
		],'''
			package foo
			
			interface bar
			{
				public abstract def baz()
			}
		''')	
	}
	
	@Test def formatMethod1() {
		assertFormatted('''
			package foo
			
			interface bar {
				def baz(String x)
			}
		''')	
	}
	
	@Test def formatMethod2() {
		assertFormatted('''
			package foo
			
			interface bar {
				def baz(String x, String y)
			}
		''')	
	}
	
	@Test def formatMethod3() {
		assertFormatted('''
			package foo

			interface bar {
				def baz(String p1, String p2, String p3, String p4, String p5, String p6,
					String p7, String p8, String p9, String p10, String p11, String p12,
					String p13, String p14)
			}
		''')	
	}
		
	@Test def formatMethod4() {
		assertFormatted('''
			abstract interface bar {
				def foo()

				def baz()
			}
		''')	
	}
	
	
	@Test def formatMethodMultiline() {
		assertFormatted('''
			package foo
			
			interface bar {
				def baz(
					String x,
					String y
				)
			}
		''', '''
			package foo
			
			interface bar {
				def baz(String x, String y
				)
			}
		''')	
	}
	
	
	@Test def formatMethodAnnotation() {
		assertFormatted('''
			package foo
			
			interface bar {
				@Deprecated def baz()
			}
		''')	
	}
}