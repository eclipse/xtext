/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import java.util.Map;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.ui.LexerUIBindings;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TerminalsTokenTypeToPartitionMapper implements ITokenTypeToPartitionTypeMapper {
	public final static String COMMENT_PARTITION = "__comment";
	public final static String STRING_LITERAL_PARTITION = "__string";
	
	private Map<Integer, String> tokenDefs;

	@Inject
	public void setTokenDefProvider(@Named(LexerUIBindings.HIGHLIGHTING) ITokenDefProvider tokenDefProvider) {
		this.tokenDefs = tokenDefProvider.getTokenDefMap();
	}

	public String getPartitionType(int antlrTokenType) {
		String string = tokenDefs.get(antlrTokenType);
		if ("RULE_ML_COMMENT".equals(string) || "RULE_SL_COMMENT".equals(string)) {
			return COMMENT_PARTITION;
		} else if ("RULE_STRING".equals(string)) {
			return STRING_LITERAL_PARTITION;
		}
		return IDocument.DEFAULT_CONTENT_TYPE;
	}

	public String[] getSupportedPartitionTypes() {
		return new String[]{COMMENT_PARTITION,STRING_LITERAL_PARTITION,IDocument.DEFAULT_CONTENT_TYPE};
	}

}
