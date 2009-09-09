/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.PrimitiveType;
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.TypesFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrimitiveTypeProvider implements IClasspathTypeProvider {

	public <T> Type createType(Class<T> clazz) {
		if (Void.TYPE.equals(clazz))
			return TypesFactory.eINSTANCE.createVoid();
		PrimitiveType result = TypesFactory.eINSTANCE.createPrimitiveType();
		result.setName(clazz.getName());
		return result;
	}

}
