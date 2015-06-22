/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.Collection
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.resource.CompilerPhases
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.util.internal.Log

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9 
 */
@Singleton @Log
class Indexer {

	@Inject CompilerPhases compilerPhases

	@Data static class IndexResult {
		List<Delta> resourceDeltas
		ResourceDescriptionsData newIndex
	}
	
	def IndexResult computeAndIndexAffected(BuildRequest request, extension BuildContext context) {
		val previousIndex = request.previousState.resourceDescriptions
		val newIndex = previousIndex.copy
		installIndex(resourceSet, newIndex)

		// get the direct deltas
		val List<Delta> deltas = newArrayList
		if (LOG.isInfoEnabled)
			LOG.info('Creating Deltas for changes. Deleted : '+request.deletedFiles.toSet+', Changed : '+request.dirtyFiles.toSet+'.')
		deltas.addAll(getDeltasForDeletedResources(request, previousIndex, context))
		deltas.addAll(getDeltasForChangedResources(request.dirtyFiles, previousIndex, context))
		// update the index with the direct deltas
		for (delta : deltas)
			newIndex.register(delta)
		
		// add external deltas
		if (!request.externalDeltas.empty)
			deltas.addAll(request.externalDeltas)
		
		val remainingURIs = previousIndex.allResourceDescriptions.map[getURI].toSet
		remainingURIs.removeAll(deltas.map[uri])
		
		val allAffected = remainingURIs.filter [
			if (!request.belongsToThisBuildRun(it))
				return false;
			val manager = getResourceServiceProvider.resourceDescriptionManager
			val resourceDescription = previousIndex.getResourceDescription(it)
			val isAffected = resourceDescription.isAffected(manager, deltas, deltas, newIndex)
			return isAffected
		].toList
		if (LOG.isInfoEnabled && !allAffected.empty)
			LOG.info('Creating Deltas for affected resources : '+allAffected.toSet+".")
		deltas.addAll(getDeltasForChangedResources(allAffected, previousIndex, context))
		
		return new IndexResult(deltas, newIndex)
	}
	
	protected def List<Delta> getDeltasForDeletedResources(BuildRequest request, ResourceDescriptionsData oldIndex, extension BuildContext context) {
		val deltas = <Delta>newArrayList()
		request.deletedFiles.filter[context.getResourceServiceProvider(it) != null].forEach [
			val IResourceDescription oldDescription = oldIndex?.getResourceDescription(it)
			if (oldDescription != null) {
				val delta = new DefaultResourceDescriptionDelta(oldDescription, null)
				deltas += delta
			}
		]
		return deltas
	}

	protected def List<Delta> getDeltasForChangedResources(Iterable<URI> affectedUris, ResourceDescriptionsData oldIndex, extension BuildContext context) {
		try {
			compilerPhases.setIndexing(resourceSet, true)
			return affectedUris.executeClustered [
				addToIndex(true, oldIndex, context)
			].toList
		} finally {
			compilerPhases.setIndexing(resourceSet, false)
		}
	}

	def protected Delta addToIndex(Resource resource, boolean isPreIndexing, ResourceDescriptionsData oldIndex, BuildContext context) {
		val uri = resource.URI
		val serviceProvider = context.getResourceServiceProvider(uri)
		val manager = serviceProvider.resourceDescriptionManager
		val newDescription = manager.getResourceDescription(resource)
		val IResourceDescription toBeAdded = new ResolvedResourceDescription(newDescription)
		val delta = new DefaultResourceDescriptionDelta(oldIndex?.getResourceDescription(uri), toBeAdded)
		return delta
	}

	def protected void installIndex(XtextResourceSet resourceSet, ResourceDescriptionsData index) {
		ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resourceSet, index)
	}
	
	def protected boolean isAffected(IResourceDescription affectionCandidate, IResourceDescription.Manager manager,
		Collection<IResourceDescription.Delta> newDeltas, Collection<IResourceDescription.Delta> allDeltas,
		IResourceDescriptions resourceDescriptions) {
		if ((manager instanceof IResourceDescription.Manager.AllChangeAware)) {
			return manager.isAffectedByAny(allDeltas, affectionCandidate, resourceDescriptions);
		} else {
			if (newDeltas.empty) {
				return false;
			} else {
				return manager.isAffected(newDeltas, affectionCandidate, resourceDescriptions);
			}
		}
	}
}