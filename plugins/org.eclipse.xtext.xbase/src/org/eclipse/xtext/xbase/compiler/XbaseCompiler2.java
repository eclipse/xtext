/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Compiler implementation that uses mainly newly introduced
 * APIs with the reimplemented type system.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class XbaseCompiler2 extends XbaseCompiler {
	
	@Inject 
	private IBatchTypeResolver batchTypeResolver;
	
	@Inject
	private CommonTypeComputationServices services;
	
	@Override
	protected List<XExpression> getActualArguments(XAbstractFeatureCall featureCall) {
		return featureCall.getActualArguments();
	}
	@Nullable
	@Override
	protected XExpression getActualReceiver(XAbstractFeatureCall featureCall) {
		return featureCall.getActualReceiver();
	}
	@Override
	protected boolean isMemberCall(XAbstractFeatureCall call) {
		return !call.isStatic();
	}
	
	@Override
	protected ITreeAppendable appendTypeArguments(XAbstractFeatureCall call, ITreeAppendable original) {
		if (!call.getTypeArguments().isEmpty()) {
			return super.appendTypeArguments(call, original);
		}
		ILocationData completeLocationData = getLocationWithTypeArguments(call);
		ITreeAppendable completeFeatureCallAppendable = completeLocationData != null ? original.trace(completeLocationData) : original;
		IResolvedTypes resolvedTypes = batchTypeResolver.resolveTypes(call);
		List<LightweightTypeReference> typeArguments = resolvedTypes.getActualTypeArguments(call);
		if (!typeArguments.isEmpty()) {
			List<JvmTypeReference> resolvedTypeArguments = Lists.newArrayListWithCapacity(typeArguments.size());
			for(LightweightTypeReference typeArgument: typeArguments) {
				if (typeArgument.isWildcard()) {
					return completeFeatureCallAppendable;
				}
				JvmTypeReference jvmTypeReference = typeArgument.toJavaCompliantTypeReference();
				resolvedTypeArguments.add(jvmTypeReference);
			}
			completeFeatureCallAppendable.append("<");
			for (int i = 0; i < resolvedTypeArguments.size(); i++) {
				if (i != 0) {
					completeFeatureCallAppendable.append(", ");
				}
				JvmTypeReference typeArgument = resolvedTypeArguments.get(i);
				serialize(typeArgument, call, completeFeatureCallAppendable);
			}
			completeFeatureCallAppendable.append(">");
		}
		return completeFeatureCallAppendable;
	}
	
	/*
	 * Pretty much a copy of the super impl but without the type argument context geraffel.
	 */
	@Override
	protected void convertFunctionType(JvmTypeReference expectedType, final JvmTypeReference functionType,
			ITreeAppendable appendable, Later expression, XExpression context) {
		if (expectedType.getIdentifier().equals(Object.class.getName())
				|| EcoreUtil.equals(expectedType.getType(), functionType.getType())
				|| ((expectedType instanceof JvmSynonymTypeReference) 
					&& Iterables.any(((JvmSynonymTypeReference)expectedType).getReferences(), new Predicate<JvmTypeReference>() {
						public boolean apply(@Nullable JvmTypeReference ref) {
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
		JvmOperation operation = getClosures().findImplementingOperation(expectedType, context.eResource());
		if (operation == null) {
			throw new IllegalStateException("expected type " + expectedType + " not mappable from " + functionType);
		}
		appendable.append("new ");
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, context.eResource().getResourceSet());
		LightweightTypeReference lightweightExpectedType = new OwnedConverter(owner).toLightweightReference(expectedType);
		FunctionTypeReference functionTypeReference = lightweightExpectedType.tryConvertToFunctionTypeReference(false);
		if (functionTypeReference == null)
			throw new IllegalStateException("Expected type does not seem to be a SAM type");
		JvmTypeReference convertedExpectedType = functionTypeReference.toInstanceTypeReference().toTypeReference();
		serialize(convertedExpectedType, context, appendable, false, false);
		appendable.append("() {");
		appendable.increaseIndentation().increaseIndentation();
		appendable.newLine().append("public ");
		LightweightTypeReference returnType = functionTypeReference.getReturnType();
		if (returnType == null)
			throw new IllegalStateException("Could not find return type");
		serialize(returnType.toTypeReference(), context, appendable, false, false);
		appendable.append(" ").append(operation.getSimpleName()).append("(");
		List<JvmFormalParameter> params = operation.getParameters();
		for (int i = 0; i < params.size(); i++) {
			if (i != 0)
				appendable.append(",");
			JvmFormalParameter p = params.get(i);
			final String name = p.getName();
			serialize(functionTypeReference.getParameterTypes().get(i).toTypeReference(), context, appendable, false, false);
			appendable.append(" ").append(name);
		}
		appendable.append(") {");
		appendable.increaseIndentation();
		if (!getTypeReferences().is(operation.getReturnType(), Void.TYPE))
			appendable.newLine().append("return ");
		else
			appendable.newLine();
		expression.exec(appendable);
		appendable.append(".");
		JvmOperation actualOperation = getClosures().findImplementingOperation(functionType, context.eResource());
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
	
	@Override
	protected JvmTypeReference getClosureOperationParameterType(JvmTypeReference closureType, ITypeArgumentContext context,
			JvmOperation operation, int i) {
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, operation.eResource().getResourceSet());
		OwnedConverter converter = new OwnedConverter(owner);
		LightweightTypeReference lightweightTypeReference = converter.toLightweightReference(closureType);
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(lightweightTypeReference);
		LightweightTypeReference parameterType = converter.toLightweightReference(operation.getParameters().get(i).getParameterType());
		return new StandardTypeParameterSubstitutor(mapping, owner).substitute(parameterType).toJavaCompliantTypeReference();
	}

	@Override
	protected JvmTypeReference getClosureOperationReturnType(JvmTypeReference closureType, ITypeArgumentContext context, JvmOperation operation) {
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, operation.eResource().getResourceSet());
		OwnedConverter converter = new OwnedConverter(owner);
		LightweightTypeReference lightweightTypeReference = converter.toLightweightReference(closureType);
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(lightweightTypeReference);
		LightweightTypeReference parameterType = converter.toLightweightReference(operation.getReturnType());
		return new StandardTypeParameterSubstitutor(mapping, owner).substitute(parameterType).toJavaCompliantTypeReference();
	}
	
	@Override
	protected JvmOperation findImplementingOperation(JvmTypeReference closureType, EObject context) {
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, context);
		OwnedConverter converter = new OwnedConverter(owner);
		LightweightTypeReference lightweightTypeReference = converter.toLightweightReference(closureType);
		return services.getFunctionTypes().findImplementingOperation(lightweightTypeReference);
	}
	
	@Override
	protected JvmTypeReference getTypeForVariableDeclaration(XExpression expr) {
		JvmTypeReference type = getTypeProvider().getType(expr);
		//TODO we need to replace any occurrence of JvmAnyTypeReference with a better match from the expected type
		if (type instanceof JvmAnyTypeReference) {
			JvmTypeReference expectedType = getTypeProvider().getExpectedType(expr);
			if (expectedType == null) {
				expectedType = getTypeProvider().getExpectedReturnType(expr, false);
			}
			if (expectedType!=null && !(expectedType.getType() instanceof JvmTypeParameter))
				type = expectedType;
		}
		return type;
	}
	
	@Override
	protected JvmTypeReference getForLoopParameterType(XForLoopExpression expr) {
		JvmTypeReference declaredType = expr.getDeclaredParam().getParameterType();
		if (declaredType != null) {
			return declaredType;
		}
		return super.getForLoopParameterType(expr);
	}
	
}