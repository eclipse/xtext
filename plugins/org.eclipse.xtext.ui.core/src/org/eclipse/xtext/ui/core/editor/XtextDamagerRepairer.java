/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.apache.log4j.Logger;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.xtext.parser.antlr.Lexer;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 * 
 */
public class XtextDamagerRepairer extends AbstractDamagerRepairer {

	private final static Logger log = Logger.getLogger(XtextDamagerRepairer.class);

	private Provider<Lexer> lexer;
	private WeakHashMap<IDocument, TokenIterator> tokenIterators = new WeakHashMap<IDocument, TokenIterator>();

	@Inject
	public XtextDamagerRepairer(ITokenScanner scanner, Provider<Lexer> lexer) {
		super(scanner);
		this.lexer = lexer;
	}

	@Override
	public void setDocument(IDocument document) {
		super.setDocument(document);
		tokenIterators.put(document, TokenIterator.create(lexer.get(), document.get()));
	}

	@Override
	public IRegion getDamageRegion(ITypedRegion partition, final DocumentEvent e, boolean documentPartitioningChanged) {
		if (documentPartitioningChanged)
			return partition;
		try {
			return computeRegion(e);
		} catch (Exception e1) {
			log.error(e1.getMessage(), e1);
			return new Region(0, e.getDocument().getLength());
		}

	}

	private IRegion computeRegion(final DocumentEvent e) {
		TokenIterator previous = tokenIterators.get(e.fDocument);

		// set previous iterator to offset
		previous.goTo(e.getOffset());

		TokenIterator newOne = TokenIterator.create(lexer.get(), e.getDocument().get(), previous);

		// lengthDiff is the number of characters the trailing text (i.e. text
		// after the change) is moved.
		int lengthDiff = e.getText().length() - e.getLength();

		// start offSet of the dirty region
		int start = newOne.getOffset();

		// go forward to the minimal end offSet
		newOne.goTo(e.getOffset() + e.getText().length());

		// keep previous in sync
		previous.goTo(newOne.getOffset() + newOne.getLength());

		try {
			while (newOne.hasNext() && !(newOne.getOffset() + newOne.getLength() == previous.getOffset() + lengthDiff)) {
				newOne.next();

				// keep the previous iterator in sync, i.e. forward to the
				while (newOne.getOffset() + newOne.getLength() > previous.getOffset() + lengthDiff) {
					if (previous.hasNext())
						previous.next();
					else
						// if the previous text exceeds, we know that we have to
						// repair until the end of the document
						return log(new Region(start, e.getDocument().getLength() - start));
				}
			}
			return log(new Region(start, newOne.getOffset() + newOne.getLength() - start));
		} finally {
			tokenIterators.put(e.getDocument(), newOne);
		}
	}

	/**
	 * @param region
	 * @return
	 */
	private IRegion log(Region region) {
		if (log.isDebugEnabled())
			log.debug(" dirty :" + region.getOffset() + " .. " + region.getLength());
		return region;
	}

	public static class TokenIterator {

		private List<Integer> tokenLengths;
		private int index = -1;
		private int offset = 0;
		private Lexer lexer;

		/**
		 * @param document
		 */
		private TokenIterator(Lexer lexer, int offset, List<Integer> parsed) {
			this.tokenLengths = parsed;
			if (!tokenLengths.isEmpty())
				this.index = tokenLengths.size();// - 1;
			this.offset = offset;
			this.lexer = lexer;
		}

		public static TokenIterator create(Lexer lexer, String contents) {
			lexer.setCharStream(new ANTLRStringStream(contents));
			ArrayList<Integer> parsed = new ArrayList<Integer>();
			TokenIterator tokenIterator = new TokenIterator(lexer, 0, parsed);
			if (tokenIterator.hasNext())
				tokenIterator.next();
			return tokenIterator;
		}

		public static TokenIterator create(Lexer lexer, String txt, TokenIterator previous) {
			int offset2 = previous.getOffset();
			String input = txt.substring(offset2);
			lexer.setCharStream(new ANTLRStringStream(input));

			List<Integer> subList = new ArrayList<Integer>();
			if (previous.getIndex() != -1) {
				subList.addAll(previous.tokenLengths.subList(0, previous.getIndex()));
			}

			return new TokenIterator(lexer, offset2, subList);
		}

		public void goTo(int offset) {
			while (!(getOffset() <= offset && getOffset() + getLength() > offset)) {
				if (getOffset() > offset) {
					backward();
				} else {
					if (hasNext()) {
						next();
					} else {
						return;
					}

				}
			}
		}

		public int getIndex() {
			return index;
		}

		public int getOffset() {
			return offset;
		}

		public int getLength() {
			if (getIndex() == -1)
				return 0;
			while (tokenLengths.size() - 1 < index && !eof) {
				consume();
			}
			return tokenLengths.get(getIndex());
		}

		public void next() {
			if (hasNext()) {
				index++;
				if (index > 0)
					offset = offset + tokenLengths.get(index - 1);
			} else {
				throw new IllegalStateException();
			}
		}

		public boolean hasNext() {
			return index + 1 < tokenLengths.size() || consume();
		}

		private boolean eof = false;

		/**
		 * @return
		 */
		private boolean consume() {
			CommonToken token = (CommonToken) lexer.nextToken();
			eof = eof || token.getType() == Token.EOF;
			if (!eof) {
				tokenLengths.add(token.getStopIndex() + 1 - token.getStartIndex());
			}
			return !eof;
		}

		public void backward() {
			if (index > 0) {
				offset = offset - tokenLengths.get(--index);
			} else
				throw new IllegalStateException();
		}

	}

}
