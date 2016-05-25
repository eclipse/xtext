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
import io.typefox.lsapi.TextEdit
import java.util.ArrayList
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider
import org.eclipse.xtext.resource.XtextResource
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

    def didChange(URI uri, int version, Iterable<TextEdit> changes) {
        val contents = openDocuments.get(uri)
        openDocuments.put(uri, contents.applyChanges(changes))
        doBuild(#[uri], newArrayList)
    }
    
    def didOpen(URI uri, int version, String contents) {
        openDocuments.put(uri, new Document(version, contents))
        doBuild(#[uri], newArrayList)
    }
    
    def didClose(URI uri) {
        openDocuments.remove(uri)
        doBuild(#[uri], newArrayList)    
    }
    
    def didSave(URI uri) {
        // do nothing for now
    }
    
    def <T> T doRead(URI uri, (Document, XtextResource)=>T work) {
        val projectMnr = getProjectManager(uri)
        val doc = openDocuments.get(uri)
        return work.apply(doc, projectMnr.getResource(uri) as XtextResource)
    }
    
    def <T> void doWrite(URI uri, (Document, XtextResource)=>T work) {
        
    }

}
