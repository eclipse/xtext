/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtype.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.ClassURIHelper;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Procedures;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class XFunctionTypeRefs {

	private static final ClassURIHelper classURIHelper = new ClassURIHelper();

	private static final List<String> procedureURIs = new ArrayList<>();

	private static final List<String> functionURIs = new ArrayList<>();

	private static final String procedureURI = URIHelperConstants.PROTOCOL + ":" + URIHelperConstants.OBJECTS
			+ Procedures.class.getCanonicalName() + "#" + Procedures.class.getCanonicalName() + "$Procedure";

	private static final String functionURI = URIHelperConstants.PROTOCOL + ":" + URIHelperConstants.OBJECTS
			+ Functions.class.getCanonicalName() + "#" + Functions.class.getCanonicalName() + "$Function";

	static {
		for (int index = 0; index <= 6; index++) {
			procedureURIs.add(procedureURI + index);
			functionURIs.add(functionURI + index);
		}
	}

	public static URI computeTypeUri(boolean procedure, int functionParamCount) {
		return URI.createURI(buildUri(procedure, functionParamCount));
	}

	public static String buildUri(boolean procedure, int functionParamCount) {
		int paramCount = Math.min(6, functionParamCount);
		if (procedure) {
			return procedureURIs.get(paramCount);
		}
		return functionURIs.get(paramCount);
	}

	public static URI computeTypeUri(Class<?> topLevelClass) {
		return classURIHelper.getFullURI(topLevelClass);
	}

	public static JvmTypeReference wrapIfNecessary(JvmTypeReference reference, JvmType type) {
		if (type instanceof JvmPrimitiveType) {
			JvmType wrappedType = getWrappedType(type);
			if (wrappedType == null) {
				return reference;
			} else {
				JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
				result.setType(wrappedType);
				return result;
			}
		} else if (type instanceof JvmVoid) {
			if (!((JvmVoid) type).eIsProxy()) {
				JvmParameterizedTypeReference result = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
				result.setType(getType(Void.class, type));
				return result;
			}
		}
		return reference;
	}

	public static JvmType getWrappedType(JvmType type) {
		String name = type.getIdentifier();
		if ("int".equals(name)) {
			return getType(Integer.class, type);
		} else if ("boolean".equals(name)) {
			return getType(Boolean.class, type);
		} else if ("char".equals(name)) {
			return getType(Character.class, type);
		} else if ("long".equals(name)) {
			return getType(Long.class, type);
		} else if ("double".equals(name)) {
			return getType(Double.class, type);
		} else if ("byte".equals(name)) {
			return getType(Byte.class, type);
		} else if ("float".equals(name)) {
			return getType(Float.class, type);
		} else if ("short".equals(name)) {
			return getType(Short.class, type);
		}
		return null;
	}

	public static JvmType getType(Class<?> clazz, EObject context) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createJvmVoid();
		proxy.eSetProxyURI(computeTypeUri(clazz));
		return (JvmType) EcoreUtil.resolve(proxy, context);
	}
}
