/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.IRawTypeHelper;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.typing.Closures;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeConvertingCompiler extends AbstractXbaseCompiler {

	@Inject
	private Closures closures;

	@Inject
	private TypeArgumentContextProvider contextProvider;
	
	@Inject
	private IRawTypeHelper rawTypeHelper;
	
	/*
	 * TODO Do the conversion as post processing of toJavaStatement
	 */

	@Override
	protected void internalToJavaExpression(final XExpression obj, final IAppendable appendable) {
		JvmTypeReference expectedType = getTypeProvider().getExpectedType(obj);
		internalToConvertedExpression(obj, appendable, expectedType);
	}
	
	@Override
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
		if (getPrimitives().isPrimitive(right) && !getPrimitives().isPrimitive(left)) {
			convertPrimitiveToWrapper(getPrimitives().asWrapperTypeIfPrimitive(right), context, appendable, expression);
		} else if (right instanceof JvmMultiTypeReference) {
			convertMultiType(left, (JvmMultiTypeReference) right, context, appendable, expression);
		} else if (right instanceof JvmDelegateTypeReference) {
			doConversion(left, ((JvmDelegateTypeReference) right).getDelegate(), appendable, context, expression);
		} else if (getTypeReferences().isArray(right) && isList(left)) {
			convertArrayToList(left, appendable, context, expression);
		} else if (isList(right) && getTypeReferences().isArray(left)) {
			convertListToArray(left, appendable, context, expression);
		} else if (isFunction(right)) {
			convertFunctionType(left, right, appendable, expression, context);
		} else if (isProcedure(right)) {
			convertFunctionType(left, right, appendable, expression, context);
		} else {
			expression.exec();
		}
	}
	
	protected boolean isFunction(JvmTypeReference typeReference) {
		return identifierStartWith(typeReference, Functions.class.getCanonicalName());
	}
	
	protected boolean isProcedure(JvmTypeReference typeReference) {
		return identifierStartWith(typeReference, Procedures.class.getCanonicalName());		
	}
	
	protected boolean identifierStartWith(JvmTypeReference typeReference, String prefix) {
		if (typeReference == null || typeReference.getType() == null)
			return false;
		String identifier = typeReference.getType().getIdentifier();
		if (identifier != null)
			return identifier.startsWith(prefix);
		return false;
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
			final IAppendable appendable, final Later expression, XExpression context) {
//		JvmTypeReference resolvedLeft = closures.getResolvedExpectedType(expectedType, functionType);
		if (expectedType == null || expectedType.getIdentifier().equals(Object.class.getName())
				|| EcoreUtil.equals(expectedType.getType(), functionType.getType())) {
			expression.exec();
			return;
		}
		JvmOperation operation = closures.findImplementingOperation(expectedType, context.eResource());
		if (operation == null) {
			throw new IllegalStateException("expected type " + expectedType + " not mappable from " + functionType);
		}
		JvmDeclaredType declaringType = operation.getDeclaringType();
		final JvmParameterizedTypeReference typeReferenceWithPlaceHolder = getTypeReferences().createTypeRef(declaringType);
		ITypeArgumentContext typeArgumentContext = contextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.AbstractRequest() {
					@Override
					public JvmTypeReference getExpectedType() {
						return functionType;
					}
					@Override
					public JvmTypeReference getDeclaredType() {
						return typeReferenceWithPlaceHolder;
					}
					@Override
					public String toString() {
						return "TypeConvertingCompiler.convertFunctionType [expected=" + functionType + ",declared="
								+ typeReferenceWithPlaceHolder + "]";
					}
				});
		JvmTypeReference resolvedExpectedType = typeArgumentContext.resolve(typeReferenceWithPlaceHolder); 
		appendable.append("new ");
		serialize(resolvedExpectedType, null, appendable, true, false);
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
		if (!getTypeReferences().is(operation.getReturnType(), Void.TYPE))
			appendable.append("\nreturn ");
		else
			appendable.append("\n");
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

	protected void convertListToArray(
			final JvmTypeReference arrayTypeReference, 
			final IAppendable appendable,
			XExpression context,
			final Later expression) {
		appendable.append("((");
		serialize(arrayTypeReference, context, appendable);
		appendable.append(")");
		JvmTypeReference conversions = getTypeReferences().getTypeForName(Conversions.class, context);
		serialize(conversions, context, appendable);
		appendable.append(".unwrapArray(");
		expression.exec();
		JvmGenericArrayTypeReference rawTypeArrayReference = (JvmGenericArrayTypeReference) rawTypeHelper.getRawTypeReference(arrayTypeReference, context.eResource());
		appendable.append(", ");
		serialize(rawTypeArrayReference.getComponentType(), context, appendable);
		appendable.append(".class))");
	}

	protected void convertArrayToList(final JvmTypeReference left, final IAppendable appendable, XExpression context,
			final Later expression) {
		appendable.append("((");
		serialize(left, context, appendable);
		appendable.append(")");
		JvmTypeReference conversions = getTypeReferences().getTypeForName(Conversions.class, context);
		serialize(conversions, context, appendable);
		appendable.append(".doWrapArray(");
		expression.exec();
		appendable.append("))");
	}

	protected void convertPrimitiveToWrapper(
			final JvmTypeReference wrapper, 
			XExpression context, 
			final IAppendable appendable,
			final Later expression) {
		appendable.append("((");
		serialize(wrapper, null, appendable);
		appendable.append(")");
		expression.exec();
		appendable.append(")");
	}

	//TODO externalize whole conversion strategy and use org.eclipse.xtext.xbase.typing.SynonymTypesProvider.isList(JvmTypeReference)
	protected boolean isList(JvmTypeReference type) {
		TypeReferences typeRefs = getTypeReferences();
		return typeRefs.isInstanceOf(type, Iterable.class);
	}
	
	protected TypeArgumentContextProvider getContextProvider() {
		return contextProvider;
	}
	
}
