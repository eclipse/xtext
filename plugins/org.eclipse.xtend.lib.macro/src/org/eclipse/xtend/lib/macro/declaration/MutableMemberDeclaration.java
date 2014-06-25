/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import com.google.common.annotations.Beta;

/**
 * 
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface MutableMemberDeclaration extends MutableDeclaration, MemberDeclaration {
	
	/**
	 * Sets the JavaDoc comment for this member
	 * @param docComment
	 */
	public void setDocComment(String docComment);
	
	/**
	 * Sets the {@link Visibility} of this member.
	 * 
	 * @param visibility
	 */
	public void setVisibility(Visibility visibility);
	
	/**
	 * @return the type declaring this member
	 */
	public MutableTypeDeclaration getDeclaringType();
}
