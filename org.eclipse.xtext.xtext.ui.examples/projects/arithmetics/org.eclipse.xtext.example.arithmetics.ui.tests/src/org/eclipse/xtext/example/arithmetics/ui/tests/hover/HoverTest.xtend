/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.tests.hover

import org.eclipse.jface.text.Region
import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractHoverTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(ArithmeticsUiInjectorProvider)
class HoverTest extends AbstractHoverTest {

	@Test def hover_over_function_call() {
		val text = '''
			module arithmetics
			
			/*
			 * A mathematical constant.
			 * It is approximately equal to 3.14.
			 */
			def pi: 3.14
			
			pi * 4;
		'''
		
		val hoverText = "pi"
		val hoverRegion = new Region(text.lastIndexOf(hoverText), hoverText.length)
		text.hasHoverOver(hoverRegion, '''
			A mathematical constant.
			It is approximately equal to 3.14.'''
		)
	}
}