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
import io.typefox.lsapi.DidChangeTextDocumentParams
import io.typefox.lsapi.DidChangeWatchedFilesParams
import io.typefox.lsapi.DidCloseTextDocumentParams
import io.typefox.lsapi.DidOpenTextDocumentParams
import io.typefox.lsapi.DidSaveTextDocumentParams
import io.typefox.lsapi.FileEvent
import java.util.List
import java.util.Map
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
import org.eclipse.xtext.resource.IExternalContentSupport
import org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class WorkspaceManager {

    @Inject protected IncrementalBuilder incrementalBuilder
    @Inject protected Provider<XtextResourceSet> resourceSetProvider
    @Inject protected IResourceServiceProvider.Registry languagesRegistry
    @Inject protected IFileSystemScanner fileSystemScanner
    @Inject protected IExternalContentSupport externalContentSupport

    IndexState indexState = new IndexState
    URI baseDir
    (URI, Iterable<Issue>)=>void issueAcceptor
    Map<URI, Document> openDocuments = newHashMap()

    def void initialize(URI baseDir, (URI, Iterable<Issue>)=>void acceptor) {
        val uris = newArrayList
        this.baseDir = baseDir
        this.issueAcceptor = acceptor
        this.fileSystemScanner.scan(baseDir)[uris += it]
        doBuild(uris, emptyList)
    }

    def didChangeWatchedFiles(DidChangeWatchedFilesParams fileChanges) {
        val dirtyFiles = newArrayList
        val deletedFiles = newArrayList
        for (fileEvent : fileChanges.changes) {
            if (fileEvent.type === FileEvent.TYPE_DELETED) {
                deletedFiles += toUri(fileEvent.uri)
            } else {
                dirtyFiles += toUri(fileEvent.uri)
            }
        }
        doBuild(dirtyFiles, deletedFiles)
    }
    
    def void doBuild(List<URI> dirtyFiles, List<URI> deletedFiles) {
        val result = incrementalBuilder.build(newBuildRequest(dirtyFiles, deletedFiles), [
            languagesRegistry.getResourceServiceProvider(it)
        ])
        indexState = result.indexState
    }
    
    def didChange(DidChangeTextDocumentParams changeEvent) {
        val uri = toUri(changeEvent.textDocument.uri)
        val contents = openDocuments.get(uri)
        openDocuments.put(uri, contents.applyChanges(changeEvent.contentChanges))
        doBuild(#[uri], newArrayList)
    }
    
    def didOpen(DidOpenTextDocumentParams changeEvent) {
        val uri = toUri(changeEvent.textDocument.uri)
        openDocuments.put(uri, new Document(changeEvent.textDocument.version, changeEvent.textDocument.text))
        doBuild(#[uri], newArrayList)
    }
    
    def URI toUri(String path) {
        URI.createURI(baseDir.toString + path)
    }
    
    def toPath(org.eclipse.emf.common.util.URI uri) {
        uri.toString.substring(baseDir.toString.length)
    }
    
    def didClose(DidCloseTextDocumentParams changeEvent) {
        val uri = toUri(changeEvent.textDocument.uri)
        openDocuments.remove(uri)
        doBuild(#[uri], newArrayList)    
    }
    
    def didSave(DidSaveTextDocumentParams changeEvent) {
        // do nothing for now
    }

    protected def BuildRequest newBuildRequest(List<URI> changedFiles, List<URI> deletedFiles) {
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
            externalContentSupport.configureResourceSet(it, new IExternalContentProvider() {
                
                override getActualContentProvider() {
                    return this
                }
                
                override getContent(URI uri) {
                    openDocuments.get(uri)?.contents
                }
                
                override hasContent(URI uri) {
                    openDocuments.containsKey(uri)
                }
             })
        ]
    }
    
    
    
}
