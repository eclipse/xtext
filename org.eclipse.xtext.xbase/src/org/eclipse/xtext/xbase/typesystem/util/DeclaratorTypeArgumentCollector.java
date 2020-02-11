/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.InnerFunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.InnerTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTraversalData;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceFactory;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithParameterAndResult;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class DeclaratorTypeArgumentCollector extends TypeReferenceVisitorWithParameterAndResult<LightweightTraversalData, Boolean> {
	
	@Override
	protected Boolean doVisitTypeReference(LightweightTypeReference reference, LightweightTraversalData data) {
		return Boolean.FALSE;
	}

	@Override
	public Boolean doVisitCompoundTypeReference(CompoundTypeReference reference, LightweightTraversalData data) {
		// TODO error message, cannot extend compound reference - error handling does not belong here
		boolean result = true;
		for(LightweightTypeReference component: reference.getMultiTypeComponents()) {
			Boolean componentsDone = component.accept(this, data);
			result &= componentsDone != null && componentsDone.booleanValue();
		}
		return result;
	}

	@Override
	public Boolean doVisitArrayTypeReference(ArrayTypeReference reference, LightweightTraversalData data) {
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean doVisitWildcardTypeReference(WildcardTypeReference reference, LightweightTraversalData data) {
		// TODO error message, cannot extend wildcard type - error handling does not belong here
		return Boolean.FALSE;
	}

	@Override
	public Boolean doVisitParameterizedTypeReference(ParameterizedTypeReference reference, LightweightTraversalData data) {
		JvmType type = reference.getType();
		// TODO improve handling of redundant super types where a better path to the supertype exists
		/*
		 * e.g. MyList extends AbstractList implements List<String> {}
		 * the implements clause seems to be redundant but provides more reliable information
		 */
		if (!type.eIsProxy() && data.getVisited().add(type)) {
			return doVisitParameterizedTypeReference(reference, type, data);
		}
		return Boolean.FALSE;
	}
	
	@Override
	protected Boolean doVisitInnerTypeReference(InnerTypeReference reference, LightweightTraversalData data) {
		if (!reference.getOuter().accept(this, data)) {
			return super.doVisitInnerTypeReference(reference, data);
		}
		return Boolean.TRUE;
	}
	
	@Override
	protected Boolean doVisitInnerFunctionTypeReference(InnerFunctionTypeReference reference, LightweightTraversalData data) {
		if (!reference.getOuter().accept(this, data)) {
			return super.doVisitInnerFunctionTypeReference(reference, data);
		}
		return Boolean.TRUE;
	}
	
	protected Boolean addConstraintMapping(final JvmTypeParameter typeParameter, ITypeReferenceOwner owner, LightweightTraversalData data) {
		List<JvmTypeConstraint> constraints = typeParameter.getConstraints();
		List<LightweightTypeReference> upperBounds = Lists.newArrayList();
		LightweightTypeReferenceFactory factory = new LightweightTypeReferenceFactory(owner) {
			@Override
			protected JvmType getType(JvmTypeReference reference) {
				// guard against raw type references where the declarator is recursively defined, e.g.
				// E extends Enum<E> with Class<? extends Enum/* raw */>
				JvmType type = reference.getType();
				if (type == typeParameter) {
					return getObjectType();
				}
				return type;
			}
		};
		for(JvmTypeConstraint constraint: constraints) {
			if (constraint instanceof JvmUpperBound && constraint.getTypeReference() != null) {
				LightweightTypeReference upperBound = factory.toLightweightReference(constraint.getTypeReference());
				upperBound.accept(this, data);
				upperBounds.add(upperBound);
			}
		}
		if (upperBounds.size() > 1) {
			CompoundTypeReference result = owner.newCompoundTypeReference(false);
			for(LightweightTypeReference upperBound: upperBounds) {
				result.addComponent(upperBound);
			}
			data.getTypeParameterMapping().put(typeParameter, new LightweightMergedBoundTypeArgument(result, VarianceInfo.INVARIANT));
		} else if (upperBounds.size() == 1) {
			data.getTypeParameterMapping().put(typeParameter, new LightweightMergedBoundTypeArgument(upperBounds.get(0), VarianceInfo.INVARIANT));
		}
		return Boolean.FALSE;
	}

	protected Boolean doVisitParameterizedTypeReference(ParameterizedTypeReference reference, JvmType type,
			LightweightTraversalData data) {
		// TODO check constraints, add validation messages if necessary - error handling does not belong here
		if (reference.isRawType()) {
			if (type instanceof JvmTypeParameterDeclarator) {
				List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) type).getTypeParameters();
				for(JvmTypeParameter typeParameter: typeParameters) {
					addConstraintMapping(typeParameter, reference.getOwner(), data);
				}
			}
		} else if (type instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) type).getTypeParameters();
			List<LightweightTypeReference> typeArguments = reference.getTypeArguments();
			int size = Math.min(typeArguments.size(), typeParameters.size());
			for (int i = 0; i <  size; i++) {
				JvmTypeParameter param = typeParameters.get(i);
				LightweightTypeReference argument = typeArguments.get(i);
				if (param != null && argument != null) {
					data.getTypeParameterMapping().put(param, new LightweightMergedBoundTypeArgument(argument, VarianceInfo.INVARIANT));
				}
			}
		}
		if (type instanceof JvmDeclaredType) {
			ITypeReferenceOwner owner = reference.getOwner();
			List<JvmTypeReference> superTypes = ((JvmDeclaredType) type).getSuperTypes();
			for(JvmTypeReference superType: superTypes) {
				LightweightTypeReference lightweightSuperType = owner.toLightweightTypeReference(superType);
				Boolean recursion = lightweightSuperType.accept(this, data);
				if (recursion != null && recursion.booleanValue()) {
					return Boolean.TRUE;
				}
			}
		} else if (type instanceof JvmTypeParameter) {
			ITypeReferenceOwner owner = reference.getOwner();
			List<JvmTypeConstraint> constraints = ((JvmTypeParameter) type).getConstraints();
			for(JvmTypeConstraint constraint: constraints) {
				JvmTypeReference constraintReference = constraint.getTypeReference();
				if (constraintReference != null) {
					LightweightTypeReference lightweightSuperType = owner.toLightweightTypeReference(constraintReference);
					Boolean recursion = lightweightSuperType.accept(this, data);
					if (recursion != null && recursion.booleanValue()) {
						return Boolean.TRUE;
					}
				}
			}
		}
		return Boolean.FALSE;
	}
	
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping(LightweightTypeReference reference) {
		LightweightTraversalData data = new LightweightTraversalData();
		reference.accept(this, data);
		return data.getTypeParameterMapping();
	}
	
}