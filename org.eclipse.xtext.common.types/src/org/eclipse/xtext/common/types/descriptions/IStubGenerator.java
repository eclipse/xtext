/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.descriptions;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.annotations.Beta;
import com.google.inject.ImplementedBy;

/**
 * 
 * A stub generator is responsible for generating Java stubs during compilation.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.5
 */
@Beta
@ImplementedBy(EObjectDescriptionBasedStubGenerator.class)
public interface IStubGenerator {

	/**
	 * called by the standalone compiler, to generate Java stubs.
	 * A Java stub is a Java type declaration with name and correct arity of type parameters.
	 * No members or inheritance information must be provided.
	 */
	public void doGenerateStubs(IFileSystemAccess access, IResourceDescription description);
}
