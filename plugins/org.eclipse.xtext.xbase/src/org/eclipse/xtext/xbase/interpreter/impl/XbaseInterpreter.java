/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter.impl;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.impl.ClassFinder;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
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
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseInterpreter implements IExpressionInterpreter {

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
	
	protected static class WrappedArray<T> extends AbstractList<T> implements RandomAccess {

		protected static <T> WrappedArray<T> create(T[] array) {
			return new WrappedArray<T>(array);
		}
		
		private T[] array;

		protected WrappedArray(T[] array) {
			this.array = array;
		}

		@Override
		public T get(int index) {
			return array[index];
		}
		
		@Override
		public T set(int index, T element) {
			T old = array[index];
			array[index] = element;
			modCount++;
			return old;
		}

		@Override
		public int size() {
			return array.length;
		}
		
		@Override
		public Object[] toArray() {
			return array.clone();
		}
		
		public T[] internalToArray() {
			modCount++;
			return array;
		}
		
	}
	
	protected static class WrappedPrimitiveArray extends AbstractList<Object> implements RandomAccess {

		protected static WrappedPrimitiveArray create(Object array) {
			return new WrappedPrimitiveArray(array);
		}
		
		private Object array;
		private int size;

		protected WrappedPrimitiveArray(Object array) {
			this.array = array;
			this.size = Array.getLength(array);
		}

		@Override
		public Object get(int index) {
			return Array.get(array, index);
		}
		
		@Override
		public Object set(int index, Object element) {
			Object old = get(index);
			Array.set(array, index, element);
			modCount++;
			return old;
		}

		@Override
		public int size() {
			return size;
		}
		
		public Object internalToArray() {
			modCount++;
			return array;
		}
		
	}
	
	public XbaseInterpreter() {
	}
	
	public XbaseInterpreter(Provider<IEvaluationContext> contextProvider, JavaReflectAccess javaReflectAccess, ClassLoader loader) {
		this.contextProvider = contextProvider;
		this.javaReflectAccess = javaReflectAccess;
		setClassLoader(loader);
	}
	
	@Inject
	private Provider<IEvaluationContext> contextProvider;
	
	@Inject
	private JavaReflectAccess javaReflectAccess;

	private ClassFinder classFinder;

	private ClassLoader classLoader;

	@Inject
	public void setClassLoader(ClassLoader classLoader) {
		this.classFinder = new ClassFinder(classLoader);
		this.classLoader = classLoader;
	}
	
	private PolymorphicDispatcher<IEvaluationResult> evaluateDispatcher = createEvaluateDispatcher();
	private PolymorphicDispatcher<IEvaluationResult> assignmentDispatcher = createAssignmentDispatcher();
	private PolymorphicDispatcher<IEvaluationResult> featureCallDispatcher = createFeatureCallDispatcher();

	protected PolymorphicDispatcher<IEvaluationResult> createEvaluateDispatcher() {
		return PolymorphicDispatcher.createForSingleTarget(new PrefixMethodFilter("_evaluate", 2, 2), this);
	}
	
	protected PolymorphicDispatcher<IEvaluationResult> createAssignmentDispatcher() {
		return PolymorphicDispatcher.createForSingleTarget(new PrefixMethodFilter("_assignValue", 4, 4), this);
	}
	
	protected PolymorphicDispatcher<IEvaluationResult> createFeatureCallDispatcher() {
		return PolymorphicDispatcher.createForSingleTarget(new PrefixMethodFilter("_featureCall", 4, 4), this);
	}
	
	public IEvaluationResult evaluate(EObject expression) {
		return evaluate(expression, createContext());
	}

	protected IEvaluationContext createContext() {
		return contextProvider.get();
	}

	public IEvaluationResult evaluate(EObject expression, IEvaluationContext context) {
		IEvaluationResult result = evaluateDispatcher.invoke(expression, context);
		result = wrapArray(result);
		return result;
	}
	
	public IEvaluationResult _evaluateNullLiteral(XNullLiteral literal, IEvaluationContext context) {
		return DefaultEvaluationResult.NULL;
	}
	
	public IEvaluationResult _evaluateStringLiteral(XStringLiteral literal, IEvaluationContext context) {
		return new DefaultEvaluationResult(literal.getValue(), null);
	}
	
	public IEvaluationResult _evaluateIntLiteral(XIntLiteral literal, IEvaluationContext context) {
		return new DefaultEvaluationResult(literal.getValue(), null);
	}
	
	public IEvaluationResult _evaluateBooleanLiteral(XBooleanLiteral literal, IEvaluationContext context) {
		return new DefaultEvaluationResult(literal.isIsTrue(), null);
	}
	
	public IEvaluationResult _evaluateTypeLiteral(XTypeLiteral literal, IEvaluationContext context) {
		if (literal.getType() == null || literal.getType().eIsProxy()) {
			List<INode> nodesForFeature = NodeModelUtils.findNodesForFeature(literal, XbasePackage.Literals.XTYPE_LITERAL__TYPE);
			// TODO cleanup
			if (nodesForFeature.isEmpty())
				return new DefaultEvaluationResult(null, new ClassNotFoundException());
			return new DefaultEvaluationResult(null, new ClassNotFoundException(nodesForFeature.get(0).getText()));
		}
		try {
			Class<?> result = classFinder.forName(literal.getType().getCanonicalName());
			return new DefaultEvaluationResult(result, null);
		} catch(ClassNotFoundException cnfe) {
			return new DefaultEvaluationResult(null, cnfe);
		}
	}
	
	public IEvaluationResult _evaluateClosure(XClosure closure, IEvaluationContext context) {
		Class<?> functionIntf = null;
		switch(closure.getFormalParameters().size()) {
			case 0:  functionIntf = Functions.Function0.class; break;
			case 1:  functionIntf = Functions.Function1.class; break;
			case 2:  functionIntf = Functions.Function2.class; break;
			case 3:  functionIntf = Functions.Function3.class; break;
			case 4:  functionIntf = Functions.Function4.class; break;
			case 5:  functionIntf = Functions.Function5.class; break;
			case 6:  functionIntf = Functions.Function6.class; break;
			default: functionIntf = Functions.FunctionX.class;
		}
		ClosureInvocationHandler invocationHandler = new ClosureInvocationHandler(closure, context, this);
		Object proxy = Proxy.newProxyInstance(classLoader, new Class<?>[] { functionIntf }, invocationHandler);
		return new DefaultEvaluationResult(proxy, null);
	}
	
	public IEvaluationResult _evaluateBlockExpression(XBlockExpression literal, IEvaluationContext context) {
		List<XExpression> expressions = literal.getExpressions();
		
		IEvaluationResult result = DefaultEvaluationResult.NULL;
		IEvaluationContext forkedContext = context.fork();
		for(int i = 0; i < expressions.size(); i++) {
			result = evaluate(expressions.get(i), forkedContext);
			if (result.getException() != null)
				return new DefaultEvaluationResult(null, result.getException());
		}
		return result;
	}
	
	public IEvaluationResult _evaluateIfExpression(XIfExpression ifExpression, IEvaluationContext context) {
		IEvaluationResult conditionResult = evaluate(ifExpression.getIf(), context);
		if (conditionResult.getException() != null) {
			return conditionResult;
		}
		if (Boolean.TRUE.equals(conditionResult.getResult())) {
			return evaluate(ifExpression.getThen(), context);
		} else {
			if (ifExpression.getElse() == null)
				return DefaultEvaluationResult.NULL;
			return evaluate(ifExpression.getElse(), context);
		}
	}
	
	public IEvaluationResult _evaluateSwitchExpression(XSwitchExpression switchExpression, IEvaluationContext context) {
		IEvaluationContext forkedContext = context.fork();
		IEvaluationResult conditionResult = null;
		if (switchExpression.getSwitch() != null) {
			conditionResult = evaluate(switchExpression.getSwitch(), forkedContext);
			if (conditionResult.getException() != null) {
				return conditionResult;
			}
			if (!(switchExpression.getSwitch() instanceof XVariableDeclaration)) {
				forkedContext.newValue(XbaseScopeProvider.THIS, conditionResult.getResult());
			}
		} else {
			conditionResult = new DefaultEvaluationResult(forkedContext.getValue(XbaseScopeProvider.THIS), null);
		}
		for(XCasePart casePart: switchExpression.getCases()) {
			Class<?> expectedType = null;
			if (casePart.getTypeGuard() != null) {
				String typeName = casePart.getTypeGuard().getType().getCanonicalName();
				try {
					expectedType = classFinder.forName(typeName);
				} catch (ClassNotFoundException e) {
					return new DefaultEvaluationResult(null, e);
				}
			}
			if (expectedType != null && conditionResult.getResult() == null)
				throw new IllegalStateException("Switch without expression or implicit 'this' may not use type guards");
			if (expectedType == null || expectedType.isInstance(conditionResult.getResult())) {
				if (casePart.getCase() != null) {
					IEvaluationResult casePartResult = evaluate(casePart.getCase(), forkedContext);
					if (casePartResult.getException() != null)
						return casePartResult;
					if (Boolean.TRUE.equals(casePartResult.getResult()) || eq(conditionResult.getResult(), casePartResult.getResult())) {
						return evaluate(casePart.getThen(), forkedContext);
					}
				} else {
					return evaluate(casePart.getThen(), forkedContext);
				}
			}
		}
		if (switchExpression.getDefault() != null) {
			IEvaluationResult defaultResult = evaluate(switchExpression.getDefault(), forkedContext);
			return defaultResult;
		}
		return DefaultEvaluationResult.NULL;
	}
	
	public IEvaluationResult _evaluateCastedExpression(XCastedExpression castedExpression, IEvaluationContext context) {
		IEvaluationResult result = evaluate(castedExpression.getTarget(), context);
		if (result.getException() != null)
			return result;
		String typeName = castedExpression.getType().getType().getCanonicalName();
		Class<?> expectedType = null;
		try {
			expectedType = classFinder.forName(typeName);
		} catch (ClassNotFoundException e) {
			return new DefaultEvaluationResult(null, e);
		}
		try {
			expectedType.cast(result.getResult());
		} catch(ClassCastException e) {
			return new DefaultEvaluationResult(null, e);
		}
		return result;
	}
	
	public IEvaluationResult _evaluateThrowExpression(XThrowExpression throwExpression, IEvaluationContext context) {
		IEvaluationResult thrown = evaluate(throwExpression.getExpression(), context);
		if (thrown.getException() != null)
			return thrown;
		if (thrown.getResult() == null) {
			return createNullPointerResult(throwExpression, "throwable expression evaluated to 'null'");
		}
		if (!(thrown.getResult() instanceof Throwable)) {
			return createClassCastResult(throwExpression.getExpression(), thrown, Throwable.class);
		}
		return new DefaultEvaluationResult(null, (Throwable)thrown.getResult());
	}
	
	public IEvaluationResult _evaluateTryCatchFinallyExpression(XTryCatchFinallyExpression tryCatchFinally, IEvaluationContext context) {
		IEvaluationResult result = evaluate(tryCatchFinally.getExpression(), context);
		if (result.getException() != null) {
			for(XCatchClause catchClause: tryCatchFinally.getCatchClauses()) {
				JvmFormalParameter exception = catchClause.getDeclaredParam();
				String exceptionTypeName = exception.getParameterType().getType().getCanonicalName();
				try {
					Class<?> exceptionType = classFinder.forName(exceptionTypeName);
					if (!exceptionType.isInstance(result.getException()))
						continue;
				} catch(ClassNotFoundException e) {
					return new DefaultEvaluationResult(null, e);
				}
				IEvaluationContext forked = context.fork();
				forked.newValue(QualifiedName.create(exception.getName()), result.getException());
				result = evaluate(catchClause.getExpression(), forked);
				break;
			}
		}
		if (tryCatchFinally.getFinallyExpression() != null) {
			IEvaluationResult finallyResult = evaluate(tryCatchFinally.getFinallyExpression(), context);
			if (finallyResult.getException() != null) {
				return new DefaultEvaluationResult(null, new FinallyDidNotCompleteException(finallyResult.getException()));
			}
		}
		return result;
	}
	
	protected boolean eq(Object a, Object b) {
		return a == b || (a!=null && a.equals(b));
	}
	
	protected IEvaluationResult createNullPointerResult(XExpression expression, String message) {
		return new DefaultEvaluationResult(null, new NullPointerException(message)); 
	}
	
	protected IEvaluationResult createClassCastResult(XExpression expression, 
			IEvaluationResult result, Class<?> expectedType) {
		return new DefaultEvaluationResult(null, 
				new ClassCastException("Expected: " + expectedType.getCanonicalName() + " but got: " + result.getResult().getClass().getCanonicalName())); 
	}
	
	protected IEvaluationResult wrapArray(IEvaluationResult result) {
		if (result.getResult() != null && result.getException() == null) {
			return wrapArray(result, result.getResult());
		}
		return result;
	}
	
	protected Object unwrapArray(Object value) {
		if (value instanceof WrappedArray<?>)
			return ((WrappedArray<?>) value).internalToArray();
		if (value instanceof WrappedPrimitiveArray)
			return ((WrappedPrimitiveArray) value).internalToArray();
		return value;
	}
	
	protected IEvaluationResult wrapArray(IEvaluationResult original, Object array) {
		Class<?> arrayClass = array.getClass();
		if (arrayClass.isArray()) {
			if (arrayClass.getComponentType().isPrimitive()) {
				WrappedPrimitiveArray result = WrappedPrimitiveArray.create(array);
				return new DefaultEvaluationResult(result, null);
			}
			WrappedArray<Object> result = WrappedArray.create((Object[])array);
			return new DefaultEvaluationResult(result, null);
		}
		return original;
	}
	
	public IEvaluationResult _evaluateForLoopExpression(XForLoopExpression forLoop, IEvaluationContext context) {
		IEvaluationResult iterableOrIterator = evaluate(forLoop.getForExpression(), context);
		if (iterableOrIterator.getException() != null)
			return iterableOrIterator;
		if (iterableOrIterator.getResult() == null)
			return createNullPointerResult(forLoop.getForExpression(), "iterable evaluated to 'null'");
		Iterator<?> iter = null;
		if (iterableOrIterator.getResult() instanceof Iterable<?>) {
			iter = ((Iterable<?>) iterableOrIterator.getResult()).iterator();
		} else {
			return createClassCastResult(forLoop.getForExpression(), iterableOrIterator, java.lang.Iterable.class); 
		}
		IEvaluationContext forkedContext = context.fork();
		QualifiedName paramName = QualifiedName.create(forLoop.getDeclaredParam().getName());
		forkedContext.newValue(paramName, null);
		while(iter.hasNext()) {
			Object next = iter.next();
			forkedContext.assignValue(paramName, next);
			IEvaluationResult result = evaluate(forLoop.getEachExpression(), forkedContext);
			if (result.getException() != null)
				return result;
		}
		return DefaultEvaluationResult.NULL;
	}
	
	public IEvaluationResult _evaluateWhileExpression(XWhileExpression whileLoop, IEvaluationContext context) {
		IEvaluationResult condition = evaluate(whileLoop.getPredicate(), context);
		if (condition.getException() != null)
			return condition;
		while(Boolean.TRUE.equals(condition.getResult())) {
			IEvaluationResult body = evaluate(whileLoop.getBody(), context);
			if (body.getException() != null)
				return body;
			condition = evaluate(whileLoop.getPredicate(), context);
			if (condition.getException() != null)
				return condition;
		}
		return DefaultEvaluationResult.NULL;
	}
	
	public IEvaluationResult _evaluateDoWhileExpression(XDoWhileExpression doWhileLoop, IEvaluationContext context) {
		IEvaluationResult condition = null;
		do {
			IEvaluationResult body = evaluate(doWhileLoop.getBody(), context);
			if (body.getException() != null)
				return body;
			condition = evaluate(doWhileLoop.getPredicate(), context);
			if (condition.getException() != null)
				return condition;
		} while(Boolean.TRUE.equals(condition.getResult()));
		return DefaultEvaluationResult.NULL;
	}
	
	public IEvaluationResult _evaluateConstructorCall(XConstructorCall constructorCall, IEvaluationContext context) {
		List<Object> arguments = Lists.newArrayList();
		JvmConstructor jvmConstructor = constructorCall.getConstructor();
		IEvaluationResult argumentException = evaluateArgumentExpressions(jvmConstructor, constructorCall.getArguments(), arguments, context);
		if (argumentException != null && argumentException.getException() != null)
			return argumentException;
		Constructor<?> constructor = javaReflectAccess.getConstructor(jvmConstructor);
		try {
			if (constructor == null)
				throw new NoSuchMethodException("Could not find constructor " + jvmConstructor.getFullyQualifiedName());
			constructor.setAccessible(true);
			Object result = constructor.newInstance(arguments.toArray(new Object[arguments.size()]));
			return new DefaultEvaluationResult(result, null);
		} catch(InvocationTargetException targetException) {
			return new DefaultEvaluationResult(null, targetException.getTargetException());
		} catch(Exception e) {
			throw new IllegalStateException("Could not invoke constructor: " + jvmConstructor.getCanonicalName(), e);
		}
	}
	
	public IEvaluationResult _evaluateMemberFeatureCall(XMemberFeatureCall featureCall, IEvaluationContext context) {
		IEvaluationResult memberCallTarget = evaluate(featureCall.getMemberCallTarget(), context);
		if (memberCallTarget.getException() != null)
			return memberCallTarget;
		IEvaluationResult result = featureCallDispatcher.invoke(featureCall.getFeature(), featureCall, memberCallTarget.getResult(), context);
		return result;
	}
	
	public IEvaluationResult _evaluateBinaryOperation(XBinaryOperation operation, IEvaluationContext context) {
		IEvaluationResult leftOperand = evaluate(operation.getLeftOperand(), context);
		if (leftOperand.getException() != null)
			return leftOperand;
		IEvaluationResult result = featureCallDispatcher.invoke(operation.getFeature(), operation, leftOperand.getResult(), context);
		return result;
	}
	
	public IEvaluationResult _evaluateInstanceOf(XInstanceOfExpression instanceOf, IEvaluationContext context) {
		IEvaluationResult instance = evaluate(instanceOf.getExpression(), context);
		if (instance.getException() != null)
			return instance;
		if (instance.getResult() == null)
			return new DefaultEvaluationResult(Boolean.FALSE, null);
		
		Class<?> expectedType = null;
		try {
			expectedType = classFinder.forName(instanceOf.getType().getCanonicalName());
		} catch(ClassNotFoundException cnfe) {
			return new DefaultEvaluationResult(null, cnfe);
		}
		return new DefaultEvaluationResult(expectedType.isInstance(instance.getResult()), null);
	}
	
	public IEvaluationResult _evaluateVariableDeclaration(XVariableDeclaration variableDecl, IEvaluationContext context) {
		IEvaluationResult result = evaluate(variableDecl.getRight(), context);
		if (result.getException() != null)
			return result;
		context.newValue(QualifiedName.create(variableDecl.getName()), result.getResult());
		return result;
	}
	
	public IEvaluationResult _evaluateFeatureCall(XFeatureCall featureCall, IEvaluationContext context) {
		return featureCallDispatcher.invoke(featureCall.getFeature(), featureCall, null, context);
	}
	
	public IEvaluationResult _featureCallVariableDeclaration(XVariableDeclaration variableDeclaration, XAbstractFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		if (receiver != null)
			throw new IllegalStateException("feature was variableDeclaration but got receiver instead of null. Receiver: " + receiver);
		Object value = context.getValue(QualifiedName.create(variableDeclaration.getName()));
		return new DefaultEvaluationResult(value, null);
	}
	
	public IEvaluationResult _featureCallFormalParameter(JvmFormalParameter parameter, XAbstractFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		if (receiver != null)
			throw new IllegalStateException("feature was parameter but got receiver instead of null. Receiver: " + receiver);
		Object value = context.getValue(QualifiedName.create(parameter.getName()));
		return new DefaultEvaluationResult(value, null);
	}
	
	public IEvaluationResult _featureCallOperation(JvmOperation operation, XAbstractFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		List<XExpression> operationArguments = featureCall.getArguments().subList(1, featureCall.getArguments().size());
		return featureCallOperationImpl(operation, operationArguments, receiver, context);
	}
	
	public IEvaluationResult _featureCallOperation(JvmOperation operation, XFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		if (receiver != null)
			throw new IllegalStateException("feature was simple feature call but got receiver instead of null. Receiver: " + receiver);
		List<XExpression> operationArguments = featureCall.getFeatureCallArguments();
		return featureCallOperationImpl(operation, operationArguments, context.getValue(XbaseScopeProvider.THIS), context);
	}

	protected IEvaluationResult featureCallOperationImpl(JvmOperation operation, List<XExpression> operationArguments,
			Object receiver, IEvaluationContext context) {
		List<Object> argumentValues = Lists.newArrayList();
		IEvaluationResult argumentException = evaluateArgumentExpressions(operation, operationArguments, argumentValues, context);
		if (argumentException != null && argumentException.getException() != null)
			return argumentException;
		return invokeOperation(operation, receiver, argumentValues);
	}

	protected IEvaluationResult invokeOperation(JvmOperation operation, Object receiver, List<Object> argumentValues) {
		Method method = javaReflectAccess.getMethod(operation);
		try {
			if (method == null) {
				throw new NoSuchMethodException("Could not find method " + operation.getFullyQualifiedName());
			}
			method.setAccessible(true);
			if (!Modifier.isStatic(method.getModifiers())) {
				if (receiver == null)
					return new DefaultEvaluationResult(null, new NullPointerException("Cannot invoke instance method: " + operation.getCanonicalName() + " without receiver"));
				Object result = method.invoke(receiver, argumentValues.toArray(new Object[argumentValues.size()]));
				return new DefaultEvaluationResult(result, null);
			} else {
				argumentValues.add(0, receiver);
				Object result = method.invoke(null, argumentValues.toArray(new Object[argumentValues.size()]));
				return new DefaultEvaluationResult(result, null);
			}
		} catch(InvocationTargetException targetException) {
			return new DefaultEvaluationResult(null, targetException.getTargetException());
		} catch(Exception e) {
			throw new IllegalStateException("Could not invoke method: " + operation.getFullyQualifiedName() + " on instance: " + receiver, e);
		}
	}
	
	protected IEvaluationResult evaluateArgumentExpressions(JvmExecutable executable, List<XExpression> expressions, List<Object> result,
			IEvaluationContext context) {
		int i = 0;
		for(XExpression arg: expressions) {
			IEvaluationResult argResult = evaluate(arg, context);
			if (argResult.getException() != null)
				return argResult;
			JvmTypeReference parameterType = executable.getParameters().get(i).getParameterType();
			Object argumentValue = coerceArgumentType(argResult.getResult(), parameterType);
			result.add(argumentValue);
			i++;
		}
		return null;
	}

	protected Object coerceArgumentType(Object value, JvmTypeReference expectedType) {
		if (value == null)
			return null;
		if (expectedType.getType() instanceof JvmArrayType)
			return unwrapArray(value);
		if (expectedType.getType() instanceof JvmGenericType && ((JvmGenericType) expectedType.getType()).isInterface()) {
			try {
				JvmType type = expectedType.getType();
				Class<?> functionIntf = classFinder.forName(type.getCanonicalName());
				if (!functionIntf.isInstance(value)) {
					InvocationHandler invocationHandler = null;
					if (Proxy.isProxyClass(value.getClass())) {
						invocationHandler = Proxy.getInvocationHandler(value);
					} else if (Functions.Function0.class.isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, Functions.Function0.class);
					} else if (Functions.Function1.class.isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, Functions.Function1.class);
					} else if (Functions.Function2.class.isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, Functions.Function2.class);
					} else if (Functions.Function3.class.isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, Functions.Function3.class);
					} else if (Functions.Function4.class.isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, Functions.Function4.class);
					} else if (Functions.Function5.class.isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, Functions.Function5.class);
					} else if (Functions.Function6.class.isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, Functions.Function6.class);
					} else if (Functions.FunctionX.class.isInstance(value)) {
						invocationHandler = new DelegatingInvocationHandler(value, Functions.FunctionX.class);
					}
					Object proxy = Proxy.newProxyInstance(classLoader, new Class<?>[] { functionIntf }, invocationHandler);
					return proxy;
				}
			} catch (ClassNotFoundException e) {
				throw new NoClassDefFoundError(e.getMessage());
			}
			
		}
		return value;
	}

	public IEvaluationResult _featureCallField(JvmField jvmField, XMemberFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		if (receiver == null)
			return new DefaultEvaluationResult(null, new NullPointerException("Cannot access field: " + jvmField.getCanonicalName() + " on null instance"));
		
		return featureCallField(jvmField, receiver);
	}
	
	public IEvaluationResult _featureCallField(JvmField jvmField, XFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		if (receiver != null)
			throw new IllegalStateException("feature was simple feature call but got receiver instead of null. Receiver: " + receiver);
		Object thisReceiver = context.getValue(XbaseScopeProvider.THIS);
		if (thisReceiver == null)
			return new DefaultEvaluationResult(null, new NullPointerException("Cannot access field: " + jvmField.getCanonicalName() + " on null instance"));
		
		return featureCallField(jvmField, thisReceiver);
	}

	protected IEvaluationResult featureCallField(JvmField jvmField, Object receiver) {
		Field field = javaReflectAccess.getField(jvmField);
		try {
			if (field == null) {
				throw new NoSuchFieldException("Could not find field " + jvmField.getFullyQualifiedName());
			}
			field.setAccessible(true);
			Object result = field.get(receiver);
			return new DefaultEvaluationResult(result, null);
		} catch(Exception e) {
			throw new IllegalStateException("Could not access field: " + jvmField.getFullyQualifiedName() + " on instance: " + receiver, e);
		}
	}
	
	public IEvaluationResult _evaluateAssignment(XAssignment assignment, IEvaluationContext context) {
		IEvaluationResult value = evaluate(assignment.getValue(), context);
		if (value.getException() != null)
			return value;
		IEvaluationResult assign = assignValue(assignment.getFeature(), assignment.getAssignable(), value.getResult(), context);
		return assign;
	}
	
	public IEvaluationResult assignValue(JvmIdentifyableElement feature, Object assignable, Object value, IEvaluationContext context) {
		return assignmentDispatcher.invoke(feature, assignable, value, context);
	}
	
	public IEvaluationResult _assignValueToDeclaredVariable(XVariableDeclaration variable, Object assignable, Object value, IEvaluationContext context) {
		context.assignValue(QualifiedName.create(variable.getName()), value);
		return new DefaultEvaluationResult(value, null);
	}
	
	public IEvaluationResult _assignValueToField(JvmField jvmField, XMemberFeatureCall assignable, Object value, IEvaluationContext context) {
		IEvaluationResult target = evaluate(assignable.getMemberCallTarget(), context);
		if (target.getException() != null)
			return target;
		Object receiver = target.getResult();
		if (receiver == null)
			return new DefaultEvaluationResult(null, new NullPointerException("Cannot assign value to field: " + jvmField.getCanonicalName() + " on null instance"));
		
		return assignValueToField(jvmField, receiver, value);
	}
	
	public IEvaluationResult _assignValueToField(JvmField jvmField, XFeatureCall assignable, Object value, IEvaluationContext context) {
		Object receiver = context.getValue(XbaseScopeProvider.THIS);
		if (receiver == null)
			return new DefaultEvaluationResult(null, new NullPointerException("Cannot assign value to field: " + jvmField.getCanonicalName() + " on null instance"));
		return assignValueToField(jvmField, receiver, value);
	}

	protected IEvaluationResult assignValueToField(JvmField jvmField, Object receiver, Object value) {
		Field field = javaReflectAccess.getField(jvmField);
		try {
			if (field == null) {
				throw new NoSuchFieldException("Could not find field " + jvmField.getFullyQualifiedName());
			}
			field.setAccessible(true);
			field.set(receiver, value);
			return new DefaultEvaluationResult(value, null);
		} catch(Exception e) {
			throw new IllegalStateException("Could not access field: " + jvmField.getFullyQualifiedName() + " on instance: " + receiver, e);
		}
	}
	
	public IEvaluationResult _assignValueByOperation(JvmOperation jvmOperation, XMemberFeatureCall assignable, Object value, IEvaluationContext context) {
		IEvaluationResult target = evaluate(assignable.getMemberCallTarget(), context);
		if (target.getException() != null)
			return target;
		Object receiver = target.getResult();
		if (receiver == null)
			return new DefaultEvaluationResult(null, new NullPointerException("Cannot invoke instance method: " + jvmOperation.getCanonicalName() + " without receiver"));
		
		return assignValueByOperation(jvmOperation, receiver, value);
	}
	
	public IEvaluationResult _assignValueByOperation(JvmOperation jvmOperation, XFeatureCall assignable, Object value, IEvaluationContext context) {
		// TODO: rework linking semantic and remove special case for add()
		Object receiver = null;
		if ("add".equals(jvmOperation.getSimpleName())) {
			IEvaluationResult receiverResult = evaluate(assignable, context);
			if (receiverResult.getException() != null)
				return receiverResult;
			receiver = receiverResult.getResult();
		} else {
			receiver = context.getValue(XbaseScopeProvider.THIS);
		}
		if (receiver == null)
			return new DefaultEvaluationResult(null, new NullPointerException("Cannot invoke instance method: " + jvmOperation.getCanonicalName() + " without receiver"));
		return assignValueByOperation(jvmOperation, receiver, value);
	}
	
	protected IEvaluationResult assignValueByOperation(JvmOperation operation, Object receiver, Object value) {
		List<Object> argumentValues = Lists.newArrayList(value);
		IEvaluationResult result = invokeOperation(operation, receiver, argumentValues);
		return result;
	}
	
	public ClassFinder getClassFinder() {
		return classFinder;
	}
	
	public JavaReflectAccess getJavaReflectAccess() {
		return javaReflectAccess;
	}
}
