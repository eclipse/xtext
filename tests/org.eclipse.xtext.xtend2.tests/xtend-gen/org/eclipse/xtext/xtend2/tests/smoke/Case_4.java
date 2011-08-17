package org.eclipse.xtext.xtend2.tests.smoke;

import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class Case_4 {
  
  public StringConcatenation richStrings_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foobar");
    return _builder;
  }
  
  public StringConcatenation richStrings_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("start", "");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t  ");
    _builder.append("first line");
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("second line");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation richStrings_03() {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (false) {
        _builder.append("foobar");} else {
        if (false) {
          _builder.append("foobar");} else {
          _builder.append("zonk");
        }
      }
    }
    return _builder;
  }
  
  public StringConcatenation richStrings_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("  ");
    {
      char[] _charArray = "1".toCharArray();
      for(final char a : _charArray) {
        {
          char[] _charArray_1 = "1".toCharArray();
          for(final char a2 : _charArray_1) {
            _builder.append("foobar");
          }
        }
      }
    }
    return _builder;
  }
  
  public StringConcatenation richStrings_05() {
    StringConcatenation _builder = new StringConcatenation();
    {
      char[] _charArray = "1".toCharArray();
      for(final char a : _charArray) {
        {
          char[] _charArray_1 = "12".toCharArray();
          for(final char a2 : _charArray_1) {
            _builder.append("foobar");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}