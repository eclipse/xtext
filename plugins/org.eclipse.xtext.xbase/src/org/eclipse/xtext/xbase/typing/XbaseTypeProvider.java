/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.util.Triple;
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
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.impl.FeatureCallToJavaMapping;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge
 */
@Singleton
public class XbaseTypeProvider extends AbstractTypeProvider {

	@Inject
	private TypesFactory factory;

	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;

	@Inject
	private FeatureCallToJavaMapping featureCall2javaMapping;

	@Inject
	private FunctionConversion functionConversion;

	@Inject
	private SuperTypeCollector collector;
	
	protected JvmTypeReference _expectedType(XAssignment assignment, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XASSIGNMENT__VALUE) {
			JvmIdentifiableElement feature = assignment.getFeature();
			JvmTypeReference receiverType = getReceiverType(assignment, rawType);
			if (feature instanceof JvmOperation) {
				JvmOperation operation = (JvmOperation) feature;
				XExpression expression = getExpression(assignment, reference, index);
				List<XExpression> actualArguments = featureCall2javaMapping.getActualArguments(assignment);
				int actualIndex = actualArguments.indexOf(expression);
				JvmTypeReference declaredType = getParam(operation, actualIndex).getParameterType();
				TypeArgumentContext context = getFeatureCallTypeArgContext(assignment, reference, index, rawType);
				return context.getLowerBound(declaredType);
			} else {
				final JvmTypeReference type = getTypeForIdentifiable(feature, rawType);
				if (rawType)
					return type;
				TypeArgumentContext context = typeArgumentContextProvider.getReceiverContext(receiverType);
				return context.getLowerBound(type);
			}
		}
		return null;
	}

	protected XExpression getExpression(EObject object, EReference reference, int index) {
		if (index == -1) {
			return (XExpression) object.eGet(reference, true);
		} else {
			List<?> expressions = (List<?>) object.eGet(reference, true);
			XExpression result = (XExpression) expressions.get(index);
			return result;
		}
	}

	protected JvmTypeReference _expectedType(XAbstractFeatureCall featureCall, EReference reference, int index,
			boolean rawType) {
		if (featureCall.getFeature() == null || featureCall.getFeature().eIsProxy())
			return null;
		if ((featureCall instanceof XMemberFeatureCall && (reference == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS || reference == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET))
				|| (featureCall instanceof XFeatureCall && reference == XbasePackage.Literals.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS)) {
			if (featureCall.getFeature() instanceof JvmOperation) {
				JvmOperation operation = (JvmOperation) featureCall.getFeature();
				XExpression argumentExpression = getExpression(featureCall, reference, index);
				List<XExpression> actualArguments = featureCall2javaMapping.getActualArguments(featureCall);
				TypeArgumentContext context = getFeatureCallTypeArgContext(featureCall, reference, index, rawType);
				int argumentIndex = actualArguments.indexOf(argumentExpression);
				if (argumentIndex >= 0) {
					if (operation.isVarArgs()) {
						if (argumentIndex >= operation.getParameters().size() - 1) {
							JvmTypeReference result = getExpectedVarArgType(operation, context, rawType);
							return result;
						}
					}
					if (argumentIndex >= operation.getParameters().size())
						return null;
					JvmFormalParameter parameter = getParam(operation, argumentIndex);
					final JvmTypeReference parameterType = parameter.getParameterType();
					final JvmTypeReference result = context.getLowerBound(parameterType);
					return result;
				} else {
					final JvmTypeReference declaringType = getTypeReferences().createTypeRef(operation.getDeclaringType());
					if (rawType)
						return declaringType;
					return context.getLowerBound(declaringType);
				}
			} else if (featureCall.getFeature() instanceof JvmField) {
				JvmField field = (JvmField) featureCall.getFeature();
				// TODO: lower bound for fields? resolve type parameters?
				return getTypeReferences().createTypeRef(field.getDeclaringType());
			}
		}
		return null;
	}

	protected JvmTypeReference _expectedType(XClosure closure, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XCLOSURE__EXPRESSION) {
			JvmTypeReference functionType = getExpectedType(closure, rawType);
			if (functionType != null) {
				JvmTypeReference result = functionConversion.getReturnType(functionType);
				return result;
			}
		}
		return null;
	}

	@Override
	protected JvmTypeReference handleCycleGetExpectedType(XExpression expression, boolean rawType) {
		Triple<EObject, EReference, Integer> info = getContainingInfo(expression);
		if (info.getFirst() instanceof XAbstractFeatureCall) {
			JvmTypeReference result = _expectedType((XAbstractFeatureCall) info.getFirst(), info.getSecond(),
					info.getThird(), rawType);
			return result;
		}
		return super.handleCycleGetExpectedType(expression, rawType);
	}

	protected TypeArgumentContext getFeatureCallTypeArgContext(XAbstractFeatureCall expr, EReference reference,
			int index, boolean rawType) {
		JvmTypeReference receiverType = getReceiverType(expr, rawType);
		if (expr.getFeature() instanceof JvmOperation) {
			JvmOperation operation = (JvmOperation) expr.getFeature();
			if (expr.getTypeArguments().isEmpty()) {
				receiverType = convertIfNeccessary(expr, receiverType, operation, rawType);
				JvmTypeReference expectedType = getExpectedType(expr, rawType);
				JvmTypeReference[] argTypes = getArgumentTypes(expr, rawType);
				TypeArgumentContext context = typeArgumentContextProvider.getInferredMethodInvocationContext(operation,
						receiverType, expectedType, argTypes);
				return context;
			} else {
				TypeArgumentContext result = typeArgumentContextProvider.getExplicitMethodInvocationContext(operation,
						receiverType, expr.getTypeArguments());
				return result;
			}
		} else {
			return typeArgumentContextProvider.getReceiverContext(receiverType);
		}
	}

	protected JvmTypeReference[] getArgumentTypes(XAbstractFeatureCall expr, boolean rawType) {
		List<XExpression> arguments = featureCall2javaMapping.getActualArguments(expr);
		JvmTypeReference[] argTypes = new JvmTypeReference[arguments.size()];
		if (arguments.isEmpty())
			return argTypes;
		JvmOperation op = (JvmOperation) expr.getFeature();
		for (int i = 0; i < argTypes.length; i++) {
			XExpression arg = arguments.get(i);
			JvmFormalParameter parameter = getParam(op, i);
			if (parameter != null) {
				final JvmTypeReference type = getType(arg, rawType);
				if (type != null) {
					JvmTypeReference parameterType = parameter.getParameterType();
					if (parameterType != null) {
						JvmTypeReference synonymType = this.synonymTypesProvider.findCompatibleSynonymType(type, parameterType.getType());
						argTypes[i] = synonymType != null ? synonymType : type;
					} else {
						argTypes[i] = type;
					}
				}
			}
		}
		return argTypes;
	}

	protected JvmFormalParameter getParam(JvmOperation op, int i) {
		if (op.getParameters().size() <= i) {
			if (op.isVarArgs())
				return op.getParameters().get(op.getParameters().size() - 1);
			return null;
		}
		return op.getParameters().get(i);
	}

	protected JvmTypeReference getReceiverType(XAbstractFeatureCall expr, boolean rawType) {
		XExpression receiver = featureCall2javaMapping.getActualReceiver(expr);
		JvmTypeReference receiverType = null;
		if (receiver != null)
			receiverType = getType(receiver, rawType);
		return receiverType;
	}

	protected JvmTypeReference _expectedType(XBinaryOperation expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XBINARY_OPERATION__RIGHT_OPERAND
				&& expr.getFeature() instanceof JvmOperation) {
			JvmOperation feature = (JvmOperation) expr.getFeature();
			JvmFormalParameter parameter = getLast(feature.getParameters());
			TypeArgumentContext context = getFeatureCallTypeArgContext(expr, reference, index, rawType);
			final JvmTypeReference parameterType = parameter.getParameterType();
			JvmTypeReference result = context.getLowerBound(parameterType);
			return result;
		}
		return null;
	}

	protected JvmTypeReference _expectedType(XVariableDeclaration expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XVARIABLE_DECLARATION__RIGHT) {
			final JvmTypeReference type = expr.getType();
			if (type != null)
				return type;
			return getTypeReferences().getTypeForName(Object.class, expr);
		}
		return null; // no expectations
	}

	protected JvmTypeReference _expectedType(XConstructorCall expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XCONSTRUCTOR_CALL__ARGUMENTS) {
			JvmExecutable feature = expr.getConstructor();
			TypeArgumentContext typeArgumentContext = typeArgumentContextProvider.getReceiverContext(null);
			if (index >= feature.getParameters().size()) {
				if (feature.isVarArgs()) {
					return getExpectedVarArgType(feature, typeArgumentContext, rawType);
				}
				return null;
			}
			if (feature.isVarArgs() && index == feature.getParameters().size() - 1) {
				return getExpectedVarArgType(feature, typeArgumentContext, rawType);
			}
			JvmFormalParameter parameter = feature.getParameters().get(index);
			JvmTypeReference parameterType = parameter.getParameterType();
			return typeArgumentContext.getLowerBound(parameterType);
		}
		return getExpectedType(expr, rawType);
	}

	protected JvmTypeReference getExpectedVarArgType(JvmExecutable feature, TypeArgumentContext typeArgumentContext,
			boolean rawType) {
		JvmFormalParameter lastParameter = feature.getParameters().get(feature.getParameters().size() - 1);
		JvmType parameterType = lastParameter.getParameterType().getType();
		if (parameterType instanceof JvmArrayType) {
			JvmTypeReference componentType = ((JvmArrayType) parameterType).getComponentType();
			return typeArgumentContext.getLowerBound(componentType);
		} else {
			throw new IllegalStateException("Var arg parameter has to be an array type");
		}
	}

	protected JvmTypeReference _expectedType(XBlockExpression expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XBLOCK_EXPRESSION__EXPRESSIONS) {
			// if last expression
			if (index + 1 == expr.getExpressions().size()) {
				return getExpectedType(expr, rawType);
			} else {
				return null; // no expectation
			}
		}
		throw new IllegalStateException("Unhandled reference " + reference);
	}

	protected JvmTypeReference _expectedType(XIfExpression expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XIF_EXPRESSION__IF) {
			return getTypeReferences().getTypeForName(Boolean.class, expr);
		}
		return getExpectedType(expr, rawType);
	}

	protected JvmTypeReference _expectedType(XForLoopExpression expr, EReference reference, int index, boolean rawType) {
		// Unless we can have multiple possible expected types (i.e. array and iterable), we shouldn't expect anything here
		// The conformance test is done explicitly in the validator.
		return null; // no expectations
	}

	protected JvmTypeReference _expectedType(XAbstractWhileExpression expr, EReference reference, int index,
			boolean rawType) {
		if (reference == XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__PREDICATE) {
			final JvmTypeReference typeForName = getTypeReferences().getTypeForName(Boolean.class, expr);
			return typeForName;
		}
		return null; // no other expectations
	}

	protected JvmTypeReference _expectedType(XTryCatchFinallyExpression expr, EReference reference, int index,
			boolean rawType) {
		if (reference == XbasePackage.Literals.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION) {
			return getExpectedType(expr, rawType);
		}
		return null; // no other expectations
	}

	protected JvmTypeReference _expectedType(XCatchClause expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XCATCH_CLAUSE__DECLARED_PARAM) {
			return getTypeReferences().getTypeForName(Throwable.class, expr);
		}
		return null; // no other expectations
	}

	protected JvmTypeReference _expectedType(XCastedExpression expr, EReference reference, int index, boolean rawType) {
		return null; // no expectations!
	}

	protected JvmTypeReference _expectedType(XThrowExpression expr, EReference reference, int index, boolean rawType) {
		return getTypeReferences().getTypeForName(Throwable.class, expr);
	}

	protected JvmTypeReference _expectedType(XReturnExpression expr, EReference reference, int index, boolean rawType) {
		return null; // no expectations!
	}

	protected JvmTypeReference _expectedType(XSwitchExpression expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XSWITCH_EXPRESSION__SWITCH) {
			return null; // no expectations
		}
		return getExpectedType(expr, rawType);
	}

	protected JvmTypeReference _expectedType(XCasePart expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XCASE_PART__TYPE_GUARD) {
			return getTypeReferences().getTypeForName(Class.class, expr);
		}
		if (reference == XbasePackage.Literals.XCASE_PART__CASE) {
			final XSwitchExpression switchExpr = (XSwitchExpression) expr.eContainer();
			if (switchExpr.getSwitch() == null) {
				return getTypeReferences().getTypeForName(Boolean.class, expr);
			}
			return null;
		}
		if (reference == XbasePackage.Literals.XCASE_PART__THEN) {
			return getExpectedType((XSwitchExpression) expr.eContainer(), rawType);
		}
		return null;
	}

	protected JvmTypeReference _type(XIfExpression object, boolean rawType) {
		if (object.getElse() == null) {
			return getType(object.getThen(), rawType);
		}
		List<JvmTypeReference> returnTypes = newArrayList();
		JvmTypeReference thenType = getType(object.getThen(), rawType);
		if (thenType != null)
			returnTypes.add(thenType);
		JvmTypeReference elseType = getType(object.getElse(), rawType);
		if (elseType != null)
			returnTypes.add(elseType);
		return getCommonType(returnTypes);
	}

	protected JvmTypeReference getCommonType(List<JvmTypeReference> returnTypes) {
		if (returnTypes.isEmpty())
			return null;
		if (returnTypes.size() == 1) {
			return returnTypes.get(0);
		}
		return getTypeConformanceComputer().getCommonSuperType(returnTypes);
	}

	protected JvmTypeReference _type(XSwitchExpression object, boolean rawType) {
		List<JvmTypeReference> returnTypes = Lists.newArrayList();
		EList<XCasePart> cases = object.getCases();
		for (XCasePart xCasePart : cases) {
			final JvmTypeReference unconverted = getType(xCasePart.getThen(), rawType);
			returnTypes.add(unconverted);
		}
		if (object.getDefault() != null) {
			final JvmTypeReference unconverted = getType(object.getDefault(), rawType);
			returnTypes.add(unconverted);
		}
		return getCommonType(returnTypes);
	}

	protected JvmTypeReference _type(XBlockExpression object, boolean rawType) {
		List<XExpression> expressions = object.getExpressions();
		if (expressions.isEmpty())
			return getTypeReferences().getTypeForName(Void.TYPE, object);
		final JvmTypeReference result = getType(expressions.get(expressions.size() - 1), rawType);
		return result;
	}

	protected JvmTypeReference _type(XVariableDeclaration object, boolean rawType) {
		return getPrimitiveVoid(object);
	}

	protected JvmTypeReference _type(XConstructorCall object, boolean rawType) {
		JvmConstructor constructor = object.getConstructor();
		if (constructor.eIsProxy())
			return null;
		JvmParameterizedTypeReference type = (JvmParameterizedTypeReference) getTypeForIdentifiable(
				object.getConstructor(), rawType);
		if (rawType)
			return type;
		if (!object.getTypeArguments().isEmpty()) {
			type = EcoreUtil2.clone(type);
			for (JvmTypeReference typeArg : object.getTypeArguments()) {
				JvmTypeReference copiedArgument = EcoreUtil2.clone(typeArg);
				type.getArguments().add(copiedArgument);
			}
		}
		return type;
	}

	protected JvmTypeReference _type(XBooleanLiteral object, boolean rawType) {
		return getTypeReferences().getTypeForName(Boolean.class, object);
	}

	protected JvmTypeReference _type(XNullLiteral object, boolean rawType) {
		return getTypeReferences().getTypeForName(Void.class, object);
	}

	protected JvmTypeReference _type(XIntLiteral object, boolean rawType) {
		return getTypeReferences().getTypeForName(Integer.class, object);
	}

	protected JvmTypeReference _type(XStringLiteral object, boolean rawType) {
		return getTypeReferences().getTypeForName(String.class, object);
	}

	protected JvmTypeReference _type(XClosure object, boolean rawType) {
		if (rawType) {
			JvmParameterizedTypeReference result = functionConversion.createRawFunctionTypeRef(object, object
					.getFormalParameters().size());
			return result;
		}
		JvmTypeReference returnType = getCommonReturnType(object.getExpression(), true);
		if (getTypeReferences().is(returnType, Void.TYPE)) {
			returnType = getTypeReferences().getTypeForName(Void.class,object);
		}
		List<JvmTypeReference> parameterTypes = Lists.newArrayList();
		List<JvmFormalParameter> params = object.getFormalParameters();
		for (JvmFormalParameter param : params) {
			parameterTypes.add(param.getParameterType());
		}
		// inferred argument types?
		if (!params.isEmpty()) {
			JvmTypeReference expectedType = getExpectedType(object, rawType);
			if (expectedType != null) {
				JvmOperation singleMethod = functionConversion.findSingleMethod(expectedType);
				if (singleMethod != null) {
					TypeArgumentContext context = typeArgumentContextProvider.getReceiverContext(expectedType);
					for (int i = 0; i < params.size(); i++) {
						JvmTypeReference resultParam = parameterTypes.get(i);
						if (resultParam == null) {
							JvmFormalParameter p = getParam(singleMethod, i);
							final JvmTypeReference resolved = context.resolve(p.getParameterType());
							parameterTypes.set(i, resolved);
						}
					}
				}
			}
		}
		return functionConversion.createFunctionTypeRef(object, parameterTypes, returnType);
	}

	protected JvmTypeReference _type(XCastedExpression object, boolean rawType) {
		return object.getType();
	}

	protected JvmTypeReference _type(XForLoopExpression object, boolean rawType) {
		return getPrimitiveVoid(object);
	}

	protected JvmTypeReference _type(XAbstractWhileExpression object, boolean rawType) {
		return getPrimitiveVoid(object);
	}

	protected JvmTypeReference _type(XTypeLiteral object, boolean rawType) {
		JvmParameterizedTypeReference typeRef = factory.createJvmParameterizedTypeReference();
		typeRef.setType(object.getType());
		return getTypeReferences().getTypeForName(Class.class, object, typeRef);
	}

	protected JvmTypeReference _type(XInstanceOfExpression object, boolean rawType) {
		return getTypeReferences().getTypeForName(Boolean.class, object);
	}

	protected JvmTypeReference _type(XThrowExpression object, boolean rawType) {
		final JvmTypeReference typeForName = getPrimitiveVoid(object);
		return typeForName;
	}

	protected JvmTypeReference _type(XReturnExpression object, boolean rawType) {
		final JvmTypeReference typeForName = getPrimitiveVoid(object);
		return typeForName;
	}

	protected JvmTypeReference getPrimitiveVoid(XExpression object) {
		return getTypeReferences().getTypeForName(Void.TYPE, object);
	}

	protected JvmTypeReference _type(XTryCatchFinallyExpression object, boolean rawType) {
		List<JvmTypeReference> returnTypes = newArrayList();
		final JvmTypeReference getType = getType(object.getExpression(), rawType);
		returnTypes.add(getType);
		for (XCatchClause catchClause : object.getCatchClauses()) {
			JvmTypeReference type = getType(catchClause.getExpression(), rawType);
			returnTypes.add(type);
		}
		JvmTypeReference commonSuperType = getTypeConformanceComputer().getCommonSuperType(returnTypes);
		return commonSuperType;
	}

	protected JvmTypeReference _type(XAbstractFeatureCall featureCall, boolean rawType) {
		JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature == null || feature.eIsProxy())
			return null;
		JvmTypeReference featureType = getTypeForIdentifiable(feature, rawType);
		if (isResolved(featureType, rawType)) {
			return featureType;
		} else {
			// method was either already called with rawType==false or the featureType points directly to a JvmTypeParameter
			rawType = false;
		}
		final JvmTypeReference receiverType2 = getReceiverType(featureCall, rawType);
		JvmTypeReference receiverType = convertIfNeccessary(featureCall, receiverType2, feature, rawType);
		if (feature instanceof JvmOperation) {
			JvmOperation operation = (JvmOperation) feature;
			if (featureCall.getTypeArguments().isEmpty()) {
				TypeArgumentContext context = typeArgumentContextProvider.getNullContext();
				JvmTypeReference result = featureType;
				if (receiverType != null) {
					context = typeArgumentContextProvider.injectReceiverContext(context, receiverType);
					result = context.getUpperBound(featureType, featureCall);
					if (isResolved(result, rawType)) {
						return result;
					}
				}
				JvmTypeReference[] argumentTypes = getArgumentTypes(featureCall, rawType);
				if (argumentTypes.length != 0 || operation.isVarArgs()) {
					context = typeArgumentContextProvider.injectArgumentTypeContext(context, operation, argumentTypes);
					result = context.getUpperBound(featureType, featureCall);
					if (isResolved(result, rawType)) {
						return result;
					}
				}
				JvmTypeReference expectedType = getExpectedType(featureCall, rawType);
				if (expectedType != null) {
					context = typeArgumentContextProvider.injectExpectedTypeContext(context, operation, expectedType);
					result = context.getUpperBound(featureType, featureCall);
					if (isResolved(result, rawType)) {
						return result;
					}
				}

				if (!isResolved(result, rawType)) {
					if (result instanceof JvmTypeParameter) {
						JvmTypeParameter type = (JvmTypeParameter) result.getType();
						JvmTypeReference upperBound = null;
						for (JvmTypeConstraint constraint : type.getConstraints()) {
							if (constraint instanceof JvmUpperBound) {
								if (upperBound != null) {
									return getType(featureCall, false);
								}
								JvmTypeReference reference = constraint.getTypeReference();
								upperBound = context.getUpperBound(reference, featureCall);
							}
						}
						if (upperBound != null && !(upperBound.getType() instanceof JvmTypeParameter))
							return upperBound;
						return getType(featureCall, false);
					}
				}
				result = context.getUpperBound(featureType, operation);
				return result;
			} else {
				TypeArgumentContext context = typeArgumentContextProvider.getExplicitMethodInvocationContext(operation,
						receiverType, featureCall.getTypeArguments());
				return context.getUpperBound(featureType, featureCall);
			}
		} else {
			JvmTypeReference expectedType = rawType ? null : getExpectedType(featureCall, rawType);
			TypeArgumentContext context = typeArgumentContextProvider
					.getReceiverContext(receiverType, featureType, expectedType);
			return context.getUpperBound(featureType, featureCall);
		}
	}

	@Inject
	private SynonymTypesProvider synonymTypesProvider;

	protected JvmTypeReference convertIfNeccessary(XAbstractFeatureCall context, JvmTypeReference toBeConverted,
			JvmIdentifiableElement feature, boolean rawType) {
		if (toBeConverted != null && feature instanceof JvmMember) {
			JvmDeclaredType declaringType = ((JvmMember) feature).getDeclaringType();
			if (synonymTypesProvider.hasSynonymTypes(toBeConverted)) {
				final JvmTypeReference findCompatibleSynonymType = synonymTypesProvider.findCompatibleSynonymType(
						toBeConverted, declaringType);
				return findCompatibleSynonymType != null ? findCompatibleSynonymType : toBeConverted;
			}
		}
		return toBeConverted;
	}

	protected JvmTypeReference _typeForIdentifiable(XSwitchExpression object, boolean rawType) {
		if (object.getLocalVarName() != null) {
			final JvmTypeReference result = getType(object.getSwitch(), rawType);
			return result;
		}
		return null;
	}

	protected JvmTypeReference _typeForIdentifiable(XCasePart object, boolean rawType) {
		if (object.getTypeGuard() != null) {
			return object.getTypeGuard();
		}
		return null;
	}

	protected JvmTypeReference _typeForIdentifiable(XVariableDeclaration object, boolean rawType) {
		if (object.getType() != null)
			return object.getType();
		return getType(object.getRight(), rawType);
	}

	protected JvmTypeReference _typeForIdentifiable(JvmFormalParameter parameter, boolean rawType) {
		if (parameter.getParameterType() == null) {
			if (parameter.eContainer() instanceof XClosure) {
				final XClosure closure = (XClosure) parameter.eContainer();
				JvmTypeReference type = getExpectedType(closure, rawType);
				int indexOf = closure.getFormalParameters().indexOf(parameter);
				if (type == null) {
					return null;
				}
				JvmOperation operation = functionConversion.findSingleMethod(type);
				if (operation != null && indexOf < operation.getParameters().size()) {
					JvmFormalParameter declaredParam = getParam(operation, indexOf);
					if (rawType) {
						if (declaredParam.getParameterType().getType() instanceof JvmTypeParameter) {
							JvmTypeReference result = _typeForIdentifiable(parameter, false);
							return result;
						}
					}
					TypeArgumentContext context = typeArgumentContextProvider.getReceiverContext(type);
					JvmTypeReference result = context.getLowerBound(declaredParam.getParameterType());
					if (result != null) {
						return result;
					}
					result = context.resolve(declaredParam.getParameterType());
					return result;
				}
				return null;
			} else if (parameter.eContainer() instanceof XForLoopExpression) {
				XForLoopExpression forLoop = (XForLoopExpression) parameter.eContainer();
				JvmTypeReference reference = getType(forLoop.getForExpression(), rawType);
				if (reference == null)
					return null;
				TypeArgumentContext context = typeArgumentContextProvider.getReceiverContext(reference);
				final String iterableName = Iterable.class.getName();
				// TODO remove the special array treatment and put into some generic facility
				if (reference.getType() instanceof JvmArrayType) {
					JvmTypeReference type = ((JvmArrayType) reference.getType()).getComponentType();
					return type;
				}
				if (!reference.getType().getIdentifier().equals(iterableName)) {
					try {
						final Set<JvmTypeReference> collectSuperTypes = collector.collectSuperTypes(reference);
						reference = find(collectSuperTypes, new Predicate<JvmTypeReference>() {
							public boolean apply(JvmTypeReference input) {
								return input.getType().getIdentifier().equals(iterableName);
							}
						});
					} catch (NoSuchElementException e) {
						return null;
					}
				}
				final JvmTypeReference resolveContravariant = context.getUpperBound(
						((JvmParameterizedTypeReference) reference).getArguments().get(0), parameter);
				return resolveContravariant;
			}
		}
		return parameter.getParameterType();
	}

	protected JvmTypeReference _typeForIdentifiable(JvmConstructor constructor, boolean rawType) {
		JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
		reference.setType(constructor.getDeclaringType());
		return reference;
	}

	protected JvmTypeReference _typeForIdentifiable(JvmField field, boolean rawType) {
		return field.getType();
	}

	protected JvmTypeReference _typeForIdentifiable(JvmOperation operation, boolean rawType) {
		return operation.getReturnType();
	}
	
	protected void _earlyExits(XClosure expr, EarlyExitAcceptor a) {
		// Don't go into closures
	}
	
	protected void _earlyExits(XReturnExpression expr, EarlyExitAcceptor a) {
		if (expr.getExpression()!=null) {
			JvmTypeReference type = getType(expr.getExpression());
			a.returns.add(type);
		}
	}
	
	protected void _earlyExits(XThrowExpression expr, EarlyExitAcceptor a) {
		if (expr.getExpression()!=null) {
			JvmTypeReference type = getType(expr.getExpression());
			a.thrown.add(type);
		}
	}
	
	protected void _earlyExits(XAbstractFeatureCall expr, EarlyExitAcceptor a) {
		if (expr.getFeature() instanceof JvmOperation) {
			JvmOperation op  =(JvmOperation) expr.getFeature();
			EList<JvmTypeReference> exceptions = op.getExceptions();
			a.thrown.addAll(exceptions);
		}
		_earlyExits((EObject)expr, a);
	}
	
	protected void _earlyExits(XTryCatchFinallyExpression expr, EarlyExitAcceptor a) {
		EarlyExitAcceptor acceptor = new EarlyExitAcceptor();
		internalCollectEarlyExits(expr.getExpression(), acceptor);
		a.returns.addAll(acceptor.returns);
		for (XCatchClause catchClause : expr.getCatchClauses()) {
			Iterator<JvmTypeReference> iterator = acceptor.thrown.iterator();
			while (iterator.hasNext()) {
				JvmTypeReference thrown = iterator.next();
				if (getTypeConformanceComputer().isConformant(catchClause.getDeclaredParam().getParameterType(), thrown)) {
					iterator.remove();
				}
			}
			internalCollectEarlyExits(catchClause.getExpression(), a);
		}
		a.thrown.addAll(acceptor.thrown);
		if (expr.getFinallyExpression()!=null)
			internalCollectEarlyExits(expr.getFinallyExpression(), a);
	}
	
	protected TypesFactory getTypesFactory() {
		return factory;
	}
	
	protected TypeArgumentContextProvider getTypeArgumentContextProvider() {
		return typeArgumentContextProvider;
	}
}
