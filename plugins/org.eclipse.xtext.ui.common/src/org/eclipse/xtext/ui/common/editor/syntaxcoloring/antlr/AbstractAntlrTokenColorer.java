/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ITokenStyle;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Dennis Hübner
 */
public abstract class AbstractAntlrTokenColorer implements ITokenColorer {

	@Inject
	protected AntlrTokenDefProvider tokenDefProvider;

	private Map<String, ITokenStyle> tokenStyleMap;

	protected Map<String, ITokenStyle> getTokenStyleMap() {
		if (tokenStyleMap == null) {
			tokenStyleMap = new HashMap<String, ITokenStyle>();
			Map<Integer, String> tokenDefMap = tokenDefProvider.getTokenDefMap();
			//Using entrySet iterator is more efficient as keySet+get(key)
			for (Entry<Integer, String> antlrTokenEntry : tokenDefMap.entrySet()) {
				String antlrTokenDef = antlrTokenEntry.getValue();
				ITokenStyle tokenStyle = deriveTokenStyle(antlrTokenDef);
				tokenStyleMap.put(Integer.toString(antlrTokenEntry.getKey()), tokenStyle);
			}
		}
		return tokenStyleMap;
	}

	protected abstract ITokenStyle deriveTokenStyle(String antlrTokenDef);

	public ITokenStyle getTokenStyle(String tokenTypeID) {
		ITokenStyle tokenStyle = getTokenStyleMap().get(tokenTypeID);
		return tokenStyle;
	}
}
