/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.util;

import static org.eclipse.xtext.util.Strings.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.ByteExtensions;
import org.eclipse.xtext.xbase.lib.CharacterExtensions;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.FloatExtensions;
import org.eclipse.xtext.xbase.lib.Inline;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.LongExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.ReassignFirstArgument;
import org.eclipse.xtext.xbase.lib.ShortExtensions;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XExpressionHelper {

	@Inject
	private TypeReferences typeReferences;
	
	@Inject 
	private OperatorMapping operatorMapping; 

	/**
	 * @return whether the expression itself (not its children) possibly causes a side-effect
	 */
	public boolean hasSideEffects(XExpression expr) {
		if (expr instanceof XClosure
			|| expr instanceof XStringLiteral
			|| expr instanceof XTypeLiteral
			|| expr instanceof XBooleanLiteral
			|| expr instanceof XNumberLiteral
			|| expr instanceof XNullLiteral
			|| expr instanceof XAnnotation
			)
			return false;
		if(expr instanceof XCollectionLiteral) {
			for(XExpression element: ((XCollectionLiteral)expr).getElements()) {
				if(hasSideEffects(element))
					return true;
			}
			return false;
		}
		if (expr instanceof XAbstractFeatureCall) {
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) expr;
			return hasSideEffects(featureCall, true);
		}
		if (expr instanceof XConstructorCall) {
			XConstructorCall constrCall = (XConstructorCall) expr;
			return findPureAnnotation(constrCall.getConstructor()) == null;
		}
		return true;
	}

	public boolean hasSideEffects(XAbstractFeatureCall featureCall, boolean inspectContents) {
		if (featureCall instanceof XBinaryOperation) {
			XBinaryOperation binaryOperation = (XBinaryOperation) featureCall;
			if (binaryOperation.isReassignFirstArgument()) {
				return true;
			}
		}
		if (featureCall instanceof XAssignment) {
			return true;
		}
		if (featureCall.isPackageFragment() || featureCall.isTypeLiteral()) {
			return false;
		}
		final JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature == null || feature.eIsProxy())
			return true; // linking problems ... could be anything
		if (feature instanceof JvmConstructor) { //super() and this()
			return true;
		}
		if (feature instanceof JvmOperation) {
			JvmOperation jvmOperation = (JvmOperation) feature;
			if (findPureAnnotation(jvmOperation) == null) {
				return true;
			} else {
				if(inspectContents) {
					for (XExpression param : featureCall.getActualArguments()) {
						if (hasSideEffects(param))
							return true;
					}
				}
			}
		}
		return false;
	}
	
	public JvmAnnotationReference findInlineAnnotation(XAbstractFeatureCall featureCall) {
		final JvmIdentifiableElement feature = featureCall.getFeature();
		return findInlineAnnotation(feature);
	}

	public JvmAnnotationReference findInlineAnnotation(final JvmIdentifiableElement feature) {
		if (feature instanceof JvmAnnotationTarget) {
			return findAnnotation((JvmAnnotationTarget) feature, Inline.class.getName());
		}
		return null;
	}
	
	public JvmAnnotationReference findCompoundAssignmentAnnotation(XAbstractFeatureCall featureCall) {
		final JvmIdentifiableElement feature = featureCall.getFeature();
		return findReassignFirstArgumentAnnotation(feature);
	}

	public JvmAnnotationReference findReassignFirstArgumentAnnotation(JvmIdentifiableElement feature) {
		if (feature instanceof JvmAnnotationTarget) {
			return findAnnotation((JvmAnnotationTarget) feature, ReassignFirstArgument.class.getName());
		}
		return null;
	}
	
	public JvmAnnotationReference findPureAnnotation(JvmExecutable featureCall) {
		return findAnnotation(featureCall, Pure.class.getName());
	}
	
	protected JvmAnnotationReference findAnnotation(JvmAnnotationTarget feature, String annotationType) {
		if (feature == null)
			return null;
		if (annotationType == null)
			throw new NullPointerException();
		List<JvmAnnotationReference> annotations = feature.getAnnotations();
		for (JvmAnnotationReference annotation : annotations) {
			if (annotationType.equals(annotation.getAnnotation().getQualifiedName())) {
				return annotation;
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

	public String getElvisOperator() {
		return "?:";
	}
	
	public boolean isGetAndAssign(XAbstractFeatureCall featureCall) {
		if (!(featureCall instanceof XPostfixOperation)) {
			return false;
		}
		if (isOperatorFromExtension(featureCall, OperatorMapping.MINUS_MINUS, DoubleExtensions.class)) {
			return true;
		}
		if (isOperatorFromExtension(featureCall, OperatorMapping.PLUS_PLUS, DoubleExtensions.class)) {
			return true;
		}
		if (isOperatorFromExtension(featureCall, OperatorMapping.MINUS_MINUS, FloatExtensions.class)) {
			return true;
		}
		if (isOperatorFromExtension(featureCall, OperatorMapping.PLUS_PLUS, FloatExtensions.class)) {
			return true;
		}
		if (isOperatorFromExtension(featureCall, OperatorMapping.MINUS_MINUS, LongExtensions.class)) {
			return true;
		}
		if (isOperatorFromExtension(featureCall, OperatorMapping.PLUS_PLUS, LongExtensions.class)) {
			return true;
		}
		if (isOperatorFromExtension(featureCall, OperatorMapping.MINUS_MINUS, IntegerExtensions.class)) {
			return true;
		}
		if (isOperatorFromExtension(featureCall, OperatorMapping.PLUS_PLUS, IntegerExtensions.class)) {
			return true;
		}
		if (isOperatorFromExtension(featureCall, OperatorMapping.MINUS_MINUS, ShortExtensions.class)) {
			return true;
		}
		if (isOperatorFromExtension(featureCall, OperatorMapping.PLUS_PLUS, ShortExtensions.class)) {
			return true;
		}
		if (isOperatorFromExtension(featureCall, OperatorMapping.MINUS_MINUS, CharacterExtensions.class)) {
			return true;
		}
		if (isOperatorFromExtension(featureCall, OperatorMapping.PLUS_PLUS, CharacterExtensions.class)) {
			return true;
		}
		if (isOperatorFromExtension(featureCall, OperatorMapping.MINUS_MINUS, ByteExtensions.class)) {
			return true;
		}
		if (isOperatorFromExtension(featureCall, OperatorMapping.PLUS_PLUS, ByteExtensions.class)) {
			return true;
		}
		return false;
	}

	public boolean isShortCircuitOperation(XAbstractFeatureCall featureCall) {
		if (featureCall instanceof XBinaryOperation) {
			if (isOperatorFromExtension(featureCall, OperatorMapping.ELVIS, ObjectExtensions.class))
				return true;
			else 
				return isBooleanAndOrOr(featureCall);
		}
		return false;
	}

	public boolean isBooleanAndOrOr(XAbstractFeatureCall featureCall) {
		return isOperatorFromExtension(featureCall, OperatorMapping.AND, BooleanExtensions.class) 
			|| isOperatorFromExtension(featureCall, OperatorMapping.OR, BooleanExtensions.class);
	}

	public boolean isOperatorFromExtension(XExpression expression, QualifiedName operatorSymbol, Class<?> definingExtensionClass) {
		return expression instanceof XAbstractFeatureCall && isOperatorFromExtension((XAbstractFeatureCall) expression, operatorSymbol, definingExtensionClass);
	}

	public boolean isOperatorFromExtension(XAbstractFeatureCall featureCall, QualifiedName operatorSymbol, Class<?> definingExtensionClass) {
		return isOperatorFromExtension(featureCall, featureCall.getConcreteSyntaxFeatureName(), operatorSymbol, definingExtensionClass);
	}

	public boolean isOperatorFromExtension(XAbstractFeatureCall featureCall, String concreteSyntax, QualifiedName operatorSymbol, Class<?> definingExtensionClass) {
		if(!equal(concreteSyntax, operatorSymbol.getLastSegment()))
			return false;
		List<QualifiedName> methodNames = getMethodNames(featureCall, operatorSymbol);
		JvmDeclaredType definingJvmType = (JvmDeclaredType) typeReferences.findDeclaredType(definingExtensionClass, featureCall);
		if (definingJvmType == null)
			return false;
		JvmIdentifiableElement feature = featureCall.getFeature();
		if (definingJvmType != feature.eContainer()) {
			return false;
		}
		for (QualifiedName methodName : methodNames) {
			if (methodName.getLastSegment().equals(feature.getSimpleName())) {
				return true;
			}
		}
		return false;
	}
	
	protected List<QualifiedName> getMethodNames(XAbstractFeatureCall featureCall, QualifiedName operatorSymbol) {
		List<QualifiedName> methodNames = new ArrayList<QualifiedName>();
		methodNames.add(operatorMapping.getMethodName(operatorSymbol));
		if (featureCall instanceof XBinaryOperation) {
			XBinaryOperation binaryOperation = (XBinaryOperation) featureCall;
			if (binaryOperation.isReassignFirstArgument()) {
				QualifiedName simpleOperator = operatorMapping.getSimpleOperator(operatorSymbol);
				if (simpleOperator != null) {
					methodNames.add(operatorMapping.getMethodName(simpleOperator));
				}
			}
		}
		return methodNames;
	}

	public boolean isInlined(XAbstractFeatureCall call) {
		return findInlineAnnotation(call) != null;
	}
}
