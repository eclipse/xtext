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
import io.typefox.lsapi.DidChangeConfigurationParams
import io.typefox.lsapi.DidChangeWatchedFilesParams
import io.typefox.lsapi.FileEvent
import io.typefox.lsapi.InitializeParams
import io.typefox.lsapi.WorkspaceService
import io.typefox.lsapi.WorkspaceSymbolParams
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.build.BuildRequest
import org.eclipse.xtext.build.IncrementalBuilder
import org.eclipse.xtext.build.IndexState
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.ProjectDescription
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.validation.Issue

/**
 * @author efftinge - Initial contribution and API
 */
class WorkspaceServiceImpl implements WorkspaceService {
    
    @Inject
    protected IncrementalBuilder incrementalBuilder

    @Inject
    protected Provider<XtextResourceSet> resourceSetProvider
    
    @Inject
    protected IResourceServiceProvider.Registry languagesRegistry
    
    protected IndexState indexState = new IndexState
    
    @Inject IFileSystemScanner fileSystemScanner
    
    URI baseDir
    
    (URI, Iterable<Issue>)=>void issueAcceptor
    
    public def void initialize(InitializeParams params, (URI, Iterable<Issue>)=>void acceptor) {
        val uris = newArrayList
        this.baseDir = URI.createFileURI(params.rootPath)
        this.issueAcceptor = acceptor
        fileSystemScanner.scan(URI.createFileURI(params.rootPath)) [uris += it]
        val result = incrementalBuilder.build(newBuildRequest(uris, emptyList),[languagesRegistry.getResourceServiceProvider(it)])
        indexState = result.indexState
    }
    
    override didChangeConfiguraton(DidChangeConfigurationParams param) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override didChangeWatchedFiles(DidChangeWatchedFilesParams fileChanges) {
        val dirtyFiles = newArrayList
        val deletedFiles = newArrayList
        for (fileEvent : fileChanges.changes) {
            if (fileEvent.type === FileEvent.TYPE_DELETED) {
                deletedFiles += URI.createFileURI(fileEvent.uri)
            } else {
                dirtyFiles += URI.createFileURI(fileEvent.uri)
            }
        }
        val result = incrementalBuilder.build(newBuildRequest(dirtyFiles, deletedFiles),[languagesRegistry.getResourceServiceProvider(it)])
        indexState = result.indexState
    }
    
    override symbol(WorkspaceSymbolParams param) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    protected def BuildRequest newBuildRequest(List<URI> changedFiles, List<URI> deletedFiles) {
        new BuildRequest => [
            it.baseDir = baseDir
            it.resourceSet = createFreshResourceSet(new ResourceDescriptionsData(emptyList))
            it.state = new IndexState(indexState.resourceDescriptions.copy, indexState.fileMappings.copy)
            it.resourceSet = createFreshResourceSet(state.resourceDescriptions)
            it. dirtyFiles = changedFiles
            it.deletedFiles = deletedFiles
            afterValidate = [ uri, issues|
                issueAcceptor.apply(uri, issues)
                return true
            ]
        ]
    }
    
    protected def XtextResourceSet createFreshResourceSet(ResourceDescriptionsData newIndex) {
        resourceSetProvider.get => [
            val projectDescription = new ProjectDescription => [
                name = 'test-project'
            ]
            projectDescription.attachToEmfObject(it)
            val index = new ChunkedResourceDescriptions(emptyMap, it)
            index.setContainer(projectDescription.name, newIndex)
        ]
    }
    
}