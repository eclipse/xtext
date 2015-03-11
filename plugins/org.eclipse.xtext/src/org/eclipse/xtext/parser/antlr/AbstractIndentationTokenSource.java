/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.Stack;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.antlr.AbstractSplittingTokenSource;
import org.eclipse.xtext.parser.antlr.ITokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
public abstract class AbstractIndentationTokenSource extends AbstractSplittingTokenSource {

	protected AbstractIndentationTokenSource(TokenSource delegate) {
		setDelegate(delegate);
	}
	
	protected Stack<Integer> indentationStack = new Stack<Integer>();

	{
		indentationStack.push(0);
	}
	
	protected int currentOffset = 0;
	protected int currentIndentation = 0;
	protected int currentEnd = 0;
	protected int nextOffset = 0;
	
	@Override
	protected boolean shouldSplitToken(Token token) {
		return token.getType() == Token.EOF || shouldSplitTokenImpl(token);
	}
	
	/**
	 * Return {@code true} if the given token is a whitespace token that should be splitted.
	 * Usually the token type will be compared to one of the int constants from the parser.
	 */
	protected abstract boolean shouldSplitTokenImpl(Token token);

	@Override
	protected void doSplitToken(Token token, ITokenAcceptor result) {
		if (token.getType() == Token.EOF) {
			if (shouldEmitPendingEndTokens()) {
				while(indentationStack.size() > 1) {
					indentationStack.pop();
					result.accept(createEndToken(nextOffset));
				}
			}
			result.accept(token);
			return;
		}
		doSplitTokenImpl(token, result);
	}
	
	protected boolean shouldEmitPendingEndTokens() {
		return true;
	}
	
	@Override
	public Token nextToken() {
		Token result = super.nextToken();
		if (result instanceof CommonToken) {
			nextOffset = ((CommonToken) result).getStopIndex() + 1;
		} else {
			throw new IllegalArgumentException(String.valueOf(result));
		}
		return result;
	}

	/**
	 * The token was previously determined as potentially to-be-splitted.
	 */
	protected void doSplitTokenImpl(Token token, ITokenAcceptor result) {
		String text = token.getText();
		int indentation = computeIndentation(text);
		if (indentation == -1 || indentation == currentIndentation) {
			result.accept(token);
		} else if (indentation > currentIndentation) {
			splitIntoBeginToken(token, indentation, result);
		} else if (indentation < currentIndentation) {
			while(indentation < currentIndentation) {
				indentationStack.pop();
				currentIndentation = indentationStack.peek();
				result.accept(createEndToken(nextOffset));
			}
			if (indentation > currentIndentation) {
				splitIntoBeginToken(token, indentation, result);
				return;
			}
			result.accept(token);
		} else {
			throw new IllegalStateException(String.valueOf(indentation));
		}
	}

	private void splitIntoBeginToken(Token token, int indentation, ITokenAcceptor result) {
		result.accept(token);
		indentationStack.push(indentation);
		currentIndentation = indentation;
		result.accept(createBeginToken(((CommonToken) token).getStopIndex() + 1));
	}

	protected Token createEndToken(int offset) {
		CommonToken result = new CommonToken(getEndTokenType());
		result.setText("");
		result.setChannel(Token.DEFAULT_CHANNEL);
		result.setStartIndex(offset);
		result.setStopIndex(offset-1);
		return result;
	}
	
	protected abstract int getEndTokenType();
	protected abstract int getBeginTokenType();

	protected Token createBeginToken(int offset) {
		CommonToken result = new CommonToken(getBeginTokenType());
		result.setText("");
		result.setChannel(Token.DEFAULT_CHANNEL);
		result.setStartIndex(offset);
		result.setStopIndex(offset-1);
		return result;
	}

	protected int computeIndentation(String text) {
		int result = 0;
		for(int i = text.length() - 1; i>=0; i--) {
			char c = text.charAt(i);
			if (c == '\n' || c == '\r') {
				return result;
			}
			if (c == '\t') {
				result+=getTabWidth();
			} else {
				result++;
			}
		}
		return -1;
	}

	protected char getTabWidth() {
		return 8;
	}
	
}