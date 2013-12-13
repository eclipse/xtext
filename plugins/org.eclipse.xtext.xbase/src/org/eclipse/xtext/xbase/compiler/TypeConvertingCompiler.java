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
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.IRawTypeHelper;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typing.Closures;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@NonNullByDefault
@SuppressWarnings("deprecation")
public class TypeConvertingCompiler extends AbstractXbaseCompiler {

	@Inject
	private Closures closures;

	@Inject
	private TypeArgumentContextProvider contextProvider;
	
	@Inject
	private IRawTypeHelper rawTypeHelper;
	
	/*
	 * TODO Do the conversion as post processing of toJavaStatement
	 * SZ: why was that todo added?
	 */

	@Override
	protected final void internalToJavaExpression(final XExpression obj, final ITreeAppendable appendable) {
		JvmTypeReference expectedType = getTypeProvider().getExpectedType(obj);
		
		internalToConvertedExpression(obj, appendable, expectedType);
	}

	@Override
	protected final void internalToConvertedExpression(final XExpression obj, ITreeAppendable appendable,
			@Nullable JvmTypeReference toBeConvertedTo) {
		if (toBeConvertedTo != null) {
			JvmTypeReference actualType = getType(obj);
			if (isPrimitiveVoid(actualType)) {
				actualType = toBeConvertedTo;
			}
			if (!EcoreUtil.equals(toBeConvertedTo, actualType)) {
				doConversion(toBeConvertedTo, actualType, appendable, obj, new Later() {
					public void exec(ITreeAppendable appendable) {
						appendable = appendable.trace(obj, true);
						internalToConvertedExpression(obj, appendable);
					}
				});
				return;
			}
			if (mustInsertTypeCast(obj, actualType)) {
				doCastConversion(actualType, appendable, obj, new Later() {
					public void exec(ITreeAppendable appendable) {
						appendable = appendable.trace(obj, true);
						internalToConvertedExpression(obj, appendable);
					}
				});
				return;
			}
		} else {
			JvmTypeReference actualType = getType(obj);
			if (obj instanceof XAbstractFeatureCall && mustInsertTypeCast(obj, actualType)){
				doCastConversion(actualType, appendable, obj, new Later() {
					public void exec(ITreeAppendable appendable) {
						appendable = appendable.trace(obj, true);
						internalToConvertedExpression(obj, appendable);
					}
				});
				return;
			}
		}
		final ITreeAppendable trace = appendable.trace(obj, true);
		internalToConvertedExpression(obj, trace);
	}

	private boolean mustInsertTypeCast(XExpression expression, JvmTypeReference actualType) {
		IResolvedTypes resolvedTypes = getTypeResolver().resolveTypes(expression);
		if (resolvedTypes.isRefinedType(expression) || resolvedTypes.getActualType(expression).isMultiType()) {
			if (expression instanceof XAbstractFeatureCall) {
				LightweightTypeReference featureType = resolvedTypes.getActualType(((XAbstractFeatureCall) expression).getFeature());
				if (featureType != null && featureType.isSubtypeOf(actualType.getType()) && !featureType.isMultiType()) {
					return false;
				}
			}
			if (expression.eContainer() instanceof XCastedExpression) {
				return false;
			}
			return true;
		}
		return false;
	}

	protected void internalToConvertedExpression(final XExpression obj, final ITreeAppendable appendable) {
		super.internalToJavaExpression(obj, appendable);
	}

	protected void doConversion(final JvmTypeReference left, final JvmTypeReference right,
			final ITreeAppendable appendable, XExpression context, final Later expression) {
		if(getPrimitives().isPrimitive(left) && !getPrimitives().isPrimitive(right)) {
			if (right instanceof JvmAnyTypeReference) {
				convertWrapperToPrimitive(left, getPrimitives().asPrimitiveIfWrapperType(left), context, appendable, expression);
			} else {
				convertWrapperToPrimitive(right, getPrimitives().asPrimitiveIfWrapperType(right), context, appendable, expression);
			}
		} else if (getPrimitives().isPrimitive(right) && !getPrimitives().isPrimitive(left)) {
			convertPrimitiveToWrapper(right, getPrimitives().asWrapperTypeIfPrimitive(right), context, appendable, expression);
		} else if (right instanceof JvmMultiTypeReference) {
			convertMultiType(left, (JvmMultiTypeReference) right, context, appendable, expression);
		} else if (right instanceof JvmDelegateTypeReference) {
			doConversion(left, ((JvmDelegateTypeReference) right).getDelegate(), appendable, context, expression);
		} else if (getTypeReferences().isArray(right) && isList(left)) {
			convertArrayToList(left, appendable, context, expression);
		} else if (isList(right) && getTypeReferences().isArray(left)) {
			convertListToArray(left, appendable, context, expression);
		} else if (isFunction(right) || (isFunction(left) && closures.findImplementingOperation(right, context.eResource()) != null)) {
			convertFunctionType(left, right, appendable, expression, context);
		} else if (isProcedure(right) || (isProcedure(left) && closures.findImplementingOperation(right, context.eResource()) != null)) {
			convertFunctionType(left, right, appendable, expression, context);
		} else if (mustInsertTypeCast(context, left)) {
			doCastConversion(left, appendable, context, expression);
		} else {
			expression.exec(appendable);
		}
	}
	
	protected void doCastConversion(final JvmTypeReference castTo, final ITreeAppendable b, XExpression context, final Later expression) {
		b.append("((");
		serialize(castTo, context, b);
		b.append(")");
		expression.exec(b);
		b.append(")");
	}
	
	protected boolean isFunction(JvmTypeReference typeReference) {
		return identifierStartWith(typeReference, Functions.class.getCanonicalName());
	}
	
	protected boolean isProcedure(JvmTypeReference typeReference) {
		return identifierStartWith(typeReference, Procedures.class.getCanonicalName());		
	}
	
	protected boolean identifierStartWith(JvmTypeReference typeReference, String prefix) {
		JvmType type = typeReference.getType();
		if (type == null)
			return false;
		String identifier = type.getIdentifier();
		if (identifier != null)
			return identifier.startsWith(prefix);
		return false;
	}

	protected void convertMultiType(JvmTypeReference expectation, JvmMultiTypeReference multiType, XExpression context,
			ITreeAppendable b, Later expression) {
		JvmTypeReference castTo = null;
		for(JvmTypeReference candidate: multiType.getReferences()) {
			if (getTypeConformanceComputer().isConformant(expectation, candidate, true)) {
				castTo = candidate;
				break;
			}
		}
		if (castTo != null && mustInsertTypeCast(context, castTo)) {
			b.append("((");
			serialize(castTo, context, b, true, false);
			b.append(")");
			expression.exec(b);
			b.append(")");
		} else {
			expression.exec(b);
		}
	}

	protected void convertFunctionType(final JvmTypeReference expectedType, final JvmTypeReference functionType,
			final ITreeAppendable appendable, final Later expression, XExpression context) {
//		JvmTypeReference resolvedLeft = closures.getResolvedExpectedType(expectedType, functionType);
		if (expectedType.getIdentifier().equals(Object.class.getName())
				|| EcoreUtil.equals(expectedType.getType(), functionType.getType())
				|| ((expectedType instanceof JvmSynonymTypeReference) 
					&& Iterables.any(((JvmSynonymTypeReference)expectedType).getReferences(), new Predicate<JvmTypeReference>() {
						public boolean apply(@Nullable JvmTypeReference ref) {
							if (ref == null) {
								throw new IllegalArgumentException();
							}
							return EcoreUtil.equals(ref.getType(), functionType.getType());
						}
					}))) {
			// same raw type but different type parameters
			// at this point we know that we are compatible so we have to convince the Java compiler about that ;-)
			if (!getTypeConformanceComputer().isConformant(expectedType, functionType)) {
				// insert a cast
				appendable.append("(");
				serialize(expectedType, context, appendable);
				appendable.append(")");
			}
			expression.exec(appendable);
			return;
		}
		JvmOperation operation = closures.findImplementingOperation(expectedType, context.eResource());
		if (operation == null) {
			throw new IllegalStateException("expected type " + expectedType + " not mappable from " + functionType);
		}
		JvmType declaringType = (expectedType instanceof JvmParameterizedTypeReference) ? expectedType.getType() : operation.getDeclaringType();
		final JvmTypeReference typeReferenceWithPlaceHolder = getTypeReferences().createTypeRef(declaringType);
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
		serialize(resolvedExpectedType, context, appendable, true, false);
		appendable.append("() {");
		appendable.increaseIndentation().increaseIndentation();
		appendable.newLine().append("public ");
		serialize(typeArgumentContext.resolve(operation.getReturnType()), context, appendable, true, false);
		appendable.append(" ").append(operation.getSimpleName()).append("(");
		EList<JvmFormalParameter> params = operation.getParameters();
		for (Iterator<JvmFormalParameter> iterator = params.iterator(); iterator.hasNext();) {
			JvmFormalParameter p = iterator.next();
			final String name = p.getName();
			serialize(typeArgumentContext.resolve(p.getParameterType()), context, appendable, false, false);
			appendable.append(" ").append(name);
			if (iterator.hasNext())
				appendable.append(",");
		}
		appendable.append(") {");
		appendable.increaseIndentation();
		if (!getTypeReferences().is(operation.getReturnType(), Void.TYPE))
			appendable.newLine().append("return ");
		else
			appendable.newLine();
		expression.exec(appendable);
		appendable.append(".");
		JvmOperation actualOperation = closures.findImplementingOperation(functionType, context.eResource());
		appendable.append(actualOperation.getSimpleName());
		appendable.append("(");
		for (Iterator<JvmFormalParameter> iterator = params.iterator(); iterator.hasNext();) {
			JvmFormalParameter p = iterator.next();
			final String name = p.getName();
			appendable.append(name);
			if (iterator.hasNext())
				appendable.append(",");
		}
		appendable.append(");");
		appendable.decreaseIndentation();
		appendable.newLine().append("}");
		appendable.decreaseIndentation().decreaseIndentation();
		appendable.newLine().append("}");
	}

	protected void convertListToArray(
			final JvmTypeReference arrayTypeReference, 
			final ITreeAppendable appendable,
			XExpression context,
			final Later expression) {
		appendable.append("((");
		serialize(arrayTypeReference, context, appendable);
		appendable.append(")");
		JvmTypeReference conversions = getTypeReferences().getTypeForName(Conversions.class, context);
		serialize(conversions, context, appendable);
		appendable.append(".unwrapArray(");
		expression.exec(appendable);
		JvmGenericArrayTypeReference rawTypeArrayReference = (JvmGenericArrayTypeReference) rawTypeHelper.getRawTypeReference(arrayTypeReference, context.eResource());
		appendable.append(", ");
		serialize(rawTypeArrayReference.getComponentType(), context, appendable);
		appendable.append(".class))");
	}

	protected void convertArrayToList(final JvmTypeReference left, final ITreeAppendable appendable, XExpression context,
			final Later expression) {
		appendable.append("((");
		serialize(left, context, appendable);
		appendable.append(")");
		JvmTypeReference conversions = getTypeReferences().getTypeForName(Conversions.class, context);
		serialize(conversions, context, appendable);
		appendable.append(".doWrapArray(");
		expression.exec(appendable);
		appendable.append("))");
	}

	/**
	 * @param primitive unused in this context but useful for inheritors 
	 */
	protected void convertPrimitiveToWrapper(
			final JvmTypeReference primitive, 
			final JvmTypeReference wrapper, 
			XExpression context, 
			final ITreeAppendable appendable,
			final Later expression) {
		serialize(wrapper, context, appendable);
		appendable.append(".");
		appendable.append("valueOf(");
		expression.exec(appendable);
		appendable.append(")");
	}

	/**
	 * @param wrapper unused in this context but useful for inheritors 
	 */
	protected void convertWrapperToPrimitive(
			final JvmTypeReference wrapper, 
			final JvmTypeReference primitive, 
			XExpression context, 
			final ITreeAppendable appendable,
			final Later expression) {
		appendable.append("(");
		expression.exec(appendable);
		appendable.append(")");
		appendable.append(".");
		serialize(primitive, context, appendable);
		appendable.append("Value(");
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
