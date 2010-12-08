/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeConverter {

	private static final QualifiedName JAVA_UTIL_LIST = QualifiedName.create("java", "util", "List");

	@Inject
	private TypesService typesService;
	
	@Inject
	private IQualifiedNameConverter nameConverter;

	/**
	 * converts the toBeConverter type to something different.
	 * 
	 * this implementation converts any primitive types to their wrapper types and any arrays X[]to corresponding
	 * java.util.List<X> types.
	 */
	public JvmTypeReference convert(JvmTypeReference toBeConverted, final EObject context) {
		if (toBeConverted == null)
			return null;

		@SuppressWarnings("serial")
		EcoreUtil.Copier copier = new EcoreUtil.Copier(false, true) {
			@Override
			public EObject copy(EObject object) {
				if (object instanceof JvmTypeReference) {
					JvmTypeReference typeRef = (JvmTypeReference) object;
					if (typeRef.getType() instanceof JvmVoid) {
						return typesService.getTypeForName(
								nameConverter.toQualifiedName(Void.class.getCanonicalName()), context);
					}
					if (typeRef.getType() instanceof JvmPrimitiveType) {
						return convertPrimitiveToWrapper((JvmPrimitiveType) typeRef.getType(), context);
					}
					if (typeRef.getType() instanceof JvmArrayType) {
						return convertArrayToList((JvmArrayType) typeRef.getType(), context);
					}
				}
				return super.copy(object);
			}
		};
		JvmTypeReference copy = (JvmTypeReference) copier.copy(toBeConverted);
		copier.copyReferences();
		return copy;
	}
	
	protected JvmTypeReference convertArrayToList(JvmArrayType jvmArrayType, EObject context) {
		return typesService.getTypeForName(JAVA_UTIL_LIST, context, convert(jvmArrayType.getComponentType(), context));
	}

	protected JvmTypeReference convertPrimitiveToWrapper(JvmPrimitiveType type, EObject context) {
		// TODO: extract constants
		return typesService.getTypeForName(nameConverter.toQualifiedName(getWrapperTypeName(type.getCanonicalName())),
				context);
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
			throw new IllegalArgumentException("Not a primitive : " + primitiveTypeName);
		}
	}

}
