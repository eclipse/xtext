/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.hyperlinking

import com.google.inject.Inject
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.common.types.xtext.ui.JdtHyperlink
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper
import org.junit.Test

/**
 * @author miklossy - Initial contribution and API
 */
class JavaDocHyperlinkingTest extends AbstractXtendUITestCase {

	// position marker
	val c = '''<|>'''

	@Inject extension IHyperlinkHelper

	@Inject extension WorkbenchTestHelper

	@Test def import_statement() {
		'''
			import «c»java.util.Date«c»
			
			class Foo {
				Date date
			}
		'''.containsHyperlinkToJavaDate
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
		'''.containsHyperlinkToJavaDate
	}

	@Test def multi_line_comment_link() {
		'''
			import java.util.Date
			
			/*
			 * {@link «c»Date«c»}
			 */
			class Foo {
			}
		'''.containsHyperlinkToJavaDate
	}

	@Test def multi_line_comment_see() {
		'''
			import java.util.Date
			
			/*
			 * @see «c»Date«c»
			 */
			class Foo {
			}
		'''.containsHyperlinkToJavaDate
	}

	@Test def javadoc_link_no_hyperlink_if_the_type_cannot_be_resolved() {
		'''
			/**
			 * {@link «c»Date«c»}
			 */
			class Foo {
			}
		'''.containsNoHyperlinks
	}

	@Test def javadoc_see_no_hyperlink_if_the_type_cannot_be_resolved() {
		'''
			/**
			 * @see «c»Date«c»
			 */
			class Foo {
			}
		'''.containsNoHyperlinks
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
		'''.containsHyperlinkToJavaDate
	}

	@Test def javadoc_link02() {
		'''
			/**
			 * {@link «c»java.util.Date«c»}
			 * {@link java.lang.StringBuffer}
			 */
			class Foo {
			}
		'''.containsHyperlinkToJavaDate
	}

	@Test def javadoc_link03() {
		'''
			/**
			 * {@link java.lang.StringBuffer}
			 * {@link «c»java.util.Date«c»}
			 */
			class Foo {
			}
		'''.containsHyperlinkToJavaDate
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
		'''.containsHyperlinkToJavaDate
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
		'''.containsHyperlinkToJavaDate
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
		'''.containsHyperlinkToJavaDate
	}

	@Test def javadoc_link07() {
		'''
			import java.util.Date
			/**
			 * {@link «c»Date«c»}
			 */
		'''.containsHyperlinkToJavaDate
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
		'''.containsHyperlinkToJavaDate
	}

	@Test def javadoc_see02() {
		'''
			/**
			 * @see «c»java.util.Date«c»
			 * @see java.lang.StringBuffer
			 */
			class Foo {
			}
		'''.containsHyperlinkToJavaDate
	}

	@Test def javadoc_see03() {
		'''
			/**
			 * @see java.lang.StringBuffer
			 * @see «c»java.util.Date«c»
			 */
			class Foo {
			}
		'''.containsHyperlinkToJavaDate
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
		'''.containsHyperlinkToJavaDate
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
		'''.containsHyperlinkToJavaDate
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
		'''.containsHyperlinkToJavaDate
	}

	@Test def javadoc_see07() {
		'''
			import java.util.Date
			/**
			 * @see «c»Date«c»
			 */
		'''.containsHyperlinkToJavaDate
	}

	private def containsNoHyperlinks(CharSequence it) {
		determineHyperlinks(expectedPositionInformation.head).assertNull
	}

	private def containsHyperlinkToJavaDate(CharSequence it) {
		val expected = expectedPositionInformation
		val expectedOffset = expected.head
		val expectedLength = expected.last
		
		val hyperlinks = determineHyperlinks(expectedOffset)
		assertNotNull("No hyperlinks found!", hyperlinks)
		1.assertEquals(hyperlinks.length)
		val hyperlink = hyperlinks.head
		
		"Date".assertEquals(hyperlink.hyperlinkText)
		expectedOffset.assertEquals(hyperlink.hyperlinkRegion.offset)
		expectedLength.assertEquals(hyperlink.hyperlinkRegion.length)
		
		assertTrue(hyperlink instanceof JdtHyperlink)
		val jdtHyperlink = hyperlink as JdtHyperlink
		
		val javaElement = jdtHyperlink.javaElement
		"Date".assertEquals(javaElement.elementName)
	}

	private def getExpectedPositionInformation(CharSequence input) {
		val text = input.toString

		val first = text.indexOf(c)
		if(first == -1) {
			fail('''Can't locate first position symbols '«c»' in the input text.''')
		}

		val second = text.lastIndexOf(c)
		if(first == second) {
			fail('''Can't locate second position symbols '«c»' in the input text.''')
		}

		val offset = first
		val length = second - first - c.length

		#[offset, length]
	}

	private def determineHyperlinks(CharSequence text, int offset) {
		val content = text.toString.replace(c, "")

		val xtendFile = "Foo".xtendFile(content)
		val resource = xtendFile.eResource as XtextResource
		resource.createHyperlinksByOffset(offset, true)
	}
}