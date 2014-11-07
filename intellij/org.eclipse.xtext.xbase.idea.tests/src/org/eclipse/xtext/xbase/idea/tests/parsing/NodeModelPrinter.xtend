package org.eclipse.xtext.xbase.idea.tests.parsing

import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.INode

class NodeModelPrinter {

	def dispatch String print(ICompositeNode it) '''
		«doPrint» {
			«FOR child : children SEPARATOR '\n'»
				«child.print»
			«ENDFOR»
		}
	'''

	def dispatch String print(INode it) {
		doPrint
	}

	protected def String doPrint(INode it) '''
		«class» «textRegion»
		grammarElements: «grammarElement.printGrammarElement»
		hasDirectSemanticElement: «hasDirectSemanticElement»
		«IF it instanceof ICompositeNode»lookAhead: «lookAhead»«ENDIF»
		syntaxErrorMessage: «syntaxErrorMessage»'''

	protected dispatch def String printGrammarElement(Void grammarElement) {
		'null'
	}

	protected dispatch def String printGrammarElement(Object grammarElement) {
		grammarElement.toString
	}

	protected dispatch def String printGrammarElement(AbstractRule rule) '''
		«rule.class.simpleName» [«rule.name»]
	'''

	protected dispatch def String printGrammarElement(RuleCall grammarElement) '''
		RuleCall --> «grammarElement.rule.printGrammarElement»
	'''

	protected dispatch def String printGrammarElement(Keyword grammarElement) '''
		Keyword [«grammarElement.value»]
	'''

}
