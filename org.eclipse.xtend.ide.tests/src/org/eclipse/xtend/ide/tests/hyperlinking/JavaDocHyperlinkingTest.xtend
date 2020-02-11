/*******************************************************************************
 * Copyright (c) 2018, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.hyperlinking

import org.eclipse.jface.text.hyperlink.IHyperlink
import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractHyperlinkingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.createJavaProject

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtendIDEInjectorProvider)
class JavaDocHyperlinkingTest extends AbstractHyperlinkingTest {

	@Before def void setup() {
		/*
		 * Xbase-based languages require java project
		 */
		projectName.createJavaProject
	}

	@Test def import_statement() {
		'''
			import «c»java.util.Date«c»
			
			class Foo {
				Date date
			}
		'''.hasHyperlinkToJavaDate
	}

	@Test def member_type() {
		'''
			import java.util.Date
			
			/**
			 * {@link java.util.Date}
			 */
			class Foo {
				«c»Date«c» date
			}
		'''.hasHyperlinkToJavaDate
	}

	@Test def multi_line_comment_link() {
		'''
			import java.util.Date
			
			/*
			 * {@link «c»Date«c»}
			 */
			class Foo {
			}
		'''.hasHyperlinkToJavaDate
	}

	@Test def multi_line_comment_see() {
		'''
			import java.util.Date
			
			/*
			 * @see «c»Date«c»
			 */
			class Foo {
			}
		'''.hasHyperlinkToJavaDate
	}

	@Test def javadoc_link_no_hyperlink_if_the_type_cannot_be_resolved() {
		'''
			/**
			 * {@link «c»Date«c»}
			 */
			class Foo {
			}
		'''.hasNoHyperlink
	}

	@Test def javadoc_see_no_hyperlink_if_the_type_cannot_be_resolved() {
		'''
			/**
			 * @see «c»Date«c»
			 */
			class Foo {
			}
		'''.hasNoHyperlink
	}

	@Test def javadoc_link01() {
		'''
			import java.util.Date
			
			/**
			 * {@link «c»java.util.Date«c»}
			 */
			class Foo {
				Date date
			}
		'''.hasHyperlinkToJavaDate
	}

	@Test def javadoc_link02() {
		'''
			/**
			 * {@link «c»java.util.Date«c»}
			 * {@link java.lang.StringBuffer}
			 */
			class Foo {
			}
		'''.hasHyperlinkToJavaDate
	}

	@Test def javadoc_link03() {
		'''
			/**
			 * {@link java.lang.StringBuffer}
			 * {@link «c»java.util.Date«c»}
			 */
			class Foo {
			}
		'''.hasHyperlinkToJavaDate
	}

	@Test def javadoc_link04() {
		'''
			import java.util.Date
			
			/**
			 * {@link «c»Date«c»}
			 */
			class Foo {
				Date date
			}
		'''.hasHyperlinkToJavaDate
	}

	@Test def javadoc_link05() {
		'''
			import java.util.Date
			
			class Foo {
				
				/**
				 * {@link «c»Date«c»}
				 */
				val a = 1
			}
		'''.hasHyperlinkToJavaDate
	}

	@Test def javadoc_link06() {
		'''
			import java.util.Date
			
			class A {
				Date date
			}
			
			/**
			 * {@link «c»Date«c»}
			 */
		'''.hasHyperlinkToJavaDate
	}

	@Test def javadoc_link07() {
		'''
			import java.util.Date
			/**
			 * {@link «c»Date«c»}
			 */
		'''.hasHyperlinkToJavaDate
	}

	@Test def javadoc_see01() {
		'''
			import java.util.Date
			
			/**
			 * @see «c»java.util.Date«c»
			 */
			class Foo {
				Date date
			}
		'''.hasHyperlinkToJavaDate
	}

	@Test def javadoc_see02() {
		'''
			/**
			 * @see «c»java.util.Date«c»
			 * @see java.lang.StringBuffer
			 */
			class Foo {
			}
		'''.hasHyperlinkToJavaDate
	}

	@Test def javadoc_see03() {
		'''
			/**
			 * @see java.lang.StringBuffer
			 * @see «c»java.util.Date«c»
			 */
			class Foo {
			}
		'''.hasHyperlinkToJavaDate
	}

	@Test def javadoc_see04() {
		'''
			import java.util.Date
			
			/**
			 * @see «c»Date«c»
			 */
			class Foo {
				Date date
			}
		'''.hasHyperlinkToJavaDate
	}

	@Test def javadoc_see05() {
		'''
			import java.util.Date
			
			class Foo {
				
				/**
				 * @see «c»Date«c»
				 */
				val a = 1
			}
		'''.hasHyperlinkToJavaDate
	}

	@Test def javadoc_see06() {
		'''
			import java.util.Date
			
			class A {
				Date date
			}
			
			/**
			 * @see «c»Date«c»
			 */
		'''.hasHyperlinkToJavaDate
	}

	@Test def javadoc_see07() {
		'''
			import java.util.Date
			/**
			 * @see «c»Date«c»
			 */
		'''.hasHyperlinkToJavaDate
	}

	private def hasHyperlinkToJavaDate(CharSequence it) {
		hasHyperlinkTo("java.util.Date")
	}

	private def hasNoHyperlink(CharSequence it) {
		// given
		dslFile.
		// when
		hyperlinkingOn(hyperlinkRegion.offset).
		// then
		noHyperlinkIsOffered
	}

	private def noHyperlinkIsOffered(IHyperlink[] hyperlinks) {
		hyperlinks.assertNull
	}
}