/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.RawSuperTypes;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContextualVisibilityHelper implements IVisibilityHelper {

	private JvmType rawContextType;
	private Set<String> superTypeNames;
	private IVisibilityHelper parent;
	private String packageName;
	
	public ContextualVisibilityHelper(IVisibilityHelper parent, String packageName) {
		this.parent = parent;
		this.packageName = packageName;
	}

	public ContextualVisibilityHelper(IVisibilityHelper parent, LightweightTypeReference contextType) {
		this.parent = parent;
		this.rawContextType = contextType.getRawTypeReference().getType();
		if (rawContextType instanceof JvmDeclaredType) {
			this.packageName = ((JvmDeclaredType) rawContextType).getPackageName();
		}
	}
	
	public ContextualVisibilityHelper(IVisibilityHelper parent, LightweightTypeReference contextType, String packageName) {
		this.parent = parent;
		this.rawContextType = contextType.getRawTypeReference().getType();
		this.packageName = packageName;
	}
	
	public ContextualVisibilityHelper(IVisibilityHelper parent, JvmType rawContextType, String packageName) {
		this.parent = parent;
		this.rawContextType = rawContextType;
		this.packageName = packageName;
	}
	
	public ContextualVisibilityHelper(IVisibilityHelper parent, JvmType rawContextType) {
		this.parent = parent;
		this.rawContextType = rawContextType;
		if (rawContextType instanceof JvmDeclaredType) {
			this.packageName = ((JvmDeclaredType) rawContextType).getPackageName();
		}
	}
	
	public ContextualVisibilityHelper(LightweightTypeReference contextType) {
		this(new PublicVisibilityHelper(), contextType);
	}
	
	public JvmType getRawContextType() {
		return rawContextType;
	}
	
	@Override
	public boolean isVisible(JvmMember member) {
		// TODO private visibility?
		JvmVisibility visibility = member.getVisibility();
		if (visibility == JvmVisibility.PUBLIC) {
			return true;
		}
		JvmDeclaredType type = member instanceof JvmDeclaredType ? (JvmDeclaredType) member : member.getDeclaringType();
		if (type == rawContextType || EcoreUtil.isAncestor(rawContextType, type)) {
			return true;
		}
		if (type != null && visibility == JvmVisibility.PROTECTED) {
			if (superTypeNames == null) {
				this.superTypeNames = computeSuperTypeNames();
			}
			if (superTypeNames.contains(type.getIdentifier())) {
				return true;
			}
			if (type == member) {
				JvmDeclaredType declaringType = member.getDeclaringType();
				if (declaringType != null && superTypeNames.contains(declaringType.getIdentifier())) {
					return true;
				}
			}
		}
		if (type != null 
				&& (rawContextType == null || rawContextType instanceof JvmDeclaredType) 
				&& (visibility == JvmVisibility.DEFAULT || visibility == JvmVisibility.PROTECTED)) {
			if (Strings.isEmpty(packageName) && Strings.isEmpty(type.getPackageName())
					|| (packageName != null && packageName.equals(type.getPackageName()))) {
				return true;
			}
		}
		return parent.isVisible(member);
	}

	protected Set<String> computeSuperTypeNames() {
		return new RawSuperTypes().collectNames(rawContextType);
	}

	public String getPackageName() {
		return packageName;
	}
	
}
