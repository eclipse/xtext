/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import java.util.Set;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface MemberDeclaration extends Declaration {
	
	/**
	 * @return the JavaDoc comment
	 */
	String getDocComment();

	/**
	 * @return the visibility of this member
	 */
	Visibility getVisibility();
	
	/**
	 * @return the type declaring this member or <code>null</code> if this is a top level element
	 */
	TypeDeclaration getDeclaringType();
	
	/**
	 * @return the modifiers of this Xtend element or an empty set of this is a Java element.
	 * E.g. <code>public val foo = "foo"</code> has the modifiers {@link Modifier#VAL} and {@link Modifier#PUBLIC} 
	 * @since 2.7
	 */
	Set<Modifier> getModifiers();
	
	/**
	 * Returns {@code true} if this member is marked as deprecated.
	 * @return {@code true} if this member is marked as deprecated.
	 * @since 2.7
	 */
	boolean isDeprecated();
}