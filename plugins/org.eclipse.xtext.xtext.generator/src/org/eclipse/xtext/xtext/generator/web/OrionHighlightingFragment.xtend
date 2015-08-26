/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.web

import java.util.ArrayList
import java.util.Collection
import java.util.HashSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2
import org.eclipse.xtext.xtext.generator.Issues

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.util.GrammarUtil2.*

class OrionHighlightingFragment extends AbstractGeneratorFragment2 {
	
	static val TERMINALS = 'org.eclipse.xtext.common.Terminals'
	static val XBASE = 'org.eclipse.xtext.xbase.Xbase'
	
	val enabledPatterns = new HashSet<String>
	val suppressedPatterns = new HashSet<String>
	
	String langId
	Grammar grammar
	
	@Accessors
	String moduleName
	
	@Accessors
	String keywordsFilter = '\\w*'
	
	/** The default container for JS files is the webapp outlet. */
	@Accessors
	String javaScriptPath = ''
	
	def addEnablePattern(String pattern) {
		enabledPatterns += pattern
	}
	
	def addSuppressPattern(String pattern) {
		suppressedPatterns += pattern
	}
	
	override checkConfiguration(Issues issues) {
		super.checkConfiguration(issues)
		for (pattern : enabledPatterns.filter[suppressedPatterns.contains(it)]) {
			issues.addError('The pattern \'' + pattern + '\' cannot be enabled and suppressed.')
		}
	}
	
	override generate() {
		langId = language.fileExtensions.head
		grammar = language.grammar
		if (moduleName.nullOrEmpty)
			moduleName = 'xtext/generated/' + langId + '-syntax'
		val keywords = grammar.allKeywords
		generateJavaScript(keywords).writeToFile(javaScriptPath + '/' + moduleName + '.js')
	}
	
	protected def writeToFile(CharSequence content, String fileName) {
		if (projectConfig.webApp != null) {
			projectConfig.webApp.generateFile(fileName, content)
		}
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