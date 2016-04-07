package org.eclipse.xtext.xbase.lib;

import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;

@SuppressWarnings("all")
public class ArithmeticExtensionGenerator {
  public static void main(final String[] args) {
    XbaseStandaloneSetup _xbaseStandaloneSetup = new XbaseStandaloneSetup();
    Injector _createInjectorAndDoEMFRegistration = _xbaseStandaloneSetup.createInjectorAndDoEMFRegistration();
    ArithmeticExtensionGenerator _instance = _createInjectorAndDoEMFRegistration.<ArithmeticExtensionGenerator>getInstance(ArithmeticExtensionGenerator.class);
    _instance.generate();
  }
  
  private static String since = "2.3";
  
  private List<String> types = CollectionLiterals.<String>newArrayList("double", "float", "long", "int", "char", "short", "byte");
  
  private List<QualifiedName> comparators = CollectionLiterals.<QualifiedName>newArrayList(
    OperatorMapping.LESS_THAN, 
    OperatorMapping.LESS_EQUALS_THAN, 
    OperatorMapping.GREATER_THAN, 
    OperatorMapping.GREATER_EQUALS_THAN, 
    OperatorMapping.EQUALS, 
    OperatorMapping.NOT_EQUALS);
  
  private List<QualifiedName> operators = CollectionLiterals.<QualifiedName>newArrayList(
    OperatorMapping.PLUS, 
    OperatorMapping.MINUS, 
    OperatorMapping.MULTIPLY, 
    OperatorMapping.DIVIDE, 
    OperatorMapping.MODULO, 
    OperatorMapping.LESS_THAN, 
    OperatorMapping.LESS_EQUALS_THAN, 
    OperatorMapping.GREATER_THAN, 
    OperatorMapping.GREATER_EQUALS_THAN, 
    OperatorMapping.EQUALS, 
    OperatorMapping.NOT_EQUALS);
  
  @Inject
  @Extension
  private OperatorMapping _operatorMapping;
  
  public void generate() {
    try {
      final String path = "../org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/";
      File _file = new File(path);
      _file.mkdirs();
      for (final String type : this.types) {
        {
          String _className = this.className(type);
          String _plus = (path + _className);
          String _plus_1 = (_plus + ".java");
          final File file = new File(_plus_1);
          CharSequence _xifexpression = null;
          boolean _exists = file.exists();
          if (_exists) {
            String _xblockexpression = null;
            {
              final String content = Files.toString(file, Charsets.ISO_8859_1);
              StringConcatenation _builder = new StringConcatenation();
              String _startMarker = this.startMarker();
              int _indexOf = content.indexOf(_startMarker);
              String _substring = content.substring(0, _indexOf);
              _builder.append(_substring, "");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              CharSequence _generateAllOperations = this.generateAllOperations(type);
              _builder.append(_generateAllOperations, "\t");
              _builder.newLineIfNotEmpty();
              String _endMarker = this.endMarker();
              int _indexOf_1 = content.indexOf(_endMarker);
              String _endMarker_1 = this.endMarker();
              int _length = _endMarker_1.length();
              int _plus_2 = (_indexOf_1 + _length);
              String _substring_1 = content.substring(_plus_2);
              _builder.append(_substring_1, "");
              _xblockexpression = _builder.toString();
            }
            _xifexpression = _xblockexpression;
          } else {
            _xifexpression = this.generate(type);
          }
          final CharSequence newContent = _xifexpression;
          final StringConcatenation result = new StringConcatenation("\n");
          result.append(newContent);
          Files.write(result, file, Charsets.ISO_8859_1);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public CharSequence generate(final String type) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*******************************************************************************");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* All rights reserved. This program and the accompanying materials");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* are made available under the terms of the Eclipse Public License v1.0");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* which accompanies this distribution, and is available at");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* http://www.eclipse.org/legal/epl-v10.html");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*******************************************************************************/");
    _builder.newLine();
    _builder.append("package org.eclipse.xtext.xbase.lib;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This is an extension library for {@link ");
    String _wrapperType = this.wrapperType(type);
    _builder.append(_wrapperType, " ");
    _builder.append("} numbers.");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @author Jan Koehnlein - Code generator");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @since ");
    _builder.append(ArithmeticExtensionGenerator.since, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class ");
    String _className = this.className(type);
    _builder.append(_className, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generateAllOperations = this.generateAllOperations(type);
    _builder.append(_generateAllOperations, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateAllOperations(final String type) {
    StringConcatenation _builder = new StringConcatenation();
    String _startMarker = this.startMarker();
    _builder.append(_startMarker, "");
    _builder.newLineIfNotEmpty();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* The unary <code>minus</code> operator. This is the equivalent to the Java\'s <code>-</code> function.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param ");
    char _charAt = type.charAt(0);
    _builder.append(_charAt, " ");
    _builder.append("  ");
    String _article = this.article(type);
    _builder.append(_article, " ");
    _builder.append(" ");
    String _wrapperType = this.wrapperType(type);
    String _firstLower = StringExtensions.toFirstLower(_wrapperType);
    _builder.append(_firstLower, " ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @return   <code>-");
    char _charAt_1 = type.charAt(0);
    _builder.append(_charAt_1, " ");
    _builder.append("</code>");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @since ");
    _builder.append(ArithmeticExtensionGenerator.since, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Pure");
    _builder.newLine();
    _builder.append("@Inline(value=\"(-$1)\", constantExpression=true)");
    _builder.newLine();
    _builder.append("public static ");
    String _returnType = this.returnType(type, OperatorMapping.MINUS, type);
    _builder.append(_returnType, "");
    _builder.append(" ");
    QualifiedName _methodName = this._operatorMapping.getMethodName(OperatorMapping.MINUS);
    _builder.append(_methodName, "");
    _builder.append("(");
    _builder.append(type, "");
    _builder.append(" ");
    char _charAt_2 = type.charAt(0);
    _builder.append(_charAt_2, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return -");
    char _charAt_3 = type.charAt(0);
    _builder.append(_charAt_3, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* The postfix <code>decrement</code> operator. This is the equivalent to the Java\'s <code>--</code> postfix function.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param ");
    char _charAt_4 = type.charAt(0);
    _builder.append(_charAt_4, " ");
    _builder.append("  ");
    String _article_1 = this.article(type);
    _builder.append(_article_1, " ");
    _builder.append(" ");
    String _wrapperType_1 = this.wrapperType(type);
    String _firstLower_1 = StringExtensions.toFirstLower(_wrapperType_1);
    _builder.append(_firstLower_1, " ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @return   <code>");
    char _charAt_5 = type.charAt(0);
    _builder.append(_charAt_5, " ");
    _builder.append("--</code>");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @since 2.6");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Inline(value=\"$1--\")");
    _builder.newLine();
    _builder.append("public static ");
    _builder.append(type, "");
    _builder.append(" ");
    QualifiedName _methodName_1 = this._operatorMapping.getMethodName(OperatorMapping.MINUS_MINUS);
    _builder.append(_methodName_1, "");
    _builder.append("(");
    _builder.append(type, "");
    _builder.append(" ");
    char _charAt_6 = type.charAt(0);
    _builder.append(_charAt_6, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("throw new HardcodedInInterpreterException();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* The postfix <code>decrement</code> operator. This is the equivalent to the Java\'s <code>--</code> postfix function.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param ");
    char _charAt_7 = type.charAt(0);
    _builder.append(_charAt_7, " ");
    _builder.append("  ");
    String _article_2 = this.article(type);
    _builder.append(_article_2, " ");
    _builder.append(" ");
    String _wrapperType_2 = this.wrapperType(type);
    String _firstLower_2 = StringExtensions.toFirstLower(_wrapperType_2);
    _builder.append(_firstLower_2, " ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @return   <code>");
    char _charAt_8 = type.charAt(0);
    _builder.append(_charAt_8, " ");
    _builder.append("--</code>");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @since 2.6");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Inline(value=\"$1--\")");
    _builder.newLine();
    _builder.append("public static ");
    String _wrapperType_3 = this.wrapperType(type);
    _builder.append(_wrapperType_3, "");
    _builder.append(" ");
    QualifiedName _methodName_2 = this._operatorMapping.getMethodName(OperatorMapping.MINUS_MINUS);
    _builder.append(_methodName_2, "");
    _builder.append("(");
    String _wrapperType_4 = this.wrapperType(type);
    _builder.append(_wrapperType_4, "");
    _builder.append(" ");
    char _charAt_9 = type.charAt(0);
    _builder.append(_charAt_9, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("throw new HardcodedInInterpreterException();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* The postfix <code>increment</code> operator. This is the equivalent to the Java\'s <code>++</code> postfix function.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param ");
    char _charAt_10 = type.charAt(0);
    _builder.append(_charAt_10, " ");
    _builder.append("  ");
    String _article_3 = this.article(type);
    _builder.append(_article_3, " ");
    _builder.append(" ");
    String _wrapperType_5 = this.wrapperType(type);
    String _firstLower_3 = StringExtensions.toFirstLower(_wrapperType_5);
    _builder.append(_firstLower_3, " ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @return   <code>");
    char _charAt_11 = type.charAt(0);
    _builder.append(_charAt_11, " ");
    _builder.append("++</code>");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @since 2.6");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Inline(value=\"$1++\")");
    _builder.newLine();
    _builder.append("public static ");
    _builder.append(type, "");
    _builder.append(" ");
    QualifiedName _methodName_3 = this._operatorMapping.getMethodName(OperatorMapping.PLUS_PLUS);
    _builder.append(_methodName_3, "");
    _builder.append("(");
    _builder.append(type, "");
    _builder.append(" ");
    char _charAt_12 = type.charAt(0);
    _builder.append(_charAt_12, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("throw new HardcodedInInterpreterException();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* The postfix <code>increment</code> operator. This is the equivalent to the Java\'s <code>++</code> postfix function.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param ");
    char _charAt_13 = type.charAt(0);
    _builder.append(_charAt_13, " ");
    _builder.append("  ");
    String _article_4 = this.article(type);
    _builder.append(_article_4, " ");
    _builder.append(" ");
    String _wrapperType_6 = this.wrapperType(type);
    String _firstLower_4 = StringExtensions.toFirstLower(_wrapperType_6);
    _builder.append(_firstLower_4, " ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @return   <code>");
    char _charAt_14 = type.charAt(0);
    _builder.append(_charAt_14, " ");
    _builder.append("++</code>");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @since 2.6");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Inline(value=\"$1++\")");
    _builder.newLine();
    _builder.append("public static ");
    String _wrapperType_7 = this.wrapperType(type);
    _builder.append(_wrapperType_7, "");
    _builder.append(" ");
    QualifiedName _methodName_4 = this._operatorMapping.getMethodName(OperatorMapping.PLUS_PLUS);
    _builder.append(_methodName_4, "");
    _builder.append("(");
    String _wrapperType_8 = this.wrapperType(type);
    _builder.append(_wrapperType_8, "");
    _builder.append(" ");
    char _charAt_15 = type.charAt(0);
    _builder.append(_charAt_15, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("throw new HardcodedInInterpreterException();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    {
      for(final String other : this.types) {
        CharSequence _generateOperations = this.generateOperations(type, other);
        _builder.append(_generateOperations, "");
        _builder.newLineIfNotEmpty();
      }
    }
    String _endMarker = this.endMarker();
    _builder.append(_endMarker, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateOperations(final String op1, final String op2) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final QualifiedName operator : this.operators) {
        _builder.append("/**");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* The binary <code>");
        QualifiedName _methodName = this._operatorMapping.getMethodName(operator);
        String _string = _methodName.toString();
        String _replace = _string.replace("operator_", "");
        _builder.append(_replace, " ");
        _builder.append("</code> operator. This is the equivalent to the Java <code>");
        String _html = this.toHtml(operator);
        _builder.append(_html, " ");
        _builder.append("</code> operator.");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("* ");
        _builder.newLine();
        _builder.append(" ");
        _builder.append("* @param a  ");
        String _article = this.article(op1);
        _builder.append(_article, " ");
        _builder.append(" ");
        String _wrapperType = this.wrapperType(op1);
        String _firstLower = StringExtensions.toFirstLower(_wrapperType);
        _builder.append(_firstLower, " ");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("* @param b  ");
        String _article_1 = this.article(op2);
        _builder.append(_article_1, " ");
        _builder.append(" ");
        String _wrapperType_1 = this.wrapperType(op2);
        String _firstLower_1 = StringExtensions.toFirstLower(_wrapperType_1);
        _builder.append(_firstLower_1, " ");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("* @return   <code>a");
        String _html_1 = this.toHtml(operator);
        _builder.append(_html_1, " ");
        _builder.append("b</code>");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("* @since ");
        _builder.append(ArithmeticExtensionGenerator.since, " ");
        _builder.newLineIfNotEmpty();
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("@Pure");
        _builder.newLine();
        _builder.append("@Inline(value=\"($1 ");
        _builder.append(operator, "");
        _builder.append(" $2)\", constantExpression=true)");
        _builder.newLineIfNotEmpty();
        _builder.append("public static ");
        String _returnType = this.returnType(op1, operator, op2);
        _builder.append(_returnType, "");
        _builder.append(" ");
        QualifiedName _methodName_1 = this._operatorMapping.getMethodName(operator);
        _builder.append(_methodName_1, "");
        _builder.append("(");
        _builder.append(op1, "");
        _builder.append(" a, ");
        _builder.append(op2, "");
        _builder.append(" b) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return a ");
        _builder.append(operator, "\t");
        _builder.append(" b;");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
      }
    }
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* The binary <code>power</code> operator. This is the equivalent to the Java\'s <code>Math.pow()</code> function.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param a  ");
    String _article_2 = this.article(op1);
    _builder.append(_article_2, " ");
    _builder.append(" ");
    String _wrapperType_2 = this.wrapperType(op1);
    String _firstLower_2 = StringExtensions.toFirstLower(_wrapperType_2);
    _builder.append(_firstLower_2, " ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @param b  ");
    String _article_3 = this.article(op2);
    _builder.append(_article_3, " ");
    _builder.append(" ");
    String _wrapperType_3 = this.wrapperType(op2);
    String _firstLower_3 = StringExtensions.toFirstLower(_wrapperType_3);
    _builder.append(_firstLower_3, " ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @return   <code>Math.pow(a, b)</code>");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @since ");
    _builder.append(ArithmeticExtensionGenerator.since, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Pure");
    _builder.newLine();
    _builder.append("@Inline(value=\"$3.pow($1, $2)\", imported=Math.class)");
    _builder.newLine();
    _builder.append("public static double ");
    QualifiedName _methodName_2 = this._operatorMapping.getMethodName(OperatorMapping.POWER);
    _builder.append(_methodName_2, "");
    _builder.append("(");
    _builder.append(op1, "");
    _builder.append(" a, ");
    _builder.append(op2, "");
    _builder.append(" b) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return Math.pow(a, b);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* The <code>identity equals</code> operator. This is the equivalent to Java\'s <code>==</code>");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* operator.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param a  ");
    String _article_4 = this.article(op1);
    _builder.append(_article_4, " ");
    _builder.append(" ");
    String _wrapperType_4 = this.wrapperType(op1);
    String _firstLower_4 = StringExtensions.toFirstLower(_wrapperType_4);
    _builder.append(_firstLower_4, " ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @param b  ");
    String _article_5 = this.article(op2);
    _builder.append(_article_5, " ");
    _builder.append(" ");
    String _wrapperType_5 = this.wrapperType(op2);
    String _firstLower_5 = StringExtensions.toFirstLower(_wrapperType_5);
    _builder.append(_firstLower_5, " ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @return   <code>a == b</code>");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @since 2.4");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Pure");
    _builder.newLine();
    _builder.append("@Inline(value=\"($1 == $2)\", constantExpression=true)");
    _builder.newLine();
    _builder.append("public static boolean ");
    QualifiedName _methodName_3 = this._operatorMapping.getMethodName(OperatorMapping.TRIPLE_EQUALS);
    _builder.append(_methodName_3, "");
    _builder.append("(");
    _builder.append(op1, "");
    _builder.append(" a, ");
    _builder.append(op2, "");
    _builder.append(" b) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return a == b;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* The <code>identity not equals</code> operator. This is the equivalent to Java\'s <code>!=</code>");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* operator.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @param a  ");
    String _article_6 = this.article(op1);
    _builder.append(_article_6, " ");
    _builder.append(" ");
    String _wrapperType_6 = this.wrapperType(op1);
    String _firstLower_6 = StringExtensions.toFirstLower(_wrapperType_6);
    _builder.append(_firstLower_6, " ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @param b  ");
    String _article_7 = this.article(op2);
    _builder.append(_article_7, " ");
    _builder.append(" ");
    String _wrapperType_7 = this.wrapperType(op2);
    String _firstLower_7 = StringExtensions.toFirstLower(_wrapperType_7);
    _builder.append(_firstLower_7, " ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @return   <code>a != b</code>");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @since 2.4");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Pure");
    _builder.newLine();
    _builder.append("@Inline(value=\"($1 != $2)\", constantExpression=true)");
    _builder.newLine();
    _builder.append("public static boolean ");
    QualifiedName _methodName_4 = this._operatorMapping.getMethodName(OperatorMapping.TRIPLE_NOT_EQUALS);
    _builder.append(_methodName_4, "");
    _builder.append("(");
    _builder.append(op1, "");
    _builder.append(" a, ");
    _builder.append(op2, "");
    _builder.append(" b) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return a != b;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Binary numeric promotion, see http://java.sun.com/docs/books/jls/second_edition/html/conversions.doc.html#170983
   */
  public String returnType(final String o1, final QualifiedName operator, final String o2) {
    String _xifexpression = null;
    boolean _contains = this.comparators.contains(operator);
    if (_contains) {
      _xifexpression = "boolean";
    } else {
      String _xblockexpression = null;
      {
        final HashSet<String> operands = CollectionLiterals.<String>newHashSet(o1, o2);
        String _xifexpression_1 = null;
        boolean _contains_1 = operands.contains("double");
        if (_contains_1) {
          _xifexpression_1 = "double";
        } else {
          String _xifexpression_2 = null;
          boolean _contains_2 = operands.contains("float");
          if (_contains_2) {
            _xifexpression_2 = "float";
          } else {
            String _xifexpression_3 = null;
            boolean _contains_3 = operands.contains("long");
            if (_contains_3) {
              _xifexpression_3 = "long";
            } else {
              _xifexpression_3 = "int";
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public String article(final String it) {
    String _switchResult = null;
    String _lowerCase = it.toLowerCase();
    String _substring = _lowerCase.substring(0, 1);
    boolean _matched = false;
    if (Objects.equal(_substring, "a")) {
      _matched=true;
    }
    if (!_matched) {
      if (Objects.equal(_substring, "e")) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_substring, "i")) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_substring, "o")) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_substring, "u")) {
        _matched=true;
      }
    }
    if (_matched) {
      _switchResult = "an";
    }
    if (!_matched) {
      _switchResult = "a";
    }
    return _switchResult;
  }
  
  public String wrapperType(final String it) {
    String _switchResult = null;
    boolean _matched = false;
    if (Objects.equal(it, "int")) {
      _matched=true;
      _switchResult = "Integer";
    }
    if (!_matched) {
      if (Objects.equal(it, "char")) {
        _matched=true;
        _switchResult = "Character";
      }
    }
    if (!_matched) {
      _switchResult = StringExtensions.toFirstUpper(it);
    }
    return _switchResult;
  }
  
  public String className(final String it) {
    String _wrapperType = this.wrapperType(it);
    return (_wrapperType + "Extensions");
  }
  
  public String toHtml(final QualifiedName it) {
    String _string = it.toString();
    String _replace = _string.replace("<", "&lt;");
    return _replace.replace(">", "&gt;");
  }
  
  public String startMarker() {
    return "// BEGIN generated code";
  }
  
  public String endMarker() {
    return "// END generated code\n";
  }
}
