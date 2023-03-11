/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtend.ide.editor.model.XtendDocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
@Singleton
public class TokenTypeToPartitionMapper extends TerminalsTokenTypeToPartitionMapper {

	public final static String JAVA_DOC_PARTITION = "__java_javadoc";

	public final static String RICH_STRING_LITERAL_PARTITION = "__rich_string";
	public static final String[] SUPPORTED_TOKEN_TYPES = new String[] { 
		COMMENT_PARTITION,
		JAVA_DOC_PARTITION,
		SL_COMMENT_PARTITION, 
		STRING_LITERAL_PARTITION, 
		RICH_STRING_LITERAL_PARTITION,
		IDocument.DEFAULT_CONTENT_TYPE 
	};

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if (
				"RULE_RICH_TEXT".equals(tokenName) || 
				"RULE_RICH_TEXT_START".equals(tokenName) || 
				"RULE_RICH_TEXT_END".equals(tokenName) || 
				"RULE_RICH_TEXT_INBETWEEN".equals(tokenName) ||
				"RULE_COMMENT_RICH_TEXT_END".equals(tokenName) ||
				"RULE_COMMENT_RICH_TEXT_INBETWEEN".equals(tokenName)) {
			return RICH_STRING_LITERAL_PARTITION;
		}
		if ("RULE_ML_COMMENT".equals(tokenName)) {
			return COMMENT_PARTITION;
		}
		return super.calculateId(tokenName, tokenType);
	}

	@Override
	protected String getMappedValue(int tokenType) {
		if(tokenType == XtendDocumentTokenSource.JAVA_DOC_TOKEN_TYPE){
			return JAVA_DOC_PARTITION;
		}
		return super.getMappedValue(tokenType);
	}

	@Override
	public String[] getSupportedPartitionTypes() {
		return SUPPORTED_TOKEN_TYPES;
	}
	
	@Override
	public boolean isMultiLineComment(String partitionType) {
		return super.isMultiLineComment(partitionType) || JAVA_DOC_PARTITION.equals(partitionType);
	}
}
