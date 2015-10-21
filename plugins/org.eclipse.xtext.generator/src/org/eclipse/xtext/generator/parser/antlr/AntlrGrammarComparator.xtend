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

	public interface IErrorHandler {
		def void handleInvalidGeneratedGrammarFile(ErrorContext context);
		
		def void handleInvalidReferenceGrammarFile(ErrorContext context);
		
		def void handleMismatch(String matched, String expected, ErrorContext context);
	}
	
	public static final class ErrorContext {
		@Accessors
		private AntlrGrammarComparator.MatchState testedGrammar = new MatchState()

		@Accessors
		private AntlrGrammarComparator.MatchState referenceGrammar = new MatchState()
		
		def reset() {
			testedGrammar = new MatchState()
			referenceGrammar = new MatchState()
		}
	}
	
	public static final class MatchState {
		@Accessors
		private String absoluteFileName;
		
		@Accessors
		private int lineNumber = 1
		
		// this value is used to check whether any character sequences have not been matched
		private int position = 0	
		
		@Accessors
		private String previousToken
		
		@Accessors
		private String currentToken
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
	
	private ErrorContext errorContext

	/**
	 * Performs the actual comparison of given and expected grammar.
	 * 
	 * @return {@link Pair} containing the number of lines of the tested grammar (key)
	 * 			and the referenced grammar (value) for logging purposes
	 */
	public def compareGrammars(CharSequence grammar, CharSequence grammarReference,
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
	public def compareGrammars(CharSequence grammar, CharSequence grammarReference,
			IErrorHandler errorHandler) {
		
		if (errorContext == null) {			
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
			
			if (p_newline.matcher(match).matches()) {
				state.position = matcher.end
				state.lineNumber++
			
			} else if (p_ws.matcher(match).matches) {
				state.position = matcher.end
				
			} else if (p_token.matcher(match).matches()) {
				state.position = matcher.end
			
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