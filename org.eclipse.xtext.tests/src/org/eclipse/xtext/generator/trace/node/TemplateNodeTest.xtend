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

	@Test def void testString() {
		assertEquals('''
			fooo bar
			«IF 2 > 1»
				«FOR i : 1..4»
					«other» «i»
					«multiLineString» «multiLineString»
				«ENDFOR»
			«ENDIF»
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
		val processor = new GeneratorNodeProcessor(new StringBuilder, "  ", "\n")
		
		val root = new CompositeGeneratorNode()
		ext.appendTemplate(root, c);
		processor.process(root)
		
		val expected = new StringConcatenation()
		expected.append(c)
		Assert.assertEquals(expected.toString, processor.contents.toString)
	}
}