/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.idea.parser.antlr

import com.google.inject.Inject
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.parser.antlr.AbstractAntlrGeneratorFragment2

class XtextAntlrIDEAGeneratorFragment extends AbstractAntlrGeneratorFragment2 {

	@Inject
	PsiAntlrGrammarGenerator generator

	@Inject CodeConfig codeConfig

	@Inject extension PsiGrammarNaming

	override protected doGenerate() {
		val fsa = projectConfig.ideaPlugin.srcGen
		generator.generate(grammar, options, fsa)

		val encoding = codeConfig.encoding
		val grammarFileName = '''«grammar.grammarClass.path».g'''
		val absoluteGrammarFileName = '''«fsa.path»/«grammarFileName»'''
		addAntlrParam('-fo')
		addAntlrParam(absoluteGrammarFileName.substring(0, absoluteGrammarFileName.lastIndexOf('/')))
		antlrTool.runWithEncodingAndParams(absoluteGrammarFileName, encoding, antlrParams)

		simplifyUnorderedGroupPredicatesIfRequired(grammar, fsa, grammar.internalParserClass)
		splitParserAndLexerIfEnabled(fsa, grammar.internalParserClass, grammar.lexerClass)
		#[grammar.internalParserClass, grammar.lexerClass].forEach[
			suppressWarnings(fsa, it)
			normalizeLineDelimiters(fsa, it)
		]
		normalizeTokens(fsa, grammar.tokenFileName)
	}
}
