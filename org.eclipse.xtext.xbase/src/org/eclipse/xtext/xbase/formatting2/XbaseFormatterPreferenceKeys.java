/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.preferences.BooleanKey;
import org.eclipse.xtext.preferences.IntegerKey;

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
public class XbaseFormatterPreferenceKeys extends FormatterPreferenceKeys {
	public static final IntegerKey preserveBlankLines = new IntegerKey("preserve.blank.lines", 1);

	public static final BlankLineKey blankLinesAroundExpression = new BlankLineKey("blank.line.around.expressions", 0);

	public static final BooleanKey preserveNewLines = new BooleanKey("preserve.new.lines", true);

	public static final NewLineOrPreserveKey newLineAfterClassAnnotations = new NewLineOrPreserveKey(
			"newline.after.class.annotations", false);

	public static final NewLineOrPreserveKey newLineAfterFieldAnnotations = new NewLineOrPreserveKey(
			"newline.after.field.annotations", false);

	public static final NewLineOrPreserveKey newLineAfterMethodAnnotations = new NewLineOrPreserveKey(
			"newline.after.method.annotations", false);

	public static final NewLineOrPreserveKey newLineAfterConstructorAnnotations = new NewLineOrPreserveKey(
			"newline.after.constructor.annotations", false);

	public static final NewLineOrPreserveKey newLineAfterParameterAnnotations = new NewLineOrPreserveKey(
			"newline.after.parameter.annotations", false);

	public static final WhitespaceKey whitespaceBetweenKeywordAndParenthesisSL = new WhitespaceKey(
			"whitespace.between.keyword.and.parenthesis", false);

	public static final WhitespaceKey whitespaceBetweenKeywordAndParenthesisML = new WhitespaceKey(
			"whitespace.between.keyword.and.parenthesis", true);

	public static final BlankLineKey blankLinesBetweenImports = new BlankLineKey("blank.lines.between.imports",
			Integer.valueOf(0));

	public static final BlankLineKey blankLinesAfterImports = new BlankLineKey("blank.lines.after.imports",
			Integer.valueOf(1));

	public static final NewLineKey bracesInNewLine = new NewLineKey("braces.in.new.line", false);
}
