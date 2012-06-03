/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import static org.eclipse.xtext.util.Strings.*;

import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
@Singleton
public class VisibilityService {

	@Inject
	private SuperTypeCollector superTypeCollector;

	@Inject
	private TypesFactory typesFactory;

	public void setSuperTypeCollector(SuperTypeCollector superTypeCollector) {
		this.superTypeCollector = superTypeCollector;
	}

	public void setTypesFactory(TypesFactory typesFactory) {
		this.typesFactory = typesFactory;
	}

	public boolean isVisible(final JvmMember jvmMember, JvmDeclaredType contextType) {
		if (jvmMember.getVisibility() == JvmVisibility.PUBLIC)
			return true;
		if (contextType == null) {
			return false;
		} else if (jvmMember.getVisibility() == JvmVisibility.DEFAULT) {
			if (jvmMember instanceof JvmDeclaredType) {
				return equal(((JvmDeclaredType) jvmMember).getPackageName(), contextType.getPackageName());
			} else {
				JvmDeclaredType declaringType = jvmMember.getDeclaringType();
				if (declaringType != null)
					return equal(declaringType.getPackageName(), contextType.getPackageName());
				return true;
			}
		} else if (contextType.equals(jvmMember.getDeclaringType())) {
			return true;
		} else {
			JvmParameterizedTypeReference typeReference = typesFactory.createJvmParameterizedTypeReference();
			typeReference.setType(contextType);
			Set<JvmType> rawTypes = superTypeCollector.collectSuperTypesAsRawTypes(typeReference);
			if (rawTypes.contains(jvmMember.getDeclaringType())) {
				return jvmMember.getVisibility() == JvmVisibility.PROTECTED;
			}
			return false;
		}
	}
}
