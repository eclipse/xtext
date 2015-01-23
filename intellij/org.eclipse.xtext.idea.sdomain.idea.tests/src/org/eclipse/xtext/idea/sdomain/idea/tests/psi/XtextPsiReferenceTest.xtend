/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.sdomain.idea.tests.psi

import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.psi.XtextPsiReference

class XtextPsiReferenceTest extends LightCodeInsightFixtureTestCase {

	def void testProperty_type_01() {
		'''
			entity Foo {<crossReference>
				<caret><referenceToHighlight><reference>Foo</reference></referenceToHighlight></crossReference> foo
			}
		'''.testReference
	}

	def void testProperty_type_02() {
		'''
			a.b.c {
				entity Foo {<crossReference>
					<caret><referenceToHighlight>a.b.c.<reference>Foo</reference></referenceToHighlight></crossReference> foo
				}
			}
		'''.testReference
	}

	protected def testReference(CharSequence text) {
		testReference(new XtextPsiReferenceTestContext(text.toString))
	}

	protected def testReference(extension XtextPsiReferenceTestContext context) {
		myFixture.configureByText('aaa.sdomain', text)

		val elementAtCaret = myFixture.file.findElementAt(caretOffset)
		assertNotNull(elementAtCaret)

		val reference = myFixture.file.findReferenceAt(caretOffset) as XtextPsiReference
		assertNotNull(reference)

		val startReferneceOffsetInElement = startReferenceOffset - startCrossReferenceOffset
		val endReferenceOffsetInElement = endReferenceOffset - startCrossReferenceOffset
		
		val rangeInElement = reference.rangeInElement
		assertEquals(startReferneceOffsetInElement, rangeInElement.startOffset)
		assertEquals(endReferenceOffsetInElement, rangeInElement.endOffset)
		
		val startReferenceToHighlightOffsetInElement = startReferenceToHighlightOffset - startCrossReferenceOffset
		val endReferenceToHighlightOffsetInElement = endReferenceToHighlightOffset - startCrossReferenceOffset
		
		val rangeToHighlight = reference.rangeToHighlightInElement
		assertEquals(startReferenceToHighlightOffsetInElement, rangeToHighlight.startOffset)
		assertEquals(endReferenceToHighlightOffsetInElement, rangeToHighlight.endOffset)
	}

}

@Accessors
class XtextPsiReferenceTestContext {

	String text
	int caretOffset
	int startCrossReferenceOffset
	int endCrossReferenceOffset
	int startReferenceOffset
	int endReferenceOffset
	int startReferenceToHighlightOffset
	int endReferenceToHighlightOffset

	new(String text) {
		this.text = text
		var startIndex = this.text.indexOf('<')
		while (startIndex != -1) {
			val endIndex = this.text.indexOf('>')
			val name = this.text.substring(startIndex + 1, endIndex)
			switch name {
				case 'caret': caretOffset = startIndex
				case 'crossReference': startCrossReferenceOffset = startIndex
				case '/crossReference': endCrossReferenceOffset = startIndex
				case 'reference': startReferenceOffset = startIndex
				case '/reference': endReferenceOffset = startIndex
				case 'referenceToHighlight': startReferenceToHighlightOffset = startIndex
				case '/referenceToHighlight': endReferenceToHighlightOffset = startIndex
			}
			this.text = this.text.substring(0, startIndex) + this.text.substring(endIndex + 1)
			startIndex = this.text.indexOf('<')
		}
	}

}