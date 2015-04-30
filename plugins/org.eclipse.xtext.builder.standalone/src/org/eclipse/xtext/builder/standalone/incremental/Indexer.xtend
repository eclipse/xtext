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
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.mwe.ResourceDescriptionsProvider
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.CompilerPhases
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData

import static extension org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs.*

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

	@Inject Source2GeneratedMapping source2GeneratedMapping
	
	@Inject IQualifiedNameConverter qualifiedNameConverter
	
	ResourceDescriptionsData index

	def Iterable<URI> computeAndIndexAffected(BuildRequest request, extension BuildContext context) {
		val fullBuild = request.fullBuild || index == null
		if(fullBuild) 
			LOG.info('Performing full build')
		else
			LOG.info('Performing incremental build')
			
		LOG.info('Creating new index')
		val ResourceDescriptionsData newIndex = index?.copy ?: new ResourceDescriptionsData(newArrayList)
		val resourceDescriptions = installIndex(resourceSet, newIndex)

		val isConsiderJava = !languages
				.entrySet
				.filter[value.linksAgainstJava]
				.empty

		val affectionCandidates = newHashSet
		var Iterable<URI> directlyAffected = null
		if (fullBuild) {
			directlyAffected = uriCollector.collectAllResources(request, context).toSet
		} else {
			val allModified = (request.dirtyFiles + request.deletedFiles).toSet
			affectionCandidates += index.allURIs.filter[!allModified.contains(it)]
			directlyAffected = request.dirtyFiles.map[primarySources].flatten.toSet
		}

		val currentDeltas = <IResourceDescription.Delta>newArrayList
		currentDeltas += request.removeDeletedFilesFromIndex(newIndex)

		if (isConsiderJava) 
			javaSupport.installLocalOnlyTypeProvider(
				request.sourceRoots  + request.outputs + request.classPath, resourceSet)
		preIndexChangedResources(directlyAffected, newIndex, request, context)
		if(isConsiderJava) {
			val preCompiledClasses = javaSupport.preCompileJavaFiles(directlyAffected, newIndex, request, context)
			javaSupport.installTypeProvider(
				#[preCompiledClasses] + request.sourceRoots  + request.outputs + request.classPath, 
				resourceSet)
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
						.map[source2GeneratedMapping.getGenerated(it)]
						.flatten
					+ toBeIndexed)
						.filter[fileExtension=='java']
						.toSet
				val deletedPrimaryJavaFiles = request
					.deletedFiles
					.map[primarySources]
					.flatten
					.filter[fileExtension=='java']
				val dependentJavaFiles = javaDependencyFinder.getDependentJavaFiles(
						affectedJavaFiles, deletedPrimaryJavaFiles)
				toBeIndexed += 
					dependentJavaFiles
						.map[primarySources]
						.flatten
						.filter[fileExtension=='java' || affectionCandidates.contains(it)]
			}
			allAffected.addAll(toBeIndexed)
			affectionCandidates.removeAll(toBeIndexed)
			toBeIndexed.executeClustered [ Resource resource |
				LOG.info('Indexing ' + resource.URI)
				currentDeltas += resource.addToIndex(false, newIndex, context)
				null
			]
			toBeIndexed.filter[fileExtension=='java'].forEach [
				// FIXME: this will only work for the public top-level type
				val javaPath = findSourceRootRelativeURI(request).trimFileExtension.toString
				val fqn = qualifiedNameConverter.toQualifiedName(javaPath.replace('/', '.'))
				currentDeltas += new TypeResourceDescription.ChangedDelta(fqn)
			]
			allDeltas += currentDeltas
			
			toBeIndexed.clear
			toBeIndexed.addAll(
				affectionCandidates.filter [
					if(fileExtension == 'java')
						return false
					val manager = languages.get(fileExtension).resourceDescriptionManager
					val resourceDescription = index.getResourceDescription(it)
					resourceDescription.isAffected(manager, currentDeltas, allDeltas, resourceDescriptions)
				])
			currentDeltas.clear
			if(!toBeIndexed.empty) 
				LOG.info('Indexing affected files')
		}
		index = newIndex
		return allAffected
	}
	
	private def getPrimarySources(URI uri) {
		val sources = source2GeneratedMapping.getSource(uri)
		if(sources.empty) 
			#[uri] 
		else 
			sources
	}
	
	def removeDeletedFilesFromIndex(BuildRequest request, ResourceDescriptionsData newIndex) {
		LOG.info('Removing deleted files from index')
		val deltas = <Delta>newArrayList
		request.deletedFiles.forEach [
			if(fileExtension != 'java') {
				val IResourceDescription oldDescription = index?.getResourceDescription(it)
				if (oldDescription != null)
					deltas += new DefaultResourceDescriptionDelta(oldDescription, null)
				newIndex.removeDescription(it)
			}
		]
		return deltas
	}

	protected def preIndexChangedResources(Iterable<URI> directlyAffected, ResourceDescriptionsData newIndex, BuildRequest request,
		extension BuildContext context) {
		LOG.info("Pre-indexing changed files")
		try {
			compilerPhases.setIndexing(resourceSet, true)
			directlyAffected
				.executeClustered [
					addToIndex(true, newIndex, context)
					null
				]
		} finally {
			compilerPhases.setIndexing(resourceSet, false)
		}
	}

	def protected addToIndex(Resource resource, boolean isPreIndexing, ResourceDescriptionsData newIndex, BuildContext context) {
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
		val delta = new DefaultResourceDescriptionDelta(index?.getResourceDescription(uri), toBeAdded)
		delta
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