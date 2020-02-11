/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.antlr.runtime.Token;
import org.eclipse.jface.text.IDocument;

import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class TerminalsTokenTypeToPartitionMapper extends TokenTypeToStringMapper implements ITokenTypeToPartitionTypeMapper, ITokenTypeToPartitionTypeMapperExtension {
	public final static String COMMENT_PARTITION = "__comment";
	/**
	 * @since 2.0
	 */
	public final static String SL_COMMENT_PARTITION = "__sl_comment";
	public final static String STRING_LITERAL_PARTITION = "__string";
	
	protected static final String[] SUPPORTED_PARTITIONS = new String[]{
		COMMENT_PARTITION,
		SL_COMMENT_PARTITION,
		STRING_LITERAL_PARTITION,
		IDocument.DEFAULT_CONTENT_TYPE
	};
	
	@Override
	public String getPartitionType(int antlrTokenType) {
		// on lexer error return default content type
		if (antlrTokenType == Token.INVALID_TOKEN_TYPE) {
			return IDocument.DEFAULT_CONTENT_TYPE;
		}
		return getMappedValue(antlrTokenType);
	}
	
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if ("RULE_ML_COMMENT".equals(tokenName)) {
			return COMMENT_PARTITION;
		} else if ("RULE_SL_COMMENT".equals(tokenName)) {
			return SL_COMMENT_PARTITION;
		} else if ("RULE_STRING".equals(tokenName)) {
			return STRING_LITERAL_PARTITION;
		}
		return IDocument.DEFAULT_CONTENT_TYPE;
	}

	@Override
	public String[] getSupportedPartitionTypes() {
		return SUPPORTED_PARTITIONS;
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	public boolean isMultiLineComment(String partitionType) {
		return COMMENT_PARTITION.equals(partitionType);
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	public boolean isSingleLineComment(String partitionType) {
		return SL_COMMENT_PARTITION.equals(partitionType);
	}

}
