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
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
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
	private TypeReferences typeReferences;
	
	@Inject
	private Primitives primitives;
	
	@Inject
	private TypesFactory factory;

	@Inject
	private XbaseTypeConformanceComputer typeConformanceComputer;

	@Inject
	private TypeArgumentContextProvider typeArgCtxProvider;

	@Inject
	private FunctionConversion functionConverter;
	
	@Inject
	private FeatureCallToJavaMapping featureCall2javaMapping;
	
	@Inject
	private FunctionConversion functionConversion;
	
	@Inject
	private SuperTypeCollector collector;
	
	protected JvmTypeReference _expectedType(XAssignment assignment, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XASSIGNMENT__VALUE) {
			JvmIdentifiableElement feature = assignment.getFeature();
			JvmTypeReference receiverType = getReceiverType(assignment);
			if (feature instanceof JvmOperation) {
				JvmOperation op = (JvmOperation) feature;
				XExpression expression = getExpression(assignment, reference, index);
				List<XExpression> actualArguments = featureCall2javaMapping.getActualArguments(assignment);
				int actualIndex = actualArguments.indexOf(expression);
				JvmTypeReference declaredType = op.getParameters().get(actualIndex).getParameterType();
				TypeArgumentContext context = getFeatureCallTypeArgContext(assignment, reference, index);
				return context.getLowerBound(declaredType);
			} else {
				final JvmTypeReference type = getTypeForIdentifiable(feature);
				TypeArgumentContext context = typeArgCtxProvider.getReceiverContext(receiverType);
				return context.getLowerBound(type);
			}
		}
		return null;
	}

	protected XExpression getExpression(EObject object, EReference reference, int index) {
		if (index == -1) {
			return (XExpression)object.eGet(reference, true);
		} else {
			List<?> expressions = (List<?>) object.eGet(reference, true);
			XExpression result = (XExpression) expressions.get(index);
			return result;
		}
	}

	protected JvmTypeReference _expectedType(XMemberFeatureCall expr, EReference reference, int index) {
		if (expr.getFeature() ==null || expr.getFeature().eIsProxy())
			return null;
		if (reference == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS ||
			reference == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
			if (expr.getFeature() instanceof JvmOperation) {
				JvmOperation feature = (JvmOperation) expr.getFeature();
				XExpression caller = getExpression(expr, reference, index);
				List<XExpression> actualArguments = featureCall2javaMapping.getActualArguments(expr);
				TypeArgumentContext context = getFeatureCallTypeArgContext(expr, reference, index);
				if (actualArguments.contains(caller)) {
					int paramIndex = actualArguments.indexOf(caller);
					if (paramIndex<0 || paramIndex>=feature.getParameters().size())
						return null;
					JvmFormalParameter parameter = feature.getParameters().get(paramIndex);
					final JvmTypeReference parameterType = parameter.getParameterType();
					return context.getLowerBound(parameterType);
				} else {
					final JvmParameterizedTypeReference createTypeRef = typeReferences.createTypeRef(feature.getDeclaringType());
					return context.getLowerBound(createTypeRef);
				}
			} else if (expr.getFeature() instanceof JvmField) {
				JvmField field = (JvmField) expr.getFeature();
				return typeReferences.createTypeRef(field.getDeclaringType());
			}
		}
		return null;
	}

	protected TypeArgumentContext getFeatureCallTypeArgContext(XAbstractFeatureCall expr, EReference reference, int index) {
		JvmTypeReference receiverType = getReceiverType(expr);
		if (expr.getFeature() instanceof JvmOperation) {
			JvmOperation feature = (JvmOperation) expr.getFeature();
			JvmTypeReference expectedType = getExpectedType(expr);
			XExpression caller = getExpression(expr, reference, index);
			JvmTypeReference[] argTypes = getArgumentTypes(expr, caller);
			TypeArgumentContext context = typeArgCtxProvider.getInferredMethodInvocationContext(feature, receiverType, expectedType, argTypes);
			return context;
		} else {
			return typeArgCtxProvider.getReceiverContext(receiverType);
		}
	}

	protected JvmTypeReference[] getArgumentTypes(XAbstractFeatureCall expr, XExpression excludeMe) {
		List<XExpression> arguments = featureCall2javaMapping.getActualArguments(expr);
		JvmTypeReference[] argTypes = new JvmTypeReference[arguments.size()];
		for (int i = 0; i < argTypes.length; i++) {
			XExpression arg = arguments.get(i);
			if (excludeMe==arg) { // don't ask
				argTypes[i] = null;
			} else {
				argTypes[i] = getType(arg);
			}
		}
		return argTypes;
	}

	protected JvmTypeReference getReceiverType(XAbstractFeatureCall expr) {
		XExpression receiver = featureCall2javaMapping.getActualReceiver(expr);
		JvmTypeReference receiverType = null;
		if (receiver!=null)
			receiverType = getType(receiver);
		return receiverType;
	}

	protected JvmTypeReference _expectedType(XBinaryOperation expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XBINARY_OPERATION__RIGHT_OPERAND
				&& expr.getFeature() instanceof JvmOperation) {
			JvmOperation feature = (JvmOperation) expr.getFeature();
			JvmFormalParameter parameter = getLast(feature.getParameters());
			TypeArgumentContext context = getFeatureCallTypeArgContext(expr, reference, index);
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
			return typeReferences.getTypeForName(Object.class, expr);
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
			return typeReferences.getTypeForName(Boolean.class, expr);
		}
		return getExpectedType(expr);
	}

	protected JvmTypeReference _expectedType(XForLoopExpression expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION) {
			final JvmParameterizedTypeReference typeForName = (JvmParameterizedTypeReference) typeReferences.getTypeForName(Iterable.class, expr);
			typeForName.getArguments().clear();
			JvmWildcardTypeReference wildCard = factory.createJvmWildcardTypeReference();
			JvmUpperBound upperBound = factory.createJvmUpperBound();
			wildCard.getConstraints().add(upperBound);
			typeForName.getArguments().add(wildCard);
			// infer the type argument for the iterable if a type has been specified
			if (expr.getDeclaredParam().getParameterType() != null) {
				JvmTypeReference paramType = EcoreUtil2.clone(expr.getDeclaredParam().getParameterType());
				upperBound.setTypeReference(paramType);
			} else {
				JvmTypeReference objectType = typeReferences.getTypeForName(Object.class,expr);
				upperBound.setTypeReference(objectType);
			}
			return typeForName;
		}
		return null; // no other expectations
	}

	protected JvmTypeReference _expectedType(XAbstractWhileExpression expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__PREDICATE) {
			final JvmTypeReference typeForName = typeReferences.getTypeForName(Boolean.class, expr);
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
			return typeReferences.getTypeForName(Throwable.class, expr);
		}
		return null; // no other expectations
	}
	
	protected JvmTypeReference _expectedType(XCastedExpression expr, EReference reference, int index) {
		return null; // no expectations!
	}

	protected JvmTypeReference _expectedType(XThrowExpression expr, EReference reference, int index) {
		return typeReferences.getTypeForName(Throwable.class, expr);
	}
	
	protected JvmTypeReference _expectedType(XReturnExpression expr, EReference reference, int index) {
		return null; // no expectations!
	}

	protected JvmTypeReference _expectedType(XSwitchExpression expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XSWITCH_EXPRESSION__SWITCH) {
			return null; // no expectations
		}
		return getExpectedType(expr);
	}

	protected JvmTypeReference _expectedType(XCasePart expr, EReference reference, int index) {
		if (reference == XbasePackage.Literals.XCASE_PART__TYPE_GUARD) {
			return typeReferences.getTypeForName(Class.class, expr);
		}
		if (reference == XbasePackage.Literals.XCASE_PART__CASE) {
			final XSwitchExpression switchExpr = (XSwitchExpression) expr.eContainer();
			if (switchExpr.getSwitch() == null) {
				return typeReferences.getTypeForName(Boolean.class, expr);
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
			return typeReferences.getTypeForName(Void.class, object);
		final JvmTypeReference getType = getType(expressions.get(expressions.size() - 1));
		return getType;
	}

	protected JvmTypeReference _type(XVariableDeclaration object) {
		return getPrimitiveVoid(object);
	}

	protected JvmTypeReference _type(XConstructorCall object) {
		JvmConstructor constructor = object.getConstructor();
		if (constructor.eIsProxy())
			return null;
		final JvmParameterizedTypeReference type = (JvmParameterizedTypeReference) getTypeForIdentifiable(object.getConstructor());
		for (JvmTypeReference typeArg : object.getTypeArguments()) {
			JvmTypeReference copy = EcoreUtil2.clone(typeArg);
			type.getArguments().add(copy);
		}
		return type;
	}

	protected JvmTypeReference _type(XBooleanLiteral object) {
		return typeReferences.getTypeForName(Boolean.class, object);
	}

	protected JvmTypeReference _type(XNullLiteral object) {
		final JvmTypeReference typeForName = typeReferences.getTypeForName(Void.class, object);
		return typeForName;
	}

	protected JvmTypeReference _type(XIntLiteral object) {
		return typeReferences.getTypeForName(Integer.class, object);
	}

	protected JvmTypeReference _type(XStringLiteral object) {
		return typeReferences.getTypeForName(String.class, object);
	}

	protected JvmTypeReference _type(XClosure object) {
		final JvmTypeReference returnType = getType(object.getExpression());
		List<JvmTypeReference> parameterTypes = Lists.newArrayList();
		EList<JvmFormalParameter> params = object.getFormalParameters();
		for (JvmFormalParameter param : params) {
			parameterTypes.add(param.getParameterType());
		}
		// inferred argument types?
		if (!params.isEmpty()) {
			JvmTypeReference expectedType = getExpectedType(object);
			if (expectedType!=null) {
				JvmOperation singleMethod = functionConverter.findSingleMethod(expectedType);
				TypeArgumentContext context = typeArgCtxProvider.getReceiverContext(expectedType);
				for (int i = 0;i< params.size();i++) {
					JvmTypeReference resultParam = parameterTypes.get(i);
					if (resultParam==null) {
						JvmFormalParameter p = singleMethod.getParameters().get(i);
						final JvmTypeReference resolved = context.resolve(p.getParameterType());
						parameterTypes.set(i, resolved);
					}
				}
			}
		}
		return functionConversion.createFunctionTypeRef(object, parameterTypes, returnType);
	}

	protected JvmTypeReference _type(XCastedExpression object) {
		return object.getType();
	}

	protected JvmTypeReference _type(XForLoopExpression object) {
		return getPrimitiveVoid(object);
	}

	protected JvmTypeReference _type(XAbstractWhileExpression object) {
		return getPrimitiveVoid(object);
	}

	protected JvmTypeReference _type(XTypeLiteral object) {
		JvmParameterizedTypeReference typeRef = factory.createJvmParameterizedTypeReference();
		typeRef.setType(object.getType());
		return typeReferences.getTypeForName(Class.class, object, typeRef);
	}

	protected JvmTypeReference _type(XInstanceOfExpression object) {
		return typeReferences.getTypeForName(Boolean.class, object);
	}

	protected JvmTypeReference _type(XThrowExpression object) {
		final JvmTypeReference typeForName = getPrimitiveVoid(object);
		return typeForName;
	}
	
	protected JvmTypeReference _type(XReturnExpression object) {
		final JvmTypeReference typeForName = getPrimitiveVoid(object);
		return typeForName;
	}

	protected JvmTypeReference getPrimitiveVoid(XExpression object) {
		return typeReferences.getTypeForName(Void.TYPE, object);
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
		JvmTypeReference featureType = getTypeForIdentifiable(feature);
		JvmTypeReference receiverType = convertIfNeccessary(object, getReceiverType(object), feature);
		if (feature instanceof JvmOperation) {
			JvmTypeReference expectedType = getExpectedType(object);
			JvmTypeReference[] argumentTypes = getArgumentTypes(object, null);
			TypeArgumentContext methodTypeArgContext = typeArgCtxProvider.getInferredMethodInvocationContext((JvmOperation) object.getFeature(), receiverType, expectedType, argumentTypes);
			return methodTypeArgContext.getUpperBound(featureType, object);
		} else {
			TypeArgumentContext context = typeArgCtxProvider.getReceiverContext(receiverType);
			return context.getUpperBound(featureType, object);
		}
	}

	protected JvmTypeReference convertIfNeccessary(XAbstractFeatureCall context, JvmTypeReference toBeConverted, JvmIdentifiableElement feature) {
		if (toBeConverted != null && feature instanceof JvmMember) {
			JvmDeclaredType declaringType = ((JvmMember) feature).getDeclaringType();
			if (declaringType.getCanonicalName().equals(Iterable.class.getName()) && toBeConverted.getType() instanceof JvmArrayType) {
				final JvmArrayType type2 = (JvmArrayType)toBeConverted.getType();
				JvmTypeReference type = type2.getComponentType();
				if (primitives.isPrimitive(type)) {
					type = typeReferences.createTypeRef(primitives.getWrapperType((JvmPrimitiveType) type.getType()));
				}
				JvmTypeReference clone = EcoreUtil2.clone(type);
				final JvmTypeReference wildCardExtends = typeReferences.wildCardExtends(clone);
				return typeReferences.createTypeRef(declaringType, wildCardExtends);
			}
		}
		return toBeConverted;
	}

	protected JvmTypeReference _typeForIdentifiable(XSwitchExpression object) {
		if (object.getLocalVarName() != null) {
			final JvmTypeReference result = getType(object.getSwitch());
			return result;
		}
		return null;
	}

	protected JvmTypeReference _typeForIdentifiable(XCasePart object) {
		if (object.getTypeGuard() != null) {
			return object.getTypeGuard();
		}
		return null;
	}

	protected JvmTypeReference _typeForIdentifiable(XVariableDeclaration object) {
		if (object.getType() != null)
			return object.getType();
		return getType(object.getRight());
	}

	protected JvmTypeReference _typeForIdentifiable(JvmFormalParameter parameter) {
		if (parameter.getParameterType() == null) {
			if (parameter.eContainer() instanceof XClosure) {
				final XClosure closure = (XClosure)parameter.eContainer();
					JvmTypeReference type = getExpectedType(closure);
					int indexOf = closure.getFormalParameters().indexOf(parameter);
					if (type==null) {
						return null;
					}
					JvmOperation operation = functionConversion.findSingleMethod(type);
					if (indexOf < operation.getParameters().size()) {
						JvmFormalParameter declaredParam = operation.getParameters().get(indexOf);
						TypeArgumentContext context = typeArgCtxProvider.getReceiverContext(type);
						return context.resolve(declaredParam.getParameterType());
					}
					return null;
			} else if (parameter.eContainer() instanceof XForLoopExpression) {
				XForLoopExpression forLoop = (XForLoopExpression) parameter.eContainer();
				JvmParameterizedTypeReference reference = (JvmParameterizedTypeReference) getType(forLoop
						.getForExpression());
				TypeArgumentContext context = typeArgCtxProvider.getReceiverContext(reference);
				final String iterableName = Iterable.class.getName();
				// TODO remove the special array treatment and put into some generic facility
				if (reference.getType() instanceof JvmArrayType) {
					JvmTypeReference type = ((JvmArrayType)reference.getType()).getComponentType();
					return type;
				}
				if (!reference.getType().getCanonicalName().equals(iterableName)) {
					try {
						final Set<JvmTypeReference> collectSuperTypes = collector.collectSuperTypes(reference);
						reference = (JvmParameterizedTypeReference) find(collectSuperTypes,
								new Predicate<JvmTypeReference>() {
									public boolean apply(JvmTypeReference input) {
										return input.getType().getCanonicalName().equals(iterableName);
									}
								});
					} catch (NoSuchElementException e) {
						return null;
					}
				}
				final JvmTypeReference resolveContravariant = context.getUpperBound((reference).getArguments().get(0), parameter);
				return resolveContravariant;
			}
		}
		return parameter.getParameterType();
	}

	protected JvmTypeReference _typeForIdentifiable(JvmConstructor constructor) {
		JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
		reference.setType(constructor.getDeclaringType());
		return reference;
	}

	protected JvmTypeReference _typeForIdentifiable(JvmField field) {
		return field.getType();
	}

	protected JvmTypeReference _typeForIdentifiable(JvmOperation operation) {
		return operation.getReturnType();
	}
}
