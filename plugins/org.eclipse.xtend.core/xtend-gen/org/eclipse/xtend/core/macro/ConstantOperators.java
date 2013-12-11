/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.core.macro.ConstantExpressionEvaluationException;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.InputOutput;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ConstantOperators {
  protected Object _minus(final Object operand) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(("Unsupported operator \'-\' for operand " + operand));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _minus(final Integer e) {
    return (-(e).intValue());
  }
  
  protected Object _minus(final Double e) {
    double _minus = DoubleExtensions.operator_minus(e);
    return _minus;
  }
  
  protected Object _minus(final Long e) {
    return (-(e).longValue());
  }
  
  protected Object _minus(final Short e) {
    return (-(e).shortValue());
  }
  
  protected Object _minus(final Float e) {
    return (-(e).floatValue());
  }
  
  protected Object _minus(final Byte e) {
    return (-(e).byteValue());
  }
  
  protected Object _plus(final String left, final Object right) {
    return (left + right);
  }
  
  public static void main(final String[] args) {
    Map<String,String> _xsetliteral = null;
    Map<String,String> _tempMap = Maps.<String, String>newHashMap();
    _tempMap.put("Integer", "intValue()");
    _tempMap.put("Short", "shortValue()");
    _tempMap.put("Long", "longValue()");
    _tempMap.put("Float", "floatValue()");
    _tempMap.put("Double", "doubleValue()");
    _tempMap.put("Byte", "byteValue()");
    _xsetliteral = Collections.<String, String>unmodifiableMap(_tempMap);
    final Map<String,String> types = _xsetliteral;
    Map<String,String> _xsetliteral_1 = null;
    Map<String,String> _tempMap_1 = Maps.<String, String>newHashMap();
    _tempMap_1.put("plus", "+");
    _tempMap_1.put("minus", "-");
    _tempMap_1.put("divide", "/");
    _tempMap_1.put("multiply", "*");
    _tempMap_1.put("modulo", "%");
    _tempMap_1.put("lessThan", "<");
    _tempMap_1.put("greaterThan", ">");
    _tempMap_1.put("lessEquals", "<=");
    _tempMap_1.put("greaterEquals", ">=");
    _tempMap_1.put("same", "===");
    _tempMap_1.put("notSame", "!==");
    _xsetliteral_1 = Collections.<String, String>unmodifiableMap(_tempMap_1);
    final Map<String,String> operators = _xsetliteral_1;
    final Set<String> booleanOps = Collections.<String>unmodifiableSet(Sets.<String>newHashSet("<", "<=", ">", ">=", "===", "!=="));
    Set<Map.Entry<String,String>> _entrySet = operators.entrySet();
    for (final Map.Entry<String,String> op : _entrySet) {
      {
        String _xifexpression = null;
        String _value = op.getValue();
        boolean _contains = booleanOps.contains(_value);
        if (_contains) {
          _xifexpression = "boolean ";
        } else {
          _xifexpression = "";
        }
        final String returnType = _xifexpression;
        StringConcatenation _builder = new StringConcatenation();
        _builder.newLine();
        _builder.append("def dispatch ");
        _builder.append(returnType, "");
        String _key = op.getKey();
        _builder.append(_key, "");
        _builder.append("(Object left, Object right) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("throw new ConstantExpressionEvaluationException(\"Unsupported operator \'");
        String _value_1 = op.getValue();
        _builder.append(_value_1, "\t");
        _builder.append("\' for operands \"+left+\" and \"+right);");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        InputOutput.<String>println(_builder.toString());
        Set<String> _keySet = types.keySet();
        for (final String left : _keySet) {
          {
            InputOutput.<String>println("");
            Set<String> _keySet_1 = types.keySet();
            for (final String right : _keySet_1) {
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("def dispatch ");
              _builder_1.append(returnType, "");
              String _key_1 = op.getKey();
              _builder_1.append(_key_1, "");
              _builder_1.append("(");
              _builder_1.append(left, "");
              _builder_1.append(" left, ");
              _builder_1.append(right, "");
              _builder_1.append(" right) { left.");
              String _get = types.get(left);
              _builder_1.append(_get, "");
              _builder_1.append(" ");
              String _value_2 = op.getValue();
              _builder_1.append(_value_2, "");
              _builder_1.append(" right.");
              String _get_1 = types.get(right);
              _builder_1.append(_get_1, "");
              _builder_1.append(" }");
              InputOutput.<String>println(_builder_1.toString());
            }
          }
        }
      }
    }
  }
  
  protected Object _plus(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'+\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _plus(final Byte left, final Byte right) {
    byte _byteValue = left.byteValue();
    byte _byteValue_1 = right.byteValue();
    int _plus = (_byteValue + _byteValue_1);
    return _plus;
  }
  
  protected Object _plus(final Byte left, final Double right) {
    byte _byteValue = left.byteValue();
    double _doubleValue = right.doubleValue();
    double _plus = (_byteValue + _doubleValue);
    return _plus;
  }
  
  protected Object _plus(final Byte left, final Float right) {
    byte _byteValue = left.byteValue();
    float _floatValue = right.floatValue();
    float _plus = (_byteValue + _floatValue);
    return _plus;
  }
  
  protected Object _plus(final Byte left, final Long right) {
    byte _byteValue = left.byteValue();
    long _longValue = right.longValue();
    long _plus = (_byteValue + _longValue);
    return _plus;
  }
  
  protected Object _plus(final Byte left, final Short right) {
    byte _byteValue = left.byteValue();
    short _shortValue = right.shortValue();
    int _plus = (_byteValue + _shortValue);
    return _plus;
  }
  
  protected Object _plus(final Byte left, final Integer right) {
    byte _byteValue = left.byteValue();
    int _intValue = right.intValue();
    int _plus = (_byteValue + _intValue);
    return _plus;
  }
  
  protected Object _plus(final Double left, final Byte right) {
    double _doubleValue = left.doubleValue();
    byte _byteValue = right.byteValue();
    double _plus = (_doubleValue + _byteValue);
    return _plus;
  }
  
  protected Object _plus(final Double left, final Double right) {
    double _doubleValue = left.doubleValue();
    double _doubleValue_1 = right.doubleValue();
    double _plus = (_doubleValue + _doubleValue_1);
    return _plus;
  }
  
  protected Object _plus(final Double left, final Float right) {
    double _doubleValue = left.doubleValue();
    float _floatValue = right.floatValue();
    double _plus = (_doubleValue + _floatValue);
    return _plus;
  }
  
  protected Object _plus(final Double left, final Long right) {
    double _doubleValue = left.doubleValue();
    long _longValue = right.longValue();
    double _plus = (_doubleValue + _longValue);
    return _plus;
  }
  
  protected Object _plus(final Double left, final Short right) {
    double _doubleValue = left.doubleValue();
    short _shortValue = right.shortValue();
    double _plus = (_doubleValue + _shortValue);
    return _plus;
  }
  
  protected Object _plus(final Double left, final Integer right) {
    double _doubleValue = left.doubleValue();
    int _intValue = right.intValue();
    double _plus = (_doubleValue + _intValue);
    return _plus;
  }
  
  protected Object _plus(final Float left, final Byte right) {
    float _floatValue = left.floatValue();
    byte _byteValue = right.byteValue();
    float _plus = (_floatValue + _byteValue);
    return _plus;
  }
  
  protected Object _plus(final Float left, final Double right) {
    float _floatValue = left.floatValue();
    double _doubleValue = right.doubleValue();
    double _plus = (_floatValue + _doubleValue);
    return _plus;
  }
  
  protected Object _plus(final Float left, final Float right) {
    float _floatValue = left.floatValue();
    float _floatValue_1 = right.floatValue();
    float _plus = (_floatValue + _floatValue_1);
    return _plus;
  }
  
  protected Object _plus(final Float left, final Long right) {
    float _floatValue = left.floatValue();
    long _longValue = right.longValue();
    float _plus = (_floatValue + _longValue);
    return _plus;
  }
  
  protected Object _plus(final Float left, final Short right) {
    float _floatValue = left.floatValue();
    short _shortValue = right.shortValue();
    float _plus = (_floatValue + _shortValue);
    return _plus;
  }
  
  protected Object _plus(final Float left, final Integer right) {
    float _floatValue = left.floatValue();
    int _intValue = right.intValue();
    float _plus = (_floatValue + _intValue);
    return _plus;
  }
  
  protected Object _plus(final Long left, final Byte right) {
    long _longValue = left.longValue();
    byte _byteValue = right.byteValue();
    long _plus = (_longValue + _byteValue);
    return _plus;
  }
  
  protected Object _plus(final Long left, final Double right) {
    long _longValue = left.longValue();
    double _doubleValue = right.doubleValue();
    double _plus = (_longValue + _doubleValue);
    return _plus;
  }
  
  protected Object _plus(final Long left, final Float right) {
    long _longValue = left.longValue();
    float _floatValue = right.floatValue();
    float _plus = (_longValue + _floatValue);
    return _plus;
  }
  
  protected Object _plus(final Long left, final Long right) {
    long _longValue = left.longValue();
    long _longValue_1 = right.longValue();
    long _plus = (_longValue + _longValue_1);
    return _plus;
  }
  
  protected Object _plus(final Long left, final Short right) {
    long _longValue = left.longValue();
    short _shortValue = right.shortValue();
    long _plus = (_longValue + _shortValue);
    return _plus;
  }
  
  protected Object _plus(final Long left, final Integer right) {
    long _longValue = left.longValue();
    int _intValue = right.intValue();
    long _plus = (_longValue + _intValue);
    return _plus;
  }
  
  protected Object _plus(final Short left, final Byte right) {
    short _shortValue = left.shortValue();
    byte _byteValue = right.byteValue();
    int _plus = (_shortValue + _byteValue);
    return _plus;
  }
  
  protected Object _plus(final Short left, final Double right) {
    short _shortValue = left.shortValue();
    double _doubleValue = right.doubleValue();
    double _plus = (_shortValue + _doubleValue);
    return _plus;
  }
  
  protected Object _plus(final Short left, final Float right) {
    short _shortValue = left.shortValue();
    float _floatValue = right.floatValue();
    float _plus = (_shortValue + _floatValue);
    return _plus;
  }
  
  protected Object _plus(final Short left, final Long right) {
    short _shortValue = left.shortValue();
    long _longValue = right.longValue();
    long _plus = (_shortValue + _longValue);
    return _plus;
  }
  
  protected Object _plus(final Short left, final Short right) {
    short _shortValue = left.shortValue();
    short _shortValue_1 = right.shortValue();
    int _plus = (_shortValue + _shortValue_1);
    return _plus;
  }
  
  protected Object _plus(final Short left, final Integer right) {
    short _shortValue = left.shortValue();
    int _intValue = right.intValue();
    int _plus = (_shortValue + _intValue);
    return _plus;
  }
  
  protected Object _plus(final Integer left, final Byte right) {
    int _intValue = left.intValue();
    byte _byteValue = right.byteValue();
    int _plus = (_intValue + _byteValue);
    return _plus;
  }
  
  protected Object _plus(final Integer left, final Double right) {
    int _intValue = left.intValue();
    double _doubleValue = right.doubleValue();
    double _plus = (_intValue + _doubleValue);
    return _plus;
  }
  
  protected Object _plus(final Integer left, final Float right) {
    int _intValue = left.intValue();
    float _floatValue = right.floatValue();
    float _plus = (_intValue + _floatValue);
    return _plus;
  }
  
  protected Object _plus(final Integer left, final Long right) {
    int _intValue = left.intValue();
    long _longValue = right.longValue();
    long _plus = (_intValue + _longValue);
    return _plus;
  }
  
  protected Object _plus(final Integer left, final Short right) {
    int _intValue = left.intValue();
    short _shortValue = right.shortValue();
    int _plus = (_intValue + _shortValue);
    return _plus;
  }
  
  protected Object _plus(final Integer left, final Integer right) {
    int _intValue = left.intValue();
    int _intValue_1 = right.intValue();
    int _plus = (_intValue + _intValue_1);
    return _plus;
  }
  
  protected boolean _lessThan(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'<\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected boolean _lessThan(final Byte left, final Byte right) {
    byte _byteValue = left.byteValue();
    byte _byteValue_1 = right.byteValue();
    boolean _lessThan = (_byteValue < _byteValue_1);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Byte left, final Double right) {
    byte _byteValue = left.byteValue();
    double _doubleValue = right.doubleValue();
    boolean _lessThan = (_byteValue < _doubleValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Byte left, final Float right) {
    byte _byteValue = left.byteValue();
    float _floatValue = right.floatValue();
    boolean _lessThan = (_byteValue < _floatValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Byte left, final Long right) {
    byte _byteValue = left.byteValue();
    long _longValue = right.longValue();
    boolean _lessThan = (_byteValue < _longValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Byte left, final Short right) {
    byte _byteValue = left.byteValue();
    short _shortValue = right.shortValue();
    boolean _lessThan = (_byteValue < _shortValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Byte left, final Integer right) {
    byte _byteValue = left.byteValue();
    int _intValue = right.intValue();
    boolean _lessThan = (_byteValue < _intValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Double left, final Byte right) {
    double _doubleValue = left.doubleValue();
    byte _byteValue = right.byteValue();
    boolean _lessThan = (_doubleValue < _byteValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Double left, final Double right) {
    double _doubleValue = left.doubleValue();
    double _doubleValue_1 = right.doubleValue();
    boolean _lessThan = (_doubleValue < _doubleValue_1);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Double left, final Float right) {
    double _doubleValue = left.doubleValue();
    float _floatValue = right.floatValue();
    boolean _lessThan = (_doubleValue < _floatValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Double left, final Long right) {
    double _doubleValue = left.doubleValue();
    long _longValue = right.longValue();
    boolean _lessThan = (_doubleValue < _longValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Double left, final Short right) {
    double _doubleValue = left.doubleValue();
    short _shortValue = right.shortValue();
    boolean _lessThan = (_doubleValue < _shortValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Double left, final Integer right) {
    double _doubleValue = left.doubleValue();
    int _intValue = right.intValue();
    boolean _lessThan = (_doubleValue < _intValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Float left, final Byte right) {
    float _floatValue = left.floatValue();
    byte _byteValue = right.byteValue();
    boolean _lessThan = (_floatValue < _byteValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Float left, final Double right) {
    float _floatValue = left.floatValue();
    double _doubleValue = right.doubleValue();
    boolean _lessThan = (_floatValue < _doubleValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Float left, final Float right) {
    float _floatValue = left.floatValue();
    float _floatValue_1 = right.floatValue();
    boolean _lessThan = (_floatValue < _floatValue_1);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Float left, final Long right) {
    float _floatValue = left.floatValue();
    long _longValue = right.longValue();
    boolean _lessThan = (_floatValue < _longValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Float left, final Short right) {
    float _floatValue = left.floatValue();
    short _shortValue = right.shortValue();
    boolean _lessThan = (_floatValue < _shortValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Float left, final Integer right) {
    float _floatValue = left.floatValue();
    int _intValue = right.intValue();
    boolean _lessThan = (_floatValue < _intValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Long left, final Byte right) {
    long _longValue = left.longValue();
    byte _byteValue = right.byteValue();
    boolean _lessThan = (_longValue < _byteValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Long left, final Double right) {
    long _longValue = left.longValue();
    double _doubleValue = right.doubleValue();
    boolean _lessThan = (_longValue < _doubleValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Long left, final Float right) {
    long _longValue = left.longValue();
    float _floatValue = right.floatValue();
    boolean _lessThan = (_longValue < _floatValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Long left, final Long right) {
    long _longValue = left.longValue();
    long _longValue_1 = right.longValue();
    boolean _lessThan = (_longValue < _longValue_1);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Long left, final Short right) {
    long _longValue = left.longValue();
    short _shortValue = right.shortValue();
    boolean _lessThan = (_longValue < _shortValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Long left, final Integer right) {
    long _longValue = left.longValue();
    int _intValue = right.intValue();
    boolean _lessThan = (_longValue < _intValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Short left, final Byte right) {
    short _shortValue = left.shortValue();
    byte _byteValue = right.byteValue();
    boolean _lessThan = (_shortValue < _byteValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Short left, final Double right) {
    short _shortValue = left.shortValue();
    double _doubleValue = right.doubleValue();
    boolean _lessThan = (_shortValue < _doubleValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Short left, final Float right) {
    short _shortValue = left.shortValue();
    float _floatValue = right.floatValue();
    boolean _lessThan = (_shortValue < _floatValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Short left, final Long right) {
    short _shortValue = left.shortValue();
    long _longValue = right.longValue();
    boolean _lessThan = (_shortValue < _longValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Short left, final Short right) {
    short _shortValue = left.shortValue();
    short _shortValue_1 = right.shortValue();
    boolean _lessThan = (_shortValue < _shortValue_1);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Short left, final Integer right) {
    short _shortValue = left.shortValue();
    int _intValue = right.intValue();
    boolean _lessThan = (_shortValue < _intValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Integer left, final Byte right) {
    int _intValue = left.intValue();
    byte _byteValue = right.byteValue();
    boolean _lessThan = (_intValue < _byteValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Integer left, final Double right) {
    int _intValue = left.intValue();
    double _doubleValue = right.doubleValue();
    boolean _lessThan = (_intValue < _doubleValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Integer left, final Float right) {
    int _intValue = left.intValue();
    float _floatValue = right.floatValue();
    boolean _lessThan = (_intValue < _floatValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Integer left, final Long right) {
    int _intValue = left.intValue();
    long _longValue = right.longValue();
    boolean _lessThan = (_intValue < _longValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Integer left, final Short right) {
    int _intValue = left.intValue();
    short _shortValue = right.shortValue();
    boolean _lessThan = (_intValue < _shortValue);
    return _lessThan;
  }
  
  protected boolean _lessThan(final Integer left, final Integer right) {
    int _intValue = left.intValue();
    int _intValue_1 = right.intValue();
    boolean _lessThan = (_intValue < _intValue_1);
    return _lessThan;
  }
  
  protected Object _minus(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'-\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _minus(final Byte left, final Byte right) {
    byte _byteValue = left.byteValue();
    byte _byteValue_1 = right.byteValue();
    int _minus = (_byteValue - _byteValue_1);
    return _minus;
  }
  
  protected Object _minus(final Byte left, final Double right) {
    byte _byteValue = left.byteValue();
    double _doubleValue = right.doubleValue();
    double _minus = (_byteValue - _doubleValue);
    return _minus;
  }
  
  protected Object _minus(final Byte left, final Float right) {
    byte _byteValue = left.byteValue();
    float _floatValue = right.floatValue();
    float _minus = (_byteValue - _floatValue);
    return _minus;
  }
  
  protected Object _minus(final Byte left, final Long right) {
    byte _byteValue = left.byteValue();
    long _longValue = right.longValue();
    long _minus = (_byteValue - _longValue);
    return _minus;
  }
  
  protected Object _minus(final Byte left, final Short right) {
    byte _byteValue = left.byteValue();
    short _shortValue = right.shortValue();
    int _minus = (_byteValue - _shortValue);
    return _minus;
  }
  
  protected Object _minus(final Byte left, final Integer right) {
    byte _byteValue = left.byteValue();
    int _intValue = right.intValue();
    int _minus = (_byteValue - _intValue);
    return _minus;
  }
  
  protected Object _minus(final Double left, final Byte right) {
    double _doubleValue = left.doubleValue();
    byte _byteValue = right.byteValue();
    double _minus = (_doubleValue - _byteValue);
    return _minus;
  }
  
  protected Object _minus(final Double left, final Double right) {
    double _doubleValue = left.doubleValue();
    double _doubleValue_1 = right.doubleValue();
    double _minus = (_doubleValue - _doubleValue_1);
    return _minus;
  }
  
  protected Object _minus(final Double left, final Float right) {
    double _doubleValue = left.doubleValue();
    float _floatValue = right.floatValue();
    double _minus = (_doubleValue - _floatValue);
    return _minus;
  }
  
  protected Object _minus(final Double left, final Long right) {
    double _doubleValue = left.doubleValue();
    long _longValue = right.longValue();
    double _minus = (_doubleValue - _longValue);
    return _minus;
  }
  
  protected Object _minus(final Double left, final Short right) {
    double _doubleValue = left.doubleValue();
    short _shortValue = right.shortValue();
    double _minus = (_doubleValue - _shortValue);
    return _minus;
  }
  
  protected Object _minus(final Double left, final Integer right) {
    double _doubleValue = left.doubleValue();
    int _intValue = right.intValue();
    double _minus = (_doubleValue - _intValue);
    return _minus;
  }
  
  protected Object _minus(final Float left, final Byte right) {
    float _floatValue = left.floatValue();
    byte _byteValue = right.byteValue();
    float _minus = (_floatValue - _byteValue);
    return _minus;
  }
  
  protected Object _minus(final Float left, final Double right) {
    float _floatValue = left.floatValue();
    double _doubleValue = right.doubleValue();
    double _minus = (_floatValue - _doubleValue);
    return _minus;
  }
  
  protected Object _minus(final Float left, final Float right) {
    float _floatValue = left.floatValue();
    float _floatValue_1 = right.floatValue();
    float _minus = (_floatValue - _floatValue_1);
    return _minus;
  }
  
  protected Object _minus(final Float left, final Long right) {
    float _floatValue = left.floatValue();
    long _longValue = right.longValue();
    float _minus = (_floatValue - _longValue);
    return _minus;
  }
  
  protected Object _minus(final Float left, final Short right) {
    float _floatValue = left.floatValue();
    short _shortValue = right.shortValue();
    float _minus = (_floatValue - _shortValue);
    return _minus;
  }
  
  protected Object _minus(final Float left, final Integer right) {
    float _floatValue = left.floatValue();
    int _intValue = right.intValue();
    float _minus = (_floatValue - _intValue);
    return _minus;
  }
  
  protected Object _minus(final Long left, final Byte right) {
    long _longValue = left.longValue();
    byte _byteValue = right.byteValue();
    long _minus = (_longValue - _byteValue);
    return _minus;
  }
  
  protected Object _minus(final Long left, final Double right) {
    long _longValue = left.longValue();
    double _doubleValue = right.doubleValue();
    double _minus = (_longValue - _doubleValue);
    return _minus;
  }
  
  protected Object _minus(final Long left, final Float right) {
    long _longValue = left.longValue();
    float _floatValue = right.floatValue();
    float _minus = (_longValue - _floatValue);
    return _minus;
  }
  
  protected Object _minus(final Long left, final Long right) {
    long _longValue = left.longValue();
    long _longValue_1 = right.longValue();
    long _minus = (_longValue - _longValue_1);
    return _minus;
  }
  
  protected Object _minus(final Long left, final Short right) {
    long _longValue = left.longValue();
    short _shortValue = right.shortValue();
    long _minus = (_longValue - _shortValue);
    return _minus;
  }
  
  protected Object _minus(final Long left, final Integer right) {
    long _longValue = left.longValue();
    int _intValue = right.intValue();
    long _minus = (_longValue - _intValue);
    return _minus;
  }
  
  protected Object _minus(final Short left, final Byte right) {
    short _shortValue = left.shortValue();
    byte _byteValue = right.byteValue();
    int _minus = (_shortValue - _byteValue);
    return _minus;
  }
  
  protected Object _minus(final Short left, final Double right) {
    short _shortValue = left.shortValue();
    double _doubleValue = right.doubleValue();
    double _minus = (_shortValue - _doubleValue);
    return _minus;
  }
  
  protected Object _minus(final Short left, final Float right) {
    short _shortValue = left.shortValue();
    float _floatValue = right.floatValue();
    float _minus = (_shortValue - _floatValue);
    return _minus;
  }
  
  protected Object _minus(final Short left, final Long right) {
    short _shortValue = left.shortValue();
    long _longValue = right.longValue();
    long _minus = (_shortValue - _longValue);
    return _minus;
  }
  
  protected Object _minus(final Short left, final Short right) {
    short _shortValue = left.shortValue();
    short _shortValue_1 = right.shortValue();
    int _minus = (_shortValue - _shortValue_1);
    return _minus;
  }
  
  protected Object _minus(final Short left, final Integer right) {
    short _shortValue = left.shortValue();
    int _intValue = right.intValue();
    int _minus = (_shortValue - _intValue);
    return _minus;
  }
  
  protected Object _minus(final Integer left, final Byte right) {
    int _intValue = left.intValue();
    byte _byteValue = right.byteValue();
    int _minus = (_intValue - _byteValue);
    return _minus;
  }
  
  protected Object _minus(final Integer left, final Double right) {
    int _intValue = left.intValue();
    double _doubleValue = right.doubleValue();
    double _minus = (_intValue - _doubleValue);
    return _minus;
  }
  
  protected Object _minus(final Integer left, final Float right) {
    int _intValue = left.intValue();
    float _floatValue = right.floatValue();
    float _minus = (_intValue - _floatValue);
    return _minus;
  }
  
  protected Object _minus(final Integer left, final Long right) {
    int _intValue = left.intValue();
    long _longValue = right.longValue();
    long _minus = (_intValue - _longValue);
    return _minus;
  }
  
  protected Object _minus(final Integer left, final Short right) {
    int _intValue = left.intValue();
    short _shortValue = right.shortValue();
    int _minus = (_intValue - _shortValue);
    return _minus;
  }
  
  protected Object _minus(final Integer left, final Integer right) {
    int _intValue = left.intValue();
    int _intValue_1 = right.intValue();
    int _minus = (_intValue - _intValue_1);
    return _minus;
  }
  
  protected boolean _greaterThan(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'>\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected boolean _greaterThan(final Byte left, final Byte right) {
    byte _byteValue = left.byteValue();
    byte _byteValue_1 = right.byteValue();
    boolean _greaterThan = (_byteValue > _byteValue_1);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Byte left, final Double right) {
    byte _byteValue = left.byteValue();
    double _doubleValue = right.doubleValue();
    boolean _greaterThan = (_byteValue > _doubleValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Byte left, final Float right) {
    byte _byteValue = left.byteValue();
    float _floatValue = right.floatValue();
    boolean _greaterThan = (_byteValue > _floatValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Byte left, final Long right) {
    byte _byteValue = left.byteValue();
    long _longValue = right.longValue();
    boolean _greaterThan = (_byteValue > _longValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Byte left, final Short right) {
    byte _byteValue = left.byteValue();
    short _shortValue = right.shortValue();
    boolean _greaterThan = (_byteValue > _shortValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Byte left, final Integer right) {
    byte _byteValue = left.byteValue();
    int _intValue = right.intValue();
    boolean _greaterThan = (_byteValue > _intValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Double left, final Byte right) {
    double _doubleValue = left.doubleValue();
    byte _byteValue = right.byteValue();
    boolean _greaterThan = (_doubleValue > _byteValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Double left, final Double right) {
    double _doubleValue = left.doubleValue();
    double _doubleValue_1 = right.doubleValue();
    boolean _greaterThan = (_doubleValue > _doubleValue_1);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Double left, final Float right) {
    double _doubleValue = left.doubleValue();
    float _floatValue = right.floatValue();
    boolean _greaterThan = (_doubleValue > _floatValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Double left, final Long right) {
    double _doubleValue = left.doubleValue();
    long _longValue = right.longValue();
    boolean _greaterThan = (_doubleValue > _longValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Double left, final Short right) {
    double _doubleValue = left.doubleValue();
    short _shortValue = right.shortValue();
    boolean _greaterThan = (_doubleValue > _shortValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Double left, final Integer right) {
    double _doubleValue = left.doubleValue();
    int _intValue = right.intValue();
    boolean _greaterThan = (_doubleValue > _intValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Float left, final Byte right) {
    float _floatValue = left.floatValue();
    byte _byteValue = right.byteValue();
    boolean _greaterThan = (_floatValue > _byteValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Float left, final Double right) {
    float _floatValue = left.floatValue();
    double _doubleValue = right.doubleValue();
    boolean _greaterThan = (_floatValue > _doubleValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Float left, final Float right) {
    float _floatValue = left.floatValue();
    float _floatValue_1 = right.floatValue();
    boolean _greaterThan = (_floatValue > _floatValue_1);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Float left, final Long right) {
    float _floatValue = left.floatValue();
    long _longValue = right.longValue();
    boolean _greaterThan = (_floatValue > _longValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Float left, final Short right) {
    float _floatValue = left.floatValue();
    short _shortValue = right.shortValue();
    boolean _greaterThan = (_floatValue > _shortValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Float left, final Integer right) {
    float _floatValue = left.floatValue();
    int _intValue = right.intValue();
    boolean _greaterThan = (_floatValue > _intValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Long left, final Byte right) {
    long _longValue = left.longValue();
    byte _byteValue = right.byteValue();
    boolean _greaterThan = (_longValue > _byteValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Long left, final Double right) {
    long _longValue = left.longValue();
    double _doubleValue = right.doubleValue();
    boolean _greaterThan = (_longValue > _doubleValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Long left, final Float right) {
    long _longValue = left.longValue();
    float _floatValue = right.floatValue();
    boolean _greaterThan = (_longValue > _floatValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Long left, final Long right) {
    long _longValue = left.longValue();
    long _longValue_1 = right.longValue();
    boolean _greaterThan = (_longValue > _longValue_1);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Long left, final Short right) {
    long _longValue = left.longValue();
    short _shortValue = right.shortValue();
    boolean _greaterThan = (_longValue > _shortValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Long left, final Integer right) {
    long _longValue = left.longValue();
    int _intValue = right.intValue();
    boolean _greaterThan = (_longValue > _intValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Short left, final Byte right) {
    short _shortValue = left.shortValue();
    byte _byteValue = right.byteValue();
    boolean _greaterThan = (_shortValue > _byteValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Short left, final Double right) {
    short _shortValue = left.shortValue();
    double _doubleValue = right.doubleValue();
    boolean _greaterThan = (_shortValue > _doubleValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Short left, final Float right) {
    short _shortValue = left.shortValue();
    float _floatValue = right.floatValue();
    boolean _greaterThan = (_shortValue > _floatValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Short left, final Long right) {
    short _shortValue = left.shortValue();
    long _longValue = right.longValue();
    boolean _greaterThan = (_shortValue > _longValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Short left, final Short right) {
    short _shortValue = left.shortValue();
    short _shortValue_1 = right.shortValue();
    boolean _greaterThan = (_shortValue > _shortValue_1);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Short left, final Integer right) {
    short _shortValue = left.shortValue();
    int _intValue = right.intValue();
    boolean _greaterThan = (_shortValue > _intValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Integer left, final Byte right) {
    int _intValue = left.intValue();
    byte _byteValue = right.byteValue();
    boolean _greaterThan = (_intValue > _byteValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Integer left, final Double right) {
    int _intValue = left.intValue();
    double _doubleValue = right.doubleValue();
    boolean _greaterThan = (_intValue > _doubleValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Integer left, final Float right) {
    int _intValue = left.intValue();
    float _floatValue = right.floatValue();
    boolean _greaterThan = (_intValue > _floatValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Integer left, final Long right) {
    int _intValue = left.intValue();
    long _longValue = right.longValue();
    boolean _greaterThan = (_intValue > _longValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Integer left, final Short right) {
    int _intValue = left.intValue();
    short _shortValue = right.shortValue();
    boolean _greaterThan = (_intValue > _shortValue);
    return _greaterThan;
  }
  
  protected boolean _greaterThan(final Integer left, final Integer right) {
    int _intValue = left.intValue();
    int _intValue_1 = right.intValue();
    boolean _greaterThan = (_intValue > _intValue_1);
    return _greaterThan;
  }
  
  protected Object _modulo(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'%\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _modulo(final Byte left, final Byte right) {
    byte _byteValue = left.byteValue();
    byte _byteValue_1 = right.byteValue();
    int _modulo = (_byteValue % _byteValue_1);
    return _modulo;
  }
  
  protected Object _modulo(final Byte left, final Double right) {
    byte _byteValue = left.byteValue();
    double _doubleValue = right.doubleValue();
    double _modulo = (_byteValue % _doubleValue);
    return _modulo;
  }
  
  protected Object _modulo(final Byte left, final Float right) {
    byte _byteValue = left.byteValue();
    float _floatValue = right.floatValue();
    float _modulo = (_byteValue % _floatValue);
    return _modulo;
  }
  
  protected Object _modulo(final Byte left, final Long right) {
    byte _byteValue = left.byteValue();
    long _longValue = right.longValue();
    long _modulo = (_byteValue % _longValue);
    return _modulo;
  }
  
  protected Object _modulo(final Byte left, final Short right) {
    byte _byteValue = left.byteValue();
    short _shortValue = right.shortValue();
    int _modulo = (_byteValue % _shortValue);
    return _modulo;
  }
  
  protected Object _modulo(final Byte left, final Integer right) {
    byte _byteValue = left.byteValue();
    int _intValue = right.intValue();
    int _modulo = (_byteValue % _intValue);
    return _modulo;
  }
  
  protected Object _modulo(final Double left, final Byte right) {
    double _doubleValue = left.doubleValue();
    byte _byteValue = right.byteValue();
    double _modulo = (_doubleValue % _byteValue);
    return _modulo;
  }
  
  protected Object _modulo(final Double left, final Double right) {
    double _doubleValue = left.doubleValue();
    double _doubleValue_1 = right.doubleValue();
    double _modulo = (_doubleValue % _doubleValue_1);
    return _modulo;
  }
  
  protected Object _modulo(final Double left, final Float right) {
    double _doubleValue = left.doubleValue();
    float _floatValue = right.floatValue();
    double _modulo = (_doubleValue % _floatValue);
    return _modulo;
  }
  
  protected Object _modulo(final Double left, final Long right) {
    double _doubleValue = left.doubleValue();
    long _longValue = right.longValue();
    double _modulo = (_doubleValue % _longValue);
    return _modulo;
  }
  
  protected Object _modulo(final Double left, final Short right) {
    double _doubleValue = left.doubleValue();
    short _shortValue = right.shortValue();
    double _modulo = (_doubleValue % _shortValue);
    return _modulo;
  }
  
  protected Object _modulo(final Double left, final Integer right) {
    double _doubleValue = left.doubleValue();
    int _intValue = right.intValue();
    double _modulo = (_doubleValue % _intValue);
    return _modulo;
  }
  
  protected Object _modulo(final Float left, final Byte right) {
    float _floatValue = left.floatValue();
    byte _byteValue = right.byteValue();
    float _modulo = (_floatValue % _byteValue);
    return _modulo;
  }
  
  protected Object _modulo(final Float left, final Double right) {
    float _floatValue = left.floatValue();
    double _doubleValue = right.doubleValue();
    double _modulo = (_floatValue % _doubleValue);
    return _modulo;
  }
  
  protected Object _modulo(final Float left, final Float right) {
    float _floatValue = left.floatValue();
    float _floatValue_1 = right.floatValue();
    float _modulo = (_floatValue % _floatValue_1);
    return _modulo;
  }
  
  protected Object _modulo(final Float left, final Long right) {
    float _floatValue = left.floatValue();
    long _longValue = right.longValue();
    float _modulo = (_floatValue % _longValue);
    return _modulo;
  }
  
  protected Object _modulo(final Float left, final Short right) {
    float _floatValue = left.floatValue();
    short _shortValue = right.shortValue();
    float _modulo = (_floatValue % _shortValue);
    return _modulo;
  }
  
  protected Object _modulo(final Float left, final Integer right) {
    float _floatValue = left.floatValue();
    int _intValue = right.intValue();
    float _modulo = (_floatValue % _intValue);
    return _modulo;
  }
  
  protected Object _modulo(final Long left, final Byte right) {
    long _longValue = left.longValue();
    byte _byteValue = right.byteValue();
    long _modulo = (_longValue % _byteValue);
    return _modulo;
  }
  
  protected Object _modulo(final Long left, final Double right) {
    long _longValue = left.longValue();
    double _doubleValue = right.doubleValue();
    double _modulo = (_longValue % _doubleValue);
    return _modulo;
  }
  
  protected Object _modulo(final Long left, final Float right) {
    long _longValue = left.longValue();
    float _floatValue = right.floatValue();
    float _modulo = (_longValue % _floatValue);
    return _modulo;
  }
  
  protected Object _modulo(final Long left, final Long right) {
    long _longValue = left.longValue();
    long _longValue_1 = right.longValue();
    long _modulo = (_longValue % _longValue_1);
    return _modulo;
  }
  
  protected Object _modulo(final Long left, final Short right) {
    long _longValue = left.longValue();
    short _shortValue = right.shortValue();
    long _modulo = (_longValue % _shortValue);
    return _modulo;
  }
  
  protected Object _modulo(final Long left, final Integer right) {
    long _longValue = left.longValue();
    int _intValue = right.intValue();
    long _modulo = (_longValue % _intValue);
    return _modulo;
  }
  
  protected Object _modulo(final Short left, final Byte right) {
    short _shortValue = left.shortValue();
    byte _byteValue = right.byteValue();
    int _modulo = (_shortValue % _byteValue);
    return _modulo;
  }
  
  protected Object _modulo(final Short left, final Double right) {
    short _shortValue = left.shortValue();
    double _doubleValue = right.doubleValue();
    double _modulo = (_shortValue % _doubleValue);
    return _modulo;
  }
  
  protected Object _modulo(final Short left, final Float right) {
    short _shortValue = left.shortValue();
    float _floatValue = right.floatValue();
    float _modulo = (_shortValue % _floatValue);
    return _modulo;
  }
  
  protected Object _modulo(final Short left, final Long right) {
    short _shortValue = left.shortValue();
    long _longValue = right.longValue();
    long _modulo = (_shortValue % _longValue);
    return _modulo;
  }
  
  protected Object _modulo(final Short left, final Short right) {
    short _shortValue = left.shortValue();
    short _shortValue_1 = right.shortValue();
    int _modulo = (_shortValue % _shortValue_1);
    return _modulo;
  }
  
  protected Object _modulo(final Short left, final Integer right) {
    short _shortValue = left.shortValue();
    int _intValue = right.intValue();
    int _modulo = (_shortValue % _intValue);
    return _modulo;
  }
  
  protected Object _modulo(final Integer left, final Byte right) {
    int _intValue = left.intValue();
    byte _byteValue = right.byteValue();
    int _modulo = (_intValue % _byteValue);
    return _modulo;
  }
  
  protected Object _modulo(final Integer left, final Double right) {
    int _intValue = left.intValue();
    double _doubleValue = right.doubleValue();
    double _modulo = (_intValue % _doubleValue);
    return _modulo;
  }
  
  protected Object _modulo(final Integer left, final Float right) {
    int _intValue = left.intValue();
    float _floatValue = right.floatValue();
    float _modulo = (_intValue % _floatValue);
    return _modulo;
  }
  
  protected Object _modulo(final Integer left, final Long right) {
    int _intValue = left.intValue();
    long _longValue = right.longValue();
    long _modulo = (_intValue % _longValue);
    return _modulo;
  }
  
  protected Object _modulo(final Integer left, final Short right) {
    int _intValue = left.intValue();
    short _shortValue = right.shortValue();
    int _modulo = (_intValue % _shortValue);
    return _modulo;
  }
  
  protected Object _modulo(final Integer left, final Integer right) {
    int _intValue = left.intValue();
    int _intValue_1 = right.intValue();
    int _modulo = (_intValue % _intValue_1);
    return _modulo;
  }
  
  protected Object _multiply(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'*\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _multiply(final Byte left, final Byte right) {
    byte _byteValue = left.byteValue();
    byte _byteValue_1 = right.byteValue();
    int _multiply = (_byteValue * _byteValue_1);
    return _multiply;
  }
  
  protected Object _multiply(final Byte left, final Double right) {
    byte _byteValue = left.byteValue();
    double _doubleValue = right.doubleValue();
    double _multiply = (_byteValue * _doubleValue);
    return _multiply;
  }
  
  protected Object _multiply(final Byte left, final Float right) {
    byte _byteValue = left.byteValue();
    float _floatValue = right.floatValue();
    float _multiply = (_byteValue * _floatValue);
    return _multiply;
  }
  
  protected Object _multiply(final Byte left, final Long right) {
    byte _byteValue = left.byteValue();
    long _longValue = right.longValue();
    long _multiply = (_byteValue * _longValue);
    return _multiply;
  }
  
  protected Object _multiply(final Byte left, final Short right) {
    byte _byteValue = left.byteValue();
    short _shortValue = right.shortValue();
    int _multiply = (_byteValue * _shortValue);
    return _multiply;
  }
  
  protected Object _multiply(final Byte left, final Integer right) {
    byte _byteValue = left.byteValue();
    int _intValue = right.intValue();
    int _multiply = (_byteValue * _intValue);
    return _multiply;
  }
  
  protected Object _multiply(final Double left, final Byte right) {
    double _doubleValue = left.doubleValue();
    byte _byteValue = right.byteValue();
    double _multiply = (_doubleValue * _byteValue);
    return _multiply;
  }
  
  protected Object _multiply(final Double left, final Double right) {
    double _doubleValue = left.doubleValue();
    double _doubleValue_1 = right.doubleValue();
    double _multiply = (_doubleValue * _doubleValue_1);
    return _multiply;
  }
  
  protected Object _multiply(final Double left, final Float right) {
    double _doubleValue = left.doubleValue();
    float _floatValue = right.floatValue();
    double _multiply = (_doubleValue * _floatValue);
    return _multiply;
  }
  
  protected Object _multiply(final Double left, final Long right) {
    double _doubleValue = left.doubleValue();
    long _longValue = right.longValue();
    double _multiply = (_doubleValue * _longValue);
    return _multiply;
  }
  
  protected Object _multiply(final Double left, final Short right) {
    double _doubleValue = left.doubleValue();
    short _shortValue = right.shortValue();
    double _multiply = (_doubleValue * _shortValue);
    return _multiply;
  }
  
  protected Object _multiply(final Double left, final Integer right) {
    double _doubleValue = left.doubleValue();
    int _intValue = right.intValue();
    double _multiply = (_doubleValue * _intValue);
    return _multiply;
  }
  
  protected Object _multiply(final Float left, final Byte right) {
    float _floatValue = left.floatValue();
    byte _byteValue = right.byteValue();
    float _multiply = (_floatValue * _byteValue);
    return _multiply;
  }
  
  protected Object _multiply(final Float left, final Double right) {
    float _floatValue = left.floatValue();
    double _doubleValue = right.doubleValue();
    double _multiply = (_floatValue * _doubleValue);
    return _multiply;
  }
  
  protected Object _multiply(final Float left, final Float right) {
    float _floatValue = left.floatValue();
    float _floatValue_1 = right.floatValue();
    float _multiply = (_floatValue * _floatValue_1);
    return _multiply;
  }
  
  protected Object _multiply(final Float left, final Long right) {
    float _floatValue = left.floatValue();
    long _longValue = right.longValue();
    float _multiply = (_floatValue * _longValue);
    return _multiply;
  }
  
  protected Object _multiply(final Float left, final Short right) {
    float _floatValue = left.floatValue();
    short _shortValue = right.shortValue();
    float _multiply = (_floatValue * _shortValue);
    return _multiply;
  }
  
  protected Object _multiply(final Float left, final Integer right) {
    float _floatValue = left.floatValue();
    int _intValue = right.intValue();
    float _multiply = (_floatValue * _intValue);
    return _multiply;
  }
  
  protected Object _multiply(final Long left, final Byte right) {
    long _longValue = left.longValue();
    byte _byteValue = right.byteValue();
    long _multiply = (_longValue * _byteValue);
    return _multiply;
  }
  
  protected Object _multiply(final Long left, final Double right) {
    long _longValue = left.longValue();
    double _doubleValue = right.doubleValue();
    double _multiply = (_longValue * _doubleValue);
    return _multiply;
  }
  
  protected Object _multiply(final Long left, final Float right) {
    long _longValue = left.longValue();
    float _floatValue = right.floatValue();
    float _multiply = (_longValue * _floatValue);
    return _multiply;
  }
  
  protected Object _multiply(final Long left, final Long right) {
    long _longValue = left.longValue();
    long _longValue_1 = right.longValue();
    long _multiply = (_longValue * _longValue_1);
    return _multiply;
  }
  
  protected Object _multiply(final Long left, final Short right) {
    long _longValue = left.longValue();
    short _shortValue = right.shortValue();
    long _multiply = (_longValue * _shortValue);
    return _multiply;
  }
  
  protected Object _multiply(final Long left, final Integer right) {
    long _longValue = left.longValue();
    int _intValue = right.intValue();
    long _multiply = (_longValue * _intValue);
    return _multiply;
  }
  
  protected Object _multiply(final Short left, final Byte right) {
    short _shortValue = left.shortValue();
    byte _byteValue = right.byteValue();
    int _multiply = (_shortValue * _byteValue);
    return _multiply;
  }
  
  protected Object _multiply(final Short left, final Double right) {
    short _shortValue = left.shortValue();
    double _doubleValue = right.doubleValue();
    double _multiply = (_shortValue * _doubleValue);
    return _multiply;
  }
  
  protected Object _multiply(final Short left, final Float right) {
    short _shortValue = left.shortValue();
    float _floatValue = right.floatValue();
    float _multiply = (_shortValue * _floatValue);
    return _multiply;
  }
  
  protected Object _multiply(final Short left, final Long right) {
    short _shortValue = left.shortValue();
    long _longValue = right.longValue();
    long _multiply = (_shortValue * _longValue);
    return _multiply;
  }
  
  protected Object _multiply(final Short left, final Short right) {
    short _shortValue = left.shortValue();
    short _shortValue_1 = right.shortValue();
    int _multiply = (_shortValue * _shortValue_1);
    return _multiply;
  }
  
  protected Object _multiply(final Short left, final Integer right) {
    short _shortValue = left.shortValue();
    int _intValue = right.intValue();
    int _multiply = (_shortValue * _intValue);
    return _multiply;
  }
  
  protected Object _multiply(final Integer left, final Byte right) {
    int _intValue = left.intValue();
    byte _byteValue = right.byteValue();
    int _multiply = (_intValue * _byteValue);
    return _multiply;
  }
  
  protected Object _multiply(final Integer left, final Double right) {
    int _intValue = left.intValue();
    double _doubleValue = right.doubleValue();
    double _multiply = (_intValue * _doubleValue);
    return _multiply;
  }
  
  protected Object _multiply(final Integer left, final Float right) {
    int _intValue = left.intValue();
    float _floatValue = right.floatValue();
    float _multiply = (_intValue * _floatValue);
    return _multiply;
  }
  
  protected Object _multiply(final Integer left, final Long right) {
    int _intValue = left.intValue();
    long _longValue = right.longValue();
    long _multiply = (_intValue * _longValue);
    return _multiply;
  }
  
  protected Object _multiply(final Integer left, final Short right) {
    int _intValue = left.intValue();
    short _shortValue = right.shortValue();
    int _multiply = (_intValue * _shortValue);
    return _multiply;
  }
  
  protected Object _multiply(final Integer left, final Integer right) {
    int _intValue = left.intValue();
    int _intValue_1 = right.intValue();
    int _multiply = (_intValue * _intValue_1);
    return _multiply;
  }
  
  protected Object _divide(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'/\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _divide(final Byte left, final Byte right) {
    byte _byteValue = left.byteValue();
    byte _byteValue_1 = right.byteValue();
    int _divide = (_byteValue / _byteValue_1);
    return _divide;
  }
  
  protected Object _divide(final Byte left, final Double right) {
    byte _byteValue = left.byteValue();
    double _doubleValue = right.doubleValue();
    double _divide = (_byteValue / _doubleValue);
    return _divide;
  }
  
  protected Object _divide(final Byte left, final Float right) {
    byte _byteValue = left.byteValue();
    float _floatValue = right.floatValue();
    float _divide = (_byteValue / _floatValue);
    return _divide;
  }
  
  protected Object _divide(final Byte left, final Long right) {
    byte _byteValue = left.byteValue();
    long _longValue = right.longValue();
    long _divide = (_byteValue / _longValue);
    return _divide;
  }
  
  protected Object _divide(final Byte left, final Short right) {
    byte _byteValue = left.byteValue();
    short _shortValue = right.shortValue();
    int _divide = (_byteValue / _shortValue);
    return _divide;
  }
  
  protected Object _divide(final Byte left, final Integer right) {
    byte _byteValue = left.byteValue();
    int _intValue = right.intValue();
    int _divide = (_byteValue / _intValue);
    return _divide;
  }
  
  protected Object _divide(final Double left, final Byte right) {
    double _doubleValue = left.doubleValue();
    byte _byteValue = right.byteValue();
    double _divide = (_doubleValue / _byteValue);
    return _divide;
  }
  
  protected Object _divide(final Double left, final Double right) {
    double _doubleValue = left.doubleValue();
    double _doubleValue_1 = right.doubleValue();
    double _divide = (_doubleValue / _doubleValue_1);
    return _divide;
  }
  
  protected Object _divide(final Double left, final Float right) {
    double _doubleValue = left.doubleValue();
    float _floatValue = right.floatValue();
    double _divide = (_doubleValue / _floatValue);
    return _divide;
  }
  
  protected Object _divide(final Double left, final Long right) {
    double _doubleValue = left.doubleValue();
    long _longValue = right.longValue();
    double _divide = (_doubleValue / _longValue);
    return _divide;
  }
  
  protected Object _divide(final Double left, final Short right) {
    double _doubleValue = left.doubleValue();
    short _shortValue = right.shortValue();
    double _divide = (_doubleValue / _shortValue);
    return _divide;
  }
  
  protected Object _divide(final Double left, final Integer right) {
    double _doubleValue = left.doubleValue();
    int _intValue = right.intValue();
    double _divide = (_doubleValue / _intValue);
    return _divide;
  }
  
  protected Object _divide(final Float left, final Byte right) {
    float _floatValue = left.floatValue();
    byte _byteValue = right.byteValue();
    float _divide = (_floatValue / _byteValue);
    return _divide;
  }
  
  protected Object _divide(final Float left, final Double right) {
    float _floatValue = left.floatValue();
    double _doubleValue = right.doubleValue();
    double _divide = (_floatValue / _doubleValue);
    return _divide;
  }
  
  protected Object _divide(final Float left, final Float right) {
    float _floatValue = left.floatValue();
    float _floatValue_1 = right.floatValue();
    float _divide = (_floatValue / _floatValue_1);
    return _divide;
  }
  
  protected Object _divide(final Float left, final Long right) {
    float _floatValue = left.floatValue();
    long _longValue = right.longValue();
    float _divide = (_floatValue / _longValue);
    return _divide;
  }
  
  protected Object _divide(final Float left, final Short right) {
    float _floatValue = left.floatValue();
    short _shortValue = right.shortValue();
    float _divide = (_floatValue / _shortValue);
    return _divide;
  }
  
  protected Object _divide(final Float left, final Integer right) {
    float _floatValue = left.floatValue();
    int _intValue = right.intValue();
    float _divide = (_floatValue / _intValue);
    return _divide;
  }
  
  protected Object _divide(final Long left, final Byte right) {
    long _longValue = left.longValue();
    byte _byteValue = right.byteValue();
    long _divide = (_longValue / _byteValue);
    return _divide;
  }
  
  protected Object _divide(final Long left, final Double right) {
    long _longValue = left.longValue();
    double _doubleValue = right.doubleValue();
    double _divide = (_longValue / _doubleValue);
    return _divide;
  }
  
  protected Object _divide(final Long left, final Float right) {
    long _longValue = left.longValue();
    float _floatValue = right.floatValue();
    float _divide = (_longValue / _floatValue);
    return _divide;
  }
  
  protected Object _divide(final Long left, final Long right) {
    long _longValue = left.longValue();
    long _longValue_1 = right.longValue();
    long _divide = (_longValue / _longValue_1);
    return _divide;
  }
  
  protected Object _divide(final Long left, final Short right) {
    long _longValue = left.longValue();
    short _shortValue = right.shortValue();
    long _divide = (_longValue / _shortValue);
    return _divide;
  }
  
  protected Object _divide(final Long left, final Integer right) {
    long _longValue = left.longValue();
    int _intValue = right.intValue();
    long _divide = (_longValue / _intValue);
    return _divide;
  }
  
  protected Object _divide(final Short left, final Byte right) {
    short _shortValue = left.shortValue();
    byte _byteValue = right.byteValue();
    int _divide = (_shortValue / _byteValue);
    return _divide;
  }
  
  protected Object _divide(final Short left, final Double right) {
    short _shortValue = left.shortValue();
    double _doubleValue = right.doubleValue();
    double _divide = (_shortValue / _doubleValue);
    return _divide;
  }
  
  protected Object _divide(final Short left, final Float right) {
    short _shortValue = left.shortValue();
    float _floatValue = right.floatValue();
    float _divide = (_shortValue / _floatValue);
    return _divide;
  }
  
  protected Object _divide(final Short left, final Long right) {
    short _shortValue = left.shortValue();
    long _longValue = right.longValue();
    long _divide = (_shortValue / _longValue);
    return _divide;
  }
  
  protected Object _divide(final Short left, final Short right) {
    short _shortValue = left.shortValue();
    short _shortValue_1 = right.shortValue();
    int _divide = (_shortValue / _shortValue_1);
    return _divide;
  }
  
  protected Object _divide(final Short left, final Integer right) {
    short _shortValue = left.shortValue();
    int _intValue = right.intValue();
    int _divide = (_shortValue / _intValue);
    return _divide;
  }
  
  protected Object _divide(final Integer left, final Byte right) {
    int _intValue = left.intValue();
    byte _byteValue = right.byteValue();
    int _divide = (_intValue / _byteValue);
    return _divide;
  }
  
  protected Object _divide(final Integer left, final Double right) {
    int _intValue = left.intValue();
    double _doubleValue = right.doubleValue();
    double _divide = (_intValue / _doubleValue);
    return _divide;
  }
  
  protected Object _divide(final Integer left, final Float right) {
    int _intValue = left.intValue();
    float _floatValue = right.floatValue();
    float _divide = (_intValue / _floatValue);
    return _divide;
  }
  
  protected Object _divide(final Integer left, final Long right) {
    int _intValue = left.intValue();
    long _longValue = right.longValue();
    long _divide = (_intValue / _longValue);
    return _divide;
  }
  
  protected Object _divide(final Integer left, final Short right) {
    int _intValue = left.intValue();
    short _shortValue = right.shortValue();
    int _divide = (_intValue / _shortValue);
    return _divide;
  }
  
  protected Object _divide(final Integer left, final Integer right) {
    int _intValue = left.intValue();
    int _intValue_1 = right.intValue();
    int _divide = (_intValue / _intValue_1);
    return _divide;
  }
  
  protected boolean _same(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'===\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected boolean _same(final Byte left, final Byte right) {
    byte _byteValue = left.byteValue();
    byte _byteValue_1 = right.byteValue();
    boolean _tripleEquals = (_byteValue == _byteValue_1);
    return _tripleEquals;
  }
  
  protected boolean _same(final Byte left, final Double right) {
    byte _byteValue = left.byteValue();
    double _doubleValue = right.doubleValue();
    boolean _tripleEquals = (_byteValue == _doubleValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Byte left, final Float right) {
    byte _byteValue = left.byteValue();
    float _floatValue = right.floatValue();
    boolean _tripleEquals = (_byteValue == _floatValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Byte left, final Long right) {
    byte _byteValue = left.byteValue();
    long _longValue = right.longValue();
    boolean _tripleEquals = (_byteValue == _longValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Byte left, final Short right) {
    byte _byteValue = left.byteValue();
    short _shortValue = right.shortValue();
    boolean _tripleEquals = (_byteValue == _shortValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Byte left, final Integer right) {
    byte _byteValue = left.byteValue();
    int _intValue = right.intValue();
    boolean _tripleEquals = (_byteValue == _intValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Double left, final Byte right) {
    double _doubleValue = left.doubleValue();
    byte _byteValue = right.byteValue();
    boolean _tripleEquals = (_doubleValue == _byteValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Double left, final Double right) {
    double _doubleValue = left.doubleValue();
    double _doubleValue_1 = right.doubleValue();
    boolean _tripleEquals = (_doubleValue == _doubleValue_1);
    return _tripleEquals;
  }
  
  protected boolean _same(final Double left, final Float right) {
    double _doubleValue = left.doubleValue();
    float _floatValue = right.floatValue();
    boolean _tripleEquals = (_doubleValue == _floatValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Double left, final Long right) {
    double _doubleValue = left.doubleValue();
    long _longValue = right.longValue();
    boolean _tripleEquals = (_doubleValue == _longValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Double left, final Short right) {
    double _doubleValue = left.doubleValue();
    short _shortValue = right.shortValue();
    boolean _tripleEquals = (_doubleValue == _shortValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Double left, final Integer right) {
    double _doubleValue = left.doubleValue();
    int _intValue = right.intValue();
    boolean _tripleEquals = (_doubleValue == _intValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Float left, final Byte right) {
    float _floatValue = left.floatValue();
    byte _byteValue = right.byteValue();
    boolean _tripleEquals = (_floatValue == _byteValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Float left, final Double right) {
    float _floatValue = left.floatValue();
    double _doubleValue = right.doubleValue();
    boolean _tripleEquals = (_floatValue == _doubleValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Float left, final Float right) {
    float _floatValue = left.floatValue();
    float _floatValue_1 = right.floatValue();
    boolean _tripleEquals = (_floatValue == _floatValue_1);
    return _tripleEquals;
  }
  
  protected boolean _same(final Float left, final Long right) {
    float _floatValue = left.floatValue();
    long _longValue = right.longValue();
    boolean _tripleEquals = (_floatValue == _longValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Float left, final Short right) {
    float _floatValue = left.floatValue();
    short _shortValue = right.shortValue();
    boolean _tripleEquals = (_floatValue == _shortValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Float left, final Integer right) {
    float _floatValue = left.floatValue();
    int _intValue = right.intValue();
    boolean _tripleEquals = (_floatValue == _intValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Long left, final Byte right) {
    long _longValue = left.longValue();
    byte _byteValue = right.byteValue();
    boolean _tripleEquals = (_longValue == _byteValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Long left, final Double right) {
    long _longValue = left.longValue();
    double _doubleValue = right.doubleValue();
    boolean _tripleEquals = (_longValue == _doubleValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Long left, final Float right) {
    long _longValue = left.longValue();
    float _floatValue = right.floatValue();
    boolean _tripleEquals = (_longValue == _floatValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Long left, final Long right) {
    long _longValue = left.longValue();
    long _longValue_1 = right.longValue();
    boolean _tripleEquals = (_longValue == _longValue_1);
    return _tripleEquals;
  }
  
  protected boolean _same(final Long left, final Short right) {
    long _longValue = left.longValue();
    short _shortValue = right.shortValue();
    boolean _tripleEquals = (_longValue == _shortValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Long left, final Integer right) {
    long _longValue = left.longValue();
    int _intValue = right.intValue();
    boolean _tripleEquals = (_longValue == _intValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Short left, final Byte right) {
    short _shortValue = left.shortValue();
    byte _byteValue = right.byteValue();
    boolean _tripleEquals = (_shortValue == _byteValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Short left, final Double right) {
    short _shortValue = left.shortValue();
    double _doubleValue = right.doubleValue();
    boolean _tripleEquals = (_shortValue == _doubleValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Short left, final Float right) {
    short _shortValue = left.shortValue();
    float _floatValue = right.floatValue();
    boolean _tripleEquals = (_shortValue == _floatValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Short left, final Long right) {
    short _shortValue = left.shortValue();
    long _longValue = right.longValue();
    boolean _tripleEquals = (_shortValue == _longValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Short left, final Short right) {
    short _shortValue = left.shortValue();
    short _shortValue_1 = right.shortValue();
    boolean _tripleEquals = (_shortValue == _shortValue_1);
    return _tripleEquals;
  }
  
  protected boolean _same(final Short left, final Integer right) {
    short _shortValue = left.shortValue();
    int _intValue = right.intValue();
    boolean _tripleEquals = (_shortValue == _intValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Integer left, final Byte right) {
    int _intValue = left.intValue();
    byte _byteValue = right.byteValue();
    boolean _tripleEquals = (_intValue == _byteValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Integer left, final Double right) {
    int _intValue = left.intValue();
    double _doubleValue = right.doubleValue();
    boolean _tripleEquals = (_intValue == _doubleValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Integer left, final Float right) {
    int _intValue = left.intValue();
    float _floatValue = right.floatValue();
    boolean _tripleEquals = (_intValue == _floatValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Integer left, final Long right) {
    int _intValue = left.intValue();
    long _longValue = right.longValue();
    boolean _tripleEquals = (_intValue == _longValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Integer left, final Short right) {
    int _intValue = left.intValue();
    short _shortValue = right.shortValue();
    boolean _tripleEquals = (_intValue == _shortValue);
    return _tripleEquals;
  }
  
  protected boolean _same(final Integer left, final Integer right) {
    int _intValue = left.intValue();
    int _intValue_1 = right.intValue();
    boolean _tripleEquals = (_intValue == _intValue_1);
    return _tripleEquals;
  }
  
  protected boolean _lessEquals(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'<=\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected boolean _lessEquals(final Byte left, final Byte right) {
    byte _byteValue = left.byteValue();
    byte _byteValue_1 = right.byteValue();
    boolean _lessEqualsThan = (_byteValue <= _byteValue_1);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Byte left, final Double right) {
    byte _byteValue = left.byteValue();
    double _doubleValue = right.doubleValue();
    boolean _lessEqualsThan = (_byteValue <= _doubleValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Byte left, final Float right) {
    byte _byteValue = left.byteValue();
    float _floatValue = right.floatValue();
    boolean _lessEqualsThan = (_byteValue <= _floatValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Byte left, final Long right) {
    byte _byteValue = left.byteValue();
    long _longValue = right.longValue();
    boolean _lessEqualsThan = (_byteValue <= _longValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Byte left, final Short right) {
    byte _byteValue = left.byteValue();
    short _shortValue = right.shortValue();
    boolean _lessEqualsThan = (_byteValue <= _shortValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Byte left, final Integer right) {
    byte _byteValue = left.byteValue();
    int _intValue = right.intValue();
    boolean _lessEqualsThan = (_byteValue <= _intValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Double left, final Byte right) {
    double _doubleValue = left.doubleValue();
    byte _byteValue = right.byteValue();
    boolean _lessEqualsThan = (_doubleValue <= _byteValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Double left, final Double right) {
    double _doubleValue = left.doubleValue();
    double _doubleValue_1 = right.doubleValue();
    boolean _lessEqualsThan = (_doubleValue <= _doubleValue_1);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Double left, final Float right) {
    double _doubleValue = left.doubleValue();
    float _floatValue = right.floatValue();
    boolean _lessEqualsThan = (_doubleValue <= _floatValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Double left, final Long right) {
    double _doubleValue = left.doubleValue();
    long _longValue = right.longValue();
    boolean _lessEqualsThan = (_doubleValue <= _longValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Double left, final Short right) {
    double _doubleValue = left.doubleValue();
    short _shortValue = right.shortValue();
    boolean _lessEqualsThan = (_doubleValue <= _shortValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Double left, final Integer right) {
    double _doubleValue = left.doubleValue();
    int _intValue = right.intValue();
    boolean _lessEqualsThan = (_doubleValue <= _intValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Float left, final Byte right) {
    float _floatValue = left.floatValue();
    byte _byteValue = right.byteValue();
    boolean _lessEqualsThan = (_floatValue <= _byteValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Float left, final Double right) {
    float _floatValue = left.floatValue();
    double _doubleValue = right.doubleValue();
    boolean _lessEqualsThan = (_floatValue <= _doubleValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Float left, final Float right) {
    float _floatValue = left.floatValue();
    float _floatValue_1 = right.floatValue();
    boolean _lessEqualsThan = (_floatValue <= _floatValue_1);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Float left, final Long right) {
    float _floatValue = left.floatValue();
    long _longValue = right.longValue();
    boolean _lessEqualsThan = (_floatValue <= _longValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Float left, final Short right) {
    float _floatValue = left.floatValue();
    short _shortValue = right.shortValue();
    boolean _lessEqualsThan = (_floatValue <= _shortValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Float left, final Integer right) {
    float _floatValue = left.floatValue();
    int _intValue = right.intValue();
    boolean _lessEqualsThan = (_floatValue <= _intValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Long left, final Byte right) {
    long _longValue = left.longValue();
    byte _byteValue = right.byteValue();
    boolean _lessEqualsThan = (_longValue <= _byteValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Long left, final Double right) {
    long _longValue = left.longValue();
    double _doubleValue = right.doubleValue();
    boolean _lessEqualsThan = (_longValue <= _doubleValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Long left, final Float right) {
    long _longValue = left.longValue();
    float _floatValue = right.floatValue();
    boolean _lessEqualsThan = (_longValue <= _floatValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Long left, final Long right) {
    long _longValue = left.longValue();
    long _longValue_1 = right.longValue();
    boolean _lessEqualsThan = (_longValue <= _longValue_1);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Long left, final Short right) {
    long _longValue = left.longValue();
    short _shortValue = right.shortValue();
    boolean _lessEqualsThan = (_longValue <= _shortValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Long left, final Integer right) {
    long _longValue = left.longValue();
    int _intValue = right.intValue();
    boolean _lessEqualsThan = (_longValue <= _intValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Short left, final Byte right) {
    short _shortValue = left.shortValue();
    byte _byteValue = right.byteValue();
    boolean _lessEqualsThan = (_shortValue <= _byteValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Short left, final Double right) {
    short _shortValue = left.shortValue();
    double _doubleValue = right.doubleValue();
    boolean _lessEqualsThan = (_shortValue <= _doubleValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Short left, final Float right) {
    short _shortValue = left.shortValue();
    float _floatValue = right.floatValue();
    boolean _lessEqualsThan = (_shortValue <= _floatValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Short left, final Long right) {
    short _shortValue = left.shortValue();
    long _longValue = right.longValue();
    boolean _lessEqualsThan = (_shortValue <= _longValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Short left, final Short right) {
    short _shortValue = left.shortValue();
    short _shortValue_1 = right.shortValue();
    boolean _lessEqualsThan = (_shortValue <= _shortValue_1);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Short left, final Integer right) {
    short _shortValue = left.shortValue();
    int _intValue = right.intValue();
    boolean _lessEqualsThan = (_shortValue <= _intValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Integer left, final Byte right) {
    int _intValue = left.intValue();
    byte _byteValue = right.byteValue();
    boolean _lessEqualsThan = (_intValue <= _byteValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Integer left, final Double right) {
    int _intValue = left.intValue();
    double _doubleValue = right.doubleValue();
    boolean _lessEqualsThan = (_intValue <= _doubleValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Integer left, final Float right) {
    int _intValue = left.intValue();
    float _floatValue = right.floatValue();
    boolean _lessEqualsThan = (_intValue <= _floatValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Integer left, final Long right) {
    int _intValue = left.intValue();
    long _longValue = right.longValue();
    boolean _lessEqualsThan = (_intValue <= _longValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Integer left, final Short right) {
    int _intValue = left.intValue();
    short _shortValue = right.shortValue();
    boolean _lessEqualsThan = (_intValue <= _shortValue);
    return _lessEqualsThan;
  }
  
  protected boolean _lessEquals(final Integer left, final Integer right) {
    int _intValue = left.intValue();
    int _intValue_1 = right.intValue();
    boolean _lessEqualsThan = (_intValue <= _intValue_1);
    return _lessEqualsThan;
  }
  
  protected boolean _greaterEquals(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'>=\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected boolean _greaterEquals(final Byte left, final Byte right) {
    byte _byteValue = left.byteValue();
    byte _byteValue_1 = right.byteValue();
    boolean _greaterEqualsThan = (_byteValue >= _byteValue_1);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Byte left, final Double right) {
    byte _byteValue = left.byteValue();
    double _doubleValue = right.doubleValue();
    boolean _greaterEqualsThan = (_byteValue >= _doubleValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Byte left, final Float right) {
    byte _byteValue = left.byteValue();
    float _floatValue = right.floatValue();
    boolean _greaterEqualsThan = (_byteValue >= _floatValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Byte left, final Long right) {
    byte _byteValue = left.byteValue();
    long _longValue = right.longValue();
    boolean _greaterEqualsThan = (_byteValue >= _longValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Byte left, final Short right) {
    byte _byteValue = left.byteValue();
    short _shortValue = right.shortValue();
    boolean _greaterEqualsThan = (_byteValue >= _shortValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Byte left, final Integer right) {
    byte _byteValue = left.byteValue();
    int _intValue = right.intValue();
    boolean _greaterEqualsThan = (_byteValue >= _intValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Double left, final Byte right) {
    double _doubleValue = left.doubleValue();
    byte _byteValue = right.byteValue();
    boolean _greaterEqualsThan = (_doubleValue >= _byteValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Double left, final Double right) {
    double _doubleValue = left.doubleValue();
    double _doubleValue_1 = right.doubleValue();
    boolean _greaterEqualsThan = (_doubleValue >= _doubleValue_1);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Double left, final Float right) {
    double _doubleValue = left.doubleValue();
    float _floatValue = right.floatValue();
    boolean _greaterEqualsThan = (_doubleValue >= _floatValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Double left, final Long right) {
    double _doubleValue = left.doubleValue();
    long _longValue = right.longValue();
    boolean _greaterEqualsThan = (_doubleValue >= _longValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Double left, final Short right) {
    double _doubleValue = left.doubleValue();
    short _shortValue = right.shortValue();
    boolean _greaterEqualsThan = (_doubleValue >= _shortValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Double left, final Integer right) {
    double _doubleValue = left.doubleValue();
    int _intValue = right.intValue();
    boolean _greaterEqualsThan = (_doubleValue >= _intValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Float left, final Byte right) {
    float _floatValue = left.floatValue();
    byte _byteValue = right.byteValue();
    boolean _greaterEqualsThan = (_floatValue >= _byteValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Float left, final Double right) {
    float _floatValue = left.floatValue();
    double _doubleValue = right.doubleValue();
    boolean _greaterEqualsThan = (_floatValue >= _doubleValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Float left, final Float right) {
    float _floatValue = left.floatValue();
    float _floatValue_1 = right.floatValue();
    boolean _greaterEqualsThan = (_floatValue >= _floatValue_1);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Float left, final Long right) {
    float _floatValue = left.floatValue();
    long _longValue = right.longValue();
    boolean _greaterEqualsThan = (_floatValue >= _longValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Float left, final Short right) {
    float _floatValue = left.floatValue();
    short _shortValue = right.shortValue();
    boolean _greaterEqualsThan = (_floatValue >= _shortValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Float left, final Integer right) {
    float _floatValue = left.floatValue();
    int _intValue = right.intValue();
    boolean _greaterEqualsThan = (_floatValue >= _intValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Long left, final Byte right) {
    long _longValue = left.longValue();
    byte _byteValue = right.byteValue();
    boolean _greaterEqualsThan = (_longValue >= _byteValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Long left, final Double right) {
    long _longValue = left.longValue();
    double _doubleValue = right.doubleValue();
    boolean _greaterEqualsThan = (_longValue >= _doubleValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Long left, final Float right) {
    long _longValue = left.longValue();
    float _floatValue = right.floatValue();
    boolean _greaterEqualsThan = (_longValue >= _floatValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Long left, final Long right) {
    long _longValue = left.longValue();
    long _longValue_1 = right.longValue();
    boolean _greaterEqualsThan = (_longValue >= _longValue_1);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Long left, final Short right) {
    long _longValue = left.longValue();
    short _shortValue = right.shortValue();
    boolean _greaterEqualsThan = (_longValue >= _shortValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Long left, final Integer right) {
    long _longValue = left.longValue();
    int _intValue = right.intValue();
    boolean _greaterEqualsThan = (_longValue >= _intValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Short left, final Byte right) {
    short _shortValue = left.shortValue();
    byte _byteValue = right.byteValue();
    boolean _greaterEqualsThan = (_shortValue >= _byteValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Short left, final Double right) {
    short _shortValue = left.shortValue();
    double _doubleValue = right.doubleValue();
    boolean _greaterEqualsThan = (_shortValue >= _doubleValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Short left, final Float right) {
    short _shortValue = left.shortValue();
    float _floatValue = right.floatValue();
    boolean _greaterEqualsThan = (_shortValue >= _floatValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Short left, final Long right) {
    short _shortValue = left.shortValue();
    long _longValue = right.longValue();
    boolean _greaterEqualsThan = (_shortValue >= _longValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Short left, final Short right) {
    short _shortValue = left.shortValue();
    short _shortValue_1 = right.shortValue();
    boolean _greaterEqualsThan = (_shortValue >= _shortValue_1);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Short left, final Integer right) {
    short _shortValue = left.shortValue();
    int _intValue = right.intValue();
    boolean _greaterEqualsThan = (_shortValue >= _intValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Integer left, final Byte right) {
    int _intValue = left.intValue();
    byte _byteValue = right.byteValue();
    boolean _greaterEqualsThan = (_intValue >= _byteValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Integer left, final Double right) {
    int _intValue = left.intValue();
    double _doubleValue = right.doubleValue();
    boolean _greaterEqualsThan = (_intValue >= _doubleValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Integer left, final Float right) {
    int _intValue = left.intValue();
    float _floatValue = right.floatValue();
    boolean _greaterEqualsThan = (_intValue >= _floatValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Integer left, final Long right) {
    int _intValue = left.intValue();
    long _longValue = right.longValue();
    boolean _greaterEqualsThan = (_intValue >= _longValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Integer left, final Short right) {
    int _intValue = left.intValue();
    short _shortValue = right.shortValue();
    boolean _greaterEqualsThan = (_intValue >= _shortValue);
    return _greaterEqualsThan;
  }
  
  protected boolean _greaterEquals(final Integer left, final Integer right) {
    int _intValue = left.intValue();
    int _intValue_1 = right.intValue();
    boolean _greaterEqualsThan = (_intValue >= _intValue_1);
    return _greaterEqualsThan;
  }
  
  protected boolean _notSame(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'!==\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected boolean _notSame(final Byte left, final Byte right) {
    byte _byteValue = left.byteValue();
    byte _byteValue_1 = right.byteValue();
    boolean _tripleNotEquals = (_byteValue != _byteValue_1);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Byte left, final Double right) {
    byte _byteValue = left.byteValue();
    double _doubleValue = right.doubleValue();
    boolean _tripleNotEquals = (_byteValue != _doubleValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Byte left, final Float right) {
    byte _byteValue = left.byteValue();
    float _floatValue = right.floatValue();
    boolean _tripleNotEquals = (_byteValue != _floatValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Byte left, final Long right) {
    byte _byteValue = left.byteValue();
    long _longValue = right.longValue();
    boolean _tripleNotEquals = (_byteValue != _longValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Byte left, final Short right) {
    byte _byteValue = left.byteValue();
    short _shortValue = right.shortValue();
    boolean _tripleNotEquals = (_byteValue != _shortValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Byte left, final Integer right) {
    byte _byteValue = left.byteValue();
    int _intValue = right.intValue();
    boolean _tripleNotEquals = (_byteValue != _intValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Double left, final Byte right) {
    double _doubleValue = left.doubleValue();
    byte _byteValue = right.byteValue();
    boolean _tripleNotEquals = (_doubleValue != _byteValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Double left, final Double right) {
    double _doubleValue = left.doubleValue();
    double _doubleValue_1 = right.doubleValue();
    boolean _tripleNotEquals = (_doubleValue != _doubleValue_1);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Double left, final Float right) {
    double _doubleValue = left.doubleValue();
    float _floatValue = right.floatValue();
    boolean _tripleNotEquals = (_doubleValue != _floatValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Double left, final Long right) {
    double _doubleValue = left.doubleValue();
    long _longValue = right.longValue();
    boolean _tripleNotEquals = (_doubleValue != _longValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Double left, final Short right) {
    double _doubleValue = left.doubleValue();
    short _shortValue = right.shortValue();
    boolean _tripleNotEquals = (_doubleValue != _shortValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Double left, final Integer right) {
    double _doubleValue = left.doubleValue();
    int _intValue = right.intValue();
    boolean _tripleNotEquals = (_doubleValue != _intValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Float left, final Byte right) {
    float _floatValue = left.floatValue();
    byte _byteValue = right.byteValue();
    boolean _tripleNotEquals = (_floatValue != _byteValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Float left, final Double right) {
    float _floatValue = left.floatValue();
    double _doubleValue = right.doubleValue();
    boolean _tripleNotEquals = (_floatValue != _doubleValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Float left, final Float right) {
    float _floatValue = left.floatValue();
    float _floatValue_1 = right.floatValue();
    boolean _tripleNotEquals = (_floatValue != _floatValue_1);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Float left, final Long right) {
    float _floatValue = left.floatValue();
    long _longValue = right.longValue();
    boolean _tripleNotEquals = (_floatValue != _longValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Float left, final Short right) {
    float _floatValue = left.floatValue();
    short _shortValue = right.shortValue();
    boolean _tripleNotEquals = (_floatValue != _shortValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Float left, final Integer right) {
    float _floatValue = left.floatValue();
    int _intValue = right.intValue();
    boolean _tripleNotEquals = (_floatValue != _intValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Long left, final Byte right) {
    long _longValue = left.longValue();
    byte _byteValue = right.byteValue();
    boolean _tripleNotEquals = (_longValue != _byteValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Long left, final Double right) {
    long _longValue = left.longValue();
    double _doubleValue = right.doubleValue();
    boolean _tripleNotEquals = (_longValue != _doubleValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Long left, final Float right) {
    long _longValue = left.longValue();
    float _floatValue = right.floatValue();
    boolean _tripleNotEquals = (_longValue != _floatValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Long left, final Long right) {
    long _longValue = left.longValue();
    long _longValue_1 = right.longValue();
    boolean _tripleNotEquals = (_longValue != _longValue_1);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Long left, final Short right) {
    long _longValue = left.longValue();
    short _shortValue = right.shortValue();
    boolean _tripleNotEquals = (_longValue != _shortValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Long left, final Integer right) {
    long _longValue = left.longValue();
    int _intValue = right.intValue();
    boolean _tripleNotEquals = (_longValue != _intValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Short left, final Byte right) {
    short _shortValue = left.shortValue();
    byte _byteValue = right.byteValue();
    boolean _tripleNotEquals = (_shortValue != _byteValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Short left, final Double right) {
    short _shortValue = left.shortValue();
    double _doubleValue = right.doubleValue();
    boolean _tripleNotEquals = (_shortValue != _doubleValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Short left, final Float right) {
    short _shortValue = left.shortValue();
    float _floatValue = right.floatValue();
    boolean _tripleNotEquals = (_shortValue != _floatValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Short left, final Long right) {
    short _shortValue = left.shortValue();
    long _longValue = right.longValue();
    boolean _tripleNotEquals = (_shortValue != _longValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Short left, final Short right) {
    short _shortValue = left.shortValue();
    short _shortValue_1 = right.shortValue();
    boolean _tripleNotEquals = (_shortValue != _shortValue_1);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Short left, final Integer right) {
    short _shortValue = left.shortValue();
    int _intValue = right.intValue();
    boolean _tripleNotEquals = (_shortValue != _intValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Integer left, final Byte right) {
    int _intValue = left.intValue();
    byte _byteValue = right.byteValue();
    boolean _tripleNotEquals = (_intValue != _byteValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Integer left, final Double right) {
    int _intValue = left.intValue();
    double _doubleValue = right.doubleValue();
    boolean _tripleNotEquals = (_intValue != _doubleValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Integer left, final Float right) {
    int _intValue = left.intValue();
    float _floatValue = right.floatValue();
    boolean _tripleNotEquals = (_intValue != _floatValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Integer left, final Long right) {
    int _intValue = left.intValue();
    long _longValue = right.longValue();
    boolean _tripleNotEquals = (_intValue != _longValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Integer left, final Short right) {
    int _intValue = left.intValue();
    short _shortValue = right.shortValue();
    boolean _tripleNotEquals = (_intValue != _shortValue);
    return _tripleNotEquals;
  }
  
  protected boolean _notSame(final Integer left, final Integer right) {
    int _intValue = left.intValue();
    int _intValue_1 = right.intValue();
    boolean _tripleNotEquals = (_intValue != _intValue_1);
    return _tripleNotEquals;
  }
  
  public Object minus(final Object e) {
    if (e instanceof Byte) {
      return _minus((Byte)e);
    } else if (e instanceof Double) {
      return _minus((Double)e);
    } else if (e instanceof Float) {
      return _minus((Float)e);
    } else if (e instanceof Integer) {
      return _minus((Integer)e);
    } else if (e instanceof Long) {
      return _minus((Long)e);
    } else if (e instanceof Short) {
      return _minus((Short)e);
    } else if (e != null) {
      return _minus(e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e).toString());
    }
  }
  
  public Object plus(final Object left, final Object right) {
    if (left instanceof Byte
         && right instanceof Byte) {
      return _plus((Byte)left, (Byte)right);
    } else if (left instanceof Byte
         && right instanceof Double) {
      return _plus((Byte)left, (Double)right);
    } else if (left instanceof Byte
         && right instanceof Float) {
      return _plus((Byte)left, (Float)right);
    } else if (left instanceof Byte
         && right instanceof Integer) {
      return _plus((Byte)left, (Integer)right);
    } else if (left instanceof Byte
         && right instanceof Long) {
      return _plus((Byte)left, (Long)right);
    } else if (left instanceof Byte
         && right instanceof Short) {
      return _plus((Byte)left, (Short)right);
    } else if (left instanceof Double
         && right instanceof Byte) {
      return _plus((Double)left, (Byte)right);
    } else if (left instanceof Double
         && right instanceof Double) {
      return _plus((Double)left, (Double)right);
    } else if (left instanceof Double
         && right instanceof Float) {
      return _plus((Double)left, (Float)right);
    } else if (left instanceof Double
         && right instanceof Integer) {
      return _plus((Double)left, (Integer)right);
    } else if (left instanceof Double
         && right instanceof Long) {
      return _plus((Double)left, (Long)right);
    } else if (left instanceof Double
         && right instanceof Short) {
      return _plus((Double)left, (Short)right);
    } else if (left instanceof Float
         && right instanceof Byte) {
      return _plus((Float)left, (Byte)right);
    } else if (left instanceof Float
         && right instanceof Double) {
      return _plus((Float)left, (Double)right);
    } else if (left instanceof Float
         && right instanceof Float) {
      return _plus((Float)left, (Float)right);
    } else if (left instanceof Float
         && right instanceof Integer) {
      return _plus((Float)left, (Integer)right);
    } else if (left instanceof Float
         && right instanceof Long) {
      return _plus((Float)left, (Long)right);
    } else if (left instanceof Float
         && right instanceof Short) {
      return _plus((Float)left, (Short)right);
    } else if (left instanceof Integer
         && right instanceof Byte) {
      return _plus((Integer)left, (Byte)right);
    } else if (left instanceof Integer
         && right instanceof Double) {
      return _plus((Integer)left, (Double)right);
    } else if (left instanceof Integer
         && right instanceof Float) {
      return _plus((Integer)left, (Float)right);
    } else if (left instanceof Integer
         && right instanceof Integer) {
      return _plus((Integer)left, (Integer)right);
    } else if (left instanceof Integer
         && right instanceof Long) {
      return _plus((Integer)left, (Long)right);
    } else if (left instanceof Integer
         && right instanceof Short) {
      return _plus((Integer)left, (Short)right);
    } else if (left instanceof Long
         && right instanceof Byte) {
      return _plus((Long)left, (Byte)right);
    } else if (left instanceof Long
         && right instanceof Double) {
      return _plus((Long)left, (Double)right);
    } else if (left instanceof Long
         && right instanceof Float) {
      return _plus((Long)left, (Float)right);
    } else if (left instanceof Long
         && right instanceof Integer) {
      return _plus((Long)left, (Integer)right);
    } else if (left instanceof Long
         && right instanceof Long) {
      return _plus((Long)left, (Long)right);
    } else if (left instanceof Long
         && right instanceof Short) {
      return _plus((Long)left, (Short)right);
    } else if (left instanceof Short
         && right instanceof Byte) {
      return _plus((Short)left, (Byte)right);
    } else if (left instanceof Short
         && right instanceof Double) {
      return _plus((Short)left, (Double)right);
    } else if (left instanceof Short
         && right instanceof Float) {
      return _plus((Short)left, (Float)right);
    } else if (left instanceof Short
         && right instanceof Integer) {
      return _plus((Short)left, (Integer)right);
    } else if (left instanceof Short
         && right instanceof Long) {
      return _plus((Short)left, (Long)right);
    } else if (left instanceof Short
         && right instanceof Short) {
      return _plus((Short)left, (Short)right);
    } else if (left instanceof String
         && right != null) {
      return _plus((String)left, right);
    } else if (left != null
         && right != null) {
      return _plus(left, right);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right).toString());
    }
  }
  
  public boolean lessThan(final Object left, final Object right) {
    if (left instanceof Byte
         && right instanceof Byte) {
      return _lessThan((Byte)left, (Byte)right);
    } else if (left instanceof Byte
         && right instanceof Double) {
      return _lessThan((Byte)left, (Double)right);
    } else if (left instanceof Byte
         && right instanceof Float) {
      return _lessThan((Byte)left, (Float)right);
    } else if (left instanceof Byte
         && right instanceof Integer) {
      return _lessThan((Byte)left, (Integer)right);
    } else if (left instanceof Byte
         && right instanceof Long) {
      return _lessThan((Byte)left, (Long)right);
    } else if (left instanceof Byte
         && right instanceof Short) {
      return _lessThan((Byte)left, (Short)right);
    } else if (left instanceof Double
         && right instanceof Byte) {
      return _lessThan((Double)left, (Byte)right);
    } else if (left instanceof Double
         && right instanceof Double) {
      return _lessThan((Double)left, (Double)right);
    } else if (left instanceof Double
         && right instanceof Float) {
      return _lessThan((Double)left, (Float)right);
    } else if (left instanceof Double
         && right instanceof Integer) {
      return _lessThan((Double)left, (Integer)right);
    } else if (left instanceof Double
         && right instanceof Long) {
      return _lessThan((Double)left, (Long)right);
    } else if (left instanceof Double
         && right instanceof Short) {
      return _lessThan((Double)left, (Short)right);
    } else if (left instanceof Float
         && right instanceof Byte) {
      return _lessThan((Float)left, (Byte)right);
    } else if (left instanceof Float
         && right instanceof Double) {
      return _lessThan((Float)left, (Double)right);
    } else if (left instanceof Float
         && right instanceof Float) {
      return _lessThan((Float)left, (Float)right);
    } else if (left instanceof Float
         && right instanceof Integer) {
      return _lessThan((Float)left, (Integer)right);
    } else if (left instanceof Float
         && right instanceof Long) {
      return _lessThan((Float)left, (Long)right);
    } else if (left instanceof Float
         && right instanceof Short) {
      return _lessThan((Float)left, (Short)right);
    } else if (left instanceof Integer
         && right instanceof Byte) {
      return _lessThan((Integer)left, (Byte)right);
    } else if (left instanceof Integer
         && right instanceof Double) {
      return _lessThan((Integer)left, (Double)right);
    } else if (left instanceof Integer
         && right instanceof Float) {
      return _lessThan((Integer)left, (Float)right);
    } else if (left instanceof Integer
         && right instanceof Integer) {
      return _lessThan((Integer)left, (Integer)right);
    } else if (left instanceof Integer
         && right instanceof Long) {
      return _lessThan((Integer)left, (Long)right);
    } else if (left instanceof Integer
         && right instanceof Short) {
      return _lessThan((Integer)left, (Short)right);
    } else if (left instanceof Long
         && right instanceof Byte) {
      return _lessThan((Long)left, (Byte)right);
    } else if (left instanceof Long
         && right instanceof Double) {
      return _lessThan((Long)left, (Double)right);
    } else if (left instanceof Long
         && right instanceof Float) {
      return _lessThan((Long)left, (Float)right);
    } else if (left instanceof Long
         && right instanceof Integer) {
      return _lessThan((Long)left, (Integer)right);
    } else if (left instanceof Long
         && right instanceof Long) {
      return _lessThan((Long)left, (Long)right);
    } else if (left instanceof Long
         && right instanceof Short) {
      return _lessThan((Long)left, (Short)right);
    } else if (left instanceof Short
         && right instanceof Byte) {
      return _lessThan((Short)left, (Byte)right);
    } else if (left instanceof Short
         && right instanceof Double) {
      return _lessThan((Short)left, (Double)right);
    } else if (left instanceof Short
         && right instanceof Float) {
      return _lessThan((Short)left, (Float)right);
    } else if (left instanceof Short
         && right instanceof Integer) {
      return _lessThan((Short)left, (Integer)right);
    } else if (left instanceof Short
         && right instanceof Long) {
      return _lessThan((Short)left, (Long)right);
    } else if (left instanceof Short
         && right instanceof Short) {
      return _lessThan((Short)left, (Short)right);
    } else if (left != null
         && right != null) {
      return _lessThan(left, right);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right).toString());
    }
  }
  
  public Object minus(final Object left, final Object right) {
    if (left instanceof Byte
         && right instanceof Byte) {
      return _minus((Byte)left, (Byte)right);
    } else if (left instanceof Byte
         && right instanceof Double) {
      return _minus((Byte)left, (Double)right);
    } else if (left instanceof Byte
         && right instanceof Float) {
      return _minus((Byte)left, (Float)right);
    } else if (left instanceof Byte
         && right instanceof Integer) {
      return _minus((Byte)left, (Integer)right);
    } else if (left instanceof Byte
         && right instanceof Long) {
      return _minus((Byte)left, (Long)right);
    } else if (left instanceof Byte
         && right instanceof Short) {
      return _minus((Byte)left, (Short)right);
    } else if (left instanceof Double
         && right instanceof Byte) {
      return _minus((Double)left, (Byte)right);
    } else if (left instanceof Double
         && right instanceof Double) {
      return _minus((Double)left, (Double)right);
    } else if (left instanceof Double
         && right instanceof Float) {
      return _minus((Double)left, (Float)right);
    } else if (left instanceof Double
         && right instanceof Integer) {
      return _minus((Double)left, (Integer)right);
    } else if (left instanceof Double
         && right instanceof Long) {
      return _minus((Double)left, (Long)right);
    } else if (left instanceof Double
         && right instanceof Short) {
      return _minus((Double)left, (Short)right);
    } else if (left instanceof Float
         && right instanceof Byte) {
      return _minus((Float)left, (Byte)right);
    } else if (left instanceof Float
         && right instanceof Double) {
      return _minus((Float)left, (Double)right);
    } else if (left instanceof Float
         && right instanceof Float) {
      return _minus((Float)left, (Float)right);
    } else if (left instanceof Float
         && right instanceof Integer) {
      return _minus((Float)left, (Integer)right);
    } else if (left instanceof Float
         && right instanceof Long) {
      return _minus((Float)left, (Long)right);
    } else if (left instanceof Float
         && right instanceof Short) {
      return _minus((Float)left, (Short)right);
    } else if (left instanceof Integer
         && right instanceof Byte) {
      return _minus((Integer)left, (Byte)right);
    } else if (left instanceof Integer
         && right instanceof Double) {
      return _minus((Integer)left, (Double)right);
    } else if (left instanceof Integer
         && right instanceof Float) {
      return _minus((Integer)left, (Float)right);
    } else if (left instanceof Integer
         && right instanceof Integer) {
      return _minus((Integer)left, (Integer)right);
    } else if (left instanceof Integer
         && right instanceof Long) {
      return _minus((Integer)left, (Long)right);
    } else if (left instanceof Integer
         && right instanceof Short) {
      return _minus((Integer)left, (Short)right);
    } else if (left instanceof Long
         && right instanceof Byte) {
      return _minus((Long)left, (Byte)right);
    } else if (left instanceof Long
         && right instanceof Double) {
      return _minus((Long)left, (Double)right);
    } else if (left instanceof Long
         && right instanceof Float) {
      return _minus((Long)left, (Float)right);
    } else if (left instanceof Long
         && right instanceof Integer) {
      return _minus((Long)left, (Integer)right);
    } else if (left instanceof Long
         && right instanceof Long) {
      return _minus((Long)left, (Long)right);
    } else if (left instanceof Long
         && right instanceof Short) {
      return _minus((Long)left, (Short)right);
    } else if (left instanceof Short
         && right instanceof Byte) {
      return _minus((Short)left, (Byte)right);
    } else if (left instanceof Short
         && right instanceof Double) {
      return _minus((Short)left, (Double)right);
    } else if (left instanceof Short
         && right instanceof Float) {
      return _minus((Short)left, (Float)right);
    } else if (left instanceof Short
         && right instanceof Integer) {
      return _minus((Short)left, (Integer)right);
    } else if (left instanceof Short
         && right instanceof Long) {
      return _minus((Short)left, (Long)right);
    } else if (left instanceof Short
         && right instanceof Short) {
      return _minus((Short)left, (Short)right);
    } else if (left != null
         && right != null) {
      return _minus(left, right);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right).toString());
    }
  }
  
  public boolean greaterThan(final Object left, final Object right) {
    if (left instanceof Byte
         && right instanceof Byte) {
      return _greaterThan((Byte)left, (Byte)right);
    } else if (left instanceof Byte
         && right instanceof Double) {
      return _greaterThan((Byte)left, (Double)right);
    } else if (left instanceof Byte
         && right instanceof Float) {
      return _greaterThan((Byte)left, (Float)right);
    } else if (left instanceof Byte
         && right instanceof Integer) {
      return _greaterThan((Byte)left, (Integer)right);
    } else if (left instanceof Byte
         && right instanceof Long) {
      return _greaterThan((Byte)left, (Long)right);
    } else if (left instanceof Byte
         && right instanceof Short) {
      return _greaterThan((Byte)left, (Short)right);
    } else if (left instanceof Double
         && right instanceof Byte) {
      return _greaterThan((Double)left, (Byte)right);
    } else if (left instanceof Double
         && right instanceof Double) {
      return _greaterThan((Double)left, (Double)right);
    } else if (left instanceof Double
         && right instanceof Float) {
      return _greaterThan((Double)left, (Float)right);
    } else if (left instanceof Double
         && right instanceof Integer) {
      return _greaterThan((Double)left, (Integer)right);
    } else if (left instanceof Double
         && right instanceof Long) {
      return _greaterThan((Double)left, (Long)right);
    } else if (left instanceof Double
         && right instanceof Short) {
      return _greaterThan((Double)left, (Short)right);
    } else if (left instanceof Float
         && right instanceof Byte) {
      return _greaterThan((Float)left, (Byte)right);
    } else if (left instanceof Float
         && right instanceof Double) {
      return _greaterThan((Float)left, (Double)right);
    } else if (left instanceof Float
         && right instanceof Float) {
      return _greaterThan((Float)left, (Float)right);
    } else if (left instanceof Float
         && right instanceof Integer) {
      return _greaterThan((Float)left, (Integer)right);
    } else if (left instanceof Float
         && right instanceof Long) {
      return _greaterThan((Float)left, (Long)right);
    } else if (left instanceof Float
         && right instanceof Short) {
      return _greaterThan((Float)left, (Short)right);
    } else if (left instanceof Integer
         && right instanceof Byte) {
      return _greaterThan((Integer)left, (Byte)right);
    } else if (left instanceof Integer
         && right instanceof Double) {
      return _greaterThan((Integer)left, (Double)right);
    } else if (left instanceof Integer
         && right instanceof Float) {
      return _greaterThan((Integer)left, (Float)right);
    } else if (left instanceof Integer
         && right instanceof Integer) {
      return _greaterThan((Integer)left, (Integer)right);
    } else if (left instanceof Integer
         && right instanceof Long) {
      return _greaterThan((Integer)left, (Long)right);
    } else if (left instanceof Integer
         && right instanceof Short) {
      return _greaterThan((Integer)left, (Short)right);
    } else if (left instanceof Long
         && right instanceof Byte) {
      return _greaterThan((Long)left, (Byte)right);
    } else if (left instanceof Long
         && right instanceof Double) {
      return _greaterThan((Long)left, (Double)right);
    } else if (left instanceof Long
         && right instanceof Float) {
      return _greaterThan((Long)left, (Float)right);
    } else if (left instanceof Long
         && right instanceof Integer) {
      return _greaterThan((Long)left, (Integer)right);
    } else if (left instanceof Long
         && right instanceof Long) {
      return _greaterThan((Long)left, (Long)right);
    } else if (left instanceof Long
         && right instanceof Short) {
      return _greaterThan((Long)left, (Short)right);
    } else if (left instanceof Short
         && right instanceof Byte) {
      return _greaterThan((Short)left, (Byte)right);
    } else if (left instanceof Short
         && right instanceof Double) {
      return _greaterThan((Short)left, (Double)right);
    } else if (left instanceof Short
         && right instanceof Float) {
      return _greaterThan((Short)left, (Float)right);
    } else if (left instanceof Short
         && right instanceof Integer) {
      return _greaterThan((Short)left, (Integer)right);
    } else if (left instanceof Short
         && right instanceof Long) {
      return _greaterThan((Short)left, (Long)right);
    } else if (left instanceof Short
         && right instanceof Short) {
      return _greaterThan((Short)left, (Short)right);
    } else if (left != null
         && right != null) {
      return _greaterThan(left, right);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right).toString());
    }
  }
  
  public Object modulo(final Object left, final Object right) {
    if (left instanceof Byte
         && right instanceof Byte) {
      return _modulo((Byte)left, (Byte)right);
    } else if (left instanceof Byte
         && right instanceof Double) {
      return _modulo((Byte)left, (Double)right);
    } else if (left instanceof Byte
         && right instanceof Float) {
      return _modulo((Byte)left, (Float)right);
    } else if (left instanceof Byte
         && right instanceof Integer) {
      return _modulo((Byte)left, (Integer)right);
    } else if (left instanceof Byte
         && right instanceof Long) {
      return _modulo((Byte)left, (Long)right);
    } else if (left instanceof Byte
         && right instanceof Short) {
      return _modulo((Byte)left, (Short)right);
    } else if (left instanceof Double
         && right instanceof Byte) {
      return _modulo((Double)left, (Byte)right);
    } else if (left instanceof Double
         && right instanceof Double) {
      return _modulo((Double)left, (Double)right);
    } else if (left instanceof Double
         && right instanceof Float) {
      return _modulo((Double)left, (Float)right);
    } else if (left instanceof Double
         && right instanceof Integer) {
      return _modulo((Double)left, (Integer)right);
    } else if (left instanceof Double
         && right instanceof Long) {
      return _modulo((Double)left, (Long)right);
    } else if (left instanceof Double
         && right instanceof Short) {
      return _modulo((Double)left, (Short)right);
    } else if (left instanceof Float
         && right instanceof Byte) {
      return _modulo((Float)left, (Byte)right);
    } else if (left instanceof Float
         && right instanceof Double) {
      return _modulo((Float)left, (Double)right);
    } else if (left instanceof Float
         && right instanceof Float) {
      return _modulo((Float)left, (Float)right);
    } else if (left instanceof Float
         && right instanceof Integer) {
      return _modulo((Float)left, (Integer)right);
    } else if (left instanceof Float
         && right instanceof Long) {
      return _modulo((Float)left, (Long)right);
    } else if (left instanceof Float
         && right instanceof Short) {
      return _modulo((Float)left, (Short)right);
    } else if (left instanceof Integer
         && right instanceof Byte) {
      return _modulo((Integer)left, (Byte)right);
    } else if (left instanceof Integer
         && right instanceof Double) {
      return _modulo((Integer)left, (Double)right);
    } else if (left instanceof Integer
         && right instanceof Float) {
      return _modulo((Integer)left, (Float)right);
    } else if (left instanceof Integer
         && right instanceof Integer) {
      return _modulo((Integer)left, (Integer)right);
    } else if (left instanceof Integer
         && right instanceof Long) {
      return _modulo((Integer)left, (Long)right);
    } else if (left instanceof Integer
         && right instanceof Short) {
      return _modulo((Integer)left, (Short)right);
    } else if (left instanceof Long
         && right instanceof Byte) {
      return _modulo((Long)left, (Byte)right);
    } else if (left instanceof Long
         && right instanceof Double) {
      return _modulo((Long)left, (Double)right);
    } else if (left instanceof Long
         && right instanceof Float) {
      return _modulo((Long)left, (Float)right);
    } else if (left instanceof Long
         && right instanceof Integer) {
      return _modulo((Long)left, (Integer)right);
    } else if (left instanceof Long
         && right instanceof Long) {
      return _modulo((Long)left, (Long)right);
    } else if (left instanceof Long
         && right instanceof Short) {
      return _modulo((Long)left, (Short)right);
    } else if (left instanceof Short
         && right instanceof Byte) {
      return _modulo((Short)left, (Byte)right);
    } else if (left instanceof Short
         && right instanceof Double) {
      return _modulo((Short)left, (Double)right);
    } else if (left instanceof Short
         && right instanceof Float) {
      return _modulo((Short)left, (Float)right);
    } else if (left instanceof Short
         && right instanceof Integer) {
      return _modulo((Short)left, (Integer)right);
    } else if (left instanceof Short
         && right instanceof Long) {
      return _modulo((Short)left, (Long)right);
    } else if (left instanceof Short
         && right instanceof Short) {
      return _modulo((Short)left, (Short)right);
    } else if (left != null
         && right != null) {
      return _modulo(left, right);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right).toString());
    }
  }
  
  public Object multiply(final Object left, final Object right) {
    if (left instanceof Byte
         && right instanceof Byte) {
      return _multiply((Byte)left, (Byte)right);
    } else if (left instanceof Byte
         && right instanceof Double) {
      return _multiply((Byte)left, (Double)right);
    } else if (left instanceof Byte
         && right instanceof Float) {
      return _multiply((Byte)left, (Float)right);
    } else if (left instanceof Byte
         && right instanceof Integer) {
      return _multiply((Byte)left, (Integer)right);
    } else if (left instanceof Byte
         && right instanceof Long) {
      return _multiply((Byte)left, (Long)right);
    } else if (left instanceof Byte
         && right instanceof Short) {
      return _multiply((Byte)left, (Short)right);
    } else if (left instanceof Double
         && right instanceof Byte) {
      return _multiply((Double)left, (Byte)right);
    } else if (left instanceof Double
         && right instanceof Double) {
      return _multiply((Double)left, (Double)right);
    } else if (left instanceof Double
         && right instanceof Float) {
      return _multiply((Double)left, (Float)right);
    } else if (left instanceof Double
         && right instanceof Integer) {
      return _multiply((Double)left, (Integer)right);
    } else if (left instanceof Double
         && right instanceof Long) {
      return _multiply((Double)left, (Long)right);
    } else if (left instanceof Double
         && right instanceof Short) {
      return _multiply((Double)left, (Short)right);
    } else if (left instanceof Float
         && right instanceof Byte) {
      return _multiply((Float)left, (Byte)right);
    } else if (left instanceof Float
         && right instanceof Double) {
      return _multiply((Float)left, (Double)right);
    } else if (left instanceof Float
         && right instanceof Float) {
      return _multiply((Float)left, (Float)right);
    } else if (left instanceof Float
         && right instanceof Integer) {
      return _multiply((Float)left, (Integer)right);
    } else if (left instanceof Float
         && right instanceof Long) {
      return _multiply((Float)left, (Long)right);
    } else if (left instanceof Float
         && right instanceof Short) {
      return _multiply((Float)left, (Short)right);
    } else if (left instanceof Integer
         && right instanceof Byte) {
      return _multiply((Integer)left, (Byte)right);
    } else if (left instanceof Integer
         && right instanceof Double) {
      return _multiply((Integer)left, (Double)right);
    } else if (left instanceof Integer
         && right instanceof Float) {
      return _multiply((Integer)left, (Float)right);
    } else if (left instanceof Integer
         && right instanceof Integer) {
      return _multiply((Integer)left, (Integer)right);
    } else if (left instanceof Integer
         && right instanceof Long) {
      return _multiply((Integer)left, (Long)right);
    } else if (left instanceof Integer
         && right instanceof Short) {
      return _multiply((Integer)left, (Short)right);
    } else if (left instanceof Long
         && right instanceof Byte) {
      return _multiply((Long)left, (Byte)right);
    } else if (left instanceof Long
         && right instanceof Double) {
      return _multiply((Long)left, (Double)right);
    } else if (left instanceof Long
         && right instanceof Float) {
      return _multiply((Long)left, (Float)right);
    } else if (left instanceof Long
         && right instanceof Integer) {
      return _multiply((Long)left, (Integer)right);
    } else if (left instanceof Long
         && right instanceof Long) {
      return _multiply((Long)left, (Long)right);
    } else if (left instanceof Long
         && right instanceof Short) {
      return _multiply((Long)left, (Short)right);
    } else if (left instanceof Short
         && right instanceof Byte) {
      return _multiply((Short)left, (Byte)right);
    } else if (left instanceof Short
         && right instanceof Double) {
      return _multiply((Short)left, (Double)right);
    } else if (left instanceof Short
         && right instanceof Float) {
      return _multiply((Short)left, (Float)right);
    } else if (left instanceof Short
         && right instanceof Integer) {
      return _multiply((Short)left, (Integer)right);
    } else if (left instanceof Short
         && right instanceof Long) {
      return _multiply((Short)left, (Long)right);
    } else if (left instanceof Short
         && right instanceof Short) {
      return _multiply((Short)left, (Short)right);
    } else if (left != null
         && right != null) {
      return _multiply(left, right);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right).toString());
    }
  }
  
  public Object divide(final Object left, final Object right) {
    if (left instanceof Byte
         && right instanceof Byte) {
      return _divide((Byte)left, (Byte)right);
    } else if (left instanceof Byte
         && right instanceof Double) {
      return _divide((Byte)left, (Double)right);
    } else if (left instanceof Byte
         && right instanceof Float) {
      return _divide((Byte)left, (Float)right);
    } else if (left instanceof Byte
         && right instanceof Integer) {
      return _divide((Byte)left, (Integer)right);
    } else if (left instanceof Byte
         && right instanceof Long) {
      return _divide((Byte)left, (Long)right);
    } else if (left instanceof Byte
         && right instanceof Short) {
      return _divide((Byte)left, (Short)right);
    } else if (left instanceof Double
         && right instanceof Byte) {
      return _divide((Double)left, (Byte)right);
    } else if (left instanceof Double
         && right instanceof Double) {
      return _divide((Double)left, (Double)right);
    } else if (left instanceof Double
         && right instanceof Float) {
      return _divide((Double)left, (Float)right);
    } else if (left instanceof Double
         && right instanceof Integer) {
      return _divide((Double)left, (Integer)right);
    } else if (left instanceof Double
         && right instanceof Long) {
      return _divide((Double)left, (Long)right);
    } else if (left instanceof Double
         && right instanceof Short) {
      return _divide((Double)left, (Short)right);
    } else if (left instanceof Float
         && right instanceof Byte) {
      return _divide((Float)left, (Byte)right);
    } else if (left instanceof Float
         && right instanceof Double) {
      return _divide((Float)left, (Double)right);
    } else if (left instanceof Float
         && right instanceof Float) {
      return _divide((Float)left, (Float)right);
    } else if (left instanceof Float
         && right instanceof Integer) {
      return _divide((Float)left, (Integer)right);
    } else if (left instanceof Float
         && right instanceof Long) {
      return _divide((Float)left, (Long)right);
    } else if (left instanceof Float
         && right instanceof Short) {
      return _divide((Float)left, (Short)right);
    } else if (left instanceof Integer
         && right instanceof Byte) {
      return _divide((Integer)left, (Byte)right);
    } else if (left instanceof Integer
         && right instanceof Double) {
      return _divide((Integer)left, (Double)right);
    } else if (left instanceof Integer
         && right instanceof Float) {
      return _divide((Integer)left, (Float)right);
    } else if (left instanceof Integer
         && right instanceof Integer) {
      return _divide((Integer)left, (Integer)right);
    } else if (left instanceof Integer
         && right instanceof Long) {
      return _divide((Integer)left, (Long)right);
    } else if (left instanceof Integer
         && right instanceof Short) {
      return _divide((Integer)left, (Short)right);
    } else if (left instanceof Long
         && right instanceof Byte) {
      return _divide((Long)left, (Byte)right);
    } else if (left instanceof Long
         && right instanceof Double) {
      return _divide((Long)left, (Double)right);
    } else if (left instanceof Long
         && right instanceof Float) {
      return _divide((Long)left, (Float)right);
    } else if (left instanceof Long
         && right instanceof Integer) {
      return _divide((Long)left, (Integer)right);
    } else if (left instanceof Long
         && right instanceof Long) {
      return _divide((Long)left, (Long)right);
    } else if (left instanceof Long
         && right instanceof Short) {
      return _divide((Long)left, (Short)right);
    } else if (left instanceof Short
         && right instanceof Byte) {
      return _divide((Short)left, (Byte)right);
    } else if (left instanceof Short
         && right instanceof Double) {
      return _divide((Short)left, (Double)right);
    } else if (left instanceof Short
         && right instanceof Float) {
      return _divide((Short)left, (Float)right);
    } else if (left instanceof Short
         && right instanceof Integer) {
      return _divide((Short)left, (Integer)right);
    } else if (left instanceof Short
         && right instanceof Long) {
      return _divide((Short)left, (Long)right);
    } else if (left instanceof Short
         && right instanceof Short) {
      return _divide((Short)left, (Short)right);
    } else if (left != null
         && right != null) {
      return _divide(left, right);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right).toString());
    }
  }
  
  public boolean same(final Object left, final Object right) {
    if (left instanceof Byte
         && right instanceof Byte) {
      return _same((Byte)left, (Byte)right);
    } else if (left instanceof Byte
         && right instanceof Double) {
      return _same((Byte)left, (Double)right);
    } else if (left instanceof Byte
         && right instanceof Float) {
      return _same((Byte)left, (Float)right);
    } else if (left instanceof Byte
         && right instanceof Integer) {
      return _same((Byte)left, (Integer)right);
    } else if (left instanceof Byte
         && right instanceof Long) {
      return _same((Byte)left, (Long)right);
    } else if (left instanceof Byte
         && right instanceof Short) {
      return _same((Byte)left, (Short)right);
    } else if (left instanceof Double
         && right instanceof Byte) {
      return _same((Double)left, (Byte)right);
    } else if (left instanceof Double
         && right instanceof Double) {
      return _same((Double)left, (Double)right);
    } else if (left instanceof Double
         && right instanceof Float) {
      return _same((Double)left, (Float)right);
    } else if (left instanceof Double
         && right instanceof Integer) {
      return _same((Double)left, (Integer)right);
    } else if (left instanceof Double
         && right instanceof Long) {
      return _same((Double)left, (Long)right);
    } else if (left instanceof Double
         && right instanceof Short) {
      return _same((Double)left, (Short)right);
    } else if (left instanceof Float
         && right instanceof Byte) {
      return _same((Float)left, (Byte)right);
    } else if (left instanceof Float
         && right instanceof Double) {
      return _same((Float)left, (Double)right);
    } else if (left instanceof Float
         && right instanceof Float) {
      return _same((Float)left, (Float)right);
    } else if (left instanceof Float
         && right instanceof Integer) {
      return _same((Float)left, (Integer)right);
    } else if (left instanceof Float
         && right instanceof Long) {
      return _same((Float)left, (Long)right);
    } else if (left instanceof Float
         && right instanceof Short) {
      return _same((Float)left, (Short)right);
    } else if (left instanceof Integer
         && right instanceof Byte) {
      return _same((Integer)left, (Byte)right);
    } else if (left instanceof Integer
         && right instanceof Double) {
      return _same((Integer)left, (Double)right);
    } else if (left instanceof Integer
         && right instanceof Float) {
      return _same((Integer)left, (Float)right);
    } else if (left instanceof Integer
         && right instanceof Integer) {
      return _same((Integer)left, (Integer)right);
    } else if (left instanceof Integer
         && right instanceof Long) {
      return _same((Integer)left, (Long)right);
    } else if (left instanceof Integer
         && right instanceof Short) {
      return _same((Integer)left, (Short)right);
    } else if (left instanceof Long
         && right instanceof Byte) {
      return _same((Long)left, (Byte)right);
    } else if (left instanceof Long
         && right instanceof Double) {
      return _same((Long)left, (Double)right);
    } else if (left instanceof Long
         && right instanceof Float) {
      return _same((Long)left, (Float)right);
    } else if (left instanceof Long
         && right instanceof Integer) {
      return _same((Long)left, (Integer)right);
    } else if (left instanceof Long
         && right instanceof Long) {
      return _same((Long)left, (Long)right);
    } else if (left instanceof Long
         && right instanceof Short) {
      return _same((Long)left, (Short)right);
    } else if (left instanceof Short
         && right instanceof Byte) {
      return _same((Short)left, (Byte)right);
    } else if (left instanceof Short
         && right instanceof Double) {
      return _same((Short)left, (Double)right);
    } else if (left instanceof Short
         && right instanceof Float) {
      return _same((Short)left, (Float)right);
    } else if (left instanceof Short
         && right instanceof Integer) {
      return _same((Short)left, (Integer)right);
    } else if (left instanceof Short
         && right instanceof Long) {
      return _same((Short)left, (Long)right);
    } else if (left instanceof Short
         && right instanceof Short) {
      return _same((Short)left, (Short)right);
    } else if (left != null
         && right != null) {
      return _same(left, right);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right).toString());
    }
  }
  
  public boolean lessEquals(final Object left, final Object right) {
    if (left instanceof Byte
         && right instanceof Byte) {
      return _lessEquals((Byte)left, (Byte)right);
    } else if (left instanceof Byte
         && right instanceof Double) {
      return _lessEquals((Byte)left, (Double)right);
    } else if (left instanceof Byte
         && right instanceof Float) {
      return _lessEquals((Byte)left, (Float)right);
    } else if (left instanceof Byte
         && right instanceof Integer) {
      return _lessEquals((Byte)left, (Integer)right);
    } else if (left instanceof Byte
         && right instanceof Long) {
      return _lessEquals((Byte)left, (Long)right);
    } else if (left instanceof Byte
         && right instanceof Short) {
      return _lessEquals((Byte)left, (Short)right);
    } else if (left instanceof Double
         && right instanceof Byte) {
      return _lessEquals((Double)left, (Byte)right);
    } else if (left instanceof Double
         && right instanceof Double) {
      return _lessEquals((Double)left, (Double)right);
    } else if (left instanceof Double
         && right instanceof Float) {
      return _lessEquals((Double)left, (Float)right);
    } else if (left instanceof Double
         && right instanceof Integer) {
      return _lessEquals((Double)left, (Integer)right);
    } else if (left instanceof Double
         && right instanceof Long) {
      return _lessEquals((Double)left, (Long)right);
    } else if (left instanceof Double
         && right instanceof Short) {
      return _lessEquals((Double)left, (Short)right);
    } else if (left instanceof Float
         && right instanceof Byte) {
      return _lessEquals((Float)left, (Byte)right);
    } else if (left instanceof Float
         && right instanceof Double) {
      return _lessEquals((Float)left, (Double)right);
    } else if (left instanceof Float
         && right instanceof Float) {
      return _lessEquals((Float)left, (Float)right);
    } else if (left instanceof Float
         && right instanceof Integer) {
      return _lessEquals((Float)left, (Integer)right);
    } else if (left instanceof Float
         && right instanceof Long) {
      return _lessEquals((Float)left, (Long)right);
    } else if (left instanceof Float
         && right instanceof Short) {
      return _lessEquals((Float)left, (Short)right);
    } else if (left instanceof Integer
         && right instanceof Byte) {
      return _lessEquals((Integer)left, (Byte)right);
    } else if (left instanceof Integer
         && right instanceof Double) {
      return _lessEquals((Integer)left, (Double)right);
    } else if (left instanceof Integer
         && right instanceof Float) {
      return _lessEquals((Integer)left, (Float)right);
    } else if (left instanceof Integer
         && right instanceof Integer) {
      return _lessEquals((Integer)left, (Integer)right);
    } else if (left instanceof Integer
         && right instanceof Long) {
      return _lessEquals((Integer)left, (Long)right);
    } else if (left instanceof Integer
         && right instanceof Short) {
      return _lessEquals((Integer)left, (Short)right);
    } else if (left instanceof Long
         && right instanceof Byte) {
      return _lessEquals((Long)left, (Byte)right);
    } else if (left instanceof Long
         && right instanceof Double) {
      return _lessEquals((Long)left, (Double)right);
    } else if (left instanceof Long
         && right instanceof Float) {
      return _lessEquals((Long)left, (Float)right);
    } else if (left instanceof Long
         && right instanceof Integer) {
      return _lessEquals((Long)left, (Integer)right);
    } else if (left instanceof Long
         && right instanceof Long) {
      return _lessEquals((Long)left, (Long)right);
    } else if (left instanceof Long
         && right instanceof Short) {
      return _lessEquals((Long)left, (Short)right);
    } else if (left instanceof Short
         && right instanceof Byte) {
      return _lessEquals((Short)left, (Byte)right);
    } else if (left instanceof Short
         && right instanceof Double) {
      return _lessEquals((Short)left, (Double)right);
    } else if (left instanceof Short
         && right instanceof Float) {
      return _lessEquals((Short)left, (Float)right);
    } else if (left instanceof Short
         && right instanceof Integer) {
      return _lessEquals((Short)left, (Integer)right);
    } else if (left instanceof Short
         && right instanceof Long) {
      return _lessEquals((Short)left, (Long)right);
    } else if (left instanceof Short
         && right instanceof Short) {
      return _lessEquals((Short)left, (Short)right);
    } else if (left != null
         && right != null) {
      return _lessEquals(left, right);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right).toString());
    }
  }
  
  public boolean greaterEquals(final Object left, final Object right) {
    if (left instanceof Byte
         && right instanceof Byte) {
      return _greaterEquals((Byte)left, (Byte)right);
    } else if (left instanceof Byte
         && right instanceof Double) {
      return _greaterEquals((Byte)left, (Double)right);
    } else if (left instanceof Byte
         && right instanceof Float) {
      return _greaterEquals((Byte)left, (Float)right);
    } else if (left instanceof Byte
         && right instanceof Integer) {
      return _greaterEquals((Byte)left, (Integer)right);
    } else if (left instanceof Byte
         && right instanceof Long) {
      return _greaterEquals((Byte)left, (Long)right);
    } else if (left instanceof Byte
         && right instanceof Short) {
      return _greaterEquals((Byte)left, (Short)right);
    } else if (left instanceof Double
         && right instanceof Byte) {
      return _greaterEquals((Double)left, (Byte)right);
    } else if (left instanceof Double
         && right instanceof Double) {
      return _greaterEquals((Double)left, (Double)right);
    } else if (left instanceof Double
         && right instanceof Float) {
      return _greaterEquals((Double)left, (Float)right);
    } else if (left instanceof Double
         && right instanceof Integer) {
      return _greaterEquals((Double)left, (Integer)right);
    } else if (left instanceof Double
         && right instanceof Long) {
      return _greaterEquals((Double)left, (Long)right);
    } else if (left instanceof Double
         && right instanceof Short) {
      return _greaterEquals((Double)left, (Short)right);
    } else if (left instanceof Float
         && right instanceof Byte) {
      return _greaterEquals((Float)left, (Byte)right);
    } else if (left instanceof Float
         && right instanceof Double) {
      return _greaterEquals((Float)left, (Double)right);
    } else if (left instanceof Float
         && right instanceof Float) {
      return _greaterEquals((Float)left, (Float)right);
    } else if (left instanceof Float
         && right instanceof Integer) {
      return _greaterEquals((Float)left, (Integer)right);
    } else if (left instanceof Float
         && right instanceof Long) {
      return _greaterEquals((Float)left, (Long)right);
    } else if (left instanceof Float
         && right instanceof Short) {
      return _greaterEquals((Float)left, (Short)right);
    } else if (left instanceof Integer
         && right instanceof Byte) {
      return _greaterEquals((Integer)left, (Byte)right);
    } else if (left instanceof Integer
         && right instanceof Double) {
      return _greaterEquals((Integer)left, (Double)right);
    } else if (left instanceof Integer
         && right instanceof Float) {
      return _greaterEquals((Integer)left, (Float)right);
    } else if (left instanceof Integer
         && right instanceof Integer) {
      return _greaterEquals((Integer)left, (Integer)right);
    } else if (left instanceof Integer
         && right instanceof Long) {
      return _greaterEquals((Integer)left, (Long)right);
    } else if (left instanceof Integer
         && right instanceof Short) {
      return _greaterEquals((Integer)left, (Short)right);
    } else if (left instanceof Long
         && right instanceof Byte) {
      return _greaterEquals((Long)left, (Byte)right);
    } else if (left instanceof Long
         && right instanceof Double) {
      return _greaterEquals((Long)left, (Double)right);
    } else if (left instanceof Long
         && right instanceof Float) {
      return _greaterEquals((Long)left, (Float)right);
    } else if (left instanceof Long
         && right instanceof Integer) {
      return _greaterEquals((Long)left, (Integer)right);
    } else if (left instanceof Long
         && right instanceof Long) {
      return _greaterEquals((Long)left, (Long)right);
    } else if (left instanceof Long
         && right instanceof Short) {
      return _greaterEquals((Long)left, (Short)right);
    } else if (left instanceof Short
         && right instanceof Byte) {
      return _greaterEquals((Short)left, (Byte)right);
    } else if (left instanceof Short
         && right instanceof Double) {
      return _greaterEquals((Short)left, (Double)right);
    } else if (left instanceof Short
         && right instanceof Float) {
      return _greaterEquals((Short)left, (Float)right);
    } else if (left instanceof Short
         && right instanceof Integer) {
      return _greaterEquals((Short)left, (Integer)right);
    } else if (left instanceof Short
         && right instanceof Long) {
      return _greaterEquals((Short)left, (Long)right);
    } else if (left instanceof Short
         && right instanceof Short) {
      return _greaterEquals((Short)left, (Short)right);
    } else if (left != null
         && right != null) {
      return _greaterEquals(left, right);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right).toString());
    }
  }
  
  public boolean notSame(final Object left, final Object right) {
    if (left instanceof Byte
         && right instanceof Byte) {
      return _notSame((Byte)left, (Byte)right);
    } else if (left instanceof Byte
         && right instanceof Double) {
      return _notSame((Byte)left, (Double)right);
    } else if (left instanceof Byte
         && right instanceof Float) {
      return _notSame((Byte)left, (Float)right);
    } else if (left instanceof Byte
         && right instanceof Integer) {
      return _notSame((Byte)left, (Integer)right);
    } else if (left instanceof Byte
         && right instanceof Long) {
      return _notSame((Byte)left, (Long)right);
    } else if (left instanceof Byte
         && right instanceof Short) {
      return _notSame((Byte)left, (Short)right);
    } else if (left instanceof Double
         && right instanceof Byte) {
      return _notSame((Double)left, (Byte)right);
    } else if (left instanceof Double
         && right instanceof Double) {
      return _notSame((Double)left, (Double)right);
    } else if (left instanceof Double
         && right instanceof Float) {
      return _notSame((Double)left, (Float)right);
    } else if (left instanceof Double
         && right instanceof Integer) {
      return _notSame((Double)left, (Integer)right);
    } else if (left instanceof Double
         && right instanceof Long) {
      return _notSame((Double)left, (Long)right);
    } else if (left instanceof Double
         && right instanceof Short) {
      return _notSame((Double)left, (Short)right);
    } else if (left instanceof Float
         && right instanceof Byte) {
      return _notSame((Float)left, (Byte)right);
    } else if (left instanceof Float
         && right instanceof Double) {
      return _notSame((Float)left, (Double)right);
    } else if (left instanceof Float
         && right instanceof Float) {
      return _notSame((Float)left, (Float)right);
    } else if (left instanceof Float
         && right instanceof Integer) {
      return _notSame((Float)left, (Integer)right);
    } else if (left instanceof Float
         && right instanceof Long) {
      return _notSame((Float)left, (Long)right);
    } else if (left instanceof Float
         && right instanceof Short) {
      return _notSame((Float)left, (Short)right);
    } else if (left instanceof Integer
         && right instanceof Byte) {
      return _notSame((Integer)left, (Byte)right);
    } else if (left instanceof Integer
         && right instanceof Double) {
      return _notSame((Integer)left, (Double)right);
    } else if (left instanceof Integer
         && right instanceof Float) {
      return _notSame((Integer)left, (Float)right);
    } else if (left instanceof Integer
         && right instanceof Integer) {
      return _notSame((Integer)left, (Integer)right);
    } else if (left instanceof Integer
         && right instanceof Long) {
      return _notSame((Integer)left, (Long)right);
    } else if (left instanceof Integer
         && right instanceof Short) {
      return _notSame((Integer)left, (Short)right);
    } else if (left instanceof Long
         && right instanceof Byte) {
      return _notSame((Long)left, (Byte)right);
    } else if (left instanceof Long
         && right instanceof Double) {
      return _notSame((Long)left, (Double)right);
    } else if (left instanceof Long
         && right instanceof Float) {
      return _notSame((Long)left, (Float)right);
    } else if (left instanceof Long
         && right instanceof Integer) {
      return _notSame((Long)left, (Integer)right);
    } else if (left instanceof Long
         && right instanceof Long) {
      return _notSame((Long)left, (Long)right);
    } else if (left instanceof Long
         && right instanceof Short) {
      return _notSame((Long)left, (Short)right);
    } else if (left instanceof Short
         && right instanceof Byte) {
      return _notSame((Short)left, (Byte)right);
    } else if (left instanceof Short
         && right instanceof Double) {
      return _notSame((Short)left, (Double)right);
    } else if (left instanceof Short
         && right instanceof Float) {
      return _notSame((Short)left, (Float)right);
    } else if (left instanceof Short
         && right instanceof Integer) {
      return _notSame((Short)left, (Integer)right);
    } else if (left instanceof Short
         && right instanceof Long) {
      return _notSame((Short)left, (Long)right);
    } else if (left instanceof Short
         && right instanceof Short) {
      return _notSame((Short)left, (Short)right);
    } else if (left != null
         && right != null) {
      return _notSame(left, right);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right).toString());
    }
  }
}
