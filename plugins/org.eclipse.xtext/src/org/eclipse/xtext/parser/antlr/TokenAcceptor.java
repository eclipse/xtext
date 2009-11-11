package org.eclipse.xtext.parser.antlr;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.antlr.runtime.Token;

/**
 * Simple implementation of an ITokenAcceptor based on the assumption 
 * that the calls to accept and next will be alternating with only a few
 * exceptions.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TokenAcceptor implements ITokenAcceptor, Iterator<Token> {

	private Queue<Token> queue = new LinkedList<Token>();
	
	public void accept(Token token) {
		queue.offer(token);
	}
	
	public boolean hasNext() {
		return queue.peek() != null;
	}
	
	public Token next() {
		return queue.remove();
	}
	
	// array based implementation:
	// passes the tests and is nearly 2 times faster then the 
	// queue based implementation. However it introduces a lot 
	// more complexity. In case the token acceptor is to slow
	// the more complex impl could be activated.
	
//	private Token[] tokens = new Token[2];
//	private int insertHere = 0;
//	private int next = 0;
//	
//	public void accept(Token token) {
//		tokens[insertHere] = token;
//		if (insertHere == tokens.length - 1) 
//			insertHere = 0;
//		else
//			insertHere++;
//		if (insertHere == next) {
//			Token[] oldTokens = tokens;
//			tokens = new Token[oldTokens.length * 2];
//			System.arraycopy(oldTokens, next, tokens, next + oldTokens.length, oldTokens.length - next);
//			if (next != 0) {
//				System.arraycopy(oldTokens, 0, tokens, 0, next);
//			}
//			next = next + oldTokens.length;
//		}
//	}
//
//	public boolean hasNext() {
//		return insertHere != next;
//	}
//
//	public Token next() {
//		if (!hasNext())
//			throw new NoSuchElementException("call hasNext before next");
//		Token result = tokens[next];
//		if (next == tokens.length - 1) 
//			next = 0;
//		else
//			next++;
//		return result;
//	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}