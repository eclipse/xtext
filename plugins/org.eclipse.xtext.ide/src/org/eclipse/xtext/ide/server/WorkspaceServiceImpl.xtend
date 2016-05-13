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
import io.typefox.lsapi.InitializeParams
import io.typefox.lsapi.WorkspaceService
import io.typefox.lsapi.WorkspaceSymbolParams
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.build.BuildRequest
import org.eclipse.xtext.build.IncrementalBuilder
import org.eclipse.xtext.build.IndexState
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.validation.Issue

/**
 * @author efftinge - Initial contribution and API
 */
class WorkspaceServiceImpl implements WorkspaceService {
    
    @Inject
    protected IncrementalBuilder incrementalBuilder

    @Inject
    protected IndexState indexState

    @Inject
    protected Provider<XtextResourceSet> resourceSetProvider
    
    @Inject
    protected IResourceServiceProvider.Registry languagesRegistry
    
    @Inject IFileSystemScanner fileSystemScanner
    
    public def void initialize(InitializeParams params, (URI, Iterable<Issue>)=>void acceptor) {
        val uris = newArrayList
        fileSystemScanner.scan(URI.createFileURI(params.rootPath)) [uris += it]
        incrementalBuilder.build(new BuildRequest => [
            it.baseDir = URI.createFileURI(params.rootPath)
            it.resourceSet = resourceSetProvider.get
            dirtyFiles = uris
            afterValidate = [ uri, issues|
                if (!issues.empty)
                    acceptor.apply(uri, issues)
                return true
            ]
        ],[languagesRegistry.getResourceServiceProvider(it)])
    }
    
    
    override didChangeConfiguraton(DidChangeConfigurationParams param) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override didChangeWatchedFiles(DidChangeWatchedFilesParams param) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
    override symbol(WorkspaceSymbolParams param) {
        throw new UnsupportedOperationException("TODO: auto-generated method stub")
    }
    
}