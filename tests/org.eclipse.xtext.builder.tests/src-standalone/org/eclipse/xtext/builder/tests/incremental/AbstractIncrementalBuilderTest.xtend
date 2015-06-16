/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.tests.incremental

import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.Multimap
import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest
import org.eclipse.xtext.builder.standalone.incremental.IncrementalBuilder
import org.eclipse.xtext.builder.standalone.incremental.IndexState
import org.eclipse.xtext.junit4.util.InMemoryURIHandler
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.validation.Issue
import org.junit.Before

/**
 * Abstract base class for testing incremental builder.
 */
abstract class AbstractIncrementalBuilderTest {
	
	@Inject protected IncrementalBuilder incrementalBuilder
	@Inject protected IndexState indexState
	@Inject protected Provider<XtextResourceSet> resourceSetProvider
	
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
		this.indexState = incrementalBuilder.build(buildRequest, getLanguages).indexState
		return indexState
	}
	
	abstract protected def IResourceServiceProvider.Registry getLanguages();

	protected def newBuildRequest((BuildRequest)=>void init) {
		val result = new BuildRequest => [
			baseDir = "".uri
			resourceSet = resourceSetProvider.get => [
				URIConverter.URIHandlers.clear
				URIConverter.URIHandlers += inMemoryURIHandler
				
				classpathURIContext = AbstractIncrementalBuilderTest.classLoader
			]
			classPath = #[]
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
			
			previousState = indexState
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