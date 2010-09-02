/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PartitionTokenScanner implements IPartitionTokenScanner {

	private List<? extends IXtextDocumentToken> tokens;
	private int offset;
	private int length;
	private int currentTokenIdx;
	private int currentPartitionOffSet = 0;
	private int currentPartitionLength = 0;

	@Inject
	private ITokenTypeToPartitionTypeMapper mapper;
	
	public void setMapper(ITokenTypeToPartitionTypeMapper mapper) {
		this.mapper = mapper;
	}

	public void setRange(IDocument document, int offset, int length) {
		setPartialRange(document, offset, length, null, 0);
	}

	public void setPartialRange(IDocument document, int offset, int length, String contentType, int partitionOffset) {
		tokens = getTokens(document);
		this.offset = offset;
		this.length = length;
		this.currentTokenIdx = 0;
		this.currentPartitionOffSet = 0;
		this.currentPartitionLength = 0;
		for (IXtextDocumentToken t : tokens) {
			if (t.getLength() + currentPartitionOffSet > partitionOffset) {
				return;
			}
			currentPartitionOffSet += t.getLength();
			currentTokenIdx++;
		}
	}

	protected List<? extends IXtextDocumentToken> getTokens(IDocument document) {
		return ((XtextDocument) document).getTokens();
	}

	public IToken nextToken() {
		String partition = null;
		currentPartitionOffSet+= currentPartitionLength;
		currentPartitionLength = 0;
		if (currentPartitionOffSet>=offset+length || currentTokenIdx==tokens.size())
			return Token.EOF;
		for (; currentTokenIdx < tokens.size(); currentTokenIdx++) {
			IXtextDocumentToken token = tokens.get(currentTokenIdx);
			String tokenPartition = mapper.getPartitionType(token.getAntlrTokenType());
			if (partition==null) {
				partition = tokenPartition;
			} else if (!tokenPartition.equals(partition)) {
				return new Token(partition);
			}
			currentPartitionLength+=token.getLength();
		}
		return new Token(partition);
	}

	public int getTokenOffset() {
		return currentPartitionOffSet;
	}

	public int getTokenLength() {
		return currentPartitionLength;
	}

}
