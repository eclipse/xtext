/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeConverter {

	@Inject
	private TypesService typesService;
	
	/**
	 * converts the toBeConverter type to something different.
	 * 
	 * this implementation converts any primitive types to theri wrapper types
	 * and any arrays X[]to corresponding java.util.List<X> types.
	 */
	public JvmTypeReference convert(JvmTypeReference toBeConverted, JvmTypeReference expected, EObject context) {
		if (toBeConverted.getType() instanceof JvmPrimitiveType) {
			return convertPrimitiveToWrapper((JvmPrimitiveType)toBeConverted.getType(), context);
		} 
		if (toBeConverted.getType() instanceof JvmArrayType) {
			return convertArrayToList((JvmArrayType)toBeConverted.getType(), expected ,context);
		}
		return toBeConverted;
	}
	
	protected JvmTypeReference convertArrayToList(JvmArrayType jvmArrayType, JvmTypeReference expected, EObject context) {
		return typesService.getTypeForName("java.util.List", context, convert(jvmArrayType.getComponentType(), expected, context));
	}

	protected JvmTypeReference convertPrimitiveToWrapper(JvmPrimitiveType type, EObject context) {
		return typesService.getTypeForName(getWrapperTypeName(type.getCanonicalName()), context);
	}
	
	protected String getWrapperTypeName(String primitiveTypeName) {
		if (primitiveTypeName.equals(Boolean.TYPE.getCanonicalName())) {
			return Boolean.class.getCanonicalName();
		} else if (primitiveTypeName.equals(Integer.TYPE.getCanonicalName())) {
			return Integer.class.getCanonicalName();
		} else if (primitiveTypeName.equals(Long.TYPE.getCanonicalName())) {
			return Long.class.getCanonicalName();
		} else if (primitiveTypeName.equals(Double.TYPE.getCanonicalName())) {
			return Double.class.getCanonicalName();
		} else if (primitiveTypeName.equals(Float.TYPE.getCanonicalName())) {
			return Float.class.getCanonicalName();
		} else if (primitiveTypeName.equals(Byte.TYPE.getCanonicalName())) {
			return Byte.class.getCanonicalName();
		} else if (primitiveTypeName.equals(Short.TYPE.getCanonicalName())) {
			return Short.class.getCanonicalName();
		} else if (primitiveTypeName.equals(Character.TYPE.getCanonicalName())) {
			return Character.class.getCanonicalName();
		} else {
			throw new IllegalArgumentException("Not a primitive : "+primitiveTypeName);
		}
	}

}
