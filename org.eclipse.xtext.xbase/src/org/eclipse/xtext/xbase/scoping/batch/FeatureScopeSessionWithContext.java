/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.ContextualVisibilityHelper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureScopeSessionWithContext extends AbstractNestedFeatureScopeSession {

	private ContextualVisibilityHelper visibilityHelper;

	public FeatureScopeSessionWithContext(AbstractFeatureScopeSession parent, LightweightTypeReference contextType) {
		super(parent);
		this.visibilityHelper = new ContextualVisibilityHelper(parent, contextType);
	}
	
	public FeatureScopeSessionWithContext(AbstractFeatureScopeSession parent, LightweightTypeReference contextType, String packageName) {
		super(parent);
		this.visibilityHelper = new ContextualVisibilityHelper(parent, contextType, packageName);
	}
	
	@Override
	public boolean isVisible(JvmMember member) {
		return visibilityHelper.isVisible(member);
	}
	
	@Override
	public boolean isVisible(JvmMember member, /* @Nullable */ LightweightTypeReference receiverType, /* @Nullable */ JvmIdentifiableElement receiverFeature) {
		boolean result = isVisible(member);
		if (result && JvmVisibility.PROTECTED == member.getVisibility()) {
			if (receiverFeature != null) {
				// We bypass this check for qualified.this and qualified.super in the scope provider
				// they are considered to be always visible
				/*
				 * class A {
				 *   class B {
				 *     {
				 *       A.super.toString
				 *     }
				 *   }
				 * }
				 */
				if (isThisSuperOrTypeLiteral(receiverFeature)) {
					if (receiverType == null || !receiverType.isType(Class.class)) {
						return true;
					}
				}
			}
			JvmType contextType = visibilityHelper.getRawContextType();
			if (contextType instanceof JvmDeclaredType) {
				String packageName = visibilityHelper.getPackageName();
				JvmDeclaredType declaringType = member.getDeclaringType();
				String memberPackageName = declaringType.getPackageName();
				if (Strings.equal(packageName, memberPackageName)) {
					return true;
				}
			}
			if (receiverType != null) {
				if (receiverType.isSubtypeOf(contextType)) {
					return true;
				}
				EObject container = contextType.eContainer();
				while (container instanceof JvmType) {
					if (receiverType.isSubtypeOf((JvmType)container)) {
						return true;
					}
					container = container.eContainer();
				}
			}
			return false;
		}
		return result;
	}
	
	protected boolean isThisSuperOrTypeLiteral(JvmIdentifiableElement receiverFeature) {
		return receiverFeature instanceof JvmType;
	}

}
