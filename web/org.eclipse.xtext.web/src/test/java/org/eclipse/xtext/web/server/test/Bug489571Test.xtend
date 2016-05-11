package org.eclipse.xtext.web.server.test

import org.eclipse.xtext.formatting.IIndentationInformation
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule
import org.eclipse.xtext.web.server.formatting.FormattingResult
import org.eclipse.xtext.web.server.test.Bug489571Test.Bug489571IndentationInformation
import org.junit.Test

class Bug489571Test extends AbstractWebServerTest {

	override protected getRuntimeModule() {
		new StatemachineRuntimeModule {
			def Class<? extends IIndentationInformation> bindIIndentationInformation() {
				Bug489571IndentationInformation
			}
		}
	}

	static class Bug489571IndentationInformation implements IIndentationInformation {

		override getIndentString() {
			'  '
		}

	}
	
	@Test def testFormatFile() {
		val file = createFile('/* bla */ output signal x state foo set x = true end')
		val format = getService(#{'serviceType' -> 'format', 'resource' -> file.name})
		assertTrue(format.hasSideEffects)
		val result = format.service.apply() as FormattingResult
		val String expectedResult = '''
			FormattingResult [
			  stateId = "-7fffffff"
			  formattedText = "/* bla */ output signal x\nstate foo\n  set x = true\nend\n"
			]'''
		assertEquals(expectedResult, result.toString)
	}
	
	@Test def testFormatSelection() {
		val file = createFile('/* bla */ output signal x state foo set x = true end ')
		val format = getService(#{
				'serviceType' -> 'format',
				'selectionStart' -> '26',
				'selectionEnd' -> '52',
				'resource' -> file.name
			})
		assertTrue(format.hasSideEffects)
		val result = format.service.apply() as FormattingResult
		val String expectedResult = '''
			FormattingResult [
			  stateId = "-7fffffff"
			  formattedText = "state foo\n  set x = true\nend"
			  replaceRegion = [26:26]
			]'''
		assertEquals(expectedResult, result.toString)
	}

}
