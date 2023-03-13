/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
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