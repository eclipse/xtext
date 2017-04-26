/*******************************************************************************
 * Copyright (c) 2017 TypeFox (https://typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import org.junit.Test
import org.eclipse.xtend2.lib.StringConcatenationClient
import org.junit.Assert
import org.eclipse.xtend2.lib.StringConcatenation

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class TemplateNodeTest {
	
	@Test def void testNull() {
		// need to create a local var, so the compiler doesn't remove the null segment
		val x = null
		assertEquals('''
			fooo «x»bar
		''')
	}
	
	@Test def void testNull_02() {
		// need to create a local var, so the compiler doesn't remove the null segment
		val x = null
		assertEquals('''
			fooo
				«x»
			 bar
		''')
	}
	
	@Test def void testSimpleString() {
		assertEquals('''
			fooo bar
		''')
	}
	
	@Test def void testSimpleTemplate_01() {
		assertEquals('''
			«multiLineString» «multiLineString»
		''')
	}

	@Test def void testWeirdTemplateString() {
		assertEquals('''
			fooo bar
			d   «IF 2 > 1»s
				  ee  «FOR i : 1..4»
					«''»
					«other» «i»
					«multiLineString» «multiLineString»
				«ENDFOR»
			«ENDIF»
		''')
	}
	
	@Test def void testSeparatorLoop() {
		val strings = #['a', 'b', 'c']
		assertEquals('''
			«FOR s : strings SEPARATOR ', '»"«s»"«ENDFOR»
		''')
	}
	
	private def other() '''
		foo «"dfdf" + 23» bar
	'''
	
	private def String multiLineString() '''
		test 
		bar
			«other()»
	'''
	
	def void assertEquals(StringConcatenationClient c) {
		val ext = new GeneratorNodeExtensions()
		val processor = new GeneratorNodeProcessor()
		
		val root = new CompositeGeneratorNode()
		ext.appendTemplate(root, c);
		val result = processor.process(root)
		
		val expected = new StringConcatenation()
		expected.append(c)
		Assert.assertEquals(expected.toString, result.toString)
	}
}