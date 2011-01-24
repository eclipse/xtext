/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.typing.AbstractExpectedTypeProvider;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableTypeProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XExpressionExpectedTypeProvider extends AbstractExpectedTypeProvider<JvmTypeReference, XExpression> implements IXExpressionExpectedTypeProvider {

	@Inject
	private IdentifiableTypeProvider identifiableTypeProvider;

	@Inject
	private TypesService typeService;
	
	@Inject
	private XbaseTypeArgumentContextProvider typeArgCtxProvider;
	
	@Inject
	private TypesFactory factory;

	protected JvmTypeReference _expectedType(XAssignment assignment, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XASSIGNMENT__VALUE) {
			JvmIdentifiableElement feature = assignment.getFeature();
			return identifiableTypeProvider.getType(feature);
		}
		return getExpectedType(assignment);
	}

	protected JvmTypeReference _expectedType(XMemberFeatureCall expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS) {
			if(!(expr.getFeature() instanceof JvmExecutable)) 
				return null;
			JvmExecutable feature = (JvmExecutable) expr.getFeature();
			if(index >= feature.getParameters().size())
				return null;
			JvmFormalParameter parameter = feature.getParameters().get(index);
			TypeArgumentContext context = typeArgCtxProvider.getContext(expr.getMemberCallTarget());
			return context.getLowerBound(parameter.getParameterType());
		} else if(reference == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) 
			return null;
		return getExpectedType(expr);
	}

	protected JvmTypeReference _expectedType(XBinaryOperation expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XBINARY_OPERATION__RIGHT_OPERAND && expr.getFeature() instanceof JvmExecutable) {
			JvmExecutable feature = (JvmExecutable) expr.getFeature();
			if(index >= feature.getParameters().size())
				return null;
			JvmFormalParameter parameter = feature.getParameters().get(0);
			TypeArgumentContext context = typeArgCtxProvider.getContext(expr.getLeftOperand());
			return context.getLowerBound(parameter.getParameterType());
		}
		return getExpectedType(expr);
	}

	protected JvmTypeReference _expectedType(XVariableDeclaration expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XVARIABLE_DECLARATION__RIGHT) {
			final JvmTypeReference type = expr.getType();
			if (type != null)
				return type;
			return typeService.getTypeForName(TypesService.OBJECT_TYPE_NAME, expr);
		}
		return null; // no expectations
	}

	protected JvmTypeReference _expectedType(XConstructorCall expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XCONSTRUCTOR_CALL__ARGUMENTS) {
			JvmExecutable feature = expr.getConstructor();
			if(index >= feature.getParameters().size())
				return null;
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
			final JvmTypeReference typeForName = typeService.getTypeForName(TypesService.JAVA_LANG_ITERABLE, expr);
			// infer the type argument for the iterable if a type has been specified
			if (expr.getDeclaredParam().getParameterType()!=null) {
				JvmTypeReference paramType = EcoreUtil2.clone(expr.getDeclaredParam().getParameterType());
				JvmWildcardTypeReference wildCard = factory.createJvmWildcardTypeReference();
				JvmUpperBound upperBound = factory.createJvmUpperBound();
				upperBound.setTypeReference(paramType);
				wildCard.getConstraints().add(upperBound);
				final JvmParameterizedTypeReference jvmParameterizedTypeReference = (JvmParameterizedTypeReference)typeForName;
				jvmParameterizedTypeReference.getArguments().clear();
				jvmParameterizedTypeReference.getArguments().add(wildCard);
				return typeForName;
			}
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
			return getExpectedType((XSwitchExpression)expr.eContainer());
		}
		return null;
	}
		
}
