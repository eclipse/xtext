/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.7
 */
public class JvmTypeReferenceBuilder {

	public static class Factory {
		@Inject Provider<JvmTypeReferenceBuilder> builderProvider;
		@Inject CommonTypeComputationServices services;
		public JvmTypeReferenceBuilder create(ResourceSet context) {
			if (context == null) {
				throw new NullPointerException("'context' cannot be null.");
			}
			JvmTypeReferenceBuilder result = builderProvider.get();
			result.context = context;
			result.typeReferenceOwner = new StandardTypeReferenceOwner(services, context);
			return result;
		}
	}
	
	private StandardTypeReferenceOwner typeReferenceOwner;
	
	private ResourceSet context;
	
	@Inject
	private TypeReferences references;
	
	/**
	 * Creates a new {@link JvmTypeReference} pointing to the given class and containing the given type arguments.
	 * 
	 * @param clazz
	 *            the class the type reference shall point to.
	 * @param typeArgs
	 *            type arguments
	 * 
	 * @return the newly created {@link JvmTypeReference}
	 */
	public JvmTypeReference typeRef(Class<?> clazz, JvmTypeReference... typeArgs) {
		JvmType type = references.findDeclaredType(clazz, context);
		if (type == null) {
			return createUnknownTypeReference(clazz.getName());
		}
		return typeRef(type, typeArgs);
	}

	private JvmTypeReference createUnknownTypeReference(String name) {
		JvmUnknownTypeReference reference = TypesFactory.eINSTANCE.createJvmUnknownTypeReference();
		reference.setQualifiedName(name);
		return reference;
	}

	/**
	 * Creates a new {@link JvmTypeReference} pointing to the given class and containing the given type arguments.
	 * 
	 * @param typeName
	 *            the name of the type the reference shall point to.
	 * @param typeArgs
	 *            type arguments
	 * @return the newly created {@link JvmTypeReference}
	 */
	public JvmTypeReference typeRef(String typeName, JvmTypeReference... typeArgs) {
		JvmType type = references.findDeclaredType(typeName, context);
		if (type == null) {
			return createUnknownTypeReference(typeName);
		}
		return typeRef(type, typeArgs);
	}
	
	/**
	 * Creates a new {@link JvmTypeReference} pointing to the given class and containing the given type arguments.
	 * 
	 * @param type
	 *            the type the reference shall point to.
	 * @param typeArgs
	 *            type arguments
	 * @return the newly created {@link JvmTypeReference}
	 */
	public JvmTypeReference typeRef(JvmType type, JvmTypeReference... typeArgs) {
		int typeParams = 0;
		if (type instanceof JvmGenericType) {
			typeParams = ((JvmGenericType) type).getTypeParameters().size();
		}
		if (typeParams < typeArgs.length) {
			throw new IllegalArgumentException("The type "+type.getIdentifier()+" only declares "+typeParams+" type parameters. You passed "+typeArgs.length+".");
		}
		LightweightTypeReference reference = typeReferenceOwner.toPlainTypeReference(type);
		for (JvmTypeReference jvmTypeReference : typeArgs) {
			((ParameterizedTypeReference)reference).addTypeArgument(typeReferenceOwner.toLightweightTypeReference(jvmTypeReference));
		}
		return reference.toJavaCompliantTypeReference();
	}
	
	/**
	 * Creates a new wildcard type reference with the given type as the upper bound.
	 * For example: 
	 * <pre>wildcardExtends(typeRef(CharSequence))</pre> 
	 * would create a type reference representing 
	 * <pre>? extends CharSequence</pre> 
	 * 
	 * @param extendsBound
	 *            the upper bound of the wildcard
	 * @return the newly created wildcard type reference
	 */
	public JvmTypeReference wildcardExtends(JvmTypeReference extendsBound) {
		WildcardTypeReference wildcardTypeReference = typeReferenceOwner.newWildcardTypeReference();
		wildcardTypeReference.addUpperBound(typeReferenceOwner.toLightweightTypeReference(extendsBound));
		return wildcardTypeReference.toTypeReference();
	}
	
	/**
	 * Creates a new wildcard type reference with the given type as the lower bound and {@link Object} as upper bound.
	 * 
	 * For example: 
	 * <pre>wildcardSuper(typeRef(CharSequence))</pre> 
	 * would create a type reference representing 
	 * <pre>? super CharSequence</pre> 
	 *  
	 * @param superBound
	 *            the super bound of the wildcard
	 * @return the newly created wildcard type reference
	 */
	public JvmTypeReference wildcardSuper(JvmTypeReference superBound) {
		WildcardTypeReference wildcardTypeReference = typeReferenceOwner.newWildcardTypeReference();
		wildcardTypeReference.addUpperBound(typeReferenceOwner.toLightweightTypeReference(typeRef(Object.class)));
		wildcardTypeReference.setLowerBound(typeReferenceOwner.toLightweightTypeReference(superBound));
		return wildcardTypeReference.toTypeReference();
	}
	
	/**
	 * Creates a new wildcard type reference with upper bound {@link Object}.
	 * I.e. <pre>? extends Object</pre>
	 * 
	 * @return the newly created wildcard type reference
	 */
	public JvmTypeReference wildcard() {
		return wildcardExtends(typeRef(Object.class));
	}

}
