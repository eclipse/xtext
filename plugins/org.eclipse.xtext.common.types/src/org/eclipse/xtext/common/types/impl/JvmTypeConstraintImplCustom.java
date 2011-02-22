/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmTypeConstraintImplCustom extends JvmTypeConstraintImpl {

	@Override
	public String getIdentifier() {
		if (typeReference != null) {
			return getTypeReference().getIdentifier();
		}
		return null;
	}
	
	@Override
	public final String getQualifiedName() {
		return getQualifiedName('$');
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		if (typeReference != null) {
			return getTypeReference().getQualifiedName(innerClassDelimiter);
		}
		return null;
	}
	
	@Override
	public String getSimpleName() {
		if (typeReference != null) {
			return getTypeReference().getSimpleName();
		}
		return null;
	}
	
	@Override
	public void setTypeReference(JvmTypeReference newTypeReference) {
		if (newTypeReference instanceof JvmWildcardTypeReference)
			throw new IllegalArgumentException("wildcard type references are not supported as constraint bounds");
		super.setTypeReference(newTypeReference);
	}
	
	@Override
	public String toString() {
		String result = getIdentifier();
		if (result != null)
			return result;
		return super.toString();
	}

} 
