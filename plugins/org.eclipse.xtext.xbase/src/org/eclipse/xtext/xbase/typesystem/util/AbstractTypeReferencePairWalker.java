/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
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
import org.eclipse.xtext.common.types.util.AbstractTypeReferenceVisitorWithParameter;
import org.eclipse.xtext.xtype.util.AbstractXtypeReferenceVisitorWithParameter;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypeReferencePairWalker extends AbstractXtypeReferenceVisitorWithParameter<JvmTypeReference, Void> {

	protected class ArrayTypeReferenceCollector extends
			AbstractTypeReferenceVisitorWithParameter.InheritanceAware<JvmGenericArrayTypeReference, Void> {
		@Override
		public Void doVisitCompoundTypeReference(JvmCompoundTypeReference reference, JvmGenericArrayTypeReference declaration) {
			for (JvmTypeReference component : reference.getReferences())
				visit(component, declaration);
			return null;
		}

		@Override
		public Void doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, JvmGenericArrayTypeReference declaration) {
			return outerVisit(declaration.getComponentType(), reference.getComponentType());
		}

		@Override
		public Void doVisitTypeReference(JvmTypeReference reference, JvmGenericArrayTypeReference declaration) {
			return null;
		}

		@Override
		protected Void handleNullReference(JvmGenericArrayTypeReference declaration) {
			return null;
		}
	}

	protected class WildcardTypeReferenceCollector extends
			AbstractTypeReferenceVisitorWithParameter.InheritanceAware<JvmWildcardTypeReference, Void> {
		@Override
		protected Void handleNullReference(JvmWildcardTypeReference declaration) {
			return null;
		}

		@Override
		public Void doVisitCompoundTypeReference(JvmCompoundTypeReference reference, JvmWildcardTypeReference declaration) {
			return doVisitTypeReference(reference, declaration);
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
							outerVisit(declaredConstraint.getTypeReference(), actualConstraint.getTypeReference(), declaration, VarianceInfo.IN, VarianceInfo.IN);
						}
					}
					if (!actualHasLowerBound) {
						for (JvmTypeConstraint actualConstraint : reference.getConstraints()) {
							outerVisit(declaredConstraint.getTypeReference(), actualConstraint.getTypeReference(), declaration, VarianceInfo.IN, VarianceInfo.OUT);
						}
					}
				}
			}
			if (!lowerBoundFound) {
				for (JvmTypeConstraint declaredConstraint : declaration.getConstraints()) {
					for (JvmTypeConstraint actualConstraint : reference.getConstraints()) {
						outerVisit(declaredConstraint.getTypeReference(), actualConstraint.getTypeReference(), declaration, VarianceInfo.OUT, 
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
					outerVisit(declaredConstraint.getTypeReference(), reference, declaration, VarianceInfo.IN, VarianceInfo.INVARIANT);
				}
			}
			if (!lowerBoundFound) {
				for (JvmTypeConstraint declaredConstraint : declaration.getConstraints()) {
					if (declaredConstraint instanceof JvmUpperBound) {
						outerVisit(declaredConstraint.getTypeReference(), reference, declaration, VarianceInfo.OUT, VarianceInfo.INVARIANT);
					}
				}
			}
			return null;
		}
	}

	protected class ParameterizedTypeReferenceCollector extends
			AbstractTypeReferenceVisitorWithParameter.InheritanceAware<JvmParameterizedTypeReference, Void> {
		@Override
		public Void doVisitCompoundTypeReference(JvmCompoundTypeReference reference, JvmParameterizedTypeReference declaration) {
			for (JvmTypeReference component : reference.getReferences())
				visit(component, declaration);
			return null;
		}

		@Override
		public Void doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, JvmParameterizedTypeReference declaration) {
			final JvmType type = declaration.getType();
			if (type instanceof JvmTypeParameter) {
				if (type != reference.getType() && parametersToProcess.contains(type)) {
					JvmTypeParameter typeParameter = (JvmTypeParameter) type;
					processTypeParameter(typeParameter, reference);
				}
			} else if (type instanceof JvmTypeParameterDeclarator
					&& !((JvmTypeParameterDeclarator) type).getTypeParameters().isEmpty()) {
				Map<JvmTypeParameter, JvmTypeReference> actualMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(reference);
				TypeParameterSubstitutor actualSubstitutor = new TypeParameterSubstitutor(actualMapping, services);
				Map<JvmTypeParameter, JvmTypeReference> declaredMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(declaration);
				TypeParameterSubstitutor declaredSubstitutor = new TypeParameterSubstitutor(declaredMapping, services);
				Collection<JvmTypeParameter> actualBoundParameters = actualMapping.keySet();
				Collection<JvmTypeParameter> visited = Sets.newHashSet();
				for (JvmTypeParameter actualBoundParameter : actualBoundParameters) {
					if (visited.add(actualBoundParameter)) {
						JvmTypeReference declared = declaredMapping.get(actualBoundParameter);
						while(declared == null && actualBoundParameter != null) {
							actualBoundParameter = findMappedParameter(actualBoundParameter, actualMapping, visited);
							declared = declaredMapping.get(actualBoundParameter);
						}
						if (declared != null) {
							if (declared.getType() instanceof JvmTypeParameter) {
								JvmTypeParameter declaredType = (JvmTypeParameter) declared.getType();
								if (!parametersToProcess.contains(declaredType)) {
									if (actualBoundParameters.contains(declaredType) && !visited.add(declaredType))
										continue;
									declared = declaredSubstitutor.substitute(declared);
								}
							}
							JvmTypeReference actual = actualSubstitutor.substitute(actualMapping.get(actualBoundParameter));
							outerVisit(declared, actual, declaration, VarianceInfo.INVARIANT, VarianceInfo.INVARIANT);
						}
					}
				}
			}
			return null;
		}

		private JvmTypeParameter findMappedParameter(JvmTypeParameter parameter,
				Map<JvmTypeParameter, JvmTypeReference> mapping, Collection<JvmTypeParameter> visited) {
			for(Map.Entry<JvmTypeParameter, JvmTypeReference> entry: mapping.entrySet()) {
				if (parameter == entry.getValue().getType()) {
					if (visited.add(entry.getKey()))
						return entry.getKey();
					return null;
				}
			}
			return null;
		}

		@Override
		public Void doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, JvmParameterizedTypeReference declaration) {
			final JvmType type = declaration.getType();
			if (type instanceof JvmTypeParameter) {
				if (parametersToProcess.contains(type)) {
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

		@Override
		public Void doVisitTypeReference(JvmTypeReference reference, JvmParameterizedTypeReference declaration) {
			return null;
		}
	}

	private final CommonTypeComputationServices services;
	
	private final ParameterizedTypeReferenceCollector parameterizedTypeReferenceCollector;
	private final WildcardTypeReferenceCollector wildcardTypeReferenceCollector;
	private final ArrayTypeReferenceCollector arrayTypeReferenceCollector;
	
	private final List<JvmTypeParameter> parametersToProcess;

	private VarianceInfo expectedVariance;

	private VarianceInfo actualVariance;

	private Object origin;
	
	protected AbstractTypeReferencePairWalker(List<JvmTypeParameter> parametersToProcess, CommonTypeComputationServices services) {
		this.parametersToProcess = parametersToProcess;
		this.services = services;
		parameterizedTypeReferenceCollector = createParameterizedTypeReferenceCollector();
		wildcardTypeReferenceCollector = createWildcardTypeReferenceCollector();
		arrayTypeReferenceCollector = createArrayTypeReferenceCollector();
	}
	
	protected abstract void processTypeParameter(JvmTypeParameter typeParameter, JvmTypeReference reference);

	protected ArrayTypeReferenceCollector createArrayTypeReferenceCollector() {
		return new ArrayTypeReferenceCollector();
	}

	protected WildcardTypeReferenceCollector createWildcardTypeReferenceCollector() {
		return new WildcardTypeReferenceCollector();
	}

	protected ParameterizedTypeReferenceCollector createParameterizedTypeReferenceCollector() {
		return new ParameterizedTypeReferenceCollector();
	}
	
	@Override
	public Void doVisitCompoundTypeReference(JvmCompoundTypeReference reference, JvmTypeReference param) {
		for (JvmTypeReference component : reference.getReferences())
			visit(component, param);
		return null;
	}

	@Override
	protected Void handleNullReference(JvmTypeReference parameter) {
		return null;
	}

	@Override
	public Void doVisitTypeReference(JvmTypeReference reference, JvmTypeReference param) {
		return null;
	}

	@Override
	public Void doVisitParameterizedTypeReference(JvmParameterizedTypeReference declaredReference,
			JvmTypeReference param) {
		return parameterizedTypeReferenceCollector.visit(param, declaredReference);
	}

	@Override
	public Void doVisitWildcardTypeReference(JvmWildcardTypeReference declaredReference, JvmTypeReference param) {
		return wildcardTypeReferenceCollector.visit(param, declaredReference);
	}

	@Override
	public Void doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference declaredReference,
			JvmTypeReference param) {
		return arrayTypeReferenceCollector.visit(param, declaredReference);
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
		if (parametersToProcess.isEmpty())
			return;
		outerVisit(declaredType, actualType, declaredType, VarianceInfo.OUT, VarianceInfo.OUT);
	}
	
	protected List<JvmTypeParameter> getParametersToProcess() {
		return parametersToProcess;
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
}
