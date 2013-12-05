/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
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
    final Set<String> types = Collections.<String>unmodifiableSet(Sets.<String>newHashSet("Integer", "Short", "Long", "Float", "Double", "Byte"));
    Map<String,String> _xsetliteral = null;
    Map<String,String> _tempMap = Maps.<String, String>newHashMap();
    _tempMap.put("plus", "+");
    _tempMap.put("minus", "-");
    _tempMap.put("divide", "/");
    _tempMap.put("multiply", "*");
    _tempMap.put("modulo", "%");
    _tempMap.put("lessThan", "<");
    _tempMap.put("greaterThan", ">");
    _tempMap.put("lessEquals", "<=");
    _tempMap.put("greaterEquals", ">=");
    _tempMap.put("same", "==");
    _tempMap.put("notSame", "!=");
    _xsetliteral = Collections.<String, String>unmodifiableMap(_tempMap);
    final Map<String,String> operators = _xsetliteral;
    Set<Map.Entry<String,String>> _entrySet = operators.entrySet();
    for (final Map.Entry<String,String> op : _entrySet) {
      {
        StringConcatenation _builder = new StringConcatenation();
        _builder.newLine();
        _builder.append("def dispatch ");
        String _key = op.getKey();
        _builder.append(_key, "");
        _builder.append("(Object left, Object right) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("throw new ConstantExpressionEvaluationException(\"Unsupported operator \'");
        String _value = op.getValue();
        _builder.append(_value, "\t");
        _builder.append("\' for operands \"+left+\" and \"+right);");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        InputOutput.<String>println(_builder.toString());
        for (final String left : types) {
          {
            InputOutput.<String>println("");
            for (final String right : types) {
              String _key_1 = op.getKey();
              String _plus = ("def dispatch " + _key_1);
              String _plus_1 = (_plus + "(");
              String _plus_2 = (_plus_1 + left);
              String _plus_3 = (_plus_2 + " left, ");
              String _plus_4 = (_plus_3 + right);
              String _plus_5 = (_plus_4 + " right) { left ");
              String _value_1 = op.getValue();
              String _plus_6 = (_plus_5 + _value_1);
              String _plus_7 = (_plus_6 + " right }");
              InputOutput.<String>println(_plus_7);
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
    return ((left).byteValue() + (right).byteValue());
  }
  
  protected Object _plus(final Byte left, final Double right) {
    return ((left).byteValue() + (right).doubleValue());
  }
  
  protected Object _plus(final Byte left, final Float right) {
    return ((left).byteValue() + (right).floatValue());
  }
  
  protected Object _plus(final Byte left, final Long right) {
    return ((left).byteValue() + (right).longValue());
  }
  
  protected Object _plus(final Byte left, final Short right) {
    return ((left).byteValue() + (right).shortValue());
  }
  
  protected Object _plus(final Byte left, final Integer right) {
    return ((left).byteValue() + (right).intValue());
  }
  
  protected Object _plus(final Double left, final Byte right) {
    double _plus = DoubleExtensions.operator_plus(left, right);
    return _plus;
  }
  
  protected Object _plus(final Double left, final Double right) {
    double _plus = DoubleExtensions.operator_plus(left, right);
    return _plus;
  }
  
  protected Object _plus(final Double left, final Float right) {
    double _plus = DoubleExtensions.operator_plus(left, right);
    return _plus;
  }
  
  protected Object _plus(final Double left, final Long right) {
    double _plus = DoubleExtensions.operator_plus(left, right);
    return _plus;
  }
  
  protected Object _plus(final Double left, final Short right) {
    double _plus = DoubleExtensions.operator_plus(left, right);
    return _plus;
  }
  
  protected Object _plus(final Double left, final Integer right) {
    double _plus = DoubleExtensions.operator_plus(left, right);
    return _plus;
  }
  
  protected Object _plus(final Float left, final Byte right) {
    return ((left).floatValue() + (right).byteValue());
  }
  
  protected Object _plus(final Float left, final Double right) {
    return ((left).floatValue() + (right).doubleValue());
  }
  
  protected Object _plus(final Float left, final Float right) {
    return ((left).floatValue() + (right).floatValue());
  }
  
  protected Object _plus(final Float left, final Long right) {
    return ((left).floatValue() + (right).longValue());
  }
  
  protected Object _plus(final Float left, final Short right) {
    return ((left).floatValue() + (right).shortValue());
  }
  
  protected Object _plus(final Float left, final Integer right) {
    return ((left).floatValue() + (right).intValue());
  }
  
  protected Object _plus(final Long left, final Byte right) {
    return ((left).longValue() + (right).byteValue());
  }
  
  protected Object _plus(final Long left, final Double right) {
    return ((left).longValue() + (right).doubleValue());
  }
  
  protected Object _plus(final Long left, final Float right) {
    return ((left).longValue() + (right).floatValue());
  }
  
  protected Object _plus(final Long left, final Long right) {
    return ((left).longValue() + (right).longValue());
  }
  
  protected Object _plus(final Long left, final Short right) {
    return ((left).longValue() + (right).shortValue());
  }
  
  protected Object _plus(final Long left, final Integer right) {
    return ((left).longValue() + (right).intValue());
  }
  
  protected Object _plus(final Short left, final Byte right) {
    return ((left).shortValue() + (right).byteValue());
  }
  
  protected Object _plus(final Short left, final Double right) {
    return ((left).shortValue() + (right).doubleValue());
  }
  
  protected Object _plus(final Short left, final Float right) {
    return ((left).shortValue() + (right).floatValue());
  }
  
  protected Object _plus(final Short left, final Long right) {
    return ((left).shortValue() + (right).longValue());
  }
  
  protected Object _plus(final Short left, final Short right) {
    return ((left).shortValue() + (right).shortValue());
  }
  
  protected Object _plus(final Short left, final Integer right) {
    return ((left).shortValue() + (right).intValue());
  }
  
  protected Object _plus(final Integer left, final Byte right) {
    return ((left).intValue() + (right).byteValue());
  }
  
  protected Object _plus(final Integer left, final Double right) {
    return ((left).intValue() + (right).doubleValue());
  }
  
  protected Object _plus(final Integer left, final Float right) {
    return ((left).intValue() + (right).floatValue());
  }
  
  protected Object _plus(final Integer left, final Long right) {
    return ((left).intValue() + (right).longValue());
  }
  
  protected Object _plus(final Integer left, final Short right) {
    return ((left).intValue() + (right).shortValue());
  }
  
  protected Object _plus(final Integer left, final Integer right) {
    return ((left).intValue() + (right).intValue());
  }
  
  protected Object _lessThan(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'<\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _lessThan(final Byte left, final Byte right) {
    boolean _lessThan = (left.compareTo(right) < 0);
    return _lessThan;
  }
  
  protected Object _lessThan(final Byte left, final Double right) {
    return ((left).byteValue() < (right).doubleValue());
  }
  
  protected Object _lessThan(final Byte left, final Float right) {
    return ((left).byteValue() < (right).floatValue());
  }
  
  protected Object _lessThan(final Byte left, final Long right) {
    return ((left).byteValue() < (right).longValue());
  }
  
  protected Object _lessThan(final Byte left, final Short right) {
    return ((left).byteValue() < (right).shortValue());
  }
  
  protected Object _lessThan(final Byte left, final Integer right) {
    return ((left).byteValue() < (right).intValue());
  }
  
  protected Object _lessThan(final Double left, final Byte right) {
    return ((left).doubleValue() < (right).byteValue());
  }
  
  protected Object _lessThan(final Double left, final Double right) {
    boolean _lessThan = (left.compareTo(right) < 0);
    return _lessThan;
  }
  
  protected Object _lessThan(final Double left, final Float right) {
    return ((left).doubleValue() < (right).floatValue());
  }
  
  protected Object _lessThan(final Double left, final Long right) {
    return ((left).doubleValue() < (right).longValue());
  }
  
  protected Object _lessThan(final Double left, final Short right) {
    return ((left).doubleValue() < (right).shortValue());
  }
  
  protected Object _lessThan(final Double left, final Integer right) {
    return ((left).doubleValue() < (right).intValue());
  }
  
  protected Object _lessThan(final Float left, final Byte right) {
    return ((left).floatValue() < (right).byteValue());
  }
  
  protected Object _lessThan(final Float left, final Double right) {
    return ((left).floatValue() < (right).doubleValue());
  }
  
  protected Object _lessThan(final Float left, final Float right) {
    boolean _lessThan = (left.compareTo(right) < 0);
    return _lessThan;
  }
  
  protected Object _lessThan(final Float left, final Long right) {
    return ((left).floatValue() < (right).longValue());
  }
  
  protected Object _lessThan(final Float left, final Short right) {
    return ((left).floatValue() < (right).shortValue());
  }
  
  protected Object _lessThan(final Float left, final Integer right) {
    return ((left).floatValue() < (right).intValue());
  }
  
  protected Object _lessThan(final Long left, final Byte right) {
    return ((left).longValue() < (right).byteValue());
  }
  
  protected Object _lessThan(final Long left, final Double right) {
    return ((left).longValue() < (right).doubleValue());
  }
  
  protected Object _lessThan(final Long left, final Float right) {
    return ((left).longValue() < (right).floatValue());
  }
  
  protected Object _lessThan(final Long left, final Long right) {
    boolean _lessThan = (left.compareTo(right) < 0);
    return _lessThan;
  }
  
  protected Object _lessThan(final Long left, final Short right) {
    return ((left).longValue() < (right).shortValue());
  }
  
  protected Object _lessThan(final Long left, final Integer right) {
    return ((left).longValue() < (right).intValue());
  }
  
  protected Object _lessThan(final Short left, final Byte right) {
    return ((left).shortValue() < (right).byteValue());
  }
  
  protected Object _lessThan(final Short left, final Double right) {
    return ((left).shortValue() < (right).doubleValue());
  }
  
  protected Object _lessThan(final Short left, final Float right) {
    return ((left).shortValue() < (right).floatValue());
  }
  
  protected Object _lessThan(final Short left, final Long right) {
    return ((left).shortValue() < (right).longValue());
  }
  
  protected Object _lessThan(final Short left, final Short right) {
    boolean _lessThan = (left.compareTo(right) < 0);
    return _lessThan;
  }
  
  protected Object _lessThan(final Short left, final Integer right) {
    return ((left).shortValue() < (right).intValue());
  }
  
  protected Object _lessThan(final Integer left, final Byte right) {
    return ((left).intValue() < (right).byteValue());
  }
  
  protected Object _lessThan(final Integer left, final Double right) {
    return ((left).intValue() < (right).doubleValue());
  }
  
  protected Object _lessThan(final Integer left, final Float right) {
    return ((left).intValue() < (right).floatValue());
  }
  
  protected Object _lessThan(final Integer left, final Long right) {
    return ((left).intValue() < (right).longValue());
  }
  
  protected Object _lessThan(final Integer left, final Short right) {
    return ((left).intValue() < (right).shortValue());
  }
  
  protected Object _lessThan(final Integer left, final Integer right) {
    boolean _lessThan = (left.compareTo(right) < 0);
    return _lessThan;
  }
  
  protected Object _minus(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'-\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _minus(final Byte left, final Byte right) {
    return ((left).byteValue() - (right).byteValue());
  }
  
  protected Object _minus(final Byte left, final Double right) {
    return ((left).byteValue() - (right).doubleValue());
  }
  
  protected Object _minus(final Byte left, final Float right) {
    return ((left).byteValue() - (right).floatValue());
  }
  
  protected Object _minus(final Byte left, final Long right) {
    return ((left).byteValue() - (right).longValue());
  }
  
  protected Object _minus(final Byte left, final Short right) {
    return ((left).byteValue() - (right).shortValue());
  }
  
  protected Object _minus(final Byte left, final Integer right) {
    return ((left).byteValue() - (right).intValue());
  }
  
  protected Object _minus(final Double left, final Byte right) {
    double _minus = DoubleExtensions.operator_minus(left, right);
    return _minus;
  }
  
  protected Object _minus(final Double left, final Double right) {
    double _minus = DoubleExtensions.operator_minus(left, right);
    return _minus;
  }
  
  protected Object _minus(final Double left, final Float right) {
    double _minus = DoubleExtensions.operator_minus(left, right);
    return _minus;
  }
  
  protected Object _minus(final Double left, final Long right) {
    double _minus = DoubleExtensions.operator_minus(left, right);
    return _minus;
  }
  
  protected Object _minus(final Double left, final Short right) {
    double _minus = DoubleExtensions.operator_minus(left, right);
    return _minus;
  }
  
  protected Object _minus(final Double left, final Integer right) {
    double _minus = DoubleExtensions.operator_minus(left, right);
    return _minus;
  }
  
  protected Object _minus(final Float left, final Byte right) {
    return ((left).floatValue() - (right).byteValue());
  }
  
  protected Object _minus(final Float left, final Double right) {
    return ((left).floatValue() - (right).doubleValue());
  }
  
  protected Object _minus(final Float left, final Float right) {
    return ((left).floatValue() - (right).floatValue());
  }
  
  protected Object _minus(final Float left, final Long right) {
    return ((left).floatValue() - (right).longValue());
  }
  
  protected Object _minus(final Float left, final Short right) {
    return ((left).floatValue() - (right).shortValue());
  }
  
  protected Object _minus(final Float left, final Integer right) {
    return ((left).floatValue() - (right).intValue());
  }
  
  protected Object _minus(final Long left, final Byte right) {
    return ((left).longValue() - (right).byteValue());
  }
  
  protected Object _minus(final Long left, final Double right) {
    return ((left).longValue() - (right).doubleValue());
  }
  
  protected Object _minus(final Long left, final Float right) {
    return ((left).longValue() - (right).floatValue());
  }
  
  protected Object _minus(final Long left, final Long right) {
    return ((left).longValue() - (right).longValue());
  }
  
  protected Object _minus(final Long left, final Short right) {
    return ((left).longValue() - (right).shortValue());
  }
  
  protected Object _minus(final Long left, final Integer right) {
    return ((left).longValue() - (right).intValue());
  }
  
  protected Object _minus(final Short left, final Byte right) {
    return ((left).shortValue() - (right).byteValue());
  }
  
  protected Object _minus(final Short left, final Double right) {
    return ((left).shortValue() - (right).doubleValue());
  }
  
  protected Object _minus(final Short left, final Float right) {
    return ((left).shortValue() - (right).floatValue());
  }
  
  protected Object _minus(final Short left, final Long right) {
    return ((left).shortValue() - (right).longValue());
  }
  
  protected Object _minus(final Short left, final Short right) {
    return ((left).shortValue() - (right).shortValue());
  }
  
  protected Object _minus(final Short left, final Integer right) {
    return ((left).shortValue() - (right).intValue());
  }
  
  protected Object _minus(final Integer left, final Byte right) {
    return ((left).intValue() - (right).byteValue());
  }
  
  protected Object _minus(final Integer left, final Double right) {
    return ((left).intValue() - (right).doubleValue());
  }
  
  protected Object _minus(final Integer left, final Float right) {
    return ((left).intValue() - (right).floatValue());
  }
  
  protected Object _minus(final Integer left, final Long right) {
    return ((left).intValue() - (right).longValue());
  }
  
  protected Object _minus(final Integer left, final Short right) {
    return ((left).intValue() - (right).shortValue());
  }
  
  protected Object _minus(final Integer left, final Integer right) {
    return ((left).intValue() - (right).intValue());
  }
  
  protected Object _greaterThan(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'>\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _greaterThan(final Byte left, final Byte right) {
    boolean _greaterThan = (left.compareTo(right) > 0);
    return _greaterThan;
  }
  
  protected Object _greaterThan(final Byte left, final Double right) {
    return ((left).byteValue() > (right).doubleValue());
  }
  
  protected Object _greaterThan(final Byte left, final Float right) {
    return ((left).byteValue() > (right).floatValue());
  }
  
  protected Object _greaterThan(final Byte left, final Long right) {
    return ((left).byteValue() > (right).longValue());
  }
  
  protected Object _greaterThan(final Byte left, final Short right) {
    return ((left).byteValue() > (right).shortValue());
  }
  
  protected Object _greaterThan(final Byte left, final Integer right) {
    return ((left).byteValue() > (right).intValue());
  }
  
  protected Object _greaterThan(final Double left, final Byte right) {
    return ((left).doubleValue() > (right).byteValue());
  }
  
  protected Object _greaterThan(final Double left, final Double right) {
    boolean _greaterThan = (left.compareTo(right) > 0);
    return _greaterThan;
  }
  
  protected Object _greaterThan(final Double left, final Float right) {
    return ((left).doubleValue() > (right).floatValue());
  }
  
  protected Object _greaterThan(final Double left, final Long right) {
    return ((left).doubleValue() > (right).longValue());
  }
  
  protected Object _greaterThan(final Double left, final Short right) {
    return ((left).doubleValue() > (right).shortValue());
  }
  
  protected Object _greaterThan(final Double left, final Integer right) {
    return ((left).doubleValue() > (right).intValue());
  }
  
  protected Object _greaterThan(final Float left, final Byte right) {
    return ((left).floatValue() > (right).byteValue());
  }
  
  protected Object _greaterThan(final Float left, final Double right) {
    return ((left).floatValue() > (right).doubleValue());
  }
  
  protected Object _greaterThan(final Float left, final Float right) {
    boolean _greaterThan = (left.compareTo(right) > 0);
    return _greaterThan;
  }
  
  protected Object _greaterThan(final Float left, final Long right) {
    return ((left).floatValue() > (right).longValue());
  }
  
  protected Object _greaterThan(final Float left, final Short right) {
    return ((left).floatValue() > (right).shortValue());
  }
  
  protected Object _greaterThan(final Float left, final Integer right) {
    return ((left).floatValue() > (right).intValue());
  }
  
  protected Object _greaterThan(final Long left, final Byte right) {
    return ((left).longValue() > (right).byteValue());
  }
  
  protected Object _greaterThan(final Long left, final Double right) {
    return ((left).longValue() > (right).doubleValue());
  }
  
  protected Object _greaterThan(final Long left, final Float right) {
    return ((left).longValue() > (right).floatValue());
  }
  
  protected Object _greaterThan(final Long left, final Long right) {
    boolean _greaterThan = (left.compareTo(right) > 0);
    return _greaterThan;
  }
  
  protected Object _greaterThan(final Long left, final Short right) {
    return ((left).longValue() > (right).shortValue());
  }
  
  protected Object _greaterThan(final Long left, final Integer right) {
    return ((left).longValue() > (right).intValue());
  }
  
  protected Object _greaterThan(final Short left, final Byte right) {
    return ((left).shortValue() > (right).byteValue());
  }
  
  protected Object _greaterThan(final Short left, final Double right) {
    return ((left).shortValue() > (right).doubleValue());
  }
  
  protected Object _greaterThan(final Short left, final Float right) {
    return ((left).shortValue() > (right).floatValue());
  }
  
  protected Object _greaterThan(final Short left, final Long right) {
    return ((left).shortValue() > (right).longValue());
  }
  
  protected Object _greaterThan(final Short left, final Short right) {
    boolean _greaterThan = (left.compareTo(right) > 0);
    return _greaterThan;
  }
  
  protected Object _greaterThan(final Short left, final Integer right) {
    return ((left).shortValue() > (right).intValue());
  }
  
  protected Object _greaterThan(final Integer left, final Byte right) {
    return ((left).intValue() > (right).byteValue());
  }
  
  protected Object _greaterThan(final Integer left, final Double right) {
    return ((left).intValue() > (right).doubleValue());
  }
  
  protected Object _greaterThan(final Integer left, final Float right) {
    return ((left).intValue() > (right).floatValue());
  }
  
  protected Object _greaterThan(final Integer left, final Long right) {
    return ((left).intValue() > (right).longValue());
  }
  
  protected Object _greaterThan(final Integer left, final Short right) {
    return ((left).intValue() > (right).shortValue());
  }
  
  protected Object _greaterThan(final Integer left, final Integer right) {
    boolean _greaterThan = (left.compareTo(right) > 0);
    return _greaterThan;
  }
  
  protected Object _modulo(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'%\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _modulo(final Byte left, final Byte right) {
    return ((left).byteValue() % (right).byteValue());
  }
  
  protected Object _modulo(final Byte left, final Double right) {
    return ((left).byteValue() % (right).doubleValue());
  }
  
  protected Object _modulo(final Byte left, final Float right) {
    return ((left).byteValue() % (right).floatValue());
  }
  
  protected Object _modulo(final Byte left, final Long right) {
    return ((left).byteValue() % (right).longValue());
  }
  
  protected Object _modulo(final Byte left, final Short right) {
    return ((left).byteValue() % (right).shortValue());
  }
  
  protected Object _modulo(final Byte left, final Integer right) {
    return ((left).byteValue() % (right).intValue());
  }
  
  protected Object _modulo(final Double left, final Byte right) {
    return ((left).doubleValue() % (right).byteValue());
  }
  
  protected Object _modulo(final Double left, final Double right) {
    return ((left).doubleValue() % (right).doubleValue());
  }
  
  protected Object _modulo(final Double left, final Float right) {
    return ((left).doubleValue() % (right).floatValue());
  }
  
  protected Object _modulo(final Double left, final Long right) {
    return ((left).doubleValue() % (right).longValue());
  }
  
  protected Object _modulo(final Double left, final Short right) {
    return ((left).doubleValue() % (right).shortValue());
  }
  
  protected Object _modulo(final Double left, final Integer right) {
    return ((left).doubleValue() % (right).intValue());
  }
  
  protected Object _modulo(final Float left, final Byte right) {
    return ((left).floatValue() % (right).byteValue());
  }
  
  protected Object _modulo(final Float left, final Double right) {
    return ((left).floatValue() % (right).doubleValue());
  }
  
  protected Object _modulo(final Float left, final Float right) {
    return ((left).floatValue() % (right).floatValue());
  }
  
  protected Object _modulo(final Float left, final Long right) {
    return ((left).floatValue() % (right).longValue());
  }
  
  protected Object _modulo(final Float left, final Short right) {
    return ((left).floatValue() % (right).shortValue());
  }
  
  protected Object _modulo(final Float left, final Integer right) {
    return ((left).floatValue() % (right).intValue());
  }
  
  protected Object _modulo(final Long left, final Byte right) {
    return ((left).longValue() % (right).byteValue());
  }
  
  protected Object _modulo(final Long left, final Double right) {
    return ((left).longValue() % (right).doubleValue());
  }
  
  protected Object _modulo(final Long left, final Float right) {
    return ((left).longValue() % (right).floatValue());
  }
  
  protected Object _modulo(final Long left, final Long right) {
    return ((left).longValue() % (right).longValue());
  }
  
  protected Object _modulo(final Long left, final Short right) {
    return ((left).longValue() % (right).shortValue());
  }
  
  protected Object _modulo(final Long left, final Integer right) {
    return ((left).longValue() % (right).intValue());
  }
  
  protected Object _modulo(final Short left, final Byte right) {
    return ((left).shortValue() % (right).byteValue());
  }
  
  protected Object _modulo(final Short left, final Double right) {
    return ((left).shortValue() % (right).doubleValue());
  }
  
  protected Object _modulo(final Short left, final Float right) {
    return ((left).shortValue() % (right).floatValue());
  }
  
  protected Object _modulo(final Short left, final Long right) {
    return ((left).shortValue() % (right).longValue());
  }
  
  protected Object _modulo(final Short left, final Short right) {
    return ((left).shortValue() % (right).shortValue());
  }
  
  protected Object _modulo(final Short left, final Integer right) {
    return ((left).shortValue() % (right).intValue());
  }
  
  protected Object _modulo(final Integer left, final Byte right) {
    return ((left).intValue() % (right).byteValue());
  }
  
  protected Object _modulo(final Integer left, final Double right) {
    return ((left).intValue() % (right).doubleValue());
  }
  
  protected Object _modulo(final Integer left, final Float right) {
    return ((left).intValue() % (right).floatValue());
  }
  
  protected Object _modulo(final Integer left, final Long right) {
    return ((left).intValue() % (right).longValue());
  }
  
  protected Object _modulo(final Integer left, final Short right) {
    return ((left).intValue() % (right).shortValue());
  }
  
  protected Object _modulo(final Integer left, final Integer right) {
    return ((left).intValue() % (right).intValue());
  }
  
  protected Object _multiply(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'*\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _multiply(final Byte left, final Byte right) {
    return ((left).byteValue() * (right).byteValue());
  }
  
  protected Object _multiply(final Byte left, final Double right) {
    return ((left).byteValue() * (right).doubleValue());
  }
  
  protected Object _multiply(final Byte left, final Float right) {
    return ((left).byteValue() * (right).floatValue());
  }
  
  protected Object _multiply(final Byte left, final Long right) {
    return ((left).byteValue() * (right).longValue());
  }
  
  protected Object _multiply(final Byte left, final Short right) {
    return ((left).byteValue() * (right).shortValue());
  }
  
  protected Object _multiply(final Byte left, final Integer right) {
    return ((left).byteValue() * (right).intValue());
  }
  
  protected Object _multiply(final Double left, final Byte right) {
    double _multiply = DoubleExtensions.operator_multiply(left, right);
    return _multiply;
  }
  
  protected Object _multiply(final Double left, final Double right) {
    double _multiply = DoubleExtensions.operator_multiply(left, right);
    return _multiply;
  }
  
  protected Object _multiply(final Double left, final Float right) {
    double _multiply = DoubleExtensions.operator_multiply(left, right);
    return _multiply;
  }
  
  protected Object _multiply(final Double left, final Long right) {
    double _multiply = DoubleExtensions.operator_multiply(left, right);
    return _multiply;
  }
  
  protected Object _multiply(final Double left, final Short right) {
    double _multiply = DoubleExtensions.operator_multiply(left, right);
    return _multiply;
  }
  
  protected Object _multiply(final Double left, final Integer right) {
    double _multiply = DoubleExtensions.operator_multiply(left, right);
    return _multiply;
  }
  
  protected Object _multiply(final Float left, final Byte right) {
    return ((left).floatValue() * (right).byteValue());
  }
  
  protected Object _multiply(final Float left, final Double right) {
    return ((left).floatValue() * (right).doubleValue());
  }
  
  protected Object _multiply(final Float left, final Float right) {
    return ((left).floatValue() * (right).floatValue());
  }
  
  protected Object _multiply(final Float left, final Long right) {
    return ((left).floatValue() * (right).longValue());
  }
  
  protected Object _multiply(final Float left, final Short right) {
    return ((left).floatValue() * (right).shortValue());
  }
  
  protected Object _multiply(final Float left, final Integer right) {
    return ((left).floatValue() * (right).intValue());
  }
  
  protected Object _multiply(final Long left, final Byte right) {
    return ((left).longValue() * (right).byteValue());
  }
  
  protected Object _multiply(final Long left, final Double right) {
    return ((left).longValue() * (right).doubleValue());
  }
  
  protected Object _multiply(final Long left, final Float right) {
    return ((left).longValue() * (right).floatValue());
  }
  
  protected Object _multiply(final Long left, final Long right) {
    return ((left).longValue() * (right).longValue());
  }
  
  protected Object _multiply(final Long left, final Short right) {
    return ((left).longValue() * (right).shortValue());
  }
  
  protected Object _multiply(final Long left, final Integer right) {
    return ((left).longValue() * (right).intValue());
  }
  
  protected Object _multiply(final Short left, final Byte right) {
    return ((left).shortValue() * (right).byteValue());
  }
  
  protected Object _multiply(final Short left, final Double right) {
    return ((left).shortValue() * (right).doubleValue());
  }
  
  protected Object _multiply(final Short left, final Float right) {
    return ((left).shortValue() * (right).floatValue());
  }
  
  protected Object _multiply(final Short left, final Long right) {
    return ((left).shortValue() * (right).longValue());
  }
  
  protected Object _multiply(final Short left, final Short right) {
    return ((left).shortValue() * (right).shortValue());
  }
  
  protected Object _multiply(final Short left, final Integer right) {
    return ((left).shortValue() * (right).intValue());
  }
  
  protected Object _multiply(final Integer left, final Byte right) {
    return ((left).intValue() * (right).byteValue());
  }
  
  protected Object _multiply(final Integer left, final Double right) {
    return ((left).intValue() * (right).doubleValue());
  }
  
  protected Object _multiply(final Integer left, final Float right) {
    return ((left).intValue() * (right).floatValue());
  }
  
  protected Object _multiply(final Integer left, final Long right) {
    return ((left).intValue() * (right).longValue());
  }
  
  protected Object _multiply(final Integer left, final Short right) {
    return ((left).intValue() * (right).shortValue());
  }
  
  protected Object _multiply(final Integer left, final Integer right) {
    return ((left).intValue() * (right).intValue());
  }
  
  protected Object _divide(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'/\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _divide(final Byte left, final Byte right) {
    return ((left).byteValue() / (right).byteValue());
  }
  
  protected Object _divide(final Byte left, final Double right) {
    return ((left).byteValue() / (right).doubleValue());
  }
  
  protected Object _divide(final Byte left, final Float right) {
    return ((left).byteValue() / (right).floatValue());
  }
  
  protected Object _divide(final Byte left, final Long right) {
    return ((left).byteValue() / (right).longValue());
  }
  
  protected Object _divide(final Byte left, final Short right) {
    return ((left).byteValue() / (right).shortValue());
  }
  
  protected Object _divide(final Byte left, final Integer right) {
    return ((left).byteValue() / (right).intValue());
  }
  
  protected Object _divide(final Double left, final Byte right) {
    double _divide = DoubleExtensions.operator_divide(left, right);
    return _divide;
  }
  
  protected Object _divide(final Double left, final Double right) {
    double _divide = DoubleExtensions.operator_divide(left, right);
    return _divide;
  }
  
  protected Object _divide(final Double left, final Float right) {
    double _divide = DoubleExtensions.operator_divide(left, right);
    return _divide;
  }
  
  protected Object _divide(final Double left, final Long right) {
    double _divide = DoubleExtensions.operator_divide(left, right);
    return _divide;
  }
  
  protected Object _divide(final Double left, final Short right) {
    double _divide = DoubleExtensions.operator_divide(left, right);
    return _divide;
  }
  
  protected Object _divide(final Double left, final Integer right) {
    double _divide = DoubleExtensions.operator_divide(left, right);
    return _divide;
  }
  
  protected Object _divide(final Float left, final Byte right) {
    return ((left).floatValue() / (right).byteValue());
  }
  
  protected Object _divide(final Float left, final Double right) {
    return ((left).floatValue() / (right).doubleValue());
  }
  
  protected Object _divide(final Float left, final Float right) {
    return ((left).floatValue() / (right).floatValue());
  }
  
  protected Object _divide(final Float left, final Long right) {
    return ((left).floatValue() / (right).longValue());
  }
  
  protected Object _divide(final Float left, final Short right) {
    return ((left).floatValue() / (right).shortValue());
  }
  
  protected Object _divide(final Float left, final Integer right) {
    return ((left).floatValue() / (right).intValue());
  }
  
  protected Object _divide(final Long left, final Byte right) {
    return ((left).longValue() / (right).byteValue());
  }
  
  protected Object _divide(final Long left, final Double right) {
    return ((left).longValue() / (right).doubleValue());
  }
  
  protected Object _divide(final Long left, final Float right) {
    return ((left).longValue() / (right).floatValue());
  }
  
  protected Object _divide(final Long left, final Long right) {
    return ((left).longValue() / (right).longValue());
  }
  
  protected Object _divide(final Long left, final Short right) {
    return ((left).longValue() / (right).shortValue());
  }
  
  protected Object _divide(final Long left, final Integer right) {
    return ((left).longValue() / (right).intValue());
  }
  
  protected Object _divide(final Short left, final Byte right) {
    return ((left).shortValue() / (right).byteValue());
  }
  
  protected Object _divide(final Short left, final Double right) {
    return ((left).shortValue() / (right).doubleValue());
  }
  
  protected Object _divide(final Short left, final Float right) {
    return ((left).shortValue() / (right).floatValue());
  }
  
  protected Object _divide(final Short left, final Long right) {
    return ((left).shortValue() / (right).longValue());
  }
  
  protected Object _divide(final Short left, final Short right) {
    return ((left).shortValue() / (right).shortValue());
  }
  
  protected Object _divide(final Short left, final Integer right) {
    return ((left).shortValue() / (right).intValue());
  }
  
  protected Object _divide(final Integer left, final Byte right) {
    return ((left).intValue() / (right).byteValue());
  }
  
  protected Object _divide(final Integer left, final Double right) {
    return ((left).intValue() / (right).doubleValue());
  }
  
  protected Object _divide(final Integer left, final Float right) {
    return ((left).intValue() / (right).floatValue());
  }
  
  protected Object _divide(final Integer left, final Long right) {
    return ((left).intValue() / (right).longValue());
  }
  
  protected Object _divide(final Integer left, final Short right) {
    return ((left).intValue() / (right).shortValue());
  }
  
  protected Object _divide(final Integer left, final Integer right) {
    return ((left).intValue() / (right).intValue());
  }
  
  protected Object _same(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'==\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _same(final Byte left, final Byte right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Byte left, final Double right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Byte left, final Float right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Byte left, final Long right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Byte left, final Short right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Byte left, final Integer right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Double left, final Byte right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Double left, final Double right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Double left, final Float right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Double left, final Long right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Double left, final Short right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Double left, final Integer right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Float left, final Byte right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Float left, final Double right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Float left, final Float right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Float left, final Long right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Float left, final Short right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Float left, final Integer right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Long left, final Byte right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Long left, final Double right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Long left, final Float right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Long left, final Long right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Long left, final Short right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Long left, final Integer right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Short left, final Byte right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Short left, final Double right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Short left, final Float right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Short left, final Long right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Short left, final Short right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Short left, final Integer right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Integer left, final Byte right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Integer left, final Double right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Integer left, final Float right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Integer left, final Long right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Integer left, final Short right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _same(final Integer left, final Integer right) {
    boolean _equals = Objects.equal(left, right);
    return _equals;
  }
  
  protected Object _lessEquals(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'<=\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _lessEquals(final Byte left, final Byte right) {
    boolean _lessEqualsThan = (left.compareTo(right) <= 0);
    return _lessEqualsThan;
  }
  
  protected Object _lessEquals(final Byte left, final Double right) {
    return ((left).byteValue() <= (right).doubleValue());
  }
  
  protected Object _lessEquals(final Byte left, final Float right) {
    return ((left).byteValue() <= (right).floatValue());
  }
  
  protected Object _lessEquals(final Byte left, final Long right) {
    return ((left).byteValue() <= (right).longValue());
  }
  
  protected Object _lessEquals(final Byte left, final Short right) {
    return ((left).byteValue() <= (right).shortValue());
  }
  
  protected Object _lessEquals(final Byte left, final Integer right) {
    return ((left).byteValue() <= (right).intValue());
  }
  
  protected Object _lessEquals(final Double left, final Byte right) {
    return ((left).doubleValue() <= (right).byteValue());
  }
  
  protected Object _lessEquals(final Double left, final Double right) {
    boolean _lessEqualsThan = (left.compareTo(right) <= 0);
    return _lessEqualsThan;
  }
  
  protected Object _lessEquals(final Double left, final Float right) {
    return ((left).doubleValue() <= (right).floatValue());
  }
  
  protected Object _lessEquals(final Double left, final Long right) {
    return ((left).doubleValue() <= (right).longValue());
  }
  
  protected Object _lessEquals(final Double left, final Short right) {
    return ((left).doubleValue() <= (right).shortValue());
  }
  
  protected Object _lessEquals(final Double left, final Integer right) {
    return ((left).doubleValue() <= (right).intValue());
  }
  
  protected Object _lessEquals(final Float left, final Byte right) {
    return ((left).floatValue() <= (right).byteValue());
  }
  
  protected Object _lessEquals(final Float left, final Double right) {
    return ((left).floatValue() <= (right).doubleValue());
  }
  
  protected Object _lessEquals(final Float left, final Float right) {
    boolean _lessEqualsThan = (left.compareTo(right) <= 0);
    return _lessEqualsThan;
  }
  
  protected Object _lessEquals(final Float left, final Long right) {
    return ((left).floatValue() <= (right).longValue());
  }
  
  protected Object _lessEquals(final Float left, final Short right) {
    return ((left).floatValue() <= (right).shortValue());
  }
  
  protected Object _lessEquals(final Float left, final Integer right) {
    return ((left).floatValue() <= (right).intValue());
  }
  
  protected Object _lessEquals(final Long left, final Byte right) {
    return ((left).longValue() <= (right).byteValue());
  }
  
  protected Object _lessEquals(final Long left, final Double right) {
    return ((left).longValue() <= (right).doubleValue());
  }
  
  protected Object _lessEquals(final Long left, final Float right) {
    return ((left).longValue() <= (right).floatValue());
  }
  
  protected Object _lessEquals(final Long left, final Long right) {
    boolean _lessEqualsThan = (left.compareTo(right) <= 0);
    return _lessEqualsThan;
  }
  
  protected Object _lessEquals(final Long left, final Short right) {
    return ((left).longValue() <= (right).shortValue());
  }
  
  protected Object _lessEquals(final Long left, final Integer right) {
    return ((left).longValue() <= (right).intValue());
  }
  
  protected Object _lessEquals(final Short left, final Byte right) {
    return ((left).shortValue() <= (right).byteValue());
  }
  
  protected Object _lessEquals(final Short left, final Double right) {
    return ((left).shortValue() <= (right).doubleValue());
  }
  
  protected Object _lessEquals(final Short left, final Float right) {
    return ((left).shortValue() <= (right).floatValue());
  }
  
  protected Object _lessEquals(final Short left, final Long right) {
    return ((left).shortValue() <= (right).longValue());
  }
  
  protected Object _lessEquals(final Short left, final Short right) {
    boolean _lessEqualsThan = (left.compareTo(right) <= 0);
    return _lessEqualsThan;
  }
  
  protected Object _lessEquals(final Short left, final Integer right) {
    return ((left).shortValue() <= (right).intValue());
  }
  
  protected Object _lessEquals(final Integer left, final Byte right) {
    return ((left).intValue() <= (right).byteValue());
  }
  
  protected Object _lessEquals(final Integer left, final Double right) {
    return ((left).intValue() <= (right).doubleValue());
  }
  
  protected Object _lessEquals(final Integer left, final Float right) {
    return ((left).intValue() <= (right).floatValue());
  }
  
  protected Object _lessEquals(final Integer left, final Long right) {
    return ((left).intValue() <= (right).longValue());
  }
  
  protected Object _lessEquals(final Integer left, final Short right) {
    return ((left).intValue() <= (right).shortValue());
  }
  
  protected Object _lessEquals(final Integer left, final Integer right) {
    boolean _lessEqualsThan = (left.compareTo(right) <= 0);
    return _lessEqualsThan;
  }
  
  protected Object _greaterEquals(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'>=\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _greaterEquals(final Byte left, final Byte right) {
    boolean _greaterEqualsThan = (left.compareTo(right) >= 0);
    return _greaterEqualsThan;
  }
  
  protected Object _greaterEquals(final Byte left, final Double right) {
    return ((left).byteValue() >= (right).doubleValue());
  }
  
  protected Object _greaterEquals(final Byte left, final Float right) {
    return ((left).byteValue() >= (right).floatValue());
  }
  
  protected Object _greaterEquals(final Byte left, final Long right) {
    return ((left).byteValue() >= (right).longValue());
  }
  
  protected Object _greaterEquals(final Byte left, final Short right) {
    return ((left).byteValue() >= (right).shortValue());
  }
  
  protected Object _greaterEquals(final Byte left, final Integer right) {
    return ((left).byteValue() >= (right).intValue());
  }
  
  protected Object _greaterEquals(final Double left, final Byte right) {
    return ((left).doubleValue() >= (right).byteValue());
  }
  
  protected Object _greaterEquals(final Double left, final Double right) {
    boolean _greaterEqualsThan = (left.compareTo(right) >= 0);
    return _greaterEqualsThan;
  }
  
  protected Object _greaterEquals(final Double left, final Float right) {
    return ((left).doubleValue() >= (right).floatValue());
  }
  
  protected Object _greaterEquals(final Double left, final Long right) {
    return ((left).doubleValue() >= (right).longValue());
  }
  
  protected Object _greaterEquals(final Double left, final Short right) {
    return ((left).doubleValue() >= (right).shortValue());
  }
  
  protected Object _greaterEquals(final Double left, final Integer right) {
    return ((left).doubleValue() >= (right).intValue());
  }
  
  protected Object _greaterEquals(final Float left, final Byte right) {
    return ((left).floatValue() >= (right).byteValue());
  }
  
  protected Object _greaterEquals(final Float left, final Double right) {
    return ((left).floatValue() >= (right).doubleValue());
  }
  
  protected Object _greaterEquals(final Float left, final Float right) {
    boolean _greaterEqualsThan = (left.compareTo(right) >= 0);
    return _greaterEqualsThan;
  }
  
  protected Object _greaterEquals(final Float left, final Long right) {
    return ((left).floatValue() >= (right).longValue());
  }
  
  protected Object _greaterEquals(final Float left, final Short right) {
    return ((left).floatValue() >= (right).shortValue());
  }
  
  protected Object _greaterEquals(final Float left, final Integer right) {
    return ((left).floatValue() >= (right).intValue());
  }
  
  protected Object _greaterEquals(final Long left, final Byte right) {
    return ((left).longValue() >= (right).byteValue());
  }
  
  protected Object _greaterEquals(final Long left, final Double right) {
    return ((left).longValue() >= (right).doubleValue());
  }
  
  protected Object _greaterEquals(final Long left, final Float right) {
    return ((left).longValue() >= (right).floatValue());
  }
  
  protected Object _greaterEquals(final Long left, final Long right) {
    boolean _greaterEqualsThan = (left.compareTo(right) >= 0);
    return _greaterEqualsThan;
  }
  
  protected Object _greaterEquals(final Long left, final Short right) {
    return ((left).longValue() >= (right).shortValue());
  }
  
  protected Object _greaterEquals(final Long left, final Integer right) {
    return ((left).longValue() >= (right).intValue());
  }
  
  protected Object _greaterEquals(final Short left, final Byte right) {
    return ((left).shortValue() >= (right).byteValue());
  }
  
  protected Object _greaterEquals(final Short left, final Double right) {
    return ((left).shortValue() >= (right).doubleValue());
  }
  
  protected Object _greaterEquals(final Short left, final Float right) {
    return ((left).shortValue() >= (right).floatValue());
  }
  
  protected Object _greaterEquals(final Short left, final Long right) {
    return ((left).shortValue() >= (right).longValue());
  }
  
  protected Object _greaterEquals(final Short left, final Short right) {
    boolean _greaterEqualsThan = (left.compareTo(right) >= 0);
    return _greaterEqualsThan;
  }
  
  protected Object _greaterEquals(final Short left, final Integer right) {
    return ((left).shortValue() >= (right).intValue());
  }
  
  protected Object _greaterEquals(final Integer left, final Byte right) {
    return ((left).intValue() >= (right).byteValue());
  }
  
  protected Object _greaterEquals(final Integer left, final Double right) {
    return ((left).intValue() >= (right).doubleValue());
  }
  
  protected Object _greaterEquals(final Integer left, final Float right) {
    return ((left).intValue() >= (right).floatValue());
  }
  
  protected Object _greaterEquals(final Integer left, final Long right) {
    return ((left).intValue() >= (right).longValue());
  }
  
  protected Object _greaterEquals(final Integer left, final Short right) {
    return ((left).intValue() >= (right).shortValue());
  }
  
  protected Object _greaterEquals(final Integer left, final Integer right) {
    boolean _greaterEqualsThan = (left.compareTo(right) >= 0);
    return _greaterEqualsThan;
  }
  
  protected Object _notSame(final Object left, final Object right) {
    ConstantExpressionEvaluationException _constantExpressionEvaluationException = new ConstantExpressionEvaluationException(((("Unsupported operator \'!=\' for operands " + left) + " and ") + right));
    throw _constantExpressionEvaluationException;
  }
  
  protected Object _notSame(final Byte left, final Byte right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Byte left, final Double right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Byte left, final Float right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Byte left, final Long right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Byte left, final Short right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Byte left, final Integer right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Double left, final Byte right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Double left, final Double right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Double left, final Float right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Double left, final Long right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Double left, final Short right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Double left, final Integer right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Float left, final Byte right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Float left, final Double right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Float left, final Float right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Float left, final Long right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Float left, final Short right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Float left, final Integer right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Long left, final Byte right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Long left, final Double right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Long left, final Float right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Long left, final Long right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Long left, final Short right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Long left, final Integer right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Short left, final Byte right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Short left, final Double right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Short left, final Float right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Short left, final Long right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Short left, final Short right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Short left, final Integer right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Integer left, final Byte right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Integer left, final Double right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Integer left, final Float right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Integer left, final Long right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Integer left, final Short right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
  }
  
  protected Object _notSame(final Integer left, final Integer right) {
    boolean _notEquals = (!Objects.equal(left, right));
    return _notEquals;
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
  
  public Object lessThan(final Object left, final Object right) {
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
  
  public Object greaterThan(final Object left, final Object right) {
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
  
  public Object same(final Object left, final Object right) {
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
  
  public Object lessEquals(final Object left, final Object right) {
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
  
  public Object greaterEquals(final Object left, final Object right) {
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
  
  public Object notSame(final Object left, final Object right) {
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
