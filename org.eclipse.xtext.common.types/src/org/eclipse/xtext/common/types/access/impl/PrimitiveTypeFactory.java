/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesFactory;

/**
 * A type factory that creates the {@link JvmType} representations
 * for Java primitive types.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrimitiveTypeFactory implements ITypeFactory<Class<?>, JvmType> {

	@Override
	public JvmType createType(Class<?> clazz) {
		if (Void.TYPE.equals(clazz))
			return TypesFactory.eINSTANCE.createJvmVoid();
		JvmPrimitiveType result = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		result.setSimpleName(clazz.getName());
		return result;
	}

}
