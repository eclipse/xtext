package org.eclipse.xtext.web.server.test

import org.eclipse.xtext.web.server.occurrences.OccurrencesResult
import org.junit.Test

class OccurrenceTest extends AbstractWebServerTest {
	def protected getOccurrences(CharSequence resourceContent) {
		val content = resourceContent.toString
		val offset = content.indexOf('#')
		val occurrences = getService(#{
				'requestType' -> 'occurrences',
				'fullText' -> content.replace('#', ''),
				'caretOffset' -> offset.toString
			})
		assertTrue(occurrences.hasTextInput)
		occurrences.service.apply() as OccurrencesResult
	}
	
	def protected assertOccurrences(CharSequence resourceContent, CharSequence expectation) {
		expectation.toString.trim.assertEquals(resourceContent.occurrences.toString.trim)
	}
	
	@Test 
	def void testNoOccurrenceOnEmptyFile() {
		'#'.occurrences.assertNull
	}
	
	@Test 
	def void testNoOccurrencesOnKeyword() {
		'''
			#state foo
		''' .occurrences
			.assertNull
	}
	
	@Test 
	def void testSingleWriteOccurrence() {
		'''
			state #foo
		''' .assertOccurrences('''
			OccurrencesResult [
			  stateId = "-80000000"
			  writeRegions = ArrayList (
			    TextRegionWithLineInformation [6:3][lineNumber=0, endLineNumber=0]
			  )
			  readRegions = ArrayList ()
			]
		''')
	}

	@Test 
	def void testReadAndWriteOccurrence() {
		'''
			input signal #foo
			state bar 
				set foo == true
				set foo == true
			end
		''' .assertOccurrences('''
			OccurrencesResult [
			  stateId = "-80000000"
			  writeRegions = ArrayList (
			    TextRegionWithLineInformation [13:3][lineNumber=0, endLineNumber=0]
			  )
			  readRegions = ArrayList (
			    TextRegionWithLineInformation [33:3][lineNumber=2, endLineNumber=2],
			    TextRegionWithLineInformation [50:3][lineNumber=3, endLineNumber=3]
			  )
			]
		''')
	}
	
	@Test 
	def void testReadAndWriteOccurrence_2() {
		'''
			input signal foo
			state bar 
				set #foo == true
				set foo == true
			end
		''' .assertOccurrences('''
			OccurrencesResult [
			  stateId = "-80000000"
			  writeRegions = ArrayList (
			    TextRegionWithLineInformation [13:3][lineNumber=0, endLineNumber=0]
			  )
			  readRegions = ArrayList (
			    TextRegionWithLineInformation [33:3][lineNumber=2, endLineNumber=2],
			    TextRegionWithLineInformation [50:3][lineNumber=3, endLineNumber=3]
			  )
			]
		''')
	}
	
}