/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.psi

import org.eclipse.xtend.idea.LightXtendTest
import org.junit.Test

/**
 * @author kosyakov - Initial contribution and API
 */
class XtextPsiReferenceTest extends LightXtendTest {

	@Test
	def void testGetTextOffset() {
		val model = '''
			package mypackage
			
			import java.io.File
			
			class Main {
				def static void main(String[] args) {
					val file = new File('lalala')
				}
			}
		'''
		val file = myFixture.addFileToProject('mypackage/Main.xtend', model)

		val index = model.indexOf('File(')
		val reference = file.findReferenceAt(index)
		val element = reference.element
		val textRange = element.textRange
		val textOffset = element.textOffset
		assertTrue(textRange + ' ' + textOffset, textRange.contains(textOffset))
	}

}