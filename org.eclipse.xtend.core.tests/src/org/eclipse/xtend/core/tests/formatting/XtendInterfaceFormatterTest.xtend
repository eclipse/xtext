/*******************************************************************************
 * Copyright (c) 2013, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.formatting

import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.AbstractFormatterTest
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.formatting2.FormatterPreferenceKeys.*
import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
class XtendInterfaceFormatterTest extends AbstractFormatterTest {

	@Test def formatField01() {
		'''
			interface bar {
				int foo
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatField02() {
		'''
			interface bar {
				int foo
				int baz
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldInit01() {
		'''
			interface bar {
				int foo = 1 + 1
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldInit02() {
		'''
			interface bar {
				int foo = 1 + 1
				int baz = 1 + 1
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldVal() {
		'''
			interface bar {
				val int foo
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldFinal() {
		'''
			interface bar {
				final int foo
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldPublicFinal() {
		'''
			interface bar {
				public final int foo
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldStatic02() {
		'''
			interface bar {
				static int bar
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldStatic03() {
		'''
			interface bar {
				public static int bar
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldStaticVal() {
		'''
			interface bar {
				static val int foo
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldStaticFinal() {
		'''
			interface bar {
				static final int foo
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldPublicStaticFinal() {
		'''
			interface bar {
				public static final int foo
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatMethod01() {
		'''
			package foo
			
			interface bar {
				def baz()
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatMethod02() {
		'''
			package foo
			
			interface bar
			{
				def baz()
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, true)]
	}

	@Test def formatMethod03() {
		'''
			package foo
			
			interface bar
			{
				abstract def baz()
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, true)]
	}

	@Test def formatMethod04() {
		'''
			package foo
			
			interface bar
			{
				public abstract def baz()
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, true)]
	}

	@Test def formatMethod1() {
		assertUnformattedEqualsFormatted('''
			package foo
			
			interface bar {
				def baz(String x)
			}
		''')
	}

	@Test def formatMethod2() {
		assertUnformattedEqualsFormatted('''
			package foo
			
			interface bar {
				def baz(String x, String y)
			}
		''')
	}

	@Test def formatMethod3() {
		assertUnformattedEqualsFormatted('''
			package foo

			interface bar {
				def baz(String p1, String p2, String p3, String p4, String p5, String p6,
					String p7, String p8, String p9, String p10, String p11, String p12,
					String p13, String p14)
			}
		''', [put(maxLineWidth, 80)])
	}

	@Test def formatMethod4() {
		assertUnformattedEqualsFormatted('''
			abstract interface bar {
				def foo()

				def baz()
			}
		''')
	}

	@Test def formatMethodMultiline() {
		'''
			package foo
			
			interface bar {
				def baz(String x, String y
				)
			}
		'''.assertFormattedTo('''
			package foo
			
			interface bar {
				def baz(
					String x,
					String y
				)
			}
		''')
	}

	@Test def formatMethodAnnotation() {
		assertUnformattedEqualsFormatted('''
			package foo
			
			interface bar {
				@Deprecated def baz()
			}
		''')
	}
}