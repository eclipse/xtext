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
import java.util.ArrayList
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.validation.Issue

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class WorkspaceManager {

    @Inject Provider<ProjectManager> projectManagerProvider
    Map<URI, ProjectManager> baseDir2ProjectManager = newHashMap()

    URI baseDir
    Map<URI, Document> openDocuments = newHashMap()
    val openedDocumentsContentProvider = new IExternalContentProvider() {

        override getActualContentProvider() {
            return this
        }

        override getContent(URI uri) {
            openDocuments.get(uri)?.contents
        }

        override hasContent(URI uri) {
            openDocuments.containsKey(uri)
        }
    };
    Map<String, ResourceDescriptionsData> fullIndex = newHashMap()

    def void initialize(URI baseDir, (URI, Iterable<Issue>)=>void acceptor) {
        this.baseDir = baseDir
        // TODO support multi-projects
        // We will need to figure out how we can identify project structure, dependencies, source folders, etc...
        val projectManager = projectManagerProvider.get
        val indexResult = projectManager.initialize(baseDir, acceptor, openedDocumentsContentProvider, [fullIndex])
        baseDir2ProjectManager.put(baseDir, projectManager)
        fullIndex.put("DEFAULT", indexResult.indexState.resourceDescriptions)
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
        //TODO sort projects by dependency
        val allDirty = new ArrayList(dirtyFiles)
        for (entry : baseDir2ProjectManager.entrySet) {
            val result = entry.value.doBuild(allDirty.filter[isPrefix(entry.key)].toList, deletedFiles.filter[isPrefix(entry.key)].toList)
            allDirty.addAll(result.affectedResources.map[uri])
        }
    }

    def URI getProjectBaseDir(URI candidate) {
        for (projectBaseDir : baseDir2ProjectManager.keySet.sortBy[-toString.length]) {
            if (isPrefix(candidate, projectBaseDir)) {
                return projectBaseDir
            }
        }
        return baseDir
    }
    
    protected def boolean isPrefix(URI candidate, URI prefix) {
        candidate.toString.startsWith(prefix.toString)
    }

    def ProjectManager getProjectManager(URI uri) {
        val projectBaseDir = getProjectBaseDir(uri)
        return baseDir2ProjectManager.get(projectBaseDir)
    }

    def URI toUri(String path) {
        URI.createURI(baseDir.toString + path)
    }

    def toPath(URI uri) {
        uri.toString.substring(baseDir.toString.length)
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
    
    def didClose(DidCloseTextDocumentParams changeEvent) {
        val uri = toUri(changeEvent.textDocument.uri)
        openDocuments.remove(uri)
        doBuild(#[uri], newArrayList)    
    }
    
    def didSave(DidSaveTextDocumentParams changeEvent) {
        // do nothing for now
    }

}
