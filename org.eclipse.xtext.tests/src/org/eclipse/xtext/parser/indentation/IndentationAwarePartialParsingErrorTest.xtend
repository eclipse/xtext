/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.indentation

import com.google.inject.Inject
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(IndentationAwareTestLanguageInjectorProvider)
class IndentationAwarePartialParsingErrorTest {

	@Inject
	extension ParseHelper<Tree> parseHelper
	
	@Test
	def void testResourceUpdate() {
		val String model = '''
			a
				b // single tab
			         // 8 spaces eq 1 tab
			d
		'''
		val tree = model.parse
		val resource = tree.eResource as XtextResource
		val idx = model.indexOf(' // 8')
		resource.update(idx, 0, 'c')
		val reparsed = resource.contents.head as Tree
		Assert.assertNotSame(tree, reparsed)
	}
	
	@Test
	def void testResourceUpdate_02() {
		val String model = '''
			a
				x
					b // two tabs
				         // tab and 8 spaces (eq 2 tabs)
				y
		'''
		val tree = model.parse
		val resource = tree.eResource as XtextResource
		val idx = model.indexOf(' // tab')
		resource.update(idx, 0, 'c')
		val reparsed = resource.contents.head as Tree
		Assert.assertNotSame(tree, reparsed)
	}

}