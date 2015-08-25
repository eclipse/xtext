/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.web

import com.google.common.collect.LinkedHashMultimap
import com.google.common.collect.Multimap
import com.google.inject.Inject
import java.util.Collection
import java.util.HashSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2
import org.eclipse.xtext.xtext.generator.IXtextProjectConfig

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.util.GrammarUtil2.*
import org.eclipse.xtext.xtext.generator.Issues

class AceHighlightingFragment extends AbstractGeneratorFragment2 {
	
	static val TERMINALS = 'org.eclipse.xtext.common.Terminals'
	static val XBASE = 'org.eclipse.xtext.xbase.Xbase'
	
	val enabledPatterns = new HashSet<String>
	val suppressedPatterns = new HashSet<String>
	
	String langId
	Grammar grammar
	
	@Inject IXtextProjectConfig config
	
	@Accessors
	String moduleName
	
	@Accessors
	String keywordsFilter = '\\w*'
	
	@Accessors String javaScriptPath = 'xtext/generated'
	
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
			moduleName = 'xtext/mode-' + langId
		val keywords = grammar.allKeywords
		generateJavaScript(keywords).writeToFile(javaScriptPath+ '/mode-' + langId + '.js')
	}
	
	protected def writeToFile(CharSequence content, String fileName) {
		if (config.webWebApp != null) {
			config.webWebApp.generateFile(fileName, content)
		}
	}
	
	protected def generateJavaScript(Collection<String> keywords) {
		val filteredKeywords = keywords.filter[matches(keywordsFilter)].toList
		val patterns = createPatterns(keywords, filteredKeywords)
		
		'''
		define("«moduleName»", ["ace/lib/oop", "ace/mode/text", "ace/mode/text_highlight_rules"], function(oop, mText, mTextHighlightRules) {
			var HighlightRules = function() {
				«IF !filteredKeywords.empty»
					var keywords = "«FOR keyword : filteredKeywords.sort SEPARATOR '|'»«keyword»«ENDFOR»";
				«ENDIF»
				this.$rules = {
					«FOR state : patterns.keySet SEPARATOR ','»
						"«state»": [
							«FOR rule : patterns.get(state) SEPARATOR ',\n'»«rule»«ENDFOR»
						]
					«ENDFOR»
				};
			};
			oop.inherits(HighlightRules, mTextHighlightRules.TextHighlightRules);
			
			var Mode = function() {
				this.HighlightRules = HighlightRules;
			};
			oop.inherits(Mode, mText.Mode);
			Mode.prototype.$id = "xtext/mode/«langId»";
			Mode.prototype.getCompletions = function(state, session, pos, prefix) {
				return [];
			}
			
			return {
				Mode: Mode
			};
		});
		'''
	}
	
	protected def Multimap<String, String> createPatterns(Collection<String> keywords,
			Collection<String> filteredKeywords) {
		val inheritsTerminals = grammar.inherits(TERMINALS)
		val inheritsXbase = grammar.inherits(XBASE)
		val patterns = LinkedHashMultimap.<String, String>create
		
		if (enabledPatterns.contains('comment_singleLine')
				|| (inheritsTerminals || inheritsXbase) && !suppressedPatterns.contains('comment_singleLine'))
			patterns.put('start', '''{token: "comment", regex: "\\/\\/.*$"}''')
		
		if (enabledPatterns.contains('comment_block')
				|| (inheritsTerminals || inheritsXbase) && !suppressedPatterns.contains('comment_block')) {
			patterns.put('start', '''{token: "comment", regex: "\\/\\*", next : "comment"}''')
			patterns.put('comment', '''{token: "comment", regex: ".*?\\*\\/", next : "start"}''')
			patterns.put('comment', '''{token: "comment", regex: ".+"}''')
		}
		
		if (enabledPatterns.contains('string_doubleQuote')
				|| (inheritsTerminals || inheritsXbase) && !suppressedPatterns.contains('string_doubleQuote'))
			patterns.put('start', '''{token: "string", regex: '["](?:(?:\\\\.)|(?:[^"\\\\]))*?["]'}''')
		
		if (enabledPatterns.contains('string_singleQuote')
				|| (inheritsTerminals || inheritsXbase) && !suppressedPatterns.contains('string_singleQuote'))
			patterns.put('start', '''{token: "string", regex: "['](?:(?:\\\\.)|(?:[^'\\\\]))*?[']"}''')
		
		if (enabledPatterns.contains('number_decimal')
				|| (inheritsTerminals || inheritsXbase) && !suppressedPatterns.contains('number_decimal'))
			patterns.put('start', '''{token: "constant.numeric", regex: "[+-]?\\d+(?:(?:\\.\\d*)?(?:[eE][+-]?\\d+)?)?\\b"}''')
		
		if (enabledPatterns.contains('number_hex')
				|| inheritsXbase && !suppressedPatterns.contains('number_hex'))
			patterns.put('start', '''{token: "constant.numeric", regex: "0[xX][0-9a-fA-F]+\\b"}''')
		
		val bracketOpen = enabledPatterns.contains('bracket_open') || keywords.contains('[') && !suppressedPatterns.contains('bracket_open')
		val parenOpen = enabledPatterns.contains('parenthesis_open') || keywords.contains('(') && !suppressedPatterns.contains('parenthesis_open')
		val braceOpen = enabledPatterns.contains('brace_open') || keywords.contains('{') && !suppressedPatterns.contains('brace_open')
		if (bracketOpen || parenOpen || braceOpen)
			patterns.put('start', '''{token: "lparen", regex: "[«IF bracketOpen»\\[«ENDIF»«IF parenOpen»(«ENDIF»«IF braceOpen»{«ENDIF»]"}''')
		
		val bracketClose = enabledPatterns.contains('bracket_close') || keywords.contains(']') && !suppressedPatterns.contains('bracket_close')
		val parenClose = enabledPatterns.contains('parenthesis_close') || keywords.contains(')') && !suppressedPatterns.contains('parenthesis_close')
		val braceClose = enabledPatterns.contains('brace_close') || keywords.contains('}') && !suppressedPatterns.contains('brace_close')
		if (bracketClose || parenClose || braceClose)
			patterns.put('start', '''{token: "rparen", regex: "[«IF bracketClose»\\]«ENDIF»«IF parenClose»)«ENDIF»«IF braceClose»}«ENDIF»]"}''')
		
		if (!filteredKeywords.empty)
			patterns.put('start', '''{token: "keyword", regex: "\\b(?:" + keywords + ")\\b"}''')
		
		return patterns
	}
	
}