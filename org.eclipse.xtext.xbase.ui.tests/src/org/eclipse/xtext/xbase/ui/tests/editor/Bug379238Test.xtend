/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.editor

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.text.Region
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.xbase.XConstructorCall
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase
import org.junit.Test

/**
 * @author Holger Schill - Initial contribution and API
 */
class Bug379238Test extends AbstractXbaseUITestCase {
	
	@Inject
	ParseHelper<XConstructorCall> parseHelper
	
	@Inject
	TestingXbaseHoverProvider hoverProvider
	
	@Test
	def testXConstructorWithNullConstructorNoException() throws Exception {
		val constructorCall = parseHelper.parse('''
			new()
		''')
		val result = hoverProvider.getHoverInfo(constructorCall)
		assertNull(result)
	}
}

/**
 * @author Holger Schill - Initial contribution and API
 */
class TestingXbaseHoverProvider extends XbaseHoverProvider {
		
   def getHoverInfo(EObject element) {
		super.getHoverInfo(element, new Region(0,0) , null)
	}
	
}