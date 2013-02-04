/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XSetLiteral;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Compiler implementation that uses mainly newly introduced
 * APIs with the reimplemented type system.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
@NonNullByDefault
public class XbaseCompiler2 extends XbaseCompiler {
	
	@Inject 
	private IBatchTypeResolver batchTypeResolver;
	
	@Inject
	private CommonTypeComputationServices services;
	
	@Override
	protected void internalToConvertedExpression(XExpression obj, ITreeAppendable appendable) {
		if (obj instanceof XListLiteral) {
			_toJavaExpression((XListLiteral) obj, appendable);
		} else if (obj instanceof XSetLiteral) {
			_toJavaExpression((XSetLiteral) obj, appendable);
		} else {
			super.internalToConvertedExpression(obj, appendable);
		}
	}
	
	@Override
	protected void doInternalToJavaStatement(XExpression obj, ITreeAppendable appendable, boolean isReferenced) {
		if (obj instanceof XListLiteral) {
			_toJavaStatement((XListLiteral) obj, appendable, isReferenced);
		} else if (obj instanceof XSetLiteral) {
			_toJavaStatement((XSetLiteral) obj, appendable, isReferenced);
		} else {
			super.doInternalToJavaStatement(obj, appendable, isReferenced);
		}
	}

	protected void _toJavaStatement(XListLiteral expr, ITreeAppendable b, boolean isReferenced) {
		toCollectionBuilderJavaStatement(expr, ImmutableList.Builder.class, b, isReferenced);
	}

	protected void _toJavaStatement(XSetLiteral expr, ITreeAppendable b, boolean isReferenced) {
		toCollectionBuilderJavaStatement(expr, ImmutableSet.Builder.class, b, isReferenced);
	}

	protected void toCollectionBuilderJavaStatement(XCollectionLiteral literal, Class<?> builderClass, ITreeAppendable b,
			boolean isReferenced) {
		for(XExpression element: literal.getElements()) 
			internalToJavaStatement(element, b, true);
		if(isReferenced)
			declareSyntheticVariable(literal, b);
		LightweightTypeReference literalType = batchTypeResolver.resolveTypes(literal).getActualType(literal);
		if(literalType.isArray()) {
			if(isReferenced) 
				b.newLine().append(getVarName(literal, b)).append(" = ");
			b.append("new ");
			getTypeReferenceSerializer().serialize(literalType.toTypeReference(), literal, b);
			b.append(" { ");
			boolean isFirst = true;
			for(XExpression element: literal.getElements())  {
				if(!isFirst)
					b.append(", ");
				isFirst = false;
				internalToJavaExpression(element, b);
			}
			b.append(" };");
		} else {
			LightweightTypeReference elementType = getCollectionElementType(literal);
			String builderVar = b.declareSyntheticVariable(getCollectionLiteralBuilderKey(literal), "_builder");
			JvmType builderRawType = getTypeReferences().findDeclaredType(builderClass, literal);
			ParameterizedTypeReference builderType = new ParameterizedTypeReference(elementType.getOwner(), builderRawType);
			builderType.addTypeArgument(elementType);
			b.newLine();
			getTypeReferenceSerializer().serialize(builderType.toTypeReference(), literal, b);
			b.append(" ").append(builderVar).append(" = ");
			JvmDeclaredType listType = ((JvmDeclaredType) builderType.getType()).getDeclaringType();
			b.append(listType).append(".builder();").newLine();
			for(XExpression element: literal.getElements())  {
				b.append(builderVar).append(".add(");
				internalToJavaExpression(element, b);
				b.append(");").newLine();
			}
			if(isReferenced) 
				b.append(getVarName(literal, b)).append(" = ");
			b.append(builderVar).append(".build();");
		}
	}
	
	protected LightweightTypeReference getCollectionElementType(XCollectionLiteral literal) {
		LightweightTypeReference type = batchTypeResolver.resolveTypes(literal).getActualType(literal);
		if(type.isArray()) 
			return type.getComponentType();
		else if(type.isSubtypeOf(Collection.class) && !type.getTypeArguments().isEmpty()) 
			return type.getTypeArguments().get(0).getInvariantBoundSubstitute();
		return new ParameterizedTypeReference(type.getOwner(), getTypeReferences().findDeclaredType(Object.class, literal));
	}

	protected Object getCollectionLiteralBuilderKey(XCollectionLiteral literal) {
		return Tuples.create(literal, "_builder");
	}
	
	protected Object getCollectionLiteralLoopKey(XCollectionLiteral literal) {
		return Tuples.create(literal, "_element");
	}
	
	protected void _toJavaExpression(XCollectionLiteral expr, ITreeAppendable b) {
		b.trace(expr, false).append(getVarName(expr, b));
	}

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
							if (ref == null) {
								throw new IllegalStateException();
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
	protected void reassignThisInClosure(final ITreeAppendable b, JvmType rawClosureType) {
		boolean registerClosureAsThis = rawClosureType instanceof JvmGenericType && !((JvmGenericType) rawClosureType).isInterface();
		if (b.hasObject("this")) {
			Object element = b.getObject("this");
			if (element instanceof JvmType) {
				final String proposedName = ((JvmType) element).getSimpleName()+".this";
				if (!b.hasObject(proposedName)) {
					b.declareSyntheticVariable(element, proposedName);
					if (b.hasObject("super")) {
						Object superElement = b.getObject("super");
						if (superElement instanceof JvmType) {
							b.declareSyntheticVariable(superElement, ((JvmType) element).getSimpleName()+".super");
						}
					}
				}
			} else {
				registerClosureAsThis = false;
			}
		}
		if (registerClosureAsThis)
			b.declareVariable(rawClosureType, "this");
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