/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import static com.google.common.collect.Lists.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.ClassURIHelper;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeReferences {
	
	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(TypeReferences.class);

	@Inject
	private TypesFactory factory = TypesFactory.eINSTANCE;
	
	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;
	
	@Inject
	private ClassURIHelper uriHelper;
	
	@Inject
	private SuperTypeCollector superTypeCollector;
	
	// TODO we need #getRawType(s) on the JvmTypeReference in order to deal with custom reference implementations
	// e.g. JvmMultiTypeReference et al
	public JvmType getRawType(JvmTypeReference reference) {
		if (reference instanceof JvmParameterizedTypeReference) {
			JvmType rawType = reference.getType();
			if (rawType instanceof JvmTypeParameter) {
				// TODO handle multiple upper bounds
				// TODO use object if only lower bounds were present (robustness)
				List<JvmTypeConstraint> constraints = ((JvmTypeParameter) rawType).getConstraints();
				for (JvmTypeConstraint constraint : constraints) {
					if (constraint instanceof JvmUpperBound) {
						JvmTypeReference upperBound = constraint.getTypeReference();
						return getRawType(upperBound);
					}
				}
				// no upper bound found
				return findDeclaredType(Object.class, rawType);
			}
			return rawType;
		} else if (reference instanceof JvmGenericArrayTypeReference) {
			JvmTypeReference componentTypeReference = ((JvmGenericArrayTypeReference) reference).getComponentType();
			JvmType rawComponentType = getRawType(componentTypeReference);
			if (rawComponentType instanceof JvmComponentType && !rawComponentType.eIsProxy())
				return ((JvmComponentType) rawComponentType).getArrayType();
			return null;
		} else if (reference instanceof JvmWildcardTypeReference) {
			List<JvmTypeConstraint> constraints = ((JvmWildcardTypeReference) reference).getConstraints();
			// TODO handle multiple upper bounds
			// TODO use object if only lower bounds were present (robustness)
			for (JvmTypeConstraint constraint : constraints) {
				if (constraint instanceof JvmUpperBound) {
					JvmTypeReference upperBound = constraint.getTypeReference();
					return getRawType(upperBound);
				}
			}
			return null;
		}
		return null;
	}
	
	public JvmAnyTypeReference createAnyTypeReference(EObject context) {
		JvmAnyTypeReference result = factory.createJvmAnyTypeReference();
		result.setType(findDeclaredType(Object.class, context));
		return result;
	}
	
	public JvmMultiTypeReference createMultiTypeReference(EObject context, JvmTypeReference... references) {
		 JvmMultiTypeReference result = factory.createJvmMultiTypeReference();
		 if (references != null && references.length != 0) {
			 result.getReferences().addAll(Arrays.asList(references));
		 }
		 result.setType(findDeclaredType(Object.class, context));
		 return result;
	}
	
	public JvmParameterizedTypeReference createTypeRef(JvmType type, JvmTypeReference... typeArgs) {
		List<JvmTypeReference> typeReferences = Collections.emptyList();
		if (typeArgs!=null && typeArgs.length > 0) {
			typeReferences = newArrayListWithCapacity(typeArgs.length);
			for (int i = 0; i < typeArgs.length; i++) {
				JvmTypeReference jvmTypeReference = typeArgs[i];
				typeReferences.add(EcoreUtil2.clone(jvmTypeReference));
			}
		}
		if (type instanceof JvmGenericType) {
			List<JvmTypeParameter> list = ((JvmGenericType) type).getTypeParameters();
			if (!typeReferences.isEmpty() && list.size() != typeReferences.size()) {
				throw new IllegalArgumentException("The type " + type.getIdentifier() + " expects " + list.size()
						+ " type arguments, but was " + typeReferences.size()
						+ ". Either pass zero arguments (raw type) or the correct number.");
			}
			// Raw type -> create type references to type param
			if (typeReferences.isEmpty() && !list.isEmpty()) {
				typeReferences = newArrayListWithCapacity(list.size());
				for (JvmTypeParameter typeParameter : list) {
					typeReferences.add(createTypeRef(typeParameter));
				}
			}
		}
		JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
		reference.setType(type);
		if (!typeReferences.isEmpty())
			reference.getArguments().addAll(typeReferences);
		return reference;
	}

	public JvmTypeReference getArgument(JvmTypeReference left, int index) {
		if (left.getType() instanceof JvmGenericType) {
			List<JvmTypeParameter> typeParameters = ((JvmGenericType) left.getType()).getTypeParameters();
			if (typeParameters.size() <= index) {
				throw new IllegalArgumentException("The type " + left.getType().getIdentifier()
						+ " cannot be parameterized with more than " + typeParameters.size() + " type arguments.");
			}
			if (left instanceof JvmParameterizedTypeReference) {
				List<JvmTypeReference> arguments = ((JvmParameterizedTypeReference) left).getArguments();
				if (arguments.size() == typeParameters.size()) {
					return arguments.get(index);
				}
			}
			final JvmTypeParameter jvmTypeParameter = typeParameters.get(index);
			return createTypeRef(jvmTypeParameter);
		}
		throw new IllegalArgumentException(left.getType().getIdentifier() + " is not generic.");
	}

	public JvmWildcardTypeReference wildCard() {
		JvmWildcardTypeReference result = factory.createJvmWildcardTypeReference();
		return result;
	}
	
	public JvmWildcardTypeReference wildCardExtends(JvmTypeReference clone) {
		JvmWildcardTypeReference result = factory.createJvmWildcardTypeReference();
		JvmUpperBound upperBound = factory.createJvmUpperBound();
		upperBound.setTypeReference(clone);
		result.getConstraints().add(upperBound);
		return result;
	}
	
	protected URI toCommonTypesUri(Class<?> clazz) {
		URI result = uriHelper.getFullURI(clazz);
		return result;
	}

	public JvmTypeReference getTypeForName(Class<?> clazz, EObject context, JvmTypeReference... params) {
		if (clazz == null)
			throw new NullPointerException("clazz");
		JvmType declaredType = findDeclaredType(clazz, context);
		if (declaredType == null)
			return null;
		JvmParameterizedTypeReference result = createTypeRef(declaredType, params);
		return result;
	}
	
	public JvmTypeReference getTypeForName(String typeName, Notifier context, JvmTypeReference... params) {
		if (typeName == null)
			throw new NullPointerException("typeName");
		JvmType declaredType = findDeclaredType(typeName, context);
		if (declaredType == null)
			return null;
		JvmParameterizedTypeReference result = createTypeRef(declaredType, params);
		return result;
	}
	
	public JvmGenericArrayTypeReference createArrayType(JvmTypeReference componentType) {
		JvmGenericArrayTypeReference result = factory.createJvmGenericArrayTypeReference();
		result.setComponentType(EcoreUtil2.cloneIfContained(componentType));
		return result;
	}
	
	public JvmType findDeclaredType(Class<?> clazz, EObject context) {
		if (context == null)
			throw new NullPointerException("context");
		if (context.eResource() == null)
			throw new NullPointerException("context must be contained in a resource");
		final ResourceSet resourceSet = context.eResource().getResourceSet();
		if (resourceSet == null) {
			// may be null if the editor was closed too early
			return null;
		}
		// make sure a type provider is configured in the resource set. 
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		URI uri = toCommonTypesUri(clazz);
		JvmType declaredType = (JvmType) resourceSet.getEObject(uri, true);
		return declaredType;
	}
	
	public JvmType findDeclaredType(String typeName, Notifier context) {
		if (context == null)
			throw new NullPointerException("context");
		ResourceSet resourceSet = EcoreUtil2.getResourceSet(context);
		if (resourceSet == null)
			return null;
//			throw new NullPointerException("context must be contained in a resource");
		// make sure a type provider is configured in the resource set. 
		IJvmTypeProvider typeProvider = typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		return typeProvider.findTypeByName(typeName);
	}
	
	public boolean is(final JvmTypeReference reference, final Class<?> clazz) {
		if (isNullOrProxy(reference))
			return false;
		final boolean equals = clazz.getCanonicalName().equals(reference.getType().getIdentifier());
		return equals;
	}

	public boolean isNullOrProxy(final JvmTypeReference reference) {
		return reference==null || reference.getType()==null || reference.getType().eIsProxy();
	}
	
	public boolean isInstanceOf(JvmTypeReference reference, Class<?> clazz) {
		if (isNullOrProxy(reference))
			return false;
		if (is(reference,clazz)) {
			return true;
		}
		Set<JvmTypeReference> types = superTypeCollector.collectSuperTypes(reference);
		for (JvmTypeReference jvmTypeReference : types) {
			if (is(jvmTypeReference,clazz))
				return true;
		}
		return false;
	}
	
	public boolean isArray(JvmTypeReference type) {
		if (isNullOrProxy(type))
			return false;
		return type instanceof JvmGenericArrayTypeReference || type.getType() instanceof JvmArrayType;
	}
}
