/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.util;

import static org.eclipse.xtext.xbase.XbasePackage.*;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XExpressionHelper {
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Inject
	private XbaseTypeConformanceComputer conformanceComputer;
	
	@Inject
	private TypeReferences typeReferences;

	public boolean isLiteral(XExpression expr) {
		if (expr.eClass().getEPackage() != XbasePackage.eINSTANCE)
			return false;
		switch(expr.eClass().getClassifierID()) {
			case XCLOSURE:
			case XBOOLEAN_LITERAL:
			case XINT_LITERAL:
			case XNULL_LITERAL:
			case XSTRING_LITERAL:
			case XTYPE_LITERAL:
				return true;
			default: 
				return false;
		}
	}
	
	public String getAndOperator() {
		return "&&";
	}
	
	public String getOrOperator() {
		return "||";
	}
	
	public boolean isShortCircuiteBooleanOperation(XAbstractFeatureCall featureCall) {
		if (featureCall instanceof XBinaryOperation) {
			XExpression leftOperand = ((XBinaryOperation) featureCall).getLeftOperand();
			final String op = featureCall.getConcreteSyntaxFeatureName();
			if (getAndOperator().equals(op) 
				|| getOrOperator().equals(op)) {
				JvmTypeReference booleanType = typeReferences.getTypeForName(Boolean.TYPE, leftOperand);
				JvmTypeReference leftOperandType = typeProvider.getType(leftOperand);
				JvmTypeReference operationReturnType = typeProvider.getType(featureCall);
				return (conformanceComputer.isConformant(booleanType, leftOperandType)
					&& conformanceComputer.isConformant(booleanType, operationReturnType));
			}
		}
		return false;
	}
}
