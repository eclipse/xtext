/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.formatting

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.services.XtendGrammarAccess
import org.eclipse.xtext.xbase.idea.formatting.XbaseBlockFactory

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class XtendBlockFactory extends XbaseBlockFactory {

	@Inject
	extension XtendGrammarAccess

	override protected isStructural(EObject grammarElement) {
		switch grammarElement {
			case XVariableDeclarationAccess.rightXExpressionParserRuleCall_2_1_0,
			case XSwitchExpressionAccess.defaultXExpressionParserRuleCall_5_2_0:
				true
			default:
				super.isStructural(grammarElement)
		}
	}

}