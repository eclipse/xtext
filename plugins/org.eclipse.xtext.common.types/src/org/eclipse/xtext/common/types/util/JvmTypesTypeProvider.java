/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.typing.AbstractTypeProvider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmTypesTypeProvider extends AbstractTypeProvider<JvmTypeReference> {
	
	
	protected JvmTypeReference _type(JvmField field, Context<JvmTypeReference> context) {
		return field.getType();
	}
	
	protected JvmTypeReference _type(JvmOperation operation, Context<JvmTypeReference> context) {
		return operation.getReturnType();
	}
	
	protected JvmTypeReference _type(JvmFormalParameter parameter, Context<JvmTypeReference> context) {
		return parameter.getParameterType();
	}
}
