/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.RawSuperTypes;
import org.eclipse.xtext.naming.QualifiedName;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NestedTypeCollector {

	public Map<QualifiedName, JvmDeclaredType> collectNestedTypes(JvmDeclaredType type) {
		Set<JvmType> superTypes = new RawSuperTypes().collect(type);
		Map<QualifiedName, JvmDeclaredType> nestedTypes = null;
		for(JvmType superType: superTypes) {
			nestedTypes = collectNestedTypes(superType, QualifiedName.EMPTY, nestedTypes);
		}
		if (nestedTypes != null)
			return nestedTypes;
		return Collections.emptyMap();
	}
	
	public Map<QualifiedName, JvmDeclaredType> mergeEnclosingNestedTypes(Map<QualifiedName, JvmDeclaredType> myNestedTypes, Map<QualifiedName, JvmDeclaredType> enclosingNestedTypes) {
		if (myNestedTypes.isEmpty())
			return enclosingNestedTypes;
		Map<QualifiedName, JvmDeclaredType> outerNames = Maps.newHashMapWithExpectedSize(enclosingNestedTypes.size());
		for(Map.Entry<QualifiedName, JvmDeclaredType> entry: enclosingNestedTypes.entrySet()) {
			if (!isNameShadowed(myNestedTypes, entry.getKey())) {
				outerNames.put(entry.getKey(), entry.getValue());
			}
		}
		myNestedTypes.putAll(outerNames);
		return myNestedTypes;
	}

	private boolean isNameShadowed(Map<QualifiedName, JvmDeclaredType> nestedTypes, QualifiedName name) {
		if (name.isEmpty())
			return false;
		if (nestedTypes.containsKey(name)) {
			return true;
		}
		return isNameShadowed(nestedTypes, name.skipLast(1));
	}

	protected Map<QualifiedName, JvmDeclaredType> collectNestedTypes(JvmType enclosing, QualifiedName enclosingName, Map<QualifiedName, JvmDeclaredType> result) {
		if (enclosing instanceof JvmDeclaredType) {
			for(JvmMember member: ((JvmDeclaredType) enclosing).getMembers()) {
				if (member instanceof JvmDeclaredType) {
					if (result == null) {
						result = Maps.newHashMapWithExpectedSize(4);
					}
					JvmDeclaredType nested = (JvmDeclaredType) member;
					QualifiedName relativeName = enclosingName.append(member.getSimpleName());
					if (!result.containsKey(relativeName)) {
						result.put(relativeName, nested);
						collectNestedTypes(nested, relativeName, result);
					}
				}
			}
		}
		return result;
	}
}
