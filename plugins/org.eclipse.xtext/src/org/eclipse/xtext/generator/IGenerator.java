/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.emf.ecore.resource.Resource;


/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IGenerator {
	
	/**
	 * @param input - the input for which to generate resources
	 * @param fsa - file system access to be used to generate files
	 */
	public void doGenerate(Resource input, IFileSystemAccess fsa);
	
	/**
	 * @since 2.4
	 */
	public static class NullGenerator implements IGenerator {
		public void doGenerate(Resource input, IFileSystemAccess fsa) {}
	}
}
