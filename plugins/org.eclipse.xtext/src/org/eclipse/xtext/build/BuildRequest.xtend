/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.build

import java.io.File
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.util.UriUtil
import org.eclipse.xtext.util.CancelIndicator

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
			baseDir = UriUtil.createFolderURI(new File(userDir)) 
		}
		return baseDir
	}

	List<URI> dirtyFiles = newArrayList
	List<URI> deletedFiles = newArrayList;
	List<IResourceDescription.Delta> externalDeltas = newArrayList()
	
	/**
	 * call back after validation, return <code>false</code> will stop the build.
	 */
	IPostValidationCallback afterValidate = new DefaultValidationCallback()
	(URI, URI)=>void afterGenerateFile = []
	(URI)=>void afterDeleteFile = []
	
	IndexState state = new IndexState
	
	boolean writeStorageResources = false
	boolean indexOnly = false
	
	XtextResourceSet resourceSet
	CancelIndicator cancelIndicator = CancelIndicator.NullImpl
	
	interface IPostValidationCallback {
		
		/**
		 * @return whether the build can proceed, <code>false</code> if the build should be interrupted
		 */
		def boolean afterValidate(URI validated, Iterable<Issue> issues);
	}
	
	@Log private static class DefaultValidationCallback implements IPostValidationCallback {
		
		override afterValidate(URI validated, Iterable<Issue> issues) {
			var boolean errorFree = true;
			for (Issue issue : issues) {
				switch (issue.getSeverity()) {
					case ERROR : {
						LOG.error(issue.toString())
						errorFree = false
					}
					case WARNING :
						LOG.warn(issue.toString())
					case INFO:
						LOG.info(issue.toString())
					case IGNORE:
						LOG.debug(issue.toString())
				}
			}
			return errorFree;	
		}
		
	}
}
	