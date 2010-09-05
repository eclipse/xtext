/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import java.util.Iterator;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PartitionTokenScanner implements IPartitionTokenScanner {

	private Iterator<ILexerTokenRegion> tokens;
	private int currentPartitionOffSet = 0;
	private ILexerTokenRegion firstOfNext = null;

	@Inject
	private ITokenTypeToPartitionTypeMapper mapper;
	private int currentPartitionLength;
	
	public void setMapper(ITokenTypeToPartitionTypeMapper mapper) {
		this.mapper = mapper;
	}

	public void setRange(IDocument document, int offset, int length) {
		setPartialRange(document, offset, length, null, 0);
	}

	public void setPartialRange(IDocument document, int offset, int length, String contentType, int partitionOffset) {
		tokens = Iterables.filter(getTokens(document),Regions.overlaps(offset, length)).iterator();
		this.currentPartitionOffSet = 0;
		this.firstOfNext = tokens.hasNext()?tokens.next():null;
	}

	protected Iterable<ILexerTokenRegion> getTokens(IDocument document) {
		return ((XtextDocument) document).getTokens();
	}

	public IToken nextToken() {
		if (firstOfNext==null)
			return Token.EOF;
		currentPartitionOffSet = firstOfNext.getOffset();
		currentPartitionLength = firstOfNext.getLength();
		String tokenPartition = mapper.getPartitionType(firstOfNext.getLexerTokenType());
		while (tokens.hasNext()) {
			firstOfNext = tokens.next();
			String partitionOfNext = mapper.getPartitionType(firstOfNext.getLexerTokenType());
			currentPartitionLength = firstOfNext.getOffset()-currentPartitionOffSet;
			if (!partitionOfNext.equals(tokenPartition)) {
				return new Token(tokenPartition);
			}
		}
		firstOfNext = null;
		return new Token(tokenPartition);
	}

	public int getTokenOffset() {
		return currentPartitionOffSet;
	}

	public int getTokenLength() {
		return currentPartitionLength;
	}

}
