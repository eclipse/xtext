/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test

import org.eclipse.xtext.web.server.hover.HoverResult
import org.junit.Test

import static extension org.junit.Assert.*

class HoverTest extends AbstractWebServerTest {
	
	def protected getHover(CharSequence resourceContent) {
		val content = resourceContent.toString
		val offset = content.indexOf('#')
		val hover = getService(#{
				'serviceType' -> 'hover',
				'fullText' -> content.replace('#', ''),
				'caretOffset' -> offset.toString
			})
		hover.service.apply() as HoverResult
	}
	
	protected def getContentAssistHover(CharSequence resourceContent, String proposal) {
		val content = resourceContent.toString
		val offset = content.indexOf('|')
		val hover = getService(#{
				'serviceType' -> 'hover',
				'fullText' -> content.replace('|', ''),
				'caretOffset' -> offset.toString,
				'proposal' -> proposal
			})
		hover.service.apply() as HoverResult
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
	def void testNoHoverOnEmptyFile() {
		'#'.hover.content.assertNull
	}
	
	@Test
	def void testUndocumentedElement() {
		'''
			state #foo
		''' .hover
			.assertContent('''
			''')
			.assertTitle('''
				<div class="xtext-hover">
					<div class="State-icon default-icon">
						<div class="element-name">
							foo
						</div>
					</div>
				</div>
			''')
	}
	
	@Test
	def void testDocumentedElement() {
		'''
			/**
			 * This is foo!
			 */
			state #foo
		''' .hover
			.assertContent('''
				<div class="xtext-hover">
					This is foo!
				</div>
			''')
			.assertTitle('''
				<div class="xtext-hover">
					<div class="State-icon default-icon">
						<div class="element-name">
							foo
						</div>
					</div>
				</div>
			''')
	}

	@Test
	def void testKeyword() {
		'''
			/**
			 * This is foo!
			 */
			#state foo
		''' .hover
			.content.assertNull
	}
	
	@Test
	def void testSubClass() {
		'''
			input signal #foo
		''' .hover
			.assertTitle('''
				<div class="xtext-hover">
					<div class="InputSignal-icon Signal-icon default-icon">
						<div class="element-name">
							foo
						</div>
					</div>
				</div>
			''')
	}
	
	@Test
	def void testDecoratedIcon() {
		'''
			output signal #foo
		''' .hover
			.assertTitle('''
				<div class="xtext-hover">
					<div class="OutputSignal-icon Signal-icon default-icon">
						<div class="output-icon">
							<div class="element-name">
								foo
							</div>
						</div>
					</div>
				</div>
			''')
	}
	
	@Test 
	def void testNoHoverUnnamedElement() {
		'''
			input signal x
			
			state State1
				set z = fal#se
			end
		'''.hover.content.assertNull
	}
	
	@Test
	def void testContentAssistCrossref1() {
		'''
			input signal x
			/* my nice state */
			state foo
			end
			state bar
				if x == true goto |
			end
		'''.getContentAssistHover('foo')
			.assertTitle('''
				<div class="xtext-hover">
					<div class="State-icon default-icon">
						<div class="element-name">
							foo
						</div>
					</div>
				</div>
			''')
			.assertContent('''
				<div class="xtext-hover">
					my nice state
				</div>
			''')
	}
	
	@Test
	def void testContentAssistCrossref2() {
		'''
			input signal x
			/* my nice signal */
			input signal y
			state foo
				if | == true goto foo
			end
		'''.getContentAssistHover('y')
			.assertTitle('''
				<div class="xtext-hover">
					<div class="InputSignal-icon Signal-icon default-icon">
						<div class="element-name">
							y
						</div>
					</div>
				</div>
			''')
			.assertContent('''
				<div class="xtext-hover">
					my nice signal
				</div>
			''')
	}
	
}