/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSourceAccess;
import org.eclipse.xtext.ui.editor.model.ILexerTokenRegion;
import org.eclipse.xtext.ui.editor.model.Regions;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.common.base.Predicate;
import com.google.common.collect.UnmodifiableIterator;
import com.google.inject.Inject;

/**
 * TokenScanner implementation based on {@link XtextDocument#getTokens()}
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Use reentrant iterator to reduce runtime complexity
 */
public class TokenScanner extends AbstractTokenScanner {

	private RangedReentrantIterator reentrantIterator = new RangedReentrantIterator();
	private ILexerTokenRegion currentToken;
	
	/**
	 * <p>A reentrant iterator allows to reuse and filter the elements another iterator
	 * and may update its filter criteria continuously.</p>
	 * <p>It is assumed that {@link #setRange(IDocument, int, int)} will be called with
	 * ascending order most of the time thus a sorted iterator may be reused and traversed
	 * further after the range has been updated.</p> 
	 */
	protected class RangedReentrantIterator extends UnmodifiableIterator<ILexerTokenRegion> {
		
		private Iterator<ILexerTokenRegion> delegate;
		private Iterable<ILexerTokenRegion> delegateIterable;
		private ILexerTokenRegion current = null;
		private boolean computedHasNext = false;
		private boolean hasNext = false;
		private Predicate<? super IRegion> overlapFilter;
		private int regionOffset;
		
		@Override
		public boolean hasNext() {
			// we already know whether we have a next element
			if (computedHasNext)
				return hasNext;
			
			computedHasNext = true;
			while (delegate.hasNext()) {
				current = delegate.next();
				if (overlapFilter.apply(current)) {
					hasNext = true;
					break;
				} else {
					// filter until we leave the valid region - no need to iterate
					// the delegate until it's done
					if (current.getOffset() > regionOffset) {
						hasNext = false;
						break;
					}
				}
			} 
			return hasNext;
		}

		@Override
		public ILexerTokenRegion next() {
			if (!computedHasNext) {
				// compute hasNext on demand to make sure the internal state is valid
				hasNext();
			}
			if (!hasNext) {
				throw new NoSuchElementException("You should check for #hasNext prior to calling #next");
			}
			ILexerTokenRegion result = current;
			current = null;
			computedHasNext = false;
			hasNext = false;
			return result;
		}
		
		public void setRange(IDocument document, final int offset, final int length) {
			this.regionOffset = offset;
			overlapFilter = Regions.overlaps(offset, length);
			Iterable<ILexerTokenRegion> newIterable = getTokens(document);
			if (delegateIterable != null) {
				if (!delegateIterable.equals(newIterable)) {
					current = null;
				}
			}
			if (current == null) {
				delegate = newIterable.iterator();
				delegateIterable = newIterable;
				computedHasNext = false;
				hasNext = false;
			} else {
				if (current.getOffset() <= offset && current.getOffset() + current.getLength() > offset) {
					// offset is inside of current - return current as next
					computedHasNext = true;
					hasNext = true;
				} else {
					// restart - use a new delegate
					computedHasNext = false;
					hasNext = false;
					delegate = newIterable.iterator();
					delegateIterable = newIterable;
				}
			}
		}
	}

	@Inject
	private AbstractAntlrTokenToAttributeIdMapper tokenIdMapper;
	@Inject
	private DocumentTokenSourceAccess tokenSourceAccess;

	public void setTokenIdMapper(AbstractAntlrTokenToAttributeIdMapper tokenIdMapper) {
		this.tokenIdMapper = tokenIdMapper;
	}

	@Override
	public void setRange(IDocument document, final int offset, final int length) {
		currentToken=null;
		reentrantIterator.setRange(document, offset, length);
	}

	protected Iterable<ILexerTokenRegion> getTokens(IDocument document) {
		Iterable<ILexerTokenRegion> result = tokenSourceAccess.getTokens(document, true);
		if (result == null) {
			// User might have selected a non-xtext document in e.g. a compare operation.
			// Return an empty iterable, this will disable syntax highlighting
			// for the "non-xtext editor".
			return Collections.emptyList();
		}
		return result;
	}

	@Override
	public IToken nextToken() {
		if (!reentrantIterator.hasNext())
			return Token.EOF;
		currentToken = reentrantIterator.next();
		return createToken(currentToken);
	}

	protected IToken createToken(ILexerTokenRegion currentToken) {
		String id = tokenIdMapper.getId(currentToken.getLexerTokenType());
		Token token = new Token(getAttribute(id));
		return token;
	}

	@Override
	public int getTokenOffset() {
		return currentToken.getOffset();
	}

	@Override
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	protected Iterator<ILexerTokenRegion> getIterator() {
		return reentrantIterator;
	}
	
	protected ILexerTokenRegion getCurrentToken() {
		return currentToken;
	}
	
	protected void setCurrentToken(ILexerTokenRegion currentToken) {
		this.currentToken = currentToken;
	}
	
	protected AbstractAntlrTokenToAttributeIdMapper getTokenIdMapper() {
		return tokenIdMapper;
	}

}
