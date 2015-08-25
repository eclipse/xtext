/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser

import org.eclipse.xtend.core.parser.XtendPsiAntlrGrammarGenerator
import org.eclipse.xtext.xtext.generator.idea.parser.antlr.PsiAntlrGrammarGenerator
import com.google.inject.AbstractModule

class XtendLanguageGeneratorModule extends AbstractModule {
	override protected configure() {
		bind(PsiAntlrGrammarGenerator).to(XtendPsiAntlrGrammarGenerator)
	}
}