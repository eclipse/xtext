/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter.impl;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.access.impl.Primitives;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.ReflectionUtil;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;
import org.eclipse.xtext.xbase.util.XbaseSwitch;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseInterpreter implements IExpressionInterpreter {

	@Inject
	private Provider<IEvaluationContext> contextProvider;
	
	@Inject
	private ClassLoader classLoader;
	
	@Inject
	private JavaReflectAccess javaReflectAccess;
	
	private PolymorphicDispatcher<IEvaluationResult> evaluateDispatcher = createEvaluateDispatcher();
	private PolymorphicDispatcher<IEvaluationResult> assignmentDispatcher = createAssignmentDispatcher();
	private PolymorphicDispatcher<IEvaluationResult> featureCallDispatcher = createFeatureCallDispatcher();

	protected PolymorphicDispatcher<IEvaluationResult> createEvaluateDispatcher() {
		return PolymorphicDispatcher.createForSingleTarget("_evaluate", 2, 2, this);
	}
	
	protected PolymorphicDispatcher<IEvaluationResult> createAssignmentDispatcher() {
		return PolymorphicDispatcher.createForSingleTarget("_assignValue", 4, 4, this);
	}
	
	protected PolymorphicDispatcher<IEvaluationResult> createFeatureCallDispatcher() {
		return PolymorphicDispatcher.createForSingleTarget("_featureCall", 4, 4, this);
	}
	
	public IEvaluationResult evaluate(XExpression expression) {
		return evaluate(expression, contextProvider.get());
	}

	public IEvaluationResult evaluate(XExpression expression, IEvaluationContext context) {
		IEvaluationResult result = evaluateDispatcher.invoke(expression, context);
		result = wrapArray(result);
		return result;
	}
	
	public IEvaluationResult _evaluate(XNullLiteral literal, IEvaluationContext context) {
		return DefaultEvaluationResult.NULL;
	}
	
	public IEvaluationResult _evaluate(XStringLiteral literal, IEvaluationContext context) {
		return new DefaultEvaluationResult(literal.getValue(), null);
	}
	
	public IEvaluationResult _evaluate(XIntLiteral literal, IEvaluationContext context) {
		return new DefaultEvaluationResult(literal.getValue(), null);
	}
	
	public IEvaluationResult _evaluate(XBooleanLiteral literal, IEvaluationContext context) {
		return new DefaultEvaluationResult(literal.isIsTrue(), null);
	}
	
	public IEvaluationResult _evaluate(XTypeLiteral literal, IEvaluationContext context) {
		if (literal.getType() == null || literal.getType().eIsProxy()) {
			List<AbstractNode> nodesForFeature = NodeUtil.findNodesForFeature(literal, XbasePackage.Literals.XTYPE_LITERAL__TYPE);
			// TODO cleanup
			if (nodesForFeature.isEmpty())
				return new DefaultEvaluationResult(null, new ClassNotFoundException());
			return new DefaultEvaluationResult(null, new ClassNotFoundException(nodesForFeature.get(0).serialize()));
		}
		try {
			Class<?> result = Class.forName(literal.getType().getCanonicalName(), false, classLoader);
			return new DefaultEvaluationResult(result, null);
		} catch(ClassNotFoundException cnfe) {
			Class<?> primitive = Primitives.forName(literal.getType().getCanonicalName());
			if (primitive != null)
				return new DefaultEvaluationResult(primitive, null);
			return new DefaultEvaluationResult(null, cnfe);
		}
	}
	
	public IEvaluationResult _evaluate(XBlockExpression literal, IEvaluationContext context) {
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
	
	public IEvaluationResult _evaluate(XIfExpression ifExpression, IEvaluationContext context) {
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
	
	public IEvaluationResult _evaluate(XSwitchExpression switchExpression, IEvaluationContext context) {
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
					expectedType = Class.forName(typeName, false, classLoader);
				} catch (ClassNotFoundException e) {
					expectedType = Primitives.forName(typeName);
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
	
	public IEvaluationResult _evaluate(XCastedExpression castedExpression, IEvaluationContext context) {
		IEvaluationResult result = evaluate(castedExpression.getTarget(), context);
		if (result.getException() != null)
			return result;
		String typeName = castedExpression.getType().getType().getCanonicalName();
		Class<?> expectedType = null;
		try {
			expectedType = Class.forName(typeName, false, classLoader);
		} catch (ClassNotFoundException e) {
			expectedType = Primitives.forName(typeName);
			if (expectedType == null)
				return new DefaultEvaluationResult(null, e);
		}
		try {
			expectedType.cast(result.getResult());
		} catch(ClassCastException e) {
			return new DefaultEvaluationResult(null, e);
		}
		return result;
	}
	
	public IEvaluationResult _evaluate(XTryCatchFinallyExpression tryCatchFinally, IEvaluationContext context) {
		IEvaluationResult result = evaluate(tryCatchFinally.getExpression(), context);
		if (result.getException() != null) {
			for(XCatchClause catchClause: tryCatchFinally.getCatchClauses()) {
				JvmFormalParameter exception = catchClause.getDeclaredParam();
				String exceptionTypeName = exception.getParameterType().getType().getCanonicalName();
				try {
					Class<?> exceptionType = Class.forName(exceptionTypeName, false, classLoader);
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
	
	protected IEvaluationResult wrapArray(IEvaluationResult original, Object array) {
		Class<?> arrayClass = array.getClass();
		if (arrayClass.isArray()) {
			if (arrayClass.getComponentType().isPrimitive()) {
				Class<?> objectType = ReflectionUtil.getObjectType(arrayClass.getComponentType());
				int length = Array.getLength(array);
				Object[] wrapMe = (Object[]) Array.newInstance(objectType, length);
				for(int i = 0; i < length; i++) {
					wrapMe[i] = Array.get(array, i);
				}
				return new DefaultEvaluationResult(Arrays.asList(wrapMe), null);
			}
			return new DefaultEvaluationResult(Arrays.asList((Object[])array), null);
		}
		return original;
	}
	
	public IEvaluationResult _evaluate(XForLoopExpression forLoop, IEvaluationContext context) {
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
	
	public IEvaluationResult _evaluate(XWhileExpression whileLoop, IEvaluationContext context) {
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
	
	public IEvaluationResult _evaluate(XDoWhileExpression doWhileLoop, IEvaluationContext context) {
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
	
	public IEvaluationResult _evaluate(XMemberFeatureCall featureCall, IEvaluationContext context) {
		IEvaluationResult memberCallTarget = evaluate(featureCall.getMemberCallTarget(), context);
		if (memberCallTarget.getException() != null)
			return memberCallTarget;
		IEvaluationResult result = featureCallDispatcher.invoke(featureCall.getFeature(), featureCall, memberCallTarget.getResult(), context);
		return result;
	}
	
	public IEvaluationResult _evaluate(XBinaryOperation operation, IEvaluationContext context) {
		IEvaluationResult leftOperand = evaluate(operation.getLeftOperand());
		if (leftOperand.getException() != null)
			return leftOperand;
		IEvaluationResult result = featureCallDispatcher.invoke(operation.getFeature(), operation, leftOperand.getResult(), context);
		return result;
	}
	
	public IEvaluationResult _evaluate(XVariableDeclaration variableDecl, IEvaluationContext context) {
		IEvaluationResult result = evaluate(variableDecl.getRight(), context);
		if (result.getException() != null)
			return result;
		context.newValue(QualifiedName.create(variableDecl.getName()), result.getResult());
		return result;
	}
	
	public IEvaluationResult _evaluate(XFeatureCall featureCall, IEvaluationContext context) {
		return featureCallDispatcher.invoke(featureCall.getFeature(), featureCall, null, context);
	}
	
	public IEvaluationResult _featureCall(XVariableDeclaration variableDeclaration, XAbstractFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		if (receiver != null)
			throw new IllegalStateException("feature was variableDeclaration but got receiver instead of null. Receiver: " + receiver);
		Object value = context.getValue(QualifiedName.create(variableDeclaration.getName()));
		return new DefaultEvaluationResult(value, null);
	}
	
	public IEvaluationResult _featureCall(JvmFormalParameter parameter, XAbstractFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		if (receiver != null)
			throw new IllegalStateException("feature was parameter but got receiver instead of null. Receiver: " + receiver);
		Object value = context.getValue(QualifiedName.create(parameter.getName()));
		return new DefaultEvaluationResult(value, null);
	}
	
	public IEvaluationResult _featureCall(JvmOperation operation, XAbstractFeatureCall featureCall, Object receiver, IEvaluationContext context) {
		List<Object> arguments = Lists.newArrayList();
		for(XExpression arg: featureCall.getArguments().subList(1, featureCall.getArguments().size())) {
			IEvaluationResult argResult = evaluate(arg, context);
			if (argResult.getException() != null)
				return argResult;
			arguments.add(argResult.getResult());
		}
		try {
			Method method = javaReflectAccess.getMethod(operation);
			method.setAccessible(true);
			if (!Modifier.isStatic(method.getModifiers())) {
				if (receiver == null)
					return new DefaultEvaluationResult(null, new NullPointerException("Cannot invoke instance method: " + operation.getCanonicalName() + " without receiver"));
				Object result = method.invoke(receiver, arguments.toArray(new Object[arguments.size()]));
				return new DefaultEvaluationResult(result, null);
			} else {
				arguments.add(0, receiver);
				Object result = method.invoke(null, arguments.toArray(new Object[arguments.size()]));
				return new DefaultEvaluationResult(result, null);
			}
		} catch(InvocationTargetException targetException) {
			return new DefaultEvaluationResult(null, targetException.getTargetException());
		} catch(Exception e) {
			throw new IllegalStateException("Could not invoke method: " + operation.getCanonicalName() + " on instance: " + receiver, e);
		}
	}
	
	public IEvaluationResult _evaluate(XAssignment assignment, IEvaluationContext context) {
		IEvaluationResult value = evaluate(assignment.getValue(), context);
		if (value.getException() != null)
			return value;
		IEvaluationResult assignable = evaluate(assignment.getAssignable(), context);
		if (assignable.getException() != null)
			return assignable;
		IEvaluationResult assign = assignValue(assignment.getFeature(), assignable.getResult(), value.getResult(), context);
		if (assign.getException() != null)
			return assign;
		return value;
	}
	
	public IEvaluationResult assignValue(JvmIdentifyableElement feature, Object assignable, Object value, IEvaluationContext context) {
		return assignmentDispatcher.invoke(feature, assignable, value, context);
	}
	
	public IEvaluationResult _assignValue(XVariableDeclaration variable, Object assignable, Object value, IEvaluationContext context) {
		context.assignValue(QualifiedName.create(variable.getName()), value);
		return DefaultEvaluationResult.NULL;
	}
	
	public static class XbaseInterpreterSwitch extends XbaseSwitch<Void> {
		
	}
}
