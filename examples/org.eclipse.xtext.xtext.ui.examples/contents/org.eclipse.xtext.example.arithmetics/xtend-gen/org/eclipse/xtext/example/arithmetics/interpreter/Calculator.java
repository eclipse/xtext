/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.interpreter;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.example.arithmetics.arithmetics.AbstractDefinition;
import org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsPackage;
import org.eclipse.xtext.example.arithmetics.arithmetics.DeclaredParameter;
import org.eclipse.xtext.example.arithmetics.arithmetics.Definition;
import org.eclipse.xtext.example.arithmetics.arithmetics.Div;
import org.eclipse.xtext.example.arithmetics.arithmetics.Expression;
import org.eclipse.xtext.example.arithmetics.arithmetics.FunctionCall;
import org.eclipse.xtext.example.arithmetics.arithmetics.Minus;
import org.eclipse.xtext.example.arithmetics.arithmetics.Multi;
import org.eclipse.xtext.example.arithmetics.arithmetics.NumberLiteral;
import org.eclipse.xtext.example.arithmetics.arithmetics.Plus;

/**
 * an interpreter for instances of EClasses of the {@link ArithmeticsPackage}.
 * It internally uses a polymorphic dispatcher to dispatch between the implementations for the different EClasses.
 */
@SuppressWarnings("all")
public class Calculator {
  public BigDecimal evaluate(final Expression obj) {
    ImmutableMap<String, BigDecimal> _of = ImmutableMap.<String, BigDecimal>of();
    return this.evaluate(obj, _of);
  }
  
  public BigDecimal evaluate(final Expression obj, final ImmutableMap<String, BigDecimal> values) {
    return this.internalEvaluate(obj, values);
  }
  
  protected BigDecimal _internalEvaluate(final NumberLiteral e, final ImmutableMap<String, BigDecimal> values) {
    return e.getValue();
  }
  
  /**
   * @param values the currently known values by name
   */
  protected BigDecimal _internalEvaluate(final FunctionCall e, final ImmutableMap<String, BigDecimal> values) {
    AbstractDefinition _func = e.getFunc();
    if ((_func instanceof DeclaredParameter)) {
      AbstractDefinition _func_1 = e.getFunc();
      String _name = _func_1.getName();
      return values.get(_name);
    }
    AbstractDefinition _func_2 = e.getFunc();
    final AbstractDefinition d = _func_2;
    boolean _matched = false;
    if (!_matched) {
      if (d instanceof Definition) {
        _matched=true;
        HashMap<String, BigDecimal> params = Maps.<String, BigDecimal>newHashMap();
        for (int i = 0; (i < e.getArgs().size()); i++) {
          {
            EList<DeclaredParameter> _args = ((Definition)d).getArgs();
            DeclaredParameter declaredParameter = _args.get(i);
            EList<Expression> _args_1 = e.getArgs();
            Expression _get = _args_1.get(i);
            BigDecimal evaluate = this.evaluate(_get, values);
            String _name_1 = declaredParameter.getName();
            params.put(_name_1, evaluate);
          }
        }
        Expression _expr = ((Definition)d).getExpr();
        ImmutableMap<String, BigDecimal> _copyOf = ImmutableMap.<String, BigDecimal>copyOf(params);
        return this.evaluate(_expr, _copyOf);
      }
    }
    return null;
  }
  
  protected BigDecimal _internalEvaluate(final Plus plus, final ImmutableMap<String, BigDecimal> values) {
    Expression _left = plus.getLeft();
    BigDecimal _evaluate = this.evaluate(_left, values);
    Expression _right = plus.getRight();
    BigDecimal _evaluate_1 = this.evaluate(_right, values);
    return _evaluate.add(_evaluate_1);
  }
  
  protected BigDecimal _internalEvaluate(final Minus minus, final ImmutableMap<String, BigDecimal> values) {
    Expression _left = minus.getLeft();
    BigDecimal _evaluate = this.evaluate(_left, values);
    Expression _right = minus.getRight();
    BigDecimal _evaluate_1 = this.evaluate(_right, values);
    return _evaluate.subtract(_evaluate_1);
  }
  
  protected BigDecimal _internalEvaluate(final Div div, final ImmutableMap<String, BigDecimal> values) {
    Expression _left = div.getLeft();
    BigDecimal _evaluate = this.evaluate(_left, values);
    Expression _right = div.getRight();
    BigDecimal _evaluate_1 = this.evaluate(_right, values);
    return _evaluate.divide(_evaluate_1, 20, RoundingMode.HALF_UP);
  }
  
  protected BigDecimal _internalEvaluate(final Multi multi, final ImmutableMap<String, BigDecimal> values) {
    Expression _left = multi.getLeft();
    BigDecimal _evaluate = this.evaluate(_left, values);
    Expression _right = multi.getRight();
    BigDecimal _evaluate_1 = this.evaluate(_right, values);
    return _evaluate.multiply(_evaluate_1);
  }
  
  protected BigDecimal internalEvaluate(final Expression div, final ImmutableMap<String, BigDecimal> values) {
    if (div instanceof Div) {
      return _internalEvaluate((Div)div, values);
    } else if (div instanceof FunctionCall) {
      return _internalEvaluate((FunctionCall)div, values);
    } else if (div instanceof Minus) {
      return _internalEvaluate((Minus)div, values);
    } else if (div instanceof Multi) {
      return _internalEvaluate((Multi)div, values);
    } else if (div instanceof NumberLiteral) {
      return _internalEvaluate((NumberLiteral)div, values);
    } else if (div instanceof Plus) {
      return _internalEvaluate((Plus)div, values);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(div, values).toString());
    }
  }
}
