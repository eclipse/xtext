/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core;

import com.google.common.base.Strings;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
class UnicodeTerminalsGenerator {
  public static void main(final String[] args) {
    CharSequence _generateUnicodeRules = UnicodeTerminalsGenerator.generateUnicodeRules();
    InputOutput.<CharSequence>println(_generateUnicodeRules);
  }
  
  public static CharSequence generateUnicodeRules() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("terminal fragment IDENTIFIER_START:");
    _builder.newLine();
    _builder.append("\t");
    final Function1<Integer,Boolean> _function = new Function1<Integer,Boolean>() {
      public Boolean apply(final Integer it) {
        boolean _isJavaIdentifierStart = Character.isJavaIdentifierStart((it).intValue());
        return Boolean.valueOf(_isJavaIdentifierStart);
      }
    };
    StringWriter _generateUnicodeRules = UnicodeTerminalsGenerator.generateUnicodeRules(_function);
    _builder.append(_generateUnicodeRules, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("terminal fragment IDENTIFIER_PART:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("IDENTIFIER_START | IDENTIFIER_PART_IMPL");
    _builder.newLine();
    _builder.append(";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("terminal fragment IDENTIFIER_PART_IMPL:");
    _builder.newLine();
    _builder.append("\t");
    final Function1<Integer,Boolean> _function_1 = new Function1<Integer,Boolean>() {
      public Boolean apply(final Integer it) {
        boolean _and = false;
        boolean _isJavaIdentifierPart = Character.isJavaIdentifierPart((it).intValue());
        if (!_isJavaIdentifierPart) {
          _and = false;
        } else {
          boolean _isJavaIdentifierStart = Character.isJavaIdentifierStart((it).intValue());
          boolean _not = (!_isJavaIdentifierStart);
          _and = (_isJavaIdentifierPart && _not);
        }
        return Boolean.valueOf(_and);
      }
    };
    StringWriter _generateUnicodeRules_1 = UnicodeTerminalsGenerator.generateUnicodeRules(_function_1);
    _builder.append(_generateUnicodeRules_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(";");
    _builder.newLine();
    return _builder;
  }
  
  public static StringWriter generateUnicodeRules(final Function1<? super Integer,? extends Boolean> guard) {
    Character prev = null;
    boolean run = false;
    boolean first = true;
    char c = Character.MIN_VALUE;
    StringWriter _stringWriter = new StringWriter();
    final StringWriter result = _stringWriter;
    PrintWriter _printWriter = new PrintWriter(result, true);
    final PrintWriter printer = _printWriter;
    boolean _while = true;
    while (_while) {
      {
        Boolean _apply = guard.apply(Integer.valueOf(((int) c)));
        if ((_apply).booleanValue()) {
          if ((!run)) {
            prev = Character.valueOf(c);
            run = true;
          }
        } else {
          if (run) {
            if ((!first)) {
              printer.print("| ");
            } else {
              printer.print("  ");
              first = false;
            }
            String _hexString = Integer.toHexString((prev).charValue());
            String _upperCase = _hexString.toUpperCase();
            String _padStart = Strings.padStart(_upperCase, 4, '0');
            String _plus = ("\'\\u" + _padStart);
            String _plus_1 = (_plus + "\'");
            printer.print(_plus_1);
            char _charValue = prev.charValue();
            boolean _equals = (_charValue == (c - 1));
            if (_equals) {
              printer.println();
            } else {
              String _hexString_1 = Integer.toHexString((c - 1));
              String _upperCase_1 = _hexString_1.toUpperCase();
              String _padStart_1 = Strings.padStart(_upperCase_1, 4, '0');
              String _plus_2 = ("..\'\\u" + _padStart_1);
              String _plus_3 = (_plus_2 + "\'");
              printer.println(_plus_3);
            }
            prev = null;
            run = false;
          }
        }
        c = ((char) (c + 1));
        if ((c == Character.MAX_VALUE)) {
          return result;
        }
      }
      _while = true;
    }
    return null;
  }
}
