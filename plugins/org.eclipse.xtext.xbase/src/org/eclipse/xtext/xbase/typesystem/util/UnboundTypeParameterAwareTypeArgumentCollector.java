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

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class UnboundTypeParameterAwareTypeArgumentCollector extends ActualTypeArgumentCollector {
	public UnboundTypeParameterAwareTypeArgumentCollector(List<JvmTypeParameter> parametersToBeMapped,
			CommonTypeComputationServices services) {
		super(parametersToBeMapped, services);
	}

	@Override
	protected TypeParameterSubstitutor createTypeParameterSubstitutor(Map<JvmTypeParameter, JvmTypeReference> mapping) {
		return new UnboundTypeParameterPreservingSubstitutor(mapping, getServices());
	}
	
	@Override
	public Void doVisitComputedTypeReference(XComputedTypeReference reference, JvmTypeReference param) {
		if (reference.getTypeProvider() instanceof UnboundTypeParameter) {
			UnboundTypeParameter unboundTypeParameter = (UnboundTypeParameter) reference.getTypeProvider();
			unboundTypeParameter.acceptHint(param);
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
					UnboundTypeParameter unboundTypeParameter = (UnboundTypeParameter) reference.getTypeProvider();
					JvmType type = declaration.getType();
					if (type instanceof JvmTypeParameter) {
						if (type != unboundTypeParameter.getTypeParameter() && getParametersToProcess().contains(type)) {
							JvmTypeParameter typeParameter = (JvmTypeParameter) type;
							processTypeParameter(typeParameter, reference);
						} else {
							// register synonym type param resolution et al for the actual type in the given UnboundTypeParameter
						}
					} else {
						// TODO what kind of hint is that? upper / lower?
						unboundTypeParameter.acceptHint(declaration);
					}
					return null;
				}
				return super.doVisitComputedTypeReference(reference, declaration);
			}
		};
	}
	
//	@Override
//	protected ArrayTypeReferenceTraverser createArrayTypeReferenceTraverser() {
//		return new ArrayTypeReferenceTraverser() {
//			@Override
//			public Void doVisitComputedTypeReference(XComputedTypeReference reference,
//					JvmGenericArrayTypeReference param) {
//				// TODO Auto-generated method stub
//				return super.doVisitComputedTypeReference(reference, param);
//			}
//		};
//	}
	
	@Override
	protected WildcardTypeReferenceTraverser createWildcardTypeReferenceTraverser() {
		return new WildcardTypeReferenceTraverser() {
			@Override
			public Void doVisitComputedTypeReference(XComputedTypeReference reference,
					JvmWildcardTypeReference param) {
				if (reference.getTypeProvider() instanceof UnboundTypeParameter) {
					return super.doVisitTypeReference(reference, param);
				}
				return super.doVisitComputedTypeReference(reference, param);
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
}