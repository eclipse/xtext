/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Iterator;
import java.util.WeakHashMap;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.apache.log4j.Logger;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.LexerUIBindings;
import org.eclipse.xtext.util.SimpleCache;

import com.google.common.base.Function;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
@Deprecated
public class XtextDamagerRepairer extends AbstractDamagerRepairer {

	private final static Logger log = Logger.getLogger(XtextDamagerRepairer.class);

	private final Provider<Lexer> lexer;
	private final WeakHashMap<IDocument, String> previousContent = new WeakHashMap<IDocument, String>();

	@Inject
	public XtextDamagerRepairer(ITokenScanner scanner, @Named(LexerUIBindings.HIGHLIGHTING) Provider<Lexer> lexer) {
		super(scanner);
		this.lexer = lexer;
	}

	@Override
	public void setDocument(IDocument document) {
		super.setDocument(document);
		previousContent.put(document, document.get());
	}

	@Override
	public IRegion getDamageRegion(ITypedRegion partition, final DocumentEvent e, boolean documentPartitioningChanged) {
		if (documentPartitioningChanged)
			return partition;
		try {
			return cache.get(e);
		} catch (Exception e1) {
			log.error(e1.getMessage(), e1);
			return new Region(0, e.getDocument().getLength());
		} finally {
			previousContent.put(fDocument, fDocument.get());
		}
	}

	protected Lexer createLexer(String string) {
		Lexer l = lexer.get();
		l.setCharStream(new ANTLRStringStream(string));
		return l;
	}

	private final SimpleCache<DocumentEvent, IRegion> cache = new SimpleCache<DocumentEvent, IRegion>(new Function<DocumentEvent, IRegion>() {

		public IRegion apply(DocumentEvent from) {
			return computeTextChangeRegion(from);
		}

		private IRegion computeTextChangeRegion(final DocumentEvent e) {
			// empty document -> no dirty region
			if (e.getDocument().getLength() == 0)
				return new Region(0, 0);

			// previously empty -> full document dirty
			String previousText = previousContent.get(e.getDocument());
			if (previousText.length() == 0)
				return new Region(0, e.getDocument().getLength());

			int start = e.getOffset();
			int end = Math.min(e.getDocument().getLength(),e.getOffset()+e.getLength());
			TokenIterator previous = iterator(previousText);
			TokenIterator actual = iterator(e.getDocument().get());
			// forward to the first difference
			while (previous.hasNext() && actual.hasNext() && equal(previous.next(), actual.next())) {
				// do nothing, just move forward
				if (actual.getCurrent().getStopIndex() >= start) {
					start = actual.getCurrent().getStartIndex();
					break;
				}
			}
			end = Math.max(end, actual.getCurrent().getStopIndex()+1);
			// the first pair of tokens which are not equal between previous and
			// current text determines the start offset
			start = Math.min(start, actual.getCurrent().getStartIndex());
			// lengthDiff is the number of characters the trailing text (i.e.
			// text
			// after the change) is moved.
			int lengthDiff = e.getText().length() - e.getLength();

			while (!inSync(previous, actual, lengthDiff) || actual.getCurrent().getStopIndex()+1<end) {

				if (!actual.hasNext()) {
					if (equal(previous.getCurrent(), actual.getCurrent())) {
						return new Region(end, 0);
					}
					return new Region(start, actual.getCurrent().getStopIndex() + 1 - start);
				}

				end =  Math.max(end, actual.getCurrent().getStopIndex()+1);
				// move forward and catch up
				actual.next();
				while (previous.getCurrent().getStartIndex() + lengthDiff < actual.getCurrent().getStartIndex()) {
					if (!previous.hasNext()) {
						return new Region(start, e.getDocument().getLength() - start);
					}
					previous.next();
				}
			}
			end =  Math.max(end, actual.getCurrent().getStopIndex()+1);
			return new Region(start, end - start);
		}

		private boolean inSync(TokenIterator previous, TokenIterator actual, int lengthDiff) {
			boolean equal = equal(previous.getCurrent(), actual.getCurrent());
			int prevIndex = previous.getCurrent().getStartIndex() + lengthDiff;
			int startIndex = actual.getCurrent().getStartIndex();
			return equal && prevIndex == startIndex;
		}
		
		private boolean equal(Token t1, Token t2) {
			return t1.getText().equals(t2.getText());
		}

		private TokenIterator iterator(String string) {
			TokenSource source = createLexer(string);
			return new TokenIterator(source);
		}
	});
	
	public static class TokenIterator implements Iterator<CommonToken> {

		private final TokenSource tokenSource;
		private CommonToken nextToken;
		private CommonToken current;

		/**
		 * @param document
		 */
		public TokenIterator(TokenSource tokenSource) {
			this.tokenSource = tokenSource;
		}

		public CommonToken getCurrent() {
			return current;
		}

		public boolean hasNext() {
			if (nextToken != null)
				return true;
			CommonToken token = (CommonToken) tokenSource.nextToken();
			if (token.getType() == Token.EOF) {
				return false;
			}
			nextToken = token;
			return true;
		}

		public CommonToken next() {
			try {
				if (hasNext()) {
					current = nextToken;
					return nextToken;
				}
				throw new IllegalStateException();
			} finally {
				nextToken = null;
			}
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
