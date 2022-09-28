/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeScopes extends DelegatingScopes {

	public boolean isTypeScope(EReference reference) {
		return TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(reference.getEReferenceType());
	}

	/**
	 * @param resolvedTypes the currently known resolved types
	 */
	public IScope createTypeScope(EObject context, EReference reference, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		final IScope delegateScope = getScope(context, reference);
		return new NestedTypesScope(delegateScope, session);
	}

	public IScope createTypeScope(EObject context, EReference reference) {
		if (context.eClass() == TypesPackage.Literals.JVM_INNER_TYPE_REFERENCE) {
			JvmInnerTypeReference casted = (JvmInnerTypeReference) context;
			JvmParameterizedTypeReference outerType = casted.getOuter();
			JvmType outerRawType = outerType.getType();
			if (outerRawType instanceof JvmDeclaredType) {
				Iterable<JvmDeclaredType> nestedTypes = ((JvmDeclaredType) outerRawType).getAllNestedTypes();
				List<IEObjectDescription> descriptions = Lists.newArrayList();
				for(JvmDeclaredType nestedType: nestedTypes) {
					descriptions.add(EObjectDescription.create(nestedType.getSimpleName(), nestedType));
				}
				return new SimpleScope(descriptions);
			}
			return IScope.NULLSCOPE;
		} else {
			final IScope delegateScope = getScope(context, reference);
			return delegateScope;
		}
	}
	
}
