/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser

import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.PsiAntlrGrammarGenerator
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendPsiAntlrGrammarGenerator extends PsiAntlrGrammarGenerator {

	@Inject
	extension TokenNames

	protected override compileTokens(Grammar it, AntlrOptions options) {
		'''
			
			tokens {
			  «FOR token : getTokens(newHashSet)»
			  	«token» ;
			  «ENDFOR»
			}
		'''
	}

}
