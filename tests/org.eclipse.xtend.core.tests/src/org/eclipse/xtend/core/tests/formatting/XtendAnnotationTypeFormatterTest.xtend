package org.eclipse.xtend.core.tests.formatting

import org.junit.Ignore
import org.junit.Test

import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

class XtendAnnotationTypeFormatterTest extends AbstractXtendFormatterTest {
	@Test def formatPublic() {
		assertFormatted([
		],'''
			public annotation Bar {
			}
		''')	
	}
	
	@Test def formatAbstract() {
		assertFormatted([
		],'''
			abstract annotation Bar {
			}
		''')	
	}
	
	@Test def formatPublicAbstract() {
		assertFormatted([
		],'''
			public abstract annotation Bar {
			}
		''')	
	}
	
	@Test def formatField01() {
		assertFormatted([
		],'''
			annotation Bar {
				int foo
			}
		''')	
	}
	
	@Test def formatField02() {
		assertFormatted([
		],'''
			annotation Bar {
				int foo
				int baz
			}
		''')	
	}
	
	@Ignore
	@Test def formatFieldInit01() {
		assertFormatted([
		],'''
			annotation Bar {
				int foo = 1 + 1
			}
		''')	
	}
	
	@Ignore
	@Test def formatFieldInit02() {
		assertFormatted([
		],'''
			annotation Bar {
				int foo = 1 + 1
				int baz = 1 + 1
			}
		''')	
	}
	
	@Ignore
	@Test def formatFieldInit03() {
		assertFormatted([
		],'''
			annotation Bar {
				val foo = 1 + 1
			}
		''')	
	}
	
	@Ignore
	@Test def formatFieldInit04() {
		assertFormatted([
		],'''
			annotation Bar {
				val foo = 1 + 1
				val baz = 1 + 1
			}
		''')	
	}
	
	@Test def formatBraces_01() {
		assertFormatted([
			put(bracesInNewLine, false)
		],'''
			package foo
			
			annotation Bar {
			}
		''')	
	}
	
	@Test def formatBraces_02() {
		assertFormatted([
			put(bracesInNewLine, true)
		],'''
			package foo
			
			annotation Bar
			{
			}
		''')	
	}
	
	@Test def formatFieldAnnotation() {
		assertFormatted('''
			package foo
			
			annotation Bar {
				@Deprecated int baz
			}
		''')	
	}
}