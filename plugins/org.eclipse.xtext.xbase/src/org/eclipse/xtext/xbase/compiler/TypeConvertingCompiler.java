/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.typing.FunctionConversion;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeConvertingCompiler extends AbstractXbaseCompiler {

	@Inject
	private FunctionConversion funcConversion;

	@Inject
	private TypeArgumentContextProvider contextProvider;
	
	@Inject
	private TypeReferences typeRefs;
	
	@Inject
	private Primitives primitives;
	
	/*
	 * TODO
	 * Do the conversion as post processing of toJavaStatement
	 */

	@Override
	protected void internalToJavaExpression(final XExpression obj, final IAppendable appendable) {
		JvmTypeReference expectedType = getTypeProvider().getExpectedType(obj);
		internalToConvertedExpression(obj, appendable, expectedType);
	}
	
	protected void internalToConvertedExpression(final XExpression obj, final IAppendable appendable,
			JvmTypeReference toBeConvertedTo) {
		if (toBeConvertedTo != null) {
			JvmTypeReference actualType = getTypeProvider().getType(obj);
			if (!EcoreUtil.equals(toBeConvertedTo, actualType)) {
				doConversion(toBeConvertedTo, actualType, appendable, obj, new Later() {
					@Override
					public void exec() {
						String finalVariable = appendable.getName(Tuples.create("Convertable", obj));
						if (finalVariable != null)
							appendable.append(finalVariable);
						else
							TypeConvertingCompiler.super.internalToJavaExpression(obj, appendable);
					}
				});
				return;
			}
		}
		super.internalToJavaExpression(obj, appendable);
	}

	protected void doConversion(final JvmTypeReference left, final JvmTypeReference right,
			final IAppendable appendable, XExpression context, final Later expression) {
		if (primitives.isPrimitive(right) && !primitives.isPrimitive(left)) {
			convertPrimitiveToWrapper(left, appendable, expression);
		} else if (right instanceof JvmMultiTypeReference) {
			convertMultiType(left, (JvmMultiTypeReference) right, context, appendable, expression);
		} else if (typeRefs.isArray(right) && isList(left)) {
			convertArrayToList(left, appendable, context, expression);
		} else if (isList(right) && typeRefs.isArray(left)) {
			convertListToArray(left, appendable, context, expression);
		} else if (right.getType().getIdentifier().startsWith(Functions.class.getCanonicalName())) {
			convertFunctionType(left, right, appendable, expression);
		} else {
			expression.exec();
		}
	}

	protected void convertMultiType(JvmTypeReference expectation, JvmMultiTypeReference multiType, XExpression context,
			IAppendable b, Later expression) {
		JvmTypeReference castTo = null;
		for(JvmTypeReference candidate: multiType.getReferences()) {
			if (getTypeConformanceComputer().isConformant(expectation, candidate, true)) {
				castTo = candidate;
				break;
			}
		}
		if (castTo != null) {
			b.append("((");
			serialize(castTo, context, b, true, false);
			b.append(")");
		}
		expression.exec();
		if (castTo != null) {
			b.append(")");
		}
	}

	protected void convertFunctionType(final JvmTypeReference expectedType, final JvmTypeReference functionType,
			final IAppendable appendable, final Later expression) {
		JvmTypeReference resolvedLeft = funcConversion.getResolvedExpectedType(expectedType, functionType);
		if (resolvedLeft == null || resolvedLeft.getIdentifier().equals(Object.class.getName())
				|| EcoreUtil.equals(resolvedLeft.getType(), functionType.getType())) {
			expression.exec();
			return;
		}
		JvmOperation operation = funcConversion.findSingleMethod(expectedType);
		if (operation == null) {
			throw new IllegalStateException("expected type " + resolvedLeft + " not mappable from " + functionType);
		}
		TypeArgumentContext typeArgumentContext = contextProvider.getReceiverContext(resolvedLeft);
		appendable.append("new ");
		serialize(resolvedLeft, null, appendable, true, false);
		appendable.append("() {");
		appendable.increaseIndentation().increaseIndentation();
		appendable.append("\npublic ");
		serialize(typeArgumentContext.resolve(operation.getReturnType()), null, appendable, true, false);
		appendable.append(" ").append(operation.getSimpleName()).append("(");
		EList<JvmFormalParameter> params = operation.getParameters();
		for (Iterator<JvmFormalParameter> iterator = params.iterator(); iterator.hasNext();) {
			JvmFormalParameter p = iterator.next();
			final String name = p.getName();
			serialize(typeArgumentContext.resolve(p.getParameterType()), null, appendable, true, false);
			appendable.append(" ").append(name);
			if (iterator.hasNext())
				appendable.append(",");
		}
		appendable.append(") {");
		appendable.increaseIndentation();
		appendable.append("\nreturn ");
		expression.exec();
		appendable.append(".apply(");
		for (Iterator<JvmFormalParameter> iterator = params.iterator(); iterator.hasNext();) {
			JvmFormalParameter p = iterator.next();
			final String name = p.getName();
			appendable.append(name);
			if (iterator.hasNext())
				appendable.append(",");
		}
		appendable.append(");");
		appendable.decreaseIndentation();
		appendable.append("\n}");
		appendable.decreaseIndentation().decreaseIndentation();
		appendable.append("\n}");
	}

	protected void convertListToArray(final JvmTypeReference listType, final IAppendable appendable,
			XExpression context, final Later expression) {
		appendable.append("((");
		appendable.append(listType);
		appendable.append(")");
		JvmTypeReference conversions = typeRefs.getTypeForName(Conversions.class, context);
		appendable.append(conversions).append(".unwrapArray(");
		expression.exec();
		appendable.append("))");
	}

	protected void convertArrayToList(final JvmTypeReference left, final IAppendable appendable, XExpression context,
			final Later expression) {
		appendable.append("((");
		appendable.append(left);
		appendable.append(")");
		JvmTypeReference conversions = typeRefs.getTypeForName(Conversions.class, context);
		appendable.append(conversions).append(".doWrapArray(");
		expression.exec();
		appendable.append("))");
	}

	protected void convertPrimitiveToWrapper(final JvmTypeReference wrapper, final IAppendable appendable,
			final Later expression) {
		appendable.append("((");
		serialize(wrapper, null, appendable, false, false);
		appendable.append(")");
		expression.exec();
		appendable.append(")");
	}

	//TODO externalize whole conversion strategy and use org.eclipse.xtext.xbase.typing.SynonymTypesProvider.isList(JvmTypeReference)
	protected boolean isList(JvmTypeReference type) {
		return typeRefs.is(type, List.class) || typeRefs.is(type, Iterable.class) || typeRefs.is(type, Collection.class);
	}
	
	protected TypeArgumentContextProvider getContextProvider() {
		return contextProvider;
	}
	
	public Primitives getPrimitives() {
		return primitives;
	}
}
