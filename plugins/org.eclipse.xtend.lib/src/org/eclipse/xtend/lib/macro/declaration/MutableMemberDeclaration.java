/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import com.google.common.annotations.Beta;

@Beta
public interface MutableMemberDeclaration extends MutableDeclaration, MemberDeclaration {
	public void setDocComment(String docComment);
	public void setVisibility(Visibility visibility);
	public MutableTypeDeclaration getDeclaringType();
}
