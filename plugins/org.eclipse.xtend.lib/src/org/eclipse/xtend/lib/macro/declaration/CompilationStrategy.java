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

import com.google.common.annotations.Beta;

/**
 * A compilation strategy can be assigned instead of an expression see {MutableExecutableDeclaration.
 * It's used to take control over generating Java statements and expressions directly.
 * 
 * @author Sven Efftinge
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
	
	public interface CompilationContext {
		
		/**
		 * @param a type reference
		 * @return the serialized form of the type reference, taking imports into account.
		 */
		String toJavaCode(TypeReference typeref);
		
	}

}
