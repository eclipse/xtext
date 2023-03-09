/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * Represents the context that defines a valid cluster of {@link LightweightTypeReference type references}. Clients
 * obtain an instance of the {@link ITypeReferenceOwner} by instantiating a {@link StandardTypeReferenceOwner} with a
 * given context ({@link ResourceSet}, {@link Resource} or {@link EObject}).
 * 
 * {@link ITypeReferenceOwner The owner} is used to create new type references from their EMF based counterparts (
 * {@link JvmTypeReference}, {@link JvmType}) or from their {@link Class} representations.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITypeReferenceOwner {
	
	/**
	 * Access to commonly used services for type references.
	 */
	CommonTypeComputationServices getServices();
	
	/**
	 * Returns the context resource set if any.
	 * May return null if there is no context information available.
	 * 
	 * In those cases, the owner is rather useless.
	 */
	ResourceSet getContextResourceSet();
	
	/**
	 * Creates a new {@link CompoundTypeReference} that is either a synonym
	 * or a multi type reference.
	 * 
	 * @param synonym whether it should be a synonym type reference.
	 */
	CompoundTypeReference newCompoundTypeReference(boolean synonym);
	
	/**
	 * Creates a new {@link ArrayTypeReference} with the given component type.
	 * 
	 * @throws IllegalArgumentException if the component type is not valid.
	 */
	ArrayTypeReference newArrayTypeReference(LightweightTypeReference componentTypeReference);
	
	/**
	 * Creates a new {@link WildcardTypeReference} without any upper or lower bounds.
	 * 
	 * Usually clients need to add those to make it a valid type reference. 
	 */
	WildcardTypeReference newWildcardTypeReference();
	
	/**
	 * Creates a new {@link ParameterizedTypeReference} from the given type. The type
	 * may either be a {@link JvmTypeParameter}, {@link JvmPrimitiveType}, {@link JvmDeclaredType}
	 * or {@link JvmVoid}. Other types are considered invalid and will cause an {@link IllegalArgumentException}
	 * to be thrown.
	 * 
	 * If the type is a non-static nested type, the produced type reference will be an
	 * {@link InnerTypeReference}.
	 * 
	 * The produced type reference does not have any type arguments. If the given type is generic,
	 * the returned type reference is a raw type.
	 * 
	 * @param type the raw type for the newly produced {@link ParameterizedTypeReference}
	 * @throws IllegalArgumentException if the type is a {@link JvmArrayType} or {@code null}.
	 */
	ParameterizedTypeReference newParameterizedTypeReference(JvmType type);
	
	/**
	 * Creates a new {@link InnerTypeReference}. Constraints apply as with {@link #newParameterizedTypeReference(JvmType)}.
	 * If {@code type} does not represent a non-static inner class, an exception is thrown.
	 * 
	 * This method produces references of the form {@code Outer<OuterParams>.Type}.
	 * 
	 * @param outer the outer type reference. 
	 * @param type the raw type for the newly produced {@link ParameterizedTypeReference}
	 * @throws IllegalArgumentException if the type is not a valid type for a {@link InnerTypeReference}.
	 */
	InnerTypeReference newParameterizedTypeReference(LightweightTypeReference outer, JvmType type);
	
	/**
	 * Creates a new {@link FunctionTypeReference} that is backed by the given type. Constraints apply
	 * as in {@link #newParameterizedTypeReference(JvmType)}.
	 * 
	 * Clients are responsible to pass a valid SAM type to {@link #newFunctionTypeReference(JvmType)}.
	 * 
	 * @param type the raw function type.
	 */
	FunctionTypeReference newFunctionTypeReference(JvmType type);
	
	/**
	 * Creates a new unnamed {@link UnknownTypeReference}.
	 */
	UnknownTypeReference newUnknownTypeReference();
	
	/**
	 * Creates a new named {@link UnknownTypeReference}.
	 */
	UnknownTypeReference newUnknownTypeReference(String name);

	/**
	 * Creates a new representation of the {@link AnyTypeReference any type}, e.g. the type of the 
	 * value {@code null}.
	 */
	AnyTypeReference newAnyTypeReference();
	
	/**
	 * Create a new {@link InnerFunctionTypeReference} that is backed by the given type and has to
	 * defined outer type. Constraints apply as in {@link #newFunctionTypeReference(JvmType)} and 
	 * {@link #newParameterizedTypeReference(LightweightTypeReference, JvmType)}.
	 * 
	 * @param outer the outer type reference. 
	 * @param type the raw type for the newly produced {@link ParameterizedTypeReference}
	 * @throws IllegalArgumentException if the type is not a valid type for a {@link InnerTypeReference}.
	 */
	InnerFunctionTypeReference newFunctionTypeReference(LightweightTypeReference outer, JvmType type);
	
	/**
	 * Creates a new type reference that points to the given type. If the type is a {@link JvmArrayType},
	 * an {@link ArrayTypeReference} is produced. The produced {@link LightweightTypeReference} does not
	 * have any type arguments. It is similar to a raw type reference except for cases where the type
	 * points to a {@link JvmTypeParameter} or an array of {@link JvmTypeParameter type parameters}. In
	 * those cases, the result is different form {@code toPlainTypeReference(JvmType).}
	 * {@link LightweightTypeReference#getRawTypeReference() getRawTypeReference()}.
	 * 
	 * @param type the type. May not be null.
	 */
	LightweightTypeReference toPlainTypeReference(JvmType type);
	
	/**
	 * Creates a new type reference that points to the given type. If the type is a {@link JvmArrayType},
	 * an {@link ArrayTypeReference} is produced. The produced {@link LightweightTypeReference} does have
	 * type arguments if the given type is generic or an array of a generic type. The type arguments point
	 * to the original type parameters.
	 * 
	 * Useful for later substitution of all type parameters.
	 * 
	 * @param type the raw type. May not be {@code null}.
	 */
	LightweightTypeReference toLightweightTypeReference(JvmType type);
	
	/**
	 * Transforms the given EMF based type reference to its equivalent in the {@link LightweightTypeReference}
	 * hierarchy.
	 * 
	 * @param type the type to convert. May not be {@code null}.
	 */
	LightweightTypeReference toLightweightTypeReference(JvmTypeReference type);
	
	/**
	 * Creates a reference to {@link Object} or returns an {@link UnknownTypeReference} if no
	 * JRE is available.
	 */
	LightweightTypeReference newReferenceToObject();
	
	/**
	 * Creates a wildcard reference to {@link Object} or returns a wildcard to an {@link UnknownTypeReference} if no
	 * JRE is available.
	 */
	WildcardTypeReference newWildcardExtendsObject();
	
	/**
	 * Creates a reference to the given class or returns an {@link UnknownTypeReference} if no
	 * JRE is available.
	 */
	LightweightTypeReference newReferenceTo(Class<?> type);
	
	/**
	 * Creates a reference to the given class or returns an {@link UnknownTypeReference} if no
	 * JRE is available. If the type is available, the given acceptor is used to initialize it further.
	 */
	LightweightTypeReference newReferenceTo(Class<?> type, TypeReferenceInitializer<? super ParameterizedTypeReference> init);
	
	/* ************************************************************************
	 * TODO move the following methods to a more suitable location if possible
	 * ************************************************************************/
	/**
	 * @throws UnsupportedOperationException if this owner is not capable of handling unbound type references.
	 */
	void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument);

	/**
	 * @throws UnsupportedOperationException if this owner is not capable of handling unbound type references.
	 */
	List<LightweightBoundTypeArgument> getAllHints(Object handle);

	/**
	 * @throws UnsupportedOperationException if this owner is not capable of handling unbound type references.
	 */
	boolean isResolved(Object handle);

	/**
	 * The currently known type parameters, e.g. the ones that should not be substituted.
	 */
	List<JvmTypeParameter> getDeclaredTypeParameters();

}
