/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.editor.model;

import java.io.StringReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtend.core.parser.antlr.internal.FlexTokenSource;
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendDocumentTokenSource extends DocumentTokenSource {

	public static final int JAVA_DOC_TOKEN_TYPE = -10000;

	protected int multilineTokenType = -1;
	
	@Inject
	private FlexerFactory flexerFactory;

	@Inject
	public void setTokenDefProvider(@Named(LexerIdeBindings.HIGHLIGHTING) ITokenDefProvider tokenDefProvider) {
		Map<Integer, String> tokenDefMap = tokenDefProvider.getTokenDefMap();
		Set<Entry<Integer, String>> entrySet = tokenDefMap.entrySet();
		for(Entry<Integer, String> entry : entrySet){
			if(entry.getValue().equals("RULE_ML_COMMENT")){
				multilineTokenType = entry.getKey();
				return;
			}
		}
		throw new RuntimeException("No Token for RULE ML_COMMENT found in tokenTypeDefs!");
	}

	@Override
	protected TokenSource createTokenSource(String string) {
		final FlexTokenSource delegate = flexerFactory.createTokenSource(new StringReader(string));
		return new TokenSource() {

			@Override
			public Token nextToken() {
				Token token = delegate.nextToken();
				if(token.getType() == multilineTokenType) {
					String text = token.getText();
					if(text.startsWith("/**") && !text.startsWith("/***")){
						token.setType(JAVA_DOC_TOKEN_TYPE);
					}
				}
				return token;
			}

			@Override
			public String getSourceName() {
				return delegate.getSourceName();
			}
		};
	}
	
	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 */
	public void setFlexerFactory(FlexerFactory flexerFactory) {
		this.flexerFactory = flexerFactory;
	}
}

