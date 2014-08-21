/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;

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
		public JvmTypeReferenceBuilder create(Resource context) {
			JvmTypeReferenceBuilder result = builderProvider.get();
			result.context = context;
			return result;
		}
	}
	
	private Resource context;
	
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
		return references.getTypeForName(clazz, context, typeArgs);
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
		return references.getTypeForName(typeName, context, typeArgs);
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
		return references.createTypeRef(type, typeArgs);
	}
	
	/**
	 * Creates a new {@link JvmWildcardTypeReference} with the given type as the extends (OUT) bound.
	 * 
	 * @param extendsBound
	 *            the extends bound of the wildcard
	 * @return the newly created {@link JvmWildcardTypeReference}
	 */
	public JvmTypeReference wildCardExtends(JvmTypeReference extendsBound) {
		return references.wildCardExtends(extendsBound);
	}
	
	/**
	 * Creates a new {@link JvmWildcardTypeReference} with the given type as the super (IN) bound.
	 * 
	 * @param extendsBound
	 *            the extends bound of the wildcard
	 * @return the newly created {@link JvmWildcardTypeReference}
	 */
	public JvmTypeReference wildCardSuper(JvmTypeReference extendsBound) {
		return references.wildCardSuper(extendsBound);
	}
	
	/**
	 * Creates a new {@link JvmWildcardTypeReference}.
	 * 
	 * @return the newly created {@link JvmWildcardTypeReference}
	 */
	public JvmTypeReference wildCard() {
		return references.wildCard();
	}

}
