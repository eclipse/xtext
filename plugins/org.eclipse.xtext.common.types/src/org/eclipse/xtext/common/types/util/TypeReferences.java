/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import static com.google.common.collect.Lists.*;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeReferences {

	@Inject
	private TypesFactory factory = TypesFactory.eINSTANCE;
	
	public JvmParameterizedTypeReference createTypeRef(JvmType type, JvmTypeReference... typeArgs) {
		List<JvmTypeReference> typeReferences = newArrayList();
		if (typeArgs!=null) {
			for (int i = 0; i < typeArgs.length; i++) {
				JvmTypeReference jvmTypeReference = typeArgs[i];
				typeReferences.add(EcoreUtil2.clone(jvmTypeReference));
			}
		}
		if (type instanceof JvmGenericType) {
			EList<JvmTypeParameter> list = ((JvmGenericType) type).getTypeParameters();
			if (!typeReferences.isEmpty() && list.size() != typeReferences.size()) {
				throw new IllegalArgumentException("The type " + type.getCanonicalName() + " expects " + list.size()
						+ " type arguments, but was " + typeReferences.size()
						+ ". Either pass zero arguments (raw type) or the correct number.");
			}
			// Raw type -> create type refereces to type param
			if (typeReferences.isEmpty() && !list.isEmpty()) {
				for (JvmTypeParameter typeParameter : list) {
					typeReferences.add(createTypeRef(typeParameter));
				}
			}
		}
		JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
		reference.setType(type);
		if (!typeReferences.isEmpty())
			reference.getArguments().addAll(typeReferences);
		return reference;
	}

	public JvmTypeReference getArgument(JvmTypeReference left, int index) {
		if (left.getType() instanceof JvmGenericType) {
			EList<JvmTypeParameter> typeParameters = ((JvmGenericType) left.getType()).getTypeParameters();
			if (typeParameters.size() <= index) {
				throw new IllegalArgumentException("The type " + left.getType().getCanonicalName()
						+ " cannot be parameterized with more than " + typeParameters.size() + " type arguments.");
			}
			if (left instanceof JvmParameterizedTypeReference) {
				EList<JvmTypeReference> arguments = ((JvmParameterizedTypeReference) left).getArguments();
				if (arguments.size() == typeParameters.size()) {
					return arguments.get(index);
				}
			}
			final JvmTypeParameter jvmTypeParameter = typeParameters.get(index);
			return createTypeRef(jvmTypeParameter);
		}
		throw new IllegalArgumentException(left.getType().getCanonicalName() + " is not generic.");
	}
	
}
