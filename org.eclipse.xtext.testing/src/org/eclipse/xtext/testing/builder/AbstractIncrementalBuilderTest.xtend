/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testing.builder

import com.google.common.annotations.Beta
import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.Multimap
import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.name.Named
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.Constants
import org.eclipse.xtext.build.BuildRequest
import org.eclipse.xtext.build.IncrementalBuilder
import org.eclipse.xtext.build.IndexState
import org.eclipse.xtext.generator.OutputConfiguration
import org.eclipse.xtext.generator.OutputConfigurationAdapter
import org.eclipse.xtext.generator.OutputConfigurationProvider
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.ProjectDescription
import org.eclipse.xtext.testing.util.InMemoryURIHandler
import org.eclipse.xtext.validation.Issue
import org.junit.Before

/**
 * Abstract base class for testing languages in the incremental builder.
 * 
 * @since 2.9
 * 
 * @noreference
 * @noimplement
 */
@Beta
abstract class AbstractIncrementalBuilderTest {
	
	@Inject protected IncrementalBuilder incrementalBuilder
	@Inject protected IndexState indexState
	@Inject protected Provider<XtextResourceSet> resourceSetProvider
	@Inject @Named(Constants.LANGUAGE_NAME) String languageName
	@Inject OutputConfigurationProvider configurationProvider
	
	protected Multimap<URI, URI> generated
	protected List<URI> deleted
	protected List<Issue> issues
	protected InMemoryURIHandler inMemoryURIHandler

	@Before def void setUp() {
		clean()
		inMemoryURIHandler = new InMemoryURIHandler()
	}

	protected def clean() {
		generated = ArrayListMultimap.create
		deleted = newArrayList
		issues = newArrayList
	}
	
	protected def IndexState build(BuildRequest buildRequest) {
		clean()
		this.indexState = incrementalBuilder.build(buildRequest, [getLanguages.getResourceServiceProvider(it)]).indexState
		return indexState
	}
	
	protected def void withOutputConfig(BuildRequest it, (OutputConfiguration)=>void init) {
		val config = configurationProvider.outputConfigurations.head
		init.apply(config)
		val adapter = new OutputConfigurationAdapter(#{languageName -> #{config}})
		resourceSet.eAdapters += adapter
	}
	
	abstract protected def IResourceServiceProvider.Registry getLanguages();

	protected def newBuildRequest((BuildRequest)=>void init) {
		val result = new BuildRequest => [
			val newIndex = indexState.resourceDescriptions.copy()
			baseDir = "".uri
			resourceSet = resourceSetProvider.get => [
				getURIConverter.getURIHandlers.clear
				getURIConverter.getURIHandlers += inMemoryURIHandler
				classpathURIContext = AbstractIncrementalBuilderTest.classLoader
				
				val projectDescription = new ProjectDescription => [
					name = 'test-project'
				]
				projectDescription.attachToEmfObject(it)
				val index = new ChunkedResourceDescriptions(emptyMap, it)
				index.setContainer(projectDescription.name, newIndex)
			]
			dirtyFiles = #[]
			deletedFiles = #[]
			
			afterValidate = [ uri, issues |
				this.issues.addAll(issues)
				return issues.empty
			]
			
			afterDeleteFile = [
				deleted += it
			]
			
			afterGenerateFile = [ source, target |
				generated.put(source, target)
			]
			
			state = new IndexState(newIndex, indexState.fileMappings.copy)
		]
		init.apply(result)
		return result
	}
	
	protected def URI delete(URI uri) {
		inMemoryURIHandler.delete(uri, emptyMap)
		return uri
	}

	protected def uri(String path) {
		URI.createURI(InMemoryURIHandler.SCHEME+":/"+path)
	}

	protected def URI -(String path, String content) {
		val uri = path.uri
		inMemoryURIHandler.createOutputStream(uri, emptyMap) => [
			write(content.bytes)
			close	
		]
		return uri
	}
	
	protected def boolean containsSuffix(Iterable<? extends URI> uris, String...suffixes) {
		suffixes.forall[ suffix |
			uris.exists[ uri | uri.toString.endsWith(suffix)]
		]
	}
}
