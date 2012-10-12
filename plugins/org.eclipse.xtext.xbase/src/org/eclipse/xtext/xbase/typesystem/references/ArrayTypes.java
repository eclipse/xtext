/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;

/**
 * Strategy to deal with Xbase specific conversion of types to arrays.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ArrayTypes {

	/**
	 * Returns the array representation of this reference if its represents a sub-type of {@link Iterable}.
	 * If the iterable's type is a primitive wrapper, the array is <em>not</em> the primitive array but
	 * the wrapper array. May return <code>null</code> if the conversion is not possible.
	 * 
	 * This is the externalized and thereby
	 * exchangeable implementation of {@link ParameterizedTypeReference#tryConvertToArray()}.
	 * 
	 * @param typeReference the to-be-converted reference.
	 * @return an equivalent {@link ArrayTypeReference} or <code>null</code>.
	 */
	@Nullable
	public ArrayTypeReference tryConvertToArray(ParameterizedTypeReference typeReference) {
		if (typeReference.isSubtypeOf(Iterable.class)) {
			DeclaratorTypeArgumentCollector collector = new DeclaratorTypeArgumentCollector();
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> parameterMapping = collector.getTypeParameterMapping(typeReference);
			JvmType iterableType = typeReference.getOwner().getServices().getTypeReferences().findDeclaredType(Iterable.class, typeReference.getOwner().getContextResourceSet());
			if (iterableType instanceof JvmTypeParameterDeclarator) {
				JvmTypeParameter typeParameter = ((JvmTypeParameterDeclarator) iterableType).getTypeParameters().get(0);
				UnboundTypeParameterPreservingSubstitutor substitutor = new UnboundTypeParameterPreservingSubstitutor(parameterMapping, typeReference.getOwner());
				ParameterizedTypeReference unboundTypeParameter = new ParameterizedTypeReference(typeReference.getOwner(), typeParameter);
				LightweightTypeReference componentType = substitutor.substitute(unboundTypeParameter).getUpperBoundSubstitute();
				ArrayTypeReference array = new ArrayTypeReference(typeReference.getOwner(), componentType);
				return array;
			}
		}
		return null;
	}

	public ParameterizedTypeReference convertToList(ArrayTypeReference type) {
		LightweightTypeReference componentType = type.getComponentType();
		LightweightTypeReference wrapper = componentType.getWrapperTypeIfPrimitive();
		JvmType listType = type.getServices().getTypeReferences().findDeclaredType(List.class, type.getOwner().getContextResourceSet());
		ParameterizedTypeReference result = new ParameterizedTypeReference(type.getOwner(), listType);
		result.addTypeArgument(wrapper);
		return result;
	}

}
