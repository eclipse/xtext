/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
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