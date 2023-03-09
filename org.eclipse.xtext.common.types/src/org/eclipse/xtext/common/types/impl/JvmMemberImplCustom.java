/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmMemberImplCustom extends JvmMemberImpl {
	
	@Override
	public final String getIdentifier() {
		if (identifier != null)
			return identifier;
		String identifier = computeIdentifier();
		this.identifier = identifier;
		return identifier;
	}
	
	public void clearIdentifierCache() {
		identifier = null;
		for (EObject child : eContents()) {
			if (child instanceof JvmMemberImplCustom) {
				((JvmMemberImplCustom) child).clearIdentifierCache();
			}
		}
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		if (simpleName == null)
			return null;
		JvmDeclaredType declaringType = getDeclaringType();
		if (declaringType == null)
			return simpleName;
		return declaringType.getQualifiedName(innerClassDelimiter) + '.' + simpleName;
	}
	
	@Override
	public void internalSetIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	protected String computeIdentifier() {
		if (simpleName == null)
			return null;
		JvmDeclaredType declaringType = getDeclaringType();
		if (declaringType == null)
			return simpleName;
		return declaringType.getIdentifier() + "." + simpleName;
	}

}
