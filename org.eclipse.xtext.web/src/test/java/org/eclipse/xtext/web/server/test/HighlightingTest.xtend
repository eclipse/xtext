/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test

import org.eclipse.xtext.web.server.hover.HoverResult
import org.eclipse.xtext.web.server.syntaxcoloring.HighlightingResult
import org.junit.Test

import static org.junit.Assert.*

class HighlightingTest extends AbstractWebServerTest {
	def protected assertHighlighting(CharSequence resourceContent, String... styleClasses) {
		val content = resourceContent.toString
		val highlighting = getService(#{
			'serviceType' -> 'highlight',
			'fullText' -> content.replace('#', '')
		})
		val result = highlighting.service.apply() as HighlightingResult
		assertEquals(styleClasses.length, result.regions.size)
		var offset = 0
		val snippets = content.split('#')
		for (var i = 0; i < styleClasses.length; i++) {
			offset += snippets.get(2 * i).length
			val length = snippets.get(2 * i + 1).length
			val region = result.regions.get(i)
			assertEquals(styleClasses.get(i), region.styleClasses.head)
			assertEquals(offset, region.offset)
			assertEquals(length, region.length)
			offset += length
		}
	}

	def protected assertTitle(HoverResult result, String expectedTitle) {
		assertEquals(expectedTitle, result.title)
		result
	}

	def protected assertContent(HoverResult result, String expectedContent) {
		assertEquals(expectedContent, result.content)
		result
	}

	@Test
	def void testNoHighlightingOnEmptyFile() {
		'#'.assertHighlighting()
	}

	@Test
	def void testNoSignal() {
		'''
			state State
			end
		'''.assertHighlighting()
	}

	@Test
	def void testInputSignal() {
		'''
			input signal #in#
			
			state State
				if #in# == true goto State
			end
		'''.assertHighlighting('InputSignal', 'InputSignal')
	}

	@Test
	def void testOutputSignal() {
		'''
			output signal #out#
			
			state State
				set #out# = false
			end
		'''.assertHighlighting('OutputSignal', 'OutputSignal')
	}

	@Test
	def void testMixed() {
		'''
			input signal #in#
			output signal #out#
			
			state State
				set #out# = false
				if #in# == true goto State
			end
		'''.assertHighlighting('InputSignal', 'OutputSignal', 'OutputSignal', 'InputSignal')
	}
}