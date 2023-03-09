/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This class is not intended to be referenced by clients.
 */
public class WrapperTypeLookup {

	/* @Nullable */
	private static LightweightTypeReference findTopLevelType(LightweightTypeReference context, String typeName) {
		ITypeReferenceOwner owner = context.getOwner();
		ResourceSet resourceSet = owner.getContextResourceSet();
		Resource typeResource = resourceSet.getResource(URIHelperConstants.OBJECTS_URI.appendSegment(typeName), true);
		EList<EObject> contents = typeResource.getContents();
		if (contents.isEmpty()) {
			return null;
		}
		JvmType type = (JvmType) contents.get(0);
		if (type == null)
			return null;
		return owner.newParameterizedTypeReference(type);
	}
	
	/* @Nullable */
	public static LightweightTypeReference getWrapperType(LightweightTypeReference context, Primitive primitiveKind) {
		switch(primitiveKind) {
			case Boolean:
				return findTopLevelType(context, "java.lang.Boolean");
			case Byte:
				return findTopLevelType(context, "java.lang.Byte");
			case Char:
				return findTopLevelType(context, "java.lang.Character");
			case Double:
				return findTopLevelType(context, "java.lang.Double");
			case Float:
				return findTopLevelType(context, "java.lang.Float");
			case Int:
				return findTopLevelType(context, "java.lang.Integer");
			case Long:
				return findTopLevelType(context, "java.lang.Long");
			case Short:
				return findTopLevelType(context, "java.lang.Short");
			case Void:
				return findTopLevelType(context, "java.lang.Void");
			default:
				throw new IllegalArgumentException("Unknown primitive type: " + primitiveKind);
		}
	}
	
}
