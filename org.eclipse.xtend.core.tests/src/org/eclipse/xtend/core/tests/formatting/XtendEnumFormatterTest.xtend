/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
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

import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
class XtendEnumFormatterTest extends AbstractFormatterTest {
	
	@Test def formatPublic() {
		'''
			public enum Bar {
			}
		'''.assertUnformattedEqualsFormatted	
	}
	
	@Test def formatLiteral01() {
		'''
			enum Bar {
				FOO
			}
		'''.assertUnformattedEqualsFormatted
	}
	
	@Test def formatLiteral02() {
		'''
			enum Bar {
				FOO,
				BAR,
				BAZ
			}
		'''.assertUnformattedEqualsFormatted	
	}
	
	@Test def formatLiteral03() {
		'''
			enum Bar {
				FOO,
			
				BAR,
			
				BAZ
			}
		'''.assertUnformattedEqualsFormatted	
	}
	
	@Test def formatBraces_01() {
		'''
			package foo
			
			enum Bar {
			}
		'''.assertUnformattedEqualsFormatted
	}
	
	@Test def formatBraces_02() {
		'''
			package foo
			
			enum Bar
			{
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, true)]	
	}
}