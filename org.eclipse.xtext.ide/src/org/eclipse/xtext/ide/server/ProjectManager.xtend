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
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.resource.IExternalContentSupport
import org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.ProjectDescription
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.IFileSystemScanner
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.workspace.ProjectConfigAdapter
import org.eclipse.xtext.resource.IResourceDescription

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

    @Accessors(PUBLIC_GETTER)
    URI baseDir
    
    (URI, Iterable<Issue>)=>void issueAcceptor
    Provider<Map<String, ResourceDescriptionsData>> indexProvider
    IExternalContentProvider openedDocumentsContentProvider
    
    @Accessors(PUBLIC_GETTER)
    XtextResourceSet resourceSet
    
    @Accessors(PUBLIC_GETTER)
    ProjectDescription projectDescription
    IProjectConfig projectConfig
    
    def void initialize(ProjectDescription description, IProjectConfig projectConfig, (URI, Iterable<Issue>)=>void acceptor, IExternalContentProvider openedDocumentsContentProvider, Provider<Map<String, ResourceDescriptionsData>> indexProvider, CancelIndicator cancelIndicator) {
        this.projectDescription = description
        this.projectConfig = projectConfig
        this.baseDir = projectConfig.path
        this.issueAcceptor = acceptor
        this.openedDocumentsContentProvider = openedDocumentsContentProvider
        this.indexProvider = indexProvider
    }
    
    def Result doInitialBuild(CancelIndicator cancelIndicator) {
        val uris = newArrayList
        projectConfig.sourceFolders.forEach [
            fileSystemScanner.scan(path) [uris += it]
        ] 
        return doBuild(uris, emptyList, emptyList, cancelIndicator)        
    } 

    def Result doBuild(List<URI> dirtyFiles, List<URI> deletedFiles, List<IResourceDescription.Delta> externalDeltas, CancelIndicator cancelIndicator) {
        val request = newBuildRequest(dirtyFiles, deletedFiles, externalDeltas, cancelIndicator)
        val result = incrementalBuilder.build(request, [
            languagesRegistry.getResourceServiceProvider(it)
        ])
        indexState = result.indexState
        resourceSet = request.resourceSet
        indexProvider.get.put(projectDescription.name, indexState.resourceDescriptions)
        return result;
    }

    protected def BuildRequest newBuildRequest(List<URI> changedFiles, List<URI> deletedFiles, List<IResourceDescription.Delta> externalDeltas, CancelIndicator cancelIndicator) {
        new BuildRequest => [
            it.baseDir = baseDir
            it.state = new IndexState(indexState.resourceDescriptions.copy, indexState.fileMappings.copy)
            it.resourceSet = createFreshResourceSet(state.resourceDescriptions)
            it.dirtyFiles = changedFiles
            it.deletedFiles = deletedFiles
            it.externalDeltas = externalDeltas
            afterValidate = [ uri, issues |
                issueAcceptor.apply(uri, issues)
                return true
            ]
            it.cancelIndicator = cancelIndicator
        ]
    }

	public def XtextResourceSet createNewResourceSet(ResourceDescriptionsData newIndex) {
		resourceSetProvider.get => [
            projectDescription.attachToEmfObject(it)
            ProjectConfigAdapter.install(it, projectConfig)
            val index = new ChunkedResourceDescriptions(indexProvider.get, it)
            index.setContainer(projectDescription.name, newIndex)
            externalContentSupport.configureResourceSet(it, openedDocumentsContentProvider)
        ]		
	}

    protected def XtextResourceSet createFreshResourceSet(ResourceDescriptionsData newIndex) {
        if (this.resourceSet === null) {
            this.resourceSet = createNewResourceSet(newIndex)
        } else {
            val resDescs = ChunkedResourceDescriptions.findInEmfObject(this.resourceSet);
            // update index with possible upstream changes
            for (entry : indexProvider.get.entrySet) {
                resDescs.setContainer(entry.key, entry.value)   
            }
            resDescs.setContainer(projectDescription.name, newIndex)   
        }
        return this.resourceSet;
    }
    
    def Resource getResource(URI uri) {
        val resource = resourceSet.getResource(uri, true)
        // initialize
        resource.contents
        return resource
    }
    
    def void reportProjectIssue(String message, String code, Severity severity) {
        issueAcceptor.apply(baseDir, #[
            new Issue.IssueImpl => [
                it.message = message
                it.code = code
                it.severity = severity
                it.uriToProblem = baseDir
            ]
        ])
    }
}
