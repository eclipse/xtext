/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RawSuperTypes {
	
	public Set<JvmType> collect(JvmType type) {
		Set<JvmType> result = new Implementation().collect(type);
		result.remove(type);
		return result;
	}
	
	public Set<String> collectNames(JvmType type) {
		Set<JvmType> superTypes = collect(type);
		final Set<String> superTypeNames = Sets.newHashSet();
		for(JvmType collectedSuperType: superTypes) {
			superTypeNames.add(collectedSuperType.getIdentifier());
		}
		return superTypeNames;
	}

	protected static class Implementation extends TypesSwitch<Boolean> {

		private Set<JvmType> collectedSuperTypes = Sets.newLinkedHashSet(); 
		
		@Override
		public Boolean doSwitch(EObject theEObject) {
			if (theEObject == null)
				return Boolean.FALSE;
			return super.doSwitch(theEObject);
		}
		
		@Override
		public Boolean caseJvmTypeReference(JvmTypeReference object) {
			return doSwitch(object.getType());
		}
		
		@Override
		public Boolean caseJvmType(JvmType object) {
			return collectedSuperTypes.add(object);
		}
		
		@Override
		public Boolean caseJvmArrayType(JvmArrayType object) {
			return collectedSuperTypes.add(object);
		}
		
		@Override
		public Boolean caseJvmDeclaredType(JvmDeclaredType object) {
			if (collectedSuperTypes.add(object)) {
				for (JvmTypeReference superType : object.getSuperTypes()) {
					doSwitch(superType);
				}
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}
		
		public Set<JvmType> collect(JvmType sub) {
			doSwitch(sub);
			return collectedSuperTypes;
		}
		
	}

}
