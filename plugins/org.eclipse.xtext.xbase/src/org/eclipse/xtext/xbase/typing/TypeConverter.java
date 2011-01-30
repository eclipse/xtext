/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xtype.XFunctionTypeRef;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeConverter {

	@Inject
	private TypesService typesService;
	
	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;
	
	@Inject
	private TypesFactory factory;

	/**
	 * converts the toBeConverter type to something different.
	 * 
	 * this implementation converts any primitive types to their wrapper types and any arrays X[]to corresponding
	 * java.util.List<X> types.
	 */
	public JvmTypeReference convert(JvmTypeReference type, final EObject context) {
		if (type == null)
			return null;
		
		if (type instanceof XFunctionTypeRef) {
			type = convertFunctionType((XFunctionTypeRef)type,context);
		}

		@SuppressWarnings("serial")
		EcoreUtil.Copier copier = new EcoreUtil.Copier(false, true) {
			@Override
			public EObject copy(EObject object) {
				if (object instanceof JvmTypeReference) {
					JvmTypeReference typeRef = (JvmTypeReference) object;
					if (typeRef.getType() instanceof JvmVoid) {
						return typesService.getTypeForName(Void.class, context);
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
		JvmTypeReference copy = (JvmTypeReference) copier.copy(type);
		copier.copyReferences();
		return copy;
	}
	
	protected JvmTypeReference convertFunctionType(XFunctionTypeRef functionType, EObject context) {
		IJvmTypeProvider provider = typeProviderFactory.createTypeProvider(context.eResource().getResourceSet());
		JvmType function = provider.findTypeByName(Functions.class.getName()+"$Function"+functionType.getParamTypes().size());
		JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
		reference.setType(function);
		for (JvmTypeReference ref : functionType.getParamTypes()) {
			reference.getArguments().add(EcoreUtil2.clone(ref));
		}
		reference.getArguments().add(EcoreUtil2.clone(functionType.getReturnType()));
		return reference;
	}

	protected JvmTypeReference convertArrayToList(JvmArrayType jvmArrayType, EObject context) {
		return typesService.getTypeForName(List.class, context, convert(jvmArrayType.getComponentType(), context));
	}

	protected JvmTypeReference convertPrimitiveToWrapper(JvmPrimitiveType type, EObject context) {
		return typesService.getTypeForName(getWrapperTypeName(type.getCanonicalName()),
				context);
	}

	protected Class<?> getWrapperTypeName(String primitiveTypeName) {
		if (primitiveTypeName.equals(Boolean.TYPE.getCanonicalName())) {
			return Boolean.class;
		} else if (primitiveTypeName.equals(Integer.TYPE.getCanonicalName())) {
			return Integer.class;
		} else if (primitiveTypeName.equals(Long.TYPE.getCanonicalName())) {
			return Long.class;
		} else if (primitiveTypeName.equals(Double.TYPE.getCanonicalName())) {
			return Double.class;
		} else if (primitiveTypeName.equals(Float.TYPE.getCanonicalName())) {
			return Float.class;
		} else if (primitiveTypeName.equals(Byte.TYPE.getCanonicalName())) {
			return Byte.class;
		} else if (primitiveTypeName.equals(Short.TYPE.getCanonicalName())) {
			return Short.class;
		} else if (primitiveTypeName.equals(Character.TYPE.getCanonicalName())) {
			return Character.class;
		} else {
			throw new IllegalArgumentException("Not a primitive : " + primitiveTypeName);
		}
	}

}
