/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmDeclaredType;

/**
 * Allows to add static imports and static extension imports locally. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.6
 */
@NonNullByDefault
public interface ITypeImporter {

	/**
	 * Imports all static members of the given type.
	 */
	void importStatic(JvmDeclaredType type);
	
	/**
	 * Imports the static members of the given type with the given name.
	 */
	void importStatic(JvmDeclaredType type, String memberName);
	
	/**
	 * Imports all static members of the given type.
	 */
	void importStaticExtension(JvmDeclaredType type, boolean strict);
	
	/**
	 * Imports the static members of the given type with the given name.
	 */
	void importStaticExtension(JvmDeclaredType type, String memberName, boolean strict);
	
	/**
	 * This is facade to add imports on the same level in a type computation state.
	 */
	interface Client {
		
		/**
		 * Clients should use the importer to add static imports to the scope.
		 */
		void doAddImports(ITypeImporter importer);
		
	}
	
}
