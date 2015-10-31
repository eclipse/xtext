package org.eclipse.xtext.xbase.idea.findusages

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.xtext.idea.findusages.WordsScannerProvider
import org.eclipse.xtext.idea.tests.LightToolingTest
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping
import com.intellij.openapi.fileTypes.LanguageFileType

abstract class AbstractXbaseWordsScannerTest extends LightToolingTest {

	@Inject
	OperatorMapping operatorMapping

	@Inject
	WordsScannerProvider wordsScannerProvider
	
	new(LanguageFileType fileType) {
		super(fileType)
	}

	def void testProcessWords_01() {
		'''value'''.assertWords('value')
	}

	def void testProcessWords_02() {
		'''1'''.assertWords('1')
	}

	def void testProcessWords_03() {
		'''*'''.assertWords('*')
	}

	def void testProcessWords_04() {
		'''value * 1'''.assertWords('value', '*', '1')
	}

	def void testProcessOperator_01() {
		val operators = operatorMapping.operators
		operators.join(' ').assertWords(operators.map[toString])
	}

	def void testProcessOperator_02() {
		val operators = operatorMapping.operators
		val expectedWords = newLinkedList
		expectedWords.add('before')
		for (operator : operators) {
			expectedWords.add(operator.toString)
			if (operator != operators.last) {
				expectedWords.add('foo')
				expectedWords.add('bar')
			}
		}
		expectedWords.add('after')
		operators.join('before ', ' foo bar ', ' after', [toString]).assertWords(expectedWords)
	}

	def void testProcessCompoundOperators() {
		val operators = operatorMapping.compoundOperators
		operators.join(' ').assertWords(operators.map[toString])
	}

	protected def void assertWords(CharSequence text, String ... expectedWords) {
		val Collection<String> words = newLinkedList
		val wordsScanner = wordsScannerProvider.get
		wordsScanner.processWords(text) [
			words += baseText.subSequence(start, end).toString
		]
		assertOrderedEquals(text.toString, words, expectedWords)
	}
	
}