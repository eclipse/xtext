/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterByConstraintSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.common.collect.Lists;

/**
 * Base class for resolved representation of a {@link JvmOperation}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractResolvedOperation implements IResolvedOperation {
	
	private JvmOperation declaration;
	private LightweightTypeReference contextType;
	private List<IResolvedOperation> validOverrides;
	private List<IResolvedOperation> overrideCandidates;
	private List<LightweightTypeReference> parameterTypes;
	private LightweightTypeReference returnType;
	private List<LightweightTypeReference> declaredExceptions;

	protected AbstractResolvedOperation(JvmOperation declaration, LightweightTypeReference contextType) {
		this.declaration = declaration;
		this.contextType = contextType;
	}
	
	public JvmOperation getDeclaration() {
		return declaration;
	}
	
	public LightweightTypeReference getContextType() {
		return contextType;
	}

	public List<IResolvedOperation> getOverriddenAndImplementedMethods() {
		if (validOverrides != null)
			return validOverrides;
		List<IResolvedOperation> candidates = getOverriddenAndImplementedMethodCandidates();
		if (candidates.isEmpty())
			return candidates;
		List<IResolvedOperation> result = Lists.newArrayListWithCapacity(candidates.size());
		for(IResolvedOperation candidate: candidates) {
			if (isOverridingOrImplementing(candidate.getDeclaration()).isValid()) {
				result.add(candidate);
			}
		}
		return validOverrides = Collections.unmodifiableList(result);
	}

	public List<IResolvedOperation> getOverriddenAndImplementedMethodCandidates() {
		if (overrideCandidates != null)
			return overrideCandidates;
		ParameterizedTypeReference currentDeclarator = new ParameterizedTypeReference(getContextType().getOwner(), declaration.getDeclaringType());
		List<LightweightTypeReference> superTypes = currentDeclarator.getSuperTypes();
		List<IResolvedOperation> result = Lists.newArrayListWithCapacity(5);
		for(LightweightTypeReference superType: superTypes) {
			JvmDeclaredType declaredSuperType = (JvmDeclaredType) superType.getType();
			if (declaredSuperType != null) {
				Iterable<JvmFeature> equallyNamedFeatures = declaredSuperType.findAllFeaturesByName(declaration.getSimpleName());
				for(JvmFeature equallyNamedFeature: equallyNamedFeatures) {
					if (equallyNamedFeature instanceof JvmOperation) {
						result.add(new ResolvedOperationInHierarchy((JvmOperation) equallyNamedFeature, getBottom()));
					}
				}
			}
		}
		return overrideCandidates = Collections.unmodifiableList(result);
	}
	
	public OverrideCheckResult isOverridingOrImplementing(final JvmOperation operation) {
		class Mock implements OverrideCheckResult {

			private boolean valid;

			Mock(boolean valid) {
				this.valid = valid;
				
			}
			public boolean isValid() {
				return valid;
			}

			public boolean hasProblems() {
				throw new UnsupportedOperationException();
			}

			public EnumSet<OverrideCheckDetails> getDetails() {
				throw new UnsupportedOperationException();
			}

			public IResolvedOperation getThisOperation() {
				return AbstractResolvedOperation.this;
			}

			public JvmOperation getGivenOperation() {
				return operation;
			}
			
		}
		if (operation.getSimpleName().equals(declaration.getSimpleName())) {
			if (operation.getParameters().size() == declaration.getParameters().size()) {
				return new Mock(true); 
			}
		}
		return new Mock(false);
	}
	
	public List<JvmTypeParameter> getResolvedTypeParameters() {
		return getBottom().getTypeParameters();
	}

	public List<JvmTypeParameter> getTypeParameters() {
		return Collections.unmodifiableList(declaration.getTypeParameters());
	}

	public List<LightweightTypeReference> getParameterTypes() {
		if (declaration.getParameters().isEmpty())
			return Collections.emptyList();
		if (parameterTypes != null)
			return parameterTypes;
		List<JvmFormalParameter> parameters = declaration.getParameters();
		List<JvmTypeReference> unresolvedParameterTypes = Lists.newArrayListWithCapacity(parameters.size());
		for(JvmFormalParameter parameter: parameters) {
			unresolvedParameterTypes.add(parameter.getParameterType());
		}
		return parameterTypes = getResolvedReferences(unresolvedParameterTypes);
	}

	public LightweightTypeReference getReturnType() {
		if (returnType != null)
			return returnType;
		return returnType = getResolvedReference(declaration.getReturnType());
	}
	
	protected LightweightTypeReference getResolvedReference(JvmTypeReference unresolved) {
		TypeParameterSubstitutor<?> substitutor = getSubstitutor();
		OwnedConverter converter = new OwnedConverter(getContextType().getOwner());
		LightweightTypeReference unresolvedLightweight = converter.toLightweightReference(unresolved);
		LightweightTypeReference result = substitutor.substitute(unresolvedLightweight);
		return result;
	}
	
	protected List<LightweightTypeReference> getResolvedReferences(List<JvmTypeReference> unresolved) {
		List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(unresolved.size());
		for(JvmTypeReference resolveMe: unresolved) {
			result.add(getResolvedReference(resolveMe));
		}
		return result;
	}

	public List<LightweightTypeReference> getDeclaredExceptions() {
		if (declaration.getExceptions().isEmpty())
			return Collections.emptyList();
		if (declaredExceptions != null)
			return declaredExceptions;
		return declaredExceptions = getResolvedReferences(declaration.getExceptions());
	}
	
	protected TypeParameterSubstitutor<?> getSubstitutor() {
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = getContextTypeParameterMapping();
		TypeParameterSubstitutor<?> result = new TypeParameterByConstraintSubstitutor(mapping, getContextType().getOwner()) {
			@Override
			protected boolean isDeclaredTypeParameter(JvmTypeParameter typeParameter) {
				return super.isDeclaredTypeParameter(typeParameter) || getResolvedTypeParameters().contains(typeParameter);
			}
		};
		return result;
	}
	
	protected abstract Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getContextTypeParameterMapping();
	
	protected abstract BottomResolvedOperation getBottom();
}
