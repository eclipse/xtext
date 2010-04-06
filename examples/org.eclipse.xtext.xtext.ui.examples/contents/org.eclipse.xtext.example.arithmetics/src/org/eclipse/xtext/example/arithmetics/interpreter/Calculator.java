/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtext.example.arithmetics.interpreter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

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
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * an interpreter for instances of EClasses of the {@link ArithmeticsPackage}.
 * 
 * It internally uses a polymorphic dispatcher to dispatch between the implementations for the different EClasses.
 * 
 * @author Sven Efftinge - initial contribution and API
 */
public class Calculator {
	
	private PolymorphicDispatcher<BigDecimal> dispatcher = PolymorphicDispatcher.createForSingleTarget("internalEvaluate", 2, 2, this);
	
	public BigDecimal evaluate(Expression obj) {
		return evaluate(obj, ImmutableMap.<String,BigDecimal>of());
	}
	
	public BigDecimal evaluate(Expression obj, ImmutableMap<String,BigDecimal> values) {
		BigDecimal invoke = dispatcher.invoke(obj, values);
		return invoke;
	}
	
	protected BigDecimal internalEvaluate(Expression e, ImmutableMap<String,BigDecimal> values) { 
		throw new UnsupportedOperationException(e.toString());
	}
	
	protected BigDecimal internalEvaluate(NumberLiteral e, ImmutableMap<String,BigDecimal> values) { 
		return e.getValue();
	}
	
	protected BigDecimal internalEvaluate(FunctionCall e, ImmutableMap<String,BigDecimal> values) {
		if (e.getFunc() instanceof DeclaredParameter) {
			return values.get(e.getFunc().getName());
		} 
		Definition d = (Definition) e.getFunc();
		Map<String,BigDecimal> params = Maps.newHashMap();
		for (int i=0; i<e.getArgs().size();i++) {
			DeclaredParameter declaredParameter = d.getArgs().get(i);
			BigDecimal evaluate = evaluate(e.getArgs().get(i), values);
			params.put(declaredParameter.getName(), evaluate);
		}
		return evaluate(d.getExpr(),ImmutableMap.copyOf(params));
	}
	
	protected BigDecimal internalEvaluate(Plus plus, ImmutableMap<String,BigDecimal> values) {
		return evaluate(plus.getLeft(),values).add(evaluate(plus.getRight(),values));
	}
	protected BigDecimal internalEvaluate(Minus minus, ImmutableMap<String,BigDecimal> values) {
		return evaluate(minus.getLeft(),values).subtract(evaluate(minus.getRight(),values));
	}
	protected BigDecimal internalEvaluate(Div div, ImmutableMap<String,BigDecimal> values) {
		BigDecimal left = evaluate(div.getLeft(),values);
		BigDecimal right = evaluate(div.getRight(),values);
		return left.divide(right,20,RoundingMode.HALF_UP);
	}
	protected BigDecimal internalEvaluate(Multi multi, ImmutableMap<String,BigDecimal> values) {
		return evaluate(multi.getLeft(),values).multiply(evaluate(multi.getRight(),values));
	}
	
}
