package org.eclipse.xtend.core.tests.formatting

import org.junit.Test

class XtendFormatterBugTests extends AbstractXtendFormatterTest {

	@Test
	def testBug398718(){
		assertFormatted('''
			package foo

			class bar {
				def testVisibilityOfDispatchMethods() {
					```
						package foo;

						import java.util.Arrays;

						@SuppressWarnings("all")
						public class NoSuchElementException {

						  }
						}
					```

				}
			}
		'''.decode, '''
			package foo
			class bar {
				def testVisibilityOfDispatchMethods() {
					```
					package foo;

					import java.util.Arrays;

					@SuppressWarnings("all")
					public class NoSuchElementException {

					  }
					}
					```

					}
			}
		'''.decode)
	}
}