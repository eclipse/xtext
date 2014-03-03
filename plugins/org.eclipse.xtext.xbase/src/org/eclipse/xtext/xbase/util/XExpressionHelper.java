/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.util;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
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
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CompoundAssignment;
import org.eclipse.xtext.xbase.lib.Inline;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
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
			if (binaryOperation.isCompoundOperator()) {
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
		if (feature instanceof JvmAnnotationTarget) {
			return findAnnotation((JvmAnnotationTarget) feature, Inline.class.getName());
		}
		return null;
	}
	
	public JvmAnnotationReference findCompoundAssignmentAnnotation(XAbstractFeatureCall featureCall) {
		final JvmIdentifiableElement feature = featureCall.getFeature();
		return findCompoundAssignmentAnnotation(feature);
	}

	public JvmAnnotationReference findCompoundAssignmentAnnotation(JvmIdentifiableElement feature) {
		if (feature instanceof JvmAnnotationTarget) {
			return findAnnotation((JvmAnnotationTarget) feature, CompoundAssignment.class.getName());
		}
		return null;
	}
	
	public JvmAnnotationReference findPureAnnotation(JvmExecutable featureCall) {
		return findAnnotation(featureCall, Pure.class.getName());
	}
	
	protected JvmAnnotationReference findAnnotation(JvmAnnotationTarget feature, String annotationType) {
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

	public boolean isShortCircuitOperation(XAbstractFeatureCall featureCall) {
		if (featureCall instanceof XBinaryOperation) {
			if(isOperatorFromExtension(featureCall, OperatorMapping.ELVIS, ObjectExtensions.class))
				return true;
			else 
				return (isOperatorFromExtension(featureCall, OperatorMapping.AND, BooleanExtensions.class) 
					|| isOperatorFromExtension(featureCall, OperatorMapping.OR, BooleanExtensions.class));
		}
		return false;
	}

	public boolean isOperatorFromExtension(XExpression expression, QualifiedName operatorSymbol, Class<?> definingExtensionClass) {
		return expression instanceof XAbstractFeatureCall && isOperatorFromExtension((XAbstractFeatureCall) expression, operatorSymbol, definingExtensionClass);
	}

	public boolean isOperatorFromExtension(XAbstractFeatureCall featureCall, QualifiedName operatorSymbol, Class<?> definingExtensionClass) {
		if(!equal(featureCall.getConcreteSyntaxFeatureName(), operatorSymbol.getLastSegment()))
			return false;
		List<QualifiedName> methodNames = getMethodNames(featureCall, operatorSymbol);
		for (QualifiedName methodName : methodNames) {
			JvmDeclaredType definingJvmType = (JvmDeclaredType) typeReferences.findDeclaredType(definingExtensionClass, featureCall);
			Iterable<JvmFeature> operatorImplementations = definingJvmType.findAllFeaturesByName(methodName.getLastSegment());
			return contains(operatorImplementations, featureCall.getFeature());
		}
		return false;
	}

	protected List<QualifiedName> getMethodNames(XAbstractFeatureCall featureCall, QualifiedName operatorSymbol) {
		List<QualifiedName> methodNames = new ArrayList<QualifiedName>();
		methodNames.add(operatorMapping.getMethodName(operatorSymbol));
		if (featureCall instanceof XBinaryOperation) {
			XBinaryOperation binaryOperation = (XBinaryOperation) featureCall;
			if (binaryOperation.isCompoundOperator()) {
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
