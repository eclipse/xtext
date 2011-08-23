/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Primitives {
	
	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;
	
	@Inject
	private TypeReferences typeReferences;
	
	public void setTypeProviderFactory(IJvmTypeProvider.Factory typeProviderFactory) {
		this.typeProviderFactory = typeProviderFactory;
	}
	
	public static enum Primitive {
		Byte,Short,Char,Int,Long,Float,Double,Void, Boolean
	}
	
	public Primitive primitiveKind(JvmPrimitiveType primitiveType) {
		final String name = primitiveType.getIdentifier();
		if (Boolean.TYPE.getName().equals(name)) {
			return Primitive.Boolean;
		}
		if (Integer.TYPE.getName().equals(name)) {
			return Primitive.Int;
		}
		if (Byte.TYPE.getName().equals(name)) {
			return Primitive.Byte;
		}
		if (Short.TYPE.getName().equals(name)) {
			return Primitive.Short;
		}
		if (Character.TYPE.getName().equals(name)) {
			return Primitive.Char;
		}
		if (Long.TYPE.getName().equals(name)) {
			return Primitive.Long;
		}
		if (Float.TYPE.getName().equals(name)) {
			return Primitive.Float;
		}
		if (Double.TYPE.getName().equals(name)) {
			return Primitive.Double;
		}
		if (Void.TYPE.getName().equals(name)) {
			return Primitive.Void;
		}
		throw new IllegalArgumentException("Unkown primitive "+name);
	}
	
	public JvmTypeReference asWrapperTypeIfPrimitive(JvmTypeReference primitive) {
		if (primitive == null || !isPrimitive(primitive)) {
			return primitive;
		}
		return typeReferences.createTypeRef(getWrapperType((JvmPrimitiveType) primitive.getType()));
	}
	
	public JvmType getWrapperType(JvmPrimitiveType primitive) {
		switch (primitiveKind(primitive)) {
			case Byte :
				return getType(Byte.class, primitive);
			case Short :
				return getType(Short.class, primitive);
			case Char :
				return getType(Character.class, primitive);
			case Int :
				return getType(Integer.class, primitive);
			case Long :
				return getType(Long.class, primitive);
			case Float :
				return getType(Float.class, primitive);
			case Double :
				return getType(Double.class, primitive);
			case Boolean :
				return getType(Boolean.class, primitive);
			case Void :
				return getType(Void.class, primitive);
			default :
				throw new IllegalArgumentException("Not a primitive : "+primitive);
		}
	}

	protected JvmType getType(Class<?> class1, Notifier context) {
		ResourceSet resourceSet = EcoreUtil2.getResourceSet(context);
		if (resourceSet==null)
			// context may be null if the editor was closed too early
			return null;
		IJvmTypeProvider provider = typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		return provider.findTypeByName(class1.getCanonicalName());
	}
	
	public boolean isPrimitive(JvmTypeReference type) {
		return type!=null && type.getType() instanceof JvmPrimitiveType && !type.getType().eIsProxy();
	}

	public boolean isWrapperType(JvmTypeReference type) {
		JvmTypeReference result = asPrimitiveIfWrapperType(type);
		return result != type;
	}

	public JvmTypeReference asPrimitiveIfWrapperType(JvmTypeReference type) {
		if (typeReferences.is(type, Byte.class)) {
			return typeReferences.getTypeForName(Byte.TYPE, type.getType());
		} else if (typeReferences.is(type, Short.class)) {
			return typeReferences.getTypeForName(Short.TYPE, type.getType());
		} else if (typeReferences.is(type, Character.class)) {
			return typeReferences.getTypeForName(Character.TYPE, type.getType());
		} else if (typeReferences.is(type, Integer.class)) {
			return typeReferences.getTypeForName(Integer.TYPE, type.getType());
		} else if (typeReferences.is(type, Long.class)) {
			return typeReferences.getTypeForName(Long.TYPE, type.getType());
		} else if (typeReferences.is(type, Float.class)) {
			return typeReferences.getTypeForName(Float.TYPE, type.getType());
		} else if (typeReferences.is(type, Double.class)) {
			return typeReferences.getTypeForName(Double.TYPE, type.getType());
		} else if (typeReferences.is(type, Boolean.class)) {
			return typeReferences.getTypeForName(Boolean.TYPE, type.getType());
		} else if (typeReferences.is(type, Void.class)) {
			return typeReferences.getTypeForName(Void.TYPE, type.getType());
		}
		return type;
	}
}
