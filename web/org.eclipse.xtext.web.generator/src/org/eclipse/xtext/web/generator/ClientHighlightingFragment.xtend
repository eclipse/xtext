/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.generator

import java.io.File
import java.io.FileWriter
import java.util.Collection
import java.util.Set
import org.eclipse.xpand2.XpandExecutionContext
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.generator.LanguageConfig
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment

class ClientHighlightingFragment extends Xtend2GeneratorFragment {
	
	static val TERMINALS = 'org.eclipse.xtext.common.Terminals'
	static val XBASE = 'org.eclipse.xtext.xbase.Xbase'
	
	String langId
	Grammar grammar
	
	@Accessors
	String javaScriptPath
	
	override generate(LanguageConfig config, XpandExecutionContext ctx) {
		langId = config.getFileExtensions(config.grammar).head
		grammar = config.grammar
		super.generate(config, ctx)
	}
	
	override generate(Xtend2ExecutionContext ctx) {
		val keywords = grammar.keywords
		generateJavaScript(keywords).writeToFile(langId + '-syntax.js')
	}
	
	private def Set<String> getKeywords(Grammar grammar) {
		val result = newHashSet
		for (usedGrammar : grammar.usedGrammars) {
			result += usedGrammar.keywords
		}
		val iterator = grammar.eAllContents
		while (iterator.hasNext) {
			val elem = iterator.next
			if (elem instanceof Keyword)
				result += elem.value
			else if (elem instanceof TerminalRule)
				iterator.prune
		}
		return result
	}
	
	private def inherits(Grammar grammar, String name) {
		var g = grammar
		do {
			if (g.name == name)
				return true
			g = g.usedGrammars.head
		} while (g != null)
		return false
	}
	
	protected def writeToFile(CharSequence content, String fileName) {
		new File(javaScriptPath).mkdirs
		val writer = new FileWriter(new File(javaScriptPath, fileName))
		writer.write(content.toString)
		writer.close
	}
	
	protected def generateJavaScript(Collection<String> keywords) '''
		define("xtext/«langId»-syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) {
			var keywords = [
				«FOR kw : keywords.filter[matches('\\w*')].sort SEPARATOR ', '»"«kw»"«ENDFOR»
			];
		
			var grammars = [];
			grammars.push.apply(grammars, mLib.grammars);
			grammars.push({
				id: "xtext.«langId»",
				contentTypes: ["xtext/«langId»"],
				patterns: [
					«IF grammar.inherits(TERMINALS) || grammar.inherits(XBASE) »
						{include: "orion.lib#string_doubleQuote"},
						{include: "orion.lib#string_singleQuote"},
						{include: "orion.c-like#comment_singleLine"},
						{include: "orion.c-like#comment_block"},
						{include: "orion.lib#number_decimal"},
					«ENDIF»
					«IF grammar.inherits(XBASE) »
						{include: "orion.lib#number_hex"},
					«ENDIF»
					«IF keywords.contains('{') && keywords.contains('}')»
						{include: "orion.lib#brace_open"},
						{include: "orion.lib#brace_close"},
					«ENDIF»
					«IF keywords.contains('[') && keywords.contains(']')»
						{include: "orion.lib#bracket_open"},
						{include: "orion.lib#bracket_close"},
					«ENDIF»
					«IF keywords.contains('(') && keywords.contains(')')»
						{include: "orion.lib#parenthesis_open"},
						{include: "orion.lib#parenthesis_close"},
					«ENDIF»
					{
						match: "\\b(?:" + keywords.join("|") + ")\\b",
						name: "keyword.operator.«langId»"
					}
				]
			});
		
			return {
				id: "xtext.«langId»",
				grammars: grammars,
				keywords: keywords
			};
		});
	'''
	
}