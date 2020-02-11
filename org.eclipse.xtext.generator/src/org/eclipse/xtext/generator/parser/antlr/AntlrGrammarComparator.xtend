/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
 * @noreference
 */
@Deprecated
class AntlrGrammarComparator {

	interface IErrorHandler {
		def void handleInvalidGeneratedGrammarFile(ErrorContext context);
		
		def void handleInvalidReferenceGrammarFile(ErrorContext context);
		
		def void handleMismatch(String matched, String expected, ErrorContext context);
	}
	
	static final class ErrorContext {
		@Accessors
		AntlrGrammarComparator.MatchState testedGrammar = new MatchState()

		@Accessors
		AntlrGrammarComparator.MatchState referenceGrammar = new MatchState()
		
		def reset() {
			testedGrammar = new MatchState()
			referenceGrammar = new MatchState()
		}
	}
	
	static final class MatchState {
		@Accessors
		String absoluteFileName;
		
		@Accessors
		int lineNumber = 1
		
		// this value is used to check whether any character sequences have not been matched
		int position = 0
		
		@Accessors
		String previousToken
		
		@Accessors
		String currentToken
	}
	
	
	static val SINGLE_CHAR_TOKENS = #[
		'\\(', '\\)', '\\[', '\\]', '\\{', '\\}', '\\|', '=', '\\?', '\\*', '\\+', ':', ';'
	]
	
	// quoted tokens are those like in '\'' or '\'\'\'' occurring in the Xtend grammar,
	//  and arbitrary charSequences enclosed in single quotes or double quotes
	static val QUOTED_TOKENS = #[
		"'(\\\\')+'", "('[^']*')", '("[^"]*")'
	].join('|')
	
	// valid tokens are those mentioned in SINGLE_CHAR_TOKENS and those described in QUOTED_TOKENS,
	// as well as character sequences containing no white space (\s), no single quotes ('),
	//  no double quotes ("), and none of SINGLE_CHAR_TOKENS 
	static val TOKEN = '''«SINGLE_CHAR_TOKENS.join('|')»|«QUOTED_TOKENS»|[^\s'"«SINGLE_CHAR_TOKENS.join»]+''';
	
	// platform neutral definition of newline tokens, they are distinguished for counting lines
	static val NEWLINE = "\\r?\\n|\\r"
	
	// other white space to be ignored, is distinguished for testing for any unmatched character sequences
	static val WS = "( |\\t)+"
	
	// single line comments starting with a '//' and being terminated by the end of the line
	static val SL_COMMENT = "//[^\\r\\n]*"
	
	// multi line comments start with a '/*', may contain an arbitrary amount of
	//  '*'s followed by anything else than a '/', and non-'*' characters including newlines and whitespace,
	//  and end with a '*/' sequence
	static val ML_COMMENT = '''/\*(\*[^/]|[^\*])*\*/'''
	
	val p_slComment = Pattern.compile(SL_COMMENT)
	val p_mlComment = Pattern.compile(ML_COMMENT)
	val p_token = Pattern.compile(TOKEN)
	val p_newline = Pattern.compile(NEWLINE)
	val p_ws = Pattern.compile(WS)
	val compoundPattern = Pattern.compile('''(«SL_COMMENT»)|(«ML_COMMENT»)|(«TOKEN»)|(«NEWLINE»)|(«WS»)''', Pattern.MULTILINE)
	
	ErrorContext errorContext

	/**
	 * Performs the actual comparison of given and expected grammar.
	 * 
	 * @return {@link Pair} containing the number of lines of the tested grammar (key)
	 * 			and the referenced grammar (value) for logging purposes
	 */
	def compareGrammars(CharSequence grammar, CharSequence grammarReference,
			String absoluteGrammarFileName, String absoluteGrammarFileNameReference, IErrorHandler errorHandler) {
		errorContext = new ErrorContext()
		
		errorContext.testedGrammar.absoluteFileName = absoluteGrammarFileName
		errorContext.referenceGrammar.absoluteFileName = absoluteGrammarFileNameReference
		
		return compareGrammars(grammar, grammarReference, errorHandler)
	}
	
	/**
	 * Performs the actual comparison of given and expected grammar.
	 * 
	 * @return {@link Pair} containing the number of lines of the tested grammar (key)
	 * 			and the referenced grammar (value) for logging purposes
	 */
	def compareGrammars(CharSequence grammar, CharSequence grammarReference,
			IErrorHandler errorHandler) {
		
		if (errorContext === null) {			
			errorContext = new ErrorContext()
		}
		
		val compoundMatcher = compoundPattern.matcher(grammar)
		val compoundMatcherReference = compoundPattern.matcher(grammarReference)
		
		var continue = true
		var continueReference = true 
		
		while (continue || continueReference) {
			if (continue) {
				continue = compoundMatcher.nextToken(errorContext.testedGrammar, errorHandler)
			}
			val match = if (continue) compoundMatcher.group else "««eof»»"
			
			if (continueReference) {
				continueReference = compoundMatcherReference.nextToken(errorContext.referenceGrammar, errorHandler)
			}			 
			val matchReference = if (continueReference) compoundMatcherReference.group else "««eof»»"
			
			if (matchReference != match) {
				errorHandler.handleMismatch(match, matchReference, errorContext)
			}
		}
		
		return errorContext
	}
	
	/**
	 * continue matching until the next token is found, count newlines while doing so.
	 * 
	 * @return the number of newlines passed while searching 
	 */
	def private nextToken(Matcher matcher, AntlrGrammarComparator.MatchState state, IErrorHandler errorHandler) {
		
		while (matcher.find()) {
			
			// available in error messages in case the test below is evaluates to 'true'
			state.currentToken = matcher.group
			
			if (matcher.start() != state.position) {				
				errorHandler.handleInvalidGrammarFile(state)
			}
			
			val match = matcher.group()
			state.previousToken = match
			state.position = matcher.end
			
			if (p_newline.matcher(match).matches()) {
				state.lineNumber++
			
			} else if (p_slComment.matcher(match).matches || p_ws.matcher(match).matches) {
				// do nothing
			
			} else if (p_mlComment.matcher(match).matches) {
				val newlines = p_newline.matcher(match);
				while (newlines.find) {
					state.lineNumber++;
				}
			
			} else if (p_token.matcher(match).matches()) {
				// in case a valid token has been found stop here
				return true
			}
		}
		
		return false
	}
	
	private def handleInvalidGrammarFile(IErrorHandler errorHandler, AntlrGrammarComparator.MatchState state) {
		if (state === errorContext.testedGrammar) {
			errorHandler.handleInvalidGeneratedGrammarFile(errorContext)
		} else {				
			errorHandler.handleInvalidReferenceGrammarFile(errorContext)
		}
	}
}
