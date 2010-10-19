/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmTypes {
	
	@Inject(optional=true)
	private TypesFactory typesFactory = TypesFactory.eINSTANCE;
	
	public JvmParameterizedTypeReference createJvmTypeReference(JvmType jvmType) {
		JvmParameterizedTypeReference typeRef = typesFactory.createJvmParameterizedTypeReference();
		typeRef.setType(jvmType);
		return typeRef;
	}
	
	public boolean equals(JvmTypeReference ref1, JvmTypeReference ref2) {
		return ref1.getCanonicalName().equals(ref2.getCanonicalName());
	}
	
}
