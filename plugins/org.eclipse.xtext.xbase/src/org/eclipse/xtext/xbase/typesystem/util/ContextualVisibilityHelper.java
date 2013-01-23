/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ContextualVisibilityHelper implements IVisibilityHelper {

	private LightweightTypeReference contextType;
	private JvmType rawContextType;
	private Set<String> superTypeNames;
	private IVisibilityHelper parent;

	public ContextualVisibilityHelper(IVisibilityHelper parent, LightweightTypeReference contextType) {
		this.parent = parent;
		this.contextType = contextType;
		this.rawContextType = contextType.getType();
	}
	
	public ContextualVisibilityHelper(LightweightTypeReference contextType) {
		this(new PublicVisibilityHelper(), contextType);
	}
	
	public LightweightTypeReference getContextType() {
		return contextType;
	}
	
	public JvmType getRawContextType() {
		return rawContextType;
	}
	
	public boolean isVisible(JvmMember member) {
		JvmVisibility visibility = member.getVisibility();
		if (visibility == JvmVisibility.PUBLIC) {
			return true;
		}
		JvmDeclaredType type = member.getDeclaringType();
		if (type == rawContextType) {
			return true;
		}
		if (type != null) {
			if (superTypeNames == null) {
				List<LightweightTypeReference> superTypes = contextType.getRawTypeReference().getAllSuperTypes();
				Set<String> superTypeNames = Sets.newHashSetWithExpectedSize(superTypes.size());
				for(LightweightTypeReference superType: superTypes) {
					superTypeNames.add(superType.getIdentifier());
				}
				this.superTypeNames = superTypeNames;
			}
			if (superTypeNames.contains(type.getIdentifier())) {
				if (visibility == JvmVisibility.PROTECTED) {
					return true;
				}
			}
		}
		if (type != null && rawContextType instanceof JvmDeclaredType) {
			String packageName = ((JvmDeclaredType) rawContextType).getPackageName();
			if (Strings.isEmpty(packageName) && Strings.isEmpty(type.getPackageName())
					|| (packageName != null && packageName.equals(type.getPackageName()))) {
				if (visibility == JvmVisibility.DEFAULT || visibility == JvmVisibility.PROTECTED)
					return true;
			}
		}
		return parent.isVisible(member);
	}
	
}
