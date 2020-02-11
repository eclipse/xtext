/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.emf.ecore.resource.Resource;


/**
 * Interface for sequential code generators. Implementors have to provide
 * the logic that processes a single resource. I/O is abstracted with the 
 * {@link IFileSystemAccess} which allows to provide support for in-memory 
 * code generation and UI specific implementations, e.g. based on the Eclipse
 * resource model or the IntelliJ virtual file system.
 * 
 * Clients may choose to implement and bind an {@link IGenerator2} to support
 * code generation in parallel.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IGenerator {
	
	/**
	 * @param input the input for which to generate resources
	 * @param fsa file system access to be used to generate files
	 */
	void doGenerate(Resource input, IFileSystemAccess fsa);
	
	/**
	 * @since 2.4
	 */
	public static class NullGenerator implements IGenerator {
		@Override
		public void doGenerate(Resource input, IFileSystemAccess fsa) {}
	}
}
