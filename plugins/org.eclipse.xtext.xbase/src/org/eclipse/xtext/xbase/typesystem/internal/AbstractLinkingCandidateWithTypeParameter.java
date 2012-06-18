/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.util.AbstractReentrantTypeReferenceProvider;
import org.eclipse.xtext.xbase.typesystem.util.ActualTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameter;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterAwareTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameters;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO Javadoc
 */
public abstract class AbstractLinkingCandidateWithTypeParameter<LinkingCandidate extends ILinkingCandidate<LinkingCandidate>> 
		extends AbstractLinkingCandidate<LinkingCandidate> implements ObservableTypeExpectation.Observer { 
	
	protected class LazyExpectation extends AbstractReentrantTypeReferenceProvider {
		private final JvmTypeReference declaredType;
		private final UnboundTypeParameterPreservingSubstitutor substitutor;
		private JvmTypeReference substitute;

		protected LazyExpectation(JvmTypeReference declaredType) {
			this.declaredType = declaredType;
			substitutor = new UnboundTypeParameterPreservingSubstitutor(getDeclaratorParameterMapping(), getState().getServices());
			substitutor.enhanceMapping(getFeatureTypeParameterMapping());
		}

		@Override
		protected JvmTypeReference doGetTypeReference() {
			if (substitute != null)
				return substitute;
			substitute = substitutor.substitute(declaredType);
			return substitute;
		}
	}

	private Map<JvmTypeParameter, MergedBoundTypeArgument> featureTypeParameterMapping;
	
	protected AbstractLinkingCandidateWithTypeParameter(XExpression expression, IEObjectDescription description,
			ExpressionTypeComputationState state) {
		super(expression, description, state);
		this.typeParameterMapping = Multimaps2.newLinkedHashListMultimap(2, 3);
	}

	public void accept(ObservableTypeExpectation expectation, JvmTypeReference actual, ConformanceHint conformanceHint) {
		// TODO traverse the expectation and read the actual parameter data from the actual mapping by means of a type parameter substitutor
		JvmTypeReference expectedType = expectation.getExpectedType();
		if (expectedType == null || actual instanceof JvmAnyTypeReference) {
			return;
		}
		JvmTypeReference expectedType = expectation.getExpectedType();
		if (expectedType instanceof XComputedTypeReference) {
			XComputedTypeReference computedTypeReference = (XComputedTypeReference) expectedType;
			if (UnboundTypeParameters.isUnboundTypeParameter(computedTypeReference)) {
				UnboundTypeParameter unboundTypeParameter = (UnboundTypeParameter) computedTypeReference.getTypeProvider();
				if (!UnboundTypeParameters.isUnboundAndEqual(unboundTypeParameter, actual)) {
					JvmTypeReference wrappedActual = asWrapperType(actual);
					unboundTypeParameter.acceptHint(wrappedActual, BoundTypeArgumentSource.INFERRED, this, VarianceInfo.OUT, VarianceInfo.OUT);
				}
			}
		} else if (expectedType.getType() instanceof JvmTypeParameter) {
			JvmTypeReference wrappedActual = asWrapperType(actual);
			typeParameterMapping.put((JvmTypeParameter) expectedType.getType(), new BoundTypeArgument(wrappedActual, BoundTypeArgumentSource.INFERRED, new Object(), VarianceInfo.OUT, VarianceInfo.OUT));
		} else {
			resolveAgainstActualType(expectedType, actual);
		}
	}
	
	@Override
	public List<JvmTypeParameter> getDeclaredTypeParameters() {
		JvmIdentifiableElement feature = getFeature();
		if (feature instanceof JvmTypeParameterDeclarator) {
			return ((JvmTypeParameterDeclarator) feature).getTypeParameters();
		}
		return Collections.emptyList();
	}
	
	@Override
	public void apply() {
		JvmIdentifiableElement feature = getFeature();
		JvmTypeReference featureType = getDeclaredType(feature);
		computeArgumentTypes(feature /*, featureType */);
		for(StackedResolvedTypes pending: stackedResolvedTypes) {
			pending.mergeIntoParent();
		}
		List<ITypeExpectation> expectations = getState().getImmediateExpectations();
		for(ITypeExpectation expectation: expectations) {
			// TODO implement bounds / type parameter resolution
			// TODO consider expectation if any
			Map<JvmTypeParameter, MergedBoundTypeArgument> declaratorParameterMapping = getDeclaratorParameterMapping();
			TypeParameterSubstitutor substitutor = new TypeParameterByConstraintSubstitutor(declaratorParameterMapping, getState().getServices()) {
				
				@Override
				public JvmTypeReference doVisitComputedTypeReference(XComputedTypeReference reference,
						Set<JvmTypeParameter> param) {
					if (UnboundTypeParameters.isUnboundTypeParameter(reference)) {
						XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
						result.setTypeProvider(reference.getTypeProvider());
						return result;
					}
					return super.doVisitComputedTypeReference(reference, param);
				}
				
				@Override
				protected JvmTypeReference getUnmappedSubstitute(JvmParameterizedTypeReference reference, JvmTypeParameter type, Set<JvmTypeParameter> visiting) {
					XComputedTypeReference result = getServices().getXtypeFactory().createXComputedTypeReference();
					UnboundTypeParameter unboundTypeParameter = getState().getResolvedTypes().createUnboundTypeParameter(getExpression(), type);
					result.setTypeProvider(unboundTypeParameter);
					return result;
				}
				
			};
			JvmTypeReference expectedType = expectation.getExpectedType();
			substitutor.enhanceMapping(getFeatureTypeParameterMapping());
			// TODO enhance with expectation
			JvmTypeReference substitutedFeatureType = substitutor.substitute(featureType);
			deferredBindTypeArguments(expectedType, substitutedFeatureType);
			expectation.acceptActualType(substitutedFeatureType, ConformanceHint.UNCHECKED);
		}
		getState().getResolvedTypes().mergeIntoParent();
	}

	@Override
	public void computeArgumentTypes(JvmIdentifiableElement feature /* JvmTypeReference featureType */) {
		if (stackedResolvedTypes != null)
			return;
		int declaredParameterCount = 0;
		int fixedArityParameterCount = 0;
		List<JvmFormalParameter> parameters = null;
		boolean varArgs = false;
		if (feature instanceof JvmExecutable) {
			JvmExecutable executable = (JvmExecutable) feature;
			declaredParameterCount = executable.getParameters().size();
			varArgs = executable.isVarArgs();
			fixedArityParameterCount = varArgs ? declaredParameterCount - 1 : declaredParameterCount;
			parameters = executable.getParameters();
		}
		List<XExpression> arguments = getArguments();
		int fixedArityArgumentCount = Math.min(fixedArityParameterCount, arguments.size());
		stackedResolvedTypes = Lists.newArrayListWithCapacity(arguments.size());
		if (parameters != null) {
			for(int i = 0; i < fixedArityArgumentCount; i++) {
				final JvmFormalParameter parameter = parameters.get(i);
				final JvmTypeReference parameterType = parameter.getParameterType();
				XExpression argument = arguments.get(i);
				IJvmTypeReferenceProvider expectation = new LazyExpectation(parameterType);
				AbstractTypeComputationState argumentState = new ObservableTypeComputationStateWithExpectation(
						getState().getResolvedTypes(), getState().getFeatureScopeSession(), getState().getResolver(), getState(), expectation, this);
				stackedResolvedTypes.add(resolveArgumentType(argument, expectation.getTypeReference(), argumentState));
			}
			if (varArgs) {
				int lastParamIndex = declaredParameterCount - 1;
				JvmTypeReference lastParameterType = parameters.get(lastParamIndex).getParameterType();
				if (!(lastParameterType instanceof JvmGenericArrayTypeReference))
					throw new IllegalStateException("Unexpected var arg type: " + lastParameterType);
				final JvmTypeReference componentType = ((JvmGenericArrayTypeReference) lastParameterType).getComponentType();
				
				IJvmTypeReferenceProvider expectation = new LazyExpectation(componentType);
				AbstractTypeComputationState argumentState = null;
				if (arguments.size() == declaredParameterCount) {
	//				XExpression lastArgument = arguments.get(lastParamIndex);
					// TODO expect Array and componentType
					argumentState = new ObservableTypeComputationStateWithExpectation(
							getState().getResolvedTypes(), getState().getFeatureScopeSession(), getState().getResolver(), getState(), expectation, this);
				} else {
					argumentState = new ObservableTypeComputationStateWithExpectation(
							getState().getResolvedTypes(), getState().getFeatureScopeSession(), getState().getResolver(), getState(), expectation, this);
				}
				for(int i = fixedArityArgumentCount; i < arguments.size(); i++) {
					XExpression argument = arguments.get(i);
					stackedResolvedTypes.add(resolveArgumentType(argument, null, argumentState));
				}
			}
		}
		if (!varArgs) {
			for(int i = fixedArityArgumentCount; i < arguments.size(); i++) {
				XExpression argument = arguments.get(i);
				stackedResolvedTypes.add(resolveArgumentType(argument, null, getState().fork().withNonVoidExpectation()));
			}
		}
	}

	protected void resolveAgainstActualType(JvmTypeReference declaredType, JvmTypeReference actualType) {
		JvmIdentifiableElement feature = getFeature();
		// TODO this(..) and super(..) for generic types
		if (feature instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) feature).getTypeParameters();
			if (!typeParameters.isEmpty()) {
				ActualTypeArgumentCollector implementation = new UnboundTypeParameterAwareTypeArgumentCollector(typeParameters, BoundTypeArgumentSource.EXPECTATION, getState().getServices());
				implementation.populateTypeParameterMapping(declaredType, actualType);
//				typeParameterMapping.putAll(implementation.rawGetTypeParameterMapping());
			}
		}
	}

	protected Map<JvmTypeParameter, MergedBoundTypeArgument> getFeatureTypeParameterMapping() {
		Map<JvmTypeParameter, MergedBoundTypeArgument> consolidatedMap = Maps.newLinkedHashMap();
		for(JvmTypeParameter typeParameter: typeParameterMapping.keySet()) {
			List<BoundTypeArgument> boundTypeArguments = typeParameterMapping.get(typeParameter);
			MergedBoundTypeArgument mergedTypeArguments = getState().getTypeArgumentMerger().merge(boundTypeArguments);
			if (mergedTypeArguments != null) {
				consolidatedMap.put(typeParameter, mergedTypeArguments);
			}
		}
	}

}
