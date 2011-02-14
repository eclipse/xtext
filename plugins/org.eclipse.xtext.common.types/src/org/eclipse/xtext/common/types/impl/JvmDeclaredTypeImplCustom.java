/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmDeclaredTypeImplCustom extends JvmDeclaredTypeImpl {

	@Override
	public String getPackageName() {
		if (getDeclaringType() != null)
			return getDeclaringType().getPackageName();
		return packageName;
	}

	@Override
	protected String computeIdentifier() {
		if (simpleName == null)
			return null;
		JvmDeclaredType declaringType = getDeclaringType();
		if (declaringType == null) {
			if (Strings.isEmpty(packageName))
				return simpleName;
			return packageName + "." + simpleName;
		}
		String parentName = declaringType.getIdentifier();
		if (parentName == null)
			return null;
		return parentName + "$" + simpleName;
	}
	
	@Override
	public Iterable<JvmField> getDeclaredFields() {
		return Iterables.filter(getMembers(), JvmField.class);
	}
	
	@Override
	public Iterable<JvmOperation> getDeclaredOperations() {
		return Iterables.filter(getMembers(), JvmOperation.class);
	}
	
}
