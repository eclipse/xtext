/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter.impl;

import static com.google.common.collect.Lists.*;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.impl.ClassFinder;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
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
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xbase.impl.FeatureCallToJavaMapping;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.typing.NumberLiterals;
import org.eclipse.xtext.xbase.util.XExpressionHelper;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class XbaseInterpreter implements IExpressionInterpreter {
	
	@SuppressWarnings("serial")
	static class ReturnValue extends RuntimeException {
		public Object returnValue;
		public ReturnValue(Object value) {
			super();
			this.returnValue = value;
		}
	}
	
	protected static class PrefixMethodFilter extends PolymorphicDispatcher.MethodNameFilter {

		public PrefixMethodFilter(String prefix, int minParams, int maxParams) {
			super(prefix, minParams, maxParams);
		}

		@Override
		public boolean apply(Method param) {
			return param.getName().startsWith(methodName) && param.getParameterTypes().length >= minParams
					&& param.getParameterTypes().length <= maxParams;
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
	private IdentifiableSimpleNameProvider featureNameProvider;

	public void setFeatureNameProvider(IdentifiableSimpleNameProvider featureNameProvider) {
		this.featureNameProvider = featureNameProvider;
	}

	@Inject
	private Provider<IEvaluationContext> contextProvider;

	@Inject
	private JavaReflectAccess javaReflectAccess;
	
	@Inject
	private FeatureCallToJavaMapping callToJavaMapping;
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Inject
	private TypeReferences typeRefs;
	
	@Inject
	private Primitives primitives;
	
	@Inject
	private XExpressionHelper expressionHelper;
	
	@Inject
	private NumberLiterals numberLiterals;
	
	private ClassFinder classFinder;

	private ClassLoader classLoader;

	@Inject
	public void setClassLoader(ClassLoader classLoader) {
		this.classFinder = new ClassFinder(classLoader);
		this.classLoader = classLoader;
		this.javaReflectAccess.setClassLoader(classLoader);
	}
	
	protected Class<?> getClass(Class<?> class1) {
		try {
			return classLoader.loadClass(class1.getName());
		} catch (ClassNotFoundException e) {
			throw new EvaluationException(e);
		}
	}

	private PolymorphicDispatcher<Object> evaluateDispatcher = createEvaluateDispatcher();
	private PolymorphicDispatcher<Object> assignmentDispatcher = createAssignmentDispatcher();
	private PolymorphicDispatcher<Object> featureCallDispatcher = createFeatureCallDispatcher();

	protected PolymorphicDispatcher<Object> createEvaluateDispatcher() {
		return PolymorphicDispatcher.createForSingleTarget(new PrefixMethodFilter("_evaluate", 3, 3), this);
	}

	protected PolymorphicDispatcher<Object> createAssignmentDispatcher() {
		return PolymorphicDispatcher.createForSingleTarget(new PrefixMethodFilter("_assignValue", 5, 5), this);
	}

	protected PolymorphicDispatcher<Object> createFeatureCallDispatcher() {
		return PolymorphicDispatcher.createForSingleTarget(new PrefixMethodFilter("_featureCall", 5, 5), this);
	}

	public IEvaluationResult evaluate(XExpression expression) {
		return evaluate(expression, createContext(), CancelIndicator.NullImpl);
	}

	protected IEvaluationContext createContext() {
		return contextProvider.get();
	}
	
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
		Object result = evaluateDispatcher.invoke(expression, context, indicator);
		final JvmTypeReference expectedType = typeProvider.getExpectedType(expression);
		result = wrapOrUnwrapArray(result, expectedType);
		return result;
	}

	/**
	 * @param literal unused in this context but required for dispatching 
	 * @param context unused in this context but required for dispatching
	 * @param indicator unused in this context but required for dispatching
	 */
	protected Object _evaluateNullLiteral(XNullLiteral literal, IEvaluationContext context, CancelIndicator indicator) {
		return null;
	}
	
	protected Object _evaluateReturnExpression(XReturnExpression returnExpr, IEvaluationContext context, CancelIndicator indicator) {
		Object returnValue = internalEvaluate(returnExpr.getExpression(), context, indicator);
		throw new ReturnValue(returnValue);
	}

	/**
	 * @param context unused in this context but required for dispatching
	 * @param indicator unused in this context but required for dispatching
	 */
	protected Object _evaluateStringLiteral(XStringLiteral literal, IEvaluationContext context, CancelIndicator indicator) {
		return literal.getValue();
	}

	/**
	 * @param context unused in this context but required for dispatching
	 * @param indicator unused in this context but required for dispatching
	 */
	protected Object _evaluateNumberLiteral(XNumberLiteral literal, IEvaluationContext context, CancelIndicator indicator) {
		return numberLiterals.numberValue(literal, numberLiterals.getJavaType(literal));
	}

	/**
	 * @param context unused in this context but required for dispatching
	 * @param indicator unused in this context but required for dispatching
	 */
	protected Object _evaluateBooleanLiteral(XBooleanLiteral literal, IEvaluationContext context, CancelIndicator indicator) {
		return literal.isIsTrue();
	}

	/**
	 * @param context unused in this context but required for dispatching
	 * @param indicator unused in this context but required for dispatching
	 */
	protected Object _evaluateTypeLiteral(XTypeLiteral literal, IEvaluationContext context, CancelIndicator indicator) {
		if (literal.getType() == null || literal.getType().eIsProxy()) {
			List<INode> nodesForFeature = NodeModelUtils.findNodesForFeature(literal,
					XbasePackage.Literals.XTYPE_LITERAL__TYPE);
			// TODO cleanup
			if (nodesForFeature.isEmpty())
				throw new EvaluationException(new ClassNotFoundException());
			throw new EvaluationException(new ClassNotFoundException(nodesForFeature.get(0).getText()));
		}
		try {
			Class<?> result = classFinder.forName(literal.getType().getQualifiedName());
			return result;
		} catch (ClassNotFoundException cnfe) {
			throw new EvaluationException(cnfe);
		}
	}

	protected Object _evaluateClosure(XClosure closure, IEvaluationContext context, CancelIndicator indicator) {
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

	protected Object _evaluateBlockExpression(XBlockExpression literal, IEvaluationContext context, CancelIndicator indicator) {
		List<XExpression> expressions = literal.getExpressions();

		Object result = null;
		IEvaluationContext forkedContext = context.fork();
		for (int i = 0; i < expressions.size(); i++) {
			result = internalEvaluate(expressions.get(i), forkedContext, indicator);
		}
		return result;
	}

	protected Object _evaluateIfExpression(XIfExpression ifExpression, IEvaluationContext context, CancelIndicator indicator) {
		Object conditionResult = internalEvaluate(ifExpression.getIf(), context, indicator);
		if (Boolean.TRUE.equals(conditionResult)) {
			return internalEvaluate(ifExpression.getThen(), context, indicator);
		} else {
			if (ifExpression.getElse() == null)
				return null;
			return internalEvaluate(ifExpression.getElse(), context, indicator);
		}
	}

	protected Object _evaluateSwitchExpression(XSwitchExpression switchExpression, IEvaluationContext context, CancelIndicator indicator) {
		IEvaluationContext forkedContext = context.fork();
		Object conditionResult = internalEvaluate(switchExpression.getSwitch(), forkedContext, indicator);
		String simpleName = featureNameProvider.getSimpleName(switchExpression);
		if (simpleName != null) {
			forkedContext.newValue(QualifiedName.create(simpleName), conditionResult);
		}
		for (XCasePart casePart : switchExpression.getCases()) {
			Class<?> expectedType = null;
			if (casePart.getTypeGuard() != null) {
				String typeName = casePart.getTypeGuard().getType().getQualifiedName();
				try {
					expectedType = classFinder.forName(typeName);
				} catch (ClassNotFoundException e) {
					throw new EvaluationException(new NoClassDefFoundError(typeName));
				}
			}
			if (expectedType != null && conditionResult == null)
				throw new IllegalStateException("Switch without expression or implicit 'this' may not use type guards");
			if (expectedType == null || expectedType.isInstance(conditionResult)) {
				if (casePart.getCase() != null) {
					Object casePartResult = internalEvaluate(casePart.getCase(), forkedContext, indicator);
					if (Boolean.TRUE.equals(casePartResult) || eq(conditionResult, casePartResult)) {
						return internalEvaluate(casePart.getThen(), forkedContext, indicator);
					}
				} else {
					return internalEvaluate(casePart.getThen(), forkedContext, indicator);
				}
			}
		}
		if (switchExpression.getDefault() != null) {
			Object defaultResult = internalEvaluate(switchExpression.getDefault(), forkedContext, indicator);
			return defaultResult;
		}
		return null;
	}

	protected Object _evaluateCastedExpression(XCastedExpression castedExpression, IEvaluationContext context, CancelIndicator indicator) {
		Object result = internalEvaluate(castedExpression.getTarget(), context, indicator);
		result = wrapOrUnwrapArray(result, castedExpression.getType());
		result = coerceArgumentType(result, castedExpression.getType());
		String typeName = castedExpression.getType().getType().getQualifiedName();
		Class<?> expectedType = null;
		try {
			expectedType = classFinder.forName(typeName);
		} catch (ClassNotFoundException e) {
			throw new EvaluationException(new NoClassDefFoundError(typeName));
		}
		try {
			expectedType.cast(result);
		} catch (ClassCastException e) {
			throw new EvaluationException(e);
		}
		return result;
	}

	protected Object _evaluateThrowExpression(XThrowExpression throwExpression, IEvaluationContext context, CancelIndicator indicator) {
		Object thrown = internalEvaluate(throwExpression.getExpression(), context, indicator);
		if (thrown == null) {
			return throwNullPointerException(throwExpression, "throwable expression evaluated to 'null'");
		}
		if (!(thrown instanceof Throwable)) {
			return throwClassCastException(throwExpression.getExpression(), thrown, Throwable.class);
		}
		throw new EvaluationException((Throwable) thrown);
	}

	protected Object _evaluateTryCatchFinallyExpression(XTryCatchFinallyExpression tryCatchFinally,
			IEvaluationContext context, CancelIndicator indicator) {
		Object result = null;
		try {
			result = internalEvaluate(tryCatchFinally.getExpression(), context, indicator);
		} catch (EvaluationException evaluationException) {
			Throwable cause = evaluationException.getCause();
			for (XCatchClause catchClause : tryCatchFinally.getCatchClauses()) {
				JvmFormalParameter exception = catchClause.getDeclaredParam();
				String exceptionTypeName = exception.getParameterType().getType().getQualifiedName();
				try {
					Class<?> exceptionType = classFinder.forName(exceptionTypeName);
					if (!exceptionType.isInstance(cause))
						continue;
				} catch (ClassNotFoundException e) {
					throw new EvaluationException(new NoClassDefFoundError(exceptionTypeName));
				}
				IEvaluationContext forked = context.fork();
				forked.newValue(QualifiedName.create(exception.getName()), cause);
				result = internalEvaluate(catchClause.getExpression(), forked, indicator);
				break;
			}
		}

		if (tryCatchFinally.getFinallyExpression() != null) {
			try {
				internalEvaluate(tryCatchFinally.getFinallyExpression(), context, indicator);
			} catch (EvaluationException e) {
				throw new EvaluationException(new FinallyDidNotCompleteException(e));
			}
		}
		return result;
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

	protected Object wrapOrUnwrapArray(Object result, JvmTypeReference expectedType) {
		if (typeRefs.isInstanceOf(expectedType, Iterable.class)) {
			return Conversions.doWrapArray(result);
		} else if (typeRefs.isArray(expectedType)) {
			Class<?> arrayType = getJavaReflectAccess().getRawType(expectedType.getType());
			return Conversions.unwrapArray(result, arrayType.getComponentType());
		}
		return result;
	}

	protected Object _evaluateForLoopExpression(XForLoopExpression forLoop, IEvaluationContext context, CancelIndicator indicator) {
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

	protected Object _evaluateWhileExpression(XWhileExpression whileLoop, IEvaluationContext context, CancelIndicator indicator) {
		Object condition = internalEvaluate(whileLoop.getPredicate(), context, indicator);
		while (Boolean.TRUE.equals(condition)) {
			internalEvaluate(whileLoop.getBody(), context, indicator);
			condition = internalEvaluate(whileLoop.getPredicate(), context, indicator);
		}
		return null;
	}

	protected IEvaluationResult _evaluateDoWhileExpression(XDoWhileExpression doWhileLoop, IEvaluationContext context, CancelIndicator indicator) {
		Object condition = null;
		do {
			internalEvaluate(doWhileLoop.getBody(), context, indicator);
			condition = internalEvaluate(doWhileLoop.getPredicate(), context, indicator);
		} while (Boolean.TRUE.equals(condition));
		return null;
	}
	
	protected Object _evaluateConstructorCall(XConstructorCall constructorCall, IEvaluationContext context, CancelIndicator indicator) {
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

	protected Object _evaluateMemberFeatureCall(final XMemberFeatureCall featureCall, final IEvaluationContext context, final CancelIndicator indicator) {
		if (featureCall.isSpreading()) {
			Object memberCallTarget = internalEvaluate(featureCall.getMemberCallTarget(), context, indicator);
			if (memberCallTarget == null)
				return throwNullPointerException(featureCall.getMemberCallTarget(), "iterable evaluated to 'null'");
			if (memberCallTarget instanceof Iterable) {
				class Spread implements Function<Object, Object> {
					public Object apply(Object from) {
						Object result = internalFeatureCallDispatch(featureCall, from, context, indicator);
						return result;
					}
				}
				Iterable<?> iterable = (Iterable<?>) memberCallTarget;
				return Lists.newArrayList(Iterables.transform(iterable, new Spread()));
			} else {
				return throwClassCastException(featureCall.getMemberCallTarget(), memberCallTarget,
						java.lang.Iterable.class);
			}
		} else {
			XExpression receiver = callToJavaMapping.getActualReceiver(featureCall, featureCall.getFeature(), featureCall.getImplicitReceiver());
			Object receiverObj = receiver==null?null:internalEvaluate(receiver, context, indicator);
			if (featureCall.isNullSafe() && receiverObj==null) {
				return getDefaultObjectValue(typeProvider.getType(featureCall));
			}
			return internalFeatureCallDispatch(featureCall, receiverObj, context, indicator);
		}
	}

	protected Object getDefaultObjectValue(JvmTypeReference type) {
		if(!primitives.isPrimitive(type))
			return null;
		else {
			JvmPrimitiveType primitive = (JvmPrimitiveType) type.getType();
			switch (primitives.primitiveKind(primitive)) {
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

	protected Object _evaluateInstanceOf(XInstanceOfExpression instanceOf, IEvaluationContext context, CancelIndicator indicator) {
		Object instance = internalEvaluate(instanceOf.getExpression(), context, indicator);
		if (instance == null)
			return Boolean.FALSE;

		Class<?> expectedType = null;
		String className = instanceOf.getType().getQualifiedName();
		try {
			expectedType = classFinder.forName(className);
		} catch (ClassNotFoundException cnfe) {
			throw new EvaluationException(new NoClassDefFoundError(className));
		}
		return expectedType.isInstance(instance);
	}

	protected Object _evaluateVariableDeclaration(XVariableDeclaration variableDecl, IEvaluationContext context, CancelIndicator indicator) {
		Object initialValue = null;
		if (variableDecl.getRight()!=null) {
			initialValue = internalEvaluate(variableDecl.getRight(), context, indicator);
		} else {
			if (primitives.isPrimitive(variableDecl.getType())) {
				Primitive primitiveKind = primitives.primitiveKind((JvmPrimitiveType) variableDecl.getType().getType());
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

	protected Object _evaluateAbstractFeatureCall(XAbstractFeatureCall featureCall, IEvaluationContext context, CancelIndicator indicator) {
		if (expressionHelper.isShortCircuiteBooleanOperation(featureCall)) {
			XExpression leftOperand = ((XBinaryOperation)featureCall).getLeftOperand();
			Object result = internalEvaluate(leftOperand, context, indicator);
			final boolean isAND = featureCall.getConcreteSyntaxFeatureName().equals(expressionHelper.getAndOperator());
			if (isAND && !(Boolean)result) {
				return false;
			} else if (!isAND && (Boolean)result) {
				return true;
			}
			JvmOperation operation = (JvmOperation) featureCall.getFeature();
			XExpression receiver = callToJavaMapping.getActualReceiver(featureCall);
			List<XExpression> operationArguments = callToJavaMapping.getActualArguments(featureCall);
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
		XExpression receiver = callToJavaMapping.getActualReceiver(featureCall);
		Object receiverObj = receiver==null?null:internalEvaluate(receiver, context, indicator);
		return internalFeatureCallDispatch(featureCall, receiverObj, context, indicator);
	}

	protected Object internalFeatureCallDispatch(XAbstractFeatureCall featureCall, Object receiverObj,
			IEvaluationContext context, CancelIndicator indicator) {
		return featureCallDispatcher.invoke(featureCall.getFeature(), featureCall, receiverObj, context, indicator);
	}

	/**
	 * @param featureCall unused in this context but required for dispatching
	 * @param indicator unused in this context but required for dispatching
	 */
	protected Object _featureCallJvmIdentifyableElement(JvmIdentifiableElement identifiable, XFeatureCall featureCall, Object receiver,
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
	protected Object _featureCallField(JvmField jvmField, XAbstractFeatureCall featureCall, Object receiver, IEvaluationContext context, CancelIndicator indicator) {
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

	protected Object _featureCallOperation(JvmOperation operation, XAbstractFeatureCall featureCall, Object receiver,
			IEvaluationContext context, CancelIndicator indicator) {
		List<XExpression> operationArguments = callToJavaMapping.getActualArguments(featureCall);
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
			method.setAccessible(true);
			if (!Modifier.isStatic(method.getModifiers()) && receiver==null) {
				throw new EvaluationException(new NullPointerException("cannot invoke method "+method+" on null"));
			}
			if (Modifier.isStatic(method.getModifiers()) && receiver!=null) {
				throw new IllegalArgumentException("A static method can't be invoked on a receiver.");
			}
			Object result = method.invoke(receiver, argumentValues.toArray(new Object[argumentValues.size()]));
			return result;
		} catch (EvaluationException e) {
			throw e;
		} catch (InvocationTargetException targetException) {
			if (targetException.getCause() instanceof InterpreterCanceledException)
				throw (InterpreterCanceledException) targetException.getCause();
			throw new EvaluationException(targetException.getTargetException());
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

	protected Object _evaluateAssignment(XAssignment assignment, IEvaluationContext context, CancelIndicator indicator) {
		Object value = internalEvaluate(assignment.getValue(), context, indicator);
		Object assign = assignValue(assignment.getFeature(), assignment, value, context, indicator);
		return assign;
	}
	
	protected Object assignValue(JvmIdentifiableElement feature, XAssignment assignment, Object value, IEvaluationContext context, CancelIndicator indicator) {
		return assignmentDispatcher.invoke(feature, assignment, value, context, indicator);
	}

	/**
	 * @param assignment unused in this context but required for dispatching
	 * @param indicator unused in this context but required for dispatching
	 */
	protected Object _assignValueToDeclaredVariable(XVariableDeclaration variable, XAssignment assignment, Object value,
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

	protected Object _assignValueToField(JvmField jvmField, XAssignment assignment, Object value,
			IEvaluationContext context, CancelIndicator indicator) {
		Object receiver = getReceiver(assignment, context, indicator);
		if (receiver == null)
			throw new EvaluationException(new NullPointerException("Cannot assign value to field: "
					+ jvmField.getIdentifier() + " on null instance"));
		JvmTypeReference type = jvmField.getType();
		Object coerced = coerceArgumentType(value, type);
		Field field = javaReflectAccess.getField(jvmField);
		try {
			if (field == null) {
				throw new NoSuchFieldException("Could not find field " + jvmField.getIdentifier());
			}
			field.setAccessible(true);
			field.set(receiver, coerced);
			return value;
		} catch (Exception e) {
			throw new IllegalStateException("Could not access field: " + jvmField.getIdentifier()
					+ " on instance: " + receiver, e);
		}
	}

	protected Object getReceiver(XAssignment assignment, IEvaluationContext context, CancelIndicator indicator) {
		XExpression receiver = callToJavaMapping.getActualReceiver(assignment);
		Object result = receiver == null ? null : internalEvaluate(receiver, context, indicator);
		return result;
	}

	protected Object _assignValueByOperation(JvmOperation jvmOperation, XAssignment assignment, Object value,
			IEvaluationContext context, CancelIndicator indicator) {
		List<Object> argumentValues;
		if (assignment.getImplicitReceiver() != null && assignment.getAssignable() != null) {
			XExpression implicitArgument = assignment.getAssignable();
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
