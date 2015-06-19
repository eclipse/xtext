package org.eclipse.xtext.web.server.test

import org.eclipse.xtext.web.server.hover.HoverResult
import org.junit.Test

class HoverTest extends AbstractWebServerTest {
	def protected getHover(CharSequence resourceContent) {
		val content = resourceContent.toString
		val offset = content.indexOf('#')
		val hover = getService('hover', #{
			'fullText' -> content.replace('#', ''),
			'offset' -> offset.toString
		})
		assertTrue(hover.hasTextInput)
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
		'#'.hover.assertNull
	}
	
	@Test
	def void testUnDocumentedElement() {
		'''
			state #foo
		''' .hover
			.assertContent('''
				<div class="hover">
				</div>
			''')
			.assertTitle('''
				<div class="hover">
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
				<div class="hover">
					This is foo!
				</div>
			''')
			.assertTitle('''
				<div class="hover">
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
			.assertContent('''
				<div class="hover">
					This is foo!
				</div>
			''')
			.assertTitle('''
				<div class="hover">
					<div class="State-icon default-icon">
						<div class="element-name">
							foo
						</div>
					</div>
				</div>
			''')
	}
	
	@Test
	def void testSubClass() {
		'''
			input signal #foo
		''' .hover
			.assertTitle('''
				<div class="hover">
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
				<div class="hover">
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
		'''.hover.assertNull
	}
}