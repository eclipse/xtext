/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

/**
 * @deprecated use {@link org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys}
 */
@Deprecated
public class XbaseFormatterPreferenceKeys extends BasicFormatterPreferenceKeys {
  public static final IntegerKey preserveBlankLines = new IntegerKey("preserve.blank.lines", Integer.valueOf(1));
  
  public static final BlankLineKey blankLinesAroundExpression = new BlankLineKey("blank.line.around.expressions", Integer.valueOf(0));
  
  public static final BooleanKey preserveNewLines = new BooleanKey("preserve.new.lines", true);
  
  public static final NewLineOrPreserveKey newLineAfterClassAnnotations = new NewLineOrPreserveKey("newline.after.class.annotations", Boolean.valueOf(false));
  
  public static final NewLineOrPreserveKey newLineAfterFieldAnnotations = new NewLineOrPreserveKey("newline.after.field.annotations", Boolean.valueOf(false));
  
  public static final NewLineOrPreserveKey newLineAfterMethodAnnotations = new NewLineOrPreserveKey("newline.after.method.annotations", Boolean.valueOf(false));
  
  public static final NewLineOrPreserveKey newLineAfterConstructorAnnotations = new NewLineOrPreserveKey("newline.after.constructor.annotations", Boolean.valueOf(false));
  
  public static final NewLineOrPreserveKey newLineAfterParameterAnnotations = new NewLineOrPreserveKey("newline.after.parameter.annotations", Boolean.valueOf(false));
  
  public static final WhitespaceKey whitespaceBetweenKeywordAndParenthesisSL = new WhitespaceKey("whitespace.between.keyword.and.parenthesis", Boolean.valueOf(false));
  
  public static final WhitespaceKey whitespaceBetweenKeywordAndParenthesisML = new WhitespaceKey("whitespace.between.keyword.and.parenthesis", Boolean.valueOf(true));
  
  public static final NewLineKey bracesInNewLine = new NewLineKey("braces.in.new.line", Boolean.valueOf(false));
}
