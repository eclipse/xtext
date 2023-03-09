/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Replacement interface for the {@link IGenerator} that adds support for parallel code generation.
 * 
 * Clients of {@link IGenerator} that want to perform the code generation in the background will check for this
 * extension interface and use {@link #beforeGenerate(Resource, IFileSystemAccess2, IGeneratorContext)} to prepare the resource set. That
 * is, implementors may alter the state of the resource set in the before hook. This may happen implicitly by resolving
 * proxies or explicitly by loading new resources into the resource set. No changes are allowed while
 * {@link #doGenerate(Resource, IFileSystemAccess2, IGeneratorContext)} is executed since this may be parallelized by the caller. The
 * {@link #afterGenerate(Resource, IFileSystemAccess2, IGeneratorContext)} is used to cleanup state. Also access to the file system is
 * guaranteed to be synchronous in the before and after hook.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
public interface IGenerator2 {

	/**
	 * Perform the code generation for the given input resource.
	 * Any number of files may be created or modified. Write operations
	 * to the given file system access may be processed asynchronous and
	 * are non-blocking if the given fsa is implementing that pattern.
	 * Read operations will happen in the background but
	 * are blocking.
	 */
	void doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context);

	/**
	 * Before the generation is triggered, the resource or the entire resource set
	 * may be prepared such that no modification will happen while {@link #doGenerate(Resource, IFileSystemAccess2, IGeneratorContext)}
	 * is executed.
	 */
	void beforeGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context);

	/**
	 * Release any data that is no longer necessary after the generator ran. 
	 * This is guaranteed to be called if {@link #beforeGenerate(Resource, IFileSystemAccess2, IGeneratorContext)} was called.
	 * It may be called several times. It may be called even if {@link #beforeGenerate(Resource, IFileSystemAccess2, IGeneratorContext)} was not called.
	 */
	void afterGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context);

}
