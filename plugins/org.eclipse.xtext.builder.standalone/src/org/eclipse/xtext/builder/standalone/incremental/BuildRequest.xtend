/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9 
 */
@Accessors
class BuildRequest {
	URI baseDir

	List<URI> classPath = newArrayList
	List<URI> sourceRoots = newArrayList
	List<URI> outputs = newArrayList
	List<URI> dirtyFiles = newArrayList
	List<URI> deletedFiles = newArrayList
	
	String defaultEncoding
	
	boolean isFullBuild = false
	boolean failOnValidationError = true
	boolean debugLog = false
	boolean writeStorageResources = false
	
}