/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter.impl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.access.impl.Primitives;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.ReflectionUtil;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XIntLiteral;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.util.XbaseSwitch;

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
		return PolymorphicDispatcher.createForSingleTarget("_featureCall", 3, 3, this);
	}
	
	public IEvaluationResult evaluate(XExpression expression) {
		IEvaluationResult result = evaluate(expression, contextProvider.get());
		result = wrapArray(result);
		return result;
	}

	public IEvaluationResult evaluate(XExpression expression, IEvaluationContext context) {
		return evaluateDispatcher.invoke(expression, context);
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
			Object[] wrapMe = (Object[])array;
			if (arrayClass.getComponentType().isPrimitive()) {
				Class<?> objectType = ReflectionUtil.getObjectType(arrayClass.getComponentType());
				int length = Array.getLength(array);
				wrapMe = (Object[]) Array.newInstance(objectType, length);
				for(int i = 0; i < length; i++) {
					wrapMe[i] = Array.get(array, i);
				}
			}
			return new DefaultEvaluationResult(Arrays.asList(wrapMe), null);
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
		String paramName = forLoop.getDeclaredParam().getName();
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
	
	public IEvaluationResult _evaluate(XVariableDeclaration variableDecl, IEvaluationContext context) {
		IEvaluationResult result = evaluate(variableDecl.getRight(), context);
		if (result.getException() != null)
			return result;
		context.newValue(variableDecl.getName(), result.getResult());
		return result;
	}
	
	public IEvaluationResult _evaluate(XFeatureCall featureCall, IEvaluationContext context) {
		return featureCallDispatcher.invoke(featureCall.getFeature(), featureCall, context);
	}
	
	public IEvaluationResult _featureCall(XVariableDeclaration variableDeclaration, XFeatureCall featureCall, IEvaluationContext context) {
		Object value = context.getValue(variableDeclaration.getName());
		return new DefaultEvaluationResult(value, null);
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
		context.assignValue(variable.getName(), value);
		return DefaultEvaluationResult.NULL;
	}
	
	public static class XbaseInterpreterSwitch extends XbaseSwitch<Void> {
		
	}
}
