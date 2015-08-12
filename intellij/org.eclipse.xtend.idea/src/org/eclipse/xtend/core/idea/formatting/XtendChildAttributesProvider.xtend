/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.formatting

import com.google.inject.Inject
import com.intellij.formatting.Indent
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.services.XtendGrammarAccess
import org.eclipse.xtext.xbase.idea.formatting.XbaseChildAttributesProvider

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendChildAttributesProvider extends XbaseChildAttributesProvider {

	@Inject
	extension XtendGrammarAccess
	
	override protected getIndentAfter(EObject grammarElement) {
		switch grammarElement {
			case XSwitchExpressionAccess.colonKeyword_5_1,
			case XVariableDeclarationAccess.equalsSignKeyword_2_0:
				return Indent.normalIndent
			default:
				return super.getIndentAfter(grammarElement)
		}
	}

}