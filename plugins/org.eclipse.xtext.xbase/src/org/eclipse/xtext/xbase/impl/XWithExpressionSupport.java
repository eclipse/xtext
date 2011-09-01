/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.impl;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XWithExpression;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.interpreter.IEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.impl.EvaluationException;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XWithExpressionSupport {
	
	@Inject
	private ITypeProvider typeProvider;
	
	@Inject
	private TypeReferenceSerializer referenceSerializer;
	
	@Inject
	private JavaReflectAccess javaReflectAccess;

	public void prepareMainExpressionAsJavaStatement(XWithExpression expr, IAppendable b, XbaseCompiler xbaseCompiler) {
		if (expr.getMainExpression() != null) {
			xbaseCompiler.toJavaStatement(expr.getMainExpression(), b, true);
		}
	}
	
	public void mainExpressionAsJavaExpression(XWithExpression expr, IAppendable b, XbaseCompiler xbaseCompiler) {
		if (expr.getMainExpression() != null) {
			xbaseCompiler.toJavaExpression(expr.getMainExpression(), b);
		} else {
			JvmTypeReference type = typeProvider.getExpectedType(expr);
			b.append("new ");
			referenceSerializer.serialize(type, expr, b, false, false, true , false);
			b.append("()");
		}
	}
	
	public boolean isConstructionInferrable(XWithExpression expr, JvmTypeReference expectedType) {
		if (expr.getMainExpression() != null) {
			return true;
		}
		if (expectedType.getType() instanceof JvmGenericType) {
			JvmGenericType gtype = (JvmGenericType) expectedType.getType();
			if (gtype.isAbstract() || gtype.isInterface())
				return false;
			boolean hasDefault = true;
			for (JvmConstructor con : gtype.getDeclaredConstructors()) {
				if (con.getParameters().isEmpty())
					return true;
				else 
					hasDefault = false;
			}
			return hasDefault;
		}
		return false;
	}

	public Object evaluateMainExpression(XWithExpression expr, IEvaluationContext context, CancelIndicator indicator,
			XbaseInterpreter xbaseInterpreter) {
		if (expr.getMainExpression() != null) {
			final IEvaluationResult evaluate = xbaseInterpreter.evaluate(expr.getMainExpression(), context, indicator);
			if (evaluate.getException() != null)
				throw new EvaluationException(evaluate.getException());
			else 
				return evaluate.getResult();
		} else {
			JvmTypeReference type = typeProvider.getExpectedType(expr);
			Class<?> class1 = javaReflectAccess.getRawType(type.getType());
			try {
				return class1.newInstance();
			} catch (Exception e) {
				throw new EvaluationException(e);
			}
		}
	}
}
