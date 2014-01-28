/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.xbase.typesystem.util.RecursionGuard;

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
		ArrayTypeReference result = doTryConvertToArray(typeReference);
		if (result != null) {
			return result;
		} else {
			JvmType type = typeReference.getType();
			if (type.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
				return doTryConvertToArray(typeReference, new RecursionGuard<JvmTypeParameter>());
			}
		}
		return null;
	}
	
	/**
	 * This handles bogus constraint definitions, e.g. 
	 * <ul>
	 * 	<li>{@code T extends String[]},</li>
	 * 	<li>{@code T extends V[]}, or</li>
	 * 	<li>{@code T extends V, V extends String[]}</li>
	 * </ul>
	 */
	@Nullable
	private ArrayTypeReference doTryConvertToArray(ParameterizedTypeReference typeReference, RecursionGuard<JvmTypeParameter> recursionGuard) {
		JvmType type = typeReference.getType();
		if (recursionGuard.tryNext((JvmTypeParameter) type)) {
			List<LightweightTypeReference> superTypes = typeReference.getSuperTypes();
			for(int i = 0, size = superTypes.size(); i < size; i++) {
				LightweightTypeReference superType = superTypes.get(i);
				if (superType.isArray()) {
					return (ArrayTypeReference) superType;
				}
				ArrayTypeReference result = doTryConvertToArray(typeReference);
				if (result != null) {
					return result;
				} else {
					JvmType rawSuperType = superType.getType();
					if (rawSuperType != null && rawSuperType.eClass() == TypesPackage.Literals.JVM_TYPE_PARAMETER) {
						result = doTryConvertToArray((ParameterizedTypeReference) superType, recursionGuard);
						if (result != null)
							return result;
					}
				}
			}
		}
		return null;
	}

	@Nullable
	private ArrayTypeReference doTryConvertToArray(ParameterizedTypeReference typeReference) {
		LightweightTypeReference parameterizedIterable = typeReference.getSuperType(Iterable.class);
		if (parameterizedIterable != null) {
			ITypeReferenceOwner owner = typeReference.getOwner();
			if (parameterizedIterable.isRawType()) {
				// return Object[]
				LightweightTypeReference objectType = parameterizedIterable.getSuperTypes().get(0);
				ArrayTypeReference array = new ArrayTypeReference(owner, objectType);
				return array;
			} else {
				LightweightTypeReference componentType = parameterizedIterable.getTypeArguments().get(0).getUpperBoundSubstitute();
				ArrayTypeReference array = new ArrayTypeReference(owner, componentType);
				return array;
			}
		}
		return null;
	}

	public LightweightTypeReference convertToList(ArrayTypeReference type) {
		LightweightTypeReference componentType = type.getComponentType();
		LightweightTypeReference wrapper = componentType.getWrapperTypeIfPrimitive();
		JvmType listType = type.getServices().getTypeReferences().findDeclaredType(List.class, type.getOwner().getContextResourceSet());
		if (listType == null) {
			return new UnknownTypeReference(type.getOwner(), List.class.getName());
		}
		ParameterizedTypeReference result = new ParameterizedTypeReference(type.getOwner(), listType);
		result.addTypeArgument(wrapper);
		return result;
	}

}
