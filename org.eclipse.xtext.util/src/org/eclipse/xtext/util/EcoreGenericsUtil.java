/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EcoreGenericsUtil {

	public EClass getReferenceType(EReference reference, EClass context) {
		EGenericType genericType = reference.getEGenericType();
		if (genericType == null) {
			return reference.getEReferenceType();
		}
		EGenericType boundGenericType = getBoundGenericType(genericType, context);
		if (boundGenericType.getEClassifier() == null) {
			throw new IllegalStateException("Either typeParameter or eRawType must be set in EGenericType "
					+ genericType);
		}
		return (EClass) boundGenericType.getEClassifier();
	}

	public EGenericType getBoundGenericType(EGenericType genericType, EClass context) {
		ETypeParameter typeParameter = genericType.getETypeParameter();
		if (typeParameter != null) {
			// the reference type is a type parameter
			TypeBindingAcceptor typeBindingAcceptor = new TypeBindingAcceptor();
			addTypeParameterBindingsRecursively(context, typeBindingAcceptor);
			return typeBindingAcceptor.getBoundGenericType(typeParameter);
		} else {
			// the reference type is a generic type
			if (genericType.getEClassifier() == null) {
				throw new IllegalStateException("Either typeParameter or eRawType must be set in EGenericType "
						+ genericType);
			}
			return genericType;
		}
	}

	protected static void addTypeParameterBindingsRecursively(EClass context, TypeBindingAcceptor bindingAcceptor) {
		for (EGenericType genericSuperType : context.getEGenericSuperTypes()) {
			EClassifier rawSuperType = genericSuperType.getEClassifier();
			EList<EGenericType> typeArguments = genericSuperType.getETypeArguments();
			EList<ETypeParameter> typeParameters = rawSuperType.getETypeParameters();
			if (typeArguments.size() != typeParameters.size()) {
				throw new IllegalStateException(
						"Number of typeArguments does not match number of typeParameters in EGenericType "
								+ genericSuperType);
			}
			for (int i = 0; i < typeArguments.size(); ++i) {
				bindingAcceptor.accept(typeParameters.get(i), typeArguments.get(i));
			}
			if (rawSuperType instanceof EClass) {
				addTypeParameterBindingsRecursively((EClass) rawSuperType, bindingAcceptor);
			}
		}
	}

	protected static class TypeBindingAcceptor {
		private Map<ETypeParameter, EGenericType> bindings;

		public void accept(ETypeParameter typeParameter, EGenericType typeArgument) {
			if(bindings==null) {
				bindings = new HashMap<ETypeParameter, EGenericType>();
			}
			ETypeParameter replacedParameter = typeArgument.getETypeParameter();
			if (replacedParameter != null) {
				EGenericType existingBoundType = bindings.get(replacedParameter);
				if (existingBoundType != null) {
					bindings.remove(replacedParameter);
					bindings.put(typeParameter, existingBoundType);
					return;
				}
			} else {
				if (typeArgument.getEClassifier() == null) {
					throw new IllegalStateException("Either typeParameter or eClassifier must be set in ETypeArgument "
							+ typeArgument);
				}
			}
			bindings.put(typeParameter, typeArgument);
		}

		public EGenericType getBoundGenericType(ETypeParameter typeParameter) {
			if(bindings==null) 
				return null;
			return bindings.get(typeParameter);
		}
	}
}
