/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;

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
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
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
	
	private PolymorphicDispatcher<Object> evaluateDispatcher = createEvaluateDispatcher();
	private PolymorphicDispatcher<Object> assignmentDispatcher = createAssignmentDispatcher();
	private PolymorphicDispatcher<Object> featureCallDispatcher = createFeatureCallDispatcher();

	protected PolymorphicDispatcher<Object> createEvaluateDispatcher() {
		return PolymorphicDispatcher.createForSingleTarget(new PrefixMethodFilter("_evaluate", 2, 2), this);
	}
	
	protected PolymorphicDispatcher<Object> createAssignmentDispatcher() {
		return PolymorphicDispatcher.createForSingleTarget(new PrefixMethodFilter("_assignValue", 4, 4), this);
	}
	
	protected PolymorphicDispatcher<Object> createFeatureCallDispatcher() {
		return PolymorphicDispatcher.createForSingleTarget(new PrefixMethodFilter("_featureCall", 4, 4), this);
	}
	
	public IEvaluationResult evaluate(EObject expression) {
		return evaluate(expression, createContext());
	}

	protected IEvaluationContext createContext() {
		return contextProvider.get();
	}

	public IEvaluationResult evaluate(EObject expression, IEvaluationContext context) {
		try {
			Object result = internalEvaluate(expression, context);
			// TODO: should we unwrap the array?
//			result = unwrapArray(result);
			return new DefaultEvaluationResult(result, null);
		} catch(EvaluationException e) {
			return new DefaultEvaluationResult(null, e.getCause());
		}
	}
	
	protected Object internalEvaluate(EObject expression, IEvaluationContext context) throws EvaluationException {
		Object result = evaluateDispatcher.invoke(expression, context);
		result = wrapArray(result);
		return result;
	}
	
	public Object _evaluateNullLiteral(XNullLiteral literal, IEvaluationContext context) {
		return null;
	}
	
	public Object _evaluateStringLiteral(XStringLiteral literal, IEvaluationContext context) {
		return literal.getValue();
	}
	
	public Object _evaluateIntLiteral(XIntLiteral literal, IEvaluationContext context) {
		return literal.getValue();
	}
	
	public Object _evaluateBooleanLiteral(XBooleanLiteral literal, IEvaluationContext context) {
		return literal.isIsTrue();
	}
	
	public Object _evaluateTypeLiteral(XTypeLiteral literal, IEvaluationContext context) {
		if (literal.getType() == null || literal.getType().eIsProxy()) {
			List<INode> nodesForFeature = NodeModelUtils.findNodesForFeature(literal, XbasePackage.Literals.XTYPE_LITERAL__TYPE);
			// TODO cleanup
			if (nodesForFeature.isEmpty())
				throw new EvaluationException(new ClassNotFoundException());
			throw new EvaluationException(new ClassNotFoundException(nodesForFeature.get(0).getText()));
		}
		try {
			Class<?> result = classFinder.forName(literal.getType().getCanonicalName());
			return result;
		} catch(ClassNotFoundException cnfe) {
			throw new EvaluationException(cnfe);
		}
	}
	
	public Object _evaluateClosure(XClosure closure, IEvaluationContext context) {
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
		return proxy;
	}
	
	public Object _evaluateBlockExpression(XBlockExpression literal, IEvaluationContext context) {
		List<XExpression> expressions = literal.getExpressions();
		
		Object result = null;
		IEvaluationContext forkedContext = context.fork();
		for(int i = 0; i < expressions.size(); i++) {
			result = internalEvaluate(expressions.get(i), forkedContext);
		}
		return result;
	}
	
	public Object _evaluateIfExpression(XIfExpression ifExpression, IEvaluationContext context) {
		Object conditionResult = internalEvaluate(ifExpression.getIf(), context);
		if (Boolean.TRUE.equals(conditionResult)) {
			return internalEvaluate(ifExpression.getThen(), context);
		} else {
			if (ifExpression.getElse() == null)
				return null;
			return internalEvaluate(ifExpression.getElse(), context);
		}
	}
	
	public Object _evaluateSwitchExpression(XSwitchExpression switchExpression, IEvaluationContext context) {
		IEvaluationContext forkedContext = context.fork();
		Object conditionResult = internalEvaluate(switchExpression.getSwitch(), forkedContext);
		if (switchExpression.getLocalVarName() != null) {
			forkedContext.newValue(QualifiedName.create(switchExpression.getLocalVarName()), conditionResult);
		}
		for(XCasePart casePart: switchExpression.getCases()) {
			Class<?> expectedType = null;
			if (casePart.getTypeGuard() != null) {
				String typeName = casePart.getTypeGuard().getType().getCanonicalName();
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
					Object casePartResult = internalEvaluate(casePart.getCase(), forkedContext);
					if (Boolean.TRUE.equals(casePartResult) || eq(conditionResult, casePartResult)) {
						return internalEvaluate(casePart.getThen(), forkedContext);
					}
				} else {
					return internalEvaluate(casePart.getThen(), forkedContext);
				}
			}
		}
		if (switchExpression.getDefault() != null) {
			Object defaultResult = internalEvaluate(switchExpression.getDefault(), forkedContext);
			return defaultResult;
		}
		return null;
	}
	
	public Object _evaluateCastedExpression(XCastedExpression castedExpression, IEvaluationContext context) {
		Object result = internalEvaluate(castedExpression.getTarget(), context);
		String typeName = castedExpression.getType().getType().getCanonicalName();
		Class<?> expectedType = null;
		try {
			expectedType = classFinder.forName(typeName);
		} catch (ClassNotFoundException e) {
			throw new EvaluationException(new NoClassDefFoundError(typeName));
		}
		try {
			expectedType.cast(result);
		} catch(ClassCastException e) {
			throw new EvaluationException(e);
		}
		return result;
	}
	
	public Object _evaluateThrowExpression(XThrowExpression throwExpression, IEvaluationContext context) {
		Object thrown = internalEvaluate(throwExpression.getExpression(), context);
		if (thrown == null) {
			return throwNullPointerException(throwExpression, "throwable expression evaluated to 'null'");
		}
		if (!(thrown instanceof Throwable)) {
			return throwClassCastException(throwExpression.getExpression(), thrown, Throwable.class);
		}
		throw new EvaluationException((Throwable)thrown);
	}
	
	public Object _evaluateTryCatchFinallyExpression(XTryCatchFinallyExpression tryCatchFinally, IEvaluationContext context) {
		Object result = null;
		try {
			result = internalEvaluate(tryCatchFinally.getExpression(), context);
		} catch(EvaluationException evaluationException) {
			Throwable cause = evaluationException.getCause();
			for(XCatchClause catchClause: tryCatchFinally.getCatchClauses()) {
				JvmFormalParameter exception = catchClause.getDeclaredParam();
				String exceptionTypeName = exception.getParameterType().getType().getCanonicalName();
				try {
					Class<?> exceptionType = classFinder.forName(exceptionTypeName);
					if (!exceptionType.isInstance(cause))
						continue;
				} catch(ClassNotFoundException e) {
					throw new EvaluationException(new NoClassDefFoundError(exceptionTypeName));
				}
				IEvaluationContext forked = context.fork();
				forked.newValue(QualifiedName.create(exception.getName()), cause);
				result = internalEvaluate(catchClause.getExpression(), forked);
				break;
			}
		}
		
		if (tryCatchFinally.getFinallyExpression() != null) {
			try {
				internalEvaluate(tryCatchFinally.getFinallyExpression(), context);
			} catch(EvaluationException e) {
				throw new EvaluationException(new FinallyDidNotCompleteException(e));
			}
		}
		return result;
	}
	
	protected boolean eq(Object a, Object b) {
		return a == b || (a!=null && a.equals(b));
	}
	
	protected Object throwNullPointerException(XExpression expression, String message) {
		throw new EvaluationException(new NullPointerException(message)); 
	}
	
	protected Object throwClassCastException(XExpression expression, 
			Object result, Class<?> expectedType) {
		throw new EvaluationException(new ClassCastException(
						"Expected: " + expectedType.getCanonicalName() + 
						" but got: " + result.getClass().getCanonicalName()));
	}
	
	protected Object wrapArray(Object result) {
		return Conversions.doWrapArray(result);
	}
	
	protected Object unwrapArray(Object value) {
		return Conversions.unwrapArray(value);
	}
	
	public Object _evaluateForLoopExpression(XForLoopExpression forLoop, IEvaluationContext context) {
		Object iterableOrIterator = internalEvaluate(forLoop.getForExpression(), context);
		if (iterableOrIterator == null)
			return throwNullPointerException(forLoop.getForExpression(), "iterable evaluated to 'null'");
		Iterator<?> iter = null;
		if (iterableOrIterator instanceof Iterable<?>) {
			iter = ((Iterable<?>) iterableOrIterator).iterator();
		} else {
			return throwClassCastException(forLoop.getForExpression(), iterableOrIterator, java.lang.Iterable.class); 
		}
		IEvaluationContext forkedContext = context.fork();
		QualifiedName paramName = QualifiedName.create(forLoop.getDeclaredParam().getName());
		forkedContext.newValue(paramName, null);
		while(iter.hasNext()) {
			Object next = iter.next();
			forkedContext.assignValue(paramName, next);
			internalEvaluate(forLoop.getEachExpression(), forkedContext);
		}
		return null;
	}
	
	public Object _evaluateWhileExpression(XWhileExpression whileLoop, IEvaluationContext context) {
		Object condition = internalEvaluate(whileLoop.getPredicate(), context);
		while(Boolean.TRUE.equals(condition)) {
			internalEvaluate(whileLoop.getBody(), context);
			condition = internalEvaluate(whileLoop.getPredicate(), context);
		}
		return null;
	}
	
	public IEvaluationResult _evaluateDoWhileExpression(XDoWhileExpression doWhileLoop, IEvaluationContext context) {
		Object condition = null;
		do {
			internalEvaluate(doWhileLoop.getBody(), context);
			condition = internalEvaluate(doWhileLoop.getPredicate(), context);
		} while(Boolean.TRUE.equals(condition));
		return null;
	}
	
	public Object _evaluateConstructorCall(XConstructorCall constructorCall, IEvaluationContext context) {
		List<Object> arguments = Lists.newArrayList();
		JvmConstructor jvmConstructor = constructorCall.getConstructor();
		evaluateArgumentExpressions(jvmConstructor, constructorCall.getArguments(), arguments, context);
		Constructor<?> constructor = javaReflectAccess.getConstructor(jvmConstructor);
		try {
			if (constructor == null)
				throw new NoSuchMethodException("Could not find constructor " + jvmConstructor.getFullyQualifiedName());
			constructor.setAccessible(true);
			Object result = constructor.newInstance(arguments.toArray(new Object[arguments.size()]));
			return result;
		} catch(InvocationTargetException targetException) {
			throw new EvaluationException(targetException.getTargetException());
		} catch(Exception e) {
			throw new IllegalStateException("Could not invoke constructor: " + jvmConstructor.getCanonicalName(), e);
		}
	}
	
	public Object _evaluateMemberFeatureCall(final XMemberFeatureCall featureCall, final IEvaluationContext context) {
		Object memberCallTarget = internalEvaluate(featureCall.getMemberCallTarget(), context);
		if (featureCall.isNullSafe() && memberCallTarget==null)
			return null;
		if (featureCall.isSpreading()) {
			if (memberCallTarget == null)
				return throwNullPointerException(featureCall.getMemberCallTarget(), "iterable evaluated to 'null'");
			if (memberCallTarget instanceof Iterable<?>) {
				class Spread implements Function<Object, Object> {
					public Object apply(Object from) {
						Object result = featureCallDispatcher.invoke(featureCall.getFeature(), featureCall, from, context);
						return result;
					}
				}
				Iterable<?> iterable = (Iterable<?>) memberCallTarget;
				return Lists.newArrayList(Iterables.transform(iterable, new Spread()));
			} else {
				return throwClassCastException(featureCall.getMemberCallTarget(), memberCallTarget, java.lang.Iterable.class); 
			}
		} else {
			Object result = featureCallDispatcher.invoke(featureCall.getFeature(), featureCall, memberCallTarget, context);
			return result;
		}
	}
	
	public Object _evaluateBinaryOperation(XBinaryOperation operation, IEvaluationContext context) {
		Object leftOperand = internalEvaluate(operation.getLeftOperand(), context);
		Object result = featureCallDispatcher.invoke(operation.getFeature(), operation, leftOperand, context);
		return result;
	}
	
	public Object _evaluateInstanceOf(XInstanceOfExpression instanceOf, IEvaluationContext context) {
		Object instance = internalEvaluate(instanceOf.getExpression(), context);
		if (instance == null)
			return Boolean.FALSE;
		
		Class<?> expectedType = null;
		String className = instanceOf.getType().getCanonicalName();
		try {
			expectedType = classFinder.forName(className);
		} catch(ClassNotFoundException cnfe) {
			throw new EvaluationException(new NoClassDefFoundError(className));
		}
		return expectedType.isInstance(instance);
	}
	
	public Object _evaluateVariableDeclaration(XVariableDeclaration variableDecl, IEvaluationContext context) {
		Object result = internalEvaluate(variableDecl.getRight(), context);
		context.newValue(QualifiedName.create(variableDecl.getName()), result);
		return result;
	}
	
	public Object _evaluateFeatureCall(XFeatureCall featureCall, IEvaluationContext context) {
		return featureCallDispatcher.invoke(featureCall.getFeature(), featureCall, null, context);
	}
	
	public Object _featureCallSwitchExpression(XSwitchExpression switchExpre, XFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		String localVarName = switchExpre.getLocalVarName();
		if (localVarName==null) {
			localVarName = ((XFeatureCall)switchExpre.getSwitch()).getFeatureName();
		}
		Object value = context.getValue(QualifiedName.create(localVarName));
		return value;
	}
	
	public Object _featureCallCasePart(XCasePart casePart, XFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		return _featureCallSwitchExpression((XSwitchExpression) casePart.eContainer(), featureCall, receiver, context);
	}
	
	public Object _featureCallVariableDeclaration(XVariableDeclaration variableDeclaration, XAbstractFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		if (receiver != null)
			throw new IllegalStateException("feature was variableDeclaration but got receiver instead of null. Receiver: " + receiver);
		Object value = context.getValue(QualifiedName.create(variableDeclaration.getName()));
		return value;
	}
	
	public Object _featureCallFormalParameter(JvmFormalParameter parameter, XAbstractFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		if (receiver != null)
			throw new IllegalStateException("feature was parameter but got receiver instead of null. Receiver: " + receiver);
		Object value = context.getValue(QualifiedName.create(parameter.getName()));
		return value;
	}
	
	public Object _featureCallOperation(JvmOperation operation, XAbstractFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		List<XExpression> operationArguments = featureCall.getArguments().subList(1, featureCall.getArguments().size());
		return featureCallOperationImpl(operation, operationArguments, receiver, context);
	}
	
	public Object _featureCallOperation(JvmOperation operation, XFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		if (receiver != null)
			throw new IllegalStateException("feature was simple feature call but got receiver instead of null. Receiver: " + receiver);
		List<XExpression> operationArguments = featureCall.getFeatureCallArguments();
		return featureCallOperationImpl(operation, operationArguments, context.getValue(XbaseScopeProvider.THIS), context);
	}

	protected Object featureCallOperationImpl(JvmOperation operation, List<XExpression> operationArguments,
			Object receiver, IEvaluationContext context) {
		List<Object> argumentValues = Lists.newArrayList();
		evaluateArgumentExpressions(operation, operationArguments, argumentValues, context);
		return invokeOperation(operation, receiver, argumentValues);
	}

	protected Object invokeOperation(JvmOperation operation, Object receiver, List<Object> argumentValues) {
		Method method = javaReflectAccess.getMethod(operation);
		try {
			if (method == null) {
				throw new NoSuchMethodException("Could not find method " + operation.getFullyQualifiedName());
			}
			method.setAccessible(true);
			if (!Modifier.isStatic(method.getModifiers())) {
				if (receiver == null)
					throw new EvaluationException(new NullPointerException("Cannot invoke instance method: " + operation.getCanonicalName() + " without receiver"));
				Object result = method.invoke(receiver, argumentValues.toArray(new Object[argumentValues.size()]));
				return result;
			} else {
				argumentValues.add(0, receiver);
				Object result = method.invoke(null, argumentValues.toArray(new Object[argumentValues.size()]));
				return result;
			}
		} catch(EvaluationException e) {
			throw e;
		} catch(InvocationTargetException targetException) {
			throw new EvaluationException(targetException.getTargetException());
		} catch(Exception e) {
			throw new IllegalStateException("Could not invoke method: " + operation.getFullyQualifiedName() + " on instance: " + receiver, e);
		}
	}
	
	protected void evaluateArgumentExpressions(JvmExecutable executable, List<XExpression> expressions, List<Object> result,
			IEvaluationContext context) {
		int i = 0;
		for(XExpression arg: expressions) {
			Object argResult = internalEvaluate(arg, context);
			JvmTypeReference parameterType = executable.getParameters().get(i).getParameterType();
			Object argumentValue = coerceArgumentType(argResult, parameterType);
			result.add(argumentValue);
			i++;
		}
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

	public Object _featureCallField(JvmField jvmField, XMemberFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		if (receiver == null)
			throw new EvaluationException(new NullPointerException("Cannot access field: " + jvmField.getCanonicalName() + " on null instance"));
		
		return featureCallField(jvmField, receiver);
	}
	
	public Object _featureCallField(JvmField jvmField, XFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		if (receiver != null)
			throw new IllegalStateException("feature was simple feature call but got receiver instead of null. Receiver: " + receiver);
		Object thisReceiver = context.getValue(XbaseScopeProvider.THIS);
		if (thisReceiver == null)
			throw new EvaluationException(new NullPointerException("Cannot access field: " + jvmField.getCanonicalName() + " on null instance"));
		
		return featureCallField(jvmField, thisReceiver);
	}

	protected Object featureCallField(JvmField jvmField, Object receiver) {
		Field field = javaReflectAccess.getField(jvmField);
		try {
			if (field == null) {
				throw new NoSuchFieldException("Could not find field " + jvmField.getFullyQualifiedName());
			}
			field.setAccessible(true);
			Object result = field.get(receiver);
			return result;
		} catch(Exception e) {
			throw new IllegalStateException("Could not access field: " + jvmField.getFullyQualifiedName() + " on instance: " + receiver, e);
		}
	}
	
	public Object _evaluateAssignment(XAssignment assignment, IEvaluationContext context) {
		Object value = internalEvaluate(assignment.getValue(), context);
		Object assign = assignValue(assignment.getFeature(), assignment, value, context);
		return assign;
	}
	
	public Object assignValue(JvmIdentifyableElement feature, XAssignment assignment, Object value, IEvaluationContext context) {
		return assignmentDispatcher.invoke(feature, assignment, value, context);
	}
	
	public Object _assignValueToDeclaredVariable(XVariableDeclaration variable, XAssignment assignment, Object value, IEvaluationContext context) {
		context.assignValue(QualifiedName.create(variable.getName()), value);
		return value;
	}
	
	public Object _assignValueToField(JvmField jvmField, XAssignment assignment, Object value, IEvaluationContext context) {
		Object receiver = getReceiver(assignment, context);
		if (receiver == null)
			throw new EvaluationException(new NullPointerException("Cannot assign value to field: " + jvmField.getCanonicalName() + " on null instance"));
		Field field = javaReflectAccess.getField(jvmField);
		try {
			if (field == null) {
				throw new NoSuchFieldException("Could not find field " + jvmField.getFullyQualifiedName());
			}
			field.setAccessible(true);
			field.set(receiver, value);
			return value;
		} catch(Exception e) {
			throw new IllegalStateException("Could not access field: " + jvmField.getFullyQualifiedName() + " on instance: " + receiver, e);
		}
	}

	protected Object getReceiver(XAssignment assignment, IEvaluationContext context) {
		Object receiver = null;
		if (assignment.getAssignable()==null) {
			// TODO don't imply 'this', but get the information from the AST 
			receiver = context.getValue(XbaseScopeProvider.THIS);
		} else {
			receiver = internalEvaluate(assignment.getAssignable(), context);
		}
		return receiver;
	}
	
	public Object _assignValueByOperation(JvmOperation jvmOperation, XAssignment assignment, Object value, IEvaluationContext context) {
		Object receiver = getReceiver(assignment, context);
		if (receiver == null)
			throw new EvaluationException(new NullPointerException("Cannot invoke instance method: " + jvmOperation.getCanonicalName() + " without receiver"));
		List<Object> argumentValues = Lists.newArrayList(value);
		Object result = invokeOperation(jvmOperation, receiver, argumentValues);
		return result;
	}
	
	public ClassFinder getClassFinder() {
		return classFinder;
	}
	
	public JavaReflectAccess getJavaReflectAccess() {
		return javaReflectAccess;
	}
}
