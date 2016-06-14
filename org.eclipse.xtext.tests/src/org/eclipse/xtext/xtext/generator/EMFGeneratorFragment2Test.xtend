/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.junit.Test
import org.junit.Assert

import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2

/**
 */
class EMFGeneratorFragment2Test {
	
	@Test def void testTrimMultiLineString() {
		assertTrim('foo','''
			/*foo*/
		''')
		assertTrim('foo','''
			/* 
			 * foo*/
		''')
		assertTrim('foo','''
			/* 
			 * 
			 * foo
			 */
		''')
		assertTrim('''
			multi
			foo''',
		'''
			/* 
			 * multi
			 * foo
			 * 
			 */
		''')
		assertTrim('foo','''
			/* foo */
		''')
		assertTrim('foo','foo')
	}
	
	def void assertTrim(String expected, String original) {
		Assert.assertEquals(expected, EMFGeneratorFragment2.trimMultiLineComment(original))
	}
}