/** 
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.parser

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.xtext.generator.CodeConfig
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.*

/** 
 * @author Christian Dietrich - Initial contribution and API
 */
class JFlexGeneratorFragmentTemplate {

	@Inject
	extension GrammarAccessExtensions = new GrammarAccessExtensions()
	
	def toJavaPackage(String name) {
		val result = name.substring(0, name.lastIndexOf('.'))
		result
	}

	def String generateFlexer(Grammar it, String parserName, String macros, String rules, CodeConfig c) {
		'''
			«c.fileHeader»
			package «parserName.toJavaPackage()»;
			
			import static «parserName».*;
			
			import org.antlr.runtime.Token;
			import org.antlr.runtime.CommonToken;
			import org.antlr.runtime.TokenSource;
			
			@SuppressWarnings({"all"})
			%%
			
			%{
			
			  public InternalXtendFlexer() {
			    this((java.io.Reader)null);
			  }
			
			  public int getTokenLength() {
			    return yylength();
			  }
			  
			  public String getTokenText() {
			    return yytext();
			  }
			  
			%}
			
			%unicode
			%implements org.eclipse.xtend.core.parser.InternalFlexer
			%class InternalXtendFlexer
			%function advance
			%int
			%eofval{
			return Token.EOF;
			%eofval}
				
			«macros»
			
			%%
			
			
			«tokens»
			
			
			«IF rules !== null »
				«rules»
			«ENDIF»
			
			
			«FOR rule : allTerminalRules().filter[r | !r.fragment ]»
				<YYINITIAL> {«rule.name»} { return RULE_«rule.name»; }
			«ENDFOR»
			
		'''
	}

	def tokens(Grammar it) {
		var allKeywords = newArrayList
		for (r : allParserRules) {
			collectTokens(r, allKeywords)
		}
		for (r : allEnumRules) {
			collectTokens(r, allKeywords)
		}
		return '''
			«FOR k : allKeywords.sort»
				«k.state»
			«ENDFOR»
		'''
	}

	def state(String it) {
		'''<YYINITIAL> "«toAntlrString()»" { return KW_«toJavaIdentifier(it, true)»; }'''
	}

	def dispatch void collectTokens(AbstractRule it, List<String> known) {
		collectTokens(alternatives, known)
	}

	def dispatch void collectTokens(Keyword it, List<String> known) {
		!known.contains(value) && known.add(value)
	}

	def dispatch void collectTokens(EObject it, List<String> known) {
		for (e : eContents()) {
			collectTokens(e, known)
		}
	}

}
