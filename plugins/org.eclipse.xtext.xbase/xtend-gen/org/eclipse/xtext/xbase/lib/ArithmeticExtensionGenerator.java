package org.eclipse.xtext.xbase.lib;

import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;

@SuppressWarnings("all")
public class ArithmeticExtensionGenerator {
  public static void main(final String[] args) {
    XbaseStandaloneSetup _xbaseStandaloneSetup = new XbaseStandaloneSetup();
    Injector _createInjectorAndDoEMFRegistration = _xbaseStandaloneSetup.createInjectorAndDoEMFRegistration();
    ArithmeticExtensionGenerator _instance = _createInjectorAndDoEMFRegistration.<ArithmeticExtensionGenerator>getInstance(org.eclipse.xtext.xbase.lib.ArithmeticExtensionGenerator.class);
    _instance.generate();
  }
  
  private List<String> types = new Function0<List<String>>() {
    public List<String> apply() {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("double", "float", "long", "int", "char", "short", "byte");
      return _newArrayList;
    }
  }.apply();
  
  private List<QualifiedName> comparators = new Function0<List<QualifiedName>>() {
    public List<QualifiedName> apply() {
      QualifiedName _LESS_THAN = OperatorMapping.LESS_THAN;
      QualifiedName _LESS_EQUALS_THAN = OperatorMapping.LESS_EQUALS_THAN;
      QualifiedName _GREATER_THAN = OperatorMapping.GREATER_THAN;
      QualifiedName _GREATER_EQUALS_THAN = OperatorMapping.GREATER_EQUALS_THAN;
      QualifiedName _EQUALS = OperatorMapping.EQUALS;
      QualifiedName _NOT_EQUALS = OperatorMapping.NOT_EQUALS;
      ArrayList<QualifiedName> _newArrayList = CollectionLiterals.<QualifiedName>newArrayList(_LESS_THAN, _LESS_EQUALS_THAN, _GREATER_THAN, _GREATER_EQUALS_THAN, _EQUALS, _NOT_EQUALS);
      return _newArrayList;
    }
  }.apply();
  
  private List<QualifiedName> operators = new Function0<List<QualifiedName>>() {
    public List<QualifiedName> apply() {
      QualifiedName _PLUS = OperatorMapping.PLUS;
      QualifiedName _MINUS = OperatorMapping.MINUS;
      QualifiedName _MULTIPLY = OperatorMapping.MULTIPLY;
      QualifiedName _DIVIDE = OperatorMapping.DIVIDE;
      QualifiedName _MODULO = OperatorMapping.MODULO;
      QualifiedName _LESS_THAN = OperatorMapping.LESS_THAN;
      QualifiedName _LESS_EQUALS_THAN = OperatorMapping.LESS_EQUALS_THAN;
      QualifiedName _GREATER_THAN = OperatorMapping.GREATER_THAN;
      QualifiedName _GREATER_EQUALS_THAN = OperatorMapping.GREATER_EQUALS_THAN;
      QualifiedName _EQUALS = OperatorMapping.EQUALS;
      QualifiedName _NOT_EQUALS = OperatorMapping.NOT_EQUALS;
      ArrayList<QualifiedName> _newArrayList = CollectionLiterals.<QualifiedName>newArrayList(_PLUS, _MINUS, _MULTIPLY, _DIVIDE, _MODULO, _LESS_THAN, _LESS_EQUALS_THAN, _GREATER_THAN, _GREATER_EQUALS_THAN, _EQUALS, _NOT_EQUALS);
      return _newArrayList;
    }
  }.apply();
  
  @Inject
  private OperatorMapping _operatorMapping;
  
  public void generate() {
    try {
      {
        final String path = "../org.eclipse.xtext.xbase.lib/src/org/eclipse/xtext/xbase/lib/";
        File _file = new File(path);
        _file.mkdirs();
        List<String> _types = this.types;
        for (final String type : _types) {
          {
            String _className = this.className(type);
            String _operator_plus = StringExtensions.operator_plus(path, _className);
            String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ".java");
            File _file_1 = new File(_operator_plus_1);
            final File file = _file_1;
            CharSequence _xifexpression = null;
            boolean _exists = file.exists();
            if (_exists) {
              CharSequence _xblockexpression = null;
              {
                String _absolutePath = file.getAbsolutePath();
                String _readFileIntoString = Files.readFileIntoString(_absolutePath);
                final String content = _readFileIntoString;
                StringConcatenation _builder = new StringConcatenation();
                String _startMarker = this.startMarker();
                int _indexOf = content.indexOf(_startMarker);
                String _substring = content.substring(0, _indexOf);
                _builder.append(_substring, "");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                CharSequence _generateAllOperations = this.generateAllOperations(type);
                _builder.append(_generateAllOperations, "	");
                _builder.newLineIfNotEmpty();
                String _endMarker = this.endMarker();
                int _indexOf_1 = content.indexOf(_endMarker);
                String _endMarker_1 = this.endMarker();
                int _length = _endMarker_1.length();
                int _operator_plus_2 = IntegerExtensions.operator_plus(_indexOf_1, _length);
                String _substring_1 = content.substring(_operator_plus_2);
                _builder.append(_substring_1, "");
                _builder.newLineIfNotEmpty();
                _xblockexpression = (_builder);
              }
              _xifexpression = _xblockexpression;
            } else {
              CharSequence _generate = this.generate(type);
              _xifexpression = _generate;
            }
            final CharSequence newContent = _xifexpression;
            FileWriter _fileWriter = new FileWriter(file);
            final FileWriter writer = _fileWriter;
            writer.append(newContent);
            writer.close();
          }
        }
      }
    } catch (Exception _e) {
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
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class ");
    String _className = this.className(type);
    _builder.append(_className, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generateAllOperations = this.generateAllOperations(type);
    _builder.append(_generateAllOperations, "	");
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
    _builder.append("* @param a  ");
    String _article = this.article(type);
    _builder.append(_article, " ");
    _builder.append(" ");
    String _wrapperType = this.wrapperType(type);
    String _firstLower = StringExtensions.toFirstLower(_wrapperType);
    _builder.append(_firstLower, " ");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @return   <code>-a</code>");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public static ");
    QualifiedName _MINUS = OperatorMapping.MINUS;
    String _returnType = this.returnType(type, _MINUS, type);
    _builder.append(_returnType, "");
    _builder.append(" ");
    QualifiedName _MINUS_1 = OperatorMapping.MINUS;
    QualifiedName _methodName = this._operatorMapping.getMethodName(_MINUS_1);
    _builder.append(_methodName, "");
    _builder.append("(");
    _builder.append(type, "");
    _builder.append(" a) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return -a;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      List<String> _types = this.types;
      for(final String other : _types) {
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
      List<QualifiedName> _operators = this.operators;
      for(final QualifiedName operator : _operators) {
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
        _builder.append("*/");
        _builder.newLine();
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
        _builder.append(operator, "	");
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
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public static double ");
    QualifiedName _POWER = OperatorMapping.POWER;
    QualifiedName _methodName_2 = this._operatorMapping.getMethodName(_POWER);
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
    return _builder;
  }
  
  /**
   * Binary numeric promotion, see http://java.sun.com/docs/books/jls/second_edition/html/conversions.doc.html#170983
   */
  public String returnType(final String o1, final QualifiedName operator, final String o2) {
    String _xifexpression = null;
    List<QualifiedName> _comparators = this.comparators;
    boolean _contains = _comparators.contains(operator);
    if (_contains) {
      _xifexpression = "boolean";
    } else {
      String _xblockexpression = null;
      {
        HashSet<String> _newHashSet = CollectionLiterals.<String>newHashSet(o1, o2);
        final HashSet<String> operands = _newHashSet;
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
        _xblockexpression = (_xifexpression_1);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public String article(final String it) {
    String _switchResult = null;
    String _lowerCase = it==null?(String)null:it.toLowerCase();
    String _substring = _lowerCase.substring(0, 1);
    final String __valOfSwitchOver = _substring;
    boolean matched = false;
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,"a")) {
        matched=true;
        _switchResult = "an";
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,"e")) {
        matched=true;
        _switchResult = "an";
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,"i")) {
        matched=true;
        _switchResult = "an";
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,"o")) {
        matched=true;
        _switchResult = "an";
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(__valOfSwitchOver,"u")) {
        matched=true;
        _switchResult = "an";
      }
    }
    if (!matched) {
      _switchResult = "a";
    }
    return _switchResult;
  }
  
  public String wrapperType(final String it) {
    String _switchResult = null;
    boolean matched = false;
    if (!matched) {
      if (ObjectExtensions.operator_equals(it,"int")) {
        matched=true;
        _switchResult = "Integer";
      }
    }
    if (!matched) {
      if (ObjectExtensions.operator_equals(it,"char")) {
        matched=true;
        _switchResult = "Character";
      }
    }
    if (!matched) {
      String _firstUpper = StringExtensions.toFirstUpper(it);
      _switchResult = _firstUpper;
    }
    return _switchResult;
  }
  
  public String className(final String it) {
    String _wrapperType = this.wrapperType(it);
    String _operator_plus = StringExtensions.operator_plus(_wrapperType, "Extensions");
    return _operator_plus;
  }
  
  public String toHtml(final QualifiedName it) {
    String _string = it.toString();
    String _replace = _string.replace("<", "&lt;");
    String _replace_1 = _replace.replace(">", "&gt;");
    return _replace_1;
  }
  
  public String startMarker() {
    return "// BEGIN generated code";
  }
  
  public String endMarker() {
    return "// END generated code";
  }
}
