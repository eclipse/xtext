/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build

import com.google.common.collect.HashMultimap
import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.compiler.impl.CompilerUtil
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.progress.ProcessCanceledException
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.OrderEnumerator
import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.encoding.EncodingProjectManager
import com.intellij.util.Alarm
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest
import org.eclipse.xtext.builder.standalone.incremental.IncrementalBuilder
import org.eclipse.xtext.builder.standalone.incremental.IndexState
import org.eclipse.xtext.idea.resource.ModuleBasedResourceSetProvider
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider
import org.eclipse.xtext.idea.shared.XtextLanguages

import static org.eclipse.xtext.idea.build.BuildEvent.Type.*

import static extension org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtextAutoBuilder {

	BlockingQueue<BuildEvent> queue = new LinkedBlockingQueue<BuildEvent>()

	Alarm alarm 

	Project project
	
	@Inject Provider<IncrementalBuilder> builderProvider	
	 
	@Inject XtextLanguages xtextLanguages
	
	@Inject ModuleBasedResourceSetProvider resourceSetProvider
	
	IndexState indexState
	
	new(Project project) {
		IdeaSharedInjectorProvider.injector.injectMembers(this)
		this.project = project
		alarm = new Alarm(Alarm.ThreadToUse.OWN_THREAD, project)
	}

	def void fileModified(VirtualFile file) {
		enqueue(file, MODIFIED)
	}

	def void fileDeleted(VirtualFile file) {
		enqueue(file, DELETED)
	}

	def void fileAdded(VirtualFile file) {
		enqueue(file, ADDED)
	}

	protected def enqueue(VirtualFile file, BuildEvent.Type type) {
		if (file != null && !project.isDisposed) {
			queue.put(new BuildEvent(file, type))
			alarm.cancelAllRequests
			alarm.addRequest([build], 200)
		}
	}

	protected def void build() {
		val allEvents = newArrayList
		queue.drainTo(allEvents)
		try {
			val module2event = HashMultimap.create
			val fileIndex = ProjectFileIndex.SERVICE.getInstance(project)
			allEvents.forEach [
				if(xtextLanguages.languageAccesses.get(file.extension) != null) {
					val module = fileIndex.getModuleForFile(file)
					if(module != null)
						module2event.put(module, it)
				}
			]
			val projectEncoding = EncodingProjectManager.getInstance(project).defaultCharsetName
			val refreshFiles = newArrayList
			for(module: module2event.keySet) {
				val events = module2event.get(module)
				val entries = OrderEnumerator.orderEntries(module)
				val request = new BuildRequest => [
					resourceSet = resourceSetProvider.get(module)
					dirtyFiles += events.filter[type==MODIFIED || type == ADDED].map[file.URI]
					deletedFiles += events.filter[type == DELETED].map[file.URI]
					classPath += entries.withoutSdk.classes.pathsList.virtualFiles.filter[/* HACK! we need to properly exclude the out put dir */!isDirectory].map[URI]
					baseDir = ModuleRootManager.getInstance(module).contentRoots.head.URI
					defaultEncoding = projectEncoding
					sourceRoots += entries.withoutSdk.withoutLibraries.withoutDepModules.sources.pathsList.virtualFiles.map[URI]
					// outputs = ??
					failOnValidationError = false
				
					if (indexState != null) {
						previousState = indexState
					} else {
						isFullBuild = true
					}
				
					it.issueHandler = issueHandler
				
					afterGenerateFile = [ refreshFiles += $1 ] 
					afterDeleteFile = [ refreshFiles += it ]
				]
				indexState = ApplicationManager.application.<IndexState>runReadAction [
					builderProvider.get().build(request, xtextLanguages.languageAccesses)
				]
			}
			CompilerUtil.refreshIOFiles(refreshFiles.map[asFile])
		} catch(ProcessCanceledException exc) {
			queue.addAll(allEvents)
		}		
	}
	
	protected def getURI(VirtualFile file) {
		val uri = if (file.isInLocalFileSystem)
				URI.createFileURI(file.path)
			else
				URI.createURI(file.url)
		if (file.directory)
			uri.appendSegment('')
		else
			uri
	}
}