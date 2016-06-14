package org.eclipse.xtend.core.tests.formatting

import org.junit.Test

import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

class AnonymousClassFormatterTest extends AbstractXtendFormatterTest {

	@Test def formatSingleMember() {
		assertFormatted([
			put(bracesInNewLine, false)
		],'''
			class Foo {
				val foo = new Runnable() {
					override run() {
					}
				}
			}
		''')	
	}
	
	@Test def formatMultiMember() {
		assertFormatted([
			put(bracesInNewLine, false)
		],'''
			class Foo {
				val foo = new Runnable() {
					int bar
			
					override run() {
					}
			
					def foo(String x) {
					}
				}
			}
		''')	
	}

	@Test def formatTypeParam() {
		assertFormatted([
			put(bracesInNewLine, false)
		],'''
			class Foo {
				val foo = new Iterable<String>() {
					override iterator() {
						null
					}
				}
			}
		''')	
	}

	@Test def formatNested() {
		assertFormatted([
			put(bracesInNewLine, false)
		],'''
			import java.util.Iterator

			class Foo {
				val foo = new Iterable<String>() {
					override iterator() {
						new Iterator<String>() {
							override hasNext() {
								true
							}
			
							override next() {
								null
							}
			
							override remove() {
							}
						}
					}
				}
			}
		''')	
	}
}