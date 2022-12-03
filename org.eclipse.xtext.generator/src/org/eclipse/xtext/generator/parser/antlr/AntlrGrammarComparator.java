/**
 * Copyright (c) 2015, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.parser.antlr;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Compares two charSequences of ANTLR grammars token by token. Ignores
 * differences in white space, and counts line breaks for usable error
 * diagnosis.
 * 
 * @author Christian Schneider - Initial contribution and API
 * @noreference
 */
@Deprecated(forRemoval = true)
public class AntlrGrammarComparator {
	public interface IErrorHandler {
		void handleInvalidGeneratedGrammarFile(ErrorContext context);

		void handleInvalidReferenceGrammarFile(ErrorContext context);

		void handleMismatch(String matched, String expected, ErrorContext context);
	}

	public static final class ErrorContext {
		private MatchState testedGrammar = new MatchState();

		private MatchState referenceGrammar = new MatchState();

		public MatchState reset() {
			testedGrammar = new MatchState();
			return referenceGrammar = new MatchState();
		}

		public MatchState getTestedGrammar() {
			return testedGrammar;
		}

		public void setTestedGrammar(MatchState testedGrammar) {
			this.testedGrammar = testedGrammar;
		}

		public MatchState getReferenceGrammar() {
			return referenceGrammar;
		}

		public void setReferenceGrammar(MatchState referenceGrammar) {
			this.referenceGrammar = referenceGrammar;
		}
	}

	public static final class MatchState {
		private String absoluteFileName;

		private int lineNumber = 1;

		// this value is used to check whether any character sequences have not
		// been matched
		private int position = 0;

		private String previousToken;

		private String currentToken;

		public String getAbsoluteFileName() {
			return absoluteFileName;
		}

		public void setAbsoluteFileName(String absoluteFileName) {
			this.absoluteFileName = absoluteFileName;
		}

		public int getLineNumber() {
			return lineNumber;
		}

		public void setLineNumber(int lineNumber) {
			this.lineNumber = lineNumber;
		}

		public String getPreviousToken() {
			return previousToken;
		}

		public void setPreviousToken(String previousToken) {
			this.previousToken = previousToken;
		}

		public String getCurrentToken() {
			return currentToken;
		}

		public void setCurrentToken(String currentToken) {
			this.currentToken = currentToken;
		}
	}

	private static final List<String> SINGLE_CHAR_TOKENS = Lists.newArrayList("\\(", "\\)", "\\[", "\\]", "\\{", "\\}", "\\|",
			"=", "\\?", "\\*", "\\+", ":", ";");

	// quoted tokens are those like in '\'' or '\'\'\'' occurring in the Xtend
	// grammar,
	// and arbitrary charSequences enclosed in single quotes or double quotes
	private static final String QUOTED_TOKENS = Joiner.on("|")
			.join(Lists.newArrayList("\'(\\\\\')+\'", "(\'[^\']*\')", "(\"[^\"]*\")"));

	// valid tokens are those mentioned in SINGLE_CHAR_TOKENS and those
	// described in QUOTED_TOKENS,
	// as well as character sequences containing no white space (\s), no single
	// quotes ('),
	// no double quotes ("), and none of SINGLE_CHAR_TOKENS
	private static final String TOKEN = new Function0<String>() {
		@Override
		public String apply() {
			StringConcatenation builder = new StringConcatenation();
			builder.append(Joiner.on("|").join(SINGLE_CHAR_TOKENS));
			builder.append("|");
			builder.append(QUOTED_TOKENS);
			builder.append("|[^\\s\'\"");
			builder.append(Joiner.on("").join(SINGLE_CHAR_TOKENS));
			builder.append("]+");
			return builder.toString();
		}
	}.apply();

	// platform neutral definition of newline tokens, they are distinguished for
	// counting lines
	private static final String NEWLINE = "\\r?\\n|\\r";

	// other white space to be ignored, is distinguished for testing for any
	// unmatched character sequences
	private static final String WS = "( |\\t)+";

	// single line comments starting with a '//' and being terminated by the end
	// of the line
	private static final String SL_COMMENT = "//[^\\r\\n]*";

	// multi line comments start with a '/*', may contain an arbitrary amount of
	// '*'s followed by anything else than a '/', and non-'*' characters
	// including newlines and whitespace,
	// and end with a '*/' sequence
	private static final String ML_COMMENT = "/\\*(\\*[^/]|[^\\*])*\\*/";

	private final Pattern p_slComment = Pattern.compile(SL_COMMENT);

	private final Pattern p_mlComment = Pattern.compile(ML_COMMENT);

	private final Pattern p_token = Pattern.compile(TOKEN);

	private final Pattern p_newline = Pattern.compile(NEWLINE);

	private final Pattern p_ws = Pattern.compile(WS);

	private final Pattern compoundPattern = new Function0<Pattern>() {
		@Override
		public Pattern apply() {
			StringConcatenation builder = new StringConcatenation();
			builder.append("(");
			builder.append(SL_COMMENT);
			builder.append(")|(");
			builder.append(ML_COMMENT);
			builder.append(")|(");
			builder.append(TOKEN);
			builder.append(")|(");
			builder.append(NEWLINE);
			builder.append(")|(");
			builder.append(WS);
			builder.append(")");
			return Pattern.compile(builder.toString(), Pattern.MULTILINE);
		}
	}.apply();

	private ErrorContext errorContext;

	/**
	 * Performs the actual comparison of given and expected grammar.
	 * 
	 * @return {@link Pair} containing the number of lines of the tested grammar
	 * (key) and the referenced grammar (value) for logging purposes
	 */
	public ErrorContext compareGrammars(CharSequence grammar, CharSequence grammarReference,
			String absoluteGrammarFileName, String absoluteGrammarFileNameReference, IErrorHandler errorHandler) {
		errorContext = new ErrorContext();
		errorContext.testedGrammar.absoluteFileName = absoluteGrammarFileName;
		errorContext.referenceGrammar.absoluteFileName = absoluteGrammarFileNameReference;
		return compareGrammars(grammar, grammarReference, errorHandler);
	}

	/**
	 * Performs the actual comparison of given and expected grammar.
	 * 
	 * @return {@link Pair} containing the number of lines of the tested grammar
	 * (key) and the referenced grammar (value) for logging purposes
	 */
	public ErrorContext compareGrammars(CharSequence grammar, CharSequence grammarReference,
			IErrorHandler errorHandler) {
		if (errorContext == null) {
			errorContext = new ErrorContext();
		}
		Matcher compoundMatcher = compoundPattern.matcher(grammar);
		Matcher compoundMatcherReference = compoundPattern.matcher(grammarReference);
		boolean cont = true;
		boolean continueReference = true;
		while (cont || continueReference) {
			if (cont) {
				cont = nextToken(compoundMatcher, errorContext.testedGrammar, errorHandler);
			}
			String match = null;
			if (cont) {
				match = compoundMatcher.group();
			} else {
				match = "««eof»»";
			}
			if (continueReference) {
				continueReference = nextToken(compoundMatcherReference, errorContext.referenceGrammar, errorHandler);
			}
			String matchReference = null;
			if (continueReference) {
				matchReference = compoundMatcherReference.group();
			} else {
				matchReference = "««eof»»";
			}
			if (!Objects.equal(matchReference, match)) {
				errorHandler.handleMismatch(match, matchReference, errorContext);
			}
		}
		return errorContext;
	}

	/**
	 * continue matching until the next token is found, count newlines while
	 * doing so.
	 * 
	 * @return the number of newlines passed while searching
	 */
	private boolean nextToken(Matcher matcher, MatchState state, IErrorHandler errorHandler) {
		while (matcher.find()) {
			// available in error messages in case the test below is
			// evaluates to 'true'
			state.currentToken = matcher.group();
			if (matcher.start() != state.position) {
				handleInvalidGrammarFile(errorHandler, state);
			}
			String match = matcher.group();
			state.previousToken = match;
			state.position = matcher.end();
			if (p_newline.matcher(match).matches()) {
				state.lineNumber++;
			} else {
				if (p_slComment.matcher(match).matches() || p_ws.matcher(match).matches()) {
					// do nothing
				} else {
					if (p_mlComment.matcher(match).matches()) {
						Matcher newlines = p_newline.matcher(match);
						while (newlines.find()) {
							state.lineNumber++;
						}
					} else {
						if (p_token.matcher(match).matches()) {
							// in case a valid token has been found stop
							// here
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private void handleInvalidGrammarFile(IErrorHandler errorHandler, MatchState state) {
		if (state == errorContext.testedGrammar) {
			errorHandler.handleInvalidGeneratedGrammarFile(errorContext);
		} else {
			errorHandler.handleInvalidReferenceGrammarFile(errorContext);
		}
	}
}
