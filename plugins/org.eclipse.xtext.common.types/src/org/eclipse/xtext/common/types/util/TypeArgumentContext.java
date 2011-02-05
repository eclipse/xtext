/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider.Factory;
import org.eclipse.xtext.util.Wrapper;


/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class TypeArgumentContext {

	private Map<JvmTypeParameter, JvmTypeReference> context;
	private Factory typeProviderFactory;
	private TypeReferences typeReferences;
	
	public TypeArgumentContext(Map<JvmTypeParameter, JvmTypeReference> context, IJvmTypeProvider.Factory typeProviderFactory, TypeReferences typeReferences) {
		if (context==null)
			throw new NullPointerException("context");
		if (typeProviderFactory==null)
			throw new NullPointerException("typeProviderFactory");
		if (typeReferences==null)
			throw new NullPointerException("typeReferences");
		this.context = context;
		this.typeProviderFactory = typeProviderFactory;
		this.typeReferences = typeReferences;  
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
	public JvmTypeReference getUpperBound(JvmTypeReference element, Notifier context) {
		JvmTypeReference copy = doGetResolvedCopy(element, Wrapper.wrap(Boolean.FALSE));
		if (copy instanceof JvmWildcardTypeReference) {
			for(JvmTypeConstraint constraint: ((JvmWildcardTypeReference) copy).getConstraints()) {
				if (constraint instanceof JvmUpperBound)
					return constraint.getTypeReference();
			}
			// no explicit upper bound given - return object
			IJvmTypeProvider provider = typeProviderFactory.createTypeProvider(getResourceSet(context));
			JvmType objectType = provider.findTypeByName(Object.class.getCanonicalName());
			return typeReferences.createTypeRef(objectType);
		}
		return copy;
	}
	
	protected ResourceSet getResourceSet(Notifier context2) {
		if (context2 == null)
			throw new NullPointerException("the passed context needs to be a or be contained in a ResourceSet.");
		ResourceSet resourceSet = EcoreUtil2.getResourceSet(context2);
		if (resourceSet!=null)
			return resourceSet;
		throw new IllegalArgumentException(" a notifier must be either an EObject, a Resource or a ResourceSet");
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
				return typeReferences.createTypeRef(element.getType());
			} else if (element instanceof JvmWildcardTypeReference) {
				for(JvmTypeConstraint constraint: ((JvmWildcardTypeReference) copy).getConstraints()) {
					if (constraint instanceof JvmUpperBound) {
						return typeReferences.createTypeRef(constraint.getTypeReference().getType());
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
							if (resolved.getType() == type) {
								return resolved;
							}
							return resolveTypeParameters(resolved);
						} else {
							// raw type - return object reference
							foundRawType.set(Boolean.TRUE);
							return typeReferences.createTypeRef(type);
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


}
