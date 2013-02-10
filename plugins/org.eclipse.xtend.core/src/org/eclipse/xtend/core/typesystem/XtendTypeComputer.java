/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.typesystem;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringElseIf;
import org.eclipse.xtend.core.xtend.RichStringForLoop;
import org.eclipse.xtend.core.xtend.RichStringIf;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsTypeComputer;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * Customized type computer for Xtend specific expressions.
 * 
 * The template expression and its dedicated child expressions are handled.
 * 
 * TODO: RichStringIf with instanceof cascades should downcast the checked values iff immutable.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class XtendTypeComputer extends XbaseWithAnnotationsTypeComputer {

	@Override
	public void computeTypes(XExpression expression, ITypeComputationState state) {
		if (expression instanceof RichString) {
			_computeTypes((RichString)expression, state);
		} else if (expression instanceof RichStringForLoop) {
			_computeTypes((RichStringForLoop)expression, state);
		} else if (expression instanceof RichStringIf) {
			_computeTypes((RichStringIf)expression, state);
		} else if (expression instanceof RichStringLiteral) {
			_computeTypes((RichStringLiteral)expression, state);
		} else {
			super.computeTypes(expression, state);
		}
	}
	
	protected void _computeTypes(RichString object, ITypeComputationState state) {
		List<XExpression> expressions = object.getExpressions();
		if (!expressions.isEmpty()) {
			for(XExpression expression: expressions) {
				ITypeComputationState expressionState = state.withoutExpectation();
				expressionState.computeTypes(expression);
				if (expression instanceof XVariableDeclaration) {
					state.addLocalToCurrentScope((XVariableDeclaration)expression);
				}
			}
		}
		for(ITypeExpectation expectation: state.getExpectations()) {
			LightweightTypeReference expectedType = expectation.getExpectedType();
			if (expectedType != null && expectedType.isType(String.class)) {
				expectation.acceptActualType(expectedType, ConformanceHint.SUCCESS, ConformanceHint.CHECKED, ConformanceHint.DEMAND_CONVERSION);
				// TODO this special treatment here should become obsolete as soon as the expectations are properly propagated
			} else if (expectedType != null && !expectedType.isResolved() || expectedType == null && !expectation.isVoidTypeAllowed()) {
				LightweightTypeReference type = getTypeForName(String.class, state);
				expectation.acceptActualType(type, ConformanceHint.UNCHECKED, ConformanceHint.DEMAND_CONVERSION);
			} else {
				LightweightTypeReference type = getTypeForName(CharSequence.class, state);
				expectation.acceptActualType(type, ConformanceHint.UNCHECKED);
			}
		}
	}
	
	protected void _computeTypes(RichStringForLoop object, ITypeComputationState state) {
		LightweightTypeReference charSequence = getTypeForName(CharSequence.class, state);
		ITypeComputationState eachState = state.withExpectation(charSequence);
		JvmFormalParameter parameter = object.getDeclaredParam();
		if (parameter != null) {
			LightweightTypeReference parameterType = computeForLoopParameterType(object, state);
			eachState = eachState.assignType(parameter, parameterType);
		}
		eachState.computeTypes(object.getEachExpression());
		
		state.withNonVoidExpectation().computeTypes(object.getBefore());
		state.withNonVoidExpectation().computeTypes(object.getSeparator());
		state.withNonVoidExpectation().computeTypes(object.getAfter());
		
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
		
		state.acceptActualType(charSequence);
	}
	
	protected void _computeTypes(RichStringIf object, ITypeComputationState state) {
		LightweightTypeReference charSequence = getTypeForName(CharSequence.class, state);
		LightweightTypeReference booleanType = getTypeForName(Boolean.TYPE, state);
		
		ITypeComputationState conditionExpectation = state.withExpectation(booleanType);
		conditionExpectation.computeTypes(object.getIf());
		// TODO instanceof may specialize the types in the nested expression
		state.withExpectation(charSequence).computeTypes(object.getThen());
		for(RichStringElseIf elseIf: object.getElseIfs()) {
			state.withExpectation(booleanType).computeTypes(elseIf.getIf());
			state.withExpectation(charSequence).computeTypes(elseIf.getThen());
		}
		state.withExpectation(charSequence).computeTypes(object.getElse());
		state.acceptActualType(charSequence);
	}
	
	protected void _computeTypes(RichStringLiteral object, ITypeComputationState state) {
		LightweightTypeReference type = getTypeForName(CharSequence.class, state);
		state.acceptActualType(type);
	}
	
}
