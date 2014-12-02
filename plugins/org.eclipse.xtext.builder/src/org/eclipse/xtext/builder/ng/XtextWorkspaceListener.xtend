/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.ng

import com.google.inject.Inject
import java.util.LinkedHashMap
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResourceChangeEvent
import org.eclipse.core.resources.IResourceChangeListener
import org.eclipse.core.resources.IStorage
import org.eclipse.core.resources.IWorkspace
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.ui.resource.IStorage2UriMapper

import static org.eclipse.core.resources.IResourceDelta.*
import org.eclipse.xtext.builder.ng.debug.XtextCompilerConsole

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtextWorkspaceListener implements IResourceChangeListener {

	@Inject IStorage2UriMapper storage2UriMapper

	@Inject XtextCompiler compiler

	@Inject IResourceSetProvider resourceSetProvider

	IWorkspace workspace

	@Inject
	def register(IWorkspace workspace) {
		this.workspace = workspace
		workspace.addResourceChangeListener(this)
	}

	def deregister() {
		workspace.removeResourceChangeListener(this)
	}

	override resourceChanged(IResourceChangeEvent event) {
		try {
			val project2request = new LinkedHashMap<IProject, CompilationRequest>
			for (project : workspace.computeProjectOrder(workspace.root.projects).projects) {
				project2request.put(project,
					new CompilationRequest => [
						projectName = project.name
						resourceSetProvider = [
							resourceSetProvider.get(project)
						]
					])
			}
			event.delta.accept [ delta |
				val resource = delta.resource
				switch resource {
					IStorage case delta.kind == REMOVED:
						project2request.get(resource.project).toBeDeleted += storage2UriMapper.getUri(resource)
					IStorage case delta.kind == ADDED || delta.kind == CHANGED:
						project2request.get(resource.project).toBeUpdated += storage2UriMapper.getUri(resource)
				}
				return true
			]
			val upstreamDeltas = <IResourceDescription.Delta>newArrayList
			for (entry : project2request.entrySet) {
				val compilationRequest = entry.value
				if (compilationRequest.shouldCompile) {
					compilationRequest.upstreamProjectChanges = upstreamDeltas
					upstreamDeltas += compiler.compile(compilationRequest)
				}
			}
		} catch (Exception exc) {
			XtextCompilerConsole.log(exc)
		}
	} 
}
