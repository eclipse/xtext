/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.editor.model;

import org.antlr.runtime.CommonToken;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendDocumentTokenSource extends DocumentTokenSource {
	public static final int JAVA_DOC_TOKEN_TYPE = -10000;

	@Override
	protected TokenInfo createTokenInfo(CommonToken token) {
		if(token.getType() == 16){
			String text = token.getText();
			if(text.startsWith("/**") && !text.startsWith("/***")){
				token.setType(JAVA_DOC_TOKEN_TYPE);
			}
		}
		TokenInfo info = new TokenInfo(token);
		return info;
	}
}
