/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString implementation
 */
public abstract class AbstractTypeReferencePairWalker extends AbstractTypeReferenceTraverser<JvmTypeReference> {

	protected class ArrayTypeReferenceTraverser extends
			AbstractTypeReferenceTraverser<JvmGenericArrayTypeReference> {
		@Override
		public Void doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, JvmGenericArrayTypeReference declaration) {
			return outerVisit(declaration.getComponentType(), reference.getComponentType());
		}
	}

	protected static class WildcardTypeReferenceTraverser extends
			AbstractTypeReferenceTraverser<JvmWildcardTypeReference> {
		
		private AbstractTypeReferencePairWalker delegate;

		protected WildcardTypeReferenceTraverser(AbstractTypeReferencePairWalker delegate) {
			this.delegate = delegate;
		}
		
		@Override
		public Void doVisitWildcardTypeReference(JvmWildcardTypeReference reference, JvmWildcardTypeReference declaration) {
			boolean lowerBoundFound = false;
			for (JvmTypeConstraint declaredConstraint : declaration.getConstraints()) {
				if (declaredConstraint instanceof JvmLowerBound) {
					lowerBoundFound = true;
					boolean actualHasLowerBound = false;
					for (JvmTypeConstraint actualConstraint : reference.getConstraints()) {
						if (actualConstraint instanceof JvmLowerBound) {
							actualHasLowerBound = true;
							delegate.outerVisit(declaredConstraint.getTypeReference(), actualConstraint.getTypeReference(), declaration, VarianceInfo.IN, VarianceInfo.IN);
						}
					}
					if (!actualHasLowerBound) {
						for (JvmTypeConstraint actualConstraint : reference.getConstraints()) {
							delegate.outerVisit(declaredConstraint.getTypeReference(), actualConstraint.getTypeReference(), declaration, VarianceInfo.IN, VarianceInfo.OUT);
						}
					}
				}
			}
			if (!lowerBoundFound) {
				for (JvmTypeConstraint declaredConstraint : declaration.getConstraints()) {
					for (JvmTypeConstraint actualConstraint : reference.getConstraints()) {
						delegate.outerVisit(declaredConstraint.getTypeReference(), actualConstraint.getTypeReference(), declaration, VarianceInfo.OUT, 
								actualConstraint instanceof JvmUpperBound ? VarianceInfo.OUT : VarianceInfo.IN);
					}	
				}
			}
			return null;
		}

		@Override
		public Void doVisitTypeReference(JvmTypeReference reference, JvmWildcardTypeReference declaration) {
			boolean lowerBoundFound = false;
			for (JvmTypeConstraint declaredConstraint : declaration.getConstraints()) {
				if (declaredConstraint instanceof JvmLowerBound) {
					lowerBoundFound = true;
					delegate.outerVisit(declaredConstraint.getTypeReference(), reference, declaration, VarianceInfo.IN, VarianceInfo.INVARIANT);
				}
			}
			if (!lowerBoundFound) {
				for (JvmTypeConstraint declaredConstraint : declaration.getConstraints()) {
					if (declaredConstraint instanceof JvmUpperBound) {
						delegate.outerVisit(declaredConstraint.getTypeReference(), reference, declaration, VarianceInfo.OUT, VarianceInfo.INVARIANT);
					}
				}
			}
			return null;
		}
	}

	protected class ParameterizedTypeReferenceTraverser extends
			AbstractTypeReferenceTraverser<JvmParameterizedTypeReference> {
		@Override
		public Void doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, JvmParameterizedTypeReference declaration) {
			final JvmType type = getTypeFromReference(declaration);
			if (type instanceof JvmTypeParameter) {
				if (type != getTypeFromReference(reference) && shouldProcess((JvmTypeParameter) type)) {
					JvmTypeParameter typeParameter = (JvmTypeParameter) type;
					processTypeParameter(typeParameter, reference);
				}
			} else if (type instanceof JvmTypeParameterDeclarator
					&& !((JvmTypeParameterDeclarator) type).getTypeParameters().isEmpty()) {
				doVisitSuperTypesWithMatchingParams(reference, declaration);
			}
			return null;
		}

		protected void doVisitSuperTypesWithMatchingParams(JvmParameterizedTypeReference reference,
				JvmParameterizedTypeReference declaration) {
			Map<JvmTypeParameter, MergedBoundTypeArgument> actualMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(reference);
			TypeParameterSubstitutor actualSubstitutor = createTypeParameterSubstitutor(actualMapping);
			Map<JvmTypeParameter, MergedBoundTypeArgument> declaredMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(declaration);
			TypeParameterSubstitutor declaredSubstitutor = createTypeParameterSubstitutor(declaredMapping);
			Set<JvmTypeParameter> actualBoundParameters = actualMapping.keySet();
			Set<JvmTypeParameter> visited = Sets.newHashSet();
			for (JvmTypeParameter actualBoundParameter : actualBoundParameters) {
				if (visited.add(actualBoundParameter)) {
					MergedBoundTypeArgument declaredBoundArgument = declaredMapping.get(actualBoundParameter);
					while(declaredBoundArgument == null && actualBoundParameter != null) {
						actualBoundParameter = findMappedParameter(actualBoundParameter, actualMapping, visited);
						declaredBoundArgument = declaredMapping.get(actualBoundParameter);
					}
					if (declaredBoundArgument != null) {
						JvmTypeReference declaredTypeReference = declaredBoundArgument.getTypeReference();
						JvmType declaredType = getTypeFromReference(declaredTypeReference);
						if (declaredType instanceof JvmTypeParameter) {
							JvmTypeParameter declaredTypeParameter = (JvmTypeParameter) declaredType;
							if (!shouldProcessInContextOf(declaredTypeParameter, actualBoundParameters, visited))
								continue;
							declaredTypeReference = declaredSubstitutor.substitute(declaredTypeReference);
						}
						JvmTypeReference actual = actualSubstitutor.substitute(actualMapping.get(actualBoundParameter).getTypeReference());
						outerVisit(declaredTypeReference, actual, declaration, VarianceInfo.INVARIANT, VarianceInfo.INVARIANT);
					}
				}
			}
		}
		
		protected boolean shouldProcessInContextOf(JvmTypeParameter declaredTypeParameter, Set<JvmTypeParameter> boundParameters, Set<JvmTypeParameter> visited) {
			return true;
		}

		@Override
		public Void doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, JvmParameterizedTypeReference declaration) {
			final JvmType type = getTypeFromReference(declaration);
			if (type instanceof JvmTypeParameter) {
				if (shouldProcess((JvmTypeParameter) type)) {
					JvmTypeParameter typeParameter = (JvmTypeParameter) type;
					processTypeParameter(typeParameter, reference);
				}
			}
			return null;
		}

		@Override
		public Void doVisitWildcardTypeReference(JvmWildcardTypeReference reference, JvmParameterizedTypeReference declaration) {
			boolean lowerBoundFound = false;
			for (JvmTypeConstraint actualConstraint : reference.getConstraints()) {
				if (actualConstraint instanceof JvmLowerBound) {
					lowerBoundFound = true;
					outerVisit(declaration, actualConstraint.getTypeReference(), declaration, expectedVariance, VarianceInfo.IN);
				}
			}
			if (!lowerBoundFound) {
				for (JvmTypeConstraint actualConstraint : reference.getConstraints()) {
					outerVisit(declaration, actualConstraint.getTypeReference(), declaration, expectedVariance, VarianceInfo.OUT);
				}
			}
			return null;
		}

	}
	
	private final CommonTypeComputationServices services;
	
	private final ParameterizedTypeReferenceTraverser parameterizedTypeReferenceTraverser;
	private final WildcardTypeReferenceTraverser wildcardTypeReferenceTraverser;
	private final ArrayTypeReferenceTraverser arrayTypeReferenceTraverser;
	
	private VarianceInfo expectedVariance;

	private VarianceInfo actualVariance;

	private Object origin;
	
	protected AbstractTypeReferencePairWalker(CommonTypeComputationServices services) {
		this.services = services;
		parameterizedTypeReferenceTraverser = createParameterizedTypeReferenceTraverser();
		wildcardTypeReferenceTraverser = createWildcardTypeReferenceTraverser();
		arrayTypeReferenceTraverser = createArrayTypeReferenceTraverser();
	}
	
	protected void processTypeParameter(JvmTypeParameter typeParameter, JvmTypeReference reference) {
	}
	
	protected boolean shouldProcess(JvmTypeParameter type) {
		return true;
	}

	protected ArrayTypeReferenceTraverser createArrayTypeReferenceTraverser() {
		return new ArrayTypeReferenceTraverser();
	}

	protected WildcardTypeReferenceTraverser createWildcardTypeReferenceTraverser() {
		return new WildcardTypeReferenceTraverser(this);
	}

	protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
		return new ParameterizedTypeReferenceTraverser();
	}
	
	protected JvmType getTypeFromReference(JvmTypeReference reference) {
		return reference.getType();
	}
	
	@Override
	public Void doVisitParameterizedTypeReference(JvmParameterizedTypeReference declaredReference,
			JvmTypeReference param) {
		return parameterizedTypeReferenceTraverser.visit(param, declaredReference);
	}

	@Override
	public Void doVisitWildcardTypeReference(JvmWildcardTypeReference declaredReference, JvmTypeReference param) {
		return wildcardTypeReferenceTraverser.visit(param, declaredReference);
	}

	@Override
	public Void doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference declaredReference,
			JvmTypeReference param) {
		return arrayTypeReferenceTraverser.visit(param, declaredReference);
	}

	protected Void outerVisit(JvmTypeReference reference, JvmTypeReference parameter, Object origin, VarianceInfo expectedVariance, VarianceInfo actualVariance) {
		VarianceInfo oldExpectedVariance = this.expectedVariance;
		VarianceInfo oldActualVariance = this.actualVariance;
		Object oldOrigin = this.origin;
		try {
			this.expectedVariance = expectedVariance;
			this.actualVariance = actualVariance;
			this.origin = origin;
			return outerVisit(reference, parameter);
		} finally {
			this.expectedVariance = oldExpectedVariance;
			this.actualVariance = oldActualVariance;
			this.origin = oldOrigin;
		}
	}
	
	protected Void outerVisit(JvmTypeReference reference, JvmTypeReference parameter) {
		return visit(reference, parameter);
	}

	public void processPairedReferences(JvmTypeReference declaredType, JvmTypeReference actualType) {
		outerVisit(declaredType, actualType, declaredType, VarianceInfo.OUT, VarianceInfo.OUT);
	}
	
	protected CommonTypeComputationServices getServices() {
		return services;
	}
	protected VarianceInfo getActualVariance() {
		return actualVariance;
	}
	protected VarianceInfo getExpectedVariance() {
		return expectedVariance;
	}
	
	protected Object getOrigin() {
		return origin;
	}

	protected TypeParameterSubstitutor createTypeParameterSubstitutor(Map<JvmTypeParameter, MergedBoundTypeArgument> mapping) {
		return new TypeParameterSubstitutor(mapping, services);
	}
	
	protected JvmTypeParameter findMappedParameter(JvmTypeParameter parameter,
			Map<JvmTypeParameter, MergedBoundTypeArgument> mapping, Collection<JvmTypeParameter> visited) {
		for(Map.Entry<JvmTypeParameter, MergedBoundTypeArgument> entry: mapping.entrySet()) {
			MergedBoundTypeArgument reference = entry.getValue();
			JvmType type = getTypeFromReference(reference.getTypeReference());
			if (parameter == type) {
				if (visited.add(entry.getKey()))
					return entry.getKey();
				return null;
			}
		}
		return null;
	}
}