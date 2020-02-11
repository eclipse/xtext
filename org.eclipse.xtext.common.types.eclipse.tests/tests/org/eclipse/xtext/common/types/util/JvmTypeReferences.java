/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmTypeReferences {
	
	private TypesFactory typesFactory;
	private IJvmTypeProvider typesProvider;
	
	public JvmTypeReferences(TypesFactory typesFactory, IJvmTypeProvider typesProvider) {
		this.typesProvider = typesProvider;
		this.typesFactory = typesFactory;
	}
	
	public boolean equals(JvmTypeReference ref1, JvmTypeReference ref2) {
		return ref1.getIdentifier().equals(ref2.getIdentifier());
	}
	
	public JvmParameterizedTypeReferenceConstructor typeReference(String qualifiedName) {
		return new JvmParameterizedTypeReferenceConstructor(qualifiedName, typesFactory, typesProvider, null);
	}
	public JvmParameterizedTypeReferenceConstructor typeReference(JvmType jvmType) {
		return new JvmParameterizedTypeReferenceConstructor(jvmType, typesFactory, typesProvider, null);
	}
	
	
	public static class JvmParameterizedTypeReferenceConstructor {
		private JvmParameterizedTypeReference reference;
		private TypesFactory typesFactory;
		private JvmParameterizedTypeReferenceConstructor parent = null;
		private IJvmTypeProvider typesProvider;
		
		public JvmParameterizedTypeReferenceConstructor(String qualifiedName, TypesFactory typesFactory, IJvmTypeProvider typesProvider, JvmParameterizedTypeReferenceConstructor parent) {
			this(typesProvider.findTypeByName(qualifiedName),typesFactory,typesProvider,parent);
		}
		
		public JvmParameterizedTypeReferenceConstructor(JvmType jvmType, TypesFactory typesFactory, IJvmTypeProvider typesProvider, JvmParameterizedTypeReferenceConstructor parent) {
			this.reference = typesFactory.createJvmParameterizedTypeReference();
			reference.setType(jvmType);
			this.typesFactory = typesFactory;
			this.typesProvider = typesProvider;
			this.parent  = parent;
		}
		
		protected JvmParameterizedTypeReference getReference() {
			return reference;
		}
		
		public JvmParameterizedTypeReferenceConstructor arg(String qualifiedName) {
			JvmParameterizedTypeReferenceConstructor constructor = new JvmParameterizedTypeReferenceConstructor(qualifiedName, typesFactory, typesProvider, this);
			reference.getArguments().add(constructor.getReference());
			return constructor;
		}
		
		public JvmParameterizedTypeReferenceConstructor wildCard() {
			return wildCardExtends(Object.class.getCanonicalName());
		}
		
		public JvmParameterizedTypeReferenceConstructor wildCardExtends(String qualifiedName) {
			JvmWildcardTypeReference argument = typesFactory.createJvmWildcardTypeReference();
			JvmUpperBound upperBound = typesFactory.createJvmUpperBound();
			argument.getConstraints().add(upperBound);
			JvmParameterizedTypeReferenceConstructor constructor = new JvmParameterizedTypeReferenceConstructor(qualifiedName, typesFactory, typesProvider, this);
			upperBound.setTypeReference(constructor.getReference());
			reference.getArguments().add(argument);
			return constructor;
		}
		public JvmParameterizedTypeReferenceConstructor wildCardSuper(String qualifiedName) {
			JvmWildcardTypeReference argument = typesFactory.createJvmWildcardTypeReference();
			JvmLowerBound upperBound = typesFactory.createJvmLowerBound();
			argument.getConstraints().add(upperBound);
			JvmParameterizedTypeReferenceConstructor constructor = new JvmParameterizedTypeReferenceConstructor(qualifiedName, typesFactory, typesProvider, this);
			upperBound.setTypeReference(constructor.getReference());
			reference.getArguments().add(argument);
			return constructor;
		}
		
		public JvmParameterizedTypeReference create() {
			if (this.parent!=null)
				return parent.create();
			return reference;
		}
		
		public JvmParameterizedTypeReferenceConstructor x() {
			if (this.parent==null)
				throw new IllegalStateException("No parent");
			return parent;
		}
	}
	
}
