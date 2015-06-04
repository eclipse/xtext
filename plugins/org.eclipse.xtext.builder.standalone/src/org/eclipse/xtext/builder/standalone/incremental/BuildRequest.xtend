/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import java.io.File
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.builder.standalone.IIssueHandler
import org.eclipse.xtext.resource.XtextResourceSet

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9 
 */
@Accessors
class BuildRequest {
	URI baseDir
	
	def URI getBaseDir() {
		if (baseDir == null) {
			val userDir = System.getProperty('user.dir')
			baseDir = FilesAndURIs.asURI(new File(userDir)) 
		}
		return baseDir
	}

	List<URI> classPath = newArrayList
	List<URI> sourceRoots = newArrayList
	List<URI> outputs = newArrayList
	List<URI> dirtyFiles = newArrayList
	List<URI> deletedFiles = newArrayList
	
	IIssueHandler issueHandler = new IIssueHandler.DefaultIssueHandler()
	(URI, URI)=>void afterGenerateFile = []
	(URI)=>void afterDeleteFile = []
	
	IndexState previousState = new IndexState
	
	boolean failOnValidationError = true
	boolean debugLog = false
	boolean writeStorageResources = false
	
	XtextResourceSet resourceSet
	
}