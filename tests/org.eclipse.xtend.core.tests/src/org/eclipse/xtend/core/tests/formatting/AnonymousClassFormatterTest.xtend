package org.eclipse.xtend.core.tests.formatting

import org.junit.Test

import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

class XtendClassFormatterTest extends AbstractXtendFormatterTest {
	@Test def formatConstructor01() {
		assertFormatted([
			put(bracesInNewLine, false)
		],'''
			class bar {
				new() {
				}
			}
		''')	
	}
	
	@Test def formatConstructor02() {
		assertFormatted([
			put(bracesInNewLine, true)
		],'''
			class bar
			{
				new()
				{
				}
			}
		''')	
	}
	
	@Test def formatConstructor1() {
		assertFormatted('''
			class bar {
				new() {
					super()
				}
			}
		''')	
	}
	
	@Test def formatConstructor2() {
		assertFormatted('''
			class bar {
				new(String x) {
					super(x)
				}
			}
		''')	
	}
	
	@Test def formatConstructor3() {
		assertFormatted('''
			class bar {
				new(String x, String y) {
					super(x, y)
				}
			}
		''')	
	}
	
	@Test def formatConstructor4() {
		assertFormatted('''
			package foo

			class bar {
				new(
					String p1,
					String p2,
					String p3,
					String p4,
					String p5
				) {
				}
			}
		''')	
	}
	
	
	
	@Test def formatField01() {
		assertFormatted([
		],'''
			class bar {
				int foo
			}
		''')	
	}
	
	@Test def formatField02() {
		assertFormatted([
		],'''
			class bar {
				int foo
				int baz
			}
		''')	
	}
	
	@Test def formatFieldInit01() {
		assertFormatted([
		],'''
			class bar {
				int foo = 1 + 1
			}
		''')	
	}
	
	@Test def formatFieldInit02() {
		assertFormatted([
		],'''
			class bar {
				int foo = 1 + 1
				int baz = 1 + 1
			}
		''')	
	}
	
	@Test def formatFieldVal() {
		assertFormatted([
		],'''
			class bar {
				val int foo
			}
		''')	
	}
	
	@Test def formatFieldVar() {
		assertFormatted([
		],'''
			class bar {
				var int foo
			}
		''')	
	}
	
	@Test def formatFieldStatic02() {
		assertFormatted([
		],'''
			class bar {
				static int bar
			}
		''')	
	}
	
	@Test def formatFieldStaticVal() {
		assertFormatted([
		],'''
			class bar {
				static val int foo
			}
		''')	
	}
	
	@Test def formatFieldStaticVar() {
		assertFormatted([
		],'''
			class bar {
				static var int foo
			}
		''')	
	}
	
	@Test def formatFieldExtension01() {
		assertFormatted([
		],'''
			class bar {
				extension String
			}
		''')	
	}
	
	@Test def formatFieldExtensionInit01() {
		assertFormatted([
		],'''
			class bar {
				extension String = "a" + "b"
			}
		''')	
	}
	
	@Test def formatFieldExtensionInit02() {
		assertFormatted([
		],'''
			class bar {
				extension String = "a" + "b"
				extension Integer = 1 + 2
			}
		''')	
	}
	
	@Test def formatFieldExtensionVal01() {
		assertFormatted([
		],'''
			class bar {
				extension val String
			}
		''')	
	}
	
	@Test def formatFieldExtensionVar01() {
		assertFormatted([
		],'''
			class bar {
				extension var String
			}
		''')	
	}
	
	@Test def formatFieldExtension02() {
		assertFormatted([
		],'''
			class bar {
				extension String
				extension Integer
			}
		''')	
	}
	
	@Test def formatMethod01() {
		assertFormatted([
			put(bracesInNewLine, false)
		],'''
			package foo
			
			class bar {
				def baz() {
				}
			}
		''')	
	}
	
	@Test def formatMethod02() {
		assertFormatted([
			put(bracesInNewLine, true)
		],'''
			package foo
			
			class bar
			{
				def baz()
				{
				}
			}
		''')	
	}
	
	@Test def formatMethod1() {
		assertFormatted('''
			package foo
			
			class bar {
				def baz(String x) {
				}
			}
		''')	
	}
	
	@Test def formatMethod2() {
		assertFormatted('''
			package foo
			
			class bar {
				def baz(String x, String y) {
				}
			}
		''')	
	}
	
	@Test def formatMethod3() {
		assertFormatted('''
			package foo

			class bar {
				def baz(String p1, String p2, String p3, String p4, String p5, String p6,
					String p7, String p8, String p9, String p10, String p11, String p12,
					String p13, String p14) {
				}
			}
		''')	
	}
	
	@Test def formatMethod4() {
		assertFormatted('''
			package foo

			class bar {
				def baz(
					String p1,
					String p2,
					String p3,
					String p4,
					String p5
				) {
				}
			}
		''')	
	}
	
	@Test def formatAbstractMethod1() {
		assertFormatted('''
			abstract class bar {
				def baz()
			}
		''')	
	}
	
	@Test def formatAbstractMethod2() {
		assertFormatted('''
			abstract class bar {
				def foo()

				def baz()
			}
		''')	
	}
	
	
	@Test def formatMethodMultiline() {
		assertFormatted('''
			package foo
			
			class bar {
				def baz(
					String x,
					String y
				) {
				}
			}
		''', '''
			package foo
			
			class bar {
				def baz(String x, String y
				) {
				}
			}
		''')	
	}
	
	
	@Test def formatMethodAnnotation() {
		assertFormatted('''
			package foo
			
			class bar {
				@Deprecated def baz() {
				}
			}
		''')	
	}
}