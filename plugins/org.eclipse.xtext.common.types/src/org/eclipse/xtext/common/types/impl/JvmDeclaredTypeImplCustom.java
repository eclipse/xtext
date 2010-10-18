/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;



public abstract class JvmDeclaredTypeImplCustom extends JvmDeclaredTypeImpl {


	@Override
	public String getSimpleName() {
		if (fullyQualifiedName == null)
			return null;
		int dollarIdx = fullyQualifiedName.lastIndexOf('$');
		if (dollarIdx != -1) {
			return fullyQualifiedName.substring(dollarIdx + 1);
		}
		int dotIdx = fullyQualifiedName.lastIndexOf('.');
		return fullyQualifiedName.substring(dotIdx + 1);
	}



	@Override
	public String getPackageName() {
		if (fullyQualifiedName == null)
			return null;
		int dotIdx = fullyQualifiedName.lastIndexOf('.');
		if (dotIdx == -1)
			return "";
		return fullyQualifiedName.substring(0, dotIdx);
	}

	@Override
	public String getCanonicalName() {
		return getFullyQualifiedName();
	}
	
}
