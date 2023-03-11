/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.formatting

import org.junit.Test

import static org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys.*
import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

class XtendEnumFormatterTest extends AbstractXtendFormatterTest {
	
	@Test def formatPublic() {
		assertFormatted([
		],'''
			public enum Bar {
			}
		''')	
	}
	
	@Test def formatLiteral01() {
		assertFormatted([
		],'''
			enum Bar {
				FOO
			}
		''')	
	}
	
	@Test def formatLiteral02() {
		assertFormatted([
		],'''
			enum Bar {
				FOO,
				BAR,
				BAZ
			}
		''')	
	}
	
	@Test def formatLiteral03() {
		assertFormatted([
			put(blankLinesBetweenEnumLiterals, 1)
		],'''
			enum Bar {
				FOO,
			
				BAR,
			
				BAZ
			}
		''')	
	}
	
	@Test def formatBraces_01() {
		assertFormatted([
			put(bracesInNewLine, false)
		],'''
			package foo
			
			enum Bar {
			}
		''')	
	}
	
	@Test def formatBraces_02() {
		assertFormatted([
			put(bracesInNewLine, true)
		],'''
			package foo
			
			enum Bar
			{
			}
		''')	
	}
}