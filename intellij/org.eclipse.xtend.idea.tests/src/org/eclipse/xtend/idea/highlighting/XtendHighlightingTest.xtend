/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.highlighting

import org.eclipse.xtend.idea.LightXtendTest

class XtendHighlightingTest extends LightXtendTest {
	def testKeyWord() {
		configureByText('''public''')
		assertHighlights(
			'''
				0-6:[java.awt.Color[r=0,g=0,b=128],null,1,BOXED,null,null]
			'''
		)
	}
	
	def testStringLiteral() {
		configureByText('''"Foo"''')
		assertHighlights('''
			0-5:[java.awt.Color[r=0,g=128,b=0],null,1,BOXED,null,null]
		''')
	}
	
	def testNumberLiteral() {
		configureByText("5")
		assertHighlights('''
			0-1:[java.awt.Color[r=0,g=0,b=255],null,0,BOXED,null,null]
		''')
		
	}
	
	def testComment() {
		configureByText("//comment")
		assertHighlights('''
			0-9:[java.awt.Color[r=128,g=128,b=128],null,2,BOXED,null,null]
		''')
	}
}