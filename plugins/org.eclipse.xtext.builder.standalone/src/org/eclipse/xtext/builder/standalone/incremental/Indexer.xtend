/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import com.google.inject.Inject
import java.util.List
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9 
 */
class Indexer {
	
	static val LOG = Logger.getLogger(Indexer)
	
	@Inject extension ResourceURICollector uriCollector
	@Inject extension ResourceSetClearer
	
	@Inject JavaSupport javaSupport
	
	def computeAffected(BuildRequest request, BuildContext context) {
		LOG.info("Collecting source models.")
		val startedAt = System.currentTimeMillis
		val sourceResourceURIs = request.sourceRoots.collectResources(context)
		val allResourcesURIs = sourceResourceURIs + request.classPath.collectResources(context)
		LOG.info("Finished collecting source models. Took: " + (System.currentTimeMillis - startedAt) + " ms.")

		val allClassPathEntries = (request.sourceRoots + request.classPath)
		if (context.needsJava) {
			LOG.info("Installing type provider.")
			javaSupport.installLocalOnlyTypeProvider(allClassPathEntries, context.resourceSet)
		}

		// Fill index
		var ResourceDescriptionsData index = new ResourceDescriptionsData(newArrayList());
		var allResourceIterator = allResourcesURIs.iterator
		while (allResourceIterator.hasNext) {
			var List<Resource> resources = newArrayList()
			var int clusterIndex = 0
			var continue = true
			while (allResourceIterator.hasNext && continue) {
				val uri = allResourceIterator.next
				val resource = context.resourceSet.getResource(uri, true)
				resources.add(resource)
				fillIndex(uri, resource, index, context)
				clusterIndex++
				if (!context.clusteringPolicy.continueProcessing(context.resourceSet, null, clusterIndex)) {
					continue = false
				}
			}
			if (!continue)
				context.resourceSet.clearResourceSet
		}
		context.resourceSet.installIndex(index)
		return new IndexerResult(sourceResourceURIs, request.deletedFiles, index)
	}
	
	def protected installIndex(XtextResourceSet resourceSet, ResourceDescriptionsData index) {
		ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resourceSet, index)
	}

	def protected fillIndex(URI uri, Resource resource, ResourceDescriptionsData index, BuildContext context) {
		val description = context.languages.get(uri.fileExtension).resourceDescriptionManager.getResourceDescription(resource)
		index.addDescription(uri, description)
	}
}