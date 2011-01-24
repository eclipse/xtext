/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.util.Wrapper;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class TypeArgumentContext {

	private Map<JvmTypeParameter, JvmTypeReference> context;
	
	private JvmDeclaredType objectType;

	public TypeArgumentContext(Map<JvmTypeParameter, JvmTypeReference> context, JvmDeclaredType objectType) {
		if (context==null)
			throw new NullPointerException("context");
		if (objectType==null)
			throw new NullPointerException("objectType");
		this.context = context;
		this.objectType = objectType;
	}

	public JvmTypeReference getBoundArgument(JvmTypeParameter param) {
		JvmTypeReference jvmTypeArgument = context.get(param);
		return jvmTypeArgument;
	}
	
	/**
	 * Resolve the reference for a contravariant location, i.e. returns the lower bound.
	 * @return the lower bound of a reference or <code>null</code> if there is no lower bound.
	 */
	public JvmTypeReference getLowerBound(JvmTypeReference element) {
		JvmTypeReference copy = doGetResolvedCopy(element, Wrapper.wrap(Boolean.FALSE));
		if (copy instanceof JvmWildcardTypeReference) {
			for(JvmTypeConstraint constraint: ((JvmWildcardTypeReference) copy).getConstraints()) {
				if (constraint instanceof JvmLowerBound) {
					JvmTypeReference lowerBound = constraint.getTypeReference();
					return lowerBound;
				}
			}
			// only upper bounds set - no valid contravariant value 
			return null;
		}
		return copy;
	}
	
	/**
	 * Resolve the reference for a covariant location, i.e. returns the upper bound.
	 * @return the upper bound of a reference.
	 */
	public JvmTypeReference getUpperBound(JvmTypeReference element) {
		JvmTypeReference copy = doGetResolvedCopy(element, Wrapper.wrap(Boolean.FALSE));
		if (copy instanceof JvmWildcardTypeReference) {
			for(JvmTypeConstraint constraint: ((JvmWildcardTypeReference) copy).getConstraints()) {
				if (constraint instanceof JvmUpperBound)
					return constraint.getTypeReference();
			}
			// no explicit upper bound given - return object
			JvmParameterizedTypeReference result = createTypeReference();
			result.setType(objectType);
			return result;
		}
		return copy;
	}
	
	/**
	 * Resolves and returns the reference
	 * @return the resolved reference.
	 */
	public JvmTypeReference resolve(JvmTypeReference element) {
		Wrapper<Boolean> foundRawType = Wrapper.wrap(Boolean.FALSE);
		JvmTypeReference copy = doGetResolvedCopy(element, foundRawType);
		if (foundRawType.get()) {
			if (element instanceof JvmParameterizedTypeReference) {
				JvmParameterizedTypeReference result = createTypeReference();
				result.setType(element.getType());
				return result;
			} else if (element instanceof JvmWildcardTypeReference) {
				for(JvmTypeConstraint constraint: ((JvmWildcardTypeReference) copy).getConstraints()) {
					if (constraint instanceof JvmUpperBound) {
						JvmParameterizedTypeReference result = createTypeReference();
						result.setType(constraint.getTypeReference().getType());
						return result;
					}
				}
			}
		}
		return copy;
	}

	protected JvmTypeReference doGetResolvedCopy(JvmTypeReference element, final Wrapper<Boolean> foundRawType) {
		@SuppressWarnings("serial")
		EcoreUtil.Copier copier = new EcoreUtil.Copier(false,true) {
			@Override
			public EObject copy(EObject object) {
				EObject resolvedObject = resolveTypeParameters(object); 
				EObject result = super.copy(resolvedObject);
				return result;
			}

			protected EObject resolveTypeParameters(EObject object) {
				if (object instanceof JvmParameterizedTypeReference) {
					JvmParameterizedTypeReference parameterizedTypeRef = (JvmParameterizedTypeReference) object;
					JvmType type = parameterizedTypeRef.getType();
					if (type instanceof JvmTypeParameter) {
						JvmTypeReference resolved = TypeArgumentContext.this.getBoundArgument((JvmTypeParameter) type);
						if (resolved!=null) {
							return resolveTypeParameters(resolved);
						} else {
							// raw type - return object reference
							foundRawType.set(Boolean.TRUE);
							JvmParameterizedTypeReference result = createTypeReference();
							result.setType(objectType);
							return result;
						}
					}
				}
				return object;
			}
		};
		JvmTypeReference copy = (JvmTypeReference) copier.copy(element);
		copier.copyReferences();
		return copy;
	}
	
	protected JvmParameterizedTypeReference createTypeReference() {
		TypesFactory factory = (TypesFactory) objectType.eClass().getEPackage().getEFactoryInstance();
		JvmParameterizedTypeReference result = factory.createJvmParameterizedTypeReference();
		return result;
	}

	public static class Provider {
		
		@Inject
		private IJvmTypeProvider.Factory typeProviderFactory;

		public void setTypeProviderFactory(IJvmTypeProvider.Factory typeProviderFactory) {
			this.typeProviderFactory = typeProviderFactory;
		}
		
		public Provider() {
		}
		
		public TypeArgumentContext get(JvmTypeReference contextRef) {
			if (contextRef==null)
				throw new NullPointerException("contextReference");
			Map<JvmTypeParameter, JvmTypeReference> context = Maps.newHashMap();
			JvmDeclaredType objectType = internalComputeContext(contextRef, context);
			if (objectType==null) {
				IJvmTypeProvider provider = typeProviderFactory.createTypeProvider(contextRef.getType().eResource().getResourceSet());
				objectType = (JvmDeclaredType) provider.findTypeByName(Object.class.getCanonicalName());
			}
			return new TypeArgumentContext(context, objectType);
		}

		protected JvmDeclaredType internalComputeContext(JvmTypeReference contextRef, Map<JvmTypeParameter, JvmTypeReference> context) {
			if (contextRef instanceof JvmParameterizedTypeReference) {
				JvmParameterizedTypeReference typeRef = (JvmParameterizedTypeReference) contextRef;
				if (typeRef.getType() instanceof JvmTypeParameterDeclarator) {
					List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) typeRef.getType()).getTypeParameters();
					List<JvmTypeReference> typeArguments = typeRef.getArguments();
					if (!typeArguments.isEmpty()) {
						// parameterized type reference
						for (int i = 0; i < typeArguments.size(); i++) {
							JvmTypeReference argument = typeArguments.get(i);
							JvmTypeParameter param = typeParameters.get(i);
							context.put(param, argument);
						}
					}
				}
			}
			JvmType type = contextRef.getType();
			if (type instanceof JvmDeclaredType) {
				JvmDeclaredType declaredType = (JvmDeclaredType) type;
				if (Object.class.getCanonicalName().equals(declaredType.getCanonicalName()))
					return declaredType;
				List<JvmTypeReference> superTypes = declaredType.getSuperTypes();
				if (superTypes.isEmpty())
					return null;
				JvmDeclaredType result = null;
				for (JvmTypeReference jvmTypeReference : superTypes) {
					JvmDeclaredType temp = internalComputeContext(jvmTypeReference, context);
					if (temp != null)
						result = temp;
				}
				return result;
			}
			throw new IllegalArgumentException("contextRef didn't point to a declared type : "+contextRef);
		}
	}
}
