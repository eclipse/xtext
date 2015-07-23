/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.formatting

import com.google.inject.Inject
import com.intellij.formatting.Indent
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.idea.formatting.DefaultChildAttributesProvider
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess

/**
 * @author kosyakov - Initial contribution and API
 */
class XbaseChildAttributesProvider extends DefaultChildAttributesProvider {

	@Inject
	extension XbaseGrammarAccess

	protected override getAfterIndent(EObject grammarElement) {
		grammarElement.indent ?: super.getBeforeIndent(grammarElement)
	}

	protected override getBeforeIndent(EObject grammarElement) {
		grammarElement.indent ?: super.getBeforeIndent(grammarElement)
	}

	protected def getIndent(EObject grammarElement) {
		if (grammarElement == null)
			return null

		switch grammarElement {
			case XSwitchExpressionAccess.colonKeyword_5_1,
			case XReturnExpressionAccess.returnKeyword_1,
			case XSynchronizedExpressionAccess.rightParenthesisKeyword_2,
			case XForLoopExpressionAccess.rightParenthesisKeyword_2,
			case XBasicForLoopExpressionAccess.rightParenthesisKeyword_8,
			case XWhileExpressionAccess.rightParenthesisKeyword_4,
			case XDoWhileExpressionAccess.doKeyword_1,
			case XIfExpressionAccess.rightParenthesisKeyword_4,
			case XIfExpressionAccess.elseKeyword_6_0,
			case XCasePartAccess.colonKeyword_3_0_0,
			case XCatchClauseAccess.rightParenthesisKeyword_3,
			case XThrowExpressionAccess.throwKeyword_1,
			case XTryCatchFinallyExpressionAccess.tryKeyword_1,
			case XTryCatchFinallyExpressionAccess.finallyKeyword_3_1_0,
			case XTryCatchFinallyExpressionAccess.finallyKeyword_3_0_1_0,
			case XVariableDeclarationAccess.equalsSignKeyword_3_0:
				return Indent.normalIndent
		}

		return null
	}

}