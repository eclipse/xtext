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
import org.eclipse.xpand2.XpandExecutionContext
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.generator.LanguageConfig
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment

class AceHighlightingFragment extends Xtend2GeneratorFragment {
	
	static val TERMINALS = 'org.eclipse.xtext.common.Terminals'
	static val XBASE = 'org.eclipse.xtext.xbase.Xbase'
	
	val enabledPatterns = new HashSet<String>
	val suppressedPatterns = new HashSet<String>
	
	String langId
	Grammar grammar
	
	@Accessors
	String javaScriptPath
	
	@Accessors
	String keywordsFilter = '\\w*'
	
	def addEnablePattern(String pattern) {
		if (suppressedPatterns.contains(pattern))
			throw new IllegalArgumentException('Cannot enable a suppressed pattern.')
		enabledPatterns += pattern
	}
	
	def addSuppressPattern(String pattern) {
		if (enabledPatterns.contains(pattern))
			throw new IllegalArgumentException('Cannot suppress an enabled pattern.')
		suppressedPatterns += pattern
	}
	
	override generate(LanguageConfig config, XpandExecutionContext ctx) {
		langId = config.getFileExtensions(config.grammar).head
		grammar = config.grammar
		super.generate(config, ctx)
	}
	
	override generate(Xtend2ExecutionContext ctx) {
		val keywords = grammar.keywords
		generateJavaScript(keywords).writeToFile('mode-' + langId + '.js')
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
		define("xtext/mode-«langId»", ["ace/lib/oop", "ace/mode/text", "ace/mode/text_highlight_rules"], function(oop, mText, mTextHighlightRules) {
			var HighlightRules = function() {
				«IF !filteredKeywords.empty»
					var keywords = "«FOR keyword : filteredKeywords.sort SEPARATOR '|'»«keyword»«ENDFOR»";
				«ENDIF»
				this.$rules = {
					"start": [
						«IF !filteredKeywords.empty»
							{token: "keyword", regex: "\\b(?:" + keywords + ")\\b"}
						«ENDIF»
					]
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
	
	protected def Collection<String> createPatterns(Collection<String> keywords,
			Collection<String> filteredKeywords) {
		val patterns = new ArrayList<String>
		return patterns
	}
	
}