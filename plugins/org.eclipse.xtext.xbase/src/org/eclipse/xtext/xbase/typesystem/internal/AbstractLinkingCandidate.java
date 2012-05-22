/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.batch.BucketedEObjectDescription;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.util.AbstractTypeReferencePairWalker;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameter;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO Javadoc
 */
public abstract class AbstractLinkingCandidate<LinkingCandidate extends ILinkingCandidate<LinkingCandidate>> implements ILinkingCandidate<LinkingCandidate> {
	
	private final IEObjectDescription description;
	private final AbstractTypeComputationState state;
	private final XExpression expression;
	
	protected AbstractLinkingCandidate(XExpression expression, IEObjectDescription description,
			AbstractTypeComputationState state) {
		this.expression = expression;
		this.description = description;
		this.state = state;
	}

	public List<JvmFormalParameter> getDeclaredParameters() {
		JvmIdentifiableElement feature = getFeature();
		if (feature instanceof JvmExecutable) {
			return ((JvmExecutable) feature).getParameters();
		}
		return Collections.emptyList();
	}
	
	public List<JvmTypeParameter> getDeclaredTypeParameters() {
		return Collections.emptyList();
	}
	
	public void apply() {
		JvmIdentifiableElement feature = getFeature();
		JvmTypeReference featureType = getDeclaredType(feature);
		state.getResolvedTypes().acceptLinkingInformation(getExpression(), this);
		computeArgumentTypes(feature, featureType);
		List<ITypeExpectation> expectations = state.getImmediateExpectations();
		for(ITypeExpectation expectation: expectations) {
			// TODO implement bounds / type parameter resolution
			// TODO consider expectation if any
			acceptActualType(expectation, featureType);
		}
	}
	
	protected void acceptActualType(ITypeExpectation expectation, JvmTypeReference featureType) {
		deferredBindTypeArguments(expectation, featureType);
		expectation.acceptActualType(featureType, ConformanceHint.UNCHECKED); // TODO NATIVE, EXPECTATION_INDEPENDENT ?
	}
	
	protected JvmTypeReference asWrapperType(JvmTypeReference potentialPrimitive) {
		if (potentialPrimitive instanceof XComputedTypeReference) {
			if (((XComputedTypeReference) potentialPrimitive).getTypeProvider() instanceof UnboundTypeParameter){
				return potentialPrimitive;
			}
		}
		Primitives primitives = state.getServices().getPrimitives();
		JvmTypeReference result = primitives.asWrapperTypeIfPrimitive(potentialPrimitive);
		return result;
	}
	
	protected JvmTypeParameter getTypeParameter(JvmTypeReference referenceToTypeParameter) {
		if (referenceToTypeParameter instanceof XComputedTypeReference) {
			if (((XComputedTypeReference) referenceToTypeParameter).getTypeProvider() instanceof UnboundTypeParameter){
				return null;
			}
			return getTypeParameter(((XComputedTypeReference) referenceToTypeParameter).getEquivalent());
		}
		JvmType result = referenceToTypeParameter.getType();
		if (result instanceof JvmTypeParameter) {
			return (JvmTypeParameter) result;
		}
		return null;
	}
	
	protected void deferredBindTypeArguments(ITypeExpectation expectation, JvmTypeReference type) {
		JvmTypeReference expectedType = expectation.getExpectedType();
		if (expectedType != null) { // TODO expectation#hasTypeParameters / isUnresolved
			new AbstractTypeReferencePairWalker(getState().getServices()) {
				
				@Override
				protected TypeParameterSubstitutor createTypeParameterSubstitutor(Map<JvmTypeParameter, JvmTypeReference> mapping) {
					return new UnboundTypeParameterPreservingSubstitutor(mapping, getServices());
				}
				
				@Override
				protected WildcardTypeReferenceTraverser createWildcardTypeReferenceTraverser() {
					return new WildcardTypeReferenceTraverser() {
						@Override
						public Void doVisitComputedTypeReference(XComputedTypeReference reference, JvmWildcardTypeReference declaration) {
							if (reference.getTypeProvider() instanceof UnboundTypeParameter) {
								return super.doVisitTypeReference(reference, declaration);
							}
							return super.doVisitComputedTypeReference(reference, declaration);
						}
					};
				}
				
				@Override
				public Void doVisitComputedTypeReference(XComputedTypeReference reference, JvmTypeReference param) {
					if (reference.getTypeProvider() instanceof UnboundTypeParameter) {
						UnboundTypeParameter typeParameter = (UnboundTypeParameter) reference.getTypeProvider();
						JvmTypeReference wrapped =  asWrapperType(param);
						typeParameter.acceptHint(wrapped);
						return null;
					}
					return super.doVisitComputedTypeReference(reference, param);
				}

				@Override
				protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
					return new ParameterizedTypeReferenceTraverser() {
						@Override
						public Void doVisitComputedTypeReference(XComputedTypeReference reference,
								JvmParameterizedTypeReference declaration) {
							if (reference.getTypeProvider() instanceof UnboundTypeParameter) {
								UnboundTypeParameter typeParameter = (UnboundTypeParameter) reference.getTypeProvider();
								JvmTypeReference wrapped =  asWrapperType(declaration);
								typeParameter.acceptHint(wrapped);
								return null;
							}
							return super.doVisitComputedTypeReference(reference, declaration);
						}
						@Override
						protected boolean allowToVisitTwice() {
							return false;
						}
					};
				}

				@Override
				protected JvmTypeParameter findMappedParameter(JvmTypeParameter parameter,
						Map<JvmTypeParameter, JvmTypeReference> mapping, Collection<JvmTypeParameter> visited) {
					for(Map.Entry<JvmTypeParameter, JvmTypeReference> entry: mapping.entrySet()) {
						JvmTypeReference reference = entry.getValue();
						JvmType type = null;
						if (reference instanceof XComputedTypeReference) {
							IJvmTypeReferenceProvider typeProvider = ((XComputedTypeReference) reference).getTypeProvider();
							if (typeProvider instanceof UnboundTypeParameter) {
								type = ((UnboundTypeParameter) typeProvider).getTypeParameter();
							}
						} else {
							type = reference.getType();
						}
						if (parameter == type) {
							if (visited.add(entry.getKey()))
								return entry.getKey();
							return null;
						}
					}
					return null;
				}
			}.processPairedReferences(expectedType, type);
		}
	}

	protected JvmTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		return state.getType(feature);
	}

	protected Map<JvmTypeParameter, JvmTypeReference> getDeclaratorParameterMapping() {
		return Collections.<JvmTypeParameter, JvmTypeReference>emptyMap();
	}

	protected void computeArgumentTypes(JvmIdentifiableElement feature, JvmTypeReference featureType) {
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
		List<StackedResolvedTypes> stackedResolvedTypes = Lists.newArrayListWithCapacity(arguments.size());
		if (parameters != null) {
			for(int i = 0; i < fixedArityArgumentCount; i++) {
				final JvmFormalParameter parameter = parameters.get(i);
				final JvmTypeReference parameterType = parameter.getParameterType();
				XExpression argument = arguments.get(i);
				
				AbstractTypeComputationState argumentState = state.fork().withExpectation(parameterType);
//				IJvmTypeReferenceProvider expectation = new LazyExpectation(parameterType);
//				AbstractTypeComputationState argumentState = new ObservableTypeComputationStateWithExpectation(
//						state.getResolvedTypes(), state.getFeatureScopeSession(), state.getResolver(), state, expectation, this);
				stackedResolvedTypes.add(resolveArgumentType(argument, parameterType, argumentState));
			}
			if (varArgs) {
				int lastParamIndex = declaredParameterCount - 1;
				JvmTypeReference lastParameterType = parameters.get(lastParamIndex).getParameterType();
				if (!(lastParameterType instanceof JvmGenericArrayTypeReference))
					throw new IllegalStateException("Unexpected var arg type: " + lastParameterType);
				final JvmTypeReference componentType = ((JvmGenericArrayTypeReference) lastParameterType).getComponentType();
				
//				IJvmTypeReferenceProvider expectation = new LazyExpectation(componentType);
				AbstractTypeComputationState argumentState = null;
				if (arguments.size() == declaredParameterCount) {
	//				XExpression lastArgument = arguments.get(lastParamIndex);
					// TODO expect Array and componentType
					argumentState = state.fork().withExpectation(componentType);
				} else {
					argumentState = state.fork().withExpectation(componentType);
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
				stackedResolvedTypes.add(resolveArgumentType(argument, null, state.fork().withNonVoidExpectation()));
			}
		}
		for(StackedResolvedTypes pending: stackedResolvedTypes) {
			pending.mergeIntoParent();
		}
	}
	
	protected StackedResolvedTypes resolveArgumentType(XExpression argument, JvmTypeReference declaredType, AbstractTypeComputationState argumentState) {
		return argumentState.computeTypesWithoutMerge(argument);
	}

//	protected void resolveAgainstActualType(JvmTypeReference declaredType, JvmTypeReference actualType) {
//		JvmIdentifiableElement feature = getFeature();
//		// TODO this(..) and super(..) for generic types
//		if (feature instanceof JvmTypeParameterDeclarator) {
//			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) feature).getTypeParameters();
//			if (!typeParameters.isEmpty()) {
//				ActualTypeArgumentCollector implementation = new UnboundTypeParameterAwareTypeArgumentCollector(typeParameters, state.getServices());
//				implementation.populateTypeParameterMapping(declaredType, actualType);
//				typeParameterMapping.putAll(implementation.rawGetTypeParameterMapping());
//			}
//		}
//	}

	public List<XExpression> getArguments() {
		List<XExpression> arguments = getSyntacticArguments();
		// TODO handle static feature etc
		JvmIdentifiableElement feature = getFeature();
		if (feature instanceof JvmOperation && ((JvmOperation) feature).isStatic()) {
			XExpression receiver = getReceiver();
			if (receiver != null) {
				List<XExpression> result = Lists.newArrayListWithCapacity(1 + arguments.size());
				result.add(receiver);
				result.addAll(arguments);
				return result;
			}
		}
		return arguments;
	}
	
	public int compareTo(LinkingCandidate right) {
		int arityCompareResult = compareByArity(getArityMismatch(), right.getArityMismatch());
		if (arityCompareResult != 0)
			return arityCompareResult;
		if (right.getDeclaredParameters().size() > getDeclaredParameters().size())
			return 1;
		int typeArityCompareResult = compareByArity(getTypeArityMismatch(), right.getTypeArityMismatch());
		if (typeArityCompareResult != 0)
			return typeArityCompareResult;
		if (getDeclaredTypeParameters().size() > right.getDeclaredTypeParameters().size()) {
			return 1;
		}
		return 0;
	}

	protected int compareByArity(int leftArityMismatch, int rightArityMismatch) {
		if (leftArityMismatch != rightArityMismatch) {
			if (leftArityMismatch == 0)
				return -1;
			if (rightArityMismatch == 0)
				return 1;
			if (Math.abs(leftArityMismatch) < Math.abs(rightArityMismatch))
				return -1;
			if (Math.abs(leftArityMismatch) > Math.abs(rightArityMismatch))
				return 1;
			if (leftArityMismatch > 0)
				return -1;
			if (rightArityMismatch > 0)
				return 1;
		}
		if (Math.abs(leftArityMismatch) < Math.abs(rightArityMismatch))
			return -1;
		if (Math.abs(leftArityMismatch) > Math.abs(rightArityMismatch))
			return 1;
		if (leftArityMismatch > 0)
			return -1;
		if (rightArityMismatch > 0)
			return 1;
		return 0;
	}
	
	public int getArityMismatch() {
		JvmIdentifiableElement identifiable = getFeature();
		if (identifiable instanceof JvmExecutable) {
			return getArityMismatch((JvmExecutable) identifiable, getArguments());
		} else {
			return getArguments().size();
		}
	}
	
	public int getTypeArityMismatch() {
		List<JvmTypeReference> explicitTypeArguments = getTypeArguments();
		if (explicitTypeArguments.size() == 0)
			return 0;
		return getDeclaredTypeParameters().size() - explicitTypeArguments.size();
	}
	
	protected abstract List<JvmTypeReference> getTypeArguments();

	protected int getArityMismatch(JvmExecutable executable, List<XExpression> arguments) {
		int fixedArityParamCount = executable.getParameters().size();
		if (executable.isVarArgs()) {
			fixedArityParamCount--;
			if (arguments.size() >= fixedArityParamCount) {
				return 0;
			}
		}
		return fixedArityParamCount - arguments.size();
	}
	
	protected abstract List<XExpression> getSyntacticArguments();
	
	protected IEObjectDescription getDescription() {
		return description;
	}
	
	public JvmIdentifiableElement getFeature() {
		return (JvmIdentifiableElement) getDescription().getEObjectOrProxy();
	}
	
	protected XExpression getReceiver() {
		if (getDescription() instanceof BucketedEObjectDescription) {
			return ((BucketedEObjectDescription) getDescription()).getReceiver();
		}
		return null;
	}
	
	protected XExpression getExpression() {
		return expression;
	}
	
	protected AbstractTypeComputationState getState() {
		return state;
	}

}
