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
import static java.util.Collections.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
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
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSetLiteral;
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
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge
 * @author Sebastian Zarnekow
 */
@Deprecated
@Singleton
public class XbaseTypeProvider extends AbstractTypeProvider {

	@Inject
	private TypesFactory factory;
	
	@Inject
	private FeatureCallToJavaMapping featureCall2javaMapping;

	@Inject
	private Closures closures;

	@Inject
	private SuperTypeCollector collector;
	
	@Inject
	private NumberLiterals numberLiterals;
	
	@Inject 
	private TypeReferences typeReferences;
	
	@Inject
	private Primitives primitives;

	@Override
	protected JvmTypeReference _expectedType(EObject obj, EReference reference, int index, boolean rawType) {
		Object ele = obj.eGet(reference);
		if (ele instanceof List) {
			ele = ((List<?>)ele).get(index);
		}
		if (ele instanceof XExpression) {
			JvmIdentifiableElement element = getLogicalContainerProvider().getLogicalContainer((XExpression) ele);
			if (element instanceof JvmOperation) {
				return ((JvmOperation) element).getReturnType();
			}
			if (element instanceof JvmField) {
				return ((JvmField) element).getType();
			}
		}
		return null;
	}
	
	@Override
	protected JvmTypeReference typeForIdentifiable(JvmIdentifiableElement identifiable, boolean rawType) {
		if (identifiable instanceof JvmConstructor) {
			return _typeForIdentifiable((JvmConstructor)identifiable, rawType);
		} else if (identifiable instanceof JvmField) {
			return _typeForIdentifiable((JvmField)identifiable, rawType);
		} else if (identifiable instanceof JvmFormalParameter) {
			return _typeForIdentifiable((JvmFormalParameter)identifiable, rawType);
		} else if (identifiable instanceof JvmOperation) {
			return _typeForIdentifiable((JvmOperation)identifiable, rawType);
		} else if (identifiable instanceof JvmType) {
			return _typeForIdentifiable((JvmType)identifiable, rawType);
		} else if (identifiable instanceof XVariableDeclaration) {
			return _typeForIdentifiable((XVariableDeclaration)identifiable, rawType);
		} else {
			return super.typeForIdentifiable(identifiable, rawType);
		}
	}
	
	@Override
	protected JvmTypeReference type(XExpression expression, JvmTypeReference rawExpectation, boolean rawType) {
		if (expression instanceof XFeatureCall) {
			return _type((XFeatureCall)expression, rawExpectation, rawType);
		} else if (expression instanceof XAbstractFeatureCall) {
			return _type((XAbstractFeatureCall)expression, rawExpectation, rawType);
		} else if (expression instanceof XAbstractWhileExpression) {
			return _type((XAbstractWhileExpression)expression, rawExpectation, rawType);
		} else if (expression instanceof XBlockExpression) {
			return _type((XBlockExpression)expression, rawExpectation, rawType);
		} else if (expression instanceof XBooleanLiteral) {
			return _type((XBooleanLiteral)expression, rawExpectation, rawType);
		} else if (expression instanceof XCastedExpression) {
			return _type((XCastedExpression)expression, rawExpectation, rawType);
		} else if (expression instanceof XClosure) {
			return _type((XClosure)expression, rawExpectation, rawType);
		} else if (expression instanceof XConstructorCall) {
			return _type((XConstructorCall)expression, rawExpectation, rawType);
		} else if (expression instanceof XForLoopExpression) {
			return _type((XForLoopExpression)expression, rawExpectation, rawType);
		} else if (expression instanceof XIfExpression) {
			return _type((XIfExpression)expression, rawExpectation, rawType);
		} else if (expression instanceof XInstanceOfExpression) {
			return _type((XInstanceOfExpression)expression, rawExpectation, rawType);
		} else if (expression instanceof XNumberLiteral) {
			return _type((XNumberLiteral)expression, rawExpectation, rawType);
		} else if (expression instanceof XNullLiteral) {
			return _type((XNullLiteral)expression, rawExpectation, rawType);
		} else if (expression instanceof XReturnExpression) {
			return _type((XReturnExpression)expression, rawExpectation, rawType);
		} else if (expression instanceof XStringLiteral) {
			return _type((XStringLiteral)expression, rawExpectation, rawType);
		} else if (expression instanceof XSwitchExpression) {
			return _type((XSwitchExpression)expression, rawExpectation, rawType);
		} else if (expression instanceof XThrowExpression) {
			return _type((XThrowExpression)expression, rawExpectation, rawType);
		} else if (expression instanceof XTryCatchFinallyExpression) {
			return _type((XTryCatchFinallyExpression)expression, rawExpectation, rawType);
		} else if (expression instanceof XTypeLiteral) {
			return _type((XTypeLiteral)expression, rawExpectation, rawType);
		} else if (expression instanceof XVariableDeclaration) {
			return _type((XVariableDeclaration)expression, rawExpectation, rawType);
		} else if (expression instanceof XListLiteral) {
			return _type((XListLiteral)expression, rawExpectation, rawType);
		} else if (expression instanceof XSetLiteral) {
			return _type((XSetLiteral)expression, rawExpectation, rawType);
		} else { 
			return super.type(expression, rawExpectation, rawType);
		}
	}
	
	@Override
	protected JvmTypeReference expectedType(EObject container, EReference reference, int index,
			boolean rawType) {
		if (container instanceof XAssignment) {
			return _expectedType((XAssignment)container, reference, index, rawType);
		} else if (container instanceof XBinaryOperation) {
			return _expectedType((XBinaryOperation)container, reference, index, rawType);
		} else if (container instanceof XAbstractFeatureCall) {
			return _expectedType((XAbstractFeatureCall)container, reference, index, rawType);
		} else if (container instanceof XAbstractWhileExpression) {
			return _expectedType((XAbstractWhileExpression)container, reference, index, rawType);
		} else if (container instanceof XBlockExpression) {
			return _expectedType((XBlockExpression)container, reference, index, rawType);
		} else if (container instanceof XCasePart) {
			return _expectedType((XCasePart)container, reference, index, rawType);
		} else if (container instanceof XCastedExpression) {
			return _expectedType((XCastedExpression)container, reference, index, rawType);
		} else if (container instanceof XCatchClause) {
			return _expectedType((XCatchClause)container, reference, index, rawType);
		} else if (container instanceof XClosure) {
			return _expectedType((XClosure)container, reference, index, rawType);
		} else if (container instanceof XConstructorCall) {
			return _expectedType((XConstructorCall)container, reference, index, rawType);
		} else if (container instanceof XForLoopExpression) {
			return _expectedType((XForLoopExpression)container, reference, index, rawType);
		} else if (container instanceof XIfExpression) {
			return _expectedType((XIfExpression)container, reference, index, rawType);
		} else if (container instanceof XReturnExpression) {
			return _expectedType((XReturnExpression)container, reference, index, rawType);
		} else if (container instanceof XSwitchExpression) {
			return _expectedType((XSwitchExpression)container, reference, index, rawType);
		} else if (container instanceof XThrowExpression) {
			return _expectedType((XThrowExpression)container, reference, index, rawType);
		} else if (container instanceof XTryCatchFinallyExpression) {
			return _expectedType((XTryCatchFinallyExpression)container, reference, index, rawType);
		} else if (container instanceof XVariableDeclaration) {
			return _expectedType((XVariableDeclaration)container, reference, index, rawType);
		} else if (container instanceof XListLiteral) {
			return _expectedType((XListLiteral)container, reference, index, rawType);
		} else if (container instanceof XSetLiteral) {
			return _expectedType((XSetLiteral)container, reference, index, rawType);
		} else {
			return super.expectedType(container, reference, index, rawType);
		}
	}
	
	protected JvmTypeReference _expectedType(final XAssignment assignment, EReference reference, int index, final boolean rawType) {
		if (reference == XbasePackage.Literals.XASSIGNMENT__VALUE) {
			JvmIdentifiableElement feature = getFeature(assignment);
			if (feature instanceof JvmOperation) {
				JvmOperation operation = (JvmOperation) feature;
				XExpression expression = getExpression(assignment, reference, index);
				List<XExpression> actualArguments = featureCall2javaMapping.getActualArguments(assignment);
				int actualIndex = actualArguments.indexOf(expression);
				JvmFormalParameter parameter = getParam(operation, actualIndex);
				if (parameter != null) {
					JvmTypeReference declaredType = parameter.getParameterType();
					ITypeArgumentContext context = getFeatureCallTypeArgContext(assignment, rawType);
					return context.getLowerBound(declaredType);
				}
				return null;
			} else {
				final JvmTypeReference type = getTypeForIdentifiable(feature, rawType);
				if (rawType)
					return type;
				ITypeArgumentContext context = getTypeArgumentContextProvider().getTypeArgumentContext(
						new TypeArgumentContextProvider.AbstractRequest() {
							@Override
							public JvmTypeReference getReceiverType() {
								return XbaseTypeProvider.this.getReceiverType(assignment, rawType);
							}
						});
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
		if (getFeature(featureCall) == null || getFeature(featureCall).eIsProxy())
			return null;
		if ((featureCall instanceof XMemberFeatureCall && (
				reference == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS || 
				reference == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET
				))
				|| 
			(featureCall instanceof XFeatureCall && (
				reference == XbasePackage.Literals.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS || 
				reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER ||
				reference == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT))) {
			if (getFeature(featureCall) instanceof JvmOperation) {
				JvmOperation operation = (JvmOperation) getFeature(featureCall);
				XExpression argumentExpression = getExpression(featureCall, reference, index);
				List<XExpression> actualArguments = featureCall2javaMapping.getActualArguments(featureCall);
				ITypeArgumentContext context = getFeatureCallTypeArgContext(featureCall, rawType);
				int argumentIndex = actualArguments.indexOf(argumentExpression);
				if (argumentIndex >= 0) {
					if (operation.isVarArgs()) {
						if (argumentIndex >= operation.getParameters().size() - 1) {
							int argumentSize = actualArguments.size();
							int parameterSize = operation.getParameters().size();
							JvmTypeReference result = getExpectedVarArgType(operation, context, rawType, argumentSize > parameterSize);
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
					if (!rawType && argumentExpression != null) {
						JvmTypeReference receiverType = getType(argumentExpression, rawType);
						if (receiverType != null) {
							JvmTypeReference result = context.getLowerBound(receiverType);
							if (result != null && result.getType() instanceof JvmTypeParameter)
								return result;
						}
					}
					JvmTypeReference result = context.getLowerBound(declaringType);
					return result;
				}
			} else if (getFeature(featureCall) instanceof JvmField) {
				JvmField field = (JvmField) getFeature(featureCall);
				// TODO: lower bound for fields? resolve type parameters?
				return getTypeReferences().createTypeRef(field.getDeclaringType());
			}
		}
		return null;
	}

	/**
	 * @param index the feature index 
	 */
	protected JvmTypeReference _expectedType(XClosure closure, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XCLOSURE__EXPRESSION) {
			JvmTypeReference functionType = getExpectedType(closure, rawType);
			if (functionType != null) {
				JvmOperation operation = closures.findImplementingOperation(functionType, closure.eResource());
				if (operation != null) {
					JvmTypeReference declaredReturnType = operation.getReturnType();
					ITypeArgumentContext receiverContext = getTypeArgumentContextProvider().getTypeArgumentContext(
							new TypeArgumentContextProvider.ReceiverRequest(functionType));
					JvmTypeReference result = receiverContext.getUpperBound(declaredReturnType, closure);
					return result;
				}
			}
		}
		return null;
	}

	@Override
	protected JvmTypeReference handleCycleGetExpectedType(XExpression expression, boolean rawType) {
		Triple<EObject, EReference, Integer> info = getContainingInfo(expression);
		if (info != null) {
			EObject container = info.getFirst();
			if (container instanceof XAbstractFeatureCall) {
				JvmTypeReference result = expectedType(container, info.getSecond(), info.getThird(), rawType);
				return result;
			}
		}
		return super.handleCycleGetExpectedType(expression, rawType);
	}

	protected ITypeArgumentContext getFeatureCallTypeArgContext(
			final XAbstractFeatureCall expr, 
			final boolean rawType) {
		return getTypeArgumentContextProvider().getTypeArgumentContext(new XbaseTypeArgumentContextProvider.AbstractFeatureCallRequest() {
			@Override
			public JvmTypeReference getReceiverType() {
				JvmTypeReference result = XbaseTypeProvider.this.getReceiverType(expr, rawType);
				return result;
			}
			@Override
			public XAbstractFeatureCall getFeatureCall() {
				return expr;
			}
			@Override
			public String toString() {
				return "XbaseTypeProvider.getFeatureCallTypeArgContext [expr=" + expr + "]";
			}
			@Override
			public JvmTypeReference getExpectedType() {
				JvmTypeReference result = XbaseTypeProvider.this.getExpectedType(expr, rawType);
				return result;
			}
			@Override
			public List<JvmTypeReference> getExplicitTypeArgument() {
				return expr.getTypeArguments();
			}
			@Override
			public JvmTypeParameterDeclarator getNearestDeclarator() {
				JvmTypeParameterDeclarator result = XbaseTypeProvider.this.getNearestTypeParameterDeclarator(expr);
				return result;
			}
			@Override
			public JvmFeature getFeature() {
				JvmIdentifiableElement feature = XbaseTypeProvider.this.getFeature(expr);
				if (feature instanceof JvmFeature)
					return (JvmFeature) feature;
				return null;
			}
			@Override
			public List<JvmTypeReference> getArgumentTypes() {
				List<JvmTypeReference> result = Arrays.asList(XbaseTypeProvider.this.getArgumentTypes(expr, rawType));
				return result;
			}
			@Override
			public JvmTypeReference getDeclaredType() {
				JvmIdentifiableElement feature = XbaseTypeProvider.this.getFeature(expr);
				if (feature instanceof JvmOperation)
					return ((JvmOperation) feature).getReturnType();
				if (feature instanceof JvmField)
					return ((JvmField) feature).getType();
				return null;
			}
		});
	}

	protected JvmTypeReference[] getArgumentTypes(XAbstractFeatureCall expr, boolean rawType) {
		List<XExpression> arguments = featureCall2javaMapping.getActualArguments(expr);
		JvmExecutable executable = (JvmExecutable) getFeature(expr);
		return getArgumentTypes(executable, arguments, rawType);
	}

	protected JvmTypeReference[] getArgumentTypes(JvmExecutable executable, List<XExpression> actualArguments,
			boolean rawType) {
		JvmTypeReference[] argTypes = new JvmTypeReference[actualArguments.size()];
		if (actualArguments.isEmpty())
			return argTypes;
		for (int i = 0; i < argTypes.length; i++) {
			XExpression arg = actualArguments.get(i);
			JvmFormalParameter parameter = getParam(executable, i);
			if (parameter != null) {
				JvmTypeReference parameterType = getTypeForIdentifiable(parameter, rawType);
				final JvmTypeReference type = getType(arg, parameterType, rawType);
				if (type != null) {
					argTypes[i] = type;
				} else {
					argTypes[i] = parameterType;
				}
			}
		}
		return argTypes;
	}

	protected JvmFormalParameter getParam(JvmExecutable executable, int i) {
		if (executable.getParameters().size() <= i) {
			if (executable.isVarArgs())
				return executable.getParameters().get(executable.getParameters().size() - 1);
			return null;
		}
		return executable.getParameters().get(i);
	}

	protected JvmTypeReference getReceiverType(XAbstractFeatureCall expr, boolean rawType) {
		XExpression receiver = featureCall2javaMapping.getActualReceiver(expr);
		JvmTypeReference receiverType = null;
		if (receiver != null)
			receiverType = getType(receiver, rawType);
		if (receiverType != null) {
			Set<JvmTypeReference> synonymTypes = synonymTypesProvider.getSynonymTypes(receiverType, false);
			if (!synonymTypes.isEmpty()) {
				JvmSynonymTypeReference result = factory.createJvmSynonymTypeReference();
				if (receiverType.eContainer() != null) {
					JvmDelegateTypeReference delegate = factory.createJvmDelegateTypeReference();
					delegate.setDelegate(receiverType);
					result.getReferences().add(delegate);
				} else {
					result.getReferences().add(receiverType);
				}
				for(JvmTypeReference synonym: synonymTypes) {
					if (synonym.eResource() != null) {
						JvmDelegateTypeReference delegate = factory.createJvmDelegateTypeReference();
						delegate.setDelegate(synonym);
						result.getReferences().add(delegate);
					} else {
						result.getReferences().add(synonym);
					}
				}
				return result;
			}
		}
		return receiverType;
	}

	protected JvmTypeReference _expectedType(XBinaryOperation expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XBINARY_OPERATION__RIGHT_OPERAND
				&& getFeature(expr) instanceof JvmOperation) {
			JvmOperation feature = (JvmOperation) getFeature(expr);
			JvmFormalParameter parameter = getLast(feature.getParameters());
			ITypeArgumentContext context = getFeatureCallTypeArgContext(expr, rawType);
			final JvmTypeReference parameterType = parameter.getParameterType();
			JvmTypeReference result = context.getLowerBound(parameterType);
			return result;
		}
		if (reference == XbasePackage.Literals.XBINARY_OPERATION__LEFT_OPERAND
				&& getFeature(expr) instanceof JvmOperation) {
			JvmOperation operation = (JvmOperation) getFeature(expr);
			if (operation.getParameters().size() > 1) {
				JvmFormalParameter parameter = operation.getParameters().get(0);
				ITypeArgumentContext context = getFeatureCallTypeArgContext(expr, rawType);
				final JvmTypeReference parameterType = parameter.getParameterType();
				JvmTypeReference resolved = context.resolve(parameterType);
				return resolved;
			} else if (!operation.isStatic()) {
				// expectation for member call target for operations on objects 
				XExpression argumentExpression = getExpression(expr, reference, index);
				ITypeArgumentContext context = getFeatureCallTypeArgContext(expr, rawType);
				final JvmTypeReference declaringType = getTypeReferences().createTypeRef(operation.getDeclaringType());
				if (rawType)
					return declaringType;
				if (!rawType && argumentExpression != null) {
					JvmTypeReference receiverType = getType(argumentExpression, rawType);
					if (receiverType != null) {
						JvmTypeReference result = context.getLowerBound(receiverType);
						if (result != null && result.getType() instanceof JvmTypeParameter)
							return result;
					}
				}
				JvmTypeReference result = context.getLowerBound(declaringType);
				return result;
			}
		}
		return null;
	}

	/**
	 * @param index the feature index 
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _expectedType(XVariableDeclaration expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XVARIABLE_DECLARATION__RIGHT) {
			final JvmTypeReference type = expr.getType();
			return type;
		}
		return null; // no expectations
	}

	/**
	 * @param index the feature index 
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _expectedType(XCollectionLiteral expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XCOLLECTION_LITERAL__ELEMENTS) {
			final JvmTypeReference type = getExpectedType(expr);
			if(type instanceof JvmParameterizedTypeReference) {
				List<JvmTypeReference> arguments = ((JvmParameterizedTypeReference) type).getArguments();
				if(!arguments.isEmpty()) {
					JvmTypeReference jvmTypeReference = arguments.get(0);
					return jvmTypeReference;
				}
			}
		}
		return null; // no expectations
	}

	protected JvmTypeReference _expectedType(final XConstructorCall expr, EReference reference, int index, final boolean rawType) {
		if (reference == XbasePackage.Literals.XCONSTRUCTOR_CALL__ARGUMENTS) {
			final JvmConstructor constructor = getConstructor(expr);
			if (constructor != null && !constructor.eIsProxy()) {
				ITypeArgumentContext typeArgumentContext = getTypeArgumentContextProvider().getTypeArgumentContext(new TypeArgumentContextProvider.AbstractRequest() {
					@Override
					public List<JvmTypeReference> getExplicitTypeArgument() {
						return expr.getTypeArguments();
					}
					@Override
					public String toString() {
						return "XbaseTypeProvider.expectedType(XConstructorCall,..) [expr=" + expr + "]";
					}
					@Override
					public List<JvmTypeReference> getArgumentTypes() {
						List<JvmTypeReference> result = Arrays.asList(XbaseTypeProvider.this.getArgumentTypes(constructor, expr.getArguments(), rawType));
						return result;
					}
					@Override
					public JvmFeature getFeature() {
						return constructor;
					}
					@Override
					public JvmTypeParameterDeclarator getNearestDeclarator() {
						return XbaseTypeProvider.this.getNearestTypeParameterDeclarator(expr);
					}
				});
				
				if (index >= constructor.getParameters().size()) {
					if (constructor.isVarArgs()) {
						return getExpectedVarArgType(constructor, typeArgumentContext, rawType, true);
					}
					return null;
				}
				int argumentSize = expr.getArguments().size();
				int parameterSize = constructor.getParameters().size();
				if (constructor.isVarArgs() && index == constructor.getParameters().size() - 1) {
					return getExpectedVarArgType(constructor, typeArgumentContext, rawType, argumentSize > parameterSize);
				}
				JvmFormalParameter parameter = constructor.getParameters().get(index);
				JvmTypeReference parameterType = parameter.getParameterType();
				JvmTypeReference result = typeArgumentContext.getLowerBound(parameterType);
				return result;
			}
		}
		return null;
	}

	/**
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference getExpectedVarArgType(JvmExecutable feature, ITypeArgumentContext typeArgumentContext,
			boolean rawType, boolean forceComponentType) {
		JvmFormalParameter lastParameter = feature.getParameters().get(feature.getParameters().size() - 1);
		JvmTypeReference parameterType = lastParameter.getParameterType();
		if (parameterType instanceof JvmGenericArrayTypeReference) {
			JvmTypeReference componentType = ((JvmGenericArrayTypeReference) parameterType).getComponentType();
			JvmTypeReference componentTypeLowerBound = typeArgumentContext.getLowerBound(componentType);
			if (forceComponentType || componentTypeLowerBound == null) {
				return componentTypeLowerBound;
			}
			JvmTypeReference arrayType = null;
			if (componentTypeLowerBound.eContainer() != null) {
				JvmDelegateTypeReference delegate = getTypesFactory().createJvmDelegateTypeReference();
				delegate.setDelegate(componentTypeLowerBound);
				arrayType = getTypeReferences().createArrayType(delegate);
			} else {
				arrayType = getTypeReferences().createArrayType(componentTypeLowerBound);
			}
			JvmDelegateTypeReference wrappedComponentType = getTypesFactory().createJvmDelegateTypeReference();
			wrappedComponentType.setDelegate(componentTypeLowerBound);
			JvmSynonymTypeReference result = getTypesFactory().createJvmSynonymTypeReference();
			result.getReferences().add(arrayType);
			result.getReferences().add(wrappedComponentType);
			return result;
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

	/**
	 * @param index the feature index 
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _expectedType(XIfExpression expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XIF_EXPRESSION__IF) {
			return getTypeReferences().getTypeForName(Boolean.TYPE, expr);
		}
		return getExpectedType(expr, rawType);
	}

	/**
	 * @param expr the for loop expression whose expected child type shall be computed. May not be <code>null</code>.
	 * @param reference the feature that describes the child whose type is expected
	 * @param index the feature index 
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _expectedType(XForLoopExpression expr, EReference reference, int index, boolean rawType) {
		// Unless we can have multiple possible expected types (i.e. array and iterable), we shouldn't expect anything here
		// The conformance test is done explicitly in the validator.
		return null; // no expectations
	}

	/**
	 * @param index the feature index 
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _expectedType(XAbstractWhileExpression expr, EReference reference, int index,
			boolean rawType) {
		if (reference == XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__PREDICATE) {
			final JvmTypeReference typeForName = getTypeReferences().getTypeForName(Boolean.TYPE, expr);
			return typeForName;
		}
		return null; // no other expectations
	}

	/**
	 * @param index the feature index 
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _expectedType(XTryCatchFinallyExpression expr, EReference reference, int index,
			boolean rawType) {
		if (reference == XbasePackage.Literals.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION) {
			return getExpectedType(expr, rawType);
		}
		if (reference == XbasePackage.Literals.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSES) {
			return getExpectedType(expr, rawType);
		}
		return null; // no other expectations
	}

	/**
	 * @param index the feature index 
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _expectedType(XCatchClause expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XCATCH_CLAUSE__DECLARED_PARAM) {
			return getTypeReferences().getTypeForName(Throwable.class, expr);
		}
		return getExpectedType((XExpression) expr.eContainer(), rawType);
	}

	/**
	 * @param expr the casted expression that is the container of the child whose expected type should be computed. May not be <code>null</code>.
	 * @param reference the feature that describes the child whose type is expected
	 * @param index the feature index 
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _expectedType(XCastedExpression expr, EReference reference, int index, boolean rawType) {
		// SE: This was previously explicitly set to null :
		// "return null; // no expectations!"
		// Unfortunately there was no comment explaining why this was the case also no test besides the one which explicitly tested this was failing so I changed it back.
		// return expr.getType();
		// SZ: reverted the change
		// the following xtend thing can be casted but will fail if the expected type is taken from the cast expression
		// def <T extends Integer> addFunction() {\n" + 
		//	    [T a,T b|a+b] as (T,T)=>T\n" + 
		// }
		// if the closure expects T to be the return type
		// the check for the implicit return of int (a + b) will fail
		// since T result =/= Integer
		return null;
	}

	/**
	 * @param reference the feature that describes the child whose type is expected
	 * @param index the feature index 
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _expectedType(XThrowExpression expr, EReference reference, int index, boolean rawType) {
		return getTypeReferences().getTypeForName(Throwable.class, expr);
	}

	/**
	 * @param index the feature index 
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _expectedType(XReturnExpression expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XRETURN_EXPRESSION__EXPRESSION) {
			return getExpectedReturnType(expr, rawType);
		}
		return null; // no expectations!
	}

	/**
	 * @param index the feature index 
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _expectedType(XSwitchExpression expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XSWITCH_EXPRESSION__SWITCH) {
			return null; // no expectations // TODO should we expect Object?
		}
		return getExpectedType(expr, rawType);
	}

	/**
	 * @param index the feature index 
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _expectedType(XCasePart expr, EReference reference, int index, boolean rawType) {
		if (reference == XbasePackage.Literals.XCASE_PART__TYPE_GUARD) {
			return getTypeReferences().getTypeForName(Class.class, expr);
		}
		if (reference == XbasePackage.Literals.XCASE_PART__CASE) {
			final XSwitchExpression switchExpr = (XSwitchExpression) expr.eContainer();
			if (switchExpr.getSwitch() == null) {
				return getTypeReferences().getTypeForName(Boolean.TYPE, expr);
			}
			return null;
		}
		if (reference == XbasePackage.Literals.XCASE_PART__THEN) {
			return getExpectedType((XSwitchExpression) expr.eContainer(), rawType);
		}
		return null;
	}

	protected JvmTypeReference _type(XIfExpression object, JvmTypeReference rawExpectation, boolean rawType) {
		List<JvmTypeReference> returnTypes = newArrayList();
		final JvmTypeReference thenType = getType(object.getThen(), rawExpectation, rawType);
		if (thenType != null)
			returnTypes.add(thenType);
		JvmTypeReference elseType = null;
		if (object.getElse()!=null) {
			elseType = getType(object.getElse(), rawExpectation, rawType);
		}
		if (elseType != null)
			returnTypes.add(elseType);
		return getCommonType(returnTypes);
	}

	/**
	 * Returns the common type of the given types. 
	 * {@link #isFilteredFromCommonTypesList(JvmTypeReference) Filters} for primitive voids
	 * and unresolved types prior to asking the 
	 * {@link org.eclipse.xtext.common.types.util.TypeConformanceComputer TypeConformanceComputer}.
	 * 
	 */
	protected JvmTypeReference getCommonType(List<JvmTypeReference> types) {
		if (types.isEmpty()) {
			return null;
		}
		if (types.size() == 1) {
			JvmTypeReference result = getTypeConformanceComputer().getCommonSuperType(types);
			return result;
		}
		List<JvmTypeReference> filteredTypes = Lists.newArrayListWithExpectedSize(types.size());
		for(JvmTypeReference reference: types) {
			if (!isFilteredFromCommonTypesList(reference)) {
				filteredTypes.add(reference);
			}
		}
		if (filteredTypes.isEmpty()) {
			JvmTypeReference result = getTypeConformanceComputer().getCommonSuperType(types);
			return result;
		}
		JvmTypeReference result = getTypeConformanceComputer().getCommonSuperType(filteredTypes);
		return result;
	}

	protected boolean isFilteredFromCommonTypesList(JvmTypeReference reference) {
		if (reference == null)
			return true;
		if (reference instanceof JvmMultiTypeReference && ((JvmMultiTypeReference) reference).getReferences().isEmpty())
			return true;
		if (reference instanceof JvmAnyTypeReference)
			return false;
		// TODO use IEarlyExitComputer
		if (reference.getType() instanceof JvmVoid && !reference.getType().eIsProxy())
			return true;
		return false;
	}

	protected JvmTypeReference _type(XSwitchExpression object, JvmTypeReference rawExpectation, boolean rawType) {
		List<JvmTypeReference> returnTypes = Lists.newArrayList();
		EList<XCasePart> cases = object.getCases();
		for (XCasePart xCasePart : cases) {
			final JvmTypeReference unconverted = getType(xCasePart.getThen(), rawExpectation, rawType);
			if (unconverted != null)
				returnTypes.add(unconverted);
		}
		if (object.getDefault() != null) {
			final JvmTypeReference unconverted = getType(object.getDefault(), rawExpectation, rawType);
			if (unconverted != null)
				returnTypes.add(unconverted);
		} else {
			returnTypes.add(getTypeReferences().createAnyTypeReference(object));
		}
		return getCommonType(returnTypes);
	}

	protected JvmTypeReference _type(XBlockExpression object, JvmTypeReference rawExpectation, boolean rawType) {
		List<XExpression> expressions = object.getExpressions();
		if (expressions.isEmpty())
			return getTypeReferences().createAnyTypeReference(object);
		final JvmTypeReference result = getType(expressions.get(expressions.size() - 1), rawExpectation, rawType);
		return result;
	}

	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(XVariableDeclaration object, JvmTypeReference rawExpectation, boolean rawType) {
		return getPrimitiveVoid(object);
	}

	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 */
	protected JvmTypeReference _type(final XConstructorCall constructorCall, JvmTypeReference rawExpectation, boolean rawType) {
		final JvmConstructor constructor = getConstructor(constructorCall);
		if (constructor == null || constructor.eIsProxy())
			return null;
		final JvmTypeReference constructorResultType = getTypeForIdentifiable(constructor, rawType);
		final JvmTypeParameterDeclarator nearestTypeParameterDeclarator = getNearestTypeParameterDeclarator(constructorCall);
		if (isResolved(constructorResultType, nearestTypeParameterDeclarator, rawType)) {
			return constructorResultType;
		}
		rawType = false; // inlined below
		ITypeArgumentContext context = getTypeArgumentContext(constructorCall, constructor);
		JvmTypeReference result = context.getUpperBound(constructorResultType, constructorCall);
		return result;
	}

	public ITypeArgumentContext getTypeArgumentContext(
			final XConstructorCall constructorCall,
			final JvmConstructor constructor) {
		ITypeArgumentContext context = getTypeArgumentContextProvider().getTypeArgumentContext(new TypeArgumentContextProvider.AbstractRequest() {
			@Override
			public JvmFeature getFeature() {
				return constructor;
			}
			@Override
			public String toString() {
				return "XbaseTypeProvider.type(XConstructorCall,..) [constructorCall=" + constructorCall + "]";
			}
			@Override
			public JvmTypeParameterDeclarator getNearestDeclarator() {
				return getNearestTypeParameterDeclarator(constructorCall);
			}
			@Override
			public List<JvmTypeReference> getExplicitTypeArgument() {
				return constructorCall.getTypeArguments();
			}
			@Override
			public List<JvmTypeReference> getArgumentTypes() {
				return Arrays.asList(XbaseTypeProvider.this.getArgumentTypes(constructor, constructorCall.getArguments(), false));
			}
			@Override
			public JvmTypeReference getExpectedType() {
				return XbaseTypeProvider.this.getExpectedType(constructorCall, false);
			}
			@Override
			public JvmTypeReference getDeclaredType() {
				return getTypeForIdentifiable(constructor, false);
			}
		});
		return context;
	}
	
	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(XBooleanLiteral object, JvmTypeReference rawExpectation, boolean rawType) {
		return getTypeReferences().getTypeForName(Boolean.TYPE, object);
	}

	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(XNullLiteral object, JvmTypeReference rawExpectation, boolean rawType) {
		JvmAnyTypeReference result = getTypeReferences().createAnyTypeReference(object);
		return result;
	}

	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(XNumberLiteral object, JvmTypeReference rawExpectation, boolean rawType) {
		return getTypeReferences().getTypeForName(numberLiterals.getJavaType(object), object);
	}

	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(XStringLiteral object, JvmTypeReference rawExpectation, boolean rawType) {
		return getTypeReferences().getTypeForName(String.class, object);
//		if (object.getValue().length() != 1)
//			return getTypeReferences().getTypeForName(String.class, object);
//		JvmTypeReference stringType = getTypeReferences().getTypeForName(String.class, object);
//		JvmTypeReference charType = getTypeReferences().getTypeForName(Character.TYPE, object);
//		XSynonymTypeReference result = xtypesFactory.createXSynonymTypeReference();
//		result.getSynonymes().add(stringType);
//		result.getSynonymes().add(charType);
//		return result;
	}

	protected JvmTypeReference _type(XListLiteral literal, JvmTypeReference rawExpectation, boolean rawType) {
		JvmType list = typeReferences.findDeclaredType(List.class, literal);
		return getCollectionLiteralType(list, literal, rawExpectation, rawType);
	}

	protected JvmTypeReference _type(XSetLiteral literal, JvmTypeReference rawExpectation, boolean rawType) {
		JvmType set = typeReferences.findDeclaredType(Set.class, literal);
		return getCollectionLiteralType(set, literal, rawExpectation, rawType);
	}

	protected JvmTypeReference getCollectionLiteralType(JvmType collectionRawType, XCollectionLiteral literal, JvmTypeReference rawExpectation, boolean rawType) {
		JvmTypeReference commonElementType = getCommonElementType(literal, rawExpectation, rawType);
		JvmTypeReference typeArgument;
		if(commonElementType != null && !(commonElementType instanceof JvmAnyTypeReference)) 
			typeArgument = primitives.asWrapperTypeIfPrimitive(commonElementType);
		else 
			typeArgument = typeReferences.getTypeForName(Object.class, literal);
		return typeReferences.createTypeRef(collectionRawType, typeArgument);
	}
	
	protected JvmTypeReference getCommonElementType(XCollectionLiteral literal, JvmTypeReference rawExpectation, boolean rawType) {
		List<JvmTypeReference> elementTypes = newArrayList();
		for(XExpression element: literal.getElements()) {
			JvmTypeReference type = getType(element, rawExpectation, rawType);
			if(type != null) {
				elementTypes.add(type);
			}
		}
		return getCommonType(elementTypes);
	}

	protected JvmTypeReference _type(final XClosure object, JvmTypeReference rawExpectation, final boolean rawType) {
		JvmOperation singleMethod = null;
		JvmTypeReference returnType = null;
		JvmTypeReference expectedRawType = rawExpectation == null ? getExpectedType(object, true) : rawExpectation;
		if (expectedRawType != null) {
			singleMethod = closures.findImplementingOperation(expectedRawType, object.eResource());
			if (singleMethod == null && !isResolved(expectedRawType, getNearestTypeParameterDeclarator(object), false)) {
				expectedRawType = getExpectedType(object, false);
				singleMethod = closures.findImplementingOperation(expectedRawType, object.eResource());
			}
		}
		boolean procedure = false;
		if (singleMethod != null) {
			procedure = getTypeReferences().is(singleMethod.getReturnType(), Void.TYPE);
		}
		if (rawType) {
			JvmParameterizedTypeReference result = closures.createRawFunctionTypeRef(
					object, object.getFormalParameters().size(), procedure);
			return result;
		}
		if (procedure && singleMethod != null)
			returnType = singleMethod.getReturnType();
		else
			returnType = getCommonReturnType(object.getExpression(), true);
		if (returnType instanceof JvmAnyTypeReference) {
			JvmTypeReference type = getExpectedType(object.getExpression());
			if (singleMethod != null) {
				if (isResolved(type, singleMethod, rawType))
					returnType = type;
			} else {
				returnType = type;
			}
		}
		List<JvmTypeReference> parameterTypes = Lists.newArrayList();
		List<JvmFormalParameter> params = object.getFormalParameters();
		for (JvmFormalParameter param : params) {
			parameterTypes.add(param.getParameterType());
		}
		// inferred argument types?
		if (!params.isEmpty() && singleMethod != null) {
			ITypeArgumentContext context = getTypeArgumentContextProvider().getTypeArgumentContext(
					new TypeArgumentContextProvider.AbstractRequest() {
						@Override
						public JvmTypeReference getReceiverType() {
							return XbaseTypeProvider.this.getExpectedType(object, rawType);
						}
					});
			for (int i = 0; i < params.size(); i++) {
				JvmTypeReference resultParam = parameterTypes.get(i);
				if (resultParam == null) {
					JvmFormalParameter p = getParam(singleMethod, i);
					if (p != null) {
						final JvmTypeReference resolved = context.getLowerBound(p.getParameterType());
						parameterTypes.set(i, resolved);
					}
				}
			}
		}
		JvmTypeReference result = closures.createFunctionTypeRef(object, parameterTypes, returnType, true);
		return result;
	}

	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(XCastedExpression object, JvmTypeReference rawExpectation, boolean rawType) {
		return object.getType();
	}

	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(XForLoopExpression object, JvmTypeReference rawExpectation, boolean rawType) {
		return getPrimitiveVoid(object);
	}

	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(XAbstractWhileExpression object, JvmTypeReference rawExpectation, boolean rawType) {
		return getPrimitiveVoid(object);
	}

	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(XTypeLiteral object, JvmTypeReference rawExpectation, boolean rawType) {
		JvmParameterizedTypeReference typeRef = factory.createJvmParameterizedTypeReference();
		typeRef.setType(object.getType());
		JvmTypeReference result = typeRef;
		for (int i = 0; i < object.getArrayDimensions().size(); i++) {
			JvmGenericArrayTypeReference arrayType = getTypesFactory().createJvmGenericArrayTypeReference();
			arrayType.setComponentType(result);
			result = arrayType;
		}
		return getTypeReferences().getTypeForName(Class.class, object, result);
	}

	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(XInstanceOfExpression object, JvmTypeReference rawExpectation, boolean rawType) {
		return getTypeReferences().getTypeForName(Boolean.TYPE, object);
	}

	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(XThrowExpression object, JvmTypeReference rawExpectation, boolean rawType) {
		final JvmTypeReference typeForName = getPrimitiveVoid(object);
		return typeForName;
	}

	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(XReturnExpression object, JvmTypeReference rawExpectation, boolean rawType) {
		final JvmTypeReference typeForName = getPrimitiveVoid(object);
		return typeForName;
	}
	
	protected JvmTypeReference getPrimitiveVoid(XExpression object) {
		return getTypeReferences().getTypeForName(Void.TYPE, object);
	}

	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(XTryCatchFinallyExpression object, JvmTypeReference rawExpectation, boolean rawType) {
		List<JvmTypeReference> returnTypes = newArrayList();
		final JvmTypeReference getType = getType(object.getExpression(), rawType);
		if(getType != null) 
			returnTypes.add(getType);
		for (XCatchClause catchClause : object.getCatchClauses()) {
			JvmTypeReference type = getType(catchClause.getExpression(), rawType);
			if(type != null)
				returnTypes.add(type);
		}
		JvmTypeReference commonSuperType = getCommonType(returnTypes);
		return commonSuperType;
	}

	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(final XFeatureCall featureCall, JvmTypeReference rawExpectation, boolean rawType) {
		XCasePart typeGuardedXCasePartContainer = findTypeGuardedXCasePartContainer(featureCall, featureCall);
		JvmTypeReference plainType = _type((XAbstractFeatureCall) featureCall, rawExpectation, rawType);
  		if (plainType != null && typeGuardedXCasePartContainer != null) {
			JvmTypeReference typeGuard = typeGuardedXCasePartContainer.getTypeGuard();
			if(getTypeConformanceComputer().isConformant(plainType, typeGuard))
				return typeGuard;
			else if (getTypeConformanceComputer().isConformant(typeGuard, plainType))
				return plainType;
			else
				return getTypeReferences().createMultiTypeReference(typeGuardedXCasePartContainer, typeGuard, plainType);
		}
		return plainType;
	}

	protected XCasePart findTypeGuardedXCasePartContainer(final EObject context, XFeatureCall call) {
		if (context == null)
			return null;
		XCasePart containerCase = EcoreUtil2.getContainerOfType(context, XCasePart.class);
		if (containerCase == null)
			return null;
		if (containerCase.getTypeGuard() != null) {
			XSwitchExpression containerSwitch = (XSwitchExpression) containerCase.eContainer();
			XExpression switchExpression = containerSwitch.getSwitch();
			JvmIdentifiableElement calledFeature = getFeature(call);
			if (calledFeature == containerSwitch
					|| (switchExpression instanceof XFeatureCall && getFeature((XFeatureCall) switchExpression) == calledFeature))
				return containerCase;
		}
		return findTypeGuardedXCasePartContainer(containerCase.eContainer(), call);
	}

	/**
	 * @param rawExpectation the expected raw type if set from the outside. May be <code>null</code>.
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _type(final XAbstractFeatureCall featureCall, JvmTypeReference rawExpectation,
			boolean rawType) {
		final JvmIdentifiableElement feature = getFeature(featureCall);
		if (feature == null || feature.eIsProxy())
			return null;
		if (feature instanceof JvmConstructor) {
			return getPrimitiveVoid(featureCall);
		}
		final JvmTypeReference featureType = getTypeForIdentifiable(feature, rawType);
		final JvmTypeParameterDeclarator nearestTypeParameterDeclarator = getNearestTypeParameterDeclarator(featureCall);
		if (isResolved(featureType, nearestTypeParameterDeclarator, rawType)) {
			return featureType;
		}
		// method was either already called with rawType==false or the featureType points directly to a JvmTypeParameter
		rawType = false; // inlined below
		ITypeArgumentContext context = getTypeArgumentContext(
				featureCall, 
				featureCall2javaMapping.getActualArguments(featureCall),
				new Provider<JvmTypeReference>() {
					public JvmTypeReference get() {
						JvmTypeReference result = XbaseTypeProvider.this.getReceiverType(featureCall, false);
						return result;
					}
				},
				feature);
		JvmTypeReference result = context.getUpperBound(featureType, featureCall);
		return result;
	}

	public ITypeArgumentContext getTypeArgumentContext(
			final XAbstractFeatureCall featureCall,
			final List<XExpression> actualArguments,
			final Provider<JvmTypeReference> receiverTypeProvider,
			final JvmIdentifiableElement feature) {
		ITypeArgumentContext context = getTypeArgumentContextProvider().getTypeArgumentContext(new XbaseTypeArgumentContextProvider.AbstractFeatureCallRequest() {
			@Override
			public JvmFeature getFeature() {
				if (feature instanceof JvmFeature)
					return (JvmFeature)feature;
				return null;
			}
			@Override
			public XAbstractFeatureCall getFeatureCall() {
				return featureCall;
			}
			@Override
			public String toString() {
				return "XbaseTypeProvider.type(XAbstractFeatureCall,..) [featureCall=" + featureCall + "]";
			}
			@Override
			public JvmTypeParameterDeclarator getNearestDeclarator() {
				return getNearestTypeParameterDeclarator(featureCall);
			}
			@Override
			public List<JvmTypeReference> getExplicitTypeArgument() {
				return featureCall.getTypeArguments();
			}
			@Override
			public List<JvmTypeReference> getArgumentTypes() {
				if (feature instanceof JvmExecutable) {
					List<JvmTypeReference> result = Arrays.asList(XbaseTypeProvider.this.getArgumentTypes((JvmExecutable) feature, actualArguments, false));
					return result;	
				}
				return null;
			}
			@Override
			public JvmTypeReference getExpectedType() {
				JvmTypeReference result = XbaseTypeProvider.this.getExpectedType(featureCall, false);
				return result;
			}
			@Override
			public JvmTypeReference getReceiverType() {
				if (receiverTypeProvider != null)
					return receiverTypeProvider.get();
				return null;
			}
			@Override
			public JvmTypeReference getDeclaredType() {
				return getTypeForIdentifiable(feature, false);
			}
		});
		return context;
	}

	@Inject
	private SynonymTypesProvider synonymTypesProvider;

	protected JvmTypeReference _typeForIdentifiable(XVariableDeclaration object, boolean rawType) {
		if (object.getType() != null)
			return object.getType();
		return getType(object.getRight(), rawType);
	}

	protected JvmTypeReference _typeForIdentifiable(JvmFormalParameter parameter, boolean rawType) {
		if (parameter.getParameterType() == null) {
			if (parameter.eContainer() instanceof XSwitchExpression) {
				XSwitchExpression switchExpression = (XSwitchExpression) parameter.eContainer();
				return getType(switchExpression.getSwitch(), rawType);
			} else if (parameter.eContainer() instanceof XClosure) {
				final XClosure closure = (XClosure) parameter.eContainer();
				JvmTypeReference type = getExpectedType(closure, rawType);
				if (type == null) {
					return getTypeReferences().getTypeForName(Object.class, parameter);
				}
				int indexOf = closure.getFormalParameters().indexOf(parameter);
				JvmOperation operation = closures.findImplementingOperation(type, parameter.eResource());
				if (operation == null && rawType && !isResolved(type, getNearestTypeParameterDeclarator(parameter), false)) {
					type = getExpectedType(closure, false);
					if (type != null) {
						operation = closures.findImplementingOperation(type, parameter.eResource());
					}
				}
				if (operation != null && indexOf < operation.getParameters().size()) {
					JvmFormalParameter declaredParam = getParam(operation, indexOf);
					if (rawType) {
						if (declaredParam.getParameterType().getType() instanceof JvmTypeParameter) {
							JvmTypeReference result = _typeForIdentifiable(parameter, false);
							return result;
						}
					}
					ITypeArgumentContext context = getTypeArgumentContextProvider().getTypeArgumentContext(
							new TypeArgumentContextProvider.ReceiverRequest(type));
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
				JvmTypeReference reference = getType(forLoop.getForExpression(), false);
				if (reference == null)
					return null;
				ITypeArgumentContext context = getTypeArgumentContextProvider().getTypeArgumentContext(
						new TypeArgumentContextProvider.ReceiverRequest(reference));
				final String iterableName = Iterable.class.getName();
				// TODO remove the special array treatment and put into some generic facility
				if (reference instanceof JvmGenericArrayTypeReference) {
					JvmTypeReference type = ((JvmGenericArrayTypeReference) reference).getComponentType();
					return type;
				}
				if (reference.getType() instanceof JvmArrayType) {
					JvmArrayType type = (JvmArrayType) reference.getType();
					JvmTypeReference result = getTypeReferences().createTypeRef(type);
					return result;
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
				if (reference instanceof JvmParameterizedTypeReference) {
					JvmParameterizedTypeReference parameterized = (JvmParameterizedTypeReference) reference;
					if (parameterized.getArguments().size() > 0) {
						JvmTypeReference result = context.getUpperBound(parameterized.getArguments().get(0), parameter);
						return result;
					}
				}
			}
		}
		return parameter.getParameterType();
	}
	
	@Override
	protected JvmTypeReference handleCycleGetTypeForIdentifiable(JvmIdentifiableElement identifiableElement,
			boolean rawType) {
		if (identifiableElement instanceof JvmFormalParameter && identifiableElement.eContainer() instanceof XClosure) {
			return _typeForIdentifiable((JvmFormalParameter) identifiableElement, rawType);
		}
		return super.handleCycleGetTypeForIdentifiable(identifiableElement, rawType);
	}

	/**
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _typeForIdentifiable(JvmGenericType thisOrSuper, boolean rawType) {
		if (thisOrSuper.eIsProxy())
			return null;
		JvmParameterizedTypeReference reference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		reference.setType(thisOrSuper);
		for (JvmTypeParameter param : thisOrSuper.getTypeParameters()) {
			JvmParameterizedTypeReference paramReference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
			paramReference.setType(param);
			reference.getArguments().add(paramReference);
		}
		return reference;
	}
	
	/**
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _typeForIdentifiable(JvmConstructor constructor, boolean rawType) {
		if (constructor.eIsProxy())
			return null;
		JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
		JvmDeclaredType declaringType = constructor.getDeclaringType();
		reference.setType(declaringType);
		if (declaringType instanceof JvmGenericType) {
			for(JvmTypeParameter typeParam: ((JvmGenericType)declaringType).getTypeParameters()) {
				reference.getArguments().add(getTypeReferences().createTypeRef(typeParam));
			}
		}
		return reference;
	}

	/**
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _typeForIdentifiable(JvmField field, boolean rawType) {
		return field.getType();
	}

	/**
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _typeForIdentifiable(JvmOperation operation, boolean rawType) {
		return operation.getReturnType();
	}
	
	/**
	 * @param rawType <code>true</code> if we are only interested in the raw type
	 */
	protected JvmTypeReference _typeForIdentifiable(JvmType type, boolean rawType) {
		if (type.eIsProxy())
			return null;
		return getTypeReferences().createTypeRef(type);
	}

	/**
	 * Closures don't exit early and nested expressions have no impact on the container.
	 * @param expr the closure. 
	 * @param a the collector of the early exit result.
	 */
	protected void _earlyExits(XClosure expr, EarlyExitAcceptor a) {
		// Don't go into closures
	}
	
	protected void _earlyExits(XReturnExpression expr, EarlyExitAcceptor acceptor) {
		if (expr.getExpression()!=null) {
			JvmTypeReference type = getType(expr.getExpression());
			if (type != null)
				acceptor.returns.add(type);
			internalCollectEarlyExits(expr.getExpression(), acceptor);
		}
	}
	
	protected void _earlyExits(XThrowExpression expr, EarlyExitAcceptor acceptor) {
		if (expr.getExpression()!=null) {
			JvmTypeReference type = getType(expr.getExpression());
			if (type != null)
				acceptor.thrown.add(type);
			internalCollectEarlyExits(expr.getExpression(), acceptor);
		}
	}
	
	protected void _earlyExits(XConstructorCall expr, EarlyExitAcceptor acceptor) {
		Iterable<JvmTypeReference> thrownExceptions = getThrownExceptionForIdentifiable(getConstructor(expr));
		if (thrownExceptions!=null) {
			acceptor.appendThrown(thrownExceptions);
		}
		_earlyExits((EObject)expr, acceptor);
	}
	
	protected void _earlyExits(XAbstractFeatureCall expr, EarlyExitAcceptor acceptor) {
		Iterable<JvmTypeReference> thrownExceptions = getThrownExceptionForIdentifiable(getFeature(expr));
		if (thrownExceptions!=null) {
			acceptor.appendThrown(thrownExceptions);
		}
		_earlyExits((EObject)expr, acceptor);
	}

	protected void _earlyExits(XTryCatchFinallyExpression expr, EarlyExitAcceptor acceptor) {
		EarlyExitAcceptor innerAcceptor = new EarlyExitAcceptor();
		internalCollectEarlyExits(expr.getExpression(), innerAcceptor);
		acceptor.returns.addAll(innerAcceptor.returns);
		for (XCatchClause catchClause : expr.getCatchClauses()) {
			Iterator<JvmTypeReference> iterator = innerAcceptor.thrown.iterator();
			while (iterator.hasNext()) {
				JvmTypeReference thrown = iterator.next();
				if (getTypeConformanceComputer().isConformant(catchClause.getDeclaredParam().getParameterType(), thrown)) {
					iterator.remove();
				}
			}
			internalCollectEarlyExits(catchClause.getExpression(), acceptor);
		}
		acceptor.thrown.addAll(innerAcceptor.thrown);
		if (expr.getFinallyExpression()!=null)
			internalCollectEarlyExits(expr.getFinallyExpression(), acceptor);
	}
	
	protected TypesFactory getTypesFactory() {
		return factory;
	}
	
	public Iterable<JvmTypeReference> getThrownExceptionForIdentifiable(JvmIdentifiableElement identifiable) {
		if (identifiable==null || identifiable.eIsProxy()) {
			return emptySet();
		}
		if (identifiable instanceof JvmExecutable) {
			return ((JvmExecutable) identifiable).getExceptions();
		}
		return emptySet();
	}

	public JvmTypeReference getExpectedReturnType(XExpression expr, boolean rawType) {
		XClosure closure = EcoreUtil2.getContainerOfType(expr, XClosure.class);
		if (closure!=null) {
			JvmTypeReference expectedReturnType = getExpectedType(closure.getExpression());
			if (expectedReturnType != null) {
				return expectedReturnType;
			}
			return null;
		}
		JvmIdentifiableElement logicalContainer = getLogicalContainerProvider().getNearestLogicalContainer(expr);
		if (logicalContainer instanceof JvmOperation) {
			return ((JvmOperation) logicalContainer).getReturnType();
		}
		if (logicalContainer instanceof JvmConstructor) {
			return getPrimitiveVoid(expr);
		}
		if (logicalContainer instanceof JvmField) {
			return ((JvmField) logicalContainer).getType();
		}
		return null;
	}
	
}
