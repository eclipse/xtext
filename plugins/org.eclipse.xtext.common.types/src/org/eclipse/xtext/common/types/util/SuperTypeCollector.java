/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import static com.google.common.collect.Iterables.*;

import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class SuperTypeCollector {

	interface SuperTypeAcceptor {
		/**
		 * @param superType a found super type
		 * @param the distance to the starting type. StringBuilder has a distance 1 to 
		 * AbstractStringBuilder, distance 1 and 2 to CharSequence and distance 2 to Appendable.
		 */
		boolean accept(JvmTypeReference superType, int distance);
	}
	
	@Inject
	private TypesFactory factory;
	
	public SuperTypeCollector() {}

	public SuperTypeCollector(TypesFactory factory) {
		this.factory = factory;
	}
	
	protected JvmTypeReference newRef(JvmType type) {
		JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
		reference.setType(type);
		return reference;
	}

	public Set<JvmTypeReference> collectSuperTypes(JvmType type) {
		return collectSuperTypes(newRef(type));
	}

	public Set<JvmTypeReference> collectSuperTypes(JvmTypeReference type) {
		final Set<JvmTypeReference> result = Sets.newLinkedHashSet();
		doCollectSupertypeData(type, new SuperTypeAcceptor() {
			public boolean accept(JvmTypeReference superType, int distance) {
				return result.add(superType);
			}
		});
		return result;
	}
	
	public void collectSuperTypes(JvmTypeReference type, SuperTypeAcceptor acceptor) {
		doCollectSupertypeData(type, acceptor);
	}

	public Set<String> collectSuperTypeNames(JvmType type) {
		return collectSuperTypeNames(newRef(type));
	}

	public Set<JvmType> collectSuperTypesAsRawTypes(JvmTypeReference type) {
		final Set<JvmType> result = Sets.newLinkedHashSet();
		doCollectSupertypeData(type, new SuperTypeAcceptor() {
			public boolean accept(JvmTypeReference superType, int distance) {
				return result.add(superType.getType());
			}
		});
		return result;
	}

	public Set<String> collectSuperTypeNames(JvmTypeReference type) {
		final Set<String> result = Sets.newLinkedHashSet();
		doCollectSupertypeData(type, new SuperTypeAcceptor() {
			public boolean accept(JvmTypeReference superType, int distance) {
				String name = getSuperTypeName(superType);
				return result.add(name);
			}
			
			public String getSuperTypeName(JvmTypeReference typeReference) {
				if (typeReference instanceof JvmParameterizedTypeReference) {
					return ((JvmParameterizedTypeReference) typeReference).getType().getCanonicalName();
				}
				return typeReference.getCanonicalName();
			}
		});
		return result;
	}

	public void doCollectSupertypeData(JvmTypeReference type, SuperTypeAcceptor acceptor) {
		if (type != null) {
			Implementation implementation = new Implementation(acceptor);
			implementation.doSwitch(type);
		}
	}

	public static class Implementation extends TypesSwitch<Void> {

		private boolean collecting = false;
		private final SuperTypeAcceptor acceptor;
		private int level;

		public Implementation(SuperTypeAcceptor acceptor) {
			this.acceptor = acceptor;
			this.level = 0;
		}

		@Override
		public Void caseJvmTypeReference(JvmTypeReference object) {
			if (!object.eIsProxy()) {
				if (!collecting || acceptor.accept(object, level)) {
					collecting = true;
					if (object.getType() != null)
						doSwitch(object.getType());
				}
			}
			return null;
		}
		
		@Override
		public Void caseJvmDeclaredType(JvmDeclaredType object) {
			if (!object.eIsProxy()) {
				level++;
				for (JvmTypeReference superType : reverse(object.getSuperTypes())) {
					doSwitch(superType);
				}
				level--;
			}
			return null;
		}
	}

	public boolean isSuperType(JvmDeclaredType subType, JvmDeclaredType superType) {
		if (subType==null || superType == null)
			return false;
		return collectSuperTypesAsRawTypes(newRef(subType)).contains(superType);
	}

}
