/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.List;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.ExpectationTypeParameterHintCollector;

import com.google.inject.Inject;

/**
 * Base class for type computers, e.g. the {@link XbaseTypeComputer} or the {@link CollectionLiteralsTypeComputer}.
 * 
 * Offers access to the common services along with a few useful methods that allow to obtain type references
 * for classes.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
public class AbstractTypeComputer {

	@Inject
	private CommonTypeComputationServices services;

	/* @NotNull */
	protected LightweightTypeReference getTypeForName(Class<?> clazz, ITypeComputationState state) {
		JvmType type = findDeclaredType(clazz, state);
		ITypeReferenceOwner owner = state.getReferenceOwner();
		if (type == null) {
			return owner.newUnknownTypeReference(clazz.getName());
		}
		return owner.toLightweightTypeReference(type);
	}

	/* @NotNull */
	/**
	 * @see #findDeclaredType(String, ITypeReferenceOwner)
	 * @since 2.14
	 */
	protected LightweightTypeReference getTypeForName(String clazzName, ITypeComputationState state) {
		JvmType type = findDeclaredType(clazzName, state);
		ITypeReferenceOwner owner = state.getReferenceOwner();
		if (type == null) {
			return owner.newUnknownTypeReference(clazzName);
		}
		return owner.toLightweightTypeReference(type);
	}

	protected LightweightTypeReference getRawTypeForName(Class<?> clazz, ITypeComputationState state) {
		return state.getReferenceOwner().newReferenceTo(clazz);
	}

	/**
	 * @since 2.14
	 */
	protected LightweightTypeReference getRawTypeForName(String clazzName, ITypeComputationState state) {
		JvmType rawType = findDeclaredType(clazzName, state);
		if (rawType == null) {
			return state.getReferenceOwner().newUnknownTypeReference(clazzName);
		}
		return state.getReferenceOwner().toPlainTypeReference(rawType);
	}

	/**
	 * @deprecated use {@link ITypeReferenceOwner#newReferenceTo(Class)} instead.
	 */
	/* @NotNull */
	@Deprecated
	protected LightweightTypeReference getRawTypeForName(Class<?> clazz, ITypeReferenceOwner owner) {
		return owner.newReferenceTo(clazz);
	}

	/* @Nullable */
	protected <Type extends JvmType> Type findDeclaredType(Class<?> clazz, ITypeComputationState state) {
		return findDeclaredType(clazz, state.getReferenceOwner());
	}

	/* @Nullable */
	/**
	 * @see #findDeclaredType(String, ITypeReferenceOwner)
	 * @since 2.14
	 */
	protected <Type extends JvmType> Type findDeclaredType(String clazzName, ITypeComputationState state) {
		return findDeclaredType(clazzName, state.getReferenceOwner());
	}

	/* @Nullable */
	protected <Type extends JvmType> Type findDeclaredType(Class<?> clazz, ITypeReferenceOwner owner) {
		@SuppressWarnings("unchecked")
		Type result = (Type) services.getTypeReferences().findDeclaredType(clazz, owner.getContextResourceSet());
		return result;
	}

	/* @Nullable */
	/**
	 * @param clazzName FQN of the type to find. see {@link org.eclipse.xtext.common.types.access.IJvmTypeProvider#findTypeByName(String)}.
	 * @param owner the reference owner
	 * 
	 * @since 2.14
	 */
	protected <Type extends JvmType> Type findDeclaredType(String clazzName, ITypeReferenceOwner owner) {
		@SuppressWarnings("unchecked")
		Type result = (Type) services.getTypeReferences().findDeclaredType(clazzName, owner.getContextResourceSet());
		return result;
	}
	
	/* @NotNull */
	protected LightweightTypeReference getPrimitiveVoid(ITypeComputationState state) {
		return state.getReferenceOwner().newReferenceTo(Void.TYPE);
	}
	
	/**
	 * Computes the common super type for the given list of types. The list may not be empty.
	 */
	protected LightweightTypeReference getCommonSuperType(List<LightweightTypeReference> types, ITypeComputationState state) {
		return getCommonSuperType(types, state.getReferenceOwner());
	}

	/**
	 * Computes the common super type for the given list of types. The list may not be empty.
	 */
	protected LightweightTypeReference getCommonSuperType(List<LightweightTypeReference> types, ITypeReferenceOwner owner) {
		return services.getTypeConformanceComputer().getCommonSuperType(types, owner);
	}

	protected void deferredBindTypeArgument(/* @Nullable */ LightweightTypeReference declared, LightweightTypeReference actual, ITypeComputationState state) {
		if (declared != null && actual != null) { 
			// TODO double check other clients of the ExpectationTypeParameterHintCollector
			// It may be possible / necessary to use the very same implementation instead of anonymous 
			// specializations or it may be possible that this specialization is no longer necessary.
			ExpectationTypeParameterHintCollector collector = new ResolvingTypeParameterHintCollector(state.getReferenceOwner(), BoundTypeArgumentSource.INFERRED);
			collector.processPairedReferences(declared, actual.getWrapperTypeIfPrimitive());
		}
	}
	
}
