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
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
class XtendAnnotationTypeFormatterTest extends AbstractFormatterTest {

	@Test def formatPublic() {
		'''
			public annotation Bar {
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatAbstract() {
		'''
			abstract annotation Bar {
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatPublicAbstract() {
		'''
			public abstract annotation Bar {
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatField01() {
		'''
			annotation Bar {
				int foo
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatField02() {
		'''
			annotation Bar {
				int foo
				int baz
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Ignore
	@Test def formatFieldInit01() {
		'''
			annotation Bar {
				int foo = 1 + 1
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Ignore
	@Test def formatFieldInit02() {
		'''
			annotation Bar {
				int foo = 1 + 1
				int baz = 1 + 1
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Ignore
	@Test def formatFieldInit03() {
		'''
			annotation Bar {
				val foo = 1 + 1
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Ignore
	@Test def formatFieldInit04() {
		'''
			annotation Bar {
				val foo = 1 + 1
				val baz = 1 + 1
			}
		'''.assertUnformattedEqualsFormatted
	}

	@Test def formatBraces_01() {
		'''
			package foo
			
			annotation Bar {
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, false)]
	}

	@Test def formatBraces_02() {
		'''
			package foo
			
			annotation Bar
			{
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, true)]
	}

	@Test def formatFieldAnnotation() {
		'''
			package foo
			
			annotation Bar {
				@Deprecated int baz
			}
		'''.assertUnformattedEqualsFormatted
	}
}