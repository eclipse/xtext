/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.build.BuildRequest
import org.eclipse.xtext.build.IncrementalBuilder
import org.eclipse.xtext.build.IncrementalBuilder.Result
import org.eclipse.xtext.build.IndexState
import org.eclipse.xtext.resource.IExternalContentSupport
import org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.ProjectDescription
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.util.IFileSystemScanner
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
class ProjectManager {
    
    @Inject protected IncrementalBuilder incrementalBuilder
    @Inject protected Provider<XtextResourceSet> resourceSetProvider
    @Inject protected IResourceServiceProvider.Registry languagesRegistry
    @Inject protected IFileSystemScanner fileSystemScanner
    @Inject protected IExternalContentSupport externalContentSupport
    
    @Accessors(PUBLIC_GETTER)
    IndexState indexState = new IndexState
    URI baseDir
    (URI, Iterable<Issue>)=>void issueAcceptor
    Provider<Map<String, ResourceDescriptionsData>> indexProvider
    IExternalContentProvider openedDocumentsContentProvider
    
    @Accessors(PUBLIC_GETTER)
    XtextResourceSet resourceSet
    
    def Result initialize(URI baseDir, (URI, Iterable<Issue>)=>void acceptor, IExternalContentProvider openedDocumentsContentProvider, Provider<Map<String, ResourceDescriptionsData>> indexProvider, CancelIndicator cancelIndicator) {
        val uris = newArrayList
        this.baseDir = baseDir
        this.issueAcceptor = acceptor
        this.openedDocumentsContentProvider = openedDocumentsContentProvider
        this.indexProvider = indexProvider 
        this.fileSystemScanner.scan(baseDir)[uris += it]
        return doBuild(uris, emptyList, cancelIndicator)
    }
    
    def Result doBuild(List<URI> dirtyFiles, List<URI> deletedFiles, CancelIndicator cancelIndicator) {
        val request = newBuildRequest(dirtyFiles, deletedFiles, cancelIndicator)
        val result = incrementalBuilder.build(request, [
            languagesRegistry.getResourceServiceProvider(it)
        ])
        indexState = result.indexState
        resourceSet = request.resourceSet
        return result;
    }

    protected def BuildRequest newBuildRequest(List<URI> changedFiles, List<URI> deletedFiles, CancelIndicator cancelIndicator) {
        new BuildRequest => [
            it.baseDir = baseDir
            it.resourceSet = createFreshResourceSet(new ResourceDescriptionsData(emptyList))
            it.state = new IndexState(indexState.resourceDescriptions.copy, indexState.fileMappings.copy)
            it.resourceSet = createFreshResourceSet(state.resourceDescriptions)
            it.dirtyFiles = changedFiles
            it.deletedFiles = deletedFiles
            afterValidate = [ uri, issues |
                issueAcceptor.apply(uri, issues)
                return true
            ]
            it.cancelIndicator = cancelIndicator
        ]
    }

    protected def XtextResourceSet createFreshResourceSet(ResourceDescriptionsData newIndex) {
        resourceSetProvider.get => [
            val projectDescription = new ProjectDescription => [
                name = 'test-project'
            ]
            projectDescription.attachToEmfObject(it)
            val index = new ChunkedResourceDescriptions(indexProvider.get, it)
            index.setContainer(projectDescription.name, newIndex)
            externalContentSupport.configureResourceSet(it, openedDocumentsContentProvider)
        ]
    }
    
    def Resource getResource(URI uri) {
        resourceSet.getResource(uri, true)
    }
    
}
