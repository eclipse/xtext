/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.xtend.lib.macro.declaration;

import com.google.common.annotations.Beta;

/**
 * A compilation strategy can be assigned instead of an expression see {MutableExecutableDeclaration.
 * It's used to take control over generating Java statements and expressions directly.
 * 
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface CompilationStrategy {
	
	/**
	 * call back method invoked during compliation
	 * 
	 * @param ctx - a compilation context, providing useful services.
	 * @return the Java code
	 */
	CharSequence compile(CompilationContext ctx);
	
	/**
	 * A strategy provided during compilation.
	 */
	public interface CompilationContext {
		
		/**
		 * @param typeref the type reference to serialize
		 * @return the serialized form of the type reference, taking imports into account.
		 */
		String toJavaCode(TypeReference typeref);
		
	}

}
