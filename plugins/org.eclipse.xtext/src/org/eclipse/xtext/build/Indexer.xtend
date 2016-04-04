/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.build

import com.google.common.collect.ImmutableList
import com.google.common.collect.Maps
import com.google.inject.Inject
import java.util.Collection
import java.util.HashSet
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.CompilerPhases
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.AbstractResourceDescription
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.service.OperationCanceledManager

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9 
 */
@Log class Indexer {

	@Inject CompilerPhases compilerPhases
	@Inject extension OperationCanceledManager

	@Data static class IndexResult {
		List<Delta> resourceDeltas
		ResourceDescriptionsData newIndex
	}

	def IndexResult computeAndIndexAffected(BuildRequest request, extension BuildContext context) {
		val previousIndex = context.oldState.resourceDescriptions
		val newIndex = request.state.resourceDescriptions

		// get the direct deltas
		val List<Delta> deltas = newArrayList
		if (LOG.isInfoEnabled)
			LOG.info(
				'Creating Deltas for changes. Deleted : ' + request.deletedFiles.toSet + ', Changed : ' +
					request.dirtyFiles.toSet + '.')
		deltas.addAll(getDeltasForDeletedResources(request, previousIndex, context))
		deltas.addAll(getDeltasForChangedResources(request.dirtyFiles, previousIndex, context))
		// update the index with the direct deltas
		for (delta : deltas)
			newIndex.register(delta)

		// add external deltas
		val allDeltas = new HashSet<Delta>(deltas)
		if (!request.externalDeltas.empty)
			allDeltas.addAll(request.externalDeltas)

		val remainingURIs = previousIndex.allResourceDescriptions.map[getURI].toSet
		remainingURIs.removeAll(deltas.map[uri])

		val allAffected = remainingURIs.filter [
			val manager = getResourceServiceProvider.resourceDescriptionManager
			val resourceDescription = previousIndex.getResourceDescription(it)
			val isAffected = resourceDescription.isAffected(manager, allDeltas, allDeltas, newIndex)
			return isAffected
		].toList
		if (LOG.isInfoEnabled && !allAffected.empty)
			LOG.info('Creating Deltas for affected resources : ' + allAffected.toSet + ".")
		deltas.addAll(getDeltasForChangedResources(allAffected, previousIndex, context))

		return new IndexResult(deltas, newIndex)
	}

	protected def List<Delta> getDeltasForDeletedResources(BuildRequest request, ResourceDescriptionsData oldIndex,
		extension BuildContext context) {
		val deltas = <Delta>newArrayList()
		for (it : request.deletedFiles.filter[context.getResourceServiceProvider(it) != null]) {
			context.cancelIndicator.checkCanceled
			val IResourceDescription oldDescription = oldIndex?.getResourceDescription(it)
			if (oldDescription != null) {
				val delta = new DefaultResourceDescriptionDelta(oldDescription, null)
				deltas += delta
			}
		}
		return deltas
	}

	protected def List<Delta> getDeltasForChangedResources(Iterable<URI> affectedUris,
		ResourceDescriptionsData oldIndex, extension BuildContext context) {
		try {
			compilerPhases.setIndexing(resourceSet, true)
			return affectedUris.executeClustered [
				addToIndex(true, oldIndex, context)
			].toList
		} finally {
			compilerPhases.setIndexing(resourceSet, false)
		}
	}

	def protected Delta addToIndex(Resource resource, boolean isPreIndexing, ResourceDescriptionsData oldIndex,
		BuildContext context) {
		context.cancelIndicator.checkCanceled
		val uri = resource.getURI
		val serviceProvider = context.getResourceServiceProvider(uri)
		val manager = serviceProvider.resourceDescriptionManager
		val newDescription = manager.getResourceDescription(resource)
		val IResourceDescription toBeAdded = new ResolvedResourceDescription(newDescription)
		val delta = manager.createDelta(oldIndex?.getResourceDescription(uri), toBeAdded)
		return delta
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

	@Log protected static class ResolvedResourceDescription extends AbstractResourceDescription {

		@Accessors(PUBLIC_GETTER)
		URI URI

		ImmutableList<IEObjectDescription> exported

		new(IResourceDescription original) {
			this.URI = original.getURI
			this.exported = ImmutableList.copyOf(
				original.exportedObjects.map [ IEObjectDescription from |
					if (from.getEObjectOrProxy.eIsProxy)
						return from
					var result = EcoreUtil.create(from.getEClass()) as InternalEObject
					result.eSetProxyURI(from.getEObjectURI)
					var Map<String, String> userData = null
					for (key : from.userDataKeys) {
						if (userData == null)
							userData = Maps.newHashMapWithExpectedSize(2)
						userData.put(key, from.getUserData(key))
					}
					return EObjectDescription.create(from.name, result, userData)
				]
			)
		}

		override protected List<IEObjectDescription> computeExportedObjects() {
			return exported
		}

		override Iterable<QualifiedName> getImportedNames() {
			// Should never be called during indexing.
			// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=344373
			var IllegalStateException exception = new IllegalStateException('''getImportedNames «URI»''')
			LOG.error(exception, exception)
			return emptyList
		}

		override Iterable<IReferenceDescription> getReferenceDescriptions() {
			// Should never be called during indexing.
			// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=344373
			var IllegalStateException exception = new IllegalStateException('''getReferenceDescriptions «URI»''')
			LOG.error(exception, exception)
			return emptyList
		}
	}
}
				