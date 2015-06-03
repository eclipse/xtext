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
import java.util.Set
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.mwe.ResourceDescriptionsProvider
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.CompilerPhases
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9 
 */
@Singleton
class Indexer {

	static val LOG = Logger.getLogger(Indexer)

	@Inject ResourceURICollector uriCollector

	@Inject JavaSupport javaSupport

	@Inject CompilerPhases compilerPhases

	@Inject ResourceDescriptionsProvider resourceDescriptionsProvider
	
	@Inject IClassFileBasedDependencyFinder javaDependencyFinder

	@Inject IQualifiedNameConverter qualifiedNameConverter
	
	@Data static class IndexResult {
		Set<Delta> resourceDeltas
		Set<URI> affectedResources
		ResourceDescriptionsData newIndex
	}
	
	def IndexResult computeAndIndexAffected(BuildRequest request, extension BuildContext context) {
		val fullBuild = request.fullBuild
		if(fullBuild) 
			LOG.info('Performing full build')
		else
			LOG.info('Performing incremental build')
			
		LOG.info('Creating new index')
		val fileMappings = request.previousState.fileMappings
		val ResourceDescriptionsData oldIndex = request.previousState.resourceDescriptions
		val ResourceDescriptionsData newIndex = oldIndex.copy
		val resourceDescriptions = installIndex(resourceSet, newIndex)


		val affectionCandidates = newHashSet
		var Set<URI> directlyAffected = null
		if (fullBuild) {
			directlyAffected = uriCollector.collectAllResources(request, context).toSet
		} else {
			val allModified = (request.dirtyFiles + request.deletedFiles).toSet
			affectionCandidates += oldIndex.allURIs.filter[!allModified.contains(it)]
			directlyAffected = request.dirtyFiles.map[primarySources(fileMappings)].flatten.toSet
		}

		val currentDeltas = <IResourceDescription.Delta>newArrayList
		currentDeltas += request.removeDeletedFilesFromIndex(oldIndex, newIndex)

		preIndexChangedResources(directlyAffected, oldIndex, newIndex, request, context)
		val isConsiderJava = languages
				.entrySet
				.exists[value.linksAgainstJava]
		if(isConsiderJava) {
			javaSupport.preCompileJavaFiles(directlyAffected, newIndex, request, context)
		}
	
		LOG.info("Indexing changed and added files")
		val allAffected = newHashSet
		allAffected += directlyAffected
		val toBeIndexed = newHashSet
		toBeIndexed.addAll(directlyAffected)
		val allDeltas = newHashSet
		while (!toBeIndexed.empty) {
			if(isConsiderJava && !fullBuild) {
				val affectedJavaFiles = 
					(toBeIndexed
						.map[fileMappings.getGenerated(it)]
						.flatten
					+ toBeIndexed)
						.filter[fileExtension=='java']
						.toSet
				val deletedPrimaryJavaFiles = request
					.deletedFiles
					.map[primarySources(fileMappings)]
					.flatten
					.filter[fileExtension=='java']
				val dependentJavaFiles = javaDependencyFinder.getDependentJavaFiles(
						affectedJavaFiles, deletedPrimaryJavaFiles)
				toBeIndexed += 
					dependentJavaFiles
						.map[primarySources(fileMappings)]
						.flatten
						.filter[fileExtension=='java' || affectionCandidates.contains(it)]
			}
			allAffected.addAll(toBeIndexed)
			affectionCandidates.removeAll(toBeIndexed)
			toBeIndexed.executeClustered [ Resource resource |
				LOG.info('Indexing ' + resource.URI)
				currentDeltas += resource.addToIndex(false, oldIndex, newIndex, context)
				null
			]
			toBeIndexed.filter[fileExtension=='java'].forEach [
				// FIXME: this will only work for the public top-level type
				val stringUri = it.toString
				for (srcRoot : request.sourceRoots) {
					val srcRootString = srcRoot.toString
					if (stringUri.startsWith(srcRootString)) {
						val javaPath = stringUri.substring(srcRootString.length)
						val fqn = qualifiedNameConverter.toQualifiedName(javaPath.replace('/', '.'))
						currentDeltas += new TypeResourceDescription.ChangedDelta(fqn)
						return;
					}
				}
			]
			allDeltas += currentDeltas
			
			toBeIndexed.clear
			toBeIndexed.addAll(
				affectionCandidates.filter [
					if(fileExtension == 'java')
						return false
					val manager = languages.get(fileExtension).resourceDescriptionManager
					val resourceDescription = oldIndex.getResourceDescription(it)
					resourceDescription.isAffected(manager, currentDeltas, allDeltas, resourceDescriptions)
				])
			currentDeltas.clear
			if(!toBeIndexed.empty) 
				LOG.info('Indexing affected files')
		}
		return new IndexResult(allDeltas, allAffected, newIndex)
	}
	
	private def primarySources(URI uri, Source2GeneratedMapping mappings) {
		val sources = mappings.getSource(uri)
		if(sources.empty) 
			#[uri] 
		else 
			sources
	}
	
	def removeDeletedFilesFromIndex(BuildRequest request, ResourceDescriptionsData oldIndex, ResourceDescriptionsData newIndex) {
		LOG.info('Removing deleted files from index')
		val deltas = <Delta>newArrayList
		request.deletedFiles.forEach [
			if(fileExtension != 'java') {
				val IResourceDescription oldDescription = oldIndex?.getResourceDescription(it)
				if (oldDescription != null)
					deltas += new DefaultResourceDescriptionDelta(oldDescription, null)
				newIndex.removeDescription(it)
			}
		]
		return deltas
	}

	protected def preIndexChangedResources(Iterable<URI> directlyAffected, ResourceDescriptionsData oldIndex, ResourceDescriptionsData newIndex, BuildRequest request,
		extension BuildContext context) {
		LOG.info("Pre-indexing changed files")
		try {
			compilerPhases.setIndexing(resourceSet, true)
			directlyAffected
				.executeClustered [
					addToIndex(true, oldIndex, newIndex, context)
					null
				]
		} finally {
			compilerPhases.setIndexing(resourceSet, false)
		}
	}

	def protected addToIndex(Resource resource, boolean isPreIndexing, ResourceDescriptionsData oldIndex, ResourceDescriptionsData newIndex, BuildContext context) {
		val uri = resource.URI
		val languageAccess = context.languages.get(uri.fileExtension)
		val manager = languageAccess.resourceDescriptionManager
		val newDescription = manager.getResourceDescription(resource)
		val IResourceDescription toBeAdded = 
			if(isPreIndexing) 
				new ResolvedResourceDescription(newDescription)
			else 
				newDescription
		newIndex.addDescription(uri, toBeAdded)
		val delta = new DefaultResourceDescriptionDelta(oldIndex?.getResourceDescription(uri), toBeAdded)
		return delta
	}

	def protected installIndex(XtextResourceSet resourceSet, ResourceDescriptionsData index) {
		ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resourceSet, index)
		resourceDescriptionsProvider.get(resourceSet)
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