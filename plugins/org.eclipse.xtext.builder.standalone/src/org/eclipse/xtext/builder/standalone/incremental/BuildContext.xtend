/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import java.io.File
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.builder.standalone.LanguageAccess
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.clustering.IResourceClusteringPolicy

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@FinalFieldsConstructor @Accessors
class BuildContext {
	val Map<String, LanguageAccess> languages
	val XtextResourceSet resourceSet
	val IResourceClusteringPolicy clusteringPolicy
	val File tempDir
	
	ClusteringStorageAwareResourceLoader loader
	
	def <T> executeClustered(Iterable<URI> uri, (Resource)=>T operation) {
		if(loader == null) 
			loader = new ClusteringStorageAwareResourceLoader(this)
		loader.executeClustered(uri, operation)
	}
	
	def getLanguageAccess(URI uri) {
		languages.get(uri.fileExtension)
	}
	
}