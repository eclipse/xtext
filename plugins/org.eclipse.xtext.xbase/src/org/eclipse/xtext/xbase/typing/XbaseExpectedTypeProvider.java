/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.typing.AbstractExpectedTypeProvider;
import org.eclipse.xtext.typing.ITypeProvider;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseExpectedTypeProvider extends AbstractExpectedTypeProvider<JvmTypeReference> {

	@Inject
	private ITypeProvider<JvmTypeReference> typeProvider;

	@Inject
	private TypesService typeService;

	protected JvmTypeReference _expectedType(XAssignment assignment, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XASSIGNMENT__VALUE) {
			JvmIdentifyableElement feature = assignment.getFeature();
			return typeProvider.getType(feature);
		}
		return getExpectedType(assignment);
	}

	protected JvmTypeReference _expectedType(XMemberFeatureCall expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS) {
			//TODO resolve type parameters
			JvmExecutable feature = (JvmExecutable) expr.getFeature();
			JvmFormalParameter parameter = feature.getParameters().get(index);
			return parameter.getParameterType();
		}
		return getExpectedType(expr);
	}

	protected JvmTypeReference _expectedType(XBinaryOperation expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XBINARY_OPERATION__RIGHT_OPERAND) {
			JvmExecutable feature = (JvmExecutable) expr.getFeature();
			JvmFormalParameter parameter = feature.getParameters().get(0);
			return parameter.getParameterType();
		}
		return getExpectedType(expr);
	}

	protected JvmTypeReference _expectedType(XVariableDeclaration expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XVARIABLE_DECLARATION__RIGHT) {
			return expr.getType();
		}
		return null; // no expectations
	}

	protected JvmTypeReference _expectedType(XConstructorCall expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XCONSTRUCTOR_CALL__ARGUMENTS) {
			JvmExecutable feature = expr.getConstructor();
			JvmFormalParameter parameter = feature.getParameters().get(index);
			return parameter.getParameterType();
		}
		return getExpectedType(expr);
	}

	protected JvmTypeReference _expectedType(XBlockExpression expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XBLOCK_EXPRESSION__EXPRESSIONS) {
			// if last expression
			if (index + 1 == expr.getExpressions().size()) {
				return getExpectedType(expr);
			} else {
				return null; // no expectation
			}
		}
		throw new IllegalStateException("Unhandled reference " + reference);
	}

	protected JvmTypeReference _expectedType(XIfExpression expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XIF_EXPRESSION__IF) {
			return typeService.getTypeForName(TypesService.BOOLEAN_TYPE_NAME, expr);
		}
		return getExpectedType(expr);
	}

	protected JvmTypeReference _expectedType(XForLoopExpression expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION) {
			//TODO use expr.getDeclaredParam().getParameterType() to further constraint the iterable (upper bound type param) 
			final JvmTypeReference typeForName = typeService.getTypeForName(TypesService.JAVA_UTIL_ITERABLE, expr);
			return typeForName;
		}
		return null; // no other expectations
	}

	protected JvmTypeReference _expectedType(XAbstractWhileExpression expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__PREDICATE) {
			final JvmTypeReference typeForName = typeService.getTypeForName(TypesService.BOOLEAN_TYPE_NAME, expr);
			return typeForName;
		}
		return null; // no other expectations
	}

	protected JvmTypeReference _expectedType(XTryCatchFinallyExpression expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION) {
			return getExpectedType(expr);
		}
		return null; // no other expectations
	}

	protected JvmTypeReference _expectedType(XCatchClause expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XCATCH_CLAUSE__DECLARED_PARAM) {
			return typeService.getTypeForName(TypesService.JAVA_LANG_THROWABLE, expr);
		}
		return null; // no other expectations
	}

	protected JvmTypeReference _expectedType(XThrowExpression expr, EReference reference, int index) {
		return typeService.getTypeForName(TypesService.JAVA_LANG_THROWABLE, expr);
	}

	protected JvmTypeReference _expectedType(XSwitchExpression expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XSWITCH_EXPRESSION__SWITCH) {
			return null; // no expectations
		}
		return getExpectedType(expr);
	}

	protected JvmTypeReference _expectedType(XCasePart expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XCASE_PART__TYPE_GUARD) {
			return typeService.getTypeForName(TypesService.JAVA_LANG_CLASS, expr);
		}
		if (reference == XbasePackage.Literals.XCASE_PART__CASE) {
			final XSwitchExpression switchExpr = (XSwitchExpression) expr.eContainer();
			if (switchExpr.getSwitch() == null) {
				return typeService.getTypeForName(TypesService.BOOLEAN_TYPE_NAME, expr);
			}
			return null;
		}
		if (reference == XbasePackage.Literals.XCASE_PART__THEN) {
			return getExpectedType(expr);
		}
		return null;
	}

	protected JvmTypeReference _expectedType(XCastedExpression expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XCASTED_EXPRESSION__TARGET) {
			return expr.getType();
		}
		return null;
	}

}
