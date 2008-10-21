/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.service.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Dennis Hübner
 */
public abstract class AbstractAntlrTokenColorer implements ITokenColorer {

	@Inject
	protected AntlrTokenDefProvider tokenDefProvider;

	private Map<Integer, ITokenStyle> tokenStyleMap;

	protected Map<Integer, ITokenStyle> getTokenStyleMap() {
		if (tokenStyleMap == null) {
			tokenStyleMap = new HashMap<Integer, ITokenStyle>();
			Map<Integer, String> tokenDefMap = tokenDefProvider.getTokenDefMap();
			//Using entrySet iterator is more efficient as keySet+get(key)
			for (Entry<Integer, String> antlrTokenEntry : tokenDefMap.entrySet()) {
				String antlrTokenDef = antlrTokenEntry.getValue();
				ITokenStyle tokenStyle = deriveTokenStyle(antlrTokenDef);
				tokenStyleMap.put(antlrTokenEntry.getKey(), tokenStyle);
			}
		}
		return tokenStyleMap;
	}

	protected abstract ITokenStyle deriveTokenStyle(String antlrTokenDef);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.common.editor.syntaxcoloring.tokentype.ITokenColorer
	 * #getTokenStyle(org.antlr.runtime.Token)
	 */
	public ITokenStyle getTokenStyle(int tokenTypeID) {
		ITokenStyle tokenStyle = getTokenStyleMap().get(tokenTypeID);
		return tokenStyle;
	}
}
