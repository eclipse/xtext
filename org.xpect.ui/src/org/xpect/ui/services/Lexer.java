package org.xpect.ui.services;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public abstract class Lexer extends org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer {
	public Lexer() {
		super();
	}

	public Lexer(CharStream input) {
		super(input);
	}

	public Lexer(CharStream input, RecognizerSharedState state) {
		super(input, state);
	}

	public boolean matches(String foo) {
		state.backtracking++;
		int start = input.mark();
		try {
			match(foo);
		} catch (RecognitionException re) {
			System.err.println("impossible: " + re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed = false;
		return success;
	}
}
