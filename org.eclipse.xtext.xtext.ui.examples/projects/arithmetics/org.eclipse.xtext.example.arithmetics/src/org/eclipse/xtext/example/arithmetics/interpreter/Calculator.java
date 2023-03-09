/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.arithmetics.interpreter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;

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

import com.google.common.collect.ImmutableMap;

/**
 * an interpreter for instances of EClasses of the {@link ArithmeticsPackage}.
 * It internally uses a polymorphic dispatcher to dispatch between the
 * implementations for the different EClasses.
 */
public class Calculator {
	public BigDecimal evaluate(Expression obj) {
		return evaluate(obj, ImmutableMap.of());
	}

	public BigDecimal evaluate(Expression obj, ImmutableMap<String, BigDecimal> values) {
		return internalEvaluate(obj, values);
	}

	protected BigDecimal internalEvaluate(Expression expr, ImmutableMap<String, BigDecimal> values) {
		if (expr instanceof Div) {
			Div div = (Div) expr;
			return evaluate(div.getLeft(), values).divide(evaluate(div.getRight(), values), 20, RoundingMode.HALF_UP);
		} else if (expr instanceof FunctionCall) {
			FunctionCall e = (FunctionCall) expr;
			if (e.getFunc() instanceof DeclaredParameter) {
				return values.get(e.getFunc().getName());
			}
			AbstractDefinition d = e.getFunc();
			if (d instanceof Definition) {
				HashMap<String, BigDecimal> params = new HashMap<>();
				for (int i = 0; i < e.getArgs().size(); i++) {
					DeclaredParameter declaredParameter = ((Definition) d).getArgs().get(i);
					BigDecimal evaluate = evaluate(e.getArgs().get(i), values);
					params.put(declaredParameter.getName(), evaluate);
				}
				return evaluate(((Definition) d).getExpr(), ImmutableMap.copyOf(params));
			}
			return null;
		} else if (expr instanceof Plus) {
			Plus plus = (Plus) expr;
			return evaluate(plus.getLeft(), values).add(evaluate(plus.getRight(), values));
		} else if (expr instanceof Minus) {
			Minus minus = (Minus) expr;
			return evaluate(minus.getLeft(), values).subtract(evaluate(minus.getRight(), values));
		} else if (expr instanceof Multi) {
			Multi multi = (Multi) expr;
			return evaluate(multi.getLeft(), values).multiply(evaluate(multi.getRight(), values));
		} else if (expr instanceof NumberLiteral) {
			NumberLiteral numberLiteral = (NumberLiteral) expr;
			return numberLiteral.getValue();
		} else {
			throw new IllegalArgumentException("Unhandled parameter types: " + Arrays.asList(expr, values).toString());
		}
	}
}
