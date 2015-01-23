/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.generator.parser.antlr

import com.google.inject.Inject
import java.nio.charset.Charset
import java.util.List
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.parser.antlr.AbstractAntlrXtendGeneratorFragment
import org.eclipse.xtext.generator.parser.antlr.AntlrOptions
import org.eclipse.xtend.lib.annotations.Accessors

class XtextAntlrIDEAGeneratorFragment extends AbstractAntlrXtendGeneratorFragment {
	
	String encoding
	
	@Accessors
	String ideaProjectPath
	
	@Inject
	extension Naming
	
	@Inject
	extension PsiAntlrGrammarGenerator
	
	@Inject
	extension XtextIDEAGeneratorExtensions
	
	public def void setEncoding(String encoding) {
		this.encoding = encoding
	}

	override protected generate(Grammar grammar, List<Object> parameters, Xtend2ExecutionContext ctx) {
		installOutlets(ctx, ideaProjectPath, encoding, naming.lineDelimiter)
		
		val options = parameters.head
		if (options instanceof AntlrOptions) {
			grammar.generate(options, ctx)

			val srcGenOutlet = ctx.srcGenOutlet
			val srcGenPath = srcGenOutlet.path
			val encoding = srcGenOutlet.fileEncoding
			val absoluteGrammarFileName = '''«srcGenPath»/«grammar.grammarFileName.asPath».g'''
			addAntlrParam('-fo')
			addAntlrParam(absoluteGrammarFileName.substring(0, absoluteGrammarFileName.lastIndexOf('/')))
			antlrTool.runWithEncodingAndParams(absoluteGrammarFileName, encoding, antlrParams)
			val charset = Charset.forName(encoding)
			simplifyUnorderedGroupPredicatesIfRequired(grammar, absoluteGrammarFileName, charset)
			splitParserAndLexerIfEnabled(absoluteGrammarFileName, charset)
			suppressWarnings(absoluteGrammarFileName, charset)
			normalizeLineDelimiters(absoluteGrammarFileName, charset)
			normalizeTokens(absoluteGrammarFileName, charset)
		}
	}

	override protected addToPluginXmlRt(Grammar grammar, List<Object> parameters, Xtend2ExecutionContext ctx) {
		
	}

	override protected addToPluginXmlUi(Grammar grammar, List<Object> parameters, Xtend2ExecutionContext ctx) {
		
	}

	override protected addToPluginXmlTests(Grammar grammar, List<Object> parameters, Xtend2ExecutionContext ctx) {
		
	}

	override protected addToStandaloneSetup(Grammar grammar, List<Object> parameters, Xtend2ExecutionContext ctx) {
		
	}

}
