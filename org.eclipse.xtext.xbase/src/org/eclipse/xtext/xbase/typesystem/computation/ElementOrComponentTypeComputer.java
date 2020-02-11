/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.Map;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithResult;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.ConstraintAwareTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;

/**
 * A small utility that allows to query an arbitrary type reference for the value that is bound
 * to the type parameter {@code T} of {@code java.lang.Iterable<T>}. If the queried type is an
 * array, the component type of the array is returned.
 * 
 * Clients will usually use the static method {@link #compute(LightweightTypeReference, ITypeReferenceOwner)}
 * but are free to override this class and call the constructor directly and pass it as a visitor
 * to the processed type reference.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
public class ElementOrComponentTypeComputer extends TypeReferenceVisitorWithResult<LightweightTypeReference> {
	
	/* @Nullable */
	public static LightweightTypeReference compute(LightweightTypeReference iterableOrArray, ITypeReferenceOwner owner) {
		LightweightTypeReference result = iterableOrArray.accept(new ElementOrComponentTypeComputer(owner));
		return result;
	}
	
	private final ITypeReferenceOwner owner;

	protected ElementOrComponentTypeComputer(ITypeReferenceOwner owner) {
		this.owner = owner;
	}

	@Override
	public LightweightTypeReference doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
		DeclaratorTypeArgumentCollector typeArgumentCollector = new ConstraintAwareTypeArgumentCollector(owner);
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping = typeArgumentCollector.getTypeParameterMapping(reference);
		TypeParameterSubstitutor<?> substitutor = new UnboundTypeParameterPreservingSubstitutor(typeParameterMapping, owner);
		JvmGenericType iterable = (JvmGenericType) owner.getServices().getTypeReferences().findDeclaredType(Iterable.class, owner.getContextResourceSet());
		if (iterable == null) {
			return owner.newReferenceToObject();
		}
		LightweightTypeReference substituteMe = owner.newParameterizedTypeReference(iterable.getTypeParameters().get(0));
		LightweightTypeReference substitutedArgument = substitutor.substitute(substituteMe).getUpperBoundSubstitute();
		if (substitutedArgument.getType() instanceof JvmTypeParameter && 
				!(owner.getDeclaredTypeParameters().contains(substitutedArgument.getType()))) {
			return substitutedArgument.getRawTypeReference();
		}
		return substitutedArgument;
	}

	@Override
	protected LightweightTypeReference doVisitAnyTypeReference(AnyTypeReference reference) {
		return reference;
	}

	@Override
	protected LightweightTypeReference doVisitUnknownTypeReference(UnknownTypeReference reference) {
		return reference;
	}

	@Override
	public LightweightTypeReference doVisitArrayTypeReference(ArrayTypeReference reference) {
		return reference.getComponentType();
	}

	@Override
	/* @Nullable */
	protected LightweightTypeReference doVisitUnboundTypeReference(UnboundTypeReference reference) {
		return null;
	}
	
	@Override
	protected LightweightTypeReference doVisitCompoundTypeReference(CompoundTypeReference reference) {
		return reference.getComponentType();
	}

	protected ITypeReferenceOwner getOwner() {
		return owner;
	}
}
