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
import java.util.ArrayList
import java.util.Collection
import java.util.HashSet
import org.eclipse.emf.mwe2.runtime.Mandatory
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragment2
import org.eclipse.xtext.xtext.generator.Issues
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.xtext.generator.model.TextFileAccess

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.util.Strings.*
import static extension org.eclipse.xtext.xtext.generator.util.GrammarUtil2.*

/**
 * JavaScript-based syntax highlighting for several editor frameworks.
 * Currently supported frameworks:
 * <ul>
 *   <li><a href="http://eclipse.org/orion/">Orion</a></li>
 *   <li><a href="http://ace.c9.io">Ace</a></li>
 *   <li><a href="http://codemirror.net">CodeMirror</a></li>
 * </ul>
 */
class JsHighlightingFragment extends AbstractGeneratorFragment2 {
	
	static val TERMINALS = 'org.eclipse.xtext.common.Terminals'
	static val XBASE = 'org.eclipse.xtext.xbase.Xbase'
	
	private static enum Framework {
		ORION, ACE, CODEMIRROR
	}
	
	@Inject FileAccessFactory fileAccessFactory
	
	String langId
	Grammar grammar
	
	val enabledPatterns = new HashSet<String>
	val suppressedPatterns = new HashSet<String>
	
	Framework framework
	String moduleName
	String keywordsFilter = '\\w*'
	String path
	
	/**
	 * Enable a default pattern for syntax highlighting. See the documentation of the chosen
	 * framework for details.
	 */
	def void addEnablePattern(String pattern) {
		enabledPatterns += pattern
	}
	
	/**
	 * Suppress a default pattern for syntax highlighting. See the documentation of the chosen
	 * framework for details. 
	 */
	def void addSuppressPattern(String pattern) {
		suppressedPatterns += pattern
	}
	
	/**
	 * Choose one of the supported frameworks: {@code "Orion"}, {@code "Ace"}, or {@code "CodeMirror"}
	 */
	@Mandatory
	def void setFramework(String frameworkName) {
		this.framework = Framework.valueOf(frameworkName.toUpperCase)
	}
	
	/**
	 * Name of the RequireJS module to be generated.
	 */
	def void setModuleName(String moduleName) {
		this.moduleName = moduleName
	}
	
	/**
	 * Regular expression for filtering those language keywords that should be highlighted. The default
	 * is {@code \w*}, i.e. keywords consisting only of letters and digits.
	 */
	def void setKeywordsFilter(String keywordsFilter) {
		this.keywordsFilter = keywordsFilter
	}
	
	/**
	 * The path of the JavaScript file to be generated. The default is to derive the path from
	 * the {@code moduleName} property.
	 */
	def void setPath(String path) {
		this.path = path
	}
	
	override checkConfiguration(Issues issues) {
		super.checkConfiguration(issues)
		if (projectConfig.webApp === null)
			issues.addWarning('The webapp outlet is not defined in the project configuration; JS syntax highlighting is disabled.')
		if (framework === null)
			issues.addError('The property \'framework\' is required.')
		for (pattern : enabledPatterns.filter[suppressedPatterns.contains(it)]) {
			issues.addError('The pattern \'' + pattern + '\' cannot be enabled and suppressed.')
		}
	}
	
	override generate() {
		langId = language.fileExtensions.head
		grammar = language.grammar
		if (moduleName.nullOrEmpty) {
			moduleName = switch framework {
				case ORION: 'xtext-resources/generated/' + langId + '-syntax'
				case ACE, case CODEMIRROR: 'xtext-resources/generated/mode-' + langId
			}
		} else if (moduleName.endsWith('.js'))
			moduleName = moduleName.substring(0, moduleName.length - 3)
		if (path.nullOrEmpty)
			path = moduleName + '.js'
		
		if (projectConfig.webApp != null) {
			val keywords = grammar.allKeywords
			generateJavaScript(keywords).writeTo(projectConfig.webApp)
		}
	}
	
	protected def TextFileAccess generateJavaScript(Collection<String> keywords) {
		val filteredKeywords = keywords.filter[matches(keywordsFilter)].map[convertToJavaString].toList
		val jsFile = fileAccessFactory.createTextFile()
		jsFile.path = path
		switch framework {
			
			case ORION: {
				val patterns = createOrionPatterns(keywords, filteredKeywords)
				jsFile.content = '''
					define("«moduleName»", function() {
						var keywords = "«FOR keyword : filteredKeywords.sort SEPARATOR '|'»«keyword»«ENDFOR»";
						return {
							id: "xtext.«langId»",
							contentTypes: ["xtext/«langId»"],
							patterns: [
								«FOR pattern : patterns SEPARATOR ',\n'»«pattern»«ENDFOR»
							]
						};
					});
				'''
			}
			
			case ACE: {
				val patterns = createCodeMirrorPatterns(keywords, filteredKeywords)
				jsFile.content = '''
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
						Mode.prototype.$id = "xtext/«langId»";
						Mode.prototype.getCompletions = function(state, session, pos, prefix) {
							return [];
						}
						
						return {
							Mode: Mode
						};
					});
				'''
			}
			
			case CODEMIRROR: {
				val patterns = createCodeMirrorPatterns(keywords, filteredKeywords)
				jsFile.content = '''
					define("«moduleName»", ["codemirror", "codemirror/addon/mode/simple"], function(CodeMirror, SimpleMode) {
						«IF !filteredKeywords.empty»
							var keywords = "«FOR keyword : filteredKeywords.sort SEPARATOR '|'»«keyword»«ENDFOR»";
						«ENDIF»
						CodeMirror.defineSimpleMode("xtext/«langId»", {
							«FOR state : patterns.keySet SEPARATOR ','»
								«state»: «IF state == 'meta'»{«ELSE»[«ENDIF»
									«FOR rule : patterns.get(state) SEPARATOR ',\n'»«rule»«ENDFOR»
								«IF state == 'meta'»}«ELSE»]«ENDIF»
							«ENDFOR»
						});
					});
				'''
			}
			
		}
		return jsFile
	}
	
	protected def Collection<String> createOrionPatterns(Collection<String> keywords,
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
			patterns += '''{match: "\\b(?:" + keywords + ")\\b", name: "keyword.«langId»"}'''
		
		return patterns
	}
	
	protected def Multimap<String, String> createCodeMirrorPatterns(Collection<String> keywords,
			Collection<String> filteredKeywords) {
		val inheritsTerminals = grammar.inherits(TERMINALS)
		val inheritsXbase = grammar.inherits(XBASE)
		val patterns = LinkedHashMultimap.<String, String>create
		
		val hasSingleLineComment = enabledPatterns.contains('comment_singleLine')
				|| (inheritsTerminals || inheritsXbase) && !suppressedPatterns.contains('comment_singleLine')
		if (hasSingleLineComment)
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
		
		if (framework == Framework.CODEMIRROR && patterns.containsKey('comment'))
			patterns.put('meta', '''dontIndentStates: ["comment"]''')
		if (framework == Framework.CODEMIRROR && hasSingleLineComment)
			patterns.put('meta', '''lineComment: "//"''')
		
		return patterns
	}
	
}