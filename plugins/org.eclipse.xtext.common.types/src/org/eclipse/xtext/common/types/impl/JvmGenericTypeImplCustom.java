/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class JvmGenericTypeImplCustom extends JvmGenericTypeImpl {
	
	protected Iterable<JvmType> extendedInterfaces;

	protected Iterable<JvmType> extendedClasses;

	@Override
	public Iterable<JvmType> getExtendedInterfaces() {
		if (extendedInterfaces == null) {
			extendedInterfaces = Iterables.transform(
					Iterables.filter(getSuperTypes(), new Predicate<JvmTypeReference>() {
						public boolean apply(JvmTypeReference typeReference) {
							JvmType type = typeReference.getType();
							if (type instanceof JvmGenericType) {
								return ((JvmGenericType) type).isInterface();
							}
							return false;
						}
					}), new Function<JvmTypeReference, JvmType>() {
						public JvmType apply(JvmTypeReference from) {
							return from.getType();
						}
					});
		}
		return extendedInterfaces;
	}

	@Override
	public Iterable<JvmType> getExtendedClasses() {
		if (extendedClasses == null) {
			extendedClasses = Iterables.transform(Iterables.filter(getSuperTypes(), new Predicate<JvmTypeReference>() {
				public boolean apply(JvmTypeReference typeReference) {
					JvmType type = typeReference.getType();
					if (type instanceof JvmGenericType) {
						return !((JvmGenericType) type).isInterface();
					}
					return false;
				}
			}), new Function<JvmTypeReference, JvmType>() {
				public JvmType apply(JvmTypeReference from) {
					return from.getType();
				}
			});
		}
		return extendedClasses;
	}

	@Override
	public boolean isInstantiateable() {
		return !isAbstract() && !isInterface();
	}

	@Override
	public String getCanonicalName() {
		return fullyQualifiedName;
	}
	
	@Override
	public Iterable<JvmConstructor> getDeclaredConstructors() {
		return Iterables.filter(getMembers(), JvmConstructor.class);
	}

}
