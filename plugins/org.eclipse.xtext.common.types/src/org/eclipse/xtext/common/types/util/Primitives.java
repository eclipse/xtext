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
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Primitives {
	
	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;
	
	public void setTypeProviderFactory(IJvmTypeProvider.Factory typeProviderFactory) {
		this.typeProviderFactory = typeProviderFactory;
	}
	
	public static enum Primitive {
		Byte,Short,Char,Int,Long,Float,Double,Void, Boolean
	}
	
	public Primitive primitiveKind(JvmPrimitiveType primitiveType) {
		final String name = primitiveType.getCanonicalName();
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
	
	public JvmType getWrapperType(JvmPrimitiveType primitive) {
		switch (primitiveKind(primitive)) {
			case Byte :
				return getType(Byte.class, primitive);
			case Short :
				return getType( Short.class, primitive);
			case Char :
				return getType( Character.class, primitive);
			case Int :
				return getType( Integer.class, primitive);
			case Long :
				return getType( Long.class, primitive);
			case Float :
				return getType( Float.class, primitive);
			case Double :
				return getType( Double.class, primitive);
			case Boolean :
				return getType( Boolean.class, primitive);
			case Void :
				return getType( Void.class, primitive);
			default :
				throw new IllegalArgumentException("Not a primitive : "+primitive);
		}
	}

	protected JvmType getType(Class<?> class1, Notifier context) {
		ResourceSet resourceSet = EcoreUtil2.getResourceSet(context);
		if (resourceSet==null)
			throw new NullPointerException("context not contained in ResourceSet");
		IJvmTypeProvider provider = typeProviderFactory.createTypeProvider(resourceSet);
		return provider.findTypeByName(class1.getCanonicalName());
	}
}
