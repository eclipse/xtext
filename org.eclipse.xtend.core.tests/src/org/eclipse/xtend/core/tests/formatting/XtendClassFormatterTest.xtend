/*******************************************************************************
 * Copyright (c) 2012, 2024 itemis AG (http://www.itemis.eu) and others.
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
class XtendClassFormatterTest extends AbstractFormatterTest {

	@Test def formatConstructor01() {
		'''
			class bar {
				new() {
				}
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, false)]
	}

	@Test def formatConstructor02() {
		'''
			class bar
			{
				new()
				{
				}
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, true)]
	}

	@Test def formatConstructor1() {
		'''
			class bar {
				new() {
					super()
				}
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatConstructor2() {
		'''
			class bar {
				new(String x) {
					super(x)
				}
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatConstructor3() {
		'''
			class bar {
				new(String x, String y) {
					super(x, y)
				}
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatConstructor4() {
		'''
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
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatField01() {
		'''
			class bar {
				int foo
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatField02() {
		'''
			class bar {
				int foo
				int baz
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldInit01() {
		'''
			class bar {
				int foo = 1 + 1
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldInit02() {
		'''
			class bar {
				int foo = 1 + 1
				int baz = 1 + 1
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldVal() {
		'''
			class bar {
				val int foo
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldVar() {
		'''
			class bar {
				var int foo
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldStatic02() {
		'''
			class bar {
				static int bar
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldStaticVal() {
		'''
			class bar {
				static val int foo
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldStaticVar() {
		'''
			class bar {
				static var int foo
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldExtension01() {
		'''
			class bar {
				extension String
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldExtensionInit01() {
		'''
			class bar {
				extension String = "a" + "b"
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldExtensionInit02() {
		'''
			class bar {
				extension String = "a" + "b"
				extension Integer = 1 + 2
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldExtensionVal01() {
		'''
			class bar {
				extension val String
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldExtensionVar01() {
		'''
			class bar {
				extension var String
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatFieldExtension02() {
		'''
			class bar {
				extension String
				extension Integer
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatMethod01() {
		'''
			package foo
			
			class bar {
				def baz() {
				}
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, false)]
	}

	@Test def formatMethod02() {
		'''
			package foo
			
			class bar
			{
				def baz()
				{
				}
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, true)]
	}

	@Test def formatMethod1() {
		'''
			package foo
			
			class bar {
				def baz(String x) {
				}
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatMethod2() {
		'''
			package foo
			
			class bar {
				def baz(String x, String y) {
				}
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatMethod3() {
		'''
			package foo

			class bar {
				def baz(String p1, String p2, String p3, String p4, String p5, String p6,
					String p7, String p8, String p9, String p10, String p11, String p12,
					String p13, String p14) {
				}
			}
		'''.assertUnformattedEqualsFormatted[put(maxLineWidth, 80)]
	}

	@Test def formatMethod4() {
		'''
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
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatAbstractMethod1() {
		'''
			abstract class bar {
				def baz()
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatAbstractMethod2() {
		'''
			abstract class bar {
				def foo()

				def baz()
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatMethodMultiline() {
		'''
			package foo

			class bar {
				def baz(String x, String y
				) {
				}
			}
		'''.assertFormattedTo('''
			package foo

			class bar {
				def baz(
					String x,
					String y
				) {
				}
			}
		''')
	}

	@Test def formatMethodAnnotation() {
		'''
			package foo
			
			class bar {
				@Deprecated def baz() {
				}
			}
		'''.assertUnformattedEqualsFormatted
	}
}