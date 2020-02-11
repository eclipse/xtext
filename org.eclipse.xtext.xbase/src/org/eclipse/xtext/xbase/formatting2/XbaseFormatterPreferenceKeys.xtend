/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting2

import org.eclipse.xtext.formatting2.FormatterPreferenceKeys
import org.eclipse.xtext.preferences.BooleanKey
import org.eclipse.xtext.preferences.IntegerKey

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
class XbaseFormatterPreferenceKeys extends FormatterPreferenceKeys {
	public static val preserveBlankLines = new IntegerKey("preserve.blank.lines", 1)
	public static val blankLinesAroundExpression = new BlankLineKey("blank.line.around.expressions", 0)

	public static val preserveNewLines = new BooleanKey("preserve.new.lines", true)
	public static val newLineAfterClassAnnotations = new NewLineOrPreserveKey("newline.after.class.annotations", false)
	public static val newLineAfterFieldAnnotations = new NewLineOrPreserveKey("newline.after.field.annotations", false)
	public static val newLineAfterMethodAnnotations = new NewLineOrPreserveKey("newline.after.method.annotations", false)
	public static val newLineAfterConstructorAnnotations = new NewLineOrPreserveKey("newline.after.constructor.annotations", false)
	public static val newLineAfterParameterAnnotations = new NewLineOrPreserveKey("newline.after.parameter.annotations", false)

	public static val whitespaceBetweenKeywordAndParenthesisSL = new WhitespaceKey("whitespace.between.keyword.and.parenthesis", false)
	public static val whitespaceBetweenKeywordAndParenthesisML = new WhitespaceKey("whitespace.between.keyword.and.parenthesis", true)
	
	public static val blankLinesBetweenImports = new BlankLineKey("blank.lines.between.imports", 0)
	public static val blankLinesAfterImports = new BlankLineKey("blank.lines.after.imports", 1)

	public static val bracesInNewLine = new NewLineKey("braces.in.new.line", false)
}