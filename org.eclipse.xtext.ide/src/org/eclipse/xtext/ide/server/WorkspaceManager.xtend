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
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.workspace.IWorkspaceConfig

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
class WorkspaceManager {

    @Inject Provider<ProjectManager> projectManagerProvider
    @Inject IWorkspaceConfigFactory workspaceConfigFactory
    @Inject IProjectDescriptionFactory projectDescriptionFactory
    @Inject BuildManager buildManager
    
    Map<String, ProjectManager> projectName2ProjectManager = newHashMap

    URI baseDir
    IWorkspaceConfig workspaceConfig

    Map<String, ResourceDescriptionsData> fullIndex = newHashMap()
    
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
    
    def void initialize(URI baseDir, (URI, Iterable<Issue>)=>void acceptor, CancelIndicator cancelIndicator) {
        this.baseDir = baseDir
        workspaceConfig = workspaceConfigFactory.getWorkspaceConfig(baseDir)
        workspaceConfig.projects.forEach [ projectConfig | 
            val projectManager = projectManagerProvider.get
            val projectDescription =  projectDescriptionFactory.getProjectDescription(projectConfig)
            projectManager.initialize(projectDescription, projectConfig, acceptor, openedDocumentsContentProvider, [fullIndex], cancelIndicator)
            projectName2ProjectManager.put(projectDescription.name, projectManager)
        ]
        buildManager.doFullBuild(cancelIndicator)
    }

    def void doBuild(List<URI> dirtyFiles, List<URI> deletedFiles, CancelIndicator cancelIndicator) {
    	buildManager.doBuild(dirtyFiles, deletedFiles, cancelIndicator)
    }
    
    def IResourceDescriptions getIndex() {
    	return new ChunkedResourceDescriptions(fullIndex)
    }

    def URI getProjectBaseDir(URI candidate) {
        val projectConfig = workspaceConfig.findProjectContaining(candidate)
        projectConfig.path
    }
    
    def ProjectManager getProjectManager(URI uri) {
        val projectConfig = workspaceConfig.findProjectContaining(uri)
        return projectName2ProjectManager.get(projectConfig.name)
    }
    
    def ProjectManager getProjectManager(String projectName) {
        projectName2ProjectManager.get(projectName)
    }
    
    def List<ProjectManager> getProjectManagers() {
        new ArrayList(projectName2ProjectManager.values)
    }

    def didChange(URI uri, int version, Iterable<TextEdit> changes, CancelIndicator cancelIndicator) {
        val contents = openDocuments.get(uri)
        openDocuments.put(uri, contents.applyChanges(changes))
        doBuild(#[uri], newArrayList, cancelIndicator)
    }
    
    def didOpen(URI uri, int version, String contents, CancelIndicator cancelIndicator) {
        openDocuments.put(uri, new Document(version, contents))
        doBuild(#[uri], newArrayList, cancelIndicator)
    }
    
    def didClose(URI uri, CancelIndicator cancelIndicator) {
        openDocuments.remove(uri)
        doBuild(#[uri], newArrayList, cancelIndicator)    
    }
    
    def didSave(URI uri, CancelIndicator cancelIndicator) {
        // do nothing for now
    }
    
    def <T> T doRead(URI uri, (Document, XtextResource)=>T work) {
    	val resourceURI = uri.trimFragment
    	val projectMnr = getProjectManager(resourceURI)
        val doc = openDocuments.get(resourceURI)
        return work.apply(doc, projectMnr.getResource(resourceURI) as XtextResource)
    }
    
    def <T> void doWrite(URI uri, (Document, XtextResource)=>T work) {
        
    }

}
