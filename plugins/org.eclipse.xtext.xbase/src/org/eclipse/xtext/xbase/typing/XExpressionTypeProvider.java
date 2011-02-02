/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.IJvmTypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableTypeProvider;
import org.eclipse.xtext.xbase.functions.FunctionConversion;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge
 */
public class XExpressionTypeProvider extends AbstractXExpressionTypeProvider {

	@Inject
	private TypesService typesService;

	@Inject
	private IJvmTypeConformanceComputer typeConformanceComputer;

	@Inject
	private TypesFactory factory;

	@Inject
	private TypeArgumentContext.Provider typeArgCtxProvider;

	@Inject
	private IdentifiableTypeProvider identifiableTypeProvider;

	@Inject
	private FunctionConversion functionConverter;
	
	public TypesService getTypesService() {
		return typesService;
	}

	protected JvmTypeReference _expectedType(XAssignment assignment, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XASSIGNMENT__VALUE) {
			JvmIdentifiableElement feature = assignment.getFeature();
			if (feature instanceof JvmOperation) {
				final JvmOperation op = (JvmOperation) feature;
				if (op.getParameters().size() == 1) {
					TypeArgumentContext context = functionConverter.getMethodTypeArgContext(assignment);
					final JvmTypeReference parameterType = op.getParameters().get(0).getParameterType();
					return context.getLowerBound(parameterType);
				}
				return null;
			}
			return identifiableTypeProvider.getType(feature);
		}
		return getExpectedType(assignment);
	}

	protected JvmTypeReference _expectedType(XMemberFeatureCall expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS) {
			if (!(expr.getFeature() instanceof JvmOperation))
				return null;
			JvmOperation feature = (JvmOperation) expr.getFeature();
			if (index >= feature.getParameters().size())
				return null;
			int paramIndex = feature.isStatic()?index+1:index;
			JvmFormalParameter parameter = feature.getParameters().get(paramIndex);
			TypeArgumentContext context = functionConverter.getMethodTypeArgContext(expr);
			return context.getLowerBound(parameter.getParameterType());
		} else if (reference == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET)
			return null;
		return getExpectedType(expr);
	}

	protected JvmTypeReference _expectedType(XBinaryOperation expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XBINARY_OPERATION__RIGHT_OPERAND
				&& expr.getFeature() instanceof JvmOperation) {
			JvmOperation feature = (JvmOperation) expr.getFeature();
			JvmFormalParameter parameter = feature.getParameters().get(0);
			// don't call isTargetsMemberFeatureCall, since we might still be in linking
			if (feature.getParameters().size() == 2) {
				parameter = feature.getParameters().get(1);
			}
			TypeArgumentContext context = functionConverter.getMethodTypeArgContext(expr);
			final JvmTypeReference parameterType = parameter.getParameterType();
			return context.getLowerBound(parameterType);
		}
		return null;
	}

	protected JvmTypeReference _expectedType(XVariableDeclaration expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XVARIABLE_DECLARATION__RIGHT) {
			final JvmTypeReference type = expr.getType();
			if (type != null)
				return type;
			return typesService.getTypeForName(Object.class, expr);
		}
		return null; // no expectations
	}

	protected JvmTypeReference _expectedType(XConstructorCall expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XCONSTRUCTOR_CALL__ARGUMENTS) {
			JvmExecutable feature = expr.getConstructor();
			if (index >= feature.getParameters().size())
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
			return typesService.getTypeForName(Boolean.class, expr);
		}
		return getExpectedType(expr);
	}

	protected JvmTypeReference _expectedType(XForLoopExpression expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION) {
			final JvmTypeReference typeForName = typesService.getTypeForName(Iterable.class, expr);
			// infer the type argument for the iterable if a type has been specified
			if (expr.getDeclaredParam().getParameterType() != null) {
				JvmTypeReference paramType = EcoreUtil2.clone(expr.getDeclaredParam().getParameterType());
				JvmWildcardTypeReference wildCard = factory.createJvmWildcardTypeReference();
				JvmUpperBound upperBound = factory.createJvmUpperBound();
				upperBound.setTypeReference(paramType);
				wildCard.getConstraints().add(upperBound);
				final JvmParameterizedTypeReference jvmParameterizedTypeReference = (JvmParameterizedTypeReference) typeForName;
				jvmParameterizedTypeReference.getArguments().clear();
				jvmParameterizedTypeReference.getArguments().add(wildCard);
				return typeForName;
			}
		}
		return null; // no other expectations
	}

	protected JvmTypeReference _expectedType(XAbstractWhileExpression expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__PREDICATE) {
			final JvmTypeReference typeForName = typesService.getTypeForName(Boolean.class, expr);
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
			return typesService.getTypeForName(Throwable.class, expr);
		}
		return null; // no other expectations
	}

	protected JvmTypeReference _expectedType(XThrowExpression expr, EReference reference, int index) {
		return typesService.getTypeForName(Throwable.class, expr);
	}

	protected JvmTypeReference _expectedType(XSwitchExpression expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XSWITCH_EXPRESSION__SWITCH) {
			return null; // no expectations
		}
		return getExpectedType(expr);
	}

	protected JvmTypeReference _expectedType(XCasePart expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XCASE_PART__TYPE_GUARD) {
			return typesService.getTypeForName(Class.class, expr);
		}
		if (reference == XbasePackage.Literals.XCASE_PART__CASE) {
			final XSwitchExpression switchExpr = (XSwitchExpression) expr.eContainer();
			if (switchExpr.getSwitch() == null) {
				return typesService.getTypeForName(Boolean.class, expr);
			}
			return null;
		}
		if (reference == XbasePackage.Literals.XCASE_PART__THEN) {
			return getExpectedType((XSwitchExpression) expr.eContainer());
		}
		return null;
	}

	protected JvmTypeReference _type(XIfExpression object) {
		if (object.getElse() == null) {
			return getType(object.getThen());
		}
			
		List<JvmTypeReference> returnTypes = newArrayList();
		JvmTypeReference thenType = getType(object.getThen());
		if (thenType!=null)
			returnTypes.add(thenType);
		JvmTypeReference elseType = getType(object.getElse());
		if (elseType!=null)
			returnTypes.add(elseType);
		return getCommonType(returnTypes);
	}

	protected JvmTypeReference getCommonType(List<JvmTypeReference> returnTypes) {
		if (returnTypes.isEmpty())
			return null;
		if (returnTypes.size()==1) {
			return returnTypes.get(0);
		}
		return typeConformanceComputer.getCommonSuperType(returnTypes);
	}

	protected JvmTypeReference _type(XSwitchExpression object) {
		List<JvmTypeReference> returnTypes = Lists.newArrayList();
		EList<XCasePart> cases = object.getCases();
		for (XCasePart xCasePart : cases) {
			final JvmTypeReference unconverted = getType(xCasePart.getThen());
			returnTypes.add(unconverted);
		}
		if (object.getDefault() != null) {
			final JvmTypeReference unconverted = getType(object.getDefault());
			returnTypes.add(unconverted);
		}
		return getCommonType(returnTypes);
	}

	protected JvmTypeReference _type(XBlockExpression object) {
		List<XExpression> expressions = object.getExpressions();
		if (expressions.isEmpty())
			return typesService.getTypeForName(Void.class, object);
		final JvmTypeReference getType = getType(expressions.get(expressions.size() - 1));
		return getType;
	}

	protected JvmTypeReference _type(XVariableDeclaration object) {
		return typesService.getTypeForName(Void.class, object);
	}

	protected JvmTypeReference _type(XConstructorCall object) {
		JvmConstructor constructor = object.getConstructor();
		if (constructor.eIsProxy())
			return null;
		final JvmParameterizedTypeReference type = (JvmParameterizedTypeReference) identifiableTypeProvider
				.getType(object.getConstructor());
		for (JvmTypeReference typeArg : object.getTypeArguments()) {
			JvmTypeReference copy = EcoreUtil2.clone(typeArg);
			type.getArguments().add(copy);
		}
		return type;
	}

	protected JvmTypeReference _type(XBooleanLiteral object) {
		return typesService.getTypeForName(Boolean.class, object);
	}

	protected JvmTypeReference _type(XNullLiteral object) {
		return typesService.getTypeForName(Void.class, object);
	}

	protected JvmTypeReference _type(XIntLiteral object) {
		return typesService.getTypeForName(Integer.class, object);
	}

	protected JvmTypeReference _type(XStringLiteral object) {
		return typesService.getTypeForName(String.class, object);
	}

	protected JvmTypeReference _type(XClosure object) {
		final JvmTypeReference returnType = getType(object.getExpression());
		List<JvmTypeReference> parameterTypes = Lists.newArrayList();
		EList<JvmFormalParameter> params = object.getFormalParameters();
		for (JvmFormalParameter param : params) {
			if (param.getParameterType() != null) {
				parameterTypes.add(param.getParameterType());
			}
		}
		// inferred argument types?
		if (parameterTypes.isEmpty() && !params.isEmpty()) {
			JvmTypeReference expectedType = getExpectedType(object);
			if (expectedType == null)
				return typesService.getTypeForName(Object.class, object);
			JvmOperation singleMethod = functionConverter.findSingleMethod(expectedType);
			TypeArgumentContext context = typeArgCtxProvider.get(expectedType);
			for (JvmFormalParameter p : singleMethod.getParameters()) {
				final JvmTypeReference resolve = context.resolve(p.getParameterType());
				parameterTypes.add(resolve);
			}
		}
		return typesService.createFunctionTypeRef(parameterTypes, returnType);
	}

	protected JvmTypeReference _type(XCastedExpression object) {
		return object.getType();
	}

	protected JvmTypeReference _type(XForLoopExpression object) {
		return typesService.getTypeForName(Void.class, object);
	}

	protected JvmTypeReference _type(XAbstractWhileExpression object) {
		return typesService.getTypeForName(Void.class, object);
	}

	protected JvmTypeReference _type(XTypeLiteral object) {
		JvmParameterizedTypeReference typeRef = factory.createJvmParameterizedTypeReference();
		typeRef.setType(object.getType());
		return typesService.getTypeForName(Class.class, object, typeRef);
	}

	protected JvmTypeReference _type(XInstanceOfExpression object) {
		return typesService.getTypeForName(Boolean.class, object);
	}

	protected JvmTypeReference _type(XThrowExpression object) {
		return typesService.getTypeForName(Void.class, object);
	}

	protected JvmTypeReference _type(XTryCatchFinallyExpression object) {
		List<JvmTypeReference> returnTypes = newArrayList();
		final JvmTypeReference getType = getType(object.getExpression());
		returnTypes.add(getType);
		for (XCatchClause catchClause : object.getCatchClauses()) {
			JvmTypeReference type = getType(catchClause.getExpression());
			returnTypes.add(type);
		}
		JvmTypeReference commonSuperType = typeConformanceComputer.getCommonSuperType(returnTypes);
		return commonSuperType;
	}

	protected JvmTypeReference _type(XAbstractFeatureCall object) {
		JvmIdentifiableElement feature = object.getFeature();
		if (feature == null || feature.eIsProxy())
			return null;
		JvmTypeReference featureType = identifiableTypeProvider.getType(feature);
		XExpression receiver = object.getActualReceiver();
		if (receiver!=null) {
			JvmTypeReference receiverType = getType(receiver);
			featureType = typeArgCtxProvider.get(receiverType).getUpperBound(featureType);
		}
		TypeArgumentContext methodTypeArgContext = functionConverter.getMethodTypeArgContext(object);
		return methodTypeArgContext.getUpperBound(featureType);
	}

}
