/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.tests.parsing

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Action
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.EnumLiteralDeclaration
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.INode

class NodeModelPrinter {
	
	@Accessors
	var boolean ignoreSyntaxErrors = false

	def dispatch String print(ICompositeNode it) '''
		«doPrint»
		{
			«FOR child : children SEPARATOR '\n'»
				«child.print»
			«ENDFOR»
		}
	'''

	def dispatch String print(INode it) {
		doPrint
	}

	protected def String doPrint(INode it) '''
		«IF ignoreSyntaxErrors»«class.name.replaceFirst('AndSyntaxError', '').replaceFirst('WithSyntaxError', '')»«ELSE»«class»«ENDIF» «totalTextRegion»
		grammarElements: «grammarElement.printGrammarElement»
		«IF hasDirectSemanticElement»directSemanticElement: «semanticElement.class.name»«ENDIF»
		«IF it instanceof ICompositeNode»lookAhead: «lookAhead»«ENDIF»
		«IF !ignoreSyntaxErrors && syntaxErrorMessage != null»syntaxErrorMessage: «syntaxErrorMessage»«ENDIF»'''

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

	protected dispatch def String printGrammarElement(Action action) '''
		Action [«action.type.classifier.name»]
	'''

	protected dispatch def String printGrammarElement(CrossReference crossReference) '''
		CrossReference [«crossReference.type.classifier.name»«IF crossReference.terminal != null» | «crossReference.terminal.printGrammarElement» «ENDIF»]
	'''

	protected dispatch def String printGrammarElement(EnumLiteralDeclaration it) '''
		EnumLiteralDeclaration [«enumLiteral.literal»«IF literal != null» = «literal.value»«ENDIF»]
	'''

}
