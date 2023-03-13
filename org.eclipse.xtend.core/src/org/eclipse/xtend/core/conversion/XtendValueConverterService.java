/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.conversion;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.KeywordAlternativeConverter;
import org.eclipse.xtext.xbase.conversion.XbaseValueConverterService;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Registers the value converters for Xtend, in particular the
 * converters for rich strings and qualified names with wildcards.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class XtendValueConverterService extends XbaseValueConverterService {

	@Inject
	private RichTextEndValueConverter richTextEndValueConverter;

	@ValueConverter(rule = "RICH_TEXT_END")
	public IValueConverter<String> getRichTextEndValueConverter() {
		return richTextEndValueConverter;
	}

	@Inject
	private RichTextStartValueConverter richTextStartValueConverter;
	
	@ValueConverter(rule = "RICH_TEXT_START")
	public IValueConverter<String> getRichTextStartValueConverter() {
		return richTextStartValueConverter;
	}

	@Inject
	private RichTextInBetweenValueConverter richTextInbetweenValueConverter;
	
	@ValueConverter(rule = "RICH_TEXT_INBETWEEN")
	public IValueConverter<String> getRichTextInbetweenValueConverter() {
		return richTextInbetweenValueConverter;
	}
	
	@Inject
	private RichTextValueConverter richTextValueConverter;
	
	@ValueConverter(rule = "RICH_TEXT")
	public IValueConverter<String> getRichTextValueConverter() {
		return richTextValueConverter;
	}
	
	@Inject
	private CommentRichTextInBetweenValueConverter commentRichTextInBetweenValueConverter;

	@ValueConverter(rule = "COMMENT_RICH_TEXT_INBETWEEN")
	public IValueConverter<String> getCommentRichTextInBetweenValueConverter() {
		return commentRichTextInBetweenValueConverter;
	}
	
	@Inject
	private CommentRichTextEndValueConverter commentRichTextEndValueConverter;

	@ValueConverter(rule = "COMMENT_RICH_TEXT_END")
	public IValueConverter<String> getCommentRichTextEndValueConverter() {
		return commentRichTextEndValueConverter;
	}
	
	@Inject
	private KeywordAlternativeConverter innerVarIDConverter;
	
	@ValueConverter(rule = "InnerVarID")
	public IValueConverter<String> getInnerVarIDValueConverter() {
		return innerVarIDConverter;
	}
	
	@Inject
	private FunctionIDValueConverter functionIDConverter;

	@ValueConverter(rule = "FunctionID")
	public IValueConverter<String> getFunctionIDValueConverter() {
		return functionIDConverter;
	}
	
}
