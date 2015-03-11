/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

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
	
	protected LightweightTypeReference getTypeForName(Class<?> clazz, ITypeComputationState state) {
		ResourceSet resourceSet = state.getReferenceOwner().getContextResourceSet();
		JvmTypeReference typeReference = services.getTypeReferences().getTypeForName(clazz, resourceSet);
		if (typeReference == null) {
			return state.getReferenceOwner().newUnknownTypeReference(clazz.getName());
		}
		return state.getReferenceOwner().toLightweightTypeReference(typeReference);
	}
	
	protected LightweightTypeReference getRawTypeForName(Class<?> clazz, ITypeReferenceOwner owner) {
		JvmType clazzType = findDeclaredType(clazz, owner);
		if (clazzType == null) {
			return owner.newUnknownTypeReference(clazz.getName());
		}
		LightweightTypeReference result = owner.toPlainTypeReference(clazzType);
		return result;
	}
	
	protected <Type extends JvmType> Type findDeclaredType(Class<?> clazz, ITypeComputationState state) {
		return findDeclaredType(clazz, state.getReferenceOwner());
	}

	protected <Type extends JvmType> Type findDeclaredType(Class<?> clazz, ITypeReferenceOwner owner) {
		@SuppressWarnings("unchecked")
		Type result = (Type) services.getTypeReferences().findDeclaredType(clazz, owner.getContextResourceSet());
		return result;
	}
	
	protected LightweightTypeReference getPrimitiveVoid(ITypeComputationState state) {
		return getRawTypeForName(Void.TYPE, state.getReferenceOwner());
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
	
}
