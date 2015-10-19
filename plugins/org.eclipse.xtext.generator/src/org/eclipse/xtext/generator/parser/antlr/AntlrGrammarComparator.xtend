/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr

import java.util.regex.Matcher
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Compares two charSequences of ANTLR grammars token by token.
 * Ignores differences in white space, and counts line breaks for usable error diagnosis. 
 * 
 * @author Christian Schneider - Initial contribution and API
 * @since 2.9
 */
class AntlrGrammarComparator {

	public abstract static class AbstractErrorHandler {

		@Accessors(PUBLIC_GETTER)
		private int lineNumber = 1
		
		@Accessors(PUBLIC_GETTER)
		private int lineNumberReference = 1
		
		@Accessors
		private String absoluteGrammarFileName
		
		@Accessors
		private String absoluteGrammarFileNameReference
		
		private boolean treatingReferenceGrammar = false;
		
		private def void handleUnexpectedCharSequence(int lineCount) {
			if (treatingReferenceGrammar) {
				handleUnexpectedCharSequence(absoluteGrammarFileNameReference, lineNumberReference + lineCount)
			} else {				
				handleUnexpectedCharSequence(absoluteGrammarFileName, lineNumber + lineCount)
			}
		}
		
		def void handleUnexpectedCharSequence(String absoluteGrammarFileName, int lineNo);
		
		def void handleMismatch(String match, String matchReference);
	}
	
	
	private static val SINGLE_CHAR_TOKENS = #[
		'\\(', '\\)', '\\[', '\\]', '\\{', '\\}', '\\|', '=', '\\?', '\\*', '\\+', ':', ';'
	]
	
	// quoted tokens are those like in '\'' or '\'\'\'' occurring in the Xtend grammar,
	//  and arbitrary charSequences enclosed in single quotes or double quotes
	private static val QUOTED_TOKENS = #[
		"'(\\\\')+'", "('[^']*')", '("[^"]*")'
	].join('|')
	
	// valid tokens are those mentioned in SINGLE_CHAR_TOKENS and those described in QUOTED_TOKENS,
	// as well as character sequences containing no white space (\s), no single quotes ('),
	//  no double quotes ("), and none of SINGLE_CHAR_TOKENS 
	private static val TOKEN = '''«SINGLE_CHAR_TOKENS.join('|')»|«QUOTED_TOKENS»|[^\s'"«SINGLE_CHAR_TOKENS.join»]+''';
	
	// platform neutral definition of newline tokens, they are distinguished for counting lines
	private static val NEWLINE = "\\r?\\n|\\r"
	
	// other white space to be ignored, is distinguished for testing for any unmatched character sequences
	private static val WS = "( |\\t)+"		
	
	private val p_token = Pattern.compile(TOKEN)
	private val p_newline = Pattern.compile(NEWLINE)
	private val p_ws = Pattern.compile(WS)
	private val compoundPattern = Pattern.compile('''(«TOKEN»)|(«NEWLINE»)|(«WS»)''', Pattern.MULTILINE) 		

	
	/**
	 * Performs the actual comparison of given and expected grammar.
	 * 
	 * @return {@link Pair} containing the number of lines of the tested grammar (key)
	 * 			and the referenced grammar (value) for logging purposes
	 */
	public def compareGrammars(CharSequence grammar, CharSequence grammarReference,
			AbstractErrorHandler errorHandler) {

		val compoundMatcher = compoundPattern.matcher(grammar)
		val compoundMatcherReference = compoundPattern.matcher(grammarReference)
		
		// these values are used to check whether any character sequences have not been matched
		var previousEnd = 0;
		var previousEndReference = 0;
		
		var continue = true
		var continueReference = true 
		
		while (continue || continueReference) {
			if (continue) {
				errorHandler.treatingReferenceGrammar = false
				
				val res = compoundMatcher.nextToken(previousEnd, errorHandler)
				continue = res.key
				errorHandler.lineNumber += res.value
				
				if (continue) {
					previousEnd = compoundMatcher.end
				}
			}
			val match = if (continue) compoundMatcher.group else "««eof»»"
			
			if (continueReference) {
				errorHandler.treatingReferenceGrammar = true
				
				val res = compoundMatcherReference.nextToken(previousEndReference, errorHandler)
				continueReference = res.key
				errorHandler.lineNumberReference += res.value
				
				if (continueReference) {
					previousEndReference = compoundMatcherReference.end
				}
			}			 
			
			val matchReference = if (continueReference) compoundMatcherReference.group else "««eof»»"
			
			if (matchReference != match) {
				errorHandler.handleMismatch(match, matchReference)
			}
		}
	}
	
	/**
	 * continue matching until the next token is found, count newlines while doing so.
	 * 
	 * @return the number of newlines passed while searching 
	 */
	def private nextToken(Matcher matcher, int previousEnd, AbstractErrorHandler errorHandler) {
		var newlineCounter = 0;
		var thePreviousEnd = previousEnd
		
		while (matcher.find()) {
			if (matcher.start() != thePreviousEnd) {
				errorHandler.handleUnexpectedCharSequence(newlineCounter)
			}
			
			val match = matcher.group()
			
			if (p_newline.matcher(match).matches()) {
				// in case the 'newline' pattern matches the found 'match' ...
				newlineCounter++
				thePreviousEnd = matcher.end
				
			} else if (p_ws.matcher(match).matches) {
				thePreviousEnd = matcher.end
				
			} else if (p_token.matcher(match).matches()) {
				// in case a valid token has been found stop here
				return Pair.of(true, newlineCounter)
			}
		}
		
		return Pair.of(false, newlineCounter)
	}
}