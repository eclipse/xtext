/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import java.util.Iterator;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

import com.google.common.collect.AbstractIterator;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class PartitionTokenScanner implements IPartitionTokenScanner {

	/**
	 * Iterator that is aware of the fact that the tokens are ordered. As soon as 
	 * the last token in the given {@code overlapRegion} was returned, no other 
	 * tokens are requested from {@code base}.
	 * @since 2.1
	 */
	protected static class RangedIterator extends AbstractIterator<ILexerTokenRegion> {

		private final Iterator<ILexerTokenRegion> delegate;
		
		private final IRegion overlapRegion;

		protected RangedIterator(Iterable<ILexerTokenRegion> base, IRegion overlapRegion) {
			this.overlapRegion = overlapRegion;
			this.delegate = base.iterator();
		}
		
		@Override
		protected ILexerTokenRegion computeNext() {
			while(delegate.hasNext()) {
				ILexerTokenRegion candidate = delegate.next();
				if (overlapRegion.getOffset() + overlapRegion.getLength() < candidate.getOffset())
					return endOfData();
				if (TextUtilities.overlaps(overlapRegion, candidate))
					return candidate;
			}
			return endOfData();
		}
		
	}
	
	private Iterator<ILexerTokenRegion> tokens;
	private int currentPartitionOffset = 0;
	private ILexerTokenRegion nextToken = null;

	@Inject
	private ITokenTypeToPartitionTypeMapper mapper;
	@Inject
	private DocumentTokenSourceAccess tokenSourceAccess = new DocumentTokenSourceAccess();
	private int currentPartitionLength;
	
	public void setMapper(ITokenTypeToPartitionTypeMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void setRange(IDocument document, int offset, int length) {
		setPartialRange(document, offset, length, null, 0);
	}

	@Override
	public void setPartialRange(IDocument document, int offset, int length, String contentType, int partitionOffset) {
		int overlapOffset = partitionOffset;
		int overlapLength = offset + length - partitionOffset;
		tokens = new RangedIterator(getTokens(document), new Region(overlapOffset, overlapLength));
		this.currentPartitionOffset = overlapOffset;
		this.currentPartitionLength = 0;
		this.nextToken = tokens.hasNext()?tokens.next():null;
	}

	protected Iterable<ILexerTokenRegion> getTokens(IDocument document) {
		return tokenSourceAccess.getTokens(document, false);
	}

	@Override
	public IToken nextToken() {
		if (nextToken==null) {
			return Token.EOF;
		}
		currentPartitionOffset = nextToken.getOffset();
		currentPartitionLength = nextToken.getLength();
		String tokenPartition = mapper.getPartitionType(nextToken.getLexerTokenType());
		while (tokens.hasNext()) {
			nextToken = tokens.next();
			String partitionOfNext = mapper.getPartitionType(nextToken.getLexerTokenType());
			currentPartitionLength = nextToken.getOffset()-currentPartitionOffset;
			if (!partitionOfNext.equals(tokenPartition) || !shouldMergePartitions(tokenPartition)) {
				return new Token(tokenPartition);
			}
		}
		if (nextToken != null)
			currentPartitionLength = nextToken.getOffset() + nextToken.getLength() - currentPartitionOffset; 
		nextToken = null;
		return new Token(tokenPartition);
	}
	
	/**
	 * @since 2.1
	 */
	protected boolean shouldMergePartitions(String contentType) {
		return IDocument.DEFAULT_CONTENT_TYPE.equals(contentType);
	}

	@Override
	public int getTokenOffset() {
		return currentPartitionOffset;
	}

	@Override
	public int getTokenLength() {
		return currentPartitionLength;
	}

}
