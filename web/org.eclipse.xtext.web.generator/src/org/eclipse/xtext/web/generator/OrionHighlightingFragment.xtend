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
import java.util.ArrayList
import java.util.Collection
import java.util.HashSet
import java.util.Set
import org.eclipse.emf.mwe.core.issues.Issues
import org.eclipse.xpand2.XpandExecutionContext
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.generator.LanguageConfig
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment

/**
 * This implementation is outdated and will be removed before the Xtext 2.9.0 release.
 * 
 * @deprecated Use org.eclipse.xtext.xtext.generator.web.JsHighlightingFragment
 */
@Deprecated
class OrionHighlightingFragment extends Xtend2GeneratorFragment {
	
	static val TERMINALS = 'org.eclipse.xtext.common.Terminals'
	static val XBASE = 'org.eclipse.xtext.xbase.Xbase'
	
	val enabledPatterns = new HashSet<String>
	val suppressedPatterns = new HashSet<String>
	
	String langId
	Grammar grammar
	
	@Accessors
	String javaScriptPath
	
	@Accessors
	String moduleName
	
	@Accessors
	String keywordsFilter = '\\w*'
	
	def addEnablePattern(String pattern) {
		enabledPatterns += pattern
	}
	
	def addSuppressPattern(String pattern) {
		suppressedPatterns += pattern
	}
	
	override checkConfiguration(Issues issues) {
		super.checkConfiguration(issues)
		if (javaScriptPath === null)
			issues.addError('The property \'javaScriptPath\' must be set.')
		for (pattern : enabledPatterns.filter[suppressedPatterns.contains(it)]) {
			issues.addError('The pattern \'' + pattern + '\' cannot be enabled and suppressed.')
		}
	}
	
	override generate(LanguageConfig config, XpandExecutionContext ctx) {
		langId = config.getFileExtensions(config.grammar).head
		grammar = config.grammar
		if (moduleName.nullOrEmpty)
			moduleName = 'xtext/' + langId + '-syntax'
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
	
	protected def generateJavaScript(Collection<String> keywords) {
		val filteredKeywords = keywords.filter[matches(keywordsFilter)].toList
		val patterns = createPatterns(keywords, filteredKeywords)
		
		'''
		define("«moduleName»", ["orion/editor/stylers/lib/syntax"], function(mLib) {
			var keywords = [«FOR keyword : filteredKeywords.sort SEPARATOR ', '»"«keyword»"«ENDFOR»];
		
			var grammars = [];
			grammars.push.apply(grammars, mLib.grammars);
			grammars.push({
				id: "xtext.«langId»",
				contentTypes: ["xtext/«langId»"],
				patterns: [
					«FOR pattern : patterns SEPARATOR ',\n'»«pattern»«ENDFOR»
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
	
	protected def Collection<String> createPatterns(Collection<String> keywords,
			Collection<String> filteredKeywords) {
		val inheritsTerminals = grammar.inherits(TERMINALS)
		val inheritsXbase = grammar.inherits(XBASE)
		val patterns = new ArrayList<String>
		
		if (enabledPatterns.contains('comment_singleLine')
				|| (inheritsTerminals || inheritsXbase) && !suppressedPatterns.contains('comment_singleLine'))
			patterns += '{include: "orion.c-like#comment_singleLine"}'
		
		if (enabledPatterns.contains('comment_block')
				|| (inheritsTerminals || inheritsXbase) && !suppressedPatterns.contains('comment_block'))
			patterns += '{include: "orion.c-like#comment_block"}'
		
		if (enabledPatterns.contains('string_doubleQuote')
				|| (inheritsTerminals || inheritsXbase) && !suppressedPatterns.contains('string_doubleQuote'))
			patterns += '{include: "orion.lib#string_doubleQuote"}'
		
		if (enabledPatterns.contains('string_singleQuote')
				|| (inheritsTerminals || inheritsXbase) && !suppressedPatterns.contains('string_singleQuote'))
			patterns += '{include: "orion.lib#string_singleQuote"}'
		
		if (enabledPatterns.contains('number_decimal')
				|| (inheritsTerminals || inheritsXbase) && !suppressedPatterns.contains('number_decimal'))
			patterns += '{include: "orion.lib#number_decimal"}'
		
		if (enabledPatterns.contains('number_hex')
				|| inheritsXbase && !suppressedPatterns.contains('number_hex'))
			patterns += '{include: "orion.lib#number_hex"}'
		
		if (enabledPatterns.contains('brace_open')
				|| keywords.contains('{') && !suppressedPatterns.contains('brace_open'))
			patterns += '{include: "orion.lib#brace_open"}'
		
		if (enabledPatterns.contains('brace_close')
				|| keywords.contains('}') && !suppressedPatterns.contains('brace_close'))
			patterns += '{include: "orion.lib#brace_close"}'
		
		if (enabledPatterns.contains('bracket_open')
				|| keywords.contains('[') && !suppressedPatterns.contains('bracket_open'))
			patterns += '{include: "orion.lib#bracket_open"}'
		
		if (enabledPatterns.contains('bracket_close')
				|| keywords.contains(']') && !suppressedPatterns.contains('bracket_close'))
			patterns += '{include: "orion.lib#bracket_close"}'
		
		if (enabledPatterns.contains('parenthesis_open')
				|| keywords.contains('(') && !suppressedPatterns.contains('parenthesis_open'))
			patterns += '{include: "orion.lib#parenthesis_open"}'
		
		if (enabledPatterns.contains('parenthesis_close')
				|| keywords.contains(')') && !suppressedPatterns.contains('parenthesis_close'))
			patterns += '{include: "orion.lib#parenthesis_close"}'
		
		if (enabledPatterns.contains('doc_block'))
			patterns += '{include: "orion.lib#doc_block"}'
		
		if (!filteredKeywords.empty)
			patterns += '''{match: "\\b(?:" + keywords.join("|") + ")\\b", name: "keyword.operator.«langId»"}'''
		
		return patterns
	}
	
}