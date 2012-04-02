/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.util;

import static org.eclipse.xtext.xbase.XbasePackage.*;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.internal.Inline;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XExpressionHelper {

	@Inject
	private ITypeProvider typeProvider;

	@Inject
	private TypeConformanceComputer conformanceComputer;

	@Inject
	private TypeReferences typeReferences;

	public boolean isLiteral(XExpression expr) {
		if (expr.eClass().getEPackage() != XbasePackage.eINSTANCE)
			return false;
		switch (expr.eClass().getClassifierID()) {
			case XCLOSURE:
			case XBOOLEAN_LITERAL:
			case XNUMBER_LITERAL:
			case XNULL_LITERAL:
			case XSTRING_LITERAL:
			case XTYPE_LITERAL:
				return true;
			default:
				return false;
		}
	}

	public boolean isFieldOrVariableReference(XExpression expr) {
		if (expr instanceof XFeatureCall) {
			XFeatureCall featureCall = (XFeatureCall) expr;
			final JvmIdentifiableElement feature = featureCall.getFeature();
			if (feature == null || feature.eIsProxy())
				return false;
			if (feature instanceof JvmField
				|| feature instanceof JvmFormalParameter
				|| feature instanceof XVariableDeclaration) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isJavaStatementExpression(XExpression expr) {
			if (expr instanceof XMemberFeatureCall)
				return true;
			if (expr instanceof XAssignment)
				return true;
			if (isLiteral(expr))
				return false;
			if (isFieldOrVariableReference(expr))
				return false;
			if (expr instanceof XBlockExpression) {
				XBlockExpression block = (XBlockExpression) expr;
				XExpression last = IterableExtensions.last(block.getExpressions());
				if (last != null) {
					return isJavaStatementExpression(last);
				}
				return true;
			}
			if (expr instanceof XCastedExpression) {
				return isJavaStatementExpression(((XCastedExpression) expr).getTarget());
			}
			if (expr instanceof XInstanceOfExpression) {
				return false;
			}
			if (expr instanceof XAbstractFeatureCall) {
				XAbstractFeatureCall featureCall = (XAbstractFeatureCall) expr;
				JvmAnnotationReference annotation = findInlineAnnotation(featureCall);
				if (annotation != null) {
					EList<JvmAnnotationValue> values = annotation.getValues();
					for (JvmAnnotationValue value : values) {
						if ("statementExpression".equals(value.getValueName())) {
							JvmBooleanAnnotationValue booleanValue = (JvmBooleanAnnotationValue) value;
							return booleanValue.getValues().get(0);
						}
					}
				}
			}
			return true;
	}

	public JvmAnnotationReference findInlineAnnotation(XAbstractFeatureCall featureCall) {
		JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature instanceof JvmOperation) {
			List<JvmAnnotationReference> annotations = ((JvmOperation) feature).getAnnotations();
			for (JvmAnnotationReference annotation : annotations) {
				if (Inline.class.getName().equals(annotation.getAnnotation().getQualifiedName())) {
					return annotation;
				}
			}
		}
		return null;
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
			if (getAndOperator().equals(op) || getOrOperator().equals(op)) {
				JvmTypeReference booleanType = typeReferences.getTypeForName(Boolean.TYPE, leftOperand);
				JvmTypeReference leftOperandType = typeProvider.getType(leftOperand);
				JvmTypeReference operationReturnType = typeProvider.getType(featureCall);
				return (conformanceComputer.isConformant(booleanType, leftOperandType) && conformanceComputer
						.isConformant(booleanType, operationReturnType));
			}
		}
		return false;
	}

	public boolean isInlined(XAbstractFeatureCall call) {
		return findInlineAnnotation(call) != null;
	}
}
