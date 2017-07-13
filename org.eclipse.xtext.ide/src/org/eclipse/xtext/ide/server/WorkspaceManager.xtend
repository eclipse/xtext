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
import java.util.ArrayList
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.lsp4j.TextEdit
import org.eclipse.xtext.ide.server.ILanguageServerAccess.IBuildListener
import org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.workspace.IWorkspaceConfig

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@Log class WorkspaceManager {
	
    @Inject Provider<ProjectManager> projectManagerProvider
    @Inject IWorkspaceConfigFactory workspaceConfigFactory
    @Inject IProjectDescriptionFactory projectDescriptionFactory
    BuildManager buildManager
    
    Map<String, ProjectManager> projectName2ProjectManager = newHashMap

    URI baseDir
    (URI, Iterable<Issue>)=>void issueAcceptor
    IWorkspaceConfig workspaceConfig
    
    List<IBuildListener> buildListeners = newArrayList
    
    def void addBuildListener(IBuildListener listener) {
    	this.buildListeners += listener	
    }
    
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
    
    @Inject
    def void setBuildManager(BuildManager buildManager) {
        buildManager.workspaceManager = this
        this.buildManager = buildManager
    }
    
    def void initialize(URI baseDir, (URI, Iterable<Issue>)=>void issueAcceptor, CancelIndicator cancelIndicator) {
        this.baseDir = baseDir
        this.issueAcceptor = issueAcceptor
        refreshWorkspaceConfig(cancelIndicator)
    }
    
    protected def refreshWorkspaceConfig(CancelIndicator cancelIndicator) {
        workspaceConfig = workspaceConfigFactory.getWorkspaceConfig(baseDir)
        val newProjects = newArrayList
        val remainingProjectNames = newHashSet(projectName2ProjectManager.keySet)
        workspaceConfig.projects.forEach [ projectConfig | 
            if(projectName2ProjectManager.containsKey(projectConfig.name)) {
                remainingProjectNames.remove(projectConfig.name)
            } else {
                val projectManager = projectManagerProvider.get
                val projectDescription =  projectDescriptionFactory.getProjectDescription(projectConfig)
                projectManager.initialize(projectDescription, projectConfig, issueAcceptor, openedDocumentsContentProvider, [fullIndex], cancelIndicator)
                projectName2ProjectManager.put(projectDescription.name, projectManager)
                newProjects.add(projectDescription)
            } 
        ]
        for(deletedProject: remainingProjectNames) {
            projectName2ProjectManager.remove(deletedProject)
            fullIndex.remove(deletedProject)
        }
        val result = buildManager.doInitialBuild(newProjects, cancelIndicator)
        afterBuild(result)
    }
	
	protected def afterBuild(List<Delta> deltas) {
		for (listener : buildListeners) {
			listener.afterBuild(deltas)
		}
	}

    def List<IResourceDescription.Delta> doBuild(List<URI> dirtyFiles, List<URI> deletedFiles, CancelIndicator cancelIndicator) {
    	val doBuild = buildManager.doBuild(dirtyFiles, deletedFiles, cancelIndicator)
    	afterBuild(doBuild)
		return doBuild
    }
    
    def IResourceDescriptions getIndex() {
    	return new ChunkedResourceDescriptions(fullIndex)
    }

    def URI getProjectBaseDir(URI candidate) {
        val projectConfig = workspaceConfig.findProjectContaining(candidate)
        projectConfig?.path
    }
    
    def ProjectManager getProjectManager(URI uri) {
        val projectConfig = workspaceConfig.findProjectContaining(uri)
        return projectName2ProjectManager.get(projectConfig?.name)
    }
    
    def ProjectManager getProjectManager(String projectName) {
        projectName2ProjectManager.get(projectName)
    }
    
    def List<ProjectManager> getProjectManagers() {
        new ArrayList(projectName2ProjectManager.values)
    }

    def didChange(URI uri, int version, Iterable<TextEdit> changes, CancelIndicator cancelIndicator) {
        if (!openDocuments.containsKey(uri)) {
            LOG.error("The document "+uri+" has not been opened.")
            return;
        }
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
        if (exists(uri)) {
            doBuild(#[uri], newArrayList, cancelIndicator)
        } else {
            doBuild(newArrayList, #[uri], cancelIndicator)
        }
    }
    
    protected def boolean exists(URI uri) {
        getProjectManager(uri)?.resourceSet.URIConverter.exists(uri, null)
    }
    
    def <T> T doRead(URI uri, (Document, XtextResource)=>T work) {
        val resourceURI = uri.trimFragment
        val projectMnr = getProjectManager(resourceURI)
        val resource = projectMnr?.getResource(resourceURI) as XtextResource
        if (resource === null) {
            	return work.apply(null, null)
        }
        var doc = getDocument(resource)
        return work.apply(doc, projectMnr.getResource(resourceURI) as XtextResource)
    }
    
    protected def Document getDocument(XtextResource resource) {
        return openDocuments.get(resource.URI) 
            // lets create a transient document, in case a document is not open (e.g. formatting is called just by uri)
            ?: new Document(1, resource.parseResult.rootNode.text)
    }

	public def boolean isDocumentOpen(URI uri) {
		return openDocuments.containsKey(uri)
	}
}
