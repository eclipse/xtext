/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.jface.text.DocumentEvent;

/**
 * A {@link DocumentTokenSource} for languages with lexers without backtracking.
 * For these we can start lexing from the first damaged token instead of from the beginning.
 * This is a lot faster especially when editing the trunk of big files.
 *  
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
public class DocumentTokenSource2 extends DocumentTokenSource {

	@Override
	protected RepairEntryData getRepairEntryData(DocumentEvent e) throws Exception {
		int tokenStartsAt = 0;
		int tokenInfoIdx = 0;
		for(tokenInfoIdx = 0; tokenInfoIdx< getInternalModifyableTokenInfos().size(); ++tokenInfoIdx) {
			TokenInfo oldToken = getInternalModifyableTokenInfos().get(tokenInfoIdx);
			if(tokenStartsAt <= e.getOffset() && tokenStartsAt + oldToken.getLength() >= e.getOffset())
				break;
			tokenStartsAt += oldToken.getLength();
		}
		final TokenSource delegate = createTokenSource(e.fDocument.get(tokenStartsAt, e.fDocument.getLength() - tokenStartsAt));
		final int offset = tokenStartsAt;
		TokenSource source = new TokenSource() {
			public Token nextToken() {
				CommonToken commonToken = (CommonToken) delegate.nextToken();
				commonToken.setText(commonToken.getText());
				commonToken.setStartIndex(commonToken.getStartIndex()+offset);
				commonToken.setStopIndex(commonToken.getStopIndex()+offset);
				return commonToken;
			}

			public String getSourceName() {
				return delegate.getSourceName();
			}
		};
		final CommonToken token = (CommonToken) source.nextToken();
		return new RepairEntryData(offset, tokenInfoIdx, token, source);
	}

}
