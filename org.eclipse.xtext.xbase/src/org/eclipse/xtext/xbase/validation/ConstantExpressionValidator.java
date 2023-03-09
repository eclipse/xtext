/**
 * Copyright (c) 2013, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.validation;

import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.util.XExpressionHelper;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * Checks whether a given XExpression is a a constant expression.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class ConstantExpressionValidator {
	@Inject
	private TypeReferences typeReferences;

	@Inject
	private Primitives primitives;

	@Inject
	private XExpressionHelper xExpressionHelper;

	@Inject
	private ILogicalContainerProvider logicalContainerProvider;

	protected boolean _isConstant(XExpression expression) {
		return false;
	}

	protected boolean _isConstant(XStringLiteral expression) {
		return true;
	}

	protected boolean _isConstant(XTypeLiteral expression) {
		return true;
	}

	protected boolean _isConstant(XNumberLiteral expression) {
		return true;
	}

	protected boolean _isConstant(XBooleanLiteral expression) {
		return true;
	}

	protected boolean _isConstant(XCastedExpression expression) {
		return primitives.isPrimitive(expression.getType()) || typeReferences.is(expression.getType(), String.class);
	}

	protected boolean _isConstant(XAbstractFeatureCall expression) {
		JvmIdentifiableElement feature = expression.getFeature();
		if (feature instanceof JvmEnumerationLiteral) {
			return true;
		} else if (feature instanceof JvmField) {
			JvmField jvmField = (JvmField) feature;
			if (jvmField.isSetConstant()) {
				return jvmField.isConstant();
			}
			boolean potentiallyConstant = jvmField.isStatic() && jvmField.isFinal();
			if (potentiallyConstant) {
				if (jvmField.eResource() instanceof TypeResource) {
					return true;
				} else {
					return isConstantExpression(logicalContainerProvider.getAssociatedExpression(feature));
				}
			}
			return false;
		} else if (feature instanceof JvmOperation) {
			JvmAnnotationReference annotationReference = xExpressionHelper.findInlineAnnotation(expression);
			if (annotationReference == null) {
				return false;
			}
			if (IterableExtensions.exists(
					Iterables.filter(annotationReference.getValues(), JvmBooleanAnnotationValue.class),
					(JvmBooleanAnnotationValue it) -> {
						return "constantExpression".equals(it.getValueName())
								&& Iterables.getFirst(it.getValues(), null).booleanValue();
					})) {
				boolean receiverConstant = false;
				if (expression.getActualReceiver() == null) {
					receiverConstant = true;
				} else {
					receiverConstant = isConstant(expression.getActualReceiver());
				}
				return receiverConstant
						&& IterableExtensions.forall(expression.getActualArguments(), it -> isConstant(it));
			}
		} else if (feature instanceof XVariableDeclaration) {
			XVariableDeclaration variableDeclaration = (XVariableDeclaration) feature;
			return !variableDeclaration.isWriteable() && isConstantExpression(variableDeclaration.getRight());
		} else if (feature instanceof XSwitchExpression) {
			return isConstantExpression(((XSwitchExpression) feature).getSwitch());
		} else if (feature instanceof EObject) {
			if (feature.eIsProxy()) {
				throw new NotResolvedFeatureException();
			}
		}
		return false;
	}

	protected boolean _isConstantExpression(Void it) {
		return false;
	}

	protected boolean _isConstantExpression(XExpression it) {
		return isConstant(it);
	}

	protected boolean _isConstantExpression(XAbstractFeatureCall it) {
		if (it.getFeature() instanceof JvmEnumerationLiteral) {
			return false;
		}
		return isConstant(it);
	}

	public boolean isConstant(XExpression expression) {
		if (expression instanceof XAbstractFeatureCall) {
			return _isConstant((XAbstractFeatureCall) expression);
		} else if (expression instanceof XBooleanLiteral) {
			return _isConstant((XBooleanLiteral) expression);
		} else if (expression instanceof XCastedExpression) {
			return _isConstant((XCastedExpression) expression);
		} else if (expression instanceof XNumberLiteral) {
			return _isConstant((XNumberLiteral) expression);
		} else if (expression instanceof XStringLiteral) {
			return _isConstant((XStringLiteral) expression);
		} else if (expression instanceof XTypeLiteral) {
			return _isConstant((XTypeLiteral) expression);
		} else if (expression != null) {
			return _isConstant(expression);
		} else {
			throw new IllegalArgumentException("Unhandled parameter types: " + Arrays.asList(expression).toString());
		}
	}

	public boolean isConstantExpression(XExpression it) {
		if (it instanceof XAbstractFeatureCall) {
			return _isConstantExpression((XAbstractFeatureCall) it);
		} else if (it != null) {
			return _isConstantExpression(it);
		} else {
			return _isConstantExpression((Void) null);
		}
	}
}
