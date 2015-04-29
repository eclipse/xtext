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
import org.eclipse.xtext.resource.CompilerPhases
import org.eclipse.xtext.resource.IResourceDescription
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
	
	@Inject IJavaDependencyFinder javaDependencyFinder

	@Inject Source2GeneratedMapping source2GeneratedMapping
	
	ResourceDescriptionsData index

	def Iterable<URI> computeAndIndexAffected(BuildRequest request, extension BuildContext context) {
		val fullBuild = request.fullBuild || index == null
		
		LOG.info('Creating new index')
		val ResourceDescriptionsData newIndex = index?.copy ?: new ResourceDescriptionsData(newArrayList)
		val resourceDescriptions = installIndex(resourceSet, newIndex)

		val allResources = uriCollector.collectAllResources(request, context)
		val jvmLanguageExtensions = languages
				.entrySet
				.filter[value.linksAgainstJava]
				.map[key]
				.toSet

		val affectionCandidates = newHashSet
		var Iterable<URI> directlyAffected = null
		var boolean isConsiderJava 
		if (fullBuild) {
			directlyAffected = allResources
			isConsiderJava = allResources.exists[jvmLanguageExtensions.contains(fileExtension)]
		} else {
			val allModified = (request.dirtyFiles + request.deletedFiles).toSet
			affectionCandidates += allResources.filter[!allModified.contains(it)]
			directlyAffected = request.dirtyFiles
			isConsiderJava = allModified.exists[jvmLanguageExtensions.contains(fileExtension)]
		}

		LOG.info('Removing deleted files from index')
		val currentDeltas = <IResourceDescription.Delta>newArrayList
		request.deletedFiles.forEach [
			if(fileExtension != 'java') {
				val IResourceDescription oldDescription = index.getResourceDescription(it)
				if (oldDescription != null)
					currentDeltas += new DefaultResourceDescriptionDelta(oldDescription, null)
				newIndex.removeDescription(it)
			}
		]

		val allAffected = <URI>newHashSet
		allAffected += directlyAffected
		if (isConsiderJava) 
			javaSupport.installLocalOnlyTypeProvider(request.sourceRoots  + request.outputs + request.classPath, resourceSet)
		preIndexChangedResources(directlyAffected, newIndex, request, context)
		if(isConsiderJava) {
			val preCompiledClasses = javaSupport.preCompileJavaFiles(directlyAffected, newIndex, request, context)
			javaSupport.installTypeProvider(#[preCompiledClasses] + request.sourceRoots  + request.outputs + request.classPath, resourceSet)
		}
	
		LOG.info("Indexing changed and added files")
		val toBeIndexed = newArrayList
		toBeIndexed.addAll(directlyAffected)
		val allDeltas = newHashSet
		while (!toBeIndexed.empty) {
			allAffected.addAll(toBeIndexed)
			toBeIndexed.executeClustered [ Resource resource |
				LOG.info('Indexing ' + resource.URI)
				currentDeltas += resource.addToIndex(false, newIndex, context)
				null
			]
			toBeIndexed.clear
			allDeltas += currentDeltas
			if(isConsiderJava) {
				
			}
				// TODO: Java dependencies
//			if (needsJava) {
//				val dependentJavaFiles = javaDependencyFinder.getDependentJavaFiles(toBeIndexed.filter [
//					fileExtension == 'java'
//				])
//			// addJavaDependencies
////				toBeIndexed.addAll(DSL deps by java)
//			}
			toBeIndexed.addAll(
				affectionCandidates.filter [
					if(fileExtension == 'java')
						return false
					val manager = languages.get(fileExtension).resourceDescriptionManager
					val resourceDescription = index.getResourceDescription(it)
					resourceDescription.isAffected(manager, currentDeltas, allDeltas, resourceDescriptions)
				])
			affectionCandidates.removeAll(toBeIndexed)
			currentDeltas.clear
			if(!toBeIndexed.empty)
				LOG.info('Indexing affected files')
		}
		index = newIndex
		return allAffected
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