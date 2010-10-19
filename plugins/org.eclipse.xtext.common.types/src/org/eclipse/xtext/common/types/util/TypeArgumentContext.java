/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.collect.Maps;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeArgumentContext {

	private Map<JvmTypeParameter, JvmTypeReference> context;

	public TypeArgumentContext(Map<JvmTypeParameter, JvmTypeReference> context) {
		this.context = context;
	}

	public JvmTypeReference getBoundArgument(JvmTypeParameter param) {
		JvmTypeReference jvmTypeArgument = context.get(param);
		return jvmTypeArgument;
	}
	
	@SuppressWarnings("serial")
	public JvmTypeReference resolve(JvmTypeReference element) {
		EcoreUtil.Copier copier = new EcoreUtil.Copier(false,true) {
			@Override
			public EObject copy(EObject arg0) {
				if (arg0 instanceof JvmParameterizedTypeReference) {
					JvmParameterizedTypeReference parameterizedTypeRef = (JvmParameterizedTypeReference) arg0;
					JvmType type = parameterizedTypeRef.getType();
					if (type instanceof JvmTypeParameter) {
						JvmTypeReference resolved = TypeArgumentContext.this.getBoundArgument((JvmTypeParameter) type);
						if (resolved!=null) {
							arg0 = resolve(resolved);
						}
					}
				}
				return super.copy(arg0);
			}
		};
		JvmTypeReference copy = (JvmTypeReference) copier.copy(element);
		copier.copyReferences();
		return copy;
		
	}
	

	public static class Provider {
		
		public TypeArgumentContext get(JvmTypeReference contextRef) {
			Map<JvmTypeParameter, JvmTypeReference> context = Maps.newHashMap();
			internalComputeContext(contextRef, context);
			return new TypeArgumentContext(context);
		}

		protected void internalComputeContext(JvmTypeReference contextRef,
				Map<JvmTypeParameter, JvmTypeReference> context) {
			if (contextRef instanceof JvmParameterizedTypeReference) {
				JvmParameterizedTypeReference typeRef = (JvmParameterizedTypeReference) contextRef;
				for (int i = 0; i < typeRef.getArguments().size(); i++) {
					JvmTypeReference argument = typeRef.getArguments().get(i);
					JvmTypeParameter param = ((JvmGenericType) typeRef.getType()).getTypeParameters().get(i);
					context.put(param, argument);
				}
			}
			JvmType type = contextRef.getType();
			if (type instanceof JvmDeclaredType) {
				JvmDeclaredType declaredType = (JvmDeclaredType) type;
				EList<JvmTypeReference> superTypes = declaredType.getSuperTypes();
				for (JvmTypeReference jvmTypeReference : superTypes) {
					internalComputeContext(jvmTypeReference, context);
				}
			}
		}
	}
}
