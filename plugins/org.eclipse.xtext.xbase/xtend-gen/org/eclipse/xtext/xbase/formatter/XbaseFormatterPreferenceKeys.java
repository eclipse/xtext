package org.eclipse.xtext.xbase.formatter;

import org.eclipse.xtext.formatter.FormatterPreferenceKeys;
import org.eclipse.xtext.preferences.BooleanKey;
import org.eclipse.xtext.preferences.IntegerKey;
import org.eclipse.xtext.xbase.formatter.BlankLineKey;
import org.eclipse.xtext.xbase.formatter.NewLineKey;
import org.eclipse.xtext.xbase.formatter.NewLineOrPreserveKey;
import org.eclipse.xtext.xbase.formatter.WhitespaceKey;

@SuppressWarnings("all")
public class XbaseFormatterPreferenceKeys extends FormatterPreferenceKeys {
  public final static IntegerKey preserveBlankLines = new IntegerKey("preserve.blank.lines", Integer.valueOf(1));
  
  public final static BlankLineKey blankLinesAroundExpression = new BlankLineKey("blank.line.around.expressions", Integer.valueOf(0));
  
  public final static BooleanKey preserveNewLines = new BooleanKey("preserve.new.lines", Boolean.valueOf(true));
  
  public final static NewLineOrPreserveKey newLineAfterClassAnnotations = new NewLineOrPreserveKey("newline.after.class.annotations", Boolean.valueOf(false));
  
  public final static NewLineOrPreserveKey newLineAfterFieldAnnotations = new NewLineOrPreserveKey("newline.after.field.annotations", Boolean.valueOf(false));
  
  public final static NewLineOrPreserveKey newLineAfterMethodAnnotations = new NewLineOrPreserveKey("newline.after.method.annotations", Boolean.valueOf(false));
  
  public final static NewLineOrPreserveKey newLineAfterConstructorAnnotations = new NewLineOrPreserveKey("newline.after.constructor.annotations", Boolean.valueOf(false));
  
  public final static NewLineOrPreserveKey newLineAfterParameterAnnotations = new NewLineOrPreserveKey("newline.after.parameter.annotations", Boolean.valueOf(false));
  
  public final static WhitespaceKey whitespaceBetweenKeywordAndParenthesisSL = new WhitespaceKey("whitespace.between.keyword.and.parenthesis", Boolean.valueOf(false));
  
  public final static WhitespaceKey whitespaceBetweenKeywordAndParenthesisML = new WhitespaceKey("whitespace.between.keyword.and.parenthesis", Boolean.valueOf(true));
  
  public final static NewLineKey bracesInNewLine = new NewLineKey("braces.in.new.line", Boolean.valueOf(false));
}
