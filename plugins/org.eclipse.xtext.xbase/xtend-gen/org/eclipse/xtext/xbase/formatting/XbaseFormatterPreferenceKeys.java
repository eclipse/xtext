package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.xbase.formatting.BasicFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.formatting.BlankLineKey;
import org.eclipse.xtext.xbase.formatting.BooleanKey;
import org.eclipse.xtext.xbase.formatting.IntegerKey;
import org.eclipse.xtext.xbase.formatting.NewLineKey;
import org.eclipse.xtext.xbase.formatting.NewLineOrPreserveKey;
import org.eclipse.xtext.xbase.formatting.WhitespaceKey;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class XbaseFormatterPreferenceKeys extends BasicFormatterPreferenceKeys {
  public final static IntegerKey preserveBlankLines = new Function0<IntegerKey>() {
    public IntegerKey apply() {
      IntegerKey _integerKey = new IntegerKey("preserve.blank.lines", Integer.valueOf(1));
      return _integerKey;
    }
  }.apply();
  
  public final static BlankLineKey blankLinesAroundExpression = new Function0<BlankLineKey>() {
    public BlankLineKey apply() {
      BlankLineKey _blankLineKey = new BlankLineKey("blank.line.around.expressions", Integer.valueOf(0));
      return _blankLineKey;
    }
  }.apply();
  
  public final static BooleanKey preserveNewLines = new Function0<BooleanKey>() {
    public BooleanKey apply() {
      BooleanKey _booleanKey = new BooleanKey("preserve.new.lines", true);
      return _booleanKey;
    }
  }.apply();
  
  public final static NewLineOrPreserveKey newLineAfterClassAnnotations = new Function0<NewLineOrPreserveKey>() {
    public NewLineOrPreserveKey apply() {
      NewLineOrPreserveKey _newLineOrPreserveKey = new NewLineOrPreserveKey("newline.after.class.annotations", Boolean.valueOf(false));
      return _newLineOrPreserveKey;
    }
  }.apply();
  
  public final static NewLineOrPreserveKey newLineAfterFieldAnnotations = new Function0<NewLineOrPreserveKey>() {
    public NewLineOrPreserveKey apply() {
      NewLineOrPreserveKey _newLineOrPreserveKey = new NewLineOrPreserveKey("newline.after.field.annotations", Boolean.valueOf(false));
      return _newLineOrPreserveKey;
    }
  }.apply();
  
  public final static NewLineOrPreserveKey newLineAfterMethodAnnotations = new Function0<NewLineOrPreserveKey>() {
    public NewLineOrPreserveKey apply() {
      NewLineOrPreserveKey _newLineOrPreserveKey = new NewLineOrPreserveKey("newline.after.method.annotations", Boolean.valueOf(false));
      return _newLineOrPreserveKey;
    }
  }.apply();
  
  public final static NewLineOrPreserveKey newLineAfterConstructorAnnotations = new Function0<NewLineOrPreserveKey>() {
    public NewLineOrPreserveKey apply() {
      NewLineOrPreserveKey _newLineOrPreserveKey = new NewLineOrPreserveKey("newline.after.constructor.annotations", Boolean.valueOf(false));
      return _newLineOrPreserveKey;
    }
  }.apply();
  
  public final static NewLineOrPreserveKey newLineAfterParameterAnnotations = new Function0<NewLineOrPreserveKey>() {
    public NewLineOrPreserveKey apply() {
      NewLineOrPreserveKey _newLineOrPreserveKey = new NewLineOrPreserveKey("newline.after.parameter.annotations", Boolean.valueOf(false));
      return _newLineOrPreserveKey;
    }
  }.apply();
  
  public final static WhitespaceKey whitespaceBetweenKeywordAndParenthesisSL = new Function0<WhitespaceKey>() {
    public WhitespaceKey apply() {
      WhitespaceKey _whitespaceKey = new WhitespaceKey("whitespace.between.keyword.and.parenthesis", Boolean.valueOf(false));
      return _whitespaceKey;
    }
  }.apply();
  
  public final static WhitespaceKey whitespaceBetweenKeywordAndParenthesisML = new Function0<WhitespaceKey>() {
    public WhitespaceKey apply() {
      WhitespaceKey _whitespaceKey = new WhitespaceKey("whitespace.between.keyword.and.parenthesis", Boolean.valueOf(true));
      return _whitespaceKey;
    }
  }.apply();
  
  public final static NewLineKey bracesInNewLine = new Function0<NewLineKey>() {
    public NewLineKey apply() {
      NewLineKey _newLineKey = new NewLineKey("braces.in.new.line", Boolean.valueOf(false));
      return _newLineKey;
    }
  }.apply();
}
