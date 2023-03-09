/*******************************************************************************
 * Copyright (c) 2010, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter.impl;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;
import static org.eclipse.xtext.util.Strings.*;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.impl.ClassFinder;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ReflectionUtil;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
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
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.util.XExpressionHelper;
import org.eclipse.xtext.xbase.util.XSwitchExpressions;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 * @author Eva Poell - support for try with resources
 */
public class XbaseInterpreter implements IExpressionInterpreter {
	
	/**
	 * Encapsulates the return value of an {@link XReturnExpression}.
	 *
	 * To be able to break up the control flow of the interpreter, this class inherits from {@link RuntimeException}.
	 * Clients that catch the ReturnValue, should usually re-throw it further.
	 * See also {@link #_doEvaluate(XTryCatchFinallyExpression, IEvaluationContext, CancelIndicator) }
	 * where the finally clause is evaluated after the return value has been computed but the original
	 * return value is propagated further, if the finally block completes normally.
	 * 
	 * @since 2.25
	 */
	@SuppressWarnings("serial")
	public static class ReturnValue extends RuntimeException {
		public Object returnValue;
		public ReturnValue(Object value) {
			super();
			this.returnValue = value;
		}
	}
	
	public XbaseInterpreter() {
	}

	public XbaseInterpreter(Provider<IEvaluationContext> contextProvider, JavaReflectAccess javaReflectAccess,
			ClassLoader loader) {
		this.contextProvider = contextProvider;
		this.javaReflectAccess = javaReflectAccess;
		setClassLoader(loader);
	}

	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private IdentifiableSimpleNameProvider featureNameProvider;

	public void setFeatureNameProvider(IdentifiableSimpleNameProvider featureNameProvider) {
		this.featureNameProvider = featureNameProvider;
	}

	@Inject
	private Provider<IEvaluationContext> contextProvider;

	@Inject
	private JavaReflectAccess javaReflectAccess;
	
	@Inject
	private XExpressionHelper expressionHelper;
	
	@Inject
	private NumberLiterals numberLiterals;

	@Inject
	private IBatchTypeResolver typeResolver;
	
	@Inject
	private XSwitchExpressions switchExpressions;
	
	private ClassFinder classFinder;

	private ClassLoader classLoader;
	
	@Inject
	public void setClassLoader(ClassLoader classLoader) {
		this.classFinder = createClassFinder(classLoader);
		this.classLoader = classLoader;
		this.javaReflectAccess.setClassLoader(classLoader);
	}

	/**
	 * @since 2.18
	 */
	protected ClassFinder createClassFinder(ClassLoader classLoader) {
		return new ClassFinder(classLoader);
	}
	
	protected Class<?> getClass(Class<?> class1) {
		try {
			return classLoader.loadClass(class1.getName());
		} catch (ClassNotFoundException e) {
			throw new EvaluationException(e);
		}
	}

	@Override
	public IEvaluationResult evaluate(XExpression expression) {
		return evaluate(expression, createContext(), CancelIndicator.NullImpl);
	}

	protected IEvaluationContext createContext() {
		return contextProvider.get();
	}
	
	@Override
	public IEvaluationResult evaluate(XExpression expression, IEvaluationContext context, CancelIndicator indicator) {
		try {
			Object result = internalEvaluate(expression, context,indicator!=null?indicator:CancelIndicator.NullImpl);
			return new DefaultEvaluationResult(result, null);
		} catch (ReturnValue e) {
			return new DefaultEvaluationResult(e.returnValue, null);
		} catch (EvaluationException e) {
			return new DefaultEvaluationResult(null, e.getCause());
		} catch (InterpreterCanceledException e) {
			return null;
		}
	}

	protected Object internalEvaluate(XExpression expression, IEvaluationContext context, CancelIndicator indicator) throws EvaluationException {
		if (indicator.isCanceled())
			throw new InterpreterCanceledException();
		Object result = doEvaluate(expression, context, indicator);
		final LightweightTypeReference expectedType = typeResolver.resolveTypes(expression).getExpectedType(expression);
		if(expectedType != null)
			result = wrapOrUnwrapArray(result, expectedType);
		return result;
	}
	
	/**
	 * don't call this directly. Always call evaluate() internalEvaluate()
	 */
	protected Object doEvaluate(XExpression expression, IEvaluationContext context, CancelIndicator indicator) {
		if (expression instanceof XAssignment) {
	      return _doEvaluate((XAssignment)expression, context, indicator);
	    } else if (expression instanceof XDoWhileExpression) {
	      return _doEvaluate((XDoWhileExpression)expression, context, indicator);
	    } else if (expression instanceof XMemberFeatureCall) {
	      return _doEvaluate((XMemberFeatureCall)expression, context, indicator);
	    } else if (expression instanceof XWhileExpression) {
	      return _doEvaluate((XWhileExpression)expression, context, indicator);
	    } else if (expression instanceof XFeatureCall) {
	    	return _doEvaluate((XFeatureCall)expression, context, indicator);
	    } else if (expression instanceof XAbstractFeatureCall) {
	    	return _doEvaluate((XAbstractFeatureCall)expression, context, indicator);
	    } else if (expression instanceof XBlockExpression) {
	      return _doEvaluate((XBlockExpression)expression, context, indicator);
	    } else if (expression instanceof XSynchronizedExpression) {
		  return _doEvaluate((XSynchronizedExpression)expression, context, indicator);
		} else if (expression instanceof XBooleanLiteral) {
	      return _doEvaluate((XBooleanLiteral)expression, context, indicator);
	    } else if (expression instanceof XCastedExpression) {
	      return _doEvaluate((XCastedExpression)expression, context, indicator);
	    } else if (expression instanceof XClosure) {
	      return _doEvaluate((XClosure)expression, context, indicator);
	    } else if (expression instanceof XConstructorCall) {
	      return _doEvaluate((XConstructorCall)expression, context, indicator);
	    } else if (expression instanceof XForLoopExpression) {
	      return _doEvaluate((XForLoopExpression)expression, context, indicator);
	    } else if (expression instanceof XBasicForLoopExpression) {
		  return _doEvaluate((XBasicForLoopExpression)expression, context, indicator);
		} else if (expression instanceof XIfExpression) {
	      return _doEvaluate((XIfExpression)expression, context, indicator);
	    } else if (expression instanceof XInstanceOfExpression) {
	      return _doEvaluate((XInstanceOfExpression)expression, context, indicator);
	    } else if (expression instanceof XNullLiteral) {
	      return _doEvaluate((XNullLiteral)expression, context, indicator);
	    } else if (expression instanceof XNumberLiteral) {
	      return _doEvaluate((XNumberLiteral)expression, context, indicator);
	    } else if (expression instanceof XReturnExpression) {
	      return _doEvaluate((XReturnExpression)expression, context, indicator);
	    } else if (expression instanceof XStringLiteral) {
	      return _doEvaluate((XStringLiteral)expression, context, indicator);
	    } else if (expression instanceof XSwitchExpression) {
	      return _doEvaluate((XSwitchExpression)expression, context, indicator);
	    } else if (expression instanceof XThrowExpression) {
	      return _doEvaluate((XThrowExpression)expression, context, indicator);
	    } else if (expression instanceof XTryCatchFinallyExpression) {
	      return _doEvaluate((XTryCatchFinallyExpression)expression, context, indicator);
	    } else if (expression instanceof XTypeLiteral) {
	      return _doEvaluate((XTypeLiteral)expression, context, indicator);
	    } else if (expression instanceof XVariableDeclaration) {
		      return _doEvaluate((XVariableDeclaration)expression, context, indicator);
	    } else if (expression instanceof XListLiteral) {
		      return _doEvaluate((XListLiteral)expression, context, indicator);
	    } else if (expression instanceof XSetLiteral) {
		      return _doEvaluate((XSetLiteral)expression, context, indicator);
	    } else {
	      throw new IllegalArgumentException("Unhandled parameter types: " +
	        Arrays.<Object>asList(expression, context, indicator).toString());
	    }
	}

	/**
	 * @param literal unused in this context but required for dispatching 
	 * @param context unused in this context but required for dispatching
	 * @param indicator unused in this context but required for dispatching
	 */
	protected Object _doEvaluate(XNullLiteral literal, IEvaluationContext context, CancelIndicator indicator) {
		return null;
	}
	
	protected Object _doEvaluate(XReturnExpression returnExpr, IEvaluationContext context, CancelIndicator indicator) {
		XExpression expression = returnExpr.getExpression();
		if (expression != null) {
			Object returnValue = internalEvaluate(returnExpr.getExpression(), context, indicator);
			throw new ReturnValue(returnValue);
		} else {
			throw new ReturnValue(null);
		}
	}

	/**
	 * @param context unused in this context but required for dispatching
	 * @param indicator unused in this context but required for dispatching
	 */
	protected Object _doEvaluate(XStringLiteral literal, IEvaluationContext context, CancelIndicator indicator) {
		LightweightTypeReference type = typeResolver.resolveTypes(literal).getActualType(literal);
		if (type != null && (type.isType(Character.TYPE) || type.isType(Character.class))) {
			return literal.getValue().charAt(0);
		}
		return literal.getValue();
	}

	/**
	 * @param context unused in this context but required for dispatching
	 * @param indicator unused in this context but required for dispatching
	 */
	@SuppressWarnings("unchecked")
	protected Object _doEvaluate(XNumberLiteral literal, IEvaluationContext context, CancelIndicator indicator) {
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(literal);
		LightweightTypeReference expectedType = resolvedTypes.getExpectedType(literal);
		Class<? extends Number> type = numberLiterals.getJavaType(literal);
		if (expectedType != null && expectedType.isSubtypeOf(Number.class)) {
			try {
				Class<?> expectedClassType = getJavaType(expectedType.toJavaCompliantTypeReference().getType());
				if (expectedClassType.isPrimitive()) {
					expectedClassType = ReflectionUtil.getObjectType(expectedClassType);
				}
				if (Number.class != expectedClassType && Number.class.isAssignableFrom(expectedClassType)) {
					type = (Class<? extends Number>) expectedClassType;
				}
			} catch (ClassNotFoundException e) {
			}
		}
		return numberLiterals.numberValue(literal, type);
	}

	/**
	 * @param context unused in this context but required for dispatching
	 * @param indicator unused in this context but required for dispatching
	 */
	protected Object _doEvaluate(XBooleanLiteral literal, IEvaluationContext context, CancelIndicator indicator) {
		return literal.isIsTrue();
	}

	/**
	 * @param context unused in this context but required for dispatching
	 * @param indicator unused in this context but required for dispatching
	 */
	protected Object _doEvaluate(XTypeLiteral literal, IEvaluationContext context, CancelIndicator indicator) {
		if (literal.getType() == null || literal.getType().eIsProxy()) {
			List<INode> nodesForFeature = NodeModelUtils.findNodesForFeature(literal,
					XbasePackage.Literals.XTYPE_LITERAL__TYPE);
			// TODO cleanup
			if (nodesForFeature.isEmpty())
				throw new EvaluationException(new ClassNotFoundException());
			throw new EvaluationException(new ClassNotFoundException(nodesForFeature.get(0).getText()));
		}
		JvmType type = literal.getType();
		Object result = translateJvmTypeToResult(type, literal.getArrayDimensions().size());
		return result;
	}

	protected Object _doEvaluate(XListLiteral literal, IEvaluationContext context, CancelIndicator indicator) {
		IResolvedTypes resolveTypes = typeResolver.resolveTypes(literal);
		LightweightTypeReference type = resolveTypes.getActualType(literal);
		List<Object> list = newArrayList();
		for(XExpression element: literal.getElements()) {
			if (indicator.isCanceled())
				throw new InterpreterCanceledException();
			list.add(internalEvaluate(element, context, indicator));
		}
		if(type != null && type.isArray()) {
			try {
				LightweightTypeReference componentType = type.getComponentType();
				return Conversions.unwrapArray(list, getJavaType(componentType.getType()));
			} catch (ClassNotFoundException e) {
			}
		}
		return Collections.unmodifiableList(list);
	}

	protected Class<?> getJavaType(JvmType type) throws ClassNotFoundException {
		return classFinder.forName(type.getQualifiedName());
	}

	protected Object _doEvaluate(XSetLiteral literal, IEvaluationContext context, CancelIndicator indicator) {
		if(isType(literal, Map.class)) {
			Map<Object, Object> map = newHashMap();
			for(XExpression element: literal.getElements()) {
				if (indicator.isCanceled())
					throw new InterpreterCanceledException();
				if (expressionHelper.isOperatorFromExtension(element, OperatorMapping.MAPPED_TO, ObjectExtensions.class)) {
					map.put(internalEvaluate(((XBinaryOperation)element).getLeftOperand(), context, indicator),
							internalEvaluate(((XBinaryOperation)element).getRightOperand(), context, indicator));
				} else if (isType(element, Pair.class)) {
					Pair<?, ?> pair = (Pair<?, ?>) internalEvaluate(element, context, indicator);
					map.put(pair == null ? null : pair.getKey(), pair == null ? null : pair.getValue());
				}
			}
			return Collections.unmodifiableMap(map);
		} else {
			Set<Object> set = newHashSet();
			for(XExpression element: literal.getElements()) {
				if (indicator.isCanceled())
					throw new InterpreterCanceledException();
				set.add(internalEvaluate(element, context, indicator));
			}
			return Collections.unmodifiableSet(set);
		}
	}

	protected boolean isType(XExpression element, Class<?> clazz) {
		return resolveType(element, clazz) != null;
	}

	protected LightweightTypeReference resolveType(XExpression element, Class<?> clazz) {
		LightweightTypeReference elementType = typeResolver.resolveTypes(element).getActualType(element);
		return elementType != null && elementType.isType(clazz) ? elementType : null;
	}

	protected Object _doEvaluate(XClosure closure, IEvaluationContext context, CancelIndicator indicator) {
		Class<?> functionIntf = null;
		switch (closure.getFormalParameters().size()) {
			case 0:
				functionIntf = getClass(Functions.Function0.class);
				break;
			case 1:
				functionIntf = getClass(Functions.Function1.class);
				break;
			case 2:
				functionIntf = getClass(Functions.Function2.class);
				break;
			case 3:
				functionIntf = getClass(Functions.Function3.class);
				break;
			case 4:
				functionIntf = getClass(Functions.Function4.class);
				break;
			case 5:
				functionIntf = getClass(Functions.Function5.class);
				break;
			case 6:
				functionIntf = getClass(Functions.Function6.class);
				break;
			default:
				throw new IllegalStateException("Closures with more then 6 parameters are not supported.");
		}
		ClosureInvocationHandler invocationHandler = new ClosureInvocationHandler(closure, context, this, indicator);
		Object proxy = Proxy.newProxyInstance(classLoader, new Class<?>[] { functionIntf }, invocationHandler);
		return proxy;
	}

	protected Object _doEvaluate(XBlockExpression literal, IEvaluationContext context, CancelIndicator indicator) {
		List<XExpression> expressions = literal.getExpressions();

		Object result = null;
		IEvaluationContext forkedContext = context.fork();
		for (int i = 0; i < expressions.size(); i++) {
			result = internalEvaluate(expressions.get(i), forkedContext, indicator);
		}
		return result;
	}

	protected Object _doEvaluate(XSynchronizedExpression expression, IEvaluationContext context, CancelIndicator indicator) {
		internalEvaluate(expression.getParam(), context, indicator);
		return internalEvaluate(expression.getExpression(), context, indicator);
	}

	protected Object _doEvaluate(XIfExpression ifExpression, IEvaluationContext context, CancelIndicator indicator) {
		Object conditionResult = internalEvaluate(ifExpression.getIf(), context, indicator);
		if (Boolean.TRUE.equals(conditionResult)) {
			return internalEvaluate(ifExpression.getThen(), context, indicator);
		} else {
			if (ifExpression.getElse() == null)
				return getDefaultObjectValue(typeResolver.resolveTypes(ifExpression).getActualType(ifExpression));
			return internalEvaluate(ifExpression.getElse(), context, indicator);
		}
	}

	protected Object _doEvaluate(XSwitchExpression switchExpression, IEvaluationContext context, CancelIndicator indicator) {
		IEvaluationContext forkedContext = context.fork();
		Object conditionResult = internalEvaluate(switchExpression.getSwitch(), forkedContext, indicator);
		String simpleName = featureNameProvider.getSimpleName(switchExpression.getDeclaredParam());
		if (simpleName != null) {
			forkedContext.newValue(QualifiedName.create(simpleName), conditionResult);
		}
		for (XCasePart casePart : switchExpression.getCases()) {
			JvmTypeReference typeGuard = casePart.getTypeGuard();
			if (typeGuard != null && switchExpression.getSwitch() == null)
				throw new IllegalStateException("Switch without expression or implicit 'this' may not use type guards");
			if (typeGuard == null || isInstanceoOf(conditionResult, typeGuard)) {
				if (casePart.getCase() != null) {
					Object casePartResult = internalEvaluate(casePart.getCase(), forkedContext, indicator);
					if (Boolean.TRUE.equals(casePartResult) || eq(conditionResult, casePartResult)) {
						XExpression then = switchExpressions.getThen(casePart, switchExpression);
						return internalEvaluate(then, forkedContext, indicator);
					}
				} else {
					XExpression then = switchExpressions.getThen(casePart, switchExpression);
					return internalEvaluate(then, forkedContext, indicator);
				}
			}
		}
		if (switchExpression.getDefault() != null) {
			Object defaultResult = internalEvaluate(switchExpression.getDefault(), forkedContext, indicator);
			return defaultResult;
		}
		return getDefaultObjectValue(typeResolver.resolveTypes(switchExpression).getActualType(switchExpression));
	}

	protected Object _doEvaluate(XCastedExpression castedExpression, IEvaluationContext context, CancelIndicator indicator) {
		Object result = internalEvaluate(castedExpression.getTarget(), context, indicator);
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, castedExpression);
		LightweightTypeReference targetType = owner.toLightweightTypeReference(castedExpression.getType());
		result = wrapOrUnwrapArray(result, targetType);
		result = coerceArgumentType(result, castedExpression.getType());
		JvmType castType = castedExpression.getType().getType();
		if (castType instanceof JvmPrimitiveType) {
			if (result == null) {
				throwNullPointerException(castedExpression, "Cannot cast null to primitive " + castType.getIdentifier());
			}
			return castToPrimitiveType(result, services.getPrimitives().primitiveKind((JvmPrimitiveType) castType));
		} else {
			String typeName = castType.getQualifiedName();
			Class<?> expectedType = null;
			try {
				expectedType = getJavaType(castType);
			} catch (ClassNotFoundException e) {
				throw new EvaluationException(new NoClassDefFoundError(typeName));
			}
			try {
				expectedType.cast(result);
			} catch (ClassCastException e) {
				throw new EvaluationException(new ClassCastException(typeName));
			}
			return result;
		}
	}

	protected Object castToPrimitiveType(Object castMe, Primitives.Primitive kind) {
		if (com.google.common.primitives.Primitives.isWrapperType(castMe.getClass())) {
			if (kind == Primitives.Primitive.Boolean) {
				if (castMe instanceof Boolean) {
					return castMe;
				}
			} else if (kind == Primitives.Primitive.Char) {
				if (castMe instanceof Character) {
					return ((Character) castMe).charValue();
				} else if (castMe instanceof Byte) {
					return (char) ((Byte) castMe).byteValue();
				} else if (castMe instanceof Short) {
					return (char) ((Short) castMe).shortValue();
				} else if (castMe instanceof Long) {
					return (char) ((Long) castMe).longValue();
				} else if (castMe instanceof Integer) {
					return (char) ((Integer) castMe).intValue();
				} else if (castMe instanceof Float) {
					return (char) ((Float) castMe).floatValue();
				} else if (castMe instanceof Double) {
					return (char) ((Double) castMe).doubleValue();
				}
			} else if (castMe instanceof Number) {
				Number number = (Number) castMe;
				switch(kind) {
					case Byte:
						return number.byteValue();
					case Short:
						return number.shortValue();
					case Long: 
						return number.longValue();
					case Int:
						return number.intValue();
					case Float:
						return number.floatValue();
					case Double:
						return number.doubleValue();
					default:
						throw new IllegalStateException("Unexpected cast type 'void'");
				}
			} else if (castMe instanceof Character) {
				char c = ((Character) castMe).charValue();
				switch(kind) {
					case Byte:
						return (byte) c;
					case Short:
						return (short) c;
					case Long: 
						return (long) c;
					case Int:
						return (int) c;
					case Float:
						return (float) c;
					case Double:
						return (double) c;
					default:
						throw new IllegalStateException("Unexpected cast type 'void'");
				}
			}
		}
		throw new EvaluationException(new ClassCastException(castMe.getClass().getName() + "!=" + kind.name().toLowerCase()));
	}

	protected Object _doEvaluate(XThrowExpression throwExpression, IEvaluationContext context, CancelIndicator indicator) {
		Object thrown = internalEvaluate(throwExpression.getExpression(), context, indicator);
		if (thrown == null) {
			return throwNullPointerException(throwExpression, "throwable expression evaluated to 'null'");
		}
		if (!(thrown instanceof Throwable)) {
			return throwClassCastException(throwExpression.getExpression(), thrown, Throwable.class);
		}
		throw new EvaluationException((Throwable) thrown);
	}

	protected boolean isInstanceoOf(Object value, JvmTypeReference type) {
		if (type instanceof JvmSynonymTypeReference) {
			for(JvmTypeReference synonym: ((JvmSynonymTypeReference) type).getReferences()) {
				if (isInstanceoOf(value, synonym)) {
					return true;
				}
			}
			return false;
		}
		String exceptionTypeName = type.getType().getQualifiedName();
		try {
			Class<?> exceptionType = classFinder.forName(exceptionTypeName);
			if (exceptionType.isInstance(value))
				return true;
		} catch (ClassNotFoundException e) {
			throw new EvaluationException(new NoClassDefFoundError(exceptionTypeName));
		}
		return false;
	}
	
	protected Object _doEvaluate(XTryCatchFinallyExpression tryCatchFinally, 
			IEvaluationContext context,
			CancelIndicator indicator) {
		Object result = null;
		ReturnValue returnValue = null;
		Map<String, Boolean> resIsInit = new HashMap<String, Boolean>();
		List<XVariableDeclaration> resources = tryCatchFinally.getResources();
		List<EvaluationException> caughtExceptions = newArrayList();
		// Resources
		try {
			for (XVariableDeclaration res : resources) {
				resIsInit.put(res.getName(), false);
				result = internalEvaluate(res, context, indicator);
				// Remember for automatic close which resources are initialized
				resIsInit.put(res.getName(), true);
			}
			// Expression Body
			result = internalEvaluate(tryCatchFinally.getExpression(), context, indicator);

		} catch (ReturnValue value) {
			// Keep thrown return value in mind until resources are closed
			returnValue = value;
		} catch (EvaluationException evaluationException) {
			Throwable cause = evaluationException.getCause();
			boolean caught = false;
			// Catch Clauses
			for (XCatchClause catchClause : tryCatchFinally.getCatchClauses()) {
				JvmFormalParameter exception = catchClause.getDeclaredParam();
				JvmTypeReference catchParameterType = exception.getParameterType();
				if (!isInstanceoOf(cause, catchParameterType)) {
					continue;
				}
				IEvaluationContext forked = context.fork();
				forked.newValue(QualifiedName.create(exception.getName()), cause);
				result = internalEvaluate(catchClause.getExpression(), forked, indicator);
				caught = true;
				break;
			}
			// Save uncaught exception
			if(!caught) caughtExceptions.add(evaluationException);
		}

		// finally expressions ...
		// ... given
		if (tryCatchFinally.getFinallyExpression() != null) {
			try {
				internalEvaluate(tryCatchFinally.getFinallyExpression(), context, indicator);
			} catch (EvaluationException e) {
				throw new EvaluationException(new FinallyDidNotCompleteException(e));
			}
		}
		// ... prompted by try with resources (automatic close)
		if (!resources.isEmpty()) {
			for (int i = resources.size() - 1; i >= 0; i--) {
				XVariableDeclaration resource = resources.get(i);
				// Only close resources that are instantiated (= avoid
				// NullPointerException)
				if (resIsInit.get(resource.getName())) {
					// Find close method for resource
					JvmOperation close = findCloseMethod(resource);
					// Invoke close on resource
					if (close != null) {
						// Invoking the close method might throw
						// a EvaluationException. Hence, we collect those thrown
						// EvaluationExceptions and propagate them later on.
						try {
							invokeOperation(close,
									context.getValue(QualifiedName.create(resource.getSimpleName())),
									Collections.emptyList());
						} catch (EvaluationException t) {
							caughtExceptions.add(t);
						}
					}
				}
			}
		}
		
		// Throw caught exceptions if there are any
		if (!caughtExceptions.isEmpty()) throw caughtExceptions.get(0);
					
		// throw return value from expression block after resources are closed
		if (returnValue != null)
			throw returnValue;

		return result;
	}

	/**
	 * @since 2.18
	 */
	protected JvmOperation findCloseMethod(XVariableDeclaration resource) {
		LightweightTypeReference resourceType = typeResolver.resolveTypes(resource)
				.getActualType((JvmIdentifiableElement) resource);
		for (JvmType rawType : resourceType.getRawTypes()) {
			if (rawType instanceof JvmDeclaredType) {
				Iterable<JvmFeature> closeCandidates = ((JvmDeclaredType) rawType)
						.findAllFeaturesByName("close");
				for (JvmFeature candidate : closeCandidates) {
					if (candidate instanceof JvmOperation
							&& ((JvmOperation) candidate).getParameters().isEmpty()) {
						return (JvmOperation) candidate;
					}
				}
			}
		}
		return null;
	}

	protected boolean eq(Object a, Object b) {
		return a == b || (a != null && a.equals(b));
	}

	/**
	 * @param expression may be used by inheritors 
	 */
	protected Object throwNullPointerException(XExpression expression, String message) {
		throw new EvaluationException(new NullPointerException(message));
	}

	/**
	 * @param expression may be used by inheritors 
	 */
	protected Object throwClassCastException(XExpression expression, Object result, Class<?> expectedType) {
		throw new EvaluationException(new ClassCastException("Expected: " + expectedType.getCanonicalName()
				+ " but got: " + result.getClass().getCanonicalName()));
	}

	protected Object wrapOrUnwrapArray(Object result, LightweightTypeReference expectedType) {
		if (expectedType.isArray() && !(result instanceof Object[])) {
			Class<?> arrayType;
			try {
				arrayType = getJavaType(expectedType.getComponentType().getType());
				return Conversions.unwrapArray(result, arrayType);
			} catch (ClassNotFoundException e) {
				return result;
			}
		} else if (!expectedType.isArray() && expectedType.isSubtypeOf(Iterable.class)) {
			return Conversions.doWrapArray(result);
		}
		return result;
	}

	protected Object _doEvaluate(XForLoopExpression forLoop, IEvaluationContext context, CancelIndicator indicator) {
		Object iterableOrIterator = internalEvaluate(forLoop.getForExpression(), context, indicator);
		if (iterableOrIterator == null)
			return throwNullPointerException(forLoop.getForExpression(), "iterable evaluated to 'null'");
		Iterator<?> iter = null;
		if (iterableOrIterator instanceof Iterable<?>) {
			iter = ((Iterable<?>) iterableOrIterator).iterator();
		} else if (iterableOrIterator.getClass().isArray()) {
			iter = ((Iterable<?>) Conversions.doWrapArray(iterableOrIterator)).iterator();
		} else {
			return throwClassCastException(forLoop.getForExpression(), iterableOrIterator, java.lang.Iterable.class);
		}
		IEvaluationContext forkedContext = context.fork();
		QualifiedName paramName = QualifiedName.create(forLoop.getDeclaredParam().getName());
		forkedContext.newValue(paramName, null);
		while (iter.hasNext()) {
			Object next = iter.next();
			forkedContext.assignValue(paramName, next);
			internalEvaluate(forLoop.getEachExpression(), forkedContext, indicator);
		}
		return null;
	}
	
	protected Object _doEvaluate(XBasicForLoopExpression forLoop, IEvaluationContext context, CancelIndicator indicator) {
		IEvaluationContext forkedContext = context.fork();
		for (XExpression initExpression : forLoop.getInitExpressions()) {
			internalEvaluate(initExpression, forkedContext, indicator);
		}
		XExpression expression = forLoop.getExpression();
		Object condition = expression == null ? Boolean.TRUE : internalEvaluate(expression, forkedContext, indicator);
		while (Boolean.TRUE.equals(condition)) {
			internalEvaluate(forLoop.getEachExpression(), forkedContext, indicator);
			for (XExpression updateExpression : forLoop.getUpdateExpressions()) {
				internalEvaluate(updateExpression, forkedContext, indicator);
			}
			condition = expression == null ? Boolean.TRUE : internalEvaluate(expression, forkedContext, indicator);
		}
		return null;
	}

	protected Object _doEvaluate(XWhileExpression whileLoop, IEvaluationContext context, CancelIndicator indicator) {
		Object condition = internalEvaluate(whileLoop.getPredicate(), context, indicator);
		while (Boolean.TRUE.equals(condition)) {
			internalEvaluate(whileLoop.getBody(), context, indicator);
			condition = internalEvaluate(whileLoop.getPredicate(), context, indicator);
		}
		return null;
	}

	protected IEvaluationResult _doEvaluate(XDoWhileExpression doWhileLoop, IEvaluationContext context, CancelIndicator indicator) {
		Object condition = null;
		do {
			internalEvaluate(doWhileLoop.getBody(), context, indicator);
			condition = internalEvaluate(doWhileLoop.getPredicate(), context, indicator);
		} while (Boolean.TRUE.equals(condition));
		return null;
	}
	
	protected Object _doEvaluate(XConstructorCall constructorCall, IEvaluationContext context, CancelIndicator indicator) {
		JvmConstructor jvmConstructor = constructorCall.getConstructor();
		List<Object> arguments = evaluateArgumentExpressions(jvmConstructor, constructorCall.getArguments(), context, indicator);
		Constructor<?> constructor = javaReflectAccess.getConstructor(jvmConstructor);
		try {
			if (constructor == null)
				throw new NoSuchMethodException("Could not find constructor " + jvmConstructor.getIdentifier());
			constructor.setAccessible(true);
			Object result = constructor.newInstance(arguments.toArray(new Object[arguments.size()]));
			return result;
		} catch (InvocationTargetException targetException) {
			throw new EvaluationException(targetException.getTargetException());
		} catch (Exception e) {
			throw new IllegalStateException("Could not invoke constructor: " + jvmConstructor.getIdentifier(), e);
		}
	}

	protected Object _doEvaluate(final XMemberFeatureCall featureCall, final IEvaluationContext context, final CancelIndicator indicator) {
		if (featureCall.isTypeLiteral()) {
			JvmType type = (JvmType) featureCall.getFeature();
			Object result = translateJvmTypeToResult(type, 0);
			return result;
		} else {
			XExpression receiver = getActualReceiver(featureCall); //, featureCall.getFeature(), featureCall.getImplicitReceiver());
			Object receiverObj = receiver==null?null:internalEvaluate(receiver, context, indicator);
			if (featureCall.isNullSafe() && receiverObj==null) {
				return getDefaultObjectValue(typeResolver.resolveTypes(featureCall).getActualType(featureCall));
			}
			return invokeFeature(featureCall.getFeature(), featureCall, receiverObj, context, indicator);
		}
	}

	protected Object translateJvmTypeToResult(JvmType type, int arrayDims) {
		try {
			String arrayDimensions = "";
			for (int i=0;i<arrayDims;i++)
				arrayDimensions+="[]";
			return classFinder.forName(type.getQualifiedName()+arrayDimensions);
		} catch (ClassNotFoundException e) {
			throw new EvaluationException(e);
		}
	}

	protected Object getDefaultObjectValue(LightweightTypeReference type) {
		if(!type.isPrimitive())
			return null;
		else {
			JvmPrimitiveType primitive = (JvmPrimitiveType) type.getType();
			switch (services.getPrimitives().primitiveKind(primitive)) {
				case Byte :
					return Byte.valueOf((byte)0);
				case Short :
					return Short.valueOf((short)0);
				case Char :
					return Character.valueOf((char)0);
				case Int :
					return Integer.valueOf(0);
				case Long :
					return Long.valueOf(0l);
				case Float :
					return Float.valueOf(0f);
				case Double :
					return Double.valueOf("0.");
				case Boolean :
					return Boolean.FALSE;
				case Void :
					return null;
				default :
					throw new IllegalArgumentException("Not a primitive : "+primitive);
			}
		}
	}

	protected Object _doEvaluate(XInstanceOfExpression instanceOf, IEvaluationContext context, CancelIndicator indicator) {
		Object instance = internalEvaluate(instanceOf.getExpression(), context, indicator);
		if (instance == null)
			return Boolean.FALSE;
		return isInstanceoOf(instance, instanceOf.getType());
	}

	protected Object _doEvaluate(XVariableDeclaration variableDecl, IEvaluationContext context, CancelIndicator indicator) {
		Object initialValue = null;
		if (variableDecl.getRight()!=null) {
			initialValue = internalEvaluate(variableDecl.getRight(), context, indicator);
		} else {
			if (services.getPrimitives().isPrimitive(variableDecl.getType())) {
				Primitive primitiveKind = services.getPrimitives().primitiveKind((JvmPrimitiveType) variableDecl.getType().getType());
				switch(primitiveKind) {
					case Boolean:
						initialValue = Boolean.FALSE; break;
					case Char:
						initialValue = Character.valueOf((char) 0); break;
					case Double:
						initialValue = Double.valueOf(0d); break;
					case Byte:
						initialValue = Byte.valueOf((byte) 0); break;
					case Float:
						initialValue = Float.valueOf(0f); break;
					case Int:
						initialValue = Integer.valueOf(0); break;
					case Long:
						initialValue = Long.valueOf(0L); break;
					case Short:
						initialValue = Short.valueOf((short) 0); break;
					case Void:
						throw new IllegalStateException("Void is not a valid variable type.");
					default:
						throw new IllegalStateException("Unknown primitive type " + primitiveKind);
				}
			}
		}
		context.newValue(QualifiedName.create(variableDecl.getName()), initialValue);
		return null;
	}

	protected Object _doEvaluate(XFeatureCall featureCall, IEvaluationContext context, CancelIndicator indicator) {
		if (featureCall.isTypeLiteral()) {
			JvmType type = (JvmType) featureCall.getFeature();
			Object result = translateJvmTypeToResult(type, 0);
			return result;
		} else {
			return _doEvaluate((XAbstractFeatureCall) featureCall, context, indicator);
		}
	}
	
	protected Object _doEvaluate(XAbstractFeatureCall featureCall, IEvaluationContext context, CancelIndicator indicator) {
		if (expressionHelper.isShortCircuitOperation(featureCall)) {
			XExpression leftOperand = ((XBinaryOperation)featureCall).getLeftOperand();
			Object result = internalEvaluate(leftOperand, context, indicator);
			String operatorName = featureCall.getConcreteSyntaxFeatureName();
			if (equal(expressionHelper.getElvisOperator() ,operatorName)) {
				if(result != null)
					return result;
			} else if (equal(expressionHelper.getAndOperator(), operatorName)) {
				if (!(Boolean)result) 
					return false;
			} else if (equal(expressionHelper.getOrOperator(), operatorName)) {
				if((Boolean) result)
					return true;
			}
			JvmOperation operation = (JvmOperation) featureCall.getFeature();
			XExpression receiver = getActualReceiver(featureCall);
			List<XExpression> operationArguments = getActualArguments(featureCall);
			List<Object> argumentValues = newArrayList();
			for (XExpression expr : operationArguments) {
				if (expr == leftOperand) {
					argumentValues.add(result);
				} else {
					argumentValues.add(internalEvaluate(expr, context, indicator));
				}
			}
			return invokeOperation(operation, receiver, argumentValues, context, indicator);
		}
		if (isGetAndAssign(featureCall)) {
			return evaluateGetAndAssign(featureCall, context, indicator);
		}
		XExpression receiver = getActualReceiver(featureCall);
		Object receiverObj = receiver==null?null:internalEvaluate(receiver, context, indicator);
		Object result = invokeFeature(featureCall.getFeature(), featureCall, receiverObj, context, indicator);
		if (featureCall instanceof XBinaryOperation) {
			XBinaryOperation binaryOperation = (XBinaryOperation) featureCall;
			if (binaryOperation.isReassignFirstArgument()) {
				XAbstractFeatureCall leftOperand = (XAbstractFeatureCall) binaryOperation.getLeftOperand();
				assignValueTo(leftOperand.getFeature(), featureCall, result, context, indicator);
			}
		}
		return result;
	}

	protected boolean isGetAndAssign(XAbstractFeatureCall featureCall) {
		return expressionHelper.isGetAndAssign(featureCall);
	}

	protected Object evaluateGetAndAssign(XAbstractFeatureCall featureCall, IEvaluationContext context, CancelIndicator indicator) {
		XAbstractFeatureCall operand = (XAbstractFeatureCall) featureCall.getActualArguments().get(0);
		
		Object originalValue = internalEvaluate(operand, context, indicator);
		Object value = applyGetAndAssignOperator(originalValue, featureCall.getConcreteSyntaxFeatureName());
		
		assignValueTo(operand.getFeature(), featureCall, value, context, indicator);
		return originalValue;
	}

	protected Object applyGetAndAssignOperator(Object originalValue, String operatorName) {
		if (originalValue instanceof Double) {
			Double value = (Double) originalValue;
			if (equal(OperatorMapping.MINUS_MINUS.toString(), operatorName)) {
				return (double) (value - 1);	
			}
			return (double) (value + 1);
		} 
		if (originalValue instanceof Float) {
			Float value = (Float) originalValue;
			if (equal(OperatorMapping.MINUS_MINUS.toString(), operatorName)) {
				return (float) (value - 1);	
			}
			return (float) (value + 1);
		} 
		if (originalValue instanceof Long) {
			Long value = (Long) originalValue;
			if (equal(OperatorMapping.MINUS_MINUS.toString(), operatorName)) {
				return (long) (value - 1);	
			}
			return (long) (value + 1);
		}
		if (originalValue instanceof Integer) {
			Integer value = (Integer) originalValue;
			if (equal(OperatorMapping.MINUS_MINUS.toString(), operatorName)) {
				return value - 1;	
			}
			return value + 1;
		} 
		if (originalValue instanceof Short) {
			Short value = (Short) originalValue;
			if (equal(OperatorMapping.MINUS_MINUS.toString(), operatorName)) {
				return (short) (value - 1);	
			}
			return (short) (value + 1);
		} if (originalValue instanceof Byte) {
			Byte value = (Byte) originalValue;
			if (equal(OperatorMapping.MINUS_MINUS.toString(), operatorName)) {
				return (byte) (value - 1);	
			}
			return (byte) (value + 1);
		} 
		if (originalValue instanceof Character) {
			Character value = (Character) originalValue;
			if (equal(OperatorMapping.MINUS_MINUS.toString(), operatorName)) {
				return (char) (value - 1);	
			}
			return (char) (value + 1);
		}
		throw new IllegalStateException("Unexpected value: " + originalValue);
	}

	protected List<XExpression> getActualArguments(XAbstractFeatureCall featureCall) {
		return featureCall.getActualArguments();
	}

	protected XExpression getActualReceiver(XAbstractFeatureCall featureCall) {
		return featureCall.getActualReceiver();
	}
	
	protected Object invokeFeature(JvmIdentifiableElement feature, XAbstractFeatureCall featureCall, Object receiverObj,
			IEvaluationContext context, CancelIndicator indicator) {
		if (feature instanceof JvmField) {
			return _invokeFeature((JvmField)feature, featureCall, receiverObj, context, indicator);
		} else if (feature instanceof JvmOperation) {
			return _invokeFeature((JvmOperation)feature, featureCall, receiverObj, context, indicator);
		} else if (feature != null) {
			return _invokeFeature(feature, featureCall, receiverObj, context, indicator);
		} else {
			throw new NullPointerException("Feature was null");
		}
	}

	/**
	 * @param featureCall unused in this context but required for dispatching
	 * @param indicator unused in this context but required for dispatching
	 */
	protected Object _invokeFeature(JvmIdentifiableElement identifiable, XAbstractFeatureCall featureCall, Object receiver,
			IEvaluationContext context, CancelIndicator indicator) {
		if (receiver != null)
			throw new IllegalStateException("feature was simple feature call but got receiver instead of null. Receiver: " + receiver);
		String localVarName = featureNameProvider.getSimpleName(identifiable);
		Object value = context.getValue(QualifiedName.create(localVarName));
		return value;
	}

	/**
	 * @param featureCall unused in this context but required for dispatching
	 * @param context unused in this context but required for dispatching
	 * @param indicator unused in this context but required for dispatching
	 */
	protected Object _invokeFeature(JvmField jvmField, XAbstractFeatureCall featureCall, Object receiver, IEvaluationContext context, CancelIndicator indicator) {
		return featureCallField(jvmField, receiver);
	}

	protected Object featureCallField(JvmField jvmField, Object receiver) {
		Field field = javaReflectAccess.getField(jvmField);
		try {
			if (field == null) {
				throw new NoSuchFieldException("Could not find field " + jvmField.getIdentifier());
			}
			if(!Modifier.isStatic(field.getModifiers()) && receiver == null) {
				throw new EvaluationException(new NullPointerException("cannot access field " + field + " on null"));
			}
			field.setAccessible(true);
			Object result = field.get(receiver);
			return result;
		} catch(EvaluationException ee) {
			 throw ee;
		}
		catch (Exception e) {
			throw new IllegalStateException("Could not access field: " + jvmField.getIdentifier()
					+ " on instance: " + receiver, e);
		}
	}

	protected Object _invokeFeature(JvmOperation operation, XAbstractFeatureCall featureCall, Object receiver,
			IEvaluationContext context, CancelIndicator indicator) {
		List<XExpression> operationArguments = getActualArguments(featureCall);
		List<Object> argumentValues = evaluateArgumentExpressions(operation, operationArguments, context, indicator);
		return invokeOperation(operation, receiver, argumentValues, context, indicator);
	}

	/**
	 * @param operation the operation that should be invoked.
	 * @param receiver the receiver for the invocation. It may be <code>null</code> which could signal a {@link NullPointerException} or
	 *   be valid if the given {@code operation} is a static operation.
	 * @param argumentValues the argument values. The number of arguments has to match the number of declared parameters. 
	 * @param context the current evalutation context.
	 * @param indicator the cancel indicator.
	 * @since 2.3.1
	 */
	protected Object invokeOperation(JvmOperation operation, Object receiver, List<Object> argumentValues,
			IEvaluationContext context, CancelIndicator indicator) {
		return invokeOperation(operation, receiver, argumentValues);
	}
	
	protected Object invokeOperation(JvmOperation operation, Object receiver, List<Object> argumentValues) {
		Method method = javaReflectAccess.getMethod(operation);
		try {
			if (method == null) {
				throw new NoSuchMethodException("Could not find method " + operation.getIdentifier());
			}
			if (!Modifier.isStatic(method.getModifiers()) && receiver==null) {
				throw new EvaluationException(new NullPointerException("cannot invoke method "+method+" on null"));
			}
			if (Modifier.isStatic(method.getModifiers()) && receiver!=null) {
				throw new IllegalArgumentException("A static method can't be invoked on a receiver.");
			}
			if (receiver != null && Proxy.isProxyClass(receiver.getClass())) {
				InvocationHandler invocationHandler = Proxy.getInvocationHandler(receiver);
				try {
					Object result = invocationHandler.invoke(receiver, method, argumentValues.toArray(new Object[argumentValues.size()]));
					return result;
				} catch(Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			} else {
				method.setAccessible(true);
				Object result = method.invoke(receiver, argumentValues.toArray(new Object[argumentValues.size()]));
				return result;
			}
		} catch (EvaluationException e) {
			throw e;
		} catch (InvocationTargetException targetException) {
			Throwable cause = targetException.getCause();
			if (cause instanceof InterpreterCanceledException)
				throw (InterpreterCanceledException) cause;
			if (cause instanceof UndeclaredThrowableException) {
				cause = cause.getCause();
			}
			if (cause instanceof EvaluationException) {
				throw (EvaluationException) cause;
			}
			throw new EvaluationException(cause);
		} catch (Exception e) {
			throw new IllegalStateException("Could not invoke method: " + operation.getIdentifier()
					+ " on instance: " + receiver, e);
		}
	}

	protected List<Object> evaluateArgumentExpressions(JvmExecutable executable, List<XExpression> expressions,
			IEvaluationContext context, CancelIndicator indicator) {
		List<Object> result = Lists.newArrayList();
		int paramCount = executable.getParameters().size();
		if (executable.isVarArgs())
			paramCount--;
		for (int i = 0; i < paramCount; i++) {
			XExpression arg = expressions.get(i);
			Object argResult = internalEvaluate(arg, context, indicator);
			JvmTypeReference parameterType = executable.getParameters().get(i).getParameterType();
			Object argumentValue = coerceArgumentType(argResult, parameterType);
			result.add(argumentValue);
		}
		if (executable.isVarArgs()) {
			Class<?> componentType = null;
			if (executable instanceof JvmOperation) {
				Method method = javaReflectAccess.getMethod((JvmOperation) executable);
				componentType = method.getParameterTypes()[paramCount].getComponentType();
			} else {
				Constructor<?> constructor = javaReflectAccess.getConstructor((JvmConstructor) executable);
				componentType = constructor.getParameterTypes()[paramCount].getComponentType();
			}
			if (expressions.size() == executable.getParameters().size()) {
				XExpression arg = expressions.get(paramCount);
				Object lastArgResult = internalEvaluate(arg, context, indicator);
				if (componentType.isInstance(lastArgResult)) {
					Object array = Array.newInstance(componentType, 1);
					Array.set(array, 0, lastArgResult);
					result.add(array);
				} else {
					result.add(lastArgResult);
				}
			} else {
				Object array = Array.newInstance(componentType, expressions.size() - paramCount);
				for(int i = paramCount; i < expressions.size(); i++) {
					XExpression arg = expressions.get(i);
					Object argValue = internalEvaluate(arg, context, indicator);
					Array.set(array, i - paramCount, argValue);
				}
				result.add(array);
			}
		}
		return result;
	}
	
	protected Object coerceArgumentType(Object value, JvmTypeReference expectedType) {
		if (value == null)
			return null;
		if (expectedType.getType() instanceof JvmGenericType && ((JvmGenericType) expectedType.getType()).isInterface()) {
			try {
				JvmType type = expectedType.getType();
				Class<?> functionIntf = classFinder.forName(type.getIdentifier());
				if (!functionIntf.isInstance(value)) {
					InvocationHandler invocationHandler = null;
					if (Proxy.isProxyClass(value.getClass())) {
						invocationHandler = Proxy.getInvocationHandler(value);
					} else if (getClass(Functions.Function0.class).isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, getClass(Functions.Function0.class));
					} else if (getClass(Functions.Function1.class).isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, getClass(Functions.Function1.class));
					} else if (getClass(Functions.Function2.class).isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, getClass(Functions.Function2.class));
					} else if (getClass(Functions.Function3.class).isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, getClass(Functions.Function3.class));
					} else if (getClass(Functions.Function4.class).isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, getClass(Functions.Function4.class));
					} else if (getClass(Functions.Function5.class).isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, getClass(Functions.Function5.class));
					} else if (getClass(Functions.Function6.class).isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, getClass(Functions.Function6.class));
					}  else if (getClass(Procedures.Procedure0.class).isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, getClass(Procedures.Procedure0.class));
					} else if (getClass(Procedures.Procedure1.class).isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, getClass(Procedures.Procedure1.class));
					} else if (getClass(Procedures.Procedure2.class).isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, getClass(Procedures.Procedure2.class));
					} else if (getClass(Procedures.Procedure3.class).isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, getClass(Procedures.Procedure3.class));
					} else if (getClass(Procedures.Procedure4.class).isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, getClass(Procedures.Procedure4.class));
					} else if (getClass(Procedures.Procedure5.class).isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, getClass(Procedures.Procedure5.class));
					} else if (getClass(Procedures.Procedure6.class).isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, getClass(Procedures.Procedure6.class));
					} else {
						return value;
					}
					Object proxy = Proxy.newProxyInstance(classLoader, new Class<?>[] { functionIntf },
							invocationHandler);
					return proxy;
				}
			} catch (ClassNotFoundException e) {
				throw new NoClassDefFoundError(e.getMessage());
			}

		}
		return value;
	}

	protected Object _doEvaluate(XAssignment assignment, IEvaluationContext context, CancelIndicator indicator) {
		JvmIdentifiableElement feature = assignment.getFeature();
		if (feature instanceof JvmOperation && ((JvmOperation) feature).isVarArgs()) {
			return _doEvaluate((XAbstractFeatureCall) assignment, context, indicator);
		}
		Object value = internalEvaluate(assignment.getValue(), context, indicator);
		Object assign = assignValueTo(feature, assignment, value, context, indicator);
		return assign;
	}
	
	protected Object assignValueTo(JvmIdentifiableElement feature, XAbstractFeatureCall assignment, Object value, IEvaluationContext context, CancelIndicator indicator) {
		if (feature instanceof XVariableDeclaration) {
			return _assignValueTo((XVariableDeclaration) feature, assignment, value, context, indicator);
		} else if (feature instanceof JvmField) {
			return _assignValueTo((JvmField) feature, assignment, value, context, indicator);
		} else if (feature instanceof JvmOperation) {
			return _assignValueTo((JvmOperation) feature, assignment, value, context, indicator);
		} else {
			throw new IllegalArgumentException("Couldn't invoke 'assignValueTo' for feature "+feature+"");
		}
	}

	/**
	 * @param assignment unused in this context but required for dispatching
	 * @param indicator unused in this context but required for dispatching
	 */
	protected Object _assignValueTo(XVariableDeclaration variable, XAbstractFeatureCall assignment, Object value,
			IEvaluationContext context, CancelIndicator indicator) {
		if (variable.getType() != null) {
			JvmTypeReference type = variable.getType();
			Object coerced = coerceArgumentType(value, type);
			context.assignValue(QualifiedName.create(variable.getName()), coerced);
		} else {
			context.assignValue(QualifiedName.create(variable.getName()), value);
		}
		return value;
	}

	protected Object _assignValueTo(JvmField jvmField, XAbstractFeatureCall assignment, Object value,
			IEvaluationContext context, CancelIndicator indicator) {
		Object receiver = getReceiver(assignment, context, indicator);
		Field field = javaReflectAccess.getField(jvmField);
		try {
			if (field == null) {
				throw new NoSuchFieldException("Could not find field " + jvmField.getIdentifier());
			}
			if (!Modifier.isStatic(field.getModifiers()) && receiver == null)
				throw new EvaluationException(new NullPointerException("Cannot assign value to field: "
						+ jvmField.getIdentifier() + " on null instance"));
			JvmTypeReference type = jvmField.getType();
			Object coerced = coerceArgumentType(value, type);
			field.setAccessible(true);
			field.set(receiver, coerced);
			return value;
		} catch (Exception e) {
			throw new IllegalStateException("Could not access field: " + jvmField.getIdentifier()
					+ " on instance: " + receiver, e);
		}
	}

	protected Object getReceiver(XAbstractFeatureCall assignment, IEvaluationContext context, CancelIndicator indicator) {
		XExpression receiver = getActualReceiver(assignment);
		Object result = receiver == null ? null : internalEvaluate(receiver, context, indicator);
		return result;
	}

	protected Object _assignValueTo(JvmOperation jvmOperation, XAbstractFeatureCall assignment, Object value,
			IEvaluationContext context, CancelIndicator indicator) {
		List<Object> argumentValues;
		if (assignment.getImplicitReceiver() != null 
				&& assignment instanceof XAssignment 
				&& ((XAssignment) assignment).getAssignable() != null) {
			XExpression implicitArgument = ((XAssignment) assignment).getAssignable();
			Object argResult = internalEvaluate(implicitArgument, context, indicator);
			JvmTypeReference firstParameterType = jvmOperation.getParameters().get(0).getParameterType();
			Object firstValue = coerceArgumentType(argResult, firstParameterType);
			JvmTypeReference secondParameterType = jvmOperation.getParameters().get(1).getParameterType();
			Object secondValue = coerceArgumentType(value, secondParameterType);
			argumentValues = Lists.newArrayList(firstValue, secondValue);
		} else {
			JvmTypeReference secondParameterType = jvmOperation.getParameters().get(0).getParameterType();
			Object coerced = coerceArgumentType(value, secondParameterType);
			argumentValues = Lists.newArrayList(coerced);
		}
		Object receiver = getReceiver(assignment, context, indicator);
		Object result = invokeOperation(jvmOperation, receiver, argumentValues, context, indicator);
		return result;
	}

	protected ClassFinder getClassFinder() {
		return classFinder;
	}

	protected JavaReflectAccess getJavaReflectAccess() {
		return javaReflectAccess;
	}
}
