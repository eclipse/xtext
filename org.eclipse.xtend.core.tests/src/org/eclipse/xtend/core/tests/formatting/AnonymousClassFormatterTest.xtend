/*******************************************************************************
 * Copyright (c) 2014, 2024 itemis AG (http://www.itemis.eu) and others.
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
class AnonymousClassFormatterTest extends AbstractFormatterTest {

	@Test def formatSingleMember() {
		'''
			class Foo {
				val foo = new Runnable() {
					override run() {
					}
				}
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, false)]
	}

	@Test def formatMultiMember() {
		'''
			class Foo {
				val foo = new Runnable() {
					int bar
			
					override run() {
					}
			
					def foo(String x) {
					}
				}
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, false)]
	}

	@Test def formatTypeParam() {
		'''
			class Foo {
				val foo = new Iterable<String>() {
					override iterator() {
						null
					}
				}
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, false)]
	}

	@Test def formatNested() {
		'''
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
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, false)]
	}
}