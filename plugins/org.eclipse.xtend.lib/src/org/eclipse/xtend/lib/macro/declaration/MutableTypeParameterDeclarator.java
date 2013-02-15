/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import java.util.List;

import com.google.common.annotations.Beta;

@Beta
public interface MutableTypeParameterDeclarator extends MutableMemberDeclaration, TypeParameterDeclarator {
	public List<MutableTypeParameterDeclaration> getTypeParameters();

	MutableTypeParameterDeclaration addTypeParameter(String name, TypeReference... upperBounds);
}
