/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Collection;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.XComputedTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDocs
 */
public final class UnboundTypeParameters {
	
	private UnboundTypeParameters() {
		throw new UnsupportedOperationException();
	}
	
	public static JvmTypeParameter findMappedParameter(JvmTypeParameter parameter,
			Map<JvmTypeParameter, MergedBoundTypeArgument> mapping, Collection<JvmTypeParameter> visited) {
		for(Map.Entry<JvmTypeParameter, MergedBoundTypeArgument> entry: mapping.entrySet()) {
			JvmTypeReference reference = entry.getValue().getTypeReference();
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
	
	public static boolean isUnboundTypeParameter(XComputedTypeReference reference) {
		if (reference.eIsSet(TypesPackage.Literals.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT))
			return false;
		IJvmTypeReferenceProvider typeProvider = reference.getTypeProvider();
		if (typeProvider instanceof UnboundTypeParameter) {
			boolean result = !((UnboundTypeParameter) typeProvider).isComputed();
			return result;
		}
		return false;
	}

	public static boolean isUnboundAndEqual(UnboundTypeParameter typeParameter, JvmTypeReference reference) {
		if (reference instanceof XComputedTypeReference) {
			XComputedTypeReference computed = (XComputedTypeReference) reference;
			if (UnboundTypeParameters.isUnboundTypeParameter(computed)) {
				UnboundTypeParameter unbound = (UnboundTypeParameter) computed.getTypeProvider();
				if (unbound.equals(typeParameter)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
