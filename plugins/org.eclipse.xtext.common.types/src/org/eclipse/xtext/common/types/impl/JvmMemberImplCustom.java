/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;



public abstract class JvmMemberImplCustom extends JvmMemberImpl {
	
	@Override
	public String getCanonicalName() {
		return getFullyQualifiedName();
	}
	
	@Override
	public String getSimpleName() {
		if (fullyQualifiedName == null)
			return null;
		int parenIdx = fullyQualifiedName.indexOf('(');
		if (parenIdx < 0)
			parenIdx = fullyQualifiedName.length();
		int dotIdx = fullyQualifiedName.lastIndexOf('.', parenIdx);
		return fullyQualifiedName.substring(dotIdx + 1, parenIdx);
	}


}
