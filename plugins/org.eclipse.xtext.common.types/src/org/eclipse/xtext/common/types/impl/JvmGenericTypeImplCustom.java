/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmGenericTypeImplCustom extends JvmGenericTypeImpl {
	
	protected Iterable<JvmTypeReference> extendedInterfaces;

	@Override
	public Iterable<JvmTypeReference> getExtendedInterfaces() {
		if (extendedInterfaces == null) {
			extendedInterfaces = Iterables.filter(getSuperTypes(), new Predicate<JvmTypeReference>() {
						public boolean apply(JvmTypeReference typeReference) {
							JvmType type = typeReference.getType();
							if (type instanceof JvmGenericType) {
								return ((JvmGenericType) type).isInterface();
							}
							return false;
						}
					});
		}
		return extendedInterfaces;
	}

	@Override
	public JvmTypeReference getExtendedClass() {
		for(JvmTypeReference candidate: getSuperTypes()) {
			if (candidate.getType() instanceof JvmGenericType && !((JvmGenericType) candidate.getType()).isInterface())
				return candidate;
		}
		return null;
	}

	@Override
	public boolean isInstantiateable() {
		return !isAbstract() && !isInterface();
	}

	@Override
	public boolean isAnonymous() {
		return simpleName.startsWith("$") && !(getDeclaringMember() instanceof JvmDeclaredType);
	}
	
	@Override
	public Iterable<JvmConstructor> getDeclaredConstructors() {
		return Iterables.filter(getMembers(), JvmConstructor.class);
	}

}
