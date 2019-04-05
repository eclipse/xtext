/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.ArrayList
import java.util.HashSet
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.lsp4j.TextEdit
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException
import org.eclipse.lsp4j.jsonrpc.messages.ResponseError
import org.eclipse.lsp4j.jsonrpc.messages.ResponseErrorCode
import org.eclipse.xtext.ide.server.BuildManager.Buildable
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
	IWorkspaceConfig _workspaceConfig

	List<IBuildListener> buildListeners = newArrayList

	def void addBuildListener(IBuildListener listener) {
		this.buildListeners += listener
	}

	/**
	 * Removes a build listener if it was previously registered
	 * 
	 * @since 2.18
	 */
	def void removeBuildListener(IBuildListener listener) {
		buildListeners.remove(listener)
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
	
	protected def void refreshWorkspaceConfig(CancelIndicator cancelIndicator) {
		workspaceConfig = workspaceConfigFactory.getWorkspaceConfig(baseDir)
		val newProjects = newArrayList
		val Set<String> remainingProjectNames = new HashSet(projectName2ProjectManager.keySet)
		workspaceConfig.projects.forEach [ projectConfig |
			if (projectName2ProjectManager.containsKey(projectConfig.name)) {
				remainingProjectNames.remove(projectConfig.name)
			} else {
				val projectManager = projectManagerProvider.get
				val projectDescription = projectDescriptionFactory.getProjectDescription(projectConfig)
				projectManager.initialize(projectDescription, projectConfig, issueAcceptor,
					openedDocumentsContentProvider, [fullIndex], cancelIndicator)
				projectName2ProjectManager.put(projectDescription.name, projectManager)
				newProjects.add(projectDescription)
			}
		]
		for (deletedProject : remainingProjectNames) {
			projectName2ProjectManager.remove(deletedProject)
			fullIndex.remove(deletedProject)
		}
		val result = buildManager.doInitialBuild(newProjects, cancelIndicator)
		afterBuild(result)
	}

	protected def IWorkspaceConfig getWorkspaceConfig() {
		if (_workspaceConfig === null) {
			val error = new ResponseError(ResponseErrorCode.serverNotInitialized,
				"Workspace has not been initialized yet.", null)
			throw new ResponseErrorException(error)
		}
		return _workspaceConfig
	}

	protected def void setWorkspaceConfig(IWorkspaceConfig workspaceConfig) {
		this._workspaceConfig = workspaceConfig
	}

	protected def void afterBuild(List<Delta> deltas) {
		for (listener : buildListeners) {
			listener.afterBuild(deltas)
		}
	}

	def Buildable didChangeFiles(List<URI> dirtyFiles, List<URI> deletedFiles) {
		val buildable = buildManager.submit(dirtyFiles, deletedFiles)
		return [ cancelIndicator |
			val deltas = buildable.build(cancelIndicator)
			afterBuild(deltas)
			return deltas
		]
	}

	def List<IResourceDescription.Delta> doBuild(List<URI> dirtyFiles, List<URI> deletedFiles,
		CancelIndicator cancelIndicator) {
		return didChangeFiles(dirtyFiles, deletedFiles).build(cancelIndicator)
	}

	def IResourceDescriptions getIndex() {
		return new ChunkedResourceDescriptions(fullIndex)
	}

	def URI getProjectBaseDir(URI uri) {
		val projectConfig = workspaceConfig.findProjectContaining(uri)
		return projectConfig?.path
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

	def didChange(URI uri, Integer version, Iterable<TextEdit> changes, CancelIndicator cancelIndicator) {
		didChange(uri, version, changes).build(cancelIndicator)
	}

	def Buildable didChange(URI uri, Integer version, Iterable<TextEdit> changes) {
		if (!openDocuments.containsKey(uri)) {
			LOG.error("The document " + uri + " has not been opened.")
			return [];
		}
		val contents = openDocuments.get(uri)
		openDocuments.put(uri, contents.applyChanges(changes))
		return didChangeFiles(#[uri], newArrayList)
	}

	def didOpen(URI uri, Integer version, String contents, CancelIndicator cancelIndicator) {
		didOpen(uri, version, contents).build(cancelIndicator)
	}

	def Buildable didOpen(URI uri, Integer version, String contents) {
		openDocuments.put(uri, new Document(version, contents))
		return didChangeFiles(#[uri], newArrayList)
	}

	def didClose(URI uri, CancelIndicator cancelIndicator) {
		didClose(uri).build(cancelIndicator)
	}

	def Buildable didClose(URI uri) {
		openDocuments.remove(uri)
		if (exists(uri)) {
			return didChangeFiles(#[uri], newArrayList)
		}
		return didChangeFiles(newArrayList, #[uri])
	}

	protected def boolean exists(URI uri) {
		val rs = getProjectManager(uri)?.resourceSet
		if (rs === null)
			return false
		return rs.URIConverter.exists(uri, null)
	}

	def <T> T doRead(URI uri, (Document, XtextResource)=>T work) {
		val resourceURI = uri.trimFragment
		val projectMnr = getProjectManager(resourceURI)
		val resource = projectMnr?.getResource(resourceURI) as XtextResource
		if (resource === null) {
			return work.apply(null, null)
		}
		var doc = getDocument(resource)
		return work.apply(doc, resource)
	}

	protected def Document getDocument(XtextResource resource) {
		return openDocuments.get(resource.URI) // lets create a transient document, in case a document is not open (e.g. formatting is called just by uri)
		?: new Document(1, resource.parseResult.rootNode.text)
	}

	def boolean isDocumentOpen(URI uri) {
		return openDocuments.containsKey(uri)
	}
}
