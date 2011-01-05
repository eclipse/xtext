/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.typing.AbstractTypeProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmTypesTypeProvider extends AbstractTypeProvider<JvmTypeReference> {
	
	@Inject
	private TypesFactory factory;
	
	protected JvmTypeReference _type(JvmConstructor constructor) {
		JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
		reference.setType(constructor.getDeclaringType());
		return reference;
	}
	
	protected JvmTypeReference _type(JvmField field) {
		return field.getType();
	}
	
	protected JvmTypeReference _type(JvmOperation operation) {
		return operation.getReturnType();
	}
	
	protected JvmTypeReference _type(JvmFormalParameter parameter) {
		return parameter.getParameterType();
	}
	
}
