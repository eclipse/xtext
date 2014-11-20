/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser

import com.google.inject.Binder
import org.eclipse.xtext.idea.generator.parser.antlr.PsiAntlrGrammarGenerator
import org.eclipse.xtext.idea.generator.parser.antlr.XtextAntlrIDEAGeneratorFragment

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendAntlrIDEAGeneratorFragment extends XtextAntlrIDEAGeneratorFragment {
	
	override protected addLocalBindings(Binder binder) {
		super.addLocalBindings(binder)
		binder.bind(PsiAntlrGrammarGenerator).to(XtendPsiAntlrGrammarGenerator)
	}
	
}